package com.el.cmic.domain.query;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Component
@JSONType(orders = {"配送机构ERP编号", "商品号", "商品名称", "仓库", "单据号", "单据类型", "公司", "日记账行", "库位", "业务数量", "计量单位说明", "批号", "灭菌批号",
        "生产日期", "有效期至", "灭菌失效日期", "灭菌日期","订单号", "订单类型", "订单公司", "订单行号","产品大类","特殊分类","产品分类",
"是否禁用","生产厂家","证照编码","进口/国产/合资","配送机构名称","医疗机构名称","医疗机构ERP编号",
"请购/请退科室名称","请购/请退科室ERP编号","入库/出库科室名称","入库/出库科室ERP编号","业务类型","采购订单号","科室申请单号","医疗器械配送机构内部编号",
"医疗器械配送机构内部名称","批次"})
public class Ve8spdf4111 implements Serializable {
    @JSONField(name = "配送机构ERP编号")
    private String mcco;
    /**
     * null - CRPDTA.VE8SPDF4111.ILLITM
     */
    @JSONField(name = "商品号")
    private String illitm;

    /**
     * null - CRPDTA.VE8SPDF4111.IMDSC1
     */
    @JSONField(name = "商品名称")
    private String imdsc1;

    /**
     * null - CRPDTA.VE8SPDF4111.ILMCU
     */
    @JSONField(name = "仓库")
    private String ilmcu;

    /**
     * null - CRPDTA.VE8SPDF4111.ILDOC
     */
    @JSONField(name = "单据号")
    private BigDecimal ildoc;

    /**
     * null - CRPDTA.VE8SPDF4111.ILDCT
     */
    @JSONField(name = "单据类型")
    private String ildct;

    /**
     * null - CRPDTA.VE8SPDF4111.ILKCO
     */
    @JSONField(name = "公司")
    private String ilkco;

    /**
     * null - CRPDTA.VE8SPDF4111.ILJELN
     */
    @JSONField(name = "日记账行")
    private BigDecimal iljeln;

    /**
     * null - CRPDTA.VE8SPDF4111.ILLOCN
     */
    @JSONField(name = "库位")
    private String illocn;

    /**
     * null - CRPDTA.VE8SPDF4111.ILTRUM
     */
    @JSONField(name = "计量单位", serialize = false)
    private String iltrum;

    /**
     * null - CRPDTA.VE8SPDF4111.DRDL01
     */
    @JSONField(name = "计量单位说明")
    private String drdl01;

    /**
     * null - CRPDTA.VE8SPDF4111.ILTRQT
     */
    @JSONField(name = "业务数量")
    private BigDecimal iltrqt;

    /**
     * null - CRPDTA.VE8SPDF4111.IOLOT1
     */
    @JSONField(name = "批号")
    private String iolot1;

    /**
     * null - CRPDTA.VE8SPDF4111.IOLOT2
     */
    @JSONField(name = "灭菌批号")
    private String iolot2;

    /**
     * null - CRPDTA.VE8SPDF4111.PRODDATE
     */
    @JSONField(name = "生产日期", format = "yyyy-MM-dd")
    private Date proddate;

    /**
     * null - CRPDTA.VE8SPDF4111.LOTINVALIDDATE
     */
    @JSONField(name = "有效期至", format = "yyyy-MM-dd")
    private Date lotinvaliddate;

    /**
     * null - CRPDTA.VE8SPDF4111.LOT2INVALIDDATE
     */
    @JSONField(name = "灭菌失效日期", format = "yyyy-MM-dd")
    private Date lot2invaliddate;

    /**
     * null - CRPDTA.VE8SPDF4111.ILDOCO
     */
    @JSONField(name = "订单号")
    private BigDecimal ildoco;

    /**
     * null - CRPDTA.VE8SPDF4111.ILDCTO
     */
    @JSONField(name = "订单类型")
    private String ildcto;

    /**
     * null - CRPDTA.VE8SPDF4111.ILKCOO
     */
    @JSONField(name = "订单公司")
    private String ilkcoo;

    /**
     * null - CRPDTA.VE8SPDF4111.ILLNID
     */
    @JSONField(name = "订单行号")
    private BigDecimal illnid;

    @JSONField(name = "产品大类")
    private String cpdl;
    @JSONField(name = "特殊分类")
    private String tsfl;
    @JSONField(name = "产品分类")
    private String cpfl;
    @JSONField(name = "灭菌日期", format = "yyyy-MM-dd")
    private Date mjrq;
    @JSONField(name = "是否禁用")
    private String stkt;
    @JSONField(name = "生产厂家")
    private String abalph;
    @JSONField(name = "证照编码")
    private String fce8zzbm;
    @JSONField(name = "进口/国产/合资")
    private String jhg;
    @JSONField(name = "配送机构名称")
    private String phe8psdwn;
    @JSONField(serialize = false)
    private String phe8psdwbe;
    @JSONField(name = "医疗机构名称")
    private String phe8yhyy;
    @JSONField(name = "医疗机构ERP编号")
    private String phe8yhyyn;
    @JSONField(name = "请购/请退科室名称")
    private String phe8yhksn;
    @JSONField(name = "请购/请退科室ERP编号")
    private String phe8yhks;
    @JSONField(name = "入库/出库科室名称")
    private String phe8shksn;
    @JSONField(name = "入库/出库科室ERP编号")
    private String phe8shks;

    @JSONField(name = "业务类型")
    private String phe8qglx;
    @JSONField(name = "采购订单号")
    private String phe8cgdd;
    @JSONField(name = "科室申请单号")
    private String phe8ksd;
    @JSONField(name = "医疗器械配送机构内部编号")
    private String phe8yljgd;
    @JSONField(name = "医疗器械配送机构内部名称")
    private String phe8yyycn;
    @JSONField(name = "批次")
    private String illotn;


    private static final long serialVersionUID = 1L;

    public String getIllitm() {
        return illitm;
    }

    public void setIllitm(String illitm) {
        this.illitm = illitm;
    }

    public String getImdsc1() {
        return imdsc1;
    }

    public void setImdsc1(String imdsc1) {
        this.imdsc1 = imdsc1;
    }

    public String getIlmcu() {
        return ilmcu;
    }

    public void setIlmcu(String ilmcu) {
        this.ilmcu = ilmcu;
    }

    public BigDecimal getIldoc() {
        return ildoc;
    }

    public void setIldoc(BigDecimal ildoc) {
        this.ildoc = ildoc;
    }

    public String getIldct() {
        return ildct;
    }

    public void setIldct(String ildct) {
        this.ildct = ildct;
    }

    public String getIlkco() {
        return ilkco;
    }

    public void setIlkco(String ilkco) {
        this.ilkco = ilkco;
    }

    public BigDecimal getIljeln() {
        return iljeln;
    }

    public void setIljeln(BigDecimal iljeln) {
        this.iljeln = iljeln;
    }

    public String getIllocn() {
        return illocn;
    }

    public void setIllocn(String illocn) {
        this.illocn = illocn;
    }

    public String getIltrum() {
        return iltrum;
    }

    public void setIltrum(String iltrum) {
        this.iltrum = iltrum;
    }

    public String getDrdl01() {
        return drdl01;
    }

    public void setDrdl01(String drdl01) {
        this.drdl01 = drdl01;
    }

    public BigDecimal getIltrqt() {
        return iltrqt;
    }

    public void setIltrqt(BigDecimal iltrqt) {
        this.iltrqt = iltrqt;
    }

    public String getIolot1() {
        return iolot1;
    }

    public void setIolot1(String iolot1) {
        this.iolot1 = iolot1;
    }

    public String getIolot2() {
        return iolot2;
    }

    public void setIolot2(String iolot2) {
        this.iolot2 = iolot2;
    }

    public Date getProddate() {
        return proddate;
    }

    public void setProddate(Date proddate) {
        this.proddate = proddate;
    }

    public Date getLotinvaliddate() {
        return lotinvaliddate;
    }

    public void setLotinvaliddate(Date lotinvaliddate) {
        this.lotinvaliddate = lotinvaliddate;
    }

    public Date getLot2invaliddate() {
        return lot2invaliddate;
    }

    public void setLot2invaliddate(Date lot2invaliddate) {
        this.lot2invaliddate = lot2invaliddate;
    }

    public BigDecimal getIldoco() {
        return ildoco;
    }

    public void setIldoco(BigDecimal ildoco) {
        this.ildoco = ildoco;
    }

    public String getIldcto() {
        return ildcto;
    }

    public void setIldcto(String ildcto) {
        this.ildcto = ildcto;
    }

    public String getIlkcoo() {
        return ilkcoo;
    }

    public void setIlkcoo(String ilkcoo) {
        this.ilkcoo = ilkcoo;
    }

    public BigDecimal getIllnid() {
        return illnid;
    }

    public void setIllnid(BigDecimal illnid) {
        this.illnid = illnid;
    }

    public String getMcco() {
        return mcco;
    }

    public void setMcco(String mcco) {
        this.mcco = mcco;
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

    public Date getMjrq() {
        return mjrq;
    }

    public void setMjrq(Date mjrq) {
        this.mjrq = mjrq;
    }

    public String getStkt() {
        return stkt;
    }

    public void setStkt(String stkt) {
        this.stkt = stkt;
    }

    public String getAbalph() {
        return abalph;
    }

    public void setAbalph(String abalph) {
        this.abalph = abalph;
    }

    public String getFce8zzbm() {
        return fce8zzbm;
    }

    public void setFce8zzbm(String fce8zzbm) {
        this.fce8zzbm = fce8zzbm;
    }

    public String getJhg() {
        return jhg;
    }

    public void setJhg(String jhg) {
        this.jhg = jhg;
    }

    public String getPhe8psdwn() {
        return phe8psdwn;
    }

    public void setPhe8psdwn(String phe8psdwn) {
        this.phe8psdwn = phe8psdwn;
    }

    public String getPhe8psdwbe() {
        return phe8psdwbe;
    }

    public void setPhe8psdwbe(String phe8psdwbe) {
        this.phe8psdwbe = phe8psdwbe;
    }

    public String getPhe8yhyy() {
        return phe8yhyy;
    }

    public void setPhe8yhyy(String phe8yhyy) {
        this.phe8yhyy = phe8yhyy;
    }

    public String getPhe8yhyyn() {
        return phe8yhyyn;
    }

    public void setPhe8yhyyn(String phe8yhyyn) {
        this.phe8yhyyn = phe8yhyyn;
    }

    public String getPhe8yhksn() {
        return phe8yhksn;
    }

    public void setPhe8yhksn(String phe8yhksn) {
        this.phe8yhksn = phe8yhksn;
    }

    public String getPhe8yhks() {
        return phe8yhks;
    }

    public void setPhe8yhks(String phe8yhks) {
        this.phe8yhks = phe8yhks;
    }

    public String getPhe8shksn() {
        return phe8shksn;
    }

    public void setPhe8shksn(String phe8shksn) {
        this.phe8shksn = phe8shksn;
    }

    public String getPhe8shks() {
        return phe8shks;
    }

    public void setPhe8shks(String phe8shks) {
        this.phe8shks = phe8shks;
    }

    public String getPhe8qglx() {
        return phe8qglx;
    }

    public void setPhe8qglx(String phe8qglx) {
        this.phe8qglx = phe8qglx;
    }

    public String getPhe8cgdd() {
        return phe8cgdd;
    }

    public void setPhe8cgdd(String phe8cgdd) {
        this.phe8cgdd = phe8cgdd;
    }

    public String getPhe8ksd() {
        return phe8ksd;
    }

    public void setPhe8ksd(String phe8ksd) {
        this.phe8ksd = phe8ksd;
    }

    public String getPhe8yljgd() {
        return phe8yljgd;
    }

    public void setPhe8yljgd(String phe8yljgd) {
        this.phe8yljgd = phe8yljgd;
    }

    public String getPhe8yyycn() {
        return phe8yyycn;
    }

    public void setPhe8yyycn(String phe8yyycn) {
        this.phe8yyycn = phe8yyycn;
    }

    public String getIllotn() {
        return illotn;
    }

    public void setIllotn(String illotn) {
        this.illotn = illotn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", illitm=").append(illitm);
        sb.append(", imdsc1=").append(imdsc1);
        sb.append(", ilmcu=").append(ilmcu);
        sb.append(", ildoc=").append(ildoc);
        sb.append(", ildct=").append(ildct);
        sb.append(", ilkco=").append(ilkco);
        sb.append(", iljeln=").append(iljeln);
        sb.append(", illocn=").append(illocn);
        sb.append(", iltrum=").append(iltrum);
        sb.append(", drdl01=").append(drdl01);
        sb.append(", iltrqt=").append(iltrqt);
        sb.append(", iolot1=").append(iolot1);
        sb.append(", iolot2=").append(iolot2);
        sb.append(", proddate=").append(proddate);
        sb.append(", lotinvaliddate=").append(lotinvaliddate);
        sb.append(", lot2invaliddate=").append(lot2invaliddate);
        sb.append(", ildoco=").append(ildoco);
        sb.append(", ildcto=").append(ildcto);
        sb.append(", ilkcoo=").append(ilkcoo);
        sb.append(", illnid=").append(illnid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}