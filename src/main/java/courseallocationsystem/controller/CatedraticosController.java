package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.CatedraticoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatedraticosController implements ActionListener {
    CatedraticoView catedraticoView;

    public CatedraticosController(CatedraticoView catedraticoView) {
        this.catedraticoView = catedraticoView;

        this.catedraticoView.getBtnAgregar().addActionListener(this);
        this.catedraticoView.getBtnActualizar().addActionListener(this);
        this.catedraticoView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        catedraticoView.setSize(parent.getSize());
        catedraticoView.setVisible(true);
        parent.add(catedraticoView);
        parent.validate();
        catedraticoView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == catedraticoView.getBtnAgregar()) {
            agregar();
        } else if (e == catedraticoView.getBtnActualizar()) {
            actualizar();
        } else if (e == catedraticoView.getBtnBorrar()) {
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
