/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
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
public class ActEconomicaSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<ActEconomicaSolAfilWeb> implements ActEconomicaSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public ActEconomicaSolAfilWeb saveActEconoSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        ActEconomicaSolAfilWeb saveActEconomicaSolAfilWeb = new ActEconomicaSolAfilWeb();
        try {
            saveActEconomicaSolAfilWeb = create(actEconomicaSolAfilWeb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveActEconomicaSolAfilWeb;
    }

    @Override
    public ActEconomicaSolAfilWeb updateActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        return update(actEconomicaSolAfilWeb);
    }

    @Override
    public ActEconomicaSolAfilWeb findActEconomicaSolAfilWebById(Long id) {
        return find(id);
    }

    @Override
    public ActEconomicaSolAfilWeb findActEconomicaBySolAfilWeb(Long idSolAfilWeb) {
        ActEconomicaSolAfilWeb aesaw = new ActEconomicaSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            if (idSolAfilWeb != null) {
                String sql = "SELECT A.* FROM ACT_ECONOMICA_SOL_AFIL_WEB A WHERE A.I_SOL_AFILIACION_WEB = ?";
                Query query = em.createNativeQuery(sql, ActEconomicaSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<ActEconomicaSolAfilWeb> lstActEconomicaSolAfilWeb = query.getResultList();
                if (lstActEconomicaSolAfilWeb != null && !lstActEconomicaSolAfilWeb.isEmpty()) {
                    for (ActEconomicaSolAfilWeb actEconomicaSolAfilWeb : lstActEconomicaSolAfilWeb) {
                        if (actEconomicaSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            aesaw = actEconomicaSolAfilWeb;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return aesaw;
    }

    @Override
    public void deleteActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        delete(actEconomicaSolAfilWeb);
    }

    @Override
    public List<ActEconomicaSolAfilWeb> findAllActEconomicaSolAfilWeb() {
        return findAll();
    }
    
    @Override
    public boolean updateDeclaracionRenta(String declaracion, Long idSolAfilWeb) {
        
        connectionDBJPA connDBJPA = new connectionDBJPA();
        boolean bandera = false;

        try {
            this.em = connDBJPA.getEntityManager();
            if (declaracion != null && idSolAfilWeb != null) {
                this.em.getTransaction().begin();
                Query query = this.em.createNativeQuery(" UPDATE ACT_ECONOMICA_SOL_AFIL_WEB SET C_DECLARACION_RENTA = ? WHERE I_SOL_AFILIACION_WEB = ? ");
                query.setParameter(1, declaracion);
                query.setParameter(2, idSolAfilWeb);
                query.executeUpdate();
                this.em.getTransaction().commit();
                bandera = true;

            }
        } catch (Exception e) {
             if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
            bandera = false;
            throw new RuntimeException(e.getMessage());

        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return bandera;
    }

}
