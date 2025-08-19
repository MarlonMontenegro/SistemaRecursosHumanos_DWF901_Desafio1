<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Departamento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: #f5f7fa;
            font-family: Arial, sans-serif;
        }
        .card-form {
            border: none;
            border-radius: .75rem;
            box-shadow: 0 15px 30px -10px rgba(31,111,235,0.15);
            background: #fff;
            padding: 2rem;
        }
        .btn-action {
            border-radius: .5rem;
            font-weight: 600;
            padding: .9rem 1.25rem;
            box-shadow: 0 8px 20px rgba(31,111,235,.2);
        }
        :root{
            --primary:#0d6efd;
            --success:#198754;
            --warning:#ffc107;
            --info:#0dcaf0;
            --muted:#f8f9fa;
            --card:#ffffff;
        }
        body{ background: var(--muted); }

        .brand-bar{ box-shadow: 0 2px 10px rgba(0,0,0,.05); }

        .page-title{
            font-weight: 800;
            letter-spacing: .2px;
        }

        .stat-chip{
            background: #f1f6ff;
            color: var(--primary);
            font-weight: 600;
            border-radius: 999px;
            padding: .35rem .75rem;
            font-size: .85rem;
        }
        .card-soft{
            background: var(--card);
            border: 1px solid #eef2f7;
            border-radius: 1rem;
            box-shadow: 0 10px 20px rgba(13,110,253,.05);
            transition: transform .15s ease, box-shadow .15s ease;
        }
        .card-soft:hover{ transform: translateY(-2px); box-shadow: 0 14px 26px rgba(13,110,253,.09); }

        .btn-primary{ background: var(--primary); border-color: var(--primary); }
        .btn-success{ background: var(--success); border-color: var(--success); }

        .dept-icon{
            width: 46px; height: 46px;
            display:flex; align-items:center; justify-content:center;
            border-radius: 12px;
        }
        .dept-icon.primary { background:#e9f1ff; color: var(--primary); }
        .dept-icon.success { background:#eaf7f1; color: var(--success); }
        .dept-icon.warning { background:#fff6df; color:#d39e00; }
        .dept-icon.info    { background:#e8fbff; color:#0aa2c0; }

        .search-wrap{
            background: #fff;
            border:1px solid #eef2f7; border-radius: .75rem;
            padding:.5rem .75rem;
        }
    </style>
</head>
<header class="bg-white brand-bar">
    <div class="container py-3 d-flex align-items-center justify-content-between">
        <div class="d-flex align-items-center gap-3">
            <i class="bi bi-microsoft text-primary fs-3"></i>
            <div class="">
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
        <h1 class="h3 fw-bold">Nuevo Departamento</h1>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">
            <i class="bi bi-arrow-left me-2"></i> Volver al Panel
        </a>
    </div>

    <div class="card card-form">
        <form action="${pageContext.request.contextPath}/DepartamentosServlet" method="post">

            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label fw-semibold">ID del Departamento</label>
                    <input type="text" name="idDepartamento" class="form-control" required>
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-semibold">Nombre del Departamento</label>
                    <input type="text" name="nombreDepartamento" class="form-control" required>
                </div>

                <div class="col-12">
                    <label class="form-label fw-semibold">Descripción del Departamento</label>
                    <textarea name="descripcionDepartamento" class="form-control" rows="3" required></textarea>
                </div>
            </div>

            <div class="d-flex justify-content-end mt-4 gap-2">
                <button type="reset" class="btn btn-outline-secondary btn-action">
                    <i class="bi bi-x-circle me-2"></i> Cancelar
                </button>
                <button type="submit" class="btn btn-success btn-action">
                    <i class="bi bi-check-circle me-2"></i> Guardar Departamento
                </button>
            </div>

        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
