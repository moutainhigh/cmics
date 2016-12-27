package com.el.cmic.domain.orderback;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by king_ on 2016/11/8.
 */
@JSONType(orders = {"SPD系统标识", "配送单位", "配送单位ERP编号", "配送单位名称", "要货医院ERP编号", "要货医院名称", "要货科室ERP编号"
        , "要货科室名称", "收货科室ERP编号", "收货科室名称", "采购订单号", "请购类型", "_date"
        , "订单总行数", "请求唯一标识","采购订单明细"}, ignores = {"doco", "dcto"})

public class SpdOrderBack implements Serializable {
    @JSONField(name = "SPD系统标识")
    private String e8spdid;
    @JSONField(name = "配送单位")
    private String e8psdw;

    @JSONField(name = "配送单位名称")
    private String e8psdwn;

    @JSONField(name = "配送单位ERP编号")
    private String kcoo;

    @JSONField(name = "要货医院ERP编号")
    private String e8yhyye;
    @JSONField(name = "要货医院名称")
    private String e8yhyyn;
    @JSONField(name = "要货科室ERP编号")
    private String e8yhkse;

    @JSONField(name = "要货科室名称")
    private String e8yhksn;
    @JSONField(name = "收货科室ERP编号")
    private String e8shkse;
    @JSONField(name = "收货科室名称")
    private String e8shksn;
    @JSONField(name = "采购订单号")
    private String e8cgdd;
    @JSONField(name = "请购类型")
    private String e8qglx;

    @JSONField(name = "_date", format = "yyyy-MM-dd HH:mm:ss")
    private Date e8xtsj;
    //@JSONField(name = "订单总行数")
    @JSONField(name = "任务总行数")
    private BigDecimal e8ddzhs;
    @JSONField(name = "采购订单明细")
    private List<SpdOrderBackDetail> spdOrderBackDetailList;

    private BigDecimal doco;
    private String dcto;
    @JSONField(name = "请求唯一标识")
    private String guid;

    public String getKcoo() {
        return kcoo;
    }

    public void setKcoo(String kcoo) {
        this.kcoo = kcoo;
    }

    public BigDecimal getDoco() {
        return doco;
    }

    public void setDoco(BigDecimal doco) {
        this.doco = doco;
    }

    public String getDcto() {
        return dcto;
    }

    public void setDcto(String dcto) {
        this.dcto = dcto;
    }

    public String getE8spdid() {
        return e8spdid;
    }

    public void setE8spdid(String e8spdid) {
        this.e8spdid = e8spdid;
    }

    public String getE8psdw() {
        return e8psdw;
    }

    public void setE8psdw(String e8psdw) {
        this.e8psdw = e8psdw;
    }

    public String getE8psdwn() {
        return e8psdwn;
    }

    public void setE8psdwn(String e8psdwn) {
        this.e8psdwn = e8psdwn;
    }

    public String getE8yhyye() {
        return e8yhyye;
    }

    public void setE8yhyye(String e8yhyye) {
        this.e8yhyye = e8yhyye;
    }

    public String getE8yhyyn() {
        return e8yhyyn;
    }

    public void setE8yhyyn(String e8yhyyn) {
        this.e8yhyyn = e8yhyyn;
    }

    public String getE8yhkse() {
        return e8yhkse;
    }

    public void setE8yhkse(String e8yhkse) {
        this.e8yhkse = e8yhkse;
    }

    public String getE8yhksn() {
        return e8yhksn;
    }

    public void setE8yhksn(String e8yhksn) {
        this.e8yhksn = e8yhksn;
    }

    public String getE8shkse() {
        return e8shkse;
    }

    public void setE8shkse(String e8shkse) {
        this.e8shkse = e8shkse;
    }

    public String getE8shksn() {
        return e8shksn;
    }

    public void setE8shksn(String e8shksn) {
        this.e8shksn = e8shksn;
    }

    public String getE8cgdd() {
        return e8cgdd;
    }

    public void setE8cgdd(String e8cgdd) {
        this.e8cgdd = e8cgdd;
    }

    public String getE8qglx() {
        return e8qglx;
    }

    public void setE8qglx(String e8qglx) {
        this.e8qglx = e8qglx;
    }

    public Date getE8xtsj() {
        return e8xtsj;
    }

    public void setE8xtsj(Date e8xtsj) {
        this.e8xtsj = e8xtsj;
    }

    public BigDecimal getE8ddzhs() {
        return e8ddzhs;
    }

    public void setE8ddzhs(BigDecimal e8ddzhs) {
        this.e8ddzhs = e8ddzhs;
    }

    public List<SpdOrderBackDetail> getSpdOrderBackDetailList() {
        return spdOrderBackDetailList;
    }

    public void setSpdOrderBackDetailList(List<SpdOrderBackDetail> spdOrderBackDetailList) {
        this.spdOrderBackDetailList = spdOrderBackDetailList;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "SpdOrderBack{" +
                "e8spdid='" + e8spdid + '\'' +
                ", e8psdw='" + e8psdw + '\'' +
                ", e8psdwn='" + e8psdwn + '\'' +
                ", e8yhyye='" + e8yhyye + '\'' +
                ", e8yhyyn='" + e8yhyyn + '\'' +
                ", e8yhkse='" + e8yhkse + '\'' +
                ", e8yhksn='" + e8yhksn + '\'' +
                ", e8shks='" + e8shkse + '\'' +
                ", e8shksn='" + e8shksn + '\'' +
                ", e8cgdd='" + e8cgdd + '\'' +
                ", e8qglx='" + e8qglx + '\'' +
                ", e8xtsj=" + e8xtsj +
                ", e8ddzhs=" + e8ddzhs +
                ", spdOrderBackDetailList=" + spdOrderBackDetailList +
                ", kcoo='" + kcoo + '\'' +
                ", doco=" + doco +
                ", dcto='" + dcto + '\'' +
                '}';
    }
}
