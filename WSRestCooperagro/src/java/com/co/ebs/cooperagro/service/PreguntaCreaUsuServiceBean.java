package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.PreguntaCreaUsuDataAccessImp;
import com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno;
import com.co.ebs.cooperagro.domain.PreguntaCreaUsu;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestListPregRta;
import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.ebssas.PregseguridadaleatorioDTO;
import com.ebssas.PregseguridadperDTO;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brian Cardenas
 */
public class PreguntaCreaUsuServiceBean implements PreguntaCreaUsuService {

    //NEGOCIO
    private final PreguntaCreaUsuDataAccessImp preguntaCreaUsuAcccessImp    = new PreguntaCreaUsuDataAccessImp();
    private final CygnusCoreServiceBean        cygnusCoreServiceBean        = new CygnusCoreServiceBean();
    private final ParametroServiceBean         parametroServiceBean         = new ParametroServiceBean();
    private final ClaveAccesoUsuExtServiceBean claveAccesoUsuExtServiceBean = new ClaveAccesoUsuExtServiceBean();

    //OTROS
    private final utilidad       util       = new utilidad();
    private final crearEmailHTML emailHTML  = new crearEmailHTML();
    private final sendEmailSMTP  envioEmail = new sendEmailSMTP();

    @Override
    public List<PreguntaCreaUsu> PreguntasRegUsuRandom() {
        return preguntaCreaUsuAcccessImp.getPreguntasRegUsuRandom();
    }

    // LLENO EL TRANSIENTE PreguntaCreaUsu :: ListRtasPreg para que tenga info aleatoria y una real
    @Override
    public List<PreguntaCreaUsu> askWithAnswerRegUser(int xiTipoIden, String xcIdentificacion) {

        List<PreguntaCreaUsu> preguntaCreaUsus = this.PreguntasRegUsuRandom();  // obtenemos 3 pregunta_crea_usu's aleatorios
        String tipoIden = String.valueOf(xiTipoIden);
        if (preguntaCreaUsus != null && !preguntaCreaUsus.isEmpty()) {
            
            for (PreguntaCreaUsu preguntaCreaUsu : preguntaCreaUsus) {
                
                List<String> listRtaPreg = new ArrayList<>();
                
                // obtengo la info desde un campo
                List<PregseguridadperDTO> lstAnswerPregUser = cygnusCoreServiceBean.wsConsultarPregRegistroPersona(tipoIden, xcIdentificacion, preguntaCreaUsu.getCCampo());
                
                // obtengo respuestas aleatorias segun el campo
                List<PregseguridadaleatorioDTO> listAnswerPregRegUsuRandom = cygnusCoreServiceBean.wsConsultarPregRegistroPersonaRandom(tipoIden, xcIdentificacion, preguntaCreaUsu.getCCampo());

                // coloco en listaRtaPreg la info que obtuve segun el campo y esa lista a preguntaCreaUsu
                for (PregseguridadperDTO pregseguridadperDTO : lstAnswerPregUser) {
                    if (pregseguridadperDTO.getCCampo().equals("") || pregseguridadperDTO.getCCampo() == null) {
                        listRtaPreg.add("Ninguna de las anteriores");
                    } 
                    else {
                        listRtaPreg.add(pregseguridadperDTO.getCCampo());
                    }
                    preguntaCreaUsu.setListRtasPreg(listRtaPreg);
                }
                
                // coloco en listaRtaPreg la info aleatoria segun el campo y esa lista a preguntaCreaUsu
                for (PregseguridadaleatorioDTO pregseguridadaleatorioDTO : listAnswerPregRegUsuRandom) {
                    listRtaPreg.add(pregseguridadaleatorioDTO.getCCampo());
                    preguntaCreaUsu.setListRtasPreg(listRtaPreg);
                }
                
                // coloco en preguntaCreaUsu
                Collections.shuffle(preguntaCreaUsu.getListRtasPreg());
            }
        }
        return preguntaCreaUsus;
    }
    
    

    @Override
    public respuestaGenerica validarRtasPregRegistroUsuario(String resp, int xiTipoIden, String xcIdentificacion, String iTipoCanal) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno = new ClaveAccesoUsuarioExterno();
        String tipoIden = String.valueOf(xiTipoIden);
        String sDecodeRtaPregUser = util.decodeBase64(resp);
        String sReplace1 = sDecodeRtaPregUser.replace("{", "");
        String sReplace2 = sReplace1.replace("}", "");
        String splitReplace2[] = sReplace2.split(",");
        boolean isValidateRtas = false;
        String sTipoIdent = String.valueOf(xiTipoIden);

        try {
            for (String valorSplit : splitReplace2) {

                String splitElemento[] = valorSplit.split(":");
                String sValueCampo = splitElemento[0].replace("\"", "");
                String sValueRta = splitElemento[1].replace("\"", "");
                if (sValueCampo.contains("F_")) {
                    sValueRta += ":00:00";
                }

                List<PregseguridadperDTO> listPregseguridadRtaPersona = cygnusCoreServiceBean.wsConsultarPregRegistroPersona(tipoIden, xcIdentificacion, sValueCampo);
                String sValueRtaPregPersonaCore = "";
                if (listPregseguridadRtaPersona != null && !listPregseguridadRtaPersona.isEmpty()) {
                    for (PregseguridadperDTO rtaPregSeguridadPersona : listPregseguridadRtaPersona) {
                        if (rtaPregSeguridadPersona.getCCampo() == null || rtaPregSeguridadPersona.getCCampo().equals("")) {
                            sValueRtaPregPersonaCore = "Ninguna de las anteriores";
                        } else {
                            sValueRtaPregPersonaCore = rtaPregSeguridadPersona.getCCampo();
                        }
                    }
                }
                if (!sValueRta.equals(sValueRtaPregPersonaCore)) {
                    isValidateRtas = false;
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setsMsj("Una o más respuestas son incorrectas. Por favor intente de nuevo.");
                    break;
                } else {
                    isValidateRtas = true;
                }

            }

            if (isValidateRtas) {
                rtaGenerica = validarIntentosPreguntasRegistroUsuario(xiTipoIden, xcIdentificacion, "1", "1");
                if (rtaGenerica.getbRta() && rtaGenerica.getiCodigo() == 1) {
                    String sCantDigRegUsu = parametroServiceBean.obtenerParametroPorNombre("CANT_DIG_REG_USU");
                    int iCantDigitosPassRegUsu = Integer.parseInt(sCantDigRegUsu);
                    String sLlaveSeg = util.generarAleatorio(iCantDigitosPassRegUsu);
                    String sCodConfirmacion = "", sCodConfirEncode = "", sEmailPersona = "", sNombreCompletoPersona = "";
                    ArrayList<String> listPassRandom = util.contrasenaRandom(iCantDigitosPassRegUsu, sLlaveSeg);
                    if (listPassRandom != null && !listPassRandom.isEmpty()) {
                        sCodConfirmacion = listPassRandom.get(0);
                        sCodConfirEncode = listPassRandom.get(1);
                        sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(xiTipoIden), xcIdentificacion);
                        sNombreCompletoPersona = cygnusCoreServiceBean.getNombresCompletos("", String.valueOf(xiTipoIden), xcIdentificacion);
                        if (sEmailPersona != null && !sEmailPersona.equals("")) {
                            if (sEmailPersona.contains("@")) {
                                HashMap<String, String> hashMapData = new HashMap<String, String>();
                                hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
                                hashMapData.put("sNumDOI", xcIdentificacion);
                                hashMapData.put("sNombreCompleto", sNombreCompletoPersona);
                                hashMapData.put("sClave", sCodConfirmacion);
                                String sEmalHTML = emailHTML.emailCodigoVerificacionRegUsu(hashMapData);
                                try {
                                    //SE OBTIENEN LAS CLAVES ACTIVAS DE LA PERSONA
                                    claveAccesoUsuarioExterno.setITipoIdent(new BigInteger(sTipoIdent));
                                    claveAccesoUsuarioExterno.setCIdentificacion(xcIdentificacion);
                                    List<ClaveAccesoUsuarioExterno> listClavesAccUsuExtActivasByIden = claveAccesoUsuExtServiceBean.findClaveAccesoUsuExtByIdent(claveAccesoUsuarioExterno);
                                    //SE INACTIVAN LOS REGISTROS QUE TENGA ESA PERSONA
                                    if (listClavesAccUsuExtActivasByIden != null && !listClavesAccUsuExtActivasByIden.isEmpty()) {
                                        for (ClaveAccesoUsuarioExterno caue : listClavesAccUsuExtActivasByIden) {
                                            caue.setCEstado("INA");
                                            caue.setCIdentificacion(xcIdentificacion);
                                            caue.setITipoIdent(new BigInteger(sTipoIdent));
                                            claveAccesoUsuExtServiceBean.updateClaveAccesoUsuExt(caue);
                                        }
                                    }

                                    //SE CREA EL NUEVO CODIGO DE VERIFICACION
                                    claveAccesoUsuarioExterno = new ClaveAccesoUsuarioExterno();
                                    claveAccesoUsuarioExterno.setCEstado("ACT");
                                    claveAccesoUsuarioExterno.setITipoIdent(new BigInteger(sTipoIdent));
                                    claveAccesoUsuarioExterno.setCIdentificacion(xcIdentificacion);
                                    claveAccesoUsuarioExterno.setCLlaveSeguridad(sLlaveSeg);
                                    claveAccesoUsuarioExterno.setFAcceso(new Date());
                                    claveAccesoUsuarioExterno.setCClave(sCodConfirEncode);
                                    Boolean bRtaCreate = claveAccesoUsuExtServiceBean.createClaveAccesoUsuExt(claveAccesoUsuarioExterno);
                                    if (bRtaCreate) {
                                        //SE OCULTA EL CORREO REGISTRADO
                                        String sCorreoOculto = util.ocultarCorreo(sEmailPersona);
                                        // SE OBTIENE EL CORREO REMITENTE
                                        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                        //SE GENERA EL MENSAJE EN HTML PARA ENVIAR AL ASOCIADO
                                        Boolean bRtaSendEmailHTML = envioEmail.SendEmailHTML(sEmailPersona, sEmailRemitente, sEmalHTML, "CÓDIGO VERIFICACIÓN REGISTRO ASOCIADO PORTAL TRANSACCIONAL COOPERAGRO");
                                        //SE VALIDA QUE EL ENVIO SEA EXITOSO
                                        if (bRtaSendEmailHTML) {
                                            rtaGenerica.setbRta(Boolean.TRUE);
                                            rtaGenerica.setsMsj("Se ha generado un código de verificación que le fue enviado al email " + sCorreoOculto + ". Este email es el que se encuentra registrado en COOPERAGRO.");
                                        }
                                    } else {
                                        rtaGenerica.setbRta(Boolean.FALSE);
                                        rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                                    }
                                } catch (Exception e) {
                                    rtaGenerica.setbRta(Boolean.FALSE);
                                    rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                                    e.printStackTrace();
                                }
                            } else {
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setsMsj("El email registrado en COOPERAGRO no es valido. Por favor comuniquese con COOPERAGRO para actualizar el email.");
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setsMsj("No cuenta con un correo registrado en COOPERAGRO, por favor comuniquese con COOPERAGRO para registrar un email.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                    }
                }
            } else {
                rtaGenerica = validarIntentosPreguntasRegistroUsuario(xiTipoIden, xcIdentificacion, "0", "0");
            }
        } catch (Exception ex) {
            Logger.getLogger(PreguntaCreaUsuServiceBean.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return rtaGenerica;
    }
    

    @Override
    public respuestaGenerica validarIntentosPreguntasRegistroUsuario(int iTipoIdent, String sNumIdent, String estPreg, String iTipoCanal) {
        respuestaGenerica rtaSPValidaIntPregRegUsu = new respuestaGenerica();

        rtaSPValidaIntPregRegUsu = preguntaCreaUsuAcccessImp.validarIntentosPreguntasRegistroUsuario(iTipoIdent, sNumIdent, estPreg, iTipoCanal);
        return rtaSPValidaIntPregRegUsu;
    }

    
    
    
    @Override
    public respuestaGenerica validarRtasPregRegistroUsuario2(RequestRtaCuestionario requestRtaCuestionario) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno = new ClaveAccesoUsuarioExterno();

        String xcIdentificacion = requestRtaCuestionario.getsCIdentificacion();
        int xiTipoIden = Integer.parseInt(requestRtaCuestionario.getsTipoIdentificacion());

        String tipoIden = String.valueOf(requestRtaCuestionario.getsTipoIdentificacion());
        boolean isValidateRtas = false;
        String sTipoIdent = String.valueOf(requestRtaCuestionario.getsTipoIdentificacion());

        try {

            // por cada respuesta dada por el usuario
            for (RequestListPregRta campoValor : requestRtaCuestionario.getRequestListPregRta()) {

                String sValueRta = campoValor.getsValueRta();

                // trae la información de usuario que sirve para validar si la respuesta es correcta
                List<PregseguridadperDTO> listPregseguridadRtaPersona = cygnusCoreServiceBean.wsConsultarPregRegistroPersona(tipoIden, xcIdentificacion, campoValor.getsValueCampo());
                String sValueRtaPregPersonaCore = "";
                if (listPregseguridadRtaPersona != null && !listPregseguridadRtaPersona.isEmpty()) {
                    
                    // mira pregunta por pregunta si la respuesta seleccionada es igual a la que se tiene en core
                    for (PregseguridadperDTO rtaPregSeguridadPersona : listPregseguridadRtaPersona) {
                        if (rtaPregSeguridadPersona.getCCampo() == null || rtaPregSeguridadPersona.getCCampo().equals("")) {
                            sValueRtaPregPersonaCore = "Ninguna de las anteriores";
                        } else {
                            sValueRtaPregPersonaCore = rtaPregSeguridadPersona.getCCampo();
                        }
                    }
                }

                // si la respuesta coincide con la info traída del core, entonces isValidateRtas = true
                if (!sValueRta.equals(sValueRtaPregPersonaCore)) {
                    isValidateRtas = false;
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setsMsj("Una o más respuestas son incorrectas. Por favor intente de nuevo.");
                    break; // ya no analizará más preguntas, ha fallado e isValidateRtas será false. Se sale del bloque for
                } else {
                    isValidateRtas = true;
                }

            }

            // Si y solo si todas las respuestas coincidieron con los datos traídos del core
            if (isValidateRtas) {
                
                // actualiza acceso_usuario_externo, de forma que si el tercer parámetro de validarIntentosPreguntasRegistroUsuario
                // es 1, entonces es porque las preguntas de seguridad externas fueron correctas "isValidateTrue = true"
                rtaGenerica = validarIntentosPreguntasRegistroUsuario(xiTipoIden, xcIdentificacion, "1", requestRtaCuestionario.getsTipoCanal());
                
                if (rtaGenerica.getbRta() && rtaGenerica.getiCodigo() == 1) {
                    
                    // cantidad de digitos del código de verificación para el registro del usuario
                    String sCantDigRegUsu = parametroServiceBean.obtenerParametroPorNombre("CANT_DIG_REG_USU");
                    int iCantDigitosPassRegUsu = Integer.parseInt(sCantDigRegUsu);
                    
                    // genero llave de seguridad y obtengo los datos de confirmacion
                    String sLlaveSeg = util.generarAleatorio(iCantDigitosPassRegUsu);
                    String sCodConfirmacion = "", sCodConfirEncode = "", sEmailPersona = "", sNombreCompletoPersona = "";
                
                    ArrayList<String> listPassRandom = util.contrasenaRandom(iCantDigitosPassRegUsu, sLlaveSeg);
                    if (listPassRandom != null && !listPassRandom.isEmpty()) {
                        sCodConfirmacion = listPassRandom.get(0);
                        sCodConfirEncode = listPassRandom.get(1);
                        sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(xiTipoIden), xcIdentificacion);
                        sNombreCompletoPersona = cygnusCoreServiceBean.getNombresCompletos("", String.valueOf(xiTipoIden), xcIdentificacion);
                        
                        // creo un correo con el código de confirmación
                        if (sEmailPersona != null && !sEmailPersona.equals("")) {
                            if (sEmailPersona.contains("@")) {
                                HashMap<String, String> hashMapData = new HashMap<String, String>();
                                hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
                                hashMapData.put("sNumDOI", xcIdentificacion);
                                hashMapData.put("sNombreCompleto", sNombreCompletoPersona);
                                hashMapData.put("sClave", sCodConfirmacion);
                                String sEmalHTML = emailHTML.emailCodigoVerificacionRegUsu(hashMapData);
                                try {
                                    //SE OBTIENEN LAS CLAVES ACTIVAS DE LA PERSONA
                                    claveAccesoUsuarioExterno.setITipoIdent(new BigInteger(sTipoIdent));
                                    claveAccesoUsuarioExterno.setCIdentificacion(xcIdentificacion);
                                    List<ClaveAccesoUsuarioExterno> listClavesAccUsuExtActivasByIden = claveAccesoUsuExtServiceBean.findClaveAccesoUsuExtByIdent(claveAccesoUsuarioExterno);
                                    //SE INACTIVAN LOS REGISTROS QUE TENGA ESA PERSONA
                                    if (listClavesAccUsuExtActivasByIden != null && !listClavesAccUsuExtActivasByIden.isEmpty()) {
                                        for (ClaveAccesoUsuarioExterno caue : listClavesAccUsuExtActivasByIden) {
                                            caue.setCEstado("INA");
                                            caue.setCIdentificacion(xcIdentificacion);
                                            caue.setITipoIdent(new BigInteger(sTipoIdent));
                                            claveAccesoUsuExtServiceBean.updateClaveAccesoUsuExt(caue);
                                        }
                                    }

                                    //SE CREA EL NUEVO CODIGO DE VERIFICACION
                                    claveAccesoUsuarioExterno = new ClaveAccesoUsuarioExterno();
                                    claveAccesoUsuarioExterno.setCEstado("ACT");
                                    claveAccesoUsuarioExterno.setITipoIdent(new BigInteger(sTipoIdent));
                                    claveAccesoUsuarioExterno.setCIdentificacion(xcIdentificacion);
                                    claveAccesoUsuarioExterno.setCLlaveSeguridad(sLlaveSeg);
                                    claveAccesoUsuarioExterno.setFAcceso(new Date());
                                    claveAccesoUsuarioExterno.setCClave(sCodConfirEncode);
                                    Boolean bRtaCreate = claveAccesoUsuExtServiceBean.createClaveAccesoUsuExt(claveAccesoUsuarioExterno);
                                    if (bRtaCreate) {
                                        //SE OCULTA EL CORREO REGISTRADO
                                        String sCorreoOculto = util.ocultarCorreo(sEmailPersona);
                                        // SE OBTIENE EL CORREO REMITENTE
                                        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                        //SE GENERA EL MENSAJE EN HTML PARA ENVIAR AL ASOCIADO
                                        Boolean bRtaSendEmailHTML = envioEmail.SendEmailHTML(sEmailPersona, sEmailRemitente, sEmalHTML, "CÓDIGO VERIFICACIÓN REGISTRO ASOCIADO PORTAL TRANSACCIONAL COOPERAGRO");
                                        //SE VALIDA QUE EL ENVIO SEA EXITOSO
                                        if (bRtaSendEmailHTML) {
                                            rtaGenerica.setbRta(Boolean.TRUE);
                                            rtaGenerica.setsMsj("Se ha generado un código de verificación que le fue enviado al email " + sCorreoOculto + ". Este email es el que se encuentra registrado en COOPERAGRO.");
                                        }
                                    } else {
                                        rtaGenerica.setbRta(Boolean.FALSE);
                                        rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                                    }
                                } catch (Exception e) {
                                    rtaGenerica.setbRta(Boolean.FALSE);
                                    rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                                    e.printStackTrace();
                                }
                            } else {
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setsMsj("El email registrado en COOPERAGRO no es valido. Por favor comuniquese con COOPERAGRO para actualizar el email.");
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setsMsj("No cuenta con un correo registrado en COOPERAGRO, por favor comuniquese con COOPERAGRO para registrar un email.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                    }
                }
            } else {
                rtaGenerica = validarIntentosPreguntasRegistroUsuario(xiTipoIden, xcIdentificacion, "0", requestRtaCuestionario.getsTipoCanal());
            }
        } catch (Exception ex) {
            Logger.getLogger(PreguntaCreaUsuServiceBean.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return rtaGenerica;
    }

}
