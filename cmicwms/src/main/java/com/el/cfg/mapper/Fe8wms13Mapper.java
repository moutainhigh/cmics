package com.el.cfg.mapper;

import com.el.cfg.domain.Fe8wms13;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface Fe8wms13Mapper {
    @Select({
        "select",
        "QCKCOO, QCDOCO, QCLNID, QCMCU, QCCA01, QCDCTO, QCAN8, QCE8NAME, QCDL01, QCTRDJ, ",
        "QCLITM, QCUORG, QCCA02, QCLOT1, QCLOT2, QCDSC1, QCDCM, QCAUTA, QCDL02, QCDL03, ",
        "QCAB01, QCAB02, QCAB03, QCEV01, QCEV02, QCUSER, QCPID, QCUPMJ, QCTDAY, QCAOD, ",
        "QCSOCN, QCUREC",
        "from FE8WMS13",
        "where QCKCOO = #{qckcoo,jdbcType=NCHAR}",
          "and QCDOCO = #{qcdoco,jdbcType=DECIMAL}",
          "and QCLNID = #{qclnid,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="QCKCOO", property="qckcoo", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="QCDOCO", property="qcdoco", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="QCLNID", property="qclnid", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="QCMCU", property="qcmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="QCCA01", property="qcca01", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCDCTO", property="qcdcto", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAN8", property="qcan8", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCE8NAME", property="qce8name", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL01", property="qcdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="QCTRDJ", property="qctrdj", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCLITM", property="qclitm", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUORG", property="qcuorg", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCCA02", property="qcca02", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCLOT1", property="qclot1", jdbcType=JdbcType.NCHAR),
        @Result(column="QCLOT2", property="qclot2", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDSC1", property="qcdsc1", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDCM", property="qcdcm", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAUTA", property="qcauta", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL02", property="qcdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL03", property="qcdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAB01", property="qcab01", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAB02", property="qcab02", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAB03", property="qcab03", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCEV01", property="qcev01", jdbcType=JdbcType.NCHAR),
        @Result(column="QCEV02", property="qcev02", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUSER", property="qcuser", jdbcType=JdbcType.NCHAR),
        @Result(column="QCPID", property="qcpid", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUPMJ", property="qcupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCTDAY", property="qctday", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAOD", property="qcaod", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QCSOCN", property="qcsocn", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCUREC", property="qcurec", jdbcType=JdbcType.DECIMAL)
    })
    Fe8wms13 selectByPrimaryKey(@Param("qckcoo") String qckcoo, @Param("qcdoco") BigDecimal qcdoco, @Param("qclnid") BigDecimal qclnid);

    @Select({
        "select",
        "QCKCOO, QCDOCO, QCLNID, QCMCU, QCCA01, QCDCTO, QCAN8, QCE8NAME, QCDL01, QCTRDJ, ",
        "QCLITM, QCUORG, QCCA02, QCLOT1, QCLOT2, QCDSC1, QCDCM, QCAUTA, QCDL02, QCDL03, ",
        "QCAB01, QCAB02, QCAB03, QCEV01, QCEV02, QCUSER, QCPID, QCUPMJ, QCTDAY, QCAOD, ",
        "QCSOCN, QCUREC",
        "from FE8WMS13"
    })
    @Results({
        @Result(column="QCKCOO", property="qckcoo", jdbcType=JdbcType.NCHAR, id=true),
        @Result(column="QCDOCO", property="qcdoco", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="QCLNID", property="qclnid", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="QCMCU", property="qcmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="QCCA01", property="qcca01", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCDCTO", property="qcdcto", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAN8", property="qcan8", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCE8NAME", property="qce8name", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL01", property="qcdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="QCTRDJ", property="qctrdj", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCLITM", property="qclitm", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUORG", property="qcuorg", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCCA02", property="qcca02", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCLOT1", property="qclot1", jdbcType=JdbcType.NCHAR),
        @Result(column="QCLOT2", property="qclot2", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDSC1", property="qcdsc1", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDCM", property="qcdcm", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAUTA", property="qcauta", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL02", property="qcdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="QCDL03", property="qcdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="QCAB01", property="qcab01", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAB02", property="qcab02", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAB03", property="qcab03", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCEV01", property="qcev01", jdbcType=JdbcType.NCHAR),
        @Result(column="QCEV02", property="qcev02", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUSER", property="qcuser", jdbcType=JdbcType.NCHAR),
        @Result(column="QCPID", property="qcpid", jdbcType=JdbcType.NCHAR),
        @Result(column="QCUPMJ", property="qcupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCTDAY", property="qctday", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCAOD", property="qcaod", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QCSOCN", property="qcsocn", jdbcType=JdbcType.DECIMAL),
        @Result(column="QCUREC", property="qcurec", jdbcType=JdbcType.DECIMAL)
    })
    List<Fe8wms13> selectAll();
}