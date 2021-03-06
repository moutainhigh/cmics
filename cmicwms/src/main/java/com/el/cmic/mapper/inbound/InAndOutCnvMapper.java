package com.el.cmic.mapper.inbound;

import com.el.cmic.domain.inbound.F41002Cnv1;
import com.el.cmic.domain.inbound.InboundPush;
import com.el.cmic.domain.inbound.InboundPushDetail;
import com.el.cmic.domain.inbound.InboundPushSerial;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;

/**
 * Created by Vincent on 2016/12/21.
 */
public interface InAndOutCnvMapper {
    final String UPMJ = "(SELECT TO_CHAR(sysdate, 'YYYYDDD') - 1900000 JULIAN  FROM DUAL)";
    final String TDAY = "(SELECT TO_CHAR(sysdate, 'HH24MISS') JULIAN  FROM DUAL)";

    @Select("select count(1) ct" +
            "  from ${tableSchema}.f4311" +
            " where pdUOM <> pdUOM1" +
            "   and Pdkcoo =(SELECT LSCO FROM ${tableSchema}.FE8WMS20 WHERE TRIM(LSE8HZBM)=#{wmsco} and TRIM(LSE8WLZXID)=#{wmsmcu})" +
            "   and Pddoco =#{doco}" +
            "   and PDDCTO =#{dcto}" +
            "   AND PDLNID =#{lnid}")
    @Results({@Result(column = "ct", property = "ct", jdbcType = JdbcType.INTEGER)})
    public F41002Cnv1 checkF4311UomAndUom1(@Param("wmsco") String wmsco, @Param("wmsmcu") String wmsmcu, @Param("doco") String doco,
                                           @Param("dcto") String dcto, @Param("lnid") String lnid);

    @Select("SELECT Umcnv1 / 10000000 CNV1" +
            "  FROM ${tableSchema}.F41002" +
            " INNER JOIN ${tableSchema}.f4311" +
            "    ON Pduom = UMUM" +
            "   and Pditm = Umitm" +
            //"   and Pdmcu = Ummcu" +
            "   and PDUOM1 = UMRUM" +
            " WHERE Pdkcoo =(SELECT LSCO FROM ${tableSchema}.FE8WMS20 WHERE TRIM(LSE8HZBM)=#{wmsco} and TRIM(LSE8WLZXID)=#{wmsmcu})" +
            "   and Pddoco =#{doco}" +
            "   and PDDCTO =#{dcto}" +
            "   AND PDLNID =#{lnid,jdbcType = DECIMAL}" +
            "   and pdUOM <> pdUOM1")
    @Results({@Result(column = "CNV1", property = "cnv1", jdbcType = JdbcType.DECIMAL)})
    F41002Cnv1 selectCnv1ByF4311(@Param("wmsco") String wmsco, @Param("wmsmcu") String wmsmcu, @Param("doco") String doco,
                                 @Param("dcto") String dcto, @Param("lnid") BigDecimal lnid);

    @Select("select count(1) CT" +
            "  from ${tableSchema}.F4211" +
            " where sdUOM <> sdUOM1" +
            "   and sdkcoo =(SELECT LSCO FROM ${tableSchema}.FE8WMS20 WHERE TRIM(LSE8HZBM)=#{wmsco} and TRIM(LSE8WLZXID)=#{wmsmcu})" +
            "   and sddoco =#{doco}" +
            "   and sDDCTO =#{dcto}" +
            "   AND sDLNID =#{lnid,jdbcType = DECIMAL}")
    @Results({@Result(column = "ct", property = "ct", jdbcType = JdbcType.INTEGER)})
    F41002Cnv1 checkF4211UomAndUom1(@Param("wmsco") String wmsco, @Param("wmsmcu") String wmsmcu, @Param("doco") String doco,
                                    @Param("dcto") String dcto, @Param("lnid") BigDecimal lnid);


    @Select("SELECT Umcnv1 / 10000000 CNV1" +
            "  FROM ${tableSchema}.F41002" +
            " INNER JOIN ${tableSchema}.f4211" +
            "    ON sduom = UMUM" +
            "   and sditm = Umitm" +
            // "   and sdmcu = Ummcu" +
            "   and sDUOM1 = UMRUM" +
            " WHERE sdkcoo =(SELECT LSCO FROM ${tableSchema}.FE8WMS20 WHERE TRIM(LSE8HZBM)=#{wmsco} and TRIM(LSE8WLZXID)=#{wmsmcu})" +
            "   and sddoco =#{doco}" +
            "   and sDDCTO =#{dcto}" +
            "   AND sDLNID =#{lnid,jdbcType = DECIMAL}" +
            " and sdUOM <> sdUOM1")
    @Results({@Result(column = "CNV1", property = "cnv1", jdbcType = JdbcType.DECIMAL)})
    F41002Cnv1 selectCnv1ByF4211(@Param("wmsco") String wmsco, @Param("wmsmcu") String wmsmcu, @Param("doco") String doco,
                                 @Param("dcto") String dcto, @Param("lnid") BigDecimal lnid);


    @Select("SELECT Umcnv1 / 10000000 CNV1" +
            "  FROM ${tableSchema}.F41002 a" +
            "   INNER JOIN ${tableSchema}.f4111 b" +
            "    ON Umum = iltrum" +
            "   and Umitm = ilitm" +
            "   INNER JOIN ${tableSchema}.F4101 c" +
            "   ON b.ilitm=c.IMITM AND b.Iltrum<>c.imuom1" +
            " WHERE b.Ilkco = (SELECT LSCO" +
            "                   FROM ${tableSchema}.FE8WMS20 " +
            "                  WHERE TRIM(LSE8HZBM) = #{wmsco} " +
            "                    and TRIM(LSE8WLZXID) = #{wmsmcu})" +
            "   and b.Ildoc = #{doco} " +
            "   and b.Ildct = #{dcto}" +
            "   AND b.Illnid = #{lnid, jdbcType = DECIMAL}" +
            "   and  c.IMUOM1=a.Umrum")
    @Results({@Result(column = "CNV1", property = "cnv1", jdbcType = JdbcType.DECIMAL)})
    F41002Cnv1 selectCnv1ByF4111(@Param("wmsco") String wmsco, @Param("wmsmcu") String wmsmcu, @Param("doco") String doco,
                                 @Param("dcto") String dcto, @Param("lnid") BigDecimal lnid);


    @Insert({"insert into ${tableSchema}.Fe8xlh99(LLPMUKID,LLMCU,LLLITM,LLLOTN,LLPTUT01,LLLOT1,LLLOT2,LLPUKID,LLUKID,",
            "LLKCOO,LLDCTO,LLDOCO,LLLNID,LLAA05,LLCA01,LLUPRC,LLUORG,",
            "LLPTUT02,LLUSER,LLPID,LLJOBN,LLUPMJ,LLTDAY,LLDL01,LLDL02,LLDL03,LLAB01,",
            "LLAB02,LLAB03,LLEV01,LLEV02,LLDL010,LLEV03,LLEV04,LLEV05,LLEV06,",
            "LLKCO,LLDCT,LLDOC,LLRLLN,LLIDATE,LLRDATE)",
            "SELECT", "#{pmukid,jdbcType=NUMERIC},", "LSMCU,", "#{litm,jdbcType=NCHAR},", "NVL(#{lotn,jdbcType=NCHAR},'-'),", "#{serial},", "nvl(#{lot1,jdbcType=NCHAR},' '),", "NVL(#{lot2,jdbcType=NCHAR},' '),", "0,", "0,",
            "LSCO,", "#{dcto},", "#{doco},", "#{lnid},", "#{type},", "#{ca01},", "#{pack,jdbcType=NUMERIC}*10000,", "#{ists,jdbcType=NUMERIC}*10000,",
            "' ',", "'WMS',", "'Interface',", "'Server',", UPMJ + ",", TDAY + ",", "#{rktype},", "'WMS',", "' ',", "0,",
            "0,", "0,", "#{ev01},", "' ',", "' ',", "' ',", "' ',", "' ',", "' ',",
            "' ',", "' ',", "0,", "0,", "SYSDATE,", "SYSDATE",
            " from dual", "left join ${tableSchema}.FE8WMS20 on TRIM(LSE8HZBM)=#{wmsco} and TRIM(LSE8WLZXID)=#{wmsmcu}"
    })
    @SelectKey(statement = "SELECT ${tableSchema}.FE8XLH99_SEQ.NEXTVAL FROM DUAL", keyProperty = "pmukid", resultType = BigDecimal.class, before = true)
    int insertFe8xlh99(@Param("litm")String litm,@Param("lotn")String lotn,@Param("serial")String serial,@Param("lot1")String lot1,@Param("lot2")String lot2,
                       @Param("dcto")String dcto,@Param("doco") String doco, @Param("lnid") int lnid,@Param("type")String type,@Param("ca01")int ca01,@Param("pack") int pack,@Param("ists") int ists,
                       @Param("rktype")String rktype,@Param("ev01")String ev01,@Param("wmsco") String wmsco,@Param("wmsmcu")String wmsmcu);

}
