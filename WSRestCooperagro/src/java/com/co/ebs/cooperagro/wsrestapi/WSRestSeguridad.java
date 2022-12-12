/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseParametros;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.security.Secured;
import com.co.ebs.cooperagro.service.AccesoServiceBean;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.co.ebs.cooperagro.service.UsuarioServiceBean;
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
@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestSeguridad {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestSeguridad
     */
    public WSRestSeguridad() {
    }

    @POST
//    @Secured
    @Path("Asociado/CambiarPrimeraClave")
    public respuestaGenerica cambiarPrimeraClave(@QueryParam("xCodUsuario") String xCodUsuario,
            @QueryParam("xClaveAntigua") String xClaveAntigua,
            @QueryParam("xClaveNueva") String xClaveNueva,
            @QueryParam("xClaveNuevaConf") String xClaveNuevaConf, @QueryParam("xiTipoCanal") int iTipoCanal) {
        AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
        return accesoServiceBean.cambiarPrimeraClave(xCodUsuario, xClaveAntigua, xClaveNueva, xClaveNuevaConf, iTipoCanal);
    }

    @POST
//    @Secured
    @Path("Asociado/ParametrosCambioClave")
    public ResponseParametros parametrosCambioClave() {
        ParametroServiceBean param = new ParametroServiceBean();
        return param.parametrosClave();
    }

}
