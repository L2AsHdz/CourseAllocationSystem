package courseallocationsystem.validator;

import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Horario;

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
        
        if (horarios.get(idHorario) == null) {
            error = "El horario con codigo " + idHorario + " no existe en el sistema";
        } else {
            if (horarios.get(idHorario).getAsignaciones().get(idEstudiante) != null) {
                error  = "El estudiante con carnet " + idEstudiante + " ya tiene una asignacion en este horario";
            }
        }
        
        return error;
    }
}
