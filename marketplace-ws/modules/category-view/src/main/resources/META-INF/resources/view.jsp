<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.marketplace.category.constants.CategoryViewPortletKeys"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ taglib uri="http://liferay.com/tld/site-navigation" prefix="liferay-site-navigation"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%-- <script><%@ include file="/js/main.js" %></script> --%>

<portlet:defineObjects />

<portlet:renderURL var="createCategoryURL">
	<!--  categoryId is parentcategoryId for sub Product thats y passing categoryId as a parentcategoryId -->
	<portlet:param name="parentCategoryId" value="${parentCategoryId}" />
	<portlet:param name="mvcRenderCommandName" value="createCategoryRender" />
</portlet:renderURL>

<portlet:renderURL var="updateCategoryURL">
	<portlet:param name="mvcRenderCommandName" value="updateCategoryRender" />
	<portlet:param name="categoryId" value="${category.categoryId}" />
</portlet:renderURL>

<portlet:renderURL var="deleteCategoryURL">
	<portlet:param name="mvcRenderCommandName" value="updateCategoryRender" />
	<portlet:param name="categoryId" value="${category.categoryId}" />
</portlet:renderURL>

<portlet:renderURL var="viewUrl">
	<portlet:param name="parentCategoryId"
		value="${category.parentCategoryId}" />
</portlet:renderURL>

<portlet:renderURL var="filterRenderURL">
	<portlet:param name="parentCategoryId"
		value="${category.parentCategoryId}" />
	<portlet:param name="mvcRenderCommandName" value="filterRender" />
</portlet:renderURL>

<portlet:resourceURL id="filterResource" var="filterResourceURL" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<h1 class="titlePage">Category View</h1>

<liferay-ui:success key="Category-Created"
	message="Category Created Successfully" />
<liferay-ui:success key="Category-Update"
	message="Category Updated Successfully" />

<%
	// Get the group ID
	long groupId = themeDisplay.getScopeGroupId();
%>



<%
	long parentCategoryId = (long) renderRequest.getAttribute("parentCategoryId");
	PortletURL renderURL = renderResponse.createRenderURL();
	String assetCategoryId = String.valueOf((long) renderRequest.getAttribute("assetCategoryId"));
	String parentCategory = String.valueOf(parentCategoryId);
	String search = (String) renderRequest.getAttribute("search");
	String status = (String) renderRequest.getAttribute("status");
	String activeStatus = (String) renderRequest.getAttribute("activeStatus");
	int count = (int) renderRequest.getAttribute("count");
	String counter = String.valueOf(count);
	renderURL.setParameter("count", counter);
	renderURL.setParameter("assetCategoryId", assetCategoryId);
	renderURL.setParameter("status", status);
	renderURL.setParameter("search", search);
	renderURL.setParameter("activeStatus", activeStatus);
	
	if (parentCategoryId != 0) {
		renderURL.setParameter("parentCategoryId", parentCategory);
	}
	renderURL.setParameter("mvcRenderCommandName", "viewUrl");
	long categoryId = (long) renderRequest.getAttribute("categoryId");
	List<BreadcrumbEntry> breadcrumbEntries = BreadCrumbUtil.getAssetCategoriesBreadcrumbEntries(categoryId,
			request, renderResponse);
	
	 boolean admin = (boolean)renderRequest.getAttribute("Administrator");
	 boolean manager = (boolean) renderRequest.getAttribute("Manager");
	 String isadmin="";
	 
	 if(admin || manager) {
	 	isadmin = createCategoryURL.toString();
	 }
%>

<jsp:useBean id="userData" class="com.marketplace.category.portlet.CategoryViewPortlet" scope="request" />
<c:set var="imagePath" value="<%= request.getContextPath()%>"/>
<c:set var="urlRedirect" value="<%= isadmin %>"/>
<%@ include file="/categorynav.jsp"%>

<div id="osrl"></div>
</div>

<c:if test="<%= ListUtil.isNotEmpty(breadcrumbEntries) %>">
	<liferay-site-navigation:breadcrumb
		breadcrumbEntries="<%= breadcrumbEntries %>" />
</c:if>

<liferay-ui:search-container id="CategoryTable"
	emptyResultsMessage='<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio">
	<img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="${imagePath}/images/search_state.gif">
	</div>
	</div>
	<div class="">
		<span class="text-truncate-inline">
			<span class="text-truncate">
				<a href="${urlRedirect}">No Categories Found</a>
			</span>
		</span>
	</div>
	</div>'
	total="${count}" delta="10"
	iteratorURL="<%= renderURL %>">
	
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.dao.search.EmptySearch"
		keyProperty="searchContainer" modelVar="searchContainer" />

	<liferay-ui:search-container-results results="${myCategories}" />

	<liferay-ui:search-container-row
		className="com.marketplace.category.model.Category"
		keyProperty="categoryId" modelVar="category" escapedModel="true">

		<c:if test="${category.categoryImageURL ==  ''}">
			<liferay-ui:search-container-column-text name="Image"><img class="categoryImage" src="${imagePath}/images/no-image-available.jpg"/></liferay-ui:search-container-column-text>
		</c:if>
		<c:if test="${category.categoryImageURL !=  ''}">
        	<liferay-ui:search-container-column-text name="Image"><img class="categoryImage" src="${category.categoryImageURL}" alt="Image" /></liferay-ui:search-container-column-text>
        </c:if>
        
		<liferay-ui:search-container-column-text name="Name"
			orderableProperty="categoryName"
			orderable="true">
			
			<c:if test="${category.categoryApprovalStatus eq 'Approved' || category.categoryApprovalStatus eq 'Rejected'}">
			<a
				href="${viewUrl}&<portlet:namespace/>parentCategoryId=${category.categoryId}&<portlet:namespace/>assetCategoryId=${category.assetCategoryId}"
				style="text-decoration: none;">${category.categoryName}</a>

			</c:if>
			<c:if test="${category.categoryApprovalStatus ne 'Approved' && category.categoryApprovalStatus ne 'Rejected'}">${category.categoryName}</c:if>
				
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="categoryType"
			orderableProperty="categoryType" orderable="true" />
			
		<liferay-ui:search-container-column-text name="Workflow Status" >
			${category.categoryApprovalStatus}
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Active Status">
			<c:if test="${category.categoryInactive == true}">Inactive</c:if>
			<c:if test="${category.categoryInactive == false}">Active</c:if>
		</liferay-ui:search-container-column-text>
		<c:choose>
			<c:when test="${Administrator}">
				<liferay-ui:search-container-column-text name="Assign to">
					<c:if test="${category.categoryApprovalStatus eq 'Pending'}">${userData.userName(category.assignManager)}</c:if>
					<c:if test="${category.categoryApprovalStatus eq 'In-Review' }">${userData.userName(category.assignReviewer)}</c:if>
					<c:if test="${category.categoryApprovalStatus == 'Approved' }">${userData.userName(category.assignReviewer)}</c:if>
					<c:if test="${category.categoryApprovalStatus == 'Rejected' }">${userData.userName(category.assignReviewer)}</c:if>
        	</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="${Manager}">
				<liferay-ui:search-container-column-text name="Assign to">
				<c:if test="${category.categoryApprovalStatus eq 'Pending'}">${userData.userName(category.assignReviewer)}</c:if>
					<c:if test="${category.categoryApprovalStatus eq 'In-Review' }">${userData.userName(category.assignReviewer)}</c:if>
					<c:if test="${category.categoryApprovalStatus == 'Approved' }">${userData.userName(category.assignReviewer)}</c:if>
					<c:if test="${category.categoryApprovalStatus == 'Rejected' }">${userData.userName(category.assignReviewer)}</c:if>
        	</liferay-ui:search-container-column-text>
			<%-- <liferay-ui:search-container-column-text name="Created By">
        		${userData.userName(category.createdBy)}
        	</liferay-ui:search-container-column-text> --%>
			</c:when>
			<c:when test="${Reviewer}">
				<liferay-ui:search-container-column-text name="Created By">
        		${userData.userName(category.createdBy)}
        	</liferay-ui:search-container-column-text>
			</c:when>
		</c:choose>
		
		<liferay-ui:search-container-column-text name="Created Date"  orderableProperty="createDate" orderable="true">
        <fmt:formatDate value="${category.createDate}" pattern="yy-MM-dd, hh:mm" var="formattedDate"/>${formattedDate }
        
        </liferay-ui:search-container-column-text>
        
        <liferay-ui:search-container-column-text name="Modified Date"  orderableProperty="modifiedDate" orderable="true">
        <fmt:formatDate value="${category.modifiedDate}" pattern="yy-MM-dd, hh:mm" var="formatModifiedDate" />
        	<c:if test="${category.createDate != category.modifiedDate}">
	        	${formatModifiedDate}
	        </c:if>
        
        </liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="">
			<c:set var="icon" value="fa-eye" />
		 	
<%
    if ((category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.APPROVED) || 
         category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.REJECTED)) && admin) {
%>
    <c:set var="icon" value="fa-edit" />
<%
    } else if (category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.INREVIEW) &&
               CategoryPermission.contains(permissionChecker, groupId, CategoryViewPortletKeys.REVIEW)) {
%>
   <c:set var="icon" value="fa-edit" />
<%
    } else if ((category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.PENDING) ||
                (category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.APPROVED) && category.getCreatedBy() == themeDisplay.getUserId())
                ||(category.getCategoryApprovalStatus().equalsIgnoreCase(CategoryViewPortletKeys.REJECTED) && category.getCreatedBy() == themeDisplay.getUserId()) 
                ) && manager ) {
%>
   <c:set var="icon" value="fa-edit" />
<%
    }
%>

		<a
			href="${updateCategoryURL}&<portlet:namespace/>categoryId=${category.categoryId}&<portlet:namespace/>parentCategoryId=${category.parentCategoryId}&<portlet:namespace/>assetCategoryId=${assetCategoryId}">
			<i class="fas <c:out value="${icon}"/>"
			style="-fa-primary-color: #001c40; - -fa-secondary-color: #183153;"></i>
		</a>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<!-- Add the search iterator for pagination -->
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<script>
$(document).ready(function() {
	
	$(".portlet-header").hide();
    $("#redirectLink").click(function(e) {
        e.preventDefault(); 
    	window.location.href ='<%=createCategoryURL.toString()%>';
    });
	
	/* $(".pagination li.page-item:nth-child(2) a").text("").append('<i class="icon-chevron-left icon-2x"></i>');
	$(".pagination li.page-item:nth-child(3) a").text("").append('<i class="icon-chevron-right icon-2x"></i>'); */
   
	var from = ${from};
	var count = ${count};
	var to = ${to};
	var current = ${cur};
	var result = (current * 10 > count) && (current-1 * 10 <= count);
	
	if(from < 10){
		$('.pagination li.page-item:nth-child(2) a').text("");
	}
	
	if(result){
		$(".pagination li.page-item:nth-child(3) a").text("");
	}
	
	if(count <= 10){
		$('.pagination li.page-item:nth-child(2) a').text("");
		$(".pagination li.page-item:nth-child(3) a").text("");
	}
});

function setupValidation(formName) {
	var remarkSecForm = $("#" + formName);
	remarkSecForm.validate({
		rules : {
		// Define rules for other form fields here
		},
		messages : {
		// Define error messages for other form fields here
		}
	});
	
	$.validator.addMethod("validateCategoryName", function(value, element) {
		var isValid = false;
		var categoryId = $("#categoryId").val();
		$.ajax({
			type : "GET",
			url : "${categoryCheckUrl}",
			data : {
				'<portlet:namespace/>categoryName' : value,
			},
			async : false, // Ensure synchronous behavior
			dataType : "json",
			success : function(data) {
				console.log(data.size);
				if (data.size == 1 && data.categoryId == categoryId) {
					isValid = true;
				} else if (data.size > 0) {
					isValid = false;
				} else {
					isValid = true;
				}

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("try again " + textStatus);
			}
		});

		return isValid;
	}, "Category name already exists.");

	$("#categoryName").rules("add", {
		validateCategoryName : true
	});

	$("#" + formName + " .form-field").each(function() {
		var rules = defineRulesBasedOnClass(this);
		$(this).rules("add", rules);
	});
}

function defineRulesBasedOnClass(element) {
	var rules = {};
	var messages = {};

	if ($(element).hasClass('field-required')) {
		rules.required = true;
	}

	rules.messages = messages;
	return rules;
}
</script>
