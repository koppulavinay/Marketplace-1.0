package com.marketplace.product.view.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name=" + ProductViewPortletKeys.EDIT_PRODUCT_STEP_ACTION_CMD, }, service = MVCActionCommand.class)
public class EditProductStepAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		LOGGER.info("---------------- Redirecting to the edit step -----------------");

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		long draftProductId = Long.valueOf(
				PortalUtil.getOriginalServletRequest(request).getParameter(ProductViewPortletKeys.DRAFT_PRODUCT_ID));

		long stepNumber = 0;

		try {
			stepNumber = productLocalService.getProduct(draftProductId).getStepNumber();
		} catch (PortalException e) {
			LOGGER.warn("Unable to get the step number. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

		LOGGER.info("Redirecting to step number:- " + stepNumber);
		ProductViewUtil.redirectToStep(stepNumber, draftProductId, actionResponse);

		return false;
	}

	@Reference
	private ProductLocalService productLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(EditProductStepAction.class);

}