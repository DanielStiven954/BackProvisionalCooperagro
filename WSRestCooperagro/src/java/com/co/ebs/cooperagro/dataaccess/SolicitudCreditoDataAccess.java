/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface SolicitudCreditoDataAccess {

   SolicitudCredito saveSolicitud(SolicitudCredito xData) throws Exception;

    SolicitudCredito updateSolicitud(SolicitudCredito xData);
    
    SolicitudCredito findSolicitudCreditoById(Long id);
    
    List<SolicitudCredito> findSolCreditoByPersona(Long idPersona);

    void deleteSolicitud(SolicitudCredito xData);

    List<SolicitudCredito> findSolicitudByID(long xCodigo);
    
    List<SolicitudCredito> findAllSolicitudCredito();
    
    List<SolicitudCredito> findAllSolicitudCreditoOrderByFechaSolCred();

    List<SolicitudCredito> findAllSolicitud();
    
    List<SolicitudCredito> validarSolicitud(String codPersona, String estadoSol);
    
    SolicitudCredito verificarSolCredByPersonaAndLineaCred(Long idPersona, Long idLineaCred);

    SolicitudCredito verificarSolCredByPersonaAndLineaCredRadicado(Long idPersona,Long idLineaCred);
    
    SolicitudCredito validarSolCredByPersonaAndCodCredito(Long idPersona,Long idLineaCred);
    
    SolicitudCredito verificarSolCredByPersonaAndLineaCredDiligenRadic(Long idPersona,Long idLineaCred);
    
}
