package com.marketplace.category.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Portal;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW }, service = AssetRendererFactory.class)
public class CategoryAssetRendererFactory extends BaseAssetRendererFactory<Category> {


	public static final String TYPE = "category";

	public CategoryAssetRendererFactory() {
		setClassName(Category.class.getName());
		setLinkable(true);
		setPortletId(CategoryViewPortletKeys.CATEGORYVIEW);
		setSearchable(true);
	    setCategorizable(true);
	    setSelectable(true);

	}

	@Override
	public AssetRenderer<Category> getAssetRenderer(long classPK, int type) throws PortalException {
		CategoryAssetRenderer brandAssetRenderer = new CategoryAssetRenderer(categoryLocalService.getCategory(classPK),
				ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

		brandAssetRenderer.setAssetDisplayPageFriendlyURLProvider(_assetDisplayPageFriendlyURLProvider);
		brandAssetRenderer.setAssetRendererType(type);
		brandAssetRenderer.setServletContext(_servletContext);

		return brandAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Category.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long classTypeId) {

		return PortletURLBuilder
				.create(_portal.getControlPanelPortletURL(liferayPortletRequest, getGroup(liferayPortletRequest),
						CategoryViewPortletKeys.CATEGORYVIEW, 0, 0, PortletRequest.RENDER_PHASE))
				.setMVCRenderCommandName("updateCategoryRender").buildPortletURL();
	}

	@Override
	public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {

		LiferayPortletURL liferayPortletURL = liferayPortletResponse.createLiferayPortletURL(CategoryViewPortletKeys.CATEGORYVIEW,
				PortletRequest.RENDER_PHASE);

		try {
			liferayPortletURL.setWindowState(windowState);
		} catch (WindowStateException windowStateException) {
			if (logger.isDebugEnabled()) {
				logger.debug(windowStateException);
			}
		}

		return liferayPortletURL;
	}

	@Override
	public boolean hasAddPermission(PermissionChecker permissionChecker, long groupId, long classTypeId) {
		return true;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
		return true;
	}

	private static final Log logger = LogFactoryUtil.getLog(CategoryAssetRendererFactory.class);

	@Reference
	private Portal _portal;

	@Reference
	private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;

	@Reference
	private CategoryLocalService categoryLocalService;

	@Reference(target = "(osgi.web.symbolicname=com.marketplace.category.view)")
	private ServletContext _servletContext;

}
