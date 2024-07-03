/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Vacaciones;
import Persistencia.VacacionesDAO;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class VacacionesService {
    private VacacionesDAO vacacionesDAO;

    public VacacionesService() {
        this.vacacionesDAO = new VacacionesDAO();
    }

    public void registrarVacaciones(Vacaciones vacaciones) throws SQLException {
        if (validarVacaciones(vacaciones)) {
            vacacionesDAO.insertarVacaciones(vacaciones);
        } else {
            throw new IllegalArgumentException("Las vacaciones no son válidas.");
        }
    }

    public void mostrarVacaciones(DefaultTableModel modelo) throws SQLException {
        vacacionesDAO.mostrar(modelo);
    }
     // Validaciones
    private boolean validarVacaciones(Vacaciones vacaciones) {
        if (vacaciones.getFechaInicio().isAfter(vacaciones.getFechaFinal())) {
            System.out.println("Error: La fecha de inicio de las vacaciones no puede ser posterior a la fecha de fin.");
            return false;
        }
        return true;
    }
}
