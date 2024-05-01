package com.marketplace.product.view.renderer;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.AdditionalConfigurationConstants;
import com.marketplace.product.view.helper.AdditionalInformationHelper;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.ADDITIONAL_INFORMATION_RENDER_CMD }, service = MVCRenderCommand.class)
public class AdditionalInformationRenderer implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String skuSuccessKey = ParamUtil.getString(renderRequest, "skuSuccessKey");
	       if(Validator.isNotNull(skuSuccessKey))
	          SessionMessages.add(renderRequest, skuSuccessKey);
		additionalInformationHelper.renderProductAdditionalInformation(renderRequest);

		return AdditionalConfigurationConstants.ADDITIONAL_INFORMATION_JSP.getValue();
	}

	@Reference
	private AdditionalInformationHelper additionalInformationHelper;

}
