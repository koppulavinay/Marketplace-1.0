package com.marketplace.category.listing.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.category.listing.constants.BuycorpCategoryListingPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BuycorpCategoryListingPortletKeys.BUYCORPCATEGORYLISTING,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=searchCategory" }, service = MVCActionCommand.class)

public class BuycorpSearchActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(BuycorpSearchActionCommand.class.getName());
	
	// fetching search keyword and redirect to main portlet 
	// this is action method
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		LOGGER.info(BuycorpCategoryListingPortletKeys.LOGGER_INFO_PREFIX + "Inside SearchCategory Method" + BuycorpCategoryListingPortletKeys.LOGGER_INFO_SUFFIX);
		String parentCategoryId = ParamUtil.getString(actionRequest, BuycorpCategoryListingPortletKeys.PARENT_CATEGORYID);
		String search = ParamUtil.getString(actionRequest, BuycorpCategoryListingPortletKeys.SEARCH);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
		portletURLStep.setParameter(BuycorpCategoryListingPortletKeys.PARENT_CATEGORYID, parentCategoryId);
		portletURLStep.setParameter(BuycorpCategoryListingPortletKeys.SEARCH, search);

		actionResponse.sendRedirect(portletURLStep.buildPortletURL().toString());
	}

}
