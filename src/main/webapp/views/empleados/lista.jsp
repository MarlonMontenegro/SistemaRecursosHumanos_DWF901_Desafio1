<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
    Directiva de la página JSP que define el tipo de contenido (HTML con codificación UTF-8)
    y especifica que el lenguaje de scripting será Java.
-->

<h2>Lista de Empleados</h2>
<!-- 
    Título principal de la página que indica que se mostrará la lista de empleados registrados.
-->

<table border="1" cellpadding="5" cellspacing="0">
    <!-- 
        Tabla HTML que mostrará los datos de los empleados.
        - border="1": añade un borde simple a las celdas.
        - cellpadding="5": agrega un espacio interno de 5 píxeles dentro de cada celda.
        - cellspacing="0": elimina el espacio entre celdas, haciendo que la tabla se vea más compacta.
    -->

    <tr>
        <!-- Fila de encabezados que define las columnas de la tabla -->
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
        <!-- 
            Etiqueta JSTL (JavaServer Pages Standard Tag Library) que recorre la lista de empleados.
            - var="empleado": nombre de la variable que representa cada elemento de la lista.
            - items="${listaEmpleados}": hace referencia al objeto que contiene la colección de empleados.
        -->

        <tr>
            <!-- Cada iteración crea una nueva fila en la tabla con los datos del empleado actual -->
            <td>${empleado.idEmpleado}</td>
            <!-- Muestra el ID único del empleado -->

            <td>${empleado.numeroDui}</td>
            <!-- Muestra el número de DUI -->

            <td>${empleado.nombrePersona}</td>
            <!-- Muestra el nombre completo del empleado -->

            <td>${empleado.usuario}</td>
            <!-- Muestra el usuario asignado al empleado -->

            <td>${empleado.numeroTelefono}</td>
            <!-- Muestra el número de teléfono -->

            <td>${empleado.correoInstitucional}</td>
            <!-- Muestra el correo institucional -->

            <td>${empleado.fechaNacimiento}</td>
            <!-- Muestra la fecha de nacimiento -->

            <td>
                <!-- 
                    Columna de acciones que contiene enlaces para editar o eliminar un empleado específico.
                    Se pasa el ID del empleado como parámetro en la URL para que el servlet sepa qué registro modificar o borrar.
                -->
                <a href="EmpleadoServlet?action=editar&id=${empleado.idEmpleado}">Editar</a>
                <a href="EmpleadoServlet?action=eliminar&id=${empleado.idEmpleado}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="EmpleadoServlet?action=nuevo">Nuevo Empleado</a>
<!-- 
    Enlace que redirige al servlet con la acción "nuevo". 
    Permite crear un nuevo registro de empleado.
-->
