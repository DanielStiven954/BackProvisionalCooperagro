/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoAutorizacionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public interface TipoAutorizacionSolAfilWebDataAccess {
    
    TipoAutorizacionSolAfilWeb saveTipoAutorizacionSolAfilWeb(TipoAutorizacionSolAfilWeb tipoAutorizacionSolAfilWeb);
    
    TipoAutorizacionSolAfilWeb updateTipoAutorizacionSolAfilWeb(TipoAutorizacionSolAfilWeb tipoAutorizacionSolAfilWeb);
    
    List<TipoAutorizacionSolAfilWeb> findAllTipoAutorizacionSolAfilWeb();
    
    TipoAutorizacionSolAfilWeb findByIdTipoAutoSolAfilWeb(Long id);
    
}
