package courseallocationsystem.edd.tree;

import courseallocationsystem.edd.BTreeNode;
import courseallocationsystem.model.Horario;

/**
 *
 * @date 6/05/2021
 * @time 22:38:12
 * @author asael
 */
public class BTree {

    private final BTreeNode root;

    public BTree() {
        root = new BTreeNode();
    }

    public void add(Horario h) {
        BTreeNode currentRoot = root;

        if (currentRoot.getKey(0) == null) {
            currentRoot.setKey(h, 0);
            currentRoot.increaseNumKeys();
        } else {
            add(root, h);
        }
    }

    private void add(BTreeNode root, Horario h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void add(BTreeNode currentRoot, Horario h, BTreeNode rightChild) {
        int indexNewKey = 0;

        while (currentRoot.getKey(indexNewKey).getId() < h.getId()) {
            indexNewKey++;
        }

        for (int i = currentRoot.getNumtKeys() - 1; i >= indexNewKey; i--) {
            currentRoot.setKey(currentRoot.getKey(i), i + 1);
        }
        
        for (int i = currentRoot.getNumChilds() - 1; i >= indexNewKey; i--) {
            
        }
    }

    public void printTree() {
        StringBuilder tree = new StringBuilder();
        tree.append("[");

        for (int i = 0; i < 4; i++) {
            if (root.getKey(i) != null) {
                tree.append(root.getKey(i).getCodCurso()).append("|");
            }
        }
        tree.append("]");
        System.out.println(tree.toString());
    }
}
