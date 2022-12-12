/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.DatoPersonalSolAfiWebDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.SolicitudAfiliacionWebDataAccessImp;
import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.sendEmailSMTP;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestEstadoSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.PersonaCygnus;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudAfilicion;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author JONATHAN RUGE
 */
public class SolicitudAfiliacionWebServiceBean implements SolicitudAfiliacionWebService {

    private final SolicitudAfiliacionWebDataAccessImp solAfilWebDataAccessImp = new SolicitudAfiliacionWebDataAccessImp();
    private final utilidad util = new utilidad();
//    private final Gson gson = new Gson();
    private static final Locale localeCo = new Locale("es", "CO");
    private static final SimpleDateFormat dateFormatMesDiaAnio = new SimpleDateFormat("MM/dd/yyyy", localeCo);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final sendEmailSMTP envioEmail = new sendEmailSMTP();
    private final crearEmailHTML emailHTML = new crearEmailHTML();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    public SolicitudAfiliacionWebServiceBean() {
    }

    @Override
    public SolicitudAfiliacionWeb crearSolicitudAfiliacion() {
        return solAfilWebDataAccessImp.crear();
    }

    @Override
    public SolicitudAfiliacionWeb updateSolicitudAfiliacionWeb(SolicitudAfiliacionWeb solicitudAfiliacionWeb) {
        return solAfilWebDataAccessImp.updateSolicitudAfiliacionWeb(solicitudAfiliacionWeb);
    }

    @Override
    public SolicitudAfiliacionWeb findSolicitudAfiliacionWebById(Long id) {
        return solAfilWebDataAccessImp.findSolicitudAfiliacionWebById(id);
    }

    @Override
    public respuestaGenerica updateDatosInicialesSolAflWeb(Long lCodSolAfilWeb, Long lCodCiudad, String sTipoIngreso, String sFechaRetiro, String sFechaRadicado) {
        respuestaGenerica rtaGenericaUpdate = new respuestaGenerica();
        try {
            if (lCodSolAfilWeb != null && lCodSolAfilWeb != 0) {
                if (lCodCiudad != null && lCodCiudad != 0) {
                    if (sTipoIngreso != null && !sTipoIngreso.equals("")) {
                        SolicitudAfiliacionWeb solicitudAfiliacionWeb = this.findSolicitudAfiliacionWebById(lCodSolAfilWeb);
                        if (solicitudAfiliacionWeb != null && solicitudAfiliacionWeb.getICodigo() != null) {
                            solicitudAfiliacionWeb.setICiudad(lCodCiudad);
                            solicitudAfiliacionWeb.setCTipoIngreso(sTipoIngreso);
                            Date dateFechaRadicado = new SimpleDateFormat("yyyy-MM-dd").parse(sFechaRadicado);
                            solicitudAfiliacionWeb.setFFechaRadicado(dateFechaRadicado);
                            if (sTipoIngreso.equals("R")) {
                                if (sFechaRetiro != null && !sFechaRetiro.equals("")) {
                                    Date dateFechaRetiro = dateFormat.parse(sFechaRetiro);
                                    solicitudAfiliacionWeb.setFFechaRetiro(dateFechaRetiro);
                                } else {
                                    rtaGenericaUpdate.setbRta(Boolean.FALSE);
                                    rtaGenericaUpdate.setiCodigo(0);
                                    rtaGenericaUpdate.setsMsj("El tipo de ingreso de la afiliación es REAFILIACIÓN por lo que se requiere la fecha de retiro.");
                                }
                            }
                            SolicitudAfiliacionWeb updateSolicitudAfiliacionWeb = this.updateSolicitudAfiliacionWeb(solicitudAfiliacionWeb);
                            if (updateSolicitudAfiliacionWeb != null && updateSolicitudAfiliacionWeb.getICodigo() != null && updateSolicitudAfiliacionWeb.getCTipoIngreso() != null && !updateSolicitudAfiliacionWeb.getCTipoIngreso().equals("")) {
                                rtaGenericaUpdate.setbRta(Boolean.TRUE);
                                rtaGenericaUpdate.setiCodigo(1);
                                rtaGenericaUpdate.setsMsj("Se ha actualizado los datos iniciales de la solicitud de afiliación correctamente. Puede continuar con su solicitud de afiliación.");
                            } else {
                                rtaGenericaUpdate.setbRta(Boolean.FALSE);
                                rtaGenericaUpdate.setiCodigo(0);
                                rtaGenericaUpdate.setsMsj("Se ha presentado un inconveniente al actualizar su solicitud de afiliacion, por favor verifique los datos ingresados.");
                            }
                        } else {
                            rtaGenericaUpdate.setbRta(Boolean.FALSE);
                            rtaGenericaUpdate.setiCodigo(0);
                            rtaGenericaUpdate.setsMsj("No se ha encontrado la solicitud de afiliación con el N° de radicado " + lCodSolAfilWeb);
                        }
                    } else {
                        rtaGenericaUpdate.setbRta(Boolean.FALSE);
                        rtaGenericaUpdate.setiCodigo(0);
                        rtaGenericaUpdate.setsMsj("El tipo de ingreso es requerido.");
                    }
                } else {
                    rtaGenericaUpdate.setbRta(Boolean.FALSE);
                    rtaGenericaUpdate.setiCodigo(0);
                    rtaGenericaUpdate.setsMsj("La ciudad es requerida.");
                }
            } else {
                rtaGenericaUpdate.setbRta(Boolean.FALSE);
                rtaGenericaUpdate.setiCodigo(0);
                rtaGenericaUpdate.setsMsj("El N° de radicado es requerido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rtaGenericaUpdate.setbRta(Boolean.FALSE);
            rtaGenericaUpdate.setiCodigo(0);
            rtaGenericaUpdate.setsMsj("Se ha presentado un inconveniente al actualizar los datos iniciales de la solicitud de afiliación, por favor vuelva a intentarlo, de lo contrario comuniquese con la entidad.");
        }

        return rtaGenericaUpdate;
    }

    public boolean updateEstadoSolAfilWeb(Long idEstado, Long idSolAfilWeb) {
        return solAfilWebDataAccessImp.updateEstado(idEstado, idSolAfilWeb);
    }

    public List<SolicitudAfiliacionWeb> findAll() {
        return solAfilWebDataAccessImp.findSolAfilRPA();
    }

    @Override
    public respuestaGenerica cambiarEstado(RequestEstadoSolAfilWeb estadoSolAfilWeb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public respuestaGenerica radicarSolAfilWeb(RequestEstadoSolAfilWeb estadoSolAfilWeb) {
        respuestaGenerica generica = new respuestaGenerica();

        try {
            SolicitudAfiliacionWeb afiliacionWeb = findSolicitudAfiliacionWebById(estadoSolAfilWeb.getlCodSolicitud());
            if (afiliacionWeb != null) {
                TipoEstadoSolAfilWeb buscarEstado = new TipoEstadoSolWebServiceBean().findByAbre(estadoSolAfilWeb.getAbreviatura());
                if (buscarEstado != null) {
                    String nomEstadoSolAnterior = afiliacionWeb.getIEstadoSolicitud().getCNombre();
                    afiliacionWeb.setIEstadoSolicitud(buscarEstado);
                    afiliacionWeb.setFFechaRadicado(new Date());
                    afiliacionWeb.setIUsuarioAsesor(new Usuario(estadoSolAfilWeb.getlUsuario()));
                    afiliacionWeb.setCObsVerfInf(estadoSolAfilWeb.getObservaciones());
                    SolicitudAfiliacionWeb updateSolAfilWeb = updateSolicitudAfiliacionWeb(afiliacionWeb);
                    if (updateSolAfilWeb != null) {
                        String mensajeEnvio = "";
                        String mensaje = "";
                        String mensajeTxt = "";
                        switch (buscarEstado.getCAbreviatura()) {
                            case "PRE-APR":
                                mensaje = "La solicitud de afiliación ha sido preaprobada de manera correcta.";
                                mensajeEnvio = "COOPERAGRO E.C. le informa que su solicitud de afiliación con el Nro de radicado " + afiliacionWeb.getCNumRadic() + " ha sido " + afiliacionWeb.getIEstadoSolicitud().getCNombre() + ""
                                        + " Pronto nos comunicaremos con usted, gracias por confiar en nosotros";
                                mensajeTxt = "COOPERAGRO E.C. le informa que su solicitud de afiliación con el Nro de radicado " + afiliacionWeb.getCNumRadic() + " ha sido " + afiliacionWeb.getIEstadoSolicitud().getCNombre();
                                break;
                            default:
                                mensaje = "Se cambia el estado de la solicitud de afiliación de " + nomEstadoSolAnterior + " a ";
                                mensaje += updateSolAfilWeb.getIEstadoSolicitud().getCNombre() + ", por motivo: " + estadoSolAfilWeb.getObservaciones();
                                mensajeEnvio = "COOPERAGRO E.C. le informa que su solicitud de afiliación con Nro de radicado " + afiliacionWeb.getCNumRadic()
                                        + " se encuentra en estado de \"" + afiliacionWeb.getIEstadoSolicitud().getCNombre() + "\"";
                                break;
                        }

                        HistoriaSolAfilWeb historia = new HistoriaSolAfilWeb();
                        historia.setFFechaRegistro(new Date());
                        historia.setCObservacionRegistro("La solicitud de afiliación se encontraba en estado " + nomEstadoSolAnterior);
                        historia.setFFechaCambioEst(new Date());
                        historia.setCObsCambioEst(mensaje);
                        historia.setIEstadoSolicitud(buscarEstado);
                        historia.setISolAfiliacionWeb(afiliacionWeb);
                        HistoriaSolAfilWebServiceBean historiaAfiliacionBean = new HistoriaSolAfilWebServiceBean();
                        HistoriaSolAfilWeb crearHistoria = historiaAfiliacionBean.crearDesdeCero(historia);
                        if (crearHistoria != null) {
                            DatoPersonalSolAfiWebDataAccessImp accessImp = new DatoPersonalSolAfiWebDataAccessImp();
                            DatoPersonalSolAfilWeb informacionBasica = accessImp.findDatoPersonalBySolAfilWeb(estadoSolAfilWeb.getlCodSolicitud());
                            if (informacionBasica != null) {
                                String nomPersona = "";
                                nomPersona = informacionBasica.getCPrimerNombre() + " " + informacionBasica.getCPrimerApellido() + " " + informacionBasica.getCSegundoApellido() == null ? "" : informacionBasica.getCSegundoApellido();

                                String fechaEnvio = this.util.dateToStringFormatFecha(new Date());
                                String asunto = "SOLICITUD DE AFILIACIÓN";

                                HashMap<String, String> hashMapData = new HashMap<>();
                                utilidad util = new utilidad();
                                hashMapData.put("fechaSolicitud", util.dateToStringFormatFechaHora(new Date()));
                                hashMapData.put("numRadic", afiliacionWeb.getCNumRadic() + "");
                                hashMapData.put("motivo", estadoSolAfilWeb.getObservaciones());
                                hashMapData.put("estado", afiliacionWeb.getIEstadoSolicitud().getCDescripcion());
                                hashMapData.put("mensaje", mensajeEnvio);

                                String sEmalHTML = emailHTML.emailEstadoSolicitudAfiliacionWeb(hashMapData);

                                String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                //wsMail.enviarEmail(nomPersona, fechaEnvio, emailDestino, asunto, mensajeEnvio);
                                envioEmail.SendEmailHTML(informacionBasica.getCEmail(), sEmailRemitente, sEmalHTML, asunto);
                                //sendSMS.envioSMS_Sencillo("57", informacionBasica.getcNumCelular(), mensajeEnvio);

                                if (buscarEstado.getCAbreviatura().equals("PRE")) {
                                    PersonaCygnus personaCygnus = new PersonaCygnus();
                                    personaCygnus.setpEstadoAct("P");

                                    DatoPersonalSolAfilWeb datoPersonalSolAfilWeb = new DatoPersonalSolAfilWebServiceBean().findDatoPersonalBySolAfilWeb(estadoSolAfilWeb.getlCodSolicitud());
                                    ActEconomicaSolAfilWeb actEconomicaSolAfilWeb = new ActEconoSolAfilWebServiceBean().findActEconomicaBySolAfilWeb(estadoSolAfilWeb.getlCodSolicitud());
                                    OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb = new OperMonedaExtSolAfilWebServiceBean().findOperMonedaExtBySolAfilWeb(estadoSolAfilWeb.getlCodSolicitud());

                                    String psBase = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
                                    String psUsuario = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
                                    String psClave = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");

                                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                                    personaCygnus.setpDfnNatCodigo("");
                                    personaCygnus.setpWSTipodepersona("N");
                                    personaCygnus.setpDfsNatCodaso("");
                                    personaCygnus.setPwsIdentific(datoPersonalSolAfilWeb.getCIdentificacion());
                                    personaCygnus.setpWNTipoiden("1");
                                    personaCygnus.setpDfnNatTipcli("1");
                                    personaCygnus.setpDfnNatLugexp(String.valueOf(datoPersonalSolAfilWeb.getICiudadExpIdent()));
                                    personaCygnus.setpWDFecexp(dateFormat.format(datoPersonalSolAfilWeb.getFFechaExpIdent()));
                                    personaCygnus.setpDfsNatNombres(datoPersonalSolAfilWeb.getCPrimerNombre() + " " + validarNull(datoPersonalSolAfilWeb.getCSegundoNombre()));
                                    personaCygnus.setpDfsNatApellidos(datoPersonalSolAfilWeb.getCPrimerApellido() + " " + validarNull(datoPersonalSolAfilWeb.getCSegundoApellido()));
                                    personaCygnus.setpDfnNatCiunac(String.valueOf(datoPersonalSolAfilWeb.getICiudadNacimiento()));
                                    personaCygnus.setpWDFecnac(dateFormat.format(datoPersonalSolAfilWeb.getFFechaNacimiento()));
                                    personaCygnus.setpCbsNatResAux("");
                                    personaCygnus.setpWDFecres("");
                                    personaCygnus.setpWSSexo(datoPersonalSolAfilWeb.getCGenero());
                                    personaCygnus.setpSTesoro(actEconomicaSolAfilWeb.getCManejoRecPublicos().equals("N") ? "0" : "1");
                                    personaCygnus.setpDfsNatEstciv(datoPersonalSolAfilWeb.getCEstadoCivil());
                                    personaCygnus.setpDfnNatPercar(String.valueOf(validarNull(datoPersonalSolAfilWeb.getINumPerCar())));
                                    personaCygnus.setpDfsNatCla("");
                                    personaCygnus.setpDfsNatClaint("");
                                    personaCygnus.setpDfsNatNroact("");
                                    personaCygnus.setpDfNatRut("");
                                    personaCygnus.setpDfCodOf("");
                                    personaCygnus.setpDfnNacionalidad("");
                                    personaCygnus.setpDfnNacionalidad2("");
                                    
                                    personaCygnus.setpDfnNroHijos(
                                            (((datoPersonalSolAfilWeb.getINumHijosMayoresEdad() == null ? 0 : datoPersonalSolAfilWeb.getINumHijosMayoresEdad()) + 
                                            (datoPersonalSolAfilWeb.getINumHijosMenoresEdad() == null ? 0 : datoPersonalSolAfilWeb.getINumHijosMenoresEdad()))) + "");
                                    personaCygnus.setpDfsNatApellido1(datoPersonalSolAfilWeb.getCPrimerApellido());
                                    personaCygnus.setpDfsNatApellido2(validarNull(datoPersonalSolAfilWeb.getCSegundoApellido()));
                                    personaCygnus.setpCmbEstrato(String.valueOf(datoPersonalSolAfilWeb.getIEstrato()));
                                    personaCygnus.setpCbNatMujerFam(datoPersonalSolAfilWeb.getCCabezaFamilia());
                                    personaCygnus.setpCbOperacionExt(operMonedaExtSolAfilWeb.getCRealizaOperMonExt());
                                    personaCygnus.setpWSDireccion(datoPersonalSolAfilWeb.getCDireccionResidencia().trim());
                                    personaCygnus.setpWNCiudad(String.valueOf(datoPersonalSolAfilWeb.getICiudadResidencia()));
                                    personaCygnus.setpWSTelefono(datoPersonalSolAfilWeb.getCNumTelefonoResidencia());
                                    personaCygnus.setpWSDirecelec(datoPersonalSolAfilWeb.getCEmail());
                                    personaCygnus.setPsIVinculacLab("");
                                    personaCygnus.setPsCAsesorCom("");
                                    personaCygnus.setPsNSalario(String.valueOf(actEconomicaSolAfilWeb.getNSalario()));
                                    personaCygnus.setPsINivelEstudio("");
                                    personaCygnus.setPsIProfesion(String.valueOf(actEconomicaSolAfilWeb.getCProfesion()));
                                    personaCygnus.setPsICargo(actEconomicaSolAfilWeb.getCCargoActual());
                                    personaCygnus.setPsITipoCont(String.valueOf(actEconomicaSolAfilWeb.getITipoContrato()));
                                    personaCygnus.setPsNModeloScoring("");
                                    personaCygnus.setPwsBd(psBase);
                                    personaCygnus.setPwsUsu(psUsuario);
                                    personaCygnus.setPwsPsw(psClave);

                                    PersonaCygnusServiceBean personaCygnusServiceBean = new PersonaCygnusServiceBean();
                                    String personaCygnusRegistrada = personaCygnusServiceBean.crearPersonaCygnus(personaCygnus);
                                    String codigo = personaCygnusRegistrada.substring(96, 100);
                                    if (codigo != null) {
                                        personaCygnusServiceBean.crearRolPersonaCygnus(codigo, dateFormat.format(new Date()), psBase, psUsuario, psClave);
                                        generica.setbRta(Boolean.TRUE);
                                        generica.setsMsj("La solicitud de afiliación con el Nro. de radicado " + afiliacionWeb.getCNumRadic()+ " ha sido radicada correctamente");
                                    } else {
                                        generica.setbRta(Boolean.FALSE);
                                        generica.setsMsj("No se ha realizado el cambio de estado");
                                    }
                                }
                                generica.setbRta(Boolean.TRUE);
                                generica.setsMsj("La solicitud de afiliación con el Nro. de radicado " + afiliacionWeb.getCNumRadic() + " ha sido actualizada correctamente");

                            } else {
                                generica.setiCodigo(0);
                                generica.setbRta(Boolean.FALSE);
                                generica.setsMsj("No se ha encontrado información del número de celular y correo para la solicitud");
                            }

                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setsMsj("No se ha podido dejar seguimiento al proceso, por favor comuniquese con la entidad");
                        }
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Ha ocurrido un error al actualizar, por favor intente de nuevo más tarde");
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("No se ha encontrado un estado para cambiar");
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se ha encontrado la solicitud");
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("No se ha realizado el cambio de estado");
        }

        return generica;
    }

    public String validarNull(Object valor) {
        return valor == null ? "" : String.valueOf(valor);
    }
}
