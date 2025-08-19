package db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static DataSource dataSource;

    static {
        try {
            // Buscar el DataSource registrado en Payara
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/hrDonBosco");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // Obtener conexión desde el pool de Payara
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Cerrar la conexión
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close(); // En pool, solo devuelve la conexión al pool
                System.out.println("Conexión devuelta al pool correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}