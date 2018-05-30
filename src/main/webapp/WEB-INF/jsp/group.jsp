<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="panel panel-default">
    <!-- Содержание панели по умолчанию -->
    <div class="panel-heading">${group.title}</div>
    <!-- Таблица -->
    <table class="table">
        <form:form method="post" action="" modelAttribute="group" cssClass="form-inline">
            <form:input path="id" hidden="true"/>
            <c:if test="${group.id != 0}">
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                        <a role="button" href="/group/del/${group.id}">
                            Удалить
                        </a>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>Название</td>
                <td>${group.title}</td>
                <td>
                    <c:if test="${group.id != 0}">
                        <a role="button" data-toggle="collapse" href="#changeTitle" aria-expanded="false" aria-controls="changeTitle">
                            Изменить
                        </a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="custom-td">
                    <div <c:if test="${group.id != 0}"> class="collapse" id="changeTitle" </c:if>>
                        <div class="well">
                            <div class="form-group">
                                <form:input path="title" placeholder="Введите название" cssClass="form-control"/>
                                <form:errors path="title" cssClass="alert alert-danger custom-alert" role="alert"/>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Описание</td>
                <td>${group.description}</td>
                <td>
                    <c:if test="${group.id != 0}">
                        <a role="button" data-toggle="collapse" href="#changeDescription" aria-expanded="false" aria-controls="changeDescription">
                            Изменить
                        </a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="custom-td">
                    <div <c:if test="${group.id != 0}"> class="collapse" id="changeDescription" </c:if>>
                        <div class="well">
                            <div class="form-group">
                                <form:input path="description" placeholder="Введите описание" cssClass="form-control"/>
                                <form:errors path="description" cssClass="alert alert-danger custom-alert" role="alert"/>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Дата начала</td>
                <td>${group.start_date}</td>
                <td>
                    <c:if test="${group.id != 0}">
                        <a role="button" data-toggle="collapse" href="#changeStart" aria-expanded="false" aria-controls="changeStart">
                            Изменить
                        </a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="custom-td">
                    <div <c:if test="${group.id != 0}"> class="collapse" id="changeStart" </c:if>>
                        <div class="well">
                            <div class="form-group">
                                <form:input path="start_date" placeholder="Введите дату начала" cssClass="form-control"/>
                                <form:errors path="start_date" cssClass="alert alert-danger custom-alert" role="alert"/>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Дата завершения</td>
                <td>${group.finished_date}</td>
                <td>
                    <c:if test="${group.id != 0}">
                        <a role="button" data-toggle="collapse" href="#changeFinish" aria-expanded="false" aria-controls="changeFinish">
                            Изменить
                        </a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="custom-td">
                    <div <c:if test="${group.id != 0}"> class="collapse" id="changeFinish" </c:if>>
                        <div class="well">
                            <div class="form-group">
                                <form:input path="finished_date" placeholder="Введите дату завершения" cssClass="form-control"/>
                                <form:errors path="finished_date" cssClass="alert alert-danger custom-alert" role="alert"/>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <button type="submit" class="btn btn-success">Соханить</button>
                </td>
            </tr>
        </form:form>
    </table>
</div>
<%@include file="footer.jsp" %>