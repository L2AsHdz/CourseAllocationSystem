package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.EdificioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdificiosController implements ActionListener {
    EdificioView edificioView;

    public EdificiosController(EdificioView edificioView) {
        this.edificioView = edificioView;

        this.edificioView.getBtnAgregar().addActionListener(this);
        this.edificioView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        edificioView.setSize(parent.getSize());
        edificioView.setVisible(true);
        parent.add(edificioView);
        parent.validate();
        edificioView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == edificioView.getBtnAgregar()) {
            agregar();
        } else if (e == edificioView.getBtnBorrar()) {
            borrar();
        }
    }

    private void agregar() {

    }

    private void borrar() {

    }
}
