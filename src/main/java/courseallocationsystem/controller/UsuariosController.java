package courseallocationsystem.controller;

import courseallocationsystem.view.jpanels.UsuarioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosController implements ActionListener {
    UsuarioView usuarioView;

    public UsuariosController(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;

        this.usuarioView.getBtnAgregar().addActionListener(this);
        this.usuarioView.getBtnActualizar().addActionListener(this);
        this.usuarioView.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        usuarioView.setSize(parent.getSize());
        usuarioView.setVisible(true);
        parent.add(usuarioView);
        parent.validate();
        usuarioView.limpiar();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == usuarioView.getBtnAgregar()) {
            agregar();
        } else if (e == usuarioView.getBtnActualizar()) {
            actualizar();
        } else if (e == usuarioView.getBtnBorrar()) {
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
