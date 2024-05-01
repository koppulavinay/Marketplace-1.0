<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%> 

<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ page import="com.marketplace.category.model.Category" %>
<%@ page import="com.marketplace.category.service.CategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import ="com.marketplace.brand.model.Brand" %>
<%@ page import="com.marketplace.brand.document.master.model.BrandDocumentUpload"%>
<%@ page import="com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil" %>
<%@ page import="com.marketplace.brand.models.DocumentModel" %>
<%@ page import="com.marketplace.brand.util.BrandCustomUtil" %>
<%@ page import="com.marketplace.brand.category.map.model.BrandCategoryMap"%>
<%@ page import="com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTransition" %>
<%@ page import="java.util.List" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://nickpiesco.github.io/alloy-ui-font-awesome-cheatsheet/css/style.css">

<style>
.container{
	max-width:800px;
}

.disableText {
    pointer-events: none;
}

#categoryDiv input[type="checkbox"] {margin-right: 5px; margin-top: -4px;}

.subCatDiv {display: none;}
        
.arrowIcon {cursor: pointer; margin-right: 5px; color: #505050;}
        
.showDiv > div.subCatDiv {display: block; margin-left: 30px;}
 
.icon-chevron-down:before {content: "\f078" !important;}
     
</style>

<div class="c-loader d-none">
    <span></span>
</div>
<%-- <% --%>

<!-- // WorkflowTask workflowTask = (WorkflowTask) renderRequest.getAttribute("workflow"); -->
<!-- // List<WorkflowTransition> workflowTransitions= (List<WorkflowTransition>) renderRequest.getAttribute("workflowTransition"); -->
<%--  %> --%>
 
 
<%--  <c:if test="<%= !workflowTask.isCompleted() %>"> --%>
<%-- 	  <%	for (WorkflowTransition workflowTransition : workflowTransitions) { --%>
					
<%-- 					%> --%>
<%-- 					<%= workflowTransition.getName() %> --%>
<%-- 	<%} %> --%>
	
<%--  </c:if> --%>

<%

//ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
Brand brand= (Brand)renderRequest.getAttribute("BRAND");
String categoryIds = "";
List<BrandCategoryMap> brandCategoryMaps = BrandCategoryMapLocalServiceUtil
.findByFBYBrandId(brand.getBrandId());
categoryIds = BrandCustomUtil.getBrandCategories(brandCategoryMaps);

List<DocumentModel> documentModels = new ArrayList<>();
String brandReviewer = UserLocalServiceUtil.getUser(brand.getBrandReviewer()).getFullName();

DocumentModel brandImageDoc = new DocumentModel();
List<BrandDocumentUpload> brandDocumentUploads = BrandDocumentUploadLocalServiceUtil
.findByFBYBrandId(brand.getBrandId());
documentModels = BrandCustomUtil.getBrandDocuments(brandDocumentUploads, themeDisplay, documentModels);
System.out.println(brandDocumentUploads);
if(brand.getBrandImageUpload() != 0) {
	System.out.println("Yes");
DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(brand.getBrandImageUpload());
System.out.println("Dlfileentry :::::  " + dlFileEntry);
String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
	+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/"
	+ dlFileEntry.getFileName() + "/" + dlFileEntry.getUuid();
brandImageDoc.setFileEntryId(String.valueOf(brand.getBrandImageUpload()));
brandImageDoc.setUploadedDocName(dlFileEntry.getFileName());
brandImageDoc.setDownloadDocumentLink(url);
}


List<Category> categories = CategoryLocalServiceUtil.getbyStatus("Approved");
System.out.println(categories);
%>


<liferay-ui:error key="error-key" message="Brand Updation Failed" />

<portlet:actionURL var="updateBrandURL" name="updateBrand" />

<portlet:renderURL var="dashboardURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
	
<form method="post" action="${updateBrandURL}" onsubmit="return checkBrandFrom(this)" 
	name="<portlet:namespace/>myForm" enctype="multipart/form-data">
	
	<input type="hidden" id="brandId" name="<portlet:namespace/>brandId" value="${BRAND.brandId}">
	
	<div class="">
    	<div class="customform row" style="margin-left:20px">
	
			<div class="col-6">
				<div class="form-group">
					<label for="brandCode"><liferay-ui:message key="brandCode" /></label>
					<input type="text" class="form-control disableText" id="brandCode" name="<portlet:namespace/>brandCode" value="${BRAND.brandCode}" 
				  maxlength="255">
					<label class="error d-none brandCodeVal">Brand code already exists.</label>
					<label class="error d-none brandCodeInvalid">Invalid input</label>
				</div>
			</div>
			
			<div class="col-6">
				<div class="form-group">
					<label for="brandName"><liferay-ui:message key="brandName" /><span class="requiredStar">*</span></label>
					<input type="text" class="form-control capitalize-first disableText" id="brandName" name="<portlet:namespace/>brandName" value="${BRAND.brandName}"
					  maxlength="255" onblur="brandNameVal()">
					<label class="error d-none brandNameVal">Brand name already exists.</label>
					<label class="error d-none brandNameReq">This field cannot be left blank.</label>
					<label class="error d-none brandNameInvalid">Invalid input</label>
				</div>
			</div>
		
			<div class="col-12">
				<div class="form-group">
					<label for="brandDescription"><liferay-ui:message key="brandDescription" /></label>
					<textarea class="form-control disableText" id="brandDescription" name="<portlet:namespace/>brandDescription"
						 maxlength="1000">${BRAND.brandDescription}</textarea>
					<label class="error d-none invalidDesc">Invalid input</label>
					<label class="error d-none Desclength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
		
			<div class="col-6">
				<div class="form-group">
					<label for="brandOwner"><liferay-ui:message key="brandOwner" /></label>
					<input type="text" class="form-control disableText" id="brandOwner" name="<portlet:namespace/>brandOwner" value="${BRAND.brandOwner}"
						 maxlength="120">
				</div>
			</div>
			
			<div class="col-6"></div>
			
			<div class="col-6">
				<div class="form-group">
					<label for="brandReviewer"><liferay-ui:message key="brandReviewer" /><span class="requiredStar">*</span></label>
					<c:set var="brandreviewer" value="<%= brandReviewer %>"/>
					<h5 class="form-control">${brandreviewer }</h5>
					
				  	<label class="error d-none brandReviewerReq">This field cannot be left blank.</label>
				</div>
			</div>
		
			<div class="col-6">
				<div class="form-group">
					<label for="brandType"><liferay-ui:message key="brandType" /><span class="requiredStar">*</span></label>
					<select name="<portlet:namespace/>brandType" id="brandType" class="form-control disableText">
						<option value="">${BRAND.brandType}</option>
						<option value="Branded"><liferay-ui:message key="branded" /></option>
						<option value="Unbranded"><liferay-ui:message key="unBranded" /></option>
					</select>
					<label class="error d-none brandTypeReq">This field cannot be left blank.</label>
				</div>
			</div>
		
			<div class="col-12">
				<div class="form-group">
					<label for="categoryMap"><liferay-ui:message key="categoryMap" /><span class="requiredStar">*</span></label><br/>
					   <div id="categoryDiv" class=" bgcolor disableText"></div>
					   <label class="categoryVal d-none error">This field cannot be left blank.</label>
				</div>
			</div>
		
			<div class="col-12">
				<div class="form-group">
					<label for="documentUpload"><liferay-ui:message key="documentUpload" /></label>
					<input type="file" class="form-control disableText" id="documentUpload" name="<portlet:namespace/>documentUpload" multiple 
						accept="application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/png,image/jpg,image/jpeg" 
						>
				</div>
				<h5 style="margin-top: -20px; font-weight: normal;">(Note: Allowed files type : pdf, docx, jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<p id="files-area">
					<span id="filesList">
						<span id="files-names">
							<c:forEach var="docModel" items="<%= documentModels %>">
								<span class="file-deleteDoc disableText">
									<%-- <span class="remove-button" onclick="removeDoc(this, '${docModel.fileEntryId}')">x</span> --%>
									<a target="_blank" href="${docModel.downloadDocumentLink}">${docModel.uploadedDocName}</a>
								</span>
							</c:forEach>
						</span>
					</span>
				</p>
			</div>
		
			<div class="col-6">
				<div class="form-group">
					<label for="externalReferenceId"><liferay-ui:message key="externalReferenceId" /></label>
					<input type="text" class="form-control disableText" id="externalReferenceId" name="<portlet:namespace/>externalReferenceId" value="${brand.externalReferenceId}"
						onpaste="return false;"  maxlength="75" >
					<label class="error d-none brandRefernceVal">Brand referenceId already exists.</label>
					<label class="error d-none brandRefInvalid">Invalid input</label>
				</div>
			</div>
		
			<div class="col-6">
				<div class="form-group">
					<label for="status"><liferay-ui:message key="status" /></label>
					<select name="<portlet:namespace/>currentStatus" id="currentStatus" class="form-control disableText disableText">
						
							<option value="${brand.brandApprovalStatus}" selected>${BRAND.brandApprovalStatus}</option>
					</select>
				</div>
			</div>
			
			<div class="col-6">
				<%-- <c:choose>
					<c:when test="${Reviewer}">
						<div class="form-group">
							<label for="brandApprovalStatus"><liferay-ui:message key="actionToBeTaken" /><span class="requiredStar">*</span></label>
							<select name="<portlet:namespace/>brandApprovalStatus" id="brandApprovalStatus" class="form-control disableText">
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
				
			</div>
			
			<div class="col-12">
				<div class="form-group">
					<label for="reviewerRemarks"><liferay-ui:message key="reviewerRemarks" /><span class="requiredStar">*</span></label>
					<textarea class="form-control disableText" id="reviewerRemarks" name="<portlet:namespace/>reviewerRemarks"
						 maxlength="1000">${BRAND.reviewerRemarks}</textarea>
					
				</div>
			</div>
			<div class="col-12">
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
						accept="image/png,image/jpg,image/jpeg" >
				</div>
				<h5 style="margin-top: -20px; font-weight: normal;">(Note: Allowed files type : jpeg, jpg, png; Maximum 5MB allowed)</h5>
				<label class="error d-none imageTypeError">Invalid file type</label>
				<label class="error d-none imageSizeError">File size exceeds maximum limit(5 MB)</label>
				<p id="files-area">
					<span id="filesList">
						<span id="brand-img-name">
							<span class="brand-img-delete">
								<%-- <span class="remove-button" onclick="removeDoc(this, '${docModel.fileEntryId}')">x</span> --%>
								<c:set var="brandImageDoc1" value="<%= brandImageDoc %>"/>
								<a target="_blank" href="${brandImageDoc1.downloadDocumentLink}">${brandImageDoc1.uploadedDocName}</a>
							</span>
						</span>
					</span>
				</p>
			</div>
			
			<div class="col-12">
				<div class="form-group">
					<label for="managerRemarks"><liferay-ui:message key="managerRemarks" /></label>
					<textarea class="form-control disableText" id="managerRemarks" name="<portlet:namespace/>managerRemarks"
						onkeydown="return /[a-zA-Z0-9|\.|\,\s!%&()_\-\[\]\';:.,\/|]/.test(event.key)" onblur="checkValidationManagerRemark(this.value)" maxlength="1000">${BRAND.managerRemarks}</textarea>
					<label class="error d-none invalidManRemarks">Invalid input</label>
					<label class="error d-none brandManagerLength">Length exceeds maximum limit(1000 character)</label>
				</div>
			</div>
			
			<div class="d-none">
				<div class="col-4">
				<div class="form-group">
					<label for="customAtr1"><liferay-ui:message key="customAtr1" /></label>
					<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr1" value="${BRAND.customAtr1}"
						onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
				</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr2"><liferay-ui:message key="customAtr2" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr2" value="${BRAND.customAtr2}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">	
					<div class="form-group">
						<label for="customAtr3"><liferay-ui:message key="customAtr3" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr3" value="${BRAND.customAtr3}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr4"><liferay-ui:message key="customAtr4" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr4" value="${BRAND.customAtr4}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr5"><liferay-ui:message key="customAtr5" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr5" value="${BRAND.customAtr5}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr6"><liferay-ui:message key="customAtr6" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr6" value="${BRAND.customAtr6}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr7"><liferay-ui:message key="customAtr7" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr7" value="${BRAND.customAtr7}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr8"><liferay-ui:message key="customAtr8" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr8" value="${BRAND.customAtr8}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr9"><liferay-ui:message key="customAtr9" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr9" value="${BRAND.customAtr9}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
				
				<div class="col-4">
					<div class="form-group">
						<label for="customAtr10"><liferay-ui:message key="customAtr10" /></label>
						<input type="text" class="form-control disableText" name="<portlet:namespace/>customAtr10" value="${BRAND.customAtr10}"
							onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)">
					</div>
				</div>
			</div>
			
			<div class="col-4">
				<%-- <c:if test="${Administrator && (brand.brandApprovalStatus == 'Approved' || brand.brandApprovalStatus == 'Rejected')}">
					<button type="submit" class="btn btn-primary submitBtn mr-3">Submit</button>
				</c:if>
				<c:if test="${Reviewer && (brand.brandApprovalStatus == 'Pending')}">
					<button type="submit" class="btn btn-primary submitBtn mr-3">Submit</button>
				</c:if> --%>
				
				
				
				<a href="${dashboardURL}" class="btn button-danger">Cancel</a>
			</div>
			
		</div>
	</div>
</form>
${categories}

<script type="text/javascript">

	
	var brandDocumentFlag = true;
	var brandDocumentSizeFlag = true;

	$(document).ready(function() {
		
		$(".c-loader").removeClass("d-none");
		$(".portlet-title-text").text("Update Brand");
		
		var inputFields = $(".customform label, .customform input");
		var selectStatusField = $("#brandApprovalStatus");
		var currentStatusField = $("#currentStatus");
		var selectFields = $(".customform select, input[type=checkbox]");
		var brandApprovalStatus = '${BRAND.brandApprovalStatus}';
		var brandInactive = ${BRAND.brandInactive};
		var downForSeller = ${BRAND.downForSeller};
		var downForBuyer = ${BRAND.downForBuyer};
		var downForMaintenance = ${BRAND.downForMaintenance};
	    $("#brandReviewer").val('${BRAND.brandReviewer}');
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
	    
	    inputFields.addClass('disableText');
    	selectStatusField.addClass('disableText');
    	currentStatusField.addClass('disableText');
    	selectFields.addClass('disableText');
    	$("#categoryDiv").addClass('disableText');
    	$("#reviewerRemarks").addClass('disableText');
    	$("#managerRemarks").addClass('disableText');
    	$("#brandDescription").addClass('disableText');
    	
	    
	    <c:forEach items="<%= categories %>" var="category">
			<c:if test = "${category.parentCategoryId == 0}">
				$("#categoryDiv").append("<div class='catDiv--${category.categoryId} zeroCatDiv'><span class='catSpan--${category.categoryId}'><input type='checkbox' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");	
			</c:if>
			
			<c:if test = "${category.parentCategoryId != 0}">
				if($('.catDiv--${category.parentCategoryId}').length){
					$('.catDiv--${category.parentCategoryId}').append("<div data='catDiv--${category.categoryId}' class='catDiv--${category.categoryId} subCatDiv'><span id='catDiv--${category.categoryId}' class='catSpan--${category.categoryId}'><input type='checkbox' name='<portlet:namespace/>categoryMap' id='cat-${category.categoryId}' value='${category.categoryId}'>&nbsp;${category.categoryName}</span></div>");
				}
			</c:if>
		</c:forEach>
		
	    var categoryMap = '<%=categoryIds%>';
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
            if ($(this).prop("checked")) {
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
	
	
	
		
	
		
		
</script>
