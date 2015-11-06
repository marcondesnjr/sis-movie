package io.github.marcondesnjr.sismovie.dao.daobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class ConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/SisMovie";
    private static final String NOME = "postgres";
    private static final String SENHA = "123";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection(URL,NOME,SENHA);
        conn.setAutoCommit(false);
        return conn;
    }
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("objeto", new Object());
        map.get("objeto");
    }
    
}
