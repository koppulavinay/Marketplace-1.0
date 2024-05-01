package com.marketplace.product.view.helper;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.spec.value.map.exception.NoSuchProductSpecValueMapException;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.service.ProductSpecValueMapLocalService;
import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.service.ProductSpecificationLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.SpecificationSelectionConstants;
import com.marketplace.product.view.model.ProductSpecificationValueModel;
import com.marketplace.product.view.model.ProductSpecificationsModel;
import com.marketplace.product.view.util.ProductViewUtil;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.field.data.type.service.SpecFieldDataTypeLocalService;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Contains all the business logic for Product's Specification Selection page.
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, service = SpecificationSelectionHelper.class)
public class SpecificationSelectionHelper {

	/**
	 * Update Product Specifications if already present and if not then create
	 * product specifications in the database. Upon updating the product
	 * specifications it will delete the unused product specifications from the
	 * database. It is also responsible for updating the product specification
	 * values in the database.
	 * 
	 * @param portletRequest
	 * @throws UnsupportedEncodingException
	 * @throws PortalException
	 */
	public void updateProductSpecifications(PortletRequest portletRequest)
			throws UnsupportedEncodingException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		String encodedProductSpecifications = ParamUtil.getString(portletRequest,
				SpecificationSelectionConstants.SPECIFICATIONS_JSON.getValue());
		String decodedProductSpecifications = URLDecoder.decode(encodedProductSpecifications,
				ProductViewPortletKeys.UTF_8);

		JSONObject productSpecificationsJson = JSONFactoryUtil.createJSONObject(decodedProductSpecifications);
		JSONArray specifications = productSpecificationsJson
				.getJSONArray(SpecificationSelectionConstants.SPECIFICATIONS.getValue());

		List<Long> productSpecificationIds = new ArrayList<>();
		List<ProductSpecification> productSpecificationsList = productSpecificationLocalService
				.findByDraftProductId(draftProductId);

		for (int index = 0; index < specifications.length(); index++) {

			JSONObject specification = specifications.getJSONObject(index);

			specification.put(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
			specification.put(ProductViewPortletKeys.IP_ADDRESS, httpServletRequest.getLocalAddr());
			specification.put(ProductViewPortletKeys.GROUP_ID, themeDisplay.getScopeGroupId());
			specification.put(ProductViewPortletKeys.COMPANY_ID, themeDisplay.getCompanyId());
			specification.put(ProductViewPortletKeys.USER_ID, themeDisplay.getUserId());
			specification.put(ProductViewPortletKeys.USER_NAME, themeDisplay.getUser().getFullName());

			ProductSpecification productSpecification = updateProductSpecification(specification);

			productSpecificationIds.add(productSpecification.getProductSpecificationId());

			specification.put(SpecificationSelectionConstants.PRODUCT_SPECIFICATION_ID.getValue(),
					productSpecification.getProductSpecificationId());

			updateProductSpecValues(specification);

		}

		deleteProductSpecifications(productSpecificationIds, productSpecificationsList);

	}

	private void deleteProductSpecifications(List<Long> productSpecificationIds,
			List<ProductSpecification> productSpecificationsList) {

		productSpecificationsList.stream().forEach(productSpecification -> {
			if (!productSpecificationIds.contains(productSpecification.getProductSpecificationId())) {
				try {

					List<ProductSpecValueMap> productSpecValueMapList = productSpecValueMapLocalService
							.findByProductSpecificationId(productSpecification.getProductSpecificationId());

					deleteProductSpecValueMap(productSpecValueMapList);

					productSpecificationLocalService
							.deleteProductSpecification(productSpecification.getProductSpecificationId());

				} catch (PortalException e) {
					LOGGER.warn(
							"Unable to delete product specification from the database. Please enable debug logs for full details.");
					LOGGER.debug(e, e);
				}
			}
		});

	}

	private void deleteProductSpecValueMap(List<ProductSpecValueMap> productSpecValueMapList) {

		productSpecValueMapList.stream().forEach(element -> {
			try {
				productSpecValueMapLocalService.deleteProductSpecValueMap(element.getProductSpecValueId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to Delete Product Spec Value Mapping. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});

	}

	/**
	 * Updates Product Specification if exists and if not then create Product
	 * specifications and returns it.
	 * 
	 * @param specification
	 * @return
	 */
	private ProductSpecification updateProductSpecification(JSONObject specification) {

		ProductSpecification productSpecification;

		try {
			productSpecification = productSpecificationLocalService.getProductSpecification(
					specification.getLong(SpecificationSelectionConstants.PRODUCT_SPECIFICATION_ID.getValue()));

		} catch (PortalException e) {
			LOGGER.warn("New Product Specification. Adding it into the database.");

			productSpecification = createProductSpecification(specification);
		}

		productSpecification
				.setSpecificationId(specification.getLong(SpecificationSelectionConstants.SPECIFICATION_ID.getValue()));
		productSpecification.setSpecificationLabel(
				specification.getString(SpecificationSelectionConstants.SPECIFICATION_LABEL.getValue()));
		productSpecification.setSpecificationFieldType(
				specification.getString(SpecificationSelectionConstants.SPECIFICATION_FIELD_TYPE.getValue()));
		productSpecification.setIsMandatory(specification.getBoolean("isMandatory"));
		productSpecification.setModifiedBy(specification.getLong(ProductViewPortletKeys.USER_ID));
		productSpecification.setModifiedDate(new Date());
		productSpecification.setIpAddress(specification.getString(ProductViewPortletKeys.IP_ADDRESS));

		productSpecification = productSpecificationLocalService.updateProductSpecification(productSpecification);

		return productSpecification;

	}

	/**
	 * 
	 * Creates new product specifications in the database.
	 * 
	 * @param specification
	 * @return
	 */
	private ProductSpecification createProductSpecification(JSONObject specification) {

		ProductSpecification productSpecification = productSpecificationLocalService
				.createProductSpecification(counterLocalService.increment());

		productSpecification.setDraftProductId(specification.getLong(ProductViewPortletKeys.DRAFT_PRODUCT_ID));
		productSpecification.setCompanyId(specification.getLong(ProductViewPortletKeys.COMPANY_ID));
		productSpecification.setGroupId(specification.getLong(ProductViewPortletKeys.GROUP_ID));
		productSpecification.setCreatedBy(specification.getLong(ProductViewPortletKeys.USER_ID));
		productSpecification.setUserId(specification.getLong(ProductViewPortletKeys.USER_ID));
		productSpecification.setCreateDate(new Date());
		productSpecification.setUserName(specification.getString(ProductViewPortletKeys.USER_NAME));

		return productSpecification;

	}

	/**
	 * Update product specification values for a product specification if present
	 * and if not then create product specification values in the database.
	 * 
	 * It is also responsible for deleting the product specification values from the
	 * database which are no longer in use.
	 * 
	 * @param specification
	 */
	private void updateProductSpecValues(JSONObject specification) {

		List<Long> productSpecValueIds = new ArrayList<>();

		JSONArray specificationValues = specification
				.getJSONArray(SpecificationSelectionConstants.SPECIFICATION_VALUE_LABEL.getValue());

		for (int index = 0; index < specificationValues.length(); index++) {

			JSONObject specificationValue = specificationValues.getJSONObject(index);

			long specificationValueLabelId = specificationValue
					.getLong(SpecificationSelectionConstants.SPECIFICATION_VALUE_ID.getValue());
			String specificationValueLabel = specificationValue
					.getString(SpecificationSelectionConstants.SPECIFICATION_VALUE_LABEL.getValue());

			ProductSpecValueMap productSpecValueMap;

			try {
				productSpecValueMap = productSpecValueMapLocalService.getProductSpecValueMap(
						specificationValue.getLong(SpecificationSelectionConstants.PRODUCT_SPEC_VALUE_ID.getValue()));

			} catch (PortalException e) {
				LOGGER.warn("Unable to get Product Spec Value Map. Please enable debug logs for full details.");

				productSpecValueMap = createProductSpecValues(specification, specificationValueLabelId,
						specificationValueLabel);

			}

			productSpecValueMap.setSpecificationValueLabelId(specificationValueLabelId);
			productSpecValueMap.setSpecificationValueLabel(specificationValueLabel);
			productSpecValueMap.setSpecificationValueUOM(
					specification.getString(SpecificationSelectionConstants.SPECIFICATION_VALUE_UOM.getValue()));
			productSpecValueMap.setModifiedDate(new Date());
			productSpecValueMap.setModifiedBy(specification.getLong(ProductViewPortletKeys.USER_ID));
			productSpecValueMap.setIpAddress(specification.getString(ProductViewPortletKeys.IP_ADDRESS));

			productSpecValueMap = productSpecValueMapLocalService.updateProductSpecValueMap(productSpecValueMap);

			productSpecValueIds.add(productSpecValueMap.getProductSpecValueId());

		}

		deleteUnusedProductSpecValues(productSpecValueIds,
				specification.getLong(SpecificationSelectionConstants.PRODUCT_SPECIFICATION_ID.getValue()));

	}

	/**
	 * 
	 * Creates Product specification values in the database.
	 * 
	 * @param specification
	 * @return
	 */
	private ProductSpecValueMap createProductSpecValues(JSONObject specification, long specificationValueLabelId,
			String specificationValueLabel) {

		ProductSpecValueMap productSpecValueMap = productSpecValueMapLocalService
				.createProductSpecValueMap(counterLocalService.increment());

		productSpecValueMap.setProductSpecificationId(
				specification.getLong(SpecificationSelectionConstants.PRODUCT_SPECIFICATION_ID.getValue()));
		productSpecValueMap.setGroupId(specification.getLong(ProductViewPortletKeys.GROUP_ID));
		productSpecValueMap.setCompanyId(specification.getLong(ProductViewPortletKeys.COMPANY_ID));
		productSpecValueMap.setCreateDate(new Date());
		productSpecValueMap.setCreatedBy(specification.getLong(ProductViewPortletKeys.USER_ID));
		productSpecValueMap.setUserName(specification.getString(ProductViewPortletKeys.USER_NAME));
		productSpecValueMap.setIpAddress(specification.getString(ProductViewPortletKeys.IP_ADDRESS));

		return productSpecValueMap;

	}

	private void deleteUnusedProductSpecValues(List<Long> productSpecValueIds, long productSpecificationId) {

		List<ProductSpecValueMap> productSpecValueMappingList = productSpecValueMapLocalService
				.findByProductSpecificationId(productSpecificationId);

		productSpecValueMappingList.stream().forEach(productSpecValueMapping -> {
			if (!productSpecValueIds.contains(productSpecValueMapping.getProductSpecValueId())) {
				try {
					productSpecValueMapLocalService
							.deleteProductSpecValueMap(productSpecValueMapping.getProductSpecValueId());
				} catch (PortalException e) {
					LOGGER.warn(
							"Unable to delete Product Specification Value mapping. Please enable debug logs for full details.");
					LOGGER.debug(e, e);
				}
			}
		});

	}

	/**
	 * 
	 * Returns a list of Product's Specifications POJO.
	 * 
	 * @param portletRequest
	 * @return
	 */
	public List<ProductSpecificationsModel> getProductSpecifications(PortletRequest portletRequest) {

		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);

		List<ProductSpecificationsModel> productSpecificationsList = new ArrayList<>();
		List<ProductSpecification> productSpecifications = productSpecificationLocalService
				.findByDraftProductId(draftProductId);

		productSpecifications.stream().forEach(specification -> {

			List<ProductSpecificationValueModel> productSpecificationValues = new ArrayList<>();
			List<String> specificationUOM = new ArrayList<>();
			List<Long> productSpecValueId = new ArrayList<>();

			ProductSpecificationsModel productSpecificationsModel = new ProductSpecificationsModel();

			addProductSpecValueToModel(specification, specificationUOM, productSpecValueId, productSpecificationsModel,
					productSpecificationValues);

			productSpecificationsModel.setProductSpecificationId(specification.getProductSpecificationId());
			productSpecificationsModel.setSpecificationId(specification.getSpecificationId());
			productSpecificationsModel.setSpecificationLabel(specification.getSpecificationLabel());
			productSpecificationsModel.setSpecificationFieldType(specification.getSpecificationFieldType());
			productSpecificationsModel.setProductSpecificationValues(productSpecificationValues);
			productSpecificationsModel.setMandatory(specification.getIsMandatory());
			productSpecificationsModel
					.setSpecificationValueUOM(specificationUOM.stream().findFirst().orElse(StringPool.BLANK));

			productSpecificationsList.add(productSpecificationsModel);

		});

		return productSpecificationsList;

	}

	private void addProductSpecValueToModel(ProductSpecification productSpecification, List<String> specificationUOM,
			List<Long> productSpecValueId, ProductSpecificationsModel productSpecificationsModel,
			List<ProductSpecificationValueModel> productSpecificationValues) {

		List<ProductSpecValueMap> productSpecValueMappingList = productSpecValueMapLocalService
				.findByProductSpecificationId(productSpecification.getProductSpecificationId());

		List<SpecificationValue> specificationValuesList = specificationValueLocalService
				.findByFBYSpecificationId(productSpecification.getSpecificationId());

		List<Long> specValueLabelIds = productSpecValueMappingList.stream()
				.map(ProductSpecValueMap::getSpecificationValueLabelId).collect(Collectors.toList());

		productSpecValueMappingList.stream().forEach(productSpecValue -> {

			productSpecValueId.add(productSpecValue.getProductSpecValueId());

			if (productSpecification.getSpecificationFieldType().equals("Free Text")) {
				productSpecificationsModel.setProductSpecValueId(productSpecValue.getProductSpecValueId());
				productSpecificationsModel.setSingleInputValueLabel(productSpecValue.getSpecificationValueLabel());
			}

			specificationUOM.add(productSpecValue.getSpecificationValueUOM());
		});

		specificationValuesList.stream().forEach(specificationValue -> {

			ProductSpecificationValueModel productSpecificationValueModel = new ProductSpecificationValueModel();

			productSpecificationValueModel.setSpecificationValueId(specificationValue.getSpecificationValueId());
			productSpecificationValueModel.setSpecificationValueLabel(specificationValue.getSpecificationValueLabel());

			if (specValueLabelIds.contains(specificationValue.getSpecificationValueId())) {

				ProductSpecValueMap productSpecValueMap;
				try {
					productSpecValueMap = productSpecValueMapLocalService.findByProductSpecIdNSpecValueId(
							productSpecification.getProductSpecificationId(),
							specificationValue.getSpecificationValueId());
					productSpecificationValueModel.setProductSpecValueId(productSpecValueMap.getProductSpecValueId());
				} catch (NoSuchProductSpecValueMapException e) {
					LOGGER.warn(
							"Unable to fetch Product Spec Value Mapping by Product Specification id and Specification Value Label Id. Please enable debug logs for full details.");
					LOGGER.debug(e, e);
				}

				productSpecificationValueModel.setSelected(Boolean.TRUE);
			} else {
				productSpecificationValueModel.setProductSpecValueId(0);
				productSpecificationValueModel.setSelected(Boolean.FALSE);
			}

			productSpecificationValues.add(productSpecificationValueModel);

		});

	}

	private ProductSpecificationValueModel getProductSpecificationModel(SpecificationValue specificationValue,
			long productSpecValueId, List<Long> specValueLabelIds) {

		ProductSpecificationValueModel productSpecificationValueModel = new ProductSpecificationValueModel();

		productSpecificationValueModel.setSpecificationValueId(specificationValue.getSpecificationValueId());
		productSpecificationValueModel.setSpecificationValueLabel(specificationValue.getSpecificationValueLabel());

		if (specValueLabelIds.contains(specificationValue.getSpecificationValueId())) {
			productSpecificationValueModel.setProductSpecValueId(productSpecValueId);
			productSpecificationValueModel.setSelected(Boolean.TRUE);
		} else {
			productSpecificationValueModel.setProductSpecValueId(0);
			productSpecificationValueModel.setSelected(Boolean.FALSE);
		}

		return productSpecificationValueModel;

	}

	/**
	 * 
	 * Render all the Approved specifications and upto 5 specifications that are
	 * tagged to a specific category selected in the Brand Category Selection form.
	 * 
	 * @param portletRequest
	 * @throws PortalException
	 */
	public void renderSpecificationDetails(PortletRequest portletRequest) throws PortalException {

		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		long categoryId = productLocalService.getProduct(draftProductId).getCategoryId();

		List<Specification> approvedSpecifications = specificationLocalService
				.findBySpecificationStatus(ProductViewPortletKeys.APPROVED);
		List<SpecCategoryMap> specificationCategoryMappings = specCategoryMapLocalService.findByCategoryId(categoryId,
				0, 4);
		List<Specification> nonMandatorySpecCategories = getNonMandatorySpecCategories(approvedSpecifications,
				specificationCategoryMappings);
		List<ProductSpecificationsModel> productSpecifications = getProductSpecifications(portletRequest);
		List<JSONObject> mandatorySpecCategories = new ArrayList<>();

		if (productSpecifications.isEmpty())
			mandatorySpecCategories = getMandatorySpecCategories(approvedSpecifications, specificationCategoryMappings);

		portletRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		portletRequest.setAttribute(SpecificationSelectionConstants.APPROVED_SPECIFICATIONS.getValue(),
				approvedSpecifications);
		portletRequest.setAttribute(SpecificationSelectionConstants.MANDATORY_SPEC_CATEGORIES.getValue(),
				mandatorySpecCategories);
		portletRequest.setAttribute(SpecificationSelectionConstants.NON_MANDATORY_SPEC_CATEGORIES.getValue(),
				nonMandatorySpecCategories);
		portletRequest.setAttribute(SpecificationSelectionConstants.PRODUCT_SPECIFICATIONS.getValue(),
				productSpecifications);

		try {

			ProductViewUtil.setLastModifiedDateInRequest(portletRequest, null, draftProductId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to set Modified Date. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	/**
	 * 
	 * Returns a list of approved specifications which are mapped to a specific
	 * category.
	 * 
	 * @param approvedSpecifications
	 * @param specCategoryMappings
	 * @return
	 */
	private List<Specification> getNonMandatorySpecCategories(List<Specification> approvedSpecifications,
			List<SpecCategoryMap> specCategoryMappings) {

		return approvedSpecifications.stream()
				.filter(specification -> specCategoryMappings.stream()
						.anyMatch(mapping -> mapping.getSpecificationId() == specification.getSpecificationId()
								&& !mapping.isIsCategoryMandatory()))
				.collect(Collectors.toList());

	}

	private List<JSONObject> getMandatorySpecCategories(List<Specification> approvedSpecifications,
			List<SpecCategoryMap> specCategoryMappings) {

		return approvedSpecifications.stream()
				.filter(specification -> specCategoryMappings.stream()
						.anyMatch(mapping -> mapping.getSpecificationId() == specification.getSpecificationId()
								&& mapping.isIsCategoryMandatory()))
				.map(mandatorySpecification -> {
					try {
						return getSpecificationDetailsJson(mandatorySpecification.getSpecificationId(),
								mandatorySpecification.getSpecificationFieldType(),
								mandatorySpecification.getSpecificationFieldDataType(),
								mandatorySpecification.getSpecificationLabel());
					} catch (PortalException e) {
						LOGGER.warn(
								"Unable to get mandatory specifications. Please enable debug logs for full details.");
						LOGGER.debug(e, e);
					}
					return null;
				}).collect(Collectors.toList());

	}

	private String getSpecificationFieldType(long specificationFieldTypeId) throws PortalException {
		return specFieldTypeLocalService.getSpecFieldType(specificationFieldTypeId).getFieldTypeName();
	}

	private String getSpecificationFieldDataType(long specificationFieldDataTypeId) throws PortalException {

		if (specificationFieldDataTypeId == 0)
			return StringPool.BLANK;

		return specFieldDataTypeLocalService.getSpecFieldDataType(specificationFieldDataTypeId).getFieldDataTypeName();
	}

	private JSONObject getSpecificationDetailsJson(long specificationId, long specificationFieldTypeId,
			long specificationFieldDataTypeId, String specificationLabel) throws PortalException {

		String specFieldTypeName = getSpecificationFieldType(specificationFieldTypeId);
		String specFieldDataTypeName = getSpecificationFieldDataType(specificationFieldDataTypeId);

		List<SpecificationValue> specificationValues = specificationValueLocalService
				.findByFBYSpecificationId(specificationId);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(SpecificationSelectionConstants.SPECIFICATION_ID.getValue(), specificationId);
		jsonObject.put(SpecificationSelectionConstants.SPECIFICATION_LABEL.getValue(), specificationLabel);
		jsonObject.put(SpecificationSelectionConstants.SPECIFICATION_FIELD_TYPE_NAME.getValue(), specFieldTypeName);
		jsonObject.put(SpecificationSelectionConstants.SPECIFICATION_FIELD_DATA_TYPE_NAME.getValue(),
				specFieldDataTypeName);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		specificationValues.stream().forEach(element -> {

			JSONObject specificationValue = JSONFactoryUtil.createJSONObject();

			specificationValue.put(SpecificationSelectionConstants.SPECIFICATION_VALUE_ID.getValue(),
					element.getSpecificationValueId());
			specificationValue.put(SpecificationSelectionConstants.SPECIFICATION_VALUE_LABEL.getValue(),
					element.getSpecificationValueLabel());
			specificationValue.put(SpecificationSelectionConstants.SPECIFICATION_VALUE_UOM.getValue(),
					element.getSpecificationUOM());

			jsonArray.put(specificationValue);

		});

		jsonObject.put(SpecificationSelectionConstants.SPECIFICATION_VALUES.getValue(), jsonArray);

		return jsonObject;

	}

	/**
	 * 
	 * Returns a JSON of Specification Values mapped to a product.
	 * 
	 * @param requestBody
	 * @return
	 * @throws PortalException
	 */
	public JSONObject getSpecValuesBySpecId(JSONObject requestBody) throws PortalException {

		long specificationId = requestBody.getLong(SpecificationSelectionConstants.SPECIFICATION_ID.getValue());
		String specificationLabel = requestBody
				.getString(SpecificationSelectionConstants.SPECIFICATION_LABEL.getValue());
		long specificationFieldTypeId = requestBody
				.getLong(SpecificationSelectionConstants.SPECIFICATION_FIELD_TYPE_ID.getValue());
		long specificationFieldDataTypeId = requestBody
				.getLong(SpecificationSelectionConstants.SPECIFICATION_FIELD_DATA_TYPE_ID.getValue());

		return getSpecificationDetailsJson(specificationId, specificationFieldTypeId, specificationFieldDataTypeId,
				specificationLabel);

	}

	@Reference
	private SpecificationLocalService specificationLocalService;

	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;

	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;

	@Reference
	private SpecFieldDataTypeLocalService specFieldDataTypeLocalService;

	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

	@Reference
	private ProductSpecificationLocalService productSpecificationLocalService;

	@Reference
	private ProductSpecValueMapLocalService productSpecValueMapLocalService;

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationSelectionHelper.class);

}