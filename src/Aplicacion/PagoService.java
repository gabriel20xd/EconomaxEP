/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Pago;
import Persistencia.PagoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class PagoService {
    private PagoDAO pagoDAO;

    public PagoService() {
        this.pagoDAO = new PagoDAO();
    }

     public void registrarPago(Pago pago) throws SQLException {
        if (validarPago(pago)) {
            pagoDAO.insertarPago(pago);
        } else {
            throw new IllegalArgumentException("El pago no es válido.");
        }
    }

    public void mostrarPagos(DefaultTableModel modelo) throws SQLException {
        pagoDAO.mostrar(modelo);
    }
    public void filtrarPagosPorDni(DefaultTableModel modelo, String dni) throws SQLException {
        pagoDAO.filtrarPagosPorDni(modelo, dni);
    }

    public void filtrarPagosPorAno(DefaultTableModel modelo, int ano) throws SQLException {
        pagoDAO.filtrarPagosPorAno(modelo, ano);
    }

    public boolean existePagoEnMes(int contratoId, LocalDate fechaPago) throws SQLException {
        return pagoDAO.existePagoEnMes(contratoId, fechaPago);
    }
    // Validaciones
    private boolean validarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Error: El monto del pago debe ser mayor a cero.");
            return false;
        }
        return true;
    }
}
