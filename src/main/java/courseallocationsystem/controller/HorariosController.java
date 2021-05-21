package courseallocationsystem.controller;

import courseallocationsystem.datos.Data;
import courseallocationsystem.imagegenerator.tree.HorariosImageGenerator;
import courseallocationsystem.view.jpanels.HorarioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class HorariosController implements ActionListener {
    
    private final HorarioView view;
    private final Data data = Data.getData();

    public HorariosController(HorarioView horarioView) {
        this.view = horarioView;

        this.view.getBtnAgregar().addActionListener(this);
        this.view.getBtnActualizar().addActionListener(this);
        this.view.getBtnBorrar().addActionListener(this);
        this.view.getBtnVerImage().addActionListener(this);
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
        } else if (e == view.getBtnVerImage()) {
            HorariosImageGenerator horarioGen = new HorariosImageGenerator(data.getHorarios());
            horarioGen.generate();
            data.getHorarios().printTree(data.getHorarios().getRoot(), 0);
        }
    }

    private void agregar() {

    }

    private void actualizar() {

    }

    private void borrar() {

    }

    private void updateTable() {
        data.getCatedraticos().setTitles(new String[]{"Id", "Periodo", "Dia", "Cod Curso",
        "Cod Salon", "Cod Edificio", "Id Catedratico"});
        data.getHorarios().fillDefaultTableModel(data.getHorarios().getRoot());
        DefaultTableModel model = data.getHorarios().getModel();
        view.getTblHorario().setModel(model);
    }
}
