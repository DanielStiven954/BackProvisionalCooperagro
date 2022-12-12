/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.GestionPqrsfDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.PqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.CategoriaPqrsf;
import com.co.ebs.cooperagro.domain.GestionPqrsf;
import com.co.ebs.cooperagro.domain.HistoriaPqrsf;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.domain.Pqrsf;
import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import com.co.ebs.cooperagro.domain.TipoCanal;
import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.domain.TipoPqrsf;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestGestionPQRSF;
import com.co.ebs.cooperagro.request.RequestRegistrarPQRSF;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseListPqrsrf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author YO
 */
public class PqrsfServiceBean implements PqrsfService {

    private final crearEmailHTML emailHTML = new crearEmailHTML();
    private final sendEmailSMTP envioEmail = new sendEmailSMTP();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    @Override
    public respuestaGenerica realizarRegistroPQRSF(RequestRegistrarPQRSF registrarPQRSF) {
        respuestaGenerica generica = new respuestaGenerica();
            
        if (registrarPQRSF.getcIdentificacion() != null && registrarPQRSF.getcEmail() != null) {

            Pqrsf pqrsf = new Pqrsf();
            pqrsf.setITipoIdent(new BigInteger(registrarPQRSF.getiTipoIdent() + ""));
            pqrsf.setCIdentificacion(registrarPQRSF.getcIdentificacion());
            pqrsf.setCNombre(registrarPQRSF.getcNombre());
            pqrsf.setCEmail(registrarPQRSF.getcEmail());
            pqrsf.setITipoPqrsf(new TipoPqrsf(Long.parseLong(registrarPQRSF.getiTipoPqrsf() + "")));
            pqrsf.setCDescPqrsf(registrarPQRSF.getSDescPqrsf());
            pqrsf.setITipoCanal(new TipoCanal(Long.parseLong(registrarPQRSF.getiTipoCanal() + "")));
            pqrsf.setCNavegador(registrarPQRSF.getcNavegador());
            pqrsf.setCIp(registrarPQRSF.getcIp());
            pqrsf.setITipoEstadoPqrsf(new TipoEstadoPqrsf(Long.parseLong("2")));
            pqrsf.setISubCategoria(new SubCategoriaPqrsf(registrarPQRSF.getiSubCategoriaPqrsf()));
            pqrsf.setFFechaSolictud(new Date());

            Pqrsf pqrsfS = new PqrsfDataAccessImp().savePqrsf(pqrsf);

            utilidad util = new utilidad();
            String numRadic = util.dateToStringFormatFechaNumRadicSolCred();

            if (pqrsfS != null && pqrsfS.getICodigo() != null) {
                if (pqrsfS.getICodigo().intValue() >= 1 && pqrsfS.getICodigo().intValue() <= 9) {
                    numRadic += "0" + pqrsfS.getICodigo().toString();
                } else {
                    numRadic += pqrsfS.getICodigo().toString();
                }

                pqrsf.setCNumRadic(numRadic);
                this.updatePQRSF(pqrsf);
                
                if(registrarPQRSF.getDocumentoPqrsf() != null){
                    DocumentoPqrsfServiceBean documentoPqrsfServiceBean = new DocumentoPqrsfServiceBean();
                    registrarPQRSF.getDocumentoPqrsf().setIPqrsf(pqrsf);
                    registrarPQRSF.getDocumentoPqrsf().setIPqrsf(pqrsf);
                    documentoPqrsfServiceBean.saveDocumentoPqrsf(registrarPQRSF.getDocumentoPqrsf());
                }
                
                
                HistoriaPqrsf historiaPqrsf = new HistoriaPqrsf();
                historiaPqrsf.setCObservacion("Se creo la historia del PQRSF de manera correcta");
                historiaPqrsf.setIEstPqrsfOld(new TipoEstadoPqrsf(Long.parseLong("2")));
                historiaPqrsf.setFRegistro(new Date());
                historiaPqrsf.setIPqrsf(pqrsf);
                new HistoriaPqrsfServiceBean().registrarHistoriaPqrsf(historiaPqrsf);

                if (pqrsf.getCEmail() != null && !pqrsf.getCEmail().equals("")) {
                    if (pqrsf.getCEmail().contains("@")) {

                        TipoPqrsf tpqrsfsb = new TipoPQRSFServiceBean().findById(pqrsf.getITipoPqrsf().getICodigo().longValue());
                        CategoriaPqrsf categoriaPqrsf = new CategoriaPqrsfServiceBean().findById(pqrsf.getISubCategoria().getICategoria().getICodigo());
                        SubCategoriaPqrsf subCategoriaPqrsf = new SubCategoriaPqrsfServiceBean().findById(pqrsf.getISubCategoria().getICodigo());
                        
                        try {
                            HashMap<String, String> hashMapData = new HashMap<String, String>();
                            hashMapData.put("sDescTipoDOI", "CÉDULA DE CIUDADANÍA");
                            hashMapData.put("sNumDOI", pqrsf.getCIdentificacion());
                            hashMapData.put("sNombreCompleto", pqrsf.getCNombre());
                            hashMapData.put("sNumRadicado", pqrsf.getCNumRadic());
                            hashMapData.put("sMensaje", pqrsf.getCDescPqrsf());
                            hashMapData.put("sTipoPQRSF", tpqrsfsb.getCDescripcion());
                            hashMapData.put("sCategoriaPQRSF", categoriaPqrsf.getCNombre());
                            hashMapData.put("sSubCategoriaPQRSF", subCategoriaPqrsf.getCNombre());
                            String sEmalHTML = emailHTML.emailRegistroPQRSF(hashMapData);

                            //SE OCULTA EL CORREO REGISTRADO
                            String sCorreoOculto = util.ocultarCorreo(pqrsf.getCEmail());
                            // SE OBTIENE EL CORREO REMITENTE
                            String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                            //SE GENERA EL MENSAJE EN HTML PARA ENVIAR AL ASOCIADO
                            Boolean bRtaSendEmailHTML = envioEmail.SendEmailHTML(pqrsf.getCEmail(), sEmailRemitente, sEmalHTML, "SOLICITUD PQRSF");
                            //SE VALIDA QUE EL ENVIO SEA EXITOSO
                            if (bRtaSendEmailHTML) {
                                generica.setiCodigo(1);
                                generica.setsMsj("Gracias por escribirnos. Nuestro equipo atenderá tu solicitud y te dará respuesta en el menor tiempo posible al Email que ingresaste. Tu Nro de radicado es: " + numRadic);
                                generica.setbRta(Boolean.TRUE);
                            }

                        } catch (Exception e) {
                            generica.setbRta(Boolean.FALSE);
                            generica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                            e.printStackTrace();
                        }
                        generica.setiCodigo(1);
                        generica.setsMsj("Gracias por escribirnos. Nuestro equipo atenderá tu solicitud y te dará respuesta en el menor tiempo posible al Email que ingresaste. Tu Nro de radicado es: " + numRadic);
                        generica.setbRta(Boolean.TRUE);
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("El email registrado no es válido.");
                    }

                } else {
                    generica.setiCodigo(0);
                    generica.setsMsj("Se ha presentado un inconveniente al crear la solicitud. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                    generica.setbRta(Boolean.FALSE);
                }

            } else {
                generica.setiCodigo(0);
                generica.setsMsj("Se ha presentado un inconveniente al crear la solicitud. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
                generica.setbRta(Boolean.FALSE);
            }

        }
        return generica;
    }

    public Pqrsf updatePQRSF(Pqrsf pqrsf) {
        PqrsfDataAccessImp accessImp = new PqrsfDataAccessImp();
        return accessImp.updatePqrsf(pqrsf);
    }

    public respuestaGenerica updatePQRSF(RequestGestionPQRSF gestionPQRSF) {
        utilidad util = new utilidad();
        Long estadoOld;
        respuestaGenerica generica = new respuestaGenerica();
        Usuario usuario = null;
        usuario = new UsuarioServiceBean().findUserByPersonaCodigo(gestionPQRSF.getGestionPqrsf().getIUsuarioCreador().getIPersona().getICodigo(), "1");
        gestionPQRSF.getGestionPqrsf().setIUsuarioCreador(usuario);

        try {
            if (usuario != null && usuario.getICodigo() != 0) {
                if (gestionPQRSF.getNuevoEstado() != 0) {
                    if (!gestionPQRSF.getGestionPqrsf().getCMsjRta().equals("")) {
                        GestionPqrsfServiceBean gestionPqrsfServiceBean = new GestionPqrsfServiceBean();
                        gestionPQRSF.getGestionPqrsf().setFFechaRegistro(new Date());
                        if (gestionPqrsfServiceBean.registrarGestion(gestionPQRSF.getGestionPqrsf()) != null) {
                            estadoOld = gestionPQRSF.getGestionPqrsf().getIPqrsf().getITipoEstadoPqrsf().getICodigo();
                            TipoEstadoPqrsf tipoEstadoOld = new TipoEstadoPqrsfServiceBean().obtenerEstadoPqrsf(estadoOld);
                            TipoEstadoPqrsf tipoEstadoNew = new TipoEstadoPqrsfServiceBean().obtenerEstadoPqrsf(gestionPQRSF.getNuevoEstado());
                            gestionPQRSF.getGestionPqrsf().getIPqrsf().setITipoEstadoPqrsf(new TipoEstadoPqrsf(gestionPQRSF.getNuevoEstado()));
                            if (this.updatePQRSF(gestionPQRSF.getGestionPqrsf().getIPqrsf()) != null) {
                                HistoriaPqrsf historiaPqrsf = new HistoriaPqrsf();
                                historiaPqrsf.setCObservacion("Pasó de " + tipoEstadoOld.getCDescripcion() + " a " + tipoEstadoNew.getCDescripcion());
                                historiaPqrsf.setIEstPqrsfOld(new TipoEstadoPqrsf(gestionPQRSF.getNuevoEstado()));
                                historiaPqrsf.setFRegistro(new Date());
                                historiaPqrsf.setIPqrsf(gestionPQRSF.getGestionPqrsf().getIPqrsf());
                                new HistoriaPqrsfServiceBean().registrarHistoriaPqrsf(historiaPqrsf);

                                if (gestionPQRSF.getGestionPqrsf().getIPqrsf().getCEmail().contains("@")) {
                                    HashMap<String, String> hashMapData = new HashMap<String, String>();
                                    hashMapData.put("sNumRadicado", gestionPQRSF.getGestionPqrsf().getIPqrsf().getCNumRadic());
                                    hashMapData.put("sMensaje", gestionPQRSF.getGestionPqrsf().getCMsjRta());
                                    String sEmalHTML = emailHTML.emailRespuestaPQRSF(hashMapData);

                                    //SE OCULTA EL CORREO REGISTRADO
                                    String sCorreoOculto = util.ocultarCorreo(gestionPQRSF.getGestionPqrsf().getIPqrsf().getCEmail());
                                    // SE OBTIENE EL CORREO REMITENTE
                                    String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                    //SE GENERA EL MENSAJE EN HTML PARA ENVIAR AL ASOCIADO
                                    Boolean bRtaSendEmailHTML = envioEmail.SendEmailHTML(gestionPQRSF.getGestionPqrsf().getIPqrsf().getCEmail(), sEmailRemitente, sEmalHTML, "SOLICITUD PQRSF");
                                    //SE VALIDA QUE EL ENVIO SEA EXITOSO
                                    if (bRtaSendEmailHTML) {
                                        System.out.println("Envio...");
                                        generica.setbRta(Boolean.TRUE);
                                        generica.setiCodigo(1);
                                        generica.setsMsj("Se ha registrado exitosamente la actualización de PQRSF.");
                                    } else {
                                        generica.setbRta(Boolean.FALSE);
                                        generica.setiCodigo(0);
                                        generica.setsMsj("Se ha presentado un inconveniente en el envío del correo de respuesta.");
                                    }
                                } else {
                                    generica.setbRta(Boolean.FALSE);
                                    generica.setiCodigo(0);
                                    generica.setsMsj("No se encontro correo de la persona solicitante.");
                                }
                            } else {
                                generica.setbRta(Boolean.FALSE);
                                generica.setiCodigo(0);
                                generica.setsMsj("Se ha presentado un inconveniente al crear la solicitud. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con soporte.");
                            }
                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("Se ha presentado un inconveniente al crear la solicitud. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con soporte. RG");
                        }
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("Ingrese un mensaje válido.");
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setiCodigo(0);
                    generica.setsMsj("Ingrese un estado válido.");
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setiCodigo(0);
                generica.setsMsj("El usuario no se encuentra registrado en el sistema.");
            }
        } catch (Exception e) {
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("Se ha presentado un inconveniente al crear la solicitud. Por favor vuelva a intentarlo, si el incidente persiste comuniquese con soporte.");
        }
        return generica;
    }

    @Override
    public ResponseListPqrsrf obtenerListaPqrsf() {
        List<Pqrsf> listPqrsf = new PqrsfDataAccessImp().findAllPqrsf();
        ResponseListPqrsrf RListPqrsf = new ResponseListPqrsrf();

        if (listPqrsf != null) {
            RListPqrsf.setiCodigo(1);
            RListPqrsf.setbRta(Boolean.TRUE);
            RListPqrsf.setListPqrsf(listPqrsf);
        } else {
            RListPqrsf.setiCodigo(0);
            RListPqrsf.setbRta(Boolean.FALSE);
        }

        return RListPqrsf;
    }

    @Override
    public ResponsePqrsf obtenerPqrsfById(Long codigo) {

        ResponsePqrsf responsePqrsf = new ResponsePqrsf();
        PqrsfDataAccessImp accessImp = new PqrsfDataAccessImp();
        GestionPqrsfServiceBean gestionPqrsfServiceBean = new GestionPqrsfServiceBean();
        Pqrsf p;
        p = accessImp.findById(codigo);

        if (p != null) {
            List<GestionPqrsf> listGestionPqrsf;
            listGestionPqrsf = gestionPqrsfServiceBean.obtenerMsjRta(codigo);
            responsePqrsf.setbRta(Boolean.TRUE);
            responsePqrsf.setPqrsf(p);
            responsePqrsf.setiCodigo(1);
            responsePqrsf.setListGestionPqrsf(listGestionPqrsf);
            responsePqrsf.setsMsjRta("Se encontraron registros");

        } else {
            responsePqrsf.setbRta(Boolean.TRUE);
            responsePqrsf.setPqrsf(p);
            responsePqrsf.setiCodigo(1);
            responsePqrsf.setsMsjRta("No se encontro registro con codigo: " + codigo);
        }
        return responsePqrsf;
    }

}
