/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface TipoRequisitoSolAfilWebService {

    TipoRequisitoSolAfilWeb saveTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb);

    TipoRequisitoSolAfilWeb updateTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb);

    TipoRequisitoSolAfilWeb findTipoRequisitoSolCredById(Long id);

    void deletTipoRequisitoSolAfilWeb(TipoRequisitoSolAfilWeb tipoRequisitoSolAfilWeb);

    List<TipoRequisitoSolAfilWeb> tipoRequisitoSolAfilFindAll();
}
