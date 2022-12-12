/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoEstadoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public interface TipoEstadoPqrsfService {
    
    TipoEstadoPqrsf obtenerEstadoPqrsf(Long id);
    
    ResponseTipoEstadoPqrsf obtenerListaTipos();
}
