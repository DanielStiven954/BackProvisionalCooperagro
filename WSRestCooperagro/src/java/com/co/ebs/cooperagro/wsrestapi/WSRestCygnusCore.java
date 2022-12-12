/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.service.CygnusCoreServiceBean;
import com.ebssas.PersonasDTO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Brian Cardenas
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestCygnusCore {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestCygnusCore
     */
    public WSRestCygnusCore() {
    }

    /**
     * Retrieves representation of an instance of
     * com.co.ebs.cooperagro.wsrestapi.WSRestCygnusCore
     *
     * @param xiCodigo
     * @param xiTipoIden
     * @param xcIdentificacion
     * @return an instance of java.lang.String
     */
    @GET
    @Path("WSCygnusCore/consPersona")
    public List<PersonasDTO> getConsPersona(@QueryParam("xiCodigo") String xiCodigo, @QueryParam("xiTipoIden") String xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion) {
        return new CygnusCoreServiceBean().wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
    }

}
