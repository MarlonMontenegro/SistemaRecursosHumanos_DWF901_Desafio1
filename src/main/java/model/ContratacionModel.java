package model;

import bean.*;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContratacionModel {

    private static final Logger LOGGER = Logger.getLogger(ContratacionModel.class.getName());


    private static final String BASE_SELECT =
            "SELECT c.idContratacion, " +
                    "       c.idDepartamento, d.nombreDepartamento, " +
                    "       c.idEmpleado, e.nombrePersona, " +
                    "       c.idCargo, ca.cargo AS cargo, " +
                    "       c.idTipoContratacion, t.tipoContratacion AS tipoContratacion, " +
                    "       c.fechaContratacion, c.salario, c.estado " +
                    "FROM Contrataciones c " +
                    "JOIN Empleados e        ON e.idEmpleado = c.idEmpleado " +
                    "JOIN Departamento d     ON d.idDepartamento = c.idDepartamento " +
                    "JOIN Cargo ca           ON ca.idCargo = c.idCargo " +
                    "JOIN TipoContratacion t ON t.idTipoContratacion = c.idTipoContratacion ";

    public List<ContratacionesBean> listaContratacionesActivas() {
        List<ContratacionesBean> lista = new ArrayList<>();
        String sql = BASE_SELECT + "WHERE c.estado = 1 ORDER BY c.fechaContratacion DESC";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContratacionesBean c = new ContratacionesBean();

                c.setIdContratacion(rs.getInt("idContratacion"));

                EmpleadoBean e = new EmpleadoBean();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                c.setEmpleado(e);

                DepartamentoBean d = new DepartamentoBean();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                c.setDepartamento(d);

                CargoBean cg = new CargoBean();
                cg.setIdCargo(rs.getInt("idCargo"));
                cg.setCargo(rs.getString("cargo"));
                c.setCargo(cg);

                TipoContratacionBean tc = new TipoContratacionBean();
                tc.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                tc.setTipoContratacion(rs.getString("tipoContratacion"));
                c.setTipoContratacion(tc);

                c.setFechaContratacion(rs.getDate("fechaContratacion"));
                c.setSalario(rs.getDouble("salario"));
                c.setEstado(rs.getBoolean("estado"));

                lista.add(c);
            }
            return lista;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaContratacionesActivas", ex);
            return null;
        }
    }

    public List<ContratacionesBean> listaContratacionesInactivas() {
        List<ContratacionesBean> lista = new ArrayList<>();
        String sql = BASE_SELECT + "WHERE c.estado = 0 ORDER BY c.fechaContratacion DESC";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContratacionesBean c = new ContratacionesBean();

                c.setIdContratacion(rs.getInt("idContratacion"));

                EmpleadoBean e = new EmpleadoBean();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                c.setEmpleado(e);

                DepartamentoBean d = new DepartamentoBean();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                c.setDepartamento(d);

                CargoBean cg = new CargoBean();
                cg.setIdCargo(rs.getInt("idCargo"));
                cg.setCargo(rs.getString("cargo"));
                c.setCargo(cg);

                TipoContratacionBean tc = new TipoContratacionBean();
                tc.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                tc.setTipoContratacion(rs.getString("tipoContratacion"));
                c.setTipoContratacion(tc);

                c.setFechaContratacion(rs.getDate("fechaContratacion"));
                c.setSalario(rs.getDouble("salario"));
                c.setEstado(rs.getBoolean("estado"));

                lista.add(c);
            }
            return lista;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en listaContratacionesInactivas", ex);
            return null;
        }
    }

    public ContratacionesBean obtenerContratacion(int id) {
        String sql = BASE_SELECT + "WHERE c.idContratacion = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ContratacionesBean c = new ContratacionesBean();

                    c.setIdContratacion(rs.getInt("idContratacion"));

                    EmpleadoBean e = new EmpleadoBean();
                    e.setIdEmpleado(rs.getInt("idEmpleado"));
                    e.setNombrePersona(rs.getString("nombrePersona"));
                    c.setEmpleado(e);

                    DepartamentoBean d = new DepartamentoBean();
                    d.setIdDepartamento(rs.getInt("idDepartamento"));
                    d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                    c.setDepartamento(d);

                    CargoBean cg = new CargoBean();
                    cg.setIdCargo(rs.getInt("idCargo"));
                    cg.setCargo(rs.getString("cargo"));
                    c.setCargo(cg);

                    TipoContratacionBean tc = new TipoContratacionBean();
                    tc.setIdTipoContratacion(rs.getInt("idTipoContratacion"));
                    tc.setTipoContratacion(rs.getString("tipoContratacion"));
                    c.setTipoContratacion(tc);

                    c.setFechaContratacion(rs.getDate("fechaContratacion"));
                    c.setSalario(rs.getDouble("salario"));
                    c.setEstado(rs.getBoolean("estado"));

                    return c;
                }
            }
            return null;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en obtenerContratacion", ex);
            return null;
        }
    }

    public int agregarContratacion(ContratacionesBean c) {
        String sql = "INSERT INTO Contrataciones " +
                "(idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, c.getDepartamento().getIdDepartamento());
            ps.setInt(2, c.getEmpleado().getIdEmpleado());
            ps.setInt(3, c.getCargo().getIdCargo());
            ps.setInt(4, c.getTipoContratacion().getIdTipoContratacion());

            if (c.getFechaContratacion() != null) {
                ps.setDate(5, new Date(c.getFechaContratacion().getTime())); // util.Date -> sql.Date
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setDouble(6, c.getSalario());
            ps.setBoolean(7, c.isEstado());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en agregarContratacion", ex);
            return 0;
        }
    }

    public int modificarContratacion(ContratacionesBean c) {
        String sql = "UPDATE Contrataciones SET " +
                "idDepartamento=?, idEmpleado=?, idCargo=?, idTipoContratacion=?, " +
                "fechaContratacion=?, salario=?, estado=? " +
                "WHERE idContratacion=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, c.getDepartamento().getIdDepartamento());
            ps.setInt(2, c.getEmpleado().getIdEmpleado());
            ps.setInt(3, c.getCargo().getIdCargo());
            ps.setInt(4, c.getTipoContratacion().getIdTipoContratacion());

            if (c.getFechaContratacion() != null) {
                ps.setDate(5, new Date(c.getFechaContratacion().getTime()));
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setDouble(6, c.getSalario());
            ps.setBoolean(7, c.isEstado());
            ps.setInt(8, c.getIdContratacion());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en modificarContratacion", ex);
            return 0;
        }
    }

    public int cambiarEstado(int idContratacion, boolean estado) {
        String sql = "UPDATE Contrataciones SET estado=? WHERE idContratacion=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setBoolean(1, estado);
            ps.setInt(2, idContratacion);
            return ps.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en cambiarEstado", ex);
            return 0;
        }
    }
}
