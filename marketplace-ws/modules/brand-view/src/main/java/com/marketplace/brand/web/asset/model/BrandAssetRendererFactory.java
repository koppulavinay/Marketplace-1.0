package com.marketplace.brand.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {	
	"javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW
	},		
	service = AssetRendererFactory.class
)
public class BrandAssetRendererFactory extends BaseAssetRendererFactory<Brand> {

	public static final String TYPE = "brand";

	public BrandAssetRendererFactory() {
		setClassName(Brand.class.getName());
		setLinkable(true);
		setPortletId(BrandViewPortletKeys.BRANDVIEW);
		setSearchable(true);
	    setCategorizable(true);
	    setSelectable(true);

	}

	@Override
	public AssetRenderer<Brand> getAssetRenderer(long classPK, int type) throws PortalException {
		BrandAssetRenderer brandAssetRenderer = new BrandAssetRenderer(brandLocalService.getBrand(classPK),
				ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

		brandAssetRenderer.setAssetDisplayPageFriendlyURLProvider(_assetDisplayPageFriendlyURLProvider);
		brandAssetRenderer.setAssetRendererType(type);
		brandAssetRenderer.setServletContext(_servletContext);

		return brandAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Brand.class.getName();
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
						BrandViewPortletKeys.BRANDVIEW, 0, 0, PortletRequest.RENDER_PHASE))
				.setMVCRenderCommandName("updateBrandRender").buildPortletURL();

		
	
	
	
	}

	@Override
	public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {

		LiferayPortletURL liferayPortletURL = liferayPortletResponse.createLiferayPortletURL(BrandViewPortletKeys.BRANDVIEW,
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

	private static final Log logger = LogFactoryUtil.getLog(BrandAssetRendererFactory.class);

	@Reference
	private Portal _portal;

	@Reference
	private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;

	@Reference
	private BrandLocalService brandLocalService;

	@Reference(target = "(osgi.web.symbolicname=com.marketplace.brand.view)")
	private ServletContext _servletContext;
	
	

	@Reference
	private LayoutLocalService layoutLocalService;

}

