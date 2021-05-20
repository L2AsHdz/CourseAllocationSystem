package courseallocationsystem.controller.login;

import courseallocationsystem.model.Usuario;
import courseallocationsystem.datos.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import courseallocationsystem.view.LoginView;
import courseallocationsystem.view.SuperView;
import courseallocationsystem.view.ColaboradorView;
import courseallocationsystem.view.EstudianteView;
import courseallocationsystem.controller.superU.SuperController;
import courseallocationsystem.controller.colaborador.ColaboradorController;
import courseallocationsystem.controller.estudiante.EstudianteController;
import javax.swing.JOptionPane;

/**
 *
 * @date 20/05/2021
 * @time 11:20:49
 * @author asael
 */
public class LoginController implements ActionListener {

    private final LoginView login;
    private final Data data;
    
    public LoginController(LoginView login, Data data) {
        this.login = login;
        this.data = data;
        
        this.login.getBtnLogin().addActionListener(this);
    }

    public void iniciar() {
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userId = login.getTxtUser().getText();
        String pass = new String(login.getTxtPass().getPassword());

        if (data.getUsuarios().get(Integer.parseInt(userId)) == null) {
            JOptionPane.showMessageDialog(null, "Usuario " + userId + " no existe", "Error login", JOptionPane.WARNING_MESSAGE);
            login.getTxtUser().requestFocus();
        } else {
            Usuario user = data.getUsuarios().get(Integer.parseInt(userId));
            if (user.getPassword().equals(pass)) {
                switch (user.getTipo()) {
                    case "super" -> {
                        SuperView view = new SuperView();
                        SuperController controller = new SuperController(view, data);
                        controller.iniciar();
                        login.dispose();
                    }
                    case "colaborador" -> {
                        ColaboradorView view = new ColaboradorView();
                        ColaboradorController controller = new ColaboradorController(view, data);
                        controller.iniciar();
                        login.dispose();
                    }
                    case "estudiante" -> {
                        EstudianteView view = new EstudianteView();
                        EstudianteController controller = new EstudianteController(view, data);
                        controller.iniciar();
                        login.dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error login", JOptionPane.WARNING_MESSAGE);
                login.getTxtPass().requestFocus();
            }
        }
    }
}
