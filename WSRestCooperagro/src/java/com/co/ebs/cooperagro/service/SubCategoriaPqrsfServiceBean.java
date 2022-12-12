/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.SubCategoriaPqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSubCategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class SubCategoriaPqrsfServiceBean implements SubCategoriaPqrsfService{

    private final SubCategoriaPqrsfDataAccessImp imp = new SubCategoriaPqrsfDataAccessImp();
    
    @Override
    public ResponseSubCategoriaPqrsf findByCategoria(Long id) {
        
        ResponseSubCategoriaPqrsf responseSubCategoriaPqrsf = new ResponseSubCategoriaPqrsf();
        
        List<SubCategoriaPqrsf> listSub = this.imp.findByCategoria(id);
        if(listSub != null && !listSub.isEmpty()){
            responseSubCategoriaPqrsf.setCodigo(1);
            responseSubCategoriaPqrsf.setFlag(true);
            responseSubCategoriaPqrsf.setMsm("");
            responseSubCategoriaPqrsf.setListaSubCategoriaPqrsf(listSub);
        }else{
            responseSubCategoriaPqrsf.setCodigo(0);
            responseSubCategoriaPqrsf.setFlag(false);
            responseSubCategoriaPqrsf.setMsm("");
            responseSubCategoriaPqrsf.setListaSubCategoriaPqrsf(listSub);
        }
        
        return responseSubCategoriaPqrsf;
    }

    @Override
    public SubCategoriaPqrsf findById(Long id) {
        return this.imp.findByIdSubCategoriaPQRSF(id);
    }
    
}
