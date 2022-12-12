/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.ClaveAccesoUsuarioExtDataAccessImp;
import com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno;
import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.encriptarSha;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
import com.co.ebs.cooperagro.general.utilidad;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Brayan F Silva R
 */
public class ClaveAccesoUsuExtServiceBean implements ClaveAccesoUsuExtService {

    //Service's y DAO
    private final ClaveAccesoUsuarioExtDataAccessImp claveAccesoUsuarioExtDataAccessImp = new ClaveAccesoUsuarioExtDataAccessImp();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final RegistroNuevoUsuarioServiceBean nuevoUsuarioServiceBean = new RegistroNuevoUsuarioServiceBean();
    //OTROS
    private final encriptarSha sha = new encriptarSha();
    private final utilidad util = new utilidad();
    private final sendEmailSMTP envioEmail = new sendEmailSMTP();
    private final crearEmailHTML emailHTML = new crearEmailHTML();

    @Override
    public Boolean createClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        return claveAccesoUsuarioExtDataAccessImp.createClaveAccesoUsuExt(claveAccesoUsuarioExterno);
    }

    @Override
    public Boolean updateClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        return claveAccesoUsuarioExtDataAccessImp.updateClaveAccesoUsuExt(claveAccesoUsuarioExterno);
    }

    @Override
    public void deleteClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        claveAccesoUsuarioExtDataAccessImp.deleteClaveAccesoUsuExt(claveAccesoUsuarioExterno);
    }

    @Override
    public List<ClaveAccesoUsuarioExterno> findAllClaveAccesoUsuExt() {
        return claveAccesoUsuarioExtDataAccessImp.findAll();
    }

    @Override
    public ClaveAccesoUsuarioExterno findClaveAccesoUsuExtById(Long id) {
        return claveAccesoUsuarioExtDataAccessImp.find(id);
    }

    @Override
    public List<ClaveAccesoUsuarioExterno> findClaveAccesoUsuExtByIdent(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno) {
        return claveAccesoUsuarioExtDataAccessImp.findClaveAccesoUsuExtByIdent(claveAccesoUsuarioExterno);
    }

    @Override
    public respuestaGenerica validarCodigoVerificacion(BigInteger iTtipoIdent, String sIdent, String sCodVerificacion, String sClave, int iTipoCanal) {
        respuestaGenerica rtaValidaCodVerificacion = new respuestaGenerica();
        try {
            if (iTtipoIdent != null && iTtipoIdent.intValue() != 0 && sIdent != null && !sIdent.equals("") && sCodVerificacion != null && !sCodVerificacion.equals("") && sClave != null && !sClave.equals("")) {
                //SE OBTIENE LA CANTIDAD DE CARACTERES CON EL QUE SE GENERO EL CODIGO DE VERIFICACIÓN
                String sCantDigRegUsu = parametroServiceBean.obtenerParametroPorNombre("CANT_DIG_REG_USU");
                int iCantDigitosPassRegUsu = Integer.parseInt(sCantDigRegUsu);
                //SE OBTIENE LA CANTIDAD MINIMA DE CARACTERES PARA LA PRIMERA CLAVE
                String sMinPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("MIN_PRIMER_PASSWORD");
                int iMinPrimerPassword = Integer.parseInt(sMinPrimeraClave);
                //SE OBTIENE LA CANTIDAD MAXIMA DE CARACTERES PARA LA PRIMERA CLAVE
                String sMaxPrimerClave = parametroServiceBean.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
                int iMaxPrimerPassword = Integer.parseInt(sMaxPrimerClave);
                //SE OBTIENE SI LA CLAVE DEBE ALFANUMERICA
                String sPasswordAlfanumerica = parametroServiceBean.obtenerParametroPorNombre("PASSWORD_ALPHANUMERICO");
                //SE VALIDA LA CANTIDAD DE CARACTERES DEL CODIGO DE VERIFICACION ENVIADO
                if (sCodVerificacion.length() == iCantDigitosPassRegUsu) {
                    //SE VALIDA QUE LA CLAVE ENVIADA TENGA LOS CARACTERES MAXIMOS Y MINIMOS
                    if (sClave.length() >= iMinPrimerPassword && sClave.length() <= iMaxPrimerPassword) {
                        //SE VALIDA SI LA CLAVE DE SER ALFANUMERICA
                        Boolean passwordAlfanumerico = sPasswordAlfanumerica.toLowerCase().equals("si") ? Boolean.TRUE : Boolean.FALSE;
                        if (passwordAlfanumerico) {
                            Boolean rtaValidacion = Pattern.matches("^[a-zA-Z0-9]*$", sClave);
                            if (rtaValidacion) {
                                rtaValidaCodVerificacion = this.registrarUsuarioNuevo(iTtipoIdent, sIdent, sCodVerificacion, sClave, iTipoCanal);
                            } else {
                                rtaValidaCodVerificacion.setiCodigo(0);
                                rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
                                rtaValidaCodVerificacion.setsMsj("La clave ingresada debe tener minimo " + iMinPrimerPassword + " y máximo " + iMaxPrimerPassword + " caracteres. Debe tener una letra minúscula y una mayúscula.");
                            }
                        } else {
                            Boolean rtaValidacion = Pattern.matches("^[0-9]*$", sClave);
                            if (rtaValidacion) {
                                rtaValidaCodVerificacion = this.registrarUsuarioNuevo(iTtipoIdent, sIdent, sCodVerificacion, sClave, iTipoCanal);
                            } else {
                                rtaValidaCodVerificacion.setiCodigo(0);
                                rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
                                rtaValidaCodVerificacion.setsMsj("La clave ingresada debe tener minimo " + iMinPrimerPassword + " y máximo " + iMaxPrimerPassword + " caracteres. Todos númericos");
                            }
                        }
                    } else {
                        rtaValidaCodVerificacion.setiCodigo(0);
                        rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
                        rtaValidaCodVerificacion.setsMsj("La clave ingresada debe tener minimo " + iMinPrimerPassword + " caracteres y máximo " + iMaxPrimerPassword);
                    }
                } else {
                    rtaValidaCodVerificacion.setiCodigo(0);
                    rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
                    rtaValidaCodVerificacion.setsMsj("El código de verificación no cumple con la cantidad de caracteres requeridos.");
                }
            } else {
                rtaValidaCodVerificacion.setiCodigo(0);
                rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
                rtaValidaCodVerificacion.setsMsj("Todos los datos son requeridos. Por favor verifique el formulario.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            rtaValidaCodVerificacion.setiCodigo(0);
            rtaValidaCodVerificacion.setbRta(Boolean.FALSE);
            rtaValidaCodVerificacion.setsMsj("Ha ocurrido un inconveniente en el proceso. Por favor intente de nuevo. Si continua con el inconveniente comuniquese con la entidad.");
        }

        return rtaValidaCodVerificacion;
    }

    @Override
    public respuestaGenerica registrarUsuarioNuevo(BigInteger iTtipoIdent, String sIdent, String sCodVerificacion, String sClave, int iTipoCanal) {
        respuestaGenerica rtaGenRegistroUsuNuevo = new respuestaGenerica();
        try {
            ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno = new ClaveAccesoUsuarioExterno();
            claveAccesoUsuarioExterno.setITipoIdent(iTtipoIdent);
            claveAccesoUsuarioExterno.setCIdentificacion(sIdent);
            List<ClaveAccesoUsuarioExterno> lstClaveActivaByIdent = this.findClaveAccesoUsuExtByIdent(claveAccesoUsuarioExterno);
            if (lstClaveActivaByIdent != null && !lstClaveActivaByIdent.isEmpty()) {
                String sLlaveSeg = "", sEncriptaCodTemp = "";
                for (ClaveAccesoUsuarioExterno caue : lstClaveActivaByIdent) {
                    sLlaveSeg = caue.getCLlaveSeguridad();
                    sEncriptaCodTemp = sha.encriptar(sCodVerificacion, sLlaveSeg);
                    if (caue.getCClave().equals(sEncriptaCodTemp)) {
                        caue.setCEstado("INA");
                        this.updateClaveAccesoUsuExt(caue);
                        rtaGenRegistroUsuNuevo.setiCodigo(1);
                        rtaGenRegistroUsuNuevo.setbRta(Boolean.TRUE);
                        rtaGenRegistroUsuNuevo.setsMsj("El código de verificación es correcto.");
                    } else {
                        rtaGenRegistroUsuNuevo.setiCodigo(0);
                        rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
                        rtaGenRegistroUsuNuevo.setsMsj("El código de verificación es incorrecto. Por favor intente de nuevo.");
                    }
                    break;
                }
            } else {
                rtaGenRegistroUsuNuevo.setiCodigo(0);
                rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
                rtaGenRegistroUsuNuevo.setsMsj("No existen códigos de verificación activos para el N° de documento" + sIdent + ".");
            }

            if (rtaGenRegistroUsuNuevo.getbRta()) {
                Long lCodigoPersona = cygnusCoreServiceBean.getCodigoPersona("", String.valueOf(iTtipoIdent), sIdent);
                if (lCodigoPersona != null) {
                    Persona persona = new Persona();
                    persona.setICodigo(lCodigoPersona);
                    persona.setITipoIdent(iTtipoIdent);
                    persona.setCIdentificacion(sIdent);

                    String nombresApellidos = cygnusCoreServiceBean.getNombre("", String.valueOf(iTtipoIdent), sIdent);
                    String nombreSeparado[] = nombresApellidos.split("-");
                    if (nombreSeparado.length > 1) {
                        persona.setCNombres(nombreSeparado[0]);
                        persona.setCApellidos(nombreSeparado[1]);
                    } else {
                        persona.setCNombres(nombreSeparado[0]);
                    }

                    String sClaveUsuEncriptada = "", sLlaveSeg = "", sEmailPersona = "", sNombreCompletoPersona = "";
                    String sMinPrimerPassword = parametroServiceBean.obtenerParametroPorNombre("CANT_SALT");
                    int iMinPrimerPassword = Integer.parseInt(sMinPrimerPassword);
                    sLlaveSeg = util.generarAleatorio(iMinPrimerPassword);
                    sClaveUsuEncriptada = sha.encriptar(sClave, sLlaveSeg);

                    sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(iTtipoIdent), sIdent);
                    sNombreCompletoPersona = cygnusCoreServiceBean.getNombresCompletos("", String.valueOf(iTtipoIdent), sIdent);
                    int iTipoPerfil = cygnusCoreServiceBean.getTipoPerson("", String.valueOf(iTtipoIdent), sIdent);
                    if (sEmailPersona != null && !sEmailPersona.equals("")) {
                        if (sEmailPersona.contains("@")) {
                            HashMap<String, String> hashMapData = new HashMap<>();
                            hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
                            hashMapData.put("sNumDOI", sIdent);
                            hashMapData.put("sNombreCompleto", sNombreCompletoPersona);
                            hashMapData.put("sClave", sClave);
                            String sEmalHTML = emailHTML.emailRegistroNuevoUsuario(hashMapData);
                            rtaGenRegistroUsuNuevo = nuevoUsuarioServiceBean.realizarRegistroNuevoUsuario(persona, sClaveUsuEncriptada, sLlaveSeg, iTipoPerfil, iTipoCanal);
                            if (rtaGenRegistroUsuNuevo.getbRta()) {
                                try {
                                    // SE OBTIENE EL CORREO REMITENTE
                                    String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                    //SE GENERA EL MENSAJE EN HTML PARA ENVIAR AL ASOCIADO
                                    envioEmail.SendEmailHTML(sEmailPersona, sEmailRemitente, sEmalHTML, "REGISTRO ASOCIADO PORTAL TRANSACCIONAL COOPERAGRO");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        } else {
                            rtaGenRegistroUsuNuevo.setiCodigo(0);
                            rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
                            rtaGenRegistroUsuNuevo.setsMsj("El email registrado en COOPERAGRO no es valido. Por favor comuniquese con COOPERAGRO para actualizar el email.");
                        }
                    } else {
                        rtaGenRegistroUsuNuevo.setiCodigo(0);
                        rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
                        rtaGenRegistroUsuNuevo.setsMsj("No cuenta con un correo registrado en COOPERAGRO, por favor comuniquese con COOPERAGRO para registrar un email.");
                    }

                } else {
                    rtaGenRegistroUsuNuevo.setiCodigo(0);
                    rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
                    rtaGenRegistroUsuNuevo.setsMsj("Ha ocurrido un inconveniente en la consulta de datos de la persona con N° de documento " + sIdent + ". Por favor intente de nuevo.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            rtaGenRegistroUsuNuevo.setiCodigo(0);
            rtaGenRegistroUsuNuevo.setbRta(Boolean.FALSE);
            rtaGenRegistroUsuNuevo.setsMsj("Ha ocurrido un inconveniente en el proceso. Por favor intente de nuevo. Si continua con el inconveniente comuniquese con la entidad.");
        }
        return rtaGenRegistroUsuNuevo;
    }
}
