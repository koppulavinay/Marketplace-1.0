<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.marketplace.custom.checkout.constants.CheckoutConsigneeDetailsConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %><%@
taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/commerce-ui" prefix="commerce-ui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.liferay.portal.kernel.util.PwdGenerator"%>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-portlet:resourceURL var="saveConsigneeDetailsURL"
	id="<%=CheckoutConsigneeDetailsConstants.SAVE_CONSIGNEE_DETAILS_MVC_RESOURCE_CMD%>"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="getConsigneeDetailsURL"
	id="<%=CheckoutConsigneeDetailsConstants.GET_CONSIGNEE_DETAILS_MVC_RESOURCE_CMD%>"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="submitConsigneeDetailsURL"
	id="<%=CheckoutConsigneeDetailsConstants.SUBMIT_CONSIGNEE_DETAILS_MVC_RESOURCE_CMD%>"></liferay-portlet:resourceURL>

<script
	src="<%=request.getContextPath()%>/cdn/js/jquery.dataTables.js?ver<%=PwdGenerator.getPassword(2)%>"></script>
	
<script>
	
	var portlet_namespace = '<portlet:namespace/>';
	var saveConsigneeDetailURL = '${saveConsigneeDetailsURL}';
	var getConsigneeDetailsURL = '${getConsigneeDetailsURL}';
	var submitConsigneeDetailsURL = '${submitConsigneeDetailsURL}';
	
</script>