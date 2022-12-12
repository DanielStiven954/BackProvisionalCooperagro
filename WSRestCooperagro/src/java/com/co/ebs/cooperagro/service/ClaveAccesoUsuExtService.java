/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface ClaveAccesoUsuExtService {

    Boolean createClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    Boolean updateClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    void deleteClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    List<ClaveAccesoUsuarioExterno> findAllClaveAccesoUsuExt();

    ClaveAccesoUsuarioExterno findClaveAccesoUsuExtById(Long id);

    List<ClaveAccesoUsuarioExterno> findClaveAccesoUsuExtByIdent(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    respuestaGenerica validarCodigoVerificacion(BigInteger iTtipoIdent, String sIdent, String sCodVerificacion, String sClave, int iTipoCanal);

    respuestaGenerica registrarUsuarioNuevo(BigInteger iTtipoIdent, String sIdent, String sCodVerificacion, String sClave, int iTipoCanal);

}
