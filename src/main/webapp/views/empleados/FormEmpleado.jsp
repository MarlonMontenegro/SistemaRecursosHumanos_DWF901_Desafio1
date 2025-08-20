<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">
    <h2 class="mb-4">
        <c:choose>
            <c:when test="${not empty empleado}">Editar Empleado</c:when>
            <c:otherwise>Nuevo Empleado</c:otherwise>
        </c:choose>
    </h2>

    <form action="${pageContext.request.contextPath}/empleados" method="post">
        <input type="hidden" name="action" value="<c:choose>
            <c:when test='${not empty empleado}'>actualizar</c:when>
            <c:otherwise>insertar</c:otherwise>
        </c:choose>">
        <c:if test="${not empty empleado}">
            <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
        </c:if>

        <div class="mb-3">
            <label class="form-label">DUI</label>
            <input type="text" class="form-control" name="numeroDui" value="${empleado.numeroDui}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombrePersona" value="${empleado.nombrePersona}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Usuario</label>
            <input type="text" class="form-control" name="usuario" value="${empleado.usuario}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Teléfono</label>
            <input type="text" class="form-control" name="numeroTelefono" value="${empleado.numeroTelefono}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Correo Institucional</label>
            <input type="email" class="form-control" name="correoInstitucional" value="${empleado.correoInstitucional}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Fecha de Nacimiento</label>
            <input type="date" class="form-control" name="fechaNacimiento"
                   value="<c:out value='${empleado.fechaNacimiento}'/>" required>
        </div>

        <button type="submit" class="btn btn-success">
            <c:choose>
                <c:when test="${not empty empleado}">Actualizar</c:when>
                <c:otherwise>Crear</c:otherwise>
            </c:choose>
        </button>
        <a href="${pageContext.request.contextPath}/empleados" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
