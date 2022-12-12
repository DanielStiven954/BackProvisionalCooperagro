/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DocumentoSolicitudCredito;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface DocSolicitudCreditoDataAccess {

    DocumentoSolicitudCredito saveDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    DocumentoSolicitudCredito updateDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    void deleteDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito);

    List<DocumentoSolicitudCredito> consDocSolCredito();

    DocumentoSolicitudCredito findDocSolCreditoById(Long idSolicitudCredito);

    List<DocumentoSolicitudCredito> findDocSolCreditoByIdSolCred(Long idSolicitudCredito);

    List<DocumentoSolicitudCredito> findDocSolCreditoByIdTipoReqSolCred(Long idSolicitudCredito, Long idTipoReqSolCred);

}
