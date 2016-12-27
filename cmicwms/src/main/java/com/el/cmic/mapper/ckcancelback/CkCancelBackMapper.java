package com.el.cmic.mapper.ckcancelback;

import com.el.cfg.domain.Fe8wms13;
import com.el.cmic.domain.ckcancelback.CkCancelBackOrder;
import com.el.cmic.domain.ckcancelback.CkCancelBackOrderDtl;
import com.el.utils.ReadPropertiesUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Vincent on 2016/10/29.
 */
public interface CkCancelBackMapper {
    final String schema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");
    //final String ctlSchema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "ctlSchema");
    final class SqlProvider extends SQL {


      public   String updateCancelBackStatus(@Param("ckCancelBackOrder") CkCancelBackOrder ckCancelBackOrder, @Param("ckCancelBackOrderDtl") CkCancelBackOrderDtl ckCancelBackOrderDtl, @Param("status") String status) {
            UPDATE(schema+".Fe8wms13");
            SET("Qcev01=#{status}");
            SET("QcSOCN=#{ckCancelBackOrderDtl.socn}");
            WHERE("QCDCTO=#{ckCancelBackOrder.dcto}");
            WHERE("(QCKCOO)=(select LSCO from "+schema+".FE8WMS20 where trim(LSE8WLZXID) = #{ckCancelBackOrder.wmsmcu} and TRIM(LSE8HZBM) = #{ckCancelBackOrder.wmskcoo})");
            WHERE("QCDOCO=#{ckCancelBackOrder.doco}");
            WHERE("QCLNID=#{ckCancelBackOrderDtl.lnid}");
            return toString();
        }
    }


    @UpdateProvider(type = SqlProvider.class, method = "updateCancelBackStatus")
    int updateCancelBackStatus(@Param("ckCancelBackOrder") CkCancelBackOrder ckCancelBackOrder,@Param("ckCancelBackOrderDtl") CkCancelBackOrderDtl ckCancelBackOrderDtl, @Param("status") String status);
}
