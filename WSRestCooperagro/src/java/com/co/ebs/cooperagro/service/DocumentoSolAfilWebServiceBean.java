/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.DocumentoSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.DocumentoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.request.RequestDocSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class DocumentoSolAfilWebServiceBean implements DocumentoSolAfilWebService {

    private final DocumentoSolAfilWebDataAccessImp documentoSolAfilWebDataAccessImp = new DocumentoSolAfilWebDataAccessImp();

    @Override
    public DocumentoSolAfilWeb saveDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        return this.documentoSolAfilWebDataAccessImp.saveDocumentoSolAfilWeb(documentoSolAfilWeb);
    }

    @Override
    public DocumentoSolAfilWeb updateDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        return this.documentoSolAfilWebDataAccessImp.updateDocumentoSolAfilWeb(documentoSolAfilWeb);
    }

    @Override
    public DocumentoSolAfilWeb findDocumentoSolAfilWebById(Long id) {
        return this.documentoSolAfilWebDataAccessImp.findDocumentoSolAfilWebById(id);
    }

    @Override
    public DocumentoSolAfilWeb findDocumentoBySolAfilWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb) {
        return this.documentoSolAfilWebDataAccessImp.findDocumentoBySolAfilWeb(solicitudAfiliacionWeb);
    }

    @Override
    public void deleteDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        this.documentoSolAfilWebDataAccessImp.deleteDocumentoSolAfilWeb(documentoSolAfilWeb);
    }

    @Override
    public List<DocumentoSolAfilWeb> findDocumentoByIdSolAfilWeb(Long idSolAfilWeb) {
        return this.documentoSolAfilWebDataAccessImp.findDocumentoByIdSolAfilWeb(idSolAfilWeb);
    }

    @Override
    public List<DocumentoSolAfilWeb> findAllDocumentoSolAfilWeb() {
        return this.documentoSolAfilWebDataAccessImp.findAllDocumentoSolAfilWeb();
    }

    @Override
    public DocumentoSolAfilWeb findDocumentoSolAfilWebByTipoReqSolAfil(Long idSolAfil, Long idTipoRequ) {
        return this.documentoSolAfilWebDataAccessImp.findDocumentoSolAfilWebByTipoReqSolAfil(idSolAfil, idTipoRequ);
    }

    @Override
    public respuestaGenerica saveDocumentoBySolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        respuestaGenerica rtaGenSaveDocumento = new respuestaGenerica();
        /*if (documentoSolAfilWeb != null) {
            if (documentoSolAfilWeb.getISolAfiliacionWeb() != null && documentoSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                
                DatoPersonalSolAfilWebService afilWebService = new DatoPersonalSolAfilWebServiceBean();
                boolean cursoUpdate = afilWebService.updateCursoCooperativo("S", documentoSolAfilWeb.getICodigo());
                
                if(cursoUpdate){
                    System.out.println("Se actualizo curso");
                }
                
                
                DocumentoSolAfilWeb infoBuscada = this.findDocumentoSolAfilWebByTipoReqSolAfil(documentoSolAfilWeb.getISolAfiliacionWeb().getICodigo(),documentoSolAfilWeb.getITipoRequisito().getICodigo());
                if (infoBuscada!=null) {
                    
                    infoBuscada.setCObservacion("La persona a actualizado el requisito correctamente.");
                    infoBuscada.setCRutaFtp(documentoSolAfilWeb.getCRutaFtp());
                    infoBuscada.setCNombreDocumento(documentoSolAfilWeb.getCNombreDocumento());

                    DocumentoSolAfilWeb dsaw = this.updateDocumentoSolAfilWeb(infoBuscada);
                    if (dsaw != null && dsaw.getICodigo() != null) {
                        rtaGenSaveDocumento.setbRta(Boolean.TRUE);
                        rtaGenSaveDocumento.setiCodigo(1);
                        rtaGenSaveDocumento.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                        rtaGenSaveDocumento.setiCodigo(0);
                        rtaGenSaveDocumento.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
                else{
                    documentoSolAfilWeb.setCObservacion("La persona a registrado el requisito correctamente.");
                    documentoSolAfilWeb.setFFechaDocumento(new Date());      
                    DocumentoSolAfilWeb dsaw = this.saveDocumentoSolAfilWeb(documentoSolAfilWeb);
                    if (dsaw != null && dsaw.getICodigo() != null) {
                        rtaGenSaveDocumento.setbRta(Boolean.TRUE);
                        rtaGenSaveDocumento.setiCodigo(1);
                        rtaGenSaveDocumento.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                        rtaGenSaveDocumento.setiCodigo(0);
                        rtaGenSaveDocumento.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
                
                
            } else {
                rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                rtaGenSaveDocumento.setiCodigo(0);
                rtaGenSaveDocumento.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        } else {
            rtaGenSaveDocumento.setbRta(Boolean.FALSE);
            rtaGenSaveDocumento.setiCodigo(0);
            rtaGenSaveDocumento.setsMsj("Verifique la información enviada.");
        }*/
        return rtaGenSaveDocumento;
    }

    public respuestaGenerica saveDocSolAfilWeb(RequestDocSolAfilWeb documentoSolAfilWeb) {
        respuestaGenerica rtaGenSaveDocumento = new respuestaGenerica();
        if (documentoSolAfilWeb != null) {
            if (!documentoSolAfilWeb.getListaDocumentos().isEmpty()) {
                DatoPersonalSolAfilWebServiceBean afilWebService = new DatoPersonalSolAfilWebServiceBean();
                boolean cursoUpdate = afilWebService.updateCursoCooperativo(documentoSolAfilWeb.getCCursoCooperativismo(), documentoSolAfilWeb.getListaDocumentos().get(0).getISolAfiliacionWeb().getICodigo());

                ActEconoSolAfilWebServiceBean actEconoSolAfilWebServiceBean = new ActEconoSolAfilWebServiceBean();
                boolean declaracionRenta = actEconoSolAfilWebServiceBean.updateDeclaracionRenta(documentoSolAfilWeb.getCDeclaracionRenta(), documentoSolAfilWeb.getListaDocumentos().get(0).getISolAfiliacionWeb().getICodigo());

                for (DocumentoSolAfilWeb docs : documentoSolAfilWeb.getListaDocumentos()) {
                    DocumentoSolAfilWeb infoBuscada = this.findDocumentoSolAfilWebByTipoReqSolAfil(docs.getISolAfiliacionWeb().getICodigo(), docs.getITipoRequisito().getICodigo());
                    if (infoBuscada != null) {
                        infoBuscada.setCObservacion("La persona a actualizado el requisito correctamente.");
                        infoBuscada.setCBase64(docs.getCBase64());
                        infoBuscada.setCNombreDocumento(docs.getCNombreDocumento());
                        infoBuscada.setCTipoArchivo(docs.getCTipoArchivo());

                        DocumentoSolAfilWeb dsaw = this.updateDocumentoSolAfilWeb(infoBuscada);
                        if (dsaw != null && dsaw.getICodigo() != null) {
                            rtaGenSaveDocumento.setbRta(Boolean.TRUE);
                            rtaGenSaveDocumento.setiCodigo(1);
                            rtaGenSaveDocumento.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                        } else {
                            rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                            rtaGenSaveDocumento.setiCodigo(0);
                            rtaGenSaveDocumento.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                        }
                    } else {
                        docs.setCObservacion("La persona a registrado el requisito correctamente.");
                        docs.setFFechaDocumento(new Date());
                        DocumentoSolAfilWeb dsaw = this.saveDocumentoSolAfilWeb(docs);
                        if (dsaw != null && dsaw.getICodigo() != null) {
                            rtaGenSaveDocumento.setbRta(Boolean.TRUE);
                            rtaGenSaveDocumento.setiCodigo(1);
                            rtaGenSaveDocumento.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de afiliación.");
                        } else {
                            rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                            rtaGenSaveDocumento.setiCodigo(0);
                            rtaGenSaveDocumento.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                        }
                    }

                }

            } else {
                rtaGenSaveDocumento.setbRta(Boolean.FALSE);
                rtaGenSaveDocumento.setiCodigo(0);
                rtaGenSaveDocumento.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        } else {
            rtaGenSaveDocumento.setbRta(Boolean.FALSE);
            rtaGenSaveDocumento.setiCodigo(0);
            rtaGenSaveDocumento.setsMsj("Verifique la información enviada.");
        }
        return rtaGenSaveDocumento;
    }
}
