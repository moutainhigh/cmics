package com.el.cmic.domain.customer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 客户信息推送  地址明细
 *
 * @author zhanhao
 */
@JSONType(orders = {"地址编号", "收货地址", "使用部门", "联系人","联系电话"})
public class CustomPItem {
    @JSONField(serialize = false)
    private String bsan8;
    /**
     * 地址编号
     */
    @JSONField(name = "地址编号")
    private String an8;
    /**
     * 收货地址
     */
    @JSONField(name = "收货地址")
    private String address;
    /**
     * 使用部门
     */
    @JSONField(name = "使用部门")
    private String mcu;
    /**
     * 联系人
     */
    @JSONField(name = "联系人")
    private String mlnm;
    /**
     * 联系电话
     */
    @JSONField(name = "联系电话")
    private String tellPhone;

    public String getBsan8() {
        return bsan8;
    }

    public void setBsan8(String bsan8) {
        this.bsan8 = bsan8;
    }

    public String getAn8() {
        return an8;
    }

    public void setAn8(String an8) {
        this.an8 = an8;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMcu() {
        return mcu;
    }

    public void setMcu(String mcu) {
        this.mcu = mcu;
    }

    public String getMlnm() {
        return mlnm;
    }

    public void setMlnm(String mlnm) {
        this.mlnm = mlnm;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }
}
