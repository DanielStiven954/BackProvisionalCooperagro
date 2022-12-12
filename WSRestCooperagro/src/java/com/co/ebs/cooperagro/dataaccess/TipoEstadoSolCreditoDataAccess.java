/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface TipoEstadoSolCreditoDataAccess {

    TipoEstadoSolicitudCredito findByID(Long id);

    List<TipoEstadoSolicitudCredito> findAllTipoEstado();
}
