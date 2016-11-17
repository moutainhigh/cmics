package com.el.cmic.domain.revert;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.el.utils.DateUtil;

/**
 * 结算明细 
 * @author zhanhao
 *
 */
public class RevertDataDetail {
	
	 /**
     *  null - FE8SPD15.QMUKID
     */
    private BigDecimal qmukid;
    
    /**
     *  null - FE8SPD15.QMRLLN
     */
    private BigDecimal qmrlln;
    
    /**
     *  null - FE8SPD15.QMEV01
     */
    private String qmev01;
    
    /**
     *  退货单行号 - FE8SPD15.QMLNID
     */
    @JSONField(name = "退货单行号")
    private BigDecimal qmlnid;
    
    /**
     *  原医院请购单号  - FE8SPD15.QME8YYQGD
     */
    @JSONField(name = "原医院请购单号")
    private String qme8yyqgd;
    
    /**
     *  原科室请购单号 - FE8SPD15.QME8KSQGD
     */
    @JSONField(name = "原科室请购单号")
    private String qme8ksqgd;
    
    /**
     *  医药医材编号 - FE8SPD15.QME8YYYCD
     */
    @JSONField(name = "医药医材编号")
    private String qme8yyycd;
    
    /**
     *  医药医材ERP编号  - FE8SPD15.QME8YYYCE
     */
    @JSONField(name = "医药医材ERP编号")
    private String qme8yyyce;
    
    /**
     *  医药医材名称 - FE8SPD15.QME8YYYCN
     */
    @JSONField(name = "医药医材名称")
    private String qme8yyycn;
    
    /**
     *  规格  - FE8SPD15.QME8SPDGG
     */
    @JSONField(name = "规格")
    private String qme8spdgg;

    /**
     *  生产厂商 - FE8SPD15.QME8SCCS
     */
    @JSONField(name = "生产厂商")
    private String qme8sccs;
    
    /**
     *  产地  - FE8SPD15.QME8SPDCD
     */
    @JSONField(name = "产地")
    private String qme8spdcd;
    
    /**
     *  单位  - FE8SPD15.QME8SPDDW
     */
    @JSONField(name = "单位")
    private String qme8spddw;
    
    /**
     *  批号 - FE8SPD15.QMLOT1
     */
    @JSONField(name = "批号")
    private String qmlot1;
    

    /**
     *  灭菌批号  - FE8SPD15.QMLOT2
     */
    @JSONField(name = "灭菌批号")
    private String qmlot2;
    
    /**
     *  库存类型 - FE8SPD15.QME8KCLX
     */
    @JSONField(name = "库存类型")
    private String qme8kclx;
    
    /**
     *  有效期至  - FE8SPD15.QME8YXQ
     */
    @JSONField(name = "有效期至")
    private String qme8yxq;
    
    /**
     *  生产日期  - FE8SPD15.QME8SCRQ
     */
    @JSONField(name = "生产日期")
    private String qme8scrq;

    /**
     *  包装 - FE8SPD15.QME8SPDBZ
     */
    @JSONField(name = "包装")
    private BigDecimal qme8spdbz;
    
    /**
     *  数量 - FE8SPD15.QMUORG
     */
    @JSONField(name = "数量")
    private BigDecimal qmuorg;
    
    /**
     *  入库类型 - FE8SPD15.QME8RKLX
     */
    @JSONField(name = "入库类型")
    private BigDecimal qme8rklx;

	public BigDecimal getQmukid() {
		return qmukid;
	}

	public void setQmukid(BigDecimal qmukid) {
		this.qmukid = qmukid;
	}

	public BigDecimal getQmrlln() {
		return qmrlln;
	}

	public void setQmrlln(BigDecimal qmrlln) {
		this.qmrlln = qmrlln;
	}

	public String getQmev01() {
		return qmev01;
	}

	public void setQmev01(String qmev01) {
		this.qmev01 = qmev01;
	}

	public BigDecimal getQmlnid() {
		return qmlnid;
	}

	public void setQmlnid(BigDecimal qmlnid) {
		this.qmlnid = qmlnid;
	}

	public String getQme8yyqgd() {
		return qme8yyqgd;
	}

	public void setQme8yyqgd(String qme8yyqgd) {
		this.qme8yyqgd = qme8yyqgd;
	}

	public String getQme8ksqgd() {
		return qme8ksqgd;
	}

	public void setQme8ksqgd(String qme8ksqgd) {
		this.qme8ksqgd = qme8ksqgd;
	}

	public String getQme8yyycd() {
		return qme8yyycd;
	}

	public void setQme8yyycd(String qme8yyycd) {
		this.qme8yyycd = qme8yyycd;
	}

	public String getQme8yyyce() {
		return qme8yyyce;
	}

	public void setQme8yyyce(String qme8yyyce) {
		this.qme8yyyce = qme8yyyce;
	}

	public String getQme8yyycn() {
		return qme8yyycn;
	}

	public void setQme8yyycn(String qme8yyycn) {
		this.qme8yyycn = qme8yyycn;
	}

	public String getQme8spdgg() {
		return qme8spdgg;
	}

	public void setQme8spdgg(String qme8spdgg) {
		this.qme8spdgg = qme8spdgg;
	}

	public String getQme8sccs() {
		return qme8sccs;
	}

	public void setQme8sccs(String qme8sccs) {
		this.qme8sccs = qme8sccs;
	}

	public String getQme8spdcd() {
		return qme8spdcd;
	}

	public void setQme8spdcd(String qme8spdcd) {
		this.qme8spdcd = qme8spdcd;
	}

	public String getQme8spddw() {
		return qme8spddw;
	}

	public void setQme8spddw(String qme8spddw) {
		this.qme8spddw = qme8spddw;
	}

	public String getQmlot1() {
		return qmlot1;
	}

	public void setQmlot1(String qmlot1) {
		this.qmlot1 = qmlot1;
	}

	public String getQmlot2() {
		return qmlot2;
	}

	public void setQmlot2(String qmlot2) {
		this.qmlot2 = qmlot2;
	}

	public String getQme8kclx() {
		return qme8kclx;
	}

	public void setQme8kclx(String qme8kclx) {
		this.qme8kclx = qme8kclx;
	}

	public String getQme8yxq() {
		return qme8yxq;
	}

	public void setQme8yxq(String qme8yxq) {
		this.qme8yxq = String.valueOf(DateUtil.dateStrToJuLianTwo(qme8yxq));;
	}

	public String getQme8scrq() {
		return qme8scrq;
	}

	public void setQme8scrq(String qme8scrq) {
		this.qme8scrq = String.valueOf(DateUtil.dateStrToJuLianTwo(qme8scrq));
	}

	public BigDecimal getQme8spdbz() {
		return qme8spdbz;
	}

	public void setQme8spdbz(BigDecimal qme8spdbz) {
		this.qme8spdbz = qme8spdbz;
	}

	public BigDecimal getQmuorg() {
		return qmuorg;
	}

	public void setQmuorg(BigDecimal qmuorg) {
		this.qmuorg = qmuorg;
	}

	public BigDecimal getQme8rklx() {
		return qme8rklx;
	}

	public void setQme8rklx(BigDecimal qme8rklx) {
		this.qme8rklx = qme8rklx;
	}

	@Override
	public String toString() {
		return "RevertDataDetail [qmukid=" + qmukid + ", qmrlln=" + qmrlln
				+ ", qmev01=" + qmev01 + ", qmlnid=" + qmlnid + ", qme8yyqgd="
				+ qme8yyqgd + ", qme8ksqgd=" + qme8ksqgd + ", qme8yyycd="
				+ qme8yyycd + ", qme8yyyce=" + qme8yyyce + ", qme8yyycn="
				+ qme8yyycn + ", qme8spdgg=" + qme8spdgg + ", qme8sccs="
				+ qme8sccs + ", qme8spdcd=" + qme8spdcd + ", qme8spddw="
				+ qme8spddw + ", qmlot1=" + qmlot1 + ", qmlot2=" + qmlot2
				+ ", qme8kclx=" + qme8kclx + ", qme8yxq=" + qme8yxq
				+ ", qme8scrq=" + qme8scrq + ", qme8spdbz=" + qme8spdbz
				+ ", qmuorg=" + qmuorg + ", qme8rklx=" + qme8rklx + "]";
	}
}
