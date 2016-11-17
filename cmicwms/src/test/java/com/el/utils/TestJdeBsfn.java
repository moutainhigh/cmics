package com.el.utils;

import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent on 2016/8/29.
 */
public class TestJdeBsfn extends TestCase {

    private JdeBsfn jdeBsfn;
    private ClassPathXmlApplicationContext context;

    public TestJdeBsfn() {

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        jdeBsfn = context.getBean(JdeBsfn.class);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        context.close();
    }

    public void testJdeBsfn() {
        try {
            //测试获取UKID
            Long ret = getUkid("F58H0401");
            System.out.println("......ukid=" + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public long getUkid(String tableName) throws Exception {
        Map m = new HashMap();
        m.put("szObjectName", tableName);
        Map ret = jdeBsfn.call("GetNextUniqueKeyID", m);
        return Long.valueOf(ret.get("mnUniqueKeyID").toString());
    }


}
