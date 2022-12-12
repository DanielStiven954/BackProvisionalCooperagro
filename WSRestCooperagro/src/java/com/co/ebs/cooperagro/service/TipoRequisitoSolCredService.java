/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoReqSolCred;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface TipoRequisitoSolCredService {

    TipoRequisitoSolCred saveTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    TipoRequisitoSolCred updateTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    TipoRequisitoSolCred findRequisitoSolCredById(Long id);

    void deletTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    List<TipoRequisitoSolCred> tipoRequisitoSolCredFindAll();
    
    ResponseTipoReqSolCred findTipoReqSolCredActivos();
}
