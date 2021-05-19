package courseallocationsystem.edd;

/**
 *
 * @param <T>
 * @date 6/05/2021
 * @time 22:24:23
 * @author asael
 */
public class BTreeNode<T> {

    private int numKeys;
    private boolean isLeaf;
    private T[] keys;
    private BTreeNode<T>[] childs;

    public BTreeNode() {
        this.childs = (BTreeNode<T>[]) new BTreeNode[6];
        this.keys = (T[]) new Object[5];
        this.isLeaf = true;
        this.numKeys = 0;
    }
    
    public BTreeNode(boolean isLeaf) {
        this.childs = (BTreeNode<T>[]) new BTreeNode[6];
        this.keys = (T[]) new Object[5];
        this.isLeaf = isLeaf;
        this.numKeys = 0;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int cantKeys) {
        this.numKeys = cantKeys;
    }
    
    public void increaseNumKeys() {
        this.numKeys++;
    }
    
    public void decreaseNumKeys() {
        this.numKeys--;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public T[] getKeys() {
        return keys;
    }

    public void setKeys(T[] keys) {
        this.keys = keys;
    }
    
    public T getKey(int i) {
        return keys[i];
    }
    
    public void setKey(T t, int i) {
        this.keys[i] = t;
    }

    public BTreeNode<T>[] getChilds() {
        return childs;
    }

    public void setChilds(BTreeNode<T>[] childs) {
        this.childs = childs;
    }
    
    public BTreeNode<T> getChild(int i) {
        return childs[i];
    }
    
    public void setChild(BTreeNode<T> child, int i) {
        childs[i] = child;
    }
}
