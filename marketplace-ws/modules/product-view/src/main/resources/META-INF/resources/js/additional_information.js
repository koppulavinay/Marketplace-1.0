
$(document).ready(function() {
	
	document.getElementById('searchKey').addEventListener('keyup', function(event) {
		 
		 var errorLabel = $(this).siblings('label.error');
		 errorLabel.addClass('d-none');
		 
		 if (event.key === "Enter") { // Check if Enter key is pressed
			var searchKeyword = this.value.trim().toLowerCase();
			if (searchKeyword !== '') {
				var isPresent = false;
				
				$('div.chip').each(function() {
					if($(this).text().toLowerCase().includes(searchKeyword)) {
						isPresent = true;
						return false;
					}
				});

				if(isPresent) {
					errorLabel.html('Keyword already added');
					errorLabel.removeClass('d-none');
					return;
				}
				
				var chipContainer = document.getElementById('searchKeywordContainer');
				var chip = document.createElement('div');
				
				chip.classList.add('chip');
				chip.textContent = searchKeyword;
				chip.dataset.searchkeyword = searchKeyword;
				
				var closeIcon = document.createElement('span');
				closeIcon.classList.add('close-icon');
				closeIcon.innerHTML = '&times;'; // Using HTML entity for the
													// cross icon
				
				closeIcon.addEventListener('click', function() {
					chip.remove(); // Remove the chip when close icon is
									// clicked
				});
				
				chip.appendChild(closeIcon);
				chipContainer.appendChild(chip);
				
				this.value = ""; // Clear input field after adding chip
			}
       }
	 });
	
	// Event delegation for delete button functionality
	document.querySelectorAll('#items-container').forEach(element => {
		element.addEventListener('click', function(event) {
			if (event.target.classList.contains('delete-item')) {
				checkDefaultRow();
				event.target.parentElement.parentElement.parentElement.remove();
				generateSerialNumbers('packageContentTable');
			}
		});
	});
	
	document.getElementById('add-item-btn').addEventListener('click', function() {
		
		var isNotEmpty = true;
		var isNotZero = true;
		
		$('.noPackageContentError').addClass('d-none');
		
		$('#packageContentTable tbody tr').each(function() {
	        $(this).find('input.form-control').each(function() {
	            if($(this).val() == '' || parseInt($(this).val()) === 0) {
					
	            	var errorLabel = $(this).siblings('label.error');

	            	if($(this).attr('type') == 'text' && $(this).val() == '') {
	            		errorLabel.html($(this).attr('data-validationmessage'));
	            		errorLabel.removeClass('d-none');
	            		isNotEmpty = false;
	            	} else if($(this).attr('type') == 'number') {
	            		if(parseInt($(this).val()) === 0) {
	            			errorLabel.html('Quantity cannot be 0.');
	            			errorLabel.removeClass('d-none');
	            			isNotZero = false;
	            		} else {
	            			errorLabel.html($(this).attr('data-validationmessage'));
		            		errorLabel.removeClass('d-none');
		            		isNotEmpty = false;
	            		}
					}
					
				}
	        });
		});
		
		if(isNotEmpty && isNotZero) {
			addRowToPackageContentTable();
			generateSerialNumbers('packageContentTable');
		} else {
			$('#packageContentTable tbody tr input.form-control').filter(function() {
			    return $(this).val() == '';
			}).first().focus();
		}
	});
	
	$('#customLoader').hide();
	
});

var hideError = (input, index) => {
	if($(input).val()) {
		var errorLabel = $(input).siblings('label.itemError' + index);
		errorLabel.addClass('d-none');
	}
};

var showError = (input, index) => {
	if(!$(input).val()) {
		var errorLabel = $(input).siblings('label.itemError' + index);
		errorLabel.html($(input).attr('data-validationmessage'));
		errorLabel.removeClass('d-none');
	}
};

var handleFormSubmit = (formObj) => {
	if(validateForm()) {
		jQuery('<input>', {
			type: 'hidden',
			id: `${portlet_namespace}additionalInfoJson`,
			name: `${portlet_namespace}additionalInfoJson`,
			value: encodeURIComponent(`${constructAdditionalInfoJson()}`)
		}).appendTo($(formObj));
		
		$(formObj).submit();
	}
};

var saveAsDraft = form => {
	$(`#${portlet_namespace}productStatus`).val('DRAFT');
	
	jQuery('<input>', {
		type: 'hidden',
		id: `${portlet_namespace}additionalInfoJson`,
		name: `${portlet_namespace}additionalInfoJson`,
		value: encodeURIComponent(`${constructAdditionalInfoJson()}`)
	}).appendTo($(form));
	
	$(form).submit();
};

var validateTaxCategory = () => {
	if($("#taxCategory").val() == ""){
		$(".taxCategoryReq").removeClass("d-none");
		$("#taxCategory").focus();
		return false;
	} else {
		$(".taxCategoryReq").addClass("d-none");
		return true;
	}
};

var validateForm = () => {
	
	var isValid = true;
	
	isValid = validateTaxCategory();
	
	if($("#taxCategory").val() == ""){
		$(".taxCategoryReq").removeClass("d-none");
		$("#taxCategory").focus();
		isValid = false;
	} else {
		$(".taxCategoryReq").addClass("d-none");
	}
	
	if($('.item-container').length === 0) {
		$('.noPackageContentError').html('Package Content cannot be empty');
		$('.noPackageContentError').removeClass('d-none');
		isValid = false;
	}
	
	$('.noPackageContentError').addClass('d-none');
	
	$('.item-container').eq(0).find('input').each(function(index) {
		
		var errorLabel = $(this).siblings('label.itemError' + index);

    	if($(this).attr('type') == 'text' && $(this).val() == '') {
    		errorLabel.html($(this).attr('data-validationmessage'));
    		errorLabel.removeClass('d-none');
    		isValid = false;
    		return false;
    	} else if($(this).attr('type') == 'number') {
    		if(parseInt($(this).val()) === 0) {
    			errorLabel.html('Quantity cannot be 0.');
    			errorLabel.removeClass('d-none');
    			isValid = false;
        		return false;
    		} else if($(this).val() == '') {
    			errorLabel.html($(this).attr('data-validationmessage'));
        		errorLabel.removeClass('d-none');
        		isValid = false;
        		return false;
    		}
		}

	});
	
	if(isValid) {
		$('label.error').addClass('d-none');
	} else {
		$('.requiredInput').filter(function() {
		    return $(this).val() == '';
		}).first().focus();
	}
	
	return isValid;
	
};

var constructAdditionalInfoJson = () => {
	
	var searchKeywords = [];
	var packageContents = [];
	
	$('div.chip').each(function(){
		searchKeywords.push($(this).attr('data-searchkeyword'));
	});
	
	$('.item-container').each(function(){ 
		
		var item = {};
		var itemNameObj = $(this).find('.item-name');
		var itemQtyObj = $(this).find('.item-quantity');
		
		if(itemNameObj.val() && itemQtyObj.val()) {
			item.itemName = $(this).find('.item-name').val();
			item.itemQty = $(this).find('.item-quantity').val();
		}
		
		packageContents.push(item);
		
	});
	
	var additionalInfoJson = {
		'searchKeywords' : searchKeywords,
		'packageContents' : packageContents
	};
	
	return JSON.stringify(additionalInfoJson);
	
};

var addRowToPackageContentTable = () => {
	
	var itemsContainer = document.getElementById('items-container');
	  
	// Create container for new item
	var newItemContainer = document.createElement('tr');
	newItemContainer.classList.add('item-container');

	var sNoTd = '<td>1</td>';
	newItemContainer.innerHTML += sNoTd;

	var itemNameTd = `<td>
	  	<input type="text" class="form-control item-name w-100 requiredInput" 
	  		placeholder="Item name" data-validationmessage="Item Name cannot be empty" 
			oninput="hideError(this, 0);" onfocusout="showError(this, 0);" onpaste="return false;" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key);">
	  	<label class="error d-none itemError0"></label>
	</td>`;
	newItemContainer.innerHTML += itemNameTd;

	var quantityTd = `<td>
		<input type="number" class="form-control item-quantity w-100 requiredInput" min="0"
			placeholder="Quantity" data-validationmessage="Item Quantity cannot be empty" 
			oninput="hideError(this, 1);" onfocusout="validateItemQty(this, 1);" onpaste="return false;" 
			onkeydown="javascript: return ['Backspace','Delete','ArrowLeft','ArrowRight', 'Tab'].includes(event.code) ? true : !isNaN(Number(event.key)) && event.code!=='Space'"> 
		<label class="error d-none itemError1"></label>
	</td>`;
	newItemContainer.innerHTML += quantityTd;

	var deleteActionTd = `<td class="actionTd">
		<button type="button" class="btn btn-link" style="text-transform: none;">
			<i class="fas fa-trash-alt delete-item"></i>
		</button>
	</td>`;
	newItemContainer.innerHTML += deleteActionTd;

	itemsContainer.append(newItemContainer);
	
};

var generateSerialNumbers = (tableId) => {
	$('#' + tableId).find('tbody tr').each(function(index) {
		$(this).find('td').eq(0).text(index + 1);
	});
};

var checkDefaultRow = () => {
	if(($('#packageContentTable tbody tr').length - 1) === 0) {
		addRowToPackageContentTable();
	}
};

var validateItemQty = (input, index) => {
	var errorLabel = $(input).siblings('label.itemError' + index);
	
	if(parseInt($(input).val()) < 1) {
		errorLabel.html('Quantity cannot be 0.');
		errorLabel.removeClass('d-none');
	} else {
		errorLabel.addClass('d-none');
		showError(input, index);
	}
	
	$(input).val(parseInt($(input).val()));
};