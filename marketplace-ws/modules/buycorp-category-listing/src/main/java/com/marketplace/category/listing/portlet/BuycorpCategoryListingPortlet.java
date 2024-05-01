package com.marketplace.category.listing.portlet;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.category.listing.constants.BuycorpCategoryListingPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author ashishinani
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BuycorpCategoryListing",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BuycorpCategoryListingPortletKeys.BUYCORPCATEGORYLISTING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BuycorpCategoryListingPortlet extends MVCPortlet {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(BuycorpCategoryListingPortlet.class.getName());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		LOGGER.info(BuycorpCategoryListingPortletKeys.LOGGER_INFO_PREFIX + "Inside BuycorpCategoryListingPortlet" + BuycorpCategoryListingPortletKeys.LOGGER_INFO_SUFFIX);

		int delta = ParamUtil.getInteger(renderRequest, BuycorpCategoryListingPortletKeys.DELTA);
		int cur = ParamUtil.getInteger(renderRequest, BuycorpCategoryListingPortletKeys.CUR);
		int from = delta * (cur - 1);
		int to = delta == 0 ? 10 : delta * cur;
		String parentCategoryEntryId = ParamUtil.getString(renderRequest, BuycorpCategoryListingPortletKeys.PARENT_CATEGORYID);
		String assetCategoryEntryId = ParamUtil.getString(renderRequest, BuycorpCategoryListingPortletKeys.ASSET_CATEGORYID);
		String search = ParamUtil.get(renderRequest, BuycorpCategoryListingPortletKeys.SEARCH, "");
		String orderByCol = ParamUtil.getString(renderRequest, BuycorpCategoryListingPortletKeys.ORDER_BY_COL);
		String orderByType = ParamUtil.getString(renderRequest, BuycorpCategoryListingPortletKeys.ORDER_BY_TYPE);
		List<Category> counter = null;
		long parentCategoryId = 0L;
		long assetCategoryId = 0L;
		
		if (!parentCategoryEntryId.isEmpty()) {
			parentCategoryId = Long.parseLong(parentCategoryEntryId);
		}
		
		if (!assetCategoryEntryId.isEmpty()) {
			assetCategoryId = Long.parseLong(assetCategoryEntryId);
		}
		
		DynamicQuery dynamicQuery = CategoryLocalServiceUtil.dynamicQuery();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		
		// only for cateogory roles
		dynamicQuery.add(PropertyFactoryUtil.forName(BuycorpCategoryListingPortletKeys.CATEGORY_APPROVAL_STATUS).eq(BuycorpCategoryListingPortletKeys.APPROVED));
		dynamicQuery.addOrder(orderByColSorting(orderByCol, orderByType));
		
		if(!search.isEmpty()){
			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("" + BuycorpCategoryListingPortletKeys.LOWER + "(" + 
					BuycorpCategoryListingPortletKeys.CATEGORY_NAME + ") "+BuycorpCategoryListingPortletKeys.LIKE+" ?", "%" + 
							search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			dynamicQuery.add(disjunction);
		} else {
			dynamicQuery.add(PropertyFactoryUtil.forName(BuycorpCategoryListingPortletKeys.PARENT_CATEGORYID).eq(parentCategoryId));
		}
	
		counter = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		List<Category> categories = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery, from, to);
			
		Category category = null;
		if(parentCategoryId != 0) {
			 category = CategoryLocalServiceUtil.fetchCategory(parentCategoryId);
			renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.CATEGORY_ID, category.getCategoryId());
		}else {
			renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.CATEGORY_ID, 0L);
		}
		
		LOGGER.info("Category List " + categories);
		
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.CATEGORIES, categories);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.PARENT_CATEGORYID, parentCategoryId);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.COUNT, counter.size());
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.ASSET_CATEGORYID, assetCategoryId);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.SEARCH, search);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.CUR, cur);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.FROM, from);
		renderRequest.setAttribute(BuycorpCategoryListingPortletKeys.TO, to);

		super.render(renderRequest, renderResponse);
	}

	private Order orderByColSorting(String orderByCol, String orderByType) {
		Order order;
		if (Validator.isNotNull(orderByCol)) {
			if (orderByType.equalsIgnoreCase("asc")) {
			order = OrderFactoryUtil.asc(orderByCol);
			} else {
				order = OrderFactoryUtil.desc(orderByCol);
			}
		} else {
			order = OrderFactoryUtil.desc(BuycorpCategoryListingPortletKeys.CATEGORY_NAME);
		}
		
		return order;
	}
	
}