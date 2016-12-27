package com.el.cmic.domain.settlement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.el.utils.AddSpaceUtil;
import com.el.utils.DateUtil;
import org.springframework.util.StringUtils;

public class Settlement implements Serializable {
	/**
	 * null - FE8SPD12.JSUKID
	 */
	private BigDecimal jsukid;

	/**
	 * null - FE8SPD12.JSEV01
	 */
	private String jsev01;

	/**
	 * null - FE8SPD12.JSE8SPDID
	 */
	@JSONField(name = "SPD系统标识")
	private String jse8spdid;

	/**
	 * null - FE8SPD12.JSE8ERPID
	 */
	@JSONField(name = "结算单位系统标识")
	private String jse8erpid;

	/**
	 * null - FE8SPD12.JSE8JSDW
	 */
	@JSONField(name = "结算单位")
	private String jse8jsdw;


	@JSONField(name = "结算单位ERP编号")
	private String jskcoo;

	/**
	 * null - FE8SPD12.JSE8JSDWBE
	 */
	@JSONField(name = "结算单位ERP部门编号")
	private String jsomcu;

	/**
	 * null - FE8SPD12.JSE8JSDWN
	 */
	@JSONField(name = "结算单位名称")
	private String jse8jsdwn;

	/**
	 * null - FE8SPD12.JSE8CKYY
	 */
	@JSONField(name = "出库医院")
	private String jse8ckyy;

	/**
	 * null - FE8SPD12.JSE8YHYYE
	 */
	@JSONField(name = "出库医院ERP编号")
	private String jsan8;

	/**
	 * null - FE8SPD12.JSE8YHYYN
	 */
	@JSONField(name = "出库医院名称")
	private String jse8yhyyn;


	@JSONField(name = "业务部门ERP编号")
	private String jsemcu;

	/**
	 * null - FE8SPD12.JSE8YWBMN
	 */
	@JSONField(name = "业务部门名称")
	private String jse8ywbmn;

	/**
	 * null - FE8SPD12.JSE8YWYE
	 */
	@JSONField(name = "业务员ERP编号")
	private BigDecimal jsanby;

	/**
	 * null - FE8SPD12.JSE8YWYN
	 */
	@JSONField(name = "业务员名称")
	private String jse8ywyn;

	/**
	 * null - FE8SPD12.JSE8DDZHS
	 */
	@JSONField(name = "任务总行数")
	private BigDecimal jse8ddzhs;

	/**
	 * null - FE8SPD12.JSE8XTSJ
	 */
	@JSONField(name = "_date", format = "yyyy-MM-dd HH:mm:ss")
	private Date jse8xtsj;

	/**
	 * null - FE8SPD12.JSE8XTSJ
	 */
	@JSONField(name = "_datej", serialize = false)
	private BigDecimal jse8xtsjj;

	@JSONField(name = "结算明细")
	private List<SettlementDetail> details;

	private static final long serialVersionUID = 1L;

	public BigDecimal getJsukid() {
		return jsukid;
	}

	public void setJsukid(BigDecimal jsukid) {
		this.jsukid = jsukid;
	}

	public String getJsev01() {
		return jsev01;
	}

	public void setJsev01(String jsev01) {
		this.jsev01 = jsev01;
	}

	public String getJse8spdid() {
		return jse8spdid;
	}

	public void setJse8spdid(String jse8spdid) {
		this.jse8spdid = jse8spdid;
	}

	public String getJse8erpid() {
		return jse8erpid;
	}

	public void setJse8erpid(String jse8erpid) {
		this.jse8erpid = jse8erpid;
	}

	public String getJse8jsdw() {
		return jse8jsdw;
	}

	public void setJse8jsdw(String jse8jsdw) {
		this.jse8jsdw = jse8jsdw;
	}


	public String getJse8jsdwn() {
		return jse8jsdwn;
	}

	public void setJse8jsdwn(String jse8jsdwn) {
		this.jse8jsdwn = jse8jsdwn;
	}

	public String getJse8ckyy() {
		return jse8ckyy;
	}

	public void setJse8ckyy(String jse8ckyy) {
		this.jse8ckyy = jse8ckyy;
	}


	public String getJse8yhyyn() {
		return jse8yhyyn;
	}

	public void setJse8yhyyn(String jse8yhyyn) {
		this.jse8yhyyn = jse8yhyyn;
	}


	public String getJse8ywbmn() {
		return jse8ywbmn;
	}

	public void setJse8ywbmn(String jse8ywbmn) {
		this.jse8ywbmn = jse8ywbmn;
	}


	public String getJse8ywyn() {
		return jse8ywyn;
	}

	public void setJse8ywyn(String jse8ywyn) {
		this.jse8ywyn = jse8ywyn;
	}

	public BigDecimal getJse8ddzhs() {
		return jse8ddzhs;
	}

	public void setJse8ddzhs(BigDecimal jse8ddzhs) {
		this.jse8ddzhs = jse8ddzhs;
	}

	public Date getJse8xtsj() {
		return jse8xtsj;
	}

	public String getJskcoo() {
		return jskcoo;
	}

	public void setJskcoo(String jskcoo) {
		this.jskcoo = jskcoo;
	}

	public String getJsomcu() {
		return jsomcu;
	}

	public void setJsomcu(String jsomcu) {
		if(StringUtils.isEmpty(jsomcu)){
			jsomcu=" ";
		}else{

			jsomcu= AddSpaceUtil.addSpanceLeft(jsomcu,12);
		}
		this.jsomcu = jsomcu;
	}

	public String getJsan8() {
		return jsan8;
	}

	public void setJsan8(String jsan8) {
		this.jsan8 = jsan8;
	}

	public String getJsemcu() {
		return jsemcu;
	}

	public void setJsemcu(String jsemcu) {
		if(StringUtils.isEmpty(jsemcu)){
			jsemcu=" ";
		}else{

			jsemcu= AddSpaceUtil.addSpanceLeft(jsemcu,12);
		}
		this.jsemcu = jsemcu;
	}

	public BigDecimal getJsanby() {
		return jsanby;
	}

	public void setJsanby(BigDecimal jsanby) {
		this.jsanby = jsanby;
	}

	public void setJse8xtsj(Date jse8xtsj) {
		this.jse8xtsj = jse8xtsj;
		if (jse8xtsj != null) {
			this.jse8xtsjj = new BigDecimal(DateUtil.dateToJuLian(jse8xtsj));
		}
	}

	/**
	 * @return the jse8xtsjj
	 */
	public BigDecimal getJse8xtsjj() {
		return jse8xtsjj;
	}

	/**
	 * @param jse8xtsjj
	 *            the jse8xtsjj to set
	 */
	public void setJse8xtsjj(BigDecimal jse8xtsjj) {
		this.jse8xtsjj = jse8xtsjj;
	}

	/**
	 * @return the details
	 */
	public List<SettlementDetail> getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(List<SettlementDetail> details) {
		this.details = details;
	}


}