<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CPSearchResultsDisplayContext cpSearchResultsDisplayContext = (CPSearchResultsDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

SearchContainer<CPCatalogEntry> cpCatalogEntrySearchContainer = cpSearchResultsDisplayContext.getSearchContainer();
%>

<!-- Start ProductList Top -->
<div class="productListTop">
   <button type="button" class="btn btn-secondary filtersBtn"><img src="/o/buycorp-classic-theme/images/icon/icon-filter.svg" alt="" class="iconSize"> Filters</button>
    <div class="pItems mr-auto"><%= cpCatalogEntrySearchContainer.getTotal() %> items found <span class="d-none">in Mobiles & Accessories</span></div>
    <div class="sortBy form-inline">
      <div class="form-group">
        <button aria-expanded="false" aria-haspopup="true" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" id="commerce-order-by" type="button">
			<c:set var="orderByColArgument">
				<span class="ml-1">
					<liferay-ui:message key="<%= cpSearchResultsDisplayContext.getOrderByCol() %>" />
				</span>
			</c:set>

			<liferay-ui:message arguments="${orderByColArgument}" key="sort-by-colon-x" />

			<clay:icon
				symbol="caret-double-l"
			/>
		</button>

		<div class="dropdown-menu dropdown-menu-right" id="<portlet:namespace />commerce-dropdown-order-by">

			<%
			String[] sortOptions = CPSearchResultsConstants.SORT_OPTIONS; 
			//String[] sortOptions = {"by-relevance", "price-high-to-low", "price-low-to-high", "fresh-arrivals", "name-ascending", "name-descending"};

			for (String sortOption : sortOptions) {
			%>

				<clay:link
					cssClass="dropdown-item transition-link sortWidgetOptions"
					data-label="<%= sortOption %>"
					href="#"
					id="<%= liferayPortletResponse.getNamespace() + sortOption %>"
					label="<%= LanguageUtil.get(request, sortOption) %>"
					style="secondary"
				/>

			<%
			}
			%>

		</div>
      </div>
    </div>
    <div class="listViewBox">
        
      <div class="btn-group listView" role="group">
        <button class="active btn btn-secondary" type="button"><img src="/o/buycorp-classic-theme/images/icon/grid.svg" alt="" class="iconSize"> Grid</button>
        <button class="btn btn-secondary" type="button"><img src="/o/buycorp-classic-theme/images/icon/list-ul.svg" alt="" class="iconSize"> List</button>
      </div>

    </div>
</div>
<!-- End ProductList Top -->

<liferay-frontend:component
	context='<%=
		HashMapBuilder.<String, Object>put(
			"currentURL", themeDisplay.getURLCurrent()
		).put(
			"portletDisplayId", portletDisplay.getId()
		).build()
	%>'
	module="js/sort/view"
/>