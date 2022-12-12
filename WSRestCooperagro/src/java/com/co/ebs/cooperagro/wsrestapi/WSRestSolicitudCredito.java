/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.request.RequestSimuladorCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseDocSolCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSolicitudCredito;
import com.co.ebs.cooperagro.respuestasGenericas.SolicitudCreditoRta;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCupoMaximo;
import com.co.ebs.cooperagro.service.DocSolicitudCreditoServiceBean;
import com.co.ebs.cooperagro.service.SolicitudCreditoServiceBean;
import com.co.ebs.cooperagro.service.SimuladorCreditoServiceBean;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSimuladorCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSimuladorCreditoAtr;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan F Silva R
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestSolicitudCredito {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestSolicitudCredito
     */
    public WSRestSolicitudCredito() {
    }

    @POST
    @Path("/SolicitudCredito/validarSol")
    public ResponseSolicitudCredito validarSolicituCredito(@QueryParam("xData") String xData) {        
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.validarSolicitud(xData);
    }

    @POST
    @Path("/SolicitudCredito/saveSol")
    public ResponseSolicitudCredito crearSolicitud(@QueryParam("idSolCred") Long idSolCred, @QueryParam("idTipoCanal") Long idTipoCanal, @QueryParam("idTipoProducto") Long idTipoProducto, @QueryParam("xData") String xData) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.saveSolicitud(idSolCred, idTipoCanal, idTipoProducto, xData);
    }

    @Path("/SolicitudCredito/actualizarSolicitudCred")
    public respuestaGenerica actualizarSolicitudCred(@QueryParam("xData") String xData) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.actualizarSolicitudCredito(xData);
    }

    @POST
    @Path("/SolicitudCredito/radicarSolicitudCred")
    public respuestaGenerica radicarSolicitudCredito(@QueryParam("iCodSolCred") Long iCodSolCred, @QueryParam("iCodUser") Long iCodUser) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.radicarSolicitudCredito(iCodSolCred, iCodUser);
    }
    
    @POST
    @Path("/SolicitudCredito/radicarSolicitudCreditoAPP")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public respuestaGenerica radicarSolicitudCreditoAPP(SolicitudCredito xData, @QueryParam("iCodUser") Long iCodUser) {
            return  new SolicitudCreditoServiceBean().radicarSolicitudCreditoAPP(xData, iCodUser);
    }

    @POST
    @Path("/SolicitudCredito/saveAutorizacionesSolCred")
    public respuestaGenerica saveAutorizacionesSolCred(@QueryParam("xsData") String sData) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.saveAutorizacionesSolCred(sData);
    }

    @POST
    @Path("/SolicitudCredito/obtenerDocsSolCred")
    public List<ResponseDocSolCredito> obtenerDocsSolCred(@QueryParam("idSolCred") Long idSolCred) {
        DocSolicitudCreditoServiceBean docSolCreditoServiceBean = new DocSolicitudCreditoServiceBean();
        return docSolCreditoServiceBean.obtenerDocumentosSolCredByIdSolCred(idSolCred);
    }

    @POST
    @Path("/misCreditos/cargarSolicitudesCredito")
    public ResponseSolicitudCredito cargarSolCreditoByPersona(@QueryParam("xidPersona") Long idPersona) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.cargarSolCreditoByPersona(idPersona);
    }

    @POST
    @Path("/SolicitudCredito/saveDocSolicitudCredito")
    public respuestaGenerica saveDocSolicitudCredito(@QueryParam("xiTipoReqSolCred") Long iTipoReqSolCred, @QueryParam("xsUsuario") String iUsuario, @QueryParam("xsSolicitudCredito") String sSolicitudCredito, @QueryParam("xsObservaciones") String sObservaciones, @QueryParam("xsRutaFtp") String sRutaFTP, @QueryParam("xsNombreDoc") String sNombreDoc) {
        respuestaGenerica generica = new respuestaGenerica();
        DocSolicitudCreditoServiceBean docSolCreditoServiceBean = new DocSolicitudCreditoServiceBean();
        generica = docSolCreditoServiceBean.guardarDocSolCredBySolCred(iTipoReqSolCred, iUsuario, sObservaciones, sSolicitudCredito, sRutaFTP, sNombreDoc);
        return generica;
    }

    @POST
    @Path("/SolicitudCredito/updateDocSolicitudCredito")
    public respuestaGenerica updateDocSolicitudCredito(@QueryParam("xiTipoReqSolCred") Long iTipoReqSolCred, @QueryParam("xsUsuario") String iUsuario, @QueryParam("xsSolicitudCredito") String sSolicitudCredito, @QueryParam("xsObservaciones") String sObservaciones, @QueryParam("xsRutaFtp") String sRutaFTP, @QueryParam("xsNombreDoc") String sNombreDoc) {
        respuestaGenerica generica = new respuestaGenerica();
        DocSolicitudCreditoServiceBean docSolCreditoServiceBean = new DocSolicitudCreditoServiceBean();
        generica = docSolCreditoServiceBean.guardarDocSolCredBySolCred(iTipoReqSolCred, iUsuario, sObservaciones, sSolicitudCredito, sRutaFTP, sNombreDoc);
        return generica;
    }

    @POST
    @Path("/SolicitudCredito/detalleSolCredById")
    public SolicitudCreditoRta obtenerDetalleSolCredById(@QueryParam("xidSolCred") Long idSolCred, @QueryParam("xIdCurrentUser") Long xIdCurrentUser) {
        SolicitudCreditoServiceBean solCreditoServiceBean = new SolicitudCreditoServiceBean();
        return solCreditoServiceBean.obtenerDetalleSolCredById(idSolCred, xIdCurrentUser);
    }

    @POST
    @Path("/SolicitudCredito/calcularCuposMaximos")
    public ResponseCupoMaximo obtenerValoresMaximos(@QueryParam("xsIdentPersona") String sIdentPer, @QueryParam("xsCodCredito") String pwsCodCredi, @QueryParam("xiPeriodicidad") String pwsFormPeriodic, @QueryParam("codPersona") String codPersona, @QueryParam("pwsformpag") String pwsformpag) {
        System.out.println(" xsIdentPersona: "+sIdentPer);
        System.out.println(" xsCodCredito: "+pwsCodCredi);
        System.out.println(" pwsFormPeriodic: "+pwsFormPeriodic);
        System.out.println(" codPersona: "+codPersona);
        System.out.println(" pwsformpag: "+pwsformpag);
      
        
        return new SimuladorCreditoServiceBean().calcularCupoMaximo(sIdentPer, pwsCodCredi, pwsFormPeriodic, codPersona,pwsformpag);
    }

    @POST
    @Path("/SolicitudCredito/SimuladorCredito")
    public ResponseSimuladorCredito SimuladorCredito(RequestSimuladorCredito rsc) {
        return new SimuladorCreditoServiceBean().simuladorValorCuota(rsc.getsMonto(), rsc.getsNroCuota(), "0", rsc.getsCodCredito(), rsc.getsIdentificacion(), rsc.getXsFormaPeriodicidad(),rsc.gettPago(), "0", "0", "0", "0", "0", "0");
    }
    
    @POST
    @Path("/SolicitudCredito/SimuladorCreditoAtr")
    public ResponseSimuladorCreditoAtr SimuladorCreditoAtr(RequestSimuladorCredito rsc) {
        System.err.println("sMonto: "+rsc.getsMonto());
        System.err.println("sNroCuota: "+rsc.getsNroCuota());
        System.err.println("sCodCredito: "+rsc.getsCodCredito());
        System.err.println("sIdentificacion: "+rsc.getsIdentificacion());
        System.err.println("xsFormaPeriodicidad: "+rsc.getXsFormaPeriodicidad());
        System.err.println("tPago"+rsc.gettPago());
        return new SimuladorCreditoServiceBean().simuladorValorCuotaAtr(rsc.getsMonto(), rsc.getsNroCuota(), "0", rsc.getsCodCredito(), rsc.getsIdentificacion(), rsc.getXsFormaPeriodicidad(),rsc.gettPago(), "0", "0", "0", "0", "0", "0");
    }
    

}
