package com.marketplace.category.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.InfoItemReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import com.liferay.portal.kernel.portlet.PortletLayoutFinderRegistryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryAssetRenderer extends BaseJSPAssetRenderer<Category> implements TrashRenderer {

	public static final String TYPE = "category";

	public CategoryAssetRenderer(Category categoryData, ResourceBundleLoader resourceBundleLoader) {
		_category = categoryData;
		_resourceBundleLoader = resourceBundleLoader;

	}

	@Override
	public String getClassName() {
		return Category.class.getName();
	}

	@Override
	public long getClassPK() {
		return _category.getCategoryId();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

		if (portletRequest != null) {
			abstractLength = GetterUtil.getInteger(portletRequest.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH),
					AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);
		}

		String summary = HtmlUtil.escape(_category.getCategoryDescription());

		if (Validator.isNull(summary)) {
			summary = StringUtil.shorten(HtmlUtil.stripHtml(_category.getCategoryName()), abstractLength);
		}

		return summary;
	}

	public String getPortletId() {
		AssetRendererFactory<Category> assetRendererFactory = getAssetRendererFactory();
		return assetRendererFactory.getPortletId();
	}

	
		@Override
		public PortletURL getURLEdit(HttpServletRequest httpServletRequest) throws PortalException {
			Group group = GroupLocalServiceUtil.fetchGroup(_category.getGroupId());
	
			if (group.isCompany()) {
				ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
				group = themeDisplay.getScopeGroup();
			}
//			PortletURL urlOfPortlet = PortalUtil.getControlPanelPortletURL(httpServletRequest, group,
//					CategoryViewPortletKeys.CATEGORYVIEW, 0, 0, PortletRequest.RENDER_PHASE);
//	
//			PortletURL urlOfEdit = PortletURLBuilder.create(urlOfPortlet).setMVCRenderCommandName("updateCategoryRender")
//					.setParameter(CategoryViewPortletKeys.CATEGORY_ID, _category.getCategoryId()).buildPortletURL();
	
			
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(_category.getGroupId(), true, "/category");
			PortletURL viewURL = PortletURLFactoryUtil.create(httpServletRequest, 
					"com_marketplace_category_CategoryViewPortlet", PortletRequest.RENDER_PHASE);
			PortletURLFactoryUtil.create(httpServletRequest, "com_marketplace_category_CategoryViewPortlet", layout, PortletRequest.RENDER_PHASE);
			PortletURLStep portletURLView = PortletURLBuilder.create(viewURL);
			portletURLView.setMVCRenderCommandName("updateCategoryRender");
			portletURLView.setParameter(CategoryViewPortletKeys.CATEGORY_ID, _category.getCategoryId());
			portletURLView.setParameter(CategoryViewPortletKeys.ASSET_CATEGORYID, _category.getAssetCategoryId());
			portletURLView.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, _category.getParentCategoryId());
			
			return portletURLView.buildPortletURL();
			//return urlOfEdit;
		}

		@Override
		public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
				LiferayPortletResponse liferayPortletResponse) throws PortalException {

			return getURLEdit(PortalUtil.getHttpServletRequest(liferayPortletRequest));
		}

	@Override
	public String getUrlTitle() {
		return _category.getCategoryName();
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {

		AssetRendererFactory<Category> assetRendererFactory = getAssetRendererFactory();

		return PortletURLBuilder.create(assetRendererFactory.getURLView(liferayPortletResponse, windowState))
				.setMVCRenderCommandName("updateCategoryRender")
				.setParameter(CategoryViewPortletKeys.CATEGORY_ID, _category.getCategoryId())
				.setWindowState(windowState).buildString();
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return getURLViewInContext(themeDisplay, noSuchEntryRedirect);
	}

	public String getURLViewInContext(ThemeDisplay themeDisplay, String noSuchEntryRedirect) throws PortalException {

		if (_assetDisplayPageFriendlyURLProvider != null) {
			String friendlyURL = _assetDisplayPageFriendlyURLProvider.getFriendlyURL(
					new InfoItemReference(getClassName(), new ClassPKInfoItemIdentifier(getClassPK())), themeDisplay);

			if (Validator.isNotNull(friendlyURL)) {
				return friendlyURL;
			}
		}

		if (!_hasViewInContextGroupLayout(_category.getGroupId(), themeDisplay)) {
			return null;
		}

		return getURLViewInContext(themeDisplay, noSuchEntryRedirect, "updateCategoryRender",
				CategoryViewPortletKeys.CATEGORY_ID, _category.getCategoryId());
	}

	public void setAssetDisplayPageFriendlyURLProvider(
			AssetDisplayPageFriendlyURLProvider assetDisplayPageFriendlyURLProvider) {

		_assetDisplayPageFriendlyURLProvider = assetDisplayPageFriendlyURLProvider;
	}

	private boolean _hasViewInContextGroupLayout(long groupId, ThemeDisplay themeDisplay) {

		try {
			PortletLayoutFinder portletLayoutFinder = PortletLayoutFinderRegistryUtil
					.getPortletLayoutFinder(Category.class.getName());

			PortletLayoutFinder.Result result = portletLayoutFinder.find(themeDisplay, groupId);

			if ((result == null) || Validator.isNull(result.getPortletId())) {
				return false;
			}

			return true;
		} catch (PortalException portalException) {
			if (logger.isDebugEnabled()) {
				logger.debug(portalException);
			}

			return false;
		}
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {
		//return CategoryModelPermission.contains(permissionChecker, _category, "UPDATE_CATEGORY");
		return true;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {
		return true;
				//CategoryModelPermission.contains(permissionChecker, _category, "VIEW_CATEGORY");
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		logger.info("template--> " + template);
		httpServletRequest.setAttribute("CATEGORY", _category);

		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String getTitle(Locale locale) {

		return _category.getCategoryName();
	}

	@Override
	public Category getAssetObject() {

		return _category;
	}

	@Override
	public long getGroupId() {

		return _category.getGroupId();
	}

	@Override
	public long getUserId() {

		return _category.getCreatedBy();
	}

	@Override
	public String getUserName() {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(_category.getCreatedBy());
		} catch (PortalException e) {
			logger.error("User not found :: " + e.getMessage());
		}
		return user.getFullName();
	}

	@Override
	public String getUuid() {
		return _category.getUuid();
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {

		if (template.equals(TEMPLATE_ABSTRACT) || template.equals(TEMPLATE_FULL_CONTENT)) {
			return "/" + template + ".jsp";
		}

		return null;
	}

	@Override
	public int getStatus() {
		return _category.getStatus();
	}

	private static final Log logger = LogFactoryUtil.getLog(CategoryAssetRenderer.class);
	private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;
	private final Category _category;
	private final ResourceBundleLoader _resourceBundleLoader;

}
