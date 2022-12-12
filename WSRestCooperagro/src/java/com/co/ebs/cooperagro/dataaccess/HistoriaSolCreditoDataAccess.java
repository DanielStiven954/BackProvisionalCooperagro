/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.*;

/**
 *
 * @author Jonathan
 */
public interface HistoriaSolCreditoDataAccess {

    HistoriaSolicitudCredito crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb);

    HistoriaSolicitudCredito saveHistoriaSolicitudCredito(HistoriaSolicitudCredito historiaSolicitudCredito);

    HistoriaSolicitudCredito findHistoriaSolCredById(Long id);

    HistoriaSolicitudCredito findHistoriaSolCredBySolCred(SolicitudCredito solicitudCredito);

    HistoriaSolicitudCredito update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb, String mensaje);

}
