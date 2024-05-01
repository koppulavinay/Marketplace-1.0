package com.marketplace.category.portlet;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;
import com.marketplace.category.util.CategoryCustomUtil;
import com.marketplace.category.web.internal.security.permission.resource.CategoryPermission;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=updateCategory" }, service = MVCActionCommand.class)

public class UpdateCategoryActionCommand extends BaseMVCActionCommand {

	private static final Log logger = LogFactoryUtil.getLog(UpdateCategoryActionCommand.class.getName());
	
	public static boolean workflowDelete = false;
	// update category java file using action method and redirect to render method
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateCategoryActionCommand Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<String, String> parametersMap = new HashMap<>();
		List<Boolean> regexFlag = new ArrayList<>();

		// fetch category form data from jsp
		long categoryId = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.CATEGORY_ID);
		long assetCategoryId = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.ASSET_CATEGORYID);
		long parentCategoryId = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		long workflowId = ParamUtil.getLong(actionRequest, "workflowId");
		String categoryName = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_NAME);
		regexFlag.add(CategoryCustomUtil.checkRegexValidation(categoryName));
		logger.info("Category Name " + categoryName);
		String categoryCode = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_CODE);
		if(CategoryCustomUtil.emptyCheck(categoryCode)) {
			regexFlag.add(CategoryCustomUtil.checkRegexValidationForExtandCode(categoryCode));
		}
		
		String categoryDescription = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_DESCRIPTION);
		if(CategoryCustomUtil.emptyCheck(categoryDescription)) {
			regexFlag.add(CategoryCustomUtil.checkRegexDescriptionAndReview(categoryDescription));
		}
		
		String categoryType = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_TYPE);
		String categoryStatus = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_STATUS);
			
		
		String categoryExpiryDate = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_EXPIRY_DATE);
		Date expDate = CategoryCustomUtil.parseDateString(categoryExpiryDate);
		
		boolean categoryInactive = ParamUtil.getBoolean(actionRequest, CategoryViewPortletKeys.CATEGORY_ACTIVE);
		
		String externalRefernceId = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.EXTERNAL_REFID);
		if(CategoryCustomUtil.emptyCheck(externalRefernceId)) {
			regexFlag.add(CategoryCustomUtil.checkRegexValidationForExtandCode(externalRefernceId));
		}
		
		String termsAndCondition = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.TERMS_AND_CONDITION);
		if(CategoryCustomUtil.emptyCheck(termsAndCondition)) {
			regexFlag.add(CategoryCustomUtil.checkRegexDescriptionAndReview(termsAndCondition));
		}
		
		String managerRemarks = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.MANAGER_REMARKS);
		if(CategoryCustomUtil.emptyCheck(managerRemarks)) {
			regexFlag.add(CategoryCustomUtil.checkRegexDescriptionAndReview(managerRemarks));
		}
		
		boolean downForSeller = ParamUtil.getBoolean(actionRequest, CategoryViewPortletKeys.DOWN_FOR_SELLER);
		boolean downForBuyer = ParamUtil.getBoolean(actionRequest, CategoryViewPortletKeys.DOWN_FOR_BUYER);
		boolean downForMaintenance = ParamUtil.getBoolean(actionRequest, CategoryViewPortletKeys.DOWN_FOR_MAINTENANCE);
		String customAtr1 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR1);
		String customAtr2 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR2);
		String customAtr3 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR3);
		String customAtr4 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR4);
		String customAtr5 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR5);
		String customAtr6 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR6);
		String customAtr7 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR7);
		String customAtr8 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR8);
		String customAtr9 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR9);
		String customAtr10 = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CUSTOMATR10);
		
		String reviewerRemarks = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.REVIEWER_REMARKS);
		if(CategoryCustomUtil.emptyCheck(reviewerRemarks)) {
			regexFlag.add(CategoryCustomUtil.checkRegexDescriptionAndReview(reviewerRemarks));
		}
		
		long categoryAssignManager = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.CATEGORY_ASSIGN_MANAGER);
		boolean hasManagerRoles = CategoryCustomUtil.hasManagerRoles(categoryAssignManager);
		
		long categoryAssignReviewer = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.CATEG0RY_ASSIGN_REVIEWER);
		boolean hasReviewerRoles = CategoryCustomUtil.hasReviewerRoles(categoryAssignReviewer);

		Date modifiedDate = new Date();
		long modifiedBy = themeDisplay.getUserId();

		boolean isActive = true;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		String ipAddress = request.getRemoteAddr();
		logger.info("regexFlag ::: " + regexFlag);
		
		// fetching roles 
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());

		boolean isManager = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(CategoryViewPortletKeys.MANAGER_ROLE));

		boolean isReviewer = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(CategoryViewPortletKeys.REVIEWER_ROLE));

		boolean isAdmin = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(CategoryViewPortletKeys.ADMIN_ROLE));
		
		
		
		// update category
		try {
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);
			themeDisplay.setScopeGroupId(category.getGroupId());
			parametersMap.put(CategoryViewPortletKeys.CATEGORY_NAME, categoryName);
			parametersMap.put(CategoryViewPortletKeys.CATEGORY_STATUS, categoryStatus);
			parametersMap.put(CategoryViewPortletKeys.CATEGORY_ACTIVE, String.valueOf(categoryInactive));
			parametersMap.put(CategoryViewPortletKeys.PARENT_CATEGORYID, String.valueOf(parentCategoryId));
			parametersMap.put(CategoryViewPortletKeys.CATEGORY_ID, String.valueOf(category.getCategoryId()));
			parametersMap.put(CategoryViewPortletKeys.ASSET_CATEGORYID, String.valueOf(assetCategoryId));
			parametersMap.put(CategoryViewPortletKeys.IS_REVIEWER, String.valueOf(isReviewer));
			parametersMap.put(CategoryViewPortletKeys.IS_MANAGER, String.valueOf(isManager));
			parametersMap.put(CategoryViewPortletKeys.IS_ADMIN, String.valueOf(isAdmin));
			
//			Boolean reviewerConditionFlag = isReviewerCondition(regexFlag, isReviewer, categoryStatus);
//			Boolean managerAndAdminConditionFlag = isManagerAndAdminCondition(regexFlag, hasManagerRoles, hasReviewerRoles, isAdmin, isManager, categoryStatus);
			
			if (isPermissionForReviewer(regexFlag,themeDisplay, workflowId)) {
				category.setCategoryId(categoryId);
				//category.setGroupId(themeDisplay.getScopeGroupId());
				category.setCompanyId(themeDisplay.getCompanyId());
				category.setModifiedBy(modifiedBy);
				category.setModifiedDate(modifiedDate);
				category.setReviewerRemarks(reviewerRemarks);
				category.setCategoryApprovalStatus(categoryStatus);
				category.setIpAddress(ipAddress);
				
				updateCategory(themeDisplay, actionRequest, actionResponse, category, parametersMap);

			} else if(isPermission(regexFlag, themeDisplay, workflowId)) {
				category.setCategoryId(categoryId);
				//category.setGroupId(themeDisplay.getScopeGroupId());
				category.setCompanyId(themeDisplay.getCompanyId());
				category.setModifiedBy(modifiedBy);
				category.setModifiedDate(modifiedDate);
				category.setParentCategoryId(parentCategoryId);
				category.setCategoryName(categoryName);
				category.setCategoryCode(categoryCode);
				category.setCategoryDescription(categoryDescription);
				category.setCategoryType(categoryType);
				category.setAssignManager(categoryAssignManager);
				category.setAssignReviewer(categoryAssignReviewer);
				if(categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.DRAFT)) {
					category.setCategoryApprovalStatus(CategoryViewPortletKeys.PENDING);
				}else if(categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.MANAGER_IN_REVIEW)) {
					category.setCategoryApprovalStatus(CategoryViewPortletKeys.INREVIEW);
				}else {
					category.setCategoryApprovalStatus(categoryStatus);
				}
				
				category.setDownForSeller(downForSeller);
				category.setDownForBuyer(downForBuyer);
				category.setDownForMaintenance(downForMaintenance);
				category.setReviewerRemarks(reviewerRemarks);
				category.setCategoryExpiryDate(expDate);
				category.setCategoryInactive(categoryInactive);
				category.setExternalReferenceId(externalRefernceId);
				category.setManagerRemarks(managerRemarks);
				category.setTermsCondition(termsAndCondition);
				category.setCustomAtr1(customAtr1);
				category.setCustomAtr2(customAtr2);
				category.setCustomAtr3(customAtr3);
				category.setCustomAtr4(customAtr4);
				category.setCustomAtr5(customAtr5);
				category.setCustomAtr6(customAtr6);
				category.setCustomAtr7(customAtr7);
				category.setCustomAtr8(customAtr8);
				category.setCustomAtr9(customAtr9);
				category.setCustomAtr10(customAtr10);
				category.setIpAddress(ipAddress);
				category.setIsActive(isActive);
				
				String fileEntryId = fileUpload(themeDisplay, actionRequest, categoryId);
				if (!fileEntryId.isEmpty()) {
					fileEntryId = fileEntryId.substring(0, fileEntryId.length() - 2);
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(fileEntryId));
					String categoryImageURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext()
							+ "/documents/" + themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
							+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
					category.setCategoryImageId(Long.parseLong(fileEntryId));
					category.setCategoryImageURL(categoryImageURL);
				}else {
					fileEntryId="0";
				}
				
				updateCategory(themeDisplay, actionRequest, actionResponse, category, parametersMap);
				
			} else {
				actionResponse.getRenderParameters().setValue(CategoryViewPortletKeys.UPDATE_FAILURE, CategoryViewPortletKeys.FAILURE);
				actionResponse.getRenderParameters().setValue(CategoryViewPortletKeys.MVC_RENDER_COMMAND_NAME, CategoryViewPortletKeys.UPDATE_CATEGORY_RENDER);
			}

		} catch (Exception e) {
			logger.error("Error while updating Category : " + e);
		}

	}
	
	/*
	 * public boolean isReviewerCondition(List<Boolean> regexFlag, boolean
	 * isReviewer, String categoryStatus) { return !regexFlag.contains(false) &&
	 * isReviewer &&
	 * (categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.APPROVED) ||
	 * categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.REJECTED)); }
	 */
	public boolean isRegexValid(List<Boolean> regexFlag) {
		return !regexFlag.contains(false);
	}
	public WorkflowTask fetchWorkflowTask(long workflowTaskId, long companyId) throws WorkflowException {
		return WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);
	}
	
	public boolean isPermission(List<Boolean> regexFlag,ThemeDisplay themeDisplay, long workflowId) throws WorkflowException {
		PermissionChecker permission = themeDisplay.getPermissionChecker();
		WorkflowTask workFlow = fetchWorkflowTask(workflowId, themeDisplay.getCompanyId());
				return isRegexValid(regexFlag) && isPermissionValid(themeDisplay, workFlow, permission);
	}
	
	
	public boolean isPermissionForReviewer(List<Boolean> regexFlag, ThemeDisplay themeDisplay, long workflowId) throws WorkflowException{
		WorkflowTask workFlow = fetchWorkflowTask(workflowId, themeDisplay.getCompanyId());
		return themeDisplay.getUserId() == workFlow.getAssigneeUserId() && 
				(CategoryPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.REVIEW));
	}
	
	public boolean isPermissionValid(ThemeDisplay themeDisplay,WorkflowTask workFlow, PermissionChecker permission) {
		return (themeDisplay.getUserId() == workFlow.getAssigneeUserId() || (workFlow.isCompleted()
				&& CategoryPermission.contains(permission, themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.CREATE)))
				&& ((CategoryPermission.contains(permission, themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.REVIEW)) 
						|| CategoryPermission.contains(permission, themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.UPDATE));
	}
	
	public boolean isPermissionForReStart(ThemeDisplay themeDisplay,long workFlowId,Category category,Boolean isAdmin,Boolean isManager) throws WorkflowException {
		PermissionChecker permission = themeDisplay.getPermissionChecker();
		WorkflowTask workFlow = fetchWorkflowTask(workFlowId, themeDisplay.getCompanyId());
		
		return ((workFlow.isCompleted() || category.isPending())&& CategoryPermission.contains(permission, themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.CREATE) && (isAdmin || (isManager && category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.APPROVED))));
	}
	
	public boolean isManagerAndAdminCondition(List<Boolean> regexFlag, boolean hasManagerRoles, boolean hasReviewerRoles, 
		            boolean isAdmin, boolean isManager, String categoryStatus) {
		return !regexFlag.contains(false) && hasManagerRoles && hasReviewerRoles ;
		
//		&&
//			((isAdmin && categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.PENDING)) || (isAdmin && categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.INREVIEW))||
//			(isManager && (categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.INREVIEW) ||(isManager && (categoryStatus.equalsIgnoreCase("Manager In-review")||
//			  categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.PENDING))))));
		}

	void updateCategory(ThemeDisplay themeDisplay, ActionRequest actionRequest, ActionResponse actionResponse, 
			Category category, Map<String, String> parametersMap) throws PortalException, IOException {
		// adding category to asset cateogry entry or else  updating
		Map<Locale, String> titleMap = new HashMap<>();
		int status = WorkflowConstants.STATUS_DRAFT;
		
		long workflowTaskId = ParamUtil.getLong(actionRequest,CategoryViewPortletKeys.WORKFLOWID);
		//User adminUser = UserLocalServiceUtil.getUser(category.getCreatedBy());
		User assignUser = null;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);
		serviceContext.setAttribute("isManager",false );

		if (Boolean.parseBoolean(parametersMap.get("isAdmin"))) {
			assignUser = UserLocalServiceUtil.getUser(category.getAssignManager());
		}
		if (Boolean.parseBoolean(parametersMap.get("isManager"))) {
			assignUser = UserLocalServiceUtil.getUser(category.getAssignReviewer());
			serviceContext.setAttribute("isManager",true );
			if(parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS).equalsIgnoreCase(CategoryViewPortletKeys.INREVIEW)) {
				status = WorkflowConstants.STATUS_PENDING;
			}
		}
		if (Boolean.parseBoolean(parametersMap.get("isReviewer"))) {
			assignUser = UserLocalServiceUtil.getUser(category.getAssignManager());
			if(parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS).equalsIgnoreCase(CategoryViewPortletKeys.REJECTED)) {
				status = WorkflowConstants.STATUS_DENIED;
			}else if(parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS).equalsIgnoreCase(CategoryViewPortletKeys.APPROVED)) {
				status = WorkflowConstants.STATUS_APPROVED;
			}else if(parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS).equalsIgnoreCase(CategoryViewPortletKeys.INREVIEW)) {
				status = WorkflowConstants.STATUS_PENDING;
			}
		}
		
		titleMap.put(LocaleUtil.fromLanguageId("en_US"), parametersMap.get(CategoryViewPortletKeys.CATEGORY_NAME));
	
		AssetCategory assetCategory = null;
		assetCategory = addUpdateAssetCategory(themeDisplay, Long.parseLong(parametersMap.get(CategoryViewPortletKeys.ASSET_CATEGORYID)), parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS), 
				Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.CATEGORY_ACTIVE)), category, titleMap, assetCategory);
		category = CategoryLocalServiceUtil.updateCategory(category);
		try {	
			logger.info("Theme Display check :::: " + themeDisplay.getPermissionChecker());

			logger.info("Status check :::: " + themeDisplay.getScopeGroupId());

			logger.info("Category check :::: " + category.getCategoryId());

			logger.info("ServiceContext check :::: " +WorkflowPermissionUtil.hasPermission(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId()
					,Category.class.getName(), category.getCategoryId(), "CREATE_CATEGORY"));
			
		if(WorkflowPermissionUtil.hasPermission(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId()
				,Category.class.getName(), category.getCategoryId(), "CREATE_CATEGORY")) {
			logger.info("True here ");
			
		}
		}catch(Exception e) {
			if(category.isApproved()) {
				serviceContext.setAttribute("senderUserId", assignUser.getUserId());
				serviceContext.setAttribute("senderUserId2", assignUser.getUserId());
				serviceContext.setAttribute("categoryName", category.getCategoryName());
				serviceContext.setAttribute("categoryStatus", category.getCategoryApprovalStatus());
			}
			logger.error(e);
		}
		// update category
		logger.info("Theme Display check :::: " + themeDisplay.getUserId());

		logger.info("Status check :::: " + status);

		logger.info("Category check :::: " + category.getCategoryId());

		logger.info("ServiceContext check :::: " +serviceContext);
		CategoryLocalServiceUtil.updateStatus(themeDisplay.getUserId(),category.getCategoryId(), status, serviceContext);
		
		// if ( ) && Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.IS_ADMIN))) {
		if(isPermissionForReStart(themeDisplay, workflowTaskId,category,Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.IS_ADMIN)),Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.IS_MANAGER)))) {	
			categoryCustomUtil.startWorkflowInstance(themeDisplay.getUserId(), category, serviceContext);
		} else {
			WorkflowInstanceLink instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
					category.getCompanyId(), category.getGroupId(),Category.class.getName() ,//"com.marketplace.category.model.Category"
					category.getCategoryId());
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(category.getCompanyId(),
					instanceLink.getWorkflowInstanceId());
			Map<String, Serializable> workflowcontext = instance.getWorkflowContext();
			serviceContext = (ServiceContext) workflowcontext.get("serviceContext");
			// senderUser2 is for when reviewer reject the category the nsenderuserid 1 will go to admin and 
			// senderUser 2 will goto manage
			serviceContext.setAttribute("senderUserId", assignUser.getUserId());
			serviceContext.setAttribute("senderUserId2", category.getCreatedBy());
			serviceContext.setAttribute("categoryName", category.getCategoryName());
			serviceContext.setAttribute("categoryStatus", category.getCategoryApprovalStatus());
			serviceContext.setAttribute("CreatorManager", false);
				if(category.getCreatedBy() == category.getAssignManager()) {
					serviceContext.setAttribute("CreatorManager", true);
				}
			
			workflowcontext.put("serviceContext", (Serializable) serviceContext);
//			if(category.isDenied() && Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.IS_ADMIN))) {
			WorkflowTaskManagerUtil.completeWorkflowTask(category.getCompanyId(), themeDisplay.getUserId(),
					workflowTaskId, parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS),
					"auto " + parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS), workflowcontext);
			logger.info("Workflow Completed ");
		
		}
		
		//notification payload setting and passing it to function
//		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
//				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
//		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
//		portletURLStep.setMVCRenderCommandName(CategoryViewPortletKeys.UPDATE_CATEGORY_RENDER);
//		
//		if(assetCategory != null) {
//			portletURLStep.setParameter(CategoryViewPortletKeys.ASSET_CATEGORYID,String.valueOf(assetCategory.getCategoryId()));
//		}
//		portletURLStep.setParameter(CategoryViewPortletKeys.CATEGORY_ID, String.valueOf(category.getCategoryId()));
//		portletURLStep.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, parametersMap.get(CategoryViewPortletKeys.PARENT_CATEGORYID));
//		
//		
		// for the notification
//		JSONObject payload = JSONFactoryUtil.createJSONObject();
//		payload.put(CategoryViewPortletKeys.STATUS, parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS));
//		payload.put(CategoryViewPortletKeys.TITLE, parametersMap.get(CategoryViewPortletKeys.CATEGORY_NAME));
//		payload.put(CategoryViewPortletKeys.CREATED, "updated the category to " + parametersMap.get(CategoryViewPortletKeys.CATEGORY_STATUS));
//		payload.put(CategoryViewPortletKeys.CATEGORY_ID, Long.parseLong(parametersMap.get(CategoryViewPortletKeys.CATEGORY_ID)));
//		payload.put(CategoryViewPortletKeys.ASSET_CATEGORYID, Long.parseLong(parametersMap.get(CategoryViewPortletKeys.ASSET_CATEGORYID)));
//		payload.put(CategoryViewPortletKeys.URL, portletURLStep.buildPortletURL().toString());
//		User currentUser = themeDisplay.getUser();
//		payload.put(CategoryViewPortletKeys.SENDER, currentUser.getScreenName());
//		
//		if (category.getCategoryInactive() != Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.CATEGORY_ACTIVE)) 
//				&& Boolean.parseBoolean(parametersMap.get("isReviewer"))) {
//			if (Boolean.parseBoolean(parametersMap.get(CategoryViewPortletKeys.CATEGORY_ACTIVE))) {
//				payload.put(CategoryViewPortletKeys.CREATED, currentUser.getScreenName() + "is set Category to In-Active");
//			} else {
//				payload.put(CategoryViewPortletKeys.CREATED, currentUser.getScreenName() + "is set Category to Active");
//			}
//		} else {
//			payload.put(CategoryViewPortletKeys.CREATED, CategoryViewPortletKeys.UPDATE_STATUS_OF_CATEGORY);
//		}

		
		
		//calling sendNotification method
		/*
		 * if (!Boolean.parseBoolean(parametersMap.get("isAdmin"))) {
		 * sendNotification(adminUser, payload); } sendNotification(assignUser,
		 * payload);
		 */
		SessionMessages.add(actionRequest, CategoryViewPortletKeys.CATEGORY_UPDATE);
		PortletURL viewURL = PortletURLFactoryUtil.create(actionRequest, 
				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLView = PortletURLBuilder.create(viewURL);
		
		if (assetCategory != null) {
			portletURLView.setParameter(CategoryViewPortletKeys.ASSET_CATEGORYID, String.valueOf(assetCategory.getCategoryId()));
		}

		portletURLView.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, parametersMap.get(CategoryViewPortletKeys.PARENT_CATEGORYID));
		actionResponse.sendRedirect(portletURLView.buildPortletURL().toString());
	}
	
	// Add update Asset Category
	private AssetCategory addUpdateAssetCategory(ThemeDisplay themeDisplay, long assetCategoryId, String categoryStatus,
			boolean categoryInactive, Category category, Map<Locale, String> titleMap, AssetCategory assetCategory)
			throws PortalException {
		String[] categoryProperties = { "" };
		ServiceContext serviceContext = new ServiceContext();
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
				.getGroupVocabulary(themeDisplay.getCompanyGroupId(), CategoryViewPortletKeys.CATEGORY_VOCABULARY);

		if (categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.APPROVED) && !categoryInactive) {
			if (category.getAssetCategoryId() == 0) {
				assetCategory = AssetCategoryLocalServiceUtil.addCategory("", themeDisplay.getUserId(),
						themeDisplay.getCompanyGroupId(), assetCategoryId, titleMap, new HashMap<Locale, String>(),
						assetVocabulary.getVocabularyId(), categoryProperties, serviceContext);
				category.setAssetCategoryId(assetCategory.getCategoryId());
			} else {
				assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(category.getAssetCategoryId());
				if (Validator.isNotNull(assetCategory)) {
					AssetCategoryLocalServiceUtil.updateCategory(themeDisplay.getUserId(),
							category.getAssetCategoryId(), assetCategoryId, titleMap, new HashMap<Locale, String>(),
							assetVocabulary.getVocabularyId(), categoryProperties, serviceContext);
				}
			}
			
		// update when if asset category got deleted by changing the id
		} else if (categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.APPROVED) && categoryInactive && category.getAssetCategoryId() != 0) {
				AssetCategoryLocalServiceUtil.deleteAssetCategory(category.getAssetCategoryId());
				List<Category> categories = fetchByParentCategoryId(category.getCategoryId());
				for (Category category1 : categories) {
					category1.setAssetCategoryId(0);
					category1.setCategoryInactive(true);
					CategoryLocalServiceUtil.updateCategory(category1);
				}
				logger.info("Sub Categories" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX + categories);
				category.setAssetCategoryId(0);
		}
		return assetCategory;
	}
	
	// image upload 
	public static String fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, long categoryId)
			throws PortalException {
		
		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside fileUpload Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		Category category = CategoryLocalServiceUtil.fetchCategory(categoryId);
		long fileEntryId = category.getCategoryImageId();
		FileEntry dlfileEntry = null;
		if (Validator.isNotNull(fileEntryId)) {
			dlfileEntry = DLAppLocalServiceUtil.getFileEntry(category.getCategoryImageId());
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		
		long mrfFolderId = DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CategoryViewPortletKeys.CATEGORY_LOGO).getFolderId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		
		try {
			DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
					mrfFolderId, String.valueOf(categoryId)).getFolderId();
			
		} catch (PortalException e1) {
			logger.error("Exception in getting Folder of E1 : " + e1);
			logger.error("Exception in getting Folder of CategoryId : " + categoryId);
			DLAppLocalServiceUtil.addFolder("", GetterUtil.getLong(themeDisplay.getUserId()),
					GetterUtil.getLong(themeDisplay.getScopeGroupId()), mrfFolderId, String.valueOf(categoryId),
					String.valueOf(categoryId) + " Folder", serviceContext);
		}
		String fileEntryLst = "";
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
				FileItem[] item = file2.getValue();
				fileEntryLst = processFiles(item, themeDisplay, mrfFolderId, categoryId, dlfileEntry, serviceContext);
		}
		return fileEntryLst;
	}
	
	public static String processFiles(FileItem[] item, ThemeDisplay themeDisplay, long mrfFolderId, long categoryId, FileEntry dlfileEntry, ServiceContext serviceContext) {
	    File file;
	    String title = "";
	    String description = "";
	    StringBuilder fileEntryBuilder = new StringBuilder();

	    for (FileItem fileItem : item) {
            if (fileItem.getFileName() != "") {
                title = fileItem.getFileName() + ";;" + new Date().getTime();
                description = title + " is added via programatically";
                file = fileItem.getStoreLocation();
                try {
                    FileEntry fileEntry = null;
                    if (Validator.isNotNull(dlfileEntry) && fileItem.getFileName().equals(dlfileEntry.getFileName())) {
                        return String.valueOf(dlfileEntry.getFileEntryId());
                    } else {
                        fileEntry = DLAppLocalServiceUtil.addFileEntry("", themeDisplay.getUserId(),
                                DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
                                        mrfFolderId, String.valueOf(categoryId) + "").getRepositoryId(),
                                DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
                                        mrfFolderId, String.valueOf(categoryId) + "").getFolderId(),
                                fileItem.getFileName(), "", title, "", description, "", file,
                                null, null, serviceContext);
                        
                        if (Validator.isNotNull(dlfileEntry)) {
                            DLAppLocalServiceUtil.deleteFileEntry(dlfileEntry.getFileEntryId());
                        }
                    }
                    fileEntryBuilder.append(fileEntry.getFileEntryId()).append("::");
                } catch (PortalException e) {
                    logger.error(e.getMessage());
                    logger.error("file Upload error " + e);
                }
            }
	    }
	    return fileEntryBuilder.toString();
	}

		
	// fetching the childCategory of current Category
	public List<Category> fetchByParentCategoryId(long parentCategoryId) {
	    List<Category> categoryList = new ArrayList<>();

	    DynamicQuery dynamicQuery = CategoryLocalServiceUtil.dynamicQuery();
	    dynamicQuery.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.PARENT_CATEGORYID).eq(parentCategoryId));

	    List<Category> categories = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);

	    for (Category category : categories) {
	        categoryList.add(category);

	        List<Category> subcategories = fetchByParentCategoryId(category.getCategoryId());
	        categoryList.addAll(subcategories);
	    }

	    return categoryList;
	}

	
	
		
	@Reference
	private WorkflowInstanceLinkLocalService _workflowInstanceLinkLocalService;

	@Reference
	private CategoryCustomUtil categoryCustomUtil;
}
