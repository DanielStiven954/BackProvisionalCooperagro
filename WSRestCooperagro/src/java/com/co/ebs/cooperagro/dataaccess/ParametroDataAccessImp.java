/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Parametros;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class ParametroDataAccessImp extends WSRestGenericRepositoryJPA<Parametros> implements ParametroDataAccess {

    private EntityManager em = null;

    @Override
    public String getValorParametroByNombre(String sNombreParametro) {
        String sValorParametro = "";
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Parametros> consultDocument = em.createNamedQuery("Parametros.findByCNombre", Parametros.class);
            consultDocument.setParameter("cNombre", sNombreParametro);
            List<Parametros> listParametro = consultDocument.getResultList();
            if (listParametro != null && !listParametro.isEmpty()) {
                for (Parametros param : listParametro) {
                    if (param.getCNombre().equals(sNombreParametro)) {
                        sValorParametro = param.getCValor();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            sValorParametro = "";
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return sValorParametro;
    }

}
