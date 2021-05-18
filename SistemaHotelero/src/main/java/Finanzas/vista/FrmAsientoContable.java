/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.dominio.AsientoContable;
import Finanzas.dominio.CuentaContable;
import Finanzas.dominio.PartidaContable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Vásquez
 */
public class FrmAsientoContable extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmAsientoContable
     */
    AsientoContable asientoContable = new AsientoContable();
    PartidaContable partidaContable = new PartidaContable();

    void setCodigoAsiento() {
        String codigoAsientoContable = asientoContable.CodigoAsientoContable();
        TxtCodigoAsiento.setText(codigoAsientoContable);
    }

    void setCodigoPartida() {
        String codigoPartidaContable = partidaContable.CodigoPartidaContable();
        TxtCodigoPartida.setText(codigoPartidaContable);
    }

    private void comboBoxCuenta() {
        CuentaContable objCuenta = new CuentaContable();

        objCuenta.getTablaRegistros();

        int contI = 0;
        contI = objCuenta.getTablaRegistros().length;

        String[][] matrixData = new String[contI][3];

        for (int i = 0; i < contI; i++) {
            for (int j = 0; j < 3; j++) {
                matrixData[i][j] = objCuenta.getTablaRegistros()[i][j];
            }
        }

        for (int i = 0; i < contI; i++) {
            CmbCuenta.addItem(matrixData[i][0]);
        }

    }

    private void comboBoxEncabezado() {
        AsientoContable objAsiento = new AsientoContable();

        objAsiento.getRegistrosEncabezado();

        int contI = 0;
        contI = objAsiento.getRegistrosEncabezado().length;

        String[][] matrixData = new String[contI][1];

        for (int i = 0; i < contI; i++) {
            for (int j = 0; j < 1; j++) {
                matrixData[i][j] = objAsiento.getRegistrosEncabezado()[i][j];
            }
        }

        for (int i = 0; i < contI; i++) {
            CmbEncabezado.addItem(matrixData[i][0]);
        }

    }

    private void comboBoxPeriodos() {
        AsientoContable objAsiento = new AsientoContable();

        objAsiento.getRegistrosEncabezado();

        int contI = 0;
        contI = objAsiento.getRegistrosPeriodos().length;

        String[][] matrixData = new String[contI][1];

        for (int i = 0; i < contI; i++) {
            for (int j = 0; j < 1; j++) {
                matrixData[i][j] = objAsiento.getRegistrosPeriodos()[i][j];
            }
        }

        for (int i = 0; i < contI; i++) {
            CmbPeriodoFiscal.addItem(matrixData[i][0]);
        }

    }

    private void comboBoxTipos() {
        AsientoContable objAsiento = new AsientoContable();

        objAsiento.getTipoAsientos();

        int contI = 0;
        contI = objAsiento.getTipoAsientos().length;

        String[] matrixData = new String[contI];

        for (int i = 0; i < contI; i++) {

            matrixData[i] = objAsiento.getTipoAsientos()[i];

        }

        for (int i = 0; i < contI; i++) {
            CmbTipoAsiento.addItem(matrixData[i]);
        }

    }

    public FrmAsientoContable() {
        initComponents();
        setCodigoAsiento();
        comboBoxCuenta();
        comboBoxEncabezado();
        comboBoxPeriodos();
        comboBoxTipos();
        RbtDebe.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCodigoPartida = new javax.swing.JTextField();
        DateChooserFechaPartida = new com.toedter.calendar.JDateChooser();
        CmbPeriodoFiscal = new javax.swing.JComboBox<>();
        TxtGlosaContable = new javax.swing.JTextField();
        BtnAceptarPartida = new javax.swing.JButton();
        BtnBuscarPartida = new javax.swing.JButton();
        BtnNuevaPartida = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();
        BtnAyuda = new javax.swing.JButton();
        TxtFecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtCodigoAsiento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TxtMonto = new javax.swing.JTextField();
        RbtDebe = new javax.swing.JRadioButton();
        RbtHaber = new javax.swing.JRadioButton();
        BtnRegistrarAsiento = new javax.swing.JButton();
        BtnRegistrarDetalle = new javax.swing.JButton();
        CmbCuenta = new javax.swing.JComboBox<>();
        TxtPartida = new javax.swing.JTextField();
        CmbTipoAsiento = new javax.swing.JComboBox<>();
        BtnImprimir = new javax.swing.JButton();
        BtnVerificarPartida = new javax.swing.JButton();
        BtnBuscarEncabezado = new javax.swing.JButton();
        CmbEncabezado = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Asiento Contable");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Partida Contable", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Código Partida Contable:");

        jLabel2.setText("Fecha Partida Contable:");

        jLabel3.setText("Período Fiscal:");

        jLabel4.setText("Glosa Partida:");

        TxtCodigoPartida.setEnabled(false);

        DateChooserFechaPartida.setEnabled(false);

        CmbPeriodoFiscal.setEnabled(false);

        TxtGlosaContable.setEnabled(false);

        BtnAceptarPartida.setText("Aceptar");
        BtnAceptarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarPartidaActionPerformed(evt);
            }
        });

        BtnBuscarPartida.setText("...");
        BtnBuscarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarPartidaActionPerformed(evt);
            }
        });

        BtnNuevaPartida.setText("Nueva");
        BtnNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevaPartidaActionPerformed(evt);
            }
        });

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.setEnabled(false);
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        BtnAyuda.setText("?");

        TxtFecha.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtCodigoPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBuscarPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnNuevaPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAyuda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtGlosaContable, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAceptarPartida))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CmbPeriodoFiscal, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtCodigoPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBuscarPartida)
                        .addComponent(BtnNuevaPartida)
                        .addComponent(BtnRegistrar)
                        .addComponent(BtnAyuda))
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CmbPeriodoFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtGlosaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAceptarPartida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asiento Contable", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel5.setText("Código de Detalle:");

        TxtCodigoAsiento.setEditable(false);

        jLabel6.setText("Cuenta:");

        jLabel7.setText("Partida:");

        jLabel8.setText("Encabezado:");

        jLabel9.setText("Tipo Asiento:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto"));

        buttonGroup1.add(RbtDebe);
        RbtDebe.setText("Debe");

        buttonGroup1.add(RbtHaber);
        RbtHaber.setText("Haber");

        BtnRegistrarAsiento.setText("Registrar");
        BtnRegistrarAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarAsientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtMonto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnRegistrarAsiento))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RbtDebe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RbtHaber)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbtDebe)
                    .addComponent(RbtHaber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRegistrarAsiento)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        BtnRegistrarDetalle.setText("Registrar Detalle");
        BtnRegistrarDetalle.setEnabled(false);
        BtnRegistrarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarDetalleActionPerformed(evt);
            }
        });

        TxtPartida.setEditable(false);

        BtnImprimir.setText("Imprimir");

        BtnVerificarPartida.setText("Cuadrar Partida");
        BtnVerificarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerificarPartidaActionPerformed(evt);
            }
        });

        BtnBuscarEncabezado.setText("...");
        BtnBuscarEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarEncabezadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtPartida)
                    .addComponent(CmbEncabezado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbTipoAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TxtCodigoAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnRegistrarDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnVerificarPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnBuscarEncabezado)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtCodigoAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(BtnBuscarEncabezado)
                            .addComponent(CmbEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CmbTipoAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegistrarDetalle)
                    .addComponent(BtnImprimir)
                    .addComponent(BtnVerificarPartida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarEncabezadoActionPerformed
        FrmEncabezadoAsiento frmEncabezadoAsiento = null;
        try {
            frmEncabezadoAsiento = new FrmEncabezadoAsiento();
        } catch (SQLException ex) {
            Logger.getLogger(FrmAsientoContable.class.getName()).log(Level.SEVERE, null, ex);
        }
        frmEncabezadoAsiento.setVisible(true);
    }//GEN-LAST:event_BtnBuscarEncabezadoActionPerformed

    private void BtnNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevaPartidaActionPerformed

        setCodigoPartida();

        TxtFecha.setEnabled(true);

        DateChooserFechaPartida.setEnabled(true);

        CmbPeriodoFiscal.setEnabled(true);
        TxtGlosaContable.setEnabled(true);
        BtnRegistrar.setEnabled(true);
        BtnNuevaPartida.setEnabled(false);
        BtnBuscarPartida.setEnabled(false);
        BtnAceptarPartida.setEnabled(false);
    }//GEN-LAST:event_BtnNuevaPartidaActionPerformed

    private void BtnAceptarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarPartidaActionPerformed

        if (!TxtCodigoPartida.getText().equals("")) {
            String codigoPartidaContable = "";
            codigoPartidaContable = TxtCodigoPartida.getText();
            TxtPartida.setText(codigoPartidaContable);
        } else {
            JOptionPane.showMessageDialog(null, "El Campo: 'Código Partida', está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtnAceptarPartidaActionPerformed

    private void BtnBuscarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarPartidaActionPerformed
        CodigosPartidaContable codigosPartidaContable = new CodigosPartidaContable();
        codigosPartidaContable.varOP = 1;
        codigosPartidaContable.setVisible(true);
    }//GEN-LAST:event_BtnBuscarPartidaActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed

        PartidaContable objPartidaContable = new PartidaContable();

        objPartidaContable.setCodigoPartidaContable(TxtCodigoPartida.getText());
        objPartidaContable.setFechaPartidaContable(TxtFecha.getText());
        objPartidaContable.setPeriodoFiscalPartida((CmbPeriodoFiscal.getSelectedItem().toString()));
        objPartidaContable.setGlosaPartidaContable(TxtGlosaContable.getText());

        objPartidaContable.RegistrarPartida(objPartidaContable);

        TxtCodigoPartida.setEnabled(false);
        TxtFecha.setEnabled(false);
        CmbPeriodoFiscal.setEnabled(false);
        TxtGlosaContable.setEnabled(false);

        TxtCodigoPartida.setText("");
        TxtFecha.setText("");
        CmbPeriodoFiscal.setSelectedIndex(0);
        TxtGlosaContable.setText("");

        BtnRegistrar.setEnabled(false);
        BtnAceptarPartida.setEnabled(true);
        BtnBuscarPartida.setEnabled(true);
        BtnBuscarEncabezado.setEnabled(true);


    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnRegistrarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarAsientoActionPerformed

        if (!TxtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para finalizar, presione el botón: 'Registrar Detalle'", "Advertencia", JOptionPane.WARNING_MESSAGE);
            BtnRegistrarDetalle.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "El Campo: 'Monto', está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtnRegistrarAsientoActionPerformed

    private void BtnRegistrarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarDetalleActionPerformed
        AsientoContable asientoContable = new AsientoContable();

        asientoContable.setCodigo_DetalleAsiento(TxtCodigoAsiento.getText());
        asientoContable.setCuentaContable_Asiento(CmbCuenta.getSelectedItem().toString());
        asientoContable.setPartida_Asiento(TxtPartida.getText());
        asientoContable.setTipo_Asiento(CmbTipoAsiento.getSelectedItem().toString());
        asientoContable.setEncabezado_Asiento(CmbEncabezado.getSelectedItem().toString());

        if (RbtDebe.isSelected()) {
            asientoContable.setMonto_Debe(TxtMonto.getText());
            asientoContable.setMonto_Haber("0");
        }
        if (RbtHaber.isSelected()) {
            asientoContable.setMonto_Debe("0");
            asientoContable.setMonto_Haber(TxtMonto.getText());
        }

        asientoContable.RegistrarDetalle(asientoContable);

        setCodigoAsiento();

        TxtMonto.setText("");
        BtnRegistrarDetalle.setEnabled(false);
    }//GEN-LAST:event_BtnRegistrarDetalleActionPerformed

    private void BtnVerificarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerificarPartidaActionPerformed
        FrmCuadre frmCuadre = new FrmCuadre();
        frmCuadre.setVisible(true);
    }//GEN-LAST:event_BtnVerificarPartidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptarPartida;
    private javax.swing.JButton BtnAyuda;
    private javax.swing.JButton BtnBuscarEncabezado;
    private javax.swing.JButton BtnBuscarPartida;
    private javax.swing.JButton BtnImprimir;
    private javax.swing.JButton BtnNuevaPartida;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton BtnRegistrarAsiento;
    private javax.swing.JButton BtnRegistrarDetalle;
    private javax.swing.JButton BtnVerificarPartida;
    private javax.swing.JComboBox<String> CmbCuenta;
    private javax.swing.JComboBox<String> CmbEncabezado;
    public static javax.swing.JComboBox<String> CmbPeriodoFiscal;
    private javax.swing.JComboBox<String> CmbTipoAsiento;
    public static com.toedter.calendar.JDateChooser DateChooserFechaPartida;
    private javax.swing.JRadioButton RbtDebe;
    private javax.swing.JRadioButton RbtHaber;
    private javax.swing.JTextField TxtCodigoAsiento;
    public static javax.swing.JTextField TxtCodigoPartida;
    public static javax.swing.JTextField TxtFecha;
    public static javax.swing.JTextField TxtGlosaContable;
    private javax.swing.JTextField TxtMonto;
    private javax.swing.JTextField TxtPartida;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
