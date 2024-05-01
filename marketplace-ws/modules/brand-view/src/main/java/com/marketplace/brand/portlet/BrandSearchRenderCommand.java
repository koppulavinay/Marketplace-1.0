package com.marketplace.brand.portlet;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
"mvc.command.name=brandSearchRender" }, service = MVCRenderCommand.class)

public class BrandSearchRenderCommand implements MVCRenderCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(BrandSearchRenderCommand.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// Redirecting to listing brand jsp
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside Search Brand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Boolean administrator = false;
		Boolean reviewer = false;
		String search = ParamUtil.get(renderRequest, BrandViewPortletKeys.SEARCH,"");
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Search" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX + search);
		long companyId = themeDisplay.getCompanyId();
		
		long roleAdminId = 0L;
		long roleOwnerId = 0L;
		long roleReviewerId = 0L;
		
		try {
			roleAdminId = RoleLocalServiceUtil.getRole(companyId, BrandViewPortletKeys.BRAND_ADMIN).getRoleId();
			roleReviewerId = RoleLocalServiceUtil.getRole(companyId, BrandViewPortletKeys.BRAND_REVIEWER).getRoleId();
			roleOwnerId= RoleLocalServiceUtil.getRole(companyId, BrandViewPortletKeys.ADMINISTRATOR_ROLE).getRoleId();
		} catch (PortalException e) {
			logger.error("Role Not Found : " + e.getMessage());
		}
		
		// search based on role
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		DynamicQuery dynamicQuery = BrandLocalServiceUtil.dynamicQuery();
		
		for(Role role : roles) {
			if(role.getRoleId() == roleAdminId || role.getRoleId() == roleOwnerId) {
				administrator = true;
				dynamicQuery = BrandLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("createdBy").eq(themeDisplay.getUserId()));
			}
			if(role.getRoleId() == roleReviewerId) {
				dynamicQuery = BrandLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName(BrandViewPortletKeys.BRAND_OWNER).eq(themeDisplay.getUserId()));
				reviewer = true;
			}
			if(administrator || reviewer) {
				break;
			}
		}
		Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("LOWER("+BrandViewPortletKeys.BRAND_NAME+") LIKE ?", "%" + search.toLowerCase() + "%", Type.STRING); 
		dynamicQuery.add(criterion);
		List<Brand> brands = BrandLocalServiceUtil.dynamicQuery(dynamicQuery);
		 
		renderRequest.setAttribute(BrandViewPortletKeys.BRANDS, brands);
		renderRequest.setAttribute(BrandViewPortletKeys.ADMINISTRATOR_ROLE, administrator);
		renderRequest.setAttribute(BrandViewPortletKeys.REVIEWER_ROLE, reviewer);
		return BrandViewPortletKeys.VIEW_JSP;
	}

}
