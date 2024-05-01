package com.marketplace.brand.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
	"mvc.command.name=createBrandRender" }, service = MVCRenderCommand.class)

public class CreateBrandRenderCommand implements MVCRenderCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(CreateBrandRenderCommand.class.getName());

	// before creation of brand this file will redirect to create brand jsp
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateBrandRenderCommand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String createStatus = ParamUtil.getString(renderRequest, "createFailure");
		List<User> brandReviewer = null;
		List<Category> categories = CategoryLocalServiceUtil.getbyStatus(BrandViewPortletKeys.APPROVED);
		
		try {
			Role roleOwner = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.BRAND_REVIEWER);
			brandReviewer = UserLocalServiceUtil.getRoleUsers(roleOwner.getRoleId());
		} catch (Exception e) {
		    logger.error("Role Not Found : " + e.getMessage());
		}
		
		renderRequest.setAttribute(BrandViewPortletKeys.BRANDREVIEWER, brandReviewer);
		renderRequest.setAttribute("categories", categories);
		
		if(createStatus.equalsIgnoreCase("Failure")) {
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);	
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(renderRequest, "error-key");
		}
		
		return BrandViewPortletKeys.CREATE_JSP;
	}

}
