/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoPerfilDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoPerfil;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class TipoPerfilServiceBean implements TipoPerfilService {

    TipoPerfilDataAccessImp tipoPerfilDataAccImp = new TipoPerfilDataAccessImp();

    @Override
    public ResponseTipoPerfil listTipoPerfil() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        List<TipoPerfil> listaTipPerf = tipoPerfilDataAccImp.consTipoPerfil();
        if (listaTipPerf != null) {
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            responseTipoPerfil.setListaTipoPerfil(listaTipPerf);
        } else {
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Ha ocurrido un error, la lista viene vacia");
        }
        return responseTipoPerfil;
    }

    @Override
    public ResponseTipoPerfil listTipoPerfilNotInAsociados() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        List<TipoPerfil> listaTipPerf = tipoPerfilDataAccImp.consTipoPerfil();
        if (listaTipPerf != null && !listaTipPerf.isEmpty()) {
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            listaTipPerf.removeIf(tp -> (tp.getICodigo() == 2 || tp.getICodigo() == 3));
            responseTipoPerfil.setListaTipoPerfil(listaTipPerf);
        } else {
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Sin registros");
        }
        return responseTipoPerfil;
    }

    @Override
    public ResponseTipoPerfil listTipoPerfilAsociados() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        List<TipoPerfil> listaTipPerf = tipoPerfilDataAccImp.consTipoPerfil();
        if (listaTipPerf != null && !listaTipPerf.isEmpty()) {
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            listaTipPerf.removeIf(tp -> (tp.getICodigo() != 2 && tp.getICodigo() != 3));
            responseTipoPerfil.setListaTipoPerfil(listaTipPerf);
        } else {
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Sin registros");
        }
        return responseTipoPerfil;
    }

    @Override
    public ResponseTipoPerfil listTipoPerfilByID(int codigoTipoPerfil) {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        List<TipoPerfil> listaTipPerf = tipoPerfilDataAccImp.consTipoPerfil();
        if (listaTipPerf != null) {
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            responseTipoPerfil.setListaTipoPerfil(listaTipPerf);
        } else {
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Ha ocurrido un error, la lista viene vacia");
        }
        return responseTipoPerfil;
    }

}
