
$(document).ready(function() {
	
	$(`select`).select2();
	$(`.specValueLabelOptions`).select2({
		placeholder : 'Select Specification Value'
	});
	
	$('#customLoader').hide();
	
});

var showSpecCategorySection = () => {
	
	var categorizedSpecificationsSection = document.getElementById(portlet_namespace + 'categorizedSpecificationsSection');
	var selectSpecificationsSection = document.getElementById(portlet_namespace + 'selectSpecificationsSection');
	
	selectSpecificationsSection.classList.add('d-none');
	categorizedSpecificationsSection.classList.remove('d-none');
	
};

var showSpecificationsList = () => {
	
	var categorizedSpecificationsSection = document.getElementById(portlet_namespace + 'categorizedSpecificationsSection');
	var selectSpecificationsSection = document.getElementById(portlet_namespace + 'selectSpecificationsSection');
	
	selectSpecificationsSection.classList.remove('d-none');
	categorizedSpecificationsSection.classList.add('d-none');
	
};

var enableAddSpecificationBtn = specificationValue => {
	
	if(!specificationValue)
		showHideSpecificationError('hideError');
	
	var addSpecificationBtn = $(`#${portlet_namespace}addSpecification`);
	
	if(specificationValue) {
		addSpecificationBtn.prop('disabled', false);
	} else {
		addSpecificationBtn.prop('disabled', true);
	}
	
}

var getSpecValuesBySpecId = async (specificationId, specificationLabel, specificationFieldTypeId, specificationFieldDataTypeId) => {
	
	var requestBody = {
		'specificationId' : specificationId,
		'specificationLabel' : specificationLabel,
		'specificationFieldTypeId' : specificationFieldTypeId,
		'specificationFieldDataTypeId' : specificationFieldDataTypeId
	};
	
	const response = await fetch(getSpecValuesBySpecIdURL, {
		method : 'POST',
		body : JSON.stringify(requestBody)
	});
	
	const data = await response.text();
	
	if(data) {
		
		var specificationValuesJson = JSON.parse(data);
		
		constructSpecificationDetails(specificationValuesJson);
		
	}
	
};

var addSpecification = () => {
	
	var approvedSpecification = document.getElementById(portlet_namespace + 'approvedSpecifications');
	
	if(approvedSpecification.value) {
		
		var selectedOption = approvedSpecification.options[approvedSpecification.selectedIndex];
		var specificationLabel = selectedOption.dataset.specificationlabel;
		
		if(isSpecificationSelected(specificationLabel)) {
			showHideSpecificationError('showError');
			return;
		}
		
		showHideSpecificationError('hideError');
		
		var specificationId = selectedOption.dataset.specificationid;
		var specificationFieldTypeId = selectedOption.dataset.specificationfieldtypeid;
		var specificationFieldDataTypeId = selectedOption.dataset.specificationfielddatatypeid;
		
		getSpecValuesBySpecId(specificationId, specificationLabel, specificationFieldTypeId, specificationFieldDataTypeId);
		
	}
	
};

var selectSpecification = curObj => {
	
	var specificationLabel = curObj.dataset.specificationlabel;
	
	
	var specificationErrorLabel = $(curObj).parent().siblings('td').find('label.error');

	if(isSpecificationSelected(specificationLabel)) {
		specificationErrorLabel.html('Specification already selected');
		specificationErrorLabel.removeClass('d-none');
		return;
	}
	
	specificationErrorLabel.addClass('d-none');
	
	var specificationId = curObj.dataset.specificationid;
	var specificationFieldTypeId = curObj.dataset.specificationfieldtypeid;
	var specificationFieldDataTypeId = curObj.dataset.specificationfielddatatypeid;
	
	getSpecValuesBySpecId(specificationId, specificationLabel, specificationFieldTypeId, specificationFieldDataTypeId);
	
}

var constructSpecificationDetails = specificationValuesJson => {

	var specificationFieldType = specificationValuesJson.specFieldTypeName;
	
	var selectedSpecificationsTable = document.getElementById(`${portlet_namespace}selectedSpecifications`);
	var tableBody = selectedSpecificationsTable.querySelector('tbody');
	
	var specificationValueInput;
	var specificationValueUOMInput;
	
	var specificationValues = specificationValuesJson.specificationValues;
	
	var specValueUOMOptions = '<option value="">Select Specification UOM</option>';
	specValueUOMOptions += `<option value="${specificationValues[0].specificationValueUOM}" selected>${specificationValues[0].specificationValueUOM}</option>`;
	
	specificationValueUOMInput = `<select id="${portlet_namespace}specValueUOMOptions" class="form-control" data-attrname="specificationValueUOM" data-validationmessage="Select Specification UOM" onchange="removeError(this);">${specValueUOMOptions}</select>`;
	
	if(specificationFieldType.includes('Free Text')) {
		
		specificationValueInput = `<input class="form-control" type="text" value="" id="${portlet_namespace}specificationValueLabel" data-productspecvalueid="0" data-attrname="specificationValueLabel" data-validationmessage="Enter Specification Value" oninput="removeError(this);" /><br>
									<label class="d-none error specificationValueError"></label>`;
		
	} else {
		
		var specValueLabelOptions = '<option value="">Select Specification Value</option>';
		
		specificationValues.forEach(specificationValue => {
			specValueLabelOptions += `<option value="${specificationValue.specificationValueId}" data-productspecvalueid="0">${specificationValue.specificationValueLabel} ${specificationValues[0].specificationValueUOM}</option>`;
		});
		
		var multiSelect = '';
		
		if(specificationFieldType.includes('Multi Select'))
			multiSelect = 'multiple';
		
		specificationValueInput = `<select class="specValueLabelOptions form-control" ${multiSelect} data-attrname="specificationValueLabel" data-validationmessage="Select Specification Value" onchange="removeError(this);">${specValueLabelOptions}</select><br>
									<label class="d-none error specificationValueError"></label>`;
		
	}
	
	var tableRow = `<tr id="row_${specificationValuesJson.specificationId}" class="specification-row">
		<td>
		<input type="hidden" value="${specificationValuesJson.specificationId}" data-attrname="specificationId" />
		<input type="hidden" value="${specificationValuesJson.specificationLabel}" data-attrname="specificationLabel" />
		<input type="hidden" value="${specificationFieldType}" data-attrname="specificationFieldType" />
		<input type="hidden" value="false" data-attrname="isMandatory" />
		${specificationValuesJson.specificationLabel}
		</td>
		<td>${specificationValueInput}</td>
		<td class="d-none">${specificationValueUOMInput}</td>
		<td class="lastTd">
		<button type="button" class="btn btn-link" onclick="deleteSpecification(${specificationValuesJson.specificationId});">
		<i class="fas fa-trash-alt"></i>
		</button>
		</td>
		</tr>`; 
	
	$(tableBody).append(tableRow);
	
	$('select').select2();
	
	$(`.specValueLabelOptions`).select2({
		placeholder : 'Select Specification Value'
	});

};

var deleteSpecification = specificationId => {
	$('.selectSpecificationError').addClass('d-none');
	$('.specCategoryError').addClass('d-none');
	$(`#row_${specificationId}`).remove();
}


var isSpecificationSelected = specificationLabel => {
	
	var isSelected = false;
	
	var selectedSpecificationsTable = document.getElementById(`${portlet_namespace}selectedSpecifications`);
	var tableRows = selectedSpecificationsTable.querySelectorAll('tbody tr');
	
	tableRows.forEach(row => {
		if(row.childNodes[1].innerText.trim() === specificationLabel.trim()) {
			isSelected = true;
			return;
		}
	});
	
	return isSelected;
	
}

var showHideSpecificationError = errorType => {
	
	var selectSpecificationError = $('.selectSpecificationError');
	
	if(errorType === 'showError') {
		selectSpecificationError.html('Specification Already Added');
		selectSpecificationError.removeClass('d-none');
	} else if(errorType === 'hideError') {
		selectSpecificationError.html('');
		selectSpecificationError.addClass('d-none');
	}
	
};

var handleFormSubmit = (formObj) => {
	
	var isFormValid = validateForm();
	
	if(isFormValid) {
		jQuery('<input>', {
			type: 'hidden',
			id: `${portlet_namespace}specificationsJSON`,
			name: `${portlet_namespace}specificationsJSON`,
			value: encodeURIComponent(`${constructSpecificationsJson()}`)
		}).appendTo($(formObj));
		
		$(formObj).submit();
	}
	
};

var saveAsDraft = form => {
	$(`#${portlet_namespace}productStatus`).val('DRAFT');
	
	jQuery('<input>', {
		type: 'hidden',
		id: `${portlet_namespace}specificationsJSON`,
		name: `${portlet_namespace}specificationsJSON`,
		value: encodeURIComponent(`${constructSpecificationsJson()}`)
	}).appendTo($(form));
	
	$(form).submit();
};

var validateForm = () => {
	
	var isValid = true;
	
	$(`#${portlet_namespace}selectedSpecifications tbody tr`).each(function() {
		
		$(this).find('input[type="text"], select, select[multiple]').each(function() {
			if($(this).val() == false) {
				if(!($(this).attr('data-attrname') == 'specificationValueUOM')) {
                    var errorLabel = $(this).siblings('label.error');
    				errorLabel.removeClass('d-none');
    				errorLabel.html($(this).attr('data-validationmessage'));
    				
    				isValid = false;
                }
			}
		});
		
	});
	
	if(isValid)
		$('label.error').addClass('d-none');
	
	return isValid;
	
};


var removeError = curObj => {
	
	$(curObj).siblings('label.error').addClass('d-none');
	
};

var constructSpecificationsJson = () => {
	
	var specificationsArray = [];
	
	$(`#${portlet_namespace}selectedSpecifications tbody tr`).each(function() {
		
		var specificationJsonObj = {};
		
		$(this).find('input[type="text"], input[type="hidden"], select, select[multiple]').each(function() {
			
			var key = $(this).attr('data-attrname');
			var value = $(this).val();
			
			if(key === 'specificationValueLabel') {
				
				var specificationValues = [];
				var specificationValuesArray = [];
				
				if($(this).attr('multiple')) {
					
					$(this).find('option:selected').each(function() {
						specificationValuesArray.push({
							'specificationValueId' : $(this).val(),
							'productSpecValueId' : $(this).attr('data-productspecvalueid'),
							'specificationValueLabel' : $(this).text().trim()
						});
					})
					
					//specificationValuesArray = [...$(this).val()];
				} else if($(this).find('option').length) {
					$(this).find('option:selected').each(function() {
						specificationValuesArray.push({
							'specificationValueId' : $(this).val(),
							'productSpecValueId' : $(this).attr('data-productspecvalueid'),
							'specificationValueLabel' : $(this).text().trim()
						});
					})
				} else {
					var specification = {
						'specificationValueId' : '',
						'productSpecValueId' : $(this).attr('data-productspecvalueid'),
						'specificationValueLabel' : value
					};
					
					specificationValuesArray.push(specification);
				}
				
				specificationValues = [...specificationValuesArray];
				value = specificationValues;
				
			}
			
			specificationJsonObj[key] = value;
			
		});
		
		specificationsArray.push(specificationJsonObj);
		
	});
	
	var formJson = {
		"specifications" : specificationsArray
	};
	
	return JSON.stringify(formJson);
	
};
