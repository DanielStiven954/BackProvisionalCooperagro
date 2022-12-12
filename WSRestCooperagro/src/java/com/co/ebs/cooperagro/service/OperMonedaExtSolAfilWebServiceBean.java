/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.OperMonedaExtSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class OperMonedaExtSolAfilWebServiceBean implements OperMonedaExtSolAfilWebService {

    private final OperMonedaExtSolAfilWebDataAccessImp operMonedaExtSolAfilWebDataAccessImp = new OperMonedaExtSolAfilWebDataAccessImp();

    @Override
    public OperMonedaExtSolAfilWeb saveOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        return this.operMonedaExtSolAfilWebDataAccessImp.saveOperMonedaExtSolAfilWeb(operMonedaExtSolAfilWeb);
    }

    @Override
    public OperMonedaExtSolAfilWeb updateOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        return this.operMonedaExtSolAfilWebDataAccessImp.updateOperMonedaExtSolAfilWeb(operMonedaExtSolAfilWeb);
    }

    @Override
    public OperMonedaExtSolAfilWeb findOperMonedaExtSolAfilWebById(Long id) {
        return this.operMonedaExtSolAfilWebDataAccessImp.findOperMonedaExtSolAfilWebById(id);
    }

    @Override
    public OperMonedaExtSolAfilWeb findOperMonedaExtBySolAfilWeb(Long idSolAfilWeb) {
        return this.operMonedaExtSolAfilWebDataAccessImp.findOperMonedaExtBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public void deleteOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        this.operMonedaExtSolAfilWebDataAccessImp.deleteOperMonedaExtSolAfilWeb(operMonedaExtSolAfilWeb);
    }

    @Override
    public List<OperMonedaExtSolAfilWeb> findAllOperMonedaExtSolAfilWeb() {
        return this.operMonedaExtSolAfilWebDataAccessImp.findAllOperMonedaExtSolAfilWeb();
    }

    @Override
    public respuestaGenerica saveOperMonedaExtBySolAfiWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        respuestaGenerica rtaGenSaveOperMonendaExtrajera = new respuestaGenerica();
        if (operMonedaExtSolAfilWeb != null) {
            if (operMonedaExtSolAfilWeb.getISolAfiliacionWeb() != null && operMonedaExtSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                
                OperMonedaExtSolAfilWeb buscarRegistro = this.findOperMonedaExtBySolAfilWeb(operMonedaExtSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                if (buscarRegistro!=null && buscarRegistro.getICodigo()!=null) {
                    operMonedaExtSolAfilWeb.setICodigo(buscarRegistro.getICodigo());
                    OperMonedaExtSolAfilWeb omesaw = this.updateOperMonedaExtSolAfilWeb(operMonedaExtSolAfilWeb);
                    if (omesaw != null && omesaw.getICodigo() != null) {
                        rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.TRUE);
                        rtaGenSaveOperMonendaExtrajera.setiCodigo(1);
                        rtaGenSaveOperMonendaExtrajera.setsMsj("Información actualizada correctamente. Puede continuar con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.FALSE);
                        rtaGenSaveOperMonendaExtrajera.setiCodigo(0);
                        rtaGenSaveOperMonendaExtrajera.setsMsj("Se ha presentando un inconveniente al actualizar la información de operaciones extranjeras, por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
                    }
                }
                else{
                    OperMonedaExtSolAfilWeb omesaw = this.saveOperMonedaExtSolAfilWeb(operMonedaExtSolAfilWeb);
                    if (omesaw != null && omesaw.getICodigo() != null) {
                        rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.TRUE);
                        rtaGenSaveOperMonendaExtrajera.setiCodigo(1);
                        rtaGenSaveOperMonendaExtrajera.setsMsj("Información registrada correctamente. Puede continuar con la solicitud de afiliación.");
                    } else {
                        rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.FALSE);
                        rtaGenSaveOperMonendaExtrajera.setiCodigo(0);
                        rtaGenSaveOperMonendaExtrajera.setsMsj("Se ha presentando un inconveniente al registrar la informaión de operaciones extranjeras, por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
                    }
                }
            } else {
                rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.FALSE);
                rtaGenSaveOperMonendaExtrajera.setiCodigo(0);
                rtaGenSaveOperMonendaExtrajera.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva intentarlo.");
            }
        } else {
            rtaGenSaveOperMonendaExtrajera.setbRta(Boolean.FALSE);
            rtaGenSaveOperMonendaExtrajera.setiCodigo(0);
            rtaGenSaveOperMonendaExtrajera.setsMsj("Por favor verifique los datos enviados. ");
        }
        return rtaGenSaveOperMonendaExtrajera;

    }

}
