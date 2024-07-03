/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Contrato;
import Persistencia.ContratoDAO;
import Persistencia.EmpleadoDAO;
import Persistencia.TipoContratoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class ContratoService {
    private ContratoDAO contratoDAO;
    private EmpleadoDAO empleadoDAO;
    private TipoContratoDAO tipoContratoDAO;

    public ContratoService() {
        this.contratoDAO = new ContratoDAO();
    }

    public void agregarContrato(Contrato contrato) throws SQLException {
        if (validarContrato(contrato)) {
            contratoDAO.InsertarContrato(contrato);
        } else {
            throw new IllegalArgumentException("El contrato no es válido.");
        }
    }
    public void actualizarContrato(Contrato contrato) throws SQLException {
        if (validarContrato(contrato)) {
            contratoDAO.actualizarContrato(contrato);
        } else {
            throw new IllegalArgumentException("El contrato no es válido.");
        }
    }

    public void eliminarContrato(int idContrato,String estado) throws SQLException {
        contratoDAO.EliminarContrato(idContrato,estado);
    }

    public void mostrarContratos(DefaultTableModel modelo) throws SQLException {
        contratoDAO.mostrar(modelo);
    }
    
    public int obtenerIdEmpleadoPorNombre(String nombreCompleto) throws SQLException {
        return empleadoDAO.obtenerIdEmpleadoPorNombre(nombreCompleto);
    }

    public int obtenerIdTipoContratoPorDescripcion(String descripcion) throws SQLException {
        return tipoContratoDAO.obtenerIdTipoContratoPorDescripcion(descripcion);
    }
 // Validaciones
    private boolean validarContrato(Contrato contrato) {
        if (contrato.getFechaInicio().isAfter(contrato.getFinContrato())) {
            System.out.println("Error: La fecha de inicio del contrato no puede ser posterior a la fecha de fin.");
            return false;
        }
        if (contrato.getHorasContratadasXmes() <= 0) {
            System.out.println("Error: Las horas contratadas al mes deben ser mayores a cero.");
            return false;
        }
        return true;
    }
    

    // REGLA-01: Calcular Sueldo Base
    public double calcularSueldoBase(Contrato contrato) {
        double salarioHora = contrato.getSueldo();
        int horasContratadasAlMes = 8 * 30;
        return salarioHora * horasContratadasAlMes;
    }

    // REGLA-02: Calcular Pago de Horas Extra
    public double calcularPagoHorasExtra(Contrato contrato, int horasTrabajadas) {
        int horasExtras = horasTrabajadas - (8 * 30);
        if (horasExtras > 0) {
            return horasExtras * contrato.getSueldo();
        } else {
            return 0;
        }
    }

    // REGLA-03: Calcular Descuento por Tardanza
    public double calcularDescuentoPorTardanza(Contrato contrato, int minutosTardanza) {
        double salarioPorHora = contrato.getSueldo();
        double salarioPorMinuto = salarioPorHora / 60;
        return salarioPorMinuto * minutosTardanza;
    }

    // REGLA-05: Calcular Descuento por Ausencias
    public double calcularDescuentoPorAusencias(Contrato contrato, int diasAusentes) {
        double salarioPorHora = contrato.getSueldo();
        double salarioPorDia = (salarioPorHora * (8 * 30)) / 30;
        return salarioPorDia * diasAusentes;
    }

    // REGLA-06: Calcular Adelanto de Sueldo
    public double calcularAdelantoSueldo(double sueldoBase, double porcentajeAdelanto) {
        return sueldoBase * porcentajeAdelanto;
    }

    // REGLA-07: Calcular Total de Ingresos
    public double calcularTotalIngresos(double sueldoBase, double pagoHorasExtra) {
        return sueldoBase + pagoHorasExtra;
    }

    // REGLA-08: Calcular Total de Descuentos
    public double calcularTotalDescuentos(double descuentoPorTardanza, double descuentoPorAusencias, double adelantoSueldo) {
        return descuentoPorTardanza + descuentoPorAusencias + adelantoSueldo;
    }

    // REGLA-09: Calcular Pago Total
    public double calcularPagoTotal(double totalIngresos, double totalDescuentos) {
        return totalIngresos - totalDescuentos;
    }
}
