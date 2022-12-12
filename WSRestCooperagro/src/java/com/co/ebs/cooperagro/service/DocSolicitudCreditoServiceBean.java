/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.DocSolicitudCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.DocumentoSolicitudCredito;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseDocSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joseph
 */
public class DocSolicitudCreditoServiceBean implements DocSolicitudCreditoService {

    private final DocSolicitudCreditoDataAccessImp docSolCredDataAccessImp = new DocSolicitudCreditoDataAccessImp();
    private final utilidad util = new utilidad();

    @Override
    public DocumentoSolicitudCredito saveDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        return docSolCredDataAccessImp.saveDocSolCredito(documentoSolicitudCredito);
    }

    @Override
    public DocumentoSolicitudCredito updateDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        return docSolCredDataAccessImp.updateDocSolCredito(documentoSolicitudCredito);
    }

    @Override
    public void deleteDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        docSolCredDataAccessImp.deleteDocSolCredito(documentoSolicitudCredito);
    }

    @Override
    public List<DocumentoSolicitudCredito> consDocSolCredito() {
        return docSolCredDataAccessImp.consDocSolCredito();
    }

    @Override
    public DocumentoSolicitudCredito findDocSolCreditoById(Long idDocSolCredito) {
        return docSolCredDataAccessImp.findDocSolCreditoById(idDocSolCredito);
    }

    @Override
    public respuestaGenerica guardarDocSolCredBySolCred(Long iTipoReqSolCred, String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc) {
        respuestaGenerica respGenerica = new respuestaGenerica();

        try {
            String sDecodeIdUser = util.decodeBase64(sIUsuario);
            Long lCodUser = new Long(sDecodeIdUser);
            String sDecodeObser = util.decodeBase64(Observaciones);
            String sDecodeIdSolCred = util.decodeBase64(sISolCred);
            Long lCodSolCred = new Long(sDecodeIdSolCred);
            String sDecodeRutaFTP = util.decodeBase64(RutaFtp);
            String sDecodeNombreDoc = util.decodeBase64(NombreDoc);
            Usuario usuarioCreador = new Usuario(lCodUser);
            List<DocumentoSolicitudCredito> findDocSolCred = this.findDocSolCreditoByIdTipoReqSolCred(lCodSolCred, iTipoReqSolCred);
            if (findDocSolCred != null && !findDocSolCred.isEmpty()) {
                for (DocumentoSolicitudCredito documentoSolicitudCredito : findDocSolCred) {
                    if (documentoSolicitudCredito.getISolicitudCredito().getICodigo().equals(lCodSolCred) && documentoSolicitudCredito.getITipoRequisitoSolCred().getICodigo().equals(iTipoReqSolCred)) {
                        documentoSolicitudCredito.setCObservacion(sDecodeObser);
                        documentoSolicitudCredito.setCNombreDocumento(sDecodeNombreDoc);
                        documentoSolicitudCredito.setCRutaFtp(sDecodeRutaFTP);
                        documentoSolicitudCredito.setFechaEnvio(new Date());
                        documentoSolicitudCredito.setIUsuarioCreador(usuarioCreador);
                        documentoSolicitudCredito.setFFechaCreacion(new Date());
                        DocumentoSolicitudCredito updateDocumentoSolicitudCredito = this.updateDocSolCredito(documentoSolicitudCredito);
                        if (updateDocumentoSolicitudCredito != null && updateDocumentoSolicitudCredito.getICodigo() != null && updateDocumentoSolicitudCredito.getCObservacion() != null && !updateDocumentoSolicitudCredito.getCObservacion().equals("")) {
                            respGenerica.setbRta(Boolean.TRUE);
                            respGenerica.setiCodigo(1);
                            respGenerica.setsMsj("Se ha actualizado correctamente la información del documento.");
                        } else {
                            respGenerica.setbRta(Boolean.FALSE);
                            respGenerica.setiCodigo(0);
                            respGenerica.setsMsj("No se ha podido actualizar la información información del documento.");
                        }
                    }
                }
            } else {
                DocumentoSolicitudCredito docSolicitudCredito = new DocumentoSolicitudCredito();
                TipoRequisitoSolCred tipoRequisitoSolCred = new TipoRequisitoSolCred(iTipoReqSolCred);
                SolicitudCredito sc = new SolicitudCredito(lCodSolCred);
                docSolicitudCredito.setCObservacion(sDecodeObser);
                docSolicitudCredito.setCNombreDocumento(sDecodeNombreDoc);
                docSolicitudCredito.setCRutaFtp(sDecodeRutaFTP);
                docSolicitudCredito.setFechaEnvio(new Date());
                docSolicitudCredito.setIUsuarioCreador(usuarioCreador);
                docSolicitudCredito.setFFechaCreacion(new Date());
                docSolicitudCredito.setISolicitudCredito(sc);
                docSolicitudCredito.setITipoRequisitoSolCred(tipoRequisitoSolCred);
                DocumentoSolicitudCredito saveDocSolicitudCredito = this.saveDocSolCredito(docSolicitudCredito);
                if (saveDocSolicitudCredito != null && saveDocSolicitudCredito.getICodigo() != null && saveDocSolicitudCredito.getCObservacion() != null && !saveDocSolicitudCredito.getCObservacion().equals("")) {
                    respGenerica.setbRta(Boolean.TRUE);
                    respGenerica.setiCodigo(1);
                    respGenerica.setsMsj("Se ha guardado correctamente la información del documento.");
                } else {
                    respGenerica.setbRta(Boolean.FALSE);
                    respGenerica.setiCodigo(0);
                    respGenerica.setsMsj("No se ha podido guardar correctamente la información del documento.");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            respGenerica.setbRta(Boolean.FALSE);
            respGenerica.setiCodigo(0);
            respGenerica.setsMsj("No se ha podido guardar correctamente la información del documento.");
        }

        return respGenerica;
    }

    @Override
    public respuestaGenerica saveDocSolCredCambioEstadoBySolCred(String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc) {
        respuestaGenerica respGenerica = new respuestaGenerica();

        try {
            String sDecodeIdUser = util.decodeBase64(sIUsuario);
            Long lCodUser = new Long(sDecodeIdUser);
            String sDecodeObser = util.decodeBase64(Observaciones);
            String sDecodeIdSolCred = util.decodeBase64(sISolCred);
            Long lCodSolCred = new Long(sDecodeIdSolCred);
            String sDecodeRutaFTP = util.decodeBase64(RutaFtp);
            String sDecodeNombreDoc = util.decodeBase64(NombreDoc);
            Usuario usuarioCreador = new Usuario(lCodUser);

            DocumentoSolicitudCredito docSolicitudCredito = new DocumentoSolicitudCredito();
            SolicitudCredito sc = new SolicitudCredito(lCodSolCred);
            docSolicitudCredito.setCObservacion(sDecodeObser);
            docSolicitudCredito.setCNombreDocumento(sDecodeNombreDoc);
            docSolicitudCredito.setCRutaFtp(sDecodeRutaFTP);
            docSolicitudCredito.setFechaEnvio(new Date());
            docSolicitudCredito.setIUsuarioCreador(usuarioCreador);
            docSolicitudCredito.setFFechaCreacion(new Date());
            docSolicitudCredito.setISolicitudCredito(sc);
            docSolicitudCredito.setITipoRequisitoSolCred(null);
            DocumentoSolicitudCredito saveDocSolicitudCredito = this.saveDocSolCredito(docSolicitudCredito);
            if (saveDocSolicitudCredito != null && saveDocSolicitudCredito.getICodigo() != null && saveDocSolicitudCredito.getCObservacion() != null && !saveDocSolicitudCredito.getCObservacion().equals("")) {
                respGenerica.setbRta(Boolean.TRUE);
                respGenerica.setiCodigo(1);
                respGenerica.setsMsj("Se ha guardado correctamente la información del documento.");
            } else {
                respGenerica.setbRta(Boolean.FALSE);
                respGenerica.setiCodigo(0);
                respGenerica.setsMsj("No se ha podido guardar correctamente la información del documento.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            respGenerica.setbRta(Boolean.FALSE);
            respGenerica.setiCodigo(0);
            respGenerica.setsMsj("No se ha podido guardar correctamente la información del documento.");
        }

        return respGenerica;
    }

    @Override
    public respuestaGenerica actualizarDocSolCredBySolCred(Long iIdDocSolCred, Long iTipoReqSolCred, String sIUsuario, String Observaciones, String sISolCred, String RutaFtp, String NombreDoc) {
        respuestaGenerica respGenerica = new respuestaGenerica();
        try {
            String sDecodeIdUser = util.decodeBase64(sIUsuario);
            Long lCodUser = new Long(sDecodeIdUser);
            String sDecodeObser = util.decodeBase64(Observaciones);
            String sDecodeIdSolCred = util.decodeBase64(sISolCred);
            Long lCodSolCred = new Long(sDecodeIdSolCred);
            String sDecodeRutaFTP = util.decodeBase64(RutaFtp);
            String sDecodeNombreDoc = util.decodeBase64(NombreDoc);
            DocumentoSolicitudCredito findDocSolicitudCreditoById = this.findDocSolCreditoById(iIdDocSolCred);
            if (findDocSolicitudCreditoById != null && findDocSolicitudCreditoById.getICodigo() != null) {
                Usuario usuarioCreador = new Usuario(lCodUser);
                TipoRequisitoSolCred tipoRequisitoSolCred = new TipoRequisitoSolCred(iTipoReqSolCred);
                SolicitudCredito sc = new SolicitudCredito(lCodSolCred);
                findDocSolicitudCreditoById.setCObservacion(sDecodeObser);
                findDocSolicitudCreditoById.setCNombreDocumento(sDecodeNombreDoc);
                findDocSolicitudCreditoById.setCRutaFtp(sDecodeRutaFTP);
                findDocSolicitudCreditoById.setFechaEnvio(new Date());
                findDocSolicitudCreditoById.setIUsuarioCreador(usuarioCreador);
                findDocSolicitudCreditoById.setFFechaCreacion(new Date());
                findDocSolicitudCreditoById.setISolicitudCredito(sc);
                findDocSolicitudCreditoById.setITipoRequisitoSolCred(tipoRequisitoSolCred);
                DocumentoSolicitudCredito updatwDocSolicitudCredito = this.updateDocSolCredito(findDocSolicitudCreditoById);
                if (updatwDocSolicitudCredito != null && updatwDocSolicitudCredito.getICodigo() != null && updatwDocSolicitudCredito.getCObservacion() != null && !updatwDocSolicitudCredito.getCObservacion().equals("")) {
                    respGenerica.setbRta(Boolean.TRUE);
                    respGenerica.setsMsj("Se ha actualizado correctamente la información del documento.");
                } else {
                    respGenerica.setbRta(Boolean.FALSE);
                    respGenerica.setsMsj("No se ha podido actualizar correctamente la información del documento.");
                }
            } else {
                respGenerica.setbRta(Boolean.FALSE);
                respGenerica.setsMsj("No se ha obtenido información del documento.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            respGenerica.setbRta(Boolean.FALSE);
            respGenerica.setsMsj("No se ha podido guardar correctamente la información del documento.");
        }

        return respGenerica;
    }

    @Override
    public List<DocumentoSolicitudCredito> findDocSolCreditoByIdSolCred(Long idSolicitudCredito) {
        return this.docSolCredDataAccessImp.findDocSolCreditoByIdSolCred(idSolicitudCredito);
    }

    @Override
    public List<ResponseDocSolCredito> obtenerDocumentosSolCredByIdSolCred(Long idSolicitudCredito) {
        List<ResponseDocSolCredito> responseDocSolCreditos = new ArrayList<>();
        List<DocumentoSolicitudCredito> documentoSolicitudCreditos = this.docSolCredDataAccessImp.findDocSolCreditoByIdSolCred(idSolicitudCredito);
        if (documentoSolicitudCreditos != null && !documentoSolicitudCreditos.isEmpty()) {
            ResponseDocSolCredito responseDocSolCredito = new ResponseDocSolCredito();
            for (DocumentoSolicitudCredito documentoSolicitudCredito : documentoSolicitudCreditos) {
                responseDocSolCredito.setiCodigo(documentoSolicitudCredito.getICodigo());
                responseDocSolCredito.setsRutaFTP(documentoSolicitudCredito.getCRutaFtp());
                responseDocSolCredito.setsNombreTipoReqSolCred(documentoSolicitudCredito.getITipoRequisitoSolCred().getCNombreRequisito());
                responseDocSolCredito.setsNombreArchivo(documentoSolicitudCredito.getCNombreDocumento());
                responseDocSolCredito.setiCodTipoReqSolCred(documentoSolicitudCredito.getITipoRequisitoSolCred().getICodigo());
                responseDocSolCredito.setsDescTipoReqSolCred(documentoSolicitudCredito.getITipoRequisitoSolCred().getCDescripcion());
                responseDocSolCredito.setsObligTipoReqSolCred(documentoSolicitudCredito.getITipoRequisitoSolCred().getCObligatorio());
                responseDocSolCreditos.add(responseDocSolCredito);
                responseDocSolCredito = new ResponseDocSolCredito();
            }
        }
        return responseDocSolCreditos;
    }

    @Override
    public List<DocumentoSolicitudCredito> findDocSolCreditoByIdTipoReqSolCred(Long idSolicitudCredito, Long idTipoReqSolCred) {
        List<DocumentoSolicitudCredito> documentoSolicitudCreditos = this.docSolCredDataAccessImp.findDocSolCreditoByIdTipoReqSolCred(idSolicitudCredito, idTipoReqSolCred);
        return documentoSolicitudCreditos;
    }
}
