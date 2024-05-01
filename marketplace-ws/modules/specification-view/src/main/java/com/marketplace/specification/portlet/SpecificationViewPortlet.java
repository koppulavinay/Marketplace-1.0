package com.marketplace.specification.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ashishinani
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.init-param.copy-request-parameters=false", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SpecificationView", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SpecificationViewPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationViewPortlet.class.getName());

	// main portlet where we can view search
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SpecificationViewPortlet Method"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

		List<Specification> specifications = specificationLocalService.getSpecifications(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		renderRequest.setAttribute("specifications", specifications);
		super.render(renderRequest, renderResponse);
	}

	@Reference
	private SpecificationLocalService specificationLocalService;

}