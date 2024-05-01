<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
<!-- <link rel="stylesheet" href="https://nickpiesco.github.io/alloy-ui-font-awesome-cheatsheet/css/style.css"> -->

<portlet:defineObjects />

<portlet:actionURL var="createBrandURL" name="createBrand" />

<portlet:renderURL var="dashboardURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:error key="error-key" message="Brand Creation Failed" />


<div class="c-loader d-none">
    <span></span>
</div>

<form method="post" action="${createBrandURL}" onsubmit="return checkBrandFrom(this)" 
	name="<portlet:namespace/>myForm" id="brandForm" enctype="multipart/form-data">
	<div class="container">
		<div class="titleBar">
			<h1 class="titlePage">Create Brand</h1>
		</div>
		<div class="customform row mb-4">
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandCode"><liferay-ui:message key="brandCode" /></label>
					<input type="text" id="brandCode" class="form-control editField" name="<portlet:namespace/>brandCode" onblur="brandCodeVal()" 
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9]/.test(event.key)" maxlength="255">
					<label class="error d-none brandCodeVal">Brand code already exists.</label>
					<label class="error d-none brandCodeInvalid">Invalid input</label>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandName"><liferay-ui:message key="brandName" /><span class="requiredStar">*</span></label>
					<input type="text" id="brandName" class="form-control capitalize-first editField" name="<portlet:namespace/>brandName" onblur="brandNameVal()" 
						onpaste="return false;"  onkeydown="return /[a-zA-Z\s]/.test(event.key)"  maxlength="255">
					<label class="error d-none brandNameInvalid">Invalid input</label>
					<label class="error d-none brandNameVal">Brand name already exists.</label>
					<label class="error d-none brandNameReq">This field cannot be left blank.</label>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="brandDescription"><liferay-ui:message key="brandDescription" /></label>
					<textarea class="form-control editField" id="brandDescription" name="<portlet:namespace/>brandDescription" onblur="checkValidationDesc(this.value)"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" maxlength="1000"></textarea>
					<label class="error d-none invalidDesc">Invalid input</label>
					<label class="error d-none Desclength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandOwner"><liferay-ui:message key="brandOwner" /></label>
					<input type="text" class="form-control editField" name="<portlet:namespace/>brandOwner"
						onpaste="return false;"  onkeydown="return /[a-zA-Z\s]/.test(event.key)"  maxlength="120">
				</div>
			</div>
			
			<div class="col-md-6"></div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandReviewer"><liferay-ui:message key="brandReviewer" /><span class="requiredStar">*</span></label>
					<select class="form-control editField" id="brandReviewer" name="<portlet:namespace/>brandReviewer">
						<option value="">Select Brand Reviewer</option>
				      <c:forEach items="${brandReviewer}" var="user">
				          <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
				      </c:forEach>
				  </select>
				  <label class="error d-none brandReviewerReq">This field cannot be left blank.</label>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandType"><liferay-ui:message key="brandType" /><span class="requiredStar">*</span></label>
					<select name="<portlet:namespace/>brandType" id="brandType" class="form-control editField">
						<option value="">Select Brand Type</option>
						<option value="Branded"><liferay-ui:message key="branded" /></option>
						<option value="Unbranded"><liferay-ui:message key="unBranded" /></option>
					</select>
					<label class="error d-none brandTypeReq">This field cannot be left blank.</label>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="categoryMap"><liferay-ui:message key="categoryMap" /><span class="requiredStar">*</span></label><br/>
					   <div id="categoryDiv" class="form-control bgcolor editField"></div>
					   <label class="categoryVal d-none error">This field cannot be left blank.</label>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="documentUpload"><liferay-ui:message key="documentUpload" /></label>
					<input type="file" class="form-control editField" id="documentUpload" name="<portlet:namespace/>documentUpload" multiple 
						accept="application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/png,image/jpg,image/jpeg" 
						onblur="validateDocumentType()">
				</div>
				<h5 class="allowFile">(Note: Allowed files type : pdf, docx, jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<label class="error d-none docTypeError">Invalid file type</label>
				<label class="error d-none docSizeError">File size exceeds maximum limit(5 MB)</label>
				<p id="files-area">
					<span id="filesList">
						<span id="files-names"></span>
					</span>
				</p>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="externalReferenceId"><liferay-ui:message key="externalReferenceId" /></label>
					<input type="text" id="externalReferenceId" class="form-control editField" name="<portlet:namespace/>externalReferenceId" onblur="brandRefernceVal()" 
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9]/.test(event.key)"  maxlength="75">
					<label class="error d-none brandRefernceVal">Brand referenceId already exists.</label>
					<label class="error d-none brandRefInvalid">Invalid input</label>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandApprovalStatus"><liferay-ui:message key="status" /><span class="requiredStar">*</span></label>
					<select name="<portlet:namespace/>brandApprovalStatus" class="form-control disableText">
						<option value="Pending"><liferay-ui:message key="Pending" /></option>
					</select>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group d-flex justify-content-between editField" style="background: none;">

					<div class="custom-control custom-checkbox">
						<label>
							<input type="checkbox" class=" custom-control-input" id="categoryInactive" name="<portlet:namespace/>brandInactive">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="brandInactive" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label>
							<input type="checkbox" class=" custom-control-input" id="categoryInactive" name="<portlet:namespace/>downForSeller">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForSeller" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label>
							<input type="checkbox" class=" custom-control-input" id="categoryInactive" name="<portlet:namespace/>downForBuyer">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForBuyer" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label>
							<input type="checkbox" class=" custom-control-input" id="categoryInactive" name="<portlet:namespace/>downForMaintenance">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForMaintenance" /></span></span>
						</label>
					</div>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="brandImageURL"><liferay-ui:message key="brandImageURL" /></label>
					<input type="file" class="form-control editField" id="brandImageUpload" name="<portlet:namespace/>brandImageUpload" 
						accept="image/png,image/jpg,image/jpeg" onblur="validateFileType()">
				</div>
				<h5 class="allowFile">(Note: Allowed files type : jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<label class="error d-none imageTypeError">Invalid file type</label>
				<label class="error d-none imageSizeError">File size exceeds maximum limit(5 MB)</label>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="managerRemarks"><liferay-ui:message key="managerRemarks" /></label>
					<textarea class="form-control editField" id="managerRemarks" name="<portlet:namespace/>managerRemarks"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" onblur="checkValidationRemark(this.value)" maxlength="1000"></textarea>
					<label class="error d-none invalidRemarks">Invalid input</label>
					<label class="error d-none brandManagerLength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			
			<div class="d-none">
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr1"><liferay-ui:message key="customAtr1" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr1"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr2"><liferay-ui:message key="customAtr2" /></label>
						<input type="text" class="form-control editField" class="form-control" name="<portlet:namespace/>customAtr2"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr3"><liferay-ui:message key="customAtr3" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr3"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr4"><liferay-ui:message key="customAtr4" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr4"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr5"><liferay-ui:message key="customAtr5" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr5"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr6"><liferay-ui:message key="customAtr6" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr6"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr7"><liferay-ui:message key="customAtr7" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr7"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr8"><liferay-ui:message key="customAtr8" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr8"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr9"><liferay-ui:message key="customAtr9" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr9"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr10"><liferay-ui:message key="customAtr10" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr10"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
			</div>
			
			<div class="col-md-12">
				<button class="btn btn-primary bigBtton">Submit</button>
				<a href="${dashboardURL}" class="btn btn-outline-secondary bigBtton">Cancel</a>
			</div>
			
		</div>
	</div>
</form>

<script>

	var brandDocumentFlag = true;
	var brandDocumentSizeFlag = true;

	$("#documentUpload").on('change', function(e){
		for(var i = 0; i < this.files.length; i++){
			let fileBloc = $('<span/>', {class: 'file-block'}),
				 fileName = $('<span/>', {class: 'name', text: this.files.item(i).name});
			fileBloc.append('<span class="file-delete">x</span>').append(fileName);
			$("#filesList > #files-names").append(fileBloc);
		};
		for (let file of this.files) {
			dt.items.add(file);
		}
		this.files = dt.files;
	
		$('span.file-delete').click(function(){
			let name = $(this).next('span.name').text();
			$(this).parent().remove();
			for(let i = 0; i < dt.items.length; i++){
				if(name === dt.items[i].getAsFile().name){
					dt.items.remove(i);
					brandDocumentFlag = validateDocumentType();
					brandDocumentSizeFlag = validateMaxDocumentSize();
					continue;
				}
			}
			document.getElementById('documentUpload').files = dt.files;
		});
	});
	
	$('.capitalize-first').on('input', function () {
	    var inputValue = $(this).val();
	    var capitalizedValue = inputValue.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
	    $(this).val(capitalizedValue);
	});
	
	$(document).ready(function() {
		
		$(".c-loader").removeClass("d-none");
		$(".portlet-title-text").addClass("d-none");
		
		var categories = ${categories};
		if(categories.length == 0) {
			$("#categoryDiv").append("<label class='error categoryCheck'>No Categories are available.</label>");
			categoryFlag = true;
		} else {
			<c:forEach items="${categories}" var="category">
				<c:if test = "${category.parentCategoryId == 0}">
					$("#categoryDiv").append("<div class='catDiv--${category.categoryId} zeroCatDiv'><span class='catSpan--${category.categoryId}'><input type='checkbox' class='categoryValidation' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");	
				</c:if>
				
				<c:if test = "${category.parentCategoryId != 0}">
					if($('.catDiv--${category.parentCategoryId}').length){
						$('.catDiv--${category.parentCategoryId}').append("<div data='catDiv--${category.categoryId}' class='catDiv--${category.categoryId} subCatDiv'><span id='catDiv--${category.categoryId}' class='catSpan--${category.categoryId}'><input type='checkbox' class='categoryValidation' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");
					}
				</c:if>
			</c:forEach>
			categoryFlag = false;
		}
		
		var lengthDiv = $('.subCatDiv').children('.subCatDiv').length;
		var lengthDivZeroCatDiv = $('.zeroCatDiv').children('.subCatDiv').length;
		
		if(lengthDiv) {
		    $('.subCatDiv').parent('div > div').addClass('moreCat');
		    $(".moreCat").prepend('<i class="icon-chevron-right arrowIcon"></i>');
		} else if(lengthDivZeroCatDiv) {
                $('.subCatDiv').parent('div > div').addClass('moreCat');
                $(".moreCat").prepend('<i class="icon-chevron-right arrowIcon"></i>');
		}

		$(".arrowIcon").on("click", function() {
		  $( this).toggleClass('icon-chevron-down');
		  $(this).parent('div > div').toggleClass('showDiv');
		});
		
		$(".arrowIcon + span input[type=checkbox]").click(function() {
            if($(this).prop("checked")) {
            	$(this).parent('span').parent('.moreCat').find('.subCatDiv:not(".moreCat")').find('input[type=checkbox]').prop("checked", true);
            	$(this).parent('span').parent('.moreCat').find('.arrowIcon:not(".icon-chevron-down")').click();
            }
        });
		
		$(".c-loader").addClass("d-none");
		
	});
	
	var checked;
	var brandName;
	var brandCode;
	var brandExtReferenceId;
	var brandNameFlag = true;
	var brandCodeFlag = true;
	var brandReferenceIdFlag = true;
	var brandDescFlag = true;
	var brandManagerRemarksFlag = true;
	var brandImageFlag = true;
	var brandDescLength = true;
	var brandManagerLength = true;
	var brandImageSizeFlag = true;
	var categoryFlag = false;
	
	function checkValidation(value){
		let checkRegexVal=false;
		var myRegxp = new RegExp("^[a-zA-Z0-9\\s]{1,255}$");
		if(myRegxp.test(value) != false){
			checkRegexVal = true;
		}
		return checkRegexVal;
	} 
	
	function checkValidationExtandCode(value){
		let checkRegexVal=false;
		var myRegxp = new RegExp("^[a-zA-Z0-9]{0,255}$");
		if(myRegxp.test(value) != false){
			checkRegexVal = true;
		}
		return checkRegexVal;
	} 
	
	function checkValidationRemark(value){
		if(value !== ""){
			let regex = /^[a-zA-Z0-9!%&()_\s\-[\]'"";:.,/|]+$/;
			if(regex.test(value)){
				$(".invalidRemarks").addClass("d-none");
				brandManagerRemarksFlag = true;
			} else {
				$(".invalidRemarks").removeClass("d-none");
				brandManagerRemarksFlag = false;
			}
			checkValidationRemarkLength(value);
		}
	}
	
	function checkValidationDesc(value){
		if(value !== ""){
			let regex = /^[a-zA-Z0-9!%&()_\s\-[\]'"";:.,/|]+$/;
			if(regex.test(value)){
				$(".invalidDesc").addClass("d-none");
				brandDescFlag = true;
			} else {
				$(".invalidDesc").removeClass("d-none");
				brandDescFlag = false;
			}
			checkValidationDescLength(value);
		}
	}
	
	function checkValidationRemarkLength(value){
		if(value.length<=1000){
			$(".brandManagerLength").addClass("d-none");
			brandManagerLength = true;
		} else {
			$(".brandManagerLength").removeClass("d-none");
			brandManagerLength = false;
		}
	}
	
	function checkValidationDescLength(value){
		if(value.length<=1000){
			$(".Desclength").addClass("d-none");
			brandDescLength = true;
		} else {
			$(".Desclength").removeClass("d-none");
			brandDescLength = false;
		}
	
	}
	
	function validateFileType() {
        var allowedTypes = ["image/jpeg", "image/jpg", "image/png"];
        var inputFile = $("#brandImageUpload")[0];
        if (inputFile.files.length > 0) {
        	 var fileType = inputFile.files[0].type;
        	 return allowedTypes.includes(fileType);
        } else {
        	return true;
        }
    }
	
	function validateDocumentType() {
        var allowedTypes = ["application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/pdf", "image/jpeg", "image/jpg", "image/png"];
        var inputFile = $("#documentUpload")[0];
        if (inputFile.files.length > 0) {
        	for (var i = 0; i < inputFile.files.length; i++) {
                var fileType = inputFile.files[i].type;

                if (!allowedTypes.includes(fileType)) {
                	return false;
            	}
    		}
        }
       return true;
	}
	
	function validateFileSize() {
		var maxSize = 5*1024*1024;
        var inputFile = $("#brandImageUpload")[0];
        if (inputFile.files.length > 0) {
	       var fileSize = inputFile.files[0].size;
	       if(fileSize > maxSize){
				return false;
			}
        }
        return true;
    }
	
	function validateMaxDocumentSize() {
		var maxSize = 5*1024*1024;
        var inputFile = $("#documentUpload")[0];
        if (inputFile.files.length > 0) {
        	for (var i = 0; i < inputFile.files.length; i++) {
        		var fileSize = inputFile.files[i].size;
        		if(fileSize > maxSize){
        			return false;
        		}
    		}
        }
       return true;
	}
	
	function brandNameVal(){
		brandName = $("#brandName").val();
		brandNameFlag = checkValidation(brandName);
		if(brandNameFlag){
			$(".brandNameInvalid").addClass("d-none");
			$.ajax({
				type:"GET",
				url:brandNameValURL,
				async:false,
				dataType: 'json',
				data:{
					"<portlet:namespace/>brandName":brandName
				},
				success:function(data){
					if(data.brandNameSize != '0'){
						$(".brandNameVal").removeClass("d-none");
						$(".brandNameReq").addClass("d-none");
						brandNameFlag = false;
					} else{
						$(".brandNameVal").addClass("d-none");
						$(".brandNameReq").addClass("d-none");
						brandNameFlag = true;
					}
				},
			});
		} else {
			$(".brandNameInvalid").removeClass("d-none");
			$(".brandNameReq").addClass("d-none");
			$(".brandNameVal").addClass("d-none");
			brandNameFlag = false;
		}
	}
	
	function brandCodeVal(){
		brandCode = $("#brandCode").val();
		brandCodeFlag = checkValidationExtandCode(brandCode);
		if(brandCodeFlag){
			$(".brandCodeInvalid").addClass("d-none");
			$.ajax({
				type:"GET",
				url:brandCodeValURL,
				async:false,
				dataType: 'json',
				data:{
					"<portlet:namespace/>brandCode":brandCode
				},
				success:function(data){
					if(data.brandCodeSize != '0'){
						$(".brandCodeVal").removeClass("d-none");
						brandCodeFlag = false;
					} else{
						$(".brandCodeVal").addClass("d-none");
						brandCodeFlag = true;
					}
				},
			});
		} else{
			$(".brandCodeInvalid").removeClass("d-none");
			$(".brandCodeVal").addClass("d-none");
			brandCodeFlag = false;
		}
	}
	
	function brandRefernceVal(){
		brandExtReferenceId = $("#externalReferenceId").val();
		brandReferenceIdFlag = checkValidationExtandCode(brandExtReferenceId);
		if(brandReferenceIdFlag){
			$(".brandRefInvalid").addClass("d-none");
			$.ajax({
				type:"GET",
				url:brandRefernceValURL,
				async:false,
				dataType: 'json',
				data:{
					"<portlet:namespace/>brandExtReferenceId":brandExtReferenceId
				},
				success:function(data){
					if(data.brandRefIdSize != '0'){
						$(".brandRefernceVal").removeClass("d-none");
						brandReferenceIdFlag = false;
					} else{
						$(".brandRefernceVal").addClass("d-none");
						brandReferenceIdFlag = true;
					}
				},
			});
		} else {
			$(".brandRefInvalid").removeClass("d-none");
			$(".brandRefernceVal").addClass("d-none");
			brandReferenceIdFlag = false;
		}
	}
	
	function checkBrandFrom(form){
		$(".c-loader").removeClass("d-none");
		$(".error").addClass("d-none");
		var brandReviewer = $("#brandReviewer").val();
		var brandType = $("#brandType").val();
		brandName = $("#brandName").val();
		checked = $("input[type=checkbox]:checked").length;
		brandImageFlag = validateFileType();
	    brandDocumentFlag = validateDocumentType();
		brandDocumentSizeFlag = validateMaxDocumentSize();
		brandImageSizeFlag = validateFileSize();
		
		if(brandCodeFlag){
			$(".brandCodeVal").addClass("d-none");
		} else{
			$(".brandCodeVal").removeClass("d-none");
			$(".brandCodeInvalid").addClass("d-none");
			$("#brandCode").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandName == ""){
			$(".brandNameReq").removeClass("d-none");
			$(".brandNameVal").addClass("d-none");
			$(".brandNameInvalid").addClass("d-none");
			$("#brandName").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".brandNameReq").addClass("d-none");
		}
		
		if(brandNameFlag){
			$(".brandNameVal").addClass("d-none");
		} else{
			$(".brandNameVal").removeClass("d-none");
			$(".brandNameReq").addClass("d-none");
			$(".brandNameInvalid").addClass("d-none");
			$("#brandName").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandDescFlag){
			$(".invalidDesc").addClass("d-none");
		} else{
			$(".invalidDesc").removeClass("d-none");
			$("#brandDescription").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandDescLength){
			$(".Desclength").addClass("d-none");
		} else{
			$(".Desclength").removeClass("d-none");
			$("#brandDescription").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandReviewer == ""){
			$(".brandReviewerReq").removeClass("d-none");
			$("#brandReviewer").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".brandReviewerReq").addClass("d-none");
		}
		
		if(brandType == ""){
			$(".brandTypeReq").removeClass("d-none");
			$("#brandType").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".brandTypeReq").addClass("d-none");
		}
		
		
		if(categoryFlag){
			$(".categoryCheck").removeClass("d-none");
			$(".categoryVal").addClass("d-none");
			$(".zeroCatDiv").focus();
			$(".c-loader").addClass("d-none");
	  		return false;
		} else if(checked == 0) {
	  		$(".categoryVal").removeClass("d-none");
	  		$(".categoryCheck").addClass("d-none");
	  		$(".zeroCatDiv").focus();
	  		$(".c-loader").addClass("d-none");
	  		return false;
        } else {
        	$(".categoryVal").addClass("d-none");
        	$(".categoryCheck").addClass("d-none");
        }
		
		if(!brandDocumentFlag){
			$(".docTypeError").removeClass("d-none");
			$(".c-loader").addClass("d-none");
			return false;
		} else {
			$(".docTypeError").addClass("d-none");
			if(!brandDocumentSizeFlag){
				$(".docSizeError").removeClass("d-none");
				$(".c-loader").addClass("d-none");
				return false;
			} else {
				$(".docSizeError").addClass("d-none");
			}
		}
		
		if(brandReferenceIdFlag){
			$(".brandRefernceVal").addClass("d-none");
		} else{
			$(".brandRefernceVal").removeClass("d-none");
			$(".brandRefInvalid").addClass("d-none");
			$("#externalReferenceId").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(!brandImageFlag){
			$(".imageTypeError").removeClass("d-none");
			return false;
		} else {
			$(".imageTypeError").addClass("d-none");
			if(!brandImageSizeFlag){
				$(".imageSizeError").removeClass("d-none");
				$(".c-loader").addClass("d-none");
				return false;
			} else {
				$(".imageSizeError").addClass("d-none");
			}
		}
		
		if(brandManagerRemarksFlag){
			$(".invalidRemarks").addClass("d-none");
		} else{
			$(".invalidRemarks").removeClass("d-none");
			$("#managerRemarks").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandManagerLength){
			$(".brandManagerLength").addClass("d-none");
		} else{
			$(".brandManagerLength").removeClass("d-none");
			$("#managerRemarks").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		return true;
	}
	
</script>
