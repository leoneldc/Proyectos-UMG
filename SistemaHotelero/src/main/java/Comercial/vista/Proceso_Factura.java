/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;
import Comercial.datos.ClienteDao;
import Comercial.datos.Conexion;

import Comercial.datos.facturaDao;
import Comercial.dominio.Cliente;

import Comercial.dominio.Factura;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
 * @author PERSONAL
 */
public class Proceso_Factura extends javax.swing.JInternalFrame {
  ClienteDao Clientes= new   ClienteDao  ();
  Cliente Buscar = new  Cliente ();
  ClienteDao Clientes1= new   ClienteDao  ();
  Cliente Buscar1 = new  Cliente ();
     facturaDao factura = new   facturaDao  ();
                Factura buscarf = new  Factura();
                
                  void habilitarAcciones() {

        int codigoAplicacion = 3006;
        var usuario = Login.usuarioComercial;

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[4];

        for (int i = 0; i < 4; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            btnAgregar.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            btnBuscar.setEnabled(true);
        }
        if (permisosApp[2].equals("1")) {
            btnModificar.setEnabled(true);
        }
        if (permisosApp[3].equals("1")) {
            btnEliminar.setEnabled(true);
        }
    }

  
   DefaultTableModel modelo = new DefaultTableModel();  
  int estadovalidacion;
    
    int variable1;
    /**
     * Creates new form Proceso_Factura
     */
//    
     public void llenadoDeCombos() {
        
        List<Cliente> Buscar =  Clientes.select();
        cbox_empleado.addItem("Seleccione un cliente");
        for (int i = 0; i < Buscar.size(); i++) {
            cbox_empleado.addItem(Buscar.get(i).getCliente());
             String valor =  cbox_empleado.getSelectedItem().toString();
   

    }}
        public void llenadoDeCombos2() {
        
        List<Cliente> Bus =  Clientes.select();
        cbox_empleado1.addItem("Productos Disponibles");
        for (int i = 0; i < Bus.size(); i++) {
            cbox_empleado1.addItem(Bus.get(i).getCliente());
             String valor =  cbox_empleado1.getSelectedItem().toString();
              Buscar1.setCliente(cliente.getText());
Buscar1=Clientes.query2(Buscar1);


//precio.setText(Buscar.);
E.setText(Buscar1.getCliente());
   

    }}
     
     
     public void validar(){ 
         String valor =  cbox_empleado.getSelectedItem().toString();
    
       
        Buscar.setCliente(valor);
       Buscar =   Clientes.query2( Buscar);
      
            estadovalidacion = 1;
            cliente.setText(  Buscar.getCliente());
              E.setText(  Buscar.getCliente());
     
 buscarVendedor();         
    

            estadovalidacion = 0;
        }
    public Proceso_Factura() {
         initComponents();
         llenadoDeCombos();
       tot.setText("0");
         llenadoDeTablas2();
         llenadoDeCombos2() ;
         buscarf.setId_cliente(id.getText());
buscarf=factura.query(buscarf);

monto.setText(buscarf.getMonto());
////         
    }
public void llenadoDeTablas2() {
        /**
 *
 * creaccion de la tabla de de titulos  
 */
        DefaultTableModel modelo = new DefaultTableModel();
   
          modelo.addColumn("Id_Cliente");
        modelo.addColumn("Cliente");
        modelo.addColumn("Nit");
          modelo.addColumn("Telefono");
          modelo.addColumn("Poducto");
            modelo.addColumn("cantidad");
          modelo.addColumn("Precio"); 
           modelo.addColumn("Monto");
  
    facturaDao  venta = new   facturaDao();
       List<Factura> ventas = venta.select();
        JtProductos1.setModel(modelo);
        String[] dato = new String[8];
    for (int i = 0; i < ventas.size(); i++) {
          dato[0] = ventas.get(i).getId_cliente();
            dato[1] = ventas.get(i).getCliente();
              dato[2] = (ventas.get(i).getNit());
            dato[3] = (ventas.get(i).getTelefono());
          dato[4] = (ventas.get(i).getProducto());
              dato[5] = (ventas.get(i).getPrecio_por_unidad()); 
                 dato[6] = (ventas.get(i).getCantidad()); 
          dato[7] =  (ventas.get(i).getMonto());
           
            
            
          
          
          
            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
     }      
    

private double redondear(double num) {
        return Math.rint(num * 100) / 100;
    }
public void buscarVendedor() {
     
   
 Buscar1.setCliente(cliente.getText());
Buscar1=Clientes.query2(Buscar1);

nit.setText(Buscar1.getNit());
//precio.setText(Buscar.);
telefono.setText(Buscar1.getTelefono());

}
public void buscarVendedor1() {
     
   
buscarf.setId_cliente(id.getText());
buscarf=factura.query(buscarf);
cliente.setText(buscarf.getCliente());
nit.setText(buscarf.getNit());
precio.setText(buscarf.getPrecio_por_unidad());
telefono.setText(buscarf.getTelefono());
producto.setText(buscarf.getProducto());
tot.setText(buscarf.getTotalmoNto());
monto.setText(buscarf.getMonto());
cantidad.setText(buscarf.getCantidad());

}
    public void limpiar() {
        id.setText("");
        cliente.setText("");
        nit.setText("");
        monto.setText("");
       precio.setText("");
        telefono.setText("");
           producto.setText("");
            monto.setText("");
             cantidad.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        nit = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        producto = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtProductos1 = new javax.swing.JTable();
        cbox_empleado = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        monto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        cbox_empleado1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        E = new javax.swing.JLabel();
        RBEP0 = new javax.swing.JRadioButton();
        RBEP1 = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Procesos Factura");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Total");

        tot.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pedido de  Factura");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nit");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText(" Producto");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Precio por Unidad");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Cantidad");

        JtProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtProductos1);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Generar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        monto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Monto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ID");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("Reporte");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbox_empleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_empleado1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Existencias");

        RBEP0.setText("Tarjeta");
        RBEP0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBEP0ActionPerformed(evt);
            }
        });

        RBEP1.setText("Tarjeta");
        RBEP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBEP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7)
                            .addComponent(btnModificar))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(btnAgregar))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(368, 368, 368))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(producto)
                                    .addComponent(telefono)
                                    .addComponent(nit)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id)
                                    .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(11, 11, 11)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbox_empleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel11)
                                .addGap(36, 36, 36)
                                .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RBEP1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(430, 430, 430)
                    .addComponent(RBEP0)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbox_empleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(RBEP1)
                                .addGap(26, 26, 26)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton6)
                            .addComponent(jButton1)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(RBEP0)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    
//   
float t3 ;     
float t2 ;
float t1 ;

        t2=Float.parseFloat(E.getText());
        t3=Float.parseFloat(cantidad.getText());
      
      JtProductos1.getModel();

   
    t1=t2-t3;
    if(t3<0){
     JOptionPane.showMessageDialog(null, " No se encuentra con suficientes insumos para realizar esta venta");
    }
    E.setText(String.valueOf(t1));
          String[] dato = new String[7];
   
         
            dato[0] = cliente.getText();
              dato[1] = nit.getText();
            dato[2] = telefono.getText();
          dato[3] = producto.getText();
           dato[4] =precio.getText();
            dato[5] = cantidad.getText();
             Double imp = Double.parseDouble(dato[4]) * Double.parseDouble(dato[5]);
        imp = redondear(imp);
        dato[6] = imp.toString();
        monto.setText(String.valueOf(imp));
        modelo.addRow(dato);
               facturaDao ClienteDAO = new   facturaDao  ();
                Factura AInsertar = new  Factura();
               AInsertar.setId_cliente(id.getText());
                AInsertar.setCliente(cliente.getText());
                AInsertar.setNit(nit.getText());    
                AInsertar.setTelefono(telefono.getText());
                AInsertar.setProducto(producto.getText());
                 AInsertar.setCantidad(cantidad.getText());
                 AInsertar.setPrecio_por_unidad(precio.getText());
                   AInsertar.setTotalmoNto(tot.getText());
                       AInsertar.setMonto(monto.getText());
                ClienteDAO.insert(AInsertar);
      llenadoDeTablas2();   
   
     
      
      
float tot3 ;     
float tot2 ;
 String nodo1,nodo2,noda4;
 String r;
        tot2=Float.parseFloat(tot.getText());
        tot3=Float.parseFloat(monto.getText());
      
      JtProductos1.getModel();

   
    tot2=tot2+tot3;
    tot.setText(String.valueOf(tot2));
    BitacoraDao BitacoraDAO = new BitacoraDao();
            
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Insertar");
    
 Insertar.setCodigoAplicacion("3005");
           Insertar.setModulo("3000");

            try {
                BitacoraDAO.insert(Insertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
          JOptionPane.showMessageDialog(null, " A sido  un exito");
     
    // TODO add your handling code here:
    
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 validar();
      
BitacoraDao BitacoraDAO = new BitacoraDao();
            
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Buscar");
    
 Insertar.setCodigoAplicacion("3005");
           Insertar.setModulo("3000");

            try {
                BitacoraDAO.insert(Insertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 buscarVendedor1();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      float tot3 ;     
float tot2 ;
float tot4 ;
 String nodo1,nodo2,noda4;
 String r;
        tot2=Float.parseFloat(tot.getText());
        tot3=Float.parseFloat(monto.getText());
      
      JtProductos1.getModel();

   
    tot4=tot2-tot3;
    tot.setText(String.valueOf(tot4));
        facturaDao DAO = new   facturaDao  ();
                Factura AEliminar = new  Factura();
               AEliminar.setId_cliente(id.getText());
                AEliminar.setCliente(cliente.getText());
                AEliminar.setNit(nit.getText());    
                AEliminar.setTelefono(telefono.getText());
                AEliminar.setProducto(producto.getText());
                 AEliminar.setCantidad(cantidad.getText());
                 AEliminar.setPrecio_por_unidad(precio.getText());
                  AEliminar.setTotalmoNto(tot.getText());
                    AEliminar.setMonto(monto.getText());
                DAO.delete(AEliminar);
      llenadoDeTablas2();


    BitacoraDao BitacoraDAO = new BitacoraDao();
            
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Eliminar");
    
 Insertar.setCodigoAplicacion("3005");
           Insertar.setModulo("3000");

            try {
                BitacoraDAO.insert(Insertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
              JOptionPane.showMessageDialog(null, " A sido  un exito");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    facturaDao Da1 = new   facturaDao  ();
             
                Factura AModifica1 = new  Factura();
        AModifica1.setId_cliente(id.getText());

        AModifica1.setCliente(cliente.getText());
        AModifica1.setNit(nit.getText());
        AModifica1.setTelefono(telefono.getText());
        AModifica1.setProducto(producto.getText());
        AModifica1.setPrecio_por_unidad(precio.getText());
        AModifica1.setCantidad(cantidad.getText());
        AModifica1.setTotalmoNto(tot.getText());
        AModifica1.setMonto(monto.getText());
        Da1.update(AModifica1);
           llenadoDeTablas2();
            
                    BitacoraDao BitacoraDAO = new BitacoraDao();
            limpiar();
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Modificar");
    
 Insertar.setCodigoAplicacion("3006");
           Insertar.setModulo("3000");

            try {
                BitacoraDAO.insert(Insertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed
private Connection connection = null;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
          Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                + "/src/main/java/Comercial/reportes/PFactura.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("deudor ");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\facturapedido.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\facturapedido.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RBEP0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBEP0ActionPerformed
        // TODO add your handling code here:

        prueba uno= new prueba();
        MDIComercial.jdpescritorio.add(uno);
        uno.toFront();
        uno.setVisible(true);

    }//GEN-LAST:event_RBEP0ActionPerformed

    private void RBEP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBEP1ActionPerformed
prueba uno= new prueba();
MDIComercial.jdpescritorio.add(uno);
uno.toFront();
uno.setVisible(true);



        // TODO add your handling code here:
    }//GEN-LAST:event_RBEP1ActionPerformed

    private void cbox_empleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_empleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_empleado1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel E;
    private javax.swing.JTable JtProductos1;
    private javax.swing.JRadioButton RBEP0;
    private javax.swing.JRadioButton RBEP1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> cbox_empleado;
    private javax.swing.JComboBox<String> cbox_empleado1;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel monto;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField producto;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
