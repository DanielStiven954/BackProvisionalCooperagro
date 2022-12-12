/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.domain.DocumentoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class DocumentoSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<DocumentoSolAfilWeb> implements DocumentoSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public DocumentoSolAfilWeb saveDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        return create(documentoSolAfilWeb);
    }

    @Override
    public DocumentoSolAfilWeb updateDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        return update(documentoSolAfilWeb);
    }

    @Override
    public DocumentoSolAfilWeb findDocumentoSolAfilWebById(Long id) {
        return find(id);
    }
    
    public DocumentoSolAfilWeb findDocumentoSolAfilWebByTipoReqSolAfil(Long idSolAfil,Long idTipoRequ){
        DocumentoSolAfilWeb documentoSolAfilWeb = null;
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM DOCUMENTOS_SOL_AFIL_WEB WHERE I_TIPO_REQUISITO=? AND I_SOL_AFILIACION_WEB=?";
            Query query = em.createNativeQuery(sql, DocumentoSolAfilWeb.class);
            query.setParameter(1, idTipoRequ);
            query.setParameter(2, idSolAfil);
            List<DocumentoSolAfilWeb> listDocs = query.getResultList();
            if (listDocs!=null && !listDocs.isEmpty()) {
                if (listDocs.size()>0) {
                    documentoSolAfilWeb = listDocs.get(0);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            documentoSolAfilWeb=null;
        }
        finally{
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return documentoSolAfilWeb;
    }
    
    
    @Override
    public List<DocumentoSolAfilWeb> findDocumentoByIdSolAfilWeb(Long idSolAfilWeb){
        List<DocumentoSolAfilWeb> listaDocs = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM DOCUMENTOS_SOL_AFIL_WEB WHERE I_SOL_AFILIACION_WEB = ?";
            Query query = em.createNativeQuery(sql, DocumentoSolAfilWeb.class);
            query.setParameter(1, idSolAfilWeb);
            List<DocumentoSolAfilWeb> listDocs = query.getResultList();
            if (listDocs!=null && !listDocs.isEmpty()) {
                listaDocs = listDocs;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            listaDocs=null;
        }
        finally{
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listaDocs;
    }

    @Override
    public DocumentoSolAfilWeb findDocumentoBySolAfilWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb) {
        DocumentoSolAfilWeb documentoSolAfilWeb = new DocumentoSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            if (solicitudAfiliacionWeb != null && solicitudAfiliacionWeb.getICodigo() != null) {
                em = connDBJPA.getEntityManager();
                TypedQuery<DocumentoSolAfilWeb> query = this.em.createNamedQuery("DocumentoSolAfilWeb.findByiSolAfiliacionWeb", DocumentoSolAfilWeb.class);
                query.setParameter("iSolAfiliacionWeb", solicitudAfiliacionWeb);
                List<DocumentoSolAfilWeb> lstDocumentoSolAfilWeb = new ArrayList<>();
                lstDocumentoSolAfilWeb = query.getResultList();
                if (lstDocumentoSolAfilWeb != null && !lstDocumentoSolAfilWeb.isEmpty()) {
                    for (DocumentoSolAfilWeb infoPensionadoSolAfilWeb : lstDocumentoSolAfilWeb) {
                        if (infoPensionadoSolAfilWeb.getISolAfiliacionWeb().equals(solicitudAfiliacionWeb)) {
                            documentoSolAfilWeb = infoPensionadoSolAfilWeb;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return documentoSolAfilWeb;
    }

    @Override
    public void deleteDocumentoSolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        delete(documentoSolAfilWeb);
    }

    @Override
    public List<DocumentoSolAfilWeb> findAllDocumentoSolAfilWeb() {
        return findAll();
    }

}
