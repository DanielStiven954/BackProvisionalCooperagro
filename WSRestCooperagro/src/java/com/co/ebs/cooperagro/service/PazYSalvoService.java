/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseObligacionesTerminadas;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public interface PazYSalvoService {
    
    ResponseObligacionesTerminadas obligacionesTerminadas(String xiCodigo, String xcProducto);
    
    //DatoDTO obligacionTerminada(String xiCodigo, String xcProducto);
}
