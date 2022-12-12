/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

//import com.ebssystem.Detallemov;
import com.ebssystem.Movimiento;
//import com.ebssystem.Detallecta;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RequestDetalle {

    private Movimiento detalleCta;
    private List<Movimiento> detalleAmparadoBenef;

    public Movimiento getDetalleCta() {
        return detalleCta;
    }

    public void setDetalleCta(Movimiento detalleCta) {
        this.detalleCta = detalleCta;
    }

    public List<Movimiento> getDetalleAmparadoBenef() {
        return detalleAmparadoBenef;
    }

    public void setDetalleAmparadoBenef(List<Movimiento> detalleAmparadoBenef) {
        this.detalleAmparadoBenef = detalleAmparadoBenef;
    }

    

}
