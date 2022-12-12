/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoDireccionSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan Ruge
 */
public class TipoDireccionAccessImp extends WSRestGenericRepositoryJPA<TipoDireccionSolAfilWeb> implements TipoDireccionAccess{

    @Override
    public List<TipoDireccionSolAfilWeb> consDireccion() {
        List<TipoDireccionSolAfilWeb> listTipoPerfil = new ArrayList<>();
        listTipoPerfil = findAll();
        return listTipoPerfil;
    }
  
    @Override
    public TipoDireccionSolAfilWeb findDireccionById(int idTipPerfil) {
        TipoDireccionSolAfilWeb tipoPerfBuscado = new TipoDireccionSolAfilWeb();
        Long idTipoPerfil = new Long(String.valueOf(idTipPerfil));
        tipoPerfBuscado = find(idTipoPerfil);
        return tipoPerfBuscado;
    }

    @Override
    public TipoDireccionSolAfilWeb saveDireccion(TipoDireccionSolAfilWeb tipoPerfil) {
        return create(tipoPerfil);
    }

    @Override
    public TipoDireccionSolAfilWeb updateDireccion(TipoDireccionSolAfilWeb tipoPerfil) {
        return update(tipoPerfil);
    }

    @Override
    public void deleteDireccion(TipoDireccionSolAfilWeb tipoPerfil) {
        delete(tipoPerfil);
    }

    
}
