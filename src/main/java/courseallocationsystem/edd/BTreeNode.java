package courseallocationsystem.edd;

import courseallocationsystem.model.Horario;

/**
 *
 * @date 6/05/2021
 * @time 22:24:23
 * @author asael
 */
public class BTreeNode {

    private int numKeys;
    private boolean isLeaf;
    private Horario[] keys;
    private BTreeNode[] childs;

    public BTreeNode() {
        this.childs = new BTreeNode[6];
        this.keys = new Horario[5];
        this.isLeaf = true;
        this.numKeys = 0;
    }
    
    public BTreeNode(boolean isLeaf) {
        this.childs = new BTreeNode[6];
        this.keys = new Horario[5];
        this.isLeaf = isLeaf;
        this.numKeys = 0;
    }

    public int getNumtKeys() {
        return numKeys;
    }

    public void setNumKeys(int cantKeys) {
        this.numKeys = cantKeys;
    }
    
    public void increaseNumKeys() {
        this.numKeys++;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Horario[] getKeys() {
        return keys;
    }

    public void setKeys(Horario[] keys) {
        this.keys = keys;
    }
    
    public Horario getKey(int i) {
        return keys[i];
    }
    
    public void setKey(Horario horario, int i) {
        this.keys[i] = horario;
    }

    public BTreeNode[] getChilds() {
        return childs;
    }

    public void setChilds(BTreeNode[] childs) {
        this.childs = childs;
    }
    
    public BTreeNode getChild(int i) {
        return childs[i];
    }
    
    public void setChild(BTreeNode child, int i) {
        childs[i] = child;
    }
}
