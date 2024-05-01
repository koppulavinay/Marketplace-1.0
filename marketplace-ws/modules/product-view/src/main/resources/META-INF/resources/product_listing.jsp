<%@ include file="/init.jsp"%>

<portlet:actionURL var="editProductURL"
	name="<%=ProductViewPortletKeys.EDIT_PRODUCT_STEP_ACTION_CMD%>" />

<c:set var="editURL" value="${editProductURL}&draftProductId=" />

<a href="${editURL}40028">Draft Product Step 1 40028</a>
<a href="${editURL}40030">Draft Product Step 2 40030</a>
<a href="${editURL}40033">Draft Product Step 3 40033</a>
<a href="${editURL}40049">Draft Product Step 6 40049</a>