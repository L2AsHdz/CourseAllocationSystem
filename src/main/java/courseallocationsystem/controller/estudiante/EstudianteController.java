package courseallocationsystem.controller.estudiante;

import courseallocationsystem.controller.login.LoginController;
import courseallocationsystem.view.EstudianteView;
import courseallocationsystem.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @date 20/05/2021
 * @time 13:36:56
 * @author asael
 */
public class EstudianteController implements ActionListener {

    private final EstudianteView view;

    public EstudianteController(EstudianteView view) {
        this.view = view;
        
        this.view.getItmCambiarU().addActionListener(this);
    }
    
    public void iniciar() {
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        if (s == view.getItmCambiarU()) {
            LoginView login = new LoginView();
            LoginController controller = new LoginController(login);
            controller.iniciar();
            view.dispose();
        }
    }

}
