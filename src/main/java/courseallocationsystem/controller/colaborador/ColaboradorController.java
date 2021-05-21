package courseallocationsystem.controller.colaborador;

import courseallocationsystem.controller.AsignacionesController;
import courseallocationsystem.controller.CatedraticosController;
import courseallocationsystem.controller.CursosController;
import courseallocationsystem.controller.EstudiantesController;
import courseallocationsystem.controller.HorariosController;
import courseallocationsystem.controller.login.LoginController;
import courseallocationsystem.view.ColaboradorView;
import courseallocationsystem.view.LoginView;
import courseallocationsystem.view.jpanels.AsignacionView;
import courseallocationsystem.view.jpanels.CatedraticoView;
import courseallocationsystem.view.jpanels.CursoView;
import courseallocationsystem.view.jpanels.EstudianteView;
import courseallocationsystem.view.jpanels.HorarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @date 20/05/2021
 * @time 13:33:44
 * @author asael
 */
public class ColaboradorController implements ActionListener {

    private final ColaboradorView view;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        
        this.view.getItmAsignaciones().addActionListener(this);
        this.view.getItmCambiarU().addActionListener(this);
        this.view.getItmCatedraticos().addActionListener(this);
        this.view.getItmCursos().addActionListener(this);
        this.view.getItmEstudiantes().addActionListener(this);
        this.view.getItmHorarios().addActionListener(this);
    }
    
    public void iniciar() {
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == view.getItmAsignaciones()) {
            AsignacionView asignacionView = new AsignacionView();
            AsignacionesController asignacionesController = new AsignacionesController(asignacionView);
            asignacionesController.iniciar(view.getPnlDesk());
        } else if (e == view.getItmCambiarU()) {
            LoginView login = new LoginView();
            LoginController controller = new LoginController(login);
            controller.iniciar();
            view.dispose();
        } else if (e == view.getItmCatedraticos()) {
            CatedraticoView catedraticoView = new CatedraticoView();
            CatedraticosController catedraticosController = new CatedraticosController(catedraticoView);
            catedraticosController.iniciar(view.getPnlDesk());
        } else if (e == view.getItmCursos()) {
            CursoView cursoView = new CursoView();
            CursosController cursosController = new CursosController(cursoView);
            cursosController.iniciar(view.getPnlDesk());
        } else if (e == view.getItmEstudiantes()) {
            EstudianteView estudianteView = new EstudianteView();
            EstudiantesController estudiantesController = new EstudiantesController(estudianteView);
            estudiantesController.iniciar(view.getPnlDesk());
        } else if (e == view.getItmHorarios()) {
            HorarioView horarioView = new HorarioView();
            HorariosController horariosController = new HorariosController(horarioView);
            horariosController.iniciar(view.getPnlDesk());
        }
    }
}
