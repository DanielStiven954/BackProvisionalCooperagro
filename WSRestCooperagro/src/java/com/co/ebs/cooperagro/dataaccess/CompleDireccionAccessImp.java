/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.CompDireccionSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan Ruge
 */
public class CompleDireccionAccessImp extends WSRestGenericRepositoryJPA<CompDireccionSolAfilWeb> implements CompleDireccionAccess{

    @Override
    public List<CompDireccionSolAfilWeb> consCompleDireccion() {
        List<CompDireccionSolAfilWeb> listTipoPerfil = new ArrayList<>();
        listTipoPerfil = findAllOrderByCampo("ASC", "cDescripcion");
        return listTipoPerfil;
    }
  
    @Override
    public CompDireccionSolAfilWeb findCompleDireccionById(int CompDireccion) {
        CompDireccionSolAfilWeb tipoPerfBuscado = new CompDireccionSolAfilWeb();
        Long idTipoPerfil = new Long(String.valueOf(CompDireccion));
        tipoPerfBuscado = find(idTipoPerfil);
        return tipoPerfBuscado;
    }

    @Override
    public CompDireccionSolAfilWeb saveCompleDireccion(CompDireccionSolAfilWeb tipoPerfil) {
        return create(tipoPerfil);
    }

    @Override
    public CompDireccionSolAfilWeb updateCompleDireccion(CompDireccionSolAfilWeb tipoPerfil) {
        return update(tipoPerfil);
    }

    @Override
    public void deleteCompleDireccion(CompDireccionSolAfilWeb tipoPerfil) {
        delete(tipoPerfil);
    }

    
}
