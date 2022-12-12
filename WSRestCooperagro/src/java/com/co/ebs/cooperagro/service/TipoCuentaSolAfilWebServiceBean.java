/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoCuentaSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoCuentaSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class TipoCuentaSolAfilWebServiceBean {
    
    public List<TipoCuentaSolAfilWeb> findAllTipoCuenta(){
        return new TipoCuentaSolAfilWebDataAccessImp().findAll();
    }
}
