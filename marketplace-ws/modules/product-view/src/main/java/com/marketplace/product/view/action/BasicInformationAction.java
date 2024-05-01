package com.marketplace.product.view.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.BasicInformationHelper;
import com.marketplace.product.view.util.ProductViewUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=" + ProductViewPortletKeys.BASIC_INFORMATION_ACTION_CMD }, service = MVCActionCommand.class)
public class BasicInformationAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			Product draftProduct = basicInformationHelper.addBasicInformation(actionRequest);

			LOGGER.info("---------------- Basic Information Added Successfully ----------------");

			actionRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProduct.getDraftProductId());

			String productStatus = ParamUtil.getString(actionRequest, "productStatus");
			long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");

			ProductViewUtil.updateProductStatus(draftProductId, stepNumber, themeDisplay.getUserId(), "DRAFT");

			if (productStatus.equals("DRAFT")) {
				ProductViewUtil.redirectToPIMProductListing(actionResponse);
			} else {
				SessionMessages.add(actionRequest, "product-information-key");
				ProductViewUtil.redirectToNextStep(actionRequest, actionResponse,
						ProductViewPortletKeys.SELECT_SPECIFICATIONS_RENDER_CMD);
			}

		} catch (PortalException e) {

			LOGGER.warn("Unable to add basic information for Product Id: " + draftProductId
					+ ". Please enable debug logs for full details.");
			LOGGER.debug(e, e);

			SessionErrors.add(actionRequest, "update.product.error");

		}

		return false;
	}

	@Reference
	private BasicInformationHelper basicInformationHelper;

	private static final Log LOGGER = LogFactoryUtil.getLog(BasicInformationAction.class);

}
