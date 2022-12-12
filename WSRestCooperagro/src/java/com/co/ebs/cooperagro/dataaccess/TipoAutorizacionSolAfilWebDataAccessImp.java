/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoAutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan Moreno
 */
public class TipoAutorizacionSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<TipoAutorizacionSolAfilWeb> implements TipoAutorizacionSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public TipoAutorizacionSolAfilWeb saveTipoAutorizacionSolAfilWeb(TipoAutorizacionSolAfilWeb tipoAutorizacionSolAfilWeb) {
        return create(tipoAutorizacionSolAfilWeb);
    }

    @Override
    public TipoAutorizacionSolAfilWeb updateTipoAutorizacionSolAfilWeb(TipoAutorizacionSolAfilWeb tipoAutorizacionSolAfilWeb) {
        return update(tipoAutorizacionSolAfilWeb);
    }

    @Override
    public List<TipoAutorizacionSolAfilWeb> findAllTipoAutorizacionSolAfilWeb() {
        //return findAll();
        
        List<TipoAutorizacionSolAfilWeb> listAutorizacionSolAfilWeb = new ArrayList<>();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM TIPO_AUTORIZACION_SOL_AFIL_WEB WHERE C_ESTADO = 'ACT' ";
            Query consultDocument = em.createNativeQuery(sSQL, TipoAutorizacionSolAfilWeb.class);
            listAutorizacionSolAfilWeb = consultDocument.getResultList();

            
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

        return listAutorizacionSolAfilWeb;
        
    }

    @Override
    public TipoAutorizacionSolAfilWeb findByIdTipoAutoSolAfilWeb(Long id) {

        TipoAutorizacionSolAfilWeb autorizacionSolAfilWeb = new TipoAutorizacionSolAfilWeb();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM TIPO_AUTORIZACION_SOL_AFIL_WEB WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, TipoAutorizacionSolAfilWeb.class);
            consultDocument.setParameter(1, id);
            List<TipoAutorizacionSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                for (TipoAutorizacionSolAfilWeb tipo : listTipo) {
                    if (tipo.getICodigo().longValue() == id) {
                        autorizacionSolAfilWeb = tipo;
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

        return autorizacionSolAfilWeb;
    }

}
