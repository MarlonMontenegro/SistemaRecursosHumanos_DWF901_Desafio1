<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Nueva Contratación | Sistema de Recursos Humanos</title>

    <!-- Bootstrap 5 (igual línea base que usas) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet" />

    <style>
        :root{
            --primary:#0d6efd; --success:#198754; --warning:#ffc107; --info:#0dcaf0;
            --muted:#f8f9fa; --card:#ffffff;
        }
        body{ background: var(--muted); font-family: Arial, sans-serif; }
        .brand-bar{ box-shadow: 0 2px 10px rgba(0,0,0,.05); }
        .card-form{ border: none; border-radius: .75rem; background:#fff; padding:2rem;
            box-shadow: 0 15px 30px -10px rgba(31,111,235,.15); }
        .btn-action{ border-radius:.5rem; font-weight:600; padding:.9rem 1.25rem;
            box-shadow:0 8px 20px rgba(31,111,235,.2); }
        .btn-success{ background: var(--success); border-color: var(--success); }
    </style>
</head>

<!-- Header/brand bar consistente con tus vistas -->
<header class="bg-white brand-bar">
    <div class="container py-3 d-flex align-items-center justify-content-between">
        <div class="d-flex align-items-center gap-3">
            <i class="bi bi-microsoft text-primary fs-3"></i>
            <div>
                <div class="fw-bold">Universidad Aguacate</div>
                <small class="text-secondary">Sistema de Recursos Humanos</small>
            </div>
        </div>
        <div class="d-none d-md-flex align-items-center gap-3">
            <a class="link-secondary text-decoration-none" href="#">Inicio</a>
            <a class="link-secondary text-decoration-none" href="#">Empleados</a>
        </div>
    </div>
</header>

<body>
<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="h3 fw-bold">Nueva Contratación</h1>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">
            <i class="bi bi-arrow-left me-2"></i> Volver al Panel
        </a>
    </div>

    <div class="card card-form">
        <!-- Igual que tu ejemplo: POST a un Servlet -->
        <form action="${pageContext.request.contextPath}/ContratacionesServlet" method="post">
            <div class="row g-3">
                <div class="col-md-4">
                    <label class="form-label fw-semibold">ID de Contratación</label>
                    <input type="text" name="idContratacion" class="form-control" placeholder="CTR-0001" required>
                </div>

                <div class="col-md-8">
                    <label class="form-label fw-semibold">Empleado</label>
                    <input type="text" name="empleado" class="form-control" placeholder="ID o nombre del empleado" required>
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-semibold">Departamento</label>
                    <input type="text" name="Departamento" class="form-control" placeholder="Finanzas, TI, RRHH" required>
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-semibold">Cargo</label>
                    <input type="text" name="cargo" class="form-control" placeholder="Analista, Desarrollador, etc." required>
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-semibold">Tipo de Contratación</label>
                    <select name="tipoContratacion" class="form-select" required>
                        <option value="" selected disabled>Selecciona el tipo</option>
                        <option value="Tiempo Completo">Tiempo Completo</option>
                        <option value="Medio Tiempo">Medio Tiempo</option>
                        <option value="Temporal">Temporal</option>
                        <option value="Por Horas">Por Horas</option>
                        <option value="Prácticas">Prácticas</option>
                    </select>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Fecha de Contratación</label>
                    <input type="date" name="fechaContratacion" class="form-control" required>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Salario</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-currency-dollar"></i></span>
                        <input type="number" name="salario" class="form-control" min="0" step="0.01" placeholder="0.00" required>
                    </div>
                    <small class="text-secondary">Monto bruto mensual.</small>
                </div>
            </div>

            <div class="d-flex justify-content-end mt-4 gap-2">
                <button type="reset" class="btn btn-outline-secondary btn-action">
                    <i class="bi bi-x-circle me-2"></i> Cancelar
                </button>
                <button type="submit" class="btn btn-success btn-action">
                    <i class="bi bi-check-circle me-2"></i> Guardar Contratación
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
