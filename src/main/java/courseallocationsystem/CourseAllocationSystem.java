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
        horario1.setCodCurso(8);
        Horario horario2 = new Horario();
        horario2.setCodCurso(13);
        Horario horario3 = new Horario();
        horario3.setCodCurso(25);
        Horario horario4 = new Horario();
        horario4.setCodCurso(15);
        
        arbolB.add(horario1);
        arbolB.add(horario2);
        arbolB.add(horario3);
        arbolB.add(horario4);
        arbolB.printTree();
    }
}
