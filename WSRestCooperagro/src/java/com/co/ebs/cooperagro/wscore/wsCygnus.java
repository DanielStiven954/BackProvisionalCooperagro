/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.ebssas.PersonasDTO;
import com.ebssas.PregseguridadaleatorioDTO;
import com.ebssas.PregseguridadperDTO;
import com.ebssas.ResponseIndicadores;
import com.ebssas.WSCygnusCooperagro;
import com.ebssas.WSCygnusCooperagroSoap;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

/**
 *
 * @author Brian Cardenas
 */
public class wsCygnus {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sURL_WS_CYGNUS_WSDL = parametroServiceBean.obtenerParametroPorNombre("WS_CYGNUS");

    public List<PersonasDTO> wcCONSULTARPERSONAS(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        List<PersonasDTO> WSPersona = new ArrayList();
        try {

            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();
            WSPersona = cooperagroSoap.wsCONSULTARPERSONAS(xiCodigo, xiTipoIden, xcIdentificacion).getPersonasDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return WSPersona;
    }

    public List<PregseguridadperDTO> wsCONSULTARPREGSEGURIDADPER(String xiTipoIden, String xcIdentificacion, String xcCampo) {
        List<PregseguridadperDTO> listRtasPregPersona = new ArrayList();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            listRtasPregPersona = cooperagroSoap.wsCONSULTARPREGSEGURIDADPER(xiTipoIden, xcIdentificacion, xcCampo).getPregseguridadperDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listRtasPregPersona;
    }

    public List<PregseguridadaleatorioDTO> wsCONSULTARPREGSEGURIDADALEATORIO(String xiTipoIden, String xcIdentificacion, String xcCampo) {
        List<PregseguridadaleatorioDTO> listRtasPregPersona = new ArrayList();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            listRtasPregPersona = cooperagroSoap.wsCONSULTARPREGSEGURIDADALEATORIO(xiTipoIden, xcIdentificacion, xcCampo).getPregseguridadaleatorioDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listRtasPregPersona;
    }

    public ResponseIndicadores wsGetIndicadorVinculacion(String xsFechaInicio, String xsFechaFin) {
        ResponseIndicadores responseIndicadorVinculacion = new ResponseIndicadores();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            responseIndicadorVinculacion = cooperagroSoap.wsGETINDICADORVINCULACION(xsFechaInicio, xsFechaFin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseIndicadorVinculacion;
    }

    public ResponseIndicadores wsGetIndicadorRetiro(String xsFechaInicio, String xsFechaFin) {
        ResponseIndicadores responseIndicadorRetiro = new ResponseIndicadores();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            responseIndicadorRetiro = cooperagroSoap.wsGETINDICADORRETIRO(xsFechaInicio, xsFechaFin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseIndicadorRetiro;
    }

    public ResponseIndicadores wsGetIndicadorCartera(String xsFechaCorte) {
        ResponseIndicadores responseIndicadorCartera = new ResponseIndicadores();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            responseIndicadorCartera = cooperagroSoap.wsGETINDICADORCARTERA(xsFechaCorte);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseIndicadorCartera;
    }

    public ResponseIndicadores wsGetIndicadorColocacion(String xsFechaInicio, String xsFechaFin) {
        ResponseIndicadores responseIndicadorColocacion = new ResponseIndicadores();
        try {
            URL newEndpoint = new URL(sURL_WS_CYGNUS_WSDL);
            QName qname = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

            WSCygnusCooperagro service = new WSCygnusCooperagro(newEndpoint, qname);
            WSCygnusCooperagroSoap cooperagroSoap = service.getWSCygnusCooperagroSoap();

            responseIndicadorColocacion = cooperagroSoap.wsGETINDICADORCOLOCACION(xsFechaInicio, xsFechaFin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseIndicadorColocacion;
    }
}
