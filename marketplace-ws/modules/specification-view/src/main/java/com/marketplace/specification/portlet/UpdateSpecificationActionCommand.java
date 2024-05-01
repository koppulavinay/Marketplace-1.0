package com.marketplace.specification.portlet;

import com.liferay.commerce.product.model.CPSpecificationOption;
import com.liferay.commerce.product.service.CPSpecificationOptionLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.specification.category.map.exception.NoSuchSpecCategoryMapException;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=updateSpecification" }, service = MVCActionCommand.class)

public class UpdateSpecificationActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateSpecificationActionCommand.class.getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateSpecificationActionCommand Method"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CPSpecificationOption.class.getName(),
				actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);

		String specificationLabel = ParamUtil.getString(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_LABEL);
		String specificationDescription = ParamUtil.getString(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_DESCRIPTION);

		long specificationId = ParamUtil.getLong(actionRequest, SpecificationViewPortletKeys.SPECIFICATION_ID);
		long specificationFieldType = ParamUtil.getLong(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_FIELD_TYPE);
		long specificationFieldDataType = ParamUtil.getLong(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_FIELD_DATA_TYPE);

		String submitButtonType = ParamUtil.getString(actionRequest, "submitButtonType");
		LOGGER.info("submitButtonType--> " + submitButtonType);

		// Fetching the Specification
		Specification specification = specificationLocalService.fetchSpecification(specificationId);
		boolean facetable = true;
		
		try {
			SpecFieldType specFieldType = specFieldTypeLocalService.getSpecFieldType(specificationFieldType);
			if(specFieldType.getFieldTypeName().equalsIgnoreCase("Free Text")) {
				facetable = false;
			}
			
		} catch(Exception e) {
			LOGGER.error("Specification Field Type not exist :: " + e.getMessage());
		}

		if (submitButtonType.equalsIgnoreCase("SUBMIT_FORM")) {
			addSpecOptionInCommerce(themeDisplay, serviceContext, specification, specificationLabel,
					specificationDescription, 0, facetable);
		} else {
			specification.setSpecificationStatus(SpecificationViewPortletKeys.DRAFT);
		}

		// Updating Specification
		updateSpecification(themeDisplay, specification, specificationLabel, specificationDescription,
				specificationFieldType, specificationFieldDataType, httpServletRequest.getRemoteAddr());

		String specificationDetails = ParamUtil.getString(actionRequest, "specificationDetails");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(specificationDetails);
		LOGGER.info("Specification Details------------------> " + jsonObject);

		// Updating specification categories mapping
		updateSpecificationCategoriesDetails(actionRequest, themeDisplay, specification, jsonObject,
				httpServletRequest.getRemoteAddr());

		// Update specification values mapping
		updateSpecificationValuesDetails(actionRequest, themeDisplay, specification, jsonObject,
				httpServletRequest.getRemoteAddr());

		Layout layout = layoutLocalService.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,
				themeDisplay.getLayoutFriendlyURL(themeDisplay.getLayout()));
		String URL = PortalUtil.getLayoutFullURL(layout, themeDisplay);
		actionResponse.sendRedirect(URL);
		SessionMessages.add(actionRequest, "update-key");

	}

	/**
	 * Pushes Specification Option Details in Liferay Commerce.
	 * 
	 * @param themeDisplay
	 * @param serviceContext
	 * @param specification
	 * @param specificationLabel
	 * @param specificationDescription
	 * @param specificationGroupId
	 * @throws PortalException
	 */
	private void addSpecOptionInCommerce(ThemeDisplay themeDisplay, ServiceContext serviceContext,
			Specification specification, String specificationLabel, String specificationDescription,
			long specificationGroupId, boolean facetable) throws PortalException {

		Map<Locale, String> titleMap = new HashMap<>();
		Map<Locale, String> descriptionMap = new HashMap<>();

		titleMap.put(LocaleUtil.fromLanguageId("en_US"), specificationLabel);
		descriptionMap.put(LocaleUtil.fromLanguageId("en_US"), specificationDescription);

		if (specification.getCpSpecificationId() > 0) {
			cpSpecificationOptionLocalService.updateCPSpecificationOption(specification.getCpSpecificationId(),
					specificationGroupId, titleMap, descriptionMap, facetable, specificationLabel.toLowerCase(),
					serviceContext);
		} else {
			CPSpecificationOption cpSpecificationOption = cpSpecificationOptionLocalService.addCPSpecificationOption(
					themeDisplay.getUserId(), specificationGroupId, titleMap, descriptionMap, facetable,
					specificationLabel.toLowerCase(), serviceContext);
			specification.setCpSpecificationId(cpSpecificationOption.getCPSpecificationOptionId());
		}

		specification.setSpecificationStatus(SpecificationViewPortletKeys.APPROVED);

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Updated in Commerce"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

	}

	/**
	 * Updates Specification Details in Specification Master table.
	 * 
	 * @param themeDisplay
	 * @param specification
	 * @param specificationLabel
	 * @param specificationDescription
	 * @param specificationFieldType
	 * @param specificationFieldDataType
	 * @param ipAddress
	 * @return
	 */
	private Specification updateSpecification(ThemeDisplay themeDisplay, Specification specification,
			String specificationLabel, String specificationDescription, long specificationFieldType,
			long specificationFieldDataType, String ipAddress) {

		// Updated values in custom table
		specification.setSpecificationLabel(specificationLabel);
		specification.setSpecificationDescription(specificationDescription);
		specification.setSpecificationFieldType(specificationFieldType);
		specification.setSpecificationFieldDataType(specificationFieldDataType);
		specification.setSpecificationGroupId(0);
		specification.setSpecificationPriority(0);

		// Updated for Audit purpose
		specification.setCompanyId(themeDisplay.getCompanyId());
		specification.setModifiedDate(new Date());
		specification.setModifiedBy(themeDisplay.getUserId());
		specification.setIpAddress(ipAddress);

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Upadted in Custom Specification"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		return specificationLocalService.updateSpecification(specification);

	}

	/**
	 * Updates Specification Categories Mapping details in Specification Category
	 * Mapping table.
	 * 
	 * It is also responsible for deleting the unused specification categories
	 * mapping from the table.
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param specification
	 * @param specificationDetails
	 * @param ipAddress
	 * @throws JSONException
	 */
	private void updateSpecificationCategoriesDetails(PortletRequest portletRequest, ThemeDisplay themeDisplay,
			Specification specification, JSONObject specificationDetails, String ipAddress) throws JSONException {

		List<Long> specificationCategoryIds = new ArrayList<>();

		List<SpecCategoryMap> specCategoryMap = specCategoryMapLocalService
				.findByFBYSpecificationId(specification.getSpecificationId());

		JSONArray specCategories = specificationDetails.getJSONArray("selectedCategories");

		if (specCategories.length() == 0 && Validator.isNotNull(specCategoryMap)) {
			specCategoryMap.stream().forEach(element -> {
				deleteSpecCategoryMap(element.getSpecCategoryMapId());
			});

			return;
		}

		specificationCategoryIds = updateSpecificationCategories(themeDisplay, specCategories, specification, ipAddress,
				specificationCategoryIds);

		deleteSpecCategoryMapping(specCategoryMap, specificationCategoryIds);

	}

	/**
	 * Update/Add Specification categories mapping.
	 * 
	 * @param themeDisplay
	 * @param specCategories
	 * @param specification
	 * @param ipAddress
	 * @return
	 */
	private List<Long> updateSpecificationCategories(ThemeDisplay themeDisplay, JSONArray specCategories,
			Specification specification, String ipAddress, List<Long> specificationCategoryIds) {

		for (int index = 0; index < specCategories.length(); index++) {

			JSONObject specificationCategory = specCategories.getJSONObject(index);

			SpecCategoryMap specCategoryMap;

			try {

				specCategoryMap = specCategoryMapLocalService.findBySpecificationIdNCategoryId(
						specification.getSpecificationId(), specificationCategory.getLong("categoryId"));

				specCategoryMap.setIsCategoryMandatory(specificationCategory.getBoolean("isCategoryMandatory"));
				specCategoryMap.setModifiedDate(new Date());
				specCategoryMap.setModifiedBy(themeDisplay.getUserId());
				specCategoryMap.setIpAddress(ipAddress);

				specCategoryMap = specCategoryMapLocalService.updateSpecCategoryMap(specCategoryMap);

			} catch (NoSuchSpecCategoryMapException e) {
				specCategoryMap = createSpecificationCategories(themeDisplay, specification.getSpecificationId(),
						specificationCategory.getLong("categoryId"), specificationCategory.getBoolean("categoryId"),
						ipAddress);
			}

			specificationCategoryIds.add(specCategoryMap.getSpecCategoryMapId());

		}

		return specificationCategoryIds;

	}

	/**
	 * Creates Specification Categories mapping in the specification category
	 * mapping table.
	 * 
	 * @param themeDisplay
	 * @param specificationId
	 * @param categoryId
	 * @param isCategoryMadatory
	 * @param ipAddress
	 * @return
	 */
	private SpecCategoryMap createSpecificationCategories(ThemeDisplay themeDisplay, long specificationId,
			long categoryId, boolean isCategoryMadatory, String ipAddress) {

		SpecCategoryMap specCategoryMap = specCategoryMapLocalService
				.createSpecCategoryMap(counterLocalService.increment());

		specCategoryMap.setSpecificationId(specificationId);
		specCategoryMap.setCategoryId(categoryId);
		specCategoryMap.setIsCategoryMandatory(isCategoryMadatory);

		// Added for Audit purpose
		specCategoryMap.setCompanyId(themeDisplay.getCompanyId());
		specCategoryMap.setCreateDate(new Date());
		specCategoryMap.setModifiedDate(new Date());
		specCategoryMap.setCreatedBy(themeDisplay.getUserId());
		specCategoryMap.setModifiedBy(themeDisplay.getUserId());
		specCategoryMap.setIpAddress(ipAddress);

		return specCategoryMapLocalService.updateSpecCategoryMap(specCategoryMap);

	}

	/**
	 * Deletes unused specification category mapping from the table.
	 * 
	 * @param specCategoryMap
	 * @param specificationCategoryIds
	 */
	private void deleteSpecCategoryMapping(List<SpecCategoryMap> specCategoryMap, List<Long> specificationCategoryIds) {

		specCategoryMap.stream().forEach(specificationCategory -> {
			if (!specificationCategoryIds.contains(specificationCategory.getSpecCategoryMapId())) {
				deleteSpecCategoryMap(specificationCategory.getSpecCategoryMapId());
			}
		});

	}

	/**
	 * Deletes Specification Category mapping by its Primary key.
	 * 
	 * @param specCategoryMapId
	 */
	private void deleteSpecCategoryMap(long specCategoryMapId) {

		try {
			specCategoryMapLocalService.deleteSpecCategoryMap(specCategoryMapId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to delete Specification category map. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	/**
	 * Updates Specification Values Mapping details in Specification values mapping
	 * table.
	 * 
	 * It is also responsible to delete the unused specification value mappings from
	 * the database.
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param specification
	 * @param specificationDetails
	 * @param ipAddress
	 * @throws JSONException
	 */
	private void updateSpecificationValuesDetails(PortletRequest portletRequest, ThemeDisplay themeDisplay,
			Specification specification, JSONObject specificationDetails, String ipAddress) throws JSONException {

		List<Long> specificationValueIds = new ArrayList<>();

		List<SpecificationValue> specificationValues = specificationValueLocalService
				.findByFBYSpecificationId(specification.getSpecificationId());

		JSONArray specificationValuesJson = specificationDetails.getJSONArray("specificationValues");

		if ((specificationValuesJson.length() == 0 && Validator.isNotNull(specificationValues))
				|| (specificationValuesJson.getJSONObject(0).length() == 0)) {
			specificationValues.stream().forEach(element -> {
				deleteSpecificationValue(element.getSpecificationValueId());
			});

			return;
		}

		specificationValueIds = updateSpecificatioValues(themeDisplay, specificationValuesJson, specification,
				ipAddress, specificationValueIds);

		deleteSpecificationValuesMapping(specificationValues, specificationValueIds);

	}

	/**
	 * Update/Create Specification Values Mapping in the database.
	 * 
	 * @param themeDisplay
	 * @param specificationValues
	 * @param specification
	 * @param ipAddress
	 * @param specificationValueIds
	 * @return
	 */
	private List<Long> updateSpecificatioValues(ThemeDisplay themeDisplay, JSONArray specificationValues,
			Specification specification, String ipAddress, List<Long> specificationValueIds) {

		for (int index = 0; index < specificationValues.length(); index++) {

			JSONObject specificationValueJson = specificationValues.getJSONObject(index);

			SpecificationValue specificationValueMap;

			try {

				specificationValueMap = specificationValueLocalService
						.getSpecificationValue(specificationValueJson.getLong("specificationValueId"));

				specificationValueMap.setSpecificationValueLabel(specificationValueJson.getString("valueLabel"));
				specificationValueMap.setSpecificationUOM(specificationValueJson.getString("valueUOM"));
				specificationValueMap.setModifiedBy(themeDisplay.getUserId());
				specificationValueMap.setModifiedDate(new Date());

				specificationValueMap = specificationValueLocalService.updateSpecificationValue(specificationValueMap);

			} catch (PortalException e) {
				specificationValueMap = createSpecificationValues(themeDisplay, specification.getSpecificationId(),
						specificationValueJson.getString("valueLabel"), specificationValueJson.getString("valueUOM"),
						ipAddress);
			}

			specificationValueIds.add(specificationValueMap.getSpecificationValueId());

		}

		return specificationValueIds;

	}

	/**
	 * Create Specification Values mapping in the database.
	 * 
	 * @param themeDisplay
	 * @param specificationId
	 * @param specificationValueLabel
	 * @param specificationValueUOM
	 * @param ipAddress
	 * @return
	 */
	private SpecificationValue createSpecificationValues(ThemeDisplay themeDisplay, long specificationId,
			String specificationValueLabel, String specificationValueUOM, String ipAddress) {

		SpecificationValue specificationValue = specificationValueLocalService
				.createSpecificationValue(counterLocalService.increment());
		specificationValue.setSpecificationId(specificationId);
		specificationValue.setSpecificationValueLabel(specificationValueLabel);
		specificationValue.setSpecificationUOM(specificationValueUOM);

		specificationValue.setCompanyId(themeDisplay.getCompanyId());
		specificationValue.setCreateDate(new Date());
		specificationValue.setModifiedDate(new Date());
		specificationValue.setCreatedBy(themeDisplay.getUserId());
		specificationValue.setModifiedBy(themeDisplay.getUserId());
		specificationValue.setIpAddress(ipAddress);
		specificationValue.setUserId(themeDisplay.getUserId());
		specificationValue.setUserName(themeDisplay.getUser().getFullName());

		return specificationValueLocalService.updateSpecificationValue(specificationValue);

	}

	/**
	 * Deletes unused specification value mappings from the mapping table.
	 * 
	 * @param specificationValues
	 * @param specificationValueIds
	 */
	private void deleteSpecificationValuesMapping(List<SpecificationValue> specificationValues,
			List<Long> specificationValueIds) {

		specificationValues.stream().forEach(specificationValue -> {
			if (!specificationValueIds.contains(specificationValue.getSpecificationValueId())) {
				deleteSpecificationValue(specificationValue.getSpecificationValueId());
			}
		});

	}

	/**
	 * Deletes Specification value mapping by its primary key.
	 * 
	 * @param specificationValueId
	 */
	private void deleteSpecificationValue(long specificationValueId) {

		try {
			specificationValueLocalService.deleteSpecificationValue(specificationValueId);
		} catch (PortalException e) {
			LOGGER.warn("Unable to delete specification value. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

	}

	@Reference
	private CPSpecificationOptionLocalService cpSpecificationOptionLocalService;

	@Reference
	private SpecificationLocalService specificationLocalService;

	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

	@Reference
	private LayoutLocalService layoutLocalService;
	
	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;

}
