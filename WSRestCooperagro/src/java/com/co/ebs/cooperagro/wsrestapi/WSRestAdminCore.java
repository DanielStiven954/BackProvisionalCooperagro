/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoPerfil;
import com.co.ebs.cooperagro.service.AdminCoreServiceBean;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.co.ebs.cooperagro.service.TipoPerfilServiceBean;
import com.co.ebs.cooperagro.wscore.*;
import javax.ws.rs.GET;
//import wsAdminCooperagro.*;
import WSAdminCooperagro.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Brian Cardenas
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestAdminCore {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestAdminCore
     */
    public WSRestAdminCore() {
    }

    /**
     * Retrieves representation of an instance of
     * com.co.ebs.cooperagro.wsrestapi.WSRestAdminCore
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("WSAdminCore/tipoPerfil")
    public ResponseTipoPerfil getTipoPerfil() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        try {
            TipoPerfilServiceBean tipoPerfilServiceBean = new TipoPerfilServiceBean();
            responseTipoPerfil = tipoPerfilServiceBean.listTipoPerfil();
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(Response.Status.NOT_FOUND).build();
        }
        return responseTipoPerfil;
    }

    @POST
    @Path("WSAdminCore/tipoPerfilEmpleados")
    public ResponseTipoPerfil getTipoPerfilEmpleados() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        try {
            TipoPerfilServiceBean tipoPerfilServiceBean = new TipoPerfilServiceBean();
            responseTipoPerfil = tipoPerfilServiceBean.listTipoPerfilNotInAsociados();
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(Response.Status.NOT_FOUND).build();
        }
        return responseTipoPerfil;
    }

    @POST
    @Path("WSAdminCore/tipoPerfilAsociados")
    public ResponseTipoPerfil getTipoPerfilAsociados() {
        ResponseTipoPerfil responseTipoPerfil = new ResponseTipoPerfil();
        try {
            TipoPerfilServiceBean tipoPerfilServiceBean = new TipoPerfilServiceBean();
            responseTipoPerfil = tipoPerfilServiceBean.listTipoPerfilAsociados();
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(Response.Status.NOT_FOUND).build();
        }
        return responseTipoPerfil;
    }

    @POST
    @Path("WSAdminCore/tipoPerfilById")
    public ResponseTipoPerfil getTipoPerfilById(@QueryParam("xiCod") int codigo) {
        TipoPerfilServiceBean tipoPerfilServiceBean = new TipoPerfilServiceBean();
        return tipoPerfilServiceBean.listTipoPerfilByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tiposIden")
    public ResponseTiposIdent getTipoIdent() {
        
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        
        return adminCoreServiceBean.wsTiposIdentHabilitados();
    }
    
    @POST
    @Path("WSAdminCore/tiposIdenSolAfil")
    public ResponseTiposIdent getTipoIdentSolAfil() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposIdentHabilitadosSolAfil();
    }

    @POST
    @Path("WSAdminCore/tiposIdenById")
    public ResponseTiposIdent getTipoIdentById(@QueryParam("xiCod") int codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposIdentByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tiposNivEstudio")
    public ResponseNivelesEstudio getTipoNivEstu() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposNivEstudio();
    }

    @POST
    @Path("WSAdminCore/tiposNivEstudioById")
    public ResponseNivelesEstudio getTipoNivEstuById(@QueryParam("xiCod") int codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposNivEstudioById(codigo);
    }

    @POST
    @Path("WSAdminCore/tipoEstadoCivil")
    public ResponseTipoEstadoCivil getTipoEstadoCivil() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoEstadoCivil();
    }

    @POST
    @Path("WSAdminCore/tipoEstadoCivilById")
    public ResponseTipoEstadoCivil getTipoEstadoCivilByID(@QueryParam("xsCod") String codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoEstadoCivilByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tipoActiEcon")
    public ResponseActividadEconomica getTipoActEcon() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoActEco();
    }

    @POST
    @Path("WSAdminCore/tipoActiEconByID")
    public ResponseActividadEconomica getTipoActEconById(@QueryParam("xiCod") int codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoActEcoByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tipoContrato")
    public ResponseTipoContrato getTipoContrato() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoContrato();
    }

    @POST
    @Path("WSAdminCore/tipoContratoByID")
    public ResponseTipoContrato getTipoContratoByID(@QueryParam("xiCod") int codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoContratoByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tipoPago")
    public ResponseTipoPago getTipoPago() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoPagoByID();
    }

    @POST
    @Path("WSAdminCore/tipoPagoByID")
    public ResponseTipoPago getTipoPagoByID(@QueryParam("xiCod") int codigo) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoPagoByID(codigo);
    }

    @POST
    @Path("WSAdminCore/tipoCiudad")
    public ResponseCiudad getCiudad() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsCiudad();
    }

    @POST
    @Path("WSAdminCore/tipoCiudadByParam")
    public ResponseCiudad getCiudadByParam(@QueryParam("xiCod") String xiCodigo, @QueryParam("xsNom") String nombre,
            @QueryParam("xiNiv") String nivel, @QueryParam("xiIndNal") String xi_ind_nal,
            @QueryParam("xiIndNalInt") String xi_ind_internal, @QueryParam("xiUbica") String xi_ubicacion) {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsCiudadByParam(xiCodigo, nombre, nivel, xi_ind_nal, xi_ind_internal, xi_ubicacion);
    }

//   WS para la solicitud de credito
    @POST
    @Path("WSAdminCore/periodos")
//    @Secured
    public ResponsePeriodo getPeriodos() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.obtenerPeriodicidadHabilitadasSolCred();
    }

    @POST
    @Path("WSAdminCore/lineasCredito")
//    @Secured
    public ResponseLineaCredito getLineaCredito() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsLineaCredito();
    }

    @POST
    @Path("WSAdminCore/lineasCreditoServicio")
//    @Secured
    public ResponseLineaCredito getLineaCreditoServicio() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsLineaCreditoServicio();
    }

    @POST
    @Path("WSAdminCore/entidadesBancarias")
    public ResponseEntidad getEntidades() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsEntidades();
    }

    @POST
    @Path("WSAdminCore/getCargos")
    public ResponseCargo getCargos() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsCargos();
    }

    @POST
    @Path("WSAdminCore/getProfesiones")
    public ResponseProfesion getProfesiones() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsProfesiones();
    }
    
}
