/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoCanal;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class TipoCanalDataAccessImp extends WSRestGenericRepositoryJPA<TipoCanal> implements TipoCanalDataAccess {

    @Override
    public TipoCanal saveTipoCanal(TipoCanal tipoCanal) {
        TipoCanal tc = create(tipoCanal);
        return tc;
    }

    @Override
    public TipoCanal updateTipoCanal(TipoCanal tipoCanal) {
        TipoCanal tc = update(tipoCanal);
        return tc;
    }

    @Override
    public TipoCanal findTipoCanalById(Long id) {
        TipoCanal tc = find(id);
        return tc;
    }

    @Override
    public List<TipoCanal> findAllTipoCanal() {
        List<TipoCanal> listTipoCanal = findAll();
        return listTipoCanal;
    }

    @Override
    public void deleteTipoCanal(TipoCanal tipoCanal) {
        delete(tipoCanal);
    }

}
