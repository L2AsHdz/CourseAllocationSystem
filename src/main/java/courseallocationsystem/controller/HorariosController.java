package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.HorarioView;

import javax.management.ObjectName;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HorariosController implements ActionListener {
    HorarioView horarioView;

    public HorariosController(HorarioView horarioView) {
        this.horarioView = horarioView;

        this.horarioView.getBtnAgregar().addActionListener(this);
        this.horarioView.getBtnActualizar().addActionListener(this);
        this.horarioView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        horarioView.setSize(parent.getSize());
        horarioView.setVisible(true);
        parent.add(horarioView);
        parent.validate();
        horarioView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == horarioView.getBtnAgregar()) {
            agregar();
        } else if (e == horarioView.getBtnActualizar()) {
            actualizar();
        } else if (e == horarioView.getBtnBorrar()) {
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
