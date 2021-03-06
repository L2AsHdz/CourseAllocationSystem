package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:44:20
 * @author asael
 */
public class Curso extends Entidad<Integer> {
    
    private String nombre;
    private Integer semestre;
    private Integer noCreditos;

    public Curso() {
    }

    public Curso(String nombre, int semestre, int noCreditos, int id) {
        super(id);
        this.nombre = nombre;
        this.semestre = semestre;
        this.noCreditos = noCreditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNoCreditos() {
        return noCreditos;
    }

    public void setNoCreditos(int noCreditos) {
        this.noCreditos = noCreditos;
    }

    @Override
    public String[] toArray() {
        return new String[]{super.getId().toString(), nombre, semestre.toString(), noCreditos.toString()};
    }
}
