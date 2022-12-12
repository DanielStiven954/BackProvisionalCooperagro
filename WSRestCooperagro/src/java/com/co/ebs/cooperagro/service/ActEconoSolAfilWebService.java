/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface ActEconoSolAfilWebService {

    ActEconomicaSolAfilWeb saveActEconoSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) throws Exception;

    ActEconomicaSolAfilWeb updateActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb);

    ActEconomicaSolAfilWeb findActEconomicaSolAfilWebById(Long id);

    ActEconomicaSolAfilWeb findActEconomicaBySolAfilWeb(Long idSolAfilWeb);

    void deleteActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb);

    List<ActEconomicaSolAfilWeb> findAllActEconomicaSolAfilWeb();

    respuestaGenerica saveActEconomicaActualBySolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb);
    
    boolean updateDeclaracionRenta(String declaracion, Long idSolAfilWeb);
}
