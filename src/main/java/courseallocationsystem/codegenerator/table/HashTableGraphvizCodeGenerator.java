package courseallocationsystem.codegenerator.table;

import courseallocationsystem.codegenerator.CodeGenerator;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 21/05/2021
 * @time 07:12:57
 * @author asael
 */
public class HashTableGraphvizCodeGenerator<T extends Entidad, I> extends CodeGenerator {

    private final HashTable<T, I> hashT;

    public HashTableGraphvizCodeGenerator(HashTable<T, I> hashT) {
        this.hashT = hashT;
    }

    @Override
    public String generate() {
        text = new StringBuilder();

        generateHead();
        generateIndices();
        generateNodes();
        generatePointers();
        addLine("}", 0);

        return text.toString();
    }

    private void generateHead() {
        addLine("""
                digraph G {
                    nodesep=.02;
                    rankdir=LR;
                    node [shape=record,width=.1,height=.1];""", 0);
    }

    private void generateIndices() {
        StringBuilder temp = new StringBuilder();
        temp.append("node0 [label = \"");

        for (int i = 0; i < hashT.getDatos().length; i++) {
            temp.append("<f").append(i).append("> ").append(i).append("|");
        }
        temp.deleteCharAt(temp.lastIndexOf("|"));
        temp.append("\",height=6,width=.5];");
        addLine(temp.toString(), 1);
        addLine("node [width = 1.5];", 1);
    }

    private void generateNodes() {
        StringBuilder temp;
        for (int i = 0; i < hashT.getDatos().length; i++) {
            temp = new StringBuilder();
            T d = (T) hashT.getDatos()[i];
            if (d != null) {
                temp.append("node").append(i + 1).append("[label = \"{<n>").append(d.getId()).append("}\"];");
                addLine(temp.toString(), 1);
            }
        }
    }

    private void generatePointers() {
        StringBuilder temp;
        for (int i = 0; i < hashT.getDatos().length; i++) {
            temp = new StringBuilder();
            T d = (T) hashT.getDatos()[i];
            if (d != null) {
                temp.append("node0:f").append(i).append(" -> node").append(i + 1).append(":n;");
                addLine(temp.toString(), 1);
            }
        }
    }

}
