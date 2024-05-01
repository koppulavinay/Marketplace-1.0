<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.marketplace.brand.web.internal.security.permission.resource.BrandPermission"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%> 
<%@page import="com.marketplace.brand.model.Brand"%>
<%@page import="com.marketplace.brand.portlet.BrandViewPortlet"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTransition" %>
<%@ page import="java.util.List" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <link rel="stylesheet" href="https://nickpiesco.github.io/alloy-ui-font-awesome-cheatsheet/css/style.css"> -->

<%
	Brand brand = (Brand) renderRequest.getAttribute("brand");
	String nodeTransition = (String) renderRequest.getAttribute("taskName");
%>

<div class="c-loader d-none">
    <span></span>
</div>

<liferay-ui:error key="error-key" message="Brand Updation Failed" />

<portlet:actionURL var="updateBrandURL" name="updateBrand" />

<portlet:renderURL var="dashboardURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<form method="post" action="${updateBrandURL}" onsubmit="return checkBrandFrom(this)" 
	name="<portlet:namespace/>myForm" enctype="multipart/form-data">
	
	<input type="hidden" id="brandId" name="<portlet:namespace/>brandId" value="${brand.brandId}">
	<input type="hidden" id="workflowId" name="<portlet:namespace/>workflowId" value="${workFlowId}">
	
	<div class="container">
		
		<div class="titleBar">
			<h1 class="titlePage">Brand Update</h1>
		</div>
    	<div class="customform row">
	
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandCode"><liferay-ui:message key="brandCode" /></label>
					<input type="text" class="form-control editField" id="brandCode" name="<portlet:namespace/>brandCode" value="${brand.brandCode}" 
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9]/.test(event.key)"  maxlength="255" onblur="brandCodeVal()">
					<label class="error d-none brandCodeVal">Brand code already exists.</label>
					<label class="error d-none brandCodeInvalid">Invalid input</label>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandName"><liferay-ui:message key="brandName" /><span class="requiredStar">*</span></label>
					<input type="text" class="form-control capitalize-first editField" id="brandName" name="<portlet:namespace/>brandName" value="${brand.brandName}"
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)"  maxlength="255" onblur="brandNameVal()">
					<label class="error d-none brandNameVal">Brand name already exists.</label>
					<label class="error d-none brandNameReq">This field cannot be left blank.</label>
					<label class="error d-none brandNameInvalid">Invalid input</label>
				</div>
			</div>
		
			<div class="col-md-12">
				<div class="form-group">
					<label for="brandDescription"><liferay-ui:message key="brandDescription" /></label>
					<textarea class="form-control editField" id="brandDescription" name="<portlet:namespace/>brandDescription"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" onblur="checkValidationDesc(this.value)" maxlength="1000">${brand.brandDescription}</textarea>
					<label class="error d-none invalidDesc">Invalid input</label>
					<label class="error d-none Desclength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
		
			<div class="col-md-6">
				<div class="form-group">
					<label for="brandOwner"><liferay-ui:message key="brandOwner" /></label>
					<input type="text" class="form-control editField" id="brandOwner" name="<portlet:namespace/>brandOwner" value="${brand.brandOwner}"
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
		
			<div class="col-12">
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
						<span id="files-names">
							<c:forEach var="docModel" items="${documentModels}">
								<span class="file-deleteDoc editField">
									<%-- <span class="remove-button" onclick="removeDoc(this, '${docModel.fileEntryId}')">x</span> --%>
									<a target="_blank" href="${docModel.downloadDocumentLink}">${docModel.uploadedDocName}</a>
								</span>
							</c:forEach>
						</span>
					</span>
				</p>
			</div>
		
			<div class="col-md-6">
				<div class="form-group">
					<label for="externalReferenceId"><liferay-ui:message key="externalReferenceId" /></label>
					<input type="text" class="form-control editField" id="externalReferenceId" name="<portlet:namespace/>externalReferenceId" value="${brand.externalReferenceId}"
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)"  maxlength="75" onblur="brandRefernceVal()">
					<label class="error d-none brandRefernceVal">Brand referenceId already exists.</label>
					<label class="error d-none brandRefInvalid">Invalid input</label>
				</div>
			</div>
		
			<div class="col-md-6">
				<div class="form-group">
					<label for="status"><liferay-ui:message key="status" /></label>
					<select name="<portlet:namespace/>currentStatus" id="currentStatus" class="form-control disableText editField">
							<option value="${brand.brandApprovalStatus}">${brand.brandApprovalStatus}</option>
					</select>
				</div>
			</div>
			
			<div class="col-md-6">
				<%-- <c:choose>
					<c:when test="${Reviewer}">
						<div class="form-group">
							<label for="brandApprovalStatus"><liferay-ui:message key="actionToBeTaken" /><span class="requiredStar">*</span></label>
							<select name="<portlet:namespace/>brandApprovalStatus" id="brandApprovalStatus" class="form-control editField">
								<c:if test="${brand.brandApprovalStatus == 'Pending'}">
									<option value="">Select Status</option>
									<option value="Approved"><liferay-ui:message key="Approved" /></option>
									<option value="Rejected"><liferay-ui:message key="Rejected" /></option>
								</c:if>
								<c:if test="${brand.brandApprovalStatus == 'Approved' || brand.brandApprovalStatus == 'Rejected'}">
									<option value="${brand.brandApprovalStatus}">${brand.brandApprovalStatus}</option>
								</c:if>
								<c:forEach items="${workflowTransition}" var="workflowTransition">
								<option value="${workflowTransition.getName()}">${workflowTransition.getName()}</option>
								</c:forEach>
							</select>
							<label class="error d-none brandApprovalStatusReq">This field cannot be left blank.</label>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group disableText">
							<label for="brandApprovalStatus"><liferay-ui:message key="actionToBeTaken" /><span class="requiredStar">*</span></label>
							<select name="<portlet:namespace/>brandApprovalStatus" id="brandApprovalStatus" class="form-control disableText">
								<option value="Pending"><liferay-ui:message key="Pending" /></option>
								<c:forEach items="${workflowTransition}" var="workflowTransition">
								<option value="${workflowTransition.getName()}">${workflowTransition.getName()}</option>
							</c:forEach>
							</select>
							
						</div>
					</c:otherwise>
				</c:choose> --%>
				<div class="form-group">
							<label for="brandApprovalStatus"><liferay-ui:message key="actionToBeTaken" /><span class="requiredStar">*</span></label>
							<select name="<portlet:namespace/>brandApprovalStatus" id="brandApprovalStatus" class="form-control editField">
								<c:if test="${not empty workflowTransition}">
								<option value="" >Select Status</option>
								<c:forEach items="${workflowTransition}" var="workflowTransition">
								<option value="${workflowTransition.getName()}">${workflowTransition.getName()}</option>
								</c:forEach>
								</c:if>
								<c:if test="${brand.brandApprovalStatus == 'Approved' || brand.brandApprovalStatus == 'Rejected'}">
								<option value="Pending" selected>Pending</option>
								</c:if>
							</select>
							<label class="error d-none brandApprovalStatusReq">This field cannot be left blank.</label>
						</div>
			</div>
		
			<div class="col-md-12">
				<div class="form-group">
					<label for="reviewerRemarks"><liferay-ui:message key="reviewerRemarks" /><span class="requiredStar">*</span></label>
					<textarea class="form-control editField" id="reviewerRemarks" name="<portlet:namespace/>reviewerRemarks"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" onblur="checkValidationReviewerRemark(this.value)" maxlength="1000">${brand.reviewerRemarks}</textarea>
					<label class="error d-none reviewerRemarksReq">This field cannot be left blank.</label>
					<label class="error d-none invalidRevRemarks">Invalid input</label>
					<label class="error d-none reviewerRemarkLength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
		
			<div class="col-md-12">
			<div class="form-group d-flex justify-content-between">
				<div>
					<input type="checkbox" class="" id="brandInactive" name="<portlet:namespace/>brandInactive">&nbsp;
					<label for="brandInactive"><liferay-ui:message key="brandInactive" /></label>&nbsp;&nbsp;
				</div>
				<div>	
					<input type="checkbox" id="downForSeller" name="<portlet:namespace/>downForSeller">&nbsp;
					<label for="brandInactive"><liferay-ui:message key="downForSeller" /></label>&nbsp;&nbsp;
				</div>
				<div>	
					<input type="checkbox" id="downForBuyer" name="<portlet:namespace/>downForBuyer">&nbsp;
					<label for="brandInactive"><liferay-ui:message key="downForBuyer" /></label>&nbsp;&nbsp;
				</div>
				<div>	
					<input type="checkbox" id="downForMaintenance" name="<portlet:namespace/>downForMaintenance">&nbsp;
					<label for="brandInactive"><liferay-ui:message key="downForMaintenance" /></label>
				</div>
			</div>
			</div>
			
			<div class="col-12">
				<div class="form-group">
					<label for="brandImageURL"><liferay-ui:message key="brandImageURL" /></label>
					<input type="file" class="form-control" id="brandImageUpload" name="<portlet:namespace/>brandImageUpload" 
						accept="image/png,image/jpg,image/jpeg" onblur="validateFileType()">
				</div>
				<h5 class="allowFile">(Note: Allowed files type : jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<label class="error d-none imageTypeError">Invalid file type</label>
				<label class="error d-none imageSizeError">File size exceeds maximum limit(5 MB)</label>
				<p id="files-area">
					<span id="filesList">
						<span id="brand-img-name">
							<span class="brand-img-delete">
								<%-- <span class="remove-button" onclick="removeDoc(this, '${docModel.fileEntryId}')">x</span> --%>
								<a target="_blank" href="${brandImageDoc.downloadDocumentLink}">${brandImageDoc.uploadedDocName}</a>
							</span>
						</span>
					</span>
				</p>
			</div>
			
			<div class="col-md-12">
				<div class="form-group">
					<label for="managerRemarks"><liferay-ui:message key="managerRemarks" /></label>
					<textarea class="form-control editField" id="managerRemarks" name="<portlet:namespace/>managerRemarks"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" onblur="checkValidationManagerRemark(this.value)" maxlength="1000">${brand.managerRemarks}</textarea>
					<label class="error d-none invalidManRemarks">Invalid input</label>
					<label class="error d-none brandManagerLength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			
			<div class="d-none">
				<div class="col-4">
				<div class="form-group">
					<label for="customAtr1"><liferay-ui:message key="customAtr1" /></label>
					<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr1" value="${brand.customAtr1}"
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
				</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr2"><liferay-ui:message key="customAtr2" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr2" value="${brand.customAtr2}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">	
					<div class="form-group">
						<label for="customAtr3"><liferay-ui:message key="customAtr3" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr3" value="${brand.customAtr3}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr4"><liferay-ui:message key="customAtr4" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr4" value="${brand.customAtr4}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr5"><liferay-ui:message key="customAtr5" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr5" value="${brand.customAtr5}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr6"><liferay-ui:message key="customAtr6" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr6" value="${brand.customAtr6}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr7"><liferay-ui:message key="customAtr7" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr7" value="${brand.customAtr7}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr8"><liferay-ui:message key="customAtr8" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr8" value="${brand.customAtr8}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr9"><liferay-ui:message key="customAtr9" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr9" value="${brand.customAtr9}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr10"><liferay-ui:message key="customAtr10" /></label>
						<input type="text" class="form-control editField" name="<portlet:namespace/>customAtr10" value="${brand.customAtr10}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
			</div>
			
			<div class="col-md-12">
				<%-- <c:if test="${Administrator && (brand.brandApprovalStatus == 'Approved' || brand.brandApprovalStatus == 'Rejected')}">
					<button class="btn btn-primary bigBtton">Submit</button>
				</c:if>
				<c:if test="${Reviewer && (brand.brandApprovalStatus == 'Pending')}">
					<button class="btn btn-primary bigBtton">Submit</button>
				</c:if> --%>
				<%if (BrandPermission.contains(permissionChecker, groupId, "CREATE_BRAND") && brand.getStatus() != WorkflowConstants.STATUS_PENDING) {
      	 	%>
					<button type="submit" class="btn btn-primary submitBtn mr-3">Submit</button>
			<%} else if (BrandPermission.contains(permissionChecker, groupId, "REVIEW_BRAND") && brand.getStatus() == WorkflowConstants.STATUS_PENDING) {%>
					<button type="submit" class="btn btn-primary submitBtn mr-3">Submit</button>
				
				<%} %>
				<a href="${dashboardURL}" class="btn button-danger">Cancel</a>
			</div>
			
		</div>
	</div>
</form>

<script type="text/javascript">

	var Administrator = ${Administrator};
	var Reviewer = ${Reviewer};
	var brandDocumentFlag = true;
	var brandDocumentSizeFlag = true;

	$(document).ready(function() {
		
		$(".c-loader").removeClass("d-none");
		$(".portlet-title-text").addClass("d-none");
		
		var inputFields = $(".customform label, .customform input");
		var selectStatusField = $("#brandApprovalStatus");
		var currentStatusField = $("#currentStatus");
		var selectFields = $(".customform select, input[type=checkbox]");
		var brandApprovalStatus = '${brand.brandApprovalStatus}';
		var brandInactive = ${brand.brandInactive};
		var downForSeller = ${brand.downForSeller};
		var downForBuyer = ${brand.downForBuyer};
		var downForMaintenance = ${brand.downForMaintenance};
	    $("#brandReviewer").val('${brand.brandReviewer}');
	    $("#brandType").val('${brand.brandType}');
	    
	    if(downForSeller){
	    	$("#downForSeller").prop("checked", true);
	    } else{
	    	$("#downForSeller").prop("checked", false);
	    }
	    if(downForBuyer){
	    	$("#downForBuyer").prop("checked", true);
	    } else{
	    	$("#downForBuyer").prop("checked", false);
	    }
	    if(downForMaintenance){
	    	$("#downForMaintenance").prop("checked", true);
	    } else{
	    	$("#downForMaintenance").prop("checked", false);
	    }
	    if(brandInactive){
	    	$("#brandInactive").prop("checked", true);
	    } else{
	    	$("#brandInactive").prop("checked", false);
	    }
	    
	    if((brandApprovalStatus == 'Approved' || brandApprovalStatus == 'Rejected') && Reviewer){
	    	inputFields.addClass('disableText');
	    	selectFields.addClass('disableText');
	    	$("#categoryDiv").addClass('disableText');
	    	$("#reviewerRemarks").addClass('disableText');
	    	$("#managerRemarks").addClass('disableText');
	    	$("#brandDescription").addClass('disableText');
	    	inputFields.removeClass('editField');
	    	selectFields.removeClass('editField');
	    	$("#categoryDiv").removeClass('editField');
	    	$("#reviewerRemarks").removeClass('editField');
	    	$("#managerRemarks").removeClass('editField');
	    	$("#brandDescription").removeClass('editField');
	    } else if((brandApprovalStatus == 'Approved' || brandApprovalStatus == 'Rejected') && Administrator){
	    	inputFields.removeClass('disableText');
	    	selectFields.removeClass('disableText');
	    	selectStatusField.addClass('disableText');
	    	currentStatusField.addClass('disableText');
	    	$("#categoryDiv").removeClass('disableText');
	    	$("#reviewerRemarks").addClass('disableText');
	    	$("#managerRemarks").removeClass('disableText');
	    	$("#brandDescription").removeClass('disableText');
	    	inputFields.addClass('editField');
	    	selectFields.addClass('editField');
	    	selectStatusField.removeClass('editField');
	    	currentStatusField.removeClass('editField');
	    	$("#categoryDiv").addClass('editField');
	    	$("#reviewerRemarks").removeClass('editField');
	    	$("#managerRemarks").addClass('editField');
	    	$("#brandDescription").addClass('editField');
	    } else if(brandApprovalStatus == 'Pending' && Administrator){
	    	inputFields.addClass('disableText');
	    	selectStatusField.addClass('disableText');
	    	currentStatusField.addClass('disableText');
	    	selectFields.addClass('disableText');
	    	$("#categoryDiv").addClass('disableText');
	    	$("#reviewerRemarks").addClass('disableText');
	    	$("#managerRemarks").addClass('disableText');
	    	$("#brandDescription").addClass('disableText');
	    	inputFields.removeClass('editField');
	    	selectStatusField.removeClass('editField');
	    	currentStatusField.removeClass('editField');
	    	selectFields.removeClass('editField');
	    	$("#categoryDiv").removeClass('editField');
	    	$("#reviewerRemarks").removeClass('editField');
	    	$("#managerRemarks").removeClass('editField');
	    	$("#brandDescription").removeClass('editField');
	    } else if(Reviewer){
	    	inputFields.addClass('disableText');
	    	selectFields.addClass('disableText');
	    	selectStatusField.removeClass('disableText');
	    	currentStatusField.addClass('disableText');
	    	$("#categoryDiv").addClass('disableText');
	    	$("#reviewerRemarks").removeClass('disableText');
	    	$("#managerRemarks").addClass('disableText');
	    	$("#brandDescription").addClass('disableText');
	    	inputFields.removeClass('editField');
	    	selectFields.removeClass('editField');
	    	selectStatusField.addClass('editField');
	    	currentStatusField.removeClass('editField');
	    	$("#categoryDiv").removeClass('editField');
	    	$("#reviewerRemarks").addClass('editField');
	    	$("#managerRemarks").removeClass('editField');
	    	$("#brandDescription").removeClass('editField');
	    }
	    
	    <c:forEach items="${categories}" var="category">
			<c:if test = "${category.parentCategoryId == 0}">
				$("#categoryDiv").append("<div class='catDiv--${category.categoryId} zeroCatDiv'><span class='catSpan--${category.categoryId}'><input type='checkbox' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");	
			</c:if>
			
			<c:if test = "${category.parentCategoryId != 0}">
				if($('.catDiv--${category.parentCategoryId}').length){
					$('.catDiv--${category.parentCategoryId}').append("<div data='catDiv--${category.categoryId}' class='catDiv--${category.categoryId} subCatDiv'><span id='catDiv--${category.categoryId}' class='catSpan--${category.categoryId}'><input type='checkbox' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");
				}
			</c:if>
		</c:forEach>
		
	    var categoryMap = '${categoryMap}';
	    var myArray = categoryMap.split("::");
	    var i;
	    for (i = 0; i < myArray.length; ++i) {
	    	$("#cat-"+myArray[i]).prop("checked",true);
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

        $(".arrowIcon").on("click", function () {
            $(this).toggleClass('icon-chevron-down');
            $(this).parent('div > div').toggleClass('showDiv');
        });
        
        $(".arrowIcon + span input[type=checkbox]").click(function() {
            if($(this).prop("checked")) {
            	$(this).parent('span').parent('.moreCat').find('.subCatDiv:not(".moreCat")').find('input[type=checkbox]').prop("checked", true);
            	$(this).parent('span').parent('.moreCat').find('.arrowIcon:not(".icon-chevron-down")').click();
            }
        });

        var checkedChild = $('#categoryDiv input[type="checkbox"]');
        if ($(checkedChild).is(":checked")) {
            $('#categoryDiv input[type="checkbox"]:checked').parents('.moreCat').children('.arrowIcon').click();
        }
        
        $(".c-loader").addClass("d-none");
	    
	});
	
	$('.capitalize-first').on('input', function () {
	    var inputValue = $(this).val();
	    var capitalizedValue = inputValue.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
	    $(this).val(capitalizedValue);
	});
	
	$("#documentUpload").on('change', function(e){
		for(var i = 0; i < this.files.length; i++){
			let fileBloc = $('<span/>', {class: 'file-block'}),
				 fileName = $('<span/>', {class: 'name', text: this.files.item(i).name});
			fileBloc.append('<span class="file-delete"><span>x</span></span>').append(fileName);
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
	
	var brandId = $("#brandId").val();
	
	function removeDoc(e, fileEntryId){
		var element = e;
		
		$.ajax({
			type:"POST",
			url:'${fileRemoveURL}',
			async:true,
			dataType: 'json',
			data:{
				"<portlet:namespace/>fileEntryId":fileEntryId,
				"<portlet:namespace/>brandId":brandId
			},
			success:function(data){
				if(data.docFlag){
					element.parentElement.remove();
				}
			},
		});
	}
	
	var checked;
	var brandName;
	var brandCode;
	var brandExtReferenceId;
	var brandNameFlag = true;
	var brandCodeFlag = true;
	var brandReferenceIdFlag = true;
	var brandDescFlag = true;
	var brandManagerRemarksFlag = true;
	var brandReviewerRemarksFlag = true;
	var brandImageFlag = true;
	var brandDescLength = true;
	var brandManagerRemarksLength = true;
	var brandReviewerRemarksLength = true;
	var brandImageSizeFlag = true;
	
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
	
	function checkValidationManagerRemark(value){
		if(value !== ""){
			let regex = /^[a-zA-Z0-9!%&()_\s\-[\]'"";:.,/|]+$/;
			if(regex.test(value)){
				$(".invalidManRemarks").addClass("d-none");
				brandManagerRemarksFlag = true;
			} else {
				$(".invalidManRemarks").removeClass("d-none");
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
	
	function checkValidationReviewerRemark(value){
		if(value !== ""){
			let regex = /^[a-zA-Z0-9!%&()_\s\-[\]'"";:.,/|]+$/;
			if(regex.test(value)){
				$(".invalidRevRemarks").addClass("d-none");
				brandReviewerRemarksFlag = true;
			} else {
				$(".invalidRevRemarks").removeClass("d-none");
				brandReviewerRemarksFlag = false;
			}
			checkValidationReviewerRemarkLength(value);
		} else {
			brandReviewerRemarksFlag = false;
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
        return allowedTypes.includes(fileType);
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
	
	function checkValidationRemarkLength(value){
		if(value.length<=1000){
			$(".brandManagerLength").addClass("d-none");
			brandManagerRemarksLength = true;
		} else {
			$(".brandManagerLength").removeClass("d-none");
			brandManagerRemarksLength = false;
		}
	
	}
	
	function checkValidationReviewerRemarkLength(value){
		if(value.length<=1000){
			$(".reviewerRemarkLength").addClass("d-none");
			brandReviewerRemarksLength = true;
		} else {
			$(".reviewerRemarkLength").removeClass("d-none");
			brandReviewerRemarksLength = false;
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
					if(data.brandNameSize == 1 && data.brandId == brandId){
						$(".brandNameVal").addClass("d-none");
						brandNameFlag = true;
					} else if(data.brandNameSize > 0){
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
					if(data.brandCodeSize == 1 && data.brandId == brandId){
						$(".brandCodeVal").addClass("d-none");
						brandCodeFlag = true;
					} else if(data.brandCodeSize > 0){
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
					if(data.brandRefIdSize == 1 && data.brandId == brandId){
						$(".brandRefernceVal").addClass("d-none");
						brandReferenceIdFlag = true;
					} else if(data.brandRefIdSize > 0){
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
		var reviewerRemarks = $("#reviewerRemarks").val();
		var brandApprovalStatus = $("#brandApprovalStatus").val();
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
		
		if(brandApprovalStatus == ""){
			$(".brandApprovalStatusReq").removeClass("d-none");
			$("#brandApprovalStatus").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".brandApprovalStatusReq").addClass("d-none");
		}
		
		if(reviewerRemarks == ""){
			$(".reviewerRemarksReq").removeClass("d-none");
			$("#reviewerRemarks").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".reviewerRemarksReq").addClass("d-none");
			if(brandReviewerRemarksFlag){
				$(".invalidRevRemarks").addClass("d-none");
			} else{
				$(".invalidRevRemarks").removeClass("d-none");
				$("#reviewerRemarks").focus();
				$(".c-loader").addClass("d-none");
				return false;
			}
		}
		
		if(brandReviewerRemarksLength){
			$(".brandReviewerLength").addClass("d-none");
		} else{
			$(".brandReviewerLength").removeClass("d-none");
			$("#reviewerRemarks").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandType == ""){
			$(".brandTypeReq").removeClass("d-none");
			$("#brandType").focus();
			$(".c-loader").addClass("d-none");
			return false;
		} else{
			$(".brandTypeReq").addClass("d-none");
		}
		
		if(checked == 0) {
	  		$(".categoryVal").removeClass("d-none");
	  		$(".zeroCatDiv").focus();
	  		$(".c-loader").addClass("d-none");
	  		return false;
        } else {
        	$(".categoryVal").addClass("d-none");
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
			$(".c-loader").addClass("d-none");
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
			$(".invalidManRemarks").addClass("d-none");
		} else{
			$(".invalidManRemarks").removeClass("d-none");
			$("#managerRemarks").focus();
			$(".c-loader").addClass("d-none");
			return false;
		}
		
		if(brandManagerRemarksLength){
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
