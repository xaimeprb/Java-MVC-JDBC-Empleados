package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de crear una única conexión a la BBDD
 * @author xaime
 * @since 24/10/2025
 */
public class JDBCSingleton {
    
    private static JDBCSingleton instance;
    private Connection con;
    private final String URL = "jdbc:mysql://localhost:3306/bd_departamento";
    private final String USER = "root";
    private final String PASSWORD = "mysql";
    
    private JDBCSingleton() throws SQLException{
        
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
    }
    
    public static synchronized JDBCSingleton getInstance() throws SQLException {
        
        if (instance == null) {
            
            instance = new JDBCSingleton();
            
        }
        
        return instance;
        
    }
    
    public Connection getConnection() {
        
        return con;
        
    }
    
}
