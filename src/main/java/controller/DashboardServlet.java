package controller;

import db.DBConnection;
import model.DepartamentoModel;
import model.EmpleadoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/")
public class DashboardServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmpleadoModel empleado = new EmpleadoModel();
        DepartamentoModel departamento = new DepartamentoModel();

        try {
            int totalEmpleados = empleado.contarEmpleados();
            int totalDepartamentos = departamento.contarDepartamentos();

            request.setAttribute("totalEmpleados", totalEmpleados);
            request.setAttribute("totalDepartamentos", totalDepartamentos);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("totalEmpleados", 0);
            request.setAttribute("totalDepartamentos", 0);
        }

        // Forward al JSP
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}

