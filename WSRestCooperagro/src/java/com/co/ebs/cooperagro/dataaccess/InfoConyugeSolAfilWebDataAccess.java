/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.InfoConyugeSolAfilWeb;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface InfoConyugeSolAfilWebDataAccess {

    InfoConyugeSolAfilWeb saveInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb);

    InfoConyugeSolAfilWeb updateInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb);

    InfoConyugeSolAfilWeb findInfoConyugeSolAfilWebById(Long id);

    InfoConyugeSolAfilWeb findInfoConyugeBySolAfilWeb(Long idSolAfilWeb);

    void deleteInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb);

    List<InfoConyugeSolAfilWeb> findAllInfoConyugeSolAfilWeb();
}
