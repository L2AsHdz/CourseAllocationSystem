/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseallocationsystem.view;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author asael
 */
public class ColaboradorView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalColaboradorView
     */
    public ColaboradorView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDesk = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmCursos = new javax.swing.JMenuItem();
        itmEstudiantes = new javax.swing.JMenuItem();
        itmCatedraticos = new javax.swing.JMenuItem();
        itmHorarios = new javax.swing.JMenuItem();
        itmAsignaciones = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itmCambiarU = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CourseAllocationSystem");

        javax.swing.GroupLayout pnlDeskLayout = new javax.swing.GroupLayout(pnlDesk);
        pnlDesk.setLayout(pnlDeskLayout);
        pnlDeskLayout.setHorizontalGroup(
            pnlDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnlDeskLayout.setVerticalGroup(
            pnlDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        jMenu1.setText("Entidades");

        itmCursos.setText("Manejo de cursos");
        jMenu1.add(itmCursos);

        itmEstudiantes.setText("Manejo de estudiantes");
        jMenu1.add(itmEstudiantes);

        itmCatedraticos.setText("Manejo de catedraticos");
        jMenu1.add(itmCatedraticos);

        itmHorarios.setText("Manejo de horarios");
        jMenu1.add(itmHorarios);

        itmAsignaciones.setText("Manjeo de asignaciones");
        jMenu1.add(itmAsignaciones);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Login");

        itmCambiarU.setText("Cambiar usuario");
        jMenu2.add(itmCambiarU);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAsignaciones;
    private javax.swing.JMenuItem itmCambiarU;
    private javax.swing.JMenuItem itmCatedraticos;
    private javax.swing.JMenuItem itmCursos;
    private javax.swing.JMenuItem itmEstudiantes;
    private javax.swing.JMenuItem itmHorarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel pnlDesk;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getItmAsignaciones() {
        return itmAsignaciones;
    }

    public JMenuItem getItmCambiarU() {
        return itmCambiarU;
    }

    public JMenuItem getItmCatedraticos() {
        return itmCatedraticos;
    }

    public JMenuItem getItmCursos() {
        return itmCursos;
    }

    public JMenuItem getItmEstudiantes() {
        return itmEstudiantes;
    }

    public JMenuItem getItmHorarios() {
        return itmHorarios;
    }

    public JPanel getPnlDesk() {
        return pnlDesk;
    }
}