package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;

/**
 *
 * @date 20/05/2021
 * @time 17:45:53
 * @author asael
 */
public class CursoValidator {
    
    private static Data data = Data.getData();

    public static String validateCurso(int id) {
        String error = "";
        
        if (data.getCursos().get(id) != null) {
            error = "El curos con codigo " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
