<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.marketplace.category.models.DocumentModels" %>
<%@ page import="com.marketplace.category.model.Category" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<portlet:renderURL var="viewUrl">
	<portlet:param name="parentCategoryId" value="${category.parentCategoryId}" />
</portlet:renderURL>

<portlet:resourceURL var="categoryCheckUrl" id="categoryCheck" />
<portlet:actionURL var="updateCategory" name="updateCategory" />

<liferay-ui:error key="error-key" message="Category Updation Failed" />

<style>
.container{
	max-width:800px;
}

.disableText {
    pointer-events: none;
}
</style>

<%
	long groupId = themeDisplay.getScopeGroupId();
Category category = (Category) request.getAttribute("CATEGORY");
long fileEntryId = category.getCategoryImageId();
User categoryManager = UserLocalServiceUtil.getUser(category.getAssignManager());
String categoryReviewer = UserLocalServiceUtil.getUser(category.getAssignReviewer()).getFullName();

DocumentModels documentModel = new DocumentModels();
	if (category.getCategoryImageId() != 0) {
		
		DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
		
		documentModel.setUploadedDocName(dlFileEntry.getFileName());
		documentModel.setDownloadDocumentLink(category.getCategoryImageURL());
		
	}	
%>


<form method="POST" id="CategoryForm" onsubmit="return checkCategoryFrom(this)" name="<portlet:namespace/>myForm" 
	enctype="multipart/form-data" action="${updateCategory}">
	
	<input type="hidden" name="<portlet:namespace />parentCategoryId" value="${CATEGORY.parentCategoryId}" />
	<input type="hidden" name="<portlet:namespace />categoryId" id="categoryId" value="${CATEGORY.categoryId}" />
	<input type="hidden" name="<portlet:namespace />assetCategoryId" value="${assetCategoryId}" />
	<input type="hidden" id="workflowId" name="<portlet:namespace/>workflowId" value="${workFlowId}">
	<div class="container">
		<div class="customform row">
			<div class="col-6">
				<div class="form-group">
					<label for="categoryCode"><liferay-ui:message key="categoryCode" /></label>
					<input type="text" id="categoryCode" class="form-control" name="<portlet:namespace />categoryCode" 
						onkeydown="return /[a-zA-Z0-9]/.test(event.key)" onpaste="return false;" maxlength="255" value="${CATEGORY.categoryCode}" />
				</div>
			</div>
			<div class="col-6">
				<div class="form-group">
					<label for="categoryName"><liferay-ui:message key="categoryName" /><span class="requiredStar">*</span></label>
					<input type="text" id="categoryName" class="form-control form-field field-required capitalize-first"
						name="<portlet:namespace />categoryName" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" maxlength="255" 
						onpaste="return false;" value="${CATEGORY.categoryName}" />
				</div>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="categoryDescription"><liferay-ui:message key="categoryDescription" /></label>
					<textarea id="categoryDescription" class="form-control categoryDescription" name="<portlet:namespace />categoryDescription" 
					onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)">${CATEGORY.categoryDescription}</textarea>
				</div>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="categoryType"><liferay-ui:message key="categoryType" /><span class="requiredStar">*</span></label>
					<select id="categoryType" class="form-control form-field field-required" name="<portlet:namespace />categoryType">
						<option value="" >${CATEGORY.categoryType}</option>
						
					</select>
				</div>
			</div>
			<div class="col-6">
				<div class="form-group">
				
				<c:set var="categorymanager" value="<%= categoryManager %>"/>
					
					<label for="categoryAssignManager"><liferay-ui:message key="categoryAssignManager" /><span class="requiredStar">*</span></label>
					<h5 class="form-control form-field">${categorymanager.fullName }</h5>
				</div>
			</div>
			<div class="col-6">
				<div class="form-group">
				<c:set var="categoryreviewer" value="<%= categoryReviewer %>"/>
					<label for="categoryAssignReviewer"><liferay-ui:message key="categoryAssignReview" /><span class="requiredStar">*</span></label>
					<input type="text" id="categoryAssignReview" class="form-control form-field field-required capitalize-first"
						name="<portlet:namespace />categoryAssignReview" value="${categoryreviewer}" />
				</div>
			</div>
			<div class="col-6">
				<div class="form-group disableText">
					<label for="categoryStatus"><liferay-ui:message key="categoryStatus" /></label>
					<select id="currentStatus" class="form-control" name="<portlet:namespace />currentStatus">
						<option value="${CATEGORY.categoryApprovalStatus}">${CATEGORY.categoryApprovalStatus}</option>
					</select>
				</div>
			</div>
			<div class="col-6">
				<%-- <div class="form-group">
					<label for="categoryStatus"><liferay-ui:message key="actionToBeTaken" /><span class="requiredStar">*</span></label>
					<select id="categoryStatus" class="form-control form-field field-required" name="<portlet:namespace />categoryStatus">
						<option value="">Select Status</option>
						<c:if test="${Manager}">
							<option value="In-Review" ${category.categoryApprovalStatus  == 'In-Review' ? 'selected' : ''}>In-Review</option>
							<option value="Manager In-review" >Manager In-review</option>
						</c:if>
						<c:if test="${Administrator}">
							<option value="Pending" >Pending</option>
							<option value="Draft" selected >In-Review</option>
						</c:if>
						<c:if test="${Reviewer}">
							<option value="Approved" ${category.categoryApprovalStatus  == 'Approved' ? 'selected' : ''}>Approved</option>
							<option value="Rejected" ${category.categoryApprovalStatus  == 'Rejected' ? 'selected' : ''}>Rejected</option>
						</c:if>
					
				</div> --%>
			</div>
			<c:if test="${CATEGORY.categoryApprovalStatus  != 'Pending' || CATEGORY.categoryApprovalStatus == 'In-Review'}">
				<div class="col-12">
					<div class="form-group">
						<label for="reviewerRemarks" class="reviewerRemarks"><liferay-ui:message key="reviewerRemarks" /></label>
						<textarea class="form-control reviewerRemarks" id="reviewerRemarks" name="<portlet:namespace/>reviewerRemarks" 
							onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)">${CATEGORY.reviewerRemarks}</textarea>
						<label class="error d-none categoryRemarksReq">This field is required.</label>
					</div>
				</div>
			</c:if>
			<div class="col-6">
				<div class="form-group">
					<label for="categoryExpiryDate"><liferay-ui:message key="categoryExDate" /></label>
					<input value="<fmt:formatDate value="${CATEGORY.categoryExpiryDate}"  pattern="yyyy-MM-dd" />" type="date" 
						id="categoryExpiryDate" class="form-control" name="<portlet:namespace />categoryExpiryDate" onkeydown="return false" />
				</div>
			</div>
			<div class="col-12">
				<div class="form-group d-flex justify-content-between">
					<div>
						<input type="checkbox" class="" id="categoryInactive" name="<portlet:namespace/>categoryInactive">&nbsp;
						<label for="categoryInactive"><liferay-ui:message key="categoryInactive" /></label>&nbsp;&nbsp;
					</div>
					<div>
						<input type="checkbox" id="downForSeller" name="<portlet:namespace/>downForSeller">&nbsp;
						<label for="downForSeller"><liferay-ui:message key="downForSeller" /></label>&nbsp;&nbsp;
					</div>
					<div>
						<input type="checkbox" id="downForBuyer" name="<portlet:namespace/>downForBuyer">&nbsp;
						<label for="downForBuyer"><liferay-ui:message key="downForBuyer" /></label>&nbsp;&nbsp;
					</div>
					<div>
						<input type="checkbox" id="downForMaintenance" name="<portlet:namespace/>downForMaintenance">&nbsp;
						<label for="downForMaintenance"><liferay-ui:message key="downForMaintenance" /></label>
					</div>
				</div>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="externalReferenceId"><liferay-ui:message key="extRefID" /></label>
					<input value="${CATEGORY.externalReferenceId}" type="text" id="externalReferenceId" class="form-control"
						name="<portlet:namespace />externalReferenceId" onkeydown="return /[a-zA-Z0-9]/.test(event.key)" 
						onpaste="return false;" maxlength="255"/>
				</div>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="categoryImage"><liferay-ui:message key="categoryImage" /></label>
					<input type="file" class="form-control" id="categoryImage" name="<portlet:namespace/>categoryImage" 
					accept="image/png,image/jpg,image/jpeg" data-msg-accept="Invalid File Type" value="<%= documentModel.getUploadedDocName()%>">
				</div>
				<h5 style="margin-top: -20px; font-weight: normal;">(Note : Allowed files type : jpeg, jpg, png)</h5>
				<p id="files-area">
					<span id="filesList">
						<span id="files-names">
						
						<c:set var="filename" value="<%=documentModel.getUploadedDocName() %>"  />
							<c:if test="${not empty filename }">
							<a target="_blank" href="<%= documentModel.getDownloadDocumentLink() %>">${filename }</a>
						</c:if>
						</span>
					</span>
				</p>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="termsAndCondition" class="termsAndCondition"><liferay-ui:message key="termsandcondition" /></label>
					<textarea id="termsAndCondition" class="form-control termsAndCondition" name="<portlet:namespace />termsAndCondition" 
					onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)">${CATEGORY.termsCondition}</textarea>
				</div>
			</div>
			<div class="col-12">
				<div class="form-group">
					<label for="managerRemarks" class="managerRemarks"><liferay-ui:message key="managerRemarks" /></label>
					<textarea class="form-control managerRemarks" id="managerRemarks" name="<portlet:namespace/>managerRemarks" 
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)">${CATEGORY.managerRemarks}</textarea>
				</div>
			</div>
			<div class="d-none">
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr1"><liferay-ui:message key="customAtr1" /></label>
						<input value="${category.customAtr1}"type="text" id="customAtr1" class="form-control"
							name="<portlet:namespace />customAtr1" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr2"><liferay-ui:message key="customAtr2" /></label>
						<input value="${category.customAtr2}" type="text" id="customAtr2" class="form-control"
							name="<portlet:namespace />customAtr2" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr3"><liferay-ui:message key="customAtr3" /></label>
						<input value="${category.customAtr3}" type="text" class="form-control" id="customAtr3"
							name="<portlet:namespace />customAtr3" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr4"><liferay-ui:message key="customAtr4" /></label>
						<input value="${category.customAtr4}" type="text" id="customAtr4" class="form-control"
							name="<portlet:namespace />customAtr4" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
				<div class="form-group">
					<label for="customAtr5"><liferay-ui:message key="customAtr5" /></label>
					<input value="${category.customAtr5}" type="text" id="customAtr5" class="form-control"
						name="<portlet:namespace />customAtr5" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
				</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr6"><liferay-ui:message key="customAtr6" /></label>
						<input value="${category.customAtr6}" type="text" id="customAtr6" class="form-control"
							name="<portlet:namespace />customAtr6" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr7"><liferay-ui:message key="customAtr7" /></label>
						<input value="${category.customAtr7}" type="text" id="customAtr7" class="form-control"
							name="<portlet:namespace />customAtr7" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr8"><liferay-ui:message key="customAtr8" /></label>
						<input value="${category.customAtr8}" type="text" id="customAtr8" class="form-control"
							name="<portlet:namespace />customAtr8" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr9"><liferay-ui:message key="customAtr9" /></label>
						<input value="${category.customAtr9}" type="text" id="customAtr9" class="form-control"
							name="<portlet:namespace />customAtr9" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr10"><liferay-ui:message key="customAtr10" /></label>
						<input value="${category.customAtr10}" type="text" id="customAtr10" class="form-control"
							name="<portlet:namespace />customAtr10" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" onpaste="return false;"/>
					</div>
				</div>
			</div>

			<div class="col-12">
<%-- 			<%if (CategoryPermission.contains(permissionChecker, groupId, "UPDATE_CATEGORY")) {%> --%>
				<!-- <button type="submit" class="btn btn-primary" onclick="setupValidation('CategoryForm')">Submit</button> -->
<%-- 				<%} %> --%>
				<a href="${viewUrl}" class="btn button-danger">Cancel</a>
			</div>
		</div>
	</div>
</form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/additional-methods.min.js"
	integrity="sha512-TiQST7x/0aMjgVTcep29gi+q5Lk5gVTUPE9XgN0g96rwtjEjLpod4mlBRKWHeBcvGBAEvJBmfDqh2hfMMmg+5A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
<script>

	

	function FutureDate() {
		var currentDate = new Date();
		var currDate = currentDate.getDate() + 1;
		var currMonth = currentDate.getMonth() + 1; // Months are zero-based
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

	
	var inputFields = $(".customform label, .customform input");
	var selectStatusField = $("#categoryStatus");
	var selectFields = $(".customform select, input[type=checkbox]");

	var isPending = '${CATEGORY.categoryApprovalStatus}' === "Pending";
	var isReview = '${CATEGORY.categoryApprovalStatus}' === "In-Review";
	var isApproved = '${CATEGORY.categoryApprovalStatus}' === "Approved";
	var isRejected = '${CATEGORY.categoryApprovalStatus}' === "Rejected";

	$(document).ready(function() {
		$(".portlet-title-text").text("Update Category");
		$("#categoryAssignReviewer").val('${CATEGORY.assignReviewer}');
		$("#categoryAssignManager").val('${CATEGORY.assignManager}');
		var categoryInactive = ${CATEGORY.categoryInactive};
		
		var downForSeller =${CATEGORY.downForSeller};
		var downForBuyer = ${CATEGORY.downForBuyer};
		var downForMaintenance = ${CATEGORY.downForMaintenance};
		
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
	    
	    if(categoryInactive){
	    	$("#categoryInactive").prop("checked", true);
	    } else{
	    	$("#categoryInactive").prop("checked", false);
	    }

		// Call the function on page load
		setReadOnlyState();
		FutureDate();
	});
	
	function setReadOnlyState() {
		
			inputFields.addClass("disableText");
			selectFields.addClass("disableText");
			$(".categoryDescription").addClass('disableText');
			$(".submitBtn").addClass("d-none");
			$(".reviewerRemarks").addClass('disableText');
			$(".managerRemarks").addClass('disableText');
			$(".termsAndCondition").addClass('disableText');
		

	}


	
</script>
