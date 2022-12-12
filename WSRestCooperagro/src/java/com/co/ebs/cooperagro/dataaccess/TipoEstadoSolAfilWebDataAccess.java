/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public interface TipoEstadoSolAfilWebDataAccess {

    TipoEstadoSolAfilWeb findByAbre(String abrevi);
}
