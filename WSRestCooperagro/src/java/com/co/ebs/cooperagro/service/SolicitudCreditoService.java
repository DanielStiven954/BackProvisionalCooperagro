/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCambioEstadoSolCred;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseValidarSolCredPersona;
import com.co.ebs.cooperagro.respuestasGenericas.SolicitudCreditoRta;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Jonathan Ruge
 */
public interface SolicitudCreditoService {

    ResponseSolicitudCredito validarSolicitud(String xData);

    ResponseSolicitudCredito saveSolicitud(Long idSolCred,Long idTipoCanal, Long idTipoProducto, String xData);

    ResponseSolicitudCredito updateSolicitud(SolicitudCredito xData);
    
    SolicitudCredito saveSolicitudCredito(SolicitudCredito solicitudCredito);

    SolicitudCredito updateSolicitudCredito(SolicitudCredito solicitudCredito);

    ResponseCambioEstadoSolCred cambioEstadoSolicitudCredito(Long idSolicitudCredito, Long idUsuarioModificador, Long idTipoEstadoSolCred, String sObservacion);

    ResponseSolicitudCredito findSolicitudByID(long xCodigo);

    SolicitudCredito findSolicitudCreditoById(long xCodigo);

    ResponseSolicitudCredito findAllSolicitud();

    ResponseSolicitudCredito cargarSolicitudes();

    ResponseSolicitudCredito cargarSolCreditoByPersona(Long idPersona);

    SolicitudCreditoRta obtenerDetalleSolCredById(Long idSolCred);

    SolicitudCreditoRta obtenerDetalleSolCredById(Long idSolCred, Long idCurrentUser);

    respuestaGenerica radicarSolicitudCredito(Long idSolicitudCredito, Long idUsuarioModificador);
    
    respuestaGenerica radicarSolicitudCreditoAPP(SolicitudCredito solCred, Long iCodUser);

    respuestaGenerica saveAutorizacionesSolCred(String xData);

    respuestaGenerica actualizarSolicitudCredito(String xData);

    void deleteSolicitud(SolicitudCredito xData);

    SolicitudCredito validarSolCredByPersonaAndCodCredito(Long idPersona, Long idLineaCred);

    ResponseValidarSolCredPersona validarExistenciaSolCredByidLineaCred(Long idPersona, Long idLineaCred);

//    respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador);
}
