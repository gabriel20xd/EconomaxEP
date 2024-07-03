/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public class ContratoDAO {
    ///////INSERTAR//////
    public static void InsertarContrato(Contrato c) throws SQLException {
    Connection connection = null;
    PreparedStatement ps = null;

    try {
        connection = ConexionDAO.getConexion();
        String sql = "{call InsertarContrato(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ps = connection.prepareCall(sql);
        ps.setDate(1, java.sql.Date.valueOf(c.getFechaInicio()));          
        ps.setDate(2, java.sql.Date.valueOf(c.getFinContrato()));            
        ps.setString(3, c.getArea());                                    
        ps.setDouble(4, c.getSueldo());                              
        ps.setInt(5, c.getHorasXdia());                                 
        ps.setInt(6, c.getHorasContratadasXmes());                      
        ps.setString(7, c.getEstado());                                  
        ps.setDate(8, java.sql.Date.valueOf(c.getFecha()));              
        ps.setInt(9, c.getEmpleado().getIdEmpleado());                    
        ps.setInt(10, c.getTipocontrato().getIdTipoContrato());          
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        throw ex;
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
            }
        }
    }
    //////ACTUALIZAR/////

    public static void actualizarContrato(Contrato c) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConexionDAO.getConexion();            
            String sql = "{call ActualizarContrato(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            ps = connection.prepareCall(sql);
            ps.setDate(1, java.sql.Date.valueOf(c.getFechaInicio()));
            ps.setDate(2, java.sql.Date.valueOf(c.getFinContrato()));
            ps.setString(3, c.getArea());
            ps.setDouble(4, c.getSueldo());
            ps.setInt(5, c.getHorasXdia());
            ps.setInt(6, c.getHorasContratadasXmes());
            ps.setString(7, c.getEstado());
            ps.setDate(8, java.sql.Date.valueOf(c.getFecha()));
            ps.setInt(9, c.getEmpleado().getIdEmpleado());
            ps.setInt(10, c.getTipocontrato().getIdTipoContrato());
            ps.setInt(11, c.getIdContrato());           
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    /////ELIMINAR//////   
    public static void EliminarContrato(int idContrato, String nuevoEstado) throws SQLException {
        Connection connection = null;
    PreparedStatement ps = null;
    
    try {
        connection = ConexionDAO.getConexion();
        String sql = ("{call sp_ActualizarEstadoContrato(?, ?)}");
        ps = connection.prepareCall(sql);
        ps.setInt(1, idContrato);
        ps.setString(2, nuevoEstado);
        // Ejecuta el procedimiento almacenado
        ps.executeUpdate();
    } finally {
        // Asegúrate de cerrar los recursos
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    }
    /////MOSTRAR//////
    public static void mostrar(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idContrato", "Nombre", "Apellido", "DNI", "Fecha_Inicio", 
                            "Fecha_Fin", "Area", "Sueldo", "HorasDiarias", 
                            "Horas_Contratadas", "Fecha", "TipoContrato"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "{call MostrarTodosContratos}";
            ps = cn.prepareCall(sql);
            rs = ps.executeQuery();
            // Procesar el ResultSet
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("idContrato"));
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String dni = rs.getString("DNI");
                String fecha_inicio = rs.getString("F_Ini_con");
                String fecha_fin = rs.getString("F_Fin_Con");
                String area = rs.getString("Area");
                String sueldo = String.valueOf(rs.getDouble("Sueldo"));
                String horasDiarias = String.valueOf(rs.getInt("Horasaldia"));
                String horasContratadas = String.valueOf(rs.getInt("Horascontratadasalmes"));
                String fecha = rs.getDate("Fecha").toString();
                String tipoContrato = rs.getString("TipoContrato");
                // Crear una fila con los datos
                String fila[] = {id, nombre, apellido, dni, fecha_inicio, fecha_fin, area, sueldo, 
                                 horasDiarias, horasContratadas, fecha, tipoContrato};
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
}
