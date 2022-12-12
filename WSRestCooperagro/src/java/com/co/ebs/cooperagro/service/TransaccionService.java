/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Transaccion;

/**
 *
 * @author Brayan F Silva R
 */
public interface TransaccionService {

    Transaccion saveTransaccion(Transaccion transaccion);

    Transaccion editTransaccion(Transaccion transaccion);

    Transaccion findTransaccionById(Long id);

    void deleteTransaccion(Transaccion transaccion);
}