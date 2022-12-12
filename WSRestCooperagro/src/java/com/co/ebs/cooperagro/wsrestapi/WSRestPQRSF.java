/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.DocumentoPqrsf;
import com.co.ebs.cooperagro.request.RequestGestionPQRSF;
import com.co.ebs.cooperagro.request.RequestRegistrarPQRSF;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCategoriaPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseListPqrsrf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSubCategoriaPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoEstadoPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoPQRSF;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.CategoriaPqrsfServiceBean;
import com.co.ebs.cooperagro.service.DocumentoPqrsfServiceBean;
import com.co.ebs.cooperagro.service.PqrsfServiceBean;
import com.co.ebs.cooperagro.service.SubCategoriaPqrsfServiceBean;
import com.co.ebs.cooperagro.service.SubCategoriaPqrsfServiceBean;
import com.co.ebs.cooperagro.service.TipoEstadoPqrsfServiceBean;
import com.co.ebs.cooperagro.service.TipoPQRSFServiceBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author YO
 */
@Path("WSRestAPI/WSPQRSF")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestPQRSF {

    @Context
    private UriInfo context;

    @GET()
    @Path("tipoPQRSF")
    public ResponseTipoPQRSF getTiposPQRSF() {
        TipoPQRSFServiceBean tipoPQRSFServiceBean = new TipoPQRSFServiceBean();
        return tipoPQRSFServiceBean.findAllTipoPqrsf();
    }

    @GET()
    @Path("categoriaPqrsf")
    public ResponseCategoriaPqrsf getCategoriaPqrsf() {
        CategoriaPqrsfServiceBean categoriaPqrsfServiceBean = new CategoriaPqrsfServiceBean();
        return categoriaPqrsfServiceBean.findAllCategoriaPqrsf();
    }
    
    @GET()
    @Path("subCategoriaPqrsf")
    public ResponseSubCategoriaPqrsf getSubCategoriaPqrsf(@QueryParam("codCategoria") Long codCategoria) {
        SubCategoriaPqrsfServiceBean SubCategoriaPqrsfServiceBean = new SubCategoriaPqrsfServiceBean();
        return SubCategoriaPqrsfServiceBean.findByCategoria(codCategoria);
    }

    @POST
    @Path("registrarPQRSF")
    public respuestaGenerica realizarRegistroPQRSF(RequestRegistrarPQRSF registrarPQRSF) {
        PqrsfServiceBean pqrsfServiceBean = new PqrsfServiceBean();
        return pqrsfServiceBean.realizarRegistroPQRSF(registrarPQRSF);

    }

    @GET
    @Path("obtenerListaPQRSF")
    public ResponseListPqrsrf obtenerListaPqrsf() {
        PqrsfServiceBean pqrsfServiceBean = new PqrsfServiceBean();
        return pqrsfServiceBean.obtenerListaPqrsf();
    }

    @GET
    @Path("obtenerListaEstadosPQRSF")
    public ResponseTipoEstadoPqrsf obtenerListaEstadosPqrsf() {
        TipoEstadoPqrsfServiceBean bean = new TipoEstadoPqrsfServiceBean();
        return bean.obtenerListaTipos();
    }

    @POST
    @Path("actualizarEstadoPQRSF")
    public respuestaGenerica actualizarEstadoPqrsf(RequestGestionPQRSF gestionPQRSF) {
        PqrsfServiceBean pqrsfServiceBean = new PqrsfServiceBean();
        return pqrsfServiceBean.updatePQRSF(gestionPQRSF);
    }

    @GET
    @Path("obtenerPQRSF")
    public ResponsePqrsf obtenerPqrsf(@QueryParam("iCodigo") Long iCodigo) {
        PqrsfServiceBean pqrsfServiceBean = new PqrsfServiceBean();
        return pqrsfServiceBean.obtenerPqrsfById(iCodigo);
    }
    
    @GET
    @Path("obtenerDocumentoPqrsf")
    public DocumentoPqrsf obtenerDocumentoPqrsf(@QueryParam("iCodigo") Long iCodigo) {
        return new DocumentoPqrsfServiceBean().findByIdPqrsf(iCodigo);
    }
}
