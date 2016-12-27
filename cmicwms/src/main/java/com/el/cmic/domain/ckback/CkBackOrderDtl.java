package com.el.cmic.domain.ckback;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 2016/10/26.
 */
@JSONType(orders = {"通知单行号", "货品编号", "批号", "灭菌批号", "库类型", "出库数量", "差异数量", "开票数量", "出库日期",
        "货品名称", "有效期至", "生产日期", "包装", "说明", "打包流水号", "币种", "汇率",
        "原币金额", "本币金额", "快递信息", "装箱打包号", "序列号明细"})
public class CkBackOrderDtl {
    @JSONField(name = "通知单行号")
    private String lnid;
    @JSONField(name = "货品编号")
    private String litm;
    @JSONField(name = "批号")
    private String ptut01;
    @JSONField(name = "灭菌批号")
    private String ptut02;
    @JSONField(name = "库类型")
    private int ca02;
    @JSONField(name = "出库数量")
    private BigDecimal uprc;
    @JSONField(name = "差异数量")
    private BigDecimal prrc;
    @JSONField(name = "开票数量")
    private BigDecimal amc3;
    @JSONField(name = "出库日期",format = "yyyy-MM-dd")
    private Date trdj;
    @JSONField(name = "货品名称")
    private String e8name;
    @JSONField(name = "有效期至",format = "yyyy-MM-dd")
    private Date pefj;
    @JSONField(name = "生产日期",format = "yyyy-MM-dd")
    private Date psdj;
    @JSONField(name = "灭菌日期",format = "yyyy-MM-dd")
    private Date lot2Date;
    @JSONField(name = "灭菌批号有效期至",format = "yyyy-MM-dd")
    private Date lot2InvalidDate;
    @JSONField(name = "包装")
    private BigDecimal grwt;
    @JSONField(name = "说明")
    private String remark;
    @JSONField(name = "打包流水号")
    private String packLineNo;
    @JSONField(name = "币种")
    private String currency;
    @JSONField(name = "汇率")
    private BigDecimal exchangeRate;
    @JSONField(name = "原币金额")
    private BigDecimal origTotal;
    @JSONField(name = "本币金额")
    private BigDecimal localTotal;
    @JSONField(name = "快递信息")
    private String deliveryInfo;
    @JSONField(name = "装箱打包号")
    private String packageNum;
    @JSONField(name = "序列号明细")
   private List<CkBackSequence> ckBackSequenceList;

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

    public String getLnid() {
        return lnid;
    }

    public void setLnid(String lnid) {
        this.lnid = lnid;
    }

    public String getLitm() {
        return litm;
    }

    public void setLitm(String litm) {
        this.litm = litm;
    }

    public String getPtut01() {
        return ptut01;
    }

    public void setPtut01(String ptut01) {
        this.ptut01 = ptut01;
    }

    public String getPtut02() {
        return ptut02;
    }

    public void setPtut02(String ptut02) {
        this.ptut02 = ptut02;
    }

    public int getCa02() {
        return ca02;
    }

    public void setCa02(int ca02) {
        this.ca02 = ca02;
    }

    public BigDecimal getUprc() {
        return uprc;
    }

    public void setUprc(BigDecimal uprc) {
        this.uprc = uprc;
    }

    public BigDecimal getPrrc() {
        return prrc;
    }

    public void setPrrc(BigDecimal prrc) {
        this.prrc = prrc;
    }

    public BigDecimal getAmc3() {
        return amc3;
    }

    public void setAmc3(BigDecimal amc3) {
        this.amc3 = amc3;
    }

    public Date getTrdj() {
        return trdj;
    }

    public void setTrdj(Date trdj) {
        this.trdj = trdj;
    }

    public String getE8name() {
        return e8name;
    }

    public void setE8name(String e8name) {
        this.e8name = e8name;
    }

    public Date getPefj() {
        return pefj;
    }

    public void setPefj(Date pefj) {
        this.pefj = pefj;
    }

    public Date getPsdj() {
        return psdj;
    }

    public void setPsdj(Date psdj) {
        this.psdj = psdj;
    }

    public BigDecimal getGrwt() {
        return grwt;
    }

    public void setGrwt(BigDecimal grwt) {
        this.grwt = grwt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPackLineNo() {
        return packLineNo;
    }

    public void setPackLineNo(String packLineNo) {
        this.packLineNo = packLineNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getOrigTotal() {
        return origTotal;
    }

    public void setOrigTotal(BigDecimal origTotal) {
        this.origTotal = origTotal;
    }

    public BigDecimal getLocalTotal() {
        return localTotal;
    }

    public void setLocalTotal(BigDecimal localTotal) {
        this.localTotal = localTotal;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public String getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(String packageNum) {
        this.packageNum = packageNum;
    }

    public List<CkBackSequence> getCkBackSequenceList() {
        return ckBackSequenceList;
    }

    public void setCkBackSequenceList(List<CkBackSequence> ckBackSequenceList) {
        this.ckBackSequenceList = ckBackSequenceList;
    }
}
