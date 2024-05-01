package com.marketplace.category.portlet;

import com.liferay.portal.kernel.exception.PortalException;
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
import com.marketplace.category.constants.CategoryViewPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
"mvc.command.name=createCategoryRender" }, service = MVCRenderCommand.class)


public class CreateCategoryRenderCommand implements MVCRenderCommand{

	private static final Log logger = LogFactoryUtil.getLog(CreateCategoryRenderCommand.class.getName());

	// before adding category redirect to create category jsp page
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// after file upload redirect to main portlet
		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateCategoryRenderCommand Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		String createStatus = ParamUtil.getString(renderRequest, "createFailure");
		long parentCategoryId = Long.parseLong(id);
		logger.info("ParentCategoryId" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX + parentCategoryId);
		
		long companyId = themeDisplay.getCompanyId();
		// Retrieve user data
		long roleAdminId = 0L;
		long roleOwnerId = 0L;
		long roleManagerId = 0L;
		long roleReviewerId = 0L;
		List<User> userManager= null;
		List<User> userReviewer= null;
		try {
			roleAdminId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.ADMIN_ROLE).getRoleId();
			roleManagerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.MANAGER_ROLE).getRoleId();
			roleReviewerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.REVIEWER_ROLE).getRoleId();
			roleOwnerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.ADMINISTRATOR_ROLE).getRoleId();
			userManager = UserLocalServiceUtil.getRoleUsers(roleManagerId);
			userReviewer = UserLocalServiceUtil.getRoleUsers(roleReviewerId);
		} catch (PortalException e) {
			logger.error("Error while fetching Role : " + e.getMessage());
		}
		
		// fetch user role details
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		final long receivedRoleAdminId = roleAdminId;
		final long receivedRoleOwnerId = roleOwnerId;
		final long receivedRoleManagerId = roleManagerId;
		final long receivedRoleReviewerId = roleReviewerId;
		
		Boolean isAdministrator = roles.stream().anyMatch(role -> role.getRoleId() == receivedRoleAdminId || role.getRoleId() == receivedRoleOwnerId);
		Boolean isManager = roles.stream().anyMatch(role -> role.getRoleId() == receivedRoleManagerId);
		Boolean isReviewer = roles.stream().anyMatch(role -> role.getRoleId() == receivedRoleReviewerId);

		
		renderRequest.setAttribute(CategoryViewPortletKeys.ADMINISTRATOR_ROLE, isAdministrator);

		renderRequest.setAttribute(CategoryViewPortletKeys.MANAGER, isManager);
		renderRequest.setAttribute(CategoryViewPortletKeys.REVIEWER, isReviewer);

		renderRequest.setAttribute(CategoryViewPortletKeys.USER_MANAGER, userManager);
		renderRequest.setAttribute(CategoryViewPortletKeys.USER_REVIEWER, userReviewer);

		renderRequest.setAttribute(CategoryViewPortletKeys.PARENT_CATEGORYID, parentCategoryId);
		
		if(createStatus.equalsIgnoreCase(CategoryViewPortletKeys.FAILURE)) {
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);	
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(renderRequest, "error-key");
		}
		
		return CategoryViewPortletKeys.CREATE_JSP;
	}

}
