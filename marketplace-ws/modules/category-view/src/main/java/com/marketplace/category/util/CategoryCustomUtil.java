package com.marketplace.category.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
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
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = CategoryCustomUtil.class)
public class CategoryCustomUtil {
	
	private static final Log logger = LogFactoryUtil.getLog(CategoryCustomUtil.class.getName());

	public void updateAsset(long userId, Category category, long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority) throws PortalException {
		logger.info(":::: Category Model ::::" + category);
		boolean visible = true;
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, category.getGroupId(), category.getCreateDate(),
				category.getModifiedDate(), Category.class.getName(), category.getCategoryId(), category.getUuid(), 0,
				assetCategoryIds, assetTagNames, true, visible, null, null, null, null, ContentTypes.TEXT_HTML,
				category.getCategoryName(), category.getCategoryDescription(), category.getCategoryDescription(), null, null, 0, 0,
				priority);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);

	}
	
	public Category startWorkflowInstance(long userId, Category category, ServiceContext serviceContext)
			throws PortalException {

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;
		logger.info("Start work flow instance");
		if (serviceContext.getThemeDisplay() != null) {
			User user = UserLocalServiceUtil.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}
			
		Map<String, Serializable> workflowContext = HashMapBuilder
				.<String, Serializable>put(WorkflowConstants.CONTEXT_URL, _getEntryURL(category, serviceContext))
				.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL)
				.put(WorkflowConstants.CONTEXT_USER_URL, userURL).build();
		
		return WorkflowHandlerRegistryUtil.startWorkflowInstance(category.getCompanyId(), category.getGroupId(), userId,
				Category.class.getName(), category.getCategoryId(), category, serviceContext, workflowContext);
	}
	
	private String _getEntryURL(Category category, ServiceContext serviceContext) throws PortalException {

		String entryURL = GetterUtil.getString(serviceContext.getAttribute("entryURL"));
		String portletId = PortletProviderUtil.getPortletId(CategoryViewPortletKeys.CATEGORYVIEW, PortletProvider.Action.VIEW);
		HttpServletRequest httpServletRequest = serviceContext.getRequest();
		
		if (Validator.isNotNull(entryURL)) {
			return entryURL;
		}

		if (httpServletRequest == null) {
			return StringPool.BLANK;
		}

		if (Validator.isNotNull(portletId)) {
			String layoutURL = _portal.getLayoutFullURL(category.getGroupId(), portletId);
			if (Validator.isNotNull(layoutURL)) {
				return StringBundler.concat(layoutURL, Portal.FRIENDLY_URL_SEPARATOR, "category/", category.getCategoryId());
			}
		}

		portletId = PortletProviderUtil.getPortletId(CategoryViewPortletKeys.CATEGORYVIEW, PortletProvider.Action.MANAGE);

		if (Validator.isNull(portletId) || (serviceContext.getThemeDisplay() == null)) {
			return StringPool.BLANK;
		}

		return PortletURLBuilder
				.create(_portal.getControlPanelPortletURL(httpServletRequest, portletId, PortletRequest.RENDER_PHASE))
				.setMVCRenderCommandName("/category/view_category").setParameter(CategoryViewPortletKeys.CATEGORY_ID, category.getCategoryId()).buildString();
	}
	
	
	
	public static boolean hasManagerRoles(long userId) {
        List<Role> managerRole = RoleLocalServiceUtil.getUserRoles(userId);

        for (Role role : managerRole) {
            if (isManagerRole(role)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasReviewerRoles(long userId) {
        List<Role> reviewerRole = RoleLocalServiceUtil.getUserRoles(userId);

        for (Role role : reviewerRole) {
            if (isReviewerRole(role)) {
                return true;
            }
        }

        return false;
    }
    
    // Checking empty and null
 	public static boolean emptyCheck(String parameterName) {
 		boolean emptyCheckFlag = false;
 		if(Validator.isNotNull(parameterName) || !parameterName.isEmpty()) {
 			emptyCheckFlag = true;
 		}
 		
 		return emptyCheckFlag;
 	}
 	
    public static Date parseDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (Validator.isNotNull(dateString) && !dateString.equalsIgnoreCase("")) {
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                logger.error(e.getMessage());
            }
        }
        return null;
    }
    
    public static Boolean checkRegexValidation(String name) {
		Boolean regexFlag= false;
		String regex = "^[a-zA-Z0-9\\s]{1,255}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
	        if (matcher.matches()) {
	        	regexFlag = true;
	        }
		return regexFlag;
	}
	
    public static Boolean checkRegexValidationForExtandCode(String name) {
		Boolean regexFlag= false;
		String regex = "^[a-zA-Z0-9]{0,255}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
	        if (matcher.matches()) {
	        	regexFlag = true;
	        }
		return regexFlag;
	}
	
    public static Boolean checkRegexDescriptionAndReview(String name) {
		Boolean regexFlag= false;
		String regex = "^[!%&()_\\-\\[\\]'\";:.,/|a-zA-Z0-9\\s]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
	        if (matcher.matches() && name.length() <= 1000) {
	        	regexFlag = true;
	        }
		return regexFlag;
	}

    private static boolean isManagerRole(Role role) {
        return role.getName().equalsIgnoreCase(CategoryViewPortletKeys.MANAGER_ROLE);
    }
    
    private static boolean isReviewerRole(Role role) {
        return role.getName().equalsIgnoreCase(CategoryViewPortletKeys.REVIEWER_ROLE);
    }
    
    
    @Reference
	protected AssetEntryLocalService assetEntryLocalService;

	@Reference
	protected AssetLinkLocalService assetLinkLocalService;
	
	@Reference
	private Portal _portal;
	
}
