package com.el.cfg.mapper;

import com.el.cfg.domain.Fe8wms04;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface Fe8wms04Mapper {
    @Select({
        "select",
        "XLPTUT01, XLLOT1, XLAA05, XLCA01, XLUPRC, XLUORG, XLLITM, XLPTUT02, XLUSER, ",
        "XLPID, XLUPMJ, XLTDAY, XLJOBN, XLKCOO, XLDCTO, XLDOCO, XLLNID, XLDL01, XLDL02, ",
        "XLDL03, XLAB01, XLAB02, XLAB03, XLEV01, XLEV02, XLDL010, XLLOTN, XLLOT2, XLPUKID, ",
        "XLUKID, XLMCU, XLEV03, XLEV04, XLEV05, XLEV06, XLKCO, XLDCT, XLDOC, XLRLLN",
        "from FE8WMS04",
        "where XLPTUT01 = #{xlptut01,jdbcType=NCHAR}",
          "and XLLOT1 = #{xllot1,jdbcType=NCHAR}"
    })
    @Results({
        @Result(column="XLPTUT01", property="xlptut01", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="XLLOT1", property="xllot1", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="XLAA05", property="xlaa05", jdbcType=JdbcType.NCHAR),
        @Result(column="XLCA01", property="xlca01", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUPRC", property="xluprc", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUORG", property="xluorg", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLLITM", property="xllitm", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPTUT02", property="xlptut02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLUSER", property="xluser", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPID", property="xlpid", jdbcType=JdbcType.NCHAR),
        @Result(column="XLUPMJ", property="xlupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLTDAY", property="xltday", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLJOBN", property="xljobn", jdbcType=JdbcType.NCHAR),
        @Result(column="XLKCOO", property="xlkcoo", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDCTO", property="xldcto", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDOCO", property="xldoco", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLLNID", property="xllnid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLDL01", property="xldl01", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL02", property="xldl02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL03", property="xldl03", jdbcType=JdbcType.NCHAR),
        @Result(column="XLAB01", property="xlab01", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLAB02", property="xlab02", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLAB03", property="xlab03", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLEV01", property="xlev01", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV02", property="xlev02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL010", property="xldl010", jdbcType=JdbcType.NCHAR),
        @Result(column="XLLOTN", property="xllotn", jdbcType=JdbcType.NCHAR),
        @Result(column="XLLOT2", property="xllot2", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPUKID", property="xlpukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUKID", property="xlukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLMCU", property="xlmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV03", property="xlev03", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV04", property="xlev04", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV05", property="xlev05", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV06", property="xlev06", jdbcType=JdbcType.NCHAR),
        @Result(column="XLKCO", property="xlkco", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDCT", property="xldct", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDOC", property="xldoc", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLRLLN", property="xlrlln", jdbcType=JdbcType.DECIMAL)
    })
    Fe8wms04 selectByPrimaryKey(@Param("xlptut01") String xlptut01, @Param("xllot1") String xllot1);

    @Select({
        "select",
        "XLPTUT01, XLLOT1, XLAA05, XLCA01, XLUPRC, XLUORG, XLLITM, XLPTUT02, XLUSER, ",
        "XLPID, XLUPMJ, XLTDAY, XLJOBN, XLKCOO, XLDCTO, XLDOCO, XLLNID, XLDL01, XLDL02, ",
        "XLDL03, XLAB01, XLAB02, XLAB03, XLEV01, XLEV02, XLDL010, XLLOTN, XLLOT2, XLPUKID, ",
        "XLUKID, XLMCU, XLEV03, XLEV04, XLEV05, XLEV06, XLKCO, XLDCT, XLDOC, XLRLLN",
        "from FE8WMS04"
    })
    @Results({
        @Result(column="XLPTUT01", property="xlptut01", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="XLLOT1", property="xllot1", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="XLAA05", property="xlaa05", jdbcType=JdbcType.NCHAR),
        @Result(column="XLCA01", property="xlca01", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUPRC", property="xluprc", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUORG", property="xluorg", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLLITM", property="xllitm", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPTUT02", property="xlptut02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLUSER", property="xluser", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPID", property="xlpid", jdbcType=JdbcType.NCHAR),
        @Result(column="XLUPMJ", property="xlupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLTDAY", property="xltday", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLJOBN", property="xljobn", jdbcType=JdbcType.NCHAR),
        @Result(column="XLKCOO", property="xlkcoo", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDCTO", property="xldcto", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDOCO", property="xldoco", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLLNID", property="xllnid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLDL01", property="xldl01", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL02", property="xldl02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL03", property="xldl03", jdbcType=JdbcType.NCHAR),
        @Result(column="XLAB01", property="xlab01", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLAB02", property="xlab02", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLAB03", property="xlab03", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLEV01", property="xlev01", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV02", property="xlev02", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDL010", property="xldl010", jdbcType=JdbcType.NCHAR),
        @Result(column="XLLOTN", property="xllotn", jdbcType=JdbcType.NCHAR),
        @Result(column="XLLOT2", property="xllot2", jdbcType=JdbcType.NCHAR),
        @Result(column="XLPUKID", property="xlpukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLUKID", property="xlukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLMCU", property="xlmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV03", property="xlev03", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV04", property="xlev04", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV05", property="xlev05", jdbcType=JdbcType.NCHAR),
        @Result(column="XLEV06", property="xlev06", jdbcType=JdbcType.NCHAR),
        @Result(column="XLKCO", property="xlkco", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDCT", property="xldct", jdbcType=JdbcType.NCHAR),
        @Result(column="XLDOC", property="xldoc", jdbcType=JdbcType.DECIMAL),
        @Result(column="XLRLLN", property="xlrlln", jdbcType=JdbcType.DECIMAL)
    })
    List<Fe8wms04> selectAll();
}