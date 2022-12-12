package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePreguntaActNoUtilizadas;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.PreguntasServiceBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("WSRestAPI/")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestPreguntaUsuario 
{

    @Context 
    private UriInfo context;
    
    /**
     * 
     */
    @POST
    @Path("servirPreguntasActivasNoUtilizadas")
    public ResponsePreguntaActNoUtilizadas servirPreguntasActivasNoUtilizadas(
            @QueryParam("xsTipoIdent")  String xsTipoIdent, 
            @QueryParam("xsIdent")      String xsIdent
        ) {
        
        PreguntasServiceBean bean = new PreguntasServiceBean();
        ResponsePreguntaActNoUtilizadas resultado = bean.preguntasActivasNoUtilizadas(xsTipoIdent, xsIdent, false);
        
        return resultado;
    }
    
    @POST @Consumes("application/json")
    @Path("actualizarPreguntasSeguridad")
    public respuestaGenerica actualizarPreguntasSeguridad (RequestRtaCuestionario request) {
        PreguntasServiceBean svc = new PreguntasServiceBean();
        return svc.actualizarPreguntasSeguridad(request);
    }
}
