package com.marketplace.custom.checkout.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.custom.checkout.constants.CheckoutConsigneeDetailsConstants;
import com.marketplace.custom.checkout.helper.CheckoutConsigneeStepHelper;
import com.marketplace.custom.checkout.model.CommerceOrderItemModel;
import com.marketplace.custom.checkout.util.CheckoutConsigneeStepUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + CommercePortletKeys.COMMERCE_CHECKOUT,
		"mvc.command.name="
				+ CheckoutConsigneeDetailsConstants.SUBMIT_CONSIGNEE_DETAILS_MVC_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class SubmitConsigneeDetailsResourceCmd implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		LOGGER.info("--------------- Inside Submit Consignee Details -----------------");

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession httpSession = httpServletRequest.getSession();

		CommerceContext commerceContext = (CommerceContext) httpServletRequest
				.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
		CommerceOrder commerceOrder = CheckoutConsigneeStepUtil.getCommerceOrder(commerceContext);

		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<CommerceOrderItemModel>  commerceOrderItems = checkoutConsigneeStepHelper.getCommerceOrderItemsWithConsignees(commerceContext, commerceOrder, themeDisplay);

		httpSession.setAttribute("commerceOrderItems", commerceOrderItems);

		checkoutConsigneeStepHelper.renderOrderTotal(httpSession, resourceRequest, commerceOrder, "redirect-to-order-summary");

		CommonUtil.getPrintWriter(resourceResponse).write("redirect-to-order-summary");

		return false;
	}

	@Reference
	private CheckoutConsigneeStepHelper checkoutConsigneeStepHelper;

	private static final Log LOGGER = LogFactoryUtil.getLog(SubmitConsigneeDetailsResourceCmd.class);

}
