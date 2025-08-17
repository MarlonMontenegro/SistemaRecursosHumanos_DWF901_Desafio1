<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Empleados</title>
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

<c:if test="${not empty param.msg}">
    <div class="container">
        <div class="alert alert-${empty param.msgType ? 'info' : param.msgType}">${param.msg}</div>
    </div>
</c:if>

<div class="container">
    <div class="d-flex justify-content-between align-items-center mb-2">
        <h3 class="m-0">Empleados</h3>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/empleados?action=create">+ Nuevo</a>
    </div>

    <c:choose>
        <c:when test="${empty lista}">
            <div class="alert alert-warning">No hay empleados registrados.</div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table class="table table-striped table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>DUI</th>
                        <th>Nombre</th>
                        <th>Usuario</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>Nacimiento</th>
                        <th style="width:160px;">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="e" items="${lista}">
                        <tr>
                            <td>${e.idEmpleado}</td>
                            <td>${e.numeroDui}</td>
                            <td>${e.nombrePersona}</td>
                            <td>${e.usuario}</td>
                            <td>${e.numeroTelefono}</td>
                            <td>${e.correoInstitucional}</td>
                            <td>${e.fechaNacimiento}</td>
                            <td class="d-flex gap-2">
                                <a class="btn btn-sm btn-outline-primary"
                                   href="${pageContext.request.contextPath}/empleados?action=edit&id=${e.idEmpleado}">
                                    Editar
                                </a>
                                <a class="btn btn-sm btn-outline-danger"
                                   href="${pageContext.request.contextPath}/empleados?action=delete&id=${e.idEmpleado}"
                                   onclick="return confirm('¿Eliminar empleado?');">
                                    Eliminar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
