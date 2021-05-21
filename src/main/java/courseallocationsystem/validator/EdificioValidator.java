package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Edificio;

/**
 *
 * @date 20/05/2021
 * @time 17:25:27
 * @author asael
 */
public class EdificioValidator {

    public static String validateEdificio(CircularList<Edificio, String> edificios,
            String name) {
        String error = "";
        
        if (edificios.get(name) != null) {
            error = "El edificio con nombre " + name + " ya existe en el sistema";
        }
        
        return error;
    }
}
