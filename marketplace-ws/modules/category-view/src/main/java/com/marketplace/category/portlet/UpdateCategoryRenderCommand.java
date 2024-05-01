package com.marketplace.category.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTransition;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;
import com.liferay.portal.workflow.manager.WorkflowLogManager;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.models.DocumentModels;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
		"mvc.command.name=updateCategoryRender" }, service = MVCRenderCommand.class)

public class UpdateCategoryRenderCommand implements MVCRenderCommand {

	private static final Log logger = LogFactoryUtil.getLog(UpdateCategoryRenderCommand.class.getName());

	// before update the category this java file to redirect to update jsp page
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateCategoryRenderCommand Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		String id = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.CATEGORY_ID);
		long parentCategoryId = ParamUtil.getLong(renderRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		long categoryId = Long.parseLong(id);
		long assetCategoryId = ParamUtil.getLong(renderRequest, CategoryViewPortletKeys.ASSET_CATEGORYID);
		String updateStatus = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.UPDATE_FAILURE);
		
		long roleAdminId = 0L;
		long roleOwnerId = 0L;
		long roleManagerId = 0L;
		long roleReviewerId = 0L;
		List<User> userManager = null;
		List<User> userReviewer = null;

		// fetching roles
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

		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		final long roleAdmin = roleAdminId;
		final long roleOwner = roleOwnerId;
		final long roleManager = roleManagerId;
		final long roleReviewer = roleReviewerId;
		Boolean isAdministrator = roles.stream()
				.anyMatch(role -> role.getRoleId() == roleAdmin || role.getRoleId() == roleOwner);
		Boolean isManager = roles.stream().anyMatch(role -> role.getRoleId() == roleManager);
		Boolean isReviewer = roles.stream().anyMatch(role -> role.getRoleId() == roleReviewer);

		Category category = CategoryLocalServiceUtil.fetchCategory(categoryId);

		Category parentCategory = null;
		if (parentCategoryId != 0) {
			parentCategory = CategoryLocalServiceUtil.fetchCategory(parentCategoryId);
		}
		// file or image is upload fetching the id and creating image url for download
		long fileEntryId = category.getCategoryImageId();
		try {
			if (category.getCategoryImageId() != 0) {
				DocumentModels documentModel = new DocumentModels();
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
				documentModel.setUploadedDocName(dlFileEntry.getFileName());
				documentModel.setDownloadDocumentLink(category.getCategoryImageURL());
				renderRequest.setAttribute(CategoryViewPortletKeys.DOCUMENT_MODEL, documentModel);
			}

			if (Validator.isNotNull(parentCategory)) {
				if (parentCategory.getAssetCategoryId() != 0) {
					renderRequest.setAttribute(CategoryViewPortletKeys.ASSET_CATEGORYID,
							parentCategory.getAssetCategoryId());
				}
			} else {
				renderRequest.setAttribute(CategoryViewPortletKeys.ASSET_CATEGORYID, assetCategoryId);
			}

			renderRequest.setAttribute(CategoryViewPortletKeys.ADMINISTRATOR_ROLE, isAdministrator);
			renderRequest.setAttribute(CategoryViewPortletKeys.MANAGER, isManager);
			renderRequest.setAttribute(CategoryViewPortletKeys.REVIEWER, isReviewer);
			renderRequest.setAttribute(CategoryViewPortletKeys.USER_MANAGER, userManager);
			renderRequest.setAttribute(CategoryViewPortletKeys.USER_REVIEWER, userReviewer);
			renderRequest.setAttribute(CategoryViewPortletKeys.CATEGORY, category);
			renderRequest.setAttribute(CategoryViewPortletKeys.PARENT_CATEGORYID, category.getParentCategoryId());
			logger.info("workflow is approved or not " + category.isDenied());
			WorkflowInstanceLink instanceLink;
			try {
				instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
						category.getCompanyId(), category.getGroupId(), "com.marketplace.category.model.Category", category.getCategoryId());
			
				WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(category.getCompanyId(),
						instanceLink.getWorkflowInstanceId());
				//workflowinstance contains workflowcontext 
				List<Integer> assignLogTypes = new ArrayList<>();
				assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
				List<WorkflowLog> wfAssignLogs = workflowlogmanager.getWorkflowLogsByWorkflowInstance(category.getCompanyId(),
						instance.getWorkflowInstanceId(), assignLogTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
				long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
				WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(category.getCompanyId(), wfTaskId);
				
				if(category.isDenied() || (isManager && wfAssignLogs.size()>=3)) {
					for(int i=wfAssignLogs.size()-1;i>=0;i--) {
						WorkflowLog wf = wfAssignLogs.get(i);
						task = WorkflowTaskManagerUtil.getWorkflowTask(category.getCompanyId(), wf.getWorkflowTaskId());
						if(task.getAssigneeUserId() == themeDisplay.getUserId()) {
							wfTaskId=task.getWorkflowTaskId();
							break;
						}
					}
				}
				
				List<WorkflowTransition> workflowtransition = WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(
						task.getWorkflowTaskId());
				renderRequest.setAttribute("workFlowId", task.getWorkflowTaskId());
				renderRequest.setAttribute("workflowTransition", workflowtransition);
				
				renderRequest.setAttribute("taskName", task.getName().toUpperCase()+"_BRAND");
				if(task.isCompleted()) {
					renderRequest.setAttribute("taskName", "UPDATE_BRAND");
				}
			}catch(Exception e) {
				logger.error("Error while rendering update category : " + e.getMessage());
			}
			
			if(updateStatus.equalsIgnoreCase("Failure")) {
				SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);	
				SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(renderRequest, "error-key");
			}

		} catch (Exception e) {
			logger.error("Error while rendering update category : " + e.getMessage());
		}
		return CategoryViewPortletKeys.UPDATE_JSP;
	}
	

	@Reference
	private WorkflowLogManager workflowlogmanager;
}