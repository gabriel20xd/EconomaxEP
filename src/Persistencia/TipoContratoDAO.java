/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.TipoContrato;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public class TipoContratoDAO {
//////INSERTAR///////
    public static void InsertarTipoContrato(String Descripcion) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConexionDAO.getConexion();
            String sql = "{call InsertarTipoContrato(?)}";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, Descripcion);
            callableStatement.executeUpdate();
        } finally {
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
/////MOSTRAR////////
    public static void mostrarTipoContrato(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idTipoContrato", "Descripcion"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
        cn = ConexionDAO.getConexion();
        String sql = "{call MostrarTodosTipoContratos}";
        ps = cn.prepareCall(sql);
        rs = ps.executeQuery();

        // Procesar el ResultSet
        while (rs.next()) {
            String id = rs.getString("idTipoContrato");
            String nombre = rs.getString("Descripcion");
            // Crear una fila con los datos
            String fila[] = {id, nombre};
            modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            // Cerrar los recursos
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* ignored */ }
            if (ps != null) try { ps.close(); } catch (SQLException e) { /* ignored */ }
            if (cn != null) try { cn.close(); } catch (SQLException e) { /* ignored */ }
        }
}
    
    public int obtenerIdTipoContratoPorDescripcion(String descripcion) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idTipoContrato = -1;

        try {
            connection = ConexionDAO.getConexion();
            String sql = "SELECT idTipoContrato FROM TipoContrato WHERE TiempoContrato = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, descripcion);
            rs = ps.executeQuery();

            if (rs.next()) {
                idTipoContrato = rs.getInt("idTipoContrato");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return idTipoContrato;
    }
}
