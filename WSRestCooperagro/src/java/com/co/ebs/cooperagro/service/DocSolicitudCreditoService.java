/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.DocumentoSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseDocSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface DocSolicitudCreditoService {

    DocumentoSolicitudCredito saveDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    DocumentoSolicitudCredito updateDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    void deleteDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    List<DocumentoSolicitudCredito> consDocSolCredito();

    DocumentoSolicitudCredito findDocSolCreditoById(Long idDocSolCredito);

    respuestaGenerica guardarDocSolCredBySolCred(Long iTipoReqSolCred, String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc);
   
    respuestaGenerica saveDocSolCredCambioEstadoBySolCred(String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc);
    
    respuestaGenerica actualizarDocSolCredBySolCred(Long iIdDocSolCred, Long iTipoReqSolCred, String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc);

    List<DocumentoSolicitudCredito> findDocSolCreditoByIdSolCred(Long idSolicitudCredito);

    List<ResponseDocSolCredito> obtenerDocumentosSolCredByIdSolCred(Long idSolicitudCredito);
    
    List<DocumentoSolicitudCredito> findDocSolCreditoByIdTipoReqSolCred(Long idSolicitudCredito, Long idTipoReqSolCred);
}
