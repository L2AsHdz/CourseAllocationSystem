package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.imagegenerator.list.CircularListImageGenerator;
import courseallocationsystem.model.Curso;
import courseallocationsystem.validator.CursoValidator;
import courseallocationsystem.view.jpanels.CursoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CursosController implements ActionListener {
    
    private final CursoView view;
    private final Data data = Data.getData();
    
    private String codigo;
    private String nombre;
    private String semestre;
    private String creditos;

    public CursosController(CursoView cursoView) {
        this.view = cursoView;

        this.view.getBtnAgregar().addActionListener(this);
        this.view.getBtnActualizar().addActionListener(this);
        this.view.getBtnBorrar().addActionListener(this);
        this.view.getBtnVerImagen().addActionListener(this);
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
        Object s = actionEvent.getSource();
        if (s == view.getBtnAgregar()) {
            agregar();
        } else if (s == view.getBtnActualizar()) {
            actualizar();
        } else if (s == view.getBtnBorrar()) {
            borrar();
        } else if (s == view.getBtnVerImagen()) {
            CircularListImageGenerator<Curso, Integer> cursoGen = 
                    new CircularListImageGenerator(data.getCursos(), "cursos");
            cursoGen.generate();
        }
    }

    private void borrar() {
        int codigo = Integer.parseInt(view.getTxtCodigo().getText());
        
        if (data.getCursos().get(codigo) == null) {
            view.getLblError().setText("El curso " + codigo + " - " + nombre + " no existe");
        } else {
            data.getCursos().remove(codigo);
        }
        updateTable();
    }

    private void actualizar() {
        obtenerDatos();
        
        if (data.getCursos().get(Integer.parseInt(codigo)) == null) {
            view.getLblError().setText("El curso " + codigo + " - " + nombre + " no existe");
        } else {
            data.getCursos().update(new Curso(nombre, Integer.parseInt(semestre), Integer.parseInt(creditos), Integer.parseInt(codigo)));
        }
        updateTable();
    }

    private void agregar() {
        obtenerDatos();
        
        String error = CursoValidator.validateCurso(Integer.parseInt(codigo));
        
        if (error.isEmpty()) {
            data.getCursos().add(new Curso(nombre, Integer.parseInt(semestre), Integer.parseInt(creditos), Integer.parseInt(codigo)));
        } else {
            view.getLblError().setText(error);
        }
        updateTable();
    }
    
    private void obtenerDatos() {
        codigo = view.getTxtCodigo().getText();
        nombre = view.getTxtNombre().getText();
        semestre = view.getTxtSemestre().getText();
        creditos = view.getTxtCreditos().getText();
    }
    
    private void updateTable() {
        DefaultTableModel model = data.getCursos().toTable(new String[]{"Codigo", "Nombre", "Semestre", "Creditos"});
        view.getTblCurso().setModel(model);
    }
}
