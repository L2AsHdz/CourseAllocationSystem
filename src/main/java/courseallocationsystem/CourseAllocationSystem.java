package courseallocationsystem;

import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Horario;

/**
 *
 * @date 6/05/2021
 * @time 23:30:15
 * @author asael
 */
public class CourseAllocationSystem {

    public static void main(String[] args) {
        BTree arbolB = new BTree();
        
        arbolB.add(new Horario(8));
        arbolB.add(new Horario(13));
        arbolB.add(new Horario(25));
        arbolB.add(new Horario(15));
        arbolB.add(new Horario(1));
        arbolB.add(new Horario(31));
        arbolB.add(new Horario(50));
        arbolB.add(new Horario(14));
        arbolB.add(new Horario(12));
        arbolB.add(new Horario(2));
        arbolB.add(new Horario(16));
        arbolB.add(new Horario(10));
        arbolB.add(new Horario(1));
        arbolB.printTree(arbolB.getRoot());
    }
}
