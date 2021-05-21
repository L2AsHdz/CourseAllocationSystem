package courseallocationsystem.imagegenerator.tree;

import courseallocationsystem.codegenerator.tree.BTreeGraphvizCodeGenerator;
import static courseallocationsystem.controller.FileController.abrirArchivo;
import static courseallocationsystem.controller.FileController.saveFile;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.imagegenerator.ImageGenerator;
import courseallocationsystem.model.Horario;

/**
 *
 * @date 21/05/2021
 * @time 09:18:30
 * @author asael
 */
public class HorariosImageGenerator extends ImageGenerator {
    
    private final BTree<Horario, Integer> horarios;

    public HorariosImageGenerator(BTree<Horario, Integer> horarios) {
        this.horarios = horarios;
    }

    @Override
    public void generate() {
        generarArchivoDot(horarios);
        generarPng("horarios.dot", "horarios.png");
        abrirArchivo("horarios.png");
    }
    
    private void generarArchivoDot(BTree<Horario, Integer> horarios) {
        var generator = new BTreeGraphvizCodeGenerator(horarios);
        saveFile("horarios.dot", generator.generate());
    }

}
