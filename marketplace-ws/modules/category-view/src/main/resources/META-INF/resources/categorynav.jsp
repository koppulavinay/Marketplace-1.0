<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>


<portlet:actionURL var="searchCategory" name="searchCategory" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
	
<script>
	$(document).ready(function() {
		$('#multiple-checkboxes').multiselect({
			includeSelectAllOption : true,
		});
		$(".multiselect-selected-text").text("Filter");
	});

	function mobileMenuOpen() {
		document.getElementById("gmDropdown").classList.toggle("show");
	}
</script>
<%
	// Get the group ID
	long groupId1 = themeDisplay.getScopeGroupId();
%>


<div class="">
	<nav
		class="management-bar navbar navbar-expand-md management-bar-light">
		<div class="container-fluid container-fluid-max-xl">
			<ul class="navbar-nav">
				<li class="nav-item">
					<div class="dropdown">
						<button type="button"
							class="btn btn-outline-secondary dropdown-toggle"
							data-toggle="dropdown">
							<c:choose>
						        <c:when test="${not empty activeStatus and activeStatus eq 'false'}">Active</c:when>
						        <c:when test="${not empty activeStatus and activeStatus eq 'true'}">Inactive</c:when>
						        <c:when test="${not empty status}">${status}</c:when>
						        <c:otherwise>All</c:otherwise>
						    </c:choose>
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}"
								style="text-decoration: none;">All</a>
							<h5 class="status-heading">Workflow Status</h5>
							<c:if test="${Reviewer!=true }">
								<a class="dropdown-item"
									href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=Pending&<portlet:namespace/>search=${search}">
									Pending</a>
								
							</c:if>
							<a class="dropdown-item"
									href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=Draft&<portlet:namespace/>search=${search}">
									Draft</a>	
							<a class="dropdown-item"
									href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=Manager In-review&<portlet:namespace/>search=${search}">
									Manager In-review</a>
							<a class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=Approved&<portlet:namespace/>search=${search}"
								style="text-decoration: none;">Approved</a> <a
								class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=Rejected&<portlet:namespace/>search=${search}"
								style="text-decoration: none;">Rejected</a> <a
								class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>status=In-Review&<portlet:namespace/>search=${search}"
								style="text-decoration: none;">In-Review</a> 
							
							<h5 class="status-heading">Active Status</h5>
								<a class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>activeStatus=false&<portlet:namespace/>search=${search}"
								style="text-decoration: none;">Active</a>
								<a class="dropdown-item"
								href="${viewUrl}&<portlet:namespace/>parentCategoryId=${parentCategoryId}&<portlet:namespace/>activeStatus=true&<portlet:namespace/>search=${search}"
								style="text-decoration: none;">Inactive</a>
								
						</div>
					</div>
				</li>
			</ul>
			<div
				class="navbar-form navbar-form-autofit  navbar-overlay navbar-overlay-sm-down">
				<div class="container-fluid container-fluid-max-xl">
					<div class="input-group">
						<div class="input-group-item">
							<form action="${searchCategory}" method="POST">
								<input type="hidden" name="<portlet:namespace/>parentCategoryId"
									value="${parentCategoryId}" />
									<input type="hidden" name="<portlet:namespace/>status"
									value="${status}" />
									<input type="hidden" name="<portlet:namespace/>activeStatus"
									value="${activeStatus}" />
									<input
									class="form-control form-control input-group-inset input-group-inset-after"
									placeholder="Search" type="text" value="${search}"
									name="<portlet:namespace/>search" /><span
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
				<c:if test='<%=CategoryPermission.contains(permissionChecker, groupId1, "CREATE_CATEGORY")%>'>
					
						<a class="nav-btn nav-btn-monospaced btn btn-primary"
							id="redirectLink"><svg class="lexicon-icon lexicon-icon-plus"
								role="presentation" viewBox="0 0 512 512">
							<use
									xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#plus" /></svg></a>

					</c:if>
				</li>
			</ul>
		</div>
	</nav>
</div>
