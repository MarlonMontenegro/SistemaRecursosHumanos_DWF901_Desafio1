<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Contrataciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>
            <h2 class="mb-0">Contrataciones</h2>
            <small class="text-muted">Activas arriba · Inactivas abajo</small>
        </div>
        <div class="d-flex gap-2">
            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">
                <i class="bi bi-house-door-fill me-1"></i> Inicio
            </a>
            <a href="${pageContext.request.contextPath}/contrataciones?accion=nuevo" class="btn btn-primary">
                <i class="bi bi-plus-circle me-1"></i> Nueva contratación
            </a>
        </div>
    </div>

    <!-- =================== ACTIVAS =================== -->
    <h4 class="mb-3 text-success">Activas</h4>
    <table class="table table-hover align-middle">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Empleado</th>
            <th>Departamento</th>
            <th>Cargo</th>
            <th>Tipo</th>
            <th>Fecha</th>
            <th>Salario</th>
            <th>Estado</th>
            <th style="width: 220px;">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${contratacionesActivas}">
            <tr>
                <td>${c.idContratacion}</td>
                <td>${c.empleado.nombrePersona}</td>
                <td>${c.departamento.nombreDepartamento}</td>
                <td>${c.cargo.cargo}</td>
                <td>${c.tipoContratacion.tipoContratacion}</td>
                <td>${c.fechaContratacion}</td>
                <td>${c.salario}</td>
                <td><span class="badge bg-success">Activo</span></td>
                <td class="d-flex gap-2">
                    <a href="${pageContext.request.contextPath}/contrataciones?accion=editar&id=${c.idContratacion}"
                       class="btn btn-sm btn-warning">
                        <i class="bi bi-pencil-square"></i> Editar
                    </a>
                    <!-- Toggle: pasa a inactivo -->
                    <a href="${pageContext.request.contextPath}/contrataciones?accion=cambiarEstado&id=${c.idContratacion}&estado=false"
                       class="btn btn-sm btn-danger">
                        <i class="bi bi-x-circle"></i> Desactivar
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- =================== INACTIVAS =================== -->
    <h4 class="mt-5 mb-3 text-danger">Inactivas</h4>
    <table class="table table-hover align-middle">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Empleado</th>
            <th>Departamento</th>
            <th>Cargo</th>
            <th>Tipo</th>
            <th>Fecha</th>
            <th>Salario</th>
            <th>Estado</th>
            <th style="width: 220px;">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${contratacionesInactivas}">
            <tr>
                <td>${c.idContratacion}</td>
                <td>${c.empleado.nombrePersona}</td>
                <td>${c.departamento.nombreDepartamento}</td>
                <td>${c.cargo.cargo}</td>
                <td>${c.tipoContratacion.tipoContratacion}</td>
                <td>${c.fechaContratacion}</td>
                <td>${c.salario}</td>
                <td><span class="badge bg-danger">Inactivo</span></td>
                <td class="d-flex gap-2">
                    <a href="${pageContext.request.contextPath}/contrataciones?accion=editar&id=${c.idContratacion}"
                       class="btn btn-sm btn-warning">
                        <i class="bi bi-pencil-square"></i> Editar
                    </a>
                    <!-- Toggle: pasa a activo -->
                    <a href="${pageContext.request.contextPath}/contrataciones?accion=cambiarEstado&id=${c.idContratacion}&estado=true"
                       class="btn btn-sm btn-success">
                        <i class="bi bi-check-circle"></i> Activar
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
