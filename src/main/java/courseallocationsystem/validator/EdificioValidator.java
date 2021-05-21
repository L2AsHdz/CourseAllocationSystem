package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;

/**
 *
 * @date 20/05/2021
 * @time 17:25:27
 * @author asael
 */
public class EdificioValidator {
    
    private static Data data = Data.getData();

    public static String validateEdificio(String name) {
        String error = "";
        
        if (data.getEdificios().get(name) != null) {
            error = "El edificio con nombre " + name + " ya existe en el sistema";
        }
        
        return error;
    }
}
