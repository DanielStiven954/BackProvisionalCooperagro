/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.HistoriaPqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.HistoriaPqrsf;

/**
 *
 * @author YO
 */
public class HistoriaPqrsfServiceBean implements HistoriaPqrsfService{

    @Override
    public HistoriaPqrsf registrarHistoriaPqrsf(HistoriaPqrsf historiaPqrsf) {
        HistoriaPqrsfDataAccessImp accessImp = new HistoriaPqrsfDataAccessImp();
        return accessImp.saveHistoriaPqrsf(historiaPqrsf);
    }
    
}
