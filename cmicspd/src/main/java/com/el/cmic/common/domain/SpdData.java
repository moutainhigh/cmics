package com.el.cmic.common.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by Vincent on 2016/10/26.
 * 用于放置发送的data
 */
@Component
@JSONType(orders={"接口类型","接收系统标识","接口数据"})
public class SpdData {
    @JSONField(name = "接口类型")
    private String interfaceType;
    @JSONField(name = "接收系统标识")
    private String interfaceId;
    @JSONField(name = "接口数据")
    private Object interfaceData;

    /**
	 * @param type
	 * @param id
	 * @param data
	 */
	public SpdData(String type, String id, Object data,String twoType) {
		this.interfaceType = type;
		this.interfaceId = id;
		Map<String,List> map = new HashMap<String,List>();
		List<Object> list=new ArrayList<Object>();
		list.add(data);
		map.put(twoType,list );
		this.interfaceData = map;
	}
	
    /**
	 * @param type
	 * @param id
	 * @param data
	 */
	public SpdData(String type, String id, Object data) {
		this.interfaceType = type;
		this.interfaceId = id;
		this.interfaceData = data;
	}
    public SpdData(String type, String id) {
        this.interfaceType = type;
        this.interfaceId = id;
    }
    public SpdData() {
    }

	/**
	 * to a json
	 */
	public String toJson() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.SortField);
	}

	public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Object getInterfaceData() {
        return interfaceData;
    }

    public void setInterfaceData(Object interfaceData) {
        this.interfaceData = interfaceData;
    }
}
