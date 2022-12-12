/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.DocumentoSolAfilWeb;
import com.co.ebs.cooperagro.domain.InfoConyugeSolAfilWeb;
import com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb;
import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;
import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;
import com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestAutorizacionCuenta;
import com.co.ebs.cooperagro.request.RequestAutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.request.RequestConyuge;
import com.co.ebs.cooperagro.request.RequestDatosPersonalesSolAfil;
import com.co.ebs.cooperagro.request.RequestDocSolAfilWeb;
import com.co.ebs.cooperagro.request.RequestEconomica;
import com.co.ebs.cooperagro.request.RequestEstadoSolAfilWeb;
import com.co.ebs.cooperagro.request.RequestValdIdentSolAfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCompDireccion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudAfilicion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoDireccion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseValidarSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.ActEconoSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.AutorizacionSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.DatoPersonalSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.DatosConyugeServiceBean;
import com.co.ebs.cooperagro.service.DocumentoSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.InfoConyugeSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.InfoPensionadoSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.InscCuentaSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.OperMonedaExtSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.ReferenciasSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.SolicitudAfiliacionWebServiceBean;
import com.co.ebs.cooperagro.service.TipoDireccionSolWebServiceBean;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author JONATHAN RUGE
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestSolAfiWeb {

    @Context
    private UriInfo context;
    utilidad util = new utilidad();
    private final SolicitudAfiliacionWebServiceBean solicitudAfiliacionWebServiceBean = new SolicitudAfiliacionWebServiceBean();
    private final DatoPersonalSolAfilWebServiceBean datoPersonalBean = new DatoPersonalSolAfilWebServiceBean();
    private final ActEconoSolAfilWebServiceBean actEconoSolAfilWebServiceBean = new ActEconoSolAfilWebServiceBean();
    private final OperMonedaExtSolAfilWebServiceBean operMonedaExtSolAfilWebServiceBean = new OperMonedaExtSolAfilWebServiceBean();
    private final InfoPensionadoSolAfilWebServiceBean infoPensionadoSolAfilWebServiceBean = new InfoPensionadoSolAfilWebServiceBean();
    private final InfoConyugeSolAfilWebServiceBean infoConyugeSolAfilWebServiceBean = new InfoConyugeSolAfilWebServiceBean();
    private final ReferenciasSolAfilWebServiceBean referenciasSolAfilWebServiceBean = new ReferenciasSolAfilWebServiceBean();
    private final DocumentoSolAfilWebServiceBean documentoSolAfilWebServiceBean = new DocumentoSolAfilWebServiceBean();
    private final AutorizacionSolAfilWebServiceBean autorizacionSolAfilWebServiceBean = new AutorizacionSolAfilWebServiceBean();
    private final InscCuentaSolAfilWebServiceBean cuentaSolAfilWebServiceBean = new InscCuentaSolAfilWebServiceBean();

    public WSRestSolAfiWeb() {
    }

    @POST
    @Path("/SolicitudAfiWeb/ValidarSolAfiWeb")
    public ResponseValidarSolAfilWeb validarSolAfiWeb(RequestValdIdentSolAfil requestValdIdentSolAfil) {
        System.out.println("**********************Datos:"+requestValdIdentSolAfil.toString());
        ResponseValidarSolAfilWeb responseValidarSolAfilWeb = new ResponseValidarSolAfilWeb();
        responseValidarSolAfilWeb = datoPersonalBean.validarSolAfil(requestValdIdentSolAfil);
        return responseValidarSolAfilWeb;
    }

    @POST
    @Path("/SolicitudAfilWeb/datosIniciales")
    public respuestaGenerica updateDatosInicialesSolAflWeb(@QueryParam("xlCodSolAfilWeb") Long lCodSolAfilWeb, @QueryParam("xlCodCiudad") Long lCodCiudad, @QueryParam("xsTipoIngreso") String sTipoIngreso, @QueryParam("xsFechaRetiro") String sFechaRetiro, @QueryParam("xsFechaRadicado") String sFechaRadicado) {
        respuestaGenerica rtaGenericaUpdateDatosIniSolAflWeb = this.solicitudAfiliacionWebServiceBean.updateDatosInicialesSolAflWeb(lCodSolAfilWeb, lCodCiudad, sTipoIngreso, sFechaRetiro, sFechaRadicado);
        return rtaGenericaUpdateDatosIniSolAflWeb;
    }

    @POST
    @Path("/SolicitudAfilWeb/getDatoPersonalByRadicado")
    public DatoPersonalSolAfilWeb getDatoPersonalByRadicado(@QueryParam("xsRadicado") String numRadicado) {
        Long idSolAfilWeb = new Long(numRadicado);
        return this.datoPersonalBean.findDatoPersonalBySolAfilWeb(idSolAfilWeb);
    }

    @POST
    @Path("/SolicitudAfilWeb/updateDatosPersonalesSolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica updateDatosPersonalesSolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb) {
        respuestaGenerica rtaGenericaUpdDatosPersSolAfilWeb = this.datoPersonalBean.updateDatosPersonalesBySolAfilWeb(datoPersonalSolAfilWeb);
        return rtaGenericaUpdDatosPersSolAfilWeb;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveActEconoActualSolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveActEconoActualSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        respuestaGenerica g = new respuestaGenerica();
        respuestaGenerica rtaGenSaveActEcoSolAfilWeb = this.actEconoSolAfilWebServiceBean.saveActEconomicaActualBySolAfilWeb(actEconomicaSolAfilWeb);
        return rtaGenSaveActEcoSolAfilWeb;
    }

    @POST
    @Path("/SolicitudAfilWeb/getActEconByRadicado")
    public ActEconomicaSolAfilWeb getActEconByRadicado(@QueryParam("xsRadicado") String numRadicado) {
        Long idSolAfilWeb = new Long(numRadicado);
        return this.actEconoSolAfilWebServiceBean.findActEconomicaBySolAfilWeb(idSolAfilWeb);
    }

    @POST
    @Path("/SolicitudAfilWeb/saveOperMonedaExtBySolAfiWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveOperMonedaExtBySolAfiWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        respuestaGenerica rtaGenSaveOperMonedaExt = this.operMonedaExtSolAfilWebServiceBean.saveOperMonedaExtBySolAfiWeb(operMonedaExtSolAfilWeb);
        return rtaGenSaveOperMonedaExt;
    }

    @POST
    @Path("/SolicitudAfilWeb/getOperMonedaExtByRadicado")
    public OperMonedaExtSolAfilWeb getOperMonedaExtByRadicado(@QueryParam("xsRadicado") String numRadicado) {
        Long idSolAfilWeb = new Long(numRadicado);
        return this.operMonedaExtSolAfilWebServiceBean.findOperMonedaExtBySolAfilWeb(idSolAfilWeb);
    }

    @POST
    @Path("/SolicitudAfilWeb/saveInfoPensionadoBySolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveInfoPensionadoBySolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        respuestaGenerica rtaGenSaveInfoPensionado = this.infoPensionadoSolAfilWebServiceBean.saveInfoPensionadoBySolAfilWeb(infoPensionadoSolAfilWeb);
        return rtaGenSaveInfoPensionado;
    }

    @POST
    @Path("/SolicitudAfilWeb/getInfoPensionadoByRadicado")
    public InfoPensionadoSolAfilWeb getInfoPensionadoByRadicado(@QueryParam("xidSolAfilWeb") String xidSolAfilWeb) {
        Long xidSolAfilWebL = Long.parseLong(xidSolAfilWeb);
        InfoPensionadoSolAfilWeb ipsaw = this.infoPensionadoSolAfilWebServiceBean.findInfoPensionadoBySolAfilWeb(xidSolAfilWebL);
        return ipsaw;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveInfoConyugeBySolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveInfoConyugeBySolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        respuestaGenerica rtaGenSaveInfoConyuge = this.infoConyugeSolAfilWebServiceBean.saveInfoConyugeBySolAfilWeb(infoConyugeSolAfilWeb);
        return rtaGenSaveInfoConyuge;
    }

    @POST
    @Path("/SolicitudAfilWeb/getInfoConyugeByRadicado")
    public InfoConyugeSolAfilWeb getInfoConyugeByRadicado(@QueryParam("xsRadicado") String numRadicado) {
        Long idSolAfilWeb = new Long(numRadicado);
        InfoConyugeSolAfilWeb infoConyuge = this.infoConyugeSolAfilWebServiceBean.findInfoConyugeBySolAfilWeb(idSolAfilWeb);
        return infoConyuge;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveReferenciasBySolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveReferenciasBySolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        respuestaGenerica rtaGenSaveReferencias = this.referenciasSolAfilWebServiceBean.saveReferenciasBySolAfilWeb(referenciasSolAfilWeb);
        return rtaGenSaveReferencias;
    }

    @POST
    @Path("/SolicitudAfilWeb/getReferenciaByRadicado")
    public ReferenciasSolAfilWeb getReferenciaByRadicado(@QueryParam("xsRadicado") String numRadicado) {
        Long idSolAfilWeb = new Long(numRadicado);
        return this.referenciasSolAfilWebServiceBean.findReferenciasBySolAfilWeb(idSolAfilWeb);
    }

    @POST
    @Path("/SolicitudAfilWeb/saveDocumentoBySolAfilWeb")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica saveDocumentoBySolAfilWeb(DocumentoSolAfilWeb documentoSolAfilWeb) {
        respuestaGenerica rtaGenSaveDocumento = this.documentoSolAfilWebServiceBean.saveDocumentoBySolAfilWeb(documentoSolAfilWeb);
        return rtaGenSaveDocumento;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveDocsSolAfilWeb")
    public respuestaGenerica saveDocSolAfilWeb(RequestDocSolAfilWeb documentoSolAfilWeb) {
        respuestaGenerica rtaGenSaveDocumento = this.documentoSolAfilWebServiceBean.saveDocSolAfilWeb(documentoSolAfilWeb);
        return rtaGenSaveDocumento;
    }

    @POST
    @Path("/SolicitudAfilWeb/getDocsSolAfilWeb")
    public RequestDocSolAfilWeb getDocsSolAfilWeb(@QueryParam("xIdSolAfilWeb") String idSolAfilWeb) {
        RequestDocSolAfilWeb docSolAfilWeb = new RequestDocSolAfilWeb();
        List<DocumentoSolAfilWeb> rtaGenSaveDocumento = this.documentoSolAfilWebServiceBean.findDocumentoByIdSolAfilWeb(Long.parseLong(idSolAfilWeb));
        docSolAfilWeb.setListaDocumentos(rtaGenSaveDocumento);
        docSolAfilWeb.setCCursoCooperativismo(this.datoPersonalBean.findDatoPersonalBySolAfilWeb(Long.parseLong(idSolAfilWeb)).getCCursoCooperativismo());
        docSolAfilWeb.setCDeclaracionRenta(this.actEconoSolAfilWebServiceBean.findActEconomicaBySolAfilWeb(Long.parseLong(idSolAfilWeb)).getCDeclaracionRenta());
        return docSolAfilWeb;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveAutorizacionSolAfilWeb")
    public respuestaGenerica saveAutorizacionSolAfilWeb(RequestAutorizacionSolAfilWeb listAutorizaciones) {
        respuestaGenerica rtaGen = this.autorizacionSolAfilWebServiceBean.saveAutorizacionSolAfilWeb(listAutorizaciones);
        return rtaGen;
    }

    @GET
    @Path("/SolicitudAfilWeb/getAutorizacionesSolAfilWeb")
    public List<AutorizacionSolAfilWeb> getAutorizacionesSolAfilWeb(@QueryParam("xIdSolAfilWeb") Long idSolAfil) {
        return this.autorizacionSolAfilWebServiceBean.findAllAutizacionesByIdSolAfilWeb(idSolAfil);
    }

    @POST
    @Path("/SolicitudAfilWeb/saveCuentaSolAfilWeb")
    public respuestaGenerica saveCuentaSolAfilWeb(InscCuentaSolAfilWeb cuentaSolAfilWeb) {
        respuestaGenerica rtaGenSaveDocumento = this.cuentaSolAfilWebServiceBean.saveCuentaSolAfilWeb(cuentaSolAfilWeb);
        return rtaGenSaveDocumento;
    }

    @GET
    @Path("/SolicitudAfilWeb/getCuentaSolAfilWeb")
    public InscCuentaSolAfilWeb getCuentaSolAfilWeb(@QueryParam("xIdSolAfilWeb") Long idSolAfil) {
        return new InscCuentaSolAfilWebServiceBean().findInscCuentaByIdSol(idSolAfil);
    }

    @POST
    @Path("/SolicitudAfilWeb/saveEconomica")
    public respuestaGenerica saveEconomica(RequestEconomica requestEconomica) {
        respuestaGenerica g = new respuestaGenerica();
        g = this.actEconoSolAfilWebServiceBean.saveActEconomicaActualBySolAfilWeb(requestEconomica.getActEconomicaSolAfilWeb());
        if (g.getbRta()) {
            g = this.operMonedaExtSolAfilWebServiceBean.saveOperMonedaExtBySolAfiWeb(requestEconomica.getOperMonedaExtSolAfilWeb());
        }
        return g;
    }

    @POST
    @Path("/SolicitudAfilWeb/saveAutorizacionCuenta")
    public respuestaGenerica saveAutorizacionCuenta(RequestAutorizacionCuenta requestAutorizacionCuenta) {
        respuestaGenerica g = new respuestaGenerica();
        g = this.autorizacionSolAfilWebServiceBean.saveAutorizacionSolAfilWeb(requestAutorizacionCuenta.getListAutorizaciones());
        System.out.println("Cuenta " + requestAutorizacionCuenta.getCuentaSolAfilWeb());
        if (g.getbRta() && requestAutorizacionCuenta.getCuentaSolAfilWeb() != null) {
            g = this.cuentaSolAfilWebServiceBean.saveCuentaSolAfilWeb(requestAutorizacionCuenta.getCuentaSolAfilWeb());
        }
        return g;
    }

    @GET
    @Path("/SolicitudAfilWeb/getAll")
    public List<DatoPersonalSolAfilWeb> getAll() {
        return this.datoPersonalBean.listaDatoPersonal();
    }

    @GET
    @Path("/SolicitudAfilWeb/getSolAfilWeb")
    public SolicitudAfiliacionWeb getSolAfilWeb(@QueryParam("xIdSolAfilWeb") Long idSolAfil) {
        return this.solicitudAfiliacionWebServiceBean.findSolicitudAfiliacionWebById(idSolAfil);
    }

    @POST
    @Path("SolicitudAfilWeb/getTipoDireccion")
    public ResponseTipoDireccion getTipoDireccion() {
        return new TipoDireccionSolWebServiceBean().listarTiposDirecciones();
    }

    @POST
    @Path("SolicitudAfilWeb/getCompDireccion")
    public ResponseCompDireccion getCompDireccion() {
        return new TipoDireccionSolWebServiceBean().listarCompleDirecciones();
    }
    
    @POST
        @Path("SolicitudAfilWeb/cambiarEstadoSolicitudAfiliacion")
    public respuestaGenerica cambiarEstadoSolAfilWeb(RequestEstadoSolAfilWeb estadoSolAfilWeb){
        return new SolicitudAfiliacionWebServiceBean().radicarSolAfilWeb(estadoSolAfilWeb);
    }
    
    @POST
    @Path("SolicitudAfilWeb/Conyuge")
    public respuestaGenerica Conyuge (InfoConyugeSolAfilWeb conyuge){
        System.out.println("Entro a Conyuge: ");
        return new DatosConyugeServiceBean().UpdateDatosConyugue(conyuge);
    }

    /*@POST
    @Path("/SolicitudAfilWeb/saveAutorizacionCuenta")
    public respuestaGenerica saveAutorizacionCuenta(RequestAutorizacionCuenta requestAutorizacionCuenta) {
        respuestaGenerica g = new respuestaGenerica();
        g = this.autorizacionSolAfilWebServiceBean
                .saveAutorizacionSolAfilWeb(requestAutorizacionCuenta.getListAutorizaciones(), requestAutorizacionCuenta.getCIp(), requestAutorizacionCuenta.getCNavegador()
                );
        if (g.getbRta()) {
            g = this.cuentaSolAfilWebServiceBean.saveCuentaSolAfilWeb(requestAutorizacionCuenta.getCuentaSolAfilWeb());
        }
        return g;
    }*/
}
