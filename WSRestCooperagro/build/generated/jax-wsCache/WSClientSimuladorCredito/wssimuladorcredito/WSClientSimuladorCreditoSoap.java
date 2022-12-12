
package wssimuladorcredito;

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
@WebService(name = "WSClientSimuladorCreditoSoap", targetNamespace = "WSSimuladorCredito")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSClientSimuladorCreditoSoap {


    /**
     * 
     * @param pwsIdentific
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsFormaPago
     * @param pwsMonto
     * @param pwsBd
     * @param pwsFecTf3
     * @param pwsFecTf2
     * @param pwsFechaSol
     * @param pwsCodCredi
     * @param pwsFormPlazo
     * @param pwsFormPeriodic
     * @param pwsValTf2
     * @param pwsValTf1
     * @param pwsNroCuotas
     * @param pwsValRecog
     * @param pwsFecTf1
     * @param pwsValTf3
     * @return
     *     returns wssimuladorcredito.Respuesta
     */
    @WebMethod(operationName = "WS_CONSULTA_LIQUIDACION", action = "WSSimuladorCredito/WS_CONSULTA_LIQUIDACION")
    @WebResult(name = "WS_CONSULTA_LIQUIDACIONResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_CONSULTA_LIQUIDACION", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTALIQUIDACION")
    @ResponseWrapper(localName = "WS_CONSULTA_LIQUIDACIONResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTALIQUIDACIONResponse")
    public Respuesta wsCONSULTALIQUIDACION(
        @WebParam(name = "pws_monto", targetNamespace = "WSSimuladorCredito")
        String pwsMonto,
        @WebParam(name = "pws_nro_cuotas", targetNamespace = "WSSimuladorCredito")
        String pwsNroCuotas,
        @WebParam(name = "pws_fecha_sol", targetNamespace = "WSSimuladorCredito")
        String pwsFechaSol,
        @WebParam(name = "pws_val_recog", targetNamespace = "WSSimuladorCredito")
        String pwsValRecog,
        @WebParam(name = "pws_cod_credi", targetNamespace = "WSSimuladorCredito")
        String pwsCodCredi,
        @WebParam(name = "pws_form_plazo", targetNamespace = "WSSimuladorCredito")
        String pwsFormPlazo,
        @WebParam(name = "pws_identific", targetNamespace = "WSSimuladorCredito")
        String pwsIdentific,
        @WebParam(name = "pws_form_periodic", targetNamespace = "WSSimuladorCredito")
        String pwsFormPeriodic,
        @WebParam(name = "pws_forma_pago", targetNamespace = "WSSimuladorCredito")
        String pwsFormaPago,
        @WebParam(name = "pws_val_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsValTf1,
        @WebParam(name = "pws_fec_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf1,
        @WebParam(name = "pws_val_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsValTf2,
        @WebParam(name = "pws_fec_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf2,
        @WebParam(name = "pws_val_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsValTf3,
        @WebParam(name = "pws_fec_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf3,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsEstadoSolicitud
     * @param pwsIdentific
     * @param pwsNumSolicitud
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsFormaPago
     * @param pwsMonto
     * @param pwsBd
     * @param pwsEstadoCredito
     * @param pwsFecTf3
     * @param pwsFecTf2
     * @param pwsFechaSol
     * @param pwsCodCredi
     * @param pwsFormPlazo
     * @param pwsFormPeriodic
     * @param pwsDescripcion
     * @param pwsValTf2
     * @param pwsValTf1
     * @param pwsNroCuotas
     * @param pwsValRecog
     * @param pwsFecTf1
     * @param pwsValTf3
     * @return
     *     returns wssimuladorcredito.RespuestaCrea
     */
    @WebMethod(operationName = "WS_CREA_CREDITO", action = "WSSimuladorCredito/WS_CREA_CREDITO")
    @WebResult(name = "WS_CREA_CREDITOResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_CREA_CREDITO", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCREACREDITO")
    @ResponseWrapper(localName = "WS_CREA_CREDITOResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCREACREDITOResponse")
    public RespuestaCrea wsCREACREDITO(
        @WebParam(name = "pws_monto", targetNamespace = "WSSimuladorCredito")
        String pwsMonto,
        @WebParam(name = "pws_nro_cuotas", targetNamespace = "WSSimuladorCredito")
        String pwsNroCuotas,
        @WebParam(name = "pws_fecha_sol", targetNamespace = "WSSimuladorCredito")
        String pwsFechaSol,
        @WebParam(name = "pws_val_recog", targetNamespace = "WSSimuladorCredito")
        String pwsValRecog,
        @WebParam(name = "pws_cod_credi", targetNamespace = "WSSimuladorCredito")
        String pwsCodCredi,
        @WebParam(name = "pws_form_plazo", targetNamespace = "WSSimuladorCredito")
        String pwsFormPlazo,
        @WebParam(name = "pws_identific", targetNamespace = "WSSimuladorCredito")
        String pwsIdentific,
        @WebParam(name = "pws_form_periodic", targetNamespace = "WSSimuladorCredito")
        String pwsFormPeriodic,
        @WebParam(name = "pws_forma_pago", targetNamespace = "WSSimuladorCredito")
        String pwsFormaPago,
        @WebParam(name = "pws_val_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsValTf1,
        @WebParam(name = "pws_fec_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf1,
        @WebParam(name = "pws_val_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsValTf2,
        @WebParam(name = "pws_fec_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf2,
        @WebParam(name = "pws_val_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsValTf3,
        @WebParam(name = "pws_fec_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf3,
        @WebParam(name = "pws_num_solicitud", targetNamespace = "WSSimuladorCredito")
        String pwsNumSolicitud,
        @WebParam(name = "pws_estado_credito", targetNamespace = "WSSimuladorCredito")
        String pwsEstadoCredito,
        @WebParam(name = "pws_estado_solicitud", targetNamespace = "WSSimuladorCredito")
        String pwsEstadoSolicitud,
        @WebParam(name = "pws_descripcion", targetNamespace = "WSSimuladorCredito")
        String pwsDescripcion,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsNumRadic
     * @param pwsNumPagare
     * @param pwsValorComision
     * @param pwsSemestre
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsMatricula
     * @param pwsBd
     * @param pwsValorPagare
     * @param pwsAutorizacion
     * @param pwsAprobacion
     * @param pwsPorcComision
     * @param pwsFechaCuota
     * @param pwsNumCuota
     * @return
     *     returns wssimuladorcredito.RespuestaRegistro
     */
    @WebMethod(operationName = "WS_regPagareCredito", action = "WSSimuladorCredito/WS_regPagareCredito")
    @WebResult(name = "WS_regPagareCreditoResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_regPagareCredito", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRegPagareCredito")
    @ResponseWrapper(localName = "WS_regPagareCreditoResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRegPagareCreditoResponse")
    public RespuestaRegistro wsRegPagareCredito(
        @WebParam(name = "pws_numRadic", targetNamespace = "WSSimuladorCredito")
        String pwsNumRadic,
        @WebParam(name = "pws_numCuota", targetNamespace = "WSSimuladorCredito")
        String pwsNumCuota,
        @WebParam(name = "pws_numPagare", targetNamespace = "WSSimuladorCredito")
        String pwsNumPagare,
        @WebParam(name = "pws_valorPagare", targetNamespace = "WSSimuladorCredito")
        String pwsValorPagare,
        @WebParam(name = "pws_fechaCuota", targetNamespace = "WSSimuladorCredito")
        String pwsFechaCuota,
        @WebParam(name = "pws_autorizacion", targetNamespace = "WSSimuladorCredito")
        String pwsAutorizacion,
        @WebParam(name = "pws_aprobacion", targetNamespace = "WSSimuladorCredito")
        String pwsAprobacion,
        @WebParam(name = "pws_porcComision", targetNamespace = "WSSimuladorCredito")
        String pwsPorcComision,
        @WebParam(name = "pws_valorComision", targetNamespace = "WSSimuladorCredito")
        String pwsValorComision,
        @WebParam(name = "pws_matricula", targetNamespace = "WSSimuladorCredito")
        String pwsMatricula,
        @WebParam(name = "pws_semestre", targetNamespace = "WSSimuladorCredito")
        String pwsSemestre,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsNumRadic
     * @param pwsIdentific
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsBd
     * @return
     *     returns wssimuladorcredito.RespuestaCrea
     */
    @WebMethod(operationName = "WS_codeudorCredito", action = "WSSimuladorCredito/WS_codeudorCredito")
    @WebResult(name = "WS_codeudorCreditoResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_codeudorCredito", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCodeudorCredito")
    @ResponseWrapper(localName = "WS_codeudorCreditoResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCodeudorCreditoResponse")
    public RespuestaCrea wsCodeudorCredito(
        @WebParam(name = "pws_num_radic", targetNamespace = "WSSimuladorCredito")
        String pwsNumRadic,
        @WebParam(name = "pws_identific", targetNamespace = "WSSimuladorCredito")
        String pwsIdentific,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsNumRadic
     * @param pwsValorComision
     * @param pwsSemestre
     * @param pwsCodBanco
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsMatricula
     * @param pwsBd
     * @param pwsAutorizacion
     * @param pwsAprobacion
     * @param pwsNumCta
     * @param pwsEntidad
     * @param pwsPorcComision
     * @param pwsValorCheque
     * @param pwsNumCheque
     * @param pwsFechaCuota
     * @param pwsGirador
     * @param pwsNumCuota
     * @return
     *     returns wssimuladorcredito.RespuestaRegistro
     */
    @WebMethod(operationName = "WS_regChequeCredito", action = "WSSimuladorCredito/WS_regChequeCredito")
    @WebResult(name = "WS_regChequeCreditoResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_regChequeCredito", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRegChequeCredito")
    @ResponseWrapper(localName = "WS_regChequeCreditoResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRegChequeCreditoResponse")
    public RespuestaRegistro wsRegChequeCredito(
        @WebParam(name = "pws_numRadic", targetNamespace = "WSSimuladorCredito")
        String pwsNumRadic,
        @WebParam(name = "pws_numCuota", targetNamespace = "WSSimuladorCredito")
        String pwsNumCuota,
        @WebParam(name = "pws_CodBanco", targetNamespace = "WSSimuladorCredito")
        String pwsCodBanco,
        @WebParam(name = "pws_numCheque", targetNamespace = "WSSimuladorCredito")
        String pwsNumCheque,
        @WebParam(name = "pws_valorCheque", targetNamespace = "WSSimuladorCredito")
        String pwsValorCheque,
        @WebParam(name = "pws_fechaCuota", targetNamespace = "WSSimuladorCredito")
        String pwsFechaCuota,
        @WebParam(name = "pws_numCta", targetNamespace = "WSSimuladorCredito")
        String pwsNumCta,
        @WebParam(name = "pws_entidad", targetNamespace = "WSSimuladorCredito")
        String pwsEntidad,
        @WebParam(name = "pws_autorizacion", targetNamespace = "WSSimuladorCredito")
        String pwsAutorizacion,
        @WebParam(name = "pws_girador", targetNamespace = "WSSimuladorCredito")
        String pwsGirador,
        @WebParam(name = "pws_aprobacion", targetNamespace = "WSSimuladorCredito")
        String pwsAprobacion,
        @WebParam(name = "pws_matricula", targetNamespace = "WSSimuladorCredito")
        String pwsMatricula,
        @WebParam(name = "pws_porcComision", targetNamespace = "WSSimuladorCredito")
        String pwsPorcComision,
        @WebParam(name = "pws_valorComision", targetNamespace = "WSSimuladorCredito")
        String pwsValorComision,
        @WebParam(name = "pws_semestre", targetNamespace = "WSSimuladorCredito")
        String pwsSemestre,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsNumRadic
     * @param pwsFechaPag
     * @param pwsPsw
     * @param pwsCodDesem
     * @param pwsUsu
     * @param pwsBd
     * @param pwsCodDesti
     * @return
     *     returns wssimuladorcredito.RespuestaCuotas
     */
    @WebMethod(operationName = "WS_CONSULTA_VALPRIMERACUOTA", action = "WSSimuladorCredito/WS_CONSULTA_VALPRIMERACUOTA")
    @WebResult(name = "WS_CONSULTA_VALPRIMERACUOTAResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_CONSULTA_VALPRIMERACUOTA", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTAVALPRIMERACUOTA")
    @ResponseWrapper(localName = "WS_CONSULTA_VALPRIMERACUOTAResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTAVALPRIMERACUOTAResponse")
    public RespuestaCuotas wsCONSULTAVALPRIMERACUOTA(
        @WebParam(name = "pws_num_radic", targetNamespace = "WSSimuladorCredito")
        String pwsNumRadic,
        @WebParam(name = "pws_cod_desti", targetNamespace = "WSSimuladorCredito")
        String pwsCodDesti,
        @WebParam(name = "pws_cod_desem", targetNamespace = "WSSimuladorCredito")
        String pwsCodDesem,
        @WebParam(name = "pws_fecha_pag", targetNamespace = "WSSimuladorCredito")
        String pwsFechaPag,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsIdentific
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsFormaPago
     * @param pwsMonto
     * @param pwsBd
     * @param pwsFecTf3
     * @param pwsFecTf2
     * @param pwsFechaSol
     * @param pwsCodCredi
     * @param pwsFormPlazo
     * @param pwsFormPeriodic
     * @param pwsValTf2
     * @param pwsValTf1
     * @param pwsNroCuotas
     * @param pwsValRecog
     * @param pwsFecTf1
     * @param pwsValTf3
     * @return
     *     returns wssimuladorcredito.RespuestaAtr
     */
    @WebMethod(operationName = "WS_CONSULTA_LIQUIDACIONATR", action = "WSSimuladorCredito/WS_CONSULTA_LIQUIDACIONATR")
    @WebResult(name = "WS_CONSULTA_LIQUIDACIONATRResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_CONSULTA_LIQUIDACIONATR", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTALIQUIDACIONATR")
    @ResponseWrapper(localName = "WS_CONSULTA_LIQUIDACIONATRResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSCONSULTALIQUIDACIONATRResponse")
    public RespuestaAtr wsCONSULTALIQUIDACIONATR(
        @WebParam(name = "pws_monto", targetNamespace = "WSSimuladorCredito")
        String pwsMonto,
        @WebParam(name = "pws_nro_cuotas", targetNamespace = "WSSimuladorCredito")
        String pwsNroCuotas,
        @WebParam(name = "pws_fecha_sol", targetNamespace = "WSSimuladorCredito")
        String pwsFechaSol,
        @WebParam(name = "pws_val_recog", targetNamespace = "WSSimuladorCredito")
        String pwsValRecog,
        @WebParam(name = "pws_cod_credi", targetNamespace = "WSSimuladorCredito")
        String pwsCodCredi,
        @WebParam(name = "pws_form_plazo", targetNamespace = "WSSimuladorCredito")
        String pwsFormPlazo,
        @WebParam(name = "pws_identific", targetNamespace = "WSSimuladorCredito")
        String pwsIdentific,
        @WebParam(name = "pws_form_periodic", targetNamespace = "WSSimuladorCredito")
        String pwsFormPeriodic,
        @WebParam(name = "pws_forma_pago", targetNamespace = "WSSimuladorCredito")
        String pwsFormaPago,
        @WebParam(name = "pws_val_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsValTf1,
        @WebParam(name = "pws_fec_tf1", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf1,
        @WebParam(name = "pws_val_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsValTf2,
        @WebParam(name = "pws_fec_tf2", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf2,
        @WebParam(name = "pws_val_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsValTf3,
        @WebParam(name = "pws_fec_tf3", targetNamespace = "WSSimuladorCredito")
        String pwsFecTf3,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsTipo
     * @param pwsNumDocumento
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsBd
     * @return
     *     returns wssimuladorcredito.RespuestaRegistro
     */
    @WebMethod(operationName = "WS_RadicadoPagareCheque", action = "WSSimuladorCredito/WS_RadicadoPagareCheque")
    @WebResult(name = "WS_RadicadoPagareChequeResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "WS_RadicadoPagareCheque", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRadicadoPagareCheque")
    @ResponseWrapper(localName = "WS_RadicadoPagareChequeResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.WSRadicadoPagareChequeResponse")
    public RespuestaRegistro wsRadicadoPagareCheque(
        @WebParam(name = "pws_tipo", targetNamespace = "WSSimuladorCredito")
        String pwsTipo,
        @WebParam(name = "pws_numDocumento", targetNamespace = "WSSimuladorCredito")
        String pwsNumDocumento,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

    /**
     * 
     * @param pwsCodCredi
     * @param pwsFormPlazo
     * @param pwsFormPeriodic
     * @param pwsIdentific
     * @param pwsFormPag
     * @param pwsPsw
     * @param pwsUsu
     * @param pwsBd
     * @return
     *     returns wssimuladorcredito.RespuestaCupo
     */
    @WebMethod(action = "WSSimuladorCredito/calculoCupos")
    @WebResult(name = "calculoCuposResult", targetNamespace = "WSSimuladorCredito")
    @RequestWrapper(localName = "calculoCupos", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.CalculoCupos")
    @ResponseWrapper(localName = "calculoCuposResponse", targetNamespace = "WSSimuladorCredito", className = "wssimuladorcredito.CalculoCuposResponse")
    public RespuestaCupo calculoCupos(
        @WebParam(name = "pws_identific", targetNamespace = "WSSimuladorCredito")
        String pwsIdentific,
        @WebParam(name = "pws_form_periodic", targetNamespace = "WSSimuladorCredito")
        String pwsFormPeriodic,
        @WebParam(name = "pws_cod_credi", targetNamespace = "WSSimuladorCredito")
        String pwsCodCredi,
        @WebParam(name = "pws_form_plazo", targetNamespace = "WSSimuladorCredito")
        String pwsFormPlazo,
        @WebParam(name = "pws_form_pag", targetNamespace = "WSSimuladorCredito")
        String pwsFormPag,
        @WebParam(name = "pws_bd", targetNamespace = "WSSimuladorCredito")
        String pwsBd,
        @WebParam(name = "pws_usu", targetNamespace = "WSSimuladorCredito")
        String pwsUsu,
        @WebParam(name = "pws_psw", targetNamespace = "WSSimuladorCredito")
        String pwsPsw);

}