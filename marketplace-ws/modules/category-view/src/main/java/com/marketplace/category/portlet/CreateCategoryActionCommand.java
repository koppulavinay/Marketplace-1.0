package com.marketplace.category.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;
import com.marketplace.category.util.CategoryCustomUtil;
import com.marketplace.category.web.internal.security.permission.resource.CategoryPermission;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=createCategory" }, service = MVCActionCommand.class)

public class CreateCategoryActionCommand extends BaseMVCActionCommand {

	private static final Log logger = LogFactoryUtil.getLog(CreateCategoryActionCommand.class.getName());

	// Create Category java file and redirect to render java file
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateCategoryActionCommand Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		List<Boolean> regexFlag = new ArrayList<>();

		String ipAddress = httpServletRequest.getRemoteAddr();
		Date createdDate = new Date();
		long createdBy = themeDisplay.getUserId();
		long modifiedBy = themeDisplay.getUserId();
		
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());

		boolean isManager = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(CategoryViewPortletKeys.MANAGER_ROLE));

		
		long parentCategoryId = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		logger.info("ParentCategoryId " + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX + parentCategoryId);

		String categoryStatus = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_STATUS);

		String categoryCode = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_CODE);
		if(CategoryCustomUtil.emptyCheck(categoryCode)) {
			regexFlag.add(CategoryCustomUtil.checkRegexValidationForExtandCode(categoryCode));
		}
		
		String categoryName = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_NAME);
		regexFlag.add(CategoryCustomUtil.checkRegexValidation(categoryName));
		
		String categoryDescription = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_DESCRIPTION);
		if(CategoryCustomUtil.emptyCheck(categoryDescription)) {
			regexFlag.add(CategoryCustomUtil.checkRegexDescriptionAndReview(categoryDescription));
		}
		
		String categoryType = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_TYPE);
		
		long categoryAssignManager = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.CATEGORY_ASSIGN_MANAGER);
		boolean hasManagerRoles = CategoryCustomUtil.hasManagerRoles(categoryAssignManager);
		
		long categoryAssignReviewer = ParamUtil.getLong(actionRequest, CategoryViewPortletKeys.CATEG0RY_ASSIGN_REVIEWER);
		boolean hasReviewerRoles = CategoryCustomUtil.hasReviewerRoles(categoryAssignReviewer);
		
		String categoryExpiryDate = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.CATEGORY_EXPIRY_DATE);
		Date expiryDate = CategoryCustomUtil.parseDateString(categoryExpiryDate);
		
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

		logger.info("regexFlag ::: " + regexFlag);
		// categoryStatus.equalsIgnoreCase(CategoryViewPortletKeys.PENDING) && hasManagerRoles && hasReviewerRoles && !regexFlag.contains(false)
		if(!regexFlag.contains(false) && CategoryPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), CategoryViewPortletKeys.CREATE)) {
			
			Category category = CategoryLocalServiceUtil.createCategory(CounterLocalServiceUtil.increment());
			long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
			
			// uploading file and getting the fileid and creating image url
			String categoryImageURL = "";
			String fileEntryId = fileUpload(themeDisplay, actionRequest, categoryId);
			if (!fileEntryId.isEmpty()) {
				logger.info("error can be there here -------------->" + fileEntryId);
				fileEntryId = fileEntryId.substring(0, fileEntryId.length() - 2);
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(fileEntryId));
				categoryImageURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getFileName()
						+ "/" + dlFileEntry.getUuid();
			} else {
				fileEntryId = "0";
			}
			
			category.setCategoryId(categoryId);
			category.setParentCategoryId(parentCategoryId);
			category.setCategoryName(categoryName);
			category.setCategoryDescription(categoryDescription);
			category.setCategoryType(categoryType);
			category.setAssignManager(categoryAssignManager);
			category.setAssignReviewer(categoryAssignReviewer);
			category.setCategoryApprovalStatus(categoryStatus);
			category.setCategoryExpiryDate(expiryDate);
			category.setCategoryInactive(categoryInactive);
			category.setExternalReferenceId(externalRefernceId);
			category.setCategoryImageURL(categoryImageURL);
			category.setTermsCondition(termsAndCondition);
			category.setManagerRemarks(managerRemarks);
			category.setCategoryImageId(Long.parseLong(fileEntryId));
			category.setDownForSeller(downForSeller);
			category.setDownForBuyer(downForBuyer);
			category.setDownForMaintenance(downForMaintenance);
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
			category.setCategoryCode(categoryCode);

			category.setCompanyId(themeDisplay.getCompanyId());
			category.setGroupId(themeDisplay.getScopeGroupId());
			category.setCreateDate(createdDate);
			category.setCreatedBy(createdBy);
			category.setModifiedBy(modifiedBy);
			category.setIpAddress(ipAddress);
			category.setIsActive(!categoryInactive);
			
			category.setStatus(WorkflowConstants.STATUS_DRAFT);
			category.setStatusByUserId(themeDisplay.getUserId());
			category.setStatusDate(new Date());
			category.setStatusByUserName(themeDisplay.getUser().getFullName());
			
			Category parentCategory = (parentCategoryId > 0) ? CategoryLocalServiceUtil.getCategory(parentCategoryId) : null;
			category.setTreePath(Objects.isNull(parentCategory) || parentCategoryId == 0
			        ? "/" + categoryId + "/"
			        : parentCategory.getTreePath() + categoryId + "/"
			);
			
			long senderUserId = 0L;
//			if(themeDisplay.getUserId() == categoryAssignManager) {
//				senderUserId=categoryAssignReviewer;
//			}else {
				senderUserId=categoryAssignManager;
//			}
			CategoryLocalServiceUtil.addCategory(category);
			logger.info("Done Added ");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);
			serviceContext.setAttribute("isManager",false );
			if(isManager) {
				serviceContext.setAttribute("isManager",true );		
			}
			serviceContext.setAttribute("senderUserId", senderUserId);
			serviceContext.setAttribute("senderUserId2", categoryAssignReviewer);
			serviceContext.setAttribute("categoryName", category.getCategoryName());
			serviceContext.setAttribute("categoryStatus", category.getCategoryApprovalStatus());
			categoryCustomUtil.updateAsset(category.getCreatedBy(), category, null, null, null, serviceContext.getAssetPriority());
			categoryCustomUtil.startWorkflowInstance(category.getCreatedBy(), category, serviceContext);
		
			
			SessionMessages.add(actionRequest, CategoryViewPortletKeys.CATEGORY_CREATED);
			
			// notification setup with payload and pass to notification function
//			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
//					themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
//			PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
//			portletURLStep.setMVCRenderCommandName(CategoryViewPortletKeys.UPDATE_CATEGORY_RENDER);
//			portletURLStep.setParameter(CategoryViewPortletKeys.ASSET_CATEGORYID, String.valueOf(0L));
//			portletURLStep.setParameter(CategoryViewPortletKeys.CATEGORY_ID, String.valueOf(category.getCategoryId()));
//			portletURLStep.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, String.valueOf(parentCategoryId));
//
//			JSONObject payload = JSONFactoryUtil.createJSONObject();
//			payload.put(CategoryViewPortletKeys.STATUS, CategoryViewPortletKeys.PENDING);
//			payload.put(CategoryViewPortletKeys.CREATED, CategoryViewPortletKeys.CREATED_THE_CATEGORY);
//			payload.put(CategoryViewPortletKeys.CATEGORY_ID, categoryId);
//			payload.put(CategoryViewPortletKeys.URL, portletURLStep.buildPortletURL().toString());
//			payload.put(CategoryViewPortletKeys.ASSET_CATEGORYID, 0);
//			payload.put(CategoryViewPortletKeys.TITLE, categoryName);
//			payload.put(CategoryViewPortletKeys.PORTLET_FLAG, CategoryViewPortletKeys.CATEGORY_FLAG);
//			User currentUser = themeDisplay.getUser();
//			payload.put(CategoryViewPortletKeys.SENDER, currentUser.getScreenName());
//			User manage	rUser = UserLocalServiceUtil.getUser(category.getAssignManager());
			//sendNotification(managerUser, payload);
			
			PortletURL viewURL = PortletURLFactoryUtil.create(actionRequest, 
					themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
			PortletURLStep portletURLView = PortletURLBuilder.create(viewURL);
			portletURLView.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, String.valueOf(parentCategoryId));
			actionResponse.sendRedirect(portletURLView.buildPortletURL().toString());
			
		} else {
			actionResponse.getRenderParameters().setValue(CategoryViewPortletKeys.CREATE_FAILURE, CategoryViewPortletKeys.FAILURE);
			actionResponse.getRenderParameters().setValue(CategoryViewPortletKeys.MVC_RENDER_COMMAND_NAME, CategoryViewPortletKeys.CREATE_CATEGORY_RENDER);
		}
	}
	
	// file upload
	public static String fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, long categoryId)
			throws PortalException {

		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Start Fileupload" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		
		long mrfFolderId = DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CategoryViewPortletKeys.CATEGORY_LOGO).getFolderId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		try {
				DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),mrfFolderId, String.valueOf(categoryId))
				.getFolderId();
		} catch (PortalException e1) {
			logger.error("Exception in getting Folder of CategoryId : " + categoryId);
			DLAppLocalServiceUtil.addFolder("", GetterUtil.getLong(themeDisplay.getUserId()),
						GetterUtil.getLong(themeDisplay.getScopeGroupId()), mrfFolderId, String.valueOf(categoryId),
						String.valueOf(categoryId) + " Folder", serviceContext);
		}

		File file;
		String title="";
		String description="";
		StringBuilder fileEntryBuilder = new StringBuilder();
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			logger.info("File Name " + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX + file2.getKey());
			FileItem[] item = file2.getValue();

			for (FileItem fileItem : item) {
				if (fileItem.getFileName() != "") {
					title = fileItem.getFileName() + ";;" + new Date().getTime();
					description = title + " is added via programatically";
					file = fileItem.getStoreLocation();
					try {
						FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry("", themeDisplay.getUserId(), 
								DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
										mrfFolderId, String.valueOf(categoryId) + "").getRepositoryId(), 
								DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
										mrfFolderId, String.valueOf(categoryId) + "").getFolderId(), 
								fileItem.getFileName(), "", title, "", description, "", file, 
								null, null, serviceContext);
						fileEntryBuilder.append(fileEntry.getFileEntryId()).append("::");
					} catch (PortalException e) {
						logger.error("Error while file uploading : " + e.getMessage());
						logger.error("Error while : " + e);
					}
				}
			}
		}
		return fileEntryBuilder.toString();
	}

	// send notification method
	private void sendNotification(User user, JSONObject payload) {
		SendNotificationToCategoryUserHandler hndlr = new SendNotificationToCategoryUserHandler();

		if (UserNotificationManagerUtil.fetchUserNotificationDefinition(hndlr.getPortletId(),
				ClassNameLocalServiceUtil.getClassNameId(hndlr.getClass().getName()),
				UserNotificationDeliveryConstants.TYPE_WEBSITE) == null) {

			UserNotificationDefinition def = new UserNotificationDefinition(hndlr.getPortletId(),
					ClassNameLocalServiceUtil.getClassNameId(hndlr.getClass().getName()), 0, "");

			def.addUserNotificationDeliveryType(new UserNotificationDeliveryType(CategoryViewPortletKeys.WEBSITE,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, true, true));
		}

		UserNotificationEvent notification = UserNotificationEventLocalServiceUtil
				.createUserNotificationEvent(CounterLocalServiceUtil.increment());

		notification.setCompanyId(user.getCompanyId());
		notification.setUserId(user.getUserId());
		notification.setPayload(payload.toString());
		notification.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		notification.setTimestamp(new Date().getTime());
		notification.setArchived(false);
		notification.setDelivered(true);
		notification.setType(hndlr.getPortletId());

		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(notification);
	}
	
	@Reference
	private CategoryCustomUtil categoryCustomUtil;

}
