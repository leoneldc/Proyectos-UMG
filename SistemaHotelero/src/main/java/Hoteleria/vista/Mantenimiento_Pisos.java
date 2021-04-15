/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.vista;

import java.io.File;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Hoteleria.datos.PisosDAO;
import Hoteleria.dominio.Pisos;

/**
 *
 * @author Jeff
 */
public class Mantenimiento_Pisos extends javax.swing.JInternalFrame {

    ButtonGroup grupoDeRadios;
    DefaultTableModel modelo1;

    /**
     * Creates new form MantenimientoAplicacion
     */
    public Mantenimiento_Pisos() {
        initComponents();
        grupoDeRadios = new ButtonGroup();
        grupoDeRadios.add(btnRadioActivo);
        grupoDeRadios.add(btnRadioInactivo);
        //grupoDeRadios.add(btnRadioVacaciones);
        grupoDeRadios.add(btnRadioVacio);
        btnRadioVacio.setVisible(false);
        tabla();
    }

    public void tabla() {
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("No. Piso");
        modelo1.addColumn("Cantidad Habitaciones");
        modelo1.addColumn("Descripción");
        modelo1.addColumn("Estado");
        jTable.setModel(modelo1);
        String datos[] = new String[4];
        PisosDAO pisosDAO = new PisosDAO();
        List<Pisos> pisos = pisosDAO.select();
        for (Pisos piso : pisos) {
            datos[0] = String.valueOf(piso.getId_Numero_De_Piso());
            datos[1] = String.valueOf(piso.getCantidad_De_Habitaciones());
            datos[2] = piso.getDescripcion_De_Piso();
            datos[3] = String.valueOf(piso.getEstado_De_Piso());
            modelo1.addRow(datos);
            jTable.setModel(modelo1);
        }
    }

    public void limpiar() {
        txtNumeroDePiso.setText("");
        txtCantidadHabitaciones.setText("");
        txtaDescripcion.setText("");
        txtBuscar.setText("");
        btnRadioActivo.setSelected(false);
        btnRadioInactivo.setSelected(false);
        //btnRadioVacaciones.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroDePiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadHabitaciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnRadioActivo = new javax.swing.JRadioButton();
        btnRadioInactivo = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnRadioVacio = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Pisos");
        setToolTipText("");
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pisos"));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Buscar:");

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Número de Piso"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("No. de Piso:");

        txtNumeroDePiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroDePisoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad de habitaciones:");

        txtCantidadHabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadHabitacionesKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtaDescripcion);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Estado:");

        btnRadioActivo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnRadioActivo.setText("Activo");

        btnRadioInactivo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnRadioInactivo.setText("Inactivo");

        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnLimpiar.setText("Nuevo");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAyuda.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnRadioVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadioVacioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRadioActivo)
                                .addGap(18, 18, 18)
                                .addComponent(btnRadioInactivo)
                                .addGap(18, 18, 18)
                                .addComponent(btnRadioVacio))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(txtNumeroDePiso, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantidadHabitaciones, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(3, 3, 3)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroDePiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(btnRadioInactivo)
                        .addComponent(btnRadioActivo))
                    .addComponent(btnRadioVacio))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnAyuda))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(lblModulo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModulo)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        Pisos pisosInsertar = new Pisos();
        PisosDAO pisosDAO = new PisosDAO();

        if (txtNumeroDePiso.getText().length() != 0 && txtCantidadHabitaciones.getText().length() != 0
                && txtaDescripcion.getText().length() != 0
                && btnRadioActivo.isSelected() || btnRadioInactivo.isSelected()) {
            {
                pisosInsertar.setId_Numero_De_Piso(Integer.parseInt(txtNumeroDePiso.getText()));
                pisosInsertar.setCantidad_De_Habitaciones(Integer.parseInt(txtCantidadHabitaciones.getText()));
                pisosInsertar.setDescripcion_De_Piso(txtaDescripcion.getText());
                if (btnRadioInactivo.isSelected()) {
                    pisosInsertar.setEstado_De_Piso(0);
                }
                if (btnRadioActivo.isSelected()) {
                    pisosInsertar.setEstado_De_Piso(1);
                }
//                if (btnRadioVacaciones.isSelected()) {
//                    pisosInsertar.setEstado_De_Piso(2);
//                }
                btnRadioVacio.setSelected(true);
                limpiar();
                pisosDAO.insert(pisosInsertar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que estar llenos");
        }
        tabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        Pisos pisosModificar = new Pisos();
        PisosDAO pisosDAO = new PisosDAO();

        if (txtNumeroDePiso.getText().length() != 0 && txtCantidadHabitaciones.getText().length() != 0
                && txtaDescripcion.getText().length() != 0
                && btnRadioActivo.isSelected() || btnRadioInactivo.isSelected()) {
            {
                pisosModificar.setId_Numero_De_Piso(Integer.parseInt(txtNumeroDePiso.getText()));
                pisosModificar.setCantidad_De_Habitaciones(Integer.parseInt(txtCantidadHabitaciones.getText()));
                pisosModificar.setDescripcion_De_Piso(txtaDescripcion.getText());
                if (btnRadioInactivo.isSelected()) {
                    pisosModificar.setEstado_De_Piso(0);
                }
                if (btnRadioActivo.isSelected()) {
                    pisosModificar.setEstado_De_Piso(1);
                }
//                if (btnRadioVacaciones.isSelected()) {
//                    pisosModificar.setEstado_De_Piso(2);
//                }
                btnRadioVacio.setSelected(true);
                limpiar();
                pisosDAO.update(pisosModificar);
                JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que estar llenos");
        }
        tabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Pisos pisosBuscar = new Pisos();
        PisosDAO pisosDAO = new PisosDAO();
        pisosBuscar.setId_Numero_De_Piso(Integer.parseInt(txtBuscar.getText()));

        pisosBuscar = pisosDAO.query(pisosBuscar);

        txtNumeroDePiso.setText(String.valueOf(pisosBuscar.getId_Numero_De_Piso()));
        txtCantidadHabitaciones.setText(String.valueOf(pisosBuscar.getCantidad_De_Habitaciones()));
        txtaDescripcion.setText(String.valueOf(pisosBuscar.getDescripcion_De_Piso()));
        if (pisosBuscar.getEstado_De_Piso() == 0) {
            btnRadioInactivo.setSelected(true);
        }
        if (pisosBuscar.getEstado_De_Piso() == 1) {
            btnRadioActivo.setSelected(true);
        }
//        if (pisosBuscar.getEstado_De_Piso() == 2) {
//            btnRadioVacaciones.setSelected(true);
//        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        btnRadioVacio.setVisible(false);
        btnRadioVacio.setSelected(true);
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNumeroDePisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDePisoKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
        }
    }//GEN-LAST:event_txtNumeroDePisoKeyTyped

    private void txtCantidadHabitacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadHabitacionesKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
        }
    }//GEN-LAST:event_txtCantidadHabitacionesKeyTyped

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed

        try {
            if ((new File("src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoAplicación.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoAplicación.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnRadioVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadioVacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRadioVacioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JRadioButton btnRadioActivo;
    private javax.swing.JRadioButton btnRadioInactivo;
    private javax.swing.JRadioButton btnRadioVacio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidadHabitaciones;
    private javax.swing.JTextField txtNumeroDePiso;
    private javax.swing.JTextArea txtaDescripcion;
    // End of variables declaration//GEN-END:variables
}
