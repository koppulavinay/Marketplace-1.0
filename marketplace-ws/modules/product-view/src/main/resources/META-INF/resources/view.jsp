<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<portlet:renderURL var="brandCategorySelectURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%= ProductViewPortletKeys.BRAND_CATEGORY_SELECT_RENDER_CMD %>" />
</portlet:renderURL>

<portlet:actionURL var="editProductURL"
	name="<%=ProductViewPortletKeys.EDIT_PRODUCT_STEP_ACTION_CMD%>" />

<c:set var="editURL" value="${editProductURL}&draftProductId=" />

<liferay-ui:success key="success-key"
	message="Product Details Saved Successfully!" />

<section class="mt-3">

	<div class="container containerMob minMamTableWidth mt-3">
	<a href="${brandCategorySelectURL}" class="btn btn-primary addProduct ml-2">Add Product</a>

		<table id="productList" class="w-100">
			<thead>
				<tr>
					<th scope="col" class="no-sort"></th>
					<th scope="col" class="no-sort">Image</th>
					<th scope="col">Product ID</th>
					<th scope="col" width="150px">Product Name</th>
					<th scope="col" width="150px">Category</th>
					<th scope="col">Brand</th>
					<th scope="col">Status</th>
					<th scope="col">Created Date</th>
					<th scope="col" class="no-sort">Action</th>
				</tr>
			</thead>
			<tbody>
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
						<td>${product.getCategoryName()}</td>
						<td>${product.getBrandName()}</td>
						<td style="text-transform: capitalize;">${product.getStatus()}</td>
						<td width="15%">${product.getCreateDate()}</td>
						<td><a href="${editURL}${product.getProductId()}"
							class="btn btn-link"><i class="icon-pencil"></i></a>
							<button type="button" class="btn btn-link" onclick="sendDraftProductId('${product.getProductId()}')" data-toggle="modal" data-target="#dltProduct">
								<i class="fas fa-trash-alt"></i>
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</section>

<!-- Start Modal -->
  <div class="modal fade" id="dltProduct">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">

        <button type="button" class="close" data-dismiss="modal"></button>

        <!-- Modal Header -->
        <div class="modal-header">
          <div class="modal-title">Delete Product</div>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <p>Are you sure you want to delete product?</p>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
        <button type="button" class="btn btn-outline-secondary cancelbtn" data-dismiss="modal">Cancel</button>
         <button type="button" class="btn btn-primary deletebtn" id="deleteModelYesBtn" onclick="deleteProduct(this.dataset.draftproductid);" data-draftproductid="">Delete</button>
        </div>

      </div>
    </div>
  </div>
 <!-- End Modal -->


<script
	src="<%= request.getContextPath() %>/cdn/js/jquery.dataTables.js?ver<%= PwdGenerator.getPassword(2) %>"></script>
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/cdn/css/jquery.dataTables.css">


<script>
$(document).ready(function() {
debugger;
    /* var table = $('#productList').DataTable(); */
    if('${umsApifailure}'.includes('Unable')){
        alert('${umsApifailure}');
    }
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
    $("#productList_filter.dataTables_filter").prepend('<h1 class="titlePage">Product List</h1>');
    
    

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


function deleteProduct(productId) {
    console.log("Inside edit product");
    		$.ajax({
    			url : '${deleteProductResourceCommandURL}',
    			data : {
    				"productId" : productId
    			},
    			success : function(data) {
                    location.reload();
    			},
    		});
    	}

var sendDraftProductId = draftProductId => {
    $('#deleteModelYesBtn').attr('data-draftproductid', draftProductId);
}

</script>
