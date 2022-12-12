/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseOlvidoClave;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.UsuarioServiceBean;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service Olvido Clave
 *
 * @author Brayan F Silva R
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestOlvidoClave {

    private final UsuarioServiceBean usuarioServiceBean;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestOlvidoClave
     */
    public WSRestOlvidoClave() {
        this.usuarioServiceBean = new UsuarioServiceBean();
    }

    @POST
    @Path("validaOlvidoClave")
    public ResponseOlvidoClave validarOlvidoClave(@QueryParam("xsData") String xsData,@QueryParam("xiTipoCanal") String iTipoCanal) {
        ResponseOlvidoClave usuarioValidaOlvClave = usuarioServiceBean.validaOlvidoClave(xsData,Long.parseLong(iTipoCanal));
        return usuarioValidaOlvClave;
    }

    @POST
    @Path("generarNuevaClaveWeb")
    public respuestaGenerica generarNuevaClave(@QueryParam("xsData") String xsData) {
        System.out.println("Entro a Validar Clave");
        respuestaGenerica rtaGenerica = usuarioServiceBean.generarClaveNueva(xsData);
        return rtaGenerica;

    }
}
