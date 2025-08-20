<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.DepartamentoBean" %>
<%
  DepartamentoBean dep = (DepartamentoBean) request.getAttribute("departamento");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Departamento</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">

  <div class="d-flex justify-content-between align-items-center mb-4">
    <h2>Editar Departamento</h2>
    <a href="${pageContext.request.contextPath}/departamentos" class="btn btn-secondary">
      <i class="bi bi-arrow-left-circle me-1"></i> Volver
    </a>
  </div>

  <form action="${pageContext.request.contextPath}/departamentos" method="post">
    <input type="hidden" name="accion" value="editar">
    <input type="hidden" name="idDepartamento" value="<%=dep.getIdDepartamento()%>">

    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre del Departamento</label>
      <input type="text" class="form-control" id="nombre" name="nombreDepartamento" value="<%=dep.getNombreDepartamento()%>" required>
    </div>

    <div class="mb-3">
      <label for="descripcion" class="form-label">Descripción</label>
      <textarea class="form-control" id="descripcion" name="descripcionDepartamento" rows="3" required><%=dep.getDescripcionDepartamento()%></textarea>
    </div>

    <button type="submit" class="btn btn-primary">
      <i class="bi bi-pencil-square me-1"></i> Guardar Cambios
    </button>
  </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
