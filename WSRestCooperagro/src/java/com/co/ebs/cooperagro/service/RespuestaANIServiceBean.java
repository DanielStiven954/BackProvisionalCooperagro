/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.RespuestaANIDataAccessImp;
import com.co.ebs.cooperagro.domain.RespuestaAniOlimpiait;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class RespuestaANIServiceBean  implements RespuestaANIService{

    @Override
    public RespuestaAniOlimpiait saveRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait) {
        return new RespuestaANIDataAccessImp().create(respuestaAniOlimpiait);
    }

    @Override
    public RespuestaAniOlimpiait updateRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait) {
        return new RespuestaANIDataAccessImp().update(respuestaAniOlimpiait);
    }

    @Override
    public RespuestaAniOlimpiait findRespuestaById(Long id) {
        return new RespuestaANIDataAccessImp().find(id);
    }

    @Override
    public RespuestaAniOlimpiait findRespuestaByIdent(Long iTipoident, String sNumIdent) {
      RespuestaAniOlimpiait findRestByIdent = new RespuestaAniOlimpiait();
        List<RespuestaAniOlimpiait> list = new RespuestaANIDataAccessImp().findRespuestaAniOlimpiait(iTipoident, sNumIdent);
        for(RespuestaAniOlimpiait respuesta : list){
            findRestByIdent = respuesta;
            break;
        }

        return findRestByIdent;
    }
    
}
