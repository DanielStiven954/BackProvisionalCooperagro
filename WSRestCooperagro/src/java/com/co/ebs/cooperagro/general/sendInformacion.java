/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.CygnusCoreServiceBean;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan F Silva R
 */
public class sendInformacion {

    private CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();
    private ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    private sendEmailSMTP emailSMTP = new sendEmailSMTP();
    private utilidad util = new utilidad();

    public sendInformacion() {
    }

    public respuestaGenerica sendInfoByPersona(int iTipoIdent, String sIdent, String sMetodoEnvioInfo, String sSendMsj, String sAsuntoMsj) {
        respuestaGenerica rtaGenericaSendInfo = new respuestaGenerica();
        Boolean bRtaSendEnvioInfo = Boolean.FALSE;
        String sMsj = "";
        if (sMetodoEnvioInfo != null && !sMetodoEnvioInfo.equals("")) {
            switch (sMetodoEnvioInfo) {
                case "EMAIL":
                    String sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(iTipoIdent), sIdent);

                    String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                    if (sEmailPersona != null && !sEmailPersona.equals("")) {
                        if (sEmailPersona.contains("@")) {
                            try {
                                String sCorreoOculto = "";
                                sCorreoOculto = util.ocultarCorreo(sEmailPersona);
//                                bRtaSendEnvioInfo = emailSMTP.enviarEmailV2("", util.dateToStringFormatFecha(new Date()), sEmailPersona, sAsuntoMsj, sSendMsj);
                                bRtaSendEnvioInfo = emailSMTP.SendEmailHTML(sEmailPersona, sEmailRemitente, sSendMsj, sAsuntoMsj);
                                if (bRtaSendEnvioInfo) {
                                    sMsj = "Se ha enviado el correo electronico de manera exitosa al siguiente email " + sCorreoOculto + " Por favor revise la bandeja de entrada o en correos no deseados (SPAM).";
                                } else {
                                    sMsj = "Ha ocurrido un error al intentar enviar el correo electronico. Por favor intente de nuevo más tarde.";
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                bRtaSendEnvioInfo = Boolean.FALSE;
                                sMsj = "Ha ocurrido un error al intentar enviar el correo electronico. Por favor intente de nuevo más tarde.";
                            }
                        } else {
                            bRtaSendEnvioInfo = Boolean.FALSE;
                            sMsj = "El correo electronico registrado en COOPERAGRO no es un correo valido para el envio de información. Por favor pongase en contacto con COOPERAGRO.";
                        }
                    } else {
                        bRtaSendEnvioInfo = Boolean.FALSE;
                        sMsj = "No cuenta con un correo electronico registrado en COOPERAGRO. Por favor pongase en contacto con COOPERAGRO.";
                    }
                    break;
                case "SMS":
                    bRtaSendEnvioInfo = Boolean.FALSE;
                    sMsj = "No se ha podido enviar la información requerida. Por favor intente de nuevo.";
                    break;
                default:
                    bRtaSendEnvioInfo = Boolean.FALSE;
                    sMsj = "No se ha podido enviar la información requerida. Por favor intente de nuevo.";
                    break;
            }
        } else {
        }
        rtaGenericaSendInfo.setbRta(bRtaSendEnvioInfo);
        rtaGenericaSendInfo.setsMsj(sMsj);
        return rtaGenericaSendInfo;
    }

    public respuestaGenerica sendInfoByPersonaWithAttachment(int iTipoIdent, String sIdent, String sMetodoEnvioInfo, String sSendMsj, String sAsuntoMsj, String attachment) {
        respuestaGenerica rtaGenericaSendInfo = new respuestaGenerica();
        Boolean bRtaSendEnvioInfo = Boolean.FALSE;
        String sMsj = "";
        if (sMetodoEnvioInfo != null && !sMetodoEnvioInfo.equals("")) {
            switch (sMetodoEnvioInfo) {
                case "EMAIL":
                    String sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(iTipoIdent), sIdent);
                    String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                    if (sEmailPersona != null && !sEmailPersona.equals("")) {
                        if (sEmailPersona.contains("@")) {
                            try {
                                String sCorreoOculto = "";
                                sCorreoOculto = util.ocultarCorreo(sEmailPersona);
//                                bRtaSendEnvioInfo = emailSMTP.enviarEmailV2("", util.dateToStringFormatFecha(new Date()), sEmailPersona, sAsuntoMsj, sSendMsj);
                                bRtaSendEnvioInfo = emailSMTP.SendEmailHTMLWitchAttachment(sEmailPersona, sEmailRemitente, sSendMsj, sAsuntoMsj, attachment);
                                sMsj = "Se ha enviado el correo electronico de manera exitosa al siguiente email " + sCorreoOculto + " Por favor revise la bandeja de entrada o en correos no deseados (SPAM).";
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                bRtaSendEnvioInfo = Boolean.FALSE;
                                sMsj = "Ha ocurrido un error al intentar enviar el correo electronico. Por favor intente de nuevo más tarde.";
                            }
                        } else {
                            bRtaSendEnvioInfo = Boolean.FALSE;
                            sMsj = "El correo electronico registrado en COOPERAGRO no es un correo valido para el envio de información. Por favor pongase en contacto con COOPERAGRO.";
                        }
                    } else {
                        bRtaSendEnvioInfo = Boolean.FALSE;
                        sMsj = "No cuenta con un correo electronico registrado en COOPERAGRO. Por favor pongase en contacto con COOPERAGRO.";
                    }
                    break;
                case "SMS":
                    bRtaSendEnvioInfo = Boolean.FALSE;
                    sMsj = "No se ha podido enviar la información requerida. Por favor intente de nuevo.";
                    break;
                default:
                    bRtaSendEnvioInfo = Boolean.FALSE;
                    sMsj = "No se ha podido enviar la información requerida. Por favor intente de nuevo.";
                    break;
            }
        } else {
        }
        rtaGenericaSendInfo.setbRta(bRtaSendEnvioInfo);
        rtaGenericaSendInfo.setsMsj(sMsj);
        return rtaGenericaSendInfo;
    }

}
