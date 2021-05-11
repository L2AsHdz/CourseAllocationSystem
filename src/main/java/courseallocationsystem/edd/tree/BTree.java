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

    /**
     * Si el nodo root tiene 4 claves divide el nodo root si no
     * envia el horario al metodo insertarKey
     * @param h -> Horario que se agregara en arbol b
     */
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

    /**
     * Si el nodo actual es hoja inserta el nodo de lo contrario
     * busca el indice correcto, verifica si el nodo hijo tiene 4 llaves,
     * si las tienen divide el nodo si no se llama a si mismo
     * con el nodo hijo como parametro.
     * Si el nodo actual queda con 5 claves se realiza una division.
     * @param root -> Nodo raiz
     * @param h -> Horario a agregar
     */
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

    /**
     * Inserta el horario en el lugar correcto ordenado de menor a mayor
     * @param currentNode -> Nodo en el cual se quiere ingresar el horario
     * @param h 
     */
    private void insercionOrdenada(BTreeNode currentNode, Horario h) {
        int indexNewKey = findChildOrIndex(currentNode, h.getId());

        for (int i = currentNode.getNumtKeys() - 1; i >= indexNewKey; i--) {
            currentNode.setKey(currentNode.getKey(i), i + 1);
        }

        currentNode.setKey(h, indexNewKey);

        currentNode.increaseNumKeys();
    }

    /**
     * Busca y retorna el indice correcto para un horario.
     * @param currentNode -> Nodo actual donde se buscara el indice
     * @param id -> Id del horario que se quiere agregar al nodo
     * @return -> Retorna el indice donde se debe agregar el horario (Aplica para array de llaves y arrays de hijos)
     */
    private int findChildOrIndex(BTreeNode currentNode, int id) {
        int indexChild = 0;
        while (currentNode.getKey(indexChild) != null && currentNode.getKey(indexChild).getId() < id) {
            indexChild++;
        }

        return indexChild;
    }

    /**
     * Valida si el dato que se quiere ingresar ya existe en el nodo.
     * @param currentNode -> Nodo actual
     * @param id -> Id del horario
     * @return 
     */
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

    /**
     * Divide el nodo hijo en dos y los agrega al nodo actual.
     * @param currentNode -> Nodo actual a donde se subira el dato sobrante
     * @param child -> Nodo hijo, es el que contiene llaves de mas
     * @param index -> Indice donde se ingreso el nuevo dato
     */
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

    /**
     * Realiza las divisiones necesarias para que el nodo actual no tenga
     * mas llaves de las permitidas.
     * @param currentNode -> Nodo actual donde hay mas llaves de las permitidas
     */
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

    /**
     * Dado un hijo devuelve el padre al que pertenece.
     * @param possibleParent -> Padre posible (Empieza desde el root)
     * @param child -> Nodo hijo
     * @return 
     */
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

    /**
     * Elimina un dato del arbol b.
     * @param currentNode -> Nodo actual
     * @param id -> Id del horario a eliminar del arbol
     */
    private void delete(BTreeNode currentNode, int id) {
        int indexKey = findIndexKey(currentNode, id);

        if (indexKey != -1) {
            if (currentNode.isLeaf()) {
                removeFromLeaf(currentNode, indexKey);
            } else {
                //TODO: Remover dato de nodo que no sea hoja
            }

            if (currentNode != root && currentNode.getNumtKeys() < 2) {
                checkMinKeys(currentNode);
            }
        } else {
            if (currentNode.isLeaf()) {
                System.out.println("Horario no existe en el arbol");
            } else {
                int indexChild = findChildOrIndex(currentNode, id);

                delete(currentNode.getChild(indexChild), id);
            }
        }
    }

    /**
     * Devuelve el indice que tiene el dato dentro del array de llaves.
     * @param currentNode -> Nodo actual
     * @param id -> Id del horario
     * @return -> Devuelve -1 si el nodo no contiene el horario buscado
     */
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

    /**
     * Elimina el horario de un nodo que es hoja.
     * @param currentNode -> Nodo hoja actual
     * @param index -> Indice donde se encuentra el horario
     */
    private void removeFromLeaf(BTreeNode currentNode, int index) {
        for (int i = index + 1; i <= currentNode.getNumtKeys(); i++) {
            currentNode.setKey(currentNode.getKey(i), i - 1);
        }
        currentNode.decreaseNumKeys();
    }

    /**
     * Realiza las operaciones necesarias para evitar que un nodo
     * tenga menos llaves de las requeridas.
     * @param currentNode -> Nodo actual que tiene menos de 2 llaves
     */
    private void checkMinKeys(BTreeNode currentNode) {
        BTreeNode parent = findParent(root, currentNode);
        int indexCurrentChild = getIndexChild(parent, currentNode);

        BTreeNode leftBrother;
        BTreeNode rightBrother;

        //Dependiendo del indice del hijo se realizaran las operaciones
        //de prestamo y union
        switch (indexCurrentChild) {
            
            //Si el indice es 0 solo tiene hermano derecho por ende
            //las operaciones se realizan con el hermano derecho
            case 0 -> {
                rightBrother = parent.getChild(indexCurrentChild + 1);

                //Si el hermano derecho tiene mas de 2 llaves toma una de ellas
                //si no realiza una union
                if (rightBrother != null && rightBrother.getNumtKeys() > 2) {
                    borrowFromNext(parent, currentNode, rightBrother, indexCurrentChild);
                } else {
                    merge(parent, currentNode, rightBrother, indexCurrentChild + 1, 1);
                }
            }
            
            //Si el indice es 5 solo tiene hermano izquierdo por ende las
            //operaciones solo se pueden realizar con el hermano izquierdo
            case 5 -> {
                leftBrother = parent.getChild(indexCurrentChild - 1);

                //Si el hermano izquierdo tiene mas de 2 llaves toma una de ellas
                //si no realiza una union
                if (leftBrother != null && leftBrother.getNumtKeys() > 2) {
                    borrowFromPrev(parent, currentNode, leftBrother, indexCurrentChild);
                } else {
                    merge(parent, currentNode, leftBrother, indexCurrentChild, 0);
                }
            }
            
            //Si el indice es cualquier otro las operaciones se pueden realizar
            //tanto con el hermano derecho como con el hermano izquierdo
            default -> {
                leftBrother = parent.getChild(indexCurrentChild - 1);
                rightBrother = parent.getChild(indexCurrentChild + 1);

                // Si cualquiera de los dos hermanos tiene mas de 2 llaves se
                //toma una de ellas, de lo contrario se realiza una union con
                //el hermano izquierdo.
                if (leftBrother != null && leftBrother.getNumtKeys() > 2) {
                    borrowFromPrev(parent, currentNode, leftBrother, indexCurrentChild);
                } else if (rightBrother != null && rightBrother.getNumtKeys() > 2) {
                    borrowFromNext(parent, currentNode, rightBrother, indexCurrentChild);
                    System.out.println("Balanceo realizado");
                } else {
                    merge(parent, currentNode, leftBrother, indexCurrentChild, 0);
                }
            }
        }

        //Despues de realizar las operaciones en el nodo hijo se valida que 
        //el nodo padre no quede con menos de 2 llaves
        if (parent != root && parent.getNumtKeys() < 2) {
            System.out.println("Balance recursivo");
            checkMinKeys(parent);
        }
    }

    /**
     * Devuelve el indice del nodo hijo
     * @param parent -> Nodo padre
     * @param child -> Nodo hijo
     * @return -> Indice del nodo hijo en el array de hijos del padre
     */
    private int getIndexChild(BTreeNode parent, BTreeNode child) {
        for (int i = 0; i < 6; i++) {
            if (parent.getChild(i) == child) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Toma prestado el primer elemento del nodo siguiente.
     * @param parent -> Nodo padre
     * @param currentNode -> nodo actual donde hay menos de 2 llaves
     * @param rightBrother -> hermano derecho de donde se tomara una llave
     * @param indexCurrentNode -> Indice del nodo actual
     */
    private void borrowFromNext(BTreeNode parent, BTreeNode currentNode, BTreeNode rightBrother, int indexCurrentNode) {
        //Se mueve el dato del padre al nodo actual, se mueve el primer dato
        //del hijo derecho al padre
        currentNode.setKey(parent.getKey(indexCurrentNode), 1);
        currentNode.increaseNumKeys();
        parent.setKey(rightBrother.getKey(0), indexCurrentNode);

        //Si no es hoja tambien se mueven los punteros a los hijos
        if (!currentNode.isLeaf()) {
            currentNode.setChild(rightBrother.getChild(0), 2);
            
            for (int i = 0; i < 3; i++) {
                rightBrother.setChild(rightBrother.getChild(i + 1), i);
            }
            rightBrother.setChild(null, 3);
        }
        
        removeFromLeaf(rightBrother, 0);
    }

    private void borrowFromPrev(BTreeNode parent, BTreeNode currentNode, BTreeNode leftBrother, int indexCurrentNode) {
        //Se mueve el dato del padre al nodo actual, se mueve el ultimo dato
        //del hermano izquierdo al nodo padre
        insercionOrdenada(currentNode, parent.getKey(indexCurrentNode - 1));
        parent.setKey(leftBrother.getKey(leftBrother.getNumtKeys() - 1), indexCurrentNode - 1);

        //Si no es hoja tambien se mueven los punteros a los hijos
        if (!currentNode.isLeaf()) {
            for (int i = 1; i >= 0; i--) {
                currentNode.setChild(currentNode.getChild(i), i + 1);
            }
            
            currentNode.setChild(leftBrother.getChild(leftBrother.getNumtKeys()), 0);
            leftBrother.setChild(null, leftBrother.getNumtKeys());
        }
        
        removeFromLeaf(leftBrother, leftBrother.getNumtKeys() - 1);
    }

    /**
     * Une dos nodos.
     * @param parent -> Padre del nodo actual
     * @param currentNode -> Nodo en el cual las llaves son menores a dos
     * @param sibling -> Hermano del nodo actual
     * @param indexCurrentNode -> Indice del nodo actual en el padre
     * @param type -> 0 si es hermano izquierdo y 1 si es hermano derecho
     */
    private void merge(BTreeNode parent, BTreeNode currentNode, BTreeNode sibling, int indexCurrentNode, int type) {
        //Se crea un nuevo nodo vacio
        BTreeNode mergedNode = new BTreeNode(currentNode.isLeaf());

        //Se insertan de manera ordenada los datos del nodo actual, el dato del padre
        //y los datos del hermano con el que se va a unir
        insercionOrdenada(mergedNode, currentNode.getKey(0));
        insercionOrdenada(mergedNode, parent.getKey(indexCurrentNode - 1));
        for (int i = 0; i < sibling.getNumtKeys(); i++) {
            insercionOrdenada(mergedNode, sibling.getKey(i));
        }
        
        //Se actualiza el puntero al nuevo nodo en el padre
        parent.setChild(mergedNode, indexCurrentNode - 1);

        //Se mueven las llaves para llenar el espacio que dejo el dato que
        //se bajo al hijo
        for (int i = indexCurrentNode - 1; i <= parent.getNumtKeys(); i++) {
            parent.setKey(parent.getKey(i + 1), i);
        }

        //Se actualizan los punteros a los hijos
        for (int i = indexCurrentNode; i <= parent.getNumtKeys(); i++) {
            parent.setChild(parent.getChild(i + 1), i);
        }

        parent.decreaseNumKeys();
        
        //Si es hoja tambien se copian los punteros de los hijos al
        //nuevo nodo que se creo
        if (!currentNode.isLeaf()) {
            if (type == 0) {
                for (int i = 0; i < 3; i++) {
                    mergedNode.setChild(sibling.getChild(i), i);
                }
                
                for (int i = 0; i < 2; i++) {
                    mergedNode.setChild(currentNode.getChild(i), i + 3);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    mergedNode.setChild(currentNode.getChild(i), i);
                }
                
                for (int i = 0; i < 3; i++) {
                    mergedNode.setChild(sibling.getChild(i), i + 2);
                }
            }
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
