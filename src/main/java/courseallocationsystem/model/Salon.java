package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:46:07
 * @author asael
 */
public class Salon extends Entidad<Integer> {
    
    private Integer cantEstudiantes;
    private String edificio;

    public Salon() {
    }

    public Salon(int cantEstudiantes, String edificio, int id) {
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

    @Override
    public String[] toArray() {
        return new String[]{super.getId().toString(), edificio, cantEstudiantes.toString()};
    }
}
