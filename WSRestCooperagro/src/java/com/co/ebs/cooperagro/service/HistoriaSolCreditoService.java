/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.HistoriaSolicitudCredito;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Jonathan
 */
public interface HistoriaSolCreditoService {

    respuestaGenerica crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb);

    HistoriaSolicitudCredito saveHistoriaSolicitudCredito(HistoriaSolicitudCredito historiaSolicitudCredito);
    
    respuestaGenerica update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb, String mensaje);
}
