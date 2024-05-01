package com.marketplace.product.view.helper;

import com.liferay.commerce.product.model.CPTaxCategory;
import com.liferay.commerce.product.service.CPTaxCategoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.pkg.content.model.ProductPackageContent;
import com.marketplace.product.pkg.content.service.ProductPackageContentLocalService;
import com.marketplace.product.search.keywords.model.ProductSearchKeywords;
import com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.SpecificationSelectionConstants;
import com.marketplace.product.view.model.ProductPackageContentModel;
import com.marketplace.product.view.util.ProductViewUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Contains all the business logic for Product's Additional Information Page.
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, service = AdditionalInformationHelper.class)
public class AdditionalInformationHelper {

	/**
	 * 
	 * Adds Product Additional Information in the database.
	 * 
	 * @param portletRequest
	 * @throws UnsupportedEncodingException
	 * @throws JSONException
	 */
	public void addProductAdditionalInformation(PortletRequest portletRequest)
			throws UnsupportedEncodingException, JSONException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		long taxCategoryId = ParamUtil.getLong(portletRequest, "taxCategory");

		try {
			Product product = productLocalService.getProduct(draftProductId);
			product.setTaxCategoryId(taxCategoryId);
			productLocalService.updateProduct(product);
		} catch (Exception e) {
			LOGGER.error("Product is empty/null :: " + e.getMessage());
		}

		String encodedAdditionalInfoJson = ParamUtil.getString(portletRequest,
				SpecificationSelectionConstants.ADDITIONAL_INFO_JSON.getValue());
		String decodedAdditionalInfoJson = URLDecoder.decode(encodedAdditionalInfoJson, ProductViewPortletKeys.UTF_8);

		JSONObject additionalInfoJson = JSONFactoryUtil.createJSONObject(decodedAdditionalInfoJson);

		JSONArray searchKeywords = additionalInfoJson
				.getJSONArray(SpecificationSelectionConstants.SEARCH_KEYWORDS.getValue());
		JSONArray packageContents = additionalInfoJson
				.getJSONArray(SpecificationSelectionConstants.PACKAGE_CONTENTS.getValue());

		updateProductSearchKeywords(searchKeywords, themeDisplay, draftProductId, httpServletRequest.getLocalAddr());

		updateProductPackageContents(packageContents, themeDisplay, draftProductId, httpServletRequest.getLocalAddr());

	}

	/**
	 * Updates search keywords mapped to a product if present and if not then create
	 * new search keywords in the database.
	 * 
	 * It is also responsible for deleting the unused search keywords from the
	 * database if present.
	 * 
	 * @param searchKeywords
	 * @param themeDisplay
	 * @param draftProductId
	 * @param ipAddress
	 */
	public void updateProductSearchKeywords(JSONArray searchKeywords, ThemeDisplay themeDisplay, long draftProductId,
			String ipAddress) {

		List<ProductSearchKeywords> productSearchKeywords = productSearchKeywordsLocalService
				.findByDraftProductId(draftProductId);

		if (searchKeywords.length() == 0) {

			deleteAllSearchKeywords(productSearchKeywords);

			return;
		}

		List<Long> searchKeywordIds = new ArrayList<>();

		for (int index = 0; index < searchKeywords.length(); index++) {
			try {

				final Integer index1 = new Integer(index);

				// Updating the product search keyword
				ProductSearchKeywords productSearchKeyword = productSearchKeywords.stream().filter(
						searchKeyword -> searchKeyword.getSearchKeyword().equals(searchKeywords.getString(index1)))
						.findFirst().get();

				searchKeywordIds.add(productSearchKeyword.getSearchKeywordId());

				productSearchKeyword.setSearchKeyword(searchKeywords.getString(index));
				productSearchKeyword.setModifiedBy(themeDisplay.getUserId());
				productSearchKeyword.setModifiedDate(new Date());
				productSearchKeyword.setIpAddress(ipAddress);

				productSearchKeywordsLocalService.updateProductSearchKeywords(productSearchKeyword);

			} catch (NoSuchElementException e) {
				LOGGER.warn("New Search Keyword, adding it into the database");

				ProductSearchKeywords productSearchKeyword = addProductSearchKeywords(themeDisplay, draftProductId,
						searchKeywords.getString(index), ipAddress);

				searchKeywordIds.add(productSearchKeyword.getSearchKeywordId());
			}
		}

		deleteSpecificSearchKeywords(productSearchKeywords, searchKeywordIds);

	}

	private void deleteAllSearchKeywords(List<ProductSearchKeywords> productSearchKeywords) {

		productSearchKeywords.stream().forEach(searchKeyword -> {
			deleteProductSearchKeyword(searchKeyword.getSearchKeywordId());
		});

	}

	private void deleteSpecificSearchKeywords(List<ProductSearchKeywords> productSearchKeywords,
			List<Long> searchKeywordIds) {

		productSearchKeywords.stream().forEach(searchKeyword -> {
			if (!searchKeywordIds.contains(searchKeyword.getSearchKeywordId())) {
				deleteProductSearchKeyword(searchKeyword.getSearchKeywordId());
			}
		});

	}

	private void deleteProductSearchKeyword(long searchKeywordId) {

		try {
			productSearchKeywordsLocalService.deleteProductSearchKeywords(searchKeywordId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to delete Product Search Keyword. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	/**
	 * Updating product's package content if present and if not then it will create
	 * the product package contents in the database.
	 * 
	 * It is also responsible for deleting the unused product package content from
	 * the database.
	 * 
	 * @param packageContents
	 * @param themeDisplay
	 * @param draftProductId
	 * @param ipAddress
	 */
	public void updateProductPackageContents(JSONArray packageContents, ThemeDisplay themeDisplay, long draftProductId,
			String ipAddress) {

		List<ProductPackageContent> productPackageContentList = productPackageContentLocalService
				.findByDraftProductId(draftProductId);

		if (packageContents.length() == 0) {
			deleteAllPackageContents(productPackageContentList);
			return;
		}

		List<Long> packageContentIds = new ArrayList<>();

		for (int index = 0; index < packageContents.length(); index++) {

			JSONObject item = packageContents.getJSONObject(index);

			if (item.length() != 0) {

				try {

					// Updating the product package content
					ProductPackageContent productPackageContent = productPackageContentList.stream()
							.filter(packageContent -> packageContent.getItemName()
									.equals(item.getString(SpecificationSelectionConstants.ITEM_NAME.getValue())))
							.findFirst().get();

					packageContentIds.add(productPackageContent.getPackageContentId());

					productPackageContent
							.setItemName(item.getString(SpecificationSelectionConstants.ITEM_NAME.getValue()));
					productPackageContent
							.setItemQuantity(item.getString(SpecificationSelectionConstants.ITEM_QTY.getValue()));
					productPackageContent.setModifiedBy(themeDisplay.getUserId());
					productPackageContent.setModifiedDate(new Date());
					productPackageContent.setIpAddress(ipAddress);

					productPackageContentLocalService.updateProductPackageContent(productPackageContent);

				} catch (NoSuchElementException e) {
					LOGGER.warn("New Package content, adding it into the database.");

					ProductPackageContent productPackageContent = addProductPackageContent(themeDisplay, draftProductId,
							item.getString(SpecificationSelectionConstants.ITEM_NAME.getValue()),
							item.getString(SpecificationSelectionConstants.ITEM_QTY.getValue()), ipAddress);

					packageContentIds.add(productPackageContent.getPackageContentId());
				}

			}

		}

		deleteSpecificPackageContent(productPackageContentList, packageContentIds);

	}

	private void deleteAllPackageContents(List<ProductPackageContent> productPackageContentList) {

		productPackageContentList.stream().forEach(packageContent -> {
			deletePackageContent(packageContent.getPackageContentId());
		});

	}

	private void deleteSpecificPackageContent(List<ProductPackageContent> productPackageContentList,
			List<Long> packageContentIds) {

		productPackageContentList.stream().forEach(packageContent -> {
			if (!packageContentIds.contains(packageContent.getPackageContentId())) {
				deletePackageContent(packageContent.getPackageContentId());
			}
		});

	}

	private void deletePackageContent(long packageContentId) {

		try {
			productPackageContentLocalService.deleteProductPackageContent(packageContentId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to delete package content for the product. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	/**
	 * 
	 * Adds Search keywords attached by while creating product in the database.
	 * 
	 * @param themeDisplay
	 * @param draftProductId
	 * @param searchKeyword
	 * @param ipAddress
	 * @return
	 */
	private ProductSearchKeywords addProductSearchKeywords(ThemeDisplay themeDisplay, long draftProductId,
			String searchKeyword, String ipAddress) {

		ProductSearchKeywords productSearchKeywords = productSearchKeywordsLocalService
				.createProductSearchKeywords(counterLocalService.increment());

		productSearchKeywords.setSearchKeyword(searchKeyword);
		productSearchKeywords.setDraftProductId(draftProductId);
		productSearchKeywords.setCompanyId(themeDisplay.getCompanyId());
		productSearchKeywords.setGroupId(themeDisplay.getScopeGroupId());
		productSearchKeywords.setCreateDate(new Date());
		productSearchKeywords.setCreatedBy(themeDisplay.getUserId());
		productSearchKeywords.setModifiedDate(new Date());
		productSearchKeywords.setModifiedBy(themeDisplay.getUserId());
		productSearchKeywords.setUserId(themeDisplay.getUserId());
		productSearchKeywords.setUserName(themeDisplay.getUser().getFullName());
		productSearchKeywords.setIpAddress(ipAddress);

		return productSearchKeywordsLocalService.updateProductSearchKeywords(productSearchKeywords);

	}

	/**
	 * 
	 * Adds Product's package contents in the database.
	 * 
	 * @param themeDisplay
	 * @param draftProductId
	 * @param itemName
	 * @param itemQuantity
	 * @param ipAddress
	 * @return
	 */
	private ProductPackageContent addProductPackageContent(ThemeDisplay themeDisplay, long draftProductId,
			String itemName, String itemQuantity, String ipAddress) {

		ProductPackageContent productPackageContent = productPackageContentLocalService
				.createProductPackageContent(counterLocalService.increment());

		productPackageContent.setItemName(itemName);
		productPackageContent.setItemQuantity(itemQuantity);
		productPackageContent.setDraftProductId(draftProductId);
		productPackageContent.setCompanyId(themeDisplay.getCompanyId());
		productPackageContent.setGroupId(themeDisplay.getScopeGroupId());
		productPackageContent.setCreateDate(new Date());
		productPackageContent.setCreatedBy(themeDisplay.getUserId());
		productPackageContent.setModifiedDate(new Date());
		productPackageContent.setModifiedBy(themeDisplay.getUserId());
		productPackageContent.setUserId(themeDisplay.getUserId());
		productPackageContent.setUserName(themeDisplay.getUser().getFullName());
		productPackageContent.setIpAddress(ipAddress);

		return productPackageContentLocalService.updateProductPackageContent(productPackageContent);

	}

	public void renderProductAdditionalInformation(PortletRequest portletRequest) {

		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		List<CPTaxCategory> cpTaxCategories = CPTaxCategoryLocalServiceUtil.getCPTaxCategories(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		long taxCategoryId = 0;

		try {
			Product product = productLocalService.getProduct(draftProductId);
			taxCategoryId = product.getTaxCategoryId();
		} catch (Exception e) {
			LOGGER.error("Product is empty/null :: " + e.getMessage());
		}

		portletRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		portletRequest.setAttribute("cpTaxCategories", cpTaxCategories);
		portletRequest.setAttribute("taxCategoryId", taxCategoryId);
		portletRequest.setAttribute(SpecificationSelectionConstants.SEARCH_KEYWORDS.getValue(),
				getProductSearchKeywords(draftProductId));
		portletRequest.setAttribute(SpecificationSelectionConstants.PACKAGE_CONTENTS.getValue(),
				getProductPackageContent(draftProductId));

		try {
			ProductViewUtil.setLastModifiedDateInRequest(portletRequest, null, draftProductId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to set Modified Date. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	private List<String> getProductSearchKeywords(long draftProductId) {

		List<ProductSearchKeywords> productSearchKeywords = productSearchKeywordsLocalService
				.findByDraftProductId(draftProductId);

		List<String> searchKeywords = new ArrayList<>();

		productSearchKeywords.stream().forEach(searchKeyword -> {
			searchKeywords.add(searchKeyword.getSearchKeyword());
		});

		return searchKeywords;

	}

	private List<ProductPackageContentModel> getProductPackageContent(long draftProductId) {

		List<ProductPackageContent> productPackageContents = productPackageContentLocalService
				.findByDraftProductId(draftProductId);
		List<ProductPackageContentModel> productPackageContent = new ArrayList<>();

		productPackageContents.stream().forEach(packageContent -> {
			productPackageContent.add(
					new ProductPackageContentModel(packageContent.getItemName(), packageContent.getItemQuantity()));
		});

		return productPackageContent;

	}

	@Reference
	private ProductSearchKeywordsLocalService productSearchKeywordsLocalService;

	@Reference
	private ProductPackageContentLocalService productPackageContentLocalService;

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(AdditionalInformationHelper.class);

}
