<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Control - Recursos Humanos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: #f5f7fa;
            font-family: Arial, sans-serif;
        }
        .card-metric, .card-action {
            border: none;
            border-radius: .75rem;
            box-shadow: 0 15px 30px -10px rgba(31,111,235,0.15);
            background: #fff;
        }
        .btn-action {
            border-radius: .5rem;
            font-weight: 600;
            padding: .9rem 1.25rem;
            box-shadow: 0 8px 20px rgba(31,111,235,.2);
        }
        .metric-value {
            font-size: 1.75rem;
            font-weight: bold;
        }
        .metric-label {
            font-size: .85rem;
            text-transform: uppercase;
            font-weight: 600;
            color: #555;
        }
        .delta {
            font-size: .75rem;
            color: #198754;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 4px;
        }
    </style>
</head>
<body>
<div class="d-flex justify-content-center py-5">
    <div class="container" style="max-width: 900px;">

        <!-- Header -->
        <div class="text-center mb-4">
            <h1 class="h3 fw-bold mb-1">Universidad Don Bosco</h1>
            <div class="small text-secondary">Resumen general del sistema de HR</div>
        </div>

        <!-- Métricas -->
        <div class="row g-3 mb-4 justify-content-center">
            <div class="col-12 col-md-6">
                <div class="card card-metric p-3 text-center">
                    <div class="metric-label">Total Empleados</div>
                    <div class="metric-value text-dark">${totalEmpleados}</div>
                </div>
            </div>

            <div class="col-12 col-md-6">
                <div class="card card-metric p-3 text-center">
                    <div class="metric-label">Departamentos</div>
                    <div class="metric-value text-dark">${totalDepartamentos}</div>
                </div>
            </div>
        </div>

        <!-- Acciones Rápidas -->
        <div class="card card-action p-4 mb-4">
            <h5 class="mb-3 text-center">Acciones Rapidas</h5>
            <div class="d-flex flex-column gap-3">
                <a href="${pageContext.request.contextPath}/empleados"
                   class="btn btn-secondary btn-action w-100 d-flex align-items-center justify-content-center">
                    <i class="bi bi-eye-fill me-2"></i> Ver Empleados
                </a>
                <a href="${pageContext.request.contextPath}/departamentos"
                   class="btn btn-success btn-action w-100 d-flex align-items-center justify-content-center">
                    <i class="bi bi-building me-2"></i> Departamentos
                </a>
                <a href="${pageContext.request.contextPath}/contrataciones"
                   class="btn btn-warning btn-action w-100 d-flex align-items-center justify-content-center">
                    <i class="bi bi-briefcase-fill me-2"></i> Contrataciones
                </a>

                <a href="${pageContext.request.contextPath}/cargos"
                   class="btn btn-info btn-action w-100 d-flex align-items-center justify-content-center">
                    <i class="bi bi-card-checklist me-2"></i> Cargos
                </a>

            </div>
        </div>

        <!-- Footer -->
        <div class="text-center text-secondary small mt-5">
            UDB Virtual • Sistema de HR &middot; Diseño T1Falso.
        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
