package courseallocationsystem.edd.tree;

import courseallocationsystem.comparator.IdentifierComparator;
import courseallocationsystem.edd.TreeNode;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 6/04/2021
 * @time 13:40:48
 * @author asael
 */
public class ArbolAVL<T extends Entidad, I> {
    
    IdentifierComparator<I> comparator;

    private TreeNode<T> root;

    public ArbolAVL() {
        comparator = new IdentifierComparator();
    }
    
    private TreeNode<T> rightRotation(TreeNode<T> oldRoot) {
        TreeNode<T> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);

        return newRoot;
    }

    private TreeNode<T> leftRotation(TreeNode<T> oldRoot) {
        TreeNode<T> newRoot = oldRoot.getRight();
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);

        return newRoot;
    }

    private TreeNode<T> rightDoubleRotation(TreeNode<T> oldRoot) {
        TreeNode<T> newRoot;
        oldRoot.setLeft(leftRotation(oldRoot.getLeft()));
        newRoot = rightRotation(oldRoot);

        return newRoot;

    }

    private TreeNode<T> leftDoubleRotation(TreeNode<T> oldRoot) {
        TreeNode<T> newRoot;
        oldRoot.setRight(rightRotation(oldRoot.getRight()));
        newRoot = leftRotation(oldRoot);

        return newRoot;
    }

    public void inOrden(TreeNode<T> root) {
        if (root != null) {
            inOrden(root.getLeft());
            System.out.print(root.getDato().getId() + ", ");
            inOrden(root.getRight());
        }
    }

    public void preOrden(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.getDato().getId() + ", ");
            preOrden(root.getLeft());
            preOrden(root.getRight());
        }
    }

    public void postOrden(TreeNode<T> root) {
        if (root != null) {
            postOrden(root.getLeft());
            postOrden(root.getRight());
            System.out.print(root.getDato().getId() + ", ");
        }
    }

    public TreeNode<T> getRaiz() {
        return root;
    }

    public int getBalanceFactor(TreeNode<T> root) {
        if (root == null) {
            return 0;
        } else if (root.getRight() == null & root.getLeft() != null) {
            return -(getHeight(root.getLeft()) + 1);
        } else if (root.getRight() != null & root.getLeft() == null) {
            return getHeight(root.getRight()) + 1;
        } else if (root.getRight() != null & root.getLeft() != null) {
            return getHeight(root.getRight()) - getHeight(root.getLeft());
        } else {
            return 0;
        }
    }

    private int getHeight(TreeNode<T> root) {
        int Altder = ((root.getRight() == null) ? 0 : 1 + getHeight(root.getRight()));
        int Altizq = ((root.getLeft() == null) ? 0 : 1 + getHeight(root.getLeft()));
        return Math.max(Altder, Altizq);
    }

    private TreeNode<T> insert(TreeNode<T> nuevo, TreeNode<T> root) {
        TreeNode<T> newRoot = root;

        if (comparator.compare(nuevo.getDato(), root.getDato()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(nuevo);
            } else {
                root.setLeft(insert(nuevo, root.getLeft()));

                if (getBalanceFactor(root) == -2) {
                    if (comparator.compare(nuevo.getDato(), root.getLeft().getDato()) < 0) {
                        newRoot = rightRotation(root);
                    } else {
                        newRoot = rightDoubleRotation(root);
                    }
                }
            }
        } else if (comparator.compare(nuevo.getDato(), root.getDato()) > 0) {
            if (root.getRight() == null) {
                root.setRight(nuevo);
            } else {
                root.setRight(insert(nuevo, root.getRight()));

                if (getBalanceFactor(root) == 2) {
                    if (comparator.compare(nuevo.getDato(), root.getRight().getDato()) > 0) {
                        newRoot = leftRotation(root);
                    } else {
                        newRoot = leftDoubleRotation(root);
                    }
                }
            }
        } else {
            return null;
        }

        return newRoot;
    }

    public void add(T o) {
        TreeNode<T> nuevo = new TreeNode(o);

        if (root == null) {
            root = nuevo;
        } else {
            root = insert(nuevo, root);
        }
    }
    
    private TreeNode<T> get(I id, TreeNode<T> root) {
        
        if (root == null) {
            return null;
        } else if (comparator.compare(root.getDato(), id) == 0) {
            return root;
        } else if (comparator.compare(root.getDato(), id) > 0) {
            return get(id, root.getLeft());
        } else {
            return get(id, root.getRight());
        }
    }
    
    public T get(I id) {
        return (root == null) ? null : get(id, root).getDato();
    }
    
    private TreeNode<T> remove(I id, TreeNode<T> root) {
        TreeNode<T> actual = root;
        
        if (actual == null) {
            return actual;
        }
        
        if (comparator.compare(actual.getDato(), id) > 0) {
            actual.setLeft(remove(id, actual.getLeft()));
        } else if (comparator.compare(actual.getDato(), id) < 0) {
            actual.setRight(remove(id, actual.getRight()));
        } else {
            
            if (actual.getLeft() == null | actual.getRight() == null) {
                TreeNode<T> aux = null;
                if (aux == actual.getLeft()) {
                    aux = actual.getRight();
                } else {
                    aux = actual.getLeft();
                }
                
                if (aux == null) {
                    actual = null;
                } else {
                    actual = aux;
                }
            } else {
                TreeNode<T> reemplazo = getReemplazo(actual.getLeft());
                actual.setDato(reemplazo.getDato());
                actual.setLeft(remove((I)reemplazo.getDato().getId(), actual.getLeft()));
            }
        }
        
        //eliminar este if
        if (actual == null) {
            return actual;
        }
        
        int balanceFactor = getBalanceFactor(actual);
        
        //cambiar por == 2
        if ((balanceFactor > 1) & (getBalanceFactor(actual.getLeft()) >= 0)) {
            return leftRotation(actual);
        } else if (balanceFactor < -1 & getBalanceFactor(actual.getRight()) <= 0) {
            return rightRotation(actual);
        } else if (balanceFactor > 1 & getBalanceFactor(actual.getLeft())  < 0) {
            return leftDoubleRotation(actual);
        } else if (balanceFactor < -1 & getBalanceFactor(actual.getRight()) > 0) {
            return rightDoubleRotation(actual);
        }
        
        return actual;
    }
    
    public T remove(I id) {
        return remove(id, root).getDato();
    }

    private TreeNode<T> getReemplazo(TreeNode<T> root) {
        TreeNode<T> actual = root;
        
        while (actual.getRight()!= null) {
            actual = actual.getRight();
        }
        
        return actual;
    }
    
    public void printTree(TreeNode<T> currentNode, I padre) {
        System.out.println(padre + "\t->" + currentNode.getDato().getId());
        
        if (currentNode.getLeft() != null) {
            printTree(currentNode.getLeft(), (I)currentNode.getDato().getId());
        }
        
        if (currentNode.getRight() != null) {
            printTree(currentNode.getRight(), (I)currentNode.getDato().getId());
        }
    }
}
