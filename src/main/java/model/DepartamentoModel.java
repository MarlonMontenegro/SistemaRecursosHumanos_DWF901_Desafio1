package model;

import bean.DepartamentoBean;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoModel {
    private static final Logger LOGGER = Logger.getLogger(DepartamentoModel.class.getName());


    public List<DepartamentoBean> listarDepartamento() {
        List<DepartamentoBean> departamentos = new ArrayList<>();
        String sql = "SELECT idDepartamento, nombreDepartamento, descripcionDepartamento FROM departamento ORDER BY nombreDepartamento";


        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                DepartamentoBean d = new DepartamentoBean();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setDescripcionDepartamento(rs.getString("descripcionDepartamento"));
                departamentos.add(d);
            }
            return departamentos;


        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaDepartamento", ex);
            return null;
        }
    }
    public int agregarDepartamento(DepartamentoBean d) {
        String sql = "INSERT INTO departamento (nombreDepartamento, descripcionDepartamento) VALUES (?, ?)";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getDescripcionDepartamento());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en agregarDepartamento", ex);
            return 0;
        }
    }
    public int modificarDepartamento(DepartamentoBean d) {
        String sql = "UPDATE departamento SET nombreDepartamento=?, descripcionDepartamento=? WHERE idDepartamento=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getDescripcionDepartamento());
            ps.setInt(3, d.getIdDepartamento());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en modificarDepartamento", ex);
            return 0;
        }
    }
    public int eliminarDepartamento(int id) {
        String sql = "DELETE FROM departamento WHERE idDepartamento=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en eliminarDepartamento", ex);
            return 0;
        }
    }
    public DepartamentoBean obtenerDepartamento(int id) {
        String sql = "SELECT idDepartamento, nombreDepartamento, descripcionDepartamento " +
                "FROM Departamento WHERE idDepartamento = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DepartamentoBean d = new DepartamentoBean();
                    d.setIdDepartamento(rs.getInt("idDepartamento"));
                    d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                    d.setDescripcionDepartamento(rs.getString("descripcionDepartamento"));
                    return d;
                }
            }
            return null; // no encontrado

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en obtenerDepartamento", ex);
            return null;
        }
    }
    public int contarDepartamentos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM departamento";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }



} //Fin de la clase