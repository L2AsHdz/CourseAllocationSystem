package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;

/**
 *
 * @date 20/05/2021
 * @time 17:31:44
 * @author asael
 */
public class SalonValidator {
    
    private static Data data = Data.getData();

    public static String validateSalon(String nameEdificio, int codSalon) {
        String error = "";
        
        if (data.getEdificios() == null) {
            error = "El edificio con nombre " + nameEdificio + " no existe en el sistema";
        } else {
            if (data.getEdificios().get(nameEdificio).getSalones().get(codSalon) != null) {
                error = "El salon " + codSalon + " ya existe en el edificio " + nameEdificio;
            }
        }
        
        return error;
    }
}
