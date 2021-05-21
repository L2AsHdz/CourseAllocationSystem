package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:51:12
 * @author asael
 */
public class Asignacion extends Entidad<Integer> {

    private Integer codHorario;
    private Float zona;
    private Float notaFinal;

    public Asignacion() {
    }

    public Asignacion(int carnetEstudiante, int codHorario, float zona, float notaFinal) {
        super(carnetEstudiante);
        this.codHorario = codHorario;
        this.zona = zona;
        this.notaFinal = notaFinal;
    }

    public int getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(int codHorario) {
        this.codHorario = codHorario;
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

    @Override
    public String[] toArray() {
        return new String[]{super.getId().toString(), codHorario.toString(), zona.toString(), notaFinal.toString()};
    }
}
