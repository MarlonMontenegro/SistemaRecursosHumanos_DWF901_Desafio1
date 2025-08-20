package controller;

import dao.EmpleadoDAO;
import model.Empleado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Anotación @WebServlet que registra el servlet en el contenedor con la URL /EmpleadoServlet.
 * Este servlet actúa como "Controlador" en el patrón MVC para la entidad Empleado.
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    /**
     * DAO responsable de las operaciones CRUD contra la capa de datos.
    
     */
    private EmpleadoDAO empleadoDAO;

    /**
     * Ciclo de vida del servlet: init() se ejecuta una sola vez cuando el contenedor
     * instancia el servlet. Es un buen lugar para inicializar recursos compartidos.
     */
    @Override
    public void init() {
        empleadoDAO = new EmpleadoDAO();
    }

    /**
     * Método para manejar solicitudes HTTP GET.
     
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

        // Enrutamiento por acción: centraliza el flujo en un único punto de entrada (Front Controller).
        switch (action) {
            case "nuevo":
                mostrarFormularioNuevo(request, response);
                break;
            case "insertar":
                insertarEmpleado(request, response);
                break;
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "actualizar":
                actualizarEmpleado(request, response);
                break;
            case "eliminar":
                eliminarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
                break;
        }
    }

    // ===================== MÉTODOS =====================

    /**
     * Recupera la lista de empleados desde el DAO, la expone en el request
     * y reenvía (forward) a un layout JSP estableciendo "pageContent" con la vista interna.
     * Uso de layout.jsp como plantilla (header/nav/footer) y contenido dinámico inyectado.
     */
    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> lista = empleadoDAO.listar();
        request.setAttribute("listaEmpleados", lista);
        request.setAttribute("pageContent", "listaEmpleadosContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * Muestra el formulario para crear un nuevo empleado.
     * Solo prepara la vista; no realiza operaciones de base de datos.
     */
    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", "formEmpleadoContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * Inserta un empleado a partir de los parámetros del formulario.
     * Al finalizar, realiza un redirect al listado para evitar re-envíos del formulario (PRG pattern).
     */
    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Empleado empleado = obtenerEmpleadoDesdeFormulario(request);
        empleadoDAO.insertar(empleado);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    /**
     * Carga datos de un empleado existente para edición.
     * Busca por ID, setea el objeto en request y reenvía al formulario con datos precargados.
     */
    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = empleadoDAO.obtenerPorId(id);
        request.setAttribute("empleado", empleado);
        request.setAttribute("pageContent", "formEmpleadoContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    /**
     * Actualiza un empleado existente. Se reconstruye el objeto desde parámetros,
     * se setea el ID (proveniente de un campo oculto en el formulario),
     * y se delega la persistencia al DAO. Luego, redirect al listado.
     */
    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Empleado empleado = obtenerEmpleadoDesdeFormulario(request);
        empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
        empleadoDAO.actualizar(empleado);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    /**
     * Elimina un empleado por ID y redirige al listado.
     * Importante: en un sistema real, podría solicitar confirmación o aplicar soft delete.
     */
    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empleadoDAO.eliminar(id);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    // ===================== UTILIDAD =====================

    /**
     * Fábrica de objetos Empleado a partir de parámetros del formulario HTTP.

     */
    private Empleado obtenerEmpleadoDesdeFormulario(HttpServletRequest request) {
        String numeroDui = request.getParameter("numeroDui");
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");

        Date fechaNacimiento = null;
        try {
            // Convierte la fecha del formato HTML5 (input type="date" -> yyyy-MM-dd) a java.util.Date.
            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
            }
        } catch (ParseException e) {
            // En un entorno profesional, se registraría con un logger (p.ej., SLF4J) y se informaría a la vista.
            e.printStackTrace();
        }

        // Construye el objeto de dominio listo para ser persistido por la capa DAO.
        return new Empleado(numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento);
    }
}
