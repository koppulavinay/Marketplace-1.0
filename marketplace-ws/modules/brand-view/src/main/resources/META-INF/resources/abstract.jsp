<%@page import="com.marketplace.brand.model.Brand"%>
<%@include file="init.jsp" %>

<%
	Brand entry = (Brand) request.getAttribute("BRAND");
%>

<dl>
    <dt>Brand ----- </dt>
   
    <dt>Name</dt>
    <dd><%= entry.getBrandName() %>
    </dd>
    <dt>Type</dt>
    <dd><%= entry.getBrandType() %>
    </dd>
</dl>