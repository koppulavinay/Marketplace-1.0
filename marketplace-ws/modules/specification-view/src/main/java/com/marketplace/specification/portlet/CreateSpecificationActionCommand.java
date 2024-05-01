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
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.util.Date;
import java.util.HashMap;
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
		"mvc.command.name=createSpecification" }, service = MVCActionCommand.class)

public class CreateSpecificationActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(CreateSpecificationActionCommand.class.getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateSpecificationActionCommand Method"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CPSpecificationOption.class.getName(),
				actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);

		String specificationLabel = ParamUtil.getString(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_LABEL);
		String specificationDescription = ParamUtil.getString(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_DESCRIPTION);

		long specificationFieldType = ParamUtil.getLong(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_FIELD_TYPE);
		long specificationFieldDataType = ParamUtil.getLong(actionRequest,
				SpecificationViewPortletKeys.SPECIFICATION_FIELD_DATA_TYPE);

		String submitButtonType = ParamUtil.getString(actionRequest, "submitButtonType");
		LOGGER.info("submitButtonType--> " + submitButtonType);

		Specification specification = specificationLocalService.createSpecification(counterLocalService.increment());
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
		
		addSpecification(themeDisplay, specification, specificationLabel, specificationDescription,
				specificationFieldType, specificationFieldDataType, httpServletRequest.getRemoteAddr());

		// Saving Specification Category Mapping and Specification Value mapping in the
		// database
		saveSpecificationDetails(actionRequest, themeDisplay, specification, httpServletRequest.getRemoteAddr());

		Layout layout = layoutLocalService.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,
				themeDisplay.getLayoutFriendlyURL(themeDisplay.getLayout()));
		String URL = PortalUtil.getLayoutFullURL(layout, themeDisplay);
		actionResponse.sendRedirect(URL);
		SessionMessages.add(actionRequest, "success-key");
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

		// Adding Specification in Liferay Commerce
		CPSpecificationOption cpSpecificationOption = null;

		try {
			// Getting Already created CP Specification Option from Liferay commerce
			cpSpecificationOption = cpSpecificationOptionLocalService
					.getCPSpecificationOption(themeDisplay.getCompanyId(), specificationLabel.toLowerCase());

		} catch (PortalException e) {

			LOGGER.warn(
					"CP Specification Option not found. Creating a new CP Specification Option in Liferay commerce.");

			cpSpecificationOption = cpSpecificationOptionLocalService.addCPSpecificationOption(themeDisplay.getUserId(),
					specificationGroupId, titleMap, descriptionMap, facetable, specificationLabel.toLowerCase(),
					serviceContext);
		}

		specification.setCpSpecificationId(cpSpecificationOption.getCPSpecificationOptionId());
		specification.setSpecificationStatus(SpecificationViewPortletKeys.APPROVED);

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Added in Commerce"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
	}

	/**
	 * Saves Specification Category Mapping and Specification Value mapping in the
	 * database.
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param specification
	 * @param ipAddress
	 * @throws JSONException
	 */
	private void saveSpecificationDetails(PortletRequest portletRequest, ThemeDisplay themeDisplay,
			Specification specification, String ipAddress) throws JSONException {

		String specificationDetails = ParamUtil.getString(portletRequest, "specificationDetails");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(specificationDetails);
		LOGGER.info("Specification Details------------------> " + jsonObject);

		JSONArray specCategories = jsonObject.getJSONArray("selectedCategories");
		JSONArray specificationValues = jsonObject.getJSONArray("specificationValues");

		saveSpecCategoriesMapping(themeDisplay, specCategories, specification, ipAddress);
		saveSpecValueMapping(themeDisplay, specificationValues, specification, ipAddress);

	}

	private void addSpecification(ThemeDisplay themeDisplay, Specification specification,
			String specificationLabel, String specificationDescription, long specificationFieldType,
			long specificationFieldDataType, String ipAddress) {

		// Adding Specification in Custom Table
		specification.setSpecificationLabel(specificationLabel);
		specification.setSpecificationDescription(specificationDescription);
		specification.setSpecificationFieldType(specificationFieldType);
		specification.setSpecificationFieldDataType(specificationFieldDataType);
		specification.setSpecificationGroupId(0);
		specification.setSpecificationPriority(0);

		// Added for Audit purpose
		specification.setCompanyId(themeDisplay.getCompanyId());
		specification.setCreateDate(new Date());
		specification.setModifiedDate(new Date());
		specification.setCreatedBy(themeDisplay.getUserId());
		specification.setModifiedBy(themeDisplay.getUserId());
		specification.setIpAddress(ipAddress);

		specificationLocalService.addSpecification(specification);
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Added in Custom Specification"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

	}

	/**
	 * Saves Specification Categories Mapping.
	 * 
	 * @param themeDisplay
	 * @param specCategories
	 * @param specification
	 * @param ipAddress
	 */
	private void saveSpecCategoriesMapping(ThemeDisplay themeDisplay, JSONArray specCategories,
			Specification specification, String ipAddress) {

		for (int index = 0; index < specCategories.length(); index++) {

			JSONObject specificationCategory = specCategories.getJSONObject(index);

			SpecCategoryMap specCategoryMap = specCategoryMapLocalService
					.createSpecCategoryMap(counterLocalService.increment());
			specCategoryMap.setSpecificationId(specification.getSpecificationId());
			specCategoryMap.setCategoryId(specificationCategory.getLong("categoryId"));
			specCategoryMap.setIsCategoryMandatory(specificationCategory.getBoolean("isCategoryMandatory"));

			// Added for Audit purpose
			specCategoryMap.setCompanyId(themeDisplay.getCompanyId());
			specCategoryMap.setCreateDate(new Date());
			specCategoryMap.setModifiedDate(new Date());
			specCategoryMap.setCreatedBy(themeDisplay.getUserId());
			specCategoryMap.setModifiedBy(themeDisplay.getUserId());
			specCategoryMap.setIpAddress(ipAddress);

			specCategoryMapLocalService.addSpecCategoryMap(specCategoryMap);

		}

	}

	/**
	 * Saves Specification Value Mapping.
	 * 
	 * @param themeDisplay
	 * @param specificationValues
	 * @param specification
	 * @param ipAddress
	 */
	private void saveSpecValueMapping(ThemeDisplay themeDisplay, JSONArray specificationValues,
			Specification specification, String ipAddress) {

		for (int index = 0; index < specificationValues.length(); index++) {

			JSONObject optionValueJson = specificationValues.getJSONObject(index);

			if (Validator.isNotNull(optionValueJson.getString(SpecificationViewPortletKeys.VALUE_LABEL))) {

				// Adding Specification Values in Custom Table
				SpecificationValue specificationValue = specificationValueLocalService
						.createSpecificationValue(counterLocalService.increment());
				specificationValue.setSpecificationId(specification.getSpecificationId());
				specificationValue.setSpecificationValueLabel(
						optionValueJson.getString(SpecificationViewPortletKeys.VALUE_LABEL));
				specificationValue
						.setSpecificationUOM(optionValueJson.getString(SpecificationViewPortletKeys.VALUE_UOM));

				// Added for Audit purpose
				specificationValue.setCompanyId(themeDisplay.getCompanyId());
				specificationValue.setCreateDate(new Date());
				specificationValue.setModifiedDate(new Date());
				specificationValue.setCreatedBy(themeDisplay.getUserId());
				specificationValue.setModifiedBy(themeDisplay.getUserId());
				specificationValue.setIpAddress(ipAddress);

				specificationValueLocalService.addSpecificationValue(specificationValue);
				LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Added in Custom SpecificationValue"
						+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

			}

		}

	}

	@Reference
	private CPSpecificationOptionLocalService cpSpecificationOptionLocalService;

	@Reference
	private Localization localization;

	@Reference
	private SpecificationLocalService specificationLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;

	@Reference
	private LayoutLocalService layoutLocalService;
	
	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;

}
