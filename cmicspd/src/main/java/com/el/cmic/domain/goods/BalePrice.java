package com.el.cmic.domain.goods;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 商品价格数据推送
 * @author zhanhao
 *
 */
@Component
@JSONType(orders={"SPD系统标识","配送机构系统标识","配送机构ERP编号","配送机构名称","ERP商品编号","ERP商品名称","配送价","医疗机构明细"})
public class BalePrice {

	/**
     *  SPD系统标识  - VE8SPDJG.SPDBS
     */
	@JSONField(name="SPD系统标识")
    private String spdbs;
    
    /**
     *  配送机构系统标识  - VE8SPDJG.ERPBS
     */
	@JSONField(name="配送机构系统标识")
    private String erpbs;
    
    /**
     *  配送机构ERP编号  - VE8SPDJG.CO
     */
	@JSONField(name="配送机构ERP编号")
    private String co;
    
    /**
     *  配送机构名称 - VE8SPDJG.NAME
     */
	@JSONField(name="配送机构名称")
    private String name;
    
    /**
     *  ERP商品编号 - VE8SPDJG.LITM
     */
	@JSONField(name="ERP商品编号")
    private String litm;
    
    /**
     *  ERP商品名称  - VE8SPDJG.E8NAME
     */
	@JSONField(name="ERP商品名称")
    private String e8name;
    
    /**
     *  配送价  - VE8SPDJG.UPRC
     */
	@JSONField(name="配送价")
    private BigDecimal uprc;
    
    
    //医疗机构明细 
	@JSONField(name="医疗机构明细")
    private List<BaleDetailPrice>  list;


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


	public String getLitm() {
		return litm;
	}


	public void setLitm(String litm) {
		this.litm = litm;
	}


	public String getE8name() {
		return e8name;
	}


	public void setE8name(String e8name) {
		this.e8name = e8name;
	}


	public BigDecimal getUprc() {
		return uprc;
	}


	public void setUprc(BigDecimal uprc) {
		this.uprc = uprc;
	}

	public List<BaleDetailPrice> getList() {
		return list;
	}

	public void setList(List<BaleDetailPrice> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BalePrice [spdbs=" + spdbs + ", erpbs=" + erpbs + ", co=" + co
				+ ", name=" + name + ", litm=" + litm + ", e8name=" + e8name
				+ ", uprc=" + uprc + ", list=" + list + "]";
	}
    

}
