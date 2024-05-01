package com.marketplace.custom.checkout.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.marketplace.custom.checkout.constants.CheckoutConsigneeDetailsConstants;
import com.marketplace.custom.checkout.helper.CheckoutConsigneeStepHelper;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + CommercePortletKeys.COMMERCE_CHECKOUT,
		"mvc.command.name="
				+ CheckoutConsigneeDetailsConstants.GET_CONSIGNEE_DETAILS_MVC_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class GetConsigneeDetailsResourceCmd implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		LOGGER.info("-------------- Inside Get Consignee Details Resource Cmd ---------------");
		
		PortletSession portletSession = resourceRequest.getPortletSession();
		
		JSONObject requestBody = CommonUtil.getJsonFromRequestBody(resourceRequest);

		JSONObject orderConsigneeDetails = checkoutConsigneeStepHelper.getCheckoutConsigneeDetails(requestBody, portletSession);
		
		CommonUtil.getPrintWriter(resourceResponse).write(orderConsigneeDetails.toString());
		
		return false;
	}

	@Reference
	private CheckoutConsigneeStepHelper checkoutConsigneeStepHelper;

	private static final Log LOGGER = LogFactoryUtil.getLog(GetConsigneeDetailsResourceCmd.class);

}
