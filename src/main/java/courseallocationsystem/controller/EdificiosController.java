package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.edd.list.List;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Salon;
import courseallocationsystem.validator.SalonValidator;
import courseallocationsystem.view.jpanels.EdificioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class EdificiosController implements ActionListener {
    private final EdificioView view;
    private final Data data = Data.getData();
    
    private String nombre;
    private String codigo;
    private String capacidad;

    public EdificiosController(EdificioView edificioView) {
        this.view = edificioView;

        this.view.getBtnAgregar().addActionListener(this);
        this.view.getBtnBorrar().addActionListener(this);
        this.view.getBtnAddSalon().addActionListener(this);
        this.view.getBtnEditSalon().addActionListener(this);
        this.view.getBtnEliminarSalon().addActionListener(this);
        this.view.getBtnVerImage().addActionListener(this);
        this.view.getBtnVerSalones().addActionListener(this);
        this.view.getBtnVerEdificios().addActionListener(this);
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
        } else if (e == view.getBtnBorrar()) {
            borrar();
        } else if (e == view.getBtnAddSalon()) {
            codigo = view.getTxtCodSalon().getText();
            capacidad = view.getTxtCapacidad().getText();
            String error = SalonValidator.validateSalon(nombre, Integer.parseInt(codigo));
            
            if (error.isEmpty()) {
                Salon s = new Salon(Integer.parseInt(capacidad), nombre, Integer.parseInt(codigo));
                data.getEdificios().get(nombre).getSalones().add(s);
            } else {
                view.getLblError().setText(error);
            }
            mostrarSalones(nombre);
        } else if (e == view.getBtnEditSalon()) {
            codigo = view.getTxtCodSalon().getText();
            capacidad = view.getTxtCapacidad().getText();
            codigo = view.getTxtCodSalon().getText();
            
            List<Salon, Integer> salones = data.getEdificios().get(nombre).getSalones();
            if (salones.get(Integer.parseInt(codigo)) == null) {
                view.getLblError().setText("El salon " + codigo + " no existe");
            } else {
                salones.update(new Salon(Integer.parseInt(capacidad), nombre, Integer.parseInt(codigo)));
            }
            mostrarSalones(nombre);
        } else if (e == view.getBtnEliminarSalon()) {
            codigo = view.getTxtCodSalon().getText();
            List<Salon, Integer> salones = data.getEdificios().get(nombre).getSalones();
            if (salones.get(Integer.parseInt(codigo)) == null) {
                view.getLblError().setText("El salon " + codigo + " no existe");
            } else {
                salones.remove(Integer.parseInt(codigo));
            }
            mostrarSalones(nombre);
        } else if (e == view.getBtnVerImage()) {
            
        } else if (e == view.getBtnVerSalones()) {
            nombre = view.getTxtNombre().getText();
            mostrarSalones(nombre);
        } else if (e == view.getBtnVerEdificios()) {
            updateTable();
        }
    }

    private void agregar() {
        
        nombre = view.getTxtNombre().getText();
        
        if (data.getEdificios().get(nombre) != null) {
            view.getLblError().setText("El edifiocio indicado ya existe en el sistema");
        } else {
            data.getEdificios().add(new Edificio(nombre));
        }
        updateTable();
    }

    private void borrar() {
        nombre = view.getTxtNombre().getText();

        if (data.getEdificios().get(nombre) == null) {
            view.getLblError().setText("El edificio indicado no existe");
        } else {
            data.getEdificios().remove(nombre); 
        }
        updateTable();
    }
    
    private void updateTable() {
        DefaultTableModel model = data.getEdificios().toTable(new String[]{"Nombre"});
        view.getTblEdificio().setModel(model);
    }
    
    private void mostrarSalones(String edificio) {
        DefaultTableModel model = data.getEdificios().get(edificio).getSalones().toTable(new String[]{"Codigo", "Edificio", "Capacidad"});
        view.getTblEdificio().setModel(model);
    }
}
