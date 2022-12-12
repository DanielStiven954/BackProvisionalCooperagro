/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Transaccion;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;

/**
 *
 * @author Brayan F Silva R
 */
public class TransaccionDataAccessImp extends WSRestGenericRepositoryJPA<Transaccion> implements TransaccionDataAccess {
    
    @Override
    public Transaccion saveTransaccion(Transaccion transaccion) {
        return create(transaccion);
    }
    
    @Override
    public Transaccion editTransaccion(Transaccion transaccion) {
        return update(transaccion);
    }
    
    @Override
    public Transaccion findTransaccionById(Long id) {
        return find(id);
    }
    
    @Override
    public void deleteTransaccion(Transaccion transaccion) {
        delete(transaccion);
    }
    
}
