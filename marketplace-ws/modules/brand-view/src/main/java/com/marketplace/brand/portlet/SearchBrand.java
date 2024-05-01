package com.marketplace.brand.portlet;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.brand.constants.BrandViewPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
"mvc.command.name=searchBrand" }, service = MVCActionCommand.class)

// search brand fetch the key word and redirect to main portlet
public class SearchBrand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		// fetching search key word and redirecting mainportlet
		String search = ParamUtil.getString(actionRequest, BrandViewPortletKeys.SEARCH);
		String status = ParamUtil.getString(actionRequest, BrandViewPortletKeys.STATUS);
		String activeStatus = ParamUtil.getString(actionRequest, BrandViewPortletKeys.ACTIVE_STATUS);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
		portletURLStep.setParameter(BrandViewPortletKeys.SEARCH, search);
		portletURLStep.setParameter(BrandViewPortletKeys.STATUS, status);
		portletURLStep.setParameter(BrandViewPortletKeys.ACTIVE_STATUS, activeStatus);
        actionResponse.sendRedirect(portletURLStep.buildPortletURL().toString());
	}

}
