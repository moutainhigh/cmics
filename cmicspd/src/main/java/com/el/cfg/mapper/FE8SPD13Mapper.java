package com.el.cfg.mapper;

import com.el.cfg.domain.FE8SPD13;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface FE8SPD13Mapper {
    @Select({
        "select",
        "JMUKID, JMRLLN, JMEV01, JME8PSDW, JME8PSDWE, JME8PSDWN, JME8CKKS, JME8CKKSE, ",
        "JME8CKKSN, JME8CKDH, JME8CKRQ, JME8CKLX, JME8SJLX, JMLNID, JME8YYYCD, JME8YYYCE, ",
        "JME8YYYCN, JME8SPDGG, JME8SCCS, JME8SPDCD, JME8SPDDW, JMLOT1, JMLOT2, JME8KCLX, ",
        "JME8YXQ, JME8SCRQ, JME8SPDBZ, JMUORG",
        "from FE8SPD13",
        "where JMUKID = #{jmukid,jdbcType=DECIMAL}",
          "and JMRLLN = #{jmrlln,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="JMUKID", property="jmukid", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="JMRLLN", property="jmrlln", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="JMEV01", property="jmev01", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDW", property="jme8psdw", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDWE", property="jme8psdwe", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDWN", property="jme8psdwn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKS", property="jme8ckks", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKSE", property="jme8ckkse", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKSN", property="jme8ckksn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKDH", property="jme8ckdh", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKRQ", property="jme8ckrq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8CKLX", property="jme8cklx", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SJLX", property="jme8sjlx", jdbcType=JdbcType.DECIMAL),
        @Result(column="JMLNID", property="jmlnid", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8YYYCD", property="jme8yyycd", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YYYCE", property="jme8yyyce", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YYYCN", property="jme8yyycn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDGG", property="jme8spdgg", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SCCS", property="jme8sccs", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDCD", property="jme8spdcd", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDDW", property="jme8spddw", jdbcType=JdbcType.NCHAR),
        @Result(column="JMLOT1", property="jmlot1", jdbcType=JdbcType.NCHAR),
        @Result(column="JMLOT2", property="jmlot2", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8KCLX", property="jme8kclx", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YXQ", property="jme8yxq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SCRQ", property="jme8scrq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SPDBZ", property="jme8spdbz", jdbcType=JdbcType.DECIMAL),
        @Result(column="JMUORG", property="jmuorg", jdbcType=JdbcType.DECIMAL)
    })
    FE8SPD13 selectByPrimaryKey(@Param("jmukid") BigDecimal jmukid, @Param("jmrlln") BigDecimal jmrlln);

    @Select({
        "select",
        "JMUKID, JMRLLN, JMEV01, JME8PSDW, JME8PSDWE, JME8PSDWN, JME8CKKS, JME8CKKSE, ",
        "JME8CKKSN, JME8CKDH, JME8CKRQ, JME8CKLX, JME8SJLX, JMLNID, JME8YYYCD, JME8YYYCE, ",
        "JME8YYYCN, JME8SPDGG, JME8SCCS, JME8SPDCD, JME8SPDDW, JMLOT1, JMLOT2, JME8KCLX, ",
        "JME8YXQ, JME8SCRQ, JME8SPDBZ, JMUORG",
        "from FE8SPD13"
    })
    @Results({
        @Result(column="JMUKID", property="jmukid", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="JMRLLN", property="jmrlln", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="JMEV01", property="jmev01", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDW", property="jme8psdw", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDWE", property="jme8psdwe", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8PSDWN", property="jme8psdwn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKS", property="jme8ckks", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKSE", property="jme8ckkse", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKKSN", property="jme8ckksn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKDH", property="jme8ckdh", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8CKRQ", property="jme8ckrq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8CKLX", property="jme8cklx", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SJLX", property="jme8sjlx", jdbcType=JdbcType.DECIMAL),
        @Result(column="JMLNID", property="jmlnid", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8YYYCD", property="jme8yyycd", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YYYCE", property="jme8yyyce", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YYYCN", property="jme8yyycn", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDGG", property="jme8spdgg", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SCCS", property="jme8sccs", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDCD", property="jme8spdcd", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8SPDDW", property="jme8spddw", jdbcType=JdbcType.NCHAR),
        @Result(column="JMLOT1", property="jmlot1", jdbcType=JdbcType.NCHAR),
        @Result(column="JMLOT2", property="jmlot2", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8KCLX", property="jme8kclx", jdbcType=JdbcType.NCHAR),
        @Result(column="JME8YXQ", property="jme8yxq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SCRQ", property="jme8scrq", jdbcType=JdbcType.DECIMAL),
        @Result(column="JME8SPDBZ", property="jme8spdbz", jdbcType=JdbcType.DECIMAL),
        @Result(column="JMUORG", property="jmuorg", jdbcType=JdbcType.DECIMAL)
    })
    List<FE8SPD13> selectAll();
}