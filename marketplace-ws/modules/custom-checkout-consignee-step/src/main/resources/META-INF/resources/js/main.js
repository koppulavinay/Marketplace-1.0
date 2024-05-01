var MAX_QTY_LIMIT_ERROR = 'Maximum limit reached';
var ZERO_QTY_ERROR = 'Quantity should be equal or more than 1';
var QTY_REQUIRED_ERROR = 'Quantity is required';

$(document).ready(function() {
	addRequiredValidations();
	
	checkoutTable = new DataTable('#checkoutTable', {
		"dom": '<f<"table-responsive" t><"tableFootBar"pil>>',
		columnDefs: [
			{ 
				targets: 'nestedTable', 
				type: 'html' 
			},
		],
		paging : true,
		searching : false,
		lengthChange : false,
		"bInfo" : false,
		language: {
			paginate: {
                previous: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M5.15356 0.501202L1.1151 4.53966L5.15356 8.57812" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>',
                next: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M0.92334 8.57692L4.9618 4.53846L0.92334 0.5" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>'
			},
		 }
	});
	
});

var addDeleteRowEvent = () => {
	document.querySelectorAll('#items-container').forEach(element => {
		element.addEventListener('click', function(event) {
			if (event.target.classList.contains('delete-item')) {
				event.target.parentElement.parentElement.parentElement.remove();
				$(event.target).closest('table').attr('data-changed', true);
			}
		});
	});
};

var addConsigneeRowEvent = () => {
	$('.add-item-btn').on('click', function() {
		var table = $(this).closest('table');
		$(table).attr('data-changed', true);

		if(areConsigneeDetailsValid(table)) {
			//updateMaxQtyLimit(table);
			addRowToConsigneeTable(table);
		}
	});
};

var areConsigneeDetailsValid = (tableObj) => {
	
	var isNotEmpty = true;
	
	$(tableObj).find('.requiredInput').each(function() {
		if($(this).val() == '') {
			isNotEmpty = false;
			$(this).siblings('label.error').eq(0).removeClass('d-none');
		}
	});

	if(!isNotEmpty)
	    return false;

	if(!isQuantityAvailable(tableObj)) {
		$(tableObj).find('.qtyError').removeClass('d-none');
		$(tableObj).find('.qtyError').text(MAX_QTY_LIMIT_ERROR);
		return false;
	} else if($(tableObj).find('.quantity').length != 0) {

	    var isValid = true;

	    $(tableObj).find('.quantity').each(function() {
	        if(!isQuantityValid($(this))) {
	            isValid = false;
                $(this).siblings('.qtyError').eq(0).removeClass('d-none');
                $(this).siblings('.qtyError').eq(0).text(ZERO_QTY_ERROR);
            } else {
                $(this).siblings('.qtyError').eq(0).addClass('d-none');
            }
	    });

	    return isValid;

	} else {
		$(tableObj).find('.qtyError').addClass('d-none');
	}
	
	return isNotEmpty;
};

var addRequiredValidations = () => {
	$('.requiredInput').on('change', function() {
		$(this).closest('table').attr('data-changed', true);
		if($(this).val()) {
			$(this).siblings('label.error').eq(0).addClass('d-none');
		} else {
			$(this).siblings('label.error').eq(0).removeClass('d-none');
		}
	});
};

var updateMaxQtyLimit = (table) => {
	$(table).find('.quantity').each(function() {
		$(this).attr('max', parseInt($(table).attr('data-totalqty'), 10));
	});
};

/*var validateQuantity = (currObj) => {
	$(currObj).val($(currObj).val().replace(/[^0-9]/gi, ''));
	
	$(currObj).on('focusout', function() {
		if(!isQuantityValid($(this))) {
			$(this).focus();
			$(this).siblings('.qtyError').removeClass('d-none');
		} else {
			$(this).siblings('.qtyError').addClass('d-none');
		}
	});
};*/

var isQtyLessThanOne = (qtyInput) => {
    return parseInt($(qtyInput).val(), 10) < 1;
};

var getSumOfQty = (table) => {
    var sum = 0;

    table.find('.quantity').each(function() {
        sum += parseInt($(this).val(), 10);
    });

    return sum;
};

var validateQuantity = (currObj) => {

    var table = $(currObj).closest('table');

    $(table).find('.quantity').each(function() {
        if(parseInt($(this).val(), 10) > 0)
            $(this).siblings('.qtyError').eq(0).addClass('d-none');
    });

    if(isQtyLessThanOne(currObj)) {
        $(currObj).siblings('.qtyError').text(ZERO_QTY_ERROR);
        $(currObj).siblings('.qtyError').removeClass('d-none');
        return false;
    }

    $(currObj).siblings('.qtyError').removeClass('d-none');

    var totalQty = parseInt(table.attr('data-totalqty'), 10);

    var sum = getSumOfQty(table);

    if(sum > totalQty) {
        $(currObj).focus();
        $(currObj).siblings('.qtyError').text(MAX_QTY_LIMIT_ERROR);
        $(currObj).siblings('.qtyError').removeClass('d-none');
        return false;
    } else {
        $(currObj).siblings('.qtyError').addClass('d-none');
        return true;
    }

};

var isQuantityValid = (quantityInput) => {
    return parseInt($(quantityInput).val(), 10) > 0;
};

var isQuantityAvailable = tableObj => {
	
	if($(tableObj).find('.quantity').length == 0)
		return true;
	
	var totalQty = parseInt($(tableObj).attr('data-totalqty'), 10);
	var quantitySum = 0;
	
	$(tableObj).find('.quantity').each(function() {
		quantitySum += parseInt($(this).val(), 10);
	});
	
	return totalQty > quantitySum;
	
};

/*var isQuantityValid = (quantityInput) => {
	return parseInt($(quantityInput).val()) <= parseInt($(quantityInput).attr('max'));
};*/

var getAvailableQty = tableObj => {
	
	var totalQty = parseInt($(tableObj).attr('data-totalqty'), 10);
	var quantitySum = 0;
	
	$(tableObj).find('.quantity').each(function() {
		quantitySum += parseInt($(this).val(), 10);
	});
	
	return totalQty - quantitySum;
};

var saveCheckoutDetails = (currObj) => {
	$('.consignee-details-table').each(function() {
		var selectConsigneeBtn = $(this).attr('data-consigneebtn');

		if($(this).find('tbody tr').length == 1) {
			$('.' + selectConsigneeBtn).siblings('.consigneeError').removeClass('d-none');
			return;
		} else {
			$('.' + selectConsigneeBtn).siblings('.consigneeError').addClass('d-none');
		}
	});
};

var showConsigneeDetails = async currObj => {
	
	var tr = $(currObj).closest('tr');
	var row = checkoutTable.row(tr);
	
	if(row.child.isShown())
		return;
	
	$(currObj).siblings('.consigneeError').addClass('d-none');
	
	var parentCartId = $(currObj).attr('data-parentcartid');
	var orderItemId = $(currObj).attr('data-orderitemid');
	var totalQuantity = parseInt($(currObj).attr('data-totalquantity'), 10);
	var consigneeBtnIndex = $(currObj).attr('data-consigneebtnindex');
	
	const response = await fetch(getConsigneeDetailsURL, {
		method : 'POST',
		body : JSON.stringify({
			'parentCartId' : parentCartId,
			'orderItemId' : orderItemId
		})
	});
	
	const data = await response.json();
	
	if(data) {
		
		var orderConsigneeDetails = data.orderConsigneeDetails;
		var consigneeDetails = '';
		
		orderConsigneeDetails.forEach(consignee => {
			var tr = `<tr class="item-container" data-checkoutconsigneeid="${consignee.checkoutConsigneeId}">`;
			tr += getConsgineeDetailsHTML(consignee, totalQuantity);
			
			consigneeDetails += tr;
		});
		
		if(!consigneeDetails) {
			consigneeDetails += getShippingConsigneeNames() + getShippingConsigneeAddresses() + getBillingConsgineeNames() + 
				getBillingConsigneeAddresses() + getQuantity(totalQuantity, totalQuantity) + getDeleteActionHtml();
		}
		
    	var consigneeDetailsDiv = getConsigneeDetailsDivHtml(totalQuantity, consigneeBtnIndex, consigneeDetails, parentCartId, orderItemId);
    	
    	row.child(consigneeDetailsDiv).show();
    	tr.addClass('shown');
		
		addConsigneeRowEvent();
		addDeleteRowEvent();
		addRequiredValidations();
		
	}
	
};

var getConsgineeDetailsHTML = (consignee, quantity) => {
	
	var shippingConsignees = consignee.shippingConsignees;
	var shippingConsigneeAddresses = consignee.shippingConsigneeAddresses;
	var billingConsignees = consignee.billingConsignees;
	var billingConsigneeAddresses = consignee.billingConsigneeAddresses;

	var shippingConsigneeOptions = '';
	var shippingConsigneeAddressOptions = '';
	var billingConsigneeOptions = '';
	var billingConsigneeAddressOptions = '';
	
	shippingConsignees.forEach(shippingConsignee => {
		shippingConsigneeOptions += createDropdownOptions(shippingConsignee.userId, shippingConsignee.userName, shippingConsignee.isSelected);
	});
	
	shippingConsigneeAddresses.forEach(shippingConsigneeAddress => {
		shippingConsigneeAddressOptions += createDropdownOptions(shippingConsigneeAddress.organizationAddressId, shippingConsigneeAddress.organizationAddress, shippingConsigneeAddress.isSelected);
	});
	
	billingConsignees.forEach(billingConsignee => {
		billingConsigneeOptions += createDropdownOptions(billingConsignee.userId, billingConsignee.userName, billingConsignee.isSelected);
	});
	
	billingConsigneeAddresses.forEach(billingConsigneeAddress => {
		billingConsigneeAddressOptions += createDropdownOptions(billingConsigneeAddress.organizationAddressId, billingConsigneeAddress.organizationAddress, billingConsigneeAddress.isSelected);
	});
	
	var shippingConsigneeDropdown = getShippingConsigneeNames(shippingConsigneeOptions);
	var shippingConsigneeAddressDropdown = getShippingConsigneeAddresses(shippingConsigneeAddressOptions);
	var billingConsigneeDropdown = getBillingConsgineeNames(billingConsigneeOptions);
	var billingConsigneeAddressDropdown = getBillingConsigneeAddresses(billingConsigneeAddressOptions);
	var quantityDropdown = getQuantity(quantity, consignee.quantity > 0 ? consignee.quantity : quantity);
	var deleteButtonHtml = getDeleteActionHtml();
	
	return shippingConsigneeDropdown + shippingConsigneeAddressDropdown + billingConsigneeDropdown + billingConsigneeAddressDropdown + quantityDropdown + deleteButtonHtml;
};

var getConsigneeDetailsDivHtml = (totalQuantity, consigneeBtnIndex, consigneeDetails, parentCartId, orderItemId) => {
	return `<div id="">
			<p class="pt-2"><strong>Shipping & Billing Consignee Details</strong></p>
			<div class="table-responsive">
				<table class="table table-bordered consignee-details-table"
					data-totalqty="${totalQuantity}"
					data-consigneebtn="consignee-btn-${consigneeBtnIndex}"
					data-changed="false">
					<thead>
						<tr>
							<th>Shipping Consignee Name<span class="requiredStar">*</span></th>
							<th>Shipping Consignee Address<span
							class="requiredStar">*</span></th>
							<th>Billing Consignee Name<span class="requiredStar">*</span></th>
							<th>Billing Consignee Address<span
							class="requiredStar">*</span></th>
							<th>Quantity<span class="requiredStar">*</span></th>
							<th width="80px" class="actionTd">Action</th>
						</tr>
					</thead>
					<tbody id="items-container">
						${consigneeDetails}
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" class="text-right">
								<button type="button"
									class="btn btn-link pl-0 pr-0 add-item-btn">ADD
									VALUE</button>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<div class="bottomBarButton">
				<button class="btn btn-primary pull-right" type="button" data-parentcartid="${parentCartId}" data-orderitemid="${orderItemId}" data-totalquantity="${totalQuantity}" onclick="saveConsigneeDetails(this);">Save Details</button>
			</div>
		</div>`;
};

var checkTotalQuantityOfConsignee = (tableObj) => {
	
	var quantitySum = $(tableObj).find('.quantity').toArray().reduce(function(acc, input) {
	    var quantity = parseFloat($(input).val()) || 0;
	    return acc + quantity;
	}, 0);
	
	var totalQuantity = parseInt($(tableObj).attr('data-totalqty'));
	
	return quantitySum == totalQuantity; 
	
};

var saveConsigneeDetails = async currObj => {
	
	var table = $(currObj).closest('table table');

	if(!areConsigneeDetailsValid(table))
		return false;	
	
	table = $(currObj).parent().siblings('.table-responsive').find('table');

	if(!checkTotalQuantityOfConsignee(table)) {
		alert('Add more consignees or increase quantity to match total.');
		return false;
	} else {
		$(currObj).siblings('.addMoreConsigneesError').addClass('d-none');
	}
	
	var parentCartId = $(currObj).attr('data-parentcartid');
	var orderItemId = $(currObj).attr('data-orderitemid');
	
	var consigneeDetailsJson = constructConsigneeDetailsJson(table, parentCartId, orderItemId);
	
	const response = await fetch(saveConsigneeDetailURL, {
		method : 'POST',
		body : consigneeDetailsJson
	});
	
	const data = await response.text();
	
	if(data == 'save-sucess') {
		$(currObj).closest('tr').prev('tr').find('.select-consignee-btn').text('EDIT CONSIGNEE');
		
		var tr = $(currObj).closest('tr').prev('tr');
		var row = checkoutTable.row(tr);
		
		if (row.child.isShown()) {
	        row.child.hide();
	        tr.removeClass('shown');
	    }
		
		alert('Consignee Details Saved Successfully!!');
	}
	
};

var constructConsigneeDetailsJson = (table, parentCartId, orderItemId) => {
	var consignees = [];
	
	$(table).find('tbody tr').each(function() {
		var consignee = {};
		
		consignee.checkoutConsigneeId = $(this).attr('data-checkoutconsigneeid');
		
		$(this).find('.requiredInput').each(function() {
			var attrName = $(this).attr('data-attrname');
			var value = $(this).val();
			
			consignee[attrName] = value;
		});

		if(Object.keys(consignee).length)
			consignees.push(consignee);
	});
	
	var consigneeDetails = {
		'parentCartId' : parentCartId,
		'orderItemId' : orderItemId,
		'consignees' : consignees
	};
	
	return JSON.stringify(consigneeDetails);
	
};

var areConsigneeSelected = () => {
	
	var areConsigneeDetailsFilled = true;
	
	$('.select-consignee-btn').each(function() {
		if($(this).text().trim() != 'EDIT CONSIGNEE') {
			$(this).siblings('.select-consignee-error').removeClass('d-none');
			areConsigneeDetailsFilled = false;
		} else {
			
			var table = $(this).closest('tr').siblings('tr').eq(0).find('table');
			
			if($(table).attr('data-changed') == 'true') {
                areConsigneeDetailsFilled = false;
				alert('Please save consginee details before proceeding further.');
				var scrollPos =  $(table).offset().top;
				$(window).scrollTop(scrollPos);
			}
			
			$(this).siblings('.select-consignee-error').addClass('d-none');
		}
	});
	
	return areConsigneeDetailsFilled;
	
};

var submitConsigneeDetails = async () => {
	
	if(areConsigneeSelected()) {
		const response = await fetch(submitConsigneeDetailsURL, {
			method : 'POST'
		});
		
		const data = await response.text();
		
		if(data === 'redirect-to-order-summary')
			$(`#${portlet_namespace}continue`).click();
	}
	
};

var createDropdownOptions = (optionValue, optionLabel, isSelected) => {
	
	return `<option value="${optionValue}" ${isSelected ? 'selected' : ''}>${optionLabel}</option>`;
	
};

var getShippingConsigneeNames = (shippingConsigneeOptions = '') => {
	return `<td>
			<select class="form-control requiredInput" data-attrname="shippingConsigneeName">
				<option value="">Select Shipping Consginee Name</option>
				${shippingConsigneeOptions}
			</select>
			<label class="error d-none">Shipping Consignee Name is required.</label>
		</td>`;
};

var getShippingConsigneeAddresses = (shippingConsigneeAddressOptions = '') => {
	return `<td>
			<select class="form-control requiredInput" data-attrname="shippingConsigneeAddress">
				<option value="">Select Shipping Consginee Address</option>
				${shippingConsigneeAddressOptions}
			</select>
			<label class="error d-none">Shipping Consignee Address is required</label>
		</td>`;
};

var getBillingConsgineeNames = (billingConsigneeOptions = '') => {
	return `<td>
			<select class="form-control requiredInput" data-attrname="billingConsigneeName">
				<option value="">Select Billing Consginee Name</option>
		    	${billingConsigneeOptions}								
			</select>
			<label class="error d-none">Billing Consignee Name is required.</label>
		</td>`;
};

var getBillingConsigneeAddresses = (billingConsigneeAddressOptions ='') => {
	return `<td>
			<select class="form-control requiredInput" data-attrname="billingConsigneeAddress">
				<option value="">Select Billing Consginee Address</option>
				${billingConsigneeAddressOptions}
			</select><label class="error d-none">Billing Consignee Address is required</label>
		</td>`;
};

var getQuantity = (maxQtyLimit, availableQty = 1) => {
	return '<td>' +
				'<input class="form-control requiredInput quantity" type="number" name="' + portlet_namespace + 'quantity" data-attrname="quantity" min="1" max="'+ maxQtyLimit +'" placeholder="Enter Quantity" value="'+ availableQty +'" onfocusout="validateQuantity(this);" />' +
				'<label class="error d-none">Quantity is required</label><label class="error d-none qtyError">Maximum limit reached</label>' +
		'</td>';
};

var getDeleteActionHtml = () => {
	return `<td class="actionTd">
			<button type="button" class="btn btn-link" style="text-transform: none;"> 
				<i class="fas fa-trash-alt delete-item"></i>
			</button>
		</td>`;
};
