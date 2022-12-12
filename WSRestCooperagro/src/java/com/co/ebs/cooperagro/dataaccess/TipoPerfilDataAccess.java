/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoPerfil;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface TipoPerfilDataAccess {

    TipoPerfil saveTipoPerfil(TipoPerfil tipoPerfil);

    TipoPerfil updateTipoPerfil(TipoPerfil tipoPerfil);

    void deleteTipoPerfil(TipoPerfil tipoPerfil);

    List<TipoPerfil> consTipoPerfil();

    TipoPerfil findTipoPerfilById(int idTipPerfil);
}
