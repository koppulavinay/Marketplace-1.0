package com.marketplace.product.inventory.management.helper;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.inventory.management.model.ProductSkuModel;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ProductSkuListingHelper.class)

public class ProductSkuListingHelper {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ProductSkuListingHelper.class);
	
	public List<ProductSkuModel> getAllProductsSku(ThemeDisplay themeDisplay, long draftProductId,String search) {
		
		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside getAllProductsSku Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		
	List<ProductSKU> productSKUs = new ArrayList<>();
		
		if(Validator.isNotNull(search)) {
			//
			Order order = OrderFactoryUtil.desc("modifiedDate");
			DynamicQuery dynamicQuery = productSKULocalService.dynamicQuery();
			dynamicQuery.addOrder(order);
			
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
				Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("LOWER (skuName) LIKE ?", "%" + search.toLowerCase() + "%", Type.STRING);
				disjunction.add(criterion);
				dynamicQuery.add(disjunction);
				productSKUs= productSKULocalService.dynamicQuery(dynamicQuery);
				System.out.println(productSKUs);
		}else {
			productSKUs = productSKULocalService.findByDraftProductSkuId(draftProductId);
		}
		List<ProductSkuModel> productSkuModelList = new ArrayList<>();
		
		productSKUs.stream().forEach(productSKU -> {
			
			ProductSkuModel productSkuModel = new ProductSkuModel();
			productSkuModel.setProductSkuId(productSKU.getProductSKUId());
			
			CommerceInventoryWarehouse commerceInventoryWarehouse;
			try {
				commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
						.getCommerceInventoryWarehouseByExternalReferenceCode(CommonUtil.getCustomFieldValue("Warehouse"), themeDisplay.getCompanyId());
				CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
						.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(), 
								productSKU.getSkuId() + "(" + productSKU.getSkuCreationName() + ")");
				LOGGER.info("commerceInventoryWarehouseItem.getQuantity()--> " + commerceInventoryWarehouseItem.getQuantity().setScale(0));
				productSkuModel.setStock(Long.parseLong(commerceInventoryWarehouseItem.getQuantity().setScale(0).toString()));
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				LOGGER.error("No SKU available regarding that stock :: " + e.getMessage());
			}
			
			productSkuModelList.add(productSkuModel);
			
		});
		
		return productSkuModelList;
	}
	
	
public List<ProductSkuModel> getAllProductsSku(ThemeDisplay themeDisplay, long draftProductId,int start , int end,String search) {
		
		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside getAllProductsSku Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		List<ProductSKU> productSKUs = new ArrayList<>();
		
		if(Validator.isNotNull(search)) {
			//
			Order order = OrderFactoryUtil.desc("modifiedDate");
			DynamicQuery dynamicQuery = productSKULocalService.dynamicQuery();
			dynamicQuery.addOrder(order);
			
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
				Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("LOWER (skuName) LIKE ?", "%" + search.toLowerCase() + "%", Type.STRING);
				disjunction.add(criterion);
				dynamicQuery.add(disjunction);
				productSKUs= productSKULocalService.dynamicQuery(dynamicQuery,start,end);
				System.out.println(productSKUs);
		}else {
			productSKUs = productSKULocalService.findByDraftProductSkuId(draftProductId, start, end);
		}
		List<ProductSkuModel> productSkuModelList = new ArrayList<>();
		
		productSKUs.stream().forEach(productSKU -> {
			
			ProductSkuModel productSkuModel = new ProductSkuModel();
			productSkuModel.setProductSkuId(productSKU.getProductSKUId());
			
			CommerceInventoryWarehouse commerceInventoryWarehouse;
			try {
				commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
						.getCommerceInventoryWarehouseByExternalReferenceCode(CommonUtil.getCustomFieldValue("Warehouse"), themeDisplay.getCompanyId());
				CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
						.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(), 
								productSKU.getSkuId() + "(" + productSKU.getSkuCreationName() + ")");
				LOGGER.info("commerceInventoryWarehouseItem.getQuantity()--> " + commerceInventoryWarehouseItem.getQuantity().setScale(0));
				productSkuModel.setStock(Long.parseLong(commerceInventoryWarehouseItem.getQuantity().setScale(0).toString()));
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				LOGGER.error("No SKU available regarding that stock :: " + e.getMessage());
			}
			
			productSkuModelList.add(productSkuModel);
			
		});
		
		return productSkuModelList;
	}
	
	
	
	
	
	
	
	@Reference
	private ProductSKULocalService productSKULocalService;

}
