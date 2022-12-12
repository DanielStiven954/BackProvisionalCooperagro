/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

import com.co.ebs.cooperagro.service.ParametroServiceBean;
import wssimuladorcredito.*;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 *
 * @author Brayan F Silva R
 */
public class WSSimuladorCredito {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sURL_WS_SIM_CRED_WSDL = parametroServiceBean.obtenerParametroPorNombre("WS_SIM_CREDITO");

    public Respuesta liqSimuladorCredito(String pwsMonto, String pwsNroCuotas, String pwsFechaSol, String pwsValRecog, String pwsCodCredi, String pwsFormPlazo, String pwsIdentific, String pwsFormPeriodic, String pwsformapago, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3, String pwsBd, String pwsUsu, String pwsPsw) {
        Respuesta rtaSimCredito = new Respuesta();
        try {
            URL newEndpoint = new URL(sURL_WS_SIM_CRED_WSDL);
            QName qname = new QName("WSSimuladorCredito", "WSClientSimuladorCredito");
            WSClientSimuladorCredito wSClientSimuladorCredito = new WSClientSimuladorCredito(newEndpoint, qname);
            WSClientSimuladorCreditoSoap clientSimuladorCreditoSoap = wSClientSimuladorCredito.getWSClientSimuladorCreditoSoap();
            rtaSimCredito = clientSimuladorCreditoSoap.wsCONSULTALIQUIDACION(pwsMonto, pwsNroCuotas, pwsFechaSol, pwsValRecog, pwsCodCredi, pwsFormPlazo, pwsIdentific, pwsFormPeriodic,pwsformapago, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtaSimCredito;
    }

    public RespuestaAtr liqSimuladorCreditoAtr(String pwsMonto, String pwsNroCuotas, String pwsFechaSol, String pwsValRecog, String pwsCodCredi, String pwsFormPlazo, String pwsIdentific, String pwsFormPeriodic,String pwsformapago, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3, String pwsBd, String pwsUsu, String pwsPsw) {
        //Respuesta rtaSimCredito = new Respuesta();
        RespuestaAtr rtaSimCreditoAtr = new RespuestaAtr();
        try {
            URL newEndpoint = new URL(sURL_WS_SIM_CRED_WSDL);
            QName qname = new QName("WSSimuladorCredito", "WSClientSimuladorCredito");
            WSClientSimuladorCredito wSClientSimuladorCredito = new WSClientSimuladorCredito(newEndpoint, qname);
            WSClientSimuladorCreditoSoap clientSimuladorCreditoSoap = wSClientSimuladorCredito.getWSClientSimuladorCreditoSoap();
            rtaSimCreditoAtr = clientSimuladorCreditoSoap.wsCONSULTALIQUIDACIONATR(pwsMonto, pwsNroCuotas, pwsFechaSol, pwsValRecog, pwsCodCredi, pwsFormPlazo, pwsIdentific, pwsFormPeriodic,pwsformapago, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtaSimCreditoAtr;
    }

    public RespuestaCupo calculoCupos(String pwsIdentific, String pwsFormPeriodic, String pwsCodCredi, String pwsFormPlazo, String pwsformpag, String pwsBd, String pwsUsu, String pwsPsw) {
        RespuestaCupo respuestaCupo = new RespuestaCupo();
        try {
            URL newEndpoint = new URL(sURL_WS_SIM_CRED_WSDL);
            QName qname = new QName("WSSimuladorCredito", "WSClientSimuladorCredito");
            WSClientSimuladorCredito wSClientSimuladorCredito = new WSClientSimuladorCredito(newEndpoint, qname);
            WSClientSimuladorCreditoSoap clientSimuladorCreditoSoap = wSClientSimuladorCredito.getWSClientSimuladorCreditoSoap();
            respuestaCupo = clientSimuladorCreditoSoap.calculoCupos(pwsIdentific, pwsFormPeriodic, pwsCodCredi, pwsFormPlazo,pwsformpag, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuestaCupo;
    }

}
