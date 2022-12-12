/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface ReferenciasSolAfilWebService {

    ReferenciasSolAfilWeb saveReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    ReferenciasSolAfilWeb updateReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    ReferenciasSolAfilWeb findReferenciasSolAfilWebById(Long id);

    ReferenciasSolAfilWeb findReferenciasBySolAfilWeb(Long idSolAfilWeb);

    void deleteReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    List<ReferenciasSolAfilWeb> findAllReferenciasSolAfilWeb();
    
    respuestaGenerica saveReferenciasBySolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);
}
