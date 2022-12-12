/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import java.util.List;

/**
 *
 * @author JONATHAN RUGE
 */
public interface DatoPersonalSolAfiWebDataAccess {

    SolicitudAfiliacionWeb validarSolAfi(int iTipoIdent, String ident);

    DatoPersonalSolAfilWeb crear(Long tipoIdent, String cIdentificacion, SolicitudAfiliacionWeb solAfiWeb);

    List<DatoPersonalSolAfilWeb> listaDatoPersonal();

    DatoPersonalSolAfilWeb updateDatoPersonalSolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb);

    DatoPersonalSolAfilWeb findDatoPersonalSolAfilWebById(Long Id);

    DatoPersonalSolAfilWeb findDatoPersonalBySolAfilWeb(Long idSolAfilWeb);
    
    DatoPersonalSolAfilWeb findDatoPersonalByCedula(String Cedula);
    
    boolean updateCursoCooperativo(String curso, Long idSolAfilWeb);
}
