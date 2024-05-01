package com.marketplace.brand.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.brand.util.BrandCustomUtil;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=createBrand" }, service = MVCActionCommand.class)

public class CreateBrandActionCommand extends BaseMVCActionCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(CreateBrandActionCommand.class.getName());
	
	// create brand action method 
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateBrandActionCommand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		boolean isActive = true;
		List<Boolean> regexFlag = new ArrayList<>();
		
		Brand brand = BrandLocalServiceUtil.createBrand(CounterLocalServiceUtil.increment());
		
		// get brand data from jsp page
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
		boolean hasReviewerRoles = brandCustomUtil.hasReviewerRoles(brandReviewer);
		
		String brandType = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_TYPE);
		String brandApprovalStatus = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_APPROVAL_STATUS);
		String[] categoryMaps = ParamUtil.getStringValues(actionRequest, BrandViewPortletKeys.CATEGORYMAP);
		
		String externalReferenceId = ParamUtil.getString(actionRequest, BrandViewPortletKeys.BRAND_REFERENCEID);
		if(brandCustomUtil.emptyCheck(externalReferenceId)) {
			regexFlag.add(brandCustomUtil.checkRegexValidationForExtandCode(externalReferenceId));
		}
		
		boolean brandInactive = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.BRAND_INACTIVE);
		boolean downForSeller = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_SELLER);
		boolean downForBuyer = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_BUYER);
		boolean downForMaintenance = ParamUtil.getBoolean(actionRequest, BrandViewPortletKeys.DOWN_FOR_MAINTENANCE);
		
		String managerRemarks = ParamUtil.getString(actionRequest, BrandViewPortletKeys.MANAGER_REMARKS);
		if(brandCustomUtil.emptyCheck(managerRemarks)) {
			regexFlag.add(brandCustomUtil.checkRegexDessciptionAndReview(managerRemarks));
		}
		
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
		if(brandApprovalStatus.equalsIgnoreCase(BrandViewPortletKeys.PENDING) && hasReviewerRoles && !regexFlag.contains(false)) {
			// creating image url
			String brandImageURL = "";
			String dlFileEntryId = fileUpload(themeDisplay, actionRequest, brand.getBrandId(), BrandViewPortletKeys.IMAGE);
			logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "dlFileEntryId" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX + dlFileEntryId);
			if(!dlFileEntryId.isEmpty()) {
				dlFileEntryId = dlFileEntryId.substring(0, dlFileEntryId.length() - 2);
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(dlFileEntryId));
				brandImageURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
						+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
			} else {
				dlFileEntryId = "0";
			}
			
			// set brand data
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
			brand.setBrandImageUpload(Long.parseLong(dlFileEntryId));
			brand.setBrandImageURL(brandImageURL);
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
			brand.setGroupId(themeDisplay.getScopeGroupId());
			brand.setCompanyId(themeDisplay.getCompanyId());
			brand.setCreateDate(new Date());
			brand.setCreatedBy(themeDisplay.getUserId());
			brand.setModifiedDate(new Date());
			brand.setModifiedBy(themeDisplay.getUserId());
			brand.setStatus(WorkflowConstants.STATUS_PENDING);
			brand.setStatusByUserId(themeDisplay.getUserId());
			brand.setStatusDate(new Date());
			brand.setStatusByUserName(themeDisplay.getUser().getFullName());
			
			//category mapping
			brandCategoryAdd(categoryMaps, brand);
			
			//uploading file and fetch the id 
			uploadFileToBrandDocumentUpload(actionRequest, themeDisplay, brand);
			
			BrandLocalServiceUtil.addBrand(brand);
			
			//sending notification 
//			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
//					themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
//			PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
//			portletURLStep.setMVCRenderCommandName(BrandViewPortletKeys.UPDATE_BRAND_RENDER);
//			portletURLStep.setParameter(BrandViewPortletKeys.ASSET_CATEGORYID,String.valueOf(brand.getAssetCategoryId()));
//			portletURLStep.setParameter(BrandViewPortletKeys.BRAND_ID, String.valueOf(brand.getBrandId()));
//			
//			// setting payload for the notification
//			JSONObject payload = JSONFactoryUtil.createJSONObject();
//			payload.put(BrandViewPortletKeys.STATUS, "Pending");
//			payload.put(BrandViewPortletKeys.CREATED, "created the brand,");
//			payload.put(BrandViewPortletKeys.BRAND_ID, brand.getBrandId());
//			payload.put(BrandViewPortletKeys.TITLE, brandName);
//			payload.put(BrandViewPortletKeys.URL, portletURLStep.buildPortletURL().toString());
//			User currentUser = themeDisplay.getUser();
//			payload.put(BrandViewPortletKeys.SENDER, currentUser.getScreenName());
//			User managerUser = UserLocalServiceUtil.getUser(brand.getBrandReviewer());
//			
//			SendNotificationToUserHandler.sendNotification(managerUser, payload);
			SessionMessages.add(actionRequest, "success-key");
			
			//ResourceLocalServiceUtil.addResources(brand.getCompanyId(), brand.getGroupId(), brand.getCreatedBy(), Brand.class.getName(), brand.getBrandId(), false, true, true);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);
			serviceContext.setAttribute("senderUserId", brandReviewer);
			serviceContext.setAttribute("brandName", brand.getBrandName());
			serviceContext.setAttribute("brandStatus", brand.getBrandApprovalStatus());
			brandCustomUtil.updateAsset(brand.getCreatedBy(), brand, null, null, null, serviceContext.getAssetPriority());
			brandCustomUtil.startWorkflowInstance(brand.getCreatedBy(), brand, serviceContext);
		} else {
			actionResponse.getRenderParameters().setValue("createFailure", BrandViewPortletKeys.FAILURE);
			actionResponse.getRenderParameters().setValue(BrandViewPortletKeys.MVC_RENDER_COMMAND_NAME, BrandViewPortletKeys.CREATE_BRAND_RENDER);
		}
	}
	
	// brand category add
		private void brandCategoryAdd(String[] categoryMaps, Brand brand) {
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
			logger.info("documentUploads--> " + documentUploads);
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
	
	// upload file
	public static String fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, long brandId, String name) throws PortalException {

		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside fileUpload Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
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
			logger.info("key--> " + file2.getKey() + " name--> " + name);
			if(file2.getKey().equalsIgnoreCase(name)) {
				FileItem[] item = file2.getValue();
				fileEntryLst = getFileEntries(item, themeDisplay, mrfFolderId, brandId, serviceContext);
			}
		}
		
		return fileEntryLst;
	}
	
	// Store all files one by one
	private static String getFileEntries(FileItem[] item, ThemeDisplay themeDisplay, long mrfFolderId, 
			long brandId, ServiceContext serviceContext) {
		File file;
		String title ="";
		String description="";
		StringBuilder fileEntryBuilder = new StringBuilder();
		for (FileItem fileItem : item) {
			if(fileItem.getFileName() != "") {
				logger.info("fileItem--> " + fileItem.getFileName());
				title = fileItem.getFileName()+";;"+new Date().getTime();
				description = title + " is added via programatically";
				file = fileItem.getStoreLocation();
				try {
					FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry("", themeDisplay.getUserId(), 
							DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
									mrfFolderId, String.valueOf(brandId) + "").getRepositoryId(), 
							DLFolderServiceUtil.getFolder(GetterUtil.getLong(themeDisplay.getScopeGroupId()),
									mrfFolderId, String.valueOf(brandId) + "").getFolderId(), 
							fileItem.getFileName(), "", title, "", description, "", file, 
							null, null, serviceContext);
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
