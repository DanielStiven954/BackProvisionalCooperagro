/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface InfoPensionadoSolAfilWebService {

    InfoPensionadoSolAfilWeb saveInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    InfoPensionadoSolAfilWeb updateInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    InfoPensionadoSolAfilWeb findInfoPensionadoSolAfilWebById(Long id);

    InfoPensionadoSolAfilWeb findInfoPensionadoBySolAfilWeb(Long idSolAfilWeb);

    void deleteInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    List<InfoPensionadoSolAfilWeb> findAllInfoPensionadoSolAfilWeb();

    respuestaGenerica saveInfoPensionadoBySolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);
}
