package com.marketplace.category.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.servlet.taglib.ui.BreadcrumbEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

public class BreadCrumbUtil {

	public static List<BreadcrumbEntry> getAssetCategoriesBreadcrumbEntries(long categoryId,
			HttpServletRequest httpServletRequest, RenderResponse renderResponse) throws PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (categoryId == 0) {
			return Collections.emptyList();
		}
		//create list and add title and it url to the list 
		Category category = CategoryLocalServiceUtil.getCategory(categoryId);
		List<BreadcrumbEntry> breadcrumbEntries = new ArrayList<>();
		BreadcrumbEntry vocabularyBreadcrumbEntry = new BreadcrumbEntry();
		vocabularyBreadcrumbEntry.setTitle(CategoryViewPortletKeys.BREADCUMB_VOCABULARY);
		PortletURL portletURL = PortletURLBuilder.createRenderURL(renderResponse).setMVCRenderCommandName(CategoryViewPortletKeys.VIEW_URL)
				.setNavigation(() -> {
					String navigation = ParamUtil.getString(httpServletRequest, CategoryViewPortletKeys.NAVIGATION);

					if (Validator.isNotNull(navigation)) {
						return navigation;
					}
					return null;
				}).buildPortletURL();

		vocabularyBreadcrumbEntry.setURL(portletURL.toString());

		breadcrumbEntries.add(vocabularyBreadcrumbEntry);

		String treePath = category.getTreePath();
		String[] categoryIds = treePath.split("/");
		
	//fetching parent category object
		for (String categoryid : categoryIds) {
			BreadcrumbEntry categoryBreadcrumbEntry = new BreadcrumbEntry();
			if (!categoryid.isEmpty()) {
				long id = Long.parseLong(categoryid);
				Category categoryObj = CategoryLocalServiceUtil.fetchCategory(id);
				categoryBreadcrumbEntry.setTitle(categoryObj.getCategoryName());
				
				PortletURL portletURL1 = PortletURLFactoryUtil.create(httpServletRequest, 
						themeDisplay.getPortletDisplay().getId(), PortletRequest.RENDER_PHASE);
				PortletURLStep portletURLStep = PortletURLBuilder.create(portletURL1);
				
				portletURLStep.setParameter(CategoryViewPortletKeys.PARENT_CATEGORYID, String.valueOf(categoryObj.getCategoryId()));
				categoryBreadcrumbEntry.setURL(portletURL1.toString());
				breadcrumbEntries.add(categoryBreadcrumbEntry);
			}
		}
		return breadcrumbEntries;
	}
}
