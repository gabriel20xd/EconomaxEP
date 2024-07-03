/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.TipoContrato;
import Persistencia.TipoContratoDAO;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhampool
 */
public class TipoContratoService {
    private TipoContratoDAO tipoContratoDAO;

    public TipoContratoService() {
        this.tipoContratoDAO = new TipoContratoDAO();
    }

    public void registrarTipoContrato(TipoContrato tipoContrato) throws SQLException {
        if (validarTipoContrato(tipoContrato)) {
            tipoContratoDAO.InsertarTipoContrato(tipoContrato.getTiempoContrato());
        } else {
            throw new IllegalArgumentException("El tipo de contrato no es válido.");
        }
    }

    public void mostrarTiposContrato(DefaultTableModel modelo) throws SQLException {
        tipoContratoDAO.mostrarTipoContrato(modelo);
    }
    // Validaciones
    private boolean validarTipoContrato(TipoContrato tipoContrato) {
        if (tipoContrato.getTiempoContrato() == null || tipoContrato.getTiempoContrato().isEmpty()) {
            System.out.println("Error: La descripción del tipo de contrato no puede estar vacía.");
            return false;
        }
        return true;
    }
}
