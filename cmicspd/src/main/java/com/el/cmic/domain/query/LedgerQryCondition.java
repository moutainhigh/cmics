package com.el.cmic.domain.query;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Vincent on 2017/1/17.
 */
public class LedgerQryCondition {
    @JSONField(name = "配送机构ERP编号")
    private String erpco;
    @JSONField(name = "商品号")
    private String litm;
    @JSONField(name = "仓库")
    private String mcu;
    @JSONField(name = "库位")
    private String locn;
    @JSONField(name = "批次")
    private String lotn;
    @JSONField(name = "订单号")
    private String doco;
    @JSONField(name = "订单类型")
    private String dcto;
    @JSONField(name = "订单公司")
    private String kcoo;
    @JSONField(name = "订单行号")
    private String lnid;
    @JSONField(name = "产品大类")
    private String cpdl;
    @JSONField(name = "特殊分类")
    private String tsfl;
    @JSONField(name = "产品分类")
    private String cpfl;
    @JSONField(name = "是否禁用")
    private String stkt;//Y禁用，N启用
    @JSONField(name = "生产厂家")
    private String alph;
    @JSONField(name = "证照编码")
    private String ebzzbm;

    @JSONField(name = "起始行")
    private int startRowNum;
    @JSONField(name = "截止行")
    private int endRowNum;

    public String getKcoo() {
        return kcoo;
    }

    public void setKcoo(String kcoo) {
        this.kcoo = kcoo;
    }

    public String getLitm() {
        return litm;
    }

    public void setLitm(String litm) {
        this.litm = litm;
    }

    public int getStartRowNum() {
        return startRowNum;
    }

    public void setStartRowNum(int startRowNum) {
        this.startRowNum = startRowNum;
    }

    public int getEndRowNum() {
        return endRowNum;
    }

    public void setEndRowNum(int endRowNum) {
        this.endRowNum = endRowNum;
    }

    public String getErpco() {
        return erpco;
    }

    public void setErpco(String erpco) {
        this.erpco = erpco;
    }

    public String getMcu() {
        return mcu;
    }

    public void setMcu(String mcu) {
        this.mcu = mcu;
    }

    public String getLocn() {
        return locn;
    }

    public void setLocn(String locn) {
        this.locn = locn;
    }

    public String getLotn() {
        return lotn;
    }

    public void setLotn(String lotn) {
        this.lotn = lotn;
    }

    public String getDoco() {
        return doco;
    }

    public void setDoco(String doco) {
        this.doco = doco;
    }

    public String getDcto() {
        return dcto;
    }

    public void setDcto(String dcto) {
        this.dcto = dcto;
    }

    public String getLnid() {
        return lnid;
    }

    public void setLnid(String lnid) {
        this.lnid = lnid;
    }

    public String getCpdl() {
        return cpdl;
    }

    public void setCpdl(String cpdl) {
        this.cpdl = cpdl;
    }

    public String getTsfl() {
        return tsfl;
    }

    public void setTsfl(String tsfl) {
        this.tsfl = tsfl;
    }

    public String getCpfl() {
        return cpfl;
    }

    public void setCpfl(String cpfl) {
        this.cpfl = cpfl;
    }

    public String getStkt() {
        return stkt;
    }

    public void setStkt(String stkt) {
        this.stkt = stkt;
    }

    public String getAlph() {
        return alph;
    }

    public void setAlph(String alph) {
        this.alph = alph;
    }

    public String getEbzzbm() {
        return ebzzbm;
    }

    public void setEbzzbm(String ebzzbm) {
        this.ebzzbm = ebzzbm;
    }
}
