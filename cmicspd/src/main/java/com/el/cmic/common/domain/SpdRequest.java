package com.el.cmic.common.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.el.utils.DateUtil;
import com.el.utils.Md5Util;
import com.el.utils.ReadPropertiesUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

/**
 * Created by ELSIAN
 * 用于放置spd请求数据
 */
//@PropertySource({"classpath:config/spd/testspd.properties"})
@Component
@Scope("prototype")
@JSONType(orders = {"appkey", "timestamp", "data", "sign", "ver"})
public class SpdRequest {
    Logger logger = Logger.getLogger(SpdRequest.class);
    @Autowired
    private Environment env;

    @Value("${spd.AppKey}")
    @JSONField(name = "appkey")
    private String appkey;

    @Value(("${spd.AppPassword}"))
    private String appPassword;

    @JSONField(name = "timestamp")
    private String timestamp;

    @JSONField(name = "data")
    private String data;

    @JSONField(name = "sign")
    private String sign;

    @Value("${spd.Ver}")
    @JSONField(name = "ver")
    private String ver;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String encodeData = "";
        try {
            //进行转码
            encodeData = Base64Utils.encodeToString(data.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("请求数据转成Base64位格式出错,error:" + e.getMessage());
        }
        this.data = encodeData;

        this.timestamp = DateUtil.getTimeStamp();
        this.sign = Md5Util.md5s(this.timestamp + this.data + appPassword);
    }

    /**
     * to a map
     */
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appkey", this.appkey);
        map.put("timestamp", this.timestamp);
        map.put("data", this.data);
        map.put("sign", this.sign);
        map.put("ver", this.ver);
        return map;
    }

    /**
     * to a json
     */
    public String toJson() {


        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.SortField);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "spdRequest [appkey=" + appkey + ", timestamp=" + timestamp + ", data=" + data + ", sign=" + sign
                + ", ver=" + ver + "]";
    }

}
