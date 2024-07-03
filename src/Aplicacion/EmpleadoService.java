/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Empleado;
import Persistencia.EmpleadoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class EmpleadoService {
     private EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void agregarEmpleado(Empleado empleado) throws SQLException {
        empleadoDAO.InsertarEmpleado(empleado);
    }

    public void actualizar(Empleado empleado) throws SQLException {
    empleadoDAO.actualizar(empleado);
}


    public void eliminarEmpleado(int idEmpleado) throws SQLException {
        empleadoDAO.EliminarEmpleado(idEmpleado);
    }

 public void mostrarEmpleados(DefaultTableModel modelo) throws SQLException {
        empleadoDAO.mostrar(modelo);
    }
}
