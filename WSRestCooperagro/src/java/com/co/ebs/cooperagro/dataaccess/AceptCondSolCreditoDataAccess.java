/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AceptCondSolCredito;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface AceptCondSolCreditoDataAccess {

    AceptCondSolCredito saveAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito);

    AceptCondSolCredito updateAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito);

    AceptCondSolCredito findAceptCondSolCreditoById(Long id);

    AceptCondSolCredito findAceptCondSolCreditoBySolCredId(Long idSolCred);
    
    List<AceptCondSolCredito> findAllAceptCondSolCredito();

    void deleteTipoCanal(AceptCondSolCredito aceptCondSolCredito);
    
    void inactivarTokensOld(Long idSolCred,Long idUserMod);
}
