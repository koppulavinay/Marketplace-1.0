package com.marketplace.brand.portlet;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.brand.util.BrandCustomUtil;
import com.marketplace.brand.web.internal.security.permission.resource.BrandPermission;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.io.File;
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

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=updateBrand" }, service = MVCActionCommand.class)

// update brand using action method
public class UpdateBrandActionCommand extends BaseMVCActionCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(UpdateBrandActionCommand.class.getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateBrandActionCommand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isActive = true;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(UpdateBrandActionCommand.class.getName(), actionRequest);
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		List<Boolean> regexFlag = new ArrayList<>();
		
		
		
		
		// get brand detials from jsp
		long brandId = ParamUtil.getLong(actionRequest, BrandViewPortletKeys.BRAND_ID);
		
		String brandCode = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_CODE);
		if(brandCustomUtil.emptyCheck(brandCode)) {
			regexFlag.add(brandCustomUtil.checkRegexValidationForExtandCode(brandCode));
		}
		
		String brandName = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_NAME);
		regexFlag.add(brandCustomUtil.checkRegexValidation(brandName));
		
		String brandDescription = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_DESCRIPTION);
		if(brandCustomUtil.emptyCheck(brandDescription)) {
			regexFlag.add(brandCustomUtil.checkRegexDessciptionAndReview(brandDescription));
		}
		
		String brandOwner = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_OWNER);
		
		long brandReviewer = ParamUtil.getLong(actionRequest, BrandViewPortletKeys.BRANDREVIEWER);
	//	boolean hasReviewerRoles = brandCustomUtil.hasReviewerRoles(brandReviewer);
		
		String brandType = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_TYPE);
		String brandApprovalStatus = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_APPROVAL_STATUS);
		logger.info("brand approval status  ------- > " + brandApprovalStatus);
		String[] categoryMaps = ParamUtil.getStringValues(actionRequest, BrandViewPortletKeys.CATEGORYMAP);
		
		String externalReferenceId = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_REFERENCEID);
		if(brandCustomUtil.emptyCheck(externalReferenceId)) {
			regexFlag.add(brandCustomUtil.checkRegexValidationForExtandCode(externalReferenceId));
		}
		
		String reviewerRemarks = ParamUtil.getString(actionRequest, BrandViewPortletKeys.REVIEWER_REMARKS);
		if(brandCustomUtil.emptyCheck(reviewerRemarks)) {
			regexFlag.add(brandCustomUtil.checkRegexDessciptionAndReview(reviewerRemarks));
		}
		
		boolean brandInactive = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.BRAND_INACTIVE);
		boolean downForSeller = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_SELLER);
		boolean downForBuyer = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_BUYER);
		boolean downForMaintenance = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_MAINTENANCE);
		
		String managerRemarks = ParamUtil.getString(actionRequest, BrandViewPortletKeys.MANAGER_REMARKS);
//		if(brandCustomUtil.emptyCheck(managerRemarks)) {
//			regexFlag.add(brandCustomUtil.checkRegexDessciptionAndReview(managerRemarks));
//		}
		
		String customAtr1 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR1);
		String customAtr2 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR2);
		String customAtr3 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR3);
		String customAtr4 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR4);
		String customAtr5 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR5);
		String customAtr6 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR6);
		String customAtr7 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR7);
		String customAtr8 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR8);
		String customAtr9 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR9);
		String customAtr10 = ParamUtil.getString(actionRequest, BrandViewPortletKeys.CUSTOMATR10);

		logger.info("regexFlag ::: " + regexFlag);
		//fetching role
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		
		boolean isAdmin = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(BrandViewPortletKeys.BRAND_ADMIN) ||
		                         role.getName().equalsIgnoreCase(BrandViewPortletKeys.ADMINISTRATOR_ROLE));

		boolean isReviewer = userRoles.stream()
		        .anyMatch(role -> role.getName().equalsIgnoreCase(BrandViewPortletKeys.BRAND_REVIEWER));
		
		try {
			Brand brand = BrandLocalServiceUtil.getBrand(brandId);
			if(!regexFlag.contains(false) && BrandPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), "REVIEW_BRAND")) {
				
				// set brand details
				brand.setBrandId(brandId);
				brand.setReviewerRemarks(reviewerRemarks);
				brand.setBrandApprovalStatus(brandApprovalStatus);
				brand.setIpAddress(httpServletRequest.getRemoteAddr());
				
				brand.setCompanyId(themeDisplay.getCompanyId());
				brand.setModifiedDate(new Date());
				brand.setModifiedBy(themeDisplay.getUserId());
				
				//Updating brand
				updateBrand(actionRequest, themeDisplay, brand, isAdmin, isReviewer,brandApprovalStatus);

			} else if (!regexFlag.contains(false) && BrandPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), "CREATE_BRAND")) {
				
				// file upload
				uploadFileToBrandDocumentUpload(actionRequest, themeDisplay, brand);
				
				// brand image url creating
				String brandImageURL = "";
				String dlFileEntryId = fileUpload(themeDisplay, actionRequest, brand.getBrandId(), BrandViewPortletKeys.IMAGE);
				logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "dlFileEntryId" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX + dlFileEntryId);
				if(!dlFileEntryId.isEmpty()) {
					dlFileEntryId = dlFileEntryId.substring(0, dlFileEntryId.length() - 2);
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(dlFileEntryId));
					brandImageURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
							+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
							+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
					brand.setBrandImageUpload(Long.parseLong(dlFileEntryId));
					brand.setBrandImageURL(brandImageURL);
				}
				
				//brand category mapping adding and deletion
				brandCategoryAddAndDelete(categoryMaps, brand);
				
				// set brand details
				brand.setBrandId(brandId);
				brand.setBrandCode(brandCode);
				brand.setBrandName(brandName);
				brand.setBrandDescription(brandDescription);
				brand.setBrandOwner(brandOwner);
				brand.setBrandReviewer(brandReviewer);
				brand.setBrandType(brandType);
				brand.setExternalReferenceId(externalReferenceId);
				brand.setBrandApprovalStatus(brandApprovalStatus);
				brand.setBrandInactive(brandInactive);
				brand.setDownForSeller(downForSeller);
				brand.setDownForBuyer(downForBuyer);
				brand.setDownForMaintenance(downForMaintenance);
				brand.setManagerRemarks(managerRemarks);
				brand.setCustomAtr1(customAtr1);
				brand.setCustomAtr2(customAtr2);
				brand.setCustomAtr3(customAtr3);
				brand.setCustomAtr4(customAtr4);
				brand.setCustomAtr5(customAtr5);
				brand.setCustomAtr6(customAtr6);
				brand.setCustomAtr7(customAtr7);
				brand.setCustomAtr8(customAtr8);
				brand.setCustomAtr9(customAtr9);
				brand.setCustomAtr10(customAtr10);
				brand.setIsActive(isActive);
				brand.setIpAddress(httpServletRequest.getRemoteAddr());
				brand.setCompanyId(themeDisplay.getCompanyId());
				brand.setModifiedDate(new Date());
				brand.setModifiedBy(themeDisplay.getUserId());
				
				//Updating brand
				updateBrand(actionRequest, themeDisplay, brand, isAdmin, isReviewer,brandApprovalStatus);

			} else {
				actionResponse.getRenderParameters().setValue("updateFailure", BrandViewPortletKeys.FAILURE);
				actionResponse.getRenderParameters().setValue(BrandViewPortletKeys.MVC_RENDER_COMMAND_NAME, BrandViewPortletKeys.UPDATE_BRAND_RENDER);
			}
		} catch (Exception e) {
			logger.error("Error while updating Brand : " + e.getMessage());
		}
	}
	
	//Updating Brand
	private void updateBrand(ActionRequest actionRequest, ThemeDisplay themeDisplay, Brand brand, boolean isAdmin, boolean isReviewer,String brandApprovalStatus) throws PortalException {
		//notifcation payload set up
		int status=1;
		long workflowTaskId = ParamUtil.getLong(actionRequest,"workflowId");
//		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
//				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
//		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
//		portletURLStep.setMVCRenderCommandName(BrandViewPortletKeys.UPDATE_BRAND_RENDER);
//		portletURLStep.setParameter(BrandViewPortletKeys.ASSET_CATEGORYID, String.valueOf(brand.getAssetCategoryId()));
//		portletURLStep.setParameter(BrandViewPortletKeys.BRAND_ID, String.valueOf(brand.getBrandId()));
//		
//		JSONObject payload = JSONFactoryUtil.createJSONObject();
//		payload.put(BrandViewPortletKeys.STATUS, brand.getBrandApprovalStatus());
//		payload.put(BrandViewPortletKeys.BRAND_ID, brand.getBrandId());
//		payload.put(BrandViewPortletKeys.TITLE, brand.getBrandName());
//		payload.put(BrandViewPortletKeys.URL, portletURLStep.buildPortletURL().toString());
//		
//		payload.put(BrandViewPortletKeys.SENDER, currentUser.getScreenName());
//		
		// fetching assigned user according to role
		User currentUser = themeDisplay.getUser(); 
		User assignUser = null;
		if(isAdmin) {
			assignUser = UserLocalServiceUtil.getUser(brand.getBrandReviewer());
		} else if(isReviewer) {
			assignUser = UserLocalServiceUtil.getUser(brand.getCreatedBy());
		}
		if(brandApprovalStatus.equalsIgnoreCase(BrandViewPortletKeys.REJECTED)) {
			status = 4;
			
		}else if(brandApprovalStatus.equalsIgnoreCase(BrandViewPortletKeys.APPROVED)) {
			status = 0;
		}else {
			status = 1;
		}
		
		
		//send notification
	//	SendNotificationToUserHandler.sendNotification(assignUser, payload);
		
		assetCategoryAddUpdateDelete(themeDisplay, brand.getBrandName(), brand.getBrandInactive(), brand.getBrandApprovalStatus(), brand);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);
		serviceContext.setAttribute("senderUserId", assignUser.getUserId());
		serviceContext.setAttribute("brandName", brand.getBrandName());
		serviceContext.setAttribute("brandStatus", brand.getBrandApprovalStatus());
		BrandLocalServiceUtil.updateBrand(brand);		
		BrandLocalServiceUtil.updateStatus(currentUser.getUserId(),brand.getBrandId(), status, serviceContext);
		try {
		if(brand.isApproved()) {
		brandCustomUtil.startWorkflowInstance(themeDisplay.getUserId(), brand, serviceContext);
		}else {
			
		WorkflowInstanceLink instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				brand.getCompanyId(), brand.getGroupId(), "com.marketplace.brand.model.Brand", brand.getBrandId());
		WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(brand.getCompanyId(),
				instanceLink.getWorkflowInstanceId());
		Map<String, Serializable> workflowcontext = instance.getWorkflowContext();
		workflowcontext.put("serviceContext", (Serializable) serviceContext);
		WorkflowTaskManagerUtil.completeWorkflowTask(brand.getCompanyId(), themeDisplay.getUserId(),
				workflowTaskId, brandApprovalStatus, "auto " + brandApprovalStatus, workflowcontext);
		}
		SessionMessages.add(actionRequest, "update-key");
		}catch(Exception e) {
			logger.error(e);
		}
	}
	
	// asset category add, edit and delete
	private void assetCategoryAddUpdateDelete(ThemeDisplay themeDisplay, String brandName, boolean brandInactive,
			String brandApprovalStatus, Brand brand) throws PortalException {
		Map<Locale, String> titleMap = new HashMap<>();
		titleMap.put(LocaleUtil.fromLanguageId("en_US"), brandName);
		String[] categoryProperties = {""};
		ServiceContext serviceContext = new ServiceContext();
		long parentCategoryId = 0;
		AssetCategory assetCategory = null;
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
				.getGroupVocabulary(themeDisplay.getCompanyGroupId(), BrandViewPortletKeys.BRAND_VOCABULARY);
		
		if(brandApprovalStatus.equalsIgnoreCase(BrandViewPortletKeys.APPROVED) && !brandInactive) {
			if(brand.getAssetCategoryId() == 0) {
				assetCategory = AssetCategoryLocalServiceUtil.addCategory("", themeDisplay.getUserId(),
						themeDisplay.getCompanyGroupId(), parentCategoryId, titleMap, new HashMap<Locale, String>(),
						assetVocabulary.getVocabularyId(), categoryProperties, serviceContext);
				brand.setAssetCategoryId(assetCategory.getCategoryId());
			} else {
				assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(brand.getAssetCategoryId());
				if(Validator.isNotNull(assetCategory)) {
					AssetCategoryLocalServiceUtil.updateCategory(themeDisplay.getUserId(), brand.getAssetCategoryId(), 
							parentCategoryId, titleMap, new HashMap<Locale, String>(), assetVocabulary.getVocabularyId(), 
							categoryProperties, serviceContext);
				}
			}
			
		} else if(brandInactive && brand.getAssetCategoryId() != 0) {
				AssetCategoryLocalServiceUtil.deleteAssetCategory(brand.getAssetCategoryId());
				brand.setAssetCategoryId(0);
			
		}
	}

	// brand category add and delete
	private void brandCategoryAddAndDelete(String[] categoryMaps, Brand brand) {
		List<BrandCategoryMap> brandCategoryMaps = BrandCategoryMapLocalServiceUtil
				.findByFBYBrandId(brand.getBrandId());
		for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
			BrandCategoryMapLocalServiceUtil.deleteBrandCategoryMap(brandCategoryMap).getBrandCategoryMapId();
		}
		
		for (String categoryId : categoryMaps) {
			long categorySize = CategoryLocalServiceUtil.countByparentCategoryIdStatus(Long.parseLong(categoryId), BrandViewPortletKeys.APPROVED);
			if(categorySize == 0) {
				BrandCategoryMap brandCategoryMap = BrandCategoryMapLocalServiceUtil
						.createBrandCategoryMap(CounterLocalServiceUtil.increment());
				brandCategoryMap.setBrandId(brand.getBrandId());
				brandCategoryMap.setCategoryId(Long.parseLong(categoryId));
				BrandCategoryMapLocalServiceUtil.addBrandCategoryMap(brandCategoryMap);
			}
		}
	}

	// file upload and setting up data
	private void uploadFileToBrandDocumentUpload(ActionRequest actionRequest, ThemeDisplay themeDisplay, Brand brand)
			throws PortalException {
		String documentUploads = fileUpload(themeDisplay, actionRequest, brand.getBrandId(), BrandViewPortletKeys.DOCUMENT_UPLOAD);
		if(!documentUploads.isEmpty()) {
			documentUploads = documentUploads.substring(0, documentUploads.length() - 2);
			for (String documentId : documentUploads.split("::")) {
				BrandDocumentUpload brandDocumentUpload = BrandDocumentUploadLocalServiceUtil
						.createBrandDocumentUpload(CounterLocalServiceUtil.increment());
				brandDocumentUpload.setBrandId(brand.getBrandId());
				brandDocumentUpload.setDocumentId(Long.parseLong(documentId));
				BrandDocumentUploadLocalServiceUtil.addBrandDocumentUpload(brandDocumentUpload);
			}
		}
	}
	
	// file upload method
	public static String fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, long brandId, String name) throws PortalException {

		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside fileUpload Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		Brand brand = null;
		long fileEntryId = 0;
		FileEntry dlFileEntry = null;
		if(name.equalsIgnoreCase("brandImageUpload")) {
			brand = BrandLocalServiceUtil.getBrand(brandId);
			fileEntryId = brand.getBrandImageUpload();
			if (Validator.isNotNull(fileEntryId)) {
				dlFileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
			}
		}
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();

		long mrfFolderId = DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Brand").getFolderId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		try {
			DLFolderServiceUtil
					.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()), mrfFolderId, String.valueOf(brandId))
					.getFolderId();
		} catch (PortalException e1) {
			logger.error("Exception in getting Folder of brandId : " + brandId);
			DLAppLocalServiceUtil.addFolder("",GetterUtil.getLong(themeDisplay.getUserId()),
					GetterUtil.getLong(themeDisplay.getScopeGroupId()), mrfFolderId, String.valueOf(brandId),
					String.valueOf(brandId) + " Folder", serviceContext);
		}
		
		String fileEntryLst = "";
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			if(file2.getKey().equalsIgnoreCase(name)) {
				FileItem[] item = file2.getValue();
				fileEntryLst = getFileEntries(item, dlFileEntry, themeDisplay, mrfFolderId, brandId, serviceContext);
				
			}
		}
		return fileEntryLst;
	}

	// Store all files one by one
	private static String getFileEntries(FileItem[] item, FileEntry dlFileEntry, ThemeDisplay themeDisplay, 
			long mrfFolderId, long brandId, ServiceContext serviceContext) {
		File file;
		String title = "";
		String description = "";
		StringBuilder fileEntryBuilder = new StringBuilder();
		for (FileItem fileItem : item) {
			if(fileItem.getFileName() != "") {
				title = fileItem.getFileName()+";;"+new Date().getTime();
				description = title + " is added via programatically";
				file = fileItem.getStoreLocation();
				try {
					FileEntry fileEntry = null;
					if(Validator.isNotNull(dlFileEntry) && fileItem.getFileName().equals(dlFileEntry.getFileName())) {
							return String.valueOf(dlFileEntry.getFileEntryId());
					}else {
						fileEntry = DLAppLocalServiceUtil.addFileEntry("", themeDisplay.getUserId(), 
								DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
										mrfFolderId, String.valueOf(brandId) + "").getRepositoryId(), 
								DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
										mrfFolderId, String.valueOf(brandId) + "").getFolderId(), 
								fileItem.getFileName(), "", title, "", description, "", file, 
								null, null, serviceContext);
						if(Validator.isNotNull(dlFileEntry)) {
							DLAppLocalServiceUtil.deleteFileEntry(dlFileEntry.getFileEntryId());
						}
					}
					fileEntryBuilder.append(fileEntry.getFileEntryId()).append("::");
				} catch (PortalException e) {
					logger.error("Exception in creating File : " + e.getMessage());
				} 
			}
		}
		return fileEntryBuilder.toString();
	}
	
	@Reference
	private BrandCustomUtil brandCustomUtil;
	
}
