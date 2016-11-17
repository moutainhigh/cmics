package com.el.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-09-23T11:39:53.629+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "EmpWsServiceImplService", 
                  wsdlLocation = "http://localhost:8080/cmicmdm/ws/EmpWebService?wsdl",
                  targetNamespace = "http://cmic.el.com/") 
public class EmpWsServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cmic.el.com/", "EmpWsServiceImplService");
    public final static QName EmpWsServiceImplPort = new QName("http://cmic.el.com/", "EmpWsServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/cmicmdm/ws/EmpWebService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EmpWsServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/cmicmdm/ws/EmpWebService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EmpWsServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmpWsServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmpWsServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public EmpWsServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EmpWsServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EmpWsServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns EmpWsService
     */
    @WebEndpoint(name = "EmpWsServiceImplPort")
    public EmpWsService getEmpWsServiceImplPort() {
        return super.getPort(EmpWsServiceImplPort, EmpWsService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmpWsService
     */
    @WebEndpoint(name = "EmpWsServiceImplPort")
    public EmpWsService getEmpWsServiceImplPort(WebServiceFeature... features) {
        return super.getPort(EmpWsServiceImplPort, EmpWsService.class, features);
    }

}
