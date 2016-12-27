package com.el.cmic.callmdm.mapper;

import com.el.cmic.callmdm.domain.RqM001InputMfr;
import com.el.cmic.common.domain.MdmFuncType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * 生产厂家查询mapper
 * Created by Vincent on 2016/10/13.
 */
public interface MftMapper {

    final class SqlProvider extends SQL {

        public String mfrQry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("funcType") String funcType) {
            if (funcType.equals(MdmFuncType.FUNC_TYPE_ADD)) {
                return mfrAddQry(schema, ctlSchema);
            } else {
                return mfrModQry(schema, ctlSchema);
            }
        }

        private String mfrAddQry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema) {
            schema = schema + ".";
            ctlSchema = ctlSchema + ".";
            SELECT("ABALPH AS mfname");
            SELECT("KSAN8 AS an8");
            //SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='BR' and trim(drky)=trim(a.kse8cp)) as mfbrand");
            SELECT("KSE8SCXKZ AS mflicense");
            FROM(schema + "FE80101 A");
            INNER_JOIN(schema + "F0101 B ON A.KSAN8=B.ABAN8");
            WHERE("trim(A.KSFLAG)='P'");
            WHERE("trim(B.abat1)='MF' ");

            return toString();
        }

        private String mfrModQry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema) {
            schema = schema + ".";
            ctlSchema = ctlSchema + ".";
            SELECT("SCUKID AS ukid");
            SELECT("SCAN8 AS an8");
            SELECT("SCALPH AS mfname");
             SELECT("Scalky AS mfcd");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='19' and trim(drky)=trim(a.sce8cp )) as mfbrand");
            SELECT("SCE8SCXKZ AS mflicense");
            FROM(schema + "FE841005 A");
            WHERE("trim(A.SCFLAG)='P'");
            return toString();
        }
    }

    @SelectProvider(type = SqlProvider.class, method = "mfrQry")
    List<RqM001InputMfr> mfrQry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("funcType") String funcType);
}
