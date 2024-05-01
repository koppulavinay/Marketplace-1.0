package com.marketplace.product.view.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=" + ProductViewPortletKeys.SELECT_SKU_ACTION_CMD }, service = MVCActionCommand.class)
public class SkuAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {

			LOGGER.info("---------------- Inside SKU Action ----------------");

			long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");

			ProductViewUtil.updateProductStatus(draftProductId, stepNumber, themeDisplay.getUserId(), "DRAFT");

			SessionMessages.add(actionRequest, "sku-key");
			ProductViewUtil.redirectToNextStep(actionRequest, actionResponse,
					ProductViewPortletKeys.ADDITIONAL_INFORMATION_RENDER_CMD);

		} catch (Exception e) {

			LOGGER.warn("Unable to add basic information for Product Id: " + draftProductId
					+ ". Please enable debug logs for full details.");
			LOGGER.debug(e, e);

			SessionErrors.add(actionRequest, "update.product.error");

		}

		return false;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(SkuAction.class);

}