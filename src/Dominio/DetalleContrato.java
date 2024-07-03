/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Jhampool
 */
public class DetalleContrato {
    private int idDetalleContrato;
    private double salarioHora;
    private int horasTrabajadas;
    private int horasContratadasAlMes;
    private int tardanzasTotales;
    private int ausencias;
    private int adelantoSueldo;
    private int horasExtrasTrabajadas;
    private Contrato contrato;
    private Pago pago;

    public DetalleContrato(double salarioHora, int horasTrabajadas, int horasContratadasAlMes, int tardanzasTotales, int ausencias, int adelantoSueldo, int horasExtrasTrabajadas, Contrato contrato, Pago pago) {
        this.salarioHora = salarioHora;
        this.horasTrabajadas = horasTrabajadas;
        this.horasContratadasAlMes = horasContratadasAlMes;
        this.tardanzasTotales = tardanzasTotales;
        this.ausencias = ausencias;
        this.adelantoSueldo = adelantoSueldo;
        this.horasExtrasTrabajadas = horasExtrasTrabajadas;
        this.contrato = contrato;
        this.pago = pago;
    }

    public DetalleContrato(int idDetalleContrato) {
        this.idDetalleContrato = idDetalleContrato;
    }

    public DetalleContrato() {
    }

    public int getIdDetalleContrato() {
        return idDetalleContrato;
    }

    public void setIdDetalleContrato(int idDetalleContrato) {
        this.idDetalleContrato = idDetalleContrato;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasContratadasAlMes() {
        return horasContratadasAlMes;
    }

    public void setHorasContratadasAlMes(int horasContratadasAlMes) {
        this.horasContratadasAlMes = horasContratadasAlMes;
    }

    public int getTardanzasTotales() {
        return tardanzasTotales;
    }

    public void setTardanzasTotales(int tardanzasTotales) {
        this.tardanzasTotales = tardanzasTotales;
    }

    public int getAusencias() {
        return ausencias;
    }

    public void setAusencias(int ausencias) {
        this.ausencias = ausencias;
    }

    public int getAdelantoSueldo() {
        return adelantoSueldo;
    }

    public void setAdelantoSueldo(int adelantoSueldo) {
        this.adelantoSueldo = adelantoSueldo;
    }

    public int getHorasExtrasTrabajadas() {
        return horasExtrasTrabajadas;
    }

    public void setHorasExtrasTrabajadas(int horasExtrasTrabajadas) {
        this.horasExtrasTrabajadas = horasExtrasTrabajadas;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
}
