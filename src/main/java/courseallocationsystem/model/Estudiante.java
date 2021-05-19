package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:39:11
 * @author asael
 */
public class Estudiante extends Entidad<Integer> {
    
    private String nombre;
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(String nombre, String direccion, int id) {
        super(id);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
