package com.el.cmic.mapper.stock;

import com.el.utils.ReadPropertiesUtil;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.jdbc.SQL;

import com.el.cmic.domain.stock.StockDetail;

public interface StockDetailMapper {
	//动态 获取  db.properties  文件属性值
	String schema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");
	/**
	 * 销退入库验收推送  insert
	 * @return
	 */
	@InsertProvider(type=StockDetailMapper.sqlProvider.class,method=StockDetailMapper.sqlProvider.insertStrockDetail)
	public  Integer  insertStockDetail(StockDetail stockDetail );
	
	class sqlProvider extends SQL{
		
		public static final String insertStrockDetail ="insertStockDetail";
		public String insertStockDetail(StockDetail stockDetail){
			INSERT_INTO(schema+".FE8WMS10");
			VALUES("XTUKID",schema+".FE8WMS10_SEQ.NEXTVAL");
			VALUES("xtmcu","(select LSMCU from "+schema+".FE8WMS20 where trim(LSE8WLZXID) = #{xtmcu,jdbcType=NCHAR} and trim(LSE8HZBM) = #{xtco,jdbcType=NCHAR})");
			VALUES("xtco","(select LSCO from "+schema+".FE8WMS20 where trim(LSE8WLZXID) = #{xtmcu,jdbcType=NCHAR} and trim(LSE8HZBM) = #{xtco,jdbcType=NCHAR})");
			VALUES("xtdoco","#{xtdoco,jdbcType=NCHAR}");
			VALUES("xtptut01","#{xtptut01,jdbcType=NCHAR}");
			VALUES("xtptut02","#{xtptut02,jdbcType=NCHAR}");
			VALUES("xte8tym","#{xte8tym,jdbcType=NCHAR}");
			VALUES("xtptut03","#{xtptut03,jdbcType=NCHAR}");
			VALUES("xte8name","#{xte8name,jdbcType=NCHAR}");
			VALUES("xtfstr1","#{xtfstr1,jdbcType=NCHAR}");
			VALUES("xtfstr2","nvl(#{xtfstr2,jdbcType=NCHAR},' ')");
			VALUES("xtidate","#{xtidate,jdbcType=DATE}");
			VALUES("xtrdate","#{xtrdate,jdbcType=DATE}");
			VALUES("xtuprc","#{xtuprc,jdbcType=DECIMAL}");
			VALUES("xtprrc","#{xtprrc,jdbcType=DECIMAL}");
			VALUES("xtfrrc","#{xtfrrc,jdbcType=DECIMAL}");
			VALUES("xtdstl","#{xtdstl,jdbcType=NCHAR}");
			VALUES("xtfstr3","#{xtfstr3,jdbcType=NCHAR}");
			VALUES("xtfstr4","#{xtfstr4,jdbcType=NCHAR}");
			VALUES("xtfstr5","#{xtfstr5,jdbcType=NCHAR}");
			VALUES("xtdtee","#{xtdtee,jdbcType=DATE}");
			VALUES("xtdtetp","#{xtdtetp,jdbcType=DATE}");
			VALUES("xtdl01","#{xtdl01,jdbcType=NCHAR}");
			VALUES("xtads1","#{xtads1,jdbcType=NCHAR}");
			VALUES("xtfstr6","#{xtfstr6,jdbcType=NCHAR}");
			VALUES("xtfstr61","#{xtfstr61,jdbcType=NCHAR}");
			VALUES("xtdl011","#{xtdl011,jdbcType=NCHAR}");
			VALUES("xtconstr1","#{xtconstr1,jdbcType=NCHAR}");
			VALUES("xtahl1","#{xtahl1,jdbcType=NCHAR}");
			VALUES("xtahl2","#{xtahl2,jdbcType=NCHAR}");
			VALUES("xtconstr2","#{xtconstr2,jdbcType=NCHAR}");
			VALUES("xtfstr62","#{xtfstr62,jdbcType=NCHAR}");
			VALUES("xtfstr63","#{xtfstr63,jdbcType=NCHAR}");
			return toString();
		}
	}

}
