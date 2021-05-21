package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;
import java.util.Objects;

/**
 *
 * @date 20/05/2021
 * @time 17:48:13
 * @author asael
 */
public class HorarioValidator {
    
    private static Data data = Data.getData();

    public static String validateHorario(int idHorario, int idCurso, int idCatedratico, int idSalon, String edificio) {
        String error = "";
        
        if (!Objects.isNull(data.getHorarios().get(idHorario))) {
            error = "El horario con codigo " + idHorario + " ya existe en el sistema";
        } else {
            if (Objects.isNull(data.getCursos().get(idCurso))) {
                error = "El curso con codigo " + idCurso + " no existe en el sistema";
            } else if (data.getEdificios().get(edificio) != null) {
                if (Objects.isNull(data.getEdificios().get(edificio).getSalones().get(idSalon))) {
                    error = "El salon con codigo " + idSalon + " no existe en el edificio " + edificio;
                }
            } else if (Objects.isNull(data.getCatedraticos().get(idCatedratico))) {
                error = "El catedratico con identificacion " + idCatedratico + " no existe en el sistema";
            }
        }
        
        
        return error;
    }
}
