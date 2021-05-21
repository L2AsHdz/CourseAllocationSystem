package courseallocationsystem.validator;

import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Horario;
import java.util.Objects;

/**
 *
 * @date 20/05/2021
 * @time 17:58:45
 * @author asael
 */
public class AsignacionValidator {

    public static String validateAsignacion(BTree<Horario, Integer> horarios,
            int idEstudiante, int idHorario) {
        String error = "";
        
        if (Objects.isNull(horarios.get(idHorario))) {
            error = "El horario con codigo " + idHorario + " no existe en el sistema";
        } else {
            if (!Objects.isNull(horarios.get(idHorario).getAsignaciones().get(idEstudiante))) {
                error  = "El estudiante con carnet " + idEstudiante + " ya tiene una asignacion en este horario";
            }
        }
        
        return error;
    }
}
