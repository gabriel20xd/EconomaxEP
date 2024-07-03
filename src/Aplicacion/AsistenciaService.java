/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Asistencia;
import Persistencia.AsistenciasDAO;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class AsistenciaService {
    private AsistenciasDAO asistenciasDAO;

    public AsistenciaService() {
        this.asistenciasDAO = new AsistenciasDAO();
    }

    public void registrarAsistencia(Asistencia asistencia) throws SQLException {
        if (validarAsistencia(asistencia)) {
            asistenciasDAO.InsertarAsistencia(asistencia);
        } else {
            throw new IllegalArgumentException("La asistencia no es válida.");
        }
    }

    public void registrarSalida(int idAsistencia, LocalTime horaSalida) throws SQLException {
        asistenciasDAO.InsertarSalida(idAsistencia, horaSalida);
    }

    public void mostrarAsistencias(DefaultTableModel modelo) throws SQLException {
        asistenciasDAO.mostrar(modelo);
    }
    // Validaciones
    private boolean validarAsistencia(Asistencia asistencia) {
        if (asistencia.getHoraIngreso().isAfter(asistencia.getHoraSalida())) {
            System.out.println("Error: La hora de ingreso no puede ser posterior a la hora de salida.");
            return false;
        }
        return true;
    }
}
