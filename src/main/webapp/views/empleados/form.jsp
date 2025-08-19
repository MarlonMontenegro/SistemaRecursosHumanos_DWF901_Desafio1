<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>${empleado != null ? "Editar Empleado" : "Nuevo Empleado"}</h2>

<form action="EmpleadoServlet" method="post">
    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}"/>

    <label for="numeroDui">DUI:</label>
    <input type="text" id="numeroDui" name="numeroDui" value="${empleado.numeroDui}" required/><br/>

    <label for="nombrePersona">Nombre Completo:</label>
    <input type="text" id="nombrePersona" name="nombrePersona" value="${empleado.nombrePersona}" required/><br/>

    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" value="${empleado.usuario}" required/><br/>

    <label for="numeroTelefono">Teléfono:</label>
    <input type="text" id="numeroTelefono" name="numeroTelefono" value="${empleado.numeroTelefono}"/><br/>

    <label for="correoInstitucional">Correo Institucional:</label>
    <input type="email" id="correoInstitucional" name="correoInstitucional" value="${empleado.correoInstitucional}" required/><br/>

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento"
           value="${empleado.fechaNacimiento != null ? empleado.fechaNacimiento : ''}"/><br/>

    <button type="submit">Guardar</button>
    <a href="EmpleadoServlet?action=listar">Cancelar</a>
</form>
