package courseallocationsystem.edd.tree;

import courseallocationsystem.edd.BTreeNode;
import courseallocationsystem.model.Horario;
import java.util.Arrays;

/**
 *
 * @date 6/05/2021
 * @time 22:38:12
 * @author asael
 */
public class BTree {

    private BTreeNode root;

    public BTree() {
        root = new BTreeNode();
    }

    public void add(Horario h) {
        if (root.getNumtKeys() == 4) {
            BTreeNode newRoot = new BTreeNode(false);

            newRoot.setChild(root, 0);

            splitChild(newRoot, root, 0, h);

            this.root = newRoot;
        } else {
            insertarKey(root, h);
        }
    }

    private void insertarKey(BTreeNode root, Horario h) {
        BTreeNode currentNode = root;

        if (currentNode.isLeaf()) {
            if (!itsRepeated(currentNode, h)) {
                insercionOrdenada(currentNode, h);
            } else {
                System.out.println("Dato repetido");
            }
        } else {
            int indexChild = findChildOrIndex(currentNode, h);
            if (!itsRepeated(currentNode.getChild(indexChild), h)) {
                if (currentNode.getChild(indexChild).getNumtKeys() == 4) {
                    System.out.println("Dividiendo nodo");
                    splitChild(currentNode, currentNode.getChild(indexChild), indexChild, h);
                } else {
                    insertarKey(root.getChild(indexChild), h);
                }
            } else {
                System.out.println("Dato repetido");
            }
        }

    }

    private void insercionOrdenada(BTreeNode currentNode, Horario h) {
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

        for (int i = 0; i < 4; i++) {
            if (currentNode.getKey(i) != null) {
                if (currentNode.getKey(i).getId() == h.getId()) {
                    return true;
                }
            }
        }

        return false;
    }

    private void splitChild(BTreeNode currentNode, BTreeNode child, int index, Horario h) {
        insercionOrdenada(child, h);
        
        BTreeNode right = new BTreeNode(child.isLeaf());
        right.setNumKeys(2);

        //Mover elementos 3 y 4 de child a right
        right.setKeys(Arrays.copyOf(Arrays.copyOfRange(child.getKeys(), 3, 5), 5));
        child.setKey(null, 3);
        child.setKey(null, 4);
        //Si no es hoja copiar childs tambien
        if (!child.isLeaf()) {
            right.setChilds(Arrays.copyOf(Arrays.copyOfRange(child.getChilds(), 3, 6), 6));
        }
        child.setNumKeys(2);

        //Insertar child en current node
        for (int i = currentNode.getNumtKeys(); i >= index + 1; i--) {
            currentNode.setChild(currentNode.getChild(i), i + 1);
        }
        currentNode.setChild(right, index + 1);

        insercionOrdenada(currentNode, child.getKey(2));
        child.setKey(null, 2);

    }

    public void printTree(BTreeNode currentNode) {
        StringBuilder tree = new StringBuilder();
        tree.append("[");

        for (int i = 0; i < 4; i++) {
            if (currentNode.getKey(i) != null) {
                tree.append(currentNode.getKey(i).getId()).append("|");
            }
        }
        tree.append("]");
        System.out.println(tree.toString());

        for (int i = 0; i < 5; i++) {
            if (currentNode.getChild(i) != null) {
                System.out.print("Hijo " + i + ":");
                printTree(currentNode.getChild(i));
            }
        }
    }

    public BTreeNode getRoot() {
        return root;
    }

}
