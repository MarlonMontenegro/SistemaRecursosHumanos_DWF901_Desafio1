<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Lista de Empleados</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>DUI</th>
        <th>Nombre</th>
        <th>Usuario</th>
        <th>Teléfono</th>
        <th>Correo</th>
        <th>Fecha Nacimiento</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="empleado" items="${listaEmpleados}">
        <tr>
            <td>${empleado.idEmpleado}</td>
            <td>${empleado.numeroDui}</td>
            <td>${empleado.nombrePersona}</td>
            <td>${empleado.usuario}</td>
            <td>${empleado.numeroTelefono}</td>
            <td>${empleado.correoInstitucional}</td>
            <td>${empleado.fechaNacimiento}</td>
            <td>
                <a href="EmpleadoServlet?action=editar&id=${empleado.idEmpleado}">Editar</a>
                <a href="EmpleadoServlet?action=eliminar&id=${empleado.idEmpleado}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="EmpleadoServlet?action=nuevo">Nuevo Empleado</a>
