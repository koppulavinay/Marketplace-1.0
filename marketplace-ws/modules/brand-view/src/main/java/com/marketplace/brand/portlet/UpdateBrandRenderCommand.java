package com.marketplace.brand.portlet;

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
import com.liferay.portal.kernel.theme.PortletDisplay;
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
import com.liferay.portal.workflow.manager.WorkflowLogManager;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.models.DocumentModel;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
	"mvc.command.name=updateBrandRender" }, service = MVCRenderCommand.class)

// before updation of brand after that this file will redirect to update brand jsp page
public class UpdateBrandRenderCommand implements MVCRenderCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(UpdateBrandRenderCommand.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateBrandRenderCommand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long brandId = ParamUtil.getLong(renderRequest, BrandViewPortletKeys.BRAND_ID);
		String updateStatus = ParamUtil.getString(renderRequest, "updateFailure");
		Brand brand = null;
		String categoryIds = "";
		List<DocumentModel> documentModels = new ArrayList<>();
		DocumentModel brandImageDoc = new DocumentModel();
		List<User> brandReviewer = null;
		Boolean reviewer = false;
		Boolean administrator = false;
		
		List<Category> categories = CategoryLocalServiceUtil.getbyStatus(BrandViewPortletKeys.APPROVED);
		
		try {
			// get brand details
			brand = BrandLocalServiceUtil.getBrand(brandId);
			
			// get brand category map details
			List<BrandCategoryMap> brandCategoryMaps = BrandCategoryMapLocalServiceUtil
					.findByFBYBrandId(brandId);
			categoryIds = getBrandCategories(brandCategoryMaps);
			
			// document render
			List<BrandDocumentUpload> brandDocumentUploads = BrandDocumentUploadLocalServiceUtil
					.findByFBYBrandId(brandId);
			documentModels = getBrandDocuments(brandDocumentUploads, themeDisplay, documentModels);
			
			if(brand.getBrandImageUpload() != 0) {
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(brand.getBrandImageUpload());
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
						+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
				brandImageDoc.setFileEntryId(String.valueOf(brand.getBrandImageUpload()));
				brandImageDoc.setUploadedDocName(dlFileEntry.getFileName());
				brandImageDoc.setDownloadDocumentLink(url);
			}
			
			// fetch role
			Role roleOwner = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.BRAND_REVIEWER);
			Role roleBrandAdmin = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.BRAND_ADMIN);
			Role roleAdmin = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.ADMINISTRATOR_ROLE);
			brandReviewer = UserLocalServiceUtil.getRoleUsers(roleOwner.getRoleId());
			List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
			for(Role role : roles) {
				if(role.getRoleId() == roleOwner.getRoleId()) {
					reviewer = true;
				}
				
				if(role.getRoleId() == roleBrandAdmin.getRoleId() || role.getRoleId() == roleAdmin.getRoleId()) {
					administrator = true;
				}
				
				if(administrator || reviewer) {
					break;
				}
			}
		} catch(Exception e) {
			logger.error("Error while fetching role : " + e.getMessage());
		}
		
		renderRequest.setAttribute("documentModels", documentModels);
		renderRequest.setAttribute("brandImageDoc", brandImageDoc);
		renderRequest.setAttribute("brand", brand);
		renderRequest.setAttribute(BrandViewPortletKeys.CATEGORYMAP, categoryIds);
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute(BrandViewPortletKeys.REVIEWER_ROLE, reviewer);
		renderRequest.setAttribute(BrandViewPortletKeys.ADMINISTRATOR_ROLE, administrator);
		renderRequest.setAttribute(BrandViewPortletKeys.BRANDREVIEWER, brandReviewer);
		
		if(updateStatus.equalsIgnoreCase("Failure")) {
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);	
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(renderRequest, "error-key");
		}
		WorkflowInstanceLink instanceLink;
		try {
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
					brand.getCompanyId(), brand.getGroupId(), "com.marketplace.brand.model.Brand", brand.getBrandId());
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(brand.getCompanyId(),
					instanceLink.getWorkflowInstanceId());
			List<Integer> assignLogTypes = new ArrayList<>();
			assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
			List<WorkflowLog> wfAssignLogs = workflowlogmanager.getWorkflowLogsByWorkflowInstance(brand.getCompanyId(),
					instance.getWorkflowInstanceId(), assignLogTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(brand.getCompanyId(), wfTaskId);
			List<WorkflowTransition> workflowtransition = WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(
					task.getWorkflowTaskId());
			renderRequest.setAttribute("workFlowId", task.getWorkflowTaskId());
			renderRequest.setAttribute("workflowTransition", workflowtransition);
			renderRequest.setAttribute("taskName", task.getName().toUpperCase()+"_BRAND");
			if(task.isCompleted()) {
				renderRequest.setAttribute("taskName", "UPDATE_BRAND");
			}
		} catch (PortalException e) {
			logger.error("Error Message For WorkFlow " + e);
		}
		

		return BrandViewPortletKeys.UPDATE_JSP;
	}

	// method for getting documents uploaded in brand
	private List<DocumentModel> getBrandDocuments(List<BrandDocumentUpload> brandDocumentUploads, ThemeDisplay themeDisplay, 
			List<DocumentModel> documentModels) throws PortalException {
		if(!brandDocumentUploads.isEmpty() && Validator.isNotNull(brandDocumentUploads)) {
			for (BrandDocumentUpload brandDocumentUpload : brandDocumentUploads) {
				DocumentModel documentModel = new DocumentModel();
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(brandDocumentUpload.getDocumentId());
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
						+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
				
				documentModel.setFileEntryId(String.valueOf(brandDocumentUpload.getDocumentId()));
				documentModel.setUploadedDocName(dlFileEntry.getFileName());
				documentModel.setDownloadDocumentLink(url);
				documentModels.add(documentModel);
			}
		}
		return documentModels;
	}
	
	private String getBrandCategories(List<BrandCategoryMap> brandCategoryMaps) {
		StringBuilder categoryIds = new StringBuilder();
		String categoryId = "";
		if(!brandCategoryMaps.isEmpty() && Validator.isNotNull(brandCategoryMaps)) {
			for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
				categoryIds.append(brandCategoryMap.getCategoryId()).append("::");
			}
			categoryId = categoryIds.substring(0, categoryIds.length()-2);
		}
		return categoryId;
	}
	
	@Reference
	private WorkflowLogManager workflowlogmanager;
	
}
