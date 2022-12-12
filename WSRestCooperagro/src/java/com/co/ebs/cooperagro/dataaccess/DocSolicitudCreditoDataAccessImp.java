/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DocumentoSolicitudCredito;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author joseph
 */
public class DocSolicitudCreditoDataAccessImp extends WSRestGenericRepositoryJPA<DocumentoSolicitudCredito> implements DocSolicitudCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public DocumentoSolicitudCredito saveDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        return create(documentoSolicitudCredito);
    }

    @Override
    public DocumentoSolicitudCredito updateDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        return update(documentoSolicitudCredito);
    }

    @Override
    public void deleteDocSolCredito(DocumentoSolicitudCredito documentoSolicitudCredito) {
        delete(documentoSolicitudCredito);
    }

    @Override
    public List<DocumentoSolicitudCredito> consDocSolCredito() {
        return findAll();
    }

    @Override
    public DocumentoSolicitudCredito findDocSolCreditoById(Long idSolicitudCredito) {
        return find(idSolicitudCredito);
    }

    @Override
    public List<DocumentoSolicitudCredito> findDocSolCreditoByIdSolCred(Long idSolicitudCredito) {
        connectionDBJPA connDBJPA = new connectionDBJPA();
        List<DocumentoSolicitudCredito> listDocSolCred = null;
        try {
            em = connDBJPA.getEntityManager();
            String sSQLQuery = "SELECT * FROM DOCUMENTOS_SOLICITUD_CREDITO WHERE I_SOLICITUD_CREDITO=?";
            Query query = em.createNativeQuery(sSQLQuery, DocumentoSolicitudCredito.class);
            query.setParameter(1, idSolicitudCredito);
            listDocSolCred = query.getResultList();
        } catch (Exception e) {
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return listDocSolCred;
    }

    @Override
    public List<DocumentoSolicitudCredito> findDocSolCreditoByIdTipoReqSolCred(Long idSolicitudCredito, Long idTipoReqSolCred) {
        connectionDBJPA connDBJPA = new connectionDBJPA();
        List<DocumentoSolicitudCredito> listDocSolCred = null;
        String sSQLQuery = "SELECT * FROM DOCUMENTOS_SOLICITUD_CREDITO WHERE I_SOLICITUD_CREDITO=? AND I_TIPO_REQ_SOL_CRED = ?";
        try {
            em = connDBJPA.getEntityManager();           
            Query query = em.createNativeQuery(sSQLQuery, DocumentoSolicitudCredito.class);
            query.setParameter(1, idSolicitudCredito);
            query.setParameter(2, idTipoReqSolCred);
            listDocSolCred = query.getResultList();
        } catch (Exception e) {
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listDocSolCred;
    }

}
