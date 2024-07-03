/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Asistencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public class AsistenciasDAO {
    ///////INSERTAR HORA DE INGRESO////////
    public static void InsertarAsistencia(Asistencia e) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = ConexionDAO.getConexion();
            String sql = "{call InsertarAsistencia(?, ?, ?, ?)}"; 
            ps = connection.prepareCall(sql);
            ps.setTime(1, Time.valueOf(e.getHoraIngreso()));
            ps.setTime(2, Time.valueOf(e.getHoraSalida())); 
            ps.setDate(3, Date.valueOf(e.getFecha()));
            ps.setInt(4, e.getContrato().getIdContrato());
            
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

    ///////INSERTAR HORA DE SALIDA////////
    public static void InsertarSalida(int idAsistencia, LocalTime horaSalida) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = ConexionDAO.getConexion();
            String sql = "UPDATE Asistencia SET HoraSalida = ? WHERE idAsistencia = ?";
            ps = cn.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(horaSalida));
            ps.setInt(2, idAsistencia);
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }
    }

    //////MOSTRAR//////
    public static void mostrar(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idAsistencia", "HoraIngreso", "HoraSalida", "Fecha", "idContrato"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "{call MostrarTodasAsistencias}";
            ps = cn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idAsistencia = rs.getString("idAsistencia");
                String hIngreso = rs.getString("HoraIngreso");
                String hSalida = rs.getString("HoraSalida");
                String fecha = rs.getDate("Fecha").toString();
                String idContrato = rs.getString("idContrato");
                String fila[] = {idAsistencia, hIngreso, hSalida, fecha, idContrato};
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
