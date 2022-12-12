/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseEstadoCuenta;
import com.ebssystem.DatoDTO;
//import com.ebssystem.Detallecta;
import com.ebssystem.Movimiento;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public interface EstadoCuentaCoreService {

    List<DatoDTO> wsConsultarEstadoCuenta(String xiTipoIden, String xcIdentificacion, String xcProducto);

    List<DatoDTO> wsConsultarEstadoCuenta(int xiCodUser, String xcProducto);

    Movimiento wsConsultaDetalleCtaCredito(String xsNumRadic);

    Movimiento wsConsultaDetalleCtaAporte(String xsNumRadic);

    Movimiento wsConsultaDetalleCtaServicio(String xsNumRadic);

    Movimiento wsConsultaMovimientosCtaCredito(String xsNumRadic);

    Movimiento wsConsultaMovimientosCtaAporte(String xsNumRadic);

    Movimiento wsConsultaMovimientosCtaServicio(String xsNumRadic);

    Movimiento wsConsultaDetalleMovCtaCredito(String xsNumRadic, String codOperation);
    
    Movimiento wsConsultaDetalleMovCtaServicio(String xsNumRadic, String codOperation);
    
    ResponseEstadoCuenta obtenerEstaCuentaByUser(int xiCodUser);

    Movimiento wsConsultaDetalleCta(String xsNumRadic, String xcProducto);
}
