package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContratacionesServlet")
public class ContratacionesServlet extends HttpServlet {

    private static final String JSP_VIEW = "/views/contrataciones/Contratacionesview.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(JSP_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        // Lee parámetros del formulario 
        String idContratacion   = request.getParameter("idContratacion");
        String empleado         = request.getParameter("empleado");
        String departamento     = request.getParameter("Departamento"); 
        String cargo            = request.getParameter("cargo");
        String tipoContratacion = request.getParameter("tipoContratacion");
        String fecha            = request.getParameter("fechaContratacion");
        String salario          = request.getParameter("salario");

        System.out.printf("[ContratacionesServlet] id=%s, emp=%s, dept=%s, cargo=%s, tipo=%s, fecha=%s, salario=%s%n",
                idContratacion, empleado, departamento, cargo, tipoContratacion, fecha, salario);

       
        response.sendRedirect(request.getContextPath() + "/ContratacionesServlet");
    }
}
