package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.EstadoCedulaDataAccessImp;
import com.co.ebs.cooperagro.domain.EstadoCedula;

/**
 *
 * @author Brayan Moreno
 */
public class EstadoCedulaServiceBean implements EstadoCedulaService{

    @Override
    public EstadoCedula findEstadoCedulaById(Long id) {
        return new EstadoCedulaDataAccessImp().findEstadoCedulaByid(id);
    }

    @Override
    public EstadoCedula findEstadoCedulaByICodVigencia(Long idCodVigencia) {
        return new EstadoCedulaDataAccessImp().findEstadoCedulaByCodVigencia(idCodVigencia);
    }
    
    
}
