package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:26:38
 * @author asael
 */
public class Usuario extends Objeto {
    
    private String nombre;
    private String password;
    private String tipo;

    public Usuario() {
    }

    public Usuario(String nombre, String password, String tipo, int id) {
        super(id);
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
