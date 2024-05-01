$(document).ready(function() {
	$('#customLoader').hide();
});
var validateForm = () => {
	
	var isFormValid = true;
	
	var shortDescription = document.getElementById(portlet_namespace + 'shortDescription');
	var shortDescriptionError = document.querySelector('.shortDescriptionError');
	
	var longDescription = document.getElementById(portlet_namespace + 'longDescription_en_US');
	var longDescriptionError = document.querySelector('.longDescriptionError');
	
	if (!shortDescription.value) {
		shortDescriptionError.innerHTML = 'Enter Short Description';
		shortDescriptionError.classList.remove('d-none');
		shortDescription.focus();
		return false;
	} else if (shortDescription.value.length < 10 || shortDescription.value.length > 255) {
		shortDescriptionError.innerHTML = 'Short Description must be between 10 to 255 characters';
		shortDescriptionError.classList.remove('d-none');
		shortDescription.focus();
		return false;
	} else if (!isValidShortDescription(shortDescription.value)) {
	    shortDescriptionError.innerHTML = 'Short Description can only contain alphanumeric characters and spaces';
	    shortDescriptionError.classList.remove('d-none');
	    shortDescription.focus();
	    return false;
	} else {
		shortDescriptionError.innerHTML = '';
		shortDescriptionError.classList.add('d-none');
	}
	
	// Replacing HTML Tags from Long Description and calculating its length.
	//var longDescriptionLength = longDescription.value?.replace(/(<([^>]+)>)/ig, '').length;
	var longDescriptionLength = longDescription.value.length;
	
	if (!longDescription.value) {
		longDescriptionError.innerHTML = 'Enter Long Description';
		longDescriptionError.classList.remove('d-none');
		longDescription.focus();
		return false;
	} else if (longDescriptionLength < 255 || longDescriptionLength > 5000) {
		longDescriptionError.innerHTML = 'Long Description must be between 255 to 5000 characters';
		longDescriptionError.classList.remove('d-none');
		longDescription.focus();
		return false;
	} else {
		longDescriptionError.innerHTML = '';
		longDescriptionError.classList.add('d-none');
	}
	
	return isFormValid;
	
};

function isValidShortDescription(shortDescription) {
	var invalidRegex = /[^a-zA-Z0-9\s]/;
    return !invalidRegex.test(shortDescription);
}

var submitForm = form => {
	if(validateForm()) {
		$(form).submit();
	}
};

var saveAsDraft = form => {
	$(`#${portlet_namespace}productStatus`).val('DRAFT');
	$(form).submit();
};
