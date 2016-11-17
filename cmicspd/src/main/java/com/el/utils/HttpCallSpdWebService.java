package com.el.utils;

import com.alibaba.fastjson.JSON;
import com.el.cmic.common.domain.SpdResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.httpclient.HttpURL;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.xml.rpc.ServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.rmi.RemoteException;

/**
 * Created by Vincent on 2016/11/14.
 */
@Component
public class HttpCallSpdWebService {
    Logger logger = Logger.getLogger(CallSpdWebServiceUtil.class);
    @Value("${spd.AppKey}")
    private String appKey;

    @Value("${spd.Url}")
    private String spdUrl;

    @Value("${spd.AppPassword}")
    private String appPassword;

    @Value("${spd.Ver}")
    private String ver;

    public SpdResult callSpdWebService(String data) {
        SpdResult spdResult = new SpdResult(true, "0000", "成功");
        HttpURLConnection connection = null;
        PrintWriter out = null;
        BufferedReader in = null;

        String sendStr = "";//发送参数
        try {
            logger.info("发送:[原始数据]:" + data);
            String encodeData = Base64Utils.encodeToString(data.getBytes("utf-8"));
            String timestamp = DateUtil.getTimeStamp();
            String sign = Md5Util.md5s(timestamp + encodeData + appPassword);
            logger.info("发送:[编码数据]:" + "appKey:" + appKey + ";timestamp:" + timestamp + ";data:" + encodeData + ";sign="
                    + sign + ";ver:" + ver);

            encodeData = URLEncoder.encode(encodeData, "utf-8");
            sendStr = "appkey=" + appKey + "&timestamp=" + timestamp + "&data=" + encodeData + "&sign=" + sign + "&ver=" + ver;
            System.out.println(sendStr);

            HttpResponse<String> response = Unirest.post(spdUrl)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("cache-control", "no-cache").header("charset", "utf-8")
                    .header("postman-token", "f1196580-9622-20ae-b73f-c25d4786336e")
                    .body(sendStr).asString();
            String strResult = "";
            String xmlResult = response.getBody();
            Document document = DocumentHelper.parseText(xmlResult);
            Element element = document.getRootElement();
            strResult = element.getText();
            logger.info("返回:[原始数据]:" + strResult);
            byte[] bytes = Base64Utils.decodeFromString(strResult);
            String decodeResult = new String(bytes, "utf-8");
            spdResult = JSON.parseObject(decodeResult, SpdResult.class);
            logger.info("返回:[解码数据]:" + spdResult);
        } catch (Exception e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("9999");
            spdResult.setMessage("调用SPD WebService失败,error:" + e.getMessage());
            logger.error("调用SPD接口失败,[error]" + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return spdResult;
    }


}
