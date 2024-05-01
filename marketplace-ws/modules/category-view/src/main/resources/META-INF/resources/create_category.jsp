<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<portlet:renderURL var="viewUrl">
	<portlet:param name="parentCategoryId"
		value="${category.parentCategoryId}" />
</portlet:renderURL>

<portlet:resourceURL var="categoryCheckUrl" id="categoryCheck" />

<portlet:actionURL var="createCategory" name="createCategory" />

<liferay-ui:error key="error-key" message="Category Creation Failed" />


 <div class="c-loader d-none">
    <span></span>
</div>

<%
long groupId = themeDisplay.getScopeGroupId();
	long parentCategoryId = (Long) request.getAttribute("parentCategoryId");
	Category category1 = null;
	if (parentCategoryId != 0) {
		category1 = CategoryLocalServiceUtil.getCategory(parentCategoryId);
%>
<h4><%=category1.getCategoryName()%></h4>
<%
	}
%>

<form name="myForm" method="POST" id="CategoryForm" onsubmit="return setupValidation(this)" action="<%=createCategory.toString()%>">
	
	<input type="hidden" name="<portlet:namespace/>parentCategoryId" value="${parentCategoryId}" />
	<input type="hidden" name="<portlet:namespace/>assetCategoryId" value="${assetCategoryId}" />

	<div class="container">
		<div class="titleBar">
			<h1 class="titlePage">Create Category</h1>
		</div>	
		
		<div class="customform row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryCode"><liferay-ui:message key="categoryCode" /></label>
					<input type="text" id="categoryCode" class="form-control editField" name="<portlet:namespace />categoryCode" 
						onkeydown="return /[a-zA-Z0-9]/.test(event.key)" onpaste="return false;" maxlength="255" onblur="validateCategoryCode()" />
				<label class="error d-none categoryCodeVal">Category code already exists.</label>
					<label class="error d-none categoryCodeInvalid">Invalid input</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryName"><liferay-ui:message key="categoryName" /><span class="requiredStar">*</span></label>
					<input type="text" id="categoryName" class="form-control form-field field-required capitalize-first editField"
						name="<portlet:namespace />categoryName" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)"  onblur="validateCategoryName()"
						onpaste="return false;" maxlength="255"/>
						<label class="error d-none categoryNameInvalid">Invalid input</label>
					<label class="error d-none categoryNameVal">Category name already exists.</label>
					<label class="error d-none categoryNameReq">This field cannot be left blank.</label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="categoryDescription"><liferay-ui:message key="categoryDescription" /></label>
					<textarea id="categoryDescription" class="form-control editField" name="<portlet:namespace />categoryDescription" maxlength="1000" onblur="validationDescAndRemark(this,'invalidDesc')"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)"></textarea>
						<label class="error d-none invalidDesc">Invalid input</label>
						<label class="error d-none Desclength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="categoryType"><liferay-ui:message key="categoryType" /><span class="requiredStar">*</span></label>
					<select id="categoryType" class="form-control form-field field-required editField" name="<portlet:namespace />categoryType" onblur="requiredCheckField(this,'categoryTypeReq')">
						<option value="">Select the Category Type</option>
						<option value="Product">Product</option>
						<option value="Service">Service</option>
						<option value="AMC">AMC</option>
					</select>
					<label class="error d-none categoryTypeReq">This field cannot be left blank.</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryAssignManager"><liferay-ui:message key="categoryAssignManager" /><span class="requiredStar">*</span></label>
					<select id="categoryAssignManager" class="form-control form-field field-required editField" name="<portlet:namespace />categoryAssignManager" onblur="requiredCheckField(this,'categoryManagerReq')">
						<option value="">Select the Category Manager</option>
						<c:forEach items="${userManager}" var="user">
							<option value="${user.userId}">${user.firstName}
								${user.lastName}</option>
						</c:forEach>
					</select>
					<label class="error d-none categoryManagerReq">This field cannot be left blank.</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryAssignReviewer"><liferay-ui:message	key="categoryAssignReview" /><span class="requiredStar">*</span></label>
					<select id="categoryAssignReviewer" class="form-control form-field field-required editField" name="<portlet:namespace />categoryAssignReviewer" onblur="requiredCheckField(this,'categoryReviewerReq')">
						<option value="">Select the Category Reviewer</option>
						<c:forEach items="${userReviewer}" var="user">
							<option value="${user.userId}">${user.firstName}
								${user.lastName}</option>
						</c:forEach>
					</select>
					<label class="error d-none categoryReviewerReq">This field cannot be left blank.</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryStatus"><liferay-ui:message key="categoryStatus" /><span class="requiredStar">*</span></label>
					<select id="categoryStatus" class="form-control disableText" style="color: black;" name="<portlet:namespace />categoryStatus">
						<option value="Pending">Pending</option>
					</select>
					<label class="error d-none categoryStatusReq">This field cannot be left blank.</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="categoryExpiryDate"><liferay-ui:message key="categoryExDate" /></label>
					<input type="date" id="categoryExpiryDate" class="form-control editField" name="<portlet:namespace />categoryExpiryDate" 
						onkeydown="return false" />
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group d-flex justify-content-between">
					<div class="custom-control custom-checkbox">
						<label for="categoryInactive">
							<input type="checkbox" class="editField custom-control-input" id="categoryInactive" name="<portlet:namespace/>categoryInactive">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="categoryInactive" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label for="downForSeller">
							<input type="checkbox" class="editField custom-control-input" id="downForSeller" name="<portlet:namespace/>downForSeller">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForSeller" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label for="downForBuyer">
							<input type="checkbox" class="editField custom-control-input" id="downForBuyer" name="<portlet:namespace/>downForBuyer">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForBuyer" /></span></span>
						</label>
					</div>
					<div class="custom-control custom-checkbox">
						<label for="downForMaintenance">
							<input type="checkbox" class="editField custom-control-input" id="downForMaintenance" name="<portlet:namespace/>downForMaintenance">
						  <span class="custom-control-label"><span class="custom-control-label-text"><liferay-ui:message key="downForMaintenance" /></span></span>
						</label>
					</div>
					
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="externalReferenceId"><liferay-ui:message key="extRefID" /></label>
					<input type="text" id="externalReferenceId" class="form-control editField" name="<portlet:namespace />externalReferenceId"  onblur="validateExt(this,'categoryExternalVal','categoryExternalInvalid')"
						onkeydown="return /[a-zA-Z0-9]/.test(event.key)" onpaste="return false;" maxlength="255" />
					<label class="error d-none categoryExternalVal">External reference Id already exists.</label>	
					<label class="error d-none categoryExternalInvalid">External reference Id is Invalid</label>
							
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="categoryImage"><liferay-ui:message key="categoryImage" /></label>
					<input type="file" class="form-control editField" id="categoryImage" name="<portlet:namespace/>categoryImage" onblur="fileUpload()"
						accept="image/png,image/jpg,image/jpeg" data-msg-accept="Invalid File Type">
						<label class="error d-none imageTypeError">Invalid file type</label>
				<label class="error d-none imageSizeError">File size exceeds maximum limit(5 MB)</label>
				</div>
				<h5 class="allowFile">(Note: Allowed files type : jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<p id="files-area">
					<span id="filesList">
						<span id="files-names"></span>
					</span>
				</p>
				
			</div>

			<div class="col-md-12">
				<div class="form-group">
					<label for="termsAndCondition"><liferay-ui:message key="termsandcondition" /></label>
					<textarea id="termsAndCondition" class="form-control editField" name="<portlet:namespace />termsAndCondition" maxlength="1000" onblur="validationDescAndRemark(this,'invalidTerms')"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)"></textarea>
							<label class="error d-none invalidTerms">Invalid input</label>
								<label class="error d-none termlength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="managerRemarks"><liferay-ui:message key="managerRemarks" /></label>
					<textarea class="form-control editField" id="managerRemarks" name="<portlet:namespace/>managerRemarks" maxlength="1000" onblur="validationDescAndRemark(this,'invalidManagerRemark')"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)"></textarea>
						<label class="error d-none invalidManagerRemark">Invalid input</label>
						<label class="error d-none managerLength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			<div class="d-none">
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr1"><liferay-ui:message key="customAtr1" /></label>
						<input type="text" id="customAtr1" class="form-control editField" name="<portlet:namespace />customAtr1" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr2"><liferay-ui:message key="customAtr2" /></label>
						<input type="text" id="customAtr2" class="form-control editField" name="<portlet:namespace />customAtr2" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr3"><liferay-ui:message key="customAtr3" /></label>
						<input type="text" class="form-control editField" id="customAtr3" name="<portlet:namespace />customAtr3" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr4"><liferay-ui:message key="customAtr4" /></label>
						<input type="text" id="customAtr4" class="form-control editField" name="<portlet:namespace />customAtr4" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr5"><liferay-ui:message key="customAtr5" /></label>
						<input type="text" id="customAtr5" class="form-control editField" name="<portlet:namespace />customAtr5" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr6"><liferay-ui:message key="customAtr6" /></label>
						<input type="text" id="customAtr6" class="form-control editField" name="<portlet:namespace />customAtr6" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr7"><liferay-ui:message key="customAtr7" /></label>
						<input type="text" id="customAtr7" class="form-control editField" name="<portlet:namespace />customAtr7" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr8"><liferay-ui:message key="customAtr8" /></label>
						<input type="text" id="customAtr8" class="form-control editField" name="<portlet:namespace />customAtr8" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr9"><liferay-ui:message key="customAtr9" /></label>
						<input type="text" id="customAtr9" class="form-control editField" name="<portlet:namespace />customAtr9" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr10"><liferay-ui:message key="customAtr10" /></label>
						<input type="text" id="customAtr10" class="form-control editField" name="<portlet:namespace />customAtr10" 
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
			</div>

			<div class="col-12">
			<%if (CategoryPermission.contains(permissionChecker, groupId, "CREATE_CATEGORY")) {%> 
			
				<button type="submit" class="btn btn-primary mr-3">Submit</button>
				<%} %> 
				<a href="${viewUrl}" class="btn button-danger">Cancel</a>
			</div>
		</div>
	</div>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/additional-methods.min.js"
	integrity="sha512-TiQST7x/0aMjgVTcep29gi+q5Lk5gVTUPE9XgN0g96rwtjEjLpod4mlBRKWHeBcvGBAEvJBmfDqh2hfMMmg+5A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>


<script>

	$('.capitalize-first').on('input', function () {
	    var inputValue = $(this).val();
	    var capitalizedValue = inputValue.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
	    $(this).val(capitalizedValue);
	});
	
	function FutureDate() {

		var currentDate = new Date();
		var currDate = currentDate.getDate() + 1;
		var currMonth = currentDate.getMonth() + 1; 
		if (currMonth < 10) {
			currMonth = '0' + currMonth;
		}
		
		if (currDate < 10) {
			currDate = '0' + currDate;
		}
		
		var currYear = currentDate.getFullYear();
		var currentDateStr = currYear + "-" + currMonth + "-" + currDate;
		$('#categoryExpiryDate').attr('min', currentDateStr);
	}

	function setupValidation(formName) {
		$(".c-loader").removeClass("d-none");
		var fieldName = "CategoryForm";
		
		$(".error").addClass("d-none");
		debugger
		var categoryName = checkValidation($('#categoryName').val());
		var categoryCode = checkValidationExtandCode($('#categoryCode').val());
		var categoryCodeDup = validateCategoryField($('#categoryCode').val(), 'categoryCode');
		var categoryDesciprtion = checkValidationDescAndRemark($('#categoryDescription').val(),'Desclength');
		var categoryDesciprtionLength = checkValidationDescAndRemarkLength($('#categoryDescription').val());
		var externalReferenceId = checkValidationExtandCode($('#externalReferenceId').val(),'categoryExternalInvalid');
		var externalReferenceIdDup = validateCategoryField($('#externalReferenceId').val(), 'externalReferenceId');
		var fileValidationBool = fileValidation();
		var validateDocumentTypeBool = validateDocumentType();
		var termsAndCondition = checkValidationDescAndRemark($('#termsAndCondition').val(),'invalidTerms');
		var termsAndConditionLength = checkValidationDescAndRemarkLength($('#termsAndCondition').val());
		var managerRemarkLength = checkValidationDescAndRemarkLength($('#managerRemarks').val());
		var managerRemark = checkValidationDescAndRemark($('#managerRemarks').val(),'invalidManagerRemark');
		
		if(!requiredCategoryName($('#categoryName').val())){
			$(".categoryNameReq").removeClass("d-none");
			$(".categoryNameVal").addClass("d-none");
			$(".categoryNameInvalid").addClass("d-none");
			addclassFunction('categoryName');
			return false;
		}else if(!categoryName){
			$(".categoryNameReq").addClass("d-none");
			$(".categoryNameVal").addClass("d-none");
			$(".categoryNameInvalid").removeClass("d-none");
			addclassFunction('categoryName');
			return false;
		}else if(!validateCategoryField($('#categoryName').val(), 'categoryName')){
			$(".categoryNameReq").addClass("d-none");
			$(".categoryNameVal").removeClass("d-none");
			$(".categoryNameInvalid").addClass("d-none");
			addclassFunction('categoryName');
			return false;
		}
		
		if(!categoryCode){
			$(".categoryCodeInvalid").removeClass("d-none");
			$(".categoryCodeVal").addClass("d-none");
			addclassFunction('categoryCode');
			return false;
		} else if(!categoryCodeDup){
			$(".categoryCodeVal").removeClass("d-none");
			$(".categoryCodeInvalid").addClass("d-none");
			addclassFunction('categoryCode');
			return false;
		}
		
		if(categoryDesciprtion){
			$(".invalidDesc").addClass("d-none");
		} else{
			$(".invalidDesc").removeClass("d-none");
			addclassFunction('categoryDescription');
			return false;
		}
		
		if(categoryDesciprtionLength){
			$(".Desclength").addClass("d-none");
		} else{
			$(".Desclength").removeClass("d-none");
			addclassFunction('categoryDescription');
			return false;
		}
		
		if($('#categoryType').val() === ''){
				$(".categoryTypeReq").removeClass("d-none");
				addclassFunction('categoryTypeReq');
				return false;
			} else{
				$(".categoryTypeReq").addClass("d-none");
			}
		
		if($('#categoryAssignManager').val() === ''){
			$(".categoryManagerReq").removeClass("d-none");
			addclassFunction('categoryAssignManager');
			return false;
		} else{
			$(".categoryManagerReq").addClass("d-none");
		}
		
		if($('#categoryAssignReviewer').val() === ''){
			$(".categoryReviewerReq").removeClass("d-none");
			addclassFunction('categoryAssignReviewer');
			return false;
		} else{
			$(".categoryReviewerReq").addClass("d-none");
		}
		
		
		if(externalReferenceIdDup){
			$(".categoryExternalVal").addClass("d-none");
		} else{
			$(".categoryExternalVal").removeClass("d-none");
			addclassFunction('externalReferenceId');
			return false;
		}
		
		
		if(externalReferenceId){
			$(".categoryExternalInvalid").addClass("d-none");
		} else{
			$(".categoryExternalInvalid").removeClass("d-none");
			addclassFunction('externalReferenceId');
			return false;
		}
		
		
		if(!validateDocumentTypeBool){
			$(".imageTypeError").removeClass("d-none");
			$(".c-loader").addClass("d-none");
			return false;
		} else {
			$(".imageTypeError").addClass("d-none");
			if(!fileValidationBool){
				$(".imageSizeError").removeClass("d-none");
				$(".c-loader").addClass("d-none");
				return false;
			} else {
				$(".imageSizeError").addClass("d-none");
			}
		}
		
		if(termsAndCondition){
			$(".invalidTerms").addClass("d-none");
		} else{
			$(".invalidTerms").removeClass("d-none");
			addclassFunction('termsAndCondition');
			return false;
		}
		if(termsAndConditionLength){
			$(".termlength").addClass("d-none");
		} else{
			$(".termlength").removeClass("d-none");
			addclassFunction('termsAndCondition');
			return false;
		}
		if(managerRemarkLength){
			$(".managerLength").addClass("d-none");
		} else{
			$(".managerLength").removeClass("d-none");
			addclassFunction('managerRemark');
			return false;
		}
		
		if(managerRemark){
			$(".invalidManagerRemark").addClass("d-none");
		} else{
			$(".invalidManagerRemark").removeClass("d-none");
			addclassFunction('managerRemark');
			return false;
		}
		
		
	}
	
	

	function addclassFunction(fieldName){
		$("#"+fieldName).focus();
		$(".c-loader").addClass("d-none");
	}
	
	function removeclassFunction(){
		$("."+fieldName).removeClass("d-none");
	}

	
	function validateDocumentType() {
        var allowedTypes = ["application/vnd.openxmlformats-officedocument.wordprocessingml.document", "image/jpeg", "image/jpg", "image/png"];
        var inputFile = $("#categoryImage")[0];
        if (inputFile.files.length > 0) {
        	
                var fileType = inputFile.files[0].type;

                if (!allowedTypes.includes(fileType)) {
                	return false;
            	}
    		
        }
       return true;
	}
	
	function filterDropdown() {
		var input, filter, select, option, i;
		input = document.getElementById("userSearch");
		filter = input.value.toLowerCase();
		select = document.getElementById("manager");
		option = select.getElementsByTagName("option");

		for (i = 0; i < option.length; i++) {
			if (option[i].innerText.toLowerCase().indexOf(filter) > -1) {
				option[i].style.display = "";
			} else {
				option[i].style.display = "none";
			}
		}
	}
	
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
	
	function validationDescAndRemark(fieldName,errorMessage){
		checkValidationDescAndRemark(fieldName.value,errorMessage);
	}
	
	
	function checkValidationDescAndRemark(value,fieldName){
		debugger
		let checkValidDesc=false;
		if(value !== ''){
			let regex = /^[a-zA-Z0-9!%&()_\s\-[\]'"";:.,/|]+$/;
			if(regex.test(value) || value === ''){
				$("."+fieldName).addClass("d-none");
				checkValidDesc = true;
			} else {
				$("."+fieldName).removeClass("d-none");
				checkValidDesc = false;
			}
			checkValidationDescAndRemarkLength(value);
		}else{
			$("."+fieldName).addClass("d-none");
			checkValidDesc = true;
		}
		return checkValidDesc;
	} 
	
	function checkValidationDescAndRemarkLength(value){
		let checkRegexVal=false;
		if(value.length <= 1000){
			checkRegexVal=true;
		}
		return checkRegexVal;
	}
	
	function requiredCheckField(fieldName,errorvariable){
		if(fieldName.value !== ''){
			$("."+errorvariable).addClass("d-none");
		}else{
			$("."+errorvariable).removeClass("d-none");
		}
	}
	
	
	function requiredCategoryName(value) {
		let requiredName = false;
		value = value.trim();
		if(value.length > 0) {
			requiredName = true;
		}
		return requiredName;
	}
	
	
	function fileUpload(){
		if(!validateDocumentTypeBool){
			$(".imageTypeError").removeClass("d-none");
			
		} else {
			$(".imageTypeError").addClass("d-none");
			if(!fileValidationBool){
				$(".imageSizeError").removeClass("d-none");
				
			} else {
				$(".imageSizeError").addClass("d-none");
			}
		}
	}
	
	function fileValidation() {
		debugger
		var maxSize = 5*1024*1024;
        var inputFile = $("#categoryImage")[0];
        if (inputFile.files.length > 0) {
	        var fileSize = inputFile.files[0].size;
	        if(fileSize > maxSize){
				return false;
			}
        }
        return true;
    }
	
	function validateCategoryName(){
		var value = $("#categoryName").val();
		var fieldName = 'categoryName'
		var categoryName = validateCategoryField($('#categoryName').val(),'categoryName');
		if(!categoryName){
			$(".categoryNameVal").removeClass("d-none");
		}else{
			$(".categoryNameVal").addClass("d-none");
		}
	}
	
	function validateExt(field){
		if(field.value !== ''){
		var externalReferenceIdDub = validateCategoryField(field.value,'externalReferenceId');
		var externalReferenceId = checkValidationExtandCode($('#externalReferenceId').val(),'categoryExternalInvalid');
		if(externalReferenceIdDub){
			$(".categoryExternalVal").addClass("d-none");
		} else{
			$(".categoryExternalVal").removeClass("d-none");
		}
		if(externalReferenceId){
			$(".categoryExternalInvalid").addClass("d-none");
		} else{
			$(".categoryExternalInvalid").removeClass("d-none");
		}
		}
	}
	
	function validateCategoryCode(){
		var value =  $("#categoryCode").val();
		var fieldName = 'categoryCode';
		if(value !== ''){
			
			var categoryCode = validateCategoryField(value, fieldName) ;
			if(!categoryCode){
				$(".categoryCodeVal").removeClass("d-none");
			}else{
				$(".categoryCodeVal").addClass("d-none");
			}
		}
	}
	
	function validateCategoryField(value, fieldName) {
		debugger
	    var isValid = false;
	    var categoryId = $("#categoryId").val();

	    var dataObj = {};
	    dataObj['<portlet:namespace/>' + fieldName] = value;
	    
	    if ((fieldName === 'categoryCode' || fieldName === 'categoryName' || fieldName === 'externalReferenceId') && !value.trim()) {
	        return true;
	    }

	    $.ajax({
	        type: "GET",
	        url: "${categoryCheckUrl}",
	        data: dataObj,
	        async: false,
	        dataType: "json",
	        success: function (data) {
	            if (data.size == 1 && data.categoryId == categoryId) {
	                isValid = true;
	            } else if (data.size > 0) {
	                isValid = false;
	            } else {
	                isValid = true;
	            }
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	        }
	    });

	    return isValid;
	}
	
	$(document).ready(function() {
		
		$(".c-loader").removeClass("d-none");
		$(".portlet-title-text").addClass("d-none");
		FutureDate();
		$(".c-loader").addClass("d-none");
		
	});
	
</script>
