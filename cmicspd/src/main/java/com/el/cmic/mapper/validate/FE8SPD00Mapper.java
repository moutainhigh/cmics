package com.el.cmic.mapper.validate;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.el.cfg.domain.FE8SPD00;

public interface FE8SPD00Mapper {
	
	@Select("select * from ${tableSchema}.fe8spd00")
	List<FE8SPD00> selectAllFE8SPD00();
	
	@Select("select * from ${tableSchema}.fe8spd00 where (LSCO=#{lsco} and LSDL01=#{lsco01})  or (LSCO=#{lsco} and trim(LSDL01) is null)")
	FE8SPD00  selectByLsco(@Param("lsco") String lsco,@Param("lsco01") String lsco01);

}
