<%@page
	import="com.marketplace.product.view.constants.ProductViewPortletKeys"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>

<!-- jQuery -->
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->

<!-- Select2 CSS -->
<link
	href="<%= request.getContextPath() %>/cdn/css/select2.min.css"
	rel="stylesheet" />

<!-- Select2 JS -->
<script
	src="<%= request.getContextPath() %>/cdn/js/select2.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL id="categoryMap" var="categoryMapURL" />
<portlet:resourceURL id="deleteVariant" var="deleteVariantURL" />
<portlet:resourceURL id="deleteVariantValue" var="deleteVariantValueURL" />
<portlet:resourceURL id="deleteProductResourceCommand" var="deleteProductResourceCommandURL" />

<portlet:actionURL var="basicInfoActionURL"
	name="<%=ProductViewPortletKeys.BASIC_INFORMATION_ACTION_CMD%>" />
<portlet:actionURL var="selectSpecificationActionURL"
	name="<%=ProductViewPortletKeys.SELECT_SPECIFICATION_ACTION_CMD%>" />
<portlet:actionURL var="additionalInformationActionURL"
	name="<%=ProductViewPortletKeys.ADDITIONAL_INFORMATION_ACTION_CMD%>" />

<liferay-portlet:resourceURL var="getSpecValuesBySpecIdURL"
	id="<%=ProductViewPortletKeys.GET_SPEC_VALUES_BY_SPEC_ID_RESOURCE_CMD%>" />

<liferay-portlet:resourceURL var="saveSKUDetailsURL"
	id="<%=ProductViewPortletKeys.SAVE_SKU_DETAILS_RESOURCE_CMD%>"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="skuMediaResourceURL"
	id="<%=ProductViewPortletKeys.SKU_MEDIA_RESOURCE_CMD%>" />
<liferay-portlet:resourceURL var="saveVariantValueURL"
	id="<%=ProductViewPortletKeys.SAVE_VARIANT_VALUE_RESOURCE_CMD%>" />
<liferay-portlet:resourceURL var="skuMediaRemoveResourceURL" 
	id="<%= ProductViewPortletKeys.SKU_MEDIA_REMOVE_RESOURCE_CMD %>" />
<liferay-portlet:resourceURL var="skuDeleteResourceURL" 
	id="<%= ProductViewPortletKeys.SKU_DELETE_RESOURCE_CMD %>" />

<script>

	var portlet_namespace = '<portlet:namespace/>';
	var categoryMapURL = '${categoryMapURL}';
	var saveSKUDetailsURL = '${saveSKUDetailsURL}';
	var skuMediaURL = '${skuMediaResourceURL}';
	var getSpecValuesBySpecIdURL = '${getSpecValuesBySpecIdURL}';
	var deleteVariantURL = '${deleteVariantURL}';
	var deleteVariantValueURL = '${deleteVariantValueURL}';
	var saveVariantValueURL = '${saveVariantValueURL}';
	var skuMediaRemoveURL = '${skuMediaRemoveResourceURL}';
	var skuDeleteURL = '${skuDeleteResourceURL}';
	
</script>
