package com.el.cmic.ws.mapper;

import com.el.cfg.domain.Fe80101z;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

/**
 * Created by king_ on 2016/10/11.
 */
@Repository(value = "fe80101ZUpdateByE8ZZBMMapper")
public interface FE80101ZUpdateByE8ZZBMMapper {

    final class SqlProvider extends SQL{
        public String updateByE8ZZBM (@Param("schema")String schema,@Param("record") Fe80101z record, @Param("datatype") String datatype,@Param("dj") String dj){


            UPDATE(schema+".FE80101Z");
            if(datatype.equals("C01")){

                SET("ZZE8JYFW = #{record.zze8jyfw}");
                if(record.getZze8jyfw2()!=null){
                    SET("ZZE8JYFW2 = #{record.zze8jyfw2}");
                }
                if(record.getZze8jyfw3()!=null){
                    SET("ZZE8JYFW3 = #{record.zze8jyfw3}");
                }

            }
            if(record.getZzfil2()!=null){
                SET("ZZFIL2 = #{record.zzfil2}");
            }
            WHERE("Trim(ZZEXDJ) = (SELECT TO_CHAR(TO_DATE(#{dj}, 'yyyy- mm-dd'), 'yyyy') * 1000 +TO_CHAR(TO_DATE(#{dj}, 'yyyy-mm- dd'), 'ddd ') - 1900000 FROM DUAL)");

            WHERE("Trim(ZZE8ZZLXA) = #{record.zze8zzlxa}");
            WHERE("Trim(ZZE8ZZBM) = #{record.zze8zzbm}");
            WHERE("Trim(ZZAN8) = #{record.zzan8}");


            return toString();
        }
        public String insertSelective(@Param("schema")String schema,@Param("record") Fe80101z record,@Param("dj") String dj){


            INSERT_INTO(schema+".FE80101Z");

            if (record.getZzan8() != null) {
                VALUES("ZZAN8", "#{record.zzan8}");
            }

            if (record.getZze8zzlxa() != null) {
                VALUES("ZZE8ZZLXA", "#{record.zze8zzlxa}");
            }

            if (record.getZze8zzbm() != null) {
                VALUES("ZZE8ZZBM", "#{record.zze8zzbm}");
            }

            if (dj != null) {
                VALUES("ZZEXDJ", "(SELECT TO_CHAR(TO_DATE(#{dj}, 'yyyy- mm-dd'), 'yyyy') * 1000 +TO_CHAR(TO_DATE(#{dj}, 'yyyy-mm- dd'), 'ddd ') - 1900000 FROM DUAL)");
            }

            if (record.getZze8jyfw() != null) {
                VALUES("ZZE8JYFW", "#{record.zze8jyfw}");
            }

            if(record.getZzfil2()!=null){
                VALUES("ZZFIL2","#{record.zzfil2}");

            }

            if(record.getZze8jyfw2()!=null){
                VALUES("ZZE8JYFW2","#{record.zze8jyfw2}");
            }
            if(record.getZze8jyfw3()!=null){
                VALUES("ZZE8JYFW3", "#{record.zze8jyfw3}");
            }
            VALUES("ZZPF1","'1'");
            VALUES("ZZALPH","(SELECT abalph from "+schema+".F0101 where trim(aban8)=#{record.zzan8})");
            return toString();


        }
        public String selectByPrimaryKey(@Param("schema")String schema,@Param("record") Fe80101z record){
            SELECT("count(1)");
            FROM(schema+".FE80101Z");

            WHERE("Trim(ZZE8ZZLXA) = #{record.zze8zzlxa}");
            WHERE("Trim(ZZE8ZZBM) = #{record.zze8zzbm}");
            WHERE("Trim(ZZAN8) = #{record.zzan8}");
            return toString();
        }

    }

    @UpdateProvider(type=SqlProvider.class, method="updateByE8ZZBM")
    int updateByE8ZZBM(@Param("schema")String schema,@Param("record") Fe80101z record, @Param("datatype") String datatype,@Param("dj") String dj);

    @SelectProvider(type=SqlProvider.class, method="selectByPrimaryKey")
    int selectByPrimaryKey(@Param("schema")String schema,@Param("record") Fe80101z record);

    @InsertProvider(type=SqlProvider.class, method="insertSelective")
    int insertSelective(@Param("schema")String schema,@Param("record") Fe80101z record,@Param("dj") String dj);
}
