/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.Conexion;
import Comercial.datos.ProcesoProductoDAO;
import Comercial.datos.ProductoDAO;
import Comercial.datos.ProveedorDAO1;
import Comercial.dominio.ProcesoProducto;
import Comercial.dominio.Producto;
import Comercial.dominio.Proveedor;
import java.awt.HeadlessException;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;
import seguridad.vista.MDI_Components;

/**
 *
 * @author Diana
 */
public class Proceso_Producto extends javax.swing.JInternalFrame {

    ProcesoProductoDAO procesoproducto = new ProcesoProductoDAO();
    int estadovalidacion;
    ProcesoProducto Buscar = new ProcesoProducto();

    /**
     * Creates new form Proceso_Producto
     */
       public void llenadoDeCombos2() {

        List<ProcesoProducto> Bus =procesoproducto.select();
        
        for (int i = 0; i < Bus.size(); i++) {
            cbox_empleado1.addItem(Bus.get(i).getNombre_producto());
            String valor = cbox_empleado1.getSelectedItem().toString();
//              producto.setNombre_producto(producto.getText());
            

        }
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Producto");
        modelo.addColumn("Bodega");
        modelo.addColumn("Existencias");
        modelo.addColumn("Fecha de Entrega");
        modelo.addColumn("Bodega");
        modelo.addColumn("Nueva Existencia");
        modelo.addColumn("Nueva Bodega");

        ProcesoProductoDAO procesoproductoDAO = new ProcesoProductoDAO();
        List<ProcesoProducto> procesoproducto = procesoproductoDAO.select();
        TablaProducto.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < procesoproducto.size(); i++) {
            dato[0] = Integer.toString(procesoproducto.get(i).getPK_id_procesoproducto());
            dato[1] = procesoproducto.get(i).getNombre_producto();
            dato[2] = procesoproducto.get(i).getNombre_bodega();
            dato[3] = procesoproducto.get(i).getExistencias_producto();
            dato[4] = procesoproducto.get(i).getBodegasNuevaExistencia();
            dato[5] = procesoproducto.get(i).getNuevaExistencia();
            dato[6] = procesoproducto.get(i).getBodegasNuevaExistencia();

            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void limpiar() {
        //   txt_combox.setText("");
        txtnombrebodega.setText("");
        txtExistenciasProducto.setText("");
//        txt_fechaActualizacion.setText("");
        txtProductoNuevo.setText("");
        txtNuevaExistencia.setText("");

    }

    public void buscar() {
        //  Buscar.setNombre_producto(txt_combox.getText());
        Buscar = procesoproducto.query(Buscar);
        txtnombrebodega.setText(Buscar.getNombre_bodega());
        txtExistenciasProducto.setText(Buscar.getExistencias_producto());
        txtProductoNuevo.setText(Buscar.getProductoNuevo());
        // cbox_BodegasNuevaExistencia.setText(Buscar.getBodegasNuevaExistencia());

    }

    public Proceso_Producto() {
        initComponents();
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        // txtfechaActualizacion.setCalendar(formato(sistFecha));
    }

//    public void llenadoDeCombos2() {
//        // List<Cliente> Bus = Cliente.select();
////        txt_combox.addItem("Productos Disponibles");
////        for (int i = 0; i < Bus.size(); i++) {
////            txt_combox.addItem(Bus.get(i).getCliente());
////            String valor = txt_combox.getSelectedItem().toString();
////    }
//    }
//              Buscar1.setCliente(cliente.getText());
//Buscar1=Clientes.query2(Buscar1);
//
//
////precio.setText(Buscar.);
//E.setText(Buscar1.getCliente());

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombrebodega = new javax.swing.JTextField();
        txtExistenciasProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtfechaActualizacion = new com.toedter.calendar.JDateChooser();
        txtProdcuto = new javax.swing.JTextField();
        cbox_empleado1 = new javax.swing.JComboBox<>();
        btnAyuda = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProductoNuevo = new javax.swing.JTextField();
        txtNuevaExistencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtExistenciasTotales = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        txtBodegasNuevaExistencia = new javax.swing.JTextField();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proceso Productos");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PROCESO PRODUCTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Producto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Bodega");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Existencias");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de Actualización");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtfechaActualizacion.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtExistenciasProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(txtfechaActualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(128, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombrebodega, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbox_empleado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnBuscar)))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtProdcuto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnBuscar)
                    .addComponent(cbox_empleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProdcuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombrebodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtExistenciasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtfechaActualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaProducto);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporte)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnReporte)
                    .addComponent(btnGuardar))
                .addGap(40, 40, 40))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevos Articulos"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Producto");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nueva existencia");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Bodega");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Existencias totales");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtProductoNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtNuevaExistencia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtExistenciasTotales)
                    .addComponent(txtBodegasNuevaExistencia))
                .addGap(35, 35, 35)
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProductoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNuevaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtExistenciasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtBodegasNuevaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(435, 435, 435)
                .addComponent(btnAyuda)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAyuda)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Connection connection = null;

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:}buscar();
        ProcesoProductoDAO productoDAO = new ProcesoProductoDAO();
        ProcesoProducto productoAActualizar = new ProcesoProducto();
        // productoAActualizar.setPK_id_producto(Integer.parseInt(txt_IdProducto.getText()));
        productoAActualizar.setNombre_producto(txtnombrebodega.getText());
        productoAActualizar.setNombre_producto(txtExistenciasProducto.getText());
//        productoAActualizar.setFechaIngreso_producto(fechaActualizacion.getText());
        productoDAO.update(productoAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");

        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario("MantenimientoProductos");
        Insertar.setAccion("Modificar");
        Insertar.setCodigoAplicacion("3010");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaProcesoProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaProcesoProducto.chm");
                p.waitFor();

            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/Comercial/reportes/ProcesoProducto.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Proceso Productos");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String valor = cbox_empleado1.getSelectedItem().toString();
        int valorint = Integer.parseInt(valor);
        ProductoDAO perfilDAO = new ProductoDAO();
        Producto perfilconsultar = new Producto();
        perfilconsultar.setPK_id_producto(valorint);
        perfilconsultar = perfilDAO.query(perfilconsultar);
        if (perfilconsultar.getPK_id_producto() != 0) {
            estadovalidacion = 1;
            txtProdcuto.setText(perfilconsultar.getNombre_producto());
            txtnombrebodega.setText(perfilconsultar.getBodega());
            //      txtfechaActualizacion.setCalendar(perfilconsultar.getFechaIngreso());
        } else {

            estadovalidacion = 0;
        }

        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Buscar");

        Insertar.setCodigoAplicacion("3007");
        Insertar.setModulo("3000");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ProcesoProductoDAO productoDAO = new ProcesoProductoDAO();
        ProcesoProducto productoAEliminar = new ProcesoProducto();
        productoAEliminar.setPK_id_procesoproducto(Integer.parseInt(cbox_empleado1.getItemAt(WIDTH)));
        productoDAO.delete(productoAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");

        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario("MantenimientoProductos");
        Insertar.setAccion("Modificar");
        Insertar.setCodigoAplicacion("3010");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        GenerarPermisos permisos = new GenerarPermisos();
        MDI_Components mdi_Components = new MDI_Components();
        String cbx_AccesoSeguridad = cbox_empleado1.getSelectedItem().toString();
        String id = "0";
        MantenimientoProductos manteminetoProductosDAO = new MantenimientoProductos();
        ProcesoProductoDAO productoDAO = new ProcesoProductoDAO();
        ProcesoProducto productoAInsertar = new ProcesoProducto();

        productoAInsertar.setPK_id_procesoproducto((int) Integer.parseInt(cbox_empleado1.getActionCommand()));
        productoAInsertar.setNombre_producto(cbox_empleado1.getSelectedItem().toString());
        productoAInsertar.setNombre_bodega(txtnombrebodega.getText());
        productoAInsertar.setExistencias_producto(txtExistenciasProducto.getText());
        productoAInsertar.setFechaActualizacion(txtfechaActualizacion.getDateFormatString());
        productoAInsertar.setProductoNuevo(txtProductoNuevo.getText());
        productoAInsertar.setNuevaExistencia(txtNuevaExistencia.getText());
        productoAInsertar.setBodegasNuevaExistencia(txtBodegasNuevaExistencia.getText());
        productoDAO.insert(productoAInsertar);

        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario("MantenimientoProductos");
        Insertar.setAccion("Insertar");
        Insertar.setCodigoAplicacion("3000");
        Insertar.setId_Usuario(Login.usuarioComercial);

        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int numero1, numero2, total;
        numero1 = Integer.parseInt(txtExistenciasProducto.getText());
        numero2 = Integer.parseInt(txtNuevaExistencia.getText());

        total = numero1 + numero2;
        txtExistenciasTotales.setText(String.valueOf(total));
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProducto;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbox_empleado1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBodegasNuevaExistencia;
    public static javax.swing.JTextField txtExistenciasProducto;
    private javax.swing.JTextField txtExistenciasTotales;
    public static javax.swing.JTextField txtNuevaExistencia;
    private javax.swing.JTextField txtProdcuto;
    public static javax.swing.JTextField txtProductoNuevo;
    private com.toedter.calendar.JDateChooser txtfechaActualizacion;
    public static javax.swing.JTextField txtnombrebodega;
    // End of variables declaration//GEN-END:variables
}
