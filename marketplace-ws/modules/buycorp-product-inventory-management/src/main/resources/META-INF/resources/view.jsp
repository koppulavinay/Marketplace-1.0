<%@page import="com.marketplace.product.inventory.management.display.context.DashboardManagementToolbarDisplayContext"%>
<%@page import="com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys"%>
<%@ include file="/init.jsp"%>
<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%> 
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<script type="text/javascript">
	$('#customLoader').show();
</script>

<%-- <portlet:actionURL var="editProductURL"
	name="<%=BuycorpProductInventoryManagementPortletKeys.PRODUCT_SKUS%>" /> --%>
	
<portlet:renderURL var="editProductURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=BuycorpProductInventoryManagementPortletKeys.PRODUCT_SKUS%>" />
</portlet:renderURL>
 <portlet:resourceURL var="inventoryFetchUrl" id="inventoryFetch" />
           
<c:set var="editURL" value="${editProductURL}&draftProductId=" />

<section class="mt-3">
	<%-- <div class="container containerMob minMamTableWidth mt-3">
		<table id="productList" class="w-100">
			<thead>
				<tr>
					<th scope="col" class="no-sort"></th>
					<!-- <th scope="col" class="no-sort">Image</th> -->
					<th scope="col">Product ID</th>
					<th scope="col" width="150px">Product Name</th>
					<th scope="col">Product Type</th>
					<th scope="col" width="150px">Category</th>
					<th scope="col">Brand</th>
					<th scope="col">Status</th>
					<th scope="col">Created Date</th>
					<th scope="col" class="no-sort">Action</th>
				</tr>
			</thead>
			<tbody id="tableBody">
				<c:forEach items="${products}" var="product">
					<tr>
						<td class="checkboxTd">
							<!-- <input type="checkbox" class="select-checkbox"> -->
							<div class="custom-control custom-checkbox">
								<label> <input
									class="custom-control-input select-checkbox" type="checkbox" />
									<span class="custom-control-label"></span>
								</label>
							</div>
						</td>
						<td class="picViewTable">
						
						<c:set var="imageURL" value="${product.getImageURL() != '' ? product.getImageURL() : '/o/buycorp-classic-theme/images/no-image-available.jpg'}" /> 
						
						<img
							src="${imageURL}"
							alt="" style="max-height: 50px;"></td>
						<td>${product.getProductId()}</td>
						<td>${product.getProductName()}</td>
						<td>${product.getProductType()}</td>
						<td>${product.getCategoryName()}</td>
						<td>${product.getBrandName()}</td>
						<td style="text-transform: capitalize;">${product.getStatus()}</td>
						<td width="15%">${product.getCreateDate()}</td>
						<td><a href="${editURL}${product.getProductId()}"class="btn btn-link"><i class="icon-pencil"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			</tfoot>
		</table>
	</div> --%>
	<%
	DashboardManagementToolbarDisplayContext dashboardManagementToolbarDisplayContext = (DashboardManagementToolbarDisplayContext)request.getAttribute("dashboardManagementToolbarDisplayContext");
	
	PortletURL renderURL = renderResponse.createRenderURL();
	String search = (String) renderRequest.getAttribute("search");
	
	renderURL.setParameter("search",search);
	
	renderURL.setParameter("mvcRenderCommandName", "viewUrl");
%> 
	
	
	<clay:management-toolbar
									displayContext="${dashboardManagementToolbarDisplayContext}"
									searchContainerId="dashboardEntries"
									itemsTotal="${productCount}"
									selectable="false"
									
								/>

 <liferay-ui:search-container 
	emptyResultsMessage='<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio">
	<img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="${imagePath}/images/search_state.gif"/></div></div>
	<div class=""><span class="text-truncate-inline"><span class="text-truncate">
	
	<a href="">No Products found.</a> 
	
	
	 </span></span></div>
</div>' total="${productCount}" delta="10" iteratorURL="<%= renderURL %>">

    <!-- Add the search box -->
    <liferay-ui:search-container-row
        className="com.liferay.portal.kernel.dao.search.EmptySearch"
        keyProperty="searchContainer" modelVar="searchContainer" />

    <liferay-ui:search-container-results results="${products}" />

    <liferay-ui:search-container-row
        className="com.marketplace.product.inventory.management.model.ProductModel"
        keyProperty="productId"
        modelVar="product"
        escapedModel="true">

 		 <liferay-ui:search-container-column-text name=" "><input type="checkbox"/> </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Product ID">${product.getProductId()}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Product Name" >${product.getProductName()}</liferay-ui:search-container-column-text>
         <liferay-ui:search-container-column-text name="Product Type" >${product.getProductType()}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Category Name">${product.getCategoryName() }</liferay-ui:search-container-column-text>
         <liferay-ui:search-container-column-text name="Brand Name">${product.getBrandName() }</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Status">${product.getStatus() }</liferay-ui:search-container-column-text>
      
        
        <liferay-ui:search-container-column-text name="Created Date">${product.getCreateDate()}
<%--         <fmt:formatDate value="${product.getCreateDate()}" pattern="yy-MM-dd, hh:mm" var="formattedDate"/>${formattedDate} --%>
        </liferay-ui:search-container-column-text>
        
        
        <liferay-ui:search-container-column-text name="Action">
        <td><a href="${editURL}${product.getProductId()}"class="btn btn-link"><i class="icon-pencil"></i>Edit</a></td>
	           
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <!-- Add the search iterator for pagination -->
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
	
	
	
	
	
	
	
	
</section>

<script src="<%= request.getContextPath() %>/cdn/js/jquery.dataTables.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/cdn/css/jquery.dataTables.css">

<script>

$(document).ready(function() {
    /* var table = $('#productList').DataTable(); */
    
  /*  $('#productList').DataTable({
    "dom": '<f<"table-responsive" t><"tableFootBar"pil>>',
    "info": false, 
    "serverSide": true,
    "processing": true,
    "paging": true,
    "pagingType":"simple_numbers",
    "searching" : true,
    "pageLength": 10,
    "ajax": {
        "type": "POST",
         "url": "${inventoryFetchUrl}",
        "dataType": "json",
        "data" : {
        	"<portlet:namespace />filter" : false
    	}
    },
    "language": {
        "paginate": {
            "previous": '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M5.15356 0.501202L1.1151 4.53966L5.15356 8.57812" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>',
            "next": '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M0.92334 8.57692L4.9618 4.53846L0.92334 0.5" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>'
        },
        "lengthMenu": 'Show _MENU_ entries',
        "entries": {
            "_": 'people',
            "1": 'person'
        }
    },
    "columns": [
        { "data": "Product ID" },
        { "data": "Product Name" },
        { "data": "Product Type" },
        { "data": "Category" },
        { "data": "Brand" },
        { "data": "Status" },
        { "data": "Created Date"},
        {"data":"Action"}
    ]
});

$("#productList_filter.dataTables_filter").append($(".addProduct"));
$("#productList_filter.dataTables_filter").prepend('<h1 class="titlePage">Inventory Update</h1>');

    // Add event listener for checkbox selection
    $('#productList tbody').on('change', '.select-checkbox', function(){
        if($(this).is(':checked')){
            $(this).closest('tr').addClass('selected');
        } else {
            $(this).closest('tr').removeClass('selected');
        }
    });
    
    $('#customLoader').hide();
    
}); */

</script>
