
package wssimuladorcredito;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSClientSimuladorCredito", targetNamespace = "WSSimuladorCredito", wsdlLocation = "http://localhost/WSSimuladorCreditoCooperagro/WSClientSimuladorCredito.asmx?WSDL")
public class WSClientSimuladorCredito
    extends Service
{

    private final static URL WSCLIENTSIMULADORCREDITO_WSDL_LOCATION;
    private final static WebServiceException WSCLIENTSIMULADORCREDITO_EXCEPTION;
    private final static QName WSCLIENTSIMULADORCREDITO_QNAME = new QName("WSSimuladorCredito", "WSClientSimuladorCredito");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost/WSSimuladorCreditoCooperagro/WSClientSimuladorCredito.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCLIENTSIMULADORCREDITO_WSDL_LOCATION = url;
        WSCLIENTSIMULADORCREDITO_EXCEPTION = e;
    }

    public WSClientSimuladorCredito() {
        super(__getWsdlLocation(), WSCLIENTSIMULADORCREDITO_QNAME);
    }

    public WSClientSimuladorCredito(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCLIENTSIMULADORCREDITO_QNAME, features);
    }

    public WSClientSimuladorCredito(URL wsdlLocation) {
        super(wsdlLocation, WSCLIENTSIMULADORCREDITO_QNAME);
    }

    public WSClientSimuladorCredito(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCLIENTSIMULADORCREDITO_QNAME, features);
    }

    public WSClientSimuladorCredito(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSClientSimuladorCredito(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSClientSimuladorCreditoSoap
     */
    @WebEndpoint(name = "WSClientSimuladorCreditoSoap")
    public WSClientSimuladorCreditoSoap getWSClientSimuladorCreditoSoap() {
        return super.getPort(new QName("WSSimuladorCredito", "WSClientSimuladorCreditoSoap"), WSClientSimuladorCreditoSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSClientSimuladorCreditoSoap
     */
    @WebEndpoint(name = "WSClientSimuladorCreditoSoap")
    public WSClientSimuladorCreditoSoap getWSClientSimuladorCreditoSoap(WebServiceFeature... features) {
        return super.getPort(new QName("WSSimuladorCredito", "WSClientSimuladorCreditoSoap"), WSClientSimuladorCreditoSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WSClientSimuladorCreditoSoap
     */
    @WebEndpoint(name = "WSClientSimuladorCreditoSoap12")
    public WSClientSimuladorCreditoSoap getWSClientSimuladorCreditoSoap12() {
        return super.getPort(new QName("WSSimuladorCredito", "WSClientSimuladorCreditoSoap12"), WSClientSimuladorCreditoSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSClientSimuladorCreditoSoap
     */
    @WebEndpoint(name = "WSClientSimuladorCreditoSoap12")
    public WSClientSimuladorCreditoSoap getWSClientSimuladorCreditoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("WSSimuladorCredito", "WSClientSimuladorCreditoSoap12"), WSClientSimuladorCreditoSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCLIENTSIMULADORCREDITO_EXCEPTION!= null) {
            throw WSCLIENTSIMULADORCREDITO_EXCEPTION;
        }
        return WSCLIENTSIMULADORCREDITO_WSDL_LOCATION;
    }

}