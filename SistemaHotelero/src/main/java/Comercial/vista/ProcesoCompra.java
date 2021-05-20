/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;
import java.sql.Connection;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Comercial.dominio.Producto;
import Comercial.dominio.Compra;
import Comercial.dominio.Proveedor;
import Comercial.datos.ProveedorDAO1;
import Comercial.datos.CompraDAO;
import Comercial.datos.ProductoDAO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import Comercial.datos.Conexion;
import java.io.File;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
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

/**
 *
 * @author SipaqueRitaMaria
 */
public class ProcesoCompra extends javax.swing.JInternalFrame {
      ProveedorDAO1 cargarCombobox = new ProveedorDAO1();
    int estadovalidacion;
    ProductoDAO productos = new ProductoDAO();
    int variable1;
    DefaultTableModel model = new DefaultTableModel();
     ButtonGroup RadiosGrupo;
     int codigoAplicacion = 3007;
    
     
     public void llenadoDeTablas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.FACTURA");
        model.addColumn("NO.PROVEEDOR");
        model.addColumn("NOMBRE");
        model.addColumn("NIT");
        model.addColumn("ID");
        
        
       model.addColumn("PRODUCTO");
        model.addColumn("PRECIO");
        model.addColumn("CANTIDAD");
        model.addColumn("SUBTOTAL");
        model.addColumn("FECHA");
        model.addColumn("PAGO");
        
        CompraDAO proveedorDAO = new CompraDAO();
        
        List<Compra> proveedor = proveedorDAO.select();
        tbtTabla.setModel(model);
        String[] dato = new String[11];
        for (int i = 0; i < proveedor.size(); i++) {
            dato[0] = Integer.toString(proveedor.get(i).getId_factura());
            dato[1] = proveedor.get(i).getId_proveedor();
            dato[2] = proveedor.get(i).getNombre_proveedor();
            dato[3] = proveedor.get(i).getNit_proveedor();
            dato[4] = proveedor.get(i).getId_producto();
            dato[5] = proveedor.get(i).getNombre_producto();
            dato[6] = proveedor.get(i).getPrecio_producto();
            dato[7] = proveedor.get(i).getCantidad_producto();
            dato[8] = proveedor.get(i).getSubtotal_producto();
            dato[9] = proveedor.get(i).getFecha_producto();
            dato[10] = proveedor.get(i).getPago_producto();
            
            
            //System.out.println("vendedor:" + vendedores);
            model.addRow(dato);
            
            
            
        }
            
             
     }
     
     
     
     
    void habilitarAcciones() {

        int codigoAplicacion = 3001;
        var usuario = Login.usuarioComercial;

        GenerarCompra.setEnabled(false);
        validar.setEnabled(false);
        valiar.setEnabled(false);
        Eliminar.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[4];

        for (int i = 0; i < 4; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            GenerarCompra.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            validar.setEnabled(true);
        }
        if (permisosApp[2].equals("1")) {
            valiar.setEnabled(true);
        }
        if (permisosApp[3].equals("1")) {
            Eliminar.setEnabled(true);
        }
        
         
        
         
        
        
        
        
     }
    
    
   
        
    /**
     * Creates new form ProcesoCompra
     */ public void buscar() {
       Compra proveedorAConsultar = new Compra();
        CompraDAO proveedorDAO = new CompraDAO();
        proveedorAConsultar.setId_factura(Integer.parseInt(txt_idfacutra.getText()));
        proveedorAConsultar = proveedorDAO.query(proveedorAConsultar);
         txt_combox.setSelectedItem(proveedorAConsultar.getId_proveedor());
       
         txt_nombre.setText(proveedorAConsultar.getNombre_proveedor());
        txt_nit.setText(proveedorAConsultar.getNit_proveedor());
        uno.setSelectedItem(proveedorAConsultar.getId_producto());
        txt_nombreproducto.setText(proveedorAConsultar.getNombre_producto());
        txt_precio.setText(proveedorAConsultar.getPrecio_producto());
        txt_cantidad.setText(proveedorAConsultar.getCantidad_producto());
        txt_1.setText(proveedorAConsultar.getSubtotal_producto());
        txt_total.setText(proveedorAConsultar.getSubtotal_producto());
        
        txt_fecha.setText(proveedorAConsultar.getFecha_producto());
        pago.setSelectedItem(proveedorAConsultar.getId_proveedor());
        
        
      
        
        
     }


    public ProcesoCompra() {
        initComponents();
        llenadoDeTablas();
        cargarCombobox.query2(txt_combox);
        productos.query2(uno);

        model.addColumn("No.FACTURA");
        model.addColumn("NO.PROVEEDOR");
        model.addColumn("NOMBRE");
        model.addColumn("NIT");
        model.addColumn("NOMBRE");
        model.addColumn("PRECIO");
        
        model.addColumn("NO.PRODUCTO");
        model.addColumn("CANTIDAD");
        model.addColumn("SUBTOTAL");
        
        model.addColumn("FECHA");
         model.addColumn("PAGO");
       

        this.tbtTabla.setModel(model);
        
        Date sistFecha=new Date ();
        SimpleDateFormat formato =new SimpleDateFormat("dd-MMM-YYYY");
        txt_fecha.setText(formato.format(sistFecha));
        RadiosGrupo = new ButtonGroup();
//        RadiosGrupo.add(RBEP1);
//        RadiosGrupo.add(RBEP0);
//        RadiosGrupo.add(RBEPvacio);
//        RBEPvacio.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRODUCTO = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_nit = new javax.swing.JTextField();
        txt_combox = new javax.swing.JComboBox<>();
        validar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_fecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        uno = new javax.swing.JComboBox<>();
        txt_nombreproducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        valiar = new javax.swing.JButton();
        RBEP0 = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtTabla = new javax.swing.JTable();
        txt_idfacutra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        GenerarCompra = new javax.swing.JButton();
        Ayuda = new javax.swing.JButton();
        Ayuda1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        pago = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout PRODUCTOLayout = new javax.swing.GroupLayout(PRODUCTO.getContentPane());
        PRODUCTO.getContentPane().setLayout(PRODUCTOLayout);
        PRODUCTOLayout.setHorizontalGroup(
            PRODUCTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PRODUCTOLayout.setVerticalGroup(
            PRODUCTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proceso Compra");
        setToolTipText("");
        setVisible(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Proveedor"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nit Proveedor:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Id Proveedor : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nombre Proeedor:");

        validar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        validar.setText("Buscar");
        validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_combox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(validar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Compra"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Id Producto:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Nombre Producto");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Precio:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Cantidad:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Fecha:");

        valiar.setText("Buscar");
        valiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valiarActionPerformed(evt);
            }
        });

        RBEP0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RBEP0.setText("Exsistencia");
        RBEP0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBEP0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valiar)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RBEP0))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RBEP0)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Forma de pago");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DetalleCompra"));

        jLabel15.setText("Total");

        jLabel16.setText("SubTotal");

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        tbtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Eliminar)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Eliminar)
                            .addComponent(jButton1)
                            .addComponent(jLabel16)
                            .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Factura De  Compras");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText(" No. de Factura :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText(" Nit :001250089 56");

        GenerarCompra.setText("GenerarCompra");
        GenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarCompraActionPerformed(evt);
            }
        });

        Ayuda.setText("Ayuda");
        Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaActionPerformed(evt);
            }
        });

        Ayuda1.setText("Buscar");
        Ayuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ayuda1ActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17)
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txt_idfacutra, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21)))
                        .addComponent(Ayuda1)
                        .addGap(152, 152, 152)
                        .addComponent(Ayuda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(GenerarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_idfacutra)
                                .addComponent(Ayuda1))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Ayuda)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GenerarCompra)
                        .addComponent(btnModificar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                + "/src/main/java/Comercial/reportes/Compra.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Proceso compras");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
         txt_idfacutra.setText("");
        txt_nombre.setText("");
         txt_combox.setSelectedIndex(0);
       
        txt_nit.setText("");
        
        model.getDataVector().removeAllElements();
        tbtTabla.updateUI();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
 
        
      
              eliminara();

        
        
        
    }//GEN-LAST:event_EliminarActionPerformed

    private void valiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valiarActionPerformed
        // TODO add your handling code here:
        String valor1 = uno.getSelectedItem().toString();
        int valor1int = Integer.parseInt(valor1);
        ProductoDAO perfilDAO = new ProductoDAO();
        Producto perfilconsultar = new Producto();
        perfilconsultar.setPK_id_producto(valor1int);
        perfilconsultar = perfilDAO.query(perfilconsultar);
        if (perfilconsultar.getPK_id_producto() != 0) {
            variable1 = 1;
            txt_nombreproducto.setText(perfilconsultar.getNombre_producto());
            txt_precio.setText(String.valueOf(perfilconsultar.getPrecio_producto()));

        } else {

            variable1 = 0;
        }
    }//GEN-LAST:event_valiarActionPerformed

    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed
        // TODO add your handling code here:
       
        

          String valor = txt_combox.getSelectedItem().toString();
        int valorint = Integer.parseInt(valor);
        ProveedorDAO1 perfilDAO = new ProveedorDAO1();
        Proveedor perfilconsultar = new Proveedor();
        perfilconsultar.setPK_id_proveedor(valorint);
        perfilconsultar = perfilDAO.query(perfilconsultar);
        if (perfilconsultar.getPK_id_proveedor() != 0) {
            estadovalidacion = 1;

            txt_nombre.setText(perfilconsultar.getNombre_proveedor());
            

            txt_nit.setText(perfilconsultar.getNit_proveedor());
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
        
        
    }//GEN-LAST:event_validarActionPerformed

    private void RBEP0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBEP0ActionPerformed
        // TODO add your handling code here:
 Proceso_Producto uno= new Proceso_Producto();
MDIComercial.jdpescritorio.add(uno);
uno.toFront();
uno.setVisible(true);
Proceso_Producto.txtProductoNuevo.setText(txt_nombreproducto.getText());
Proceso_Producto.txtNuevaExistencia.setText(txt_cantidad.getText());

        
        
        
    }//GEN-LAST:event_RBEP0ActionPerformed

    private void GenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarCompraActionPerformed
        // TODO add your handling code here:

        double S = 0, tot;
        for (int i = 0; i < tbtTabla.getRowCount(); i++) {
            S = S + Double.parseDouble(model.getValueAt(i, 8).toString());

        }
        S = redondear(S);
        //txt_subtotal.setText(String.valueOf(S));

        tot = S;
        tot = redondear(tot);

        txt_total.setText(String.valueOf(tot));

        if (txt_cantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE LA CANTIDAD A COMPRAR", "SISTEMA", JOptionPane.WARNING_MESSAGE);
            txt_cantidad.requestFocus();
            return;
        }
        if (txt_precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE EL PRECIO DEL PRODUCTO", "SISTEMA", JOptionPane.WARNING_MESSAGE);
            txt_precio.requestFocus();
            return;
        }
        //Entrada
        String datos[] = new String[11];
        datos[0] = txt_idfacutra.getText();
        datos[1] = txt_combox.getSelectedItem().toString();
        datos[2] = txt_nombre.getText();
        datos[3] = txt_nit.getText();
        datos[4] = uno.getSelectedItem().toString();
        datos[5] = txt_nombreproducto.getText();
        datos[6] = txt_precio.getText();
        datos[7] = txt_cantidad.getText();

        Double imp = Double.parseDouble(datos[6]) * Double.parseDouble(datos[7]);
        imp = redondear(imp);
        datos[8] = imp.toString();

        txt_1.setText(String.valueOf(imp));
        txt_total.setText(String.valueOf(tot));
        datos[9] = txt_fecha.getText();
        datos[10] = pago.getSelectedItem().toString();
       

        model.addRow(datos);
        calTot();

        CompraDAO proveedorDAO = new CompraDAO();
        Compra proveedorAInsertar = new Compra();
        proveedorAInsertar.setId_factura((int) Integer.parseInt(txt_idfacutra.getText()));
        proveedorAInsertar.setId_proveedor(txt_combox.getSelectedItem().toString());
        proveedorAInsertar.setNombre_proveedor(txt_nombre.getText());
        proveedorAInsertar.setNit_proveedor(txt_nit.getText());
        proveedorAInsertar.setId_producto(uno.getSelectedItem().toString());
        proveedorAInsertar.setNombre_producto(txt_nombreproducto.getText());
        proveedorAInsertar.setPrecio_producto(txt_precio.getText());
        proveedorAInsertar.setCantidad_producto(txt_cantidad.getText());
        proveedorAInsertar.setSubtotal_producto(txt_1.getText());
        proveedorAInsertar.setTotal_producto(txt_total.getText());
        proveedorAInsertar.setFecha_producto(txt_fecha.getText());
        proveedorAInsertar.setPago_producto(pago.getSelectedItem().toString());

        proveedorDAO.insert(proveedorAInsertar);

        JOptionPane.showMessageDialog(this, "COMPRA REALIZADA", "SISTEMA", JOptionPane.INFORMATION_MESSAGE);

        uno.setSelectedIndex(0);
        txt_nombreproducto.setText("");
        txt_precio.setText("");
        txt_cantidad.setText("");
        txt_1.setText("");
        pago.setSelectedIndex(0);
        BitacoraDao BitacoraDAO = new BitacoraDao();
            
        
       Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Guardar");

        Insertar.setCodigoAplicacion("3007");
        Insertar.setModulo("3000");
            try {
                BitacoraDAO.insert(Insertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        
            }
llenadoDeTablas();
    }//GEN-LAST:event_GenerarCompraActionPerformed

    private void AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaProcesoCompra.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaProcesoCompra.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         llenadoDeTablas();
    }//GEN-LAST:event_AyudaActionPerformed

    private void Ayuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ayuda1ActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_Ayuda1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        CompraDAO proveedorDAO = new  CompraDAO();
        Compra proveedorAActualizar = new Compra();
                
        proveedorAActualizar.setId_factura(Integer.parseInt(txt_idfacutra.getText()));
        proveedorAActualizar.setId_proveedor(txt_combox.getSelectedItem().toString());
        proveedorAActualizar.setNombre_proveedor(txt_nombre.getText());
        proveedorAActualizar.setNit_proveedor(txt_nit.getText());
        proveedorAActualizar.setId_proveedor(uno.getSelectedItem().toString());
        proveedorAActualizar.setNombre_producto(txt_nombreproducto.getText());
        proveedorAActualizar.setPrecio_producto(txt_precio.getText());
        proveedorAActualizar.setCantidad_producto(txt_cantidad.getText());
        proveedorAActualizar.setSubtotal_producto(txt_1.getText());
        proveedorAActualizar.setTotal_producto(txt_total.getText());
        proveedorAActualizar.setFecha_producto(txt_fecha.getText());
        proveedorAActualizar.setPago_producto(pago.getSelectedItem().toString());
        

        proveedorDAO.update(proveedorAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");

        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Modifcar");

        Insertar.setCodigoAplicacion("3007");
        Insertar.setModulo("3000");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
         llenadoDeTablas();

//        llenadoDeTablas();
//        limpiar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed
private double redondear(double num) {
        return Math.rint(num * 100) / 100;
    }

    private void eliminar() {
        int rpta = JOptionPane.showConfirmDialog(this, "ESTA SEGURO DE ELIMINAR ESTA FILA", "SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        int fil;

        if (model.getRowCount() > 0) {
            if (tbtTabla.getSelectedRow() != -1) {

                fil = tbtTabla.getSelectedRow();
                model.removeRow(fil);
                calTot();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Una Fila");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");
        }
    }

    private void calTot() {
        double S = 0, tot;
        for (int i = 0; i < tbtTabla.getRowCount(); i++) {
            S = S + Double.parseDouble(model.getValueAt(i, 8).toString());
            
        }
        S = redondear(S);
        //txt_subtotal.setText(String.valueOf(S));

        tot = S;
        tot = redondear(tot);
        
        txt_total.setText(String.valueOf(tot));
    }private Connection connection = null;

    private void eliminara() {
        int rpta = JOptionPane.showConfirmDialog(this, "ESTA SEGURO DE ELIMINAR ESTA FILA", "SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        int fil;

        if (model.getRowCount() > 0) {
            if (tbtTabla.getSelectedRow() != -1) {

                fil = tbtTabla.getSelectedRow();
                model.removeRow(fil);
                calTot();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Una Fila");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");
        }}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ayuda;
    private javax.swing.JButton Ayuda1;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton GenerarCompra;
    private javax.swing.JDialog PRODUCTO;
    private javax.swing.JRadioButton RBEP0;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pago;
    private javax.swing.JTable tbtTabla;
    private javax.swing.JTextField txt_1;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JComboBox<String> txt_combox;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_idfacutra;
    private javax.swing.JTextField txt_nit;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreproducto;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_total;
    private javax.swing.JComboBox<String> uno;
    private javax.swing.JButton valiar;
    private javax.swing.JButton validar;
    // End of variables declaration//GEN-END:variables
}
