/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.ActEconomicaSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ActEconoSolAfilWebServiceBean implements ActEconoSolAfilWebService {

    private final ActEconomicaSolAfilWebDataAccessImp actEconomicaSolAfilWebDataAccessImp = new ActEconomicaSolAfilWebDataAccessImp();
    private final SolicitudAfiliacionWebServiceBean solicitudAfiliacionWebServiceBean = new SolicitudAfiliacionWebServiceBean();

    @Override
    public ActEconomicaSolAfilWeb saveActEconoSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) throws Exception {
        return this.actEconomicaSolAfilWebDataAccessImp.saveActEconoSolAfilWeb(actEconomicaSolAfilWeb);
    }

    @Override
    public ActEconomicaSolAfilWeb updateActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        return this.actEconomicaSolAfilWebDataAccessImp.updateActEconomicaSolAfilWeb(actEconomicaSolAfilWeb);
    }

    @Override
    public ActEconomicaSolAfilWeb findActEconomicaSolAfilWebById(Long id) {
        return this.actEconomicaSolAfilWebDataAccessImp.findActEconomicaSolAfilWebById(id);
    }

    @Override
    public ActEconomicaSolAfilWeb findActEconomicaBySolAfilWeb(Long idSolAfilWeb) {
        return this.actEconomicaSolAfilWebDataAccessImp.findActEconomicaBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public void deleteActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        this.actEconomicaSolAfilWebDataAccessImp.deleteActEconomicaSolAfilWeb(actEconomicaSolAfilWeb);
    }

    @Override
    public List<ActEconomicaSolAfilWeb> findAllActEconomicaSolAfilWeb() {
        return this.actEconomicaSolAfilWebDataAccessImp.findAllActEconomicaSolAfilWeb();
    }

    @Override
    public respuestaGenerica saveActEconomicaActualBySolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        respuestaGenerica rtaGenericaSaveActEcono = new respuestaGenerica();
        try {
            if (actEconomicaSolAfilWeb != null) {
                if (actEconomicaSolAfilWeb.getISolAfiliacionWeb() != null && actEconomicaSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                    SolicitudAfiliacionWeb solicitudAfiliacionWeb = solicitudAfiliacionWebServiceBean.findSolicitudAfiliacionWebById(actEconomicaSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                    if (solicitudAfiliacionWeb != null && solicitudAfiliacionWeb.getICodigo() != null) {
                        actEconomicaSolAfilWeb.setISolAfiliacionWeb(solicitudAfiliacionWeb);
                        ActEconomicaSolAfilWeb infoBuscada = this.findActEconomicaBySolAfilWeb(solicitudAfiliacionWeb.getICodigo());
                        if (infoBuscada.getICodigo() != null) {
                            actEconomicaSolAfilWeb.setICodigo(infoBuscada.getICodigo());
                            ActEconomicaSolAfilWeb actEconomicaSolAfilWeb1 = this.updateActEconomicaSolAfilWeb(actEconomicaSolAfilWeb);
                            if (actEconomicaSolAfilWeb1 != null && actEconomicaSolAfilWeb1.getICodigo() != null) {
                                rtaGenericaSaveActEcono.setbRta(Boolean.TRUE);
                                rtaGenericaSaveActEcono.setiCodigo(1);
                                rtaGenericaSaveActEcono.setsMsj("Se ha actualizado la información de la actividad economica actual. Puede continuar con la solicitud de afiliación.");
                            } else {
                                rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
                                rtaGenericaSaveActEcono.setiCodigo(0);
                                rtaGenericaSaveActEcono.setsMsj("No se ha podido actualizar la información de la actividad economica actual. Por favor revise la información ingresada.");
                            }
                        } else {
                            ActEconomicaSolAfilWeb actEconomicaSolAfilWeb1 = this.saveActEconoSolAfilWeb(actEconomicaSolAfilWeb);
                            if (actEconomicaSolAfilWeb1.getICodigo() != null) {
                                rtaGenericaSaveActEcono.setbRta(Boolean.TRUE);
                                rtaGenericaSaveActEcono.setiCodigo(1);
                                rtaGenericaSaveActEcono.setsMsj("Se ha guardado la información de la actividad economica actual. Puede continuar con la solicitud de afiliación.");
                            } else {
                                rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
                                rtaGenericaSaveActEcono.setiCodigo(0);
                                rtaGenericaSaveActEcono.setsMsj("No se ha podido guardar la información de la actividad economica actual. Por favor revise la información ingresada.");
                            }
                        }
                    } else {
                        rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
                        rtaGenericaSaveActEcono.setiCodigo(0);
                        rtaGenericaSaveActEcono.setsMsj("No se ha podido obtener la información de la solicitud de afiliación con N° de radicado " + actEconomicaSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                    }

                } else {
                    rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
                    rtaGenericaSaveActEcono.setiCodigo(0);
                    rtaGenericaSaveActEcono.setsMsj("No se ha enviado el N° de Radicado de la solicitud de afiliación. Por favor verifique, si el error persiste comuniquese con la entidad. 3");
                }
            } else {
                rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
                rtaGenericaSaveActEcono.setiCodigo(0);
                rtaGenericaSaveActEcono.setsMsj("Por favor verifique la información enviada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rtaGenericaSaveActEcono.setbRta(Boolean.FALSE);
            rtaGenericaSaveActEcono.setiCodigo(0);
            rtaGenericaSaveActEcono.setsMsj("No se ha podido guardar la información de la actividad economica actual. Por favor revise la información ingresada.");
        }

        return rtaGenericaSaveActEcono;
    }

    @Override
    public boolean updateDeclaracionRenta(String declaracion, Long idSolAfilWeb) {
        return this.actEconomicaSolAfilWebDataAccessImp.updateDeclaracionRenta(declaracion, idSolAfilWeb);
    }
}
