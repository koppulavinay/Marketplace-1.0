package com.marketplace.product.inventory.management.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.inventory.management.display.context.DashboardManagementToolbarDisplayContext;
import com.marketplace.product.inventory.management.helper.ProductListingHelper;
import com.marketplace.product.inventory.management.model.ProductModel;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.marketplace.product.master.model.Product;

/**
 * @author ashishinani
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.init-param.copy-request-parameters=false",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BuycorpProductInventoryManagement",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BuycorpProductInventoryManagementPortletKeys.BUYCORPPRODUCTINVENTORYMANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BuycorpProductInventoryManagementPortlet extends MVCPortlet {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(BuycorpProductInventoryManagementPortletKeys.class.getName());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside BuycorpProductInventoryManagementPortlet Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		String search = ParamUtil.get(renderRequest, "keywords","");
		int from = delta * (cur-1);
		int to = delta==0 ? 10 : delta*cur;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LOGGER.info("search ::::::: " + search);
			List<ProductModel> products = productListingHelper.getAllProducts(themeDisplay,from,to,search);
			LOGGER.info("search ::::::: " + products);
		List<Product> allProoduct = productListingHelper.fetchAllProductWithSearch(themeDisplay, search);
		
		renderRequest.setAttribute("from", from);
		renderRequest.setAttribute("to", to);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("products", products);
		renderRequest.setAttribute("productCount", allProoduct.size());
		addManagementToolbarAttributes(renderRequest, renderResponse);
		super.render(renderRequest, renderResponse);
	}
	
	
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(renderRequest);
		DashboardManagementToolbarDisplayContext dashboardManagementToolbarDisplayContext = new DashboardManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		renderRequest.setAttribute("dashboardManagementToolbarDisplayContext",
				dashboardManagementToolbarDisplayContext);
	}
	
	@Reference
	private Portal portal;
	
	
	@Reference
	private ProductListingHelper productListingHelper;
}
