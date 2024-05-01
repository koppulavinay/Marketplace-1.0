package com.marketplace.product.view.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.SpecificationSelectionHelper;
import com.marketplace.product.view.util.ProductViewUtil;

import java.io.UnsupportedEncodingException;

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
		"javax.portlet.init-param.copy-request-parameters=false", "mvc.command.name="
				+ ProductViewPortletKeys.SELECT_SPECIFICATION_ACTION_CMD }, service = MVCActionCommand.class)
public class SelectSpecificationsAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
			long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");
			
			String productStatus = ParamUtil.getString(actionRequest, "productStatus");

			specificationSelectionHelper.updateProductSpecifications(actionRequest);

			ProductViewUtil.updateProductStatus(draftProductId, stepNumber, themeDisplay.getUserId(), "DRAFT");

			if (productStatus.equals("DRAFT")) {
				ProductViewUtil.redirectToPIMProductListing(actionResponse);
			} else {
				SessionMessages.add(actionRequest, "specification-key");
				ProductViewUtil.redirectToNextStep(actionRequest, actionResponse, ProductViewPortletKeys.VARIANT_CREATION_RENDER);
			}

		} catch (UnsupportedEncodingException | PortalException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Reference
	private SpecificationSelectionHelper specificationSelectionHelper;

}
