package courseallocationsystem.model;

import courseallocationsystem.edd.list.CircularList;

/**
 *
 * @date 29/04/2021
 * @time 04:49:30
 * @author asael
 */
public class Horario extends Entidad<Integer> {
    
    private String periodo;
    private String dia;
    private Integer codCurso;
    private Integer codSalon;
    private String codEdificio;
    private Integer idCatedratico;
    private CircularList<Asignacion, Integer> asignaciones;

    public Horario() {
    }

    public Horario(Integer id) {
        super(id);
    }

    public Horario(String periodo, String dia, int codCurso, int codSalon, String codEdificio, int idCatedratico, int id) {
        super(id);
        this.periodo = periodo;
        this.dia = dia;
        this.codCurso = codCurso;
        this.codSalon = codSalon;
        this.codEdificio = codEdificio;
        this.idCatedratico = idCatedratico;
        asignaciones = new CircularList();
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

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodSalon() {
        return codSalon;
    }

    public void setCodSalon(Integer codSalon) {
        this.codSalon = codSalon;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public Integer getIdCatedratico() {
        return idCatedratico;
    }

    public void setIdCatedratico(Integer idCatedratico) {
        this.idCatedratico = idCatedratico;
    }

    public CircularList<Asignacion, Integer> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(CircularList<Asignacion, Integer> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String[] toArray() {
        return new String[]{super.getId().toString(), periodo, dia, codCurso.toString(),
        codSalon.toString(), codEdificio, idCatedratico.toString()};
    }
}
