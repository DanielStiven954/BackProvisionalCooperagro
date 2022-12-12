/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DocumentoPqrsf;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class DocumentoPqrsfDataAccessImp extends WSRestGenericRepositoryJPA<DocumentoPqrsf> implements DocumentoPqrsfDataAccess {

    private EntityManager em = null;

    @Override
    public DocumentoPqrsf saveDocumentoPqrsf(DocumentoPqrsf documentoPqrsf) {
        return create(documentoPqrsf);
    }

    @Override
    public DocumentoPqrsf findByIdPqrsf(Long id) {
        DocumentoPqrsf documentoPqrsf = null;
        String sql = "SELECT * FROM DOCUMENTO_PQRSF WHERE I_PQRSF = ?";
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();
            Query consulta = this.em.createNativeQuery(sql, DocumentoPqrsf.class);
            consulta.setParameter(1, id);
            List<DocumentoPqrsf> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && listaConsulta.size() > 0) {
                documentoPqrsf = listaConsulta.get(0); //Escoge el registro con la fecha más reciente
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

        return documentoPqrsf;
    }

}
