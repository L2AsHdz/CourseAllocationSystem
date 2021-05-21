package courseallocationsystem.validator;

import courseallocationsystem.datos.Data;
import courseallocationsystem.model.Horario;
import courseallocationsystem.model.Salon;
import java.util.Objects;

/**
 *
 * @date 20/05/2021
 * @time 17:58:45
 * @author asael
 */
public class AsignacionValidator {
    
    private static Data data = Data.getData();

    public static String validateAsignacion(int idEstudiante, int idHorario) {
        String error = "";
        
        if (Objects.isNull(data.getHorarios().get(idHorario))) {
            error = "El horario con codigo " + idHorario + " no existe en el sistema";
        } else {
            if (!Objects.isNull(data.getHorarios().get(idHorario).getAsignaciones().get(idEstudiante))) {
                error  = "El estudiante con carnet " + idEstudiante + " ya tiene una asignacion en este horario";
            }
            Horario h = data.getHorarios().get(idHorario);
            Salon s = data.getEdificios().get(h.getCodEdificio()).getSalones().get(h.getCodSalon());
             if (h.getAsignaciones().size() == s.getCantEstudiantes()) {
                error = "El salon ya cuenta con el numero maximo de estudiantes permitido";
            }
        }
        
        return error;
    }
}
