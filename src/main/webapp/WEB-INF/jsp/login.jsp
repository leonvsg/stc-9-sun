<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<c:if test="${not empty param.login_error}">
  <span style="color: red; ">
    Вы не прошли авторизацию.<br/><br/>
    Причина: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
  </span>
</c:if>
<form:form method="POST" action="" modelAttribute="user">
    <div>
        <form:label path="email">E-mail *</form:label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <form:label path="password">Пароль *</form:label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <input type="submit" value="Отправить"/>
    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
</form:form>
<%@include file="footer.jsp" %>
