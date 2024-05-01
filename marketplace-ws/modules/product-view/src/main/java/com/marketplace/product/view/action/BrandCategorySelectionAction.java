package com.marketplace.product.view.action;

import com.buycorp.common.util.CommonUtil;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.commerce.product.constants.CPInstanceConstants;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CommerceCatalogLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.ProductViewHelper;
import com.marketplace.product.view.util.ProductViewUtil;
import com.marketplace.ws.api.WebServiceApi;
import com.marketplace.ws.response.user.org.details.UserInfo;
import com.marketplace.ws.response.user.org.details.UserOrgAssociation;
import com.marketplace.ws.response.user.org.details.UserOrgDetailsBean;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=brandCategorySelect" }, service = MVCActionCommand.class)

public class BrandCategorySelectionAction extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(BrandCategorySelectionAction.class.getName());
	int displayDateMonth;
	int displayDateDay;
	int displayDateYear;
	int displayDateHour;
	int displayDateMinute;
	int displayDateAmPm;
	ServiceContext serviceContext;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside BrandCategorySelectionAction Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);

		HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		UserOrgDetailsBean userOrgDetails = null;
//		try {
//			userOrgDetails = callUserOrgAssociationApi(httpServletRequest);
//			if (Validator.isNull(userOrgDetails.getUserOrgAssociation()))
//				throw new Exception();
//		} catch (Exception e) {
//			actionRequest.setAttribute("umsApifailure",
//					"user-org-association API is not working.Unable to create product at this moment");
//			ProductViewUtil.redirectToPIMProductListing(actionResponse);
//			return;
//		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Fetching the data from jsp
		String draftProductId = ParamUtil.getString(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		LOGGER.info("draftProductId--> " + draftProductId);
		long brandId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.BRAND);
		long categoryId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.CATEGORY);
		Map<Locale, String> productNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				ProductViewPortletKeys.PRODUCT_NAME);
		String productType = ParamUtil.getString(actionRequest, ProductViewPortletKeys.PRODUCT_TYPE);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);

		CommerceCatalog commerceCatalog;

		try {
			commerceCatalog = CommerceCatalogLocalServiceUtil
					.getCommerceCatalog(Long.parseLong(CommonUtil.getCustomFieldValue("Catalog")));
			LOGGER.info("commerceCatalog---> " + commerceCatalog);
		} catch (PortalException e) {
			LOGGER.error(e, e);
			throw new PortalException(e);
		}

		Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(),
				String.valueOf(commerceCatalog.getCommerceCatalogId()));

		serviceContext = setServiceContext(themeDisplay.getUser(), commerceCatalog);
		LOGGER.info("serviceContext---> " + serviceContext);

		Calendar displayCalendar = CalendarFactoryUtil.getCalendar(serviceContext.getTimeZone());
		displayCalendar.add(Calendar.YEAR, -1);
		displayDateMonth = displayCalendar.get(Calendar.MONTH);
		displayDateDay = displayCalendar.get(Calendar.DAY_OF_MONTH);
		displayDateYear = displayCalendar.get(Calendar.YEAR);
		displayDateHour = displayCalendar.get(Calendar.HOUR);
		displayDateMinute = displayCalendar.get(Calendar.MINUTE);
		displayDateAmPm = displayCalendar.get(Calendar.AM_PM);

		if (displayDateAmPm == Calendar.PM) {
			displayDateHour += 12;
		}

		// setting all values in a map to pass in common method
		Map<String, String> parameters = new HashMap<>();
		parameters.put(ProductViewPortletKeys.BRAND, String.valueOf(brandId));
		parameters.put(ProductViewPortletKeys.CATEGORY, String.valueOf(categoryId));
		parameters.put(ProductViewPortletKeys.PRODUCT_TYPE, String.valueOf(productType));

		String productMappingId = brandId + StringPool.SLASH + categoryId + StringPool.SLASH;

		Product product;
		CPDefinition cpDefinition;

		if (draftProductId.equals("")) {
			// Creating product object for new entry
			product = productLocalService.createProduct(counterLocalService.increment());
			parameters.put(ProductViewPortletKeys.CREATE_FLAG, "true");
			product = setValues(parameters, productNameMap, themeDisplay, httpServletRequest, product, productMappingId,
					userOrgDetails);

			LOGGER.info("::: Start of data push to LR for new product :::");

			cpDefinition = CPDefinitionLocalServiceUtil.addCPDefinition(String.valueOf(product.getDraftProductId()),
					group.getGroupId(), themeDisplay.getUserId(), product.getProductNameMap(), null, null, null, null,
					null, null, product.getProductType(), true, true, true, true, 0, 0, 0, 0, 0, 0, false, false, null,
					false, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, 0, 0,
					0, 0, 0, true, CPInstanceConstants.DEFAULT_SKU, false, 1, null, null, 0, 2, serviceContext);

			LOGGER.info("LR Product Created--> " + cpDefinition.getCPDefinitionId());
			cpDefinition.setStatus(WorkflowConstants.STATUS_DRAFT);
			cpDefinition.getExpandoBridge().setAttribute("Vendor Name",
					product.getVendorName() + " - " + product.getVendorId());
			cpDefinition.getExpandoBridge().setAttribute("Vendor Organization",
					product.getOrganizationName() + " - " + product.getOrganizationId());
			LOGGER.info("::: Custom Field for Vendor and Organization has been set :::");
			CPDefinitionLocalServiceUtil.updateCPDefinition(cpDefinition);

			product.setCpDefinitionId(cpDefinition.getCPDefinitionId());

			assignBrandCategory(product.getBrandId(), product.getCategoryId(), cpDefinition);
			LOGGER.info("::: Brand and Category are assigned to new product :::");

			productLocalService.addProduct(product);

			portletURLStep.setParameter(ProductViewPortletKeys.DRAFT_PRODUCT_ID, product.getDraftProductId());

		} else {
			// Fetching product object for the existing entry
			product = productLocalService.getProduct(Long.parseLong(draftProductId));
			parameters.put(ProductViewPortletKeys.CREATE_FLAG, "false");

			product = setValues(parameters, productNameMap, themeDisplay, httpServletRequest, product, productMappingId,
					userOrgDetails);

			LOGGER.info("::: Start of data push to LR for existing product :::");

			cpDefinition = CPDefinitionLocalServiceUtil.updateCPDefinition(product.getCpDefinitionId(),
					product.getProductNameMap(), null, null, null, null, null, null, true, true, true, true, 0, 0, 0, 0,
					0, 0, false, false, null, false, displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, 0, 0, 0, 0, 0, true, serviceContext);

			cpDefinition.setStatus(WorkflowConstants.STATUS_DRAFT);
			cpDefinition.getExpandoBridge().setAttribute("Vendor Name",
					product.getVendorName() + " - " + product.getVendorId());
			cpDefinition.getExpandoBridge().setAttribute("Vendor Organization",
					product.getOrganizationName() + " - " + product.getOrganizationId());
			CPDefinitionLocalServiceUtil.updateCPDefinition(cpDefinition);

			deleteBrandCategory(cpDefinition);
			assignBrandCategory(product.getBrandId(), product.getCategoryId(), cpDefinition);
			LOGGER.info("::: Brand and Category are assigned to existing product :::");

			productLocalService.updateProduct(product);
			portletURLStep.setParameter(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		}

		String productStatus = ParamUtil.getString(actionRequest, "productStatus");
		long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");

		if (productStatus.equalsIgnoreCase("DRAFT")) {
			productViewHelper.saveProductAsDraft(product.getDraftProductId(), productStatus, stepNumber,
					themeDisplay.getUserId());
			SessionMessages.add(actionRequest, "success-key");
			portletURLStep.setMVCRenderCommandName(ProductViewPortletKeys.PIM_PRODUCT_LISTING_RENDER_CMD);
		} else {
			productViewHelper.saveProductAsDraft(product.getDraftProductId(), "DRAFT", stepNumber,
					themeDisplay.getUserId());
			SessionMessages.add(actionRequest, "brand-category-key");
			portletURLStep.setMVCRenderCommandName(ProductViewPortletKeys.BASIC_INFO_RENDER_CMD);
		}

		actionResponse.sendRedirect(portletURLStep.buildPortletURL().toString());

	}

	private void deleteBrandCategory(CPDefinition cpDefinition) {
		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(CPDefinition.class.getName(),
					cpDefinition.getCPDefinitionId());
			AssetEntryAssetCategoryRelLocalServiceUtil
					.deleteAssetEntryAssetCategoryRelByAssetEntryId(assetEntry.getEntryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void assignBrandCategory(long brandId, long categoryId, CPDefinition cpDefinition) {
		try {
			Brand brand = BrandLocalServiceUtil.getBrand(brandId);
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(CPDefinition.class.getName(),
					cpDefinition.getCPDefinitionId());
			AssetEntryAssetCategoryRelLocalServiceUtil.addAssetEntryAssetCategoryRel(assetEntry.getEntryId(),
					brand.getAssetCategoryId());
			AssetEntryAssetCategoryRelLocalServiceUtil.addAssetEntryAssetCategoryRel(assetEntry.getEntryId(),
					category.getAssetCategoryId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ServiceContext setServiceContext(User user, CommerceCatalog commerceCatalog) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(commerceCatalog.getCompanyId());
		serviceContext.setScopeGroupId(commerceCatalog.getGroupId());
		serviceContext.setTimeZone(user.getTimeZone());
		serviceContext.setUserId(commerceCatalog.getUserId());
		return serviceContext;
	}

	// Method for setting data in custom tables
	private Product setValues(Map<String, String> parameters, Map<Locale, String> productNameMap,
			ThemeDisplay themeDisplay, HttpServletRequest httpServletRequest, Product product, String productMappingId,
			UserOrgDetailsBean userOrgDetails) throws NumberFormatException, PortalException {

		String brandId = parameters.get(ProductViewPortletKeys.BRAND);
		String categoryId = parameters.get(ProductViewPortletKeys.CATEGORY);
		String productType = parameters.get(ProductViewPortletKeys.PRODUCT_TYPE);
		String createFlag = parameters.get(ProductViewPortletKeys.CREATE_FLAG);

		product.setBrandId(Long.parseLong(brandId));
		product.setCategoryId(Long.parseLong(categoryId));
		product.setProductNameMap(productNameMap);
		setVendorDetails(product, userOrgDetails);
		if (productType.equalsIgnoreCase("physical")) {
			product.setProductType("simple");
		} else if (productType.equalsIgnoreCase("service")) {
			product.setProductType("virtual");
		}

		product.setProductStatus(null);
		product.setStepNumber(0);

		// Audit fields
		product.setIpAddress(httpServletRequest.getRemoteAddr());
		product.setGroupId(themeDisplay.getScopeGroupId());
		product.setCompanyId(themeDisplay.getCompanyId());
		product.setUserId(themeDisplay.getUserId());
		product.setUserName(themeDisplay.getUser().getFullName());

		if (createFlag.equalsIgnoreCase("true")) {
			product.setCreateDate(new Date());
			product.setCreatedBy(themeDisplay.getUserId());
		}

		product.setModifiedDate(new Date());
		product.setModifiedBy(themeDisplay.getUserId());

		product.setProductMappingId(productMappingId + product.getDraftProductId());

		return product;
	}

	private UserOrgDetailsBean callUserOrgAssociationApi(HttpServletRequest httpServletRequest) {

		HttpSession httpSession = httpServletRequest.getSession();

		String arxUserId = (String) httpSession.getAttribute("arxUserId");
		LOGGER.info("ARX User Id ---------------> " + arxUserId);
		try {
			return webServiceApi.getUserOrganisationDetails(httpServletRequest, arxUserId);
		} catch (Exception e) {
			LOGGER.warn("Unable to invoke User Org Details API. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}
		return null;
	}

	/**
	 * Setting Vendor Details by Invoking User Org Details API.
	 *
	 * @param product
	 */
	private void setVendorDetails(Product product, UserOrgDetailsBean userOrgDetails) {

		String organizationId = StringPool.BLANK;
		String organizationName = StringPool.BLANK;
		String vendorId = StringPool.BLANK;
		String vendorFirstName = StringPool.BLANK;
		String vendorLastName = StringPool.BLANK;

//		try {
//			UserOrgAssociation userOrgAssociation = userOrgDetails.getUserOrgAssociation().get(0);
//			UserInfo userInfo = userOrgAssociation.getUserInfo();
//
//			organizationId = userOrgAssociation.getOrganizationId();
//			organizationName = userOrgAssociation.getOrganizationName();
//			vendorId = userOrgAssociation.getUserId();
//			vendorFirstName = userInfo.getFirstName();
//			vendorLastName = userInfo.getLastName();
//
//		} catch (Exception e) {
//
//			LOGGER.warn("Unable to invoke User Org Details API. Please enable debug logs for full details.");
//			LOGGER.debug(e, e);
//
//		}
//
//		product.setOrganizationId(organizationId);
//		product.setOrganizationName(organizationName);
//		product.setVendorId(vendorId);
//		product.setVendorName(vendorFirstName + StringPool.SPACE + vendorLastName);
		
		product.setOrganizationId("11");
		product.setOrganizationName("vdhjnzx");
		product.setVendorId("43");
		product.setVendorName("fcsghvjbh");

	}

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProductViewHelper productViewHelper;

	@Reference
	private WebServiceApi webServiceApi;

}
