/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoEstadoSolCredito;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface TipoEstadoSolCreditoService {
    TipoEstadoSolicitudCredito findByID(long id);
    
    List<ResponseTipoEstadoSolCredito> findAllTipoEstado();
}
 