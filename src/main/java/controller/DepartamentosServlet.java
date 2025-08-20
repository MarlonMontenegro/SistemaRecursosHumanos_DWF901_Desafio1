package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DepartamentosServlet")
public class DepartamentosServlet extends HttpServlet {

    private static final String JSP_FORM = "/views/departamentos/depaEdit.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(JSP_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("idDepartamento");
        String nombre = request.getParameter("nombreDepartamento");
        String descripcion = request.getParameter("descripcionDepartamento");

        System.out.printf("[DepartamentosServlet] id=%s, nombre=%s, desc=%s%n", id, nombre, descripcion);

        // PRG → redirige a GET
        response.sendRedirect(request.getContextPath() + "/DepartamentosServlet");
    }
}
