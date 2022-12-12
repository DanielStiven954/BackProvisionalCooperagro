/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoPQRSF;
import java.util.List;

/**
 *
 * @author YO
 */
public interface TipoPQRSFService {
    
    TipoPqrsf saveTipoPqrsf(TipoPqrsf tipoPqrsf);
    
    TipoPqrsf updateTipoPqrsf(TipoPqrsf tipoPqrsf);
    
    void deleteTipoPqrsf(TipoPqrsf tipoPqrsf);
    
    ResponseTipoPQRSF findAllTipoPqrsf();
    
    TipoPqrsf findById(Long id);
}
