<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><c:out value="${empty item ? 'Nuevo empleado' : 'Editar empleado'}"/></title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark bg-dark mb-3">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">RRHH</a>
        <a class="nav-link text-white" href="${pageContext.request.contextPath}/empleados?action=list">Empleados</a>
    </div>
</nav>

<c:set var="edit" value="${not empty item}" />

<c:if test="${not empty msg}">
<div class="container">
    <div class="alert alert-${empty msgType ? 'info' : msgType}">${msg}</div>
</div>
</c:if>

<div class="container">
    <h3 class="mb-3">
<c:out value="${edit}"></c:out>