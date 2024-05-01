package com.marketplace.product.listing.detail.portlet;

import com.liferay.account.model.AccountEntry;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.render.CPContentRenderer;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CProductLocalServiceUtil;
import com.liferay.commerce.product.type.simple.constants.SimpleCPTypeConstants;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
			"commerce.product.content.renderer.key=buycorp",
			"commerce.product.content.renderer.order=1",
			"commerce.product.content.renderer.type=" + SimpleCPTypeConstants.NAME
		},
		service = CPContentRenderer.class
	)

public class ProductDetailContentRenderer implements CPContentRenderer {

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "buycorp";
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return LanguageUtil.get(
				resourceBundle, "buycorp-renderer");
	}

	@Override
	public void render(CPCatalogEntry cpCatalogEntry, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		httpServletRequest.setAttribute("isLoggedUser", themeDisplay.isSignedIn());

		//log.info("CPCatalogEntry :::: " + cpCatalogEntry.getCProductId());
		CProduct cProduct = CProductLocalServiceUtil.getCProduct(cpCatalogEntry.getCProductId());
		User user = UserLocalServiceUtil.getUser(cProduct.getUserId());
		String imagePath = UserConstants.getPortraitURL(user.fetchPortraitURL(themeDisplay), user.isMale(), user.getPortraitId(), user.getUuid());
		CommerceContext commerceContext = (CommerceContext)httpServletRequest.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
		AccountEntry accountEntry = commerceContext.getAccountEntry();
		long accountEntryId = accountEntry.getAccountEntryId();
		List<Address> addressList = AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(),  Contact.class.getName(), user.getContactId());
		for(Address address: addressList) {
			if(address.getPrimary()) {
				 httpServletRequest.setAttribute("shippingAddressCity", address.getCity());
				 httpServletRequest.setAttribute("shippingAddressCountry", address.getCountry().getName());
				 break; 
			}
		}
		
		httpServletRequest.setAttribute("imagePath",imagePath);
		httpServletRequest.setAttribute("vendorName", user.getFullName());
		httpServletRequest.setAttribute("commerceAccountId", accountEntryId);
		
		_jspRenderer.renderJSP(
				_servletContext, httpServletRequest, httpServletResponse,
				"/product_detail_render/product_detail.jsp");
		
	}
	
	@Reference
	private JSPRenderer _jspRenderer;
	
	@Reference(target = "(osgi.web.symbolicname=com.marketplace.product.listing.detail)")
	private ServletContext _servletContext;

}
