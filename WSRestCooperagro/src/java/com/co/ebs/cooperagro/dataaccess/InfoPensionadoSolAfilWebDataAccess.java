/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface InfoPensionadoSolAfilWebDataAccess {

    InfoPensionadoSolAfilWeb saveInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    InfoPensionadoSolAfilWeb updateInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    InfoPensionadoSolAfilWeb findInfoPensionadoSolAfilWebById(Long id);

    InfoPensionadoSolAfilWeb findInfoPensionadoBySolAfilWeb(Long idSolAfilWeb);

    void deleteInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb);

    List<InfoPensionadoSolAfilWeb> findAllInfoPensionadoSolAfilWeb();
}
