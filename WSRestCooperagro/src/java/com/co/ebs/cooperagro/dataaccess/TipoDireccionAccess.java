/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoDireccionSolAfilWeb;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface TipoDireccionAccess {

    TipoDireccionSolAfilWeb saveDireccion(TipoDireccionSolAfilWeb tipoPerfil);

    TipoDireccionSolAfilWeb updateDireccion(TipoDireccionSolAfilWeb tipoPerfil);

    void deleteDireccion(TipoDireccionSolAfilWeb tipoPerfil);

    List<TipoDireccionSolAfilWeb> consDireccion();

    TipoDireccionSolAfilWeb findDireccionById(int TipoDireccionSolAfilWeb);
}
