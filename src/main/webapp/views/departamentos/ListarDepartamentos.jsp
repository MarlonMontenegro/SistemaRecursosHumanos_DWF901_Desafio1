<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Departamentos - Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Departamentos</h2>
        <div class="d-flex gap-2">
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">
                <i class="bi bi-house-door me-1"></i> Inicio
            </a>
            <a href="${pageContext.request.contextPath}/departamentos?accion=nuevo" class="btn btn-primary">
                <i class="bi bi-plus-circle me-1"></i> Nuevo Departamento
            </a>
        </div>
    </div>


    <table class="table table-hover">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dep" items="${departamentos}">
            <tr>
                <td>${dep.nombreDepartamento}</td>
                <td>${dep.descripcionDepartamento}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/departamentos?accion=editar&id=${dep.idDepartamento}" class="btn btn-warning btn-sm">
                        <i class="bi bi-pencil-square"></i> Editar
                    </a>
                    <a href="${pageContext.request.contextPath}/departamentos?accion=eliminar&id=${dep.idDepartamento}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar este departamento?');">
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
