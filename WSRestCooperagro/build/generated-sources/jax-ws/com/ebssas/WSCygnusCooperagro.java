
package com.ebssas;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Servicios web para uso de Cooperagro
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSCygnusCooperagro", targetNamespace = "http://www.ebssas.com/", wsdlLocation = "http://localhost/WSCygnusCooperagro/WSClientCygnus.asmx?WSDL")
public class WSCygnusCooperagro
    extends Service
{

    private final static URL WSCYGNUSCOOPERAGRO_WSDL_LOCATION;
    private final static WebServiceException WSCYGNUSCOOPERAGRO_EXCEPTION;
    private final static QName WSCYGNUSCOOPERAGRO_QNAME = new QName("http://www.ebssas.com/", "WSCygnusCooperagro");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost/WSCygnusCooperagro/WSClientCygnus.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCYGNUSCOOPERAGRO_WSDL_LOCATION = url;
        WSCYGNUSCOOPERAGRO_EXCEPTION = e;
    }

    public WSCygnusCooperagro() {
        super(__getWsdlLocation(), WSCYGNUSCOOPERAGRO_QNAME);
    }

    public WSCygnusCooperagro(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCYGNUSCOOPERAGRO_QNAME, features);
    }

    public WSCygnusCooperagro(URL wsdlLocation) {
        super(wsdlLocation, WSCYGNUSCOOPERAGRO_QNAME);
    }

    public WSCygnusCooperagro(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCYGNUSCOOPERAGRO_QNAME, features);
    }

    public WSCygnusCooperagro(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCygnusCooperagro(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSCygnusCooperagroSoap
     */
    @WebEndpoint(name = "WSCygnusCooperagroSoap")
    public WSCygnusCooperagroSoap getWSCygnusCooperagroSoap() {
        return super.getPort(new QName("http://www.ebssas.com/", "WSCygnusCooperagroSoap"), WSCygnusCooperagroSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSCygnusCooperagroSoap
     */
    @WebEndpoint(name = "WSCygnusCooperagroSoap")
    public WSCygnusCooperagroSoap getWSCygnusCooperagroSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ebssas.com/", "WSCygnusCooperagroSoap"), WSCygnusCooperagroSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WSCygnusCooperagroSoap
     */
    @WebEndpoint(name = "WSCygnusCooperagroSoap12")
    public WSCygnusCooperagroSoap getWSCygnusCooperagroSoap12() {
        return super.getPort(new QName("http://www.ebssas.com/", "WSCygnusCooperagroSoap12"), WSCygnusCooperagroSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSCygnusCooperagroSoap
     */
    @WebEndpoint(name = "WSCygnusCooperagroSoap12")
    public WSCygnusCooperagroSoap getWSCygnusCooperagroSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ebssas.com/", "WSCygnusCooperagroSoap12"), WSCygnusCooperagroSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCYGNUSCOOPERAGRO_EXCEPTION!= null) {
            throw WSCYGNUSCOOPERAGRO_EXCEPTION;
        }
        return WSCYGNUSCOOPERAGRO_WSDL_LOCATION;
    }

}
