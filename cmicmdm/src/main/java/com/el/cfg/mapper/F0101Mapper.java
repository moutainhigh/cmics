package com.el.cfg.mapper;

import com.el.cfg.domain.F0101;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface F0101Mapper {
    @Select({
        "select",
        "ABAN8, ABALKY, ABTAX, ABALPH, ABDC, ABMCU, ABSIC, ABLNGP, ABAT1, ABCM, ABTAXC, ",
        "ABAT2, ABAT3, ABAT4, ABAT5, ABATP, ABATR, ABATPR, ABAB3, ABATE, ABSBLI, ABEFTB, ",
        "ABAN81, ABAN82, ABAN83, ABAN84, ABAN86, ABAN85, ABAC01, ABAC02, ABAC03, ABAC04, ",
        "ABAC05, ABAC06, ABAC07, ABAC08, ABAC09, ABAC10, ABAC11, ABAC12, ABAC13, ABAC14, ",
        "ABAC15, ABAC16, ABAC17, ABAC18, ABAC19, ABAC20, ABAC21, ABAC22, ABAC23, ABAC24, ",
        "ABAC25, ABAC26, ABAC27, ABAC28, ABAC29, ABAC30, ABGLBA, ABPTI, ABPDI, ABMSGA, ",
        "ABRMK, ABTXCT, ABTX2, ABALP1, ABURCD, ABURDT, ABURAT, ABURAB, ABURRF, ABUSER, ",
        "ABPID, ABUPMJ, ABJOBN, ABUPMT, ABPRGF, ABSCCLTP, ABTICKER, ABEXCHG, ABDUNS, ",
        "ABCLASS01, ABCLASS02, ABCLASS03, ABCLASS04, ABCLASS05, ABNOE, ABGROWTHR, ABYEARSTAR, ",
        "ABAEMPGP, ABACTIN, ABREVRNG, ABSYNCS, ABPERRS, ABCAAD",
        "from F0101",
        "where ABAN8 = #{aban8,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ABAN8", property="aban8", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ABALKY", property="abalky", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTAX", property="abtax", jdbcType=JdbcType.NCHAR),
        @Result(column="ABALPH", property="abalph", jdbcType=JdbcType.NCHAR),
        @Result(column="ABDC", property="abdc", jdbcType=JdbcType.NCHAR),
        @Result(column="ABMCU", property="abmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSIC", property="absic", jdbcType=JdbcType.NCHAR),
        @Result(column="ABLNGP", property="ablngp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT1", property="abat1", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCM", property="abcm", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTAXC", property="abtaxc", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT2", property="abat2", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT3", property="abat3", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT4", property="abat4", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT5", property="abat5", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATP", property="abatp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATR", property="abatr", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATPR", property="abatpr", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAB3", property="abab3", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATE", property="abate", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSBLI", property="absbli", jdbcType=JdbcType.NCHAR),
        @Result(column="ABEFTB", property="abeftb", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN81", property="aban81", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN82", property="aban82", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN83", property="aban83", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN84", property="aban84", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN86", property="aban86", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN85", property="aban85", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAC01", property="abac01", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC02", property="abac02", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC03", property="abac03", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC04", property="abac04", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC05", property="abac05", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC06", property="abac06", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC07", property="abac07", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC08", property="abac08", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC09", property="abac09", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC10", property="abac10", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC11", property="abac11", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC12", property="abac12", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC13", property="abac13", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC14", property="abac14", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC15", property="abac15", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC16", property="abac16", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC17", property="abac17", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC18", property="abac18", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC19", property="abac19", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC20", property="abac20", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC21", property="abac21", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC22", property="abac22", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC23", property="abac23", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC24", property="abac24", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC25", property="abac25", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC26", property="abac26", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC27", property="abac27", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC28", property="abac28", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC29", property="abac29", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC30", property="abac30", jdbcType=JdbcType.NCHAR),
        @Result(column="ABGLBA", property="abglba", jdbcType=JdbcType.NCHAR),
        @Result(column="ABPTI", property="abpti", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPDI", property="abpdi", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABMSGA", property="abmsga", jdbcType=JdbcType.NCHAR),
        @Result(column="ABRMK", property="abrmk", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTXCT", property="abtxct", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTX2", property="abtx2", jdbcType=JdbcType.NCHAR),
        @Result(column="ABALP1", property="abalp1", jdbcType=JdbcType.NCHAR),
        @Result(column="ABURCD", property="aburcd", jdbcType=JdbcType.NCHAR),
        @Result(column="ABURDT", property="aburdt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURAT", property="aburat", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURAB", property="aburab", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURRF", property="aburrf", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUSER", property="abuser", jdbcType=JdbcType.NCHAR),
        @Result(column="ABPID", property="abpid", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUPMJ", property="abupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABJOBN", property="abjobn", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUPMT", property="abupmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPRGF", property="abprgf", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSCCLTP", property="absccltp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTICKER", property="abticker", jdbcType=JdbcType.NCHAR),
        @Result(column="ABEXCHG", property="abexchg", jdbcType=JdbcType.NCHAR),
        @Result(column="ABDUNS", property="abduns", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS01", property="abclass01", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS02", property="abclass02", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS03", property="abclass03", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS04", property="abclass04", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS05", property="abclass05", jdbcType=JdbcType.NCHAR),
        @Result(column="ABNOE", property="abnoe", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABGROWTHR", property="abgrowthr", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABYEARSTAR", property="abyearstar", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAEMPGP", property="abaempgp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABACTIN", property="abactin", jdbcType=JdbcType.NCHAR),
        @Result(column="ABREVRNG", property="abrevrng", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSYNCS", property="absyncs", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPERRS", property="abperrs", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABCAAD", property="abcaad", jdbcType=JdbcType.DECIMAL)
    })
    F0101 selectByPrimaryKey(BigDecimal aban8);

    @Select({
        "select",
        "ABAN8, ABALKY, ABTAX, ABALPH, ABDC, ABMCU, ABSIC, ABLNGP, ABAT1, ABCM, ABTAXC, ",
        "ABAT2, ABAT3, ABAT4, ABAT5, ABATP, ABATR, ABATPR, ABAB3, ABATE, ABSBLI, ABEFTB, ",
        "ABAN81, ABAN82, ABAN83, ABAN84, ABAN86, ABAN85, ABAC01, ABAC02, ABAC03, ABAC04, ",
        "ABAC05, ABAC06, ABAC07, ABAC08, ABAC09, ABAC10, ABAC11, ABAC12, ABAC13, ABAC14, ",
        "ABAC15, ABAC16, ABAC17, ABAC18, ABAC19, ABAC20, ABAC21, ABAC22, ABAC23, ABAC24, ",
        "ABAC25, ABAC26, ABAC27, ABAC28, ABAC29, ABAC30, ABGLBA, ABPTI, ABPDI, ABMSGA, ",
        "ABRMK, ABTXCT, ABTX2, ABALP1, ABURCD, ABURDT, ABURAT, ABURAB, ABURRF, ABUSER, ",
        "ABPID, ABUPMJ, ABJOBN, ABUPMT, ABPRGF, ABSCCLTP, ABTICKER, ABEXCHG, ABDUNS, ",
        "ABCLASS01, ABCLASS02, ABCLASS03, ABCLASS04, ABCLASS05, ABNOE, ABGROWTHR, ABYEARSTAR, ",
        "ABAEMPGP, ABACTIN, ABREVRNG, ABSYNCS, ABPERRS, ABCAAD",
        "from F0101"
    })
    @Results({
        @Result(column="ABAN8", property="aban8", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ABALKY", property="abalky", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTAX", property="abtax", jdbcType=JdbcType.NCHAR),
        @Result(column="ABALPH", property="abalph", jdbcType=JdbcType.NCHAR),
        @Result(column="ABDC", property="abdc", jdbcType=JdbcType.NCHAR),
        @Result(column="ABMCU", property="abmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSIC", property="absic", jdbcType=JdbcType.NCHAR),
        @Result(column="ABLNGP", property="ablngp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT1", property="abat1", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCM", property="abcm", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTAXC", property="abtaxc", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT2", property="abat2", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT3", property="abat3", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT4", property="abat4", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAT5", property="abat5", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATP", property="abatp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATR", property="abatr", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATPR", property="abatpr", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAB3", property="abab3", jdbcType=JdbcType.NCHAR),
        @Result(column="ABATE", property="abate", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSBLI", property="absbli", jdbcType=JdbcType.NCHAR),
        @Result(column="ABEFTB", property="abeftb", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN81", property="aban81", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN82", property="aban82", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN83", property="aban83", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN84", property="aban84", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN86", property="aban86", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAN85", property="aban85", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABAC01", property="abac01", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC02", property="abac02", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC03", property="abac03", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC04", property="abac04", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC05", property="abac05", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC06", property="abac06", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC07", property="abac07", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC08", property="abac08", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC09", property="abac09", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC10", property="abac10", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC11", property="abac11", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC12", property="abac12", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC13", property="abac13", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC14", property="abac14", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC15", property="abac15", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC16", property="abac16", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC17", property="abac17", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC18", property="abac18", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC19", property="abac19", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC20", property="abac20", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC21", property="abac21", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC22", property="abac22", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC23", property="abac23", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC24", property="abac24", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC25", property="abac25", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC26", property="abac26", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC27", property="abac27", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC28", property="abac28", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC29", property="abac29", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAC30", property="abac30", jdbcType=JdbcType.NCHAR),
        @Result(column="ABGLBA", property="abglba", jdbcType=JdbcType.NCHAR),
        @Result(column="ABPTI", property="abpti", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPDI", property="abpdi", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABMSGA", property="abmsga", jdbcType=JdbcType.NCHAR),
        @Result(column="ABRMK", property="abrmk", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTXCT", property="abtxct", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTX2", property="abtx2", jdbcType=JdbcType.NCHAR),
        @Result(column="ABALP1", property="abalp1", jdbcType=JdbcType.NCHAR),
        @Result(column="ABURCD", property="aburcd", jdbcType=JdbcType.NCHAR),
        @Result(column="ABURDT", property="aburdt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURAT", property="aburat", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURAB", property="aburab", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABURRF", property="aburrf", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUSER", property="abuser", jdbcType=JdbcType.NCHAR),
        @Result(column="ABPID", property="abpid", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUPMJ", property="abupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABJOBN", property="abjobn", jdbcType=JdbcType.NCHAR),
        @Result(column="ABUPMT", property="abupmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPRGF", property="abprgf", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSCCLTP", property="absccltp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABTICKER", property="abticker", jdbcType=JdbcType.NCHAR),
        @Result(column="ABEXCHG", property="abexchg", jdbcType=JdbcType.NCHAR),
        @Result(column="ABDUNS", property="abduns", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS01", property="abclass01", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS02", property="abclass02", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS03", property="abclass03", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS04", property="abclass04", jdbcType=JdbcType.NCHAR),
        @Result(column="ABCLASS05", property="abclass05", jdbcType=JdbcType.NCHAR),
        @Result(column="ABNOE", property="abnoe", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABGROWTHR", property="abgrowthr", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABYEARSTAR", property="abyearstar", jdbcType=JdbcType.NCHAR),
        @Result(column="ABAEMPGP", property="abaempgp", jdbcType=JdbcType.NCHAR),
        @Result(column="ABACTIN", property="abactin", jdbcType=JdbcType.NCHAR),
        @Result(column="ABREVRNG", property="abrevrng", jdbcType=JdbcType.NCHAR),
        @Result(column="ABSYNCS", property="absyncs", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABPERRS", property="abperrs", jdbcType=JdbcType.DECIMAL),
        @Result(column="ABCAAD", property="abcaad", jdbcType=JdbcType.DECIMAL)
    })
    List<F0101> selectAll();
}