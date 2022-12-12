/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.EstadoCedula;

/**
 *
 * @author Brayan Moreno
 */
public interface EstadoCedulaDataAccess {
    
    EstadoCedula findEstadoCedulaByCodVigencia(Long idCodVigencia);
    
    EstadoCedula findEstadoCedulaByid(Long id);
    
}
