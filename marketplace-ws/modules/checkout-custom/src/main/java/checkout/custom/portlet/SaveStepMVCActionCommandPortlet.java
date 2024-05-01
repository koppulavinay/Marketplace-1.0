/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package checkout.custom.portlet;

import checkout.custom.bid.api.BidApi;
import checkout.custom.constants.CheckoutCustomPortletKeys;
import checkout.custom.model.BIDResponse;
import checkout.custom.model.OMSCreateDraftOrderResponse;
import checkout.custom.oms.api.OmsAPI;
import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItemModel;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.util.CommerceCheckoutStep;
import com.liferay.commerce.util.CommerceCheckoutStepRegistry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Marco Leo
 */
@Component(property = { "javax.portlet.name=" + CommercePortletKeys.COMMERCE_CHECKOUT,
		"mvc.command.name=/commerce_checkout/save_step",
		"service.ranking:Integer=100" }, service = MVCActionCommand.class)
public class SaveStepMVCActionCommandPortlet extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SaveStepMVCActionCommandPortlet.class);

	public String getRedirect(ActionRequest actionRequest, ActionResponse actionResponse, String checkoutStepName)
			throws Exception {
		String redirect = GetterUtil.getString(actionRequest.getAttribute(WebKeys.REDIRECT));

		if (Validator.isNotNull(redirect)) {
			return redirect;
		}

		if (!SessionErrors.isEmpty(actionRequest)) {
			return _getPortletURL(actionRequest, actionResponse, checkoutStepName);
		}

		CommerceCheckoutStep commerceCheckoutStep = _commerceCheckoutStepRegistry.getNextCommerceCheckoutStep(
				checkoutStepName, _portal.getHttpServletRequest(actionRequest),
				_portal.getHttpServletResponse(actionResponse));

		if (commerceCheckoutStep == null) {
			return ParamUtil.getString(actionRequest, "redirect");
		}

		return _getPortletURL(actionRequest, actionResponse, commerceCheckoutStep.getName());
	}

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		HttpServletRequest servletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		HttpSession httpSession = servletRequest.getSession();

		String checkoutStepName = ParamUtil.getString(actionRequest, "checkoutStepName");

		LOGGER.info("CheckoutStepName------------> " + checkoutStepName);
		
		if (checkoutStepName.equalsIgnoreCase("checkout-consignee-step")) {
			
			LOGGER.info("-------------- Redirecting to Order-summary step ------------");
			
			List<CommerceOrderItemModel> commerceOrderItem = (List<CommerceOrderItemModel>) httpSession.getAttribute("commerceOrderItems");
			
			actionRequest.setAttribute("commerceOrderItems", commerceOrderItem);
			
			sendRedirectToStep(actionRequest, actionResponse, checkoutStepName);
			return;
		}

		LOGGER.info(":::: Order Creation Start ::::");

		CommerceContext commerceContext = (CommerceContext) actionRequest
				.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);


		String accessToken = (String) httpSession.getAttribute(CheckoutCustomPortletKeys.ACCESS_TOKEN);
		String arxUserId = (String) httpSession.getAttribute("arxUserId");

		LOGGER.info("accessToken --> " + accessToken);

		String currentButton = ParamUtil.getString(actionRequest, "currentBtn");
		LOGGER.info("currentButton --> " + currentButton);

		String redirectURL = "";
		boolean apiCall = false;

		if (checkoutStepName.equalsIgnoreCase("order-summary")) {

			if (currentButton.equalsIgnoreCase("create-order")) {

				try {
					OMSCreateDraftOrderResponse omsCreateDraftOrderResponse = omsAPI
							.getOmsCreateDraftOrder(actionRequest, accessToken, arxUserId);

					if (Validator.isNotNull(omsCreateDraftOrderResponse) && omsCreateDraftOrderResponse.getData()
							.getStatus().equalsIgnoreCase(CheckoutCustomPortletKeys.SUCCESS)) {
						redirectURL = omsCreateDraftOrderResponse.getData().getRediectUrl();
						apiCall = true;
					}

				} catch (Exception e) {

					LOGGER.warn(
							"Unable to invoke OMS Create Draft Order API. Please enable debug logs for full details."+e.getMessage());
					LOGGER.debug(e, e);

					SessionErrors.add(actionRequest, "oms-redirect-failure");
					sendRedirectToStep(actionRequest, actionResponse, checkoutStepName);

					return;

				}

			} else if (currentButton.equalsIgnoreCase("sent-to-bid")) {

				try {
					BIDResponse bidResponse = bidAPI.getBidRequest(actionRequest, accessToken,arxUserId);

					if (Validator.isNotNull(bidResponse)
							&& bidResponse.getStatus().equalsIgnoreCase(CheckoutCustomPortletKeys.SUCCESS)) {

						redirectURL = bidResponse.getData().getRediectUrl() ;

						apiCall = true;
					}

				} catch (Exception e) {

					LOGGER.warn("Unable to invoke Send to Bid API. Please enable debug logs for full details.");
					LOGGER.debug(e, e);

					SessionErrors.add(actionRequest, "bid-redirect-failure");
					sendRedirectToStep(actionRequest, actionResponse, checkoutStepName);
					return;

				}
			}
			// Marking commerce order as complete
			completeCommerceOrder(commerceContext);
			
			if (!apiCall) {
				hideDefaultSuccessMessage(actionRequest);
				SessionErrors.add(actionRequest, "error");
				return;
			}

		}

		if (Validator.isNotNull(redirectURL)) {

			LOGGER.info(":::: Redirecting to :::: " + redirectURL);

			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

			response.addHeader(CheckoutCustomPortletKeys.AUTHORIZATION, accessToken);
			response.sendRedirect(redirectURL);

		}

		LOGGER.info(":::: Order Creation End ::::");
	}

	private String _getPortletURL(ActionRequest actionRequest, ActionResponse actionResponse, String checkoutStepName) {

		return PortletURLBuilder.createRenderURL(_portal.getLiferayPortletResponse(actionResponse))
				.setParameter("checkoutStepName", checkoutStepName)
				.setParameter("commerceOrderUuid", ParamUtil.getString(actionRequest, "commerceOrderUuid"))
				.buildString();
	}

	private void sendRedirectToStep(ActionRequest actionRequest, ActionResponse actionResponse, String checkoutStepName)
			throws Exception {

		hideDefaultSuccessMessage(actionRequest);

		String redirect = getRedirect(actionRequest, actionResponse, checkoutStepName);

		sendRedirect(actionRequest, actionResponse, redirect);

	}

	private void completeCommerceOrder(CommerceContext commerceContext) {
	    long commerceOrderId = commerceContext.getCommerceOrder().getCommerceOrderId();

	    CommerceOrder commerceOrder = null;
	    try {
	        commerceOrder = commerceOrderLocalService.getCommerceOrder(commerceOrderId);
	        commerceOrder.setOrderStatus(CommerceOrderConstants.ORDER_STATUS_PENDING);
	        commerceOrderLocalService.updateCommerceOrder(commerceOrder);
	    } catch (PortalException e) {
	        LOGGER.error(e, e);
	    }
	}

	@Reference
	private CommerceCheckoutStepRegistry _commerceCheckoutStepRegistry;

	@Reference
	private Portal _portal;
	
	@Reference
	private CommerceOrderLocalService commerceOrderLocalService;

	@Reference
	private BidApi bidAPI;

	@Reference
	private OmsAPI omsAPI;

}
