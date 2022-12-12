/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AuditoriaSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.AutorizacionSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.AuditoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestAutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan Moreno
 */
public class AutorizacionSolAfilWebServiceBean {

    private final sendEmailSMTP envioEmail = new sendEmailSMTP();
    private final crearEmailHTML emailHTML = new crearEmailHTML();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    public respuestaGenerica saveAutorizacionSolAfilWeb(RequestAutorizacionSolAfilWeb listAutorizaciones) {
        respuestaGenerica generica = new respuestaGenerica();
        AutorizacionSolAfilWebDataAccessImp accessImp = new AutorizacionSolAfilWebDataAccessImp();
        boolean actualizacion = false;
        if (!listAutorizaciones.getListAutorizaciones().isEmpty()) {

            for (AutorizacionSolAfilWeb autorizacion : listAutorizaciones.getListAutorizaciones()) {
                AuditoriaSolAfilWebDataAccessImp auditoriaSolAfilWebDataAccessImp = new AuditoriaSolAfilWebDataAccessImp();
                AutorizacionSolAfilWeb autoBuscada = accessImp.findAutorizacionSolAfilWebByTipoAutorizacion(autorizacion.getISolAfiliacionWeb().getICodigo(), autorizacion.getITipoAutorizacion().getICodigo());
                if (autoBuscada.getICodigo() != null) {
                    actualizacion = true;
                    autoBuscada.setCAutorizo(autorizacion.getCAutorizo());
                    AutorizacionSolAfilWeb autorizacionUpdate = accessImp.updateAutorizacionSolAfilWeb(autoBuscada);
                    if (autorizacionUpdate != null && autorizacionUpdate.getICodigo() != null) {

                        AuditoriaSolAfilWeb afilWeb = new AuditoriaSolAfilWeb();
                        afilWeb.setCIp(listAutorizaciones.getCIp());
                        afilWeb.setCNavegador(listAutorizaciones.getCNavegador());
                        afilWeb.setfFechaSistema(new Date());
                        afilWeb.setIAutorizacionSolAfilWeb(autoBuscada);
                        auditoriaSolAfilWebDataAccessImp.create(afilWeb);

                        generica.setbRta(Boolean.TRUE);
                        generica.setiCodigo(1);
                        generica.setsMsj("Información actualizada correctamente.");

                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad..");
                    }
                } else {
                    AutorizacionSolAfilWeb autorizacionSave = accessImp.saveAutorizacionSolAfilWeb(autorizacion);
                    if (autorizacionSave != null && autorizacionSave.getICodigo() != null) {
                        AuditoriaSolAfilWeb afilWeb = new AuditoriaSolAfilWeb();
                        afilWeb.setCIp(listAutorizaciones.getCIp());
                        afilWeb.setCNavegador(listAutorizaciones.getCNavegador());
                        afilWeb.setfFechaSistema(new Date());
                        afilWeb.setIAutorizacionSolAfilWeb(autorizacionSave);
                        auditoriaSolAfilWebDataAccessImp.create(afilWeb);
                        generica.setbRta(Boolean.TRUE);
                        generica.setiCodigo(1);
                        generica.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad...");
                    }
                }
            }

        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("Por favor verifique la información enviada.");
        }

        try {
            if (generica.getbRta()) {
                SolicitudAfiliacionWebServiceBean afiliacionWebServiceBean = new SolicitudAfiliacionWebServiceBean();
                afiliacionWebServiceBean.updateEstadoSolAfilWeb(Long.parseLong("6"), listAutorizaciones.getListAutorizaciones().get(0).getISolAfiliacionWeb().getICodigo());

                HistoriaSolAfilWeb historia = new HistoriaSolAfilWeb();
                historia.setFFechaRegistro(new Date());
                historia.setCObservacionRegistro("La solicitud de afiliación se encontraba en estado EN CURSO");
                historia.setFFechaCambioEst(new Date());
                historia.setIEstadoSolicitud(new TipoEstadoSolAfilWeb(Long.parseLong("6")));
                historia.setISolAfiliacionWeb(listAutorizaciones.getListAutorizaciones().get(0).getISolAfiliacionWeb());
                HistoriaSolAfilWebServiceBean historiaAfiliacionBean = new HistoriaSolAfilWebServiceBean();
                HistoriaSolAfilWeb crearHistoria = historiaAfiliacionBean.crearDesdeCero(historia);
                System.out.println("CrearHistoria " + crearHistoria);

                DatoPersonalSolAfilWebServiceBean afilWebServiceBean = new DatoPersonalSolAfilWebServiceBean();
                DatoPersonalSolAfilWeb datosPersona = afilWebServiceBean.findDatoPersonalBySolAfilWeb(listAutorizaciones.getListAutorizaciones().get(0).getISolAfiliacionWeb().getICodigo());
                if (datosPersona.getCEmail().contains("@")) {
                    SolicitudAfiliacionWeb saw = afiliacionWebServiceBean.findSolicitudAfiliacionWebById(listAutorizaciones.getListAutorizaciones().get(0).getISolAfiliacionWeb().getICodigo());
                    HashMap<String, String> hashMapData = new HashMap<>();
                    utilidad util = new utilidad();
                    hashMapData.put("fechaSolicitud", util.dateToStringFormatFechaHora(saw.getFFechaSolicitud()));
                    hashMapData.put("numRadic", saw.getCNumRadic() + "");
                    hashMapData.put("estado", saw.getIEstadoSolicitud().getCDescripcion());
                    hashMapData.put("tipo", actualizacion ? "actualizada" : "realizada");
                    String sEmalHTML = emailHTML.emailSolicitudAfiliacionWeb(hashMapData);
                    String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                    envioEmail.SendEmailHTML(datosPersona.getCEmail(), sEmailRemitente, sEmalHTML, actualizacion ? "ACTUALIZACIÓN DE SOLICITUD DE AFILIACIÓN COOPERAGRO E.C." : "SOLICITUD DE AFILIACIÓN COOPERAGRO E.C.");

                    if (!actualizacion) {
                        HashMap<String, String> hashMapDataAdmin = new HashMap<>();
                        String nombreUsuario = new UsuarioServiceBean().findUserByPersonaCodigo(Long.parseLong("1723"), "1").getIPersona().getCNombres();
                        hashMapDataAdmin.put("nombreUsuario", nombreUsuario);
                        String sEmalHTMLAdmin = emailHTML.emailSolicitudAfiliacionAdmin(hashMapDataAdmin);
                        String emailReceptor = this.parametroServiceBean.obtenerParametroPorNombre("EMAIL_NOT_SOL_AFIL");
                        envioEmail.SendEmailHTML(emailReceptor, sEmailRemitente, sEmalHTMLAdmin, "NUEVA SOLICITUD DE AFILIACIÓN COOPERAGRO");
                    }

                    generica.setbRta(Boolean.TRUE);
                    generica.setiCodigo(1);
                    generica.setsMsj("Información actualizada correctamente.");
                } else {
                    generica.setbRta(Boolean.TRUE);
                    generica.setiCodigo(1);
                    generica.setsMsj("Información actualizada correctamente. No cuenta con un correo registrado en COOPERAGRO.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad....");
        }

        return generica;
    }

    public List<AutorizacionSolAfilWeb> findAllAutizacionesByIdSolAfilWeb(Long idSolAfil) {
        return new AutorizacionSolAfilWebDataAccessImp().findAllAutizacionesByIdSolAfilWeb(idSolAfil);
    }

}
