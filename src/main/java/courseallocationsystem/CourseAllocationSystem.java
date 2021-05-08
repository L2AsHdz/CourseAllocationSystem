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
        Horario horario1 = new Horario();
        horario1.setId(8);
        Horario horario2 = new Horario();
        horario2.setId(13);
        Horario horario3 = new Horario();
        horario3.setId(25);
        Horario horario4 = new Horario();
        horario4.setId(15);
        Horario horario5 = new Horario();
        horario5.setId(1);
        
        arbolB.add(horario1);
        arbolB.add(horario2);
        arbolB.add(horario3);
        arbolB.add(horario4);
        arbolB.add(horario5);
        arbolB.printTree();
    }
}
