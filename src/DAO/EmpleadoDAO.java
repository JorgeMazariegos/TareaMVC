/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Conexion.Conexion;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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
    
    public List<Empleado> consultar(){
        List<Empleado> lista = new ArrayList<>();
        query = "SELECT * FROM EMPLEADO";
        Empleado emp = null;
        try{
            cn = conexion.getConnection();
            ps = cn.prepareStatement(query);
            r = ps.executeQuery();
            
            while(r.next()){
                emp = new Empleado(r.getInt("id_emp"), r.getString("nombre"), r.getString("apellido"), r.getDouble("salario"), r.getBoolean("estatus"));
                lista.add(emp);
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public boolean agregar(Empleado emp){
        query = "INSERT INTO PUBLIC.EMPLEADO (NOMBRE, APELLIDO, SALARIO, ESTATUS) "+
                "VALUES (?,?,?,?)";
        boolean wasAdded=false;
        try{
            cn = conexion.getConnection();
            ps = cn.prepareStatement(query);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setDouble(3, emp.getSalario());
            ps.setBoolean(4, emp.isEstatus());
            int contador = ps.executeUpdate();
            if(contador==1){
                wasAdded = true;
            }
        cn.close();
        ps.close();   
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return wasAdded;
    }
    
    public boolean actualizar(Empleado emp){
        query = "UPDATE PUBLIC.EMPLEADO SET NOMBRE = ?, APELLIDO = ?, SALARIO ?, ESTATUS = ? "+
                "WHERE ID_EMP = ?";
        boolean wasAdded=false;
        try{
            cn = conexion.getConnection();
            ps = cn.prepareStatement(query);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setDouble(3, emp.getSalario());
            ps.setBoolean(4, emp.isEstatus());
            ps.setInt(5, emp.getId());
            System.out.println(ps.toString());
            int contador = ps.executeUpdate();       
            if(contador==1){
                wasAdded = true;
            }
            ps.close();
            cn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return wasAdded;
    }
}
