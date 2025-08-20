<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!-- 
    Directiva de la página JSP que establece el tipo de contenido (HTML con UTF-8)
    y especifica que el lenguaje de scripting será Java.
-->

<h2>${empleado != null ? "Editar Empleado" : "Nuevo Empleado"}</h2>
<!-- 
    Uso de Expression Language (EL) para determinar dinámicamente el título de la página.
    Si el objeto 'empleado' existe (no es null), se muestra "Editar Empleado".
    En caso contrario, se muestra "Nuevo Empleado".
-->

<form action="EmpleadoServlet" method="post">
    <!-- 
        Formulario que envía los datos al servlet 'EmpleadoServlet' usando el método POST.
        Este servlet se encargará de procesar los datos para registrar o actualizar un empleado.
    -->

    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}"/>
    <!-- 
        Campo oculto que contiene el identificador del empleado. 
        Es útil cuando se está editando un registro existente, 
        ya que permite identificar qué empleado debe actualizarse en la base de datos.
    -->

    <label for="numeroDui">DUI:</label>
    <input type="text" id="numeroDui" name="numeroDui" value="${empleado.numeroDui}" required/><br/>
    <!-- 
        Campo de entrada para el número de DUI (Documento Único de Identidad).
        Está marcado como "required", lo que obliga a que el usuario lo complete antes de enviar el formulario.
    -->

    <label for="nombrePersona">Nombre Completo:</label>
    <input type="text" id="nombrePersona" name="nombrePersona" value="${empleado.nombrePersona}" required/><br/>
    <!-- 
        Campo de entrada para el nombre completo del empleado.
        También es obligatorio gracias a la validación "required".
    -->

    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" value="${empleado.usuario}" required/><br/>
    <!-- 
        Campo de entrada para el nombre de usuario del empleado. 
        Puede representar el login en el sistema.
    -->

    <label for="numeroTelefono">Teléfono:</label>
    <input type="text" id="numeroTelefono" name="numeroTelefono" value="${empleado.numeroTelefono}"/><br/>
    <!-- 
        Campo opcional para ingresar el número de teléfono. 
        No es requerido, lo que significa que puede quedar vacío.
    -->

    <label for="correoInstitucional">Correo Institucional:</label>
    <input type="email" id="correoInstitucional" name="correoInstitucional" value="${empleado.correoInstitucional}" required/><br/>
    <!-- 
        Campo de entrada tipo "email", lo que fuerza validación básica de formato en el navegador.
        Es obligatorio y sirve para registrar el correo institucional del empleado.
    -->

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento"
           value="${empleado.fechaNacimiento != null ? empleado.fechaNacimiento : ''}"/><br/>
    <!-- 
        Campo de entrada tipo "date" para seleccionar la fecha de nacimiento.
        Si el empleado ya tiene registrada una fecha en la base de datos, se carga automáticamente.
        De lo contrario, se deja vacío.
    -->

    <button type="submit">Guardar</button>
    <!-- Botón que envía los datos del formulario al servidor para ser procesados. -->

    <a href="EmpleadoServlet?action=listar">Cancelar</a>
    <!-- 
        Enlace que redirige a la acción 'listar' del servlet, 
        lo que generalmente muestra el listado de empleados registrados.
    -->
</form>
