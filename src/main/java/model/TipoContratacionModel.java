package model;

import bean.TipoContratacionBean;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoContratacionModel {

    private static final Logger LOGGER = Logger.getLogger(TipoContratacionModel.class.getName());

        public List<TipoContratacionBean> listaTipoContratacion() {
        List<TipoContratacionBean> lista = new ArrayList<>();
        String sql = "SELECT idTipoContratacion, tipoContratacion FROM tipocontratacion ORDER BY tipoContratacion";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TipoContratacionBean t = new TipoContratacionBean();
                t.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                t.setTipoContratacion(rs.getString("tipoContratacion"));
                lista.add(t);
            }
            return lista;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaTipoContratacion", ex);
            return null;
        }
    }

    public int agregarTipoContratacion(TipoContratacionBean t) {
            String sql = "INSERT INTO tipocontratacion (tipoContratacion) VALUES (?)";

            try (Connection cn = DBConnection.getConnection();
                 PreparedStatement ps = cn.prepareStatement(sql)){

                ps.setString(1, t.getTipoContratacion());
                return ps.executeUpdate();

            }catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error en agregarTipoContratacion", ex);
                return 0;
            }
    }

    public TipoContratacionBean obtenerTipoContratacion(int id) {
        String sql = "SELECT idTipoContratacion, tipoContratacion FROM tipocontratacion WHERE idTipoContratacion = ?";

        try (Connection cn = DBConnection.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql))
        {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoContratacionBean t = new TipoContratacionBean();
                    t.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                    t.setTipoContratacion(rs.getString("tipoContratacion"));
                    return t;
                }
            }

            return null;

        }catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en obtenerTipoContratacion", ex);
            return null;
        }

    }

    public int modificarTipoContratacion(TipoContratacionBean t) {
        String sql = "UPDATE tipocontratacion SET tipoContratacion=? WHERE idTipoContratacion=?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, t.getTipoContratacion());
            ps.setInt(2, t.getIdTipoContratacion());
            return ps.executeUpdate(); // >0 = ok, 0 = no existía ese id

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en modificarTipoContratacion", ex);
            return 0;
        }
    }

}
