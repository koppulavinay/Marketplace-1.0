package com.marketplace.product.inventory.management.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.inventory.management.helper.ProductListingHelper;
import com.marketplace.product.inventory.management.model.ProductModel;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {		"javax.portlet.name=" + BuycorpProductInventoryManagementPortletKeys.BUYCORPPRODUCTINVENTORYMANAGEMENT,
		"mvc.command.name=inventoryFetch", }, service = MVCResourceCommand.class)

public class InventoryFetchResourceCommand extends BaseMVCResourceCommand {

	private static final Log logger = LogFactoryUtil.getLog(InventoryFetchResourceCommand.class);

	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		int pageNumber; 
		int end;
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject tableData = JSONFactoryUtil.createJSONObject();
		int start = Integer.parseInt(httpReq.getParameter("start"));
		int length = Integer.parseInt(httpReq.getParameter("length"));
		
		logger.info("start " + start);
		logger.info("length " + length);

		if (start == 0) {
			pageNumber = 1;
		} else {
			pageNumber = (start / length) + 1;
		}
		logger.info("Page Number is:" + pageNumber);
		end = pageNumber * length;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ProductModel> resourcesArray= productListingHelper.getAllProducts(themeDisplay, start, end,"");
		System.out.println(" resource Array " + resourcesArray);
		System.out.println();
		System.out.println();
		
		JSONArray superAdminDetailsArray = JSONFactoryUtil.createJSONArray();
		for (ProductModel product : resourcesArray) {
			JSONObject superAdminList = JSONFactoryUtil.createJSONObject();
			superAdminList.put("Product ID", product.getProductId());
			 superAdminList.put("Product Name",product.getProductName());
		      superAdminList.put("Product Type",product.getProductType());
		      superAdminList.put("Category" ,product.getCategoryName());
			superAdminList.put("Brand",product.getBrandName());
			superAdminList.put("Status" ,product.getStatus());
			superAdminList.put("Created Date",product.getCreateDate());
			superAdminList.put("Action", "Action");
			superAdminDetailsArray.put(superAdminList);
		}
		 resourceResponse.setContentType("application/json");
		try {
			tableData.put("data", superAdminDetailsArray);
			logger.info("tableData:" + tableData.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse), tableData.toString());
		} catch (IOException e) {
			logger.error("Error " + e);
		}
	}
	
	@Reference
	private ProductListingHelper productListingHelper;

}
