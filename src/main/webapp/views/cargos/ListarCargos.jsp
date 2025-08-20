<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Cargos - Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Cargos</h2>
        <div>
            <a href="${pageContext.request.contextPath}/cargos?accion=nuevo" class="btn btn-primary me-2">
                <i class="bi bi-plus-circle me-1"></i> Nuevo Cargo
            </a>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">
                <i class="bi bi-house-door me-1"></i> Inicio
            </a>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Jefatura</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${cargos}">
            <tr>
                <td>${c.cargo}</td>
                <td>${c.descripcionCargo}</td>
                <td>
                    <c:choose>
                        <c:when test="${c.jefatura}">Sí</c:when>
                        <c:otherwise>No</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/cargos?accion=editar&id=${c.idCargo}" class="btn btn-warning btn-sm me-1">
                        <i class="bi bi-pencil-square"></i> Editar
                    </a>
                    <a href="${pageContext.request.contextPath}/cargos?accion=eliminar&id=${c.idCargo}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar este cargo?');">
                        <i class="bi bi-trash"></i> Eliminar
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
