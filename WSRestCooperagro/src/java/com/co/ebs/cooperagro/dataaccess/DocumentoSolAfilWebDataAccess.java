/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DocumentoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface DocumentoSolAfilWebDataAccess {

    DocumentoSolAfilWeb saveDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb);

    DocumentoSolAfilWeb updateDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb);

    DocumentoSolAfilWeb findDocumentoSolAfilWebById(Long id);

    DocumentoSolAfilWeb findDocumentoBySolAfilWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb);
    
    List<DocumentoSolAfilWeb> findDocumentoByIdSolAfilWeb(Long idSolAfilWeb);

    void deleteDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb);

    List<DocumentoSolAfilWeb> findAllDocumentoSolAfilWeb();
}
