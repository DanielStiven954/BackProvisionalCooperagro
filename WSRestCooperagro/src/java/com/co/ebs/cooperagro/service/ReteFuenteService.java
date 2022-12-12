/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import wsmovimientoscygnus_retefuente.RespuestaCert;
import com.co.ebs.cooperagro.request.RequestReteFuente;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.HashMap;

/**
 *
 * @author YO
 */
public interface ReteFuenteService {
    
    //HashMap<String, String> retencionFuente(RequestReteFuente requestReteFuente);
    respuestaGenerica retencionFuentePDF(RequestReteFuente requestReteFuente);
}
