/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoProductoSolCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoProductoSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoProductoSolCredito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class TipoProductoSolCreditoServiceBean implements TipoProductoSolCreditoService{

    TipoProductoSolCreditoDataAccessImp tipoProductoSolCred = new TipoProductoSolCreditoDataAccessImp();
    
    @Override
    public ResponseTipoProductoSolCredito listTipoProductoSolCredito()
    {
        ResponseTipoProductoSolCredito responseTipoPerfil = new ResponseTipoProductoSolCredito();
        List<TipoProductoSolCredito> listaTipPerf = tipoProductoSolCred.consTipoProducto();
        if(listaTipPerf!=null){
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            responseTipoPerfil.setListaTipoProducto(listaTipPerf);
        }
        else{
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Ha ocurrido un error, la lista viene vacia");
        }
        return responseTipoPerfil;
    }

    @Override
    public ResponseTipoProductoSolCredito listTipoProductoSolCreditoById(Long codigoTipoProducto)
    {
        ResponseTipoProductoSolCredito responseTipoPerfil = new ResponseTipoProductoSolCredito();
        TipoProductoSolCredito listaTipPerf = tipoProductoSolCred.consTipoProductoByID(codigoTipoProducto);
        if(listaTipPerf!=null){
            List<TipoProductoSolCredito> lista = new ArrayList<>();
            lista.add(listaTipPerf);
            responseTipoPerfil.setCodigo(1);
            responseTipoPerfil.setFlag(true);
            responseTipoPerfil.setListaTipoProducto(lista);
        }
        else{
            responseTipoPerfil.setCodigo(0);
            responseTipoPerfil.setFlag(false);
            responseTipoPerfil.setMsm("Ha ocurrido un error, la lista viene vacia");
        }
        return responseTipoPerfil;
    }
    
}
