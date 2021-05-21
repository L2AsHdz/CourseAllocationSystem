package courseallocationsystem.controller.superU;

import courseallocationsystem.controller.CursosController;
import courseallocationsystem.controller.EdificiosController;
import courseallocationsystem.controller.SalonesController;
import courseallocationsystem.controller.UsuariosController;
import courseallocationsystem.controller.inputfile.InputFileController;
import courseallocationsystem.controller.login.LoginController;
import courseallocationsystem.view.LoginView;
import courseallocationsystem.view.SuperView;
import courseallocationsystem.view.inputfile.InputFileView;
import courseallocationsystem.view.jpanels.CursoView;
import courseallocationsystem.view.jpanels.EdificioView;
import courseallocationsystem.view.jpanels.SalonView;
import courseallocationsystem.view.jpanels.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @date 20/05/2021
 * @time 12:45:11
 * @author asael
 */
public class SuperController implements ActionListener {

    private final SuperView view;

    public SuperController(SuperView view) {
        this.view = view;
        
        this.view.getItmCambiarU().addActionListener(this);
        this.view.getItmCursos().addActionListener(this);
        this.view.getItmEdificios().addActionListener(this);
        this.view.getItmRead().addActionListener(this);
        this.view.getItmSalones().addActionListener(this);
        this.view.getItmsUsers().addActionListener(this);
    }
    
    public void iniciar() {
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        if (s == view.getItmRead()) {
            InputFileView inputView = new InputFileView();
            InputFileController controller = new InputFileController(inputView);
            controller.iniciar(view.getPnlDesk());
        } else if (s == view.getItmCursos()) {
            CursoView cursoView  = new CursoView();
            CursosController cursosController = new CursosController(cursoView);
            cursosController.iniciar(view.getPnlDesk());
        } else  if (s == view.getItmEdificios()) {
            EdificioView edificioView = new EdificioView();
            EdificiosController edificiosController = new EdificiosController(edificioView);
            edificiosController.iniciar(view.getPnlDesk());
        } else if (s == view.getItmCambiarU()) {
            LoginView login = new LoginView();
            LoginController controller = new LoginController(login);
            controller.iniciar();
            view.dispose();
        } else if (s == view.getItmSalones()) {
            SalonView salonView = new SalonView();
            SalonesController salonesController = new SalonesController(salonView);
            salonesController.iniciar(view.getPnlDesk());
        } else if (s == view.getItmsUsers()) {
            UsuarioView usuarioView = new UsuarioView();
            UsuariosController usuariosController = new UsuariosController(usuarioView);
            usuariosController.iniciar(view.getPnlDesk());
        }
    }
}
