/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Vacaciones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public class VacacionesDAO {
//////INSERTAR///////
    public static void insertarVacaciones(Vacaciones vacaciones) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = ConexionDAO.getConexion();
            String sql = "INSERT INTO Vacaciones (F_Ini, F_Fin, Comentario, Estado, idContrato) VALUES (?, ?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(vacaciones.getFechaInicio()));
            ps.setDate(2, Date.valueOf(vacaciones.getFechaFinal()));
            ps.setString(3, vacaciones.getComentario());
            ps.setString(4, vacaciones.getEstado());
            ps.setInt(5, vacaciones.getContrato().getIdContrato());

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }
    }
/////MOSTRAR///////
    public static void mostrar(DefaultTableModel modelo) throws SQLException {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String titulos[] = {"idVacaciones", "F_Ini", "F_Fin", "Comentario", "Estado", "idContrato"};
    modelo.getDataVector().removeAllElements();
    modelo.setColumnIdentifiers(titulos);
    try {
        cn = ConexionDAO.getConexion();
        String sql = "{call MostrarTodasVacaciones}";
        ps = cn.prepareCall(sql);
        rs = ps.executeQuery();
        // Procesar el ResultSet
        while (rs.next()) {
            String idVacaciones = rs.getString("idVacaciones");
            String fIni = rs.getDate("F_Ini").toString();
            String fFin = rs.getDate("F_Fin").toString();
            String comentario = rs.getString("Comentario");
            String estado = rs.getString("Estado");
            String idContrato = rs.getString("idContrato");
            // Crear una fila con los datos
            String fila[] = {idVacaciones, fIni, fFin, comentario, estado, idContrato};
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
