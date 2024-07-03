/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jhampool
 */
public class Asistencia {
    private int idAsistencia;
    private LocalTime HoraIngreso;
    private LocalTime HoraSalida;
    private LocalDate Fecha;
    private Contrato contrato;

    public Asistencia(LocalTime HoraIngreso, LocalTime HoraSalida, LocalDate Fecha, Contrato contrato) {
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
        this.Fecha = Fecha;
        this.contrato = contrato;
    }

    public Asistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Asistencia() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public LocalTime getHoraIngreso() {
        return HoraIngreso;
    }

    public void setHoraIngreso(LocalTime HoraIngreso) {
        this.HoraIngreso = HoraIngreso;
    }

    public LocalTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalTime HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

}
