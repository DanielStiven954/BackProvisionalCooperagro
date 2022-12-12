/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoAutorizacionSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoAutorizacionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class TipoAutorizacionSolAfilWebServiceBean implements TipoAutorizacionSolAfilWebService{

    @Override
    public List<TipoAutorizacionSolAfilWeb> findAllTipoAutorizacionSolAfilWeb() {
        return new TipoAutorizacionSolAfilWebDataAccessImp().findAll();
    }
    
}
