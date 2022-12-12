/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Pqrsf;
import com.co.ebs.cooperagro.request.RequestRegistrarPQRSF;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseListPqrsrf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author YO
 */
public interface PqrsfService {
    
    respuestaGenerica realizarRegistroPQRSF(RequestRegistrarPQRSF registrarPQRSF);
    
    ResponseListPqrsrf obtenerListaPqrsf();
   
    ResponsePqrsf obtenerPqrsfById(Long id);
}
