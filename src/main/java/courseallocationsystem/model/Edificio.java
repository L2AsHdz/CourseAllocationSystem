package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:43:39
 * @author asael
 */
public class Edificio {

    private String nombre;

    public Edificio() {
    }

    public Edificio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
