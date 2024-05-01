package com.marketplace.product.view.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.handler.SKUMediaHandler;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.SKU_MEDIA_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class SKUMediaResource implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		System.out.println("---------------- SKU Media Resource -------------");
		try {
			JSONObject responseMediaImageJson =skuMediaHandler.uploadFilesToProductsDMS(resourceRequest);
			responseMediaImageJson.put("isDataSaved", Boolean.TRUE);
			saveMediaImages(responseMediaImageJson,productMediaSKULocalService,counterLocalService);
            CommonUtil.getPrintWriter(resourceResponse).write(responseMediaImageJson.toString());
			System.out.println("======>"+responseMediaImageJson);
			//skuMediaHandler.uploadFilesToProductsDMS(resourceRequest);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	private static  void saveMediaImages(JSONObject dataJson,ProductMediaSKULocalService productMediaSKULocalService,CounterLocalService counterLocalService ) {
		JSONArray ja_data = dataJson.getJSONArray("documents");
		int length = ja_data.length(); 
		for(int i=0; i<length; i++) 
		{
			
		    JSONObject jObj = ja_data.getJSONObject(i);
		    ProductMediaSKU productMediaSKU = productMediaSKULocalService.createProductMediaSKU(counterLocalService.increment());
		    productMediaSKU.setImageUrl(jObj.getString("documentURL"));
		    productMediaSKU.setFileEntryId(Long.parseLong(jObj.getString("documentId")));
		    productMediaSKU.setProductSKUId(Long.parseLong(dataJson.getString("skuId")));
		    productMediaSKU.setDraftProductId(Long.parseLong(dataJson.getString("draftProductId")));
		    productMediaSKULocalService.addProductMediaSKU(productMediaSKU);
		} 
		
	}
	
	
	@Reference
	private SKUMediaHandler skuMediaHandler;
	
	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;

}
