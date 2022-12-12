/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.AccesoServiceBean;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brian Cardenas
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestAcceso {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestAcceso
     */
    public WSRestAcceso() {
    }

    @POST
    @Path("loginPostCreateNewUser")
    public String loginRegistroNuevoUsuario(@QueryParam("xiTipoIden") int xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion, @QueryParam("xcClave") String xcClave, @QueryParam("xiTipoCanal") String xiTipoCanal) {
        String sJSON_Rta = "";
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        sJSON_Rta = accesoServiceBean.loginRegistroNuevoUsuario(xiTipoIden, xcIdentificacion, "1", xcClave, xiTipoCanal);
        return sJSON_Rta;
    }

    @POST
    @Path("loginAdmin")
    public String loginAdmin(@QueryParam("iTipoPerfil") int iPerfil,
            @QueryParam("xiTipoIden") int xiTipoIden,
            @QueryParam("xcIdentificacion") String xcIdentificacion,
            @QueryParam("xcClave") String xcClave,
            @QueryParam("xcNavegador") String xcNavegador,
            @QueryParam("xiTipoCanal") String xiTipoCanal) {
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        return accesoServiceBean.validarLoginAdmin(iPerfil, xiTipoIden, xcIdentificacion, "1", xcClave, xcNavegador, xiTipoCanal);
    }

    @GET
    @Path("loginUsuario")
    public String loginUsuario(@QueryParam("xiTipoIden") int xiTipoIden,
            @QueryParam("xcIdentificacion") String xcIdentificacion,
            @QueryParam("xcClave") String xcClave,
            @QueryParam("xcNavegador") String xcNavegador,
            @QueryParam("xiTipoCanal") String xiTipoCanal) {
        System.out.println("xiTipoIden "+xiTipoIden);
        System.out.println("xcIdentificacion "+ xcIdentificacion);
        System.out.println("xcClave "+ xcClave);
        System.out.println("xcNavegador "+ xcNavegador);
        System.out.println("xiTipoCanal "+ xiTipoCanal);
        
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        return accesoServiceBean.validarLoginUsuario(xiTipoIden, xcIdentificacion, "1", xcClave, xcNavegador, xiTipoCanal);
    }

    @GET
    @Path("validarPersona")
    public Persona validarPersona(@QueryParam("xiTipoIden") int xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion) {
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        Persona valperson = accesoServiceBean.validarPersona(xiTipoIden, xcIdentificacion);
        return valperson;
    }

    @GET
    @Path("CerrarSession")
    public respuestaGenerica cerrarSession(@QueryParam("iUsuario") long xiUsuario) {
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        return accesoServiceBean.cerrarSession(xiUsuario);
    }

}
