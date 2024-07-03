/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.time.LocalDate;

/**
 *
 * @author Jhampool
 */
public class Contrato {
    private int idContrato;
    private LocalDate FechaInicio;
    private LocalDate FinContrato;
    private String Area;
    private double Sueldo;
    private int HorasXdia;
    private int HorasContratadasXmes;
    private String Estado;
    private LocalDate Fecha;
    private Empleado empleado;
    private TipoContrato tipocontrato;

    public Contrato(LocalDate FechaInicio, LocalDate FinContrato, String Area, double Sueldo, int HorasXdia, int HorasContratadasXmes, String Estado, LocalDate Fecha, Empleado empleado, TipoContrato tipocontrato) {
        this.FechaInicio = FechaInicio;
        this.FinContrato = FinContrato;
        this.Area = Area;
        this.Sueldo = Sueldo;
        this.HorasXdia = HorasXdia;
        this.HorasContratadasXmes = HorasContratadasXmes;
        this.Estado = Estado;
        this.Fecha = Fecha;
        this.empleado = empleado;
        this.tipocontrato = tipocontrato;
    }

    public Contrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato() {
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public LocalDate getFinContrato() {
        return FinContrato;
    }

    public void setFinContrato(LocalDate FinContrato) {
        this.FinContrato = FinContrato;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public int getHorasXdia() {
        return HorasXdia;
    }

    public void setHorasXdia(int HorasXdia) {
        this.HorasXdia = HorasXdia;
    }

    public int getHorasContratadasXmes() {
        return HorasContratadasXmes;
    }

    public void setHorasContratadasXmes(int HorasContratadasXmes) {
        this.HorasContratadasXmes = HorasContratadasXmes;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoContrato getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(TipoContrato tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

}
