package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;
import java.util.Objects;

/**
 *
 * @date 20/05/2021
 * @time 17:42:21
 * @author asael
 */
public class CatedraticoValidator {
    
    private static Data data = Data.getData();

    public static String validateCatedratico(int id) {
        String error = "";
        
        if (!Objects.isNull(data.getCatedraticos().get(id))) {
            error = "El catedratico con identificacion " + id + " ya existe en el sistema";
        }
        
        return error;
    }
}
