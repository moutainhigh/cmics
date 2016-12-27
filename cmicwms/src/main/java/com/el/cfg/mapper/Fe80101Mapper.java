package com.el.cfg.mapper;

import com.el.cfg.domain.Fe80101;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface Fe80101Mapper {
    @Select({
        "select",
        "KSAN8, KSALPH, KSE8NAME, KSEV01, KSE8SCS, KSE8JXS, KSE8JKS, KSE8YY, KSE8YLJG, ",
        "KSE8GR, KSE8QT, KSE8DL, KSE8XL, KSE8YYYL, KSE8YYGL, KSE8YYSB, KSE8YYGS, KSE8YLJB, ",
        "KSE8TGYF, KSE8DWXZ, KSE8YYNSR, KSE8SFZ, KSE8SFFC, KSALKY, KSE8WMSID, KSE8WMSHZ, ",
        "KSE8WMSHZM, KSE8BYM, KSCUSTS, KSE8JDSJ, KSURCD, KSURDT, KSURAT, KSURAB, KSURRF, ",
        "KSEV02, KSEV03, KSEV04, KSEV05, KSDL01, KSDL02, KSDL03, KSDL010, KSDL011, KSUSER, ",
        "KSPID, KSJOBN, KSUPMJ, KSUPMT, KSIDATE, KSDF01, KSRDATE, KSDF02, KSUKID, KSSTATUS, ",
        "KSE8SCXKZ, KSE8SCBAH, KSE8JYCS, KSE8CKDZ, KSE8FR, KSE8QYFZR, KSE8YWLXR, KSFLAG, ",
        "KSE8CP, KSE8KPDZ, KSMCU, KSE8KSTYM, KSDATE01, KSTXT1, KSE8STR200",
        "from FE80101",
        "where KSAN8 = #{ksan8,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="KSAN8", property="ksan8", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="KSALPH", property="ksalph", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8NAME", property="kse8name", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV01", property="ksev01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCS", property="kse8scs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JXS", property="kse8jxs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JKS", property="kse8jks", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YY", property="kse8yy", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YLJG", property="kse8yljg", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8GR", property="kse8gr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8QT", property="kse8qt", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8DL", property="kse8dl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8XL", property="kse8xl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYYL", property="kse8yyyl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYGL", property="kse8yygl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYSB", property="kse8yysb", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYGS", property="kse8yygs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YLJB", property="kse8yljb", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8TGYF", property="kse8tgyf", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8DWXZ", property="kse8dwxz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYNSR", property="kse8yynsr", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSE8SFZ", property="kse8sfz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SFFC", property="kse8sffc", jdbcType=JdbcType.NCHAR),
        @Result(column="KSALKY", property="ksalky", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSID", property="kse8wmsid", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSHZ", property="kse8wmshz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSHZM", property="kse8wmshzm", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8BYM", property="kse8bym", jdbcType=JdbcType.NCHAR),
        @Result(column="KSCUSTS", property="kscusts", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JDSJ", property="kse8jdsj", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSURCD", property="ksurcd", jdbcType=JdbcType.NCHAR),
        @Result(column="KSURDT", property="ksurdt", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURAT", property="ksurat", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURAB", property="ksurab", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURRF", property="ksurrf", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV02", property="ksev02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV03", property="ksev03", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV04", property="ksev04", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV05", property="ksev05", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL01", property="ksdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL02", property="ksdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL03", property="ksdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL010", property="ksdl010", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL011", property="ksdl011", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUSER", property="ksuser", jdbcType=JdbcType.NCHAR),
        @Result(column="KSPID", property="kspid", jdbcType=JdbcType.NCHAR),
        @Result(column="KSJOBN", property="ksjobn", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUPMJ", property="ksupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSUPMT", property="ksupmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSIDATE", property="ksidate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSDF01", property="ksdf01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSRDATE", property="ksrdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSDF02", property="ksdf02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUKID", property="ksukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSSTATUS", property="ksstatus", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCXKZ", property="kse8scxkz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCBAH", property="kse8scbah", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JYCS", property="kse8jycs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8CKDZ", property="kse8ckdz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8FR", property="kse8fr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8QYFZR", property="kse8qyfzr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YWLXR", property="kse8ywlxr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSFLAG", property="ksflag", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8CP", property="kse8cp", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8KPDZ", property="kse8kpdz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSMCU", property="ksmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8KSTYM", property="kse8kstym", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDATE01", property="ksdate01", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSTXT1", property="kstxt1", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8STR200", property="kse8str200", jdbcType=JdbcType.NCHAR)
    })
    Fe80101 selectByPrimaryKey(BigDecimal ksan8);

    @Select({
        "select",
        "KSAN8, KSALPH, KSE8NAME, KSEV01, KSE8SCS, KSE8JXS, KSE8JKS, KSE8YY, KSE8YLJG, ",
        "KSE8GR, KSE8QT, KSE8DL, KSE8XL, KSE8YYYL, KSE8YYGL, KSE8YYSB, KSE8YYGS, KSE8YLJB, ",
        "KSE8TGYF, KSE8DWXZ, KSE8YYNSR, KSE8SFZ, KSE8SFFC, KSALKY, KSE8WMSID, KSE8WMSHZ, ",
        "KSE8WMSHZM, KSE8BYM, KSCUSTS, KSE8JDSJ, KSURCD, KSURDT, KSURAT, KSURAB, KSURRF, ",
        "KSEV02, KSEV03, KSEV04, KSEV05, KSDL01, KSDL02, KSDL03, KSDL010, KSDL011, KSUSER, ",
        "KSPID, KSJOBN, KSUPMJ, KSUPMT, KSIDATE, KSDF01, KSRDATE, KSDF02, KSUKID, KSSTATUS, ",
        "KSE8SCXKZ, KSE8SCBAH, KSE8JYCS, KSE8CKDZ, KSE8FR, KSE8QYFZR, KSE8YWLXR, KSFLAG, ",
        "KSE8CP, KSE8KPDZ, KSMCU, KSE8KSTYM, KSDATE01, KSTXT1, KSE8STR200",
        "from FE80101"
    })
    @Results({
        @Result(column="KSAN8", property="ksan8", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="KSALPH", property="ksalph", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8NAME", property="kse8name", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV01", property="ksev01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCS", property="kse8scs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JXS", property="kse8jxs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JKS", property="kse8jks", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YY", property="kse8yy", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YLJG", property="kse8yljg", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8GR", property="kse8gr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8QT", property="kse8qt", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8DL", property="kse8dl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8XL", property="kse8xl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYYL", property="kse8yyyl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYGL", property="kse8yygl", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYSB", property="kse8yysb", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYGS", property="kse8yygs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YLJB", property="kse8yljb", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8TGYF", property="kse8tgyf", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8DWXZ", property="kse8dwxz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YYNSR", property="kse8yynsr", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSE8SFZ", property="kse8sfz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SFFC", property="kse8sffc", jdbcType=JdbcType.NCHAR),
        @Result(column="KSALKY", property="ksalky", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSID", property="kse8wmsid", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSHZ", property="kse8wmshz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8WMSHZM", property="kse8wmshzm", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8BYM", property="kse8bym", jdbcType=JdbcType.NCHAR),
        @Result(column="KSCUSTS", property="kscusts", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JDSJ", property="kse8jdsj", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSURCD", property="ksurcd", jdbcType=JdbcType.NCHAR),
        @Result(column="KSURDT", property="ksurdt", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURAT", property="ksurat", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURAB", property="ksurab", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSURRF", property="ksurrf", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV02", property="ksev02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV03", property="ksev03", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV04", property="ksev04", jdbcType=JdbcType.NCHAR),
        @Result(column="KSEV05", property="ksev05", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL01", property="ksdl01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL02", property="ksdl02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL03", property="ksdl03", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL010", property="ksdl010", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDL011", property="ksdl011", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUSER", property="ksuser", jdbcType=JdbcType.NCHAR),
        @Result(column="KSPID", property="kspid", jdbcType=JdbcType.NCHAR),
        @Result(column="KSJOBN", property="ksjobn", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUPMJ", property="ksupmj", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSUPMT", property="ksupmt", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSIDATE", property="ksidate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSDF01", property="ksdf01", jdbcType=JdbcType.NCHAR),
        @Result(column="KSRDATE", property="ksrdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="KSDF02", property="ksdf02", jdbcType=JdbcType.NCHAR),
        @Result(column="KSUKID", property="ksukid", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSSTATUS", property="ksstatus", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCXKZ", property="kse8scxkz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8SCBAH", property="kse8scbah", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8JYCS", property="kse8jycs", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8CKDZ", property="kse8ckdz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8FR", property="kse8fr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8QYFZR", property="kse8qyfzr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8YWLXR", property="kse8ywlxr", jdbcType=JdbcType.NCHAR),
        @Result(column="KSFLAG", property="ksflag", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8CP", property="kse8cp", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8KPDZ", property="kse8kpdz", jdbcType=JdbcType.NCHAR),
        @Result(column="KSMCU", property="ksmcu", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8KSTYM", property="kse8kstym", jdbcType=JdbcType.NCHAR),
        @Result(column="KSDATE01", property="ksdate01", jdbcType=JdbcType.DECIMAL),
        @Result(column="KSTXT1", property="kstxt1", jdbcType=JdbcType.NCHAR),
        @Result(column="KSE8STR200", property="kse8str200", jdbcType=JdbcType.NCHAR)
    })
    List<Fe80101> selectAll();
}