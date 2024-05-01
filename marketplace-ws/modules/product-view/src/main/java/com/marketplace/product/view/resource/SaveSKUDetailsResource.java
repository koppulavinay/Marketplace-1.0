package com.marketplace.product.view.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author sobhit.kumar
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, 
		"mvc.command.name=" + ProductViewPortletKeys.SAVE_SKU_DETAILS_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class SaveSKUDetailsResource implements MVCResourceCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SaveSKUDetailsResource.class.getName());
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("------------- Inside Save SKU Resource -------------");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long sellerId=themeDisplay.getUserId();
		JSONObject dataJson=CommonUtil.getJsonFromRequestBody(resourceRequest);
		LOGGER.info("getProductSkuId(dataJson):--"+Long.parseLong(getProductSkuId(dataJson)));
		  try { 
			  
			  System.out.println("getDefaultSku(dataJson)-->"+getDefaultSku(dataJson));
			  if(getDefaultSku(dataJson).equals("on")) {
			  List<ProductSKU>  productSKULst= productSKULocalService.findByDraftProductSkuId(Long.parseLong(getDraftProductId(dataJson)));
			  for (ProductSKU productSKU : productSKULst) {
				  ProductSKU productSKUUpdate =productSKULocalService.getProductSKU(productSKU.getProductSKUId());
				  productSKUUpdate.setDefaultSku(null);
				  productSKULocalService.updateProductSKU(productSKUUpdate);
			    }
			  } 
			  ProductSKU productSKU =productSKULocalService.getProductSKU(Long.parseLong(getProductSkuId(dataJson)));
  			  productSKU = convertJsonToEntity(dataJson,productSKU,sellerId);
  			  //convertJsonToArrayEntity(dataJson,productMediaSKULocalService,productSKU,counterLocalService);
			  productSKULocalService.updateProductSKU(productSKU);
			  JSONObject flagData = JSONFactoryUtil.createJSONObject();
			  flagData.put("isDataSaved", Boolean.TRUE);
			  CommonUtil.getPrintWriter(resourceResponse).write(flagData.toString());
		  } catch (PortalException e) { 
			  e.printStackTrace();
		 }
		return false;
	}
	
	
	private static  ProductSKU convertJsonToEntity(JSONObject dataJson,ProductSKU ProductSKU ,Long sellerId) {
		JSONObject skudetails = dataJson.getJSONObject("skuDetails");
		ProductSKU.setDraftProductId(Long.parseLong(skudetails.getString("draftProductId")));
		ProductSKU.setProductSKUId(Long.parseLong(skudetails.getString("productskuId")));
		ProductSKU.setSkuId(sellerId+"/"+Long.parseLong(skudetails.getString("productskuId"))+"/"+Long.parseLong(skudetails.getString("draftProductId")));
		ProductSKU.setSellerSkuId(skudetails.getString("sellerskuid"));
		ProductSKU.setDefaultSku(skudetails.getString("defaultsku"));
		ProductSKU.setBasePrice(new BigDecimal(skudetails.getString("baseprice")));
		ProductSKU.setOfferPrice(new BigDecimal(skudetails.getString("offerprice")));
		ProductSKU.setCost(new BigDecimal(skudetails.getString("cost")));
		ProductSKU.setMargin(new BigDecimal(skudetails.getString("margin")));
		ProductSKU.setStock(Long.parseLong(skudetails.getString("availablestock")));
		ProductSKU.setUom(skudetails.getString("uom"));
		ProductSKU.setMinimumOrderQuantity(Long.parseLong(skudetails.getString("minumiumqty")));
		ProductSKU.setMaximumOrderQuantity(Long.parseLong(skudetails.getString("maximumqty")));
		ProductSKU.setLowStockThreshold(Long.parseLong(skudetails.getString("lowstockthreshold")));
		ProductSKU.setTax(skudetails.getString("tax"));
		ProductSKU.setSkuPublishingDate(getDateFromString(skudetails.getString("skupublishingdate")) );
		ProductSKU.setSkuExpiryDate(getDateFromString(skudetails.getString("skuexpirydate")));
		
		
		return ProductSKU;
	}
	

	
	
	private static String  getProductSkuId(JSONObject dataJson)  {
		JSONObject skudetails = dataJson.getJSONObject("skuDetails");
		return skudetails.getString("productskuId");
	}
	
	private static String  getDefaultSku(JSONObject dataJson)  {
		JSONObject skudetails = dataJson.getJSONObject("skuDetails");
		return skudetails.getString("defaultsku");
	}
	
	private static String  getDraftProductId(JSONObject dataJson)  {
		JSONObject skudetails = dataJson.getJSONObject("skuDetails");
		return skudetails.getString("draftProductId");
	}
	
	
	
	
	public static Date getDateFromString(String strDate) {
		Date lDate = null;
		
		if (strDate != null) {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				lDate = simpleDateFormat.parse(strDate);
			} catch (ParseException e) {

			}
		
			return lDate;
		} else {
			return null;
		}

	}
	
	
  
 
	
	@Reference
	ProductSKULocalService productSKULocalService;
	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;
	
	/*
	 * @Reference private SKUMediaHandler sKUMediaHandler;
	 */
	
	
	public static String getBase64(String base64Image) {
 	    String base64[]=base64Image.split(",");
		
		return base64[1].toString();
	
	}

}
