package courseallocationsystem.imagegenerator.tree;

import courseallocationsystem.codegenerator.tree.AVLTreeGraphvizCodeGenerator;
import static courseallocationsystem.controller.FileController.abrirArchivo;
import static courseallocationsystem.controller.FileController.saveFile;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.imagegenerator.ImageGenerator;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 21/05/2021
 * @time 08:22:55
 * @author asael
 */
public class AVLTreeImageGenerator<T extends Entidad, I> extends ImageGenerator {
    
    private final ArbolAVL<T,I> tree;
    private final String nameFile;

    public AVLTreeImageGenerator(ArbolAVL<T,I> tree, String nameFile) {
        this.tree = tree;
        this.nameFile = nameFile;
    }

    @Override
    public void generate() {
        generarArchivoDot(tree);
        generarPng(nameFile + ".dot", nameFile + ".png");
        abrirArchivo(nameFile + ".png");
    }
    
    private void generarArchivoDot(ArbolAVL<T,I> tree) {
        var generator = new AVLTreeGraphvizCodeGenerator<T, I>(tree);
        saveFile(nameFile + ".dot", generator.generate());
    }

}
