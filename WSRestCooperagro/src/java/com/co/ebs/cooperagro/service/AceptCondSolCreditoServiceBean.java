/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AceptCondSolCreditoDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.SolicitudCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.AceptCondSolCredito;
import com.co.ebs.cooperagro.domain.HistoriaSolicitudCredito;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.TipoEstadoSolicitudCredito;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.encriptarSha;
import com.co.ebs.cooperagro.general.sendSMS;
import com.co.ebs.cooperagro.general.sendWSPHP;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePHPSendEmail;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class AceptCondSolCreditoServiceBean implements AceptCondSolCreditoService {

    private final AceptCondSolCreditoDataAccessImp aceptCondSolCreditoDAOImp = new AceptCondSolCreditoDataAccessImp();
    private TipoEstadoSolCreditoServiceBean tipoSolCredServiceBean = new TipoEstadoSolCreditoServiceBean();
    private final SolicitudCreditoDataAccessImp solCreditoDataAccessImp = new SolicitudCreditoDataAccessImp();
    private final HistoriaSolCreditoServiceBean histSolCreditoServiceBean = new HistoriaSolCreditoServiceBean();
    private final UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();

    private final utilidad util = new utilidad();   
    private final encriptarSha sha = new encriptarSha();
    private final sendSMS sendSMS = new sendSMS();

    @Override
    public AceptCondSolCredito saveAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito) {
        return aceptCondSolCreditoDAOImp.saveAceptCondSolCredito(aceptCondSolCredito);
    }

    @Override
    public AceptCondSolCredito updateAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito) {
        return aceptCondSolCreditoDAOImp.updateAceptCondSolCredito(aceptCondSolCredito);
    }

    @Override
    public AceptCondSolCredito findAceptCondSolCreditoById(Long id) {
        return aceptCondSolCreditoDAOImp.findAceptCondSolCreditoById(id);
    }

    @Override
    public List<AceptCondSolCredito> findAllAceptCondSolCredito() {
        return aceptCondSolCreditoDAOImp.findAllAceptCondSolCredito();
    }

    @Override
    public void deleteTipoCanal(AceptCondSolCredito aceptCondSolCredito) {
        aceptCondSolCreditoDAOImp.deleteTipoCanal(aceptCondSolCredito);
    }

    @Override
    public respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador, String sTokenRandom) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            String sCantDigKeyToken = parametroServiceBean.obtenerParametroPorNombre("CANT_KEY_SOL_CRED");
            String sMinVigToken = parametroServiceBean.obtenerParametroPorNombre("MINUTOS_VIG_TOKEN_SOL_CRED");
            if (idSolCred != null && idUserCreador != null) {
                SolicitudCredito findSolCredById = this.solCreditoDataAccessImp.findSolicitudCreditoById(idSolCred);
                if (findSolCredById != null && findSolCredById.getICodigo() != null) {
                    Usuario findUserCreator = this.usuarioServiceBean.findUsuarioById(idUserCreador);
                    if (findUserCreator != null && findUserCreator.getICodigo() != null) {
                        this.inactivarTokensOld(idSolCred, idUserCreador);
                        AceptCondSolCredito aceptCondSolCredito = new AceptCondSolCredito();
                        int iMinutosVigToken = Integer.parseInt(sMinVigToken);
                        int iCantDigKey = Integer.parseInt(sCantDigKeyToken);
                        Date dateInicio = new Date();
                        Date dateFin = util.getDateAddMinutos(dateInicio, iMinutosVigToken);
                        String sKeyRandomSHA = util.passwordRandom(iCantDigKey);
                        String sEncodeKey = util.encodeBase64(sKeyRandomSHA);
                        String sTokenSha = sha.encriptar(sTokenRandom, sKeyRandomSHA);
                        aceptCondSolCredito.setISolicitudCredito(findSolCredById);
                        aceptCondSolCredito.setCToken(sTokenSha);
                        aceptCondSolCredito.setCKeyToken(sEncodeKey);
                        aceptCondSolCredito.setFFechaInicio(dateInicio);
                        aceptCondSolCredito.setFFechaFin(dateFin);
                        aceptCondSolCredito.setCEstado("ACT");
                        aceptCondSolCredito.setIUsuarioCreador(findUserCreator);
                        aceptCondSolCredito.setFFechaCreacion(new Date());
                        AceptCondSolCredito savAceptCondSolCredito = this.saveAceptCondSolCredito(aceptCondSolCredito);
                        if (savAceptCondSolCredito != null && savAceptCondSolCredito.getICodigo() != null && savAceptCondSolCredito.getCEstado() != null && !savAceptCondSolCredito.getCEstado().equals("")) {
                            HistoriaSolicitudCredito newHistSolCred = new HistoriaSolicitudCredito();
                            newHistSolCred.setISolicitudCredito(findSolCredById);
                            newHistSolCred.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                            newHistSolCred.setFFechaHistoria(new Date());
                            newHistSolCred.setCObservacion("Se ha generado el Token para aprobar y aceptar los documentos, terminos y condiciones del crédito.");
                            newHistSolCred.setIUsuarioCreador(findUserCreator);
                            newHistSolCred.setFFechaCreacion(new Date());
                            this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(newHistSolCred);
                            rtaGenerica.setbRta(Boolean.TRUE);
                            rtaGenerica.setiCodigo(1);
                            rtaGenerica.setsMsj("Se ha generado el Token para aprobar y aceptar los documentos, terminos y condiciones de la solicitud crédito.");
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("Se ha presentado un inconveniente al generar el token de aceptación, por favor intente de nuevo.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la información del usuario, por favor intente de nuevo.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la información de la solicitud de créditp, por favor intente de nuevo.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("Por favor verifique la información que es de caracter obligatorio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("Se ha presentado un inconveniente en el proceso de generación del token de aceptación de documentos, terminos y condiciones del crédito, por favor intente de nuevo.");
        }
        return rtaGenerica;
    }

    @Override
    public respuestaGenerica verificarTokenAceptCondSolCred(Long idSolCred, Long idUserMod, String sTokenRandom) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        if (idSolCred != null && idUserMod != null && sTokenRandom != null && !sTokenRandom.equals("")) {
            String sTokenRandomDecode = util.decodeBase64(sTokenRandom);
            SolicitudCredito findSolCredById = this.solCreditoDataAccessImp.findSolicitudCreditoById(idSolCred);
            if (findSolCredById != null && findSolCredById.getICodigo() != null) {
                Usuario findUserModificador = this.usuarioServiceBean.findUsuarioById(idUserMod);
                if (findUserModificador != null && findUserModificador.getICodigo() != null) {
                    AceptCondSolCredito findAcepCondSolCredByIdSolCred = this.findAceptCondSolCreditoBySolCredId(idSolCred);
                    if (findAcepCondSolCredByIdSolCred != null && findAcepCondSolCredByIdSolCred.getICodigo() != null) {
                        try {
                            String sDecodeKey = util.decodeBase64(findAcepCondSolCredByIdSolCred.getCKeyToken());
                            String sToken = findAcepCondSolCredByIdSolCred.getCToken();
                            Date dateInicio = findAcepCondSolCredByIdSolCred.getFFechaInicio();
                            Date dateFin = findAcepCondSolCredByIdSolCred.getFFechaFin();
                            if (new Date().after(dateInicio) && new Date().before(dateFin)) {
                                String sSHAToken = sha.encriptar(sTokenRandomDecode, sDecodeKey);
                                if (sSHAToken.equals(sToken)) {
                                    findAcepCondSolCredByIdSolCred.setCAceptaCondiciones("S");
                                    findAcepCondSolCredByIdSolCred.setCEstado("INA");
                                    findAcepCondSolCredByIdSolCred.setIUsuarioModificador(findUserModificador);
                                    findAcepCondSolCredByIdSolCred.setFFechaModificacion(new Date());
                                    this.aceptCondSolCreditoDAOImp.updateAceptCondSolCredito(findAcepCondSolCredByIdSolCred);
//                                    TipoEstadoSolicitudCredito tipoEstSolCredOld = new TipoEstadoSolicitudCredito();
                                    TipoEstadoSolicitudCredito tipoEstadoSolCred = this.tipoSolCredServiceBean.findByID(6);
                                    if (tipoEstadoSolCred != null && tipoEstadoSolCred.getICodigo() != null) {
//                                        tipoEstSolCredOld = findSolCredById.getIEstadoSolicitud();
                                        findSolCredById.setIUsuarioModificador(findUserModificador);
                                        findSolCredById.setFFechaModificacion(new Date());
                                        findSolCredById.setIEstadoSolicitud(tipoEstadoSolCred);
                                        SolicitudCredito updateSolicitudCredito = this.solCreditoDataAccessImp.updateSolicitud(findSolCredById);
                                        if (updateSolicitudCredito != null && (updateSolicitudCredito.getICodigo().equals(findSolCredById.getICodigo()))) {
                                            HistoriaSolicitudCredito historiaSolicitudCredito = new HistoriaSolicitudCredito();
                                            historiaSolicitudCredito.setISolicitudCredito(updateSolicitudCredito);
                                            historiaSolicitudCredito.setIEstadoSolicitud(tipoEstadoSolCred);
                                            historiaSolicitudCredito.setCObservacion("Felicidades, se han aceptado los terminos y condiciones de la solicitud de credito, en pocos días su crédito sera desembolsado en la cuenta registrada, se enviara un correo electronico y sms notificando el desembolso.");
                                            historiaSolicitudCredito.setFFechaHistoria(new Date());
                                            historiaSolicitudCredito.setIUsuarioCreador(findUserModificador);
                                            historiaSolicitudCredito.setFFechaCreacion(new Date());
                                            HistoriaSolicitudCredito hsc = this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(historiaSolicitudCredito);
                                            if (hsc != null && hsc.getICodigo() != null) {
                                                sendWSPHP wsphp = new sendWSPHP();
                                                String sICodigo = findSolCredById.getIPersona().getICodigo().toString();
                                                String sTipoIdent = findSolCredById.getIPersona().getITipoIdent().toString();
                                                String sIdent = findSolCredById.getIPersona().getCIdentificacion();
                                                String sMailDestino = cygnusCoreServiceBean.getEmailPersona(sICodigo, sTipoIdent, sIdent);
                                                String sNumCel = cygnusCoreServiceBean.getTelPersona(sICodigo, sTipoIdent, sIdent);
                                                ResponsePHPSendEmail responsePHPSendEmail = wsphp.enviarEmailAceptadaAprobada(sMailDestino, findSolCredById.getINumRadic().toString());
                                                HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
                                                if (responsePHPSendEmail != null && responsePHPSendEmail.getFlag()) {
                                                    histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                                    histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                                    histSolicitudCredito.setCObservacion("Se ha enviado la notificación al email " + sMailDestino + " Felicidades, se han aceptado los terminos y condiciones de la solicitud de credito, en pocos días su crédito sera desembolsado en la cuenta registrada, se enviara un correo electronico y sms notificando el desembolso.");
                                                    histSolicitudCredito.setFFechaHistoria(new Date());
                                                    histSolicitudCredito.setIUsuarioCreador(findUserModificador);
                                                    histSolicitudCredito.setFFechaCreacion(new Date());
                                                    this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolicitudCredito);
                                                } else {
                                                    histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                                    histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                                    histSolicitudCredito.setCObservacion("No ha sido posible enviar la notificación de cambio de estado de solicitud de crédito al correo " + sMailDestino);
                                                    histSolicitudCredito.setFFechaHistoria(new Date());
                                                    histSolicitudCredito.setIUsuarioCreador(findUserModificador);
                                                    histSolicitudCredito.setFFechaCreacion(new Date());
                                                    this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolicitudCredito);
                                                }
                                                Boolean bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "Felicidades, se han aceptado los terminos y condiciones de la solicitud de credito, en pocos días su crédito sera desembolsado en la cuenta regisrada, se genera un correo electronico y mensaje de texto notificando el desembolso.");
                                                HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
                                                if (bRtaSendSMS) {
                                                    histSolCredSMS.setISolicitudCredito(findSolCredById);
                                                    histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                                    histSolCredSMS.setCObservacion("Se ha enviado SMS al numero " + sNumCel + " de la aceptación de terminos y condiciones Felicidades, se han aceptado los terminos y condiciones de la solicitud de credito, en pocos días su crédito sera desembolsado en la cuenta regisrada, se genera un correo electronico y mensaje de texto notificando el desembolso.");
                                                    histSolCredSMS.setFFechaHistoria(new Date());
                                                    histSolCredSMS.setIUsuarioCreador(findUserModificador);
                                                    histSolCredSMS.setFFechaCreacion(new Date());
                                                    this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolCredSMS);
                                                } else {
                                                    histSolCredSMS.setISolicitudCredito(findSolCredById);
                                                    histSolCredSMS.setIEstadoSolicitud(tipoEstadoSolCred);
                                                    histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS de cambio de estado de solicitud de crédito al número de celular " + sNumCel);
                                                    histSolCredSMS.setFFechaHistoria(new Date());
                                                    histSolCredSMS.setIUsuarioCreador(findUserModificador);
                                                    histSolCredSMS.setFFechaCreacion(new Date());
                                                    this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolCredSMS);
                                                }
                                            }
                                        }
                                    }
                                    rtaGenerica.setbRta(Boolean.TRUE);
                                    rtaGenerica.setiCodigo(1);
                                    rtaGenerica.setsMsj("Felicidades, se han aceptado los terminos y condiciones de la solicitud de credito, en pocos días su crédito sera desembolsado en la cuenta registrada, se genera un correo electronico y mensaje de texto notificando el desembolso.");
                                } else {
                                    rtaGenerica.setbRta(Boolean.FALSE);
                                    rtaGenerica.setiCodigo(0);
                                    rtaGenerica.setsMsj("Estimado asociado, verifique el token ingresado, no corresponde al enviado. Por favor intente de nuevo o comuniquese con la entidad para solicitar uno nuevo.");
                                }
                            } else {
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setiCodigo(0);
                                rtaGenerica.setsMsj("Ya se cumplio la vigencia del token ingresado, por favor comuniquese con la entidad para obtener uno nuevo.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("Se ha presentado un inconveniente al procesar la petición de la aceptación de terminos y condiciones, por favor intente de nuevo.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la información de la aceptación de terminos y condiciones, por favor intente de nuevo.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la información del usuario, por favor intente de nuevo.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("Se ha presentado un inconveniente al obtener la información de la solicitud de créditp, por favor intente de nuevo.");
            }
        } else {
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("Por favor verifique la información que es de caracter obligatorio.");
        }
        return rtaGenerica;
    }

    @Override
    public AceptCondSolCredito findAceptCondSolCreditoBySolCredId(Long idSolCred) {
        return aceptCondSolCreditoDAOImp.findAceptCondSolCreditoBySolCredId(idSolCred);
    }

    @Override
    public void inactivarTokensOld(Long idSolCred, Long idUserMod) {
        aceptCondSolCreditoDAOImp.inactivarTokensOld(idSolCred, idUserMod);
    }

    @Override
    public respuestaGenerica generarTokenAceptacionSolCred(Long idSolCred, Long idUserCreador) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        sendWSPHP wsphp = new sendWSPHP();
        String sCantDigKeyToken = parametroServiceBean.obtenerParametroPorNombre("CANT_KEY_SOL_CRED");
        try {
            if (idSolCred != null && idUserCreador != null) {
                int iCantDigKey = Integer.parseInt(sCantDigKeyToken);
                String sTokenRandom = util.passwordRandom(iCantDigKey);
                SolicitudCredito findSolCredById = this.solCreditoDataAccessImp.findSolicitudCreditoById(idSolCred);
                if (findSolCredById != null && findSolCredById.getICodigo() != null) {
                    rtaGenerica = this.generarTokenAceptacionSolCred(idSolCred, idUserCreador, sTokenRandom);
                    if (rtaGenerica != null && rtaGenerica.getbRta()) {
                        Usuario usuario = new Usuario(idUserCreador);
                        Persona persona = findSolCredById.getIPersona();
                        if (persona != null && persona.getICodigo() != null) {
                            String sMailDestino = cygnusCoreServiceBean.getEmailPersona(persona.getICodigo().toString(), persona.getITipoIdent().toString(), persona.getCIdentificacion().toString());
                            String sNumCel = cygnusCoreServiceBean.getTelPersona(persona.getICodigo().toString(), persona.getITipoIdent().toString(), persona.getCIdentificacion().toString());
                            ResponsePHPSendEmail responsePHPSendEmail = wsphp.enviarEmailNewToken(sMailDestino, findSolCredById.getINumRadic().toString(), sTokenRandom);
                            HistoriaSolicitudCredito histSolicitudCredito = new HistoriaSolicitudCredito();
                            if (responsePHPSendEmail != null && responsePHPSendEmail.getFlag()) {
                                histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                histSolicitudCredito.setCObservacion("Se ha enviado la notificación al email " + sMailDestino + "SOMEC, le informa que se ha generado un nuevo token para la solicitud de crédito con Nro de radicado " + findSolCredById.getINumRadic() + " que se encuentra en estado " + findSolCredById.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                histSolicitudCredito.setFFechaHistoria(new Date());
                                histSolicitudCredito.setIUsuarioCreador(usuario);
                                histSolicitudCredito.setFFechaCreacion(new Date());
                                this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolicitudCredito);
                            } else {
                                histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                histSolicitudCredito.setCObservacion("No ha sido posible enviar la notificación de cambio de estado de solicitud de crédito al correo " + sMailDestino);
                                histSolicitudCredito.setFFechaHistoria(new Date());
                                histSolicitudCredito.setIUsuarioCreador(usuario);
                                histSolicitudCredito.setFFechaCreacion(new Date());
                                this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolicitudCredito);
                            }
                            Boolean bRtaSendSMS = sendSMS.envioSMS_Sencillo("57", sNumCel, "SOMEC, le informa que se ha generado un nuevo token para la solicitud de crédito con Nro de radicado " + findSolCredById.getINumRadic() + " que se encuentra en estado " + findSolCredById.getIEstadoSolicitud().getCDescripcion().toUpperCase() + ". El siguiente TOKEN: " + sTokenRandom + " debe ser ingresado para aceptar los terminos y condiciones mediante la opcion Mis Solicitudes.");
                            HistoriaSolicitudCredito histSolCredSMS = new HistoriaSolicitudCredito();
                            if (bRtaSendSMS) {
                                histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                histSolicitudCredito.setCObservacion("Se ha enviado SMS al número celular " + sNumCel + " SOMEC, le informa que se ha generado un nuevo token para la solicitud de crédito con Nro de radicado " + findSolCredById.getINumRadic() + " que se encuentra en estado " + findSolCredById.getIEstadoSolicitud().getCDescripcion().toUpperCase());
                                histSolCredSMS.setFFechaHistoria(new Date());
                                histSolCredSMS.setIUsuarioCreador(usuario);
                                histSolCredSMS.setFFechaCreacion(new Date());
                                this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolCredSMS);
                            } else {
                                histSolicitudCredito.setISolicitudCredito(findSolCredById);
                                histSolicitudCredito.setIEstadoSolicitud(findSolCredById.getIEstadoSolicitud());
                                histSolCredSMS.setCObservacion("Se ha presentado un inconveniente al enviar SMS de cambio de estado de solicitud de crédito al número de celular " + sNumCel);
                                histSolCredSMS.setFFechaHistoria(new Date());
                                histSolCredSMS.setIUsuarioCreador(usuario);
                                histSolCredSMS.setFFechaCreacion(new Date());
                                this.histSolCreditoServiceBean.saveHistoriaSolicitudCredito(histSolCredSMS);
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("Se ha presentado un inconveniente al validar la información de la persona. Por favor vuelve a intentarlo.");
                        }
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al validar la información de la solicitud de crédito. Por favor vuelve a intentarlo.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("No se han enviado todos los datos obligatorios, por favor revisar la información ingresada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setiCodigo(0);
            rtaGenerica.setsMsj("Se ha presentado un incidente al realizar la petición solicitada, por favor intente de nuevo.");
        }
        return rtaGenerica;
    }
}
