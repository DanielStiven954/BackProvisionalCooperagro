/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.HistoriaSolCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.HistoriaSolicitudCredito;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Jonathan
 */
public class HistoriaSolCreditoServiceBean implements HistoriaSolCreditoService {

    private HistoriaSolCreditoDataAccessImp historiaDataImpl = new HistoriaSolCreditoDataAccessImp();

    @Override
    public respuestaGenerica crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb) {
        respuestaGenerica respuesta = new respuestaGenerica();
        HistoriaSolicitudCredito histSolCre = historiaDataImpl.crear(tipoEstSolAfilWeb, solAfilWeb);
        if (histSolCre != null && histSolCre.getICodigo() != null) {
            respuesta.setiCodigo(1);
            respuesta.setbRta(Boolean.TRUE);
            respuesta.setsMsj("Se creo la historia del credito de manera correcta");
        } else {
            respuesta.setiCodigo(0);
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ocurrio un error al crear la historia de credito");
        }
        return respuesta;
    }

    @Override
    public HistoriaSolicitudCredito saveHistoriaSolicitudCredito(HistoriaSolicitudCredito historiaSolicitudCredito) {
        return historiaDataImpl.saveHistoriaSolicitudCredito(historiaSolicitudCredito);
    }

    @Override
    public respuestaGenerica update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb, String mensaje) {
        respuestaGenerica respuesta = new respuestaGenerica();
        HistoriaSolicitudCredito histSolCre = historiaDataImpl.update(tipoEstSolAfilWeb, solAfilWeb, mensaje);
        if (histSolCre != null) {
            respuesta.setiCodigo(1);
            respuesta.setbRta(Boolean.TRUE);
            respuesta.setsMsj("Se creo la historia del credito de manera correcta");
        } else {
            respuesta.setiCodigo(0);
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ocurrio un error al crear la historia de credito");
        }
        return respuesta;
    }

}
