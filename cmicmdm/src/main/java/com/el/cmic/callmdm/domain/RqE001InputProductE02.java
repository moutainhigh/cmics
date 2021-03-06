package com.el.cmic.callmdm.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Vincent on 2016/9/20.
 */
@XmlRootElement(name = "main")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"doco","ev01","litm","kcoo","productcode", "productname", "producttype", "pk_mfname", "mfname", "pk_mfcountry", "form", "sync", "fileno", "pk_weight", "pk_zdypdl", "pk_jhg", "pk_ztw"
        , "pk_fgjyw", "pk_ptyp", "basecode", "customscode", "atccode", "atcname", "pk_atcdl", "pk_atcxl","modcause","creator","creationtime","creatcause","SZEDUS","SZEDBT","SZEDTN","SZEDLN"})
public class RqE001InputProductE02 {
    private String doco;
    private String ev01;
    private String litm;

    private String kcoo;

    private String productcode = "";// <productcode>产品编码</productcode>
    private String productname = "";//<productname>产品名称(通用名)</productname>
    private String producttype = "";//    <producttype>规格型号</producttype>
    private String pk_mfname = "";//<pk_mfname>生产厂家</pk_mfname>
    private String mfname = "";//<mfname>厂家</mfname>
    private String pk_mfcountry = "";//<pk_mfcountry>生产国</pk_mfcountry>
    private String form = ""; //<form>剂型</form>
    private String sync = "";//<sync>商品名</sync>
    private String fileno = "";//<fileno>批准文号</fileno>
    private String pk_weight = "";//<pk_weight>最小包装单位</pk_weight>
    private String pk_zdypdl = "";//<pk_zdypdl>诊断药品大类</pk_zdypdl>
    private String pk_jhg = ""; //<pk_jhg>进口/合资/国产</pk_jhg>
    private String pk_ztw = "";//<pk_ztw>自产/贴牌/外产</pk_ztw>
    private String pk_fgjyw = "";//<pk_fgjyw>国家/非国家基本药物</pk_fgjyw>
    private String pk_ptyp = "";//<pk_ptyp>普通/特殊药品</pk_ptyp>
    private String basecode = "";//<basecode>本位码</basecode>
    private String customscode = "";//<customscode>海关码</customscode>
    private String atccode = ""; //<atccode>ATC码</atccode>
    private String atcname = ""; //<atcname>ATC通用名</atcname>
    private String pk_atcdl = "";//<pk_atcdl>ATC大类</pk_atcdl>
    private String pk_atcxl = "";// <pk_atcxl>ATC小类</pk_atcxl>

    private String modcause = "";//变更原因 1025

    private String creator="";
    private String creationtime="";
    private String creatcause ="";

    private String SZEDUS;
    private String SZEDBT;
    private String SZEDTN;
    private String SZEDLN;

    public String getSZEDUS() {
        return SZEDUS;
    }

    public void setSZEDUS(String SZEDUS) {
        this.SZEDUS = SZEDUS;
    }

    public String getSZEDBT() {
        return SZEDBT;
    }

    public void setSZEDBT(String SZEDBT) {
        this.SZEDBT = SZEDBT;
    }

    public String getSZEDTN() {
        return SZEDTN;
    }

    public void setSZEDTN(String SZEDTN) {
        this.SZEDTN = SZEDTN;
    }

    public String getSZEDLN() {
        return SZEDLN;
    }

    public void setSZEDLN(String SZEDLN) {
        this.SZEDLN = SZEDLN;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getCreatcause() {
        return creatcause;
    }

    public void setCreatcause(String creatcause) {
        this.creatcause = creatcause;
    }

    public String getKcoo() {
        return kcoo;
    }

    public void setKcoo(String kcoo) {
        this.kcoo = kcoo;
    }

    public String getModcause() {
        return modcause;
    }

    public void setModcause(String modcause) {
        this.modcause = modcause;
    }

    public String getLitm() {
        return litm;
    }

    public void setLitm(String litm) {
        this.litm = litm;
    }

    public String getDoco() {
        return doco;
    }

    public void setDoco(String doco) {
        this.doco = doco;
    }

    public String getEv01() {
        return ev01;
    }

    public void setEv01(String ev01) {
        this.ev01 = ev01;
    }

    public String getPk_mfname() {
        return pk_mfname;
    }

    public void setPk_mfname(String pk_mfname) {
        this.pk_mfname = pk_mfname;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getMfname() {
        return mfname;
    }

    public void setMfname(String mfname) {
        this.mfname = mfname;
    }

    public String getPk_mfcountry() {
        return pk_mfcountry;
    }

    public void setPk_mfcountry(String pk_mfcountry) {
        this.pk_mfcountry = pk_mfcountry;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getPk_weight() {
        return pk_weight;
    }

    public void setPk_weight(String pk_weight) {
        this.pk_weight = pk_weight;
    }

    public String getPk_zdypdl() {
        return pk_zdypdl;
    }

    public void setPk_zdypdl(String pk_zdypdl) {
        this.pk_zdypdl = pk_zdypdl;
    }

    public String getPk_jhg() {
        return pk_jhg;
    }

    public void setPk_jhg(String pk_jhg) {
        this.pk_jhg = pk_jhg;
    }

    public String getPk_ztw() {
        return pk_ztw;
    }

    public void setPk_ztw(String pk_ztw) {
        this.pk_ztw = pk_ztw;
    }

    public String getPk_fgjyw() {
        return pk_fgjyw;
    }

    public void setPk_fgjyw(String pk_fgjyw) {
        this.pk_fgjyw = pk_fgjyw;
    }

    public String getPk_ptyp() {
        return pk_ptyp;
    }

    public void setPk_ptyp(String pk_ptyp) {
        this.pk_ptyp = pk_ptyp;
    }

    public String getBasecode() {
        return basecode;
    }

    public void setBasecode(String basecode) {
        this.basecode = basecode;
    }

    public String getCustomscode() {
        return customscode;
    }

    public void setCustomscode(String customscode) {
        this.customscode = customscode;
    }

    public String getAtccode() {
        return atccode;
    }

    public void setAtccode(String atccode) {
        this.atccode = atccode;
    }

    public String getAtcname() {
        return atcname;
    }

    public void setAtcname(String atcname) {
        this.atcname = atcname;
    }

    public String getPk_atcdl() {
        return pk_atcdl;
    }

    public void setPk_atcdl(String pk_atcdl) {
        this.pk_atcdl = pk_atcdl;
    }

    public String getPk_atcxl() {
        return pk_atcxl;
    }

    public void setPk_atcxl(String pk_atcxl) {
        this.pk_atcxl = pk_atcxl;
    }

    @Override
    public String toString() {
        return "RqE001InputProductE02{" +
                "doco='" + doco + '\'' +
                ", ev01='" + ev01 + '\'' +
                ", litm='" + litm + '\'' +
                ", kcoo='" + kcoo + '\'' +
                ", productcode='" + productcode + '\'' +
                ", productname='" + productname + '\'' +
                ", producttype='" + producttype + '\'' +
                ", pk_mfname='" + pk_mfname + '\'' +
                ", mfname='" + mfname + '\'' +
                ", pk_mfcountry='" + pk_mfcountry + '\'' +
                ", form='" + form + '\'' +
                ", sync='" + sync + '\'' +
                ", fileno='" + fileno + '\'' +
                ", pk_weight='" + pk_weight + '\'' +
                ", pk_zdypdl='" + pk_zdypdl + '\'' +
                ", pk_jhg='" + pk_jhg + '\'' +
                ", pk_ztw='" + pk_ztw + '\'' +
                ", pk_fgjyw='" + pk_fgjyw + '\'' +
                ", pk_ptyp='" + pk_ptyp + '\'' +
                ", basecode='" + basecode + '\'' +
                ", customscode='" + customscode + '\'' +
                ", atccode='" + atccode + '\'' +
                ", atcname='" + atcname + '\'' +
                ", pk_atcdl='" + pk_atcdl + '\'' +
                ", pk_atcxl='" + pk_atcxl + '\'' +
                ", modcause='" + modcause + '\'' +
                ", creator='" + creator + '\'' +
                ", creationtime='" + creationtime + '\'' +
                ", creatcause='" + creatcause + '\'' +
                ", SZEDUS='" + SZEDUS + '\'' +
                ", SZEDBT='" + SZEDBT + '\'' +
                ", SZEDTN='" + SZEDTN + '\'' +
                ", SZEDLN='" + SZEDLN + '\'' +
                '}';
    }
}
