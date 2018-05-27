<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<h1>${title}</h1>
<c:forEach var="groupGet" items="${groups}" >
    <div>
        <form:form method="POST" action="" modelAttribute="group">
            <form:input path="id" type="hidden" value="${groupGet.id}"/>
            <form:input path="is_active" type="hidden" value="${groupGet.is_active}"/>
            <div>
                <form:label path="title">Название:</form:label>
                <form:input path="title" value="${groupGet.title}"/>
                <form:errors path="title" cssClass="error"/>
            </div>
            <div>
                <form:label path="description">Описание:</form:label>
                <form:input path="description" value="${groupGet.description}"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <div>
                <form:label path="start_date">Дата начала:</form:label>
                <form:input path="start_date" value="${groupGet.start_date}"/>
                <form:errors path="start_date" cssClass="error"/>
            </div>
            <div>
                <form:label path="finished_date">Дата завершения:</form:label>
                <form:input path="finished_date" value="${groupGet.finished_date}"/>
                <form:errors path="finished_date" cssClass="error"/>
            </div>
            <input type="submit" value="Обновить"/>
        </form:form>
        <form:form method="POST" action="" modelAttribute="group">
            <form:input path="id" type="hidden" value="${-groupGet.id}"/>
            <form:input path="is_active" type="hidden" value="${groupGet.is_active}"/>
            <form:input path="title" type="hidden" value="${groupGet.title}"/>
            <form:input path="description" type="hidden" value="${groupGet.description}"/>
            <form:input path="start_date" type="hidden" value="${groupGet.start_date}"/>
            <form:input path="finished_date" type="hidden" value="${groupGet.finished_date}"/>
            <input type="submit" value="Удалить"/>
        </form:form>
    </div>
</c:forEach>
<h3>Создание новой группы</h3>
<form:form method="POST" action="" modelAttribute="group">
    <form:input path="id" type="hidden" value="0"/>
    <form:input path="is_active" type="hidden" value="true"/>
    <div>
        <form:label path="title">Название:</form:label>
        <form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
    </div>
    <div>
        <form:label path="description">Описание:</form:label>
        <form:input path="description"/>
        <form:errors path="description" cssClass="error"/>
    </div>
    <div>
        <form:label path="start_date">Дата начала:</form:label>
        <form:input path="start_date"/>
        <form:errors path="start_date" cssClass="error"/>
    </div>
    <div>
        <form:label path="finished_date">Дата завершения:</form:label>
        <form:input path="finished_date"/>
        <form:errors path="finished_date" cssClass="error"/>
    </div>
    <input type="submit" value="Добавить"/>
</form:form>
<%@include file="footer.jsp" %>