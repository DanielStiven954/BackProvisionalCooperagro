/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public interface HistoriaSolAfilWebService {
    HistoriaSolAfilWeb crear(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb);
    HistoriaSolAfilWeb update(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb);
    HistoriaSolAfilWeb crearDesdeCero(HistoriaSolAfilWeb historiaSolAfilWeb);
}
