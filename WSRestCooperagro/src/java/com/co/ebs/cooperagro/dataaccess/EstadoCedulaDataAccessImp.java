/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.EstadoCedula;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan Moreno
 */
public class EstadoCedulaDataAccessImp extends WSRestGenericRepositoryJPA<EstadoCedula> implements EstadoCedulaDataAccess {

    private EntityManager em = null;

    @Override
    public EstadoCedula findEstadoCedulaByCodVigencia(Long idCodVigencia) {
        EstadoCedula findEstadoCedula = new EstadoCedula();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<EstadoCedula> consultDocument = em.createNamedQuery("EstadoCedula.findByICodigoVigencia", EstadoCedula.class);
            consultDocument.setParameter("iCodigoVigencia", idCodVigencia);
            List<EstadoCedula> list = consultDocument.getResultList();
            if (list != null && !list.isEmpty()) {
                findEstadoCedula = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return findEstadoCedula;
    }

    @Override
    public EstadoCedula findEstadoCedulaByid(Long id) {
        return find(id);
    }

}
