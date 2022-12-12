/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;


import com.co.ebs.cooperagro.dataaccess.TipoCanalDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoCanal;

import java.util.List;

/**
 *
 * @author Braya
 */
public class TipoCanalServiceBean implements TipoCanalService {
    
    private final TipoCanalDataAccessImp tipoCanalDataAccessImp = new TipoCanalDataAccessImp();
    
    @Override
    public TipoCanal saveTipoCanal(TipoCanal tipoCanal) {
        return tipoCanalDataAccessImp.saveTipoCanal(tipoCanal);
    }
    
    @Override
    public TipoCanal updateTipoCanal(TipoCanal tipoCanal) {
        return tipoCanalDataAccessImp.updateTipoCanal(tipoCanal);
    }
    
    @Override
    public TipoCanal findTipoCanalById(Long id) {
        return tipoCanalDataAccessImp.findTipoCanalById(id);
    }
    
    @Override
    public List<TipoCanal> findAllTipoCanal() {
        return tipoCanalDataAccessImp.findAllTipoCanal();
    }
    
    @Override
    public void deleteTipoCanal(TipoCanal tipoCanal) {
        tipoCanalDataAccessImp.deleteTipoCanal(tipoCanal);
    }
}
