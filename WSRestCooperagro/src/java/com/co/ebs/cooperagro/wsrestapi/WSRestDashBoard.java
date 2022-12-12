/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorCartera;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorColocacion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorRetiro;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorVinculacion;
import com.co.ebs.cooperagro.service.CygnusCoreServiceBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Jonathan Ruge
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestDashBoard {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestDashBoard
     */
    public WSRestDashBoard() {
    }

    @POST
    @Path("WSRestDashBoard/getIndicadorVinculacion")
    public ResponseIndicadorVinculacion getIndicadorVinculacion(@QueryParam("xsFechaInicio") String xsFechaInicio, @QueryParam("xsFechaFin") String xsFechaFin) {
        ResponseIndicadorVinculacion responseIndicadorVinculacion = new CygnusCoreServiceBean().getIndicadorVinculacion(xsFechaInicio, xsFechaFin);
        return responseIndicadorVinculacion;
    }

    @POST
    @Path("WSRestDashBoard/getIndicadorRetiro")
    public ResponseIndicadorRetiro getIndicadorRetiro(@QueryParam("xsFechaInicio") String xsFechaInicio, @QueryParam("xsFechaFin") String xsFechaFin) {
        ResponseIndicadorRetiro responseIndicadorRetiro = new CygnusCoreServiceBean().getIndicadorRetiro(xsFechaInicio, xsFechaFin);
        return responseIndicadorRetiro;
    }

    @POST
    @Path("WSRestDashBoard/getIndicadorCartera")
    public ResponseIndicadorCartera getIndicadorCartera(@QueryParam("xsFechaCorte") String xsFechaCorte) {
        ResponseIndicadorCartera responseIndicadorCartera = new CygnusCoreServiceBean().getIndicadorCartera(xsFechaCorte);
        return responseIndicadorCartera;
    }

    @POST
    @Path("WSRestDashBoard/getIndicadorColocacion")
    public ResponseIndicadorColocacion getIndicadorColocacion(@QueryParam("xsFechaInicio") String xsFechaInicio, @QueryParam("xsFechaFin") String xsFechaFin) {
        ResponseIndicadorColocacion responseIndicadorColocacion = new CygnusCoreServiceBean().getIndicadorColocacion(xsFechaInicio, xsFechaFin);
        return responseIndicadorColocacion;
    }
}
