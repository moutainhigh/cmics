package com.el.cmic.mapper.inbound;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Value;

import com.el.cmic.domain.inbound.InboundPush;
import com.el.cmic.domain.inbound.InboundPushDetail;
import com.el.cmic.domain.inbound.InboundPushSerial;
import com.el.utils.ReadPropertiesUtil;
import org.springframework.util.StringUtils;

public interface InboundBackMapper {

    @Value("${tableSchema}")
    final String tableSchema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");

    final String UPMJ = "(SELECT TO_CHAR(sysdate, 'YYYYDDD') - 1900000 JULIAN  FROM DUAL)";
    final String TDAY = "(SELECT TO_CHAR(sysdate, 'HH24MISS') JULIAN  FROM DUAL)";

    final class SqlProvider extends SQL {

        public String insertFe8wms04(@Param("inboundPush") InboundPush inboundPush,
                                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail,
                                     @Param("inboundPushSerial") InboundPushSerial inboundPushSerial) {
            INSERT_INTO(tableSchema + ".Fe8wms04");
            VALUES("XLPTUT01", "#{inboundPushSerial.serial}");
            VALUES("XLAA05", "#{inboundPushSerial.type}");
            VALUES("XLCA01", "1");
            VALUES("XLUPRC", "#{inboundPushSerial.pack,jdbcType=NUMERIC}*10000");
            VALUES("XLUORG", "#{inboundPushSerial.ists,jdbcType=NUMERIC}*10000");
            VALUES("XLLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("XLPTUT02", "#{inboundPushDetail.lot1,jdbcType=NCHAR}");
            VALUES("XLUSER", "'WMS'");
            VALUES("XLPID", "'Interface'");
            VALUES("XLKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("Xlmcu", "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("XLDOCO", "#{inboundPush.doco}");
            VALUES("XLDCTO", "#{inboundPush.dcto}");
            // VALUES("XLJOBN", "'Server'");
            VALUES("XLUPMJ", UPMJ);
            VALUES("XLTDAY", TDAY);
            VALUES("XLLOTN", "#{inboundPushDetail.lotn,jdbcType=NCHAR}");
            VALUES("XLLOT1", "#{inboundPushDetail.lot1,jdbcType=NCHAR}");
            VALUES("XLLOT2", "#{inboundPushDetail.lot2,jdbcType=NCHAR}");
            VALUES("Xldl02", "'JKWMS'");
            return toString();
        }

        public String insertFe8wms05(@Param("inboundPush") InboundPush inboundPush,
                                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail) {
            INSERT_INTO(tableSchema + ".FE8WMS05");
            VALUES("XLMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("XLCA01", "#{inboundPush.rktype}");
            VALUES("XLKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("XLDOCO", "#{inboundPush.doco}");
            VALUES("XLDCTO", "#{inboundPush.dcto}");
            VALUES("XLCF01", "#{inboundPushDetail.remark,jdbcType=NCHAR}");
            VALUES("XLLNID", "#{inboundPushDetail.lnid,jdbcType=NUMERIC}");
            VALUES("XLLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("XLPTUT01", "#{inboundPushDetail.lot1,jdbcType=NCHAR}");
            VALUES("XLPTUT02", "#{inboundPushDetail.lot2,jdbcType=NCHAR}");
            VALUES("XLCA02", "#{inboundPushDetail.rp30,jdbcType=NCHAR}");
            VALUES("XLUPRC", "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000");
            VALUES("XLPRRC", "#{inboundPushDetail.disq,jdbcType=NUMERIC}*10000");
            VALUES("XLAMC3", "#{inboundPushDetail.amc3,jdbcType=NUMERIC}*10000");
            VALUES("XLTRDJ", "#{inboundPushDetail.addjj,jdbcType=NUMERIC}");
            VALUES("XLPEFJ", "#{inboundPushDetail.exdjj,jdbcType=NUMERIC}");
            VALUES("XLPSDJ", "#{inboundPushDetail.prdjj,jdbcType=NUMERIC}");
            VALUES("XLGRWT", "#{inboundPushDetail.pack,jdbcType=NUMERIC}*10000");
            VALUES("XLUSER", "'WMS'");
            VALUES("XLPID", "'Interface'");
            // VALUES("XLJOBN", "'Server'");
            VALUES("XLUPMJ", UPMJ);
            VALUES("XLTDAY", TDAY);
            return toString();
        }

        public String insertFe8wms17(@Param("inboundPush") InboundPush inboundPush,
                                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail) {
            INSERT_INTO(tableSchema + ".Fe8wms17");
            VALUES("CRMCU", "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("CRLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("CRLOTN", "#{inboundPushDetail.lotn,jdbcType=NCHAR}");
            if (!StringUtils.isEmpty(inboundPushDetail.getLot1())) {
                VALUES("CRLOT1", "#{inboundPushDetail.lot1,jdbcType=NCHAR}");
            } else {
                VALUES("CRLOT1", "' '");
            }
            if (!StringUtils.isEmpty(inboundPushDetail.getLot2())) {
                VALUES("CRLOT2", "#{inboundPushDetail.lot2,jdbcType=NCHAR}");
            } else {
                VALUES("CRLOT2", "' '");
            }

            VALUES("CRKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("CRDOCO", "#{inboundPush.doco}");
            VALUES("CRDCTO", "#{inboundPush.dcto}");
            VALUES("CRLNID", "#{inboundPushDetail.lnid}");
            VALUES("CRUSER", "'WMS'");
            VALUES("CRPID", "'Interface'");
            // VALUES("CRJOBN", "'Server'");
            VALUES("CRUPMJ", UPMJ);
            VALUES("CRTDAY", TDAY);
            VALUES("Crev01", "' '");
            VALUES("Crd01", "#{inboundPushDetail.prdjj}");//生产日期
            VALUES("Crd02", "#{inboundPushDetail.exdjj}");//有效期至
            return toString();
        }

        public String insertF47071(@Param("inboundPush") InboundPush inboundPush) {
            INSERT_INTO(tableSchema + ".F47071");
            VALUES("SYEKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SYEDOC", "#{inboundPush.edoc}");
            VALUES("SYEDST", "'861'");
            VALUES("SYEDER", "'R'");
            VALUES("SYEDSP", "'N'");
            VALUES("SYTPUR", "'02'");
            VALUES("SYRATY", "'2'");
            VALUES("SYDCTO", "#{inboundPush.dcto}");
            VALUES("SYSFXO", "'000'");
            VALUES("SYAN8", "(SELECT PHAN8 from " + tableSchema
                    + ".F4301 where PHDOCO=#{inboundPush.doco} and PHDCTO=#{inboundPush.dcto})");
            VALUES("SYSHAN", "(SELECT PHSHAN from " + tableSchema
                    + ".F4301 where PHDOCO=#{inboundPush.doco} and PHDCTO=#{inboundPush.dcto})");
            VALUES("SYUSER", "'WMS'");
            VALUES("SYPID", "'Interface'");
            VALUES("SYJOBN", "'Server'");
            VALUES("SYUPMJ", UPMJ);
            VALUES("SYTDAY", TDAY);
            VALUES("SYMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("SYKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SYEDCT", "#{inboundPush.dcto}");
            VALUES("SYDOCO", "#{inboundPush.doco}");
            return toString();
        }

        public String insertF47072(@Param("inboundPush") InboundPush inboundPush,
                                   @Param("inboundPushDetail") InboundPushDetail inboundPushDetail) {
            INSERT_INTO(tableSchema + ".F47072");
            VALUES("SZEKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SZEDOC", "#{inboundPush.edoc}");
            VALUES("SZEDCT", "#{inboundPush.dcto}");
            VALUES("SZEDST", "'861'");
            VALUES("SZEDER", "'R'");
            VALUES("SZEDSP", "'N'");
            VALUES("SZLSTS", "'7'");
            VALUES("SZKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SZDOCO", "#{inboundPush.doco}");
            VALUES("SZDCTO", "#{inboundPush.dcto}");
            VALUES("SZSFXO", "'000'");
            VALUES("SZMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("SZAN8", "(SELECT pdan8 from " + tableSchema
                    + ".F4311 where pddoco=#{inboundPush.doco} and pddcto=#{inboundPush.dcto} and pdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZSHAN", "(SELECT pdSHAN from " + tableSchema
                    + ".F4311 where pddoco=#{inboundPush.doco} and pddcto=#{inboundPush.dcto} and pdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZLOTN", "#{inboundPushDetail.lotn,jdbcType=NCHAR}");
            VALUES("SZUORG", "(SELECT pdUORG from " + tableSchema
                    + ".F4311 where pddoco=#{inboundPush.doco} and pddcto=#{inboundPush.dcto} and pdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZUSER", "'WMS'");
            VALUES("SZPID", "'Interface'");
            VALUES("SZJOBN", "'Server'");
            VALUES("SZUPMJ", UPMJ);
            VALUES("SZTDAY", TDAY);
            VALUES("SZEDLN", "#{inboundPushDetail.lnid}");
            VALUES("SZLNID", "#{inboundPushDetail.lnid}");
            VALUES("SZLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("SZUREC", "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000");
            VALUES("SZADDJ", "#{inboundPushDetail.addjj,jdbcType=NUMERIC}");
            VALUES("SZBCRC", "'CNY'");//本位 币
            VALUES("SZCRR", "0");//汇 率
            VALUES("SZTRDJ", "(SELECT TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'yyyy') * 1000 +TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'ddd ') - 1900000 JULIAN FROM DUAL)");
            //失效日期 月份=trdj+1年
            VALUES("SZMMEJ", "(SELECT TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'yyyy') * 1000 +TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'ddd ') - 1900000+1000 JULIAN FROM DUAL)");
            VALUES("SZUOM", "' '");//计量单位
            return toString();
        }

        public String insertF47131(@Param("inboundPush") InboundPush inboundPush) {
            INSERT_INTO(tableSchema + ".F47131");
            VALUES("SYEKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SYEDOC", "#{inboundPush.edoc}");
            VALUES("SYEDCT", "#{inboundPush.dcto}");
            VALUES("SYEDST", "'860'");
            VALUES("SYEDDT", UPMJ);
            VALUES("SYEDER", "'R'");
            VALUES("SYEDSP", "'N'");
            VALUES("SYTPUR", "'4'");
            VALUES("SYSFXO", "'000'");
            VALUES("SYAN8", "(SELECT shan8 from " + tableSchema
                    + ".F4201 where shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            VALUES("SYSHAN", "(SELECT shshan from " + tableSchema
                    + ".F4201 where shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            VALUES("SYDRQJ", "(SELECT shtrdj  from " + tableSchema
                    + ".F4201 where shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            VALUES("SYTRDJ", "(SELECT shtrdj  from " + tableSchema
                    + ".F4201 where shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            VALUES("SYUSER", "'WMS'");
            VALUES("SYPID", "'Interface'");
            VALUES("SYJOBN", "'Server'");
            VALUES("SYUPMJ", UPMJ);
            VALUES("SYTDAY", TDAY);
            VALUES("SYMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("SYDCTO", "#{inboundPush.dcto}");
            VALUES("SYKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SYDOCO", "#{inboundPush.doco}");
            return toString();
        }

        public String insertF47132(@Param("inboundPush") InboundPush inboundPush,
                                   @Param("inboundPushDetail") InboundPushDetail inboundPushDetail) {
            INSERT_INTO(tableSchema + ".F47132");
            VALUES("SZEKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SZEDOC", "#{inboundPush.edoc}");
            VALUES("SZEDCT", "#{inboundPush.dcto}");
            VALUES("SZEDST", "'860'");
            VALUES("SZEDER", "'R'");
            VALUES("SZEDSP", "'N'");
            VALUES("SZLSTS", "'7'");
            VALUES("SZKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("SZDOCO", "#{inboundPush.doco}");
            VALUES("SZDCTO", "#{inboundPush.dcto}");
            VALUES("SZSFXO", "'000'");
            VALUES("SZMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("SZAN8", "(SELECT sdan8 from " + tableSchema
                    + ".F4211 where sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and sdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZSHAN", "(SELECT sdshan from " + tableSchema
                    + ".F4211 where sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and sdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZLOTN", "#{inboundPushDetail.lotn}");
            VALUES("SZUORG", "(SELECT sduorg from " + tableSchema
                    + ".F4211 where sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and sdlnid=#{inboundPushDetail.lnid})");
            VALUES("SZUSER", "'WMS'");
            VALUES("SZPID", "'Interface'");
            VALUES("SZJOBN", "'Server'");
            VALUES("SZUPMJ", UPMJ);
            VALUES("SZTDAY", TDAY);
            VALUES("SZEDLN", "#{inboundPushDetail.lnid}");
            VALUES("SZLNID", "#{inboundPushDetail.lnid}");
            VALUES("SZLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("SZSOQS", "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000");
            VALUES("SZADDJ", "#{inboundPushDetail.addjj,jdbcType=NUMERIC}");
            return toString();
        }

        public String insertF47121(@Param("inboundPush") InboundPush inboundPush) {
            INSERT_INTO(tableSchema + ".F47121");
            VALUES("M1EDTY", "'2'");
            VALUES("M1EKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("M1EDOC", "#{inboundPush.edoc}");
            VALUES("M1EDCT", "#{inboundPush.dcto}");
            VALUES("M1EDST", "'852'");
            VALUES("M1EDDT", UPMJ);
            VALUES("M1EDER", "'R'");
            VALUES("M1EDSP", "'N'");
            VALUES("M1TPUR", "'4'");
            VALUES("M1SFXO", "'000'");
            // VALUES("M1AN8", "(SELECT shan8 from F4201 where
            // shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            // VALUES("M1SHAN", "(SELECT shshan from F4201 where
            // shdoco=#{inboundPush.doco} and shdcto=#{inboundPush.dcto})");
            VALUES("M1USER", "'WMS'");
            VALUES("M1PID", "'Interface'");
            VALUES("M1JOBN", "'Server'");
            VALUES("M1UPMJ", UPMJ);
            VALUES("M1TDAY", TDAY);
            VALUES("M1MCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            VALUES("M1DCTO", "#{inboundPush.dcto}");
            VALUES("M1KCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("M1DOCO", "#{inboundPush.doco}");
            return toString();
        }

        public String insertF47122(@Param("inboundPush") InboundPush inboundPush,
                                   @Param("inboundPushDetail") InboundPushDetail inboundPushDetail) {
            INSERT_INTO(tableSchema + ".F47122");
            VALUES("MJEDTY", "'2'");
            VALUES("MJEKCO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("MJEDOC", "#{inboundPush.edoc}");
            VALUES("MJEDCT", "#{inboundPush.dcto}");
            VALUES("MJEDST", "'852'");
            VALUES("MJEDER", "'R'");
            VALUES("MJEDSP", "'N'");
            VALUES("MJLSTS", "'7'");
            VALUES("MJKCOO", "(select LSCO from " + tableSchema + ".FE8WMS20 where TRIM(LSE8HZBM)=#{inboundPush.wmsco})");
            VALUES("MJDOCO", "#{inboundPush.doco}");
            VALUES("MJDCTO", "#{inboundPush.dcto}");
            VALUES("MJSFXO", "'000'");
            VALUES("MJMCU",
                    "(select LSMCU from " + tableSchema + ".FE8WMS21 where TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu})");
            // VALUES("MJAN8", "(SELECT sdan8 from F4211 where
            // sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and
            // sdlnid=#{inboundPushDetail.lnid})");
            // VALUES("MJSHAN", "(SELECT sdshan from F4211 where
            // sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and
            // sdlnid=#{inboundPushDetail.lnid})");
            // VALUES("MJLOTN", "#{inboundPushDetail.lotn}");
            // VALUES("MJUORG", "(SELECT sduorg from F4211 where
            // sddoco=#{inboundPush.doco} and sddcto=#{inboundPush.dcto} and
            // sdlnid=#{inboundPushDetail.lnid})");
            VALUES("MJLOTN", "#{inboundPushDetail.lotn,jdbcType=NCHAR}");
            VALUES("MJUSER", "'WMS'");
            VALUES("MJPID", "'Interface'");
            VALUES("MJJOBN", "'Server'");
            VALUES("MJUPMJ", UPMJ);
            VALUES("MJTDAY", TDAY);
            VALUES("MJEDLN", "#{inboundPushDetail.lnid}");
            VALUES("MJLNID", "#{inboundPushDetail.lnid}");
            VALUES("MJLITM", "#{inboundPushDetail.litm,jdbcType=NCHAR}");
            VALUES("MJTRQT", "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000");
            VALUES("MJTRDJ", "#{inboundPushDetail.addjj,jdbcType=NUMERIC}");
            return toString();
        }

    }

    @InsertProvider(type = SqlProvider.class, method = "insertFe8wms04")
    int insertFe8wms04(@Param("inboundPush") InboundPush inboundPush,
                       @Param("inboundPushDetail") InboundPushDetail inboundPushDetail,
                       @Param("inboundPushSerial") InboundPushSerial inboundPushSerial);

    // @InsertProvider(type = SqlProvider.class, method = "insertFe8wms05")
    @Insert({"insert into ${tableSchema}.FE8WMS05 (", "XLMCU,", "XLCA01,", "XLKCOO,", "XLDOCO,", "XLDCTO,", "XLCF01,",
            "XLLNID,", "XLLITM,", "XLPTUT01,", "XLPTUT02,", "XLCA02,", "XLUPRC,", "XLPRRC,", "XLAMC3,", "XLTRDJ,",
            "XLPEFJ,", "XLPSDJ,", "XLGRWT,", "XLUSER,", "XLPID,", /*"XLJOBN,",*/ "XLUPMJ,", "XLTDAY)", "select ", "LSMCU,",
            "#{inboundPush.rktype},", "LSCO,", "#{inboundPush.doco},", "#{inboundPush.dcto},",
            "#{inboundPushDetail.remark,jdbcType=NCHAR},", "#{inboundPushDetail.lnid,jdbcType=NUMERIC},",
            "#{inboundPushDetail.litm,jdbcType=NCHAR},", "#{inboundPushDetail.lot1,jdbcType=NCHAR},", "#{inboundPushDetail.lot2,jdbcType=NCHAR},",
            "#{inboundPushDetail.rp30,jdbcType=NCHAR},", "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000,",
            "#{inboundPushDetail.disq,jdbcType=NUMERIC}*10000,", "#{inboundPushDetail.amc3,jdbcType=NUMERIC}*10000,",
            "#{inboundPushDetail.addjj,jdbcType=NUMERIC},", "#{inboundPushDetail.exdjj,jdbcType=NUMERIC},",
            "#{inboundPushDetail.prdjj,jdbcType=NUMERIC},", "#{inboundPushDetail.pack,jdbcType=NUMERIC}*10000,", "'WMS',",
            "'Interface',", /*"'Server',",*/ "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual)", "from dual",
            "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}"})
    int insertFe8wms05(@Param("inboundPush") InboundPush inboundPush,
                       @Param("inboundPushDetail") InboundPushDetail inboundPushDetail);

    @InsertProvider(type = SqlProvider.class, method = "insertFe8wms17")
    int insertFe8wms17(@Param("inboundPush") InboundPush inboundPush,
                       @Param("inboundPushDetail") InboundPushDetail inboundPushDetail);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47071")
    @Insert({"insert into ${tableSchema}.F47071 (", "SYEKCO,", "SYEDOC,", "SYEDST,", "SYEDER,", "SYEDSP,", "SYTPUR,",
            "SYRATY,", "SYDCTO,", "SYSFXO,", "SYAN8,", "SYSHAN,", "SYUSER,", "SYPID,", "SYJOBN,", "SYUPMJ,", "SYTDAY,",
            "SYMCU,", "SYKCOO,", "SYEDCT,", "SYDOCO)", "select ", "LSCO,", "#{inboundPush.edoc},", "'861',", "'R',",
            "'N',", "'02',", "'2',", "#{inboundPush.dcto},", "'000',", "PHAN8,", "PHSHAN,", "'WMS',", "'Interface',",
            "'Server',", "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "LSMCU,", "LSCO,", "#{inboundPush.dcto},",
            "#{inboundPush.doco}", "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}",
            "left join ${tableSchema}.F4301 on PHDOCO=#{inboundPush.doco} and PHDCTO=#{inboundPush.dcto} and PHKCOO=LSCO"})
    @SelectKey(statement = "SELECT F47071_SEQ.NEXTVAL FROM DUAL", keyProperty = "inboundPush.edoc", resultType = BigDecimal.class, before = true)
    int insertF47071(@Param("inboundPush") InboundPush inboundPush);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47072")
    @Insert({"insert into ${tableSchema}.F47072 (", "SZEKCO,", "SZEDOC,", "SZEDCT,", "SZEDST,", "SZEDER,", "SZEDSP,",
            "SZLSTS,", "SZKCOO,", "SZDOCO,", "SZDCTO,", "SZSFXO,", "SZMCU,", "SZAN8,", "SZSHAN,", "SZLOTN,", "SZUORG,",
            "SZUSER,", "SZPID,", "SZJOBN,", "SZUPMJ,", "SZTDAY,", "SZEDLN,", "SZLNID,", "SZLITM,", "SZUREC,", "SZADDJ,", "SZBCRC,", "SZCRR,", "SZTRDJ,", "SZMMEJ,", "SZUOM)",
            "select ", "LSCO,", "#{inboundPush.edoc},", "#{inboundPush.dcto},", "'861',", "'R',", "'N',", "'7',",
            "LSCO,", "#{inboundPush.doco},", "#{inboundPush.dcto},", "'000',", "LSMCU,", "PDAN8,", "PDSHAN,", "#{inboundPushDetail.lotn,jdbcType=NCHAR},",
            "PDUORG,", "'WMS',", "'Interface',", "'Server',",
            "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "#{inboundPushDetail.lnid},",
            "#{inboundPushDetail.lnid},", "#{inboundPushDetail.litm,jdbcType=NCHAR},",
            "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000,", "#{inboundPushDetail.addjj,jdbcType=NUMERIC},", "'CNY',", "0,", "(SELECT TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'yyyy') * 1000 +TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'ddd ') - 1900000 JULIAN FROM DUAL),", "(SELECT TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'yyyy') * 1000 +TO_CHAR(nvl(#{inboundPush.trdj},sysdate), 'ddd ') - 1900000+1000 JULIAN FROM DUAL),", "Pduom",
            "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}",
            "left join ${tableSchema}.F4311 on PDKCOO=LSCO and PDDOCO=#{inboundPush.doco} and PDDCTO=#{inboundPush.dcto} and PDLNID=#{inboundPushDetail.lnid}"})
    @SelectKey(statement = "select daily_sequence() from dual", keyProperty = "inboundPushDetail.lotn", resultType = String.class, before = true)
    int insertF47072(@Param("inboundPush") InboundPush inboundPush,
                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47131")
    @Insert({"insert into ${tableSchema}.F47131 (", "SYEKCO,", "SYEDOC,", "SYEDCT,", "SYEDST,", "SYEDDT,", "SYEDER,",
            "SYEDSP,", "SYTPUR,", "SYSFXO,", "SYAN8,", "SYSHAN,", "SYDRQJ,", "SYTRDJ,", "SYUSER,", "SYPID,", "SYJOBN,",
            "SYUPMJ,", "SYTDAY,", "SYMCU,", "SYDCTO,", "SYKCOO,", "SYDOCO)", "select ", "LSCO,", "#{inboundPush.edoc},",
            "#{inboundPush.dcto},", "'860',", "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),", "'R',", "'N',", "'4',", "'000',", "shan8,", "shshan,", "shtrdj,",
            "shtrdj,", "'WMS',", "'Interface',", "'Server',",
            "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "LSMCU,", "#{inboundPush.dcto},", "LSCO,",
            "#{inboundPush.doco}", "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}",
            "left join ${tableSchema}.F4201 on SHDOCO=#{inboundPush.doco} and SHDCTO=#{inboundPush.dcto} and SHKCOO=LSCO"})
    @SelectKey(statement = "SELECT F47131_SEQ.NEXTVAL FROM DUAL", keyProperty = "inboundPush.edoc", resultType = BigDecimal.class, before = true)
    int insertF47131(@Param("inboundPush") InboundPush inboundPush);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47132")
    @Insert({"insert into ${tableSchema}.F47132 (", "SZEKCO,", "SZEDOC,", "SZEDCT,", "SZEDST,", "SZEDER,", "SZEDSP,",
            /*"SZLSTS,",*/ "SZKCOO,", "SZDOCO,", "SZDCTO,", "SZSFXO,", "SZMCU,", "SZAN8,", "SZSHAN,", "SZLOTN,", "SZUORG,", "SZUSER,",
            "SZPID,", "SZJOBN,", "SZUPMJ,", "SZTDAY,", "SZEDLN,", "SZLNID,", "SZLITM,", "SZSOQS,", "SZADDJ,", "szlocn,",  "SZLNTY,", "SZNXTR,", "SZLTTR,", "SZSONE,", "SZSWMS)", "select",
            "LSCO,", "#{inboundPush.edoc},", "#{inboundPush.dcto},", "'860',", "'R',", "'N',", /*"'7',",*/ "LSCO,",
            "#{inboundPush.doco},", "#{inboundPush.dcto},", "'000',", "LSMCU,", "sdan8,", "sdshan,", "sdlotn,", "sduorg,",
            "'WMS',", "'Interface',", "'Server',", "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "#{inboundPushDetail.lnid},",
            "#{inboundPushDetail.lnid},", "#{inboundPushDetail.litm,jdbcType=NCHAR},",
            "#{inboundPushDetail.urec,jdbcType=NUMERIC}*-10000,", "#{inboundPushDetail.addjj,jdbcType=NUMERIC},", "sdlocn,",  "'S',", "'580',", "'560',", "0,", "' '",
            "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}",
            "left join ${tableSchema}.F4211 on SDKCOO=LSCO and SDDOCO=#{inboundPush.doco} and SDDCTO=#{inboundPush.dcto} and SDLNID=#{inboundPushDetail.lnid}"})
    @SelectKey(statement = "select daily_sequence() from dual", keyProperty = "inboundPushDetail.lotn", resultType = String.class, before = true)
    int insertF47132(@Param("inboundPush") InboundPush inboundPush,
                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47121")
    @Insert({"insert into ${tableSchema}.F47121 (", "M1EDTY,", "M1EKCO,", "M1EDOC,", "M1EDCT,", "M1EDST,", "M1EDDT,",
            "M1EDER,", "M1EDSP,", /*"M1TPUR,",*/ "M1USER,", "M1PID,", "M1JOBN,", "M1UPMJ,", "M1TDAY,",
            "M1AN8,", /*"M1MCU,","M1DCTO,", "M1KCOO,",*/ "M1VR01)", "select ", "'2',", "LSCO,", "#{inboundPush.edoc},", "#{inboundPush.dcto},",
            "'852',", "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),", "'R',", "'N',", /*"'4',",*/
            "'WMS',", "'Interface',", "'Server',", "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "MCAN8,", /*"LSMCU,", "#{inboundPush.dcto},", "LSCO,",*/
            "#{inboundPush.doco}", "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}", "left join ${tableSchema}.F0006 on MCMCU=LSMCU"})

    @SelectKey(statement = "SELECT F47121_SEQ.NEXTVAL FROM DUAL", keyProperty = "inboundPush.edoc", resultType = BigDecimal.class, before = true)
    int insertF47121(@Param("inboundPush") InboundPush inboundPush);

    // @InsertProvider(type = SqlProvider.class, method = "insertF47122")
    @Insert({"insert into ${tableSchema}.F47122 (", "MJEDTY,", "MJEKCO,", "MJEDOC,", "MJEDCT,", "MJEDST,", "MJEDER,",
            "MJEDSP,", /*"MJLSTS,",*/ "MJKCOO,", "MJDOCO,", "MJDCTO,", /*"MJSFXO,",*/ "MJMCU,", "MJLOTN", "MJUSER,", "MJPID,", "MJJOBN,",
            "MJUPMJ,", "MJTDAY,", "MJEDLN,", "MJLNID,", "MJLITM,", "MJTRQT,", "MJTRDJ)", "select", "'2',", "LSCO,",
            "#{inboundPush.edoc},", "#{inboundPush.dcto},", "'852',", "'R',", "'N',", /*"'7',",*/ "LSCO,",
            "#{inboundPush.doco},", "#{inboundPush.dcto},", /*"'000',",*/ "LSMCU,", "#{inboundPushDetail.lotn,jdbcType=NCHAR}", "'WMS',", "'Interface',", "'Server',",
            "(select TO_CHAR(sysdate, 'YYYYDDD') - 1900000 from dual),",
            "(select TO_CHAR(sysdate, 'HH24MISS') from dual),", "#{inboundPushDetail.lnid},",
            "#{inboundPushDetail.lnid},", "#{inboundPushDetail.litm,jdbcType=NCHAR},",
            "#{inboundPushDetail.urec,jdbcType=NUMERIC}*10000,", "#{inboundPushDetail.addjj,jdbcType=NUMERIC}",
            "from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{inboundPush.wmsco}",
            "left join ${tableSchema}.FE8WMS21 on TRIM(LSE8WLZXID)=#{inboundPush.wmsmcu}",})
    @SelectKey(statement = "select daily_sequence() from dual", keyProperty = "inboundPushDetail.lotn", resultType = String.class, before = true)
    int insertF47122(@Param("inboundPush") InboundPush inboundPush,
                     @Param("inboundPushDetail") InboundPushDetail inboundPushDetail);
}