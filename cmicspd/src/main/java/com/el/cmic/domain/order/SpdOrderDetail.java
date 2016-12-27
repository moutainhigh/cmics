package com.el.cmic.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.el.utils.DateUtil;

public class SpdOrderDetail implements Serializable {
	/**
	 * null - FE8SPD11.PHUKID
	 */
	private BigDecimal phukid;

    /**
     *  null - FE8SPD11.PHRLLN
     */
    private BigDecimal phrlln;

    /**
	 * null - FE8SPD11.PHLNID
	 */
	@JSONField(name = "采购订单行号")
	private BigDecimal phlnid;

	/**
	 * null - FE8SPD11.PHEV01
	 */
	private String phev01;

	/**
	 * null - FE8SPD11.PHE8YLJGD
	 */
	@JSONField(name = "医疗机构申请单号")
	private String phe8yljgd;

	/**
	 * null - FE8SPD11.PHE8KSD
	 */
	@JSONField(name = "科室申请单号")
	private String phe8ksd;


	@JSONField(name = "指定供应商ERP编号")
	private BigDecimal phpa8;

	/**
	 * null - FE8SPD11.PHE8ZDGYSN
	 */
	@JSONField(name = "指定供应商ERP名称")
	private String phe8zdgysn;

	/**
	 * null - FE8SPD11.PHTRDJ
	 */
	@JSONField(name = "采购订单日期", format="yyyy-MM-dd HH:mm:ss")
	private Date phtrdj;

	/**
	 * null - FE8SPD11.PHTRDJ
	 */
	@JSONField(name = "采购订单日期J", serialize=false)
	private BigDecimal phtrdjj;

	/**
	 * null - FE8SPD11.PHE8YYYCD
	 */
	@JSONField(name = "医药医材编号")
	private String phe8yyycd;


	@JSONField(name = "医药医材ERP编号")
	private String phlitm;

	/**
	 * null - FE8SPD11.PHE8YYYCN
	 */
	@JSONField(name = "医药医材名称")
	private String phe8yyycn;

	/**
	 * null - FE8SPD11.PHE8SGG
	 * FE8SPD11.PHE8SPDGG
	 */
	@JSONField(name = "规格")
	private String phe8sgg;

	/**
	 * null - FE8SPD11.PHE8SCCS
	 */
	@JSONField(name = "生产厂商")
	private String phe8sccs;

	/**
	 * null - FE8SPD11.PHE8SCD
	 * 	FE8SPD11.PHE8SPDCD
	 */
	@JSONField(name = "产地")
	private String phe8scd;

	/**
	 * null - FE8SPD11.PHE8SDW
	 * FE8SPD11.PHE8SPDDW
	 */
	@JSONField(name = "单位")
	private String phe8sdw;

	/**
	 * null - FE8SPD11.PHE8SBZ
	 * FE8SPD11.PHE8SPDBZ
	 */
	@JSONField(name = "包装")
	private BigDecimal phe8sbz;

	/**
	 * null - FE8SPD11.PHUPRC
	 */
	@JSONField(name = "单价")
	private BigDecimal phuprc;

	/**
	 * null - FE8SPD11.PHUORG
	 */
	@JSONField(name = "数量")
	private BigDecimal phuorg;

	/**
	 * null - FE8SPD11.PHE8YJDHRQ
	 */
	@JSONField(name = "预计到货日期", format="yyyy-MM-dd HH:mm:ss")
	private Date phe8yjdhrq;

	/**
	 * null - FE8SPD11.PHE8YJDHRQ
	 */
	@JSONField(name = "预计到货日期J", serialize=false)
	private BigDecimal phe8yjdhrqj;

	private static final long serialVersionUID = 1L;

	public BigDecimal getPhukid() {
		return phukid;
	}

	public void setPhukid(BigDecimal phukid) {
		this.phukid = phukid;
	}

	/**
	 * @return the phrlln
	 */
	public BigDecimal getPhrlln() {
		return phrlln;
	}

	/**
	 * @param phrlln the phrlln to set
	 */
	public void setPhrlln(BigDecimal phrlln) {
		this.phrlln = phrlln;
	}

	public BigDecimal getPhlnid() {
		return phlnid;
	}

	public void setPhlnid(BigDecimal phlnid) {
		this.phlnid = phlnid;
	}

	public String getPhev01() {
		return phev01;
	}

	public void setPhev01(String phev01) {
		this.phev01 = phev01;
	}

	public String getPhe8yljgd() {
		return phe8yljgd;
	}

	public void setPhe8yljgd(String phe8yljgd) {
		this.phe8yljgd = phe8yljgd;
	}

	public String getPhe8ksd() {
		return phe8ksd;
	}

	public void setPhe8ksd(String phe8ksd) {
		this.phe8ksd = phe8ksd;
	}


	public String getPhe8zdgysn() {
		return phe8zdgysn;
	}

	public void setPhe8zdgysn(String phe8zdgysn) {
		this.phe8zdgysn = phe8zdgysn;
	}

	public Date getPhtrdj() {
		return phtrdj;
	}

	public void setPhtrdj(Date phtrdj) {
		this.phtrdj = phtrdj;
		if (phtrdj != null) {
			this.phtrdjj = new BigDecimal(DateUtil.dateToJuLian(phtrdj));
		}
	}

	public String getPhlitm() {
		return phlitm;
	}

	public void setPhlitm(String phlitm) {
		this.phlitm = phlitm;
	}

	public BigDecimal getPhpa8() {
		return phpa8;
	}

	public void setPhpa8(BigDecimal phpa8) {
		this.phpa8 = phpa8;
	}

	public String getPhe8yyycd() {
		return phe8yyycd;
	}

	public void setPhe8yyycd(String phe8yyycd) {
		this.phe8yyycd = phe8yyycd;
	}

	public String getPhe8yyycn() {
		return phe8yyycn;
	}

	public void setPhe8yyycn(String phe8yyycn) {
		this.phe8yyycn = phe8yyycn;
	}

	public String getPhe8sgg() {
		return phe8sgg;
	}

	public void setPhe8sgg(String phe8sgg) {
		this.phe8sgg = phe8sgg;
	}

	public String getPhe8sccs() {
		return phe8sccs;
	}

	public void setPhe8sccs(String phe8sccs) {
		this.phe8sccs = phe8sccs;
	}

	public String getPhe8scd() {
		return phe8scd;
	}

	public void setPhe8scd(String phe8scd) {
		this.phe8scd = phe8scd;
	}

	public String getPhe8sdw() {
		return phe8sdw;
	}

	public void setPhe8sdw(String phe8sdw) {
		this.phe8sdw = phe8sdw;
	}

	public BigDecimal getPhe8sbz() {
		return phe8sbz;
	}

	public void setPhe8sbz(BigDecimal phe8sbz) {
		this.phe8sbz = phe8sbz;
	}

	public BigDecimal getPhuprc() {
		return phuprc;
	}

	public void setPhuprc(BigDecimal phuprc) {
		this.phuprc = phuprc;
	}

	public BigDecimal getPhuorg() {
		return phuorg;
	}

	public void setPhuorg(BigDecimal phuorg) {
		this.phuorg = phuorg;
	}

	public Date getPhe8yjdhrq() {
		return phe8yjdhrq;
	}

	public void setPhe8yjdhrq(Date phe8yjdhrq) {
		this.phe8yjdhrq = phe8yjdhrq;
		if (phe8yjdhrq != null) {
			this.phe8yjdhrqj = new BigDecimal(DateUtil.dateToJuLian(phe8yjdhrq));
		}
	}

	/**
	 * @return the phtrdjj
	 */
	public BigDecimal getPhtrdjj() {
		return phtrdjj;
	}

	/**
	 * @param phtrdjj the phtrdjj to set
	 */
	public void setPhtrdjj(BigDecimal phtrdjj) {
		this.phtrdjj = phtrdjj;
	}

	/**
	 * @return the phe8yjdhrqj
	 */
	public BigDecimal getPhe8yjdhrqj() {
		return phe8yjdhrqj;
	}

	/**
	 * @param phe8yjdhrqj the phe8yjdhrqj to set
	 */
	public void setPhe8yjdhrqj(BigDecimal phe8yjdhrqj) {
		this.phe8yjdhrqj = phe8yjdhrqj;
	}

	@Override
	public String toString() {
		return "SpdOrderDetail{" +
				"phukid=" + phukid +
				", phrlln=" + phrlln +
				", phlnid=" + phlnid +
				", phev01='" + phev01 + '\'' +
				", phe8yljgd='" + phe8yljgd + '\'' +
				", phe8ksd='" + phe8ksd + '\'' +
				", phpa8='" + phpa8 + '\'' +
				", phe8zdgysn='" + phe8zdgysn + '\'' +
				", phtrdj=" + phtrdj +
				", phtrdjj=" + phtrdjj +
				", phe8yyycd='" + phe8yyycd + '\'' +
				", phlitm='" + phlitm + '\'' +
				", phe8yyycn='" + phe8yyycn + '\'' +
				", phe8sgg='" + phe8sgg + '\'' +
				", phe8sccs='" + phe8sccs + '\'' +
				", phe8scd='" + phe8scd + '\'' +
				", phe8sdw='" + phe8sdw + '\'' +
				", phe8sbz=" + phe8sbz +
				", phuprc=" + phuprc +
				", phuorg=" + phuorg +
				", phe8yjdhrq=" + phe8yjdhrq +
				", phe8yjdhrqj=" + phe8yjdhrqj +
				'}';
	}
}