package courseallocationsystem.datos;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.model.Curso;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Estudiante;
import courseallocationsystem.model.Horario;
import courseallocationsystem.model.Usuario;

/**
 *
 * @date 20/05/2021
 * @time 12:59:29
 * @author asael
 */
public class Data {

    private CircularList<Usuario, Integer> usuarios;
    private CircularList<Edificio, String> edificios;
    private CircularList<Curso, Integer> cursos;
    private HashTable<Estudiante, Integer> estudiantes;
    private ArbolAVL<Catedratico, Integer> catedraticos;
    private BTree<Horario, Integer> horarios;
    
    private static Data data = null;

    private Data() {
        this.horarios = new BTree();
        this.catedraticos = new ArbolAVL();
        this.estudiantes = new HashTable(37, 0.55f);
        this.cursos = new CircularList();
        this.edificios = new CircularList();
        this.usuarios = new CircularList();
        
        this.usuarios.add(new Usuario("admin", "123", "super", 00000));
        this.usuarios.add(new Usuario("admin", "123", "colaborador", 11111));
        this.usuarios.add(new Usuario("admin", "123", "estudiante", 22222));
    }
    
    public static Data getData() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    public CircularList<Usuario, Integer> getUsuarios() {
        return usuarios;
    }

    public CircularList<Edificio, String> getEdificios() {
        return edificios;
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

    public void setUsuarios(CircularList<Usuario, Integer> usuarios) {
        this.usuarios = usuarios;
    }

    public void setEdificios(CircularList<Edificio, String> edificios) {
        this.edificios = edificios;
    }

    public void setCursos(CircularList<Curso, Integer> cursos) {
        this.cursos = cursos;
    }

    public void setEstudiantes(HashTable<Estudiante, Integer> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setCatedraticos(ArbolAVL<Catedratico, Integer> catedraticos) {
        this.catedraticos = catedraticos;
    }

    public void setHorarios(BTree<Horario, Integer> horarios) {
        this.horarios = horarios;
    }
}
