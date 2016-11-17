package com.el.cfg.mapper;

import com.el.cfg.domain.FE8WMS20;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface FE8WMS20Mapper {
    @Select({
        "select",
        "LSCO, LSE8HZBM, LSE8APPK, LSEPAPSD, LSUSER, LSPID, LSUPMJ, LSTDAY, LSDL01, LSDL02, ",
        "LSDL03, LSDL04, LSDL05, LSEV01, LSEV02, LSEV03",
        "from FE8WMS20",
        "where LSCO = #{lsco,jdbcType=NCHAR}"
    })
    @Results({
        @Result(column="LSCO", property="lsco", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="LSE8HZBM", property="lse8hzbm", jdbcType=JdbcType.NCHAR),
        @Result(column="LSE8APPK", property="lse8appk", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEPAPSD", property="lsepapsd", jdbcType=JdbcType.NCHAR),
        @Result(column="LSUSER", property="lsuser", jdbcType=JdbcType.NCHAR),
        @Result(column="LSPID", property="lspid", jdbcType=JdbcType.NCHAR),
        @Result(column="LSUPMJ", property="lsupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="LSTDAY", property="lstday", jdbcType=JdbcType.DECIMAL),
        @Result(column="LSDL01", property="lsdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL02", property="lsdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL03", property="lsdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL04", property="lsdl04", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL05", property="lsdl05", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV01", property="lsev01", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV02", property="lsev02", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV03", property="lsev03", jdbcType=JdbcType.NCHAR)
    })
    FE8WMS20 selectByPrimaryKey(String lsco);

    @Select({
        "select",
        "LSCO, LSE8HZBM, LSE8APPK, LSEPAPSD, LSUSER, LSPID, LSUPMJ, LSTDAY, LSDL01, LSDL02, ",
        "LSDL03, LSDL04, LSDL05, LSEV01, LSEV02, LSEV03",
        "from FE8WMS20"
    })
    @Results({
        @Result(column="LSCO", property="lsco", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="LSE8HZBM", property="lse8hzbm", jdbcType=JdbcType.NCHAR),
        @Result(column="LSE8APPK", property="lse8appk", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEPAPSD", property="lsepapsd", jdbcType=JdbcType.NCHAR),
        @Result(column="LSUSER", property="lsuser", jdbcType=JdbcType.NCHAR),
        @Result(column="LSPID", property="lspid", jdbcType=JdbcType.NCHAR),
        @Result(column="LSUPMJ", property="lsupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="LSTDAY", property="lstday", jdbcType=JdbcType.DECIMAL),
        @Result(column="LSDL01", property="lsdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL02", property="lsdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL03", property="lsdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL04", property="lsdl04", jdbcType=JdbcType.NCHAR),
        @Result(column="LSDL05", property="lsdl05", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV01", property="lsev01", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV02", property="lsev02", jdbcType=JdbcType.NCHAR),
        @Result(column="LSEV03", property="lsev03", jdbcType=JdbcType.NCHAR)
    })
    List<FE8WMS20> selectAll();
}