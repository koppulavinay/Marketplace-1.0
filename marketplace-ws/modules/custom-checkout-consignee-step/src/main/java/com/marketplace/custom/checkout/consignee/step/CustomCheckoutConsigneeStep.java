package com.marketplace.custom.checkout.consignee.step;

import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.util.BaseCommerceCheckoutStep;
import com.liferay.commerce.util.CommerceCheckoutStep;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.custom.checkout.helper.CheckoutConsigneeStepHelper;
import com.marketplace.custom.checkout.model.CommerceOrderItemModel;
import com.marketplace.custom.checkout.util.CheckoutConsigneeStepUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "commerce.checkout.step.name=checkout-consignee-step",
		"commerce.checkout.step.order:Integer=" + (Integer.MAX_VALUE - 160) }, service = CommerceCheckoutStep.class)
public class CustomCheckoutConsigneeStep extends BaseCommerceCheckoutStep {

	@Override
	public String getName() {
		return "checkout-consignee-step";
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Add business logic if required
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		HttpSession httpSession = httpServletRequest.getSession();

		PortletRequest portletRequest = (PortletRequest) httpServletRequest.getAttribute("javax.portlet.request");

		PortletSession portletSession = portletRequest.getPortletSession();

		CommerceContext commerceContext = (CommerceContext) httpServletRequest
				.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
		CommerceOrder commerceOrder = CheckoutConsigneeStepUtil.getCommerceOrder(commerceContext);

		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<CommerceOrderItemModel> commerceOrderItems = checkoutConsigneeStepHelper
				.getCommerceOrderItems(commerceContext, commerceOrder, themeDisplay);

		checkoutConsigneeStepHelper.constructConsigneeDetails(httpServletRequest, portletSession, portletRequest);
		checkoutConsigneeStepHelper.renderOrderTotal(httpSession, portletRequest, commerceOrder,
				"checkout-consignee-step");

		httpServletRequest.setAttribute("commerceContext", commerceContext);
		httpServletRequest.setAttribute("commerceOrder", commerceOrder);
		httpServletRequest.setAttribute("commerceOrderItems", commerceOrderItems);

		_jspRenderer.renderJSP(_servletContext, httpServletRequest, httpServletResponse, "/view.jsp");

	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(target = "(osgi.web.symbolicname=com.marketplace.custom.checkout.consignee.step)")
	private ServletContext _servletContext;

	@Reference
	private CheckoutConsigneeStepHelper checkoutConsigneeStepHelper;

}
