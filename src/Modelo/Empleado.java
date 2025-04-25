package Modelo;

/**
 *
 * @author i5
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private Double salario;
    private boolean estatus;

    public Empleado(){
        
    }
    
    public Empleado(String nombre, String apellido, Double salario, boolean estatus){
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.estatus = estatus; 
    }
    
    public Empleado(int id, String nombre, String apellido, Double salario, boolean estatus) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
