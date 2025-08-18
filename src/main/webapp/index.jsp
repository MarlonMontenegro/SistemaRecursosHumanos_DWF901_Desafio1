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
        .card-metric, .card-recent {
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
            gap: 4px;
        }
        .avatar-circle {
            width: 38px;
            height: 38px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: bold;
            color: white;
            font-size: .85rem;
        }
        .small-muted {
            font-size: .75rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="d-flex flex-column flex-md-row justify-content-between align-items-start mb-4">
        <div>
            <h1 class="h3 fw-bold mb-1">INDEX</h1>
            <div class="small text-secondary">Resumen general del sistema de HR</div>
        </div>
        <div class="mt-3 mt-md-0 d-flex gap-3 align-items-center">
            <div class="text-end">
                <div class="small text-muted">Usuario:</div>
                <div class="fw-semibold">CHOCOLATE</div>
            </div>
            <div class="rounded-circle bg-primary text-white d-flex align-items-center justify-content-center" style="width:40px; height:40px;">
                <i class="bi bi-person-fill"></i>
            </div>
        </div>
    </div>

    <div class="row g-3 mb-4">
        <div class="col-12 col-md-6 col-lg-3">
            <div class="card card-metric p-3">
                <div class="d-flex justify-content-between align-items-center mb-2">
                    <div class="metric-label">Total Empleados</div>
                    <div class="text-primary fs-4"><i class="bi bi-people-fill"></i></div>
                </div>
                <div class="d-flex align-items-baseline justify-content-between">
                    <div class="metric-value text-dark">300</div>
                    <div class="delta">
                        <i class="bi bi-arrow-up-right"></i>
                        <span>+12 desde el mes pasado</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row g-4">
        <div class="col-12 col-lg-6">
            <div class="card p-4 card-metric">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <div>
                        <h5 class="mb-1">Acciones Rapidas</h5>
                        <div class="small text-muted">Gestiona los recursos humanos de manera eficiente</div>
                    </div>
                    <i class="bi bi-speedometer2 fs-2 text-primary"></i>
                </div>
                <div class="d-flex flex-column gap-3">
                    <a href="#" class="btn btn-primary btn-action w-100 d-flex align-items-center justify-content-center">
                        <i class="bi bi-person-plus-fill me-2"></i> Empleados
                    </a>
                    <a href="#" class="btn btn-secondary btn-action w-100 d-flex align-items-center justify-content-center">
                        <i class="bi bi-eye-fill me-2"></i> Ver Empleados
                    </a>
                    <button class="btn btn-success btn-action w-100 d-flex align-items-center justify-content-center">
                        <i class="bi bi-building me-2"></i> Departamentos
                    </button>
                    <button class="btn btn-info btn-action w-100 d-flex align-items-center justify-content-center text-white">
                        <i class="bi bi-file-earmark-text me-2"></i> Generar Reporte
                    </button>
                </div>
            </div>
        </div>
        <div class="col-12 col-lg-6">
            <div class="card p-3 card-recent">
                <div class="d-flex justify-content-between align-items-center mb-2">
                    <div>
                        <h5 class="mb-1">Empleados Recientes</h5>
                        <div class="small text-muted">Últimos empleados registrados</div>
                    </div>
                    <i class="bi bi-clock-history fs-2 text-secondary"></i>
                </div>
                <ul class="list-group">
                    <li class="list-group-item d-flex align-items-center gap-3 border-0">
                        <div class="avatar-circle bg-primary">MA</div>
                        <div class="flex-grow-1">
                            <div class="fw-semibold">Eduardo Montenegro</div>
                            <div class="small text-muted">Profesor - Ingenieria</div>
                        </div>
                        <div class="small-muted">Hace 2 días</div>
                    </li>
                    <li class="list-group-item d-flex align-items-center gap-3 border-0">
                        <div class="avatar-circle bg-success">JC</div>
                        <div class="flex-grow-1">
                            <div class="fw-semibold">Jhon Constantine</div>
                            <div class="small text-muted">Jefe de seguridad</div>
                        </div>
                        <div class="small-muted">Hace 5 días</div>
                    </li>
                    <li class="list-group-item d-flex align-items-center gap-3 border-0">
                        <div class="avatar-circle bg-warning">AL</div>
                        <div class="flex-grow-1">
                            <div class="fw-semibold">Alejandra Lopez</div>
                            <div class="small text-muted">Coordinadora - Finanzas</div>
                        </div>
                        <div class="small-muted">Hace 1 semana</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="mt-5 text-center text-secondary small">
        UDB Virtual • Sistema de HR &middot; Diseño T1Falso.
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
