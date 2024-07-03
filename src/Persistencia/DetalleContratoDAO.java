/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.DetalleContrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class DetalleContratoDAO {
     // Método para insertar un DetalleContrato en la base de datos
    public static void insertarDetalleContrato(DetalleContrato detalle) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = ConexionDAO.getConexion();
            String sql = "INSERT INTO DetalleContrato (salarioHora, horasTrabajadas, horasContratadasAlMes, tardanzasTotales, ausencias, adelantoSueldo, horasExtrasTrabajadas, idContrato, idPago) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setDouble(1, detalle.getSalarioHora());
            ps.setInt(2, detalle.getHorasTrabajadas());
            ps.setInt(3, detalle.getHorasContratadasAlMes());
            ps.setInt(4, detalle.getTardanzasTotales());
            ps.setInt(5, detalle.getAusencias());
            ps.setInt(6, detalle.getAdelantoSueldo());
            ps.setInt(7, detalle.getHorasExtrasTrabajadas());
            ps.setInt(8, detalle.getContrato().getIdContrato());
            ps.setInt(9, detalle.getPago().getIdPago());

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }
    }

    // Método para mostrar todos los DetalleContrato en una tabla
    public static void mostrar(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idDetalleContrato", "salarioHora", "horasTrabajadas", "horasContratadasAlMes", "tardanzasTotales", "ausencias", "adelantoSueldo", "horasExtrasTrabajadas", "idContrato", "idPago"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "SELECT * FROM DetalleContrato";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idDetalleContrato = rs.getString("idDetalleContrato");
                String salarioHora = rs.getString("salarioHora");
                String horasTrabajadas = rs.getString("horasTrabajadas");
                String horasContratadasAlMes = rs.getString("horasContratadasAlMes");
                String tardanzasTotales = rs.getString("tardanzasTotales");
                String ausencias = rs.getString("ausencias");
                String adelantoSueldo = rs.getString("adelantoSueldo");
                String horasExtrasTrabajadas = rs.getString("horasExtrasTrabajadas");
                String idContrato = rs.getString("idContrato");
                String idPago = rs.getString("idPago");
                String fila[] = {idDetalleContrato, salarioHora, horasTrabajadas, horasContratadasAlMes, tardanzasTotales, ausencias, adelantoSueldo, horasExtrasTrabajadas, idContrato, idPago};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* ignored */ }
            if (ps != null) try { ps.close(); } catch (SQLException e) { /* ignored */ }
            if (cn != null) try { cn.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
}
