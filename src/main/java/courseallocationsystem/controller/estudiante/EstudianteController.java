package courseallocationsystem.controller.estudiante;

import courseallocationsystem.datos.Data;
import courseallocationsystem.view.EstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @date 20/05/2021
 * @time 13:36:56
 * @author asael
 */
public class EstudianteController implements ActionListener {

    private EstudianteView view;
    private final Data data;

    public EstudianteController(EstudianteView view) {
        this.view = view;
        this.data = Data.getData();
        
        
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
