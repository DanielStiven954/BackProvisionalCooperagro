/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.request.RequestGenerarDocPersona;
import com.co.ebs.cooperagro.request.RequestObligacionTerm;
import com.co.ebs.cooperagro.request.RequestReteFuente;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.security.Secured;
import com.co.ebs.cooperagro.service.EstadoCuentaCoreServiceBean;
import com.co.ebs.cooperagro.service.ExtractosAsociadoBean;
import com.co.ebs.cooperagro.service.ReteFuenteServiceBean;
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
 * @author YO
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestGeneracionDocumento { //GeneracionDocumento

    @Context
    private UriInfo context;

    
    @POST
    @Path("WSExtractosAsociado")
    public respuestaGenerica getExtractoAsociado(RequestGenerarDocPersona request) {
        System.out.println("RequestGenerarDocPersona: "+request);
        ExtractosAsociadoBean extractoBean = new ExtractosAsociadoBean();
        return extractoBean.obtenerExtractoAsociado(request);
    }
    
    @POST
    @Path("WSReteFuenteAsociado")
    public respuestaGenerica getReteFuente(RequestReteFuente requestReteFuente){
        ReteFuenteServiceBean fuenteServiceBean = new ReteFuenteServiceBean();
        return fuenteServiceBean.retencionFuentePDF(requestReteFuente);
    }
    
    @GET
    @Path("WSObtenerEstadoCuentaPdf")
    public respuestaGenerica obtenerEstadoCuenta(@QueryParam("xiCodUser") int xiCodUser) {
        EstadoCuentaCoreServiceBean estadoCuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return estadoCuentaCoreServiceBean.estadoCuentaPDF(xiCodUser);
    }

    @POST
    @Path("WSGenerarPazSalvoObligacion")
    public respuestaGenerica generarPazSalvoObligacion(RequestObligacionTerm obligacionTerm) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.generarPazSalvoObligacion(obligacionTerm);
    }
        
}
