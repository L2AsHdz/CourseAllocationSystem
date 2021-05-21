package courseallocationsystem.codegenerator.list;

import courseallocationsystem.codegenerator.CodeGenerator;
import courseallocationsystem.edd.Nodo;
import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Entidad;


/**
 *
 * @param <T>
 * @date 12/04/2021
 * @time 04:04:40
 * @author asael
 */
public class CircularListGraphvizCodeGenerator<T extends Entidad, I> extends CodeGenerator {

    private CircularList<T, I> t;

    public CircularListGraphvizCodeGenerator(CircularList t) {
        this.t = t;
    }

    @Override
    public String generate() {
        text = new StringBuilder();

        generateHeader();
        generarNodosImagen();
        generateRank();
        generarPointers();
        addLine("}", 0);

        return text.toString();
    }

    private void generateHeader() {
        addLine("""
                digraph g {
                    node[shape=rect,width=1,height=.1];""", 0);
    }

    private void generarNodosImagen() {
        Nodo<T> primero = t.getPrimero();
        Nodo<T> actual = primero;

        if (actual == null) {
            System.out.println("Lista vacia");
        } else {
            do {
                String name = String.valueOf(actual.getDato().getId());
                text.append("    ").append(name).append("[label = \"")
                        .append(name).append("\"];\n");
                actual = actual.getNext();
            } while (actual != primero);
        }
    }

    private void generateRank() {
        Nodo<T> primero = t.getPrimero();
        Nodo<T> actual = primero;

        text.append("    {rank = same; ");
        if (actual != null) {
            do {
                String name = String.valueOf(actual.getDato().getId());
                text.append(name).append("; ");

                actual = actual.getNext();
            } while (actual != primero);
        }
        text.append("}\n");
    }

    private void generarPointers() {
        Nodo<T> primero = t.getPrimero();
        Nodo<T> actual = primero;

        if (actual != null) {
            do {
                String name = String.valueOf(actual.getDato().getId());
                String nameP = String.valueOf(actual.getPrev().getDato().getId());
                String nameN = String.valueOf(actual.getNext().getDato().getId());

                if (actual == primero) {
                    text.append("    ").append(name).append(" -> ")
                            .append(nameN).append(";\n");
                    text.append("    ").append(name).append(" -> ")
                            .append(nameP).append("[constraint=false]").append(";\n");
                } else {
                    text.append("    ").append(name).append(" -> ")
                            .append(nameN).append(";\n");
                    text.append("    ").append(name).append(" -> ")
                            .append(nameP).append(";\n");
                }

                actual = actual.getNext();
            } while (actual != primero);
        }
    }
}
