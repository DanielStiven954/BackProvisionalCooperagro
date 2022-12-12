/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseInfoUsuarioSimulador;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseInformacionUsuario;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.AccesoService;
import com.co.ebs.cooperagro.service.AccesoServiceBean;
import com.co.ebs.cooperagro.service.AccesoUsuarioServiceBean;
import com.co.ebs.cooperagro.service.InformacionPersonaServiceBean;
import com.co.ebs.cooperagro.service.UsuarioServiceBean;
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
 * @author Jonathan Ruge
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSInformacionUsuario {

    @Context
    private UriInfo context;

    @POST
    @Path("WSInformacionUsuario/getInformacionUsuario")
    public ResponseInformacionUsuario getInformacionUsuario(@QueryParam("xsCodigo") String xsCodigo, @QueryParam("xsTipoIdent") String xsTipoIdent, @QueryParam("xsIdent") String xIdent) {
        InformacionPersonaServiceBean informacion = new InformacionPersonaServiceBean();
        return informacion.informacionUsuario(xsCodigo, xsTipoIdent, xIdent);
    }

    @POST
    @Path("WSInformacionUsuario/getInformacionUsuarioSimulador")
    public ResponseInfoUsuarioSimulador getInformacionUsuarioSimulador(@QueryParam("xsCodigo") String xsCodigo) {
        InformacionPersonaServiceBean informacion = new InformacionPersonaServiceBean();
        return informacion.informacionUsuarioSimulador(xsCodigo);
    }

    @POST
    @Path("WSInformacionUsuario/listarUsuarios")
    public ResponseInformacionUsuario buscarTodosUsuarios() {
        UsuarioServiceBean usuarioBean = new UsuarioServiceBean();
        return usuarioBean.listarUsuarios();
    }

    @POST
    @Path("WSInformacionUsuario/DesbloquearUsuario")
    public respuestaGenerica desbloquearUsuario(@QueryParam("xCodUsuario") String xCodUsuario) {
        AccesoUsuarioServiceBean accesoUsuarioServiceBean = new AccesoUsuarioServiceBean();
        return accesoUsuarioServiceBean.desbloquearUsuario(xCodUsuario);
    }

    @POST
    @Path("WSInformacionUsuario/restaurarUsuario")
    public respuestaGenerica restaurarClaveUsuario(@QueryParam("xCodUsuario") String xCodUsuario) {
        return new AccesoServiceBean().restaurarClave(Long.valueOf(xCodUsuario));
    }

    @POST
    @Path("WSInformacionUsuario/restaurarClave")
    public respuestaGenerica restaurarClave(@QueryParam("xCodUsuario") String xCodUsuario) {
        return new AccesoServiceBean().restaurarClaveNueva(Long.valueOf(xCodUsuario));

    }

}
