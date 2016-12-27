package com.el.cmic.repertory;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.el.cmic.domain.repertory.StroTransferPush;
import com.el.cmic.service.repertory.impl.StoTransferPushServiceImpl;


public class TestStoTransferPushServiceImpl   extends TestCase{
	

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
	    public void testStotransferpush(){
	    	StoTransferPushServiceImpl  stoTransferPushServiceImpl =(StoTransferPushServiceImpl) context.getBean("stoTransferPushServiceImpl");
	    	//库存转移推送测试
			  
			 String str= "{\"物流中心\":1,"
							+ "\"货主\":\"02002\","
							+ "\"通知单号\":\"XSDD201707010001\","
							+ "\"通知单日期\":\"2012-12-09\","
							+ "\"说明\":\"说明\","
							+ "\"通知单明细\":["
											+"{"
											+ "\"通知单行号\":1,"
											+ "\"货品编号\":\"0200572\","
											+ "\"数量\":21,"
											+ "\"批号\":\"2016030087733\","
											+ "\"灭菌批号\":\"33\","
											+ "\"移出库类型\":\"0\","
											+ "\"移入库类型\":\"1\","
											+ "\"货品名称\":\"感冒灵胶囊\","
											+ "\"有效期至\":\"yyyyMMdd\","
											+ "\"生产日期\":\"yyyyMMdd\","
											+ "\"移库原因\":\"333\","
											+ "\"不合格审批单号\":\"3333\","
											+ "\"移库原因\":\"3333\","
											+ "\"通知单日期\":\"3333\""
											+ "},"
											+"{"
											+ "\"通知单行号\":2,"
											+ "\"货品编号\":\"0200572\","
											+ "\"数量\":21,"
											+ "\"批号\":\"2016030087733\","
											+ "\"灭菌批号\":\"33\","
											+ "\"移出库类型\":\"0\","
											+ "\"移入库类型\":\"1\","
											+ "\"货品名称\":\"感冒灵胶囊\","
											+ "\"有效期至\":\"yyyyMMdd\","
											+ "\"生产日期\":\"yyyyMMdd\","
											+ "\"移库原因\":\"333\","
											+ "\"不合格审批单号\":\"3333\","
											+ "\"移库原因\":\"3333\","
											+ "\"通知单日期\":\"3333\""
											+ "}"
										+ "]"
					+ "}";
			
			StroTransferPush	stroTransferPush =JSONObject.toJavaObject(JSONObject.parseObject(str), StroTransferPush.class);
			System.out.println(stroTransferPush);
			Integer count = stoTransferPushServiceImpl.insertSTPush(stroTransferPush);
			System.out.println(count);
	    }
}
