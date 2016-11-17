package com.el.cmic.callmdm.mapper;

import com.el.cfg.domain.F0101;
import com.el.cfg.domain.Fe80101;
import com.el.cfg.domain.Fe841003;
import com.el.cfg.domain.Fe841005;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * Created by Vincent on 2016/10/12.
 */
public interface RqC001Mapper {
    final class SqlProvider extends SQL {

        public String updateFE80101(Fe80101 fe80101) {
            UPDATE("FE80101");
            if (!StringUtils.isEmpty(fe80101.getKsev01())) {
                SET("ksev01=#{ksev01}");
            }
            if (!StringUtils.isEmpty(fe80101.getKsflag())) {
                SET("ksflag=#{ksflag}");
            }
            if(!StringUtils.isEmpty(fe80101.getKse8kstym())){
                SET("kse8kstym =#{kse8kstym}");
            }
            WHERE("ksan8=#{ksan8}");
            return toString();
        }

        public String updateF0101(F0101 f0101) {
            UPDATE("F0101");
            SET("Abalky=#{abalky}");
            WHERE("aban8=#{aban8}");
            return toString();
        }

        public String updateFe841003(Fe841003 fe841003) {
            UPDATE("Fe841003");
            SET("sqflag=#{sqflag}");
            WHERE("squkid=#{squkid}");
            return toString();
        }

        public String updateFe841005(Fe841005 fe841005) {
            UPDATE("Fe841005");
            SET("scflag=#{sqflag}");
            WHERE("scukid=#{squkid}");
            return toString();
        }

    }

    @UpdateProvider(type = SqlProvider.class, method = "updateFE80101")
    int updateFE80101(Fe80101 fe80101);

    @UpdateProvider(type = SqlProvider.class, method = "updateF0101")
    int updateF0101(F0101 f0101);

    @UpdateProvider(type = SqlProvider.class, method = "updateFe841003")
    int updateFe841003(Fe841003 fe841003);

    @UpdateProvider(type = SqlProvider.class, method = "updateFe841005")
    int updateFe841005(Fe841005 fe841005);
}
