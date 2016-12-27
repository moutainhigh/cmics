package com.el.cmic.mapper.inbound;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.el.cmic.domain.inbound.InboundPushDetail;

public interface InboundPushDetailMapper {
    @Select({
        "select",
        "CO, DOCO, DCTO, LNID as LNID, LITM, UORG/10000 as UORG, LOT1, LOT2, RP30, CASE WHEN YDDJ > 0 THEN TO_CHAR(TO_DATE(YDDJ+1900000, 'YYYYDDD'), 'YYYY-MM-DD') ELSE '' END AS YDDJ, DSC1, CXPH, RZPQ, ",
        "ZCZH",
        "from ${tableSchema}.VE8RK002"
    })
    @Results({
        @Result(column="CO", property="kcoo", jdbcType=JdbcType.NCHAR),
        @Result(column="DOCO", property="doco", jdbcType=JdbcType.DECIMAL),
        @Result(column="DCTO", property="dcto", jdbcType=JdbcType.NCHAR),
        @Result(column="LNID", property="lnid", jdbcType=JdbcType.DECIMAL),
        @Result(column="LITM", property="litm", jdbcType=JdbcType.NCHAR),
        @Result(column="UORG", property="uorg", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOT1", property="lot1", jdbcType=JdbcType.NCHAR),
        @Result(column="LOT2", property="lot2", jdbcType=JdbcType.NCHAR),
        @Result(column="RP30", property="rp30", jdbcType=JdbcType.NCHAR),
        @Result(column="YDDJ", property="yddj", jdbcType=JdbcType.DATE),
        @Result(column="DSC1", property="dsc1", jdbcType=JdbcType.NCHAR),
        @Result(column="CXPH", property="cxph", jdbcType=JdbcType.DECIMAL),
        @Result(column="RZPQ", property="rzpq", jdbcType=JdbcType.CHAR),
        @Result(column="ZCZH", property="zczh", jdbcType=JdbcType.CHAR)
    })
    List<InboundPushDetail> selectAll();
}