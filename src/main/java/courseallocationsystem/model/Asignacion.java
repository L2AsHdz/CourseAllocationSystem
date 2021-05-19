package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:51:12
 * @author asael
 */
public class Asignacion extends Entidad<Integer> {

    private int codHorario;
    private float zona;
    private float notaFinal;

    public Asignacion() {
    }

    public Asignacion(int carnetEstudiante, int codHorario, float zona, float notaFinal) {
        super(carnetEstudiante);
        this.codHorario = codHorario;
        this.zona = zona;
        this.notaFinal = notaFinal;
    }
}
