package controller;

import bean.EmpleadoBean;
import model.EmpleadoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/empleados")
public class EmpleadosServlet extends HttpServlet {

    private EmpleadoModel empleadoModel = new EmpleadoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String idParam = request.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        if ("nuevo".equals(accion)) {
            request.getRequestDispatcher("/views/empleados/FormEmpleado.jsp").forward(request, response);
        } else if ("editar".equals(accion) && id > 0) {
            EmpleadoBean emp = empleadoModel.obtenerEmpleado(id);
            request.setAttribute("empleado", emp);
            request.getRequestDispatcher("/views/empleados/FormEmpleado.jsp").forward(request, response);
        } else if ("eliminar".equals(accion) && id > 0) {
            empleadoModel.eliminarEmpleado(id);
            response.sendRedirect(request.getContextPath() + "/empleados");
        } else {
            List<EmpleadoBean> lista = empleadoModel.listaEmpleados();
            request.setAttribute("listaEmpleados", lista);
            request.getRequestDispatcher("/views/empleados/ListarEmpleados.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            EmpleadoBean emp = obtenerEmpleadoDesdeFormulario(request);
            empleadoModel.agregarEmpleado(emp);
            response.sendRedirect(request.getContextPath() + "/empleados");
        } else if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idEmpleado"));
            EmpleadoBean emp = obtenerEmpleadoDesdeFormulario(request);
            emp.setIdEmpleado(id);
            empleadoModel.modificarEmpleado(emp);
            response.sendRedirect(request.getContextPath() + "/empleados");
        }
    }

    private EmpleadoBean obtenerEmpleadoDesdeFormulario(HttpServletRequest request) {
        String numeroDui = request.getParameter("numeroDui");
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");

        Date fechaNacimiento = null;
        try {
            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                java.util.Date parsed = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
                fechaNacimiento = new Date(parsed.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new EmpleadoBean(numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento);
    }
}


