package courseallocationsystem.validator;

import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.model.Catedratico;

/**
 *
 * @date 20/05/2021
 * @time 17:42:21
 * @author asael
 */
public class CatedraticoValidator {

    public static String validateCatedratico(ArbolAVL<Catedratico, Integer> catedraticos,
            int id) {
        String error = "";
        
        if (catedraticos.get(id) != null) {
            error = "El catedratico con identificacion " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
