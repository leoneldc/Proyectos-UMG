/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Finanzas.datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Finanzas.dominio.TransaccionBancaria;

/**
 * 
 * @author Santiago Martinez Diaz
 */
public class TransaccionBancariaDAO {
    private static final String sql_select = "SELECT Codigo_Transaccion, Fecha_Transaccion, Beneficiario,Cuenta_Bancaria,Tipo_Transaccion,Monto_Transaccion,Concepto_Transaccion FROM TransaccionBancaria";
    private static final String sql_insert = "INSERT INTO TransaccionBancaria VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE TransaccionBancaria SET Monto_Transaccion=? WHERE Monto_Transaccion = ?";
    private static final String sql_delete = "DELETE FROM TransaccionBancaria WHERE Codigo_Transaccion=?";
    private static final String sql_query = "SELECT Codigo_Transaccion, Fecha_Transaccion, Beneficiario,Cuenta_Bancaria,Tipo_Transaccion,Monto_Transaccion,Concepto_Transaccion  FROM TransaccionBancaria WHERE Codigo_Transaccion=?";

    public List<TransaccionBancaria> listar(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TransaccionBancaria tipos = null;
        List<TransaccionBancaria> tipo1 = new ArrayList<TransaccionBancaria>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
              String Codigo_Transaccion = rs.getString("Codigo_Transaccion");
              String Fecha_Transaccion = rs.getString("Fecha_Transaccion");
              String Beneficiario = rs.getString("Beneficiario");
              String Cuenta_Bancaria = rs.getString("Cuenta_Bancaria");
              String Tipo_Transaccion = rs.getString("Tipo_Transaccion");
              String Monto_Transaccion = rs.getString("Monto_Transaccion");
              String Concepto_Transaccion = rs.getString("Concepto_Transaccion");
              
   
                tipos = new TransaccionBancaria();
               tipos.setCodigo_Transaccion(Codigo_Transaccion);
                tipos.setFecha_Transaccion(Fecha_Transaccion);
                tipos.setBeneficiario(Beneficiario);
                 tipos.setCuenta_Bancaria(Cuenta_Bancaria);
                tipos.setTipo_Transaccion(Tipo_Transaccion);
                tipos.setMonto_Transaccion(Monto_Transaccion);
                 tipos.setConcepto_Transaccion(Concepto_Transaccion);


             

                tipo1.add(tipos);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tipo1;
    }

    public int insert(TransaccionBancaria tipo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, tipo.getCodigo_Transaccion());
            stmt.setString(2, tipo.getFecha_Transaccion());
            stmt.setString(3, tipo.getBeneficiario());
            stmt.setString(4, tipo.getCuenta_Bancaria());
            stmt.setString(5, tipo.getTipo_Transaccion());
            stmt.setString(6, tipo.getMonto_Transaccion());
            stmt.setString(7, tipo.getConcepto_Transaccion());


            rows = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }
       public int update(TransaccionBancaria cuenta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
          stmt.setString(1, cuenta.getMonto_Transaccion());

 
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }


    public int delete(TransaccionBancaria tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, tipo.getCodigo_Transaccion());
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " Eliminado Con Exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public TransaccionBancaria query(TransaccionBancaria tipot) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TransaccionBancaria> tipotr = new ArrayList<TransaccionBancaria>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, tipot.getCodigo_Transaccion());
            rs = stmt.executeQuery();
            while (rs.next()) {
           String Codigo_Transaccion = rs.getString("Codigo_Transaccion");
              String Fecha_Transaccion = rs.getString("Fecha_Transaccion");
              String Beneficiario = rs.getString("Beneficiario");
              String Cuenta_Bancaria = rs.getString("Cuenta_Bancaria");
              String Tipo_Transaccion = rs.getString("Tipo_Transaccion");
              String Monto_Transaccion = rs.getString("Monto_Transaccion");
              String Concepto_Transaccion = rs.getString("Concepto_Transaccion");
              
   
                tipot = new TransaccionBancaria();
               tipot.setCodigo_Transaccion(Codigo_Transaccion);
                tipot.setFecha_Transaccion(Fecha_Transaccion);
                tipot.setBeneficiario(Beneficiario);
                 tipot.setCuenta_Bancaria(Cuenta_Bancaria);
                tipot.setTipo_Transaccion(Tipo_Transaccion);
                tipot.setMonto_Transaccion(Monto_Transaccion);
                 tipot.setConcepto_Transaccion(Concepto_Transaccion);
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipot;
    }



    
}
