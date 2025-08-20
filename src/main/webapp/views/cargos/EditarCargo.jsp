<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Cargo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">
    <h2>Editar Cargo</h2>
    <form action="${pageContext.request.contextPath}/cargos" method="post">
        <input type="hidden" name="accion" value="editar">
        <input type="hidden" name="idCargo" value="${cargo.idCargo}">

        <div class="mb-3">
            <label for="nombreCargo" class="form-label">Nombre del Cargo</label>
            <input type="text" class="form-control" id="nombreCargo" name="cargo" value="${cargo.cargo}" required>
        </div>

        <div class="mb-3">
            <label for="descripcionCargo" class="form-label">Descripción</label>
            <textarea class="form-control" id="descripcionCargo" name="descripcionCargo" rows="3" required>${cargo.descripcionCargo}</textarea>
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="jefatura" name="jefatura" <c:if test="${cargo.jefatura}">checked</c:if>>
            <label class="form-check-label" for="jefatura">Es Jefatura</label>
        </div>

        <button type="submit" class="btn btn-success">
            <i class="bi bi-check-circle me-1"></i> Guardar Cambios
        </button>
        <a href="${pageContext.request.contextPath}/cargos" class="btn btn-secondary">
            <i class="bi bi-arrow-left-circle me-1"></i> Cancelar
        </a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
