package courseallocationsystem.controller.superU;

import courseallocationsystem.datos.Data;
import courseallocationsystem.view.SuperView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @date 20/05/2021
 * @time 12:45:11
 * @author asael
 */
public class SuperController implements ActionListener {

    private SuperView view;
    private Data data;

    public SuperController(SuperView view, Data data) {
        this.view = view;
        this.data = data;
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
