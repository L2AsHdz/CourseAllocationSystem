package courseallocationsystem.edd.tree;

import courseallocationsystem.edd.TreeNode;
import courseallocationsystem.model.Entidad;

/**
 *
 * @date 6/04/2021
 * @time 13:40:48
 * @author asael
 */
public class ArbolAVL {

    private TreeNode<Entidad> root;
    
    private TreeNode<Entidad> rightRotation(TreeNode<Entidad> oldRoot) {
        TreeNode<Entidad> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);

        return newRoot;
    }

    private TreeNode<Entidad> leftRotation(TreeNode<Entidad> oldRoot) {
        TreeNode<Entidad> newRoot = oldRoot.getRight();
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);

        return newRoot;
    }

    private TreeNode<Entidad> rightDoubleRotation(TreeNode<Entidad> oldRoot) {
        TreeNode<Entidad> newRoot;
        oldRoot.setLeft(leftRotation(oldRoot.getLeft()));
        newRoot = rightRotation(oldRoot);

        return newRoot;

    }

    private TreeNode<Entidad> leftDoubleRotation(TreeNode<Entidad> oldRoot) {
        TreeNode<Entidad> newRoot;
        oldRoot.setRight(rightRotation(oldRoot.getRight()));
        newRoot = leftRotation(oldRoot);

        return newRoot;
    }

    public void inOrden(TreeNode<Entidad> root) {
        if (root != null) {
            inOrden(root.getLeft());
            System.out.print(root.getDato().getId() + ", ");
            inOrden(root.getRight());
        }
    }

    public void preOrden(TreeNode<Entidad> root) {
        if (root != null) {
            System.out.print(root.getDato().getId() + ", ");
            preOrden(root.getLeft());
            preOrden(root.getRight());
        }
    }

    public void postOrden(TreeNode<Entidad> root) {
        if (root != null) {
            postOrden(root.getLeft());
            postOrden(root.getRight());
            System.out.print(root.getDato().getId() + ", ");
        }
    }

    public TreeNode<Entidad> getRaiz() {
        return root;
    }

    public int getBalanceFactor(TreeNode<Entidad> root) {
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

    private int getHeight(TreeNode<Entidad> root) {
        int Altder = ((root.getRight() == null) ? 0 : 1 + getHeight(root.getRight()));
        int Altizq = ((root.getLeft() == null) ? 0 : 1 + getHeight(root.getLeft()));
        return Math.max(Altder, Altizq);
    }/*

    private TreeNode<Entidad> insert(TreeNode<Entidad> nuevo, TreeNode<Entidad> root) {
        TreeNode<Entidad> newRoot = root;

        if (nuevo.getDato().getId() < root.getDato().getId()) {
            if (root.getLeft() == null) {
                root.setLeft(nuevo);
            } else {
                root.setLeft(insert(nuevo, root.getLeft()));

                if (getBalanceFactor(root) == -2) {
                    if (nuevo.getDato().getId() < root.getLeft().getDato().getId()) {
                        newRoot = rightRotation(root);
                    } else {
                        newRoot = rightDoubleRotation(root);
                    }
                }
            }
        } else if (nuevo.getDato().getId() > root.getDato().getId()) {
            if (root.getRight() == null) {
                root.setRight(nuevo);
            } else {
                root.setRight(insert(nuevo, root.getRight()));

                if (getBalanceFactor(root) == 2) {
                    if (nuevo.getDato().getId() > root.getRight().getDato().getId()) {
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

    public void add(Entidad o) {
        TreeNode<Entidad> nuevo = new TreeNode(o);

        if (root == null) {
            root = nuevo;
        } else {
            root = insert(nuevo, root);
        }
    }
    
    private TreeNode<Entidad> get(int id, TreeNode<Entidad> root) {
        
        if (root == null) {
            return null;
        } else if (root.getDato().getId() == id) {
            return root;
        } else if (id < root.getDato().getId()) {
            return get(id, root.getLeft());
        } else {
            return get(id, root.getRight());
        }
    }
    
    public Entidad get(int id) {
        return get(id, root).getDato();
    }
    
    private TreeNode<Entidad> remove(int id, TreeNode<Entidad> root) {
        TreeNode<Entidad> actual = root;
        
        if (actual == null) {
            return actual;
        }
        
        if (id < actual.getDato().getId()) {
            actual.setLeft(remove(id, actual.getLeft()));
        } else if (id > actual.getDato().getId()) {
            actual.setRight(remove(id, actual.getRight()));
        } else {
            
            if (actual.getLeft() == null | actual.getRight() == null) {
                TreeNode<Entidad> aux = null;
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
                TreeNode<Entidad> reemplazo = getReemplazo(actual.getLeft());
                actual.setDato(reemplazo.getDato());
                actual.setLeft(remove(reemplazo.getDato().getId(), actual.getLeft()));
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
    
    public Entidad remove(int id) {
        return remove(id, root).getDato();
    }

    private TreeNode<Entidad> getReemplazo(TreeNode<Entidad> root) {
        TreeNode<Entidad> actual = root;
        
        while (actual.getRight()!= null) {
            actual = actual.getRight();
        }
        
        return actual;
    }*/
}
