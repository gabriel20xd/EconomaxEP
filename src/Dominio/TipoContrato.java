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
public class TipoContrato {
    private int idTipoContrato;
    private String tiempoContrato;

    public TipoContrato(String tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public TipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public int getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(String tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

   
}
