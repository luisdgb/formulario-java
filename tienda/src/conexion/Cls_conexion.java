
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class Cls_conexion {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/tienda?autoReconnect=true&useSSL=false";
    private Connection CN;
    
    public Cls_conexion(){
        CN = null;
    
}
    public Connection getConnection(){
            
            try {
                Class .forName(DRIVER);
                CN = DriverManager.getConnection(URL, USER, PASSWORD);
            }catch (ClassNotFoundException | SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                
            }
        return CN;
  
    
}
    
    public void close(){
        try{
            CN.close();
        }catch  (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error cerrar la conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}