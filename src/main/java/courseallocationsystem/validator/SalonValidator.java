package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Edificio;

/**
 *
 * @date 20/05/2021
 * @time 17:31:44
 * @author asael
 */
public class SalonValidator {

    public static String validateSalon(CircularList<Edificio, String> edificios,
            String nameEdificio, int codSalon) {
        String error = "";
        
        if (edificios.get(nameEdificio) == null) {
            error = "El edificio con nombre " + nameEdificio + " no existe en el sistema";
        } else {
            if (edificios.get(nameEdificio).getSalones().get(codSalon) != null) {
                error = "El salon " + codSalon + " ya existe en el edificio " + nameEdificio;
            }
        }
        
        return error;
    }
}
