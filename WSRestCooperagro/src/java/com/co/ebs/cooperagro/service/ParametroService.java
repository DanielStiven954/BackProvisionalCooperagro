/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseParametros;

/**
 *
 * @author Brayan F Silva R
 */
public interface ParametroService {
    
    String obtenerParametroPorNombre(String sNombreParam);
    ResponseParametros parametrosClave();
}
