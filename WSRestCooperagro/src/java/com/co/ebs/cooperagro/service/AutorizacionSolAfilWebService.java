/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public interface AutorizacionSolAfilWebService {
    
    respuestaGenerica saveAutorizacionSolAfilWeb(List<AutorizacionSolAfilWeb> listAutorizaciones);
}
