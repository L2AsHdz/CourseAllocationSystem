package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:46:07
 * @author asael
 */
public class Salon extends Entidad<Integer> {
    
    private int cantEstudiantes;
    private String edificio;

    public Salon() {
    }

    public Salon(int cantEstudiantes, String edificio, Integer id) {
        super(id);
        this.cantEstudiantes = cantEstudiantes;
        this.edificio = edificio;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
}
