package courseallocationsystem.edd.tree;

import courseallocationsystem.comparator.IdentifierComparator;
import courseallocationsystem.edd.BTreeNode;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 6/05/2021
 * @time 22:38:12
 * @author asael
 */
public class BTree<T extends Entidad, I> {

    private final IdentifierComparator<I> comparator;
    
    private BTreeNode<T> root;

    public BTree() {
        root = new BTreeNode();
        comparator = new IdentifierComparator();
    }

    /**
     * Si el nodo root tiene 4 claves divide el nodo root si no
     * envia el horario al metodo insertarKey
     * @param t -> T que se agregara en arbol b
     */
    public void add(T t) {
        if (root.getNumKeys() == 4 && root.isLeaf()) {
            BTreeNode<T> newRoot = new BTreeNode(false);

            newRoot.setChild(root, 0);

            insercionOrdenada(root, t);
            splitChild(newRoot, root, 0);

            this.root = newRoot;
        } else {
            insertarKey(root, t);
        }
    }

    /**
     * Si el nodo actual es hoja inserta el nodo de lo contrario
     * busca el indice correcto, verifica si el nodo hijo tiene 4 llaves,
     * si las tienen divide el nodo si no se llama a si mismo
     * con el nodo hijo como parametro.
     * Si el nodo actual queda con 5 claves se realiza una division.
     * @param root -> Nodo raiz
     * @param t -> T a agregar
     */
    private void insertarKey(BTreeNode<T> root, T t) {
        BTreeNode<T> currentNode = root;

        if (currentNode.isLeaf()) {
            if (!itsRepeated(currentNode, (I)t.getId())) {
                insercionOrdenada(currentNode, t);
            } else {
                System.out.println("Dato repetido");
            }
        } else {
            int indexChild = findChildOrIndex(currentNode, (I)t.getId());
            if (!itsRepeated(currentNode.getChild(indexChild), (I)t.getId())) {
                BTreeNode<T> child = currentNode.getChild(indexChild);
                if (child.getNumKeys() == 4 && child.isLeaf()) {
                    insercionOrdenada(currentNode.getChild(indexChild), t);
                    splitChild(currentNode, currentNode.getChild(indexChild), indexChild);
                } else {
                    insertarKey(root.getChild(indexChild), t);
                }

                if (currentNode.getNumKeys() == 5) {
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
     * @param t 
     */
    private void insercionOrdenada(BTreeNode<T> currentNode, T t) {
        int indexNewKey = findChildOrIndex(currentNode, (I)t.getId());

        for (int i = currentNode.getNumKeys() - 1; i >= indexNewKey; i--) {
            currentNode.setKey(currentNode.getKey(i), i + 1);
        }

        currentNode.setKey(t, indexNewKey);

        currentNode.increaseNumKeys();
    }

    /**
     * Busca y retorna el indice correcto para un horario.
     * @param currentNode -> Nodo actual donde se buscara el indice
     * @param id -> Id del horario que se quiere agregar al nodo
     * @return -> Retorna el indice donde se debe agregar el horario (Aplica para array de llaves y arrays de hijos)
     */
    private int findChildOrIndex(BTreeNode<T> currentNode, I id) {
        int indexChild = 0;
        while (currentNode.getKey(indexChild) != null && comparator.compare(currentNode.getKey(indexChild), id) < 0) {
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
    private boolean itsRepeated(BTreeNode<T> currentNode, I id) {

        for (int i = 0; i < 5; i++) {
            if (currentNode.getKey(i) != null) {
                if (comparator.compare(currentNode.getKey(i), id) == 0) {
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
    private void splitChild(BTreeNode<T> currentNode, BTreeNode<T> child, int index) {
        BTreeNode<T> right = new BTreeNode(child.isLeaf());
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
        for (int i = currentNode.getNumKeys(); i >= index + 1; i--) {
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
    private void checkMaxKeys(BTreeNode<T> currentNode) {

        if (currentNode == this.root) {
            BTreeNode<T> newRoot = new BTreeNode(false);

            newRoot.setChild(root, 0);

            splitChild(newRoot, root, 0);

            this.root = newRoot;
        } else {
            BTreeNode<T> parent = findParent(root, currentNode);

            int indexMiddleKey = findChildOrIndex(parent, (I)currentNode.getKey(2).getId());
            splitChild(parent, currentNode, indexMiddleKey);

            if (parent.getNumKeys() == 5) {
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
    private BTreeNode<T> findParent(BTreeNode<T> possibleParent, BTreeNode<T> child) {
        BTreeNode<T> parent = null;
        for (int i = 0; i < 6; i++) {
            BTreeNode<T> tempChild = possibleParent.getChild(i);
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

    public T get(I id) {
        return (root == null) ? null : search(root, id);
    }

    private T search(BTreeNode<T> currentNode, I id) {
        T t = null;
        for (int i = 0; i < 5; i++) {
            T tempKey = currentNode.getKey(i);
            if (tempKey != null) {
                if (comparator.compare(tempKey, id) == 0) {
                    t = tempKey;
                }
            }
        }

        if (t == null) {
            int indexChild = findChildOrIndex(currentNode, id);
            t = search(currentNode.getChild(indexChild), id);
        }

        return t;
    }

    public void remove(I id) {
        delete(root, id);
    }

    /**
     * Elimina un dato del arbol b.
     * @param currentNode -> Nodo actual
     * @param id -> Id del horario a eliminar del arbol
     */
    private void delete(BTreeNode<T> currentNode, I id) {
        int indexKey = findIndexKey(currentNode, id);

        if (indexKey != -1) {
            if (currentNode.isLeaf()) {
                removeFromLeaf(currentNode, indexKey);
            } else {
                //TODO: Remover dato de nodo que no sea hoja
                removeFromNonLeaf(currentNode, indexKey);
            }

            if (currentNode != root && currentNode.getNumKeys() < 2) {
                checkMinKeys(currentNode);
            }
        } else {
            if (currentNode.isLeaf()) {
                System.out.println("No existe en el arbol");
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
    private int findIndexKey(BTreeNode<T> currentNode, I id) {
        for (int i = 0; i < 5; i++) {
            T tempKey = currentNode.getKey(i);
            if (tempKey != null) {
                if (comparator.compare(tempKey, id) == 0) {
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
    private void removeFromLeaf(BTreeNode<T> currentNode, int index) {
        for (int i = index + 1; i <= currentNode.getNumKeys(); i++) {
            currentNode.setKey(currentNode.getKey(i), i - 1);
        }
        currentNode.decreaseNumKeys();
    }
    
    private void removeFromNonLeaf(BTreeNode<T> currentNode, int index) {
        BTreeNode<T> rightmost = findRightmostNode(currentNode.getChild(index));
        
        currentNode.setKey(rightmost.getKey(rightmost.getNumKeys() - 1), index);
        removeFromLeaf(rightmost, rightmost.getNumKeys() - 1);
        
        if (rightmost.getNumKeys() < 2) {
            checkMinKeys(rightmost);
        }
    }
    
    private BTreeNode<T> findRightmostNode(BTreeNode<T> currentNode) {
        BTreeNode<T> node = currentNode;
        while (!node.isLeaf()) {
            node = node.getChild(node.getNumKeys());
        }
        return node;
    }

    /**
     * Realiza las operaciones necesarias para evitar que un nodo
     * tenga menos llaves de las requeridas.
     * @param currentNode -> Nodo actual que tiene menos de 2 llaves
     */
    private void checkMinKeys(BTreeNode<T> currentNode) {
        BTreeNode<T> parent = findParent(root, currentNode);
        int indexCurrentChild = getIndexChild(parent, currentNode);

        BTreeNode<T> leftBrother;
        BTreeNode<T> rightBrother;

        //Dependiendo del indice del hijo se realizaran las operaciones
        //de prestamo y union
        switch (indexCurrentChild) {
            
            //Si el indice es 0 solo tiene hermano derecho por ende
            //las operaciones se realizan con el hermano derecho
            case 0 -> {
                rightBrother = parent.getChild(indexCurrentChild + 1);

                //Si el hermano derecho tiene mas de 2 llaves toma una de ellas
                //si no realiza una union
                if (rightBrother != null && rightBrother.getNumKeys() > 2) {
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
                if (leftBrother != null && leftBrother.getNumKeys() > 2) {
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
                if (leftBrother != null && leftBrother.getNumKeys() > 2) {
                    borrowFromPrev(parent, currentNode, leftBrother, indexCurrentChild);
                } else if (rightBrother != null && rightBrother.getNumKeys() > 2) {
                    borrowFromNext(parent, currentNode, rightBrother, indexCurrentChild);
                } else {
                    merge(parent, currentNode, leftBrother, indexCurrentChild, 0);
                }
            }
        }

        //Despues de realizar las operaciones en el nodo hijo se valida que 
        //el nodo padre no quede con menos de 2 llaves
        if (parent != root && parent.getNumKeys() < 2) {
            checkMinKeys(parent);
        }
    }

    /**
     * Devuelve el indice del nodo hijo
     * @param parent -> Nodo padre
     * @param child -> Nodo hijo
     * @return -> Indice del nodo hijo en el array de hijos del padre
     */
    private int getIndexChild(BTreeNode<T> parent, BTreeNode<T> child) {
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
    private void borrowFromNext(BTreeNode<T> parent, BTreeNode<T> currentNode, BTreeNode<T> rightBrother, int indexCurrentNode) {
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

    private void borrowFromPrev(BTreeNode<T> parent, BTreeNode<T> currentNode, BTreeNode<T> leftBrother, int indexCurrentNode) {
        //Se mueve el dato del padre al nodo actual, se mueve el ultimo dato
        //del hermano izquierdo al nodo padre
        insercionOrdenada(currentNode, parent.getKey(indexCurrentNode - 1));
        parent.setKey(leftBrother.getKey(leftBrother.getNumKeys() - 1), indexCurrentNode - 1);

        //Si no es hoja tambien se mueven los punteros a los hijos
        if (!currentNode.isLeaf()) {
            for (int i = 1; i >= 0; i--) {
                currentNode.setChild(currentNode.getChild(i), i + 1);
            }
            
            currentNode.setChild(leftBrother.getChild(leftBrother.getNumKeys()), 0);
            leftBrother.setChild(null, leftBrother.getNumKeys());
        }
        
        removeFromLeaf(leftBrother, leftBrother.getNumKeys() - 1);
    }

    /**
     * Une dos nodos.
     * @param parent -> Padre del nodo actual
     * @param currentNode -> Nodo en el cual las llaves son menores a dos
     * @param sibling -> Hermano del nodo actual
     * @param indexCurrentNode -> Indice del nodo actual en el padre
     * @param type -> 0 si es hermano izquierdo y 1 si es hermano derecho
     */
    private void merge(BTreeNode<T> parent, BTreeNode<T> currentNode, BTreeNode<T> sibling, int indexCurrentNode, int type) {
        //Se crea un nuevo nodo vacio
        BTreeNode<T> mergedNode = new BTreeNode<T>(currentNode.isLeaf());

        //Se insertan de manera ordenada los datos del nodo actual, el dato del padre
        //y los datos del hermano con el que se va a unir
        insercionOrdenada(mergedNode, currentNode.getKey(0));
        insercionOrdenada(mergedNode, parent.getKey(indexCurrentNode - 1));
        for (int i = 0; i < sibling.getNumKeys(); i++) {
            insercionOrdenada(mergedNode, sibling.getKey(i));
        }
        
        //Se actualiza el puntero al nuevo nodo en el padre
        parent.setChild(mergedNode, indexCurrentNode - 1);

        //Se mueven las llaves para llenar el espacio que dejo el dato que
        //se bajo al hijo
        for (int i = indexCurrentNode - 1; i <= parent.getNumKeys(); i++) {
            parent.setKey(parent.getKey(i + 1), i);
        }

        //Se actualizan los punteros a los hijos
        for (int i = indexCurrentNode; i <= parent.getNumKeys(); i++) {
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

    public void printTree(BTreeNode<T> currentNode, int contador) {
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

    private void traverse(BTreeNode<T> currentNode) {
        int i;
        for (i = 0; i < currentNode.getNumKeys(); i++) {
            if (!currentNode.isLeaf()) {
                traverse(currentNode.getChild(i));
            }
            System.out.printf(" %d", currentNode.getKey(i).getId());
        }

        if (!currentNode.isLeaf()) {
            traverse(currentNode.getChild(i));
        }
    }

    public BTreeNode<T> getRoot() {
        return root;
    }

}
