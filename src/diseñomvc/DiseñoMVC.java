/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diseñomvc;
import diseñomvc.Conexion;
import java.sql.SQLException;

/**
 *
 * @author i5
 */
public class DiseñoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion con = new Conexion();
        try{
            con.getConnection();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
