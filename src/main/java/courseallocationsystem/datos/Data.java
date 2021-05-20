package courseallocationsystem.datos;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.list.List;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Asignacion;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.model.Curso;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Estudiante;
import courseallocationsystem.model.Horario;
import courseallocationsystem.model.Salon;
import courseallocationsystem.model.Usuario;

/**
 *
 * @date 20/05/2021
 * @time 12:59:29
 * @author asael
 */
public class Data {

    private final CircularList<Usuario, Integer> usuarios;
    private final CircularList<Edificio, String> edificios;
    private final List<Salon, String> salones;
    private final CircularList<Curso, Integer> cursos;
    private final HashTable<Estudiante, Integer> estudiantes;
    private final ArbolAVL<Catedratico, Integer> catedraticos;
    private final BTree<Horario, Integer> horarios;
    private final CircularList<Asignacion, String> asignaciones;

    public Data() {
        this.asignaciones = new CircularList();
        this.horarios = new BTree();
        this.catedraticos = new ArbolAVL();
        this.estudiantes = new HashTable(37, 0.55f);
        this.cursos = new CircularList();
        this.salones = new List();
        this.edificios = new CircularList();
        this.usuarios = new CircularList();
        
        this.usuarios.add(new Usuario("admin", "123", "super", 00000));
    }

    public CircularList<Usuario, Integer> getUsuarios() {
        return usuarios;
    }

    public CircularList<Edificio, String> getEdificios() {
        return edificios;
    }

    public List<Salon, String> getSalones() {
        return salones;
    }

    public CircularList<Curso, Integer> getCursos() {
        return cursos;
    }

    public HashTable<Estudiante, Integer> getEstudiantes() {
        return estudiantes;
    }

    public ArbolAVL<Catedratico, Integer> getCatedraticos() {
        return catedraticos;
    }

    public BTree<Horario, Integer> getHorarios() {
        return horarios;
    }

    public CircularList<Asignacion, String> getAsignaciones() {
        return asignaciones;
    }

}
