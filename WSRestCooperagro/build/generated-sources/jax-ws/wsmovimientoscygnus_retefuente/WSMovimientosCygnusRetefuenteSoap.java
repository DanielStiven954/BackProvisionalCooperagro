
package wsmovimientoscygnus_retefuente;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSMovimientosCygnus_RetefuenteSoap", targetNamespace = "WSMovimientosCygnus_retefuente")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSMovimientosCygnusRetefuenteSoap {


    /**
     * 
     * @param psBase
     * @param psFechaIni
     * @param psIdentificacion
     * @param psFechaFin
     * @param psClave
     * @param psUsuario
     * @return
     *     returns wsmovimientoscygnus_retefuente.RespuestaCert
     */
    @WebMethod(action = "WSMovimientosCygnus_retefuente/retefuente")
    @WebResult(name = "retefuenteResult", targetNamespace = "WSMovimientosCygnus_retefuente")
    @RequestWrapper(localName = "retefuente", targetNamespace = "WSMovimientosCygnus_retefuente", className = "wsmovimientoscygnus_retefuente.Retefuente")
    @ResponseWrapper(localName = "retefuenteResponse", targetNamespace = "WSMovimientosCygnus_retefuente", className = "wsmovimientoscygnus_retefuente.RetefuenteResponse")
    public RespuestaCert retefuente(
        @WebParam(name = "ps_identificacion", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psIdentificacion,
        @WebParam(name = "ps_fecha_ini", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psFechaIni,
        @WebParam(name = "ps_fecha_fin", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psFechaFin,
        @WebParam(name = "ps_base", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psBase,
        @WebParam(name = "ps_usuario", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psUsuario,
        @WebParam(name = "ps_clave", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psClave);

    /**
     * 
     * @param psBase
     * @param psFechaIni
     * @param psIdentificacion
     * @param psFechaFin
     * @param psClave
     * @param psUsuario
     * @return
     *     returns wsmovimientoscygnus_retefuente.RespuestaCert
     */
    @WebMethod(operationName = "retefuente_coopedac", action = "WSMovimientosCygnus_retefuente/retefuente_coopedac")
    @WebResult(name = "retefuente_coopedacResult", targetNamespace = "WSMovimientosCygnus_retefuente")
    @RequestWrapper(localName = "retefuente_coopedac", targetNamespace = "WSMovimientosCygnus_retefuente", className = "wsmovimientoscygnus_retefuente.RetefuenteCoopedac")
    @ResponseWrapper(localName = "retefuente_coopedacResponse", targetNamespace = "WSMovimientosCygnus_retefuente", className = "wsmovimientoscygnus_retefuente.RetefuenteCoopedacResponse")
    public RespuestaCert retefuenteCoopedac(
        @WebParam(name = "ps_identificacion", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psIdentificacion,
        @WebParam(name = "ps_fecha_ini", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psFechaIni,
        @WebParam(name = "ps_fecha_fin", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psFechaFin,
        @WebParam(name = "ps_base", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psBase,
        @WebParam(name = "ps_usuario", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psUsuario,
        @WebParam(name = "ps_clave", targetNamespace = "WSMovimientosCygnus_retefuente")
        String psClave);

}