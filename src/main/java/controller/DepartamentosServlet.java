package controller;

import bean.DepartamentoBean;
import model.DepartamentoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/departamentos")
public class DepartamentosServlet extends HttpServlet {

    private DepartamentoModel depModel = new DepartamentoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String idParam = request.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        if ("nuevo".equals(accion)) {
            // Formulario para crear
            request.getRequestDispatcher("/views/departamentos/CrearDepartamento.jsp").forward(request, response);
        } else if ("editar".equals(accion) && id > 0) {
            // Formulario para editar
            DepartamentoBean dep = depModel.obtenerDepartamento(id);
            request.setAttribute("departamento", dep);
            request.getRequestDispatcher("/views/departamentos/EditarDepartamento.jsp").forward(request, response);
        } else if ("eliminar".equals(accion) && id > 0) {
            // Eliminar departamento
            depModel.eliminarDepartamento(id);
            response.sendRedirect(request.getContextPath() + "/departamentos");
        } else {
            // Listado de departamentos
            List<DepartamentoBean> departamentos = depModel.listarDepartamento();
            request.setAttribute("departamentos", departamentos);
            request.getRequestDispatcher("/views/departamentos/ListarDepartamentos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("crear".equals(accion)) {
            // Crear departamento
            String nombre = request.getParameter("nombreDepartamento");
            String descripcion = request.getParameter("descripcionDepartamento");
            depModel.agregarDepartamento(new DepartamentoBean(nombre, descripcion));
            response.sendRedirect(request.getContextPath() + "/departamentos");
        } else if ("editar".equals(accion)) {
            // Editar departamento
            int id = Integer.parseInt(request.getParameter("idDepartamento"));
            String nombre = request.getParameter("nombreDepartamento");
            String descripcion = request.getParameter("descripcionDepartamento");
            depModel.modificarDepartamento(new DepartamentoBean(id, nombre, descripcion));
            response.sendRedirect(request.getContextPath() + "/departamentos");
        }
    }
}
