package sv.edu.udb.www.servlets;

import db.DBConnection;

import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = {"/api/contrataciones"})
public class ContratacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");

        String sql =
            "SELECT " +
            " c.idContratacion, e.idEmpleado, e.nombrePersona, d.nombreDepartamento, ca.cargo, t.tipoContratacion, " +
            " c.salario, c.fechaContratacion, CASE WHEN c.estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS estado " +
            "FROM Contrataciones c " +
            "JOIN Empleados e ON c.idEmpleado = e.idEmpleado " +
            "JOIN Departamento d ON c.idDepartamento = d.idDepartamento " +
            "JOIN Cargo ca ON c.idCargo = ca.idCargo " +
            "JOIN TipoContratacion t ON c.idTipoContratacion = t.idTipoContratacion";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            JsonArrayBuilder arr = Json.createArrayBuilder();
            while (rs.next()) {
                arr.add(Json.createObjectBuilder()
                    .add("idContratacion", rs.getInt("idContratacion"))
                    .add("idEmpleado", rs.getInt("idEmpleado"))
                    .add("nombrePersona", rs.getString("nombrePersona"))
                    .add("nombreDepartamento", rs.getString("nombreDepartamento"))
                    .add("cargo", rs.getString("cargo"))
                    .add("tipoContratacion", rs.getString("tipoContratacion"))
                    .add("salario", rs.getBigDecimal("salario").toPlainString())
                    .add("fechaContratacion", String.valueOf(rs.getDate("fechaContratacion")))
                    .add("estado", rs.getString("estado"))
                );
            }

            resp.getWriter().write(Json.createObjectBuilder().add("ok", true).add("data", arr).build().toString());

        } catch (Exception ex) {
            resp.setStatus(500);
            resp.getWriter().write(Json.createObjectBuilder()
                .add("ok", false)
                .add("error", ex.getClass().getSimpleName()+": "+ex.getMessage())
                .build().toString());
        }
    }
}
