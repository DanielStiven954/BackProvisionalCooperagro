/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoPQRSFDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoPQRSF;
import java.util.List;

/**
 *
 * @author YO
 */
public class TipoPQRSFServiceBean implements TipoPQRSFService{

    private final TipoPQRSFDataAccessImp tipoPQRSFDataAccessImp = new TipoPQRSFDataAccessImp();
    
    @Override
    public TipoPqrsf saveTipoPqrsf(TipoPqrsf tipoPqrsf) {
        return tipoPQRSFDataAccessImp.saveTipoPQRSF(tipoPqrsf);
    }

    @Override
    public TipoPqrsf updateTipoPqrsf(TipoPqrsf tipoPqrsf) {
        return tipoPQRSFDataAccessImp.update(tipoPqrsf);
    }

    @Override
    public void deleteTipoPqrsf(TipoPqrsf tipoPqrsf) {
        tipoPQRSFDataAccessImp.delete(tipoPqrsf);
    }

    @Override
    public ResponseTipoPQRSF findAllTipoPqrsf() {
        ResponseTipoPQRSF responseTipoPQRSF = new ResponseTipoPQRSF();
        List<TipoPqrsf> list = this.tipoPQRSFDataAccessImp.findAll();
        if(list != null && !list.isEmpty()){
            responseTipoPQRSF.setCodigo(1);
            responseTipoPQRSF.setFlag(true);
            responseTipoPQRSF.setListaTipoPQRSF(list);
        }else{
            responseTipoPQRSF.setCodigo(0);
            responseTipoPQRSF.setFlag(false);
            responseTipoPQRSF.setListaTipoPQRSF(list);
        }
        
        return responseTipoPQRSF;
    }

    @Override
    public TipoPqrsf findById(Long id) {
        return tipoPQRSFDataAccessImp.findByIdTipoPQRSF(id);
    }
    
    
    
}
