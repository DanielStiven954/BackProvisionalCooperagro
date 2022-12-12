/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoEstadoSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public class TipoEstadoSolWebServiceBean implements TipoEstadoSolAfilWebService{
    TipoEstadoSolAfilWebDataAccessImp tipoEstado = new TipoEstadoSolAfilWebDataAccessImp();
    @Override
    public TipoEstadoSolAfilWeb findByAbre(String abrevi)
    {
        return tipoEstado.findByAbre(abrevi);
    }
    
}
