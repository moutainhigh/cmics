package com.el.cmic.callmdm.service;

import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 商品测试类
 * Created by Vincent on 2016/10/8.
 */
@Transactional
public class RqECallMdmServiceImplTest extends TestCase{
    private  ClassPathXmlApplicationContext context;
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

    public void testAddCallWS(){
        RqECallMdmServiceImpl rqECallMdmService= (RqECallMdmServiceImpl) context.getBean("rqECallMdmServiceImpl");
        rqECallMdmService.addCallWS();
//        TestService testService=(TestService)context.getBean("testServiceImpl");
//        FE8Log01 fe8Log01=new FE8Log01();
//        //fe8Log01.setLgukid(1L);
//        fe8Log01.setLgdl01("ssssss");
//        testService.insert(fe8Log01);

    }

    public void testUpdateCallWS(){
        RqECallMdmServiceImpl rqECallMdmService= (RqECallMdmServiceImpl) context.getBean("rqECallMdmServiceImpl");
        rqECallMdmService.updateCallWS();
//        TestService testService=(TestService)context.getBean("testServiceImpl");
//        FE8Log01 fe8Log01=new FE8Log01();
//        //fe8Log01.setLgukid(1L);
//        fe8Log01.setLgdl01("ssssss");
//        testService.insert(fe8Log01);

    }

}
