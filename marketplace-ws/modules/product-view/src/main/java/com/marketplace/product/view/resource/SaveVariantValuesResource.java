package com.marketplace.product.view.resource;

import com.liferay.commerce.product.model.CPOption;
import com.liferay.commerce.product.model.CPOptionValue;
import com.liferay.commerce.product.service.CPOptionLocalServiceUtil;
import com.liferay.commerce.product.service.CPOptionValueLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, 
		"mvc.command.name=" + ProductViewPortletKeys.SAVE_VARIANT_VALUE_RESOURCE_CMD, }, service = MVCResourceCommand.class)

public class SaveVariantValuesResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SaveVariantValuesResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SaveVariantValuesResource Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		
		String draftProductId = ParamUtil.getString(resourceRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		String variantName = ParamUtil.getString(resourceRequest, "variantName");
		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		
		if(cmd.equalsIgnoreCase("Add")) {
			LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Start Adding Variant Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
			String[] variantValues = ParamUtil.getParameterValues(resourceRequest, "variantValues");

			// Adding new variant in custom tables
			ProductVariant productVariant = productVariantLocalService.createProductVariant(counterLocalService.increment());
			Map<String, String> parameters = new HashMap<>();
			parameters.put(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
			parameters.put("variantName", variantName);
			parameters.put(ProductViewPortletKeys.CREATE_FLAG, "true");
			
			// setting data in custom tables
			productVariant = setVariant(productVariant, httpServletRequest, themeDisplay, parameters);
			
			productVariantLocalService.addProductVariant(productVariant);
			
			// setting data in Liferay Commerce if not available
			long cpOptionId = addCpOption(variantName, themeDisplay, resourceRequest);
			
			// setting variant values in custom table
			newVariantValuesIterations(variantValues, themeDisplay, httpServletRequest, resourceRequest, 
					productVariant.getProductVariantId(), cpOptionId, draftProductId);
			
			LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "End Adding Variant Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
			
		} else {
			LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Start Updating Variant Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
			
			long productVariantId = ParamUtil.getLong(resourceRequest, "productVariantId");
			long[] variantValueIds = ParamUtil.getLongValues(resourceRequest, "variantValueId");
			String[] variantValues = ParamUtil.getParameterValues(resourceRequest, "variantVaue");
			
			// getting variant from the database to update
			ProductVariant productVariant = productVariantLocalService.getProductVariant(productVariantId);
			Map<String, String> prodVariantParameters = new HashMap<>();
			prodVariantParameters.put(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
			prodVariantParameters.put("variantName", variantName);
			prodVariantParameters.put(ProductViewPortletKeys.CREATE_FLAG, "false");
			
			// setting data in custom tables
			productVariant = setVariant(productVariant, httpServletRequest, themeDisplay, prodVariantParameters);
			
			productVariantLocalService.updateProductVariant(productVariant);
			
			// setting data in Liferay Commerce if not available
			long cpOptionId = addCpOption(variantName, themeDisplay, resourceRequest);
			
			if(variantValueIds.length > 0) {
				variantValuesIterations(variantValues, resourceRequest, productVariantId, draftProductId, themeDisplay, httpServletRequest, cpOptionId);
			} else {
				productVariantLocalService.deleteProductVariant(productVariantId);
				deleteVariantValues(productVariantId);
			}
			
			// setting old variant values in custom table
			//oldVariantValuesIterations(variantValueIds, resourceRequest, productVariantId, themeDisplay, httpServletRequest, cpOptionId, draftProductId);
			
			LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "End Updating Variant Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		}
		
		resourceResponse.getWriter().print("true");
		
	}
	
	private void deleteVariantValues(long productVariantId) throws PortalException {
		List<VariantValue> variantValues = variantValueLocalService.findByProductVariantId(productVariantId);
		for (VariantValue variantValue : variantValues) {
			variantValueLocalService.deleteVariantValue(variantValue.getVariantValueId());
		}
	}
	
	private void variantValuesIterations(String[] variantValues, ResourceRequest resourceRequest, long productVariantId, 
			String draftProductId, ThemeDisplay themeDisplay, HttpServletRequest httpServletRequest, long cpOptionId) throws PortalException {
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Start Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		deleteVariantValues(productVariantId);
		
		for (String variantValue : variantValues) {
			Map<String, String> variantValParameters = new HashMap<>();
			//String variantValue = ParamUtil.getString(resourceRequest, "variantVaue_"+variantVal);
			//LOGGER.info("variantValue--> "+ variantValue);
			VariantValue variantValueObj = variantValueLocalService.createVariantValue(counterLocalService.increment());
			variantValParameters.put("productVariantId", String.valueOf(productVariantId));
			variantValParameters.put("variantValue", variantValue);
			variantValParameters.put(ProductViewPortletKeys.CREATE_FLAG, "true");
			variantValParameters.put("draftProductId", draftProductId);
			
			variantValueObj = setVariantValues(variantValueObj, themeDisplay, httpServletRequest, variantValParameters);
			
			variantValueLocalService.addVariantValue(variantValueObj);
			
			addCpOptionValus(variantValue, resourceRequest, cpOptionId);
		}
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "End Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
	}
	
	// setting old variant values in custom table
	public void oldVariantValuesIterations(long[] variantValueIds, ResourceRequest resourceRequest, long productVariantId, 
			ThemeDisplay themeDisplay, HttpServletRequest httpServletRequest, long cpOptionId, String draftProductId) throws PortalException {
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Start Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		for (long variantVal : variantValueIds) {
			LOGGER.info("value--> " + variantVal);
			String variantValue = ParamUtil.getString(resourceRequest, "variantVaue_"+variantVal);
			VariantValue variantValueObj = null;
			Map<String, String> variantValParameters = new HashMap<>();
			try {
				if(variantVal == 0) {
					variantValueObj = variantValueLocalService.createVariantValue(counterLocalService.increment());
					
					variantValParameters.put("productVariantId", String.valueOf(productVariantId));
					variantValParameters.put("variantValue", variantValue);
					variantValParameters.put(ProductViewPortletKeys.CREATE_FLAG, "true");
					variantValParameters.put("draftProductId", draftProductId);
					
					variantValueObj = setVariantValues(variantValueObj, themeDisplay, httpServletRequest, variantValParameters);
					
					variantValueLocalService.addVariantValue(variantValueObj);
					
					addCpOptionValus(variantValue, resourceRequest, cpOptionId);
					
				} else {
					variantValueObj = variantValueLocalService.getVariantValue(variantVal);
					variantValParameters.put("productVariantId", String.valueOf(productVariantId));
					variantValParameters.put("variantValue", variantValue);
					variantValParameters.put(ProductViewPortletKeys.CREATE_FLAG, "false");
					variantValParameters.put("draftProductId", draftProductId);
					
					variantValueObj = setVariantValues(variantValueObj, themeDisplay, httpServletRequest, variantValParameters);
					
					variantValueLocalService.updateVariantValue(variantValueObj);
				}
				
			} catch(Exception e) {
				variantValueObj = variantValueLocalService.createVariantValue(counterLocalService.increment());
				variantValParameters.put("productVariantId", String.valueOf(productVariantId));
				variantValParameters.put("variantValue", variantValue);
				variantValParameters.put(ProductViewPortletKeys.CREATE_FLAG, "true");
				variantValParameters.put("draftProductId", draftProductId);
				
				variantValueObj = setVariantValues(variantValueObj, themeDisplay, httpServletRequest, variantValParameters);
				
				variantValueLocalService.addVariantValue(variantValueObj);
				
				addCpOptionValus(variantValue, resourceRequest, cpOptionId);
			}
		}
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "End Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
	}
	
	// setting new variant values in custom table
	public void newVariantValuesIterations(String[] variantValues, ThemeDisplay themeDisplay, HttpServletRequest httpServletRequest, 
			ResourceRequest resourceRequest, long productVariantId, long cpOptionId, String draftProductId) throws PortalException {
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Start Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		for (String variantVal : variantValues) {
			VariantValue variantValue = variantValueLocalService.createVariantValue(counterLocalService.increment());
			variantValue.setProductVariantId(productVariantId);
			variantValue.setVariantVal(variantVal);
			variantValue.setDraftProductId(Long.parseLong(draftProductId));
			
			// Audit fields
			variantValue.setIpAddress(httpServletRequest.getRemoteAddr());
			variantValue.setGroupId(themeDisplay.getScopeGroupId());
			variantValue.setCompanyId(themeDisplay.getCompanyId());
			variantValue.setUserId(themeDisplay.getUserId());
			variantValue.setUserName(themeDisplay.getUser().getFullName());
			variantValue.setCreateDate(new Date());
			variantValue.setCreatedBy(themeDisplay.getUserId());
			variantValue.setModifiedDate(new Date());
			variantValue.setModifiedBy(themeDisplay.getUserId());
			
			variantValueLocalService.addVariantValue(variantValue);
			
			addCpOptionValus(variantVal, resourceRequest, cpOptionId);
			
			LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "End Adding Variant Values" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		}
	}
	
	// setting data in custom tables of product variant
	public ProductVariant setVariant(ProductVariant productVariant, HttpServletRequest httpServletRequest, 
			ThemeDisplay themeDisplay, Map<String, String> parameters) {
		
		productVariant.setDraftProductId(Long.parseLong(parameters.get(ProductViewPortletKeys.DRAFT_PRODUCT_ID)));
		productVariant.setVariantName(parameters.get("variantName"));
		
		// Audit fields
		productVariant.setIpAddress(httpServletRequest.getRemoteAddr());
		productVariant.setGroupId(themeDisplay.getScopeGroupId());
		productVariant.setCompanyId(themeDisplay.getCompanyId());
		productVariant.setUserId(themeDisplay.getUserId());
		productVariant.setUserName(themeDisplay.getUser().getFullName());
		
		if(parameters.get(ProductViewPortletKeys.CREATE_FLAG).equalsIgnoreCase("true")) {
			productVariant.setCreateDate(new Date());
			productVariant.setCreatedBy(themeDisplay.getUserId());
		}
		
		productVariant.setModifiedDate(new Date());
		productVariant.setModifiedBy(themeDisplay.getUserId());
		
		return productVariant;
	}
	
	// setting data in custom tables of variant values
	public VariantValue setVariantValues(VariantValue variantValue, ThemeDisplay themeDisplay, 
			HttpServletRequest httpServletRequest, Map<String, String> parameters) {
		
		variantValue.setVariantVal(parameters.get("variantValue"));
		variantValue.setProductVariantId(Long.parseLong(parameters.get("productVariantId")));
		variantValue.setDraftProductId(Long.parseLong(parameters.get("draftProductId")));
		
		// Audit fields
		variantValue.setIpAddress(httpServletRequest.getRemoteAddr());
		variantValue.setGroupId(themeDisplay.getScopeGroupId());
		variantValue.setCompanyId(themeDisplay.getCompanyId());
		variantValue.setUserId(themeDisplay.getUserId());
		variantValue.setUserName(themeDisplay.getUser().getFullName());
		
		if(parameters.get(ProductViewPortletKeys.CREATE_FLAG).equalsIgnoreCase("true")) {
			variantValue.setCreateDate(new Date());
			variantValue.setCreatedBy(themeDisplay.getUserId());
		}
		
		variantValue.setModifiedDate(new Date());
		variantValue.setModifiedBy(themeDisplay.getUserId());
		
		return variantValue;
	}
	
	// pushing variants data to LR Commerce Options
	public long addCpOption(String variantName, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CPOption.class.getName(), resourceRequest);
		Map<Locale, String> variantNameMap = new HashMap<>();
		variantNameMap.put(LocaleUtil.US, variantName);
		CPOption cpOption = null;
		long cpOptionId = 0;
		
		try {
			cpOption = CPOptionLocalServiceUtil.fetchCPOption(themeDisplay.getCompanyId(), getLiferaykeyFormat(variantName));
			cpOptionId = cpOption.getCPOptionId();
		} catch (Exception e1) {
			if(Validator.isNull(cpOption)) {
				cpOption = CPOptionLocalServiceUtil.addCPOption(variantName, themeDisplay.getUserId(), variantNameMap, null, "select", true, 
						false, true, getLiferaykeyFormat(variantName), serviceContext);
				cpOptionId = cpOption.getCPOptionId();
			}
		}
		
		return cpOptionId;
	}
	
	// pushing variant values to LR Commerce Option Values
	public void addCpOptionValus(String variantVal, ResourceRequest resourceRequest, long cpOptionId) throws PortalException {
		ServiceContext serviceContextValue = ServiceContextFactory.getInstance(CPOptionValue.class.getName(), resourceRequest);
		Map<Locale, String> variantValueMap = new HashMap<>();
		variantValueMap.put(LocaleUtil.US, variantVal);
		CPOptionValue cpOptionValue = null;
		
		try {
			cpOptionValue = CPOptionValueLocalServiceUtil.getCPOptionValue(cpOptionId, getLiferaykeyFormat(variantVal));
			
		} catch (Exception e1) {
			if(Validator.isNull(cpOptionValue)) {
				CPOptionValueLocalServiceUtil.addCPOptionValue(cpOptionId, variantValueMap, 0.0, getLiferaykeyFormat(variantVal), serviceContextValue);
			}
		}
	}
	
	// generating key as per LR format
	public static String getLiferaykeyFormat(String key) {
		return key.toLowerCase().replaceAll("[^\\dA-Za-z_]", " ").replaceAll("/ +(?= )/g", " ").replaceAll("\\s+", "-");
	}
	
	@Reference
	private ProductVariantLocalService productVariantLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private VariantValueLocalService variantValueLocalService;

}
