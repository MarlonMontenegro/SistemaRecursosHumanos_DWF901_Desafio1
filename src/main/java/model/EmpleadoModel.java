package model;

import bean.EmpleadoBean;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoModel {

    private static final Logger LOGGER = Logger.getLogger(EmpleadoModel.class.getName());


    public List<EmpleadoBean> listaEmpleados() {
        List<EmpleadoBean> empleados = new ArrayList<>();
        String sql = "SELECT idEmpleado, numeroDui, nombrePersona, usuario, " +
                "numeroTelefono, correoInstitucional, fechaNacimiento " +
                "FROM empleados ORDER BY nombrePersona";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EmpleadoBean e = new EmpleadoBean();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNumeroDui(rs.getString("numeroDui"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                e.setUsuario(rs.getString("usuario"));
                e.setNumeroTelefono(rs.getString("numeroTelefono"));
                e.setCorreoInstitucional(rs.getString("correoInstitucional"));
                e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                empleados.add(e);
            }
            return empleados;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaEmpleados", ex);
            return null;
        }
    }

    public EmpleadoBean obtenerEmpleado(int id) {
        String sql = "SELECT idEmpleado, numeroDui, nombrePersona, usuario, " +
                "numeroTelefono, correoInstitucional, fechaNacimiento " +
                "FROM empleados WHERE idEmpleado = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    EmpleadoBean e = new EmpleadoBean();
                    e.setIdEmpleado(rs.getInt("idEmpleado"));
                    e.setNumeroDui(rs.getString("numeroDui"));
                    e.setNombrePersona(rs.getString("nombrePersona"));
                    e.setUsuario(rs.getString("usuario"));
                    e.setNumeroTelefono(rs.getString("numeroTelefono"));
                    e.setCorreoInstitucional(rs.getString("correoInstitucional"));
                    e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    return e;
                }
            }

            return null;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en obtenerEmpleado", ex);
            return null;
        }
    }

    public int agregarEmpleado(EmpleadoBean e) {
        String sql = "INSERT INTO empleados " +
                "(numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, e.getNumeroDui());
            ps.setString(2, e.getNombrePersona());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getNumeroTelefono());
            ps.setString(5, e.getCorreoInstitucional());
            ps.setDate(6, e.getFechaNacimiento());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en agregarEmpleado", ex);
            return 0;
        }
    }

    public int modificarEmpleado(EmpleadoBean e) {
        String sql = "UPDATE empleados SET " +
                "numeroDui=?, nombrePersona=?, usuario=?, numeroTelefono=?, " +
                "correoInstitucional=?, fechaNacimiento=? " +
                "WHERE idEmpleado=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, e.getNumeroDui());
            ps.setString(2, e.getNombrePersona());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getNumeroTelefono());
            ps.setString(5, e.getCorreoInstitucional());
            ps.setDate(6,  e.getFechaNacimiento());
            ps.setInt(7, e.getIdEmpleado());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en modificarEmpleado", ex);
            return 0;
        }
    }

    public int eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE idEmpleado = ?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en eliminarEmpleado", ex);
            return 0;
        }
    }

    public int contarEmpleados() throws SQLException {
        String sql = "SELECT COUNT(*) FROM empleados";
        try (Connection cn = DBConnection.getConnection();
        ResultSet rs = cn.prepareStatement(sql).executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
