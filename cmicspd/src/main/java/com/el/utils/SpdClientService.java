package com.el.utils;


import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Base64;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import com.el.cmic.common.domain.Fe8spdlg;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.el.cmic.common.domain.SpdResult;

/**
 * 调用webService  接口  客户端
 *
 * @author zhanhao
 */
@Component
public class SpdClientService {
    Logger logger = Logger.getLogger(SpdClientService.class);
    //@Value("${spd.Url}")
    //private String url;

    //@Value("${spd.AppKey}")
    //private String appKey;

    //@Value("${spd.AppPassword}")
    //private String appPassword;

    //@Value("${spd.Ver}")
    //private String ver;

    //@Value("${spd.NameSpace}")
    //private String nameSpace;

    public SpdResult callSpdWebService(String data, String appKey, String appPassword, String url, String nameSpace, String ver, Fe8spdlg fe8spdlg)
            throws RemoteException,UnsupportedEncodingException,ServiceException,MalformedURLException,Exception {
        SpdResult spdResult = new SpdResult(true, "0000", "成功");
        // try {
        String encodeData = Base64.getEncoder().encodeToString(data.getBytes("utf-8"));
        System.out.println("=============================================");
        System.out.println(encodeData);
        String timestamp = DateUtil.getTimeStamp();
        String sign = Md5Util.md5s(timestamp + encodeData + appPassword);
        logger.info("发送:[原始数据]:[data]=" + data+";[appkey]="+appKey+";" +
                "[timestamp]="+timestamp+";[ver]="+ver+";[sign]="+sign);

        logger.info("发送:[编码数据]:[data]=" + encodeData+";[appkey]="+appKey+";" +
                "[timestamp]="+timestamp+";[ver]="+ver+";[sign]="+sign);


        /** Axis Client */
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(url));
        // 这个要注意 就是要加上要调用接口的NAMESPACE,不然会报错 ！！ (NAMESPACE来源于接口WSDL)
        call.setOperationName(new QName(nameSpace, "UpLoadData"));

        // 这个要注意 参数也要加上NAMESPACE,不然也会报错 ！！
        call.addParameter(new QName(nameSpace, "appkey"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName(nameSpace, "timestamp"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName(nameSpace, "data"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName(nameSpace, "sign"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName(nameSpace, "ver"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);

        call.setUseSOAPAction(true);
        call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); // 返回参数的类型
        call.setSOAPActionURI(nameSpace + "UpLoadData"); // 这个也要注意
        // 就是要加上要调用的方法UpLoadData,不然也会报错

        String resultBase64="";
        resultBase64 = (String) call.invoke(new Object[]{appKey, timestamp, encodeData, sign, ver});
        logger.info("返回:[原始数据]:" + resultBase64);
        String decodeResult = new String(Base64.getDecoder().decode(resultBase64.getBytes()), "utf-8");
        spdResult = JSON.parseObject(decodeResult, SpdResult.class);
        //}
    /*catch (RemoteException e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("9999");
            spdResult.setMessage("调用SPD WebService失败,error:" + e.getMessage());
            logger.error("调用SPD接口失败,[error]" + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("9999");
            spdResult.setMessage("调用SPD WebService失败,error:" + e.getMessage());
            logger.error("调用SPD接口失败,[error]" + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("9999");
            spdResult.setMessage("调用SPD WebService失败,error:" + e.getMessage());
            logger.error("调用SPD接口失败,[error]" + e.getMessage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("9999");
            spdResult.setMessage("调用SPD WebService失败,error:" + e.getMessage());
            logger.error("调用SPD接口失败,[error]" + e.getMessage());
        }*/
        return spdResult;
    }

}
