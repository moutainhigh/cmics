package com.el.cmic.mapper.ck;

import com.el.cmic.common.BillType;
import com.el.cmic.domain.ck.CkOrder;
import com.el.cmic.domain.ck.CkOrderDtl;
import com.el.utils.ReadPropertiesUtil;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Vincent on 2016/10/24.
 */
public interface CkMapper {
    //动态 获取  db.properties  文件属性值
    final String schema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");
    // final String ctlSchema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "ctlSchema");

    final class SqlProvider extends SQL {
        public String selectCkOrderDtlByDoco() {
            SELECT("CO");
            SELECT("DOCO");
            SELECT("DCTO");
            SELECT("LNID");
            SELECT("LITM");
            SELECT("UORG/10000 as UORG");
            SELECT("LOT1");
            SELECT("LOT2");
            SELECT("DSC1");
            SELECT("UPRC/10000 as UPRC");
            SELECT("AEXP/100 as AEXP");
            SELECT("FLAG");
            SELECT("UKID");
            SELECT("yfhDate");
            SELECT("invalidDate");
            SELECT("productDate");
            SELECT("lot2Date");
            SELECT("lot2InvalidDate");
            SELECT("kType");
            FROM(schema + ".VE8CK002");
            WHERE("doco=#{doco}");
            WHERE("dcto=#{dcto}");
            WHERE("co=#{co}");
            return toString();
        }

        public String updateCk(@Param("ckOrderDtl") CkOrderDtl ckOrderDtl) {
            if (ckOrderDtl.getFlag().equals(BillType.FLAG_SO)) {
                UPDATE(schema + ".F4211");
                SET("SDNXTR=560");
                SET("SDLTTR=535");
                WHERE("SDKCOO=#{ckOrderDtl.co}");
                WHERE("SDDOCO=#{ckOrderDtl.doco}");
                WHERE("SDDCTO=#{ckOrderDtl.dcto}");
                WHERE("SDLNID=#{ckOrderDtl.lnid}");
            } else if (ckOrderDtl.getFlag().equals(BillType.FLAG_OP)) {
                UPDATE(schema + ".F4311");
                SET("PDNXTR=400");
                SET("PDLTTR=390");
                WHERE("PDKCOO=#{ckOrderDtl.co}");
                WHERE("PDDOCO=#{ckOrderDtl.doco}");
                WHERE("PDDCTO=#{ckOrderDtl.dcto}");
                WHERE("PDLNID=#{ckOrderDtl.lnid}");
            } else {
                UPDATE(schema + ".FE8WMS03");
                SET("BSEV01='Y'");
                WHERE("BSUKID=#{ckOrderDtl.ukid}");
            }
            return toString();
        }

        public String selectAll(@Param("co") String co, @Param("mcu") String mcu) {
            SELECT("ORDERNO");
            SELECT("WMSMCU");
            SELECT("MCU");
            SELECT("DCTO");
            SELECT("CKTYPE");
            SELECT("WMSCO");
            SELECT("CO");
            SELECT("DOCO");
            SELECT("AN8");
            SELECT("ALPH");
            SELECT("VR01");
            SELECT("REMARK");
            SELECT("ADDRESS");
            SELECT("flag");
            SELECT("AT1");
            SELECT("(to_date(trunc(TRDJ/1000)  +1900||'-01-01','yyyy-MM-dd')+mod( TRDJ, 1000)-1) as trdjDate");
            SELECT("DEPTNAME");
            SELECT("transport");
            SELECT("contactMan");
            SELECT("phone");
            FROM(schema + ".VE8CK001");
            WHERE("trim(CO)=#{co}");
            WHERE("trim(MCU)=#{mcu}");
            return toString();
        }
    }

    @SelectProvider(type = SqlProvider.class, method = "selectCkOrderDtlByDoco")
    List<CkOrderDtl> selectCkOrderDtlByDoco(@Param("doco") BigDecimal doco, @Param("dcto") String dcto, @Param("co") String co);


    @SelectProvider(type = SqlProvider.class, method = "selectAll")
    @Results({@Result(column = "ORDERNO", property = "orderno", jdbcType = JdbcType.NCHAR),
            @Result(column = "WMSMCU", property = "wmsMcu", jdbcType = JdbcType.NCHAR),
            @Result(column = "MCU", property = "mcu", jdbcType = JdbcType.NCHAR),
            @Result(column = "DCTO", property = "dcto", jdbcType = JdbcType.NCHAR),
            @Result(column = "CKTYPE", property = "cktype", jdbcType = JdbcType.NCHAR),
            @Result(column = "WMSCO", property = "wmsCo", jdbcType = JdbcType.NCHAR),
            @Result(column = "CO", property = "co", jdbcType = JdbcType.NCHAR),
            @Result(column = "DOCO", property = "doco", jdbcType = JdbcType.NCHAR),
            @Result(column = "AN8", property = "an8", jdbcType = JdbcType.NCHAR),
            @Result(column = "ALPH", property = "alph", jdbcType = JdbcType.NCHAR),
            @Result(column = "VR01", property = "vr01", jdbcType = JdbcType.NCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.NCHAR),
            @Result(column = "ADDRESS", property = "address", jdbcType = JdbcType.NCHAR),
            @Result(column = "flag", property = "flag", jdbcType = JdbcType.NCHAR),
            @Result(column = "AT1", property = "at1", jdbcType = JdbcType.NCHAR),
            @Result(column = "trdjDate", property = "trdjDate", jdbcType = JdbcType.DATE),
            @Result(column = "DEPTNAME", property = "deptname", jdbcType = JdbcType.NCHAR),
            @Result(column = "transport", property = "transport", jdbcType = JdbcType.INTEGER),
            @Result(column = "contactMan", property = "contactMan", jdbcType = JdbcType.NCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.NCHAR)})
    List<CkOrder> selectAll(@Param("co") String co, @Param("mcu") String mcu);

    @UpdateProvider(type = SqlProvider.class, method = "updateCk")
    void updateCk(@Param("ckOrderDtl") CkOrderDtl ckOrderDtl);

    /*@Update({"<script>" ,
            "update F4211" ,
            "set SDNXTR=560,SDLTTR=530" ,
            "<foreach collection='ckDtlList' item='ckDtl'>" ,
            "where SDKCOO=#{ckDtl.co} and SDDOCO=#{ckDtl.doco} and SDDCTO=#{ckDtl.dcto} and SDLNID=#{ckDtl.lnid}" ,
            "</foreach>" ,
            "</script> "})
    int updateCk(@Param("ckDtlList") List<CkOrderDtl> ckOrderDtlList);*/


}
