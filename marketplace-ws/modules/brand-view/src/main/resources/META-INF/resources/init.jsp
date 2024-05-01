<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.marketplace.brand.web.internal.security.permission.resource.BrandModelPermission" %>
<%@ page import="com.marketplace.brand.web.internal.security.permission.resource.BrandPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@
page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL id="fileRemoveCommand" var="fileRemoveURL" />

<portlet:resourceURL id="brandNameVal" var="brandNameValURL" />

<portlet:resourceURL id="brandCodeVal" var="brandCodeValURL" />

<portlet:resourceURL id="brandRefernceVal" var="brandRefernceValURL" />
<%
	// Get the group ID
	long groupId = themeDisplay.getScopeGroupId();
%>
<script>

	var dt = new DataTransfer();
	var fileRemoveURL = '${fileRemoveURL}';
	var brandNameValURL = '${brandNameValURL}';
	var brandCodeValURL = '${brandCodeValURL}';
	var brandRefernceValURL = '${brandRefernceValURL}';

</script>