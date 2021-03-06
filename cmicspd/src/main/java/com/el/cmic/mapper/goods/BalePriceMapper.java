package com.el.cmic.mapper.goods;

import java.util.List;

import com.el.cmic.domain.goods.BaleDetailPrice;
import com.el.utils.ReadPropertiesUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.el.cmic.domain.goods.BalePrice;

public interface BalePriceMapper {
	//动态 获取  db.properties  文件属性值
	final String schema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");
	// final String ctlSchema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "ctlSchema");
	/**
	 * 商品价格数据推送
	 * @return
	 */
	@Select("select  SPDBS,ERPBS,CO,NAME,LITM,E8NAME,UPRC/10000 AS UPRC from ${tableSchema}.VE8SPDJG where AN8=0")
	public List<BalePrice> selectBalePrice();

	/**
	 *
	 * @return
     */
	@Select("select  alph,an8,UPRC/10000 AS UPRC from ${tableSchema}.VE8SPDJG where trim(co)=#{co} and trim(litm)=#{litm} and an8>0")
	public List<BaleDetailPrice> selectBaleDetailPrice(@Param("co")String co,@Param("litm")String litm);
	
	/**
	 * FE8SPD04  更新   EV01
	 * @param co
	 * @param limt
	 * @return
	 */
	@Update("update ${tableSchema}.FE8SPD04 set JGEV01 = #{status,jdbcType=NCHAR} where JGCO=#{co,jdbcType=NCHAR} and JGLITM=#{limt,jdbcType=NCHAR} ")
	public Integer  updateEV01(@Param("status") String status,@Param("co") String co,@Param("limt") String limt);

}
