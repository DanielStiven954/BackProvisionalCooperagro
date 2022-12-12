/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public interface TipoPQRSFDataAccess {
    
    public TipoPqrsf saveTipoPQRSF(TipoPqrsf tipoPqrsf);
    
    TipoPqrsf updateTipoPQRSF(TipoPqrsf tipoPqrsf);
    
    void deleteTipoPQRSF(TipoPqrsf tipoPqrsf);
    
    List<TipoPqrsf> findAllTipoPQRSF();
    
    TipoPqrsf findByIdTipoPQRSF(Long id);
}
