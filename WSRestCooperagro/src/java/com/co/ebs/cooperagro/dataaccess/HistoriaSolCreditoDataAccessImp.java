/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.HistoriaSolicitudCredito;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
public class HistoriaSolCreditoDataAccessImp extends WSRestGenericRepositoryJPA<HistoriaSolicitudCredito> implements HistoriaSolCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public HistoriaSolicitudCredito crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb) {
        HistoriaSolicitudCredito hisSolAfiWebTemporal = new HistoriaSolicitudCredito();
        hisSolAfiWebTemporal.setISolicitudCredito(solAfilWeb);
        hisSolAfiWebTemporal.setIEstadoSolicitud(tipoEstSolAfilWeb);
        hisSolAfiWebTemporal.setCObservacion("Se inicio el proceso de solicitud de crédito.");
        hisSolAfiWebTemporal.setFFechaHistoria(new Date());
        hisSolAfiWebTemporal.setIUsuarioCreador(solAfilWeb.getIUsuarioCreador());
        hisSolAfiWebTemporal.setFFechaCreacion(new Date());
        HistoriaSolicitudCredito hisSolAfiWeb = create(hisSolAfiWebTemporal);
        return hisSolAfiWeb;
    }

    @Override
    public HistoriaSolicitudCredito saveHistoriaSolicitudCredito(HistoriaSolicitudCredito historiaSolicitudCredito) {
        return create(historiaSolicitudCredito);
    }

    @Override
    public HistoriaSolicitudCredito findHistoriaSolCredById(Long id) {
        return find(id);
    }

    @Override
    public HistoriaSolicitudCredito findHistoriaSolCredBySolCred(SolicitudCredito solicitudCredito) {
        HistoriaSolicitudCredito histSolCred = new HistoriaSolicitudCredito();
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT   h.*\n"
                    + "    FROM historia_solicitud_credito h,\n"
                    + "         solicitud_credito sc,\n"
                    + "         tipo_estado_solicitud_credito tesc\n"
                    + "   WHERE h.i_solicitud_credito = sc.i_codigo\n"
                    + "     AND h.i_estado_solicitud = tesc.i_codigo\n"
                    + "     AND sc.i_estado_solicitud = tesc.i_codigo\n"
                    + "     AND h.i_estado_solicitud = sc.i_estado_solicitud\n"
                    + "     AND tesc.i_codigo = ? \n"
                    + "     AND sc.I_CODIGO = ? \n"
                    + "ORDER BY h.f_fecha_historia DESC", HistoriaSolicitudCredito.class);

            consultDocument.setParameter(1, solicitudCredito.getIEstadoSolicitud().getICodigo());
            consultDocument.setParameter(2, solicitudCredito.getICodigo());

            List<HistoriaSolicitudCredito> historiaSolCredList = consultDocument.getResultList();
            if (historiaSolCredList != null && !historiaSolCredList.isEmpty()) {
                for (HistoriaSolicitudCredito hsc : historiaSolCredList) {
                    if (hsc.getISolicitudCredito().equals(solicitudCredito)) {
                        histSolCred = hsc;
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
        return histSolCred;
    }

    @Override
    public HistoriaSolicitudCredito update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb, String mensaje) {
        HistoriaSolicitudCredito hisSolAfiWebTemporal = new HistoriaSolicitudCredito();
        hisSolAfiWebTemporal.setFFechaCreacion(new Date());
        hisSolAfiWebTemporal.setCObservacion(mensaje);
        hisSolAfiWebTemporal.setIEstadoSolicitud(tipoEstSolAfilWeb);
        hisSolAfiWebTemporal.setISolicitudCredito(solAfilWeb);
        HistoriaSolicitudCredito hisSolAfiWeb = update(hisSolAfiWebTemporal);
        return hisSolAfiWeb;
    }

}
