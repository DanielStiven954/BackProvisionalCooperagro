/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoDireccionAccessImp;
import com.co.ebs.cooperagro.dataaccess.CompleDireccionAccessImp;
import com.co.ebs.cooperagro.domain.TipoDireccionSolAfilWeb;
import com.co.ebs.cooperagro.domain.CompDireccionSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCompDireccion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoDireccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilo Sanchez
 */
public class TipoDireccionSolWebServiceBean implements TipoDireccionSolAfilWebService{
    TipoDireccionAccessImp tipoEstado = new TipoDireccionAccessImp();
    CompleDireccionAccessImp CompleDire = new CompleDireccionAccessImp();
    
    @Override    
    public ResponseTipoDireccion listarTiposDirecciones(){
        List<TipoDireccionSolAfilWeb> ListTiposDir = new ArrayList();
        ResponseTipoDireccion responseTipoDireccion = new ResponseTipoDireccion();
        ListTiposDir= tipoEstado.consDireccion();         
        if (ListTiposDir!=null && ListTiposDir.size()>0){
            responseTipoDireccion.setFlag(true);
            responseTipoDireccion.setMsm("Los tipos se consultaro de manera exitosa.");
            responseTipoDireccion.setListaTipoDireccion(ListTiposDir);
        }else{
            responseTipoDireccion.setFlag(false);
            responseTipoDireccion.setMsm("Los tipos no se pudieron consultar.");
            responseTipoDireccion.setListaTipoDireccion(null);
        }
            
        return responseTipoDireccion;
    }
    
    public ResponseCompDireccion listarCompleDirecciones(){
        List<CompDireccionSolAfilWeb> ListCompDir = new ArrayList();
        ResponseCompDireccion responseCompDireccion = new ResponseCompDireccion();
        ListCompDir = CompleDire.consCompleDireccion();
        if (ListCompDir!=null && ListCompDir.size()>0){
            responseCompDireccion.setFlag(true);
            responseCompDireccion.setMsm("Los tipos se consultaro de manera exitosa.");
            responseCompDireccion.setListaCompDireccion(ListCompDir);
        }else{
            responseCompDireccion.setFlag(false);
            responseCompDireccion.setMsm("Los tipos no se pudieron consultar.");
            responseCompDireccion.setListaCompDireccion(null);
        }
        return responseCompDireccion;
    }
    
}
