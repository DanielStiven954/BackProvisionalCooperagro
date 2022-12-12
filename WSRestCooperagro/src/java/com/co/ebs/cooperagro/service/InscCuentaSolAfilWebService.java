/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Administrador
 */
public interface InscCuentaSolAfilWebService {
    
    respuestaGenerica saveCuentaSolAfilWeb(InscCuentaSolAfilWeb cuentaSolAfilWeb);
    
    InscCuentaSolAfilWeb findInscCuentaByIdSol(Long idSolAfilWeb);
    
}
