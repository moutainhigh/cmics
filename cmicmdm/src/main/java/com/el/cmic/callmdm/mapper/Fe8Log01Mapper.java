package com.el.cmic.callmdm.mapper;

import com.el.cfg.domain.Fe8log01;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Vincent on 2016/10/9.
 */
@Repository(value = "fe8Log01Mapper")
public interface Fe8Log01Mapper {
    final class SqlProvider extends SQL {
        private static final String INSERT_SQL = "insert";

        public String insert(Fe8log01 fe8Log01) {
            INSERT_INTO("FE8Log01");
            if (fe8Log01.getLgukid() != null) {
                VALUES("lgukid", "#{lgukid}");
            }
            if (fe8Log01.getLgukidp() != null) {
                VALUES("lgukidp", "#{lgukidp}");
            }
            if (fe8Log01.getLglitm() != null) {
                VALUES("lglitm", "#{lglitm}");
            }
            if (fe8Log01.getLgdl01() != null) {
                VALUES("lgdl01", "#{lgdl01}");
            }
            if (fe8Log01.getLgdl02() != null) {
                VALUES("lgdl02", "#{lgdl02}");
            }
            if (fe8Log01.getLgdl03() != null) {
                VALUES("lgdl03", "#{lgdl03}");
            }
            if (fe8Log01.getLgdl04() != null) {
                VALUES("lgdl04", "#{lgdl04}");
            }
            if (fe8Log01.getLgdl05() != null) {
                VALUES("lgdl05", "#{lgdl05}");
            }

            if (fe8Log01.getLgdl010() != null) {
                VALUES("lgdl010", "#{lgdl010}");
            }
            if (fe8Log01.getLgvar1() != null) {
                VALUES("lgvar1", "#{lgvar1}");
            }
            if (fe8Log01.getLguser() != null) {
                VALUES("lguser", "#{lguser}");
            }
            if (fe8Log01.getLgpid() != null) {
                VALUES("lgpid", "#{lgpid}");
            }
            if (fe8Log01.getLgjobn() != null) {
                VALUES("lgjobn", "#{lgjobn}");
            }
            if (fe8Log01.getLgupmj() != null) {
                VALUES("lgupmj", "#{lgupmj}");
            }
            if (fe8Log01.getLgupmt() != null) {
                VALUES("lgupmt", "#{lgupmt}");
            }
            if (fe8Log01.getLgidate() != null) {
                VALUES("lgidate", "#{lgidate}");
            }
            if (fe8Log01.getLgdf01() != null) {
                VALUES("lgdf01", "#{lgdf01}");
            }
            if (fe8Log01.getLgrdate() != null) {
                VALUES("lgrdate", "#{lgrdate}");
            }
            if (fe8Log01.getLgdf02() != null) {
                VALUES("lgdf02", "#{lgdf02}");
            }
            if (fe8Log01.getLgstatus() != null) {
                VALUES("lgstatus", "#{lgstatus}");
            }
            if (fe8Log01.getLgflag() != null) {
                VALUES("lgflag", "#{lgflag}");
            }

            return toString();
        }
    }


    @InsertProvider(type = SqlProvider.class, method = SqlProvider.INSERT_SQL)
    //@Insert("INSERT INTO FE8Log01 (lgukid,lgdl01) VALUES(#{lgukid},#{lgdl01})")
    @SelectKey(statement = "SELECT FE8LOG01_SEQ.NEXTVAL FROM DUAL", keyProperty = "lgukid", resultType = BigDecimal.class, before = true)
        // @Options(useGeneratedKeys = true, keyProperty = "lgukid", keyColumn = "lgukid")
    int insert(Fe8log01 fe8log01);
}
