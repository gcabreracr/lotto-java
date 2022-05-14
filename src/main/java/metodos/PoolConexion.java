package metodos;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Variables;
import static modelo.Variables.IP_DB;
import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexion {

    private static PoolConexion dataSource;
    private BasicDataSource bds = null;

    // Conexion acceso remoto
    private final String DB_NAME = Variables.DB_NAME;
    private final String DB_USER = "gcabrera";
    private final String DB_PASS = "Gca$2323";
    private final String URL = IP_DB + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private PoolConexion() {
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUsername(DB_USER);
        bds.setPassword(DB_PASS);
        bds.setUrl(URL);
        bds.setValidationQuery("select 1");

    }

    public static PoolConexion getInstance() {

        if (dataSource == null) {
            dataSource = new PoolConexion();
        }

        return dataSource;
    }

    public Connection getConnection() throws SQLException {

        return bds.getConnection();

    }

    public static void showDownInstance() {
        
        dataSource = null;
        
    }

}
