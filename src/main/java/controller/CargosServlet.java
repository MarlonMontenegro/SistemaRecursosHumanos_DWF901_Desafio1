package controller;

import bean.CargoBean;
import model.CargoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cargos")
public class CargosServlet extends HttpServlet {

    private CargoModel cargoModel = new CargoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String idParam = request.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        if ("nuevo".equals(accion)) {
            request.getRequestDispatcher("/views/cargos/CrearCargo.jsp").forward(request, response);
        } else if ("editar".equals(accion) && id > 0) {
            CargoBean cargo = cargoModel.obtenerCargo(id);
            request.setAttribute("cargo", cargo);
            request.getRequestDispatcher("/views/cargos/EditarCargo.jsp").forward(request, response);
        } else if ("eliminar".equals(accion) && id > 0) {
            cargoModel.eliminarCargo(id);
            response.sendRedirect(request.getContextPath() + "/cargos");
        } else {
            List<CargoBean> cargos = cargoModel.listaCargo();
            request.setAttribute("cargos", cargos);
            request.getRequestDispatcher("/views/cargos/ListarCargos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            String nombre = request.getParameter("cargo");
            String descripcion = request.getParameter("descripcionCargo");
            boolean jefatura = "on".equals(request.getParameter("jefatura"));

            CargoBean nuevoCargo = new CargoBean(nombre, descripcion, jefatura);
            cargoModel.agregarCargo(nuevoCargo);
            response.sendRedirect(request.getContextPath() + "/cargos");

        } else if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idCargo"));
            String nombre = request.getParameter("cargo");
            String descripcion = request.getParameter("descripcionCargo");
            boolean jefatura = "on".equals(request.getParameter("jefatura"));

            CargoBean cargoEdit = new CargoBean(id, nombre, descripcion, jefatura);
            cargoModel.modificarCargo(cargoEdit);
            response.sendRedirect(request.getContextPath() + "/cargos");
        }
    }
}
