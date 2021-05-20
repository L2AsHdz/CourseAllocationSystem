package courseallocationsystem.controller;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.model.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import courseallocationsystem.view.LoginView;
import javax.swing.JOptionPane;

/**
 *
 * @date 20/05/2021
 * @time 11:20:49
 * @author asael
 */
public class LoginController implements ActionListener {

    private final LoginView login;
    private final CircularList<Usuario, Integer> users;

    public LoginController(LoginView login, CircularList<Usuario, Integer> users) {
        this.login = login;
        this.users = users;
        
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

        if (users.get(Integer.parseInt(userId)) == null) {
            JOptionPane.showMessageDialog(null, "Usuario " + userId + " no existe", "Error login", JOptionPane.WARNING_MESSAGE);
            login.getTxtUser().requestFocus();
        } else {
            Usuario user = users.get(Integer.parseInt(userId));
            if (user.getPassword().equals(pass)) {
                //Redirigir a nueva Interfaz
                System.out.println("Logeando");
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error login", JOptionPane.WARNING_MESSAGE);
                login.getTxtPass().requestFocus();
            }
        }
    }
}
