
package wspersonascygnus;

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
@WebServiceClient(name = "WSPersonasCygnus", targetNamespace = "WSPersonasCygnus", wsdlLocation = "http://localhost/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL")
public class WSPersonasCygnus
    extends Service
{

    private final static URL WSPERSONASCYGNUS_WSDL_LOCATION;
    private final static WebServiceException WSPERSONASCYGNUS_EXCEPTION;
    private final static QName WSPERSONASCYGNUS_QNAME = new QName("WSPersonasCygnus", "WSPersonasCygnus");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSPERSONASCYGNUS_WSDL_LOCATION = url;
        WSPERSONASCYGNUS_EXCEPTION = e;
    }

    public WSPersonasCygnus() {
        super(__getWsdlLocation(), WSPERSONASCYGNUS_QNAME);
    }

    public WSPersonasCygnus(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSPERSONASCYGNUS_QNAME, features);
    }

    public WSPersonasCygnus(URL wsdlLocation) {
        super(wsdlLocation, WSPERSONASCYGNUS_QNAME);
    }

    public WSPersonasCygnus(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSPERSONASCYGNUS_QNAME, features);
    }

    public WSPersonasCygnus(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSPersonasCygnus(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSPersonasCygnusSoap
     */
    @WebEndpoint(name = "WSPersonasCygnusSoap")
    public WSPersonasCygnusSoap getWSPersonasCygnusSoap() {
        return super.getPort(new QName("WSPersonasCygnus", "WSPersonasCygnusSoap"), WSPersonasCygnusSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSPersonasCygnusSoap
     */
    @WebEndpoint(name = "WSPersonasCygnusSoap")
    public WSPersonasCygnusSoap getWSPersonasCygnusSoap(WebServiceFeature... features) {
        return super.getPort(new QName("WSPersonasCygnus", "WSPersonasCygnusSoap"), WSPersonasCygnusSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WSPersonasCygnusSoap
     */
    @WebEndpoint(name = "WSPersonasCygnusSoap12")
    public WSPersonasCygnusSoap getWSPersonasCygnusSoap12() {
        return super.getPort(new QName("WSPersonasCygnus", "WSPersonasCygnusSoap12"), WSPersonasCygnusSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns WSPersonasCygnusSoap
     */
    @WebEndpoint(name = "WSPersonasCygnusSoap12")
    public WSPersonasCygnusSoap getWSPersonasCygnusSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("WSPersonasCygnus", "WSPersonasCygnusSoap12"), WSPersonasCygnusSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSPERSONASCYGNUS_EXCEPTION!= null) {
            throw WSPERSONASCYGNUS_EXCEPTION;
        }
        return WSPERSONASCYGNUS_WSDL_LOCATION;
    }

}
