/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Empleado;
import DAO.EmpleadoDAO;
import java.util.List;

/**
 *
 * @author i5
 */
public class EmpleadoControlador {

    private final EmpleadoDAO dao = new EmpleadoDAO();
    
    public List<Empleado> getEmpleado(){
        return dao.consultar();
    }
    
    public boolean agregarEmpleado(String nombre, String apellido, Double salario, boolean estatus){
        Empleado emp = new Empleado(nombre, apellido, salario, estatus);
        return dao.agregar(emp);
    }
    
    public boolean actualizarEmpleado(int id, String nombre, String apellido, Double salario, boolean estatus){
        Empleado emp = new Empleado(id, nombre, apellido, salario, estatus);
        System.out.println(emp.getNombre());
        System.out.println(emp.getApellido());
        System.out.println(emp.getSalario());
        System.out.println(emp.isEstatus());
        System.out.println(emp.getId());
        return dao.actualizar(emp);
    }
}
