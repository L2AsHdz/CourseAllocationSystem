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
public class SuperView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public SuperView() {
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

        jPanel1 = new javax.swing.JPanel();
        pnlDesk = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        itmRead = new javax.swing.JMenuItem();
        asdasda = new javax.swing.JMenu();
        itmsUsers = new javax.swing.JMenuItem();
        itmEdificios = new javax.swing.JMenuItem();
        itmCursos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu2.setText("Archivo de entrada");

        itmRead.setText("Leer archivo");
        jMenu2.add(itmRead);

        jMenuBar1.add(jMenu2);

        asdasda.setText("Entidades");

        itmsUsers.setText("Manejo de usuarios");
        asdasda.add(itmsUsers);

        itmEdificios.setText("Manejo de edificios y salones");
        asdasda.add(itmEdificios);

        itmCursos.setText("Manejo de cursos");
        asdasda.add(itmCursos);

        jMenuBar1.add(asdasda);

        jMenu1.setText("Login");

        itmCambiarU.setText("Cambiar usuario");
        jMenu1.add(itmCambiarU);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu asdasda;
    private javax.swing.JMenuItem itmCambiarU;
    private javax.swing.JMenuItem itmCursos;
    private javax.swing.JMenuItem itmEdificios;
    private javax.swing.JMenuItem itmRead;
    private javax.swing.JMenuItem itmsUsers;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlDesk;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getItmCambiarU() {
        return itmCambiarU;
    }

    public JMenuItem getItmCursos() {
        return itmCursos;
    }

    public JMenuItem getItmEdificios() {
        return itmEdificios;
    }

    public JMenuItem getItmRead() {
        return itmRead;
    }

    public JMenuItem getItmsUsers() {
        return itmsUsers;
    }

    public JPanel getPnlDesk() {
        return pnlDesk;
    }
}