/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface OperMonedaExtSolAfilWebService {

    OperMonedaExtSolAfilWeb saveOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb);

    OperMonedaExtSolAfilWeb updateOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb);

    OperMonedaExtSolAfilWeb findOperMonedaExtSolAfilWebById(Long id);

    OperMonedaExtSolAfilWeb findOperMonedaExtBySolAfilWeb(Long idSolAfilWeb);

    void deleteOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb);

    List<OperMonedaExtSolAfilWeb> findAllOperMonedaExtSolAfilWeb();
    
    respuestaGenerica saveOperMonedaExtBySolAfiWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb);
}
