/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class TipoRequisitoSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<TipoRequisitoSolAfilWeb> implements TipoRequisitoSolAfilWebDataAccess {

    @Override
    public TipoRequisitoSolAfilWeb saveTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        return create(tipoRequisitoSolAfilWeb);
    }

    @Override
    public TipoRequisitoSolAfilWeb updateTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        return update(tipoRequisitoSolAfilWeb);
    }

    @Override
    public TipoRequisitoSolAfilWeb findTipoRequisitoSolCredById(Long id) {
        return find(id);
    }

    @Override
    public void deletTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        delete(tipoRequisitoSolAfilWeb);
    }

    @Override
    public List<TipoRequisitoSolAfilWeb> tipoRequisitoSolAfilFindAll() {
        return findAll();
    }

}
