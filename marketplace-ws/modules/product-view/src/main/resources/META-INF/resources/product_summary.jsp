<%@ include file="/init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=ProductViewPortletKeys.ADDITIONAL_INFORMATION_RENDER_CMD %>" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<h2>Product Summary</h2>
<div class="container">
	<marquee><h2>This page is currently under maintenance.</h2></marquee>
	<a href="${backURL}" class="btn btn-primary">Back</a>
</div>