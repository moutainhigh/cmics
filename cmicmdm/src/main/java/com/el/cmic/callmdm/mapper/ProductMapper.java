package com.el.cmic.callmdm.mapper;

import com.el.cmic.callmdm.domain.*;
import com.el.cmic.common.domain.MdmDataType;
import com.el.cmic.common.domain.MdmFuncType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.exolab.castor.mapping.xml.Sql;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by Vincent on 2016/9/29.
 */
public interface ProductMapper {
    final class SqlProvider extends SQL {

        private final static String PRODUCT_E01_QRY = "productE01Qry";


        public String productE01Qry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType) {
            String strSchema = schema + ".";
            String strCtlSchema = ctlSchema + ".";
            if (funcType.equals(MdmFuncType.FUNC_TYPE_ADD)) {
                return productE01AddQry(strSchema, strCtlSchema, dataType);
            } else {
                return productE01ModQry(strSchema, strCtlSchema, dataType);
            }

        }

        public String productE01AddQry(String schema, String ctlSchema, @Param("dataType") String dataType) {

            SELECT("B.IMLITM as litm");
            //---------------------------------AITM不上传---------------------------------------------------------------
            //SELECT("B.imaitm as productcode");
            SELECT("'' as productcode");
            //-----------------------------------------------------------------------------------------------------------
            SELECT("a.spe8name as productname");
            SELECT("b.imDSC2 as producttype");
            // SELECT("a.Span8 as pk_mfname");
            SELECT("E.KSE8NAME as pk_mfname");
            SELECT("a.Sporig as pk_mfcountry");
            //SELECT("(select drdl01 from " + ctlSchema + " f0005 where drsy='E8' AND DRRT='17' and TRIM(drky)=TRIM(a.Sporig)) as pk_mfcountry");
            //SELECT("a.Spe8jx as form");
            SELECT("nvl((select drdl01 from " + ctlSchema + " f0005  where drsy='E8' AND DRRT='JX' and (TRIM(drky) = TRIM(A.Spe8jx) OR  (drky) = (A.Spe8jx))),'.') AS form");
            SELECT("b.Imdsc1 as sync");
            SELECT("a.Spe8pzwh as fileno");
            // SELECT("b.Imuom1 as pk_weight");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005D WHERE drsy='00' AND DRRT='UM' AND trim(DRKY)=trim(b.Imuom1)) as pk_weight");
            SELECT("(select c.kse8scxkz from " + schema + "FE80101 c where a.span8 = C.KSAN8 and rownum = 1) as licenseno");
            SELECT("F.Ivcitm as Hibcode");
            SELECT("G.Ivcitm as gmdncode");
            SELECT("H.IVCITM as gs1code");
            //SELECT("d.abac28 As pk_label");
           // SELECT("e.kse8cp As pk_label");
            SELECT("(select drdl01 from "+ctlSchema+"f0005 where drsy='E8' AND DRRT='BR' and TRIM(drky)=TRIM(e.kse8cp)) As pk_label ");
            // SELECT("b.Imsrp3 as pk_productclass");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='14' and trim(drky)=trim(A.SPE8CPDL)) as pk_productclass");
            // SELECT("b.Imsrp4 as pk_yltsfl");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='15' and trim(drky)=trim(a.SPE8TSFL)) as pk_yltsfl");
            SELECT("a.Spe8yyks AS pk_department");
            FROM(schema + "FE84101 a");
            INNER_JOIN(schema + "F4101 b on A.SPLITM = B.IMLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON A.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "FE80101 E ON A.SPAN8=E.KSAN8");
            LEFT_OUTER_JOIN(schema + "F4104 F ON A.SPLITM=F.IVLITM AND F.Ivxrt='HB'");
            LEFT_OUTER_JOIN(schema + "F4104 g ON A.SPLITM=g.IVLITM AND g.Ivxrt='GD'");
            LEFT_OUTER_JOIN(schema + "F4104 H ON A.SPLITM=H.IVLITM AND H.Ivxrt='GS'");
            WHERE("A.spflag='P'");
            WHERE("Trim(A.SPE8SPXZ)=#{dataType}");
            return toString();
        }

        public String productE01ModQry(String schema, String ctlSchema, @Param("dataType") String dataType) {

            SELECT("a.SQUKIDP as doco");
            SELECT("a.sqev01 as ev01");
            SELECT("a.sqlitm as litm");
            SELECT("a.sqkcoo as kcoo");

            SELECT("a.Sqaitm as productcode");

            //---------------------------------AITM---------------------------------------------------------------------
            //SELECT("B.E8SPTYM as productcode");
            //-----------------------------------------------------------------------------------------------------------


            SELECT("a.sqdsc2 as producttype");
            SELECT("a.sqe8name as productname");
            // SELECT("b.span8 as pk_mfname");
            SELECT("E.KSE8NAME as pk_mfname");
            SELECT("a.sqorig as pk_mfcountry");
           //SELECT("(select drdl01 from " + ctlSchema + " f0005  where drsy='E8' AND DRRT='17' and TRIM(drky)=TRIM(a.sqorig)) as pk_mfcountry");
            // SELECT("a.sqe8jx as form");
            SELECT("nvl((select drdl01 from " + ctlSchema + " f0005  where drsy='E8' AND DRRT='JX' and (TRIM(drky) = TRIM(A.sqe8jx) OR  (drky) = (A.sqe8jx))),'.') AS form");
            SELECT("a.sqdsc1 as sync");
            SELECT("a.sqe8pzwh as fileno");
            //SELECT("a.squom1 as pk_weight");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005D WHERE drsy='00' AND DRRT='UM' AND trim(DRKY)=trim(a.squom1)) as pk_weight");

            SELECT("a.sqdf01 as modcause");
            SELECT("a.sqe8scxkz  as licenseno");
            SELECT("F.Ivcitm as Hibcode");
            SELECT("G.Ivcitm as gmdncode");
            SELECT("H.IVCITM as gs1code");
           // SELECT("d.abac28 As pk_label");
            //SELECT("e.kse8cp As pk_label");
            SELECT("(select drdl01 from "+ctlSchema+"f0005 where drsy='E8' AND DRRT='BR' and TRIM(drky)=TRIM(e.kse8cp)) As pk_label ");
            //SELECT("a.sqsrp3 as pk_productclass");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='14' and trim(drky)=trim(a.sqE8CPDL)) as pk_productclass");
            // SELECT("a.sqsrp4 as pk_yltsfl");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='15' and trim(drky)=trim(a.sqE8TSFL)) as pk_yltsfl");
            SELECT("a.sqe8yyks AS pk_department");
            FROM(schema + "FE841001 a");
            LEFT_OUTER_JOIN(schema + "FE84101 b on A.SQLITM = B.SPLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON b.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "FE80101 E ON A.SQAN8=E.KSAN8");
            LEFT_OUTER_JOIN(schema + "F4104 F ON A.SQLITM=F.IVLITM AND F.Ivxrt='HB'");
            LEFT_OUTER_JOIN(schema + "F4104 g ON A.SQLITM=g.IVLITM AND g.Ivxrt='GD'");
            LEFT_OUTER_JOIN(schema + "F4104 H ON A.SQLITM=H.IVLITM AND H.Ivxrt='GS'");
            WHERE("A.sqflag='P'");
            WHERE("Trim(A.SqE8SPXZ)=#{dataType}");
            return toString();
        }

        private final static String PRODUCT_E02_QRY = "productE02Qry";

        public String productE02Qry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType) {
            String strSchema = schema + ".";
            String strCtlSchema = ctlSchema + ".";
            if (funcType.equals(MdmFuncType.FUNC_TYPE_ADD)) {
                return productE02AddQry(strSchema, strCtlSchema, dataType);
            } else {
                return productE02ModQry(strSchema, strCtlSchema, dataType);
            }

        }

        public String productE02AddQry(String schema, String ctlSchema, @Param("dataType") String dataType) {


            SELECT("b.IMLITM as litm");


            //---------------------------------AITM---------------------------------------------------------------------
            SELECT("'' as productcode");
            //-----------------------------------------------------------------------------------------------------------
            //SELECT("b.imaitm as productcode");




            SELECT("a.spe8name as productname");
            SELECT("b.imDSC2 as producttype");
            SELECT("E.KSE8NAME as mfname");
            SELECT("E.KSE8NAME as pk_mfname");
            SELECT("a.Sporig as pk_mfcountry");
            //SELECT("(select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='17' and TRIM(drky)=TRIM(a.Sporig)) as pk_mfcountry");
            //SELECT("a.Spe8jx as form");
            SELECT("nvl((select drdl01 from " + ctlSchema + " f0005  where drsy='E8' AND   DRRT='JX' and (TRIM(drky) = TRIM(A.Spe8jx) OR  (drky) = (A.Spe8jx))),'.') AS form");
            SELECT("b.Imdsc1 as sync");
            SELECT("a.Spe8pzwh as fileno");
            //SELECT("b.Imuom1 as pk_weight");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005D WHERE drsy='00' AND DRRT='UM' AND trim(DRKY)=trim(b.Imuom1)) as pk_weight");
            // SELECT(" A.SPE8ZDYL AS pk_zdypdl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='29' AND trim(DRKY)=trim(A.SPE8ZDYL)) as pk_zdypdl");
            //SELECT(" A.SPE8JHG AS pk_jhg");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='21' AND trim(DRKY)=trim(A.SPE8JHG)) as pk_jhg");
            // SELECT(" A.SPE8ZTW AS pk_ztw");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='32' and trim(drky)=trim(a.SPE8ZTW)) as pk_ztw");
            // SELECT(" A.SPE8GFG AS pk_fgjyw");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='33' and trim(drky)=trim(a.SPE8GFG)) as pk_fgjyw");
            //SELECT(" A.SPE8PTYP AS pk_ptyp");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='34' and trim(drky)=trim(a.SPE8PTYP)) as pk_ptyp");
            SELECT(" '' AS basecode");
            SELECT(" '' AS customscode");
            SELECT(" '' AS atccode");
            SELECT(" '' AS atcname");
            // SELECT(" A.SPE8ATCDL AS pk_atcdl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='30' AND trim(DRKY)=trim(A.SPE8ATCDL)) as pk_atcdl");
            // SELECT(" A.SPE8ATCXL AS pk_atcxl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='31' AND trim(DRKY)=trim(A.SPE8ATCXL)) as pk_atcxl");

            FROM(schema + "FE84101 a");
            INNER_JOIN(schema + "F4101 b on A.SPLITM = B.IMLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON A.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "FE80101 E ON A.SPAN8=E.KSAN8");
            WHERE("A.spflag='P'");
            WHERE("Trim(A.SPE8SPXZ)=#{dataType}");
            return toString();
        }

        public String productE02ModQry(String schema, String ctlSchema, @Param("dataType") String dataType) {

            SELECT("a.SQUKIDP as doco");
            SELECT("a.sqev01 as ev01");
            SELECT("a.SQLITM as litm");

            SELECT("a.sqkcoo as kcoo");

            SELECT("a.sqaitm as productcode");
            //---------------------------------AITM---------------------------------------------------------------------
            //SELECT("B.E8SPTYM as productcode");
            //-----------------------------------------------------------------------------------------------------------


            SELECT("a.sqe8name as productname");
            SELECT("a.sqdsc2 as producttype");
            SELECT("E.KSE8NAME as mfname");
            SELECT("E.KSE8NAME as pk_mfname");
            SELECT("a.sqorig as pk_mfcountry");
           // SELECT("(select drdl01 from crpctl.f0005 a where a.drsy='E8' AND   A.DRRT='17' and TRIM(a.drky)=TRIM(a.sqorig)) as pk_mfcountry");
            //SELECT("a.sqe8jx as form");
            SELECT("nvl((select drdl01 from " + ctlSchema + " f0005  where drsy='E8' AND   DRRT='JX' and (TRIM(drky) = TRIM(A.sqe8jx) OR  (drky) = (A.sqe8jx))),'.') AS form");
            SELECT("a.sqdsc1 as sync");
            SELECT("a.sqe8pzwh as fileno");
            // SELECT("a.squom1 as pk_weight");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005D WHERE drsy='00' AND DRRT='UM' AND trim(DRKY)=trim(a.squom1)) as pk_weight");
            // SELECT(" a.sqe8zdyl AS pk_zdypdl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='29' AND trim(DRKY)=trim(A.sqe8zdyl)) as pk_zdypdl");
            //SELECT(" a.sqe8jhg AS pk_jhg");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='21' AND trim(DRKY)=trim(A.sqe8jhg)) as pk_jhg");
            //SELECT(" a.sqe8ztw AS pk_ztw");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='32' and trim(drky)=trim(a.sqe8ztw)) as pk_ztw");
            //SELECT(" a.sqe8gfg AS pk_fgjyw");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='33' and trim(drky)=trim(a.sqe8gfg)) as pk_fgjyw");
            //SELECT(" a.sqe8ptyp AS pk_ptyp");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='34' and trim(drky)=trim(a.sqe8ptyp)) as pk_ptyp");
            SELECT(" '' AS basecode");
            SELECT(" '' AS customscode");
            SELECT(" '' AS atccode");
            SELECT(" '' AS atcname");
            //SELECT(" a.sqe8atcdl AS pk_atcdl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='30' AND trim(DRKY)=trim(A.sqe8atcdl)) as pk_atcdl");
            //SELECT(" a.sqe8atcxl AS pk_atcxl");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='31' AND trim(DRKY)=trim(A.sqe8atcxl)) as pk_atcxl");

            SELECT("a.sqdf01 as modcause");

            FROM(schema + "FE841001 a");
            INNER_JOIN(schema + "FE84101 b on A.SQLITM = B.SPLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON b.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "FE80101 E ON A.SQAN8=E.KSAN8");
            WHERE("a.sqflag='P'");
            WHERE("Trim(a.SqE8SPXZ)=#{dataType}");
            return toString();
        }

        private final static String PRODUCT_E03_QRY = "productE03Qry";

        public String productE03Qry(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType) {
            String strSchema = schema + ".";
            String strCtlSchema = ctlSchema + ".";
            if (funcType.equals(MdmFuncType.FUNC_TYPE_ADD)) {
                return productE03AddQry(strSchema, strCtlSchema, dataType);
            } else {
                return productE03ModQry(strSchema, strCtlSchema, dataType);
            }
        }

        public String productE03AddQry(String schema, String strCtlSchema, @Param("dataType") String dataType) {
            SELECT("b.IMLITM as litm");



            //SELECT("b.imaitm as productcode");
            //---------------------------------AITM---------------------------------------------------------------------
            SELECT("'' as productcode");
            //-----------------------------------------------------------------------------------------------------------


            SELECT("a.spe8name as productname");
            SELECT("b.imDSC2 as producttype");
            //SELECT("a.Span8 as pk_mfname");
            SELECT("F.KSE8NAME as mfname");
            SELECT("a.Sporig as pk_mfcountry");
            //SELECT("(select drdl01 from crpctl.f0005 a where a.drsy='E8' AND   A.DRRT='17' and TRIM(a.drky)=TRIM(a.Sporig)) as pk_mfcountry");
            SELECT("b.Imdsc1 as sync");
            // SELECT("a.Spe8jx as form");
            //SELECT(" A.SPE8JHG AS pk_jhg");
            SELECT("(SELECT DRDL01 FROM " + strCtlSchema + "f0005 WHERE drsy='E8' AND DRRT='21' AND trim(DRKY)=trim(A.SPE8JHG)) as pk_jhg");
            //SELECT(" A.SPE8ZTW AS pk_ztw");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='32' and trim(drky)=trim(a.SPE8ZTW)) as pk_ztw");
            SELECT(" E.IVCITM AS interbarcode");
            // SELECT(" B.IMSRP3 AS pk_productclass");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='14' and trim(drky)=trim(A.SPE8CPDL)) as pk_productclass");
            //SELECT(" B.IMSRP4 AS pk_yltsfl");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='15' and trim(drky)=trim(A.SPE8TSFL )) as pk_yltsfl");
            FROM(schema + "FE84101 a");
            INNER_JOIN(schema + "F4101 b on A.SPLITM = B.IMLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON A.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "F4104 E ON E.IVLITM=B.IMLITM AND TRIM(IVXRT)='IC'");
            LEFT_OUTER_JOIN(schema + "FE80101 F ON A.SPAN8=F.KSAN8");
            WHERE("A.spflag='P'");
            WHERE("Trim(A.SPE8SPXZ)=#{dataType}");
            return toString();
        }

        public String productE03ModQry(String schema, String ctlSchema, @Param("dataType") String dataType) {

            SELECT("a.SQUKIDP as doco");
            SELECT("a.sqev01 as ev01");
            SELECT("a.sqlitm as litm");
            SELECT("a.sqkcoo as kcoo");

            //---------------------------------AITM---------------------------------------------------------------------
            //SELECT("B.E8SPTYM as productcode");
            //-----------------------------------------------------------------------------------------------------------
            SELECT("a.sqaitm as productcode");

            SELECT("a.sqe8name as productname");
            SELECT("a.sqdsc2 as producttype");
            //SELECT("b.span8 as pk_mfname");
            SELECT("F.KSE8NAME as mfname");
            SELECT("a.sqorig as pk_mfcountry");
            //SELECT("(select drdl01 from "+ctlSchema+"f0005 a where a.drsy='E8' AND   A.DRRT='17' and TRIM(a.drky)=TRIM(a.sqorig)) as pk_mfcountry");
            SELECT("a.sqdsc1 as sync");
           // SELECT(" a.sqe8jhg AS pk_jhg");
            SELECT("(SELECT DRDL01 FROM " + ctlSchema + "f0005 WHERE drsy='E8' AND DRRT='21' AND trim(DRKY)=trim(A.sqe8jhg)) as pk_jhg");
            //SELECT(" a.sqe8ztw AS pk_ztw");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='32' and trim(drky)=trim(a.sqe8ztw)) as pk_ztw");
            SELECT(" E.IVCITM AS interbarcode");
            // SELECT(" a.sqsrp3 AS pk_productclass");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='14' and trim(drky)=trim(a.SQE8CPDL)) as pk_productclass");
            //SELECT(" a.sqsrp4 AS pk_yltsfl");
            SELECT(" (select drdl01 from " + ctlSchema + "f0005  where drsy='E8' AND DRRT='15' and trim(drky)=trim(a.sqE8TSFL )) as pk_yltsfl");

            SELECT("a.sqdf01 as modcause");

            FROM(schema + "FE841001 a");
            INNER_JOIN(schema + "FE84101 b on A.SQLITM = B.SPLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON b.SPAN8 = d.aban8");
            LEFT_OUTER_JOIN(schema + "F4104 E ON E.IVLITM=B.SPLITM AND TRIM(IVXRT)='IC'");
            LEFT_OUTER_JOIN(schema + "FE80101 F ON A.SqAN8=F.KSAN8");
            WHERE("A.sqflag='P'");
            WHERE("Trim(A.SqE8SPXZ)=#{dataType}");
            return toString();
        }

        private final static String PRODUCT_E04_QRY = "productE04Qry";


        public String productE04Qry(@Param("schema") String schema, @Param("dataType") String dataType, @Param("funcType") String funcType) {
            String strSchema = schema + ".";

            if (funcType.equals(MdmFuncType.FUNC_TYPE_ADD)) {
                return productE04AddQry(strSchema, dataType);
            } else {
                return productE04ModQry(strSchema, dataType);
            }
        }

        public String productE04AddQry(String schema, @Param("dataType") String dataType) {
            SELECT("b.IMLITM as litm");

            //---------------------------------AITM---------------------------------------------------------------------
            SELECT("'' as productcode");
            //-----------------------------------------------------------------------------------------------------------
            //SELECT("b.imaitm as productcode");


            SELECT("a.spe8name as servicename");
            FROM(schema + "FE84101 a");
            INNER_JOIN(schema + "F4101 b on A.SPLITM = B.IMLITM");
            LEFT_OUTER_JOIN(schema + "F0101 D ON A.SPAN8 = d.aban8");
            WHERE("A.spflag='P'");
            WHERE("Trim(A.SPE8SPXZ)=#{dataType}");
            return toString();
        }

        public String productE04ModQry(String schema, @Param("dataType") String dataType) {
            SELECT("a.SQUKIDP as doco");
            SELECT("a.sqev01 as ev01");
            SELECT("a.sqLITM as litm");


            SELECT("a.sqaitm as productcode");
            //---------------------------------AITM---------------------------------------------------------------------
            //SELECT("B.E8SPTYM as productcode");
            //-----------------------------------------------------------------------------------------------------------

            SELECT("a.sqe8name as servicename");

            SELECT("a.sqdf01 as modcause");

            FROM(schema + "FE841001 a");
          /*  INNER_JOIN(strSchema + "F4101 b on A.SPLITM = B.IMLITM");
            LEFT_OUTER_JOIN(strSchema + "F0101 D ON A.SPAN8 = d.aban8");*/
            WHERE("A.sqflag='P'");
            WHERE("Trim(A.SqE8SPXZ)=#{dataType}");
            return toString();
        }

        private final static String PRODUCT_QRY_B_INFO = "productQryBInfo";

        public String productQryBInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("litm") String litm) {
            String strSchema = schema + ".";
            String strCtlSchema = ctlSchema + ".";
            //SELECT(" A.ZZE8ZZLXA AS pk_licensetype");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='28' and trim(drky)=trim(a.ZZE8ZZLXA )) as pk_licensetype");
            SELECT("A.ZZE8ZZBM AS licenseno");
           // SELECT("A.ZZEXDJ AS todate");
            //SELECT("A.ZZEXDJ AS todate");
            SELECT("TO_CHAR(to_date(trunc(ZZEXDJ/1000)  +1900||'-01-01','yyyy-MM-dd')+mod( ZZEXDJ, 1000)-1,'yyyy-MM-dd') AS todate");
            // SELECT("B.SPE8FXDJ AS fxdj");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='18' and trim(drky)=trim(b.SPE8FXDJ )) as fxdj");
            SELECT("'N' AS iscqyx");
            // SELECT("B.SPE8CCTJ AS cctj");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='19' and trim(drky)=trim(b.SPE8CCTJ )) as cctj");
            SELECT("B.SPE8QTCC AS qtcctj");
            SELECT("B.SPE8CPFL AS pk_productclass");
            //SELECT("B.SPE8JGG AS pk_jgg");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='35' and trim(drky)=trim(b.SPE8JGG )) as pk_jgg");

            SELECT("A.ZZCO as co");

            FROM(strSchema + "FE84101Z A");
            INNER_JOIN(strSchema + "FE84101 B  ON A.ZZLITM = B.SPLITM");
            WHERE("TRIM(A.ZZLITM) =#{litm}");
            WHERE("A.zzflag='P'");
            return toString();
        }

        private final static String PRODUCT_MOD_QRY_B_INFO = "productModQryBInfo";

        public String productModQryBInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("ukidp") String ukidp, @Param("co")String co) {
            String strSchema = schema + ".";
            String strCtlSchema = ctlSchema + ".";
            //SELECT(" A.ZZE8ZZLXA AS pk_licensetype");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='28' and trim(drky)=trim(a.ZZE8ZZLXA )) as pk_licensetype");
            SELECT("A.ZZE8ZZBM AS licenseno");
            //SELECT("A.ZZEXDJ AS todate");
            SELECT("TO_CHAR(to_date(trunc(ZZEXDJ/1000)  +1900||'-01-01','yyyy-MM-dd')+mod( ZZEXDJ, 1000)-1,'yyyy-MM-dd') AS todate");
            // SELECT("B.SPE8FXDJ AS fxdj");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='18' and trim(drky)=trim(b.SqE8FXDJ )) as fxdj");
            SELECT("'N' AS iscqyx");
            // SELECT("B.SPE8CCTJ AS cctj");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='19' and trim(drky)=trim(b.SQE8CCTJ )) as cctj");
            SELECT("B.SqE8QTCC AS qtcctj");
            SELECT("B.SqE8CPFL AS pk_productclass");
            //SELECT("B.SPE8JGG AS pk_jgg");
            SELECT(" (select drdl01 from " + strCtlSchema + "f0005  where drsy='E8' AND DRRT='35' and trim(drky)=trim(b.SQE8JGG )) as pk_jgg");

            SELECT("a.zzco as co");

            FROM(strSchema + "FE841002 A");
            INNER_JOIN(strSchema + "FE841001 B  ON A.ZZUKIDP = B.SQUKIDP");
            WHERE("TRIM(A.ZZUKIDP) =#{ukidp}");

                WHERE("Trim(a.zzco) = #{co}");

            return toString();
        }

        public String productAddQryAInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema,@Param("gdtxky")String gdtxky){
            SELECT("GDGTITNM as filename2");
            SELECT("GDGTFILENM as filepath");
            FROM(schema+".F00165");
            WHERE("Trim(GDGTMOTYPE) = 5");
            WHERE("Trim(GDOBNM) = 'GTE842001'");
            WHERE("Trim(GDTXKY) = #{gdtxky}");
            return toString();
        }

    }


    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_E01_QRY)
    List<RqE001InputProductE01> productE01QryInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType);

    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_E02_QRY)
    List<RqE001InputProductE02> productE02QryInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType);

    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_E03_QRY)
    List<RqE001InputProductE03> productE03QryInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("dataType") String dataType, @Param("funcType") String funcType);

    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_E04_QRY)
    List<RqE001InputProductE04> productE04QryInfo(@Param("schema") String schema, @Param("dataType") String dataType, @Param("funcType") String funcType);

    /**
     * 根据商品编码查找商品注册证等信息
     *
     * @param litm 商品编码
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_QRY_B_INFO)
    List<RqE001InputBE01> productQryBInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("litm") String litm);

    @SelectProvider(type = SqlProvider.class, method = SqlProvider.PRODUCT_MOD_QRY_B_INFO)
    List<RqE001InputBE01> productModQryBInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema, @Param("ukidp") String ukidp,@Param("co") String co);

    @SelectProvider(type = SqlProvider.class,method = "productAddQryAInfo")
    List<RqE001InputAttachment> productAddQryAInfo(@Param("schema") String schema, @Param("ctlSchema") String ctlSchema,@Param("gdtxky")String gdtxky);
}
