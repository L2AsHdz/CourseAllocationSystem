package courseallocationsystem.imagegenerator.table;

import courseallocationsystem.codegenerator.table.HashTableGraphvizCodeGenerator;
import static courseallocationsystem.controller.FileController.abrirArchivo;
import static courseallocationsystem.controller.FileController.saveFile;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.imagegenerator.ImageGenerator;
import courseallocationsystem.model.Entidad;

/**
 *
 * @param <T>
 * @param <I>
 * @date 21/05/2021
 * @time 07:56:16
 * @author asael
 */
public class HashTableImageGenerator<T extends Entidad, I> extends ImageGenerator {
    
    private final HashTable<T,I> table;
    private final String nameFile;

    public HashTableImageGenerator(HashTable<T,I> table, String nameFile) {
        this.table = table;
        this.nameFile = nameFile;
    }

    @Override
    public void generate() {
        generarArchivoDot(table);
        generarPng(nameFile + ".dot", nameFile + ".png");
        abrirArchivo(nameFile + ".png");
    }
    
    private void generarArchivoDot(HashTable<T,I> table) {
        var generator = new HashTableGraphvizCodeGenerator<T, I>(table);
        saveFile(nameFile + ".dot", generator.generate());
    }

}
