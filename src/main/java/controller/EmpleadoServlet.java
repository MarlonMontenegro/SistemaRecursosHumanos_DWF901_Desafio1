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

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    private EmpleadoDAO empleadoDAO;

    @Override
    public void init() {
        empleadoDAO = new EmpleadoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

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

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> lista = empleadoDAO.listar();
        request.setAttribute("listaEmpleados", lista);
        request.setAttribute("pageContent", "listaEmpleadosContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", "formEmpleadoContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Empleado empleado = obtenerEmpleadoDesdeFormulario(request);
        empleadoDAO.insertar(empleado);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = empleadoDAO.obtenerPorId(id);
        request.setAttribute("empleado", empleado);
        request.setAttribute("pageContent", "formEmpleadoContent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Empleado empleado = obtenerEmpleadoDesdeFormulario(request);
        empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
        empleadoDAO.actualizar(empleado);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empleadoDAO.eliminar(id);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }

    // ===================== UTILIDAD =====================

    private Empleado obtenerEmpleadoDesdeFormulario(HttpServletRequest request) {
        String numeroDui = request.getParameter("numeroDui");
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");

        Date fechaNacimiento = null;
        try {
            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Empleado(numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento);
    }
}
