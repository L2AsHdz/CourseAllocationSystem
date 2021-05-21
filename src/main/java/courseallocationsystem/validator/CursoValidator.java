package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Curso;

/**
 *
 * @date 20/05/2021
 * @time 17:45:53
 * @author asael
 */
public class CursoValidator {

    public static String validateCurso(CircularList<Curso, Integer> cursos,
            int id) {
        String error = "";
        
        if (cursos.get(id) != null) {
            error = "El curos con codigo " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
