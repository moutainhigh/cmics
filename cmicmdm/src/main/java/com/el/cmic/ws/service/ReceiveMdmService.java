package com.el.cmic.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Vincent on 2016/9/13.
 */
@WebService
public interface ReceiveMdmService {
    @WebMethod
    public String receive(String info);

    /**
     * 验证字符串是否是xml
     *
     * @param info
     * @return
     */
   /* public String validXml(String info);

    *//**
     * 存储请求的info数据到日志表
     * @param info
     *//*
    public void saveLog(String info);

*/
}
