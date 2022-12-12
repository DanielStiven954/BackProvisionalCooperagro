/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TransaccionDataAccessImp;
import com.co.ebs.cooperagro.domain.Transaccion;

/**
 *
 * @author Brayan F Silva R
 */
public class TransaccionServiceBean implements TransaccionService {
    
    private final TransaccionDataAccessImp transaccionDataAccessImp = new TransaccionDataAccessImp();
    
    @Override
    public Transaccion saveTransaccion(Transaccion transaccion) {
        return transaccionDataAccessImp.saveTransaccion(transaccion);
    }
    
    @Override
    public Transaccion editTransaccion(Transaccion transaccion) {
        return transaccionDataAccessImp.editTransaccion(transaccion);
    }
    
    @Override
    public Transaccion findTransaccionById(Long id) {
        return transaccionDataAccessImp.findTransaccionById(id);
    }
    
    @Override
    public void deleteTransaccion(Transaccion transaccion) {
        transaccionDataAccessImp.deleteTransaccion(transaccion);
    }
    
}