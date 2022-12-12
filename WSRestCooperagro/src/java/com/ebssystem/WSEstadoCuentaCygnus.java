
package com.ebssystem;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * WebServicesEstadoCuenta
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSEstadoCuentaCygnus", targetNamespace = "http://www.ebssystem.com/", wsdlLocation = "http://localhost/WSEstadoCuentaCooperagro/WSClientEstadoCuenta.asmx?WSDL")
public class WSEstadoCuentaCygnus
    extends Service
{

    private final static URL WSESTADOCUENTACYGNUS_WSDL_LOCATION;
    private final static WebServiceException WSESTADOCUENTACYGNUS_EXCEPTION;
    private final static QName WSESTADOCUENTACYGNUS_QNAME = new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnus");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost/WSEstadoCuentaCooperagro/WSClientEstadoCuenta.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSESTADOCUENTACYGNUS_WSDL_LOCATION = url;
        WSESTADOCUENTACYGNUS_EXCEPTION = e;
    }

    public WSEstadoCuentaCygnus() {
        super(__getWsdlLocation(), WSESTADOCUENTACYGNUS_QNAME);
    }

    public WSEstadoCuentaCygnus(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSESTADOCUENTACYGNUS_QNAME, features);
    }

    public WSEstadoCuentaCygnus(URL wsdlLocation) {
        super(wsdlLocation, WSESTADOCUENTACYGNUS_QNAME);
    }

    public WSEstadoCuentaCygnus(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSESTADOCUENTACYGNUS_QNAME, features);
    }

    public WSEstadoCuentaCygnus(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSEstadoCuentaCygnus(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSEstadoCuentaCygnusSoap
     */
    @WebEndpoint(name = "WSEstadoCuentaCygnusSoap")
    public WSEstadoCuentaCygnusSoap getWSEstadoCuentaCygnusSoap() {
        return super.getPort(new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnusSoap"), WSEstadoCuentaCygnusSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSEstadoCuentaCygnusSoap
     */
    @WebEndpoint(name = "WSEstadoCuentaCygnusSoap")
    public WSEstadoCuentaCygnusSoap getWSEstadoCuentaCygnusSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnusSoap"), WSEstadoCuentaCygnusSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WSEstadoCuentaCygnusSoap
     */
    @WebEndpoint(name = "WSEstadoCuentaCygnusSoap12")
    public WSEstadoCuentaCygnusSoap getWSEstadoCuentaCygnusSoap12() {
        return super.getPort(new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnusSoap12"), WSEstadoCuentaCygnusSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSEstadoCuentaCygnusSoap
     */
    @WebEndpoint(name = "WSEstadoCuentaCygnusSoap12")
    public WSEstadoCuentaCygnusSoap getWSEstadoCuentaCygnusSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ebssystem.com/", "WSEstadoCuentaCygnusSoap12"), WSEstadoCuentaCygnusSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSESTADOCUENTACYGNUS_EXCEPTION!= null) {
            throw WSESTADOCUENTACYGNUS_EXCEPTION;
        }
        return WSESTADOCUENTACYGNUS_WSDL_LOCATION;
    }

}