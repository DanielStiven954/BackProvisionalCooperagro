/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class TipoRequisitoSolCredDataAccessImp extends WSRestGenericRepositoryJPA<TipoRequisitoSolCred> implements TipoRequisitoSolCredDataAccess {

    @Override
    public TipoRequisitoSolCred saveTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        return create(tipoRequisitoSolCred);
    }

    @Override
    public TipoRequisitoSolCred updateTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        return update(tipoRequisitoSolCred);
    }

    @Override
    public TipoRequisitoSolCred findRequisitoSolCredById(Long id) {
        return find(id);
    }

    @Override
    public void deletTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        delete(tipoRequisitoSolCred);
    }

    @Override
    public List<TipoRequisitoSolCred> tipoRequisitoSolCredFindAll() {
        return findAll();
    }

}
