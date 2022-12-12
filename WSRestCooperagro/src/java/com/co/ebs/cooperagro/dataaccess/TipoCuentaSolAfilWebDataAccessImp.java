/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoCuentaSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class TipoCuentaSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<TipoCuentaSolAfilWeb> implements TipoCuentaSolAfilWebDataAccess{
    
    @Override
    public List<TipoCuentaSolAfilWeb> findAllTipoCuenta(){
        return findAll();
    }
    
}
