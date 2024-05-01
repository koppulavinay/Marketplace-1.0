<%@page import="com.marketplace.product.inventory.management.display.context.DashboardManagementToolbarProductSkuDisplayContext"%>
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


	
<portlet:renderURL var="viewRenderURl">
	<portlet:param name="mvcRenderCommandName"
		value="viewUrl" />
</portlet:renderURL>


<c:set var="editURL" value="${editProductURL}&draftProductId=" />
<a href="${viewRenderURl}" >Back</a>
	
	
	<%
	DashboardManagementToolbarProductSkuDisplayContext dashboardManagementToolbarProductSkuDisplayContext = (DashboardManagementToolbarProductSkuDisplayContext)request.getAttribute("dashboardManagementToolbarProductSkuDisplayContext");
	PortletURL renderURL = renderResponse.createRenderURL();
	String productId = (String) renderRequest.getAttribute("draftProductId");
	renderURL.setParameter("draftProductId",productId);
	renderURL.setParameter("mvcRenderCommandName", "productSkus");
	System.out.println(renderURL);
%> 
<section class="mt-3">
	<%-- <div class="container containerMob minMamTableWidth mt-3">
		<table id="productList" class="w-100">
			<thead>
				<tr>
					<th scope="col" class="no-sort"></th>
					<!-- <th scope="col" class="no-sort">Image</th> -->
					<th scope="col">Product SKU ID</th>
					<th scope="col" width="150px">Stock</th>
					<th scope="col" class="no-sort">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productSKUs}" var="productSKU">
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
						<td>${productSKU.getProductSkuId()}</td>
						<td>${productSKU.getStock()}</td>
						<td>
							<button type="button" class="btn btn-link" onclick="updateStock('${productSKU.getProductSkuId()}', '${productSKU.getStock()}')" 
								data-toggle="modal" data-target="#editProductSku"><i class="icon-pencil"></i></button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> --%>
	
	
	
	 <clay:management-toolbar
									displayContext="${dashboardManagementToolbarProductSkuDisplayContext}"
									searchContainerId="dashboardEntry"
									itemsTotal="${productCount}"
									
									selectable="false"
								/> 

 <liferay-ui:search-container 
	emptyResultsMessage='<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio">
	<img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="${imagePath}/images/search_state.gif"/></div></div>
	<div class=""><span class="text-truncate-inline"><span class="text-truncate">
	
	<a href="">No ProductSKUs found.</a> 
	
	
	 </span></span></div>
</div>' total="${productCount}" delta="10" iteratorURL="<%= renderURL %>">

    <!-- Add the search box -->
    <liferay-ui:search-container-row
        className="com.liferay.portal.kernel.dao.search.EmptySearch"
        keyProperty="searchContainer" modelVar="searchContainer" />

    <liferay-ui:search-container-results results="${products}" />

    <liferay-ui:search-container-row
        className="com.marketplace.product.inventory.management.model.ProductSkuModel"
        keyProperty="productSkuId"
        modelVar="productSKU"
        escapedModel="true">

 		 <liferay-ui:search-container-column-text name=" "><input type="checkbox"/> </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="ProductSku ID">${productSKU.getProductSkuId()}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Product Stock" >${productSKU.getStock()}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Action">
       <button type="button" class="btn btn-link" onclick="updateStock('${productSKU.getProductSkuId()}', '${productSKU.getStock()}')" 
								data-toggle="modal" data-target="#editProductSku"><i class="icon-pencil"></i></button>
	           
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <!-- Add the search iterator for pagination -->
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
	
</section>

<!-- Start Modal -->
  <div class="modal fade" id="editProductSku">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
		<form>
			<button type="button" class="close" data-dismiss="modal"></button>
	
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <div class="modal-title">Update Stock</div>
	        </div>
	
	        <!-- Modal body -->
	        <div class="modal-body">
	        	<input type="hidden" name="<portlet:namespace/>productSkuId" id="productSkuId">
	        	<label for="availablestock">Stock</label><span class="requiredStar">*</span>
	          	<input type="text" onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;" maxlength="10"
	          		placeholder="Stock" id="stock" name="<portlet:namespace/>stock">
	          	<label class="error d-none stockReq">This field cannot be blank</label>
	        </div>
	
	        <!-- Modal footer -->
	        <div class="modal-footer">
	         <button type="button" class="btn btn-primary" onclick="saveStock()">Save</button>
	         <!-- <div onclick="saveStock()">
	         	Save
	         </div> -->
	        </div>
		</form>
      </div>
    </div>
  </div>
 <!-- End Modal -->

<script src="<%= request.getContextPath() %>/cdn/js/jquery.dataTables.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/cdn/css/jquery.dataTables.css">

<script>

function updateStock(productSkuId, stock) {
	$('#productSkuId').val(productSkuId);
	$('#stock').val(stock);
	$(".stockReq").addClass("d-none");
}

function saveStock() {
	var productSkuId = $('#productSkuId').val();
	var stock = $('#stock').val().trim();
	
	if(stock !== ""){
		$(".stockReq").addClass("d-none");
		$.ajax({
			type : "GET",
			url : updateStockURL,
			async : false,
			dataType : 'json',
			data : {
				"<portlet:namespace/>stock" : stock,
				"<portlet:namespace/>productSkuId" : productSkuId,
			},
			success : function(data) {
				location.reload();
			},
		});
	} else {
		$(".stockReq").removeClass("d-none");
	}
}

$(document).ready(function() {
    /* var table = $('#productList').DataTable(); */
    
    $('#productList').DataTable({
		"dom": '<f<"table-responsive" t><"tableFootBar"pil>>',
		"info": false, 
		"columnDefs": [
		    { 
	    		"orderable": false, 
	    		"targets": "no-sort" 
    		} // Applies the option to all columns
		],
		language: {
			paginate: {
                previous: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M5.15356 0.501202L1.1151 4.53966L5.15356 8.57812" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>',
                next: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M0.92334 8.57692L4.9618 4.53846L0.92334 0.5" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>'
              },
			 search: "_INPUT_",
			 searchPlaceholder: "Search...",
			 lengthMenu: 'Show _MENU_ ',
             entries: {
                 _: 'people',
                 1: 'person'
             }
		 }
                   
	});
    
    $("#productList_filter.dataTables_filter").append($(".addProduct"));
    $("#productList_filter.dataTables_filter").prepend('<h1 class="titlePage">Product SKU List</h1>');
    
    // Add event listener for checkbox selection
    $('#productList tbody').on('change', '.select-checkbox', function(){
        if($(this).is(':checked')){
            $(this).closest('tr').addClass('selected');
        } else {
            $(this).closest('tr').removeClass('selected');
        }
    });
    
    $('#customLoader').hide();
    
});

</script>
