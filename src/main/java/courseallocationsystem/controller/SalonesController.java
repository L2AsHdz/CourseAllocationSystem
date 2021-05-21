package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.SalonView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalonesController implements ActionListener {
    SalonView salonView;

    public SalonesController(SalonView salonView) {
        this.salonView = salonView;

        this.salonView.getBtnAgregar().addActionListener(this);
        this.salonView.getBtnActualizar().addActionListener(this);
        this.salonView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        salonView.setSize(parent.getSize());
        salonView.setVisible(true);
        parent.add(salonView);
        parent.validate();
        salonView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == salonView.getBtnAgregar()) {
            agregar();
        } else if (e == salonView.getBtnActualizar()) {
            actualizar();
        } else if (e == salonView.getBtnBorrar()) {
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
