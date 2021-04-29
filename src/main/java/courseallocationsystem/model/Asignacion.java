package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:51:12
 * @author asael
 */
public class Asignacion extends Objeto {

    private int carnetEstudiante;
    private int codCurso;
    private float zona;
    private float notaFinal;

    public Asignacion() {
    }

    public Asignacion(int carnetEstudiante, int codCurso, float zona, float notaFinal, int id) {
        super(id);
        this.carnetEstudiante = carnetEstudiante;
        this.codCurso = codCurso;
        this.zona = zona;
        this.notaFinal = notaFinal;
    }

    public int getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(int carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public float getZona() {
        return zona;
    }

    public void setZona(float zona) {
        this.zona = zona;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }
}
