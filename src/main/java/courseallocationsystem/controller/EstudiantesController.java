package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.model.Estudiante;
import courseallocationsystem.validator.EstudianteValidator;
import courseallocationsystem.view.jpanels.EstudianteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class EstudiantesController implements ActionListener {
    private final EstudianteView view;
    private final Data data = Data.getData();
    
    private String carnet;
    private String nombre;
    private String direccion;

    public EstudiantesController(EstudianteView estudianteView) {
        this.view = estudianteView;

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
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e = actionEvent.getSource();
        if (e == view.getBtnAgregar()) {
            agregar();
        } else if (e == view.getBtnActualizar()) {
            actuaizar();
        } else if (e == view.getBtnBorrar()) {
            borrar();
        }
    }

    private void agregar() {
        obtenerDatos();
        String error = EstudianteValidator.validateEstudiante(Integer.parseInt(carnet));
        
        if (error.isEmpty()) {
            data.getEstudiantes().add(new Estudiante(nombre, direccion, Integer.parseInt(carnet)));
        } else {
            view.getLblError().setText(error);
        }
        actualizarTabla();
    }

    private void actuaizar() {
        obtenerDatos();
        
        if (data.getEstudiantes().get(Integer.parseInt(carnet)) == null) {
            view.getLblError().setText("Estudiante " + carnet + " no existe");
        } else {
            data.getEstudiantes().update(new Estudiante(nombre, direccion, Integer.parseInt(carnet)));
        }
        actualizarTabla();
    }

    private void borrar() {
        carnet = view.getTxtCarnet().getText();
        
        if (data.getEstudiantes().get(Integer.parseInt(carnet)) == null) {
            view.getLblError().setText("Estudiante " + carnet + " no existe");
        } else {
            data.getEstudiantes().remove(Integer.parseInt(carnet));
        }
        actualizarTabla();
    }
    
    private void obtenerDatos() {
        carnet = view.getTxtCarnet().getText();
        nombre = view.getTxtNombre().getText();
        direccion = view.getTxtDireccion().getText();
    }
    
    private void actualizarTabla() {
        DefaultTableModel model = data.getEstudiantes().toTable(new String[]{"Carnet", "Nombre", "Direccion"});
        view.getTblEstudiante().setModel(model);
    }
}
