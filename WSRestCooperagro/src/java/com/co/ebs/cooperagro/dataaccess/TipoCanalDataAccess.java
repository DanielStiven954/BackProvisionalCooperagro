/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoCanal;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface TipoCanalDataAccess {

    TipoCanal saveTipoCanal(TipoCanal tipoCanal);

    TipoCanal updateTipoCanal(TipoCanal tipoCanal);

    TipoCanal findTipoCanalById(Long id);

    List<TipoCanal> findAllTipoCanal();

    void deleteTipoCanal(TipoCanal tipoCanal);
}
