package com.el.cmic.domain.ckcancelback;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 2016/10/29.
 */
@JSONType(orders = {"物流中心", "出库类型", "货主", "通知单号", "客户编号", "客户名称", "业务员", "通知单日期", "订单类型", "通知单明细"})

public class CkCancelBackOrder {
    @JSONField(name = "物流中心")
    private int wmsmcu;
    @JSONField(serialize = false)
    private int mcu;
    @JSONField(name = "出库类型")
    private String dl02;
    @JSONField(name = "货主")
    private String wmskcoo;
    @JSONField(serialize = false)
    private String kcco;
    @JSONField(name = "通知单号")
    private String doco;
    @JSONField(name = "客户编号")
    private String an8;
    @JSONField(name = "客户名称")
    private String e8name;
    @JSONField(name = "业务员")
    private String dl01;
    @JSONField(name = "通知单日期", format = "yyyy-MM-dd")
    private Date trdj;
    @JSONField(name = "订单类型")
    private String dcto;
    @JSONField(name = "通知单明细")
    private List<CkCancelBackOrderDtl> ckCancelBackOrderDtl;

    public int getMcu() {
        return mcu;
    }

    public int getWmsmcu() {
        return wmsmcu;
    }

    public void setWmsmcu(int wmsmcu) {
        this.wmsmcu = wmsmcu;
    }

    public String getWmskcoo() {
        return wmskcoo;
    }

    public void setWmskcoo(String wmskcoo) {
        this.wmskcoo = wmskcoo;
    }

    public void setMcu(int mcu) {
        this.mcu = mcu;
    }

    public String getDl02() {
        return dl02;
    }

    public void setDl02(String dl02) {
        this.dl02 = dl02;
    }

    public String getKcco() {
        return kcco;
    }

    public void setKcco(String kcco) {
        this.kcco = kcco;
    }

    public String getDoco() {
        return doco;
    }

    public void setDoco(String doco) {
        this.doco = doco;
    }

    public String getAn8() {
        return an8;
    }

    public void setAn8(String an8) {
        this.an8 = an8;
    }

    public String getE8name() {
        return e8name;
    }

    public void setE8name(String e8name) {
        this.e8name = e8name;
    }

    public String getDl01() {
        return dl01;
    }

    public void setDl01(String dl01) {
        this.dl01 = dl01;
    }

    public Date getTrdj() {
        return trdj;
    }

    public void setTrdj(Date trdj) {
        this.trdj = trdj;
    }

    public String getDcto() {
        return dcto;
    }

    public void setDcto(String dcto) {
        this.dcto = dcto;
    }

    public List<CkCancelBackOrderDtl> getCkCancelBackOrderDtl() {
        return ckCancelBackOrderDtl;
    }

    public void setCkCancelBackOrderDtl(List<CkCancelBackOrderDtl> ckCancelBackOrderDtl) {
        this.ckCancelBackOrderDtl = ckCancelBackOrderDtl;
    }
}
