package courseallocationsystem.analyzer;

import courseallocationsystem.analizadores.Lexer;
import courseallocationsystem.analizadores.Parser;
import courseallocationsystem.datos.Data;
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
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @date 20/05/2021
 * @time 16:09:33
 * @author asael
 */
public class InputFileAnalyzer {

    private final String inputText;
    private Lexer lexer;
    private final Data data;
    private Parser parser;

    public InputFileAnalyzer(String inputText) {
        this.inputText = inputText;
        data = Data.getData();
    }

    public void analyze() {
        try {
            StringReader reader = new StringReader(inputText);
            lexer = new Lexer(reader);
            parser = new Parser(lexer);
            parser.parse();
            setData();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public ArrayList<String> getMensajes() {
        return parser.getMensajes();
    }

    public ArrayList<String> getErrores() {
        return parser.getErrores();
    }

    public CircularList<Usuario, Integer> getUsuarios() {
        return parser.getUsuarios();
    }

    public CircularList<Edificio, String> getEdificios() {
        return parser.getEdificios();
    }

    public CircularList<Curso, Integer> getCursos() {
        return parser.getCursos();
    }

    public HashTable<Estudiante, Integer> getEstudiantes() {
        return parser.getEstudiantes();
    }

    public ArbolAVL<Catedratico, Integer> getCatedraticos() {
        return parser.getCatedraticos();
    }

    public BTree<Horario, Integer> getHorarios() {
        return parser.getHorarios();
    }

    private void setData() {
        if (parser.getErrores().isEmpty()) {
            data.setCatedraticos(parser.getCatedraticos());
            data.setCursos(parser.getCursos());
            data.setEdificios(parser.getEdificios());
            data.setEstudiantes(parser.getEstudiantes());
            data.setHorarios(parser.getHorarios());
            data.setUsuarios(parser.getUsuarios());
        }
    }
}
