package com.el.cmic.mapper.ck;

import com.el.cmic.common.BillType;
import com.el.cmic.domain.ck.CkOrder;
import com.el.cmic.domain.ck.CkOrderDtl;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Vincent on 2016/10/24.
 */
public interface CkMapper {
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
            FROM("VE8CK002");
            WHERE("doco=#{doco}");
            WHERE("dcto=#{dcto}");
            WHERE("co=#{co}");
            return toString();
        }

        public String updateCk(@Param("ckOrderDtl") CkOrderDtl ckOrderDtl) {
            if (ckOrderDtl.getFlag().equals(BillType.FLAG_SO)) {
                UPDATE("F4211");
                SET("SDNXTR=560");
                SET("SDLTTR=535");
                WHERE("SDKCOO=#{ckOrderDtl.co}");
                WHERE("SDDOCO=#{ckOrderDtl.doco}");
                WHERE("SDDCTO=#{ckOrderDtl.dcto}");
                WHERE("SDLNID=#{ckOrderDtl.lnid}");
            } else if (ckOrderDtl.getFlag().equals(BillType.FLAG_OP)) {
                UPDATE("F4311");
                SET("PDNXTR=400");
                SET("PDLTTR=390");
                WHERE("PDKCOO=#{ckOrderDtl.co}");
                WHERE("PDDOCO=#{ckOrderDtl.doco}");
                WHERE("PDDCTO=#{ckOrderDtl.dcto}");
                WHERE("PDLNID=#{ckOrderDtl.lnid}");
            } else {
                UPDATE("FE8WMS03");
                SET("BSEV01='Y'");
                WHERE("BSUKID=#{ckOrderDtl.ukid}");
            }
            return toString();
        }

        public String selectAll(@Param("co")String co) {
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
            FROM("VE8CK001");
            WHERE("CO=#{co}");
            return toString();
        }
    }

    @SelectProvider(type = SqlProvider.class, method = "selectCkOrderDtlByDoco")
    List<CkOrderDtl> selectCkOrderDtlByDoco(@Param("doco") BigDecimal doco, @Param("dcto") String dcto, @Param("co") String co);


    @SelectProvider(type = SqlProvider.class, method = "selectAll")
    List<CkOrder> selectAll(@Param("co")String co);

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
