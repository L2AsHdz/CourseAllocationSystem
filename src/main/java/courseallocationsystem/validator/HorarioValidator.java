package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.model.Curso;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Horario;
import java.util.Objects;

/**
 *
 * @date 20/05/2021
 * @time 17:48:13
 * @author asael
 */
public class HorarioValidator {

    public static String validateHorario(BTree<Horario, Integer> horarios,
            CircularList<Curso, Integer> cursos,
            CircularList<Edificio, String> edificios,
            ArbolAVL<Catedratico, Integer> catedraticos,
            int idHorario, int idCurso, int idCatedratico, int idSalon, String edificio) {
        String error = "";
        
        if (!Objects.isNull(horarios.get(idHorario))) {
            error = "El horario con codigo " + idHorario + " ya existe en el sistema";
        } else {
            if (Objects.isNull(cursos.get(idCurso))) {
                error = "El curso con codigo " + idCurso + " no existe en el sistema";
            } else if (edificios.get(edificio) != null) {
                if (Objects.isNull(edificios.get(edificio).getSalones().get(idSalon))) {
                    error = "El salon con codigo " + idSalon + " no existe en el edificio " + edificio;
                }
            } else if (Objects.isNull(catedraticos.get(idCatedratico))) {
                error = "El catedratico con identificacion " + idCatedratico + " no existe en el sistema";
            }
        }
        
        
        return error;
    }
}
