<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<h1>${title}</h1>
<c:forEach var="groupGet" items="${groups}" >
    <div>
        <h4>${groupGet.title}</h4>
        <p>${groupGet.description}</p>
        <p>${groupGet.start_date} - ${groupGet.finished_date}</p>
        <a href="/group/${groupGet.id}">Изменить</a>
        <br><br>
    </div>
</c:forEach>
<a href="/group">Создать новую группу</a>
<%@include file="footer.jsp" %>
