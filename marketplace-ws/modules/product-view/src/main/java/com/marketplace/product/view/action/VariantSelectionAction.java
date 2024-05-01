package com.marketplace.product.view.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=variantSelection" }, service = MVCActionCommand.class)

public class VariantSelectionAction extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(BrandCategorySelectionAction.class.getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside VariantSelectionAction Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);

		long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		long stepNumber = ParamUtil.getLong(actionRequest, "stepNumber");

		String productStatus = ParamUtil.getString(actionRequest, "productStatus");

		ProductViewUtil.updateProductStatus(draftProductId, stepNumber, themeDisplay.getUserId(), "DRAFT");

		if (productStatus.equals("DRAFT")) {

			SessionMessages.add(actionRequest, "success-key");
			ProductViewUtil.redirectToPIMProductListing(actionResponse);

		} else {
			SessionMessages.add(actionRequest, "variant-key");

			portletURLStep.setMVCRenderCommandName(ProductViewPortletKeys.SKU_CREATION_RENDER);
			portletURLStep.setParameter(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);

			actionResponse.sendRedirect(portletURLStep.buildPortletURL().toString());
		}

	}

}
