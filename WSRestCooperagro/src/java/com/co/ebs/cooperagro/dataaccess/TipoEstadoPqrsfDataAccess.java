/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public interface TipoEstadoPqrsfDataAccess {
        
    TipoEstadoPqrsf findByIdTipoEstadoPqrsf(Long id);
    
    List<TipoEstadoPqrsf> findAllTipoEstadoPqrsd();
}
