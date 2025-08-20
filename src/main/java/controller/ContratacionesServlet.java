package controller;

import bean.ContratacionesBean;
import model.ContratacionModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contrataciones")
public class ContratacionesServlet extends HttpServlet {

    private ContratacionModel contratacionModel = new ContratacionModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "cambiarEstado": {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean nuevoEstado = Boolean.parseBoolean(request.getParameter("estado")); // "true"/"false"
                contratacionModel.cambiarEstado(id, nuevoEstado);
                response.sendRedirect(request.getContextPath() + "/contrataciones?accion=listar");
                return;
            }
            case "nuevo": {
                // Solo mostrar formulario (placeholder si aún no existe)
                request.getRequestDispatcher("/views/contrataciones/FormContratacion.jsp")
                        .forward(request, response);
                return;
            }
            case "editar": {
                int id = Integer.parseInt(request.getParameter("id"));
                // ContratacionesBean c = contratacionModel.obtenerPorId(id); // si ya lo tienes
                // request.setAttribute("contratacion", c);
                request.getRequestDispatcher("/views/contrataciones/FormContratacion.jsp")
                        .forward(request, response);
                return;
            }
            case "listar":
            default:
                listarAmbas(request, response);
        }
    }

    private void listarAmbas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ContratacionesBean> activas    = contratacionModel.listaContratacionesActivas();
        List<ContratacionesBean> inactivas  = contratacionModel.listaContratacionesInactivas();

        request.setAttribute("contratacionesActivas", activas);
        request.setAttribute("contratacionesInactivas", inactivas);
        request.getRequestDispatcher("/views/contrataciones/ListarContrataciones.jsp")
                .forward(request, response);
    }
}

