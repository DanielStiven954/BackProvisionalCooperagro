/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.InfoPensionadoSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class InfoPensionadoSolAfilWebServiceBean implements InfoPensionadoSolAfilWebService {

    private final InfoPensionadoSolAfilWebDataAccessImp infoPensionadoSolAfilWebDataAccessImp = new InfoPensionadoSolAfilWebDataAccessImp();

    @Override
    public InfoPensionadoSolAfilWeb saveInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        return this.infoPensionadoSolAfilWebDataAccessImp.saveInfoPensionadoSolAfilWeb(infoPensionadoSolAfilWeb);
    }

    @Override
    public InfoPensionadoSolAfilWeb updateInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        return this.infoPensionadoSolAfilWebDataAccessImp.updateInfoPensionadoSolAfilWeb(infoPensionadoSolAfilWeb);
    }

    @Override
    public InfoPensionadoSolAfilWeb findInfoPensionadoSolAfilWebById(Long id) {
        return this.infoPensionadoSolAfilWebDataAccessImp.findInfoPensionadoSolAfilWebById(id);
    }

    @Override
    public InfoPensionadoSolAfilWeb findInfoPensionadoBySolAfilWeb(Long idSolAfilWeb) {
        return this.infoPensionadoSolAfilWebDataAccessImp.findInfoPensionadoBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public void deleteInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        this.infoPensionadoSolAfilWebDataAccessImp.deleteInfoPensionadoSolAfilWeb(infoPensionadoSolAfilWeb);
    }

    @Override
    public List<InfoPensionadoSolAfilWeb> findAllInfoPensionadoSolAfilWeb() {
        return this.infoPensionadoSolAfilWebDataAccessImp.findAllInfoPensionadoSolAfilWeb();
    }

    @Override
    public respuestaGenerica saveInfoPensionadoBySolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        respuestaGenerica rtaGenSaveInfoPensionado = new respuestaGenerica();
        if (infoPensionadoSolAfilWeb != null) {
            if (infoPensionadoSolAfilWeb.getISolAfiliacionWeb() != null && infoPensionadoSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                InfoPensionadoSolAfilWeb buscarRegistro = this.findInfoPensionadoBySolAfilWeb(infoPensionadoSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                if (buscarRegistro!=null) {
                    InfoPensionadoSolAfilWeb ipsaw = this.updateInfoPensionadoSolAfilWeb(infoPensionadoSolAfilWeb);
                    if (ipsaw != null && ipsaw.getICodigo() != null) {
                        rtaGenSaveInfoPensionado.setbRta(Boolean.TRUE);
                        rtaGenSaveInfoPensionado.setiCodigo(1);
                        rtaGenSaveInfoPensionado.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveInfoPensionado.setbRta(Boolean.FALSE);
                        rtaGenSaveInfoPensionado.setiCodigo(0);
                        rtaGenSaveInfoPensionado.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
                else{
                    InfoPensionadoSolAfilWeb ipsaw = this.saveInfoPensionadoSolAfilWeb(infoPensionadoSolAfilWeb);
                    if (ipsaw != null && ipsaw.getICodigo() != null) {
                        rtaGenSaveInfoPensionado.setbRta(Boolean.TRUE);
                        rtaGenSaveInfoPensionado.setiCodigo(1);
                        rtaGenSaveInfoPensionado.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveInfoPensionado.setbRta(Boolean.FALSE);
                        rtaGenSaveInfoPensionado.setiCodigo(0);
                        rtaGenSaveInfoPensionado.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
            } 
            else {
                rtaGenSaveInfoPensionado.setbRta(Boolean.FALSE);
                rtaGenSaveInfoPensionado.setiCodigo(0);
                rtaGenSaveInfoPensionado.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        } else {
            rtaGenSaveInfoPensionado.setbRta(Boolean.FALSE);
            rtaGenSaveInfoPensionado.setiCodigo(0);
            rtaGenSaveInfoPensionado.setsMsj("Verifique la información enviada.");
        }
        return rtaGenSaveInfoPensionado;
    }

}
