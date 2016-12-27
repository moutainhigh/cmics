package com.el.cmic.domain.orderback;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by king_ on 2016/11/8.
 */
@JSONType(orders = {"采购订单行号", "医疗机构申请单号", "科室申请单号", "销售单号", "复核打包号", "运单号"
        , "采购订单日期", "医药医材ERP编号", "医药医材名称", "规格", "生产厂商"
        , "产地", "单位", "批号", "灭菌批号", "有效期至",
        "生产日期", "灭菌日期","灭菌批号有效期至","包装", "数量", "单价", "出库库区",
        "发货日期", "说明", "条码", "定量包装", "发票号", "发票日期"},
        ignores = {"kcoo", "dcto"})
public class SpdOrderBackDetail implements Serializable {
    @JSONField(name = "采购订单行号")
    private BigDecimal lnid;

    @JSONField(name = "jde行号", serialize = false)
    private BigDecimal sdlnid;
    @JSONField(name = "医疗机构申请单号")
    private String e8yljgd;
    @JSONField(name = "科室申请单号")
    private String e8ksd;
    @JSONField(name = "销售单号")
    private BigDecimal doco;
    @JSONField(name = "复核打包号")
    private String e8fhdbh;
    @JSONField(name = "运单号")
    private String e8ydh;

    @JSONField(name = "采购订单日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date trdj;
    @JSONField(name = "医药医材ERP编号")
    private String e8yyyce;
    @JSONField(name = "医药医材名称")
    private String e8yyycn;
    @JSONField(name = "规格")
    private String e8spdgg;
    @JSONField(name = "生产厂商")
    private String e8sccs;

    @JSONField(name = "产地")
    private String e8spdcd;
    @JSONField(name = "单位")
    private String e8spddw;
    @JSONField(name = "批号")
    private String lot1;
    @JSONField(name = "灭菌批号")
    private String lot2;
    @JSONField(name = "有效期至", format = "yyyy-MM-dd HH:mm:ss")
    private Date mmej;
    @JSONField(name = "灭菌日期", format = "yyyy-MM-dd")
    private Date mjrq;
    @JSONField(name = "灭菌批号有效期至", format = "yyyy-MM-dd")
    private Date mjsxq;

    @JSONField(name = "生产日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date scrq;
    @JSONField(name = "包装")
    private BigDecimal e8spdbz;
    @JSONField(name = "数量")
    private BigDecimal uorg;
    @JSONField(name = "单价")
    private BigDecimal uprc;
    @JSONField(name = "出库库区")
    private String ckkq;

    @JSONField(name = "发货日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date addj;
    @JSONField(name = "说明")
    private String sm;
    @JSONField(name = "条码")
    private String tm;
    @JSONField(name = "定量包装")
    private String dlbz;
    @JSONField(name = "发票号")
    private String fph;
    @JSONField(name = "发票日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date fprq;

    private String kcoo;
    private String dcto;

    public BigDecimal getDoco() {
        return doco;
    }

    public void setDoco(BigDecimal doco) {
        this.doco = doco;
    }

    public String getKcoo() {
        return kcoo;
    }

    public void setKcoo(String kcoo) {
        this.kcoo = kcoo;
    }

    public String getDcto() {
        return dcto;
    }

    public void setDcto(String dcto) {
        this.dcto = dcto;
    }

    public BigDecimal getLnid() {
        return lnid;
    }

    public void setLnid(BigDecimal lnid) {
        this.lnid = lnid;
    }

    public String getE8yljgd() {
        return e8yljgd;
    }

    public void setE8yljgd(String e8yljgd) {
        this.e8yljgd = e8yljgd;
    }

    public String getE8ksd() {
        return e8ksd;
    }

    public void setE8ksd(String e8ksd) {
        this.e8ksd = e8ksd;
    }

    public BigDecimal getSdlnid() {
        return sdlnid;
    }

    public void setSdlnid(BigDecimal sdlnid) {
        this.sdlnid = sdlnid;
    }

    public String getE8fhdbh() {
        return e8fhdbh;
    }

    public void setE8fhdbh(String e8fhdbh) {
        this.e8fhdbh = e8fhdbh;
    }

    public String getE8ydh() {
        return e8ydh;
    }

    public void setE8ydh(String e8ydh) {
        this.e8ydh = e8ydh;
    }

    public Date getTrdj() {
        return trdj;
    }

    public void setTrdj(Date trdj) {
        this.trdj = trdj;
    }

    public String getE8yyyce() {
        return e8yyyce;
    }

    public void setE8yyyce(String e8yyyce) {
        this.e8yyyce = e8yyyce;
    }

    public String getE8yyycn() {
        return e8yyycn;
    }

    public void setE8yyycn(String e8yyycn) {
        this.e8yyycn = e8yyycn;
    }

    public String getE8spdgg() {
        return e8spdgg;
    }

    public void setE8spdgg(String e8spdgg) {
        this.e8spdgg = e8spdgg;
    }

    public String getE8sccs() {
        return e8sccs;
    }

    public void setE8sccs(String e8sccs) {
        this.e8sccs = e8sccs;
    }

    public String getE8spdcd() {
        return e8spdcd;
    }

    public void setE8spdcd(String e8spdcd) {
        this.e8spdcd = e8spdcd;
    }

    public String getE8spddw() {
        return e8spddw;
    }

    public void setE8spddw(String e8spddw) {
        this.e8spddw = e8spddw;
    }

    public String getLot1() {
        return lot1;
    }

    public void setLot1(String lot1) {
        this.lot1 = lot1;
    }

    public String getLot2() {
        return lot2;
    }

    public void setLot2(String lot2) {
        this.lot2 = lot2;
    }

    public Date getMmej() {
        return mmej;
    }

    public void setMmej(Date mmej) {
        this.mmej = mmej;
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

    public BigDecimal getE8spdbz() {
        return e8spdbz;
    }

    public void setE8spdbz(BigDecimal e8spdbz) {
        this.e8spdbz = e8spdbz;
    }

    public BigDecimal getUorg() {
        return uorg;
    }

    public void setUorg(BigDecimal uorg) {
        this.uorg = uorg;
    }

    public BigDecimal getUprc() {
        return uprc;
    }

    public void setUprc(BigDecimal uprc) {
        this.uprc = uprc;
    }

    public String getCkkq() {
        return ckkq;
    }

    public void setCkkq(String ckkq) {
        this.ckkq = ckkq;
    }

    public Date getAddj() {
        return addj;
    }

    public void setAddj(Date addj) {
        this.addj = addj;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getDlbz() {
        return dlbz;
    }

    public void setDlbz(String dlbz) {
        this.dlbz = dlbz;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    public Date getFprq() {
        return fprq;
    }

    public void setFprq(Date fprq) {
        this.fprq = fprq;
    }

    public Date getMjrq() {
        return mjrq;
    }

    public void setMjrq(Date mjrq) {
        this.mjrq = mjrq;
    }

    public Date getMjsxq() {
        return mjsxq;
    }

    public void setMjsxq(Date mjsxq) {
        this.mjsxq = mjsxq;
    }

    @Override
    public String toString() {
        return "SpdOrderBackDetail{" +
                "lnid=" + lnid +
                ", e8yljgd='" + e8yljgd + '\'' +
                ", e8ksd='" + e8ksd + '\'' +
                ", doco=" + doco +
                ", e8fhdbh='" + e8fhdbh + '\'' +
                ", e8ydh='" + e8ydh + '\'' +
                ", trdj=" + trdj +
                ", e8yyyce='" + e8yyyce + '\'' +
                ", e8yyycn='" + e8yyycn + '\'' +
                ", e8spdgg='" + e8spdgg + '\'' +
                ", e8sccs='" + e8sccs + '\'' +
                ", e8spdcd='" + e8spdcd + '\'' +
                ", e8spddw='" + e8spddw + '\'' +
                ", lot1='" + lot1 + '\'' +
                ", lot2='" + lot2 + '\'' +
                ", mmej=" + mmej +
                ", scrq=" + scrq +
                ", e8spdbz=" + e8spdbz +
                ", uorg=" + uorg +
                ", uprc=" + uprc +
                ", ckkq='" + ckkq + '\'' +
                ", addj=" + addj +
                ", sm='" + sm + '\'' +
                ", tm='" + tm + '\'' +
                ", dlbz='" + dlbz + '\'' +
                ", fph='" + fph + '\'' +
                ", fprq='" + fprq + '\'' +
                ", kcoo='" + kcoo + '\'' +
                ", dcto='" + dcto + '\'' +
                '}';
    }
}