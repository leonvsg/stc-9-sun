<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<security:authorize access= "hasAnyRole('ADMIN','USER', 'TEACHER')" var= "isUSer"/>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<div class="wrapper">
    <header class="header">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <c:if test= "${isUSer}">
                    <a class="navbar-brand" href="/">Academy</a>
                    <p class="navbar-text navbar-right">Вошли как <security:authentication property= "principal.username"/> под ролью <security:authentication property= "principal.authorities"/></p>
                    <a class="btn btn-default navbar-btn btn-logout btn-head" href="#">My page</a>
                    <a class="btn btn-default navbar-btn btn-my-page btn-head" href="#">Logout</a>
                    </c:if>
                    <c:if test= "${not isUSer}">
                        <a class="navbar-brand" href="/">Academy</a>
                        <p class="navbar-text navbar-right">Вы не вошли <a href= "<c:url value= "/login.jsp"/>">Войти</a></p>
                        <a class="btn btn-default navbar-btn btn-logout btn-head" href="#">My page</a>
                        <a class="btn btn-default navbar-btn btn-my-page btn-head" href="#">Logout</a>
                    </c:if>


                </div>
            </div>
        </nav>
    </header>
    <div class="middle">
        <%@ include file="menu.jsp"%>
        <div class="container">
            <main class="content">