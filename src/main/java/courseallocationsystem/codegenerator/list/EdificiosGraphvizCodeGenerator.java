package courseallocationsystem.codegenerator.list;

import courseallocationsystem.codegenerator.CodeGenerator;
import courseallocationsystem.edd.Nodo;
import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Salon;

/**
 *
 * @date 21/05/2021
 * @time 06:55:25
 * @author asael
 */
public class EdificiosGraphvizCodeGenerator extends CodeGenerator {

    private final CircularList<Edificio, String> edificios;

    public EdificiosGraphvizCodeGenerator(CircularList<Edificio, String> edificios) {
        this.edificios = edificios;
    }

    @Override
    public String generate() {
        text = new StringBuilder();

        generateHeader();
        generarNodosImagen();
        generarNodosCaps();
        generateRank();
        generarPointers();
        generarPointersCaps();
        addLine("}", 0);

        return text.toString();
    }

    private void generateHeader() {
        addLine("""
                digraph g {
                    node[shape=rect,width=1,height=.1];""", 0);
    }

    private void generarNodosImagen() {
        Nodo<Edificio> primero = edificios.getPrimero();
        Nodo<Edificio> actual = primero;

        if (actual == null) {
            System.out.println("Lista vacia");
        } else {
            do {
                String name = actual.getDato().getId();
                text.append("    ").append(name).append("[label = \"")
                        .append(name).append("\"];\n");
                actual = actual.getNext();
            } while (actual != primero);
        }
    }

    private void generarNodosCaps() {
        Nodo<Edificio> primero = edificios.getPrimero();
        Nodo<Edificio> actual = primero;

        if (actual != null) {
            do {
                Nodo<Salon> inicio = actual.getDato().getSalones().getInicio();
                Nodo<Salon> actualC = inicio;

                if (actualC != null) {

                    while (actualC != null) {
                        String idI = actual.getDato().getId();
                        int idC = actualC.getDato().getId();
                        String nameC = "cap" + idI + idC;
                        int nameCap = ((Salon) actualC.getDato()).getId();
                        text.append("    ").append(nameC).append("[label = \"")
                                .append(nameCap).append("\" ];\n");
                        actualC = actualC.getNext();
                    }
                }
                actual = actual.getNext();
            } while (actual != primero);
        }
    }

    private void generateRank() {
        Nodo<Edificio> primero = edificios.getPrimero();
        Nodo<Edificio> actual = primero;

        text.append("    {rank = same; ");
        if (actual != null) {
            do {
                String name = actual.getDato().getId();
                text.append(name).append("; ");

                actual = actual.getNext();
            } while (actual != primero);
        }
        text.append("}\n");
    }

    private void generarPointers() {
        Nodo<Edificio> primero = edificios.getPrimero();
        Nodo<Edificio> actual = primero;

        if (actual != null) {
            do {
                String name = actual.getDato().getId();
                String nameP = actual.getPrev().getDato().getId();
                String nameN = actual.getNext().getDato().getId();

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
    
    private void generarPointersCaps() {
        Nodo<Edificio> primero = edificios.getPrimero();
        Nodo<Edificio> actual = primero;

        if (actual != null) {
            do {
                Nodo<Salon> inicio = actual.getDato().getSalones().getInicio();
                Nodo<Salon> actualC = inicio;

                if (actualC != null) {
                    String name = actual.getDato().getId();
                    text.append("    ").append(name).append(" -> ");
                    while (actualC != null) {
                        String idI = actual.getDato().getId();
                        int idC = actualC.getDato().getId();
                        String nameC = "cap" + idI + idC;
                        text.append(nameC).append(" -> ");
                        
                        actualC = actualC.getNext();
                    }
                    text.deleteCharAt(text.lastIndexOf(">"));
                    text.deleteCharAt(text.lastIndexOf("-"));
                    text.append(";\n");
                }
                actual = actual.getNext();
            } while (actual != primero);
        }
    }
}
