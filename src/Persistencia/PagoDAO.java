/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Pago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public class PagoDAO {
// Método para insertar un Pago en la base de datos
    public static void insertarPago(Pago pago) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = ConexionDAO.getConexion();
            String sql = "INSERT INTO Pago (FechaPago, Estado, MontoTotal) VALUES (?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(pago.getFechaPago()));
            ps.setString(2, pago.getEstado());
            ps.setDouble(3, pago.getMonto());

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }
    }

    // Método para mostrar todos los Pagos en una tabla
    public static void mostrar(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idPago", "FechaPago", "Estado", "MontoTotal"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "SELECT * FROM Pago";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idPago = rs.getString("idPago");
                String fechaPago = rs.getDate("FechaPago").toString();
                String estado = rs.getString("Estado");
                String montoTotal = rs.getString("MontoTotal");
                String fila[] = {idPago, fechaPago, estado, montoTotal};
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
 // Método para filtrar pagos por DNI
    public static void filtrarPagosPorDni(DefaultTableModel modelo, String dni) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idPago", "FechaPago", "Estado", "MontoTotal", "dni"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "SELECT * FROM Pago WHERE dni = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idPago = rs.getString("idPago");
                String fechaPago = rs.getDate("FechaPago").toString();
                String estado = rs.getString("Estado");
                String montoTotal = rs.getString("MontoTotal");
                String dniResultado = rs.getString("dni");
                String fila[] = {idPago, fechaPago, estado, montoTotal, dniResultado};
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
 // Método para filtrar pagos por año
    public static void filtrarPagosPorAno(DefaultTableModel modelo, int ano) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idPago", "FechaPago", "Estado", "MontoTotal"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "SELECT * FROM Pago WHERE YEAR(FechaPago) = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, ano);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idPago = rs.getString("idPago");
                String fechaPago = rs.getDate("FechaPago").toString();
                String estado = rs.getString("Estado");
                String montoTotal = rs.getString("MontoTotal");
                String fila[] = {idPago, fechaPago, estado, montoTotal};
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
    // Método para verificar si ya existe un pago en un mes específico
    public static boolean existePagoEnMes(int contratoId, LocalDate fechaPago) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            cn = ConexionDAO.getConexion();
            String sql = "SELECT COUNT(*) FROM Pago WHERE idContrato = ? AND YEAR(FechaPago) = ? AND MONTH(FechaPago) = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, contratoId);
            ps.setInt(2, fechaPago.getYear());
            ps.setInt(3, fechaPago.getMonthValue());
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                existe = true;
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }

        return existe;
    }
}
