package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.EstadoCedula;

/**
 *
 * @author Brayan Moreno
 */
public interface EstadoCedulaService {
    
    EstadoCedula findEstadoCedulaById(Long id);
    
    EstadoCedula findEstadoCedulaByICodVigencia(Long idCodVigencia);
}
