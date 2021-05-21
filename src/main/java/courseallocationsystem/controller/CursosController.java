package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.CursoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursosController implements ActionListener {
    CursoView cursoView;

    public CursosController(CursoView cursoView) {
        this.cursoView = cursoView;

        this.cursoView.getBtnAgregar().addActionListener(this);
        this.cursoView.getBtnActualizar().addActionListener(this);
        this.cursoView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        cursoView.setSize(parent.getSize());
        cursoView.setVisible(true);
        parent.add(cursoView);
        parent.validate();
        cursoView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object s = actionEvent.getSource();
        if (s == cursoView.getBtnAgregar()) {
            agregar();
        } else if (s == cursoView.getBtnActualizar()) {
            actualizar();
        } else if (s == cursoView.getBtnBorrar()) {
            borrar();
        }
    }

    private void borrar() {

    }

    private void actualizar() {
    }

    private void agregar() {

    }
}
