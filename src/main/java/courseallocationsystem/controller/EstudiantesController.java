package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.EstudianteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstudiantesController implements ActionListener {
    EstudianteView estudianteView;

    public EstudiantesController(EstudianteView estudianteView) {
        this.estudianteView = estudianteView;

        this.estudianteView.getBtnAgregar().addActionListener(this);
        this.estudianteView.getBtnActualizar().addActionListener(this);
        this.estudianteView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        estudianteView.setSize(parent.getSize());
        estudianteView.setVisible(true);
        parent.add(estudianteView);
        parent.validate();
        estudianteView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == estudianteView.getBtnAgregar()) {
            agregar();
        } else if (e == estudianteView.getBtnActualizar()) {
            actuaizar();
        } else if (e == estudianteView.getBtnBorrar()) {
            borrar();
        }
    }

    private void agregar() {

    }

    private void actuaizar() {

    }

    private void borrar() {

    }
}
