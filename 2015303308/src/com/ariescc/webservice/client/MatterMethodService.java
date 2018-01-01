
package com.ariescc.webservice.server;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MatterMethodService", targetNamespace = "http://server.webservice.ariescc.com/", wsdlLocation = "http://localhost:8080/service?wsdl")
public class MatterMethodService
    extends Service
{

    private final static URL MATTERMETHODSERVICE_WSDL_LOCATION;
    private final static WebServiceException MATTERMETHODSERVICE_EXCEPTION;
    private final static QName MATTERMETHODSERVICE_QNAME = new QName("http://server.webservice.ariescc.com/", "MatterMethodService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MATTERMETHODSERVICE_WSDL_LOCATION = url;
        MATTERMETHODSERVICE_EXCEPTION = e;
    }

    public MatterMethodService() {
        super(__getWsdlLocation(), MATTERMETHODSERVICE_QNAME);
    }

    public MatterMethodService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MATTERMETHODSERVICE_QNAME, features);
    }

    public MatterMethodService(URL wsdlLocation) {
        super(wsdlLocation, MATTERMETHODSERVICE_QNAME);
    }

    public MatterMethodService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MATTERMETHODSERVICE_QNAME, features);
    }

    public MatterMethodService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MatterMethodService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMatterMethod
     */
    @WebEndpoint(name = "MatterMethodPort")
    public IMatterMethod getMatterMethodPort() {
        return super.getPort(new QName("http://server.webservice.ariescc.com/", "MatterMethodPort"), IMatterMethod.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMatterMethod
     */
    @WebEndpoint(name = "MatterMethodPort")
    public IMatterMethod getMatterMethodPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.webservice.ariescc.com/", "MatterMethodPort"), IMatterMethod.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MATTERMETHODSERVICE_EXCEPTION!= null) {
            throw MATTERMETHODSERVICE_EXCEPTION;
        }
        return MATTERMETHODSERVICE_WSDL_LOCATION;
    }

}
