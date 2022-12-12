/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface TipoRequisitoSolCredDataAccess {

    TipoRequisitoSolCred saveTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    TipoRequisitoSolCred updateTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    TipoRequisitoSolCred findRequisitoSolCredById(Long id);

    void deletTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred);

    List<TipoRequisitoSolCred> tipoRequisitoSolCredFindAll();
}
