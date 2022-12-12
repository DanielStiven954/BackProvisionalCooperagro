/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Brayan F Silva R
 */
public class connectionDBJPA {

    private String sNombrePersistencia = new utilidad().getValueConfigurePropByKey("PERSISTENCE_UNIT_NAME");    
    private EntityManager em = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        
        emf = Persistence.createEntityManagerFactory(sNombrePersistencia);
        System.out.println("Dato "+emf);
        em = emf.createEntityManager();
        return em;
    }

   public void closeEntityManager() {
        if (emf != null) {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        if (em != null) {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
