CREATE DATABASE IF NOT EXISTS hr_donbosco;

USE hr_donbosco;

CREATE TABLE Empleados (
    idEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    numeroDui VARCHAR(9) NOT NULL UNIQUE, 
    nombrePersona VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    numeroTelefono VARCHAR(9),
    correoInstitucional VARCHAR(100) NOT NULL UNIQUE,
    fechaNacimiento DATE NOT NULL
);

CREATE TABLE Departamento (
    idDepartamento INT AUTO_INCREMENT PRIMARY KEY,
    nombreDepartamento VARCHAR(100) NOT NULL UNIQUE,
    descripcionDepartamento TEXT
);

CREATE TABLE Cargo (
    idCargo INT AUTO_INCREMENT PRIMARY KEY,
    cargo VARCHAR(50) NOT NULL UNIQUE,
    descripcionCargo TEXT NOT NULL,
    jefatura BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE TipoContratacion (
    idTipoContratacion INT AUTO_INCREMENT PRIMARY KEY,
    tipoContratacion VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Contrataciones (
    idContratacion INT AUTO_INCREMENT PRIMARY KEY,
    idDepartamento INT NOT NULL,
    idEmpleado INT NOT NULL,
    idCargo INT NOT NULL,
    fechaContratacion DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT 1,
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado),
    FOREIGN KEY (idCargo) REFERENCES Cargo(idCargo)
);




-- Insertar departamentos
INSERT INTO Departamento (nombreDepartamento, descripcionDepartamento) VALUES
('Recursos Humanos', 'Departamento encargado del talento humano y nóminas'),
('Tecnología', 'Departamento de desarrollo y mantenimiento de sistemas'),
('Ventas', 'Equipo encargado de la comercialización y atención al cliente');

-- Insertar cargos
INSERT INTO Cargo (cargo, descripcionCargo, jefatura) VALUES
('Analista de RRHH', 'Responsable del análisis y gestión de recursos humanos', 0),
('Jefe de Tecnología', 'Lidera el departamento de tecnología', 1),
('Vendedor', 'Encargado de las ventas y atención al cliente', 0);

-- Insertar tipos de contratación
INSERT INTO TipoContratacion (tipoContratacion) VALUES
('Temporal'),
('Permanente'),
('Por Proyecto');

-- Insertar empleados
INSERT INTO Empleados (numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES
('012345678', 'Carlos López', 'clopez', '77771234', 'clopez@donbosco.edu.sv', '1985-07-15'),
('098765432', 'Ana Martínez', 'amartinez', '77779876', 'amartinez@donbosco.edu.sv', '1990-11-22'),
('123456789', 'José Ramírez', 'jramirez', '77770011', 'jramirez@donbosco.edu.sv', '1995-03-10');

-- Insertar contrataciones
INSERT INTO Contrataciones (idDepartamento, idEmpleado, idCargo, fechaContratacion, salario, estado) VALUES
(1, 1, 1, '2020-01-10', 500.00, 1),
(2, 2, 2, '2018-06-01', 1200.00, 1),
(3, 3, 3, '2021-09-15', 450.00, 1);


SELECT 
    e.idEmpleado,
    e.nombrePersona,
    d.nombreDepartamento,
    ca.cargo,
    c.salario,
    c.fechaContratacion,
    CASE 
        WHEN c.estado = 1 THEN 'Activo'
        ELSE 'Inactivo'
    END AS estado
FROM 
    Contrataciones c
JOIN 
    Empleados e ON c.idEmpleado = e.idEmpleado
JOIN 
    Departamento d ON c.idDepartamento = d.idDepartamento
JOIN 
    Cargo ca ON c.idCargo = ca.idCargo;
