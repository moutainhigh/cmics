package nc.itf.mdm.ws.mfr;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.lang.*;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-10-17T10:45:30.249+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://ws.mdm.itf.nc/QxmdmMfrService", name = "QxmdmMfrServicePortType")
@XmlSeeAlso({ObjectFactory.class, nc.uap.ws.lang.ObjectFactory.class})
public interface QxmdmMfrServicePortType {

    @WebMethod(action = "urn:reqModMfrSrv")
    @Action(input = "urn:reqModMfrSrv", output = "urn:reqModMfrSrvResponse", fault = {})
    @RequestWrapper(localName = "reqModMfrSrv", targetNamespace = "http://ws.mdm.itf.nc/QxmdmMfrService", className = "nc.itf.mdm.ws.ReqModMfrSrv")
    @ResponseWrapper(localName = "reqModMfrSrvResponse", targetNamespace = "http://ws.mdm.itf.nc/QxmdmMfrService", className = "nc.itf.mdm.ws.ReqModMfrSrvResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String reqModMfrSrv(
            @WebParam(name = "string", targetNamespace = "")
                    String string,
            @WebParam(name = "string1", targetNamespace = "")
                    String string1,
            @WebParam(name = "string2", targetNamespace = "")
                    String string2
    ) throws java.lang.Exception;

    @WebMethod(action = "urn:reqMfrSrv")
    @Action(input = "urn:reqMfrSrv", output = "urn:reqMfrSrvResponse", fault = {})
    @RequestWrapper(localName = "reqMfrSrv", targetNamespace = "http://ws.mdm.itf.nc/QxmdmMfrService", className = "nc.itf.mdm.ws.ReqMfrSrv")
    @ResponseWrapper(localName = "reqMfrSrvResponse", targetNamespace = "http://ws.mdm.itf.nc/QxmdmMfrService", className = "nc.itf.mdm.ws.ReqMfrSrvResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String reqMfrSrv(
            @WebParam(name = "string", targetNamespace = "")
                    String string,
            @WebParam(name = "string1", targetNamespace = "")
                    String string1,
            @WebParam(name = "string2", targetNamespace = "")
                    String string2
    ) throws java.lang.Exception;
}
