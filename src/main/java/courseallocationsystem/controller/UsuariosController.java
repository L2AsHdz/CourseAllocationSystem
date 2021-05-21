package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.model.Usuario;
import courseallocationsystem.validator.UserValidator;
import courseallocationsystem.view.jpanels.UsuarioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;

public class UsuariosController implements ActionListener {
    
    private final UsuarioView view;
    private final Data data;
    
    private String id;
    private String name;
    private String pass;
    private String tipo;
    
    public UsuariosController(UsuarioView usuarioView) {
        this.view = usuarioView;

        this.view.getBtnAgregar().addActionListener(this);
        this.view.getBtnActualizar().addActionListener(this);
        this.view.getBtnBorrar().addActionListener(this);
        data = Data.getData();
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        view.setSize(parent.getSize());
        view.setVisible(true);
        parent.add(view);
        parent.validate();
        view.limpiar();
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == view.getBtnAgregar()) {
            agregar();
        } else if (e == view.getBtnActualizar()) {
            actualizar();
        } else if (e == view.getBtnBorrar()) {
            borrar();
        }
    }

    private void agregar() {
        obtenerDatos();
        String error = UserValidator.validateUser(Integer.parseInt(id), tipo);
        
        if (error.isEmpty()) {
            data.getUsuarios().add(new Usuario(name, pass, tipo, Integer.parseInt(id)));
        } else {
            view.getLblError().setText(error);
        }
        actualizarTabla();
    }

    private void actualizar() {
        obtenerDatos();
        
        if (data.getUsuarios().get(Integer.parseInt(id)) == null) {
            view.getLblError().setText("El estudiante con carnet " + id + " no existe en el sistema");
        } else {
            data.getUsuarios().update(new Usuario(name, pass, tipo, Integer.parseInt(id)));            
        }
        actualizarTabla();
    }

    private void borrar() {
        id = view.getTxtIdentificador().getText();
        
        try {
            int ident = Integer.parseInt(id);
            if (Objects.isNull(data.getUsuarios().remove(ident))) {
                view.getLblError().setText("El usuario con el identificador " + ident + " no existe");
            }
        } catch (NumberFormatException e) {
            view.getLblError().setText("El id debe ser un dato numerico");
        }
        actualizarTabla();
    }
    
    private void obtenerDatos() {
        id = view.getTxtIdentificador().getText();
        name = view.getTxtNombre().getText();
        tipo = view.getCbTipoUser().getSelectedItem().toString();
        pass = view.getTxtPassword().getText();
    }
    
    private void actualizarTabla() {
        DefaultTableModel model = data.getUsuarios().toTable(new String[]{"Identificador", "Nombre", "Password", "Tipo"});
        view.getTblUsuario().setModel(model);
    }
}
