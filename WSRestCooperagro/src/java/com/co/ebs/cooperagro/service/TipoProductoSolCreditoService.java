/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoProductoSolCredito;

/**
 *
 * @author Jonathan Ruge
 */
public interface TipoProductoSolCreditoService {

    ResponseTipoProductoSolCredito listTipoProductoSolCredito();

    ResponseTipoProductoSolCredito listTipoProductoSolCreditoById(Long codigoTipoProducto);
}
