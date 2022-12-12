/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class TipoEstadoSolCreditoDataAccessImp extends WSRestGenericRepositoryJPA<TipoEstadoSolicitudCredito> implements TipoEstadoSolCreditoDataAccess {

    @Override
    public TipoEstadoSolicitudCredito findByID(Long id) {
        TipoEstadoSolicitudCredito tpe = find(id);
        return tpe;
    }

    @Override
    public List<TipoEstadoSolicitudCredito> findAllTipoEstado() {

        List<TipoEstadoSolicitudCredito> listTipoEstadoSol = findAll();
        return listTipoEstadoSol;

    }

}
