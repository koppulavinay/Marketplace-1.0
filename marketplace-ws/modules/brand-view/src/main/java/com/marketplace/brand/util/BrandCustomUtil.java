package com.marketplace.brand.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.models.DocumentModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BrandCustomUtil.class)
public class BrandCustomUtil {

	public void updateAsset(long userId, Brand brand, long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority) throws PortalException {
		logger.info(":::: Brand Model ::::" + brand);
		boolean visible = true;
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, brand.getGroupId(), brand.getCreateDate(),
				brand.getModifiedDate(), Brand.class.getName(), brand.getBrandId(), brand.getUuid(), 0,
				assetCategoryIds, assetTagNames, true, visible, null, null, null, null, ContentTypes.TEXT_HTML,
				brand.getBrandName(), brand.getBrandDescription(), brand.getBrandDescription(), null, null, 0, 0,
				priority);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);

	}
	
	public Brand startWorkflowInstance(long userId, Brand brand, ServiceContext serviceContext)
			throws PortalException {

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = UserLocalServiceUtil.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		Map<String, Serializable> workflowContext = HashMapBuilder
				.<String, Serializable>put(WorkflowConstants.CONTEXT_URL, _getEntryURL(brand, serviceContext))
				.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL)
				.put(WorkflowConstants.CONTEXT_USER_URL, userURL).build();

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(brand.getCompanyId(), brand.getGroupId(), userId,
				Brand.class.getName(), brand.getBrandId(), brand, serviceContext, workflowContext);
	}
	
	private String _getEntryURL(Brand brand, ServiceContext serviceContext) throws PortalException {

		String entryURL = GetterUtil.getString(serviceContext.getAttribute("entryURL"));
		String portletId = PortletProviderUtil.getPortletId(BrandViewPortletKeys.BRANDVIEW, PortletProvider.Action.VIEW);
		HttpServletRequest httpServletRequest = serviceContext.getRequest();
		
		if (Validator.isNotNull(entryURL)) {
			return entryURL;
		}

		if (httpServletRequest == null) {
			return StringPool.BLANK;
		}

		if (Validator.isNotNull(portletId)) {
			String layoutURL = _portal.getLayoutFullURL(brand.getGroupId(), portletId);
			if (Validator.isNotNull(layoutURL)) {
				return StringBundler.concat(layoutURL, Portal.FRIENDLY_URL_SEPARATOR, "brand/", brand.getBrandId());
			}
		}

		portletId = PortletProviderUtil.getPortletId(BrandViewPortletKeys.BRANDVIEW, PortletProvider.Action.MANAGE);

		if (Validator.isNull(portletId) || (serviceContext.getThemeDisplay() == null)) {
			return StringPool.BLANK;
		}

		return PortletURLBuilder
				.create(_portal.getControlPanelPortletURL(httpServletRequest, portletId, PortletRequest.RENDER_PHASE))
				.setMVCRenderCommandName("/brand/view_brand").setParameter(BrandViewPortletKeys.BRAND_ID, brand.getBrandId()).buildString();
	}
	
	public boolean hasReviewerRoles(long userId) {
        List<Role> reviewerRole = RoleLocalServiceUtil.getUserRoles(userId);

        for (Role role : reviewerRole) {
            if (isReviewerRole(role)) {
                return true;
            }
        }
        return false;
    }
	
	// Checking empty and null
	public boolean emptyCheck(String parameterName) {
		boolean emptyCheckFlag = false;
		if(Validator.isNotNull(parameterName) || !parameterName.isEmpty()) {
			emptyCheckFlag = true;
		}
		
		return emptyCheckFlag;
	}
	
	public Boolean checkRegexValidation(String name) {
		Boolean regexFlag= false;
		String regex = "^[a-zA-Z0-9\\s]{1,255}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
        	regexFlag = true;
        }
		return regexFlag;
	}
	
    public Boolean checkRegexValidationForExtandCode(String name) {
		Boolean regexFlag= false;
		String regex = "^[a-zA-Z0-9]{0,255}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
	    	regexFlag = true;
	    }
		return regexFlag;
	}
	
    public Boolean checkRegexDessciptionAndReview(String name) {
		Boolean regexFlag= false;
		String regex = "^[!%&()_\\-\\[\\]'\";:.,/|a-zA-Z0-9\\s]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches() && name.length() <= 1000) {
			regexFlag = true;
		}
		return regexFlag;
	}
    
    
	public static List<DocumentModel> getBrandDocuments(List<BrandDocumentUpload> brandDocumentUploads, ThemeDisplay themeDisplay, 
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
    
    
	public static String getBrandCategories(List<BrandCategoryMap> brandCategoryMaps) {
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

    private boolean isReviewerRole(Role role) {
        return role.getName().equalsIgnoreCase(BrandViewPortletKeys.BRAND_REVIEWER);
    }
    
    private static final Log logger = LogFactoryUtil.getLog(BrandCustomUtil.class.getName());
    
	@Reference
	protected AssetEntryLocalService assetEntryLocalService;

	@Reference
	protected AssetLinkLocalService assetLinkLocalService;
	
	@Reference
	private Portal _portal;
	
}
