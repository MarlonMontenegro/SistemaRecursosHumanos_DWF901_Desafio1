package model;

import bean.CargoBean;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoModel {

    private static final Logger LOGGER = Logger.getLogger(CargoModel.class.getName());

    public List<CargoBean> listaCargo() {
        List<CargoBean> cargos = new ArrayList<>();
        String sql = "SELECT idCargo, cargo, descripcionCargo, jefatura FROM cargo ORDER BY cargo";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CargoBean c = new CargoBean();
                c.setIdCargo(rs.getInt("idCargo"));
                c.setCargo(rs.getString("cargo"));
                c.setDescripcionCargo(rs.getString("descripcionCargo"));
                c.setJefatura(rs.getBoolean("jefatura"));
                cargos.add(c);
            }
            return cargos;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaCargo", ex);
            return null;
        }
    }

    public CargoBean obtenerCargo(int id) {
        String sql = "SELECT idCargo, cargo, descripcionCargo, jefatura FROM cargo WHERE idCargo = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    CargoBean c = new CargoBean();
                    c.setIdCargo(rs.getInt("idCargo"));
                    c.setCargo(rs.getString("cargo"));
                    c.setDescripcionCargo(rs.getString("descripcionCargo"));
                    c.setJefatura(rs.getBoolean("jefatura"));
                    return c;
                }
            }

            return null;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en obtenerCargo", ex);
            return null;
        }
    }

    public int agregarCargo(CargoBean c) {
        String sql = "INSERT INTO cargo (cargo, descripcionCargo, jefatura) VALUES (?, ?, ?)";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getCargo());
            ps.setString(2, c.getDescripcionCargo());
            ps.setBoolean(3, c.isJefatura());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en agregarCargo", ex);
            return 0;
        }
    }

    public int modificarCargo(CargoBean c) {
        String sql = "UPDATE cargo SET cargo=?, descripcionCargo=?, jefatura=? WHERE idCargo=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getCargo());
            ps.setString(2, c.getDescripcionCargo());
            ps.setBoolean(3, c.isJefatura());
            ps.setInt(4, c.getIdCargo());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en modificarCargo", ex);
            return 0;
        }
    }

    public int eliminarCargo(int id) {
        String sql = "DELETE FROM cargo WHERE idCargo=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en eliminarCargo", ex);
            return 0;
        }
    }

}
