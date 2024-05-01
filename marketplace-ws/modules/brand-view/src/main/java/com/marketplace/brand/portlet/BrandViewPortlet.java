package com.marketplace.brand.portlet;

import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Brand View",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BrandViewPortlet extends MVCPortlet {
	
	public static final Log logger = LogFactoryUtil.getLog(BrandViewPortlet.class.getName());
	
	// main portlet where we can view search and filter data 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// this is the main portlet
		// this is render method at present for the first time displaying the data
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String orderByCol = ParamUtil.getString(renderRequest, BrandViewPortletKeys.ORDER_BY_COL);
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + BrandViewPortletKeys.ORDER_BY_COL + BrandViewPortletKeys.LOGGER_INFO_SUFFIX + orderByCol);
		String orderByType = ParamUtil.getString(renderRequest, BrandViewPortletKeys.ORDER_BY_TYPE);
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + BrandViewPortletKeys.ORDER_BY_TYPE + BrandViewPortletKeys.LOGGER_INFO_SUFFIX + orderByType);
		String search = ParamUtil.get(renderRequest, BrandViewPortletKeys.SEARCH, "");
		String status = ParamUtil.get(renderRequest, BrandViewPortletKeys.STATUS, "");
		String activeStatus = ParamUtil.get(renderRequest, BrandViewPortletKeys.ACTIVE_STATUS, "");
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		int from = delta * (cur-1);
		int to = delta==0 ? 10 : delta*cur;
		List<Brand> brandCounter = null;
		long adminstratorId = 0L;
		long brandAdminId = 0L;
		long brandReviewerId = 0L;
		
		//fetching roles 
		try {
			brandAdminId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.BRAND_ADMIN).getRoleId();
			brandReviewerId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.BRAND_REVIEWER).getRoleId();
			adminstratorId= RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), BrandViewPortletKeys.ADMINISTRATOR_ROLE).getRoleId();
		} catch (Exception e) {
			logger.error("Role Not Found : " + e.getMessage());
		}
		
		final long brandAdmin = brandAdminId;
		final long brandReviewer = brandReviewerId;
		final long brandadminstrator = adminstratorId;
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());

		boolean administrator = roles.stream()
		        .anyMatch(role -> role.getRoleId() == brandAdmin || role.getRoleId() == brandadminstrator);

		boolean reviewer = roles.stream()
		        .anyMatch(role -> role.getRoleId() == brandReviewer);

		// adding column according to admin or reviewer
		String userColumns = extractedUserColumn(administrator);
		
		// map for conditional searching
		Map<String, String> parameters = new HashMap<>();
		parameters.put(BrandViewPortletKeys.SEARCH, search);
		parameters.put(BrandViewPortletKeys.STATUS, status);
		parameters.put(BrandViewPortletKeys.ACTIVE_STATUS, activeStatus);
		parameters.put(BrandViewPortletKeys.ORDER_BY_COL, orderByCol);
		parameters.put(BrandViewPortletKeys.ORDER_BY_TYPE, orderByType);
		parameters.put(BrandViewPortletKeys.USER_COLUMNS, userColumns);
		
		//calling fetchResultUsingDynamicquery method
		DynamicQuery dynamicQuery = fetchResultUsingDynamicQuery(themeDisplay, administrator, parameters);
		
		brandCounter = BrandLocalServiceUtil.dynamicQuery(dynamicQuery);
		List<Brand> brands = BrandLocalServiceUtil.dynamicQuery(dynamicQuery, from, to);
		
		renderRequest.setAttribute(BrandViewPortletKeys.SEARCH, search);
		renderRequest.setAttribute(BrandViewPortletKeys.BRANDS, brands);
		renderRequest.setAttribute(BrandViewPortletKeys.ADMINISTRATOR_ROLE, administrator);
		renderRequest.setAttribute(BrandViewPortletKeys.REVIEWER_ROLE, reviewer);
		renderRequest.setAttribute("brandCount", brandCounter.size());
		renderRequest.setAttribute(BrandViewPortletKeys.STATUS, status);
		renderRequest.setAttribute("from", from);
		renderRequest.setAttribute("to", to);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute(BrandViewPortletKeys.ACTIVE_STATUS, activeStatus);
		super.render(renderRequest, renderResponse);
	}

	// Search, General Table and Filter are retrived using dynamic query method 
	private DynamicQuery fetchResultUsingDynamicQuery(ThemeDisplay themeDisplay, Boolean administrator, Map<String,String> parameters) {
		String search = parameters.get(BrandViewPortletKeys.SEARCH);
		String userColumns = parameters.get(BrandViewPortletKeys.USER_COLUMNS);
		String status = parameters.get(BrandViewPortletKeys.STATUS);
		String activeStatus = parameters.get(BrandViewPortletKeys.ACTIVE_STATUS);
		String orderByCol=parameters.get(BrandViewPortletKeys.ORDER_BY_COL);
		String orderByType = parameters.get(BrandViewPortletKeys.ORDER_BY_TYPE);
		DynamicQuery dynamicQuery = BrandLocalServiceUtil.dynamicQuery();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		if(!administrator) {
			dynamicQuery.add(PropertyFactoryUtil.forName(userColumns).eq(themeDisplay.getUserId()));
		}
		// sorting by column
		dynamicQuery.addOrder(orderByColSorting(orderByCol, orderByType));
		
		// if status is empty the brand approval status include
			if(!search.isEmpty() && (!status.isEmpty() || !activeStatus.isEmpty())) {

				if(!activeStatus.isEmpty()) {
					Boolean activeStatusBool = Boolean.parseBoolean(activeStatus);
					dynamicQuery.add(PropertyFactoryUtil.forName(BrandViewPortletKeys.BRAND_INACTIVE).eq(activeStatusBool));
				}
				if(!status.isEmpty()) {
				dynamicQuery.add(PropertyFactoryUtil.forName(BrandViewPortletKeys.BRAND_APPROVAL_STATUS).eq(status));
				}
				Criterion criterion = RestrictionsFactoryUtil.sqlRestriction(""+BrandViewPortletKeys.LOWER+"("+BrandViewPortletKeys.BRAND_NAME+") "+BrandViewPortletKeys.LIKE+" ?", "%" + search.toLowerCase() + "%", Type.STRING);
				disjunction.add(criterion);
				criterion = RestrictionsFactoryUtil.sqlRestriction(""+BrandViewPortletKeys.LOWER+"("+BrandViewPortletKeys.BRAND_TYPE+") "+BrandViewPortletKeys.LIKE+" ?", "%" + search.toLowerCase() + "%", Type.STRING);
				disjunction.add(criterion);
				dynamicQuery.add(disjunction);
			
		} else if(!status.isEmpty()) {
			disjunction.add(PropertyFactoryUtil.forName(BrandViewPortletKeys.BRAND_APPROVAL_STATUS).eq(status));
			dynamicQuery.add(disjunction);
		} else if(!activeStatus.isEmpty()) {
			disjunction.add(PropertyFactoryUtil.forName(BrandViewPortletKeys.BRAND_INACTIVE).eq(Boolean.parseBoolean(activeStatus)));
			dynamicQuery.add(disjunction);
		} else if(!search.isEmpty()) {
			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction(""+BrandViewPortletKeys.LOWER+"("+BrandViewPortletKeys.BRAND_NAME+") "+BrandViewPortletKeys.LIKE+" ?", "%" + search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			criterion = RestrictionsFactoryUtil.sqlRestriction(""+BrandViewPortletKeys.LOWER+"("+BrandViewPortletKeys.BRAND_TYPE+") "+BrandViewPortletKeys.LIKE+" ?", "%" + search.toLowerCase() + "%", Type.STRING);
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
			order = OrderFactoryUtil.desc("modifiedDate");
		}
		
		return order;
	}
	
	// create a column according to admin and reviewer
	private String extractedUserColumn(Boolean administrator) {
		String userColumns="";
		if(administrator) {
			userColumns="createdBy";	
		}else {
			userColumns=BrandViewPortletKeys.BRANDREVIEWER;
		}
		return userColumns;
	}
	
	//fetch user name
	public static String userName(long userId) {
		User user = null;
		String name = "";
		try {
			user = UserLocalServiceUtil.getUser(userId);
			name = user.getFirstName() + " " + user.getLastName();
		} catch (PortalException e) {
			logger.error("User Not Found : " + e.getMessage());
		}
		
		return name;
	}
	
}
