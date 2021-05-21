package courseallocationsystem.codegenerator.tree;

import courseallocationsystem.codegenerator.CodeGenerator;
import courseallocationsystem.edd.TreeNode;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 21/05/2021
 * @time 08:15:26
 * @author asael
 */
public class AVLTreeGraphvizCodeGenerator<T extends Entidad, I> extends CodeGenerator {

    private final ArbolAVL<T, I> tree;

    public AVLTreeGraphvizCodeGenerator(ArbolAVL<T, I> tree) {
        this.tree = tree;
    }    

    @Override
    public String generate() {
        text = new StringBuilder();

        generateHeader();
        generateNodos(tree.getRaiz());
        generarPointers(tree.getRaiz());
        addLine("}", 0);

        return text.toString();
    }

    private void generateHeader() {
        addLine("""
                digraph grafica{
                    rankdir=TB;
                    node [shape = record];""", 0);
    }

    private void generateNodos(TreeNode<T> root) {
        if (root != null) {
            String id = String.valueOf(root.getDato().getId());
            generateNodos(root.getLeft());
            text.append("    ").append(id);
            if (root.getLeft() == null && root.getRight() == null) {
                text.append("[ label =\"").append(id).append("\"];\n");
            } else {
                text.append("[ label =\"<C0>|").append(id)
                        .append("|<C1>\" ];\n");
            }
            generateNodos(root.getRight());
        }
    }

    private void generarPointers(TreeNode<T> root) {
        if (root != null) {
            String name = String.valueOf(root.getDato().getId());
            generarPointers(root.getLeft());
            if (root.getLeft() != null) {
                String nameL = String.valueOf(root.getLeft().getDato().getId());
                text.append("    ").append(name).append(":C0").append(" -> ")
                        .append(nameL).append(";\n");
            }
            if (root.getRight() != null) {
                String nameR = String.valueOf(root.getRight().getDato().getId());
                text.append("    ").append(name).append(":C1").append(" -> ")
                        .append(nameR).append(";\n");
            }
            generarPointers(root.getRight());
        }
    }

}
