package com.marketplace.category.portlet;

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
import com.marketplace.category.constants.CategoryViewPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=searchCategory" }, service = MVCActionCommand.class)

public class SearchCategoryActionCommand extends BaseMVCActionCommand {

	private static final Log logger = LogFactoryUtil.getLog(SearchCategoryActionCommand.class.getName());
	
	// fetching search keyword and redirect to main portlet 
	// this is action method
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SearchCategory Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		String parentCategoryId = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		String search = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.SEARCH);
		String status = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.STATUS);
		String activeStatus = ParamUtil.getString(actionRequest, CategoryViewPortletKeys.ACTIVE_STATUS);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, 
				themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
		PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL);
		portletURLStep.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, parentCategoryId);
		portletURLStep.setParameter(CategoryViewPortletKeys.SEARCH, search);
		portletURLStep.setParameter(CategoryViewPortletKeys.STATUS, status);
		portletURLStep.setParameter(CategoryViewPortletKeys.ACTIVE_STATUS, activeStatus);

		actionResponse.sendRedirect(portletURLStep.buildPortletURL().toString());
	}

}
