/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public interface AutorizacionSolAfilWebDataAccess {

    AutorizacionSolAfilWeb saveAutorizacionSolAfilWeb(AutorizacionSolAfilWeb autorizacionSolAfilWeb);

    AutorizacionSolAfilWeb updateAutorizacionSolAfilWeb(AutorizacionSolAfilWeb autorizacionSolAfilWeb);

    List<AutorizacionSolAfilWeb> findAllAutorizacionSolAfilWeb();

    AutorizacionSolAfilWeb findByAutorizacionSolAfilWeb(Long id);
    
    AutorizacionSolAfilWeb findAutorizacionSolAfilWebByTipoAutorizacion(Long idSolAfil, Long idTipoAuto);
    
    List<AutorizacionSolAfilWeb> findAllAutizacionesByIdSolAfilWeb(Long idSolAfil);
}
