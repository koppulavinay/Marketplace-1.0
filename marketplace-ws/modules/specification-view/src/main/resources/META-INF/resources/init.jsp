<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL id="getSpecifications" var="getSpecificationsURL" />
<portlet:resourceURL id="specificationFieldTypeVal" var="specificationFieldTypeValURL" />
<portlet:resourceURL id="deleteSpecificationVal" var="deleteSpecificationValURL" />
<portlet:resourceURL id="specificationLabelVal" var="specificationLabelValURL" />
<portlet:resourceURL id="specificationDelete" var="deleteSpecificationURL" />
<portlet:resourceURL id="getAllSpecifications" var="getAllSpecificationsURL" />

<portlet:renderURL var="specificationListingURL">
	<portlet:param name="mvcRenderCommandName"
		value="specificationListingRender" />
</portlet:renderURL>

<script>

	var getSpecificationsURL = '${getSpecificationsURL}';
	var specificationFieldTypeValURL = '${specificationFieldTypeValURL}';
	var deleteSpecificationValURL = '${deleteSpecificationValURL}';
	var specificationLabelValURL = '${specificationLabelValURL}';
	var deleteSpecificationURL = '${deleteSpecificationURL}';
	var getAllSpecificationsURL = '${getAllSpecificationsURL}';

</script>