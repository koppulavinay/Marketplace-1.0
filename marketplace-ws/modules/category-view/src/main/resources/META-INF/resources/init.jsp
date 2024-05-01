<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page import="com.marketplace.category.model.Category" %>
<%@ page import="com.marketplace.category.service.CategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.taglib.ui.BreadcrumbEntry" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.marketplace.category.util.BreadCrumbUtil" %>
<%@ page import="com.marketplace.category.portlet.CategoryViewPortlet" %>
<%@ page import="java.util.List" %>


<%@ page import="com.marketplace.category.web.internal.security.permission.resource.CategoryModelPermission" %>
<%@ page import="com.marketplace.category.web.internal.security.permission.resource.CategoryPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>


<%@
page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<%@ page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />





