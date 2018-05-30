<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<c:if test="${not empty param.login_error}">
  <span style="color: red; ">
    Вы не прошли авторизацию.<br/><br/>
    Причина: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
  </span>
</c:if>
<div>
    <form name= "form" action= "security_check" method= "post" class= "">
        <security:authorize access= "hasAnyRole('ADMIN','USER', 'TEACHER')" var= "isUSer"/>
        <c:if test= "${not isUSer}">
            <c:if test= "${empty param.error}">
                Вы не вошши в систему
            </c:if>
            <c:if test= "${not empty param.error}">
                <br>Неправильный логин или пароль
            </c:if>
        </c:if>
        <c:if test= "${isUSer}">
            Вы вошли как: <security:authentication property= "principal.username"/> с ролью: <security:authentication property= "principal.authorities"/>
        </c:if>

        <label for= "inputEmail" class= ""></label>
        <input id= "inputEmail" class= "" name= "username" required autofocus/>

        <label for= "inputPassword" class= ""></label>
        <input type= "password" id= "inputPassword" class= "" name= "password" required/>
        <input type= "submit" value= "Войти">
    </form>
</div>
<%@include file="footer.jsp" %>
