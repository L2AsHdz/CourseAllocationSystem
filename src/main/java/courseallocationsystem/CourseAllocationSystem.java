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
        
        arbolB.add(new Horario(50));
        arbolB.add(new Horario(100));
        arbolB.add(new Horario(150));
        arbolB.add(new Horario(200));
        arbolB.add(new Horario(250));
        
        arbolB.add(new Horario(25));
        arbolB.add(new Horario(75));
        arbolB.add(new Horario(125));

        arbolB.add(new Horario(175));
        arbolB.add(new Horario(225));
        arbolB.add(new Horario(275));
        
        arbolB.add(new Horario(35));
        arbolB.add(new Horario(15));
        arbolB.add(new Horario(60));
        
        arbolB.add(new Horario(230));
        arbolB.add(new Horario(260));
        arbolB.add(new Horario(290));
        
        arbolB.add(new Horario(160));
        arbolB.add(new Horario(185));
        arbolB.add(new Horario(210));
        
        arbolB.add(new Horario(227));
        arbolB.add(new Horario(240));
        arbolB.add(new Horario(255));
        
        arbolB.add(new Horario(265));
        arbolB.add(new Horario(282));
        arbolB.add(new Horario(310));
        arbolB.add(new Horario(115));
        
        Horario horarioRecuperado = arbolB.get(265);
        
        System.out.println("Dato recuperado del arbol:  " + horarioRecuperado.getId());
        
        arbolB.remove(50);
        arbolB.add(new Horario(30));
        arbolB.remove(60);
        
        arbolB.add(new Horario(5));
        arbolB.add(new Horario(10));
        arbolB.add(new Horario(20));
        
        arbolB.add(new Horario(315));
        arbolB.add(new Horario(320));
        arbolB.add(new Horario(325));
        
        arbolB.remove(20);
        arbolB.remove(325);
        arbolB.remove(250);
        
        System.out.println("");
        arbolB.printTree(arbolB.getRoot(), 0);
        arbolB.showTree();
    }
}
