package com.el.cmic.ws.mapper;

import com.el.cfg.domain.Fe841003;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by king_ on 2016/10/14.
 */
@Repository(value = "fe841003SelectByAn8Mapper")
public interface FE841003SelectByAn8Mapper {
    final class SqlProvider extends SQL {
        public String selectByPrimaryKey(@Param("schema") String schema,@Param("ukid") BigDecimal ukid){
            SELECT("SQA427");
            SELECT("SQE8TYM");
            SELECT("SQCNEM");
            SELECT("SQCNICL");
            SELECT("SQCNYP");
            FROM(schema+".FE841003");
            WHERE("SQUKID = #{ukid}");
            return toString();
        }
    }


    @SelectProvider(type=SqlProvider.class, method="selectByPrimaryKey")
    Fe841003 selectByPrimaryKey(@Param("schema") String schema,@Param("ukid") BigDecimal ukid);
}
