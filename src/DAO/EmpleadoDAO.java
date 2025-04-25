/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Conexion.Conexion;
import Modelo.EmpleadoModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


/**
 *
 * @author Jorge Mazariegos
 */
public class EmpleadoDAO {
    private final Conexion conexion = new Conexion();
    Connection cn;
    ResultSet r;
    PreparedStatement ps;
    Statement stmt = null;
    String query = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public EmpleadoModelo consultar(){
        query = "SELECT * FROM EMPLEADO";
        EmpleadoModelo emp = null;
        try{
            cn = conexion.getConnection();
            ps = cn.prepareStatement(query);
            r = ps.executeQuery();
            
            while(r.next()){
                emp = new EmpleadoModelo(r.getInt("id_emp"), r.getString("nombre"), r.getString("apellido"), r.getDouble("salario"), r.getBoolean("estatus"));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return emp;
    }
    
    public void agregar(){
        query = "INSERT INTO PUBLIC.EMPLEADO (NOMBRE, APELLIDO, SALARIO, ESTATUS)";
        try{
            cn = conexion.getConnection();
            ps = cn.prepareStatement(query);
            int contador = ps.executeUpdate();
            if(contador==1){
                
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
