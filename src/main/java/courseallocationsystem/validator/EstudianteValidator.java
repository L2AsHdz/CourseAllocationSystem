package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;

/**
 *
 * @date 20/05/2021
 * @time 17:21:32
 * @author asael
 */
public class EstudianteValidator {
    
    private static Data data = Data.getData();

    public static String validateEstudiante(int id) {
        String error = "";
    
        if (data.getEstudiantes().get(id) != null) {
            error = "El estudiante con el carnet " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
