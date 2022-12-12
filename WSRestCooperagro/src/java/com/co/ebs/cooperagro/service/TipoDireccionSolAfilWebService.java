/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoDireccionSolAfilWeb;
import com.co.ebs.cooperagro.domain.CompDireccionSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoDireccion;
import java.util.List;

/**
 *
 * @author Camilo Sanchez
 */
public interface TipoDireccionSolAfilWebService {
   ResponseTipoDireccion listarTiposDirecciones();
    
}
