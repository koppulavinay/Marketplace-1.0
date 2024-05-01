<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<portlet:actionURL var="brandCategorySelectURL"
	name="brandCategorySelect" />

<portlet:renderURL var="viewUrl" />

<form method="post" action="${brandCategorySelectURL}"
	name="<portlet:namespace/>brandCategoryForm" id="brandCategoryForm"
	enctype="multipart/form-data">

	<input type="hidden" name="<portlet:namespace/>draftProductId"
		value="${draftProductId}"> <input type="hidden"
		id="<portlet:namespace/>productStatus"
		name="<portlet:namespace/>productStatus" value="" /> <input
		type="hidden" id="<portlet:namespace/>stepNumber"
		name="<portlet:namespace/>stepNumber" value="1" />

	<div class="container">
		<div class="addProductTitle">
			<h1 class="titlePage mt-4">Product Creation</h1>
			<%-- <div>
				<%@ include file="/last_modified_date.jsp" %>
				<button type="button" class="btn btn-outline-secondary"
					onclick="saveAsDraft(this.form);">Save as draft</button>
			</div> --%>
		</div>
	</div>


	<div class="container">

		<div class="customform stepperCustomform mb-4">
			<section class="steperBar">
				<div class="container">
					<div class="stepper-wrapper">
						<div class="stepper-item active">
							<div class="step-counter">1</div>
							<div class="step-name">Category and Brand</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">2</div>
							<div class="step-name">Product Information</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">3</div>
							<div class="step-name">Specification</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">4</div>
							<div class="step-name">Variant Creation</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">5</div>
							<div class="step-name">SKU</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">6</div>
							<div class="step-name">Additional Configuration</div>
						</div>
						<!-- <div class="stepper-item">
							<div class="step-counter">7</div>
							<div class="step-name">Product Summary</div>
						</div> -->
					</div>
				</div>
			</section>

			<h2 class="h2Form">Category Brand</h2>
			<div class="row">
				<div class="col-md-6 mb-5">
					<div class="form-group">
						<label for="productType"><liferay-ui:message
								key="productType" /><span class="requiredStar">*</span></label> <select
							class="form-control editField select2" id="productType"
							name="<portlet:namespace/>productType"
							value="${product.productType}">
							<option value="">Select Product Type</option>
							<c:forEach items="${productTypes}" var="productType">
								<option value="${productType}">${productType}</option>
							</c:forEach>
						</select> <label class="error d-none productTypeReq">Select product
							type</label>
					</div>

					<div class="form-group">
						<label for="selectBrand"><liferay-ui:message
								key="selectBrand" /><span class="requiredStar">*</span></label> <select
							class="form-control editField select2" id="brand"
							name="<portlet:namespace/>brand" onchange="getCategory()">
							<option value="">Select Brand</option>
							<c:forEach items="${brands}" var="brand">
								<option value="${brand.brandId}">${brand.brandName}</option>
							</c:forEach>
						</select> <label class="error d-none brandReq">Select brand</label>
					</div>

					<div class="form-group">
						<label for="selectCategory"><liferay-ui:message
								key="selectCategory" /><span class="requiredStar">*</span></label> <select
							class="form-control editField select2" id="category"
							name="<portlet:namespace/>category" disabled>
							<option value="">Select Category</option>
						</select> <label class="error d-none categoryReq">Select category</label>
					</div>

					<div class="form-group">
						<aui:input type="text" localized="true" label="Enter Product/Service Name<span class='requiredStar'>*</span>" name="productName"
							id="productName" value="${product.productName}" />
						<label class="error d-none productNameReq">Product name
							cannot be empty</label> 
						<label class="error d-none productNameVal">Product
							name must be between 2 to 200 characters with no special characters</label>
					</div>

					<div class="stepperBarButton">
						<a href="${viewUrl}" class="btn btn-outline-secondary bigButton">Cancel</a>
						<button type="button" class="btn btn-primary bigButton"
							onclick="submitForm(this.form);">Save & Continue</button>
					</div>

				</div>


				<div class="col-md-5 ml-auto">
					<section class="steperSlider">
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="steperCard">
							           <p> Below are the steps and guidelines to help you seamlessly navigate through the service creation process: </p>
										<div class="mb-2"><strong>Step 1:</strong> Select Service Type Choose "Service" as your desired type.
							  				<ul class="ml-3 p-0">
											    <li> Select the Brand associated with your service. </li>
											    <li>If no specific brand applies, simply choose "Unbranded." </li>
											    <li>Next, select the Category that best fits your service. </li>
											</ul>
										</div>
										<div class="mb-2"><strong>Step 2:</strong> Enter Service Details Provide the Service Name, a concise yet descriptive title for your service. 
											<ul class="ml-3 p-0">
											  <li>Enter a Short Description to give users a quick overview of what your service entails. </li>
											  <li>In the Long Description section, elaborate on the Scope of your service. </li>
											</ul>
										</div>
										<div class="mb-2"><strong>Step 3:</strong> For Service Type "Product" please ensure to fill out the mandatory specifications such as :
										  Type of Contract,
										  Billing Cycle,
										  Service Inclusions,
										  Frequency of Service,
										  Models Covered,
										  Mobilisation Period,
										  Brands Covered 
							  			</div>
							  			<p>If any of the mandatory specifications do not apply to your service, simply enter "N/A" to indicate the absence of data.</p>
							
							         </div>
								</div>
							</div>
							<div class="swiper-pagination"></div>
						</div>
					</section>
				</div>

			</div>

		</div>
	</div>
</form>

<!-- Swiper JS -->
<script src="/o/buycorp-classic-theme/js/swiper-bundle.min.js"></script>
<script>
	/* Start Steper Slider */
	var steperSlider = new Swiper(".steperSlider .swiper", {
		slidesPerView : 1,
		lazy : true,
		pagination : {
			el : ".steperSlider .swiper-pagination",
			clickable : true,
		},
	});
	/* End Steper Slider */
</script>

<script>
	$(document).ready(function() {
		$('.select2').select2();
		$('#customLoader').hide();
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

	/* function checkValidation(value) {
		let checkRegexVal = false;
		var englishRegex = new RegExp("^[a-zA-Z0-9\\s]{2,200}$");
        var hindiRegex = new RegExp('^[\u0900-\u097F0-9\\s]{2,200}$');
		if (englishRegex.test(value) != false) {
			checkRegexVal = true;
		} else if(hindiRegex.test(value) != false) {
            checkRegexVal = true;
        }
		return checkRegexVal;
	} */
	
	var saveAsDraft = form => {
		$("#<portlet:namespace/>productStatus").val('DRAFT');
		$(form).submit();
	};
	
	var submitForm = form => {
		if(checkFrom(form)) {
			$(form).submit();
		}
	};
	
	function checkValidation(value) {
        let checkRegexVal = false;
        var invalidRegex = /[^a-zA-Z0-9\s\u0900-\u097F]/;
        if(!invalidRegex.test(value) && value.length >= 2 && value.length <= 200){
            checkRegexVal = true;
        }
        return checkRegexVal;
    }

    
    function checkFrom(form){
        var brandId = $("#brand").val().trim();
        var categoryId = $("#category").val().trim();
        var productName = $("#<portlet:namespace/>productName").val().trim();
        var productType = $("#productType").val().trim();
        
        if(productType == ""){
            $(".productTypeReq").removeClass("d-none");
            $(".brandReq").addClass("d-none");
            $(".categoryReq").addClass("d-none");
            $(".productNameReq").addClass("d-none");
            $(".productNameVal").addClass("d-none");
            $("#productType").focus();
            return false;
        } else {
            $(".productTypeReq").addClass("d-none");
        }
        
        if(brandId == ""){
            $(".brandReq").removeClass("d-none");
            $(".productTypeReq").addClass("d-none");
            $(".categoryReq").addClass("d-none");
            $(".productNameReq").addClass("d-none");
            $(".productNameVal").addClass("d-none");
            $("#brand").focus();
            return false;
        } else {
            $(".brandReq").addClass("d-none");
        }
        
        if(categoryId == ""){
            $(".categoryReq").removeClass("d-none");
            $(".brandReq").addClass("d-none");
            $(".productTypeReq").addClass("d-none");
            $(".productNameReq").addClass("d-none");
            $(".productNameVal").addClass("d-none");
            $("#category").focus();
            return false;
        } else {
            $(".categoryReq").addClass("d-none");
        }
        
        if(productName == ""){
            $(".productNameReq").removeClass("d-none");
            $(".categoryReq").addClass("d-none");
            $(".brandReq").addClass("d-none");
            $(".productTypeReq").addClass("d-none");
            $(".productNameVal").addClass("d-none");
            $("#<portlet:namespace/>productName").focus();
            return false;
        } else {
            $(".productNameReq").addClass("d-none");
        }
        
        if(!checkValidation(productName)){
            $(".productNameVal").removeClass("d-none");
            $(".productNameReq").addClass("d-none");
            $(".categoryReq").addClass("d-none");
            $(".brandReq").addClass("d-none");
            $(".productTypeReq").addClass("d-none");
            $("#<portlet:namespace/>productName").focus();
            return false;
        } else{
            $(".productNameVal").addClass("d-none");
            $(".productNameReq").addClass("d-none");
        }
        
        return true;
        
    }
</script>
