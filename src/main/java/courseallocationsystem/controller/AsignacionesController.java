package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.AsignacionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsignacionesController implements ActionListener {
    AsignacionView  asignacionView;

    public AsignacionesController(AsignacionView asignacionView) {
        this.asignacionView = asignacionView;

        this.asignacionView.getBtnAgregar().addActionListener(this);
        this.asignacionView.getBtnActualizar().addActionListener(this);
        this.asignacionView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        asignacionView.setSize(parent.getSize());
        asignacionView.setVisible(true);
        parent.add(asignacionView);
        parent.validate();
        asignacionView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == asignacionView.getBtnAgregar()) {
            agregar();
        } else if (e == asignacionView.getBtnActualizar()) {
            actualizar();
        } else if (e == asignacionView.getBtnBorrar()) {
            borrar();
        }
    }

    private void agregar() {

    }

    private void actualizar() {

    }

    private void borrar() {

    }
}
