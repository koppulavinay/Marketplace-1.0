package com.marketplace.product.view.action;

import com.buycorp.common.util.CommonUtil;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalServiceUtil;
import com.liferay.commerce.model.CPDefinitionInventory;
import com.liferay.commerce.price.list.constants.CommercePriceListConstants;
import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.service.CommercePriceEntryLocalServiceUtil;
import com.liferay.commerce.price.list.service.CommercePriceListLocalServiceUtil;
import com.liferay.commerce.product.model.CPAttachmentFileEntry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.model.CPOption;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.service.CPAttachmentFileEntryLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionOptionValueRelLocalServiceUtil;
import com.liferay.commerce.product.service.CPDefinitionSpecificationOptionValueLocalServiceUtil;
import com.liferay.commerce.product.service.CPInstanceLocalServiceUtil;
import com.liferay.commerce.product.service.CPOptionLocalServiceUtil;
import com.liferay.commerce.product.service.CommerceCatalogLocalServiceUtil;
import com.liferay.commerce.service.CPDefinitionInventoryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalServiceUtil;
import com.marketplace.product.search.keywords.model.ProductSearchKeywords;
import com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalServiceUtil;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalServiceUtil;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.service.ProductSpecValueMapLocalServiceUtil;
import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.service.ProductSpecificationLocalServiceUtil;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalServiceUtil;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.ProductViewHelper;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalServiceUtil;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalServiceUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=" + ProductViewPortletKeys.ADDITIONAL_INFORMATION_ACTION_CMD }, service = MVCActionCommand.class)
public class AdditionalInformationAction implements MVCActionCommand {
	
	int displayDateMonth;
	int displayDateDay;
	int displayDateYear; 
	int displayDateHour; 
	int displayDateMinute; 
	int displayDateAmPm;
	ServiceContext serviceContext;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			productViewHelper.addProductAdditionalInformation(actionRequest);
			
			LOGGER.info("Product's Additional Information Saved Successfully.");
			
			long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
			
			actionRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
			
			String productStatus = ParamUtil.getString(actionRequest, "productStatus");

			if (productStatus.equals("DRAFT")) {
				long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");
				productViewHelper.saveProductAsDraft(draftProductId, productStatus, stepNumber,
						themeDisplay.getUserId());
				SessionMessages.add(actionRequest, "success-key");
				productViewHelper.redirectToPIMProductListing(actionResponse);
			} else {
				productViewHelper.removeDraftProductStatus(draftProductId, themeDisplay.getUserId(), "APPROVED");
				SessionMessages.add(actionRequest, "success-key");
				
				CommerceCatalog commerceCatalog = CommerceCatalogLocalServiceUtil.
						getCommerceCatalog(Long.parseLong(CommonUtil.getCustomFieldValue("Catalog")));
				//CommerceCatalog commerceCatalog = CommerceCatalogLocalServiceUtil.getCommerceCatalog(46742);
						//fetchCommerceCatalogByExternalReferenceCode("BuyCorp Catalog", themeDisplay.getCompanyId());
				
//				Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), String.valueOf(commerceCatalog.getCommerceCatalogId()));
//				User user = UserLocalServiceUtil.getGuestUser(group.getCompanyId());
				LOGGER.info("commerceCatalog---> " + commerceCatalog);
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
				
				Product product = ProductLocalServiceUtil.getProduct(draftProductId);
				
				Map<String, String> productParameters = new HashMap<>();
				productParameters.put("displayDateMonth", String.valueOf(displayDateMonth));
				productParameters.put("displayDateDay", String.valueOf(displayDateDay));
				productParameters.put("displayDateYear", String.valueOf(displayDateYear));
				productParameters.put("displayDateHour", String.valueOf(displayDateHour));
				productParameters.put("displayDateMinute", String.valueOf(displayDateMinute));
				productParameters.put("brandId", String.valueOf(product.getBrandId()));
				productParameters.put("categoryId", String.valueOf(product.getCategoryId()));
				productParameters.put("draftProductId", String.valueOf(draftProductId));
				productParameters.put("productType", product.getProductType());
				productParameters.put("groupId", String.valueOf(group.getGroupId()));
				productParameters.put("companyId", String.valueOf(group.getCompanyId()));
				
				pushDataToCommerce(product, themeDisplay, productParameters);
				
				redirectToNextStep(actionRequest, actionResponse);
				SessionMessages.add(actionRequest, "update.success");
			}
			
		} catch (UnsupportedEncodingException | PortalException e) {
			LOGGER.warn("Unable to add Product's additional information. Please enable debug logs for full details.");
			e.printStackTrace();
			LOGGER.debug(e, e);
		}
		
		return false;
	}
	
	private void redirectToNextStep(ActionRequest actionRequest, ActionResponse actionResponse) {

		long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		
		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.DRAFT_PRODUCT_ID, String.valueOf(draftProductId));
		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.MVC_RENDER_COMMAND_NAME,
				ProductViewPortletKeys.PIM_PRODUCT_LISTING_RENDER_CMD);

	}
	
	private void pushDataToCommerce(Product product, ThemeDisplay themeDisplay, Map<String,String> parameters) throws PortalException {
		
		LOGGER.info("::: Start of data push to LR :::");
		
		CPDefinition cpDefinition = CPDefinitionLocalServiceUtil.getCPDefinition(product.getCpDefinitionId());
		
		if(Validator.isNotNull(cpDefinition)) {
			
			deleteVariantValues(cpDefinition.getCPDefinitionId());
			addVariantsValue(cpDefinition, product.getDraftProductId(), themeDisplay, serviceContext);
			LOGGER.info("::: Variants are attached to product :::");
			
			deleteSpecifications(cpDefinition.getCPDefinitionId());
			addSpecification(themeDisplay, product.getDraftProductId(), cpDefinition, serviceContext);
			LOGGER.info("::: Specifications are attached to product :::");
			
			CPInstanceLocalServiceUtil.deleteCPInstances(cpDefinition.getCPDefinitionId());
			LOGGER.info("::: Deleted old SKUs of product :::");
			
			deleteModelBasedUploadImages(cpDefinition);
			LOGGER.info("::: Deleted old images of product :::");
			
			List<ProductSKU> productSKUs = ProductSKULocalServiceUtil.findByDraftProductSkuId(product.getDraftProductId());
			
			for (ProductSKU productSKU : productSKUs) {
				
				Map<Long, List<Long>> cpDefinitionOptionRelIdCPDefinitionOptionValueRelIdMap = new HashMap<>();
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				if(!productSKU.getSkuCreationName().equalsIgnoreCase("Default")) {
					
					String[] variantValues = productSKU.getSkuCreationName().split("/");
					// Red
					// M
					for (String variantValue : variantValues) {
						
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						JSONArray valueArray = JSONFactoryUtil.createJSONArray();
						
						List<Long> cPDefintionOptionRelValList = new ArrayList<>();
						List<VariantValue> variantValuesList = VariantValueLocalServiceUtil.
								findByValueAndId(product.getDraftProductId(), variantValue);
						long productVariantId = variantValuesList.get(0).getProductVariantId();
						ProductVariant productVariant = ProductVariantLocalServiceUtil.getProductVariant(productVariantId);
						long cpDefinitionOptionRelId = CPDefinitionOptionRelLocalServiceUtil
								.fetchCPDefinitionOptionRel(cpDefinition.getCPDefinitionId(), getCPOptionId(productVariant.getVariantName(), 
										themeDisplay)).getCPDefinitionOptionRelId();
						long cPDefintionOptionRelValId = CPDefinitionOptionValueRelLocalServiceUtil
								.fetchCPDefinitionOptionValueRel(cpDefinitionOptionRelId, getLiferaykeyFormat(variantValue)).getCPDefinitionOptionValueRelId();
						
						cPDefintionOptionRelValList.add(cPDefintionOptionRelValId);
						cpDefinitionOptionRelIdCPDefinitionOptionValueRelIdMap.put(cpDefinitionOptionRelId,
								cPDefintionOptionRelValList);
						
						jsonObject.put("key", getLiferaykeyFormat(productVariant.getVariantName()));
						valueArray.put(getLiferaykeyFormat(variantValue));
						jsonObject.put("value", valueArray);
						
						jsonArray.put(jsonObject);
						
					}
				}
				
				CPInstance cpInstance = CPInstanceLocalServiceUtil.addCPInstance(productSKU.getSkuId(), cpDefinition.getCPDefinitionId(), 
						Long.parseLong(parameters.get("groupId")), productSKU.getSkuId() + "(" + productSKU.getSkuCreationName() + ")", 
						null, null, purchasableFlag(productSKU), cpDefinitionOptionRelIdCPDefinitionOptionValueRelIdMap, 0.0, 0.0, 0.0, 0.0, 
						productSKU.getBasePrice(), productSKU.getOfferPrice(), productSKU.getCost(), true, displayDateMonth, displayDateDay, 
						displayDateYear, displayDateHour, displayDateMinute, 0, 0, 0, 0, 0, true, false, false, 1, null, null, 0, false, 1, 
						null, null, 0, null, false, null, 0, 0, 0, 0, serviceContext);
				
				createPriceList(cpInstance, cpDefinition.getCProductId(), serviceContext);
				LOGGER.info("SKU is created for " + productSKU.getSkuName() + " with id : " + cpInstance.getCPInstanceId());
				
				addInventoryWarehouse(themeDisplay, productSKU, cpInstance);
				LOGGER.info("::: Inventory pushed to product :::");
				
				modelBasedUploadImages(cpDefinition, themeDisplay, product, productSKU, jsonArray.toString(), 
						Long.parseLong(parameters.get("groupId")));
				
				LOGGER.info("::: Images are attached to product :::");
				
			}
			
			deleteTags(cpDefinition);
			addTags(cpDefinition, parameters, themeDisplay, serviceContext);
			LOGGER.info("::: Tags are attached to product :::");
			
			List<CPDefinitionOptionRel> cpDefinitionOptionRels = CPDefinitionOptionRelLocalServiceUtil.getCPDefinitionOptionRels(cpDefinition.getCPDefinitionId());
			boolean ignoreSKUCombinations = true;
			
			// Condition for the ignoreSKUCombinations parameter that variant are available or not
			if(cpDefinitionOptionRels.size() > 0) {
				ignoreSKUCombinations = false;
			}
			
			// setting availability of stock
			CPDefinitionInventory cpDefinitionInventory = CPDefinitionInventoryLocalServiceUtil
					.fetchCPDefinitionInventoryByCPDefinitionId(cpDefinition.getCPDefinitionId());
			cpDefinitionInventory.setDisplayAvailability(true);
			CPDefinitionInventoryLocalServiceUtil.updateCPDefinitionInventory(cpDefinitionInventory);
			
			// updating LR product with data
			CPDefinitionLocalServiceUtil.updateCPDefinition(product.getCpDefinitionId(), product.getProductNameMap(), 
					product.getShortDescriptionMap(), product.getLongDescriptionMap(), null, null, null, null, ignoreSKUCombinations, true, true, true, 0, 0, 0, 0, 0, 
					product.getTaxCategoryId(), false, false, null, true, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, 
					displayDateMinute, 0, 0, 0, 0, 0, true, serviceContext);
			
			LOGGER.info("::: Product Status has been changed to Approved :::");
			
			LOGGER.info("::: End of data push to LR :::");
			
		}
		
	}
	
	private boolean purchasableFlag(ProductSKU productSKU) {
		boolean purchasable = true;
		if(productSKU.getStock() == 0) {
			purchasable = false;
		}
		
		return purchasable;
	}
	
	private void addTags(CPDefinition cpDefinition, Map<String,String> parameters, ThemeDisplay themeDisplay, ServiceContext serviceContext) throws PortalException {
		LOGGER.info("draftProductId--> " + parameters.get("draftProductId"));
		try {
			List<ProductSearchKeywords> productSearchKeywords = ProductSearchKeywordsLocalServiceUtil
					.findByDraftProductId(Long.parseLong(parameters.get("draftProductId")));
			for (ProductSearchKeywords productSearchKeyword : productSearchKeywords) {
				AssetTag assetTag = AssetTagLocalServiceUtil.addTag(themeDisplay.getUserId(), Long.parseLong(parameters.get("groupId")), 
						productSearchKeyword.getSearchKeyword(), serviceContext);
				long entryId = AssetEntryLocalServiceUtil.getEntry(CPDefinition.class.getName(), cpDefinition.getCPDefinitionId()).getEntryId();
				AssetTagLocalServiceUtil.addAssetEntryAssetTag(entryId, assetTag);
				
			}
		} catch (Exception e) {
			LOGGER.error("Error while adding tags of product :: " + e.getMessage());
		}
		
	}
	
	private void deleteTags(CPDefinition cpDefinition) {
		try {
			long classNameId = ClassNameLocalServiceUtil.getClassName(cpDefinition.getModelClass().getName()).getClassNameId();
			List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(classNameId, cpDefinition.getCPDefinitionId());
			for (AssetTag assetTag : assetTags) {
				AssetTagLocalServiceUtil.deleteAssetTag(assetTag.getTagId());
			}
			
		} catch(Exception e) {
			LOGGER.error("Error while deleting tags of product :: " + e.getMessage());
		}
	}
	
	private void addInventoryWarehouse(ThemeDisplay themeDisplay, ProductSKU productSKU, CPInstance cpInstance) throws PortalException {
		CommerceInventoryWarehouse commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
				.getCommerceInventoryWarehouseByExternalReferenceCode(CommonUtil.getCustomFieldValue("Warehouse"), themeDisplay.getCompanyId());
		try {
			CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
					.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(), cpInstance.getSku());
			LOGGER.info("::: Updating old inventory to product :::");
			commerceInventoryWarehouseItem.setQuantity(BigDecimal.valueOf(productSKU.getStock()));
			CommerceInventoryWarehouseItemLocalServiceUtil.updateCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
		} catch (Exception e) {
			LOGGER.info("::: Adding inventory to product :::");
			addInventory(themeDisplay, cpInstance, productSKU.getStock(), commerceInventoryWarehouse.getCommerceInventoryWarehouseId());
		}
	}
	
	public long getCPOptionId(String cpOptionName, ThemeDisplay themeDisplay) throws PortalException {
		
		CPOption cpOption = CPOptionLocalServiceUtil.fetchCPOption(themeDisplay.getCompanyId(), getLiferaykeyFormat(cpOptionName));
		if (Validator.isNotNull(cpOption)) {
			return cpOption.getCPOptionId();
		}
		return 0;
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
	
	private void addInventory(ThemeDisplay themeDisplay, CPInstance cpInstance, long quantity, 
			long commerceInventoryWarehouseId) throws PortalException {
		CommerceInventoryWarehouseItemLocalServiceUtil.addCommerceInventoryWarehouseItem("", themeDisplay.getUserId(), 
				commerceInventoryWarehouseId, BigDecimal.valueOf(quantity), cpInstance.getSku(), null);
	}
	
	public void createPriceList(CPInstance cpInstance, long productId, ServiceContext serviceContext) {
		CommercePriceList commercePrice;
		CommercePriceList commercePromotionPrice;
		try {
			commercePrice = CommercePriceListLocalServiceUtil.getCatalogBaseCommercePriceListByType(
					cpInstance.getGroupId(), CommercePriceListConstants.TYPE_PRICE_LIST);
			CommercePriceEntryLocalServiceUtil.addCommercePriceEntry("price_"+cpInstance.getExternalReferenceCode(), productId, cpInstance.getCPInstanceUuid(), 
					commercePrice.getCommercePriceListId(), cpInstance.getPrice(), false, BigDecimal.ZERO, null, serviceContext);
			
			
			commercePromotionPrice = CommercePriceListLocalServiceUtil.getCatalogBaseCommercePriceListByType(
					cpInstance.getGroupId(), CommercePriceListConstants.TYPE_PROMOTION);
			
			CommercePriceEntryLocalServiceUtil.addCommercePriceEntry("promoprice_"+cpInstance.getExternalReferenceCode(), productId, cpInstance.getCPInstanceUuid(), 
					commercePromotionPrice.getCommercePriceListId(), cpInstance.getPromoPrice(), false, BigDecimal.ZERO, null, serviceContext);
			
		} catch (Exception e) {
			LOGGER.error("Error while creating commerce price list :: " + e.getMessage());
		}
	}
	
	private void deleteVariantValues(long cpDefinitionId) {
		try {
			List<CPDefinitionOptionRel> cpDefinitionOptionRels =  CPDefinitionOptionRelLocalServiceUtil.getCPDefinitionOptionRels(cpDefinitionId);
			for (CPDefinitionOptionRel cpDefinitionOptionRel : cpDefinitionOptionRels) {
				CPDefinitionOptionRelLocalServiceUtil.deleteCPDefinitionOptionRel(cpDefinitionOptionRel.getCPDefinitionOptionRelId());
				CPDefinitionOptionValueRelLocalServiceUtil.deleteCPDefinitionOptionValueRels(cpDefinitionOptionRel.getCPDefinitionOptionRelId());
			}
			
		} catch (Exception e) {
			LOGGER.error("Variant value not exist :: " + e.getMessage());
		}
	}
	
	private void deleteSpecifications(long cpDefinitionId) {
		try {
			LOGGER.info("cpDefinitionId--> " + cpDefinitionId);
			CPDefinitionSpecificationOptionValueLocalServiceUtil.deleteCPDefinitionSpecificationOptionValues(cpDefinitionId);
			LOGGER.info("::: Deleted Specification of product :::");
		} catch(Exception e) {
			LOGGER.error("Specification not exist :: " + e.getMessage());
		}
	}
	
	private void addVariantsValue(CPDefinition cpDefinition, long draftProductId, ThemeDisplay themeDisplay, 
			ServiceContext serviceContext) throws PortalException {
		List<ProductVariant> productVariants = ProductVariantLocalServiceUtil.findByDraftProductId(draftProductId);
		for (ProductVariant productVariant : productVariants) {
			CPOption cpOption = CPOptionLocalServiceUtil.fetchCPOption(themeDisplay.getCompanyId(), getLiferaykeyFormat(productVariant.getVariantName()));
			long cpDefinitionOptionRelId = addCPDefinitionOptionRelId(cpDefinition.getCPDefinitionId(),
					cpOption.getCPOptionId(), serviceContext);
			CPDefinitionOptionValueRelLocalServiceUtil.deleteCPDefinitionOptionValueRels(cpDefinitionOptionRelId);
			List<VariantValue> variantValues = VariantValueLocalServiceUtil.findByProductVariantId(productVariant.getProductVariantId());
			for (VariantValue variantValue : variantValues) {
				Map<Locale, String> variantValueMap = new HashMap<>();
				variantValueMap.put(themeDisplay.getLocale(), variantValue.getVariantVal());
				addCPDefinitionOptionRelValueId(cpDefinitionOptionRelId, variantValueMap, 
						getLiferaykeyFormat(variantValue.getVariantVal()), serviceContext);
			}
		}
	}
	
	public void deleteModelBasedUploadImages(CPDefinition cpDefinition) {
		try {
			long classNameId = ClassNameLocalServiceUtil.getClassName(cpDefinition.getModelClass().getName()).getClassNameId();
			List<CPAttachmentFileEntry> cpAttachmentFileEntries =  CPAttachmentFileEntryLocalServiceUtil
					.getCPAttachmentFileEntries(classNameId, cpDefinition.getCPDefinitionId(), 0, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (CPAttachmentFileEntry cpAttachmentFileEntry : cpAttachmentFileEntries) {
				CPAttachmentFileEntryLocalServiceUtil.deleteCPAttachmentFileEntry(cpAttachmentFileEntry.getCPAttachmentFileEntryId());
			}
			
//			List<CPAttachmentFileEntry> cpAttachmentFileEntries =  CPAttachmentFileEntryLocalServiceUtil.getCPAttachmentFileEntries(-1, -1);
//			for (CPAttachmentFileEntry cpAttachmentFileEntry : cpAttachmentFileEntries) {
//				if(cpAttachmentFileEntry.getClassPK() == cpDefinition.getCPDefinitionId()) {
//					CPAttachmentFileEntryLocalServiceUtil.deleteCPAttachmentFileEntry(cpAttachmentFileEntry.getCPAttachmentFileEntryId());
//				}
//			}
		} catch(Exception e) {
			LOGGER.error("Files are missing :: " + e.getMessage());
		}
	}
	
	public void modelBasedUploadImages(CPDefinition cpDefinition, ThemeDisplay themeDisplay, Product product, 
			ProductSKU productSKU, String json, long groupId) throws PortalException {
		DLFolder dLfolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Products");
		try {
			DLFolder productIdFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 
					dLfolder.getFolderId(), String.valueOf(product.getDraftProductId()));
			if(Validator.isNotNull(productIdFolder)) {
				DLFolder skuIdFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 
						productIdFolder.getFolderId(), String.valueOf(productSKU.getProductSKUId()));
				DLFolder imagesFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), skuIdFolder.getFolderId(), "Images");
				List<DLFileEntry> dlFileEntrieList = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), imagesFolder.getFolderId());
				for (DLFileEntry dlFileEntry : dlFileEntrieList) {
					String imageName = dlFileEntry.getFileName();
					if(Validator.isNotNull(cpDefinition)) {
						serviceContext.setTimeZone(TimeZone.getTimeZone("UTC"));
						double priority;
						Map<Locale, String> titleMap = new HashMap<>();
						titleMap.put(LocaleUtil.US, imageName);
						
						if(productSKU.getDefaultSku().equalsIgnoreCase("on")) {
							priority = 0.0;
						} else {
							priority = 1.0;
						}
						
						
						ClassName className = ClassNameLocalServiceUtil.getClassName(cpDefinition.getModelClass().getName());
						try {
							CPAttachmentFileEntryLocalServiceUtil.addCPAttachmentFileEntry("", themeDisplay.getUserId(), groupId, 
									className.getClassNameId(), cpDefinition.getCPDefinitionId(), dlFileEntry.getFileEntryId(), false, "", displayDateMonth, 
									displayDateDay, displayDateYear, displayDateHour, displayDateMinute, 0, 0, 0, 0, 0, true, titleMap, json, priority, 0, serviceContext);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Folder or files are missing :: " + e.getMessage());
		}
	}
	
	private void addSpecification(ThemeDisplay themeDisplay, long draftProductId, CPDefinition cpDefinition, 
			ServiceContext serviceContext) throws PortalException {
		
		List<ProductSpecification> productSpecifications = ProductSpecificationLocalServiceUtil.findByDraftProductId(draftProductId);
		for (ProductSpecification productSpecification : productSpecifications) {
			Specification specification = SpecificationLocalServiceUtil
					.getSpecification(productSpecification.getSpecificationId());
			List<ProductSpecValueMap> productSpecValueMaps = ProductSpecValueMapLocalServiceUtil
					.findByProductSpecificationId(productSpecification.getProductSpecificationId());
			for (ProductSpecValueMap productSpecValueMap : productSpecValueMaps) {
				
				Map<Locale, String> valueMap = new HashMap<>();
				valueMap.put(themeDisplay.getLocale(), productSpecValueMap.getSpecificationValueLabel());
				
				CPDefinitionSpecificationOptionValueLocalServiceUtil.addCPDefinitionSpecificationOptionValue(cpDefinition.getCPDefinitionId(), 
						specification.getCpSpecificationId(), specification.getSpecificationGroupId(), valueMap, 0.0, serviceContext);
			}
		}
	}
	
	public static String getLiferaykeyFormat(String key) {
		return key.toLowerCase().replaceAll("[^\\dA-Za-z_]", " ").replaceAll("/ +(?= )/g", " ").replaceAll("\\s+", "-");
	}
	
	public long addCPDefinitionOptionRelId(long cpDefinitionId, long cpOptionId, ServiceContext serviceContext) {
		long cpDefinitionOptionRelId = 0;
		try {
			cpDefinitionOptionRelId = CPDefinitionOptionRelLocalServiceUtil
					.addCPDefinitionOptionRel(cpDefinitionId, cpOptionId, serviceContext).getCPDefinitionOptionRelId();
		} catch (PortalException e) {
			LOGGER.error("Not able to add option to product :: " + e.getMessage());
		}
		return cpDefinitionOptionRelId;
	}
	
	public long addCPDefinitionOptionRelValueId(long cpDefinitionCityOptionRelId, Map<Locale, String> nameMap,
			String key, ServiceContext serviceContext) {
		long cpDefinitionOptionValueRelId = 0;
		try {
			cpDefinitionOptionValueRelId = CPDefinitionOptionValueRelLocalServiceUtil.addCPDefinitionOptionValueRel(cpDefinitionCityOptionRelId, key, 
					nameMap, 0.0, serviceContext).getCPDefinitionOptionValueRelId();
		} catch (PortalException e) {
			LOGGER.error("Not able to add option values to product :: " + e.getMessage());
		}
		return cpDefinitionOptionValueRelId;
	}

	@Reference
	private ProductViewHelper productViewHelper;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(AdditionalInformationAction.class);
	
}
