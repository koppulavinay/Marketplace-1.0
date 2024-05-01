package com.marketplace.product.inventory.management.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class DashboardManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

	public DashboardManagementToolbarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest request) {
		 super(request,liferayPortletRequest, liferayPortletResponse);
			
	}

	/*
	 * @Override protected String getOrderByCol() { return
	 * ParamUtil.getString(request, "orderByCol",
	 * ComMaxlifeCsaWorkflowWebPortletKeys.CreateDate); }
	 * 
	 * protected String getOrderByType() { return ParamUtil.getString(request,
	 * "orderByType", "asc"); }
	 */

	@Override
	public String getSearchActionURL() {
		PortletURL searchURL = liferayPortletResponse.createRenderURL();
		
		PortletURLStep portletURLStep = PortletURLBuilder.create(searchURL);
		
		String navigation = ParamUtil.getString(httpServletRequest, "dashboardEntries");
			portletURLStep.setMVCRenderCommandName("viewUrl");
			portletURLStep.setNavigation(navigation);
			portletURLStep.setParameter("orderByCol", getOrderByCol());
			portletURLStep.setParameter("orderByType", getOrderByType());
		return portletURLStep.buildPortletURL().toString();
	}

	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

				/*
				 * add(dropdownItem -> {
				 * dropdownItem.setActive(ComMaxlifeCsaWorkflowWebPortletKeys.CreateDate.equals(
				 * getOrderByCol())); try { dropdownItem.setHref(_getCurrentSortingURL(),
				 * "orderByCol", ComMaxlifeCsaWorkflowWebPortletKeys.CreateDate); } catch
				 * (PortletException e) { log.error("error in getting dropdown item value: " +
				 * e); } dropdownItem.setLabel(LanguageUtil.get(themeDisplay.getRequest(),
				 * "Create Date")); }); add(dropdownItem -> {
				 * dropdownItem.setActive(ComMaxlifeCsaWorkflowWebPortletKeys.ActionReportId.
				 * equals(getOrderByCol())); try { dropdownItem.setHref(_getCurrentSortingURL(),
				 * "orderByCol", ComMaxlifeCsaWorkflowWebPortletKeys.ActionReportId); } catch
				 * (PortletException e) { log.error("error in getting dropdown item value: " +
				 * e); } dropdownItem.setLabel(LanguageUtil.get(themeDisplay.getRequest(),
				 * "S.No.")); });
				 */
			}
		};
	}

	/*
	 * private PortletURL _getCurrentSortingURL() throws PortletException {
	 * PortletURL sortingURL = PortletURLUtil.clone(currentURLObj,
	 * liferayPortletResponse); sortingURL.setParameter("javax.portlet.name",
	 * ComMaxlifeCsaWorkflowWebPortletKeys.COMMAXLIFECSAWORKFLOWWEB);
	 * sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0"); String
	 * ActionReportId = ParamUtil.getString(request,
	 * ComMaxlifeCsaWorkflowWebPortletKeys.ActionReportId); if
	 * (Validator.isNotNull(ActionReportId)) {
	 * sortingURL.setParameter(ComMaxlifeCsaWorkflowWebPortletKeys.ActionReportId,
	 * ActionReportId); } return sortingURL; }
	 */
	
	
	

	@Override
	public String getClearResultsURL() {
		
		
		return PortletURLBuilder.create(
			getPortletURL()
		).setKeywords(
			StringPool.BLANK
		).buildString();
	}




	Log log = LogFactoryUtil.getLog(DashboardManagementToolbarDisplayContext.class);
}

