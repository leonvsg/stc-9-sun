<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<form:form method="POST" action="" modelAttribute="user">
    <div>
        <form:label path="lastName">Фамилия</form:label>
        <form:input path="lastName"/>
    </div>
    <div>
        <form:label path="firstName">Имя</form:label>
        <form:input path="firstName"/>
    </div>
    <div>
        <form:label path="patronymic">Отчество</form:label>
        <form:input path="patronymic"/>
    </div>
    <input type="submit" value="Отправить"/>
</form:form>
<%@include file="footer.jsp" %>
