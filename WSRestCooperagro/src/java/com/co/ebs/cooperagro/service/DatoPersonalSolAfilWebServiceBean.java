/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.DatoPersonalSolAfiWebDataAccessImp;
import com.co.ebs.cooperagro.domain.ConsultaAniOlimpiait;
import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.EstadoCedula;
import com.co.ebs.cooperagro.domain.RespuestaAniOlimpiait;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.olimpiait.modelapi.ConsultaANI;
import com.co.ebs.cooperagro.olimpiait.modelresponse.ResponseConsultaANI;
import com.co.ebs.cooperagro.request.RequestDatosPersonalesSolAfil;
import com.co.ebs.cooperagro.request.RequestValdIdentSolAfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseValidarSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.wscore.wsAdministracion;
import com.ebssas.PersonasDTO;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author JONATHAN RUGE
 */
public class DatoPersonalSolAfilWebServiceBean implements DatoPersonalSolAfilWebService {

    private static final Locale localeCo = new Locale("es", "CO");
    private static final SimpleDateFormat dateFormatAnioMesDia = new SimpleDateFormat("yyyy-MM-dd", localeCo);
    private static final SimpleDateFormat dateFormatDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy", localeCo);
    private final UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();

    public respuestaGenerica guardarInformacionConsultaAni(ResponseConsultaANI responseConsultaANI, ConsultaAniOlimpiait consultaAniOlimpiait) {
        respuestaGenerica generica = new respuestaGenerica();

        RespuestaAniOlimpiait respuestaAniOlimpiait = new RespuestaAniOlimpiait();
        respuestaAniOlimpiait.setCIdTransaccion(responseConsultaANI.getIdTransaccion());
        respuestaAniOlimpiait.setCNuip(responseConsultaANI.getNuip());
        respuestaAniOlimpiait.setCPrimerNombre(responseConsultaANI.getPrimerNombre());
        respuestaAniOlimpiait.setCSegundoNombre(responseConsultaANI.getSegundoNombre());
        respuestaAniOlimpiait.setCPrimerApellido(responseConsultaANI.getPrimerApellido());
        respuestaAniOlimpiait.setCSegundoApellido(responseConsultaANI.getSegundoApellido());
        respuestaAniOlimpiait.setCParticula(responseConsultaANI.getParticula());

        EstadoCedula estadoCedula = new EstadoCedulaServiceBean().findEstadoCedulaByICodVigencia(responseConsultaANI.getEstadoCedula().longValue());
        if (estadoCedula != null && estadoCedula.getICodigo() != null) {
            respuestaAniOlimpiait.setIEstadoCedula(estadoCedula);
        }
        respuestaAniOlimpiait.setCNumeroResolucion(responseConsultaANI.getNumeroResolucion());
        respuestaAniOlimpiait.setCMunicipioExpedicion(responseConsultaANI.getMunicipioExpedicion());
        respuestaAniOlimpiait.setCDepartamentoExpedicio(responseConsultaANI.getDepartamentoExpedicion());
        respuestaAniOlimpiait.setCFechaExpedicion(responseConsultaANI.getFechaExpedicion());
        Long lCodErrorDatoCedula = new Long(responseConsultaANI.getCodigoErrorDatosCedula());
        respuestaAniOlimpiait.setICodErrorDatosCedula(BigInteger.valueOf(lCodErrorDatoCedula));
        respuestaAniOlimpiait.setCAnioResolucion(responseConsultaANI.getAnioResolucion());
        respuestaAniOlimpiait.setcJsonRta(responseConsultaANI.toString());
        respuestaAniOlimpiait.setIConsAniOlimpiait(consultaAniOlimpiait);
        RespuestaAniOlimpiait aniOlimpiait = new RespuestaANIServiceBean().saveRespuesta(respuestaAniOlimpiait);
        if (responseConsultaANI.getEstadoCedula().toString().equals("0")) {
            generica.setbRta(Boolean.TRUE);
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("El número de documento con el que fue registrado y se esta validando se encuentra reportado como " + estadoCedula.getCDescripcion().toUpperCase());
        }

        return generica;
    }

    @Override
    public ResponseValidarSolAfilWeb validarSolAfil(RequestValdIdentSolAfil requestValdIdentSolAfil) {
        DatoPersonalSolAfiWebDataAccessImp datoPersonalSolAfiWebDataAcessImp = new DatoPersonalSolAfiWebDataAccessImp();
        SolicitudAfiliacionWebServiceBean solicitudAfiliacionWebServiceBean = new SolicitudAfiliacionWebServiceBean();
        FirmamosAPIServiceBean firmamosBean = new FirmamosAPIServiceBean();
        HistoriaSolAfilWebServiceBean historiaSolAfilWebServiceBean = new HistoriaSolAfilWebServiceBean();
        wsAdministracion wsAdmin = new wsAdministracion();

        ResponseValidarSolAfilWeb responseValidaSolAfilWeb = new ResponseValidarSolAfilWeb();

        if (requestValdIdentSolAfil != null && requestValdIdentSolAfil.getiTipoIdent() != null && requestValdIdentSolAfil.getsNumIdent() != null && !requestValdIdentSolAfil.getsNumIdent().isEmpty() && requestValdIdentSolAfil.getsFechaExp() != null && requestValdIdentSolAfil.getsFechaExp() != null) {

            List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(requestValdIdentSolAfil.getiTipoIdent()), requestValdIdentSolAfil.getsNumIdent());

            if (personaCore.isEmpty()) {
                try {
                    SolicitudAfiliacionWeb solicitudAfiliacionWebValida = datoPersonalSolAfiWebDataAcessImp.validarSolAfi(requestValdIdentSolAfil.getiTipoIdent().intValue(), requestValdIdentSolAfil.getsNumIdent());
                    if (solicitudAfiliacionWebValida != null && solicitudAfiliacionWebValida.getICodigo() != null) {
                        responseValidaSolAfilWeb.setbRta(true);
                        responseValidaSolAfilWeb.setsMsj("Ya tiene una solicitud en diligencia");
                        responseValidaSolAfilWeb.setSolAfilWeb(solicitudAfiliacionWebValida);
                    } else {
                        // CONSULTAR EN LA BD
                        RespuestaAniOlimpiait respuestaAniOlimpiaitBD = new RespuestaANIServiceBean().findRespuestaByIdent(requestValdIdentSolAfil.getiTipoIdent(), requestValdIdentSolAfil.getsNumIdent());
                        System.out.println("***************************************************************");
                        System.out.println("RespuestaAniOlimpiait: "+respuestaAniOlimpiaitBD.toString());
                        System.out.println("***************************************************************");
                        if (respuestaAniOlimpiaitBD != null && respuestaAniOlimpiaitBD.getICodigo() != null) {
                            //Date dateFechaExpDoc = dateFormatAnioMesDia.parse(requestValdIdentSolAfil.getsFechaExp()+"");
                            Date dateFechaExpConsulAni = dateFormatDiaMesAnio.parse(respuestaAniOlimpiaitBD.getCFechaExpedicion());
                            if (requestValdIdentSolAfil.getsFechaExp().equals(dateFechaExpConsulAni)) {
                                SolicitudAfiliacionWeb solicitudAfiliacionNueva = solicitudAfiliacionWebServiceBean.crearSolicitudAfiliacion();
                                DatoPersonalSolAfilWeb datoPersonalNuevo = new DatoPersonalSolAfilWeb();
                                datoPersonalNuevo.setITipoIdent(requestValdIdentSolAfil.getiTipoIdent());
                                datoPersonalNuevo.setCIdentificacion(requestValdIdentSolAfil.getsNumIdent());
                                datoPersonalNuevo.setISolAfiliacionWeb(solicitudAfiliacionNueva);
                                datoPersonalNuevo.setCPrimerNombre(respuestaAniOlimpiaitBD.getCPrimerNombre());
                                datoPersonalNuevo.setCSegundoNombre(respuestaAniOlimpiaitBD.getCSegundoNombre());
                                datoPersonalNuevo.setCPrimerApellido(respuestaAniOlimpiaitBD.getCPrimerApellido());
                                datoPersonalNuevo.setCSegundoApellido(respuestaAniOlimpiaitBD.getCSegundoApellido());
                                datoPersonalNuevo.setFFechaExpIdent(dateFechaExpConsulAni);
                                Long ciudadExpe = Long.parseLong(wsAdmin.codigoCiudad(respuestaAniOlimpiaitBD.getCMunicipioExpedicion(), "3"));
//                Long departExpe = Long.parseLong(wsAdmin.codigoCiudad(respuestaAniOlimpiaitBD.getDepartamentoExpedicion(), "2"));
                                datoPersonalNuevo.setICiudadExpIdent(ciudadExpe);
                                DatoPersonalSolAfilWeb datoPersonalCreado = datoPersonalSolAfiWebDataAcessImp.crearReg(datoPersonalNuevo);
                                historiaSolAfilWebServiceBean.crear(solicitudAfiliacionNueva.getIEstadoSolicitud(), solicitudAfiliacionNueva);

                                utilidad util = new utilidad();
                                String numRadic = util.dateToStringFormatFechaNumRadicSolCred();

                                if (datoPersonalCreado.getISolAfiliacionWeb().getICodigo().intValue() >= 1 && datoPersonalCreado.getISolAfiliacionWeb().getICodigo().intValue() <= 9) {
                                    numRadic += "0" + datoPersonalCreado.getISolAfiliacionWeb().getICodigo().toString();
                                } else {
                                    numRadic += datoPersonalCreado.getISolAfiliacionWeb().getICodigo().toString();
                                }

                                solicitudAfiliacionNueva.setCNumRadic(numRadic);
                                SolicitudAfiliacionWeb saw = solicitudAfiliacionWebServiceBean.updateSolicitudAfiliacionWeb(solicitudAfiliacionNueva);

                                responseValidaSolAfilWeb.setbRta(Boolean.TRUE);
                                responseValidaSolAfilWeb.setsMsj("Su número de identificación es: " + datoPersonalCreado.getCIdentificacion() + " y su número de radicado para la solicitud de afiliación es: " + saw.getCNumRadic());
                                responseValidaSolAfilWeb.setiCodigoR(solicitudAfiliacionNueva.getICodigo());
                                responseValidaSolAfilWeb.setSolAfilWeb(solicitudAfiliacionNueva);
                            } else {
                                responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                                responseValidaSolAfilWeb.setsMsj("Por favor verifique los datos ingresados, la feha de expedición ingresada no coincide con la reportada por la Registraduria.");
                            }
                        } else {

                            // CONSULTAR EL WS 
                            DatoPersonalSolAfilWeb datoPersonalNuevo = new DatoPersonalSolAfilWeb();

                            ConsultaANI consultaANI = new ConsultaANI();
                            consultaANI.setIdProcesoCliente(String.valueOf(new Date().getTime()));
                            consultaANI.setDocumento(requestValdIdentSolAfil.getsNumIdent());
                            System.out.println("***********************Valor de Identificacion: "+requestValdIdentSolAfil.getiTipoIdent().intValue());
                            switch (requestValdIdentSolAfil.getiTipoIdent().intValue()) {
                                case 1:
                                    consultaANI.setTipoDocumento("CC");
                                    break;
                                case 4:
                                    consultaANI.setTipoDocumento("NIT");
                                    break;
                                case 3:
                                    consultaANI.setTipoDocumento("CE");
                                    break;
                                default:
                                    consultaANI.setTipoDocumento("CC");
                                    break;
                            }
                            
                            ResponseConsultaANI respuestaAniOlimpiait = firmamosBean.consultaIdentificacionANI(consultaANI);
                            System.out.println("*********************************************************************************");
                            System.out.println("respuestaAniOlimpiait: "+respuestaAniOlimpiait.toString());
                            System.out.println("*********************************************************************************");
                            if (respuestaAniOlimpiait != null && respuestaAniOlimpiait.getIdTransaccion() != null && !respuestaAniOlimpiait.getIdTransaccion().equals("0")) {
                                ConsultaAniOlimpiait consultaAniOlimpiait = new ConsultaAniOlimpiait();
                                consultaAniOlimpiait.setIIdProceso(BigInteger.valueOf(new Date().getTime()));
                                consultaAniOlimpiait.setCIdentificacion(requestValdIdentSolAfil.getsNumIdent());
                                consultaAniOlimpiait.setITipoIdent(BigInteger.valueOf(requestValdIdentSolAfil.getiTipoIdent()));
                                consultaAniOlimpiait.setFFechaConsulta(new Date());

                                ConsultaAniOlimpiait saveAniOlimpiait = new ConsultaAniServiceBean().saveConsultaAniOlimpiait(consultaAniOlimpiait);
                                respuestaGenerica generica = guardarInformacionConsultaAni(respuestaAniOlimpiait, saveAniOlimpiait);

                                if (respuestaAniOlimpiait != null && respuestaAniOlimpiait.getPrimerNombre() != null) {
                                    Date dateFechaExpConsulAni = dateFormatDiaMesAnio.parse(respuestaAniOlimpiait.getFechaExpedicion());

                                    if (requestValdIdentSolAfil.getsFechaExp().equals(dateFechaExpConsulAni)) {
                                        if (generica.getbRta()) {
                                            SolicitudAfiliacionWeb solicitudAfiliacionNueva = solicitudAfiliacionWebServiceBean.crearSolicitudAfiliacion();
                                            datoPersonalNuevo.setITipoIdent(requestValdIdentSolAfil.getiTipoIdent());
                                            datoPersonalNuevo.setCIdentificacion(requestValdIdentSolAfil.getsNumIdent());
                                            datoPersonalNuevo.setISolAfiliacionWeb(solicitudAfiliacionNueva);
                                            datoPersonalNuevo.setCPrimerNombre(respuestaAniOlimpiait.getPrimerNombre());
                                            datoPersonalNuevo.setCSegundoNombre(respuestaAniOlimpiait.getSegundoNombre());
                                            datoPersonalNuevo.setCPrimerApellido(respuestaAniOlimpiait.getPrimerApellido());
                                            datoPersonalNuevo.setCSegundoApellido(respuestaAniOlimpiait.getSegundoApellido());
                                            datoPersonalNuevo.setFFechaExpIdent(dateFechaExpConsulAni);
                                            Long ciudadExpe = Long.parseLong(wsAdmin.codigoCiudad(respuestaAniOlimpiait.getMunicipioExpedicion(), "3"));
//                Long departExpe = Long.parseLong(wsAdmin.codigoCiudad(respuestaAniOlimpiait.getDepartamentoExpedicion(), "2"));
                                            datoPersonalNuevo.setICiudadExpIdent(ciudadExpe);
                                            DatoPersonalSolAfilWeb datoPersonalCreado = datoPersonalSolAfiWebDataAcessImp.crearReg(datoPersonalNuevo);
                                            historiaSolAfilWebServiceBean.crear(solicitudAfiliacionNueva.getIEstadoSolicitud(), solicitudAfiliacionNueva);
                                            utilidad util = new utilidad();
                                            String numRadic = util.dateToStringFormatFechaNumRadicSolCred();

                                            if (datoPersonalCreado.getISolAfiliacionWeb().getICodigo().intValue() >= 1 && datoPersonalCreado.getISolAfiliacionWeb().getICodigo().intValue() <= 9) {
                                                numRadic += "0" + datoPersonalCreado.getISolAfiliacionWeb().getICodigo().toString();
                                            } else {
                                                numRadic += datoPersonalCreado.getISolAfiliacionWeb().getICodigo().toString();
                                            }

                                            solicitudAfiliacionNueva.setCNumRadic(numRadic);
                                            SolicitudAfiliacionWeb saw = solicitudAfiliacionWebServiceBean.updateSolicitudAfiliacionWeb(solicitudAfiliacionNueva);

                                            responseValidaSolAfilWeb.setbRta(Boolean.TRUE);
                                            responseValidaSolAfilWeb.setsMsj("Su número de identificación es: " + datoPersonalCreado.getCIdentificacion() + " y su número de radicado para la solicitud de afiliación es: " + saw.getCNumRadic());
                                            responseValidaSolAfilWeb.setiCodigoR(solicitudAfiliacionNueva.getICodigo());
                                            responseValidaSolAfilWeb.setSolAfilWeb(solicitudAfiliacionNueva);
                                        } else {
                                            responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                                            responseValidaSolAfilWeb.setsMsj(generica.getsMsj());
                                        }

                                    } else {
                                        responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                                        responseValidaSolAfilWeb.setsMsj("Por favor verifique los datos ingresados, la feha de expedición ingresada no coincide con la reportada por la Registraduria.");
                                    }

                                } else {
                                    responseValidaSolAfilWeb.setbRta(false);
                                    responseValidaSolAfilWeb.setsMsj("No se ha encontrado registro de la persona en la registraduria, por favor verifique la información e intente de nuevo");
                                }
                            } else {
                                responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                                responseValidaSolAfilWeb.setsMsj("Se ha presentado un inconveniente inesperado en la aplicación al validar su identidad por favor comunicate con la entidad.");
                            }

                        }
                    }

                } catch (NumberFormatException | ParseException e) {
                    e.printStackTrace();
                    responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                    responseValidaSolAfilWeb.setsMsj("Se ha presentado un inconveniente inesperado en la aplicación al validar su identidad por favor comunicate con la entidad.");
                }

            } else {
                if (personaCore.get(0).getCEstadoAct().equals("P")) {
                    responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                    responseValidaSolAfilWeb.setsMsj("La persona con N° de documento: " + requestValdIdentSolAfil.getsNumIdent() + " se encuentra en estado PREAPROBADO de afiliación.");
                } else {
                    Usuario findUserByPersonaIdent = usuarioServiceBean.findUserByPersonaIdent(Integer.parseInt(String.valueOf(requestValdIdentSolAfil.getiTipoIdent())), requestValdIdentSolAfil.getsNumIdent(), 1);
                    if (findUserByPersonaIdent != null && findUserByPersonaIdent.getICodigo() != null) {
                        responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                        responseValidaSolAfilWeb.setsMsj("La persona con N° de documento: " + requestValdIdentSolAfil.getsNumIdent() + " ya se encuentra afiliada en COOPERAGRO y en la sucursal de COOPERAGRO DIGITAL.");
                    } else {
                        responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
                        responseValidaSolAfilWeb.setsMsj("La persona con N° de documento: " + requestValdIdentSolAfil.getsNumIdent() + " ya se encuentra afiliada en COOPERAGRO.");
                    }
                }

            }

        } else {
            responseValidaSolAfilWeb.setbRta(Boolean.FALSE);
            responseValidaSolAfilWeb.setsMsj("Por favor ingrese todos los datos.");
        }

        return responseValidaSolAfilWeb;
    }

    @Override
    public DatoPersonalSolAfilWeb crear(Long tipoIdent, String cIdentificacion, SolicitudAfiliacionWeb solAfiWeb) {
        return new DatoPersonalSolAfiWebDataAccessImp().crear(tipoIdent, cIdentificacion, solAfiWeb);
    }

    @Override
    public List<DatoPersonalSolAfilWeb> listaDatoPersonal() {
        return new DatoPersonalSolAfiWebDataAccessImp().listaDatoPersonal();
    }

    @Override
    public DatoPersonalSolAfilWeb updateDatoPersonalSolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb) {
        return new DatoPersonalSolAfiWebDataAccessImp().updateDatoPersonalSolAfilWeb(datoPersonalSolAfilWeb);
    }

    @Override
    public DatoPersonalSolAfilWeb findDatoPersonalSolAfilWebById(Long Id) {
        return new DatoPersonalSolAfiWebDataAccessImp().findDatoPersonalSolAfilWebById(Id);
    }

    @Override
    public DatoPersonalSolAfilWeb findDatoPersonalBySolAfilWeb(Long idSolAfilWeb) {
        return new DatoPersonalSolAfiWebDataAccessImp().findDatoPersonalBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public respuestaGenerica updateDatosPersonalesBySolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb) {
        respuestaGenerica rtaGenUpdateDatosPersBySolfAfilWeb = new respuestaGenerica();
        if (datoPersonalSolAfilWeb != null) {
            if (datoPersonalSolAfilWeb.getISolAfiliacionWeb() != null && datoPersonalSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                DatoPersonalSolAfilWeb dpsaw = this.findDatoPersonalBySolAfilWeb(datoPersonalSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                if (dpsaw != null && dpsaw.getICodigo() != null) {
                    datoPersonalSolAfilWeb.setICodigo(dpsaw.getICodigo());
                    System.out.println("datoPersonalSolAfilWeb.getINumHijosMayoresEdad() " + datoPersonalSolAfilWeb.getINumHijosMayoresEdad());
                    DatoPersonalSolAfilWeb datoPersSolAfilWeb = this.updateDatoPersonalSolAfilWeb(datoPersonalSolAfilWeb);

                    if (datoPersSolAfilWeb != null && datoPersSolAfilWeb.getICodigo() != null && datoPersSolAfilWeb.getCPrimerNombre() != null && !datoPersSolAfilWeb.getCPrimerNombre().equals("")) {
                        rtaGenUpdateDatosPersBySolfAfilWeb.setbRta(Boolean.TRUE);
                        rtaGenUpdateDatosPersBySolfAfilWeb.setiCodigo(1);
                        rtaGenUpdateDatosPersBySolfAfilWeb.setsMsj("Se han actualizados los datos personales correctamente. Puede continuar con la solicitud de afiliación.");
                    } else {
                        rtaGenUpdateDatosPersBySolfAfilWeb.setbRta(Boolean.FALSE);
                        rtaGenUpdateDatosPersBySolfAfilWeb.setiCodigo(0);
                        rtaGenUpdateDatosPersBySolfAfilWeb.setsMsj("No se ha podido actualizar los datos personales de la persona con N° de identificación " + datoPersSolAfilWeb.getCIdentificacion());
                    }
                } else {
                    rtaGenUpdateDatosPersBySolfAfilWeb.setbRta(Boolean.FALSE);
                    rtaGenUpdateDatosPersBySolfAfilWeb.setiCodigo(0);
                    rtaGenUpdateDatosPersBySolfAfilWeb.setsMsj("No se ha podido obtener la información inicial de los datos personales para la solicitud de afiliación con N° de radicación " + datoPersonalSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                }
            } else {
                rtaGenUpdateDatosPersBySolfAfilWeb.setbRta(Boolean.FALSE);
                rtaGenUpdateDatosPersBySolfAfilWeb.setiCodigo(0);
                rtaGenUpdateDatosPersBySolfAfilWeb.setsMsj("No se encuentra el N° de radicado de la solicitud de afiliación para actualizar los datos personales. Por favor intente de nuevo.");
            }
        } else {
            rtaGenUpdateDatosPersBySolfAfilWeb.setbRta(Boolean.FALSE);
            rtaGenUpdateDatosPersBySolfAfilWeb.setiCodigo(0);
            rtaGenUpdateDatosPersBySolfAfilWeb.setsMsj("Por favor verifique los datos enviados.");
        }
        return rtaGenUpdateDatosPersBySolfAfilWeb;
    }

    @Override
    public boolean updateCursoCooperativo(String curso, Long idSolAfilWeb) {
        return new DatoPersonalSolAfiWebDataAccessImp().updateCursoCooperativo(curso, idSolAfilWeb);
    }

}
