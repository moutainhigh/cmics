package com.el.cmic.mapper.record;

import com.el.utils.ReadPropertiesUtil;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.jdbc.SQL;

import com.el.cmic.domain.record.InputCheckDetail;

/**
 * 入库验收记录推送
 *
 * @author zhanhao
 */
public interface InputCheckMapper {
    String schema = ReadPropertiesUtil.getPropertyValue("/config/db.properties", "schema");

    /**
     * 入库验收记录推送  insert
     *
     * @param inputCheckDetail
     * @return
     */
    @InsertProvider(type = InputCheckMapper.sqlProvider.class, method = InputCheckMapper.sqlProvider.insertInputCheck)
    public Integer insertInputCheck(InputCheckDetail inputCheckDetail);


    class sqlProvider extends SQL {

        public static final String insertInputCheck = "insertInputCheck";

        public String insertInputCheck(InputCheckDetail inputCheckDetail) {
            INSERT_INTO(schema + ".FE8WMS06");
            //VALUES("rkmcu","#{rkmcu,jdbcType=NCHAR}");
            //VALUES("rkco","#{rkco,jdbcType=NCHAR}");
            VALUES("rkukid", schema + ".FE8WMS06_SEQ.NEXTVAL");
            VALUES("rkmcu", "(select LSMCU from " + schema + ".FE8WMS20 where trim(LSE8WLZXID) = #{rkmcu,jdbcType=NCHAR} and trim(LSE8HZBM) = #{rkco,jdbcType=NCHAR})");
            VALUES("rkco", "(select LSCO from " + schema + ".FE8WMS20 where trim(LSE8WLZXID) = #{rkmcu,jdbcType=NCHAR} and trim(LSE8HZBM) = #{rkco,jdbcType=NCHAR})");
            VALUES("rkdoco", "#{rkdoco,jdbcType=DECIMAL}");
            VALUES("rkptut01", "#{rkptut01,jdbcType=NCHAR}");
            VALUES("rkptut02", "#{rkptut02,jdbcType=NCHAR}");
            VALUES("rke8tym", "#{rke8tym,jdbcType=NCHAR}");
            VALUES("rkptut03", "#{rkptut03,jdbcType=NCHAR}");
            VALUES("rke8name", "#{rke8name,jdbcType=NCHAR}");
            VALUES("rkffds3", "#{rkffds3,jdbcType=NCHAR}");
            VALUES("rkffds4", "#{rkffds4,jdbcType=NCHAR}");
            VALUES("rkidate", "#{rkidate,jdbcType=DATE}");
            VALUES("rkrdate", "#{rkrdate,jdbcType=DATE}");
            VALUES("rkuprc", "#{rkuprc,jdbcType=DECIMAL}");
            VALUES("rkprrc", "#{rkprrc,jdbcType=DECIMAL}");
            VALUES("rkfrrc", "#{rkfrrc,jdbcType=DECIMAL}");
            VALUES("rkfmtx", "#{rkfmtx,jdbcType=NCHAR}");
            VALUES("rkfndn", "#{rkfndn,jdbcType=NCHAR}");
            VALUES("rkfstr1", "#{rkfstr1,jdbcType=NCHAR}");
            VALUES("rkfstr2", "#{rkfstr2,jdbcType=NCHAR}");
            VALUES("rkfstr3", "#{rkfstr3,jdbcType=NCHAR}");
            VALUES("rkdtee", "#{rkdtee,jdbcType=DATE}");
            VALUES("rkdtetp", "#{rkdtetp,jdbcType=DATE}");
            VALUES("rkdl01", "#{rkdl01,jdbcType=NCHAR}");
            VALUES("rkads1", "#{rkads1,jdbcType=NCHAR}");
            VALUES("rkfstr4", "#{rkfstr4,jdbcType=NCHAR}");
            VALUES("rke8jx", "#{rke8jx,jdbcType=NCHAR}");
            VALUES("rkdl011", "#{rkdl011,jdbcType=NCHAR}");
            VALUES("rkconstr1", "#{rkconstr1,jdbcType=NCHAR}");
            VALUES("rkahl1", "#{rkahl1,jdbcType=NCHAR}");
            VALUES("rkahl2", "#{rkahl2,jdbcType=NCHAR}");
            VALUES("rkconstr2", "#{rkconstr2,jdbcType=NCHAR}");
            VALUES("rkconstr3", "#{rkconstr3,jdbcType=NCHAR}");
            VALUES("rkfstr5", "#{rkfstr5,jdbcType=NCHAR}");
            VALUES("rkfstr6", "#{rkfstr6,jdbcType=NCHAR}");
            VALUES("rkdcto", "#{rkdcto,jdbcType=NCHAR}");
            VALUES("rkE8MJRQ", "(SELECT TO_CHAR(nvl(#{mjrq,jdbcType=DATE},to_date('1900-01-01','yyyy-MM-dd')), 'yyyy') * 1000 +TO_CHAR(nvl(#{mjrq,jdbcType=DATE},to_date('1900-01-01','yyyy-MM-dd')), 'ddd ') - 1900000 JULIAN FROM DUAL)");
            VALUES("rkE8MJSXQ", "(SELECT TO_CHAR(nvl(#{mjsxq,jdbcType=DATE},to_date('1900-01-01','yyyy-MM-dd')), 'yyyy') * 1000 +TO_CHAR(nvl(#{mjsxq,jdbcType=DATE},to_date('1900-01-01','yyyy-MM-dd')), 'ddd ') - 1900000 JULIAN FROM DUAL)");
            VALUES("rklnid", "#{rklnid,jdbcType=NUMERIC}");
            return toString();
        }
    }

}
