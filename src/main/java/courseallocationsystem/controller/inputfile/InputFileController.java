package courseallocationsystem.controller.inputfile;

import courseallocationsystem.analyzer.InputFileAnalyzer;
import static courseallocationsystem.controller.FileController.readFile;
import courseallocationsystem.datos.Data;
import courseallocationsystem.view.inputfile.InputFileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @date 20/05/2021
 * @time 13:55:51
 * @author asael
 */
public class InputFileController implements ActionListener {

    private InputFileView view;
    private Data data;

    public InputFileController(InputFileView view, Data data) {
        this.view = view;
        this.data = data;

        this.view.getBtnBuscar().addActionListener(this);
        this.view.getBtnIniciar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        view.setSize(parent.getSize());
        view.setVisible(true);
        parent.add(view);
        parent.validate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        if (s == view.getBtnBuscar()) {
            String path = "";
            String content = "";

            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this.view);
            try {
                path = fc.getSelectedFile().getAbsolutePath();
                content = readFile(path);
            } catch (Exception ex) {
                System.out.println("se cancelo");
            }
            view.getTxtInfo().setText(content);
            view.getLblNameFile().setText(path);
            view.getBtnIniciar().setEnabled(true);
        } else if (s == view.getBtnIniciar()) {
            String content = view.getTxtInfo().getText();
            setData(content);
            view.getBtnIniciar().setEnabled(false);
            view.getLblNameFile().setText("*Aun no se ha seleccionado ningun archivo*");
        }
    }

    public void setData(String inputText) {
        InputFileAnalyzer analyzer = new InputFileAnalyzer(inputText);
        analyzer.analyze();

        ArrayList<String> errores = analyzer.getErrores();

        if (errores.isEmpty()) {
            view.getTxtInfo().setText("");
            analyzer.getMensajes().forEach(m -> view.getTxtInfo().append(m + "\n"));
            System.out.println("Analisis realizado con exito");
        } else {
            errores.forEach(e -> view.getTxtInfo().append(e + "\n"));
        }
    }

}
