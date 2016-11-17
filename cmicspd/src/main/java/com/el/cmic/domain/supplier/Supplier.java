package com.el.cmic.domain.supplier;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

@Component
@JSONType(orders = { "SPD系统标识", "配送机构系统标识", "配送机构ERP编号", "配送机构名称", "ERP供应商编号",
		"ERP供应商名称", "简称","备注","封存"})
public class Supplier {
	
	/**
	 * SPD系统标识 VE8SPDGY.SPDBS
	 */
	@JSONField(name = "SPD系统标识")
	private   String spdbs;
	 
	/**
	 *  配送机构系统标识 VE8SPDGY.ERPBS
	 */
	@JSONField(name = "配送机构系统标识")
	private   String erpbs;
	
	/**
	 *  配送机构ERP编号 VE8SPDGY.CO
	 */
	@JSONField(name = "配送机构ERP编号")
	private   String co;
	 
	/**
	 *  配送机构名称 VE8SPDGY.NAME
	 */
	@JSONField(name = "配送机构名称")
	private String name;

	/**
	 * ERP供应商编号  VE8SPDGY.AN8
	 */
	@JSONField(name = "ERP供应商编号")
	private String an8;
	
	/**
	 * ERP供应商名称   VE8SPDGY.ALPH
	 */
	@JSONField(name = "ERP供应商名称")
	private String alph;
	
	/**
	 *   简称 VE8SPDGY.JC
	 */
	@JSONField(name = "简称")
	private String jc ;

	/**
	 *   备注 VE8SPDGY.BZ
	 */
	@JSONField(name = "备注")
	private String bz ;

	/**
	 *   封存 VE8SPDGY.FC
	 */
	@JSONField(name = "封存")
	private Integer fc;

	public String getSpdbs() {
		return spdbs;
	}

	public void setSpdbs(String spdbs) {
		this.spdbs = spdbs;
	}

	public String getErpbs() {
		return erpbs;
	}

	public void setErpbs(String erpbs) {
		this.erpbs = erpbs;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAn8() {
		return an8;
	}

	public void setAn8(String an8) {
		this.an8 = an8;
	}

	public String getAlph() {
		return alph;
	}

	public void setAlph(String alph) {
		this.alph = alph;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz =bz;
	}

	

	public Integer getFc() {
		return fc;
	}

	public void setFc(Integer fc) {
		this.fc = fc;
	}

	@Override
	public String toString() {
		return "Supplier [spdbs=" + spdbs + ", erpbs=" + erpbs + ", co=" + co
				+ ", name=" + name + ", an8=" + an8 + ", alph=" + alph
				+ ", jc=" + jc + ", bz=" + bz + ", fc=" + fc + "]";
	}

}