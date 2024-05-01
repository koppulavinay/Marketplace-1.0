package com.marketplace.specification.renderer;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specification.portlet.SpecificationViewPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW,
"mvc.command.name=specificationListingRender" }, service = MVCRenderCommand.class)
public class SpecificationListingRenderer implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationViewPortlet.class.getName());

	// main portlet where we can view search
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SpecificationViewPortlet Method"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

		List<Specification> specifications = specificationLocalService.getSpecifications(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		renderRequest.setAttribute("specifications", specifications);

		return "/view.jsp";
	}

	@Reference
	private SpecificationLocalService specificationLocalService;

}
