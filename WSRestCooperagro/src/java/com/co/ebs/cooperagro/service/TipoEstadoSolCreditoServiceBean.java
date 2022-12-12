/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoEstadoSolCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoEstadoSolCredito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class TipoEstadoSolCreditoServiceBean implements TipoEstadoSolCreditoService {

    private final TipoEstadoSolCreditoDataAccessImp TipoEstadoSol = new TipoEstadoSolCreditoDataAccessImp();

    @Override
    public TipoEstadoSolicitudCredito findByID(long id) {
        return TipoEstadoSol.findByID(id);
    }

    @Override
    public List<ResponseTipoEstadoSolCredito> findAllTipoEstado() {
        List<ResponseTipoEstadoSolCredito> listResponseTipoEstadoSolCredito = new ArrayList<>();

        List<TipoEstadoSolicitudCredito> listTipoEst = TipoEstadoSol.findAllTipoEstado();

        if (listTipoEst != null && !listTipoEst.isEmpty()) {
            ResponseTipoEstadoSolCredito respuesta = new ResponseTipoEstadoSolCredito();
            for (TipoEstadoSolicitudCredito tipoEstadoSolicitudCredito : listTipoEst) {
                if (tipoEstadoSolicitudCredito.getICodigo() == 3 || tipoEstadoSolicitudCredito.getICodigo() == 4 || tipoEstadoSolicitudCredito.getICodigo() == 5 || tipoEstadoSolicitudCredito.getICodigo() == 7) {
                    Long idCodigo = tipoEstadoSolicitudCredito.getICodigo();
                    respuesta.setiCodigo(idCodigo.intValue());
                    respuesta.setcDescripcion(tipoEstadoSolicitudCredito.getCDescripcion());
                    listResponseTipoEstadoSolCredito.add(respuesta);
                    respuesta = new ResponseTipoEstadoSolCredito();
                }
            }
        }
        return listResponseTipoEstadoSolCredito;
    }
}
