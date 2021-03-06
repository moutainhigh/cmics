package com.el.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.el.cmic.service.goods.BalePriceService;

import junit.framework.TestCase;

public class TestBalePriceServiceImpl  extends TestCase {
	
	private ClassPathXmlApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        context.close();
    }
    
    public  void testcallSpdDepartmentInterface(){
    	BalePriceService balePriceService = (BalePriceService)context.getBean("balePriceServiceImpl");
    	balePriceService.callBalePriceImplement();
    }
    

}
