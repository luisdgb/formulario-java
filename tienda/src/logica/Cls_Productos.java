
package logica;
import conexion.Cls_conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class Cls_Productos {
    
    private final String SQL_INSERT = "INSERT INTO productos(pro_descripcion,pro_categoria,pro_cantidad,pro_costo,pro_precio,pro_estado)VALUES(?,?,?,?,?,?)";
    private PreparedStatement PS;
    private final Cls_conexion CN;
    
    public Cls_Productos(){
        PS = null;
        CN = new Cls_conexion();
    }
    
    public int insertDatos(String des, String cat, int can, float cos, float pre, String est){
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, des);
            PS.setString(2, cat);
            PS.setInt(3, can);
            PS.setFloat(4, cos);
            PS.setFloat(5, pre);
            PS.setString(6, est);
            int res = PS.executeUpdate();
            if (res > 0){
                JOptionPane.showMessageDialog(null,"Registros guardados..");
                
            }
            
        } catch (Exception e){
           System.err.println("Error al guardar los datos en la db: "+ e.getMessage());
            
        } finally{
            PS = null;
            CN.close();
            
        }
        return 0;
    }
}
