/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoPerfil;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan Ruge
 */
public class TipoPerfilDataAccessImp extends WSRestGenericRepositoryJPA<TipoPerfil> implements TipoPerfilDataAccess{

    @Override
    public List<TipoPerfil> consTipoPerfil() {
        List<TipoPerfil> listTipoPerfil = new ArrayList<>();
        listTipoPerfil = findAll();
        return listTipoPerfil;
    }
  
    @Override
    public TipoPerfil findTipoPerfilById(int idTipPerfil) {
        TipoPerfil tipoPerfBuscado = new TipoPerfil();
        Long idTipoPerfil = new Long(String.valueOf(idTipPerfil));
        tipoPerfBuscado = find(idTipoPerfil);
        return tipoPerfBuscado;
    }

    @Override
    public TipoPerfil saveTipoPerfil(TipoPerfil tipoPerfil) {
        return create(tipoPerfil);
    }

    @Override
    public TipoPerfil updateTipoPerfil(TipoPerfil tipoPerfil) {
        return update(tipoPerfil);
    }

    @Override
    public void deleteTipoPerfil(TipoPerfil tipoPerfil) {
        delete(tipoPerfil);
    }

    
}
