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

    private BTreeNode root;

    public BTree() {
        root = new BTreeNode();
    }

    public void add(Horario h) {
        if (root.getNumtKeys() == 4 && root.isLeaf()) {
            BTreeNode newRoot = new BTreeNode(false);

            newRoot.setChild(root, 0);

            insercionOrdenada(root, h);
            splitChild(newRoot, root, 0);

            this.root = newRoot;
        } else {
            insertarKey(root, h);
        }
    }

    private void insertarKey(BTreeNode root, Horario h) {
        BTreeNode currentNode = root;

        if (currentNode.isLeaf()) {
            if (!itsRepeated(currentNode, h.getId())) {
                insercionOrdenada(currentNode, h);
            } else {
                System.out.println("Dato repetido");
            }
        } else {
            int indexChild = findChildOrIndex(currentNode, h.getId());
            if (!itsRepeated(currentNode.getChild(indexChild), h.getId())) {
                BTreeNode child = currentNode.getChild(indexChild);
                if (child.getNumtKeys() == 4 && child.isLeaf()) {
                    System.out.println("Dividiendo nodo");
                    insercionOrdenada(currentNode.getChild(indexChild), h);
                    splitChild(currentNode, currentNode.getChild(indexChild), indexChild);
                } else {
                    insertarKey(root.getChild(indexChild), h);
                }

                if (currentNode.getNumtKeys() == 5) {
                    checkMaxKeys(currentNode);
                }
            } else {
                System.out.println("Dato repetido");
            }
        }
    }

    private void insercionOrdenada(BTreeNode currentNode, Horario h) {
        int indexNewKey = findChildOrIndex(currentNode, h.getId());

        for (int i = currentNode.getNumtKeys() - 1; i >= indexNewKey; i--) {
            currentNode.setKey(currentNode.getKey(i), i + 1);
        }

        currentNode.setKey(h, indexNewKey);

        currentNode.increaseNumKeys();
    }

    private int findChildOrIndex(BTreeNode currentNode, int id) {
        int indexChild = 0;
        while (currentNode.getKey(indexChild) != null && currentNode.getKey(indexChild).getId() < id) {
            indexChild++;
        }

        return indexChild;
    }

    private boolean itsRepeated(BTreeNode currentNode, int id) {

        for (int i = 0; i < 5; i++) {
            if (currentNode.getKey(i) != null) {
                if (currentNode.getKey(i).getId() == id) {
                    return true;
                }
            }
        }

        return false;
    }

    private void splitChild(BTreeNode currentNode, BTreeNode child, int index) {
        BTreeNode right = new BTreeNode(child.isLeaf());
        right.setNumKeys(2);

        //Mover elementos 3 y 4 de child a right
        for (int i = 3; i < 5; i++) {
            right.setKey(child.getKey(i), i - 3);
            child.setKey(null, i);
        }
        //Si no es hoja mover childs tambien
        if (!child.isLeaf()) {
            for (int i = 3; i < 6; i++) {
                right.setChild(child.getChild(i), i - 3);
                child.setChild(null, i);
            }
        }
        child.setNumKeys(2);

        //Insertar right en current node
        for (int i = currentNode.getNumtKeys(); i >= index + 1; i--) {
            currentNode.setChild(currentNode.getChild(i), i + 1);
        }
        currentNode.setChild(right, index + 1);

        //Insertar dato medio de hijo en current node
        insercionOrdenada(currentNode, child.getKey(2));
        child.setKey(null, 2);
    }

    private void checkMaxKeys(BTreeNode currentNode) {

        if (currentNode == this.root) {
            BTreeNode newRoot = new BTreeNode(false);

            newRoot.setChild(root, 0);

            splitChild(newRoot, root, 0);

            this.root = newRoot;
            System.out.println("Se dividio el nodo root");
        } else {
            BTreeNode parent = findParent(root, currentNode);

            int indexMiddleKey = findChildOrIndex(parent, currentNode.getKey(2).getId());
            splitChild(parent, currentNode, indexMiddleKey);

            if (parent.getNumtKeys() == 5) {
                checkMaxKeys(parent);
            }
        }
    }

    private BTreeNode findParent(BTreeNode possibleParent, BTreeNode child) {
        BTreeNode parent = null;
        for (int i = 0; i < 6; i++) {
            BTreeNode tempChild = possibleParent.getChild(i);
            if (possibleParent.getChild(i) == child) {
                parent = possibleParent;
            }
            if (tempChild != null) {
                if (parent == null) {
                    parent = findParent(possibleParent.getChild(i), child);
                }
            }
        }
        return parent;
    }

    public Horario get(int id) {
        return (root == null) ? null : search(root, id);
    }

    private Horario search(BTreeNode currentNode, int id) {
        Horario horario = null;
        for (int i = 0; i < 5; i++) {
            Horario tempKey = currentNode.getKey(i);
            if (tempKey != null) {
                if (tempKey.getId() == id) {
                    horario = tempKey;
                }
            }
        }

        if (horario == null) {
            int indexChild = findChildOrIndex(currentNode, id);
            horario = search(currentNode.getChild(indexChild), id);
        }

        return horario;
    }

    public void remove(int id) {
        delete(root, id);
    }

    private void delete(BTreeNode currentNode, int id) {
        int indexKey = findIndexKey(currentNode, id);

        if (indexKey != -1) {
            if (currentNode.isLeaf()) {
                removeFromLeaf(currentNode, indexKey);
            } else {
                //remover de nodo que no es hoja
            }

            checkMinKeys(currentNode);
        } else {
            if (currentNode.isLeaf()) {
                System.out.println("Horario no existe en el arbol");
            } else {
                int indexChild = findChildOrIndex(currentNode, id);

                delete(currentNode.getChild(indexChild), id);
            }
        }
    }

    private int findIndexKey(BTreeNode currentNode, int id) {
        for (int i = 0; i < 5; i++) {
            Horario tempKey = currentNode.getKey(i);
            if (tempKey != null) {
                if (tempKey.getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void removeFromLeaf(BTreeNode currentNode, int index) {
        for (int i = index + 1; i <= currentNode.getNumtKeys(); i++) {
            currentNode.setKey(currentNode.getKey(i), i - 1);
        }
        currentNode.decreaseNumKeys();
    }

    private void checkMinKeys(BTreeNode currentNode) {
        if (currentNode.getNumtKeys() < 2) {
            BTreeNode parent = findParent(root, currentNode);
            int indexCurrentChild = getIndexChild(parent, currentNode);

            BTreeNode leftBrother;
            BTreeNode rightBrother;

            switch (indexCurrentChild) {
                case 0 -> {
                    rightBrother = parent.getChild(indexCurrentChild + 1);

                    if (rightBrother != null && rightBrother.getNumtKeys() > 2) {
                        borrowFromNext(parent, currentNode, rightBrother);
                    } else {
                        //Unir con hijo derecho
                    }
                }
                case 5 -> {
                    leftBrother = parent.getChild(indexCurrentChild - 1);

                    if (leftBrother != null && leftBrother.getNumtKeys() > 2) {
                        //Prestar de hijo izquierdo
                    } else {
                        //Unir con hijo izquierdo
                    }
                }
                default -> {
                    leftBrother = parent.getChild(indexCurrentChild - 1);
                    rightBrother = parent.getChild(indexCurrentChild + 1);

                    if (leftBrother != null && leftBrother.getNumtKeys() > 2) {
                        //Prestar de izquierdo
                    } else if (rightBrother != null && rightBrother.getNumtKeys() > 2) {
                        borrowFromNext(parent, currentNode, rightBrother);
                        System.out.println("Balanceo realizado");
                    } else {
                        //Unir con hijo izquierdo
                    }

                    System.out.println("\n\n");
                    System.out.println("LeftBro:");
                    printTree(leftBrother, 0);
                    System.out.println("RightBro:");
                    printTree(rightBrother, 0);
                    System.out.println("\n\n");

                }
            }
        }
    }

    private int getIndexChild(BTreeNode parent, BTreeNode child) {
        for (int i = 0; i < 6; i++) {
            if (parent.getChild(i) == child) {
                return i;
            }
        }
        return -1;
    }

    private void borrowFromNext(BTreeNode parent, BTreeNode currentNode, BTreeNode rightBrother) {
        int indexCurrentNode = getIndexChild(parent, currentNode);

        currentNode.setKey(parent.getKey(indexCurrentNode), 1);
        currentNode.increaseNumKeys();
        parent.setKey(rightBrother.getKey(0), indexCurrentNode);
        delete(rightBrother, rightBrother.getKey(0).getId());
        
        if (currentNode.isLeaf()) {
            System.out.println("Mover punteros tambien");
        }
    }

    public void printTree(BTreeNode currentNode, int contador) {
        StringBuilder tree = new StringBuilder();
        tree.append(contador).append(" -> [");

        for (int i = 0; i < 5; i++) {
            if (currentNode.getKey(i) != null) {
                tree.append(currentNode.getKey(i).getId()).append("|");
            }
        }
        tree.append("]");
        System.out.println(tree.toString());

        contador++;
        for (int i = 0; i < 6; i++) {
            if (currentNode.getChild(i) != null) {
                System.out.print(i + "-");
                printTree(currentNode.getChild(i), contador);
            }
        }
    }

    public void showTree() {
        if (root != null) {
            traverse(root);
        }
    }

    private void traverse(BTreeNode currentNode) {
        int i;
        for (i = 0; i < currentNode.getNumtKeys(); i++) {
            if (!currentNode.isLeaf()) {
                traverse(currentNode.getChild(i));
            }
            System.out.printf(" %d", currentNode.getKey(i).getId());
        }

        if (!currentNode.isLeaf()) {
            traverse(currentNode.getChild(i));
        }
    }

    public BTreeNode getRoot() {
        return root;
    }

}
