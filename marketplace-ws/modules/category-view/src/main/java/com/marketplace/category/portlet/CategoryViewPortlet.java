package com.marketplace.category.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Category View", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CategoryViewPortlet extends MVCPortlet {

	private static final Log logger = LogFactoryUtil.getLog(CategoryViewPortlet.class.getName());
	
	// main portlet where table view is shown data, search , filter results 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CategoryViewPortlet" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		int delta = ParamUtil.getInteger(renderRequest, CategoryViewPortletKeys.DELTA);
		int cur = ParamUtil.getInteger(renderRequest, CategoryViewPortletKeys.CUR);
		int from = delta * (cur - 1);
		int to = delta == 0 ? 10 : delta * cur;
		String parentCategoryEntryId = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.PARENT_CATEGORYID);
		String assetCategoryEntryId = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.ASSET_CATEGORYID);
		String search = ParamUtil.get(renderRequest, CategoryViewPortletKeys.SEARCH, "");
		String status = ParamUtil.get(renderRequest, CategoryViewPortletKeys.STATUS, "");
		String activeStatus = ParamUtil.get(renderRequest, CategoryViewPortletKeys.ACTIVE_STATUS, "");
		String orderByCol = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.ORDER_BY_COL);
		String orderByType = ParamUtil.getString(renderRequest, CategoryViewPortletKeys.ORDER_BY_TYPE);
		
		long parentCategoryId = 0L;
		long assetCategoryId = 0L;
		String roleName = "";
		
		if (!parentCategoryEntryId.isEmpty()) {
			parentCategoryId = Long.parseLong(parentCategoryEntryId);
		}
		if (!assetCategoryEntryId.isEmpty()) {
			assetCategoryId = Long.parseLong(assetCategoryEntryId);
		}

		long roleAdminId = 0L;
		long roleOwnerId = 0L;
		long roleManagerId = 0L;
		long roleReviewerId = 0L;
		List<Category> counter = null;
		
		//fetching roles
		try {
			roleAdminId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.ADMIN_ROLE).getRoleId();
			roleManagerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.MANAGER_ROLE).getRoleId();
			roleReviewerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.REVIEWER_ROLE).getRoleId();
			roleOwnerId = RoleLocalServiceUtil.getRole(companyId, CategoryViewPortletKeys.ADMINISTRATOR_ROLE).getRoleId();

		} catch (PortalException e) {
			logger.error("Error fetching in role : " + e.getMessage());
		}
		
		
		// finding the user with role
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		final long roleAdmin = roleAdminId;
		final long roleOwner = roleOwnerId;
		final long roleManager = roleManagerId;
		final long roleReviewer = roleReviewerId;
		boolean isOwner = roles.stream().anyMatch(role -> role.getRoleId() == roleOwner);
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getRoleId() == roleAdmin);
		boolean isManager = roles.stream().anyMatch(role -> role.getRoleId() == roleManager);
		boolean isReviewer = roles.stream().anyMatch(role -> role.getRoleId() == roleReviewer);

		if (isAdministrator) {
		    roleName = CategoryViewPortletKeys.ADMIN_ROLE;
		} else if (isManager) {
		    roleName = CategoryViewPortletKeys.MANAGER_ROLE;
		} else if (isReviewer) {
		    roleName = CategoryViewPortletKeys.REVIEWER_ROLE;
		}else if(isOwner) {
			isAdministrator=true;
			roleName=CategoryViewPortletKeys.ADMINISTRATOR_ROLE;
		}

		
		//create a column according to the user
		String userColumns = extractedUserColumn(isAdministrator, isManager, isReviewer);
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put(CategoryViewPortletKeys.SEARCH, search);
		parameters.put(CategoryViewPortletKeys.STATUS, status);
		parameters.put(CategoryViewPortletKeys.ACTIVE_STATUS, activeStatus);
		parameters.put(CategoryViewPortletKeys.ORDER_BY_COL, orderByCol);
		parameters.put(CategoryViewPortletKeys.ORDER_BY_TYPE, orderByType);
		parameters.put(CategoryViewPortletKeys.USER_COLUMNS, userColumns);
		
		// initializing the dynamic query
		DynamicQuery dynamicQuery = fetchResultUsingDynamicQuery(themeDisplay, parameters,
				parentCategoryId, isAdministrator, isReviewer);
	
		counter = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		List<Category> myCategories = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery, from, to);
			
		Category category =null;
		if(parentCategoryId != 0) {
			 category = CategoryLocalServiceUtil.fetchCategory(parentCategoryId);
			renderRequest.setAttribute(CategoryViewPortletKeys.CATEGORY_ID, category.getCategoryId());
		}else {
			renderRequest.setAttribute(CategoryViewPortletKeys.CATEGORY_ID, 0L);
		}
		
		renderRequest.setAttribute(CategoryViewPortletKeys.MY_CATEGORIES, myCategories);
		renderRequest.setAttribute(CategoryViewPortletKeys.PARENT_CATEGORYID, parentCategoryId);
		renderRequest.setAttribute(CategoryViewPortletKeys.COUNT, counter.size());
		renderRequest.setAttribute(CategoryViewPortletKeys.ROLE_NAME, roleName);
		renderRequest.setAttribute(CategoryViewPortletKeys.ASSET_CATEGORYID, assetCategoryId);
		renderRequest.setAttribute(CategoryViewPortletKeys.SEARCH, search);
		renderRequest.setAttribute(CategoryViewPortletKeys.STATUS, status);
		renderRequest.setAttribute(CategoryViewPortletKeys.ACTIVE_STATUS, activeStatus);
		renderRequest.setAttribute(CategoryViewPortletKeys.ADMINISTRATOR_ROLE, isAdministrator);
		renderRequest.setAttribute(CategoryViewPortletKeys.MANAGER, isManager);
		renderRequest.setAttribute(CategoryViewPortletKeys.REVIEWER, isReviewer);
		renderRequest.setAttribute(CategoryViewPortletKeys.CUR, cur);
		renderRequest.setAttribute(CategoryViewPortletKeys.FROM, from);
		renderRequest.setAttribute(CategoryViewPortletKeys.TO, to);

		super.render(renderRequest, renderResponse);
	}

	
	// fetch dynamic query result 
	private DynamicQuery fetchResultUsingDynamicQuery(ThemeDisplay themeDisplay, Map<String,String> parameters, long parentCategoryId, 
			Boolean administrator, Boolean reviewer) {
		
		String search = parameters.get(CategoryViewPortletKeys.SEARCH);
		String userColumns = parameters.get(CategoryViewPortletKeys.USER_COLUMNS);
		String status = parameters.get(CategoryViewPortletKeys.STATUS);
		String activeStatus = parameters.get(CategoryViewPortletKeys.ACTIVE_STATUS);
		String orderByCol=parameters.get(CategoryViewPortletKeys.ORDER_BY_COL);
		String orderByType = parameters.get(CategoryViewPortletKeys.ORDER_BY_TYPE);
		DynamicQuery dynamicQuery = CategoryLocalServiceUtil.dynamicQuery();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		
		// only for cateogory roles
		if (reviewer) {
			dynamicQuery.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.CATEGORY_APPROVAL_STATUS).ne(CategoryViewPortletKeys.PENDING));
		}

		if (!administrator) {
			dynamicQuery.add(PropertyFactoryUtil.forName(userColumns).eq(themeDisplay.getUserId()));
		}

		if(parentCategoryId != 0) {
			dynamicQuery.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.PARENT_CATEGORYID).eq(parentCategoryId));
		}
		
		dynamicQuery.addOrder(orderByColSorting(orderByCol, orderByType));
		
		//filter 
		if(!search.isEmpty() && (!status.isEmpty() || !activeStatus.isEmpty())){
			if(!activeStatus.isEmpty()) {
				Boolean activeStatusBool = Boolean.parseBoolean(activeStatus);
				dynamicQuery.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.CATEGORY_ACTIVE).eq(activeStatusBool));
			}
			
			if(!status.isEmpty()) {
				dynamicQuery.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.CATEGORY_APPROVAL_STATUS).eq(status));
			}
			
			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction(""+CategoryViewPortletKeys.LOWER+"("+CategoryViewPortletKeys.CATEGORY_NAME+") "+CategoryViewPortletKeys.LIKE+" ?",
					"%" + search.toLowerCase() + "%", Type.STRING);
			
			disjunction.add(criterion);
			criterion = RestrictionsFactoryUtil.sqlRestriction(""+CategoryViewPortletKeys.LOWER+"("+CategoryViewPortletKeys.CATEGORY_TYPE+") "+CategoryViewPortletKeys.LIKE+" ?",
					"%" + search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			dynamicQuery.add(disjunction);
			
		} else if (!status.isEmpty()) {
			disjunction.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.CATEGORY_APPROVAL_STATUS).eq(status));
			dynamicQuery.add(disjunction);
		
		} else if(!activeStatus.isEmpty()) {
			Boolean activeStatusBool = Boolean.parseBoolean(activeStatus);
			disjunction.add(PropertyFactoryUtil.forName(CategoryViewPortletKeys.CATEGORY_ACTIVE).eq(activeStatusBool));
			dynamicQuery.add(disjunction);
		
		// searching
		} else if (!search.isEmpty()) {

			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction(""+CategoryViewPortletKeys.LOWER+"("+CategoryViewPortletKeys.CATEGORY_NAME+") "+CategoryViewPortletKeys.LIKE+" ?",
					"%" + search.toLowerCase() + "%", Type.STRING);
			
			disjunction.add(criterion);
			criterion = RestrictionsFactoryUtil.sqlRestriction(""+CategoryViewPortletKeys.LOWER+"("+CategoryViewPortletKeys.CATEGORY_TYPE+") "+CategoryViewPortletKeys.LIKE+" ?",
					"%" + search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			dynamicQuery.add(disjunction);
		}
		return dynamicQuery;
	}
	
	// method for ordering the data
	private Order orderByColSorting(String orderByCol, String orderByType) {
		Order order;
		if (Validator.isNotNull(orderByCol)) {
			if (orderByType.equalsIgnoreCase("asc")) {
			order = OrderFactoryUtil.asc(orderByCol);
			} else {
				order = OrderFactoryUtil.desc(orderByCol);
			}
		} else {
			order = OrderFactoryUtil.desc(CategoryViewPortletKeys.MODIFIED_DATE);
		}
		
		return order;
	}
	
	//creating a column according to admin , manaer and reviewer
	private String extractedUserColumn(Boolean administrator, Boolean manager, Boolean reviewer) {
		if (administrator) {
	        return CategoryViewPortletKeys.CREATED_BY;
	    } else if (manager) {
	        return CategoryViewPortletKeys.ASSIGN_MANAGER;
	    } else if (reviewer) {
	        return CategoryViewPortletKeys.ASSIGN_REVIEWER;
	    } else {
	        return "";  
	    }
	}

	// fetching user name
	public static String userName(long userId) {
		User user = null;
		String name = "";
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e) {
			logger.error("User Not Found : " + e.getMessage());
		}
		if(Validator.isNotNull(user)) {
			name = user.getFirstName() + " " + user.getLastName();
		}
		return name;
		
	}
}
