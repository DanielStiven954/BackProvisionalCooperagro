/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.RespuestaAniOlimpiait;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public interface RespuestaANIDataAccess {
    
    RespuestaAniOlimpiait saveRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait);
    
    RespuestaAniOlimpiait updateRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait);
    
    RespuestaAniOlimpiait findRespuestaById(Long id);
    
    List<RespuestaAniOlimpiait> findRespuestaAniOlimpiait(Long iTipoIdent, String sNumIdent);
    
}
