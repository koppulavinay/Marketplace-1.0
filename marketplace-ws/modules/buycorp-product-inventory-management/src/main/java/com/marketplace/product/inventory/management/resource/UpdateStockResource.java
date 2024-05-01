package com.marketplace.product.inventory.management.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;

import java.math.BigDecimal;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BuycorpProductInventoryManagementPortletKeys.BUYCORPPRODUCTINVENTORYMANAGEMENT, 
		"mvc.command.name=updateStock", }, service = MVCResourceCommand.class)

public class UpdateStockResource extends BaseMVCResourceCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateStockResource.class.getName());
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateStockResource Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long productSkuId = ParamUtil.getLong(resourceRequest, "productSkuId");
		long stock = ParamUtil.getLong(resourceRequest, "stock");
		
		ProductSKU productSKU = productSKULocalService.getProductSKU(productSkuId);
		productSKU.setStock(stock);
		productSKULocalService.updateProductSKU(productSKU);
		
		CommerceInventoryWarehouse commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
				.getCommerceInventoryWarehouseByExternalReferenceCode(CommonUtil.getCustomFieldValue("Warehouse"), themeDisplay.getCompanyId());
		try {
			CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
					.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(), 
							productSKU.getSkuId() + "(" + productSKU.getSkuCreationName() + ")");
			LOGGER.info("::: Updating old inventory to product :::");
			commerceInventoryWarehouseItem.setQuantity(BigDecimal.valueOf(productSKU.getStock()));
			CommerceInventoryWarehouseItemLocalServiceUtil.updateCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
		} catch (Exception e) {
			LOGGER.error("Not able to update the stock as sku is not available :: " + e.getMessage());
		}
		
		resourceResponse.getWriter().print("true");
		
	}
	
	@Reference
	private ProductSKULocalService productSKULocalService;

}
