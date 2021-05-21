package courseallocationsystem.codegenerator.tree;

import courseallocationsystem.codegenerator.CodeGenerator;
import courseallocationsystem.edd.BTreeNode;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Horario;

/**
 *
 * @date 21/05/2021
 * @time 08:48:37
 * @author asael
 */
public class BTreeGraphvizCodeGenerator extends CodeGenerator {

    private final BTree<Horario, Integer> tree;

    public BTreeGraphvizCodeGenerator(BTree<Horario, Integer> tree) {
        this.tree = tree;
    }
    
    @Override
    public String generate() {
        text = new StringBuilder();
        
        generateHeader();
        generateTree(tree.getRoot(), 0);
        addLine("}", 0);
        
        return text.toString();
    }

    private void generateHeader() {
        addLine("""
                digraph g {
                    node [shape = record,height=.1];""", 0);
    }
    
    public void generateTree(BTreeNode<Horario> currentNode, int contador) {
        StringBuilder temp = new StringBuilder();
        temp.append("node").append(contador).append("[label = \"");
        
        int i;
        for (i = 0; i < 4; i++) {
            temp.append("<f").append(i).append("> |");
            if (currentNode.getKey(i) != null) {
                temp.append(currentNode.getKey(i).getId());
            }
            temp.append(" |");
        }
        temp.append("<f").append(i).append(">\"];");
        addLine(temp.toString(), 1);

        for (int j = 0; j < 5; j++) {
            if (currentNode.getChild(j) != null) {
                generateTree(currentNode.getChild(j), j+1);
            }
        }
    }

}
