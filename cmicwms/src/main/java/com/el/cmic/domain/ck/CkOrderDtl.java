package com.el.cmic.domain.ck;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 2016/10/25.
 */
@JSONType(orders = {"通知单行号","货品编号","数量","库类型","批号","灭菌批号","预发货日期","货品名称"
,"单价","优惠价","金额","有效期至","生产日期","批号选择要求","是否促销批号","零售价","币种","原币金额",
"汇率","子表ID","灭菌日期","灭菌批号有效期至","序列号明细"})
public class CkOrderDtl {
    @JSONField(serialize = false)
    private String co;

    @JSONField(serialize = false)
    private BigDecimal doco;

    @JSONField(serialize = false)
    private String dcto;

    @JSONField(name = "通知单行号")
    private BigDecimal lnid;

    @JSONField(name = "货品编号")
    private String litm;
    @JSONField(name = "数量")
    private BigDecimal uorg;
    @JSONField(name = "库类型")
    private int kType;
    @JSONField(name = "批号")
    private String lot1;

    @JSONField(name = "灭菌批号")
    private String lot2;

    @JSONField(name = "预发货日期",format = "yyyy-MM-dd")
    private Date yfhDate;
    @JSONField(name = "货品名称")
    private String dsc1;

    @JSONField(name = "单价")
    private BigDecimal uprc;
    @JSONField(name = "优惠价")
    private BigDecimal discountPrc;
    @JSONField(name = "金额")
    private BigDecimal aexp;
    @JSONField(name = "有效期至",format = "yyyy-MM-dd")
    private Date invalidDate;
    @JSONField(name = "生产日期",format = "yyyy-MM-dd")
    private Date productDate;
    @JSONField(name = "灭菌日期",format = "yyyy-MM-dd")
    private Date lot2Date;
    @JSONField(name = "灭菌批号有效期至",format = "yyyy-MM-dd")
    private Date lot2InvalidDate;
    @JSONField(name = "批号选择要求")
    private int lotRequirement = 0;
    @JSONField(name = "是否促销批号")
    private int promLotFlag = 0;
    @JSONField(name = "零售价")
    private BigDecimal salePrice;
    @JSONField(name = "币种")
    private String currency;
    @JSONField(name = "原币金额")
    private BigDecimal originalAexp;
    @JSONField(name = "汇率")
    private BigDecimal rate;
    @JSONField(name = "子表ID")
    private int subTblId;
    @JSONField(name = "序列号明细", serialzeFeatures = {SerializerFeature.WriteNullListAsEmpty})
    private List<Object> serialList;

    @JSONField(serialize = false)
    private String flag;

    /**
     * null - VE8CK002.UKID
     */
    @JSONField(serialize = false)
    private BigDecimal ukid;

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
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

    public BigDecimal getLnid() {
        return lnid;
    }

    public void setLnid(BigDecimal lnid) {
        this.lnid = lnid;
    }

    public String getLitm() {
        return litm;
    }

    public void setLitm(String litm) {
        this.litm = litm;
    }

    public BigDecimal getUorg() {
        return uorg;
    }

    public void setUorg(BigDecimal uorg) {
        this.uorg = uorg;
    }

    public int getkType() {
        return kType;
    }

    public void setkType(int kType) {
        this.kType = kType;
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

    public Date getLot2Date() {
        return lot2Date;
    }

    public void setLot2Date(Date lot2Date) {
        this.lot2Date = lot2Date;
    }

    public Date getLot2InvalidDate() {
        return lot2InvalidDate;
    }

    public void setLot2InvalidDate(Date lot2InvalidDate) {
        this.lot2InvalidDate = lot2InvalidDate;
    }

    public Date getYfhDate() {
        return yfhDate;
    }

    public void setYfhDate(Date yfhDate) {
        this.yfhDate = yfhDate;
    }

    public String getDsc1() {
        return dsc1;
    }

    public void setDsc1(String dsc1) {
        this.dsc1 = dsc1;
    }

    public BigDecimal getUprc() {
        return uprc;
    }

    public void setUprc(BigDecimal uprc) {
        this.uprc = uprc;
    }

    public BigDecimal getDiscountPrc() {
        return discountPrc;
    }

    public void setDiscountPrc(BigDecimal discountPrc) {
        this.discountPrc = discountPrc;
    }

    public BigDecimal getAexp() {
        return aexp;
    }

    public void setAexp(BigDecimal aexp) {
        this.aexp = aexp;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public int getLotRequirement() {
        return lotRequirement;
    }

    public void setLotRequirement(int lotRequirement) {
        this.lotRequirement = lotRequirement;
    }

    public int getPromLotFlag() {
        return promLotFlag;
    }

    public void setPromLotFlag(int promLotFlag) {
        this.promLotFlag = promLotFlag;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getOriginalAexp() {
        return originalAexp;
    }

    public void setOriginalAexp(BigDecimal originalAexp) {
        this.originalAexp = originalAexp;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public int getSubTblId() {
        return subTblId;
    }

    public void setSubTblId(int subTblId) {
        this.subTblId = subTblId;
    }

    public List<Object> getSerialList() {
        return serialList;
    }

    public void setSerialList(List<Object> serialList) {
        this.serialList = serialList;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getUkid() {
        return ukid;
    }

    public void setUkid(BigDecimal ukid) {
        this.ukid = ukid;
    }
}
