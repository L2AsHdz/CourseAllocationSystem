package courseallocationsystem;

import static controller.FileController.readFile;
import courseallocationsystem.analizadores.Lexer;
import courseallocationsystem.analizadores.Parser;
import courseallocationsystem.controller.LoginController;
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
import courseallocationsystem.view.LoginView;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @date 6/05/2021
 * @time 23:30:15
 * @author asael
 */
public class CourseAllocationSystem {

    public static void main(String[] args) {
        CircularList<Usuario, Integer> users = new CircularList();
        users.add(new Usuario("admin", "123", "super", 11111));
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view, users);
        
        controller.iniciar();
    }
    
    public void readEntradaTest() {
        String entrada = readFile("entrada.txt");
        StringReader reader = new StringReader(entrada);
        Lexer lexer = null;
        Parser parser = null;

        try {
            lexer = new Lexer(reader);
            parser = new Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        ArrayList<String> errores = parser.getErrores();

        if (errores.isEmpty()) {
            CircularList<Usuario, Integer> users = parser.getUsuarios();
            CircularList<Edificio, String> edificios = parser.getEdificios();
            List<Salon, String> salones = parser.getSalones();
            CircularList<Curso, Integer> cursos = parser.getCursos();
            HashTable<Estudiante, Integer> estudiantes = parser.getEstudiantes();
            ArbolAVL<Catedratico, Integer> catedraticos = parser.getCatedraticos();
            BTree<Horario, Integer> horarios = parser.getHorarios();
            CircularList<Asignacion, String> asignaciones = parser.getAsignaciones();
            System.out.println("\nUsuarios");
            users.show();
            System.out.println("\nEdificios");
            edificios.show();
            System.out.println("\nSalones");
            salones.show();
            System.out.println("\n\nCursos");
            cursos.show();
            System.out.println("\nEstudiantes");
            estudiantes.print();
            System.out.println("\nCatedraticos");
            catedraticos.printTree(catedraticos.getRaiz(), 0);
            System.out.println("\nHorarios");
            horarios.printTree(horarios.getRoot(), 0);
            System.out.println("\nAsignaciones");
            asignaciones.show();
        } else {
            errores.forEach(e -> System.out.println(e));
        }
    }

    private static void bTreeTest() {
        BTree<Horario, Integer> arbolB = new BTree();

        arbolB.add(new Horario(50));
        arbolB.add(new Horario(100));
        arbolB.add(new Horario(150));
        arbolB.add(new Horario(200));
        arbolB.add(new Horario(250));

        arbolB.add(new Horario(25));
        arbolB.add(new Horario(75));
        arbolB.add(new Horario(125));

        arbolB.add(new Horario(175));
        arbolB.add(new Horario(225));
        arbolB.add(new Horario(275));

        arbolB.add(new Horario(35));
        arbolB.add(new Horario(15));
        arbolB.add(new Horario(60));

        arbolB.add(new Horario(230));
        arbolB.add(new Horario(260));
        arbolB.add(new Horario(290));

        arbolB.add(new Horario(160));
        arbolB.add(new Horario(185));
        arbolB.add(new Horario(210));

        arbolB.add(new Horario(227));
        arbolB.add(new Horario(240));
        arbolB.add(new Horario(255));

        arbolB.add(new Horario(265));
        arbolB.add(new Horario(282));
        arbolB.add(new Horario(310));
        arbolB.add(new Horario(115));

        Horario horarioRecuperado = arbolB.get(265);

        System.out.println("Dato recuperado del arbol:  " + horarioRecuperado.getId());

        arbolB.remove(50);
        arbolB.add(new Horario(30));
        arbolB.remove(60);

        arbolB.add(new Horario(5));
        arbolB.add(new Horario(10));
        arbolB.add(new Horario(20));

        arbolB.add(new Horario(315));
        arbolB.add(new Horario(320));
        arbolB.add(new Horario(325));

        //Operaciones para probar merge con hermano izquierdo
        /*arbolB.remove(75);
        arbolB.remove(200);
        arbolB.remove(290);*/
        //Operaciones para probar merge con hermano derecho
        arbolB.remove(290);
        arbolB.remove(200);
        arbolB.remove(75);
        arbolB.add(new Horario(40));

        arbolB.remove(100);
        arbolB.remove(260);
        arbolB.remove(240);

        System.out.println("");
        arbolB.printTree(arbolB.getRoot(), 0);
        arbolB.showTree();
    }

    private static void listTest() {
        List<Usuario, Integer> listU = new List();

        listU.add(new Usuario("asael", "123", "estudiante", 201730192));
        listU.add(new Usuario("abner", "123", "estudiante", 201730191));

        listU.show();
        System.out.println();
        listU.sort();
        listU.show();
    }

    private static void circularListTest() {
        CircularList<Edificio, String> listE = new CircularList();

        listE.add(new Edificio("E1"));
        listE.add(new Edificio("T1"));
        listE.add(new Edificio("M1"));

        listE.show();
        System.out.println();
        listE.sort();
        listE.show();
    }

    private static void avlTreeTest() {
        ArbolAVL<Estudiante, Integer> arbol = new ArbolAVL();
        arbol.add(new Estudiante("asael", "aqui", 50));
        arbol.add(new Estudiante("asael", "aqui", 25));
        arbol.add(new Estudiante("asael", "aqui", 100));
        arbol.add(new Estudiante("asael", "aqui", 150));
        arbol.add(new Estudiante("asael", "aqui", 200));
        arbol.add(new Estudiante("asael", "aqui", 75));
        arbol.add(new Estudiante("asael", "aqui", 125));
        arbol.add(new Estudiante("asael", "aqui", 175));
        arbol.add(new Estudiante("asael", "aqui", 225));

        arbol.remove(100);
        arbol.remove(25);
        arbol.inOrden(arbol.getRaiz());
        System.out.println();
        arbol.printTree(arbol.getRaiz(), 0);
    }

    private static void hashTableTest() {
        HashTable<Horario, Integer> table = new HashTable(5, 0.60f);

        Scanner scan = new Scanner(System.in);

        String op = "1";
        while (!op.equals("0")) {
            System.out.println("1. para agregar, 2. para eliminar");
            op = scan.nextLine();
            switch (op) {
                case "1" -> {
                    op = scan.nextLine();
                    table.add(new Horario(Integer.parseInt(op)));
                }

                case "2" -> {
                    op = scan.nextLine();
                    table.remove(Integer.parseInt(op));
                }
            }
            table.print();
        }
    }
}
