package courseallocationsystem.model;

/**
 *
 * @date 29/04/2021
 * @time 04:49:30
 * @author asael
 */
public class Horario extends Objeto {
    
    private String periodo;
    private String dia;
    private int codCurso;
    private int codSalon;
    private int codEdificio;
    private int idCatedratico;

    public Horario() {
    }

    public Horario(String periodo, String dia, int codCurso, int codSalon, int codEdificio, int idCatedratico, int id) {
        super(id);
        this.periodo = periodo;
        this.dia = dia;
        this.codCurso = codCurso;
        this.codSalon = codSalon;
        this.codEdificio = codEdificio;
        this.idCatedratico = idCatedratico;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getCodSalon() {
        return codSalon;
    }

    public void setCodSalon(int codSalon) {
        this.codSalon = codSalon;
    }

    public int getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(int codEdificio) {
        this.codEdificio = codEdificio;
    }

    public int getIdCatedratico() {
        return idCatedratico;
    }

    public void setIdCatedratico(int idCatedratico) {
        this.idCatedratico = idCatedratico;
    }
}
