package com.el.cmic.logaop;

import com.alibaba.fastjson.JSON;
import com.el.cmic.common.domain.Fe8spdlg;
import com.el.cmic.common.domain.SpdResult;
import com.el.cmic.service.spdlog.SpdLogService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

/**
 * 记录日志表aop
 * Created by Vincent on 2016/11/26.
 */
@Component
@Aspect
public class SpdLogAop {
    Logger logger = Logger.getLogger(SpdLogAop.class);
    private Fe8spdlg fe8spdlg;

    @Autowired
    private SpdLogService spdLogServiceImpl;

    @Pointcut("execution(* com.el.utils.SpdClientService.callSpdWebService(..))")
    private void method() {

    }

    @Before("method()")
    public void beforeMethod(JoinPoint joinPoint) {
        try {
            Object[] objects = joinPoint.getArgs();
            fe8spdlg = (Fe8spdlg) objects[6];
            spdLogServiceImpl.insertFe8spdlg(fe8spdlg);
        } catch (Exception e) {
            logger.error("记录发送数据日志失败,[error]" + e.getMessage());
        }
    }

    @AfterReturning(pointcut = "method()", returning = "spdResult")
    public void afterMethod(JoinPoint joinPoint, SpdResult spdResult) {
        try {
            //System.out.println("返回值:" + retStr);
          //  byte[] bytes = Base64Utils.decode(retStr.getBytes("utf-8"));
           // String decodeStr = new String(bytes, "utf-8");


            //SpdResult spdResult = JSON.parseObject(decodeStr, SpdResult.class);
            if (spdResult.isSuccess()) {
                fe8spdlg.setLge8rzlx("INFO");
                logger.info("返回:[解码数据]:" + spdResult.toJson());
            } else {
                fe8spdlg.setLge8rzlx("ERROR");
                fe8spdlg.setLge8str200("错误信息:"+spdResult.toJson());
                logger.error("返回:[解码数据]:" + spdResult.toJson());
            }
            fe8spdlg.setLge8rzfx("TOERP");
            //fe8wmslg.setLsdl03("Response");
            fe8spdlg.setLge8rznr(spdResult.toJson());
            spdLogServiceImpl.insertFe8spdlg(fe8spdlg);
        } catch (Exception e) {
            logger.error("记录发送返回数据日志失败,[error]" + e.getMessage());
        }
    }

    @AfterThrowing(pointcut = "method()", throwing = "ex")
    public void afterThrow(JoinPoint point, Exception ex) {
        logger.error("调用Spd接口失败,[error]" + ex.getMessage());
        fe8spdlg.setLge8rzlx("ERROR");
        fe8spdlg.setLge8str200("错误信息:调用Spd接口失败,[error]"+ex.getMessage());
        fe8spdlg.setLge8rzfx("TOSPD");
        //fe8wmslg.setLsdl03("Request");
       /* String message = ex.getMessage();
        if (message != null && message.length() > 50) {
            message = message.substring(0, 49);
        }*/
        fe8spdlg.setLge8rznr(ex.toString());
        //fe8wmslg.setLsvar1(decodeStr);
        spdLogServiceImpl.insertFe8spdlg(fe8spdlg);

    }
}
