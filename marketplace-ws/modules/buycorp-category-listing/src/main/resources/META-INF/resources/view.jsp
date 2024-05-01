<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ taglib uri="http://liferay.com/tld/site-navigation"
	prefix="liferay-site-navigation"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<portlet:renderURL var="viewUrl">
	<portlet:param name="parentCategoryId"
		value="${category.parentCategoryId}" />
</portlet:renderURL>

<portlet:actionURL var="searchCategory" name="searchCategory" />

<%
	long parentCategoryId = (long) renderRequest.getAttribute("parentCategoryId");
	PortletURL renderURL = renderResponse.createRenderURL();
	String assetCategoryId = String.valueOf((long) renderRequest.getAttribute("assetCategoryId"));
	String parentCategory = String.valueOf(parentCategoryId);
	String search = (String) renderRequest.getAttribute("search");
	int count = (int) renderRequest.getAttribute("count");
	String counter = String.valueOf(count);
	renderURL.setParameter("count", counter);
	renderURL.setParameter("assetCategoryId", assetCategoryId);
	renderURL.setParameter("search", search);

	if (parentCategoryId != 0) {
		renderURL.setParameter("parentCategoryId", parentCategory);
	}
	renderURL.setParameter("mvcRenderCommandName", "viewUrl");
	long categoryId = (long) renderRequest.getAttribute("categoryId");
	List<BreadcrumbEntry> breadcrumbEntries = BuycorpCategoryBreadCrumbUtil.getAssetCategoriesBreadcrumbEntries(categoryId,
			request, renderResponse);
%>
<div
	class="navbar-form navbar-form-autofit  navbar-overlay navbar-overlay-sm-down">
	<div class="container-fluid container-fluid-max-xl">
		<div class="input-group">
			<div class="input-group-item">
				<form action="${searchCategory}" method="POST">
					<input type="hidden" name="<portlet:namespace/>parentCategoryId"
						value="${parentCategoryId}" /> <input
						class="form-control form-control input-group-inset input-group-inset-after"
						placeholder="Search" type="text" value="${search}"
						name="<portlet:namespace/>search" /><span
						class="input-group-inset-item input-group-inset-item-after">

						<button aria-label="Search"
							class="btn btn-monospaced btn-unstyled" type="submit">
							<svg class="lexicon-icon lexicon-icon-search" role="presentation"
								viewBox="0 0 512 512">
								<use
									xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#search" /></svg>
						</button>
					</span>
				</form>
			</div>
		</div>
	</div>
</div>


<c:if test="<%=ListUtil.isNotEmpty(breadcrumbEntries)%>">
	<liferay-site-navigation:breadcrumb
		breadcrumbEntries="<%=breadcrumbEntries%>" />
</c:if>

<div class="container lifeRayTable">
	<liferay-ui:search-container id="CategoryTable"
		emptyResultsMessage='<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio">
	<img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="${imagePath}/images/search_state.gif">
	</div>
	</div>
	<div class="">
		<span class="text-truncate-inline">
			<span class="text-truncate">
				<a href="${urlRedirect}">No Categories Found</a>
			</span>
		</span>
	</div>
	</div>'
		total="${count}" delta="10" iteratorURL="<%= renderURL %>">
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.dao.search.EmptySearch"
			keyProperty="searchContainer" modelVar="searchContainer" />
		<liferay-ui:search-container-results results="${categories}" />
		<liferay-ui:search-container-row
			className="com.marketplace.category.model.Category"
			keyProperty="categoryId" modelVar="category" escapedModel="true">
			<liferay-ui:search-container-column-text name="Category Name"
				orderableProperty="categoryName" orderable="true">
				<c:if test="${category.hasChild}">
					<a
						href="${viewUrl}&<portlet:namespace/>parentCategoryId=${category.categoryId}&<portlet:namespace/>assetCategoryId=${category.assetCategoryId}"
						style="text-decoration: none;">${category.categoryName}</a>
				</c:if>
				<c:if test="${!category.hasChild}">
					<a
						href="${themeDisplay.getPortalURL()}${themeDisplay.getPathFriendlyURLPublic()}${themeDisplay.getLayout().getGroup().getFriendlyURL()}/listing?category=${category.assetCategoryId}"
						style="text-decoration: none;">${category.categoryName}</a>
				</c:if>

			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<!-- Add the search iterator for pagination -->
		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</div>
