<%@page import="com.marketplace.brand.model.Brand"%>
<%@page import="com.marketplace.brand.portlet.BrandViewPortlet"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.portlet.PortletURL"%> 
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<portlet:defineObjects />

<portlet:renderURL var="createBrandURL">
	<portlet:param name="mvcRenderCommandName" value="createBrandRender"/>
</portlet:renderURL>

<portlet:renderURL var="updateBrandURL">
    <portlet:param name="mvcRenderCommandName" value="updateBrandRender" />
     <portlet:param name="brandId" value="${brand.brandId}" />
</portlet:renderURL>

<portlet:renderURL var="viewUrl">
    <portlet:param name="search" value="${search}" /> 
</portlet:renderURL>

<portlet:actionURL var="searchBrandURL" name="searchBrand" />
<liferay-ui:success key="success-key" message="Brand Created Successfully" />
<liferay-ui:success key="update-key" message="Brand Updated Successfully" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<h1 class="titlePage">Brand View</h1>
		
<div class="">
	<nav
		class="management-bar navbar navbar-expand-md management-bar-light">
		<div class="container-fluid container-fluid-max-xl">
			<ul class="navbar-nav">
				<li class="nav-item">
					<div class="dropdown">
					  <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
						<c:choose>
					        <c:when test="${not empty activeStatus and activeStatus eq 'false'}">Active</c:when>
					        <c:when test="${not empty activeStatus and activeStatus eq 'true'}">Inactive</c:when>
					        <c:when test="${not empty status}">${status}</c:when>
					        <c:otherwise>All</c:otherwise>
				    	</c:choose>
					  </button>
					  <div class="dropdown-menu">
					  	<a class="dropdown-item" href="${viewUrl}" style="text-decoration: none;">All</a>
					  	<h5 class="status-heading">Workflow Status</h5>	
					  		<a class="dropdown-item" href="${viewUrl}&<portlet:namespace/>search=${search}&<portlet:namespace/>status=Pending">Pending</a>
					  		<a class="dropdown-item" href="${viewUrl}&<portlet:namespace/>search=${search}&<portlet:namespace/>status=Approved" style="text-decoration: none;">Approved</a>
					  		<a class="dropdown-item" href="${viewUrl}&<portlet:namespace/>search=${search}&<portlet:namespace/>status=Rejected" style="text-decoration: none;"> Rejected</a>
					  	<h5 class="status-heading">Active Status</h5>
					  		<a class="dropdown-item" href="${viewUrl}&<portlet:namespace/>search=${search}&<portlet:namespace/>activeStatus=false" style="text-decoration: none;">Active</a>
							<a class="dropdown-item" href="${viewUrl}&<portlet:namespace/>search=${search}&<portlet:namespace/>activeStatus=true" style="text-decoration: none;">Inactive</a>
					  </div>
					</div>
				</li>
			</ul>
			<div
				class="navbar-form navbar-form-autofit  navbar-overlay navbar-overlay-sm-down">
				<div class="container-fluid container-fluid-max-xl">
					<div class="input-group">
						<div class="input-group-item">
						<form action="${searchBrandURL}" method="POST">
						<input type="hidden" name="<portlet:namespace/>status" value="${status}"/>
						<input type="hidden" name="<portlet:namespace/>activeStatus" value="${activeStatus}"/>
							<input
								class="form-control form-control input-group-inset input-group-inset-after"
								placeholder="Search" type="text" name="<portlet:namespace/>search" value="${search}" /><span
								class="input-group-inset-item input-group-inset-item-after"><button
									class=" navbar-breakpoint-d-none btn btn-monospaced btn-unstyled">
									type="submit">
									<svg class="lexicon-icon lexicon-icon-times"
										role="presentation" viewBox="0 0 512 512">
											<use
											xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#times" /></svg>
								</button>
								<button aria-label="Search"
									class="btn btn-monospaced btn-unstyled" type="submit">
									<svg class="lexicon-icon lexicon-icon-search"
										role="presentation" viewBox="0 0 512 512">
											<use
											xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#search" /></svg>
								</button></span>
							</form>
						</div>
					</div>
				</div>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item navbar-breakpoint-d-none"><button
						class="nav-link nav-link-monospaced btn btn-monospaced btn-unstyled"
						type="submit">
						<svg class="lexicon-icon lexicon-icon-search" role="presentation"
							viewBox="0 0 512 512">
							<use
								xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#search" /></svg>
					</button></li>
				<li class="nav-item">
				<%-- 	<c:if test="${Administrator}"> --%>
				<c:if test='<%=BrandPermission.contains(permissionChecker, groupId, "CREATE_BRAND")%>'>
						<a class="nav-btn nav-btn-monospaced btn btn-primary"
							id="redirectLink"><svg class="lexicon-icon lexicon-icon-plus"
								role="presentation" viewBox="0 0 512 512">
								<use xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#plus" /></svg>
						</a>
					</c:if>
				</li>
			</ul>
		</div>
	</nav>
</div>

<div id="osrl"></div>
</div>

 <%
	PortletURL renderURL = renderResponse.createRenderURL();
	String search = (String) renderRequest.getAttribute("search");
	String status = (String) renderRequest.getAttribute("status");
	String activeStatus = (String) renderRequest.getAttribute("activeStatus");
	renderURL.setParameter("status",status);
	renderURL.setParameter("search",search);
	renderURL.setParameter("activeStatus",activeStatus);
	renderURL.setParameter("mvcRenderCommandName", "viewUrl");
%> 

<jsp:useBean id="userData" class="com.marketplace.brand.portlet.BrandViewPortlet" scope="request" />
 <c:set var="imagePath" value="<%= request.getContextPath()%>"/>
 
 <%
 
 boolean admin = (boolean)renderRequest.getAttribute("Administrator");
 String isadmin="";
 
 if(admin) {
 	isadmin = createBrandURL.toString();
 }

%>
 
 <c:set var="urlRedirect" value="<%= isadmin %>"/>

 <liferay-ui:search-container 
	emptyResultsMessage='<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio">
	<img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="${imagePath}/images/search_state.gif"/></div></div>
	<div class=""><span class="text-truncate-inline"><span class="text-truncate">
	
	<a href="${urlRedirect}">No brand found.</a> 
	
	
	 </span></span></div>
</div>' total="${brandCount}" delta="10" iteratorURL="<%= renderURL %>">

    <!-- Add the search box -->
    <liferay-ui:search-container-row
        className="com.liferay.portal.kernel.dao.search.EmptySearch"
        keyProperty="searchContainer" modelVar="searchContainer" />

    <liferay-ui:search-container-results results="${brands}" />

    <liferay-ui:search-container-row
        className="com.marketplace.brand.model.Brand"
        keyProperty="brandId"
        modelVar="brand"
        escapedModel="true">

 		<c:if test="${brand.brandImageURL ==  ''}">
			<liferay-ui:search-container-column-text name="Image"><img class="brandImage" src="${imagePath}/images/no-image-available.jpg"/></liferay-ui:search-container-column-text>
		</c:if>
		<c:if test="${brand.brandImageURL !=  ''}">
        	<liferay-ui:search-container-column-text name="Image"><img class="brandImage" src="${brand.brandImageURL}" alt="Image" /></liferay-ui:search-container-column-text>
        </c:if>
        <liferay-ui:search-container-column-text name="Name" property="brandName" orderableProperty="brandName" orderable="true">${brand.brandName}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="type" property="brandType" orderableProperty="brandType" orderable="true">${brand.brandType}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Workflow Status">${brand.brandApprovalStatus}</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Active Status">
        	<c:if test="${brand.brandInactive == true}">Inactive</c:if>
			<c:if test="${brand.brandInactive == false}">Active</c:if>
        </liferay-ui:search-container-column-text>
        
        <c:choose>
			<c:when test="${Administrator}">
				<liferay-ui:search-container-column-text name="Assigned To">
        		${userData.userName(brand.brandReviewer)}
        	</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="${Reviewer}">
				<liferay-ui:search-container-column-text name="Created By">
        		${userData.userName(brand.createdBy)}
        	</liferay-ui:search-container-column-text>
			</c:when>
		</c:choose>
        
        <liferay-ui:search-container-column-text name="Created Date"  orderableProperty="createDate" orderable="true">
        <fmt:formatDate value="${brand.createDate}" pattern="yy-MM-dd, hh:mm" var="formattedDate"/>${formattedDate}
        
        </liferay-ui:search-container-column-text>
        
        <liferay-ui:search-container-column-text name="Modified Date"  orderableProperty="modifiedDate" orderable="true">
        <fmt:formatDate value="${brand.modifiedDate}" pattern="yy-MM-dd, hh:mm" var="formatModifiedDate" />
	        <c:if test="${brand.createDate != brand.modifiedDate}">
	        	${formatModifiedDate}
	        </c:if>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="">
        	 <c:set var = "icon" value = "fa-eye"/>
      	 	<%if (BrandPermission.contains(permissionChecker, groupId, "CREATE_BRAND") && !brand.getBrandApprovalStatus().equals("Pending") ) {
      	 
      	 	%>
					<c:set var = "icon" value = "fa-edit"/>
			<%} else if (BrandPermission.contains(permissionChecker, groupId, "REVIEW_BRAND") && brand.getBrandApprovalStatus().equals("Pending")) {%>
				<c:set var = "icon" value = "fa-edit"/>
			<%}%>	
	            <a href="${updateBrandURL}&<portlet:namespace/>brandId=${brand.brandId}">
	                <i class="fas <c:out value="${icon}"/>" style="--fa-primary-color: #001c40; --fa-secondary-color: #183153;"></i>
	            </a>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <!-- Add the search iterator for pagination -->
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<script>

$(document).ready(function() {
	
	$(".portlet-header").hide();
	var from = ${from};
	var brandcount = ${brandCount};
	var to = ${to};
	var current = ${cur};
	var result = (current * 10 > brandcount) && (current-1 * 10 <= brandcount);
	
	if(from < 10){
		$('.pagination li.page-item:nth-child(2) a').text("");
	}
	
	if(result){
		$(".pagination li.page-item:nth-child(3) a").text("");
	}
	
	if(brandcount <= 10){
		$('.pagination li.page-item:nth-child(2) a').text("");
		$(".pagination li.page-item:nth-child(3) a").text("");
	}
	
    $("#redirectLink").click(function(e) {
        e.preventDefault(); 
    	window.location.href ='<%= createBrandURL.toString() %>';
    });
});

</script>
