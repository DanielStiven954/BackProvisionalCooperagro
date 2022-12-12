/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.CategoriaPQRSFDataAccessImp;
import com.co.ebs.cooperagro.domain.CategoriaPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class CategoriaPqrsfServiceBean implements CategoriaPqrsfService{
 
    private final CategoriaPQRSFDataAccessImp categoriaPqrsfDataAccessImp = new CategoriaPQRSFDataAccessImp();
    
    @Override
    public ResponseCategoriaPqrsf findAllCategoriaPqrsf() {
        ResponseCategoriaPqrsf responseTipoPQRSF = new ResponseCategoriaPqrsf();
        List<CategoriaPqrsf> list = this.categoriaPqrsfDataAccessImp.findAllCategoriaPQRSF();
        if(list != null && !list.isEmpty()){
            responseTipoPQRSF.setCodigo(1);
            responseTipoPQRSF.setFlag(true);
            responseTipoPQRSF.setListaCategoriaPqrsf(list);
        }else{
            responseTipoPQRSF.setCodigo(0);
            responseTipoPQRSF.setFlag(false);
            responseTipoPQRSF.setListaCategoriaPqrsf(list);
        }
        
        return responseTipoPQRSF;
    }

    @Override
    public CategoriaPqrsf findById(Long id) {
        return categoriaPqrsfDataAccessImp.findByIdCategoriaPQRSF(id);
    }
    
}
