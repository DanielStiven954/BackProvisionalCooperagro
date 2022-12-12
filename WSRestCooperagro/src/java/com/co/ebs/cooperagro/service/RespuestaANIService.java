/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.RespuestaAniOlimpiait;

/**
 *
 * @author Brayan Moreno
 */
public interface RespuestaANIService {
    
    RespuestaAniOlimpiait saveRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait);
    
    RespuestaAniOlimpiait updateRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait);
    
    RespuestaAniOlimpiait findRespuestaById(Long id);
    
    RespuestaAniOlimpiait findRespuestaByIdent(Long iTipoident, String sNumIdent);
    
}
