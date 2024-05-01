<%@ include file="init.jsp"%>

<style>
#main-content {
	margin-left: 15px;
	margin-right: 15px;
}
</style>

<div class="mt-3">
	<liferay-ui:error key="address-api-failure" message="Unable to get Consignee Addresses due to unavailability of API resource." />
	<liferay-ui:error key="consignee-api-failure" message="Unable to get Consignee Names due to unavailability of API resource." />
</div>

<div class="container containerMob minMamTableWidth checkoutPage">
	<div class="addProductTitle">
		<h1 class="titlePage mt-4">Checkout</h1>
	</div>
	<div class="checkout-table">
		<table class="table table-bordered" id="checkoutTable">
			<thead>
				<tr>
					<th scope="col">Product</th>
					<th scope="col">Offer Price (Unit)</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commerceOrderItems}" var="commerceOrderItem"
					varStatus="counter">
					<tr class="nestedTable">
						<td>
							<div class="projectTd">
								<a href="#" class="projectPic"> <img
									src="${commerceOrderItem.getProductImageUrl()}" />
								</a>
								<div class="projectInfo">
									<a href="#" class="projectTitle">${commerceOrderItem.getProductFullName()}</a>
									<p>
										${commerceOrderItem.getProductVariant()}<br>
										Seller: ${commerceOrderItem.getSellerName()}
									</p>
								</div>
							</div>
						</td>
						<td>
							<div class="priceProduct">
								<div class="actualPrice">${commerceOrder.getCommerceCurrency().getSymbol()}
									${commerceOrderItem.getUnitPrice()}</div>
								<span class="oldPrice">${commerceOrder.getCommerceCurrency().getSymbol()}
									${commerceOrderItem.getBasePrice()}</span> <span class="greenColor">
									(${commerceOrderItem.getDiscountPercentage()}) </span>
							</div>
						</td>
						<td class="fontSize16">${commerceOrderItem.getQuantity()}</td>
						<td class="fontSize16">${commerceOrder.getCommerceCurrency().getSymbol()}
							${commerceOrderItem.getTotalAmount()}</td>
						<td><button type="button"
								class="btn btn-primary selectConsigneeBtn select-consignee-btn consignee-btn-${counter.count}"
								data-parentcartid="${commerceOrder.getCommerceOrderId()}"
								data-orderitemid="${commerceOrderItem.getCommerceOrderItemId()}"
								data-totalquantity="${commerceOrderItem.getQuantity()}"
								data-consigneebtnindex="${counter.count}"
								onclick="showConsigneeDetails(this);">${commerceOrderItem.getTotalConsignees() > 0 ? 'EDIT CONSIGNEE' : 'SELECT CONSIGNEE' }</button>
							<label class="error d-none select-consignee-error">Please
								select atleast one consignee.</label></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<div class="order-summary cartValuePage">
		<div class="cart-value">
			<ul>
				<li>SubTotal : <span>${commerceOrder.getCommerceCurrency().getSymbol()}
						${orderSubTotal}</span></li>
				<li>Tax : <span>${commerceOrder.getCommerceCurrency().getSymbol()}
						${taxAmount}</span></li>
				<li class="total-value"><strong>Total :</strong> <strong>${commerceOrder.getCommerceCurrency().getSymbol()}
						${orderTotalAmount}</strong></li>
			</ul>
		</div>
	</div>
</div>

<script
	src="<%=request.getContextPath()%>/js/main.js?ver<%=PwdGenerator.getPassword(2)%>"></script>

<script>
	var checkoutTable;
	
	var addRowToConsigneeTable = tableObj => {
		var itemsContainer = $(tableObj).find('#items-container');
	    itemsContainer.append(getConsigneeDetailsRow(tableObj));
	    
	    addRequiredValidations();
	};

	var getConsigneeDetailsRow = (tableObj) => {

		var maxQty = parseInt($(tableObj).attr('data-totalqty'), 10);
		var availableQty = getAvailableQty(tableObj);
	      
	    // Create container for new item
	    var newItemContainer = document.createElement('tr');
	    newItemContainer.classList.add('item-container');
	    
	    var shippingConsigneeName = getShippingConsigneeNamesList();
	    newItemContainer.innerHTML += shippingConsigneeName;
	    
	    var shippingConsigneeAddress = getShippingConsigneeAddressList();
	    newItemContainer.innerHTML += shippingConsigneeAddress;
	    
	    var billingConsigneeName = getBillingConsgineeNamesList();
	    newItemContainer.innerHTML += billingConsigneeName;
	    
	    var billingConsigneeAddress = getBillingConsigneeAddressList();
	    newItemContainer.innerHTML += billingConsigneeAddress;
	    
	    var quantity = getQuantity(maxQty, availableQty);
	    newItemContainer.innerHTML += quantity;

	    var actionTd = getDeleteActionHtml();
	    newItemContainer.innerHTML += actionTd;
	    
	    return newItemContainer;
		
	};
	
	var getShippingConsigneeNamesList = () => {
		return `<td>
				<select class="form-control requiredInput" data-attrname="shippingConsigneeName">
					<option value="">Select Shipping Consginee Name</option>
			    	<c:forEach items="${consigneeDetails}" var="consigneeDetails">
						<option value="${consigneeDetails.key}">${consigneeDetails.value}</option>
					</c:forEach>								
				</select>
				<label class="error d-none">Shipping Consignee Name is required.</label>
			</td>`;
	};
	
	var getShippingConsigneeAddressList = () => {
		return `<td>
				<select class="form-control requiredInput" data-attrname="shippingConsigneeAddress">
					<option value="">Select Shipping Consginee Address</option>
					<c:forEach items="${organizationAddresses}" var="address">
						<option value="${address.key}">${address.value}</option>
					</c:forEach>
				</select>
				<label class="error d-none">Shipping Consignee Address is required</label>
			</td>`;
	};
	
	var getBillingConsgineeNamesList = () => {
		return `<td>
				<select class="form-control requiredInput" data-attrname="billingConsigneeName">
					<option value="">Select Billing Consginee Name</option>
			    	<c:forEach items="${consigneeDetails}" var="consigneeDetails">
						<option value="${consigneeDetails.key}">${consigneeDetails.value}</option>
					</c:forEach>								
				</select>
				<label class="error d-none">Billing Consignee Name is required.</label>
			</td>`;
	};
	
	var getBillingConsigneeAddressList = () => {
		return `<td>
				<select class="form-control requiredInput" data-attrname="billingConsigneeAddress">
					<option value="">Select Billing Consginee Address</option>
					<c:forEach items="${organizationAddresses}" var="address">
						<option value="${address.key}">${address.value}</option>
					</c:forEach>
				</select><label class="error d-none">Billing Consignee Address is required</label>
			</td>`;
	};
	
</script>
