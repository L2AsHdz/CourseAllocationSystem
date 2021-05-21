package courseallocationsystem.imagegenerator.list;

import courseallocationsystem.codegenerator.list.EdificiosGraphvizCodeGenerator;
import static courseallocationsystem.controller.FileController.abrirArchivo;
import static courseallocationsystem.controller.FileController.saveFile;
import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.imagegenerator.ImageGenerator;
import courseallocationsystem.model.Edificio;

/**
 *
 * @date 21/05/2021
 * @time 07:04:37
 * @author asael
 */
public class EdificiosImageGenerator extends ImageGenerator {

    private final CircularList<Edificio, String> list;
    
    public EdificiosImageGenerator(CircularList<Edificio, String> list) {
        this.list = list;
    }

    @Override
    public void generate() {
        generarArchivoDot(list);
        generarPng("edificios.dot", "edificios.png");
        abrirArchivo("edificios.png");
    }
    
    private void generarArchivoDot(CircularList edificios) {
        var generator = new EdificiosGraphvizCodeGenerator(edificios);
        saveFile("edificios.dot", generator.generate());
    }
}
