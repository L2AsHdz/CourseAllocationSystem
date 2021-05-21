package courseallocationsystem.controller.colaborador;

import courseallocationsystem.datos.Data;
import courseallocationsystem.view.ColaboradorView;
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
    private final Data data;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.data = Data.getData();
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
