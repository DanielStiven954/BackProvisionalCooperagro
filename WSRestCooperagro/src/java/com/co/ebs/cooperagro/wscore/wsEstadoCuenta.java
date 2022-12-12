/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

//import WSCuentaCygnus.DatoDTO;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.ebssystem.DatoDTO;
import com.ebssystem.DetalleCta;
import com.ebssystem.DetalleCta;
import com.ebssystem.Movimiento;
import com.ebssystem.WSEstadoCuentaCygnus;
import com.ebssystem.WSEstadoCuentaCygnusSoap;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

/**
 *
 * @author Brayan F Silva R
 */
public class wsEstadoCuenta {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private String sURL_WS_ESTADO_CTA_WSDL = parametroServiceBean.obtenerParametroPorNombre("WS_ESTADO_CUENTA");
    

    public List<com.ebssystem.DatoDTO> wsConsultarEstadoCuenta(String xiTipoIden, String xcIdentificacion, String xcProducto) {
        List<com.ebssystem.DatoDTO> WSEstadoCuenta = new ArrayList();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuentaCygnus = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaCygnusSoap = estadoCuentaCygnus.getWSEstadoCuentaCygnusSoap();
            WSEstadoCuenta = wsEstadoCuentaCygnusSoap.wsCONSULTARESTADOCUENTAISERVICE(xiTipoIden, xcIdentificacion, xcProducto).getDatoDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return WSEstadoCuenta;
    }

    public DetalleCta wsConsultarDetalleCuenta(String sNumRadic, String xcProducto) {
        DetalleCta detalleCta = new DetalleCta();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuenta = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaSoap = estadoCuenta.getWSEstadoCuentaCygnusSoap();
            detalleCta = wsEstadoCuentaSoap.wsOBTENERDETALLECUENTA(sNumRadic, xcProducto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return detalleCta;
    }
    
    public List<Movimiento> wsConsultarDatosAmparadosBeneficiario(String sNumRadic, String xc_producto) {
        List<Movimiento> list = new ArrayList();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuentaCygnus = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaSoap = estadoCuentaCygnus.getWSEstadoCuentaCygnusSoap();
            //list = WSEstadoCuentaCygnusSoap.wsCONSULTARDATOSAMPARADOSBENEFICIARIO(sNumRadic, xc_producto).getDetalleAmparadoBenef();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Movimiento wsConsultaMovimientos(String sNumRadic, String xcProducto) {
        Movimiento movimiento = new Movimiento();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuentaCygnus = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaSoap = estadoCuentaCygnus.getWSEstadoCuentaCygnusSoap();
            movimiento = wsEstadoCuentaSoap.wsCONSULTARESTADOCUENTAIISERVICE(sNumRadic, xcProducto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movimiento;
    }

    public Movimiento wsConsultaDetalleMovimientos(String xnumProducto, String codOperation, String xcProducto) {
        Movimiento movimiento = new Movimiento();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuentaCygnus = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaCygnusSoap = estadoCuentaCygnus.getWSEstadoCuentaCygnusSoap();
            movimiento = wsEstadoCuentaCygnusSoap.wsOBTENERDETALLEMOVIMIENTO(xnumProducto, codOperation, xcProducto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movimiento;
    }

    public List<DatoDTO> wsConsultarObligacionesTerminadas(String xiCodigo, String xcProducto) {
        List<DatoDTO> list = new ArrayList();
        try {
            URL newEndpoint = new URL(sURL_WS_ESTADO_CTA_WSDL);
            QName qname = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

            WSEstadoCuentaCygnus estadoCuentaCygnus = new WSEstadoCuentaCygnus(newEndpoint, qname);
            WSEstadoCuentaCygnusSoap wsEstadoCuentaCygnusSoap = estadoCuentaCygnus.getWSEstadoCuentaCygnusSoap();
            //list = wsEstadoCuentaCygnusSoap.wsCONSULTARCREDITOSTERMINADOS(xiCodigo, xcProducto).getDatoDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
