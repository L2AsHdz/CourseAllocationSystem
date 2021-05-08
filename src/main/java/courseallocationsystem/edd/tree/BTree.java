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
        insertarKey(root, h);
    }

    private void insertarKey(BTreeNode root, Horario h) {
        BTreeNode currentNode = root;

        if (currentNode.isIsLeaf()) {
            if (!itsRepeated(currentNode, h)) {
                insercionOrdenada(currentNode, h, null);
            } else {
                System.out.println("Dato repetido");
            }
        } else {
            int indexChild = findChildOrIndex(currentNode, h);
            if (!itsRepeated(currentNode, h)) {
                insertarKey(currentNode.getChild(indexChild), h);
            } else {
                System.out.println("Dato repetido");
            }
        }

        if (currentNode.getNumtKeys() == 5) {
            //dividir();    ````````````````````````````````````````````````````````````````````````````
            System.out.println("dividir");
        }
    }

    private void insercionOrdenada(BTreeNode currentNode, Horario h, BTreeNode rightChild) {
        int indexNewKey = findChildOrIndex(currentNode, h);

        for (int i = currentNode.getNumtKeys() - 1; i >= indexNewKey; i--) {
            currentNode.setKey(currentNode.getKey(i), i + 1);
        }

        currentNode.setKey(h, indexNewKey);

        currentNode.increaseNumKeys();
    }

    private int findChildOrIndex(BTreeNode currentNode, Horario h) {
        int indexChild = 0;
        while (currentNode.getKey(indexChild) != null && currentNode.getKey(indexChild).getId() < h.getId()) {
            indexChild++;
        }

        return indexChild;
    }

    private boolean itsRepeated(BTreeNode currentNode, Horario h) {

        for (int i = 0; i < 5; i++) {
            if (currentNode.getKey(i) != null) {
                if (currentNode.getKey(i).getId() == h.getId()) {
                    return true;
                }
            }
        }

        return false;
    }

    public void printTree() {
        StringBuilder tree = new StringBuilder();
        tree.append("[");

        for (int i = 0; i < 5; i++) {
            if (root.getKey(i) != null) {
                tree.append(root.getKey(i).getId()).append("|");
            }
        }
        tree.append("]");
        System.out.println(tree.toString());
    }
}
