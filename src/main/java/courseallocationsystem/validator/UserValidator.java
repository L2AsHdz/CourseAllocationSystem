package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.model.Estudiante;
import courseallocationsystem.model.Usuario;

/**
 *
 * @date 20/05/2021
 * @time 17:04:59
 * @author asael
 */
public class UserValidator {

    public static String validateUser(CircularList<Usuario, Integer> usuarios,
            HashTable<Estudiante, Integer> estudiantes, int id, String tipo) {
        String error = "";
        
        if (tipo.equals("estudiante")) {
            if (estudiantes.get(id) == null) {
                error = "El estudiante con carnet " + id + " no existe en el sistema";
            }
        }
        if (usuarios.get(id) != null) {
            error = "El usuario con el id " + id + " ya existe en el sistema ";
        }
        
        return error;
    }

}
