/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Empleado;
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
public class EmpleadoDAO {
   /////INSERTAR////
   public static void InsertarEmpleado(Empleado e) throws SQLException {
    Connection connection = null;
    PreparedStatement ps = null;

    try {
        connection = ConexionDAO.getConexion();
        String sql = "{call InsertarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ps = connection.prepareCall(sql);
        ps.setString(1, e.getNombre());                        
        ps.setString(2, e.getApellidos());                     
        ps.setString(3, e.getDni());           
        ps.setString(4, e.getDireccion());                     
        ps.setString(5, e.getCelular());       
        ps.setString(6, e.getEmail());                         
        ps.setString(7, e.getSexo());                          
        ps.setDate(8, e.getFechaNacimiento()); 
        ps.setString(9, e.getEstado());                        
        ps.setString(10, e.getCargo());               
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
 ////ACTUALIZAR////
   public static void actualizar(Empleado e) throws SQLException {
    Connection connection = null;
    PreparedStatement ps = null;

    try {
        connection = ConexionDAO.getConexion();
        String sql = "UPDATE Empleado SET Nombre = ?, Apellido = ?, DNI = ?, Direccion = ?, Telefono = ?, Email = ?, Sexo = ?, FechaNacimiento = ?, Estado = ?, Cargo = ? WHERE idEmpleado = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getApellidos());
        ps.setString(3, e.getDni());
        ps.setString(4, e.getDireccion());
        ps.setString(5, e.getCelular());
        ps.setString(6, e.getEmail());
        ps.setString(7, e.getSexo());
        ps.setDate(8, e.getFechaNacimiento());
        ps.setString(9, e.getEstado());
        ps.setString(10, e.getCargo());
        ps.setInt(11, e.getIdEmpleado());
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
    
   public int obtenerIdEmpleadoPorNombre(String nombreCompleto) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idEmpleado = -1;

        try {
            connection = ConexionDAO.getConexion();
            String sql = "SELECT idEmpleado FROM Empleado WHERE CONCAT(Nombre, ' ', Apellido) = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, nombreCompleto);
            rs = ps.executeQuery();

            if (rs.next()) {
                idEmpleado = rs.getInt("idEmpleado");
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

        return idEmpleado;
    }

   ////ELIMINAR////
   public static void EliminarEmpleado(int idEmpleado) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConexionDAO.getConexion();
            String sql = "{call EliminarEmpleado(?)}";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, idEmpleado);
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
   
   ////MOSTRAR////
   public static void mostrar(DefaultTableModel modelo) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String titulos[] = {"idEmpleado", "Nombre", "Apellido", "DNI", "Direccion", "Telefono", "Email", "Sexo", "Fecha_Naci", "Estado", "Cargo"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            cn = ConexionDAO.getConexion();
            String sql = "{call MostrarEmpleados}";
            ps = cn.prepareCall(sql);
            rs = ps.executeQuery();
            // Procesar el ResultSet
            while (rs.next()) {
                String id = rs.getString("idEmpleado");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String dni = rs.getString("DNI");
                String direccion = rs.getString("Direccion");
                String telefono = rs.getString("Telefono");
                String email = rs.getString("Email");
                String sexo = rs.getString("Sexo");
                String fechaNaci = rs.getDate("FechaNacimiento").toString();
                String estado = rs.getString("Estado");
                String cargo = rs.getString("Cargo");
                // Crear una fila con los datos
                String fila[] = {id, nombre, apellido, dni, direccion, telefono, email, sexo, fechaNaci, estado, cargo};
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


