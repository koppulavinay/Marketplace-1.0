<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="com.marketplace.category.model.Category" %>
<%@ page import="com.marketplace.category.service.CategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.taglib.ui.BreadcrumbEntry" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.marketplace.category.listing.portlet.BuycorpCategoryBreadCrumbUtil" %>