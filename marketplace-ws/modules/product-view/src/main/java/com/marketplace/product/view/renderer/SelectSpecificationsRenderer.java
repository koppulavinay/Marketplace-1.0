package com.marketplace.product.view.renderer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.SpecificationSelectionConstants;
import com.marketplace.product.view.helper.SpecificationSelectionHelper;

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
		"javax.portlet.init-param.copy-request-parameters=false", "mvc.command.name="
				+ ProductViewPortletKeys.SELECT_SPECIFICATIONS_RENDER_CMD }, service = MVCRenderCommand.class)
public class SelectSpecificationsRenderer implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		LOGGER.info("----------- Inside Select specifications render -----------");

		try {
			specificationSelectionHelper.renderSpecificationDetails(renderRequest);
		} catch (PortalException e) {
			LOGGER.warn("Unable to render Specification Details. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

		return SpecificationSelectionConstants.SPECIFICATION_SELECTION_JSP.getValue();
	}

	@Reference
	private SpecificationSelectionHelper specificationSelectionHelper;

	private static final Log LOGGER = LogFactoryUtil.getLog(SelectSpecificationsRenderer.class);

}
