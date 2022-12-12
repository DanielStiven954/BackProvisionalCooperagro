/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoRequisitoSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoRequisitoSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class TipoRequisitoSolAfilWebServiceBean implements TipoRequisitoSolAfilWebService {

    private TipoRequisitoSolAfilWebDataAccessImp requisitoSolAfilWebDataAccessImp = new TipoRequisitoSolAfilWebDataAccessImp();

    @Override
    public TipoRequisitoSolAfilWeb saveTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        return this.requisitoSolAfilWebDataAccessImp.saveTipoRequisitoSolAfilWeb(tipoRequisitoSolAfilWeb);
    }

    @Override
    public TipoRequisitoSolAfilWeb updateTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        return this.requisitoSolAfilWebDataAccessImp.updateTipoRequisitoSolAfilWeb(tipoRequisitoSolAfilWeb);
    }

    @Override
    public TipoRequisitoSolAfilWeb findTipoRequisitoSolCredById(Long id) {
        return this.requisitoSolAfilWebDataAccessImp.findTipoRequisitoSolCredById(id);
    }

    @Override
    public void deletTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb) {
        this.requisitoSolAfilWebDataAccessImp.deletTipoRequisitoSolAfilWeb(tipoRequisitoSolAfilWeb);
    }

    @Override
    public List<TipoRequisitoSolAfilWeb> tipoRequisitoSolAfilFindAll() {
        return this.requisitoSolAfilWebDataAccessImp.tipoRequisitoSolAfilFindAll();
    }

}
