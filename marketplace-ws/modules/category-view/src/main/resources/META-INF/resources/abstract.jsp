<%@page import="com.marketplace.category.model.Category"%>
<%@include file="init.jsp" %>

<%
	Category entry = (Category) request.getAttribute("CATEGORY");
%>

<dl>
    <dt>Category</dt>
   
    <dt>Name</dt>
    <dd><%= entry.getCategoryName() %>
    </dd>
    <dt>Type</dt>
    <dd><%= entry.getCategoryType() %>
    </dd>
</dl>