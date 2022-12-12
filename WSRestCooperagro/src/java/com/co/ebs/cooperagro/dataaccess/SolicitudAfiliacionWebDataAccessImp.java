/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudAfilicion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JONATHAN RUGE
 */
public class SolicitudAfiliacionWebDataAccessImp extends WSRestGenericRepositoryJPA<SolicitudAfiliacionWeb> implements SolicitudAfiliacionWebDataAccess {

    TipoEstadoSolAfilWebDataAccessImp tipoEstSolAfil = new TipoEstadoSolAfilWebDataAccessImp();
    private EntityManager em = null;

    @Override
    public SolicitudAfiliacionWeb crear() {
        SolicitudAfiliacionWeb solicitudAfiliacionTemporal = new SolicitudAfiliacionWeb();
        solicitudAfiliacionTemporal.setFFechaSolicitud(new Date());
        TipoEstadoSolAfilWeb paraBuscar = tipoEstSolAfil.findByAbre("DLG");
        solicitudAfiliacionTemporal.setIEstadoSolicitud(paraBuscar);
        SolicitudAfiliacionWeb solicitudAfiliacionNueva = create(solicitudAfiliacionTemporal);
        return solicitudAfiliacionNueva;
    }

    @Override
    public SolicitudAfiliacionWeb updateSolicitudAfiliacionWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb) {
        return update(solicitudAfiliacionWeb);
    }

    @Override
    public SolicitudAfiliacionWeb findSolicitudAfiliacionWebById(Long id) {
        connectionDBJPA connDBJPA = new connectionDBJPA();
        SolicitudAfiliacionWeb saw = new SolicitudAfiliacionWeb();
        try {
            this.em = connDBJPA.getEntityManager();
            if (id != null) {
                Query query = this.em.createNativeQuery("SELECT * FROM SOLICITUD_AFILIACION_WEB WHERE I_CODIGO = ?", SolicitudAfiliacionWeb.class);
                query.setParameter(1, id);
                List<SolicitudAfiliacionWeb> lstSolAfilWeb = query.getResultList();
                if (lstSolAfilWeb != null && !lstSolAfilWeb.isEmpty()) {
                    for (SolicitudAfiliacionWeb operMonedaExtSolAfilWeb : lstSolAfilWeb) {
                        if (operMonedaExtSolAfilWeb.getICodigo().equals(id)) {
                            saw = operMonedaExtSolAfilWeb;
                            break;
                        }
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
        return saw;
    }

    public boolean updateEstado(Long estado, Long idSolAfilWeb) {
        connectionDBJPA connDBJPA = new connectionDBJPA();
        boolean bandera = false;

        try {
            this.em = connDBJPA.getEntityManager();
            if (estado != null && idSolAfilWeb != null) {
                this.em.getTransaction().begin();

                Query query = this.em.createNativeQuery(" UPDATE SOLICITUD_AFILIACION_WEB SET I_ESTADO_SOLICITUD = ? WHERE I_CODIGO = ? ");
                query.setParameter(1, estado);
                query.setParameter(2, idSolAfilWeb);
                query.executeUpdate();
                this.em.getTransaction().commit();

                bandera = true;

            }
        } catch (Exception e) {
            bandera = false;
            if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
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

    public List<SolicitudAfiliacionWeb> findSolAfilRPA() {

        connectionDBJPA connDBJPA = new connectionDBJPA();
        List<SolicitudAfiliacionWeb> saws = new ArrayList<>();
        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery("select sa.* from solicitud_afiliacion_web sa \n"
                    + "inner join tipo_estado_sol_Afil_web tipoE on tipoE.I_CODIGO = sa.I_ESTADO_SOLICITUD \n"
                    + "where tipoE.C_ABREVIATURA = 'RAD' or tipoE.C_ABREVIATURA = 'APR' or tipoE.C_ABREVIATURA = 'PRE' or tipoE.C_ABREVIATURA = 'APL'", SolicitudAfiliacionWeb.class);
            saws = query.getResultList();
            System.out.println("Size " + saws.size());

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
        return saws;
        //return findAll();
    }

}
