/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.SolicitudCreditoDataAccessImp;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.domain.*;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
//import com.co.ebs.cooperagro.general.sendSMS;
import com.co.ebs.cooperagro.general.sendSMS;
import com.co.ebs.cooperagro.general.sendWSPHP;
//import com.co.ebs.cooperagro.general.sendWSPHP;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCambioEstadoSolCred;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseDocSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePHPGeneraDocsPDF;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePHPSendEmail;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseValidarSolCredPersona;
import com.co.ebs.cooperagro.respuestasGenericas.SolicitudCreditoRta;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class SolicitudCreditoServiceBean implements SolicitudCreditoService {

    private final SolicitudCreditoDataAccessImp solicitudData = new SolicitudCreditoDataAccessImp();
    private sendWSPHP wsphp = new sendWSPHP();
    private final utilidad util = new utilidad();
    private final sendSMS sendSMS = new sendSMS();
    private crearEmailHTML emailHTML = new crearEmailHTML();
    private sendEmailSMTP emailSMTP = new sendEmailSMTP();

    @Override
    public ResponseSolicitudCredito validarSolicitud(String xData) {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        try {
            String codUsuario = util.decodeBase64(xData);
            List<SolicitudCredito> solCredito = new SolicitudCreditoDataAccessImp().validarSolicitud(codUsuario, "1");
            if (solCredito != null) {
                respuesta.setFlag(false);
                respuesta.setsMsg("Ya existe una solicitud de cr??dito en curso");
                respuesta.setListaSolicitud(solCredito);
            } else {
                respuesta.setFlag(true);
                respuesta.setsMsg("Puede continuar con la creaci??n de la solicitud");
            }

        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setFlag(false);
            respuesta.setsMsg("Ocurrio un error");
        }
        return respuesta;
    }

    @Override
    public ResponseSolicitudCredito saveSolicitud(Long idSolCred, Long idTipoCanal, Long idTipoProducto, String xData) {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        try {
            String sDataDecode = util.decodeBase64(xData);
            if (sDataDecode != null && !sDataDecode.equals("")) {
                String partes[] = sDataDecode.split(";");
                String codPersona = partes[0];
                String codCredito = partes[1];
                String montoSolicitud = partes[2];
                String plazo = partes[3];
                String valorCuota = partes[4];
                String codPeriodo = partes[5];
                String codUsuarioCreador = partes[6];
                if (idSolCred != null) {
                    SolicitudCredito findSoLCredById = new SolicitudCreditoDataAccessImp().findSolicitudCreditoById(idSolCred);
                    if (findSoLCredById != null && findSoLCredById.getICodigo() != null) {
                        try {
                            if (findSoLCredById.getIEstadoSolicitud().getICodigo() == 1) {
                                Persona personaBus = new Persona(new Long(codPersona));
                                Usuario usuarioBus = new UsuarioServiceBean().findUsuarioById(Long.parseLong(codUsuarioCreador));
                                findSoLCredById.setIPersona(personaBus);
                                findSoLCredById.setICodCredito(Long.parseLong(codCredito));
                                findSoLCredById.setNMontoSolicitud(BigDecimal.valueOf(Long.parseLong(montoSolicitud)));
                                findSoLCredById.setPlazo(BigInteger.valueOf(Long.parseLong(plazo)));
                                findSoLCredById.setNValorCuota(BigDecimal.valueOf(Long.parseLong(valorCuota)));
                                findSoLCredById.setICodPeriodo(BigInteger.valueOf(Long.parseLong(codPeriodo)));
                                findSoLCredById.setFFechaModificacion(new Date());
                                findSoLCredById.setIUsuarioModificador(usuarioBus);
                                SolicitudCredito solicitudCreada = new SolicitudCreditoDataAccessImp().updateSolicitud(findSoLCredById);
                                if (solicitudCreada != null && solicitudCreada.getICodigo() != null) {
                                    this.updateSolicitud(solicitudCreada);
                                    new HistoriaSolCreditoServiceBean().crear(findSoLCredById.getIEstadoSolicitud(), solicitudCreada);
                                    respuesta.setFlag(true);
                                    respuesta.setsMsg("Se ha modificado la informaci??n de la solicitud de cr??dito correctamente, su Nro de radicado es " + solicitudCreada.getINumRadic());
                                    respuesta.setCodigoRadicado(solicitudCreada.getICodigo());
                                } else {
                                    respuesta.setFlag(false);
                                    respuesta.setsMsg("Se ha presentado un inconveniente al editar la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                                }
                            } else {
                                respuesta.setFlag(false);
                                respuesta.setsMsg("La solicitud de cr??dito debe estar en estado DILIGENCIANDO para poder modificar la informaci??n.");
                            }
                        } catch (Exception e) {
                            System.err.println("com.co.ebs.wlosomec.service.SolicitudCreditoServiceBean.saveSolicitud()=>" + e.getMessage());
                            respuesta.setFlag(false);
                            respuesta.setsMsg("Se ha presentado un inconveniente al editar la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                        }
                    } else {
                        respuesta.setFlag(false);
                        respuesta.setsMsg("Se ha presentado un inconveniente al obtener la informaci??n de la solicitud para la modificaci??n de datos, por favor intente de nuevo si el error persiste comuniquese con la entidad.");
                    }
                } else {
                    try {
                        TipoEstadoSolicitudCredito tipoEstadoSol = new TipoEstadoSolicitudCredito(new Long(1));
                        Persona personaBus = new Persona(new Long(codPersona));
                        Usuario usuarioBus = new Usuario(new Long(codUsuarioCreador));
                        String sNumRadic = util.dateToStringFormatFechaNumRadicSolCred();

                        SolicitudCredito solNueva = new SolicitudCredito();

                        solNueva.setIPersona(personaBus);
                        solNueva.setiTipoCanal(new TipoCanal(idTipoCanal));
                        solNueva.setiTipoProducto(new TipoProductoSolCredito(idTipoProducto));
                        solNueva.setICodCredito(Long.parseLong(codCredito));
                        solNueva.setIEstadoSolicitud(tipoEstadoSol);
                        solNueva.setFFechaSolicitud(new Date());
                        solNueva.setNMontoSolicitud(BigDecimal.valueOf(Long.parseLong(montoSolicitud)));
                        solNueva.setPlazo(BigInteger.valueOf(Long.parseLong(plazo)));
                        solNueva.setNValorCuota(BigDecimal.valueOf(Long.parseLong(valorCuota)));
                        solNueva.setICodPeriodo(BigInteger.valueOf(Long.parseLong(codPeriodo)));
                        solNueva.setFFechaCreacion(new Date());
                        solNueva.setIUsuarioCreador(usuarioBus);
                        SolicitudCredito solicitudCreada = new SolicitudCreditoDataAccessImp().saveSolicitud(solNueva);
                        if (solicitudCreada != null && solicitudCreada.getICodigo() != null) {
                            Long iNumRadic = null;
                            if (sNumRadic != null && !sNumRadic.equals("")) {
                                if (solicitudCreada.getICodigo() >= 1 && solicitudCreada.getICodigo() <= 9) {
                                    iNumRadic = new Long(sNumRadic + "0" + solicitudCreada.getICodigo().toString());
                                } else {
                                    iNumRadic = new Long(sNumRadic + solicitudCreada.getICodigo().toString());
                                }
                                solicitudCreada.setINumRadic(iNumRadic);
                                this.updateSolicitud(solicitudCreada);
                            }
                            new HistoriaSolCreditoServiceBean().crear(tipoEstadoSol, solNueva);
                            respuesta.setFlag(true);
                            respuesta.setsMsg("La solicitud de cr??dito ha sido creada satisfactoriamente, su Nro de radicado es " + solicitudCreada.getINumRadic());
                            respuesta.setCodigoRadicado(solicitudCreada.getICodigo());
                        } else {
                            respuesta.setFlag(false);
                            respuesta.setsMsg("Se ha presentado un inconveniente al crear la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                        }
                    } catch (Exception e) {
                        System.err.println("com.co.ebs.cooperagro.service.SolicitudCreditoServiceBean.saveSolicitud()=>" + e.getMessage());
                        respuesta.setFlag(false);
                        respuesta.setsMsg("Se ha presentado un inconveniente al crear la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                    }
                }
            } else {
                respuesta.setFlag(false);
                respuesta.setsMsg("Por favor verifique la informaci??n ingresada, recuerde que debe diligenciar todo el formulario.");
            }
        } catch (Exception e) {
            respuesta.setFlag(false);
            respuesta.setsMsg("Se ha presentado un inconveniente al crear la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public SolicitudCredito updateSolicitudCredito(SolicitudCredito solicitudCredito) {
        return new SolicitudCreditoDataAccessImp().updateSolicitud(solicitudCredito);
    }

    @Override
    public SolicitudCredito saveSolicitudCredito(SolicitudCredito solicitudCredito) {
        return new SolicitudCreditoDataAccessImp().saveSolicitud(solicitudCredito);
    }

    @Override
    public ResponseSolicitudCredito updateSolicitud(SolicitudCredito xData) {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        SolicitudCredito solciitudEditada = new SolicitudCreditoDataAccessImp().updateSolicitud(xData);
        if (solciitudEditada != null) {
            List<SolicitudCredito> lista = new ArrayList<>();
            lista.add(solciitudEditada);
            respuesta.setFlag(true);
            respuesta.setsMsg("Solicitud editada satisfactoriamente");
            respuesta.setListaSolicitud(lista);

        } else {
            respuesta.setFlag(false);
            respuesta.setsMsg("Ocurrio un error al editar la solicitud");
        }
        return respuesta;
    }

    @Override
    public ResponseCambioEstadoSolCred cambioEstadoSolicitudCredito(Long idSolicitudCredito, Long idUsuarioModificador, Long idTipoEstadoSolCred, String sObservacion) {
        ResponseCambioEstadoSolCred responseCambioEstadoSolCred = new ResponseCambioEstadoSolCred();
        if (idSolicitudCredito != null && idUsuarioModificador != null && idTipoEstadoSolCred != null && sObservacion != null && !sObservacion.equals("")) {
            String sObsSolCred = util.decodeBase64(sObservacion);
            TipoEstadoSolicitudCredito tipoEstSolCredOld;
            tipoEstSolCredOld = new TipoEstadoSolicitudCredito();
            TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(idTipoEstadoSolCred);
            if (tipoEstadoSolCred != null && tipoEstadoSolCred.getICodigo() != null) {
                Usuario findUserModificadorByCod = new UsuarioServiceBean().findUsuarioById(idUsuarioModificador);
                if (findUserModificadorByCod != null && findUserModificadorByCod.getICodigo() != null) {
                    SolicitudCredito solicitudCredito = this.findSolicitudCreditoById(idSolicitudCredito);
                    if (solicitudCredito != null && solicitudCredito.getICodigo() != null) {
                        if (solicitudCredito.getIEstadoSolicitud().getICodigo() != 1) {
                            if (solicitudCredito.getIEstadoSolicitud().getICodigo() != 4 && solicitudCredito.getIEstadoSolicitud().getICodigo() != 5) {
                                tipoEstSolCredOld = solicitudCredito.getIEstadoSolicitud();
                                solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
                                solicitudCredito.setFFechaModificacion(new Date());
                                solicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                SolicitudCredito updateSolicitudCredito = this.updateSolicitudCredito(solicitudCredito);
                                if (updateSolicitudCredito != null && (updateSolicitudCredito.getICodigo().equals(solicitudCredito.getICodigo()))) {
                                    HistoriaSolicitudCredito historiaSolicitudCredito = new HistoriaSolicitudCredito();
                                    historiaSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                    historiaSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                    historiaSolicitudCredito.setCObservacion(sObsSolCred);
                                    historiaSolicitudCredito.setFFechaHistoria(new Date());
                                    historiaSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
                                    historiaSolicitudCredito.setFFechaCreacion(new Date());
                                    HistoriaSolicitudCredito hsc = new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(historiaSolicitudCredito);
                                    if (hsc != null && hsc.getICodigo() != null) {
                                        try {
                                            String sICodigo = solicitudCredito.getIPersona().getICodigo().toString();
                                            String sTipoIdent = solicitudCredito.getIPersona().getITipoIdent().toString();
                                            String sIdent = solicitudCredito.getIPersona().getCIdentificacion();
                                            String sMailDestino = new CygnusCoreServiceBean().getEmailPersona(sICodigo, sTipoIdent, sIdent);
                                            String sNumCel = new CygnusCoreServiceBean().getTelPersona(sICodigo, sTipoIdent, sIdent);
                                            String sEmailHTML = "";
                                            ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
                                            responsePHPSendEmail.setFlag(Boolean.FALSE);
                                            responsePHPSendEmail.setMsg("");
                                            ResponsePHPGeneraDocsPDF responsePHPGeneraDocsPDF = new ResponsePHPGeneraDocsPDF();
                                            responsePHPGeneraDocsPDF.setFlag(Boolean.FALSE);
                                            responsePHPGeneraDocsPDF.setMsg("");
                                            Boolean bRtaSendSMS = Boolean.FALSE;
                                            HashMap<String, String> hashMapData = new HashMap<>();
                                            hashMapData.put("sNumRadicSolCred", solicitudCredito.getICodigo().toString());
                                            if (idTipoEstadoSolCred == 3) {
                                                String sCantDigKeyToken = new ParametroServiceBean().obtenerParametroPorNombre("CANT_KEY_SOL_CRED");
                                                int iCantDigKey = Integer.parseInt(sCantDigKeyToken);
                                                String sTokenRandom = util.passwordRandom(iCantDigKey);
                                                respuestaGenerica rtaGenerica = new AceptCondSolCreditoServiceBean().generarTokenAceptacionSolCred(idSolicitudCredito, idUsuarioModificador, sTokenRandom);
                                                if (rtaGenerica.getbRta()) {
                                                    String sDescPeriodicidad = new AdminCoreServiceBean().getDescPeriodo(solicitudCredito.getICodPeriodo().longValue());
                                                    HashMap<String, Object> hashMapDataRta = new SimuladorCreditoServiceBean().crearCreditoCygnus(solicitudCredito.getNMontoSolicitud().toString(), solicitudCredito.getPlazo().toString(), solicitudCredito.getICodCredito().toString(), sDescPeriodicidad, sIdent, solicitudCredito.getINumRadic().toString(), "C", solicitudCredito.getIEstadoSolicitud().getCDescripcion(), sObsSolCred);
                                                    if (hashMapDataRta != null && !hashMapDataRta.isEmpty()) {
                                                        Boolean bRtaCreaCred = (Boolean) hashMapDataRta.get("bRta");
                                                        if (bRtaCreaCred) {
//                                                            String sNumRadicCred = String.valueOf(hashMapDataRta.get("sNumRadicCred"));
//                                                            String sDocPagareCred = new SimuladorCreditoServiceBean().docPagareCreditoToJSON(sNumRadicCred);
//                                                            responsePHPGeneraDocsPDF = this.wsphp.creaDocumento(solicitudCredito.getICodigo(), sDocPagareCred, 1);
//                                                            if (responsePHPGeneraDocsPDF.getFlag()) {
//                                                                new DocSolicitudCreditoServiceBean().saveDocSolCredCambioEstadoBySolCred(util.encodeBase64(idUsuarioModificador.toString()), util.encodeBase64("Se crea el pagare del cr??dito"), util.encodeBase64(solicitudCredito.getICodigo().toString()), util.encodeBase64(responsePHPGeneraDocsPDF.getRutaArchivo()), util.encodeBase64(responsePHPGeneraDocsPDF.getNombreArchivo()));
//                                                            }
//                                                            String sRtaDocAutoDesem = new SimuladorCreditoServiceBean().docAutorizacionDesembolsoToJSON(sNumRadicCred, solicitudCredito.getICodigo());
//                                                            responsePHPGeneraDocsPDF = this.wsphp.creaDocumento(solicitudCredito.getICodigo(), sRtaDocAutoDesem, 2);
//                                                            if (responsePHPGeneraDocsPDF.getFlag()) {
//                                                                new DocSolicitudCreditoServiceBean().saveDocSolCredCambioEstadoBySolCred(util.encodeBase64(idUsuarioModificador.toString()), util.encodeBase64("Se crea carta de autorizaci??n de desembolso del cr??dito"), util.encodeBase64(solicitudCredito.getICodigo().toString()), util.encodeBase64(responsePHPGeneraDocsPDF.getRutaArchivo()), util.encodeBase64(responsePHPGeneraDocsPDF.getNombreArchivo()));
//                                                            }
//                                                            String sDocCartaIntruccion = new SimuladorCreditoServiceBean().docCartaInstruccionesToJSON(sNumRadicCred);
//                                                            responsePHPGeneraDocsPDF = this.wsphp.creaDocumento(solicitudCredito.getICodigo(), sDocCartaIntruccion, 3);
//                                                            if (responsePHPGeneraDocsPDF.getFlag()) {
//                                                                new DocSolicitudCreditoServiceBean().saveDocSolCredCambioEstadoBySolCred(util.encodeBase64(idUsuarioModificador.toString()), util.encodeBase64("Se crea la carta de instrucciones del pagar?? para el cr??dito."), util.encodeBase64(solicitudCredito.getICodigo().toString()), util.encodeBase64(responsePHPGeneraDocsPDF.getRutaArchivo()), util.encodeBase64(responsePHPGeneraDocsPDF.getNombreArchivo()));
//                                                            }
                                                            responsePHPSendEmail = wsphp.enviarEmail("3", sMailDestino, solicitudCredito.getINumRadic().toString(), sTokenRandom);
                                                            sEmailHTML = emailHTML.emailSolicitudCredAprobado(hashMapData);
                                                            bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COINVERSIONES, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " fue " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + ". El siguiente TOKEN: " + sTokenRandom + " debe ser ingresado para aceptar los terminos y condiciones, mediante la opcion Mis solicitudes.");
                                                        }
                                                    }
                                                }
                                            } else if (idTipoEstadoSolCred == 4) {
//                                      responsePHPSendEmail = wsphp.enviarEmail("4", sMailDestino, solicitudCredito.getINumRadic().toString(), "");
                                                sEmailHTML = emailHTML.emailSolicitudCredAplazado(hashMapData);
                                                bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPECHANCE, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasado al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                            } else if (idTipoEstadoSolCred == 5) {
//                                      responsePHPSendEmail = wsphp.enviarEmail("5", sMailDestino, solicitudCredito.getINumRadic().toString(), "");
                                                sEmailHTML = emailHTML.emailSolicitudCredNegado(hashMapData);
                                                bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPECHANCE, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasado al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                            } else if (idTipoEstadoSolCred == 7) {
//                                      responsePHPSendEmail = wsphp.enviarEmail("7", sMailDestino, solicitudCredito.getINumRadic().toString(), "");
                                                sEmailHTML = emailHTML.emailSolicitudCredEstudio(hashMapData);
                                                bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPECHANCE, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasado al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                            } else if (idTipoEstadoSolCred == 8) {
//                                      responsePHPSendEmail = wsphp.enviarEmail("5", sMailDestino, solicitudCredito.getINumRadic().toString(), "");
                                                sEmailHTML = emailHTML.emailSolicitudCredDesembolsado(hashMapData);
                                                bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPECHANCE, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasado al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                            }
                                            //SE ENVIA INFORMACI??N DEL CAMBIO DE ESTADO AL CLIENTE
//                                    Boolean bRtaSendMailHTML = emailSMTP.SendEmailHTML(sMailDestino, sEmailHTML, "NOTIFICACI??N SOLICITUD DE CR??DITO Nro " + solicitudCredito.getICodigo() + " SOMEC");
                                            HistoriaSolicitudCredito histSolCredEMAIL = new HistoriaSolicitudCredito();
                                            if (responsePHPSendEmail != null && responsePHPSendEmail.getFlag()) {
                                                histSolCredEMAIL.setISolicitudCredito(solicitudCredito);
                                                histSolCredEMAIL.setIEstadoSolicitud(tipoEstadoSolCred);
                                                histSolCredEMAIL.setCObservacion("Se ha enviado la notificaci??n al email " + sMailDestino + "SOMEC, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasa al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                                histSolCredEMAIL.setFFechaHistoria(new Date());
                                                histSolCredEMAIL.setIUsuarioCreador(findUserModificadorByCod);
                                                histSolCredEMAIL.setFFechaCreacion(new Date());
                                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredEMAIL);
                                            } else {
                                                histSolCredEMAIL.setISolicitudCredito(solicitudCredito);
                                                histSolCredEMAIL.setIEstadoSolicitud(tipoEstadoSolCred);
                                                histSolCredEMAIL.setCObservacion("No ha sido posible enviar la notificaci??n de cambio de estado de solicitud de cr??dito al correo " + sMailDestino);
                                                histSolCredEMAIL.setFFechaHistoria(new Date());
                                                histSolCredEMAIL.setIUsuarioCreador(findUserModificadorByCod);
                                                histSolCredEMAIL.setFFechaCreacion(new Date());
                                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredEMAIL);
                                            }

                                            HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
                                            if (bRtaSendSMS) {
                                                histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                                histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                                histSolCredSMS.setCObservacion("Se ha enviado SMS al n??mero celular " + sNumCel + "SOMEC, le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasa al estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                                histSolCredSMS.setFFechaHistoria(new Date());
                                                histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
                                                histSolCredSMS.setFFechaCreacion(new Date());
                                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                            } else {
                                                histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                                histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                                histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS de cambio de estado de solicitud de cr??dito al n??mero de celular " + sNumCel);
                                                histSolCredSMS.setFFechaHistoria(new Date());
                                                histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
                                                histSolCredSMS.setFFechaCreacion(new Date());
                                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                            }
                                            responseCambioEstadoSolCred.setbRta(Boolean.TRUE);
                                            responseCambioEstadoSolCred.setsMsj("La solicitud de cr??dito en estado " + tipoEstSolCredOld.getCDescripcion().toUpperCase() + " ha pasado al estado " + tipoEstadoSolCred.getCDescripcion());
                                            responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstadoSolCred.getICodigo());
                                            responseCambioEstadoSolCred.setsDescEstado(tipoEstadoSolCred.getCDescripcion());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                                            responseCambioEstadoSolCred.setsMsj("Se ha presentado un inconveniente al intentar procesar el cambio de estado de la solicitud de cr??dito. Por favor intente de nuevo.");
                                            responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstSolCredOld.getICodigo());
                                            responseCambioEstadoSolCred.setsDescEstado(tipoEstSolCredOld.getCDescripcion());
                                            solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
                                            solicitudCredito.setFFechaModificacion(new Date());
                                            solicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                            SolicitudCredito updateSolCredito = this.updateSolicitudCredito(solicitudCredito);
                                            if (updateSolCredito != null && updateSolCredito.getICodigo() != null && updateSolCredito.getIEstadoSolicitud().equals(tipoEstSolCredOld)) {
                                                HistoriaSolicitudCredito newHistSolicitudCredito = new HistoriaSolicitudCredito();
                                                newHistSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                                newHistSolicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                                newHistSolicitudCredito.setCObservacion("La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                                                newHistSolicitudCredito.setFFechaHistoria(new Date());
                                                newHistSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
                                                newHistSolicitudCredito.setFFechaCreacion(new Date());
                                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistSolicitudCredito);
                                            }
                                        }
                                    } else {
                                        solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
                                        solicitudCredito.setFFechaModificacion(new Date());
                                        solicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                        SolicitudCredito updateSolCredito = this.updateSolicitudCredito(solicitudCredito);
                                        if (updateSolCredito != null && updateSolCredito.getICodigo() != null && updateSolCredito.getIEstadoSolicitud().equals(tipoEstSolCredOld)) {
                                            HistoriaSolicitudCredito newHistSolicitudCredito = new HistoriaSolicitudCredito();
                                            newHistSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                            newHistSolicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                            newHistSolicitudCredito.setCObservacion("La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                                            newHistSolicitudCredito.setFFechaHistoria(new Date());
                                            newHistSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
                                            newHistSolicitudCredito.setFFechaCreacion(new Date());
                                            new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistSolicitudCredito);
                                            responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                                            responseCambioEstadoSolCred.setsMsj("Se ha presentado un inconveniente al intentar cambiar el estado de la solicitud de cr??dito. Por favor intente de nuevo.");
                                        }
                                    }
                                } else {
                                    responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                                    responseCambioEstadoSolCred.setsMsj("No se ha podido realizar el cambio a la solicitud de cr??dito al estado " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + ". Por favor intente de nuevo.");
                                    responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstSolCredOld.getICodigo());
                                    responseCambioEstadoSolCred.setsDescEstado(tipoEstSolCredOld.getCDescripcion());
                                }
                            } else {
                                responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                                responseCambioEstadoSolCred.setsMsj("No es posible cambiar el estado de la solicitud de cr??dito N?? " + solicitudCredito.getINumRadic() + ", por que su estado " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " significa una decisi??n final.");
                                responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstSolCredOld.getICodigo());
                                responseCambioEstadoSolCred.setsDescEstado(tipoEstSolCredOld.getCDescripcion());
                            }
                        } else {
                            responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                            responseCambioEstadoSolCred.setsMsj("Para procesar el cambio de estado de la solicitud de cr??dito N?? " + solicitudCredito.getINumRadic() + ", la solicitud debe estar RADICADA y no en " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                            responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstSolCredOld.getICodigo());
                            responseCambioEstadoSolCred.setsDescEstado(tipoEstSolCredOld.getCDescripcion());
                        }
                    } else {
                        responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                        responseCambioEstadoSolCred.setsMsj("No se ha podido obtener los datos de la solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic());
                        responseCambioEstadoSolCred.setiCodTipoEstadoSolCred(tipoEstSolCredOld.getICodigo());
                        responseCambioEstadoSolCred.setsDescEstado(tipoEstSolCredOld.getCDescripcion());
                    }
                } else {
                    responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                    responseCambioEstadoSolCred.setsMsj("No se ha podido obtener la informaci??n del usuario. Por favor intente de nuevo m??s tarde.");
                }
            } else {
                responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
                responseCambioEstadoSolCred.setsMsj("No se ha encontrado informaci??n para el tipo de estado seleccionado. Por favor intente de nuevo m??s tarde.");
            }

        } else {
            responseCambioEstadoSolCred.setbRta(Boolean.FALSE);
            responseCambioEstadoSolCred.setsMsj("Todos los valores son requerido para procesar la solicitud de cr??dito.");
        }
        return responseCambioEstadoSolCred;
    }

    @Override
    public ResponseSolicitudCredito findSolicitudByID(long xCodigo) {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        List<SolicitudCredito> solciitudBuscada = new SolicitudCreditoDataAccessImp().findSolicitudByID(xCodigo);
        try {
            if (solciitudBuscada != null) {
                respuesta.setFlag(true);
                respuesta.setsMsg("Solicitud encontrada satisfactoriamente");
                respuesta.setListaSolicitud(solciitudBuscada);

            } else {
                respuesta.setFlag(false);
                respuesta.setsMsg("No se ha encontrado una solicitud con el c??digo " + xCodigo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setFlag(false);
            respuesta.setsMsg("Ha ocurrido un error");
        }

        return respuesta;
    }

    @Override
    public SolicitudCredito findSolicitudCreditoById(long xCodigo) {
        return new SolicitudCreditoDataAccessImp().findSolicitudCreditoById(xCodigo);
    }

    @Override
    public ResponseSolicitudCredito findAllSolicitud() {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        List<SolicitudCredito> listaSol = new SolicitudCreditoDataAccessImp().findAllSolicitud();
        if (listaSol != null) {
            respuesta.setFlag(true);
            respuesta.setsMsg("Solicitudes encontradas satisfactoriamente");
            respuesta.setListaSolicitud(listaSol);

        } else {
            respuesta.setFlag(false);
            respuesta.setsMsg("No se ha encontrado ninguna solicitud de cr??dito.");
        }
        return respuesta;
    }

    @Override
    public ResponseSolicitudCredito cargarSolicitudes() {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        List<SolicitudCredito> listaSol = new SolicitudCreditoDataAccessImp().findAllSolicitudCreditoOrderByFechaSolCred();
        List<SolicitudCreditoRta> listaSolicitudCreditoRta;
        if (listaSol != null && !listaSol.isEmpty()) {
            respuesta.setFlag(true);
            respuesta.setsMsg("Solicitudes encontradas satisfactoriamente");
            listaSolicitudCreditoRta = new ArrayList<>();
            SolicitudCreditoRta solicitudCreditoRta = new SolicitudCreditoRta();
            for (SolicitudCredito solicitudCredito : listaSol) {
                Date dateFechaSolCred = solicitudCredito.getFFechaSolicitud();

                String sFechaSolCred = util.dateToStringFormatFechaHora(dateFechaSolCred);
                String sDescLineaCredito = new AdminCoreServiceBean().getNombreLineaCredito(solicitudCredito.getICodCredito());
                String sDescPeriodo = new AdminCoreServiceBean().getDescPeriodo(solicitudCredito.getICodPeriodo().longValue());
                String sNombreAsoc = solicitudCredito.getIPersona().getCNombres() + " " + solicitudCredito.getIPersona().getCApellidos();

                //SE AGREGAN LOS DATOS A LA CLASE QUE SE RETORNARA
                solicitudCreditoRta.setiCodigo(solicitudCredito.getICodigo());
                solicitudCreditoRta.setiNumRadic(solicitudCredito.getINumRadic());
                solicitudCreditoRta.setiCodCredito(solicitudCredito.getICodCredito());
                solicitudCreditoRta.setsDescLineaCredito(sDescLineaCredito);
                solicitudCreditoRta.setiCodigoPeriodicidad(solicitudCredito.getICodPeriodo().longValue());
                solicitudCreditoRta.setsDescPeriodo(sDescPeriodo);
                solicitudCreditoRta.setiCodPersona(solicitudCredito.getIPersona().getICodigo());
                solicitudCreditoRta.setsNombreAsociado(sNombreAsoc);
                solicitudCreditoRta.setiCodTipoEstadoSolCred(solicitudCredito.getIEstadoSolicitud().getICodigo());
                solicitudCreditoRta.setsDecTipoEstadoSolCred(solicitudCredito.getIEstadoSolicitud().getCDescripcion());
                solicitudCreditoRta.setBdMontoSolCredito(solicitudCredito.getNMontoSolicitud());
                solicitudCreditoRta.setsFechaSolCredito(sFechaSolCred);
                listaSolicitudCreditoRta.add(solicitudCreditoRta);
                solicitudCreditoRta = new SolicitudCreditoRta();
            }
            respuesta.setListaSolicitudCreditoRta(listaSolicitudCreditoRta);

        } else {
            respuesta.setFlag(false);
            respuesta.setsMsg("No se ha encontrado registros de solicitudes de cr??dito.");
        }
        return respuesta;
    }

    @Override
    public SolicitudCreditoRta obtenerDetalleSolCredById(Long idSolCred) {
        SolicitudCreditoRta detalleSolCredRta = new SolicitudCreditoRta();
        SolicitudCredito findSolCredById = new SolicitudCreditoDataAccessImp().findSolicitudCreditoById(idSolCred);
        if (findSolCredById != null && findSolCredById.getICodigo() != null) {
            Date dateFechaSolCred = findSolCredById.getFFechaSolicitud();
            String sCodPersona = String.valueOf(findSolCredById.getIPersona().getICodigo());
            String sTipoIdent = String.valueOf(findSolCredById.getIPersona().getITipoIdent());
            String sIdent = findSolCredById.getIPersona().getCIdentificacion();
            String sFechaSolCred = util.dateToStringFormatFechaHora(dateFechaSolCred);
            String sDescLineaCredito = new AdminCoreServiceBean().getNombreLineaCredito(findSolCredById.getICodCredito());
            String sDescPeriodo = new AdminCoreServiceBean().getDescPeriodo(findSolCredById.getICodPeriodo().longValue());
            String sNombreAsoc = new CygnusCoreServiceBean().getNombresCompletos(sCodPersona, sTipoIdent, sIdent);
            //SE AGREGAN LOS DATOS A LA CLASE QUE SE RETORNARA
            detalleSolCredRta.setiCodigo(findSolCredById.getICodigo());
            detalleSolCredRta.setiNumRadic(findSolCredById.getINumRadic());
            detalleSolCredRta.setiCodCredito(findSolCredById.getICodCredito());
            detalleSolCredRta.setsDescLineaCredito(sDescLineaCredito);
            detalleSolCredRta.setiCodigoPeriodicidad(findSolCredById.getICodPeriodo().longValue());
            detalleSolCredRta.setsDescPeriodo(sDescPeriodo);
            detalleSolCredRta.setiCodPersona(findSolCredById.getIPersona().getICodigo());
            detalleSolCredRta.setsNombreAsociado(sNombreAsoc);
            detalleSolCredRta.setiCodTipoEstadoSolCred(findSolCredById.getIEstadoSolicitud().getICodigo());
            detalleSolCredRta.setsDecTipoEstadoSolCred(findSolCredById.getIEstadoSolicitud().getCDescripcion());
            detalleSolCredRta.setBdMontoSolCredito(findSolCredById.getNMontoSolicitud());
            detalleSolCredRta.setBIPlazo(findSolCredById.getPlazo());
            detalleSolCredRta.setBdValorCuota(findSolCredById.getNValorCuota());
            detalleSolCredRta.setsFechaSolCredito(sFechaSolCred);
            List<DocumentoSolicitudCredito> docSolCredList = findSolCredById.getDocumentoSolicitudCreditoList();
            if (docSolCredList != null && !docSolCredList.isEmpty()) {
                List<ResponseDocSolCredito> responseDocSolCreditos = new ArrayList<>();
                ResponseDocSolCredito responseDocSolCredito = new ResponseDocSolCredito();
                for (DocumentoSolicitudCredito docSolicitudCredito : docSolCredList) {
                    responseDocSolCredito.setiCodigo(docSolicitudCredito.getICodigo());
                    responseDocSolCredito.setsNombreArchivo(docSolicitudCredito.getCNombreDocumento());
                    responseDocSolCredito.setsRutaFTP(docSolicitudCredito.getCRutaFtp());
                    responseDocSolCredito.setiCodTipoReqSolCred(docSolicitudCredito.getITipoRequisitoSolCred().getICodigo());
                    responseDocSolCredito.setsDescTipoReqSolCred(docSolicitudCredito.getITipoRequisitoSolCred().getCDescripcion());
                    responseDocSolCredito.setsNombreTipoReqSolCred(docSolicitudCredito.getITipoRequisitoSolCred().getCNombreRequisito());
                    responseDocSolCreditos.add(responseDocSolCredito);
                    responseDocSolCredito = new ResponseDocSolCredito();
                }
                detalleSolCredRta.setResponseDocSolCreditos(responseDocSolCreditos);
            }
        }
        return detalleSolCredRta;
    }

    @Override
    public SolicitudCreditoRta obtenerDetalleSolCredById(Long idSolCred, Long idCurrentUser) {
        SolicitudCreditoRta detalleSolCredRta = new SolicitudCreditoRta();
        SolicitudCredito findSolCredById = new SolicitudCreditoDataAccessImp().findSolicitudCreditoById(idSolCred);
        if (findSolCredById != null && findSolCredById.getICodigo() != null) {
            Date dateFechaSolCred = findSolCredById.getFFechaSolicitud();
            String sCodPersona = String.valueOf(findSolCredById.getIPersona().getICodigo());
            String sTipoIdent = String.valueOf(findSolCredById.getIPersona().getITipoIdent());
            String sIdent = findSolCredById.getIPersona().getCIdentificacion();
            String sFechaSolCred = util.dateToStringFormatFechaHora(dateFechaSolCred);
            String sDescLineaCredito = new AdminCoreServiceBean().getNombreLineaCredito(findSolCredById.getICodCredito());
            String sDescPeriodo = new AdminCoreServiceBean().getDescPeriodo(findSolCredById.getICodPeriodo().longValue());
            String sNombreAsoc = new CygnusCoreServiceBean().getNombresCompletos(sCodPersona, sTipoIdent, sIdent);
            //SE AGREGAN LOS DATOS A LA CLASE QUE SE RETORNARA
            detalleSolCredRta.setiCodigo(findSolCredById.getICodigo());
            detalleSolCredRta.setiNumRadic(findSolCredById.getINumRadic());
            detalleSolCredRta.setiCodCredito(findSolCredById.getICodCredito());
            detalleSolCredRta.setsDescLineaCredito(sDescLineaCredito);
            detalleSolCredRta.setiCodigoPeriodicidad(findSolCredById.getICodPeriodo().longValue());
            detalleSolCredRta.setsDescPeriodo(sDescPeriodo);
            detalleSolCredRta.setiCodPersona(findSolCredById.getIPersona().getICodigo());
            detalleSolCredRta.setsNombreAsociado(sNombreAsoc);
            detalleSolCredRta.setiCodTipoEstadoSolCred(findSolCredById.getIEstadoSolicitud().getICodigo());
            detalleSolCredRta.setsDecTipoEstadoSolCred(findSolCredById.getIEstadoSolicitud().getCDescripcion());
            detalleSolCredRta.setBdMontoSolCredito(findSolCredById.getNMontoSolicitud());
            detalleSolCredRta.setBIPlazo(findSolCredById.getPlazo());
            detalleSolCredRta.setBdValorCuota(findSolCredById.getNValorCuota());
            detalleSolCredRta.setsFechaSolCredito(sFechaSolCred);
            List<DocumentoSolicitudCredito> docSolCredList = findSolCredById.getDocumentoSolicitudCreditoList();
            if (docSolCredList != null && !docSolCredList.isEmpty()) {
                List<ResponseDocSolCredito> responseDocSolCreditos = new ArrayList<>();
                ResponseDocSolCredito responseDocSolCredito = new ResponseDocSolCredito();
                for (DocumentoSolicitudCredito docSolicitudCredito : docSolCredList) {
                    if (docSolicitudCredito.getITipoRequisitoSolCred() == null) {
                        responseDocSolCredito.setiCodigo(docSolicitudCredito.getICodigo());
                        responseDocSolCredito.setsNombreArchivo(docSolicitudCredito.getCNombreDocumento());
                        responseDocSolCredito.setsRutaFTP(docSolicitudCredito.getCRutaFtp());
                        responseDocSolCreditos.add(responseDocSolCredito);
                        responseDocSolCredito = new ResponseDocSolCredito();
                    }
                }
                detalleSolCredRta.setResponseDocSolCreditos(responseDocSolCreditos);
            }
        }
        return detalleSolCredRta;
    }

    @Override
    public ResponseSolicitudCredito cargarSolCreditoByPersona(Long idPersona
    ) {
        ResponseSolicitudCredito respuesta = new ResponseSolicitudCredito();
        List<SolicitudCredito> listaSol = new SolicitudCreditoDataAccessImp().findSolCreditoByPersona(idPersona);
        List<SolicitudCreditoRta> listaSolicitudCreditoRta;
        if (listaSol != null && !listaSol.isEmpty()) {
            respuesta.setFlag(true);
            respuesta.setsMsg("Solicitudes encontradas satisfactoriamente");
            listaSolicitudCreditoRta = new ArrayList<>();
            SolicitudCreditoRta solicitudCreditoRta = new SolicitudCreditoRta();
            for (SolicitudCredito solicitudCredito : listaSol) {
                String sDescLineaCredito = new AdminCoreServiceBean().getNombreLineaCredito(solicitudCredito.getICodCredito());
                //SE AGREGAN LOS DATOS A LA CLASE QUE SE RETORNARA
                solicitudCreditoRta.setiCodigo(solicitudCredito.getICodigo());
                solicitudCreditoRta.setiNumRadic(solicitudCredito.getINumRadic());
                solicitudCreditoRta.setiCodCredito(solicitudCredito.getICodCredito());
                solicitudCreditoRta.setsDescLineaCredito(sDescLineaCredito);
                solicitudCreditoRta.setiCodTipoEstadoSolCred(solicitudCredito.getIEstadoSolicitud().getICodigo());
                solicitudCreditoRta.setsDecTipoEstadoSolCred(solicitudCredito.getIEstadoSolicitud().getCDescripcion());
                solicitudCreditoRta.setBdMontoSolCredito(solicitudCredito.getNMontoSolicitud());
                listaSolicitudCreditoRta.add(solicitudCreditoRta);
                solicitudCreditoRta = new SolicitudCreditoRta();
            }
            respuesta.setListaSolicitudCreditoRta(listaSolicitudCreditoRta);

        } else {
            respuesta.setFlag(false);
            respuesta.setsMsg("No se ha encontrado ninguna solicitud de cr??dito.");
        }
        return respuesta;
    }

    @Override
    public respuestaGenerica radicarSolicitudCredito(Long idSolicitudCredito, Long idUsuarioModificador) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        if (idSolicitudCredito != null) {
            SolicitudCredito solicitudCredito = this.findSolicitudCreditoById(idSolicitudCredito);
            if (solicitudCredito != null && solicitudCredito.getICodigo() != null) {
                TipoEstadoSolicitudCredito tipoEstSolCredOld = solicitudCredito.getIEstadoSolicitud();
                Usuario findUserModificadorByCod = new UsuarioServiceBean().findUsuarioById(idUsuarioModificador);
                TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(2);
                if (findUserModificadorByCod != null && findUserModificadorByCod.getICodigo() != null) {
                    if (tipoEstadoSolCred != null && tipoEstadoSolCred.getICodigo() != null) {
                        solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
                        solicitudCredito.setFFechaModificacion(new Date());
                        solicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                        SolicitudCredito updateSolicitudCredito = this.updateSolicitudCredito(solicitudCredito);
                        if (updateSolicitudCredito != null && (updateSolicitudCredito.getICodigo().equals(solicitudCredito.getICodigo()))) {
                            HistoriaSolicitudCredito historiaSolicitudCredito = new HistoriaSolicitudCredito();
                            historiaSolicitudCredito.setISolicitudCredito(solicitudCredito);
                            historiaSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                            historiaSolicitudCredito.setCObservacion("La solicitud de cr??dito ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
                            historiaSolicitudCredito.setFFechaHistoria(new Date());
                            historiaSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
                            historiaSolicitudCredito.setFFechaCreacion(new Date());
                            HistoriaSolicitudCredito hsc = new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(historiaSolicitudCredito);
                            if (hsc != null && hsc.getICodigo() != null) {
                                try {
                                    String sICodigo = solicitudCredito.getIPersona().getICodigo().toString();
                                    String sTipoIdent = solicitudCredito.getIPersona().getITipoIdent().toString();
                                    String sIdent = solicitudCredito.getIPersona().getCIdentificacion();
                                    String sMailDestino = new CygnusCoreServiceBean().getEmailPersona(sICodigo, sTipoIdent, sIdent);
                                    String sNumCel = new CygnusCoreServiceBean().getTelPersona(sICodigo, sTipoIdent, sIdent);
                                    String sNombresPersona = new CygnusCoreServiceBean().getNombresCompletos(sICodigo, sTipoIdent, sIdent);

                                    HashMap<String, String> hashMapData = new HashMap<>();
                                    hashMapData.put("sNumRadicSolCred", updateSolicitudCredito.getINumRadic().toString());
                                    hashMapData.put("sLineaCredito", new AdminCoreServiceBean().getNombreLineaCredito(solicitudCredito.getICodCredito()));
                                    hashMapData.put("sMontoCredito", solicitudCredito.getNMontoSolicitud().toString());
                                    hashMapData.put("sDescPeriodicidad", new AdminCoreServiceBean().getDescPeriodo(solicitudCredito.getICodPeriodo().longValue()));
                                    hashMapData.put("sPlazo", solicitudCredito.getPlazo().toString());
                                    hashMapData.put("sValorCuota", solicitudCredito.getNValorCuota().toString());
                                    hashMapData.put("sNombreDeudor", sNombresPersona);
                                    hashMapData.put("sMailDestino", sMailDestino);
                                    String sEmailHTML = emailHTML.emailSolicitudCredRadicado(hashMapData);
//                                    Boolean bRtaSendMailHTML = emailSMTP.SendEmailHTML(sMailDestino, sEmailHTML, "SOMEC -- RADICACI??N SOLICITUD DE CR??DITO N?? " + updateSolicitudCredito.getINumRadic());
//                                    ResponsePHPSendEmail responsePHPSendEmail = wsphp.enviarEmailRadicado(hashMapData);
//                                    HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
//                                    if (responsePHPSendEmail != null && responsePHPSendEmail.getFlag()) {
//                                        histSolicitudCredito.setISolicitudCredito(solicitudCredito);
//                                        histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolicitudCredito.setCObservacion("Se ha enviado la notificaci??n al correo " + sMailDestino + " La solicitud de cr??dito ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
//                                        histSolicitudCredito.setFFechaHistoria(new Date());
//                                        histSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolicitudCredito.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
//                                    } else {
//                                        histSolicitudCredito.setISolicitudCredito(solicitudCredito);
//                                        histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolicitudCredito.setCObservacion("Se ha presentado un inconveniente al enviar notificaci??n al correo " + sMailDestino);
//                                        histSolicitudCredito.setFFechaHistoria(new Date());
//                                        histSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolicitudCredito.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
//                                    }
                                    Boolean bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPERAGRO le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
                                    HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
                                    if (bRtaSendSMS) {
                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                        histSolCredSMS.setCObservacion("Se ha enviado la notificaci??n SMS al n??mero de celular " + sNumCel + ". SOMEC le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
                                        histSolCredSMS.setFFechaHistoria(new Date());
                                        histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
                                        histSolCredSMS.setFFechaCreacion(new Date());
                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                    } else {
                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                        histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS al n??mero de celular " + sNumCel);
                                        histSolCredSMS.setFFechaHistoria(new Date());
                                        histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
                                        histSolCredSMS.setFFechaCreacion(new Date());
                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                rtaGenerica.setbRta(Boolean.TRUE);
                                rtaGenerica.setiCodigo(1);
                                rtaGenerica.setsMsj("Se ha enviado un correo electronico al email registrado en la entidad con la informaci??n de la solicitud de cr??dito Nro " + +solicitudCredito.getINumRadic() + " la c??al se encuentra en estado " + tipoEstadoSolCred.getCDescripcion().toUpperCase());
                            } else {
                                TipoEstadoSolicitudCredito tipoEstadoSol = new TipoEstadoSolCreditoServiceBean().findByID(1);
                                solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
                                solicitudCredito.setFFechaModificacion(new Date());
                                solicitudCredito.setIEstadoSolicitud(tipoEstadoSol);
                                SolicitudCredito updateSolCredito = this.updateSolicitudCredito(solicitudCredito);
                                if (updateSolCredito != null && updateSolCredito.getICodigo() != null && updateSolCredito.getIEstadoSolicitud().equals(tipoEstSolCredOld)) {
                                    HistoriaSolicitudCredito newHistSolicitudCredito = new HistoriaSolicitudCredito();
                                    newHistSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                    newHistSolicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                    newHistSolicitudCredito.setCObservacion("La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                                    newHistSolicitudCredito.setFFechaHistoria(new Date());
                                    newHistSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
                                    newHistSolicitudCredito.setFFechaCreacion(new Date());
                                    new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistSolicitudCredito);
                                    rtaGenerica.setbRta(Boolean.FALSE);
                                    rtaGenerica.setiCodigo(0);
                                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al intentar cambiar el estado de la solicitud de cr??dito.\n\n" + "La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                                }
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("No se ha podido radicar la solicitud de cr??dito. Por favor intente de nuevo.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("No se encontrado la informaci??n para el tipo de estado del cr??dito.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("No se encontrado la informaci??n del usuario.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("No se encontrado la informaci??n de la solictud de cr??dito.");
            }
        } else {
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("El Nro de solicitud de cr??dito es requerido para realizar la radicaci??n.");
        }
        return rtaGenerica;
    }

    @Override
    public respuestaGenerica radicarSolicitudCreditoAPP(SolicitudCredito solicitudCredito, Long iCodUser) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        if (solicitudCredito.getIPersona() != null && solicitudCredito.getIPersona().getICodigo() != null) {
            SolicitudCreditoDataAccessImp solicitudDataAccessImp = new SolicitudCreditoDataAccessImp();
            SolicitudCredito solicitudCreditoVerificacion = new SolicitudCredito();
            solicitudCreditoVerificacion = solicitudDataAccessImp.verificarSolCredByPersonaAndLineaCredDiligenRadic(solicitudCredito.getIPersona().getICodigo(), solicitudCredito.getICodCredito());
            if (solicitudCreditoVerificacion != null && solicitudCreditoVerificacion.getICodigo() != null) {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("La solicitud de credito ya cuenta con un estado de solicitud.");
            } else {
                TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(2);
                if (tipoEstadoSolCred != null && tipoEstadoSolCred.getICodigo() != null) {

                    solicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                    solicitudCredito.setFFechaSolicitud(new Date());
                    solicitudCredito.setIPersona(solicitudCredito.getIPersona());
                    solicitudCredito.setICodPeriodo(solicitudCredito.getICodPeriodo());

                    solicitudCredito.setiTipoCanal(solicitudCredito.getiTipoCanal());
                    solicitudCredito.setiTipoProducto(solicitudCredito.getiTipoProducto());
                    solicitudCredito.setPlazo(solicitudCredito.getPlazo());
                    solicitudCredito.setNValorCuota(solicitudCredito.getNValorCuota());
                    solicitudCredito.setCAuthCentralesRiesgo(solicitudCredito.getCAuthCentralesRiesgo());
                    solicitudCredito.setCAuthDatosPersonales(solicitudCredito.getCAuthDatosPersonales());
                    solicitudCredito.setCDeclaracionOrigenFondos(solicitudCredito.getCDeclaracionOrigenFondos());
                    solicitudCredito.setCRequiereCodeudor(solicitudCredito.getCRequiereCodeudor());
                    solicitudCredito.setNMontoSolicitud(solicitudCredito.getNMontoSolicitud());
                    solicitudCredito.setFFechaCreacion(new Date());
                    solicitudCredito.setFFechaModificacion(new Date());
                    Usuario uCreador = new UsuarioServiceBean().findUsuarioById(iCodUser);
                    solicitudCredito.setIUsuarioCreador(uCreador);
                    //solicitudCredito.setIUsuarioModificador(solicitudCredito.getIUsuarioModificador());
                    SolicitudCredito saveSolicitudCredito = this.saveSolicitudCredito(solicitudCredito);
                    if ((saveSolicitudCredito.getICodigo().equals(solicitudCredito.getICodigo()))) {
                        HistoriaSolicitudCredito historiaSolicitudCredito = new HistoriaSolicitudCredito();
                        Usuario findUserModificador = new UsuarioServiceBean().findUsuarioById(iCodUser);

//                        utilidad util = new utilidad();
//                        String numRadic = util.dateToStringFormatFechaNumRadicSolCred();
//
//                        if (saveSolicitudCredito.getICodigo().intValue() >= 1 && saveSolicitudCredito.getICodigo().intValue() <= 9) {
//                            numRadic += "0" + saveSolicitudCredito.getICodigo().toString();
//                        } else {
//                            numRadic += saveSolicitudCredito.getICodigo().toString();
//                        }
//
//                        solicitudCredito.setINumRadic(Long.parseLong(numRadic));
                        historiaSolicitudCredito.setISolicitudCredito(solicitudCredito);
                        historiaSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                        historiaSolicitudCredito.setCObservacion("La solicitud de cr??dito ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
                        historiaSolicitudCredito.setFFechaHistoria(new Date());
                        historiaSolicitudCredito.setFFechaCreacion(new Date());
                        historiaSolicitudCredito.setIUsuarioCreador(findUserModificador);

                        historiaSolicitudCredito.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                        HistoriaSolicitudCredito hsc = new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(historiaSolicitudCredito);
                        if (hsc.getICodigo() != null) {
                            try {
                                String sICodigo = solicitudCredito.getIPersona().getICodigo().toString();
                                String sTipoIdent = solicitudCredito.getIPersona().getITipoIdent().toString();
                                String sIdent = solicitudCredito.getIPersona().getCIdentificacion();
                                String sMailDestino = new CygnusCoreServiceBean().getEmailPersona(sICodigo, sTipoIdent, sIdent);
                                String sNumCel = new CygnusCoreServiceBean().getTelPersona(sICodigo, sTipoIdent, sIdent);
                                String sNombresPersona = new CygnusCoreServiceBean().getNombresCompletos(sICodigo, sTipoIdent, sIdent);
                                String sNumRadic = util.dateToStringFormatFechaNumRadicSolCred();

                                SolicitudCredito solicitudCreada = new SolicitudCreditoDataAccessImp().saveSolicitud(solicitudCredito);
                                if (solicitudCreada != null && solicitudCreada.getICodigo() != null) {
                                    Long iNumRadic = null;
                                    if (sNumRadic != null && !sNumRadic.equals("")) {
                                        if (solicitudCreada.getICodigo() >= 1 && solicitudCreada.getICodigo() <= 9) {
                                            iNumRadic = new Long(sNumRadic + "0" + solicitudCreada.getICodigo().toString());
                                        } else {
                                            iNumRadic = new Long(sNumRadic + solicitudCreada.getICodigo().toString());
                                        }
                                        solicitudCreada.setINumRadic(iNumRadic);
                                        this.updateSolicitud(solicitudCreada);
                                        rtaGenerica.setbRta(Boolean.TRUE);
                                        rtaGenerica.setiCodigo(1);
                                        rtaGenerica.setsMsj("Se ha enviado un correo electronico al email registrado en la entidad con la informaci??n de la solicitud de cr??dito Nro " + solicitudCredito.getINumRadic() + " la c??al se encuentra en estado " + tipoEstadoSolCred.getCDescripcion().toUpperCase());
                                    }
                                    new HistoriaSolCreditoServiceBean().crear(tipoEstadoSolCred, solicitudCredito);
//                                    rtaGenerica.setbRta(Boolean.TRUE);
//                                    rtaGenerica.setsMsj("La solicitud de cr??dito ha sido creada satisfactoriamente, su Nro de radicado es " + solicitudCreada.getINumRadic());

                                    HashMap<String, String> hashMapData = new HashMap<>();
                                    hashMapData.put("sNumRadicSolCred", saveSolicitudCredito.getINumRadic().toString());
                                    hashMapData.put("sLineaCredito", new AdminCoreServiceBean().getNombreLineaCreditoByCodigo(solicitudCredito.getICodCredito()));
                                    hashMapData.put("sMontoCredito", solicitudCredito.getNMontoSolicitud().toString());
                                    hashMapData.put("sDescPeriodicidad", new AdminCoreServiceBean().getDescPeriodo(solicitudCredito.getICodPeriodo().longValue()));
                                    hashMapData.put("sPlazo", solicitudCredito.getPlazo().toString());
                                    hashMapData.put("sValorCuota", solicitudCredito.getNValorCuota().toString());
                                    hashMapData.put("sNombreDeudor", sNombresPersona);
                                    hashMapData.put("sMailDestino", sMailDestino);
                                    if (solicitudCredito.getiFormaPago() == 1) {
                                        hashMapData.put("sFormaPago", "Nomina");
                                    } else {
                                        hashMapData.put("sFormaPago", "Caja");
                                    }
                                    hashMapData.put("sNumPersonaAfiliar", solicitudCredito.getiNumPersonaAfiliar().toString());

                                    if (solicitudCredito.getiTipoProducto().getICodigo() == 1) {
                                        String sEmailHTML = emailHTML.emailSolicitudCredRadicado(hashMapData);
                                        String sEmailHTMLAdmin = emailHTML.emailSolicitudCreditoAdmin(hashMapData);
                                        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
                                        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                        Boolean bRtaSendMailHTML = emailSMTP.SendEmailHTML("brayan.moreno@ebssas.com", sEmailRemitente, sEmailHTML, "COOPERAGRO -- RADICACI??N SOLICITUD DE CR??DITO N?? " + saveSolicitudCredito.getINumRadic());
                                        emailSMTP.SendEmailHTMLSolCredAdmin(sEmailRemitente, sEmailHTMLAdmin, "COOPERAGRO -- NUEVA SOLICITUD DE CR??DITO");
                                        HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
                                        if (bRtaSendMailHTML != null && bRtaSendMailHTML) {
                                            histSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                            histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                            histSolicitudCredito.setCObservacion("Se ha enviado la notificaci??n al correo " + sMailDestino + " La solicitud de cr??dito ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
                                            histSolicitudCredito.setFFechaHistoria(new Date());
                                            histSolicitudCredito.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                            histSolicitudCredito.setFFechaCreacion(new Date());
                                            new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
                                        } else {
                                            histSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                            histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                            histSolicitudCredito.setCObservacion("Se ha presentado un inconveniente al enviar notificaci??n al correo " + sMailDestino);
                                            histSolicitudCredito.setFFechaHistoria(new Date());
                                            histSolicitudCredito.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                            histSolicitudCredito.setFFechaCreacion(new Date());
                                            new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
                                        }
                                    } else {
                                        String sEmailHTML = emailHTML.emailSolicitudServRadicado(hashMapData);
                                        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
                                        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                        Boolean bRtaSendMailHTML = emailSMTP.SendEmailHTML(sMailDestino, sEmailRemitente, sEmailHTML, "COOPERAGRO -- RADICACI??N SOLICITUD DE SERVICIO N?? " + saveSolicitudCredito.getINumRadic());
                                        HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
                                        if (bRtaSendMailHTML != null && bRtaSendMailHTML) {
                                            histSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                            histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                            histSolicitudCredito.setCObservacion("Se ha enviado la notificaci??n al correo " + sMailDestino + " La solicitud de servicio ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
                                            histSolicitudCredito.setFFechaHistoria(new Date());
                                            histSolicitudCredito.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                            histSolicitudCredito.setFFechaCreacion(new Date());
                                            new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
                                        } else {
                                            histSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                            histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                            histSolicitudCredito.setCObservacion("Se ha presentado un inconveniente al enviar notificaci??n al correo " + sMailDestino);
                                            histSolicitudCredito.setFFechaHistoria(new Date());
                                            histSolicitudCredito.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                            histSolicitudCredito.setFFechaCreacion(new Date());
                                            new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
                                        }
                                    }

                                    Boolean bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", "3135757509", "COOPERAGRO le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
                                    HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
                                    if (bRtaSendSMS) {
                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                        histSolCredSMS.setCObservacion("Se ha enviado la notificaci??n SMS al n??mero de celular " + sNumCel + ". COOPERAGRO le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
                                        histSolCredSMS.setFFechaHistoria(new Date());
                                        histSolCredSMS.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                        histSolCredSMS.setFFechaCreacion(new Date());
                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                    } else {
                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                        histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS al n??mero de celular " + sNumCel);
                                        histSolCredSMS.setFFechaHistoria(new Date());
                                        histSolCredSMS.setIUsuarioCreador(new UsuarioServiceBean().findUsuarioById(iCodUser));
                                        histSolCredSMS.setFFechaCreacion(new Date());
                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
                                    }
                                } else {
                                    rtaGenerica.setbRta(Boolean.FALSE);
                                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al crear la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setsMsj("Se ha presentado un inconveniente al crear la solicitud de cr??dito. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                            }

                        } else {
                            TipoEstadoSolicitudCredito tipoEstadoSol = new TipoEstadoSolCreditoServiceBean().findByID(1);
                            solicitudCredito.setFFechaModificacion(new Date());
                            solicitudCredito.setIEstadoSolicitud(tipoEstadoSol);
                            SolicitudCredito updateSolCredito = this.updateSolicitudCredito(solicitudCredito);
                            TipoEstadoSolicitudCredito tipoEstSolCredOld = solicitudCredito.getIEstadoSolicitud();
                            if (updateSolCredito != null && updateSolCredito.getICodigo() != null && updateSolCredito.getIEstadoSolicitud().equals(tipoEstSolCredOld)) {
                                HistoriaSolicitudCredito newHistSolicitudCredito = new HistoriaSolicitudCredito();
                                newHistSolicitudCredito.setISolicitudCredito(solicitudCredito);
                                newHistSolicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
                                newHistSolicitudCredito.setCObservacion("La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                                newHistSolicitudCredito.setFFechaHistoria(new Date());
                                newHistSolicitudCredito.setFFechaCreacion(new Date());
                                new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistSolicitudCredito);
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setiCodigo(0);
                                rtaGenerica.setsMsj("Se ha presentado un inconveniente al intentar cambiar el estado de la solicitud de cr??dito.\n\n" + "La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
                            }
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("No se ha podido radicar la solicitud de cr??dito. Por favor intente de nuevo.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("No se encontrado la informaci??n para el tipo de estado del cr??dito.");
                }
            }
        } else {
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("El c??digo de la persona es requerido para realizar la radicaci??n.");
        }
        return rtaGenerica;
    }

    @Override
    public respuestaGenerica saveAutorizacionesSolCred(String xData) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            String sDecodeData = util.decodeBase64(xData);
            if (sDecodeData != null && !sDecodeData.equals("")) {
                String sPartesData[] = sDecodeData.split(";");
                if (sPartesData != null && sPartesData.length > 0) {
                    String sAuthCentralesRiesgo = sPartesData[0];
                    String sAuthDatosPersonales = sPartesData[1];
                    String sAuthDeclaracionOrigenFondos = sPartesData[2];
                    String sIdSolCred = sPartesData[3];
                    String sIdUserModificador = sPartesData[4];
                    Long idSolCred = new Long(sIdSolCred);
                    Long idUserModificador = new Long(sIdUserModificador);
                    SolicitudCredito findSolCredById = this.findSolicitudCreditoById(idSolCred);
                    if (findSolCredById != null && findSolCredById.getICodigo() != null) {
                        Usuario findUserModificador = new UsuarioServiceBean().findUsuarioById(idUserModificador);
                        if (findUserModificador != null && findUserModificador.getICodigo() != null) {
                            findSolCredById.setCAuthCentralesRiesgo(sAuthCentralesRiesgo.toUpperCase());
                            findSolCredById.setCAuthDatosPersonales(sAuthDatosPersonales.toUpperCase());
                            findSolCredById.setCDeclaracionOrigenFondos(sAuthDeclaracionOrigenFondos.toUpperCase());
                            findSolCredById.setIUsuarioModificador(findUserModificador);
                            findSolCredById.setFFechaModificacion(new Date());
                            SolicitudCredito updateSolCred = this.updateSolicitudCredito(findSolCredById);
                            if (updateSolCred != null && !updateSolCred.getCAuthCentralesRiesgo().isEmpty() && !updateSolCred.getCAuthDatosPersonales().isEmpty() && !updateSolCred.getCDeclaracionOrigenFondos().isEmpty()) {
                                HistoriaSolicitudCredito newHistoriaSolCred = new HistoriaSolicitudCredito();
                                newHistoriaSolCred.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                newHistoriaSolCred.setISolicitudCredito(findSolCredById);
                                newHistoriaSolCred.setCObservacion("El usuario ha aceptado las autorizaciones para la solicitud de cr??dito.");
                                newHistoriaSolCred.setIUsuarioCreador(findUserModificador);
                                newHistoriaSolCred.setFFechaHistoria(new Date());
                                newHistoriaSolCred.setFFechaCreacion(new Date());
                                HistoriaSolicitudCredito hsc = new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistoriaSolCred);
//                                if (hsc != null && hsc.getICodigo() != null) {
//                                try {
//                                    String sICodigo = findSolCredById.getIPersona().getICodigo().toString();
//                                    String sTipoIdent = findSolCredById.getIPersona().getITipoIdent().toString();
//                                    String sIdent = findSolCredById.getIPersona().getCIdentificacion();
//                                    String sMailDestino = new CygnusCoreServiceBean().getEmailPersona(sICodigo, sTipoIdent, sIdent);
//                                    String sNumCel = new CygnusCoreServiceBean().getTelPersona(sICodigo, sTipoIdent, sIdent);
//                                    String sNombresPersona = new CygnusCoreServiceBean().getNombresCompletos(sICodigo, sTipoIdent, sIdent);
//                                    ResponseLineaCredito responseLineaCred = new AdminCoreServiceBean().wsLineaCredito();
//
//                                    HashMap<String, String> hashMapData = new HashMap<>();
//                                    hashMapData.put("sNumRadicSolCred", updateSolCred.getINumRadic().toString());
//                                    hashMapData.put("sLineaCredito", new AdminCoreServiceBean().getNombreLineaCredito(responseLineaCred,findSolCredById.getICodCredito()));
////                                    hashMapData.put("sLineaCredito", "");
//                                    hashMapData.put("sMontoCredito", updateSolCred.getNMontoSolicitud().toString());
//                                    hashMapData.put("sDescPeriodicidad", new AdminCoreServiceBean().getDescPeriodo(findSolCredById.getICodPeriodo().longValue()));
////                                    hashMapData.put("sDescPeriodicidad", "");
//                                    hashMapData.put("sPlazo", updateSolCred.getPlazo().toString());
//                                    hashMapData.put("sValorCuota", updateSolCred.getNValorCuota().toString());
//                                    hashMapData.put("sNombreDeudor", sNombresPersona);
//                                    hashMapData.put("sMailDestino", sMailDestino);
//
////                                    String sEmailHTML = emailHTML.emailSolicitudCredRadicado(hashMapData);
////                                    Boolean bRtaSendMailHTML = emailSMTP.SendEmailHTML(sMailDestino, sEmailHTML, "SOMEC -- RADICACI??N SOLICITUD DE CR??DITO N?? " + updateSolicitudCredito.getINumRadic());
//                                    String sEmalHTML = emailHTML.emailSolicitudCredRadicado(hashMapData);
//                                    boolean responsePHPSendEmail = WsMail.SendEmailFinal(sMailDestino, "SOLICITUD DE CR??DITO RADICADA", sEmalHTML);
//                                    HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
//                                    if (responsePHPSendEmail) {
//                                        histSolicitudCredito.setISolicitudCredito(solicitudCredito);
//                                        histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolicitudCredito.setCObservacion("Se ha enviado la notificaci??n al correo " + sMailDestino + " La solicitud de cr??dito ha sido " + tipoEstadoSolCred.getCDescripcion().toUpperCase() + " para su respectivo proceso. Nro radicado: " + solicitudCredito.getINumRadic());
//                                        histSolicitudCredito.setFFechaHistoria(new Date());
//                                        histSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolicitudCredito.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
//                                    } else {
//                                        histSolicitudCredito.setISolicitudCredito(solicitudCredito);
//                                        histSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolicitudCredito.setCObservacion("Se ha presentado un inconveniente al enviar notificaci??n al correo " + sMailDestino);
//                                        histSolicitudCredito.setFFechaHistoria(new Date());
//                                        histSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolicitudCredito.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolicitudCredito);
//                                    }
//                                    
//                                    Boolean bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "COOPECHANCE le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
//                                    HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
//                                    if (bRtaSendSMS) {
//                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
//                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolCredSMS.setCObservacion("Se ha enviado la notificaci??n SMS al n??mero de celular " + sNumCel + ". COOPECHANCE le informa que su solicitud de cr??dito con Nro de radicado " + solicitudCredito.getINumRadic() + " ha sido " + solicitudCredito.getIEstadoSolicitud().getCDescripcion().toUpperCase() + " para su estudio.");
//                                        histSolCredSMS.setFFechaHistoria(new Date());
//                                        histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolCredSMS.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
//                                    } else {
//                                        histSolCredSMS.setISolicitudCredito(solicitudCredito);
//                                        histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
//                                        histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS al n??mero de celular " + sNumCel);
//                                        histSolCredSMS.setFFechaHistoria(new Date());
//                                        histSolCredSMS.setIUsuarioCreador(findUserModificadorByCod);
//                                        histSolCredSMS.setFFechaCreacion(new Date());
//                                        new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(histSolCredSMS);
//                                    }
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                                rtaGenerica.setbRta(Boolean.TRUE);
//                                rtaGenerica.setiCodigo(1);
//                                rtaGenerica.setsMsj("Se ha enviado un correo electronico al email registrado en la entidad con la informaci??n de la solicitud de cr??dito Nro " + +solicitudCredito.getINumRadic() + " la c??al se encuentra en estado " + tipoEstadoSolCred.getCDescripcion().toUpperCase());
//                            } else {
//                                TipoEstadoSolicitudCredito tipoEstadoSol = new TipoEstadoSolCreditoServiceBean().findByID(1);
//                                solicitudCredito.setIUsuarioModificador(findUserModificadorByCod);
//                                solicitudCredito.setFFechaModificacion(new Date());
//                                solicitudCredito.setIEstadoSolicitud(tipoEstadoSol);
//                                SolicitudCredito updateSolCredito = this.updateSolicitudCredito(solicitudCredito);
//                                if (updateSolCredito != null && updateSolCredito.getICodigo() != null && updateSolCredito.getIEstadoSolicitud().equals(tipoEstSolCredOld)) {
//                                    HistoriaSolicitudCredito newHistSolicitudCredito = new HistoriaSolicitudCredito();
//                                    newHistSolicitudCredito.setISolicitudCredito(solicitudCredito);
//                                    newHistSolicitudCredito.setIEstadoSolicitud(tipoEstSolCredOld);
//                                    newHistSolicitudCredito.setCObservacion("La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
//                                    newHistSolicitudCredito.setFFechaHistoria(new Date());
//                                    newHistSolicitudCredito.setIUsuarioCreador(findUserModificadorByCod);
//                                    newHistSolicitudCredito.setFFechaCreacion(new Date());
//                                    new HistoriaSolCreditoServiceBean().saveHistoriaSolicitudCredito(newHistSolicitudCredito);
//                                    rtaGenerica.setbRta(Boolean.FALSE);
//                                    rtaGenerica.setiCodigo(0);
//                                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al intentar cambiar el estado de la solicitud de cr??dito.\n\n" + "La solicitud de cr??dito en estado " + tipoEstadoSolCred.getCDescripcion() + " ha pasado al estado " + tipoEstSolCredOld.getCDescripcion() + ". Por un inconveniente en el proceso.");
//                                }
//                            }
                                rtaGenerica.setbRta(Boolean.TRUE);
                                rtaGenerica.setiCodigo(1);
                                rtaGenerica.setsMsj("Se ha actualizado la informaci??n de la solicitud de cr??dito de manera correcta.");
                            } else {
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setiCodigo(0);
                                rtaGenerica.setsMsj("No se ha podido actualizar la informaci??n de la solicitud de cr??dito.");
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la informaci??n del usuario, por favor intente de neuvo.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la informaci??n de la solicitud de cr??dito, por favor intente de nuevo.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al procesar la informaci??n enviada, por favor intente de nuevo.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("La informaci??n es requerida para procesar la petici??n solicitada, por favor vuelva a intentarlo.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("Ha ocurrido un error al procesar la petici??n por favor intente de nuevo, si el inconveniente persiste comuniquese con la entidad.");
        }
        return rtaGenerica;
    }

    @Override
    public void deleteSolicitud(SolicitudCredito xData) {
        new SolicitudCreditoDataAccessImp().deleteSolicitud(xData);
    }

    @Override
    public respuestaGenerica actualizarSolicitudCredito(String xData) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        String partes[] = util.decodeBase64(xData).split(";");
        String codigoSolCred = partes[0];
        String codPersona = partes[1];
        String codCredito = partes[2];
        String montoSolicitud = partes[3];
        String plazo = partes[4];
        String valorCuota = partes[5];
        String codPeriodo = partes[6];
        String codUsuarioMod = partes[7];
        SolicitudCredito solicitudCredito = this.findSolicitudCreditoById(Long.parseLong(codigoSolCred));
        if (solicitudCredito != null && solicitudCredito.getICodigo() != null) {
            Persona personaBus = new PersonaServiceBean().personaWebFindByID(Integer.parseInt(codPersona));
            Usuario usuarioBus = new UsuarioServiceBean().findUsuarioById(Long.parseLong(codUsuarioMod));
            solicitudCredito.setIPersona(personaBus);
            solicitudCredito.setICodCredito(Long.parseLong(codCredito));
            solicitudCredito.setFFechaSolicitud(new Date());
            solicitudCredito.setNMontoSolicitud(BigDecimal.valueOf(Long.parseLong(montoSolicitud)));
            solicitudCredito.setPlazo(BigInteger.valueOf(Long.parseLong(plazo)));
            solicitudCredito.setNValorCuota(BigDecimal.valueOf(Long.parseLong(valorCuota)));
            solicitudCredito.setICodPeriodo(BigInteger.valueOf(Long.parseLong(codPeriodo)));
            solicitudCredito.setIUsuarioModificador(usuarioBus);
            solicitudCredito.setFFechaModificacion(new Date());
            SolicitudCredito updateSolCred = this.updateSolicitudCredito(solicitudCredito);
            if (updateSolCred != null && updateSolCred.getICodigo() != null) {
                rtaGenerica.setbRta(Boolean.TRUE);
                rtaGenerica.setiCodigo(1);
                rtaGenerica.setsMsj("Se ha actualizado la informaci??n de la solictud de cr??dito.");
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("Se ha presentado un inconveniente al intentar actualizar la informaci??n de la solictud de cr??dito.");
            }
        } else {
            rtaGenerica.setbRta(Boolean.TRUE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("Se ha presentado un inconveniente al intentar actualizar la informaci??n de la solictud de cr??dito.");
        }
        return rtaGenerica;
    }

    @Override
    public SolicitudCredito validarSolCredByPersonaAndCodCredito(Long idPersona, Long idLineaCred) {
        return new SolicitudCreditoDataAccessImp().validarSolCredByPersonaAndCodCredito(idPersona, idLineaCred);
    }

    @Override
    public ResponseValidarSolCredPersona validarExistenciaSolCredByidLineaCred(Long idPersona, Long idLineaCred) {
        ResponseValidarSolCredPersona respValidarSolCredPersona = new ResponseValidarSolCredPersona();
        if (idPersona != null && idLineaCred != null) {
            SolicitudCredito verificaSolCred = new SolicitudCreditoDataAccessImp().verificarSolCredByPersonaAndLineaCred(idPersona, idLineaCred);
            if (verificaSolCred != null && verificaSolCred.getICodigo() != null) {
                List<SolicitudCredito> listaSolicitud = new ArrayList<>();
                listaSolicitud.add(verificaSolCred);
                respValidarSolCredPersona.setbRtaSolCredNew(Boolean.FALSE);
                respValidarSolCredPersona.setbRtaSolCredDlg(Boolean.TRUE);
                respValidarSolCredPersona.setListaSolicitud(listaSolicitud);
                respValidarSolCredPersona.setsMsj("Ya cuenta con una solicitud de cr??dito en estado " + verificaSolCred.getIEstadoSolicitud().getCDescripcion().toUpperCase() + ". Por favor termine esta solicitud, si desea puede cambiar la informaci??n registrada.");
            } else {
                SolicitudCredito validarSolCredByPersonaAndConCred = this.validarSolCredByPersonaAndCodCredito(idPersona, idLineaCred);
                if (validarSolCredByPersonaAndConCred != null && validarSolCredByPersonaAndConCred.getICodigo() != null) {
                    respValidarSolCredPersona.setbRtaSolCredNew(Boolean.FALSE);
                    respValidarSolCredPersona.setbRtaSolCredDlg(Boolean.FALSE);
                    respValidarSolCredPersona.setListaSolicitud(new ArrayList<>());
                    respValidarSolCredPersona.setsMsj("Ya cuenta con una solicitud de cr??dito en estado " + validarSolCredByPersonaAndConCred.getIEstadoSolicitud().getCDescripcion().toUpperCase() + ".Por lo que debe esperar que se tome una decisi??n final, para m??s informaci??n ingrese a la opci??n Mis Solicitudes, cualquier cambio o notificaci??n sera notificado por correo electronico o sms.");
                } else {
                    respValidarSolCredPersona.setbRtaSolCredNew(Boolean.TRUE);
                    respValidarSolCredPersona.setbRtaSolCredDlg(Boolean.FALSE);
                    respValidarSolCredPersona.setListaSolicitud(new ArrayList<>());
                    respValidarSolCredPersona.setsMsj("La persona puede realizar el proceso con la linea de cr??dito seleccionada.");
                }
            }
        } else {
            respValidarSolCredPersona.setbRtaSolCredNew(Boolean.FALSE);
            respValidarSolCredPersona.setbRtaSolCredDlg(Boolean.FALSE);
            respValidarSolCredPersona.setListaSolicitud(new ArrayList<>());
            respValidarSolCredPersona.setsMsj("Hacen falta datos para validar si la persona cuenta con solicitudes de cr??dito en proceso.");
        }
        return respValidarSolCredPersona;
    }

//    @Override
//    public respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador) {
//        return this.aceptCondSolCredServiceBean.generarTokenAceptacionSolCred(idSolCred, idUserCreador);
//    }
}
