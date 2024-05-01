package com.marketplace.brand.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.service.LayoutLocalizationLocalServiceUtil;
import com.liferay.petra.string.StringPool;
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
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.models.DocumentModel;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Reference;

public class BrandAssetRenderer extends BaseJSPAssetRenderer<Brand> {

	public BrandAssetRenderer(Brand brandData, ResourceBundleLoader resourceBundleLoader) {
		brand = brandData;
	}

	@Override
	public String getClassName() {
		return Brand.class.getName();
	}

	@Override
	public long getClassPK() {
		return brand.getBrandId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

		if (portletRequest != null) {
			abstractLength = GetterUtil.getInteger(portletRequest.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH),
					AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);
		}

		String summary = HtmlUtil.escape(brand.getBrandDescription());

		if (Validator.isNull(summary)) {
			summary = StringUtil.shorten(HtmlUtil.stripHtml(brand.getBrandName()), abstractLength);
		}

		return summary;
	}

	@Override
	public PortletURL getURLEdit(HttpServletRequest httpServletRequest) throws PortalException {
		Group group = GroupLocalServiceUtil.fetchGroup(brand.getGroupId());
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (group.isCompany()) {
			
			group = themeDisplay.getScopeGroup();
		}

//		return PortletURLBuilder
//				.create(PortalUtil.getControlPanelPortletURL(httpServletRequest, group, BrandViewPortletKeys.BRANDVIEW, 0, 0,
//						PortletRequest.RENDER_PHASE))
//				.setMVCRenderCommandName("updateBrandRender").setParameter(BrandViewPortletKeys.BRAND_ID, brand.getBrandId())
//				.buildPortletURL();
//		
		themeDisplay.setScopeGroupId(brand.getGroupId());
		
		Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(brand.getGroupId(), true, "/brand");
		PortletURL viewURL = PortletURLFactoryUtil.create(httpServletRequest, "com_marketplace_brand_BrandViewPortlet", layout, PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLView = PortletURLBuilder.create(viewURL);
		portletURLView.setMVCRenderCommandName("updateBrandRender");
		portletURLView.setParameter(BrandViewPortletKeys.BRAND_ID, brand.getBrandId());
		
		return portletURLView.buildPortletURL();
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws PortalException {

		return getURLEdit(PortalUtil.getHttpServletRequest(liferayPortletRequest));
	}

	@Override
	public String getUrlTitle() {
		return brand.getBrandName();
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		
	   

		AssetRendererFactory<Brand> assetRendererFactory = getAssetRendererFactory();
		
		return PortletURLBuilder.create(assetRendererFactory.getURLView(liferayPortletResponse, windowState))
				.setMVCRenderCommandName("updateBrandRender").setParameter(BrandViewPortletKeys.BRAND_ID, brand.getBrandId())
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

		if (!_hasViewInContextGroupLayout(brand.getGroupId(), themeDisplay)) {
			return null;
		}

		return getURLViewInContext(themeDisplay, noSuchEntryRedirect, "updateBrandRender", BrandViewPortletKeys.BRAND_ID,
				brand.getBrandId());
	}

	public void setAssetDisplayPageFriendlyURLProvider(
			AssetDisplayPageFriendlyURLProvider assetDisplayPageFriendlyURLProvider) {

		_assetDisplayPageFriendlyURLProvider = assetDisplayPageFriendlyURLProvider;
	}

	private boolean _hasViewInContextGroupLayout(long groupId, ThemeDisplay themeDisplay) {

		try {
			PortletLayoutFinder portletLayoutFinder = PortletLayoutFinderRegistryUtil
					.getPortletLayoutFinder(Brand.class.getName());

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

		return true;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {

		return true;
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		logger.info("template--> " + template);
		httpServletRequest.setAttribute("BRAND", brand);

		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String getTitle(Locale locale) {

		return brand.getBrandName();
	}

	@Override
	public Brand getAssetObject() {

		return brand;
	}

	@Override
	public long getGroupId() {

		return brand.getGroupId();
	}

	@Override
	public long getUserId() {

		return brand.getCreatedBy();
	}

	@Override
	public String getUserName() {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(brand.getCreatedBy());
		} catch (PortalException e) {
			logger.error("User not found :: " + e.getMessage());
		}
		return user.getFullName();
	}

	@Override
	public String getUuid() {
		return brand.getUuid();
	}

	
	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {

		if (template.equals(TEMPLATE_ABSTRACT) || template.equals(TEMPLATE_FULL_CONTENT)) {
			return StringPool.FORWARD_SLASH + template + ".jsp";
		}

		return null;
	}

	@Override
	public int getStatus() {
		return brand.getStatus();
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
	
	
	private static final Log logger = LogFactoryUtil.getLog(BrandAssetRenderer.class);
	private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;
	private final Brand brand;

	@Reference
	private LayoutLocalService layoutLocalService;
}

