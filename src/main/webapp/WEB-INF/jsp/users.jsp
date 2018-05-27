<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<div class="panel panel-default">
    <!-- Содержание панели по умолчанию -->
    <div class="panel-heading">Пользователи</div>
    <!-- Таблица -->
    <table class="table">
        <tr>
            <td>Id</td>
            <td>ФИО</td>
            <td>E-Mail</td>
            <td>Активен</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>
                    <a href="/users/${user.id}/">
                    ${user.fullName}
                    </a>
                </td>
                <td>${user.email}</td>
                <td>${user.active}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="footer.jsp"%>