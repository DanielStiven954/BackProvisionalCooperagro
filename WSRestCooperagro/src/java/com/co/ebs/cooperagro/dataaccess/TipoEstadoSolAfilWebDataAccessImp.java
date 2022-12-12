/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JONATHAN RUGE
 */
public class TipoEstadoSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<TipoEstadoSolAfilWeb> implements TipoEstadoSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public TipoEstadoSolAfilWeb findByAbre(String abrevi) {
        TipoEstadoSolAfilWeb tp = null;
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            TypedQuery<TipoEstadoSolAfilWeb> query = this.em.createNamedQuery("TipoEstadoSolAfilWeb.findByCAbreviatura", TipoEstadoSolAfilWeb.class);
            query.setParameter("cAbreviatura", abrevi);
            List<TipoEstadoSolAfilWeb> listTipoEstado = query.getResultList();
            if (listTipoEstado != null && !listTipoEstado.isEmpty()) {
                for (TipoEstadoSolAfilWeb param : listTipoEstado) {
                    if (param.getCAbreviatura().equals(abrevi)) {
                        tp = param;
                        break;
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
        return tp;
    }

}
