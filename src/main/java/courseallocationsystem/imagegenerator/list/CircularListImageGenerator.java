package courseallocationsystem.imagegenerator.list;

import courseallocationsystem.codegenerator.list.CircularListGraphvizCodeGenerator;
import static courseallocationsystem.controller.FileController.abrirArchivo;
import static courseallocationsystem.controller.FileController.saveFile;
import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.imagegenerator.ImageGenerator;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 21/05/2021
 * @time 06:24:26
 * @author asael
 */
public class CircularListImageGenerator<T extends Entidad, I> extends ImageGenerator {
    
    private CircularList<T,I> list;
    private String nameFile;
    
    public CircularListImageGenerator(CircularList list, String nameFile) {
        this.list = list;
        this.nameFile = nameFile;
    }

    @Override
    public void generate() {
        generarArchivoDot(list);
        generarPng(nameFile + ".dot", nameFile + ".png");
        abrirArchivo(nameFile + ".png");
    }
    
    private void generarArchivoDot(CircularList list) {
        var generator = new CircularListGraphvizCodeGenerator(list);
        saveFile(nameFile + ".dot", generator.generate());
    }

}
