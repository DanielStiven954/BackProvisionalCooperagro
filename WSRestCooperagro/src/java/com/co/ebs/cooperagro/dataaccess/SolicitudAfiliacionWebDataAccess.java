/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public interface SolicitudAfiliacionWebDataAccess {

    SolicitudAfiliacionWeb crear();

    SolicitudAfiliacionWeb updateSolicitudAfiliacionWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb);

    SolicitudAfiliacionWeb findSolicitudAfiliacionWebById(Long id);
}
