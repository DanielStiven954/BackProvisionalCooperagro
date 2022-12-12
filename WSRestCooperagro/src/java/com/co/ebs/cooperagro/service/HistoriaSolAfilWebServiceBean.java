/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.HistoriaSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public class HistoriaSolAfilWebServiceBean implements HistoriaSolAfilWebService{
    
    private HistoriaSolAfilWebDataAccessImp hisImp = new HistoriaSolAfilWebDataAccessImp();
    
    @Override
    public HistoriaSolAfilWeb crear(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb)
    {  
        return hisImp.crear(tipoEstSolAfilWeb,solAfilWeb);
    }

    @Override
    public HistoriaSolAfilWeb update(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb)
    {
        return hisImp.update(tipoEstSolAfilWeb,solAfilWeb);
    }

    @Override
    public HistoriaSolAfilWeb crearDesdeCero(HistoriaSolAfilWeb historiaSolAfilWeb) {
        return hisImp.crearDesdeCero(historiaSolAfilWeb);
    }
    
}
