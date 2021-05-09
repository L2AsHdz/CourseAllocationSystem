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
            this.root = splitNode(currentNode);
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
    
    private BTreeNode splitNode(BTreeNode currentNode) {
        BTreeNode left = new BTreeNode();
        BTreeNode right = new BTreeNode();
        
        left.setKeys(Arrays.copyOf(Arrays.copyOfRange(currentNode.getKeys(), 0, 2), 5));
        left.setChilds(Arrays.copyOf(Arrays.copyOfRange(currentNode.getChilds(), 0, 3), 6));
        right.setKeys(Arrays.copyOf(Arrays.copyOfRange(currentNode.getKeys(), 3, 5), 5));
        right.setChilds(Arrays.copyOf(Arrays.copyOfRange(currentNode.getChilds(), 3, 6), 6));
        
        BTreeNode temp = new BTreeNode();
        temp.setKey(currentNode.getKey(2), 0);
        temp.setChild(left, 0);
        temp.setChild(right, 1);
        
        
        return temp;
    }

    public void printTree(BTreeNode currentNode) {
        StringBuilder tree = new StringBuilder();
        tree.append("[");

        for (int i = 0; i < 5; i++) {
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
