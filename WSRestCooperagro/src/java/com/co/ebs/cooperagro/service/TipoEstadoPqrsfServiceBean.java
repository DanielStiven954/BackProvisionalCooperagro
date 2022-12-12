/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoEstadoPqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoEstadoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public class TipoEstadoPqrsfServiceBean implements TipoEstadoPqrsfService {

    @Override
    public TipoEstadoPqrsf obtenerEstadoPqrsf(Long id) {
        TipoEstadoPqrsfDataAccessImp accessImp = new TipoEstadoPqrsfDataAccessImp();
        return accessImp.findByIdTipoEstadoPqrsf(id);
    }

    @Override
    public ResponseTipoEstadoPqrsf obtenerListaTipos() {
        TipoEstadoPqrsfDataAccessImp accessImp = new TipoEstadoPqrsfDataAccessImp();
        ResponseTipoEstadoPqrsf generica = new ResponseTipoEstadoPqrsf();
        List<TipoEstadoPqrsf> list = accessImp.findAllTipoEstadoPqrsd();

        if (list != null) {
            generica.setbRta(Boolean.TRUE);
            generica.setiCodigo(1);
            generica.setLista(list);
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
        }
        return generica;
    }

}
