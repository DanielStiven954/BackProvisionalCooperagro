/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AuditoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
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
public class AutorizacionSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<AutorizacionSolAfilWeb> implements AutorizacionSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public AutorizacionSolAfilWeb saveAutorizacionSolAfilWeb(AutorizacionSolAfilWeb autorizacionSolAfilWeb) {
        return create(autorizacionSolAfilWeb);
    }

    @Override
    public AutorizacionSolAfilWeb updateAutorizacionSolAfilWeb(AutorizacionSolAfilWeb autorizacionSolAfilWeb) {
        return update(autorizacionSolAfilWeb);
    }

    @Override
    public List<AutorizacionSolAfilWeb> findAllAutorizacionSolAfilWeb() {
        return findAll();
    }

    @Override
    public AutorizacionSolAfilWeb findByAutorizacionSolAfilWeb(Long id) {
        AutorizacionSolAfilWeb autorizacionSolAfilWeb = new AutorizacionSolAfilWeb();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM AUTORIZACION_SOL_AFIL_WEB WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, AutorizacionSolAfilWeb.class);
            consultDocument.setParameter(1, id);
            List<AutorizacionSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                for (AutorizacionSolAfilWeb tipo : listTipo) {
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

    @Override
    public AutorizacionSolAfilWeb findAutorizacionSolAfilWebByTipoAutorizacion(Long idSolAfil, Long idTipoAuto) {
        AutorizacionSolAfilWeb autorizacionSolAfilWeb = new AutorizacionSolAfilWeb();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM AUTORIZACION_SOL_AFIL_WEB WHERE I_TIPO_AUTORIZACION = ? AND I_SOL_AFILIACION_WEB = ? ";
            Query consultDocument = em.createNativeQuery(sSQL, AutorizacionSolAfilWeb.class);
            consultDocument.setParameter(1, idTipoAuto);
            consultDocument.setParameter(2, idSolAfil);
            List<AutorizacionSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                autorizacionSolAfilWeb = listTipo.get(0);
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

    @Override
    public List<AutorizacionSolAfilWeb> findAllAutizacionesByIdSolAfilWeb(Long idSolAfil) {

        List<AutorizacionSolAfilWeb> list = new ArrayList<>();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM AUTORIZACION_SOL_AFIL_WEB WHERE I_SOL_AFILIACION_WEB = ? ";
            Query consultDocument = em.createNativeQuery(sSQL, AutorizacionSolAfilWeb.class);
            consultDocument.setParameter(1, idSolAfil);
            List<AutorizacionSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                list = listTipo;
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

        return list;

    }

}
