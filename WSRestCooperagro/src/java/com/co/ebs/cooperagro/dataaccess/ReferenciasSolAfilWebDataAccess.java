/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface ReferenciasSolAfilWebDataAccess {

    ReferenciasSolAfilWeb saveReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    ReferenciasSolAfilWeb updateReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    ReferenciasSolAfilWeb findReferenciasSolAfilWebById(Long id);

    ReferenciasSolAfilWeb findReferenciasBySolAfilWeb(Long idSolAfilWeb);

    void deleteReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb);

    List<ReferenciasSolAfilWeb> findAllReferenciasSolAfilWeb();

}
