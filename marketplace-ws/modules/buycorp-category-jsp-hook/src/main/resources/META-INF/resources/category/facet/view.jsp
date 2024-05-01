<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.search.web.internal.category.facet.configuration.CategoryFacetPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.category.facet.portlet.CategoryFacetPortlet" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.AssetCategoriesSearchFacetDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.BucketDisplayContext" %>

<portlet:defineObjects />

<%
AssetCategoriesSearchFacetDisplayContext assetCategoriesSearchFacetDisplayContext = (AssetCategoriesSearchFacetDisplayContext)java.util.Objects.requireNonNull(request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT));

if (assetCategoriesSearchFacetDisplayContext.isRenderNothing()) {
	return;
}

CategoryFacetPortletInstanceConfiguration categoryFacetPortletInstanceConfiguration = assetCategoriesSearchFacetDisplayContext.getCategoryFacetPortletInstanceConfiguration();
List<BucketDisplayContext> brandList = new ArrayList<>();
List<BucketDisplayContext> categoryList = new ArrayList<>();
String vocubularyName = "";
%>

<c:choose>
	<c:when test="<%= assetCategoriesSearchFacetDisplayContext.isRenderNothing() %>">
		<aui:input autocomplete="off" name="<%= HtmlUtil.escapeAttribute(assetCategoriesSearchFacetDisplayContext.getParameterName()) %>" type="hidden" value="<%= assetCategoriesSearchFacetDisplayContext.getParameterValue() %>" />
	</c:when>
	<c:otherwise>
		<aui:form action="#" method="post" name="fm">
			<aui:input autocomplete="off" name="<%= HtmlUtil.escapeAttribute(assetCategoriesSearchFacetDisplayContext.getParameterName()) %>" type="hidden" value="<%= assetCategoriesSearchFacetDisplayContext.getParameterValue() %>" />
			<aui:input cssClass="facet-parameter-name" name="facet-parameter-name" type="hidden" value="<%= assetCategoriesSearchFacetDisplayContext.getParameterName() %>" />
			<aui:input cssClass="start-parameter-name" name="start-parameter-name" type="hidden" value="<%= assetCategoriesSearchFacetDisplayContext.getPaginationStartParameterName() %>" />

			<liferay-ddm:template-renderer
				className="<%= CategoryFacetPortlet.class.getName() %>"
				contextObjects='<%=
					HashMapBuilder.<String, Object>put(
						"assetCategoriesSearchFacetDisplayContext", assetCategoriesSearchFacetDisplayContext
					).put(
						"namespace", liferayPortletResponse.getNamespace()
					).build()
				%>'
				displayStyle="<%= categoryFacetPortletInstanceConfiguration.displayStyle() %>"
				displayStyleGroupId="<%= assetCategoriesSearchFacetDisplayContext.getDisplayStyleGroupId() %>"
				entries="<%= assetCategoriesSearchFacetDisplayContext.getBucketDisplayContexts() %>"
			>
			
			<%
				for (BucketDisplayContext bucketDisplayContext : assetCategoriesSearchFacetDisplayContext.getBucketDisplayContexts()) {
					long vocubularyId = AssetCategoryLocalServiceUtil.fetchAssetCategory(bucketDisplayContext.getAssetCategoryId()).getVocabularyId();
					vocubularyName = AssetVocabularyLocalServiceUtil.fetchAssetVocabulary(vocubularyId).getName();

					if(vocubularyName.equalsIgnoreCase("select brand")){
						brandList.add(bucketDisplayContext);
					} else if(vocubularyName.equalsIgnoreCase("select category")){
						categoryList.add(bucketDisplayContext);
					}
				}
			
				brandList = brandList.stream().sorted((o1, o2)->o1.getBucketText().compareTo(o2.getBucketText())).collect(Collectors.toList());
				categoryList = categoryList.stream().sorted((o1, o2)->o1.getBucketText().compareTo(o2.getBucketText())).collect(Collectors.toList());
				
				if(vocubularyName.equalsIgnoreCase("select brand")){
			%>
			
			<liferay-ui:panel-container
			extended="<%= true %>"
			id='<%= liferayPortletResponse.getNamespace() + "facetAssetCategoriesPanelContainer" %>'
			markupView="lexicon"
			persistState="<%= true %>">
			<liferay-ui:panel
				collapsible="<%= true %>"
				cssClass="search-facet"
				id='<%= liferayPortletResponse.getNamespace() + "facetAssetCategoriesPanel" %>'
				markupView="lexicon"
				persistState="<%= true %>"
				title="Brand">
				
				<ul class="list-unstyled">
				
			<%
				int i = 0;				
				for (BucketDisplayContext bucketDisplayContext : brandList) {
					i++;
			%>
				<li class="facet-value">
					<div class="custom-checkbox custom-control">
						<label class="facet-checkbox-label" for="<portlet:namespace />term_<%= i %>">
							<input
								<%= bucketDisplayContext.isSelected() ? "checked" : StringPool.BLANK %>
								class="custom-control-input facet-term brandCount"
								data-term-id="<%= bucketDisplayContext.getFilterValue() %>"
								id="<portlet:namespace />term_<%= i %>"
								name="<portlet:namespace />term_<%= i %>"
								onChange="Liferay.Search.FacetUtil.changeSelection(event);"
								type="checkbox"
							/>
	
							<span class="custom-control-label term-name <%= bucketDisplayContext.isSelected() ? "facet-term-selected" : "facet-term-unselected" %>">
								<span class="custom-control-label-text">
									<c:choose>
										<c:when test="<%= bucketDisplayContext.isSelected() %>">
											<strong><%= HtmlUtil.escape(bucketDisplayContext.getBucketText()) %></strong>
										</c:when>
										<c:otherwise>
											<%= HtmlUtil.escape(bucketDisplayContext.getBucketText()) %>
										</c:otherwise>
									</c:choose>
								</span>
							</span>
						</label>
					</div>
				</li>
				
			<%
				} %>
				</ul>
				</liferay-ui:panel>
				</liferay-ui:panel-container>
				
			<%} else if(vocubularyName.equalsIgnoreCase("select category")) {
			%>
				<liferay-ui:panel-container
				extended="<%= true %>"
				id='<%= liferayPortletResponse.getNamespace() + "facetAssetCategoriesPanelContainer" %>'
				markupView="lexicon"
				persistState="<%= true %>">
				<liferay-ui:panel
					collapsible="<%= true %>"
					cssClass="search-facet"
					id='<%= liferayPortletResponse.getNamespace() + "facetAssetCategoriesPanel" %>'
					markupView="lexicon"
					persistState="<%= true %>"
					title="category">
					
					<ul class="list-unstyled">
					
			<%
				int i = 0;				
				for (BucketDisplayContext bucketDisplayContext : categoryList) {
					i++;
			%>
				<li class="facet-value">
					<div class="custom-checkbox custom-control">
						<label class="facet-checkbox-label" for="<portlet:namespace />term_<%= i %>">
							<input
								<%= bucketDisplayContext.isSelected() ? "checked" : StringPool.BLANK %>
								class="custom-control-input facet-term categoryCount"
								data-term-id="<%= bucketDisplayContext.getFilterValue() %>"
								id="<portlet:namespace />term_<%= i %>"
								name="<portlet:namespace />term_<%= i %>"
								onChange="Liferay.Search.FacetUtil.changeSelection(event);"
								type="checkbox"
							/>
	
							<span class="custom-control-label term-name <%= bucketDisplayContext.isSelected() ? "facet-term-selected" : "facet-term-unselected" %>">
								<span class="custom-control-label-text">
									<c:choose>
										<c:when test="<%= bucketDisplayContext.isSelected() %>">
											<strong><%= HtmlUtil.escape(bucketDisplayContext.getBucketText()) %></strong>
										</c:when>
										<c:otherwise>
											<%= HtmlUtil.escape(bucketDisplayContext.getBucketText()) %>
										</c:otherwise>
									</c:choose>
								</span>
							</span>
						</label>
					</div>
				</li>
			<%	
				} %>
				</ul>
				</liferay-ui:panel>
				</liferay-ui:panel-container>
			<%}
			%>
			
						<%-- <c:if test="<%= !assetCategoriesSearchFacetDisplayContext.isNothingSelected() %>">
							<clay:button
								cssClass="btn-unstyled c-mb-4 facet-clear-btn"
								displayType="link"
								id='<%= liferayPortletResponse.getNamespace() + "facetAssetCategoriesClear" %>'
								onClick="Liferay.Search.FacetUtil.clearSelections(event);"
							>
								<strong><liferay-ui:message key="clear" /></strong>
							</clay:button>
						</c:if> --%>
			</liferay-ddm:template-renderer>
		</aui:form>
	</c:otherwise>
</c:choose>

<aui:script use="liferay-search-facet-util">
	Liferay.Search.FacetUtil.enableInputs(
		document.querySelectorAll('#<portlet:namespace />fm .facet-term')
	);
</aui:script>

<%-- <script>

$(window).on('load', function() {
	
	var brandCount = $('input.brandCount:checkbox').length;
	console.log("brandCount--> " + brandCount);
	var categoryCount = $('input.categoryCount:checkbox').length;
	console.log("categoryCount--> " + categoryCount);
	
});

</script> --%>

