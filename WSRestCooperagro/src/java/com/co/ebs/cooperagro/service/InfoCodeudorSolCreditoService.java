/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.*;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseInfoCodeudor;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface InfoCodeudorSolCreditoService {

    respuestaGenerica saveInfoCodeudor(String xData);

    respuestaGenerica editInfoCodeudor(InfoCodeudor xData);

    respuestaGenerica updateInfoCodeudor(String xsData);

    void deleteInfoCodeudor(InfoCodeudor xData);

    InfoCodeudor findById(long xCodigo);

//    InfoCodeudor findInfoCodeudorByIdSolCredito(Long idSolCred);

    ResponseInfoCodeudor findInfoCodeudorByIdSolCred(Long idSolCred);

    List<InfoCodeudor> buscarTodos();
}
