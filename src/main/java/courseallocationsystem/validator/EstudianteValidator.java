package courseallocationsystem.validator;

import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.model.Estudiante;

/**
 *
 * @date 20/05/2021
 * @time 17:21:32
 * @author asael
 */
public class EstudianteValidator {

    public static String validateEstudiante(HashTable<Estudiante, Integer> estudiantes,
            int id) {
        String error = "";
    
        if (estudiantes.get(id) != null) {
            error = "El estudiante con el carnet " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
