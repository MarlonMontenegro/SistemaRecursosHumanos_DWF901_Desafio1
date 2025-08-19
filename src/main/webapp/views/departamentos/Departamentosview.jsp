<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Departamentos | Sistema de Recursos Humanos</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet" />

    <style>
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
<body>
<!-- Top Brand -->
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
<%--            <button class="btn btn-primary btn-sm"><i class="bi bi-person-plus me-2"></i>Registrar Departamento</button> -->--%>
            <a href="${pageContext.request.contextPath}/views/departamentos/depaEdit.jsp"
               class="btn btn-success btn-action w-100 d-flex align-items-center justify-content-center">
                <i class="bi bi-building me-2"></i> Agregar Departamentos
            </a>
        </div>
    </div>
</header>

<main class="container my-4">
    <!-- Encabezado -->
    <div class="row align-items-center g-3 mb-2">
        <div class="col-12 col-lg-7">
            <h1 class="page-title display-6 mb-0">Departamentos</h1>
            <p class="text-secondary mb-0">Vista general de las areas de la empresa</p>
        </div>
        <div class="col-12 col-lg-5">
            <div class="search-wrap d-flex align-items-center gap-2">
                <i class="bi bi-search text-secondary"></i>
                <input id="search" type="text" class="form-control border-0" placeholder="Buscar departamento (ej. Finanzas)" />
                <select id="filter" class="form-select border-0" style="max-width:220px">
                    <option value="">Todos los estados</option>
                    <option value="activo">Activo</option>
                    <option value="contratacion">En contratacion</option>
                    <option value="suspendido">Suspendido</option>
                </select>
            </div>
        </div>
    </div>

    <!-- Metricas en dashboard -->
    <div class="row g-3 mb-3">
        <div class="col-6 col-md-3">
            <div class="card-soft p-3">
                <div class="d-flex align-items-center">
                    <div class="dept-icon primary me-3"><i class="bi bi-people fs-5"></i></div>
                    <div>
                        <div class="h4 mb-0">247</div>
                        <small class="text-secondary">Total empleados</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-6 col-md-3">
            <div class="card-soft p-3">
                <div class="d-flex align-items-center">
                    <div class="dept-icon success me-3"><i class="bi bi-building fs-5"></i></div>
                    <div>
                        <div class="h4 mb-0">6</div>
                        <small class="text-secondary">Departamentos</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-6 col-md-3">
            <div class="card-soft p-3">
                <div class="d-flex align-items-center">
                    <div class="dept-icon warning me-3"><i class="bi bi-briefcase fs-5"></i></div>
                    <div>
                        <div class="h4 mb-0">42</div>
                        <small class="text-secondary">Puestos</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-6 col-md-3">
            <div class="card-soft p-3">
                <div class="d-flex align-items-center">
                    <div class="dept-icon info me-3"><i class="bi bi-graph-up fs-5"></i></div>
                    <div>
                        <div class="h4 mb-0">8</div>
                        <small class="text-secondary">Nuevos ingresos</small>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="grid" class="row g-3">
        <div class="col-12 col-md-6 col-xl-4 dept" data-status="activo" data-name="Recursos Humanos">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon primary"><i class="bi bi-person-gear"></i></div>
                        <div>
                            <h5 class="mb-1">Recursos Humanos</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 28 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-primary">Activo</span>
                </div>
                <p class="text-secondary mb-4">Gestion del talento, nomina, capacitaciones y clima laboral.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-journal-text me-1"></i>Politicas</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-award me-1"></i>Capacitacion</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-calendar2-week me-1"></i>Turnos</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-person-lines-fill me-2"></i>Ver equipo</button>
                    <button class="btn btn-outline-secondary">Generar reporte</button>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-6 col-xl-4 dept" data-status="contratacion" data-name="Ingenieria">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon success"><i class="bi bi-cpu"></i></div>
                        <div>
                            <h5 class="mb-1">Ingenieria</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 62 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-success">En contratacion</span>
                </div>
                <p class="text-secondary mb-4">Desarrollo de software, infraestructura, QA y soporte tecnico.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-code-slash me-1"></i>Backend</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-window-sidebar me-1"></i>Frontend</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-diagram-3 me-1"></i>Infra</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-kanban me-2"></i>Proyectos</button>
                    <button class="btn btn-outline-secondary">Ver vacantes</button>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-6 col-xl-4 dept" data-status="activo" data-name="Finanzas">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon warning"><i class="bi bi-cash-coin"></i></div>
                        <div>
                            <h5 class="mb-1">Finanzas</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 19 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-primary">Activo</span>
                </div>
                <p class="text-secondary mb-4">Presupuestos, cuentas por pagar y analisis financiero.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-graph-up-arrow me-1"></i>Forecast</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-wallet2 me-1"></i>Contabilidad</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-receipt me-1"></i>Compliance</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-bar-chart-line me-2"></i>Dashboards</button>
                    <button class="btn btn-outline-secondary">Documentos</button>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-6 col-xl-4 dept" data-status="activo" data-name="Administracion">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon info"><i class="bi bi-building-gear"></i></div>
                        <div>
                            <h5 class="mb-1">Administracion</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 31 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-primary">Activo</span>
                </div>
                <p class="text-secondary mb-4">Compras, logistica y soporte a operaciones internas.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-truck me-1"></i>Logistica</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-bag-check me-1"></i>Compras</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-clipboard2-check me-1"></i>Procesos</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-columns-gap me-2"></i>Flujos</button>
                    <button class="btn btn-outline-secondary">KPIs</button>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-6 col-xl-4 dept" data-status="suspendido" data-name="Biblioteca">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon primary"><i class="bi bi-book"></i></div>
                        <div>
                            <h5 class="mb-1">Biblioteca</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 7 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-secondary">Suspendido</span>
                </div>
                <p class="text-secondary mb-4">Gestion de prestamos, catalogos y espacios de estudio.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-collection me-1"></i>Catalogo</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-upc-scan me-1"></i>Prestamos</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-geo-alt me-1"></i>Salas</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-list-stars me-2"></i>Servicios</button>
                    <button class="btn btn-outline-secondary">Calendario</button>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-6 col-xl-4 dept" data-status="contratacion" data-name="Marketing">
            <div class="card-soft p-4 h-100">
                <div class="d-flex justify-content-between align-items-start mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <div class="dept-icon success"><i class="bi bi-megaphone"></i></div>
                        <div>
                            <h5 class="mb-1">Marketing</h5>
                            <span class="stat-chip"><i class="bi bi-people me-1"></i> 12 empleados</span>
                        </div>
                    </div>
                    <span class="badge text-bg-success">En contratacion</span>
                </div>
                <p class="text-secondary mb-4">Estrategia digitales, redes sociales y branding institucional.</p>
                <div class="d-flex flex-wrap gap-2 mb-3">
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-badge-ad me-1"></i>Ads</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-share me-1"></i>Social</span>
                    <span class="badge rounded-pill text-bg-light"><i class="bi bi-bar-chart me-1"></i>Analytics</span>
                </div>
                <div class="d-flex gap-2">
                    <button class="btn btn-primary"><i class="bi bi-rocket-takeoff me-2"></i>Estrategias difitales</button>
                    <button class="btn btn-outline-secondary">Briefs</button>
                </div>
            </div>
        </div>
    </div>

    <div class="text-center text-secondary mt-5 mb-4">
        <small> 2025 Universidad Don Bosco,  Sistema de RRHH</small>
    </div>
</main>

<script>
    const search = document.getElementById('search');
    const filter = document.getElementById('filter');
    const cards = Array.from(document.querySelectorAll('.dept'));

    function applyFilters(){
        const q = (search.value || '').toLowerCase();
        const state = filter.value;
        cards.forEach(card=>{
            const name = (card.dataset.name||'').toLowerCase();
            const matchesText = !q || name.includes(q);
            const matchesState = !state || card.dataset.status === state;
            card.style.display = (matchesText && matchesState) ? '' : 'none';
        });
    }

    search.addEventListener('input', applyFilters);
    filter.addEventListener('change', applyFilters);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
