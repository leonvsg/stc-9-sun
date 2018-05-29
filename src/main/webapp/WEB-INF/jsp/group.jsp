<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<h1>${group.title}</h1>
<div>
    <c:if test="${group.id == 0}">
        <h3>Создание новой группы</h3>
    </c:if>
    <form:form method="POST" action="" modelAttribute="group">
        <form:input path="id" type="hidden" value="${group.id}"/>
        <form:input path="is_active" type="hidden" value="${group.is_active}"/>
        <div>
            <form:label path="title">Название:</form:label>
            <form:input path="title" value="${group.title}"/>
            <form:errors path="title" cssClass="error"/>
        </div>
        <div>
            <form:label path="description">Описание:</form:label>
            <form:input path="description" value="${group.description}"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <div>
            <form:label path="start_date">Дата начала:</form:label>
            <form:input path="start_date" value="${group.start_date}"/>
            <form:errors path="start_date" cssClass="error"/>
        </div>
        <div>
            <form:label path="finished_date">Дата завершения:</form:label>
            <form:input path="finished_date" value="${group.finished_date}"/>
            <form:errors path="finished_date" cssClass="error"/>
        </div>
        <c:if test="${group.id == 0}">
            <input type="submit" value="Создать"/>
        </c:if>
        <c:if test="${group.id != 0}">
            <input type="submit" value="Обновить"/>
            <a href="/group/del/${group.id}">Удалить</a>
        </c:if>
    </form:form>
    <a href="/groups">К списку групп</a>
</div>
<%@include file="footer.jsp" %>