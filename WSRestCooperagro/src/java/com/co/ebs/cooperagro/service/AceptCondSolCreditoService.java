/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.AceptCondSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface AceptCondSolCreditoService {

    AceptCondSolCredito saveAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito);

    AceptCondSolCredito updateAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito);

    AceptCondSolCredito findAceptCondSolCreditoById(Long id);

    AceptCondSolCredito findAceptCondSolCreditoBySolCredId(Long idSolCred);

    List<AceptCondSolCredito> findAllAceptCondSolCredito();

    void deleteTipoCanal(AceptCondSolCredito aceptCondSolCredito);

    //
    respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador, String sTokenRandom);

    respuestaGenerica verificarTokenAceptCondSolCred(Long idSolCred, Long idUserMod, String sTokenRandom);

    void inactivarTokensOld(Long idSolCred, Long idUserMod);

    respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador);
}
