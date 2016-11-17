package com.el.cmic.domain.revert;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.el.utils.DateUtil;

/**
 * SPD请退数据接收
 * @author zhanhao
 *
 */
public class RevertData {
	 /**
     *  null - FE8SPD14.QTUKID
     */
    private BigDecimal qtukid;
    
    /**
     *  null - FE8SPD14.QTEV01
     */
    private String qtev01;
    
    /**
     *  SPD系统标识  - FE8SPD14.QTE8SPDID
     */
    @JSONField(name = "SPD系统标识")
    private String qte8spdid;
    
    /**
     *  配送单位系统标识 - FE8SPD14.QTE8ERPID
     */
    @JSONField(name = "配送单位系统标识")
    private String qte8erpid;
    
    /**
     *  配送单位  - FE8SPD14.QTE8PSDW
     */
    @JSONField(name = "配送单位")
    private String qte8psdw;
    

    /**
     *  配送单位ERP编号 - FE8SPD14.QTE8PSDWE
     */
    @JSONField(name = "配送单位ERP编号")
    private String qte8psdwe;
    
    /**
     *  配送单位名称  - FE8SPD14.QTE8PSDWN
     */
    @JSONField(name = "配送单位名称")
    private String qte8psdwn;
    
    /**
     *  退货医院  - FE8SPD14.QTE8THYY
     */
    @JSONField(name = "退货医院")
    private String qte8thyy;
    
    /**
     *  退货医院ERP编号  - FE8SPD14.QTE8THYYE
     */
    @JSONField(name = "退货医院ERP编号")
    private String qte8thyye;
    
    /**
     *  退货医院名称 - FE8SPD14.QTE8THYYN
     */
    @JSONField(name = "退货医院名称")
    private String qte8thyyn;
    
    /**
     *  退货科室编号 - FE8SPD14.QTE8THKS
     */
    @JSONField(name = "退货科室编号")
    private String qte8thks;
    
    /**
     *  退货科室ERP编号 - FE8SPD14.QTE8THKSE
     */
    @JSONField(name = "退货科室ERP编号")
    private String qte8thkse;

    /**
     *  退货科室名称 - FE8SPD14.QTE8THKSN
     */
    @JSONField(name = "退货科室名称")
    private String qte8thksn;
    
    /**
     *  出库科室编号  - FE8SPD14.QTE8CKKS
     */
    @JSONField(name = "出库科室编号")
    private String qte8ckks;
    
    /**
     *  出库科室ERP编号  - FE8SPD14.QTE8CKKSE
     */
    @JSONField(name = "出库科室ERP编号")
    private String qte8ckkse;
    
    /**
     *  出库科室名称 - FE8SPD14.QTE8CKKSN
     */
    @JSONField(name = "出库科室名称")
    private String qte8ckksn;
    
    /**
     *  退货单号  - FE8SPD14.QTE8THDH
     */
    @JSONField(name = "退货单号")
    private String qte8thdh;
    
    /**
     *  退货单日期 - FE8SPD14.QTE8THRQ
     */
    @JSONField(name = "退货单日期")
    private String qte8thrq;
    
    /**
     *  _date  - FE8SPD14.QTE8XTSJ
     */
    @JSONField(name = "_date")
    private String qte8xtsj;
    
    /**
     *  任务总行数  - FE8SPD14.QTE8DDZHS
     */
    @JSONField(name = "任务总行数")
    private BigDecimal qte8ddzhs;

    @JSONField(name = "请退明细")
    List<RevertDataDetail>  listRevertDataDetail;

	public BigDecimal getQtukid() {
		return qtukid;
	}

	public void setQtukid(BigDecimal qtukid) {
		this.qtukid = qtukid;
	}

	public String getQtev01() {
		return qtev01;
	}

	public void setQtev01(String qtev01) {
		this.qtev01 = qtev01;
	}

	public String getQte8spdid() {
		return qte8spdid;
	}

	public void setQte8spdid(String qte8spdid) {
		this.qte8spdid = qte8spdid;
	}

	public String getQte8erpid() {
		return qte8erpid;
	}

	public void setQte8erpid(String qte8erpid) {
		this.qte8erpid = qte8erpid;
	}

	public String getQte8psdw() {
		return qte8psdw;
	}

	public void setQte8psdw(String qte8psdw) {
		this.qte8psdw = qte8psdw;
	}

	public String getQte8psdwe() {
		return qte8psdwe;
	}

	public void setQte8psdwe(String qte8psdwe) {
		this.qte8psdwe = qte8psdwe;
	}

	public String getQte8psdwn() {
		return qte8psdwn;
	}

	public void setQte8psdwn(String qte8psdwn) {
		this.qte8psdwn = qte8psdwn;
	}

	public String getQte8thyy() {
		return qte8thyy;
	}

	public void setQte8thyy(String qte8thyy) {
		this.qte8thyy = qte8thyy;
	}

	public String getQte8thyye() {
		return qte8thyye;
	}

	public void setQte8thyye(String qte8thyye) {
		this.qte8thyye = qte8thyye;
	}

	public String getQte8thyyn() {
		return qte8thyyn;
	}

	public void setQte8thyyn(String qte8thyyn) {
		this.qte8thyyn = qte8thyyn;
	}

	public String getQte8thks() {
		return qte8thks;
	}

	public void setQte8thks(String qte8thks) {
		this.qte8thks = qte8thks;
	}

	public String getQte8thkse() {
		return qte8thkse;
	}

	public void setQte8thkse(String qte8thkse) {
		this.qte8thkse = qte8thkse;
	}

	public String getQte8thksn() {
		return qte8thksn;
	}

	public void setQte8thksn(String qte8thksn) {
		this.qte8thksn = qte8thksn;
	}

	public String getQte8ckks() {
		return qte8ckks;
	}

	public void setQte8ckks(String qte8ckks) {
		this.qte8ckks = qte8ckks;
	}

	public String getQte8ckkse() {
		return qte8ckkse;
	}

	public void setQte8ckkse(String qte8ckkse) {
		this.qte8ckkse = qte8ckkse;
	}

	public String getQte8ckksn() {
		return qte8ckksn;
	}

	public void setQte8ckksn(String qte8ckksn) {
		this.qte8ckksn = qte8ckksn;
	}

	public String getQte8thdh() {
		return qte8thdh;
	}

	public void setQte8thdh(String qte8thdh) {
		this.qte8thdh = qte8thdh;
	}

	public String getQte8thrq() {
		return qte8thrq;
	}

	public void setQte8thrq(String qte8thrq) {
		this.qte8thrq = String.valueOf(DateUtil.dateStrToJuLianTwo(qte8thrq));
	}

	public String getQte8xtsj() {
		return qte8xtsj;
	}

	public void setQte8xtsj(String qte8xtsj) {
		this.qte8xtsj = String.valueOf(DateUtil.dateStrToJuLianTwo(qte8xtsj));
	}

	public BigDecimal getQte8ddzhs() {
		return qte8ddzhs;
	}

	public void setQte8ddzhs(BigDecimal qte8ddzhs) {
		this.qte8ddzhs = qte8ddzhs;
	}

	public List<RevertDataDetail> getListRevertDataDetail() {
		return listRevertDataDetail;
	}

	public void setListRevertDataDetail(List<RevertDataDetail> listRevertDataDetail) {
		this.listRevertDataDetail = listRevertDataDetail;
	}

	@Override
	public String toString() {
		return "RevertData [qtukid=" + qtukid + ", qtev01=" + qtev01
				+ ", qte8spdid=" + qte8spdid + ", qte8erpid=" + qte8erpid
				+ ", qte8psdw=" + qte8psdw + ", qte8psdwe=" + qte8psdwe
				+ ", qte8psdwn=" + qte8psdwn + ", qte8thyy=" + qte8thyy
				+ ", qte8thyye=" + qte8thyye + ", qte8thyyn=" + qte8thyyn
				+ ", qte8thks=" + qte8thks + ", qte8thkse=" + qte8thkse
				+ ", qte8thksn=" + qte8thksn + ", qte8ckks=" + qte8ckks
				+ ", qte8ckkse=" + qte8ckkse + ", qte8ckksn=" + qte8ckksn
				+ ", qte8thdh=" + qte8thdh + ", qte8thrq=" + qte8thrq
				+ ", qte8xtsj=" + qte8xtsj + ", qte8ddzhs=" + qte8ddzhs
				+ ", listRevertDataDetail=" + listRevertDataDetail + "]";
	}

}
