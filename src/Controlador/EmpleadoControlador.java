/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.EmpleadoModelo;
import DAO.EmpleadoDAO;

/**
 *
 * @author i5
 */
public class EmpleadoControlador {

    private final EmpleadoDAO dao = new EmpleadoDAO();
    
    public EmpleadoModelo getEmpleado(){
        return dao.consultar();
    }
    
}
