package controller;

import db.DBConnection;

import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@WebServlet(urlPatterns = {"/api/empleados", "/api/empleados/*"})
public class EmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String path = req.getPathInfo();
        try (Connection con = DBConnection.getConnection()) {
            if (path == null || "/".equals(path)) {
                String sql = "SELECT idEmpleado, numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento FROM Empleados";
                try (PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {
                    JsonArrayBuilder arr = Json.createArrayBuilder();
                    while (rs.next()) arr.add(rsToJson(rs));
                    resp.getWriter().write(Json.createObjectBuilder().add("ok", true).add("data", arr).build().toString());
                }
            } else {
                int id = Integer.parseInt(path.substring(1));
                String sql = "SELECT idEmpleado, numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento FROM Empleados WHERE idEmpleado=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) { resp.setStatus(404); resp.getWriter().write("{\"ok\":false,\"error\":\"No encontrado\"}"); return; }
                        resp.getWriter().write(Json.createObjectBuilder().add("ok", true).add("data", rsToJson(rs)).build().toString());
                    }
                }
            }
        } catch (Exception ex) { error500(resp, ex); }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection con = DBConnection.getConnection()) {
            String ct = req.getContentType()==null?"":req.getContentType();
            String numeroDui=null, nombrePersona=null, usuario=null, numeroTelefono=null, correoInstitucional=null, fechaNacimiento=null;
            if (ct.startsWith("application/json")) {
                try (InputStream in = req.getInputStream(); JsonReader r = Json.createReader(in)) {
                    JsonObject b = r.readObject();
                    numeroDui = b.getString("numeroDui", null);
                    nombrePersona = b.getString("nombrePersona", null);
                    usuario = b.getString("usuario", null);
                    numeroTelefono = b.containsKey("numeroTelefono") ? b.getString("numeroTelefono", null) : null;
                    correoInstitucional = b.getString("correoInstitucional", null);
                    fechaNacimiento = b.getString("fechaNacimiento", null);
                }
            } else {
                numeroDui = req.getParameter("numeroDui");
                nombrePersona = req.getParameter("nombrePersona");
                usuario = req.getParameter("usuario");
                numeroTelefono = req.getParameter("numeroTelefono");
                correoInstitucional = req.getParameter("correoInstitucional");
                fechaNacimiento = req.getParameter("fechaNacimiento");
            }

            if (isBlank(numeroDui) || isBlank(nombrePersona) || isBlank(usuario) || isBlank(correoInstitucional) || isBlank(fechaNacimiento)) {
                resp.setStatus(400); resp.getWriter().write("{\"ok\":false,\"error\":\"Campos requeridos: numeroDui,nombrePersona,usuario,correoInstitucional,fechaNacimiento\"}"); return;
            }

            Integer nuevoId = null;
            String sql = "INSERT INTO Empleados (numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, numeroDui);
                ps.setString(2, nombrePersona);
                ps.setString(3, usuario);
                if (isBlank(numeroTelefono)) ps.setNull(4, Types.VARCHAR); else ps.setString(4, numeroTelefono);
                ps.setString(5, correoInstitucional);
                ps.setDate(6, java.sql.Date.valueOf(fechaNacimiento));
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) { if (keys.next()) nuevoId = keys.getInt(1); }
            } catch (SQLIntegrityConstraintViolationException dup) {
                resp.setStatus(409); resp.getWriter().write("{\"ok\":false,\"error\":\"Duplicado: DUI/usuario/correo ya existe\"}"); return;
            }

            JsonObject data = Json.createObjectBuilder()
                .add("idEmpleado", nuevoId==null?JsonValue.NULL:Json.createValue(nuevoId))
                .add("numeroDui", numeroDui)
                .add("nombrePersona", nombrePersona)
                .add("usuario", usuario)
                .add("numeroTelefono", isBlank(numeroTelefono)?"":numeroTelefono)
                .add("correoInstitucional", correoInstitucional)
                .add("fechaNacimiento", fechaNacimiento)
                .build();

            resp.setStatus(201);
            resp.setHeader("Location", req.getContextPath()+"/api/empleados/"+(nuevoId==null?"":nuevoId));
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().write(Json.createObjectBuilder().add("ok", true).add("data", data).build().toString());
        } catch (Exception ex) { error500(resp, ex); }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getPathInfo(); if (path == null || path.length() <= 1) { resp.setStatus(400); resp.getWriter().write("{\"ok\":false,\"error\":\"Debe indicar /api/empleados/{id}\"}"); return; }
        int id = Integer.parseInt(path.substring(1));
        try (Connection con = DBConnection.getConnection()) {
            String ct = req.getContentType()==null?"":req.getContentType();
            String numeroDui=null, nombrePersona=null, usuario=null, numeroTelefono=null, correoInstitucional=null, fechaNacimiento=null;
            if (ct.startsWith("application/json")) {
                try (InputStream in = req.getInputStream(); JsonReader r = Json.createReader(in)) {
                    JsonObject b = r.readObject();
                    numeroDui = b.getString("numeroDui", null);
                    nombrePersona = b.getString("nombrePersona", null);
                    usuario = b.getString("usuario", null);
                    numeroTelefono = b.containsKey("numeroTelefono") ? b.getString("numeroTelefono", null) : null;
                    correoInstitucional = b.getString("correoInstitucional", null);
                    fechaNacimiento = b.getString("fechaNacimiento", null);
                }
            } else {
                numeroDui = req.getParameter("numeroDui");
                nombrePersona = req.getParameter("nombrePersona");
                usuario = req.getParameter("usuario");
                numeroTelefono = req.getParameter("numeroTelefono");
                correoInstitucional = req.getParameter("correoInstitucional");
                fechaNacimiento = req.getParameter("fechaNacimiento");
            }

            String sql = "UPDATE Empleados SET numeroDui=?, nombrePersona=?, usuario=?, numeroTelefono=?, correoInstitucional=?, fechaNacimiento=? WHERE idEmpleado=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, numeroDui);
                ps.setString(2, nombrePersona);
                ps.setString(3, usuario);
                if (isBlank(numeroTelefono)) ps.setNull(4, Types.VARCHAR); else ps.setString(4, numeroTelefono);
                ps.setString(5, correoInstitucional);
                ps.setDate(6, java.sql.Date.valueOf(fechaNacimiento));
                ps.setInt(7, id);
                int rows = ps.executeUpdate();
                if (rows==0) { resp.setStatus(404); resp.getWriter().write("{\"ok\":false,\"error\":\"No encontrado\"}"); return; }
            } catch (SQLIntegrityConstraintViolationException dup) {
                resp.setStatus(409); resp.getWriter().write("{\"ok\":false,\"error\":\"Duplicado: DUI/usuario/correo ya existe\"}"); return;
            }

            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().write("{\"ok\":true,\"msg\":\"Actualizado\"}");
        } catch (Exception ex) { error500(resp, ex); }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getPathInfo(); if (path == null || path.length() <= 1) { resp.setStatus(400); resp.getWriter().write("{\"ok\":false,\"error\":\"Debe indicar /api/empleados/{id}\"}"); return; }
        int id = Integer.parseInt(path.substring(1));
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM Empleados WHERE idEmpleado=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows==0) { resp.setStatus(404); resp.getWriter().write("{\"ok\":false,\"error\":\"No encontrado\"}"); return; }
            }
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().write("{\"ok\":true,\"msg\":\"Eliminado\"}");
        } catch (Exception ex) { error500(resp, ex); }
    }

    private static JsonObject rsToJson(ResultSet rs) throws SQLException {
        return Json.createObjectBuilder()
            .add("idEmpleado", rs.getInt("idEmpleado"))
            .add("numeroDui", rs.getString("numeroDui"))
            .add("nombrePersona", rs.getString("nombrePersona"))
            .add("usuario", rs.getString("usuario"))
            .add("numeroTelefono", rs.getString("numeroTelefono")==null?"":rs.getString("numeroTelefono"))
            .add("correoInstitucional", rs.getString("correoInstitucional"))
            .add("fechaNacimiento", String.valueOf(rs.getDate("fechaNacimiento")))
            .build();
    }
    private static boolean isBlank(String s){ return s==null || s.trim().isEmpty(); }
    private static void error500(HttpServletResponse resp, Exception ex) throws IOException {
        resp.setStatus(500);
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write(Json.createObjectBuilder().add("ok", false).add("error", ex.getClass().getSimpleName()+": "+ex.getMessage()).build().toString());
    }
}
