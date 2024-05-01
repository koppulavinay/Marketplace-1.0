package com.marketplace.product.inventory.api.custom.internal.resource.v1_0;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalServiceUtil;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.CommerceOrderItemLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.product.inventory.api.custom.dto.v1_0.InventoryUpdateObject;
import com.marketplace.product.inventory.api.custom.resource.v1_0.InventoryResource;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author ashishinani
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/inventory.properties", scope = ServiceScope.PROTOTYPE, service = InventoryResource.class)
public class InventoryResourceImpl extends BaseInventoryResourceImpl {

	private static final Log LOGGER = LogFactoryUtil.getLog(InventoryResourceImpl.class.getName());

	@Override
	public Response updateInventory(InventoryUpdateObject inventoryUpdateObject) throws Exception {
		// TODO Auto-generated method stub
		try {
			long commerceOrderId = inventoryUpdateObject.getCommerceOrderId();
			List<CommerceOrderItem> commerceOrderItems = commerceOrderItemLocalService
					.getCommerceOrderItems(commerceOrderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			LOGGER.info("Count of items in an order :: " + commerceOrderItems.size());
			if (Validator.isNull(commerceOrderItems) || commerceOrderItems.isEmpty()) {

				return Response.status(Status.OK).entity(JSONFactoryUtil.createJSONObject().
						put("message", "No record exists with the commerceOrderId : " + commerceOrderId).
						toJSONString()).type(MediaType.APPLICATION_JSON).build();
			}

			for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {
				CommerceInventoryWarehouse commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
						.getCommerceInventoryWarehouseByExternalReferenceCode(
								CommonUtil.getCustomFieldValue("Warehouse"), contextCompany.getCompanyId());

				CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
						.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(),
								commerceOrderItem.getSku());
				ProductSKU productSKU = productSKULocalService.findBySkuId(commerceOrderItem.getSku().split("\\(")[0]);
				LOGGER.info("::: Updating old inventory to product :::");
				BigDecimal quantity = commerceInventoryWarehouseItem.getQuantity().setScale(0)
						.subtract(commerceOrderItem.getQuantity().setScale(0));
				LOGGER.info("::: Updated Quantity ::: " + quantity);
				commerceInventoryWarehouseItem.setQuantity(quantity.setScale(0));
				CommerceInventoryWarehouseItemLocalServiceUtil.updateCommerceInventoryWarehouseItem(
						commerceInventoryWarehouseItem);
				LOGGER.info("::: Quantity Updated in LR Inventory :::");
				
				if(Validator.isNotNull(productSKU)) {
					productSKU.setStock(Long.parseLong(quantity.setScale(0).toString()));
					productSKULocalService.updateProductSKU(productSKU);
					LOGGER.info("::: Quantity Updated in Custom Inventory :::");
				}

			}

			return Response.status(Status.OK).entity(JSONFactoryUtil.createJSONObject().
					put("message", "Inventory updated successfully").toJSONString()).
					type(MediaType.APPLICATION_JSON).build();

		} catch (Exception e) {
			LOGGER.error("Not able to update the stock as sku is not available :: " + e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(JSONFactoryUtil.createJSONObject().
					put("message", e.getMessage()).toJSONString()).type(MediaType.APPLICATION_JSON).build();
		}
	}

	@Reference
	private CommerceOrderItemLocalService commerceOrderItemLocalService;
	
	@Reference
	private ProductSKULocalService productSKULocalService;

}
