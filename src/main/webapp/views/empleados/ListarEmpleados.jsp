<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">

    <div class="d-flex justify-content-between mb-3">
        <h2>Empleados</h2>
        <div>
            <a href="${pageContext.request.contextPath}/empleados?accion=nuevo" class="btn btn-primary">
                <i class="bi bi-person-plus-fill me-1"></i> Nuevo Empleado
            </a>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">
                <i class="bi bi-house-door-fill me-1"></i> Inicio
            </a>
        </div>
    </div>

    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>DUI</th>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Fecha Nacimiento</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="empleado" items="${listaEmpleados}">
            <tr>
                <td>${empleado.idEmpleado}</td>
                <td>${empleado.numeroDui}</td>
                <td>${empleado.nombrePersona}</td>
                <td>${empleado.usuario}</td>
                <td>${empleado.numeroTelefono}</td>
                <td>${empleado.correoInstitucional}</td>
                <td>${empleado.fechaNacimiento}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/empleados?accion=editar&id=${empleado.idEmpleado}"
                       class="btn btn-warning btn-sm">
                        <i class="bi bi-pencil-square"></i> Editar
                    </a>
                    <a href="${pageContext.request.contextPath}/empleados?accion=eliminar&id=${empleado.idEmpleado}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar este empleado?');">
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
