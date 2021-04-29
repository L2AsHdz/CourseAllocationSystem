package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:46:07
 * @author asael
 */
public class Salon extends Objeto {
    
    private int cantEstudiantes;

    public Salon() {
    }

    public Salon(int cantEstudiantes, int id) {
        super(id);
        this.cantEstudiantes = cantEstudiantes;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }
}
