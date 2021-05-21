package courseallocationsystem.validator;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.model.Curso;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Horario;

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
        
        if (horarios.get(idHorario) != null) {
            error = "El horario con codigo " + idHorario + " ya existe en el sistema";
        } else {
            if (cursos.get(idCurso) == null) {
                error = "El curso con codigo " + idCurso + " no existe en el sistema";
            } else if (edificios.get(edificio) != null) {
                if (edificios.get(edificio).getSalones().get(idSalon) == null) {
                    error = "El salon con codigo " + idSalon + " no existe en el edificio " + edificio;
                }
            } else if (catedraticos.get(idCatedratico) != null) {
                error = "El catedratico con identificacion " + idCatedratico + " no existe en el sistema";
            }
        }
        
        
        return error;
    }
}
