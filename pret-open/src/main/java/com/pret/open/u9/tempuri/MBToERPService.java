
/*
 * 
 */

package com.pret.open.u9.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.4
 * Sun Dec 22 14:25:30 CST 2019
 * Generated source version: 2.2.4
 * 
 */


@WebServiceClient(name = "MBToERPService", 
                  wsdlLocation = "http://116.228.74.171/U9Interface/MBToERPService.asmx?WSDL",
                  targetNamespace = "http://tempuri.org/") 
public class MBToERPService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://tempuri.org/", "MBToERPService");
    public final static QName MBToERPServiceSoap = new QName("http://tempuri.org/", "MBToERPServiceSoap");
    public final static QName MBToERPServiceSoap12 = new QName("http://tempuri.org/", "MBToERPServiceSoap12");
    static {
        URL url = null;
        try {
            url = new URL("http://116.228.74.171/U9Interface/MBToERPService.asmx?WSDL");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://116.228.74.171/U9Interface/MBToERPService.asmx?WSDL");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public MBToERPService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MBToERPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MBToERPService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns MBToERPServiceSoap
     */
    @WebEndpoint(name = "MBToERPServiceSoap")
    public MBToERPServiceSoap getMBToERPServiceSoap() {
        return super.getPort(MBToERPServiceSoap, MBToERPServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MBToERPServiceSoap
     */
    @WebEndpoint(name = "MBToERPServiceSoap")
    public MBToERPServiceSoap getMBToERPServiceSoap(WebServiceFeature... features) {
        return super.getPort(MBToERPServiceSoap, MBToERPServiceSoap.class, features);
    }
    /**
     * 
     * @return
     *     returns MBToERPServiceSoap
     */
    @WebEndpoint(name = "MBToERPServiceSoap12")
    public MBToERPServiceSoap getMBToERPServiceSoap12() {
        return super.getPort(MBToERPServiceSoap12, MBToERPServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MBToERPServiceSoap
     */
    @WebEndpoint(name = "MBToERPServiceSoap12")
    public MBToERPServiceSoap getMBToERPServiceSoap12(WebServiceFeature... features) {
        return super.getPort(MBToERPServiceSoap12, MBToERPServiceSoap.class, features);
    }

}
