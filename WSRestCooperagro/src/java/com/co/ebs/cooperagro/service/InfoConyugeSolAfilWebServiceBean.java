/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.InfoConyugeSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.InfoConyugeSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class InfoConyugeSolAfilWebServiceBean implements InfoConyugeSolAfilWebService {

    private final InfoConyugeSolAfilWebDataAccessImp infoConyugeSolAfilWebDataAccessImp = new InfoConyugeSolAfilWebDataAccessImp();

    @Override
    public InfoConyugeSolAfilWeb saveInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        return this.infoConyugeSolAfilWebDataAccessImp.saveInfoConyugeSolAfilWeb(infoConyugeSolAfilWeb);
    }

    @Override
    public InfoConyugeSolAfilWeb updateInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        return this.infoConyugeSolAfilWebDataAccessImp.updateInfoConyugeSolAfilWeb(infoConyugeSolAfilWeb);
    }

    @Override
    public InfoConyugeSolAfilWeb findInfoConyugeSolAfilWebById(Long id) {
        return this.infoConyugeSolAfilWebDataAccessImp.findInfoConyugeSolAfilWebById(id);
    }

    @Override
    public InfoConyugeSolAfilWeb findInfoConyugeBySolAfilWeb(Long idSolAfilWeb) {
        return this.infoConyugeSolAfilWebDataAccessImp.findInfoConyugeBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public void deleteInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        this.infoConyugeSolAfilWebDataAccessImp.deleteInfoConyugeSolAfilWeb(infoConyugeSolAfilWeb);
    }

    @Override
    public List<InfoConyugeSolAfilWeb> findAllInfoConyugeSolAfilWeb() {
        return this.infoConyugeSolAfilWebDataAccessImp.findAllInfoConyugeSolAfilWeb();
    }

    @Override
    public respuestaGenerica saveInfoConyugeBySolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        respuestaGenerica rtaGenSaveInfoConyuge = new respuestaGenerica();
        if (infoConyugeSolAfilWeb != null) {
            if (infoConyugeSolAfilWeb.getISolAfiliacionWeb() != null && infoConyugeSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                InfoConyugeSolAfilWeb infoBuscado = this.findInfoConyugeBySolAfilWeb(infoConyugeSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                if (infoBuscado != null) {
                    InfoConyugeSolAfilWeb icsaw = this.updateInfoConyugeSolAfilWeb(infoConyugeSolAfilWeb);
                    if (icsaw != null && icsaw.getICodigo() != null) {
                        rtaGenSaveInfoConyuge.setbRta(Boolean.TRUE);
                        rtaGenSaveInfoConyuge.setiCodigo(1);
                        rtaGenSaveInfoConyuge.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                    }
                    else {
                        rtaGenSaveInfoConyuge.setbRta(Boolean.FALSE);
                        rtaGenSaveInfoConyuge.setiCodigo(0);
                        rtaGenSaveInfoConyuge.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
                else {
                    InfoConyugeSolAfilWeb icsaw = this.saveInfoConyugeSolAfilWeb(infoConyugeSolAfilWeb);
                    if (icsaw != null && icsaw.getICodigo() != null) {
                        rtaGenSaveInfoConyuge.setbRta(Boolean.TRUE);
                        rtaGenSaveInfoConyuge.setiCodigo(1);
                        rtaGenSaveInfoConyuge.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de afiliación.");
                    }
                    else {
                        rtaGenSaveInfoConyuge.setbRta(Boolean.FALSE);
                        rtaGenSaveInfoConyuge.setiCodigo(0);
                        rtaGenSaveInfoConyuge.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
            }
            else {
                rtaGenSaveInfoConyuge.setbRta(Boolean.FALSE);
                rtaGenSaveInfoConyuge.setiCodigo(0);
                rtaGenSaveInfoConyuge.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        }
        else {
            rtaGenSaveInfoConyuge.setbRta(Boolean.FALSE);
            rtaGenSaveInfoConyuge.setiCodigo(0);
            rtaGenSaveInfoConyuge.setsMsj("Verifique la información enviada.");
        }
        return rtaGenSaveInfoConyuge;
    }

}
