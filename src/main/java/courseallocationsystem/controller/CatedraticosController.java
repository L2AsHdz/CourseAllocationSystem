package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.validator.CatedraticoValidator;
import courseallocationsystem.view.jpanels.CatedraticoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CatedraticosController implements ActionListener {
    
    private final CatedraticoView view;
    private final Data data = Data.getData();
    
    private String id;
    private String nombre;
    private String direccion;
    
    public CatedraticosController(CatedraticoView catedraticoView) {
        this.view = catedraticoView;

        this.view.getBtnAgregar().addActionListener(this);
        this.view.getBtnActualizar().addActionListener(this);
        this.view.getBtnBorrar().addActionListener(this);
    }

    public void iniciar(JPanel parent) {
        parent.removeAll();
        parent.repaint();
        view.setSize(parent.getSize());
        view.setVisible(true);
        parent.add(view);
        parent.validate();
        view.limpiar();
        updateTable();
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
        String error = CatedraticoValidator.validateCatedratico(Integer.parseInt(id));
        
        if (error.isEmpty()) {
            data.getCatedraticos().add(new Catedratico(nombre, direccion, Integer.parseInt(id)));
        } else {
            view.getLblError().setText(error);
        }
        updateTable();
    }

    private void actualizar() {
        obtenerDatos();
        
        if (data.getCatedraticos().get(Integer.parseInt(id)) == null) {
            view.getLblError().setText("Catedratico " + id + " no existe");
        } else {
            data.getCatedraticos().update(new Catedratico(nombre, direccion, Integer.parseInt(id)));
        }
        updateTable();
    }

    private void borrar() {
        id = view.getTxtIdentificador().getText();
        
        if (data.getCatedraticos().get(Integer.parseInt(id)) == null) {
            view.getLblError().setText("Catedratico " + id + " no existe");
        } else {
            data.getCatedraticos().remove(Integer.parseInt(id));
        }
        updateTable();
    }
    
    private void obtenerDatos() {
        id = view.getTxtIdentificador().getText();
        nombre = view.getTxtNombre().getText();
        direccion = view.getTxtDireccion().getText();
    }
    
    private void updateTable() {
        
        data.getCatedraticos().setTitles(new String[]{"Identificacion", "Nombre", "Direccion"});
        data.getCatedraticos().fillDefaultTableModel(data.getCatedraticos().getRaiz());
        DefaultTableModel model = data.getCatedraticos().getModel();
        view.getTblCatedratico().setModel(model);
    }
}
