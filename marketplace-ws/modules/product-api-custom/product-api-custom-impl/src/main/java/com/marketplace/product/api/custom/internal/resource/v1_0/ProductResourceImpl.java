package com.marketplace.product.api.custom.internal.resource.v1_0;

import com.buycorp.common.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.product.api.custom.dto.v1_0.ProductIdObject;
import com.marketplace.product.api.custom.dto.v1_0.ProductListObject;
import com.marketplace.product.api.custom.dto.v1_0.ProductReferenceObject;
import com.marketplace.product.api.custom.dto.v1_0.SkuObject;
import com.marketplace.product.api.custom.dto.v1_0.SpecificationObject;
import com.marketplace.product.api.custom.dto.v1_0.StockUpdateObject;
import com.marketplace.product.api.custom.resource.v1_0.ProductResource;
import com.marketplace.product.helper.ProductHelper;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;

import java.math.BigDecimal;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author ashishinani
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/product.properties", scope = ServiceScope.PROTOTYPE, service = ProductResource.class)
public class ProductResourceImpl extends BaseProductResourceImpl {

	private static final Log LOGGER = LogFactoryUtil.getLog(ProductResourceImpl.class.getName());

	@Override
	public Response updateStock(StockUpdateObject stockUpdateObject) throws Exception {
		// TODO Auto-generated method stub
		try {
			String skuId = stockUpdateObject.getSkuId();
			long stock = stockUpdateObject.getStock();

			if (skuId.equalsIgnoreCase("") || Validator.isNull(skuId)) {
				LOGGER.info("::: skuId cannot be null or empty :::");
				return Response
						.status(Status.OK).entity(JSONFactoryUtil.createJSONObject()
								.put("message", "skuId cannot be null or empty").toJSONString())
						.type(MediaType.APPLICATION_JSON).build();
			}

			if (stock < 0) {
				LOGGER.info("::: Stock cannot be less than 0 :::");
				return Response.status(Status.OK)
						.entity(JSONFactoryUtil.createJSONObject()
								.put("message", "Stock cannot be less than 0 : " + stock).toJSONString())
						.type(MediaType.APPLICATION_JSON).build();
			}

			ProductSKU productSKU = productSKULocalService.findBySkuId(skuId);

			if (Validator.isNull(productSKU)) {
				LOGGER.info("::: No record exists with the skuId ::: " + skuId);
				return Response.status(Status.OK)
						.entity(JSONFactoryUtil.createJSONObject()
								.put("message", "No record exists with the skuId : " + skuId).toJSONString())
						.type(MediaType.APPLICATION_JSON).build();
			}

			CommerceInventoryWarehouse commerceInventoryWarehouse = CommerceInventoryWarehouseLocalServiceUtil
					.getCommerceInventoryWarehouseByExternalReferenceCode(CommonUtil.getCustomFieldValue("Warehouse"),
							contextCompany.getCompanyId());
			CommerceInventoryWarehouseItem commerceInventoryWarehouseItem = CommerceInventoryWarehouseItemLocalServiceUtil
					.getCommerceInventoryWarehouseItem(commerceInventoryWarehouse.getCommerceInventoryWarehouseId(),
							productSKU.getSkuId() + "(" + productSKU.getSkuCreationName() + ")");
			LOGGER.info("::: Updating old inventory to product :::");
			commerceInventoryWarehouseItem.setQuantity(BigDecimal.valueOf(stock));
			CommerceInventoryWarehouseItemLocalServiceUtil
					.updateCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
			LOGGER.info("::: Updated in LR Inventory :::");

			productSKU.setStock(stock);
			productSKULocalService.updateProductSKU(productSKU);
			LOGGER.info("::: Updated in Custom Inventory :::");

			return Response
					.status(Status.OK).entity(JSONFactoryUtil.createJSONObject()
							.put("message", "Stock updated successfully").toJSONString())
					.type(MediaType.APPLICATION_JSON).build();

		} catch (Exception e) {
			LOGGER.error("Not able to update the stock as skuId is not available :: " + e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(JSONFactoryUtil.createJSONObject().put("message", e.getMessage()).toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	public Response fetchProductList(ProductIdObject productIdObject) throws Exception {
		// fetchProductList
		String vendorId = productIdObject.getVendorId();
		long categoryId = productIdObject.getCategoryId();
		String organizationId = productIdObject.getOrganizationId();

		int pageNumber = productIdObject.getPage();
		int pageSize = productIdObject.getPageSize();
		int start = (pageNumber - 1) * pageSize;
		int end = (pageNumber * pageSize);
		if (start < 0) {
			start = 0;
		}

		if (pageNumber <= 0) {
			start = 0;
			if (pageSize > 0) {
				end = pageSize;
			}
		}

		if (pageSize <= 0) {
			end = 10;
		}

		if (Validator.isNull(vendorId) || vendorId == "" || vendorId.equalsIgnoreCase("string")) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "vendorId cannot be null or empty").put("error_code", "7051")
							.toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		if (Validator.isNull(categoryId) || categoryId <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "categoryId cannot be null or empty").put("error_code", "7052")
							.toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		if (Validator.isNull(organizationId) || organizationId == "" || organizationId.equalsIgnoreCase("string")) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "organizationId cannot be null or empty").put("error_code", "7053")
							.toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		if (end == 0) {
			end = 10;
		}

		ProductListObject productListObject = productHelper.getProducts(vendorId, categoryId, organizationId, start,
				end);

		LOGGER.info("::: productListObject ::: " + productListObject.getProducts().length);

		if (productListObject.getProducts().length <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "No Products Available").put("error_code", "7054").toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(productListObject.toString());
		jsonObject.put("success", "true");
		jsonObject.put("message", "");
		jsonObject.put("error_code", "");
		return Response.status(Status.OK).entity(jsonObject).type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response fetchSpecificationList(ProductReferenceObject productReferenceObject) throws Exception {
		// fetch specification
		long draftProductId = productReferenceObject.getProductReferenceId();
		int pageNumber = productReferenceObject.getPage();
		int pageSize = productReferenceObject.getPageSize();
		int start = (pageNumber - 1) * pageSize;
		int end = (pageNumber * pageSize);
		if (start < 0) {
			start = 0;
		}

		if (pageNumber <= 0) {
			start = 0;
			if (pageSize > 0) {
				end = pageSize;
			}
		}

		if (pageSize <= 0) {
			end = 10;
		}

		// checking validation
		if (draftProductId <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "ProductReferenceId cannot be null or empty").put("error_code", "7055")
							.toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		LOGGER.info("::: draftProductId ::: " + draftProductId);

		SpecificationObject specificationObject = productHelper.getSpecifications(draftProductId, start, end);

		LOGGER.info("::: productListObject ::: " + specificationObject.getSpecification().length);

		if (specificationObject.getSpecification().length <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "No Specification Available").put("error_code", "7056").toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(specificationObject.toString());
		jsonObject.put("success", "true");
		jsonObject.put("message", "");
		jsonObject.put("error_code", "");
		return Response.status(Status.OK).entity(jsonObject).type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response fetchSkuList(ProductReferenceObject productReferenceObject) throws Exception {
		// fetchSkuList
		long draftProductId = productReferenceObject.getProductReferenceId();
		int pageNumber = productReferenceObject.getPage();
		int pageSize = productReferenceObject.getPageSize();
		int start = (pageNumber - 1) * pageSize;
		int end = (pageNumber * pageSize);
		if (start < 0) {
			start = 0;
		}

		if (pageNumber <= 0) {
			start = 0;
			if (pageSize > 0) {
				end = pageSize;
			}
		}

		if (pageSize <= 0) {
			end = 10;
		}

		if (draftProductId <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "ProductReferenceId cannot be null or empty").put("error_code", "7055")
							.toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		SkuObject skuObject = null;
		skuObject = productHelper.getSkuObjects(draftProductId, start, end);

		if (skuObject.getSkus().length <= 0) {
			return Response.status(Status.OK)
					.entity(JSONFactoryUtil.createJSONObject().put("success", "false")
							.put("message", "No Skus Available").put("error_code", "7057").toJSONString())
					.type(MediaType.APPLICATION_JSON).build();
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(skuObject.toString());
		jsonObject.put("success", "true");
		jsonObject.put("message", "");
		jsonObject.put("error_code", "");
		return Response.status(Status.OK).entity(jsonObject).type(MediaType.APPLICATION_JSON).build();
	}

	@Reference
	private ProductHelper productHelper;

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private ProductSKULocalService productSKULocalService;
}
