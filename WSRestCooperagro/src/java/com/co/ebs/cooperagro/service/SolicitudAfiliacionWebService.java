/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.request.RequestEstadoSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author JONATHAN RUGE
 */
public interface SolicitudAfiliacionWebService {

    SolicitudAfiliacionWeb crearSolicitudAfiliacion();
    
    SolicitudAfiliacionWeb updateSolicitudAfiliacionWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb);
    
    SolicitudAfiliacionWeb findSolicitudAfiliacionWebById(Long id);
    
    respuestaGenerica updateDatosInicialesSolAflWeb(Long lCodSolAfilWeb, Long lCodCiudad, String sTipoIngreso, String sFechaRetiro,String sFechaRadicado);
    
    respuestaGenerica cambiarEstado(RequestEstadoSolAfilWeb estadoSolAfilWeb);
    
    respuestaGenerica radicarSolAfilWeb(RequestEstadoSolAfilWeb estadoSolAfilWeb);
}
