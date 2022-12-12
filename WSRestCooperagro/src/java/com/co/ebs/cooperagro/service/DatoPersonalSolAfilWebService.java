/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.request.RequestDatosPersonalesSolAfil;
import com.co.ebs.cooperagro.request.RequestValdIdentSolAfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseValidarSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author JONATHAN RUGE
 */
public interface DatoPersonalSolAfilWebService {

    ResponseValidarSolAfilWeb validarSolAfil(RequestValdIdentSolAfil requestValdIdentSolAfil);

    DatoPersonalSolAfilWeb crear(Long tipoIdent, String cIdentificacion, SolicitudAfiliacionWeb solAfiWeb);

    List<DatoPersonalSolAfilWeb> listaDatoPersonal();

    DatoPersonalSolAfilWeb updateDatoPersonalSolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb);

    DatoPersonalSolAfilWeb findDatoPersonalSolAfilWebById(Long Id);

    DatoPersonalSolAfilWeb findDatoPersonalBySolAfilWeb(Long idSolAfilWeb);
    
    respuestaGenerica updateDatosPersonalesBySolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb);
    
    boolean updateCursoCooperativo(String declaracion, Long idSolAfilWeb);
}
