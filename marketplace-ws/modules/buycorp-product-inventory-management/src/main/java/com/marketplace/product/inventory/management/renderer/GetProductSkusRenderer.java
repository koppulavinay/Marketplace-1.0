package com.marketplace.product.inventory.management.renderer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.inventory.management.display.context.DashboardManagementToolbarDisplayContext;
import com.marketplace.product.inventory.management.display.context.DashboardManagementToolbarProductSkuDisplayContext;
import com.marketplace.product.inventory.management.helper.ProductSkuListingHelper;
import com.marketplace.product.inventory.management.model.ProductSkuModel;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BuycorpProductInventoryManagementPortletKeys.BUYCORPPRODUCTINVENTORYMANAGEMENT,
		"mvc.command.name=productSkus", }, service = MVCRenderCommand.class)

public class GetProductSkusRenderer implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(GetProductSkusRenderer.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside GetProductSkusRenderer Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		String search = ParamUtil.get(renderRequest, "keywords","");
		int from = delta * (cur-1);
		int to = delta==0 ? 10 : delta*cur;
		long draftProductId=0;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(PortalUtil.getOriginalServletRequest(request).getParameter("draftProductId") != null) {
		draftProductId = Long.valueOf(PortalUtil.getOriginalServletRequest(request).getParameter("draftProductId"));
		}else {
			draftProductId = ParamUtil.getLong(renderRequest, "draftProductId");
		}
		List<ProductSkuModel> allProduct = productSkuListingHelper.getAllProductsSku(themeDisplay, draftProductId,search);
		List<ProductSkuModel> products = productSkuListingHelper.getAllProductsSku(themeDisplay, draftProductId,from,to,search);
		
		renderRequest.setAttribute("from", from);
		renderRequest.setAttribute("to", to);
		
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("draftProductId", String.valueOf(draftProductId));
		renderRequest.setAttribute("products", products);
		renderRequest.setAttribute("productCount", allProduct.size());
		
		addManagementToolbarAttributes(renderRequest, renderResponse);
		return "/product_skus.jsp";
	}
	
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(renderRequest);
		DashboardManagementToolbarProductSkuDisplayContext dashboardManagementToolbarProductSkuDisplayContext = new DashboardManagementToolbarProductSkuDisplayContext(
				liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		renderRequest.setAttribute("dashboardManagementToolbarProductSkuDisplayContext",
				dashboardManagementToolbarProductSkuDisplayContext);
	}
	
	

	@Reference
	private Portal portal;
	
	
	@Reference
	private ProductSkuListingHelper productSkuListingHelper;

}
