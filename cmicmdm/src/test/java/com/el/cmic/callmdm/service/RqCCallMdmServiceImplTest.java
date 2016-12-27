package com.el.cmic.callmdm.service;

import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客商测试类
 * Created by Vincent on 2016/10/13.
 */
public class RqCCallMdmServiceImplTest extends TestCase {
    private ClassPathXmlApplicationContext context;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
         context=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        context.close();
    }
    public void testCallWs(){
        RqCCallMdmServiceImpl rqCCallMdmService=(RqCCallMdmServiceImpl) context.getBean("rqCCallMdmServiceImpl");
        rqCCallMdmService.addCallWS();
    }
    public void testUpdateCallWs(){
        RqCCallMdmServiceImpl rqCCallMdmService=(RqCCallMdmServiceImpl) context.getBean("rqCCallMdmServiceImpl");
        rqCCallMdmService.updateCallWS();
    }
}