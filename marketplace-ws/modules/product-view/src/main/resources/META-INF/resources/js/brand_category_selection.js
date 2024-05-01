$(document).ready(function() {

	$('select').select2();

});

if ('${brandId}' != 0) {
	$('#brand').val('${brandId}').trigger('change');
	getCategory();
}

if ('${categoryId}' != 0) {
	$('#category').val('${categoryId}').trigger('change');
}

if ('${productType}' != "") {
	$('#productType').val('${productType}').trigger('change');
}

function getCategory() {
	var brandId = $("#brand").val().trim();
	if (brandId != '') {
		$.ajax({
			type : "GET",
			url : categoryMapURL,
			async : false,
			dataType : 'json',
			data : {
				"<portlet:namespace/>brandId" : brandId
			},
			success : function(data) {
				var selectDropdown = $("#category");
				selectDropdown.empty();
				var defaultOption = new Option('Select Category', '');
				selectDropdown.append(defaultOption);
				data.categoryJson.forEach(function(category) {
					var option = new Option(category.categoryName,
							category.categoryId);
					$(option).html(category.categoryName); // Set the display text
					selectDropdown.append(option); // Append the option to the Select2 dropdown
				});
				selectDropdown.select2();
				$('#category').prop("disabled", false);
			},
		});
	} else {
		$('#category').val('').trigger('change');
		$('#category').prop("disabled", true);
	}
}

function checkFrom(form) {
	var brandId = $("#brand").val().trim();
	var categoryId = $("#category").val().trim();
	var productName = $("#<portlet:namespace/>productName").val();
	var productType = $("#productType").val().trim();

	if (productType == "") {
		$(".productTypeReq").removeClass("d-none");
		$("#productType").focus();
		return false;
	} else {
		$(".productTypeReq").addClass("d-none");
	}
	
	if (brandId == "") {
		$(".brandReq").removeClass("d-none");
		$("#brand").focus();
		return false;
	} else {
		$(".brandReq").addClass("d-none");
	}

	if (categoryId == "") {
		$(".categoryReq").removeClass("d-none");
		$("#category").focus();
		return false;
	} else {
		$(".categoryReq").addClass("d-none");
	}

	if (productName == "") {
		$(".productNameReq").removeClass("d-none");
		$("#<portlet:namespace/>productName").focus();
		return false;
	} else {
		$(".productNameReq").addClass("d-none");
	}

}