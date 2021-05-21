package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;

/**
 *
 * @date 20/05/2021
 * @time 17:04:59
 * @author asael
 */
public class UserValidator {
    
    private static Data data = Data.getData();

    public static String validateUser(int id, String tipo) {
        String error = "";
        
        if (tipo.equals("estudiante")) {
            if (data.getEstudiantes().get(id) == null) {
                error = "El estudiante con carnet " + id + " no existe en el sistema";
            }
        }
        if (data.getUsuarios().get(id) != null) {
            error = "El usuario con el id " + id + " ya existe en el sistema ";
        }
        
        return error;
    }

}
