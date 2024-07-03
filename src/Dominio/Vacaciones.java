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
public class Vacaciones {
    private int idVacaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String comentario;
    private String estado;
    private Contrato contrato;

    public Vacaciones(LocalDate fechaInicio, LocalDate fechaFinal, String comentario, String estado, Contrato contrato) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.comentario = comentario;
        this.estado = estado;
        this.contrato = contrato;
    }

    public Vacaciones(int idVacaciones) {
        this.idVacaciones = idVacaciones;
    }

    public int getIdVacaciones() {
        return idVacaciones;
    }

    public void setIdVacaciones(int idVacaciones) {
        this.idVacaciones = idVacaciones;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    
}
