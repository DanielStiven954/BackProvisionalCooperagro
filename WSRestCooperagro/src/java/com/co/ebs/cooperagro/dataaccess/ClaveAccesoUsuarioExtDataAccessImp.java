/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class ClaveAccesoUsuarioExtDataAccessImp extends WSRestGenericRepositoryJPA<ClaveAccesoUsuarioExterno> implements ClaveAccesoUsuarioExtDataAccess {

    private EntityManager em = null;

    @Override
    public Boolean createClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        Boolean bRtaCreate = Boolean.FALSE;
        ClaveAccesoUsuarioExterno createClaveUsuarioExterno = create(claveAccesoUsuarioExterno);
        if (createClaveUsuarioExterno != null && createClaveUsuarioExterno.getICodigo() != null) {
            bRtaCreate = Boolean.TRUE;
        }
        return bRtaCreate;
    }

    @Override
    public Boolean updateClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        Boolean bRtaUpdate = Boolean.FALSE;
        ClaveAccesoUsuarioExterno updateClaveUsuarioExterno = update(claveAccesoUsuarioExterno);
        if (updateClaveUsuarioExterno != null && updateClaveUsuarioExterno.getICodigo() != null) {
            bRtaUpdate = Boolean.TRUE;
        }
        return bRtaUpdate;
    }

    @Override
    public void deleteClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        delete(claveAccesoUsuarioExterno);
    }

    @Override
    public List<ClaveAccesoUsuarioExterno> findAllClaveAccesoUsuExt() {
        return findAll();
    }

    @Override
    public ClaveAccesoUsuarioExterno findClaveAccesoUsuExtById(Long id) {
        return find(id);
    }

    @Override
    public List<ClaveAccesoUsuarioExterno> findClaveAccesoUsuExtByIdent(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {

        List<ClaveAccesoUsuarioExterno> listClaveAccesoUsuExt = null;
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<ClaveAccesoUsuarioExterno> query = em.createNamedQuery("ClaveAccesoUsuarioExterno.findByITipoIdentAndIdentEstado", ClaveAccesoUsuarioExterno.class);
            query.setParameter("iTipoIdent", claveAccesoUsuarioExterno.getITipoIdent());
            query.setParameter("cIdentificacion", claveAccesoUsuarioExterno.getCIdentificacion());
            query.setParameter("cEstado", "ACT");
            listClaveAccesoUsuExt = query.getResultList();
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
        return listClaveAccesoUsuExt;
    }
}
