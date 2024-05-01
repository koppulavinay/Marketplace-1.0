<%@ include file="/init.jsp"%>

<span class="lastModified">Last Modified: 
	<c:choose>
		<c:when test="${not empty modifiedDate}">
			${modifiedDate}
		</c:when>
		<c:otherwise>
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate value="${now}" pattern="MMM dd, yyyy, HH:mm" var="formattedDate" />
				${formattedDate}
		</c:otherwise>
	</c:choose>
</span>