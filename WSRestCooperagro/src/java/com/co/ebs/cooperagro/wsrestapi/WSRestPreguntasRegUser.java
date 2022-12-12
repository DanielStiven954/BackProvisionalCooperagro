package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.PreguntaCreaUsu;
import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.ClaveAccesoUsuExtServiceBean;
import com.co.ebs.cooperagro.service.PreguntaCreaUsuServiceBean;
import java.math.BigInteger;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Brian Cardenas
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestPreguntasRegUser {

    @Context
    private UriInfo context;

    // ctor
    public WSRestPreguntasRegUser() {
    }

    // Obtengo 3 preguntas aleatorias de la tabla [pregunta_crea_usu] (PARA REGISTRO)
    @GET
    @Path("preguntasRegUserRandom")
    public List<PreguntaCreaUsu> PreguntasRegUsuRandom() {
        PreguntaCreaUsuServiceBean preguntasCreaUsuServiceBean = new PreguntaCreaUsuServiceBean();
        List<PreguntaCreaUsu> preguntaCreaUsus = preguntasCreaUsuServiceBean.PreguntasRegUsuRandom();
        return preguntaCreaUsus;
    }

    // Obtengo 3 pregunta_crea_usu's que se usan como match cuando se va a registrar un nuevo usuario
    @GET
    @Path("askRegForUser")
    public List<PreguntaCreaUsu> obtenerAskRegForUser(@QueryParam("xiTipoIden") int xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion) {
        PreguntaCreaUsuServiceBean preguntasCreaUsuServiceBean = new PreguntaCreaUsuServiceBean();
        List<PreguntaCreaUsu> preguntaCreaUsus = preguntasCreaUsuServiceBean.askWithAnswerRegUser(xiTipoIden, xcIdentificacion);
        return preguntaCreaUsus;
    }

    /*@GET
    @Path("ValidaskRegForUser")
    public respuestaGenerica validarAskRegForUser(@QueryParam("respPreg") String respPreg, @QueryParam("xiTipoIden") int xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion, @QueryParam("xiTipoCanal") String iTipoCanal) {
        PreguntaCreaUsuServiceBean preguntasCreaUsuServiceBean = new PreguntaCreaUsuServiceBean();
        respuestaGenerica validarRespuesta = preguntasCreaUsuServiceBean.validarRtasPregRegistroUsuario(respPreg, xiTipoIden, xcIdentificacion, iTipoCanal);
        return validarRespuesta;
    }*/

    @POST
    @Path("ValidaskRegForUserPost")
    public respuestaGenerica validarAskRegForUserPost(RequestRtaCuestionario requestRtaCuestionario) {
        PreguntaCreaUsuServiceBean preguntasCreaUsuServiceBean = new PreguntaCreaUsuServiceBean();
        respuestaGenerica validarRespuesta = preguntasCreaUsuServiceBean.validarRtasPregRegistroUsuario2(requestRtaCuestionario);
        return validarRespuesta;
    }

    @POST
    @Path("validarCodigoVerificacion")
    public respuestaGenerica validarCodVerficacion(@QueryParam("xiTipoIden") int xiTipoIden, @QueryParam("xcIdentificacion") String xcIdentificacion, @QueryParam("xcCodVerificacion") String sCodVerificacion, @QueryParam("xcClave") String sClave, @QueryParam("xiTipoCanal") int iTipoCanal) {
        respuestaGenerica rtaGenericaValCodVerif = new respuestaGenerica();
        String sTipoIdent = String.valueOf(xiTipoIden);
        ClaveAccesoUsuExtServiceBean claveAccesoUsuExtServiceBean = new ClaveAccesoUsuExtServiceBean();
        rtaGenericaValCodVerif = claveAccesoUsuExtServiceBean.validarCodigoVerificacion(new BigInteger(sTipoIdent), xcIdentificacion, sCodVerificacion, sClave, xiTipoIden);
        return rtaGenericaValCodVerif;
    }
}
