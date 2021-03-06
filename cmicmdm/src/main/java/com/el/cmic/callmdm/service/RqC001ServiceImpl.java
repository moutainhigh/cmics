package com.el.cmic.callmdm.service;

import com.el.cfg.domain.F0101;
import com.el.cfg.domain.Fe80101;
import com.el.cfg.domain.Fe841003;
import com.el.cfg.domain.Fe841005;
import com.el.cmic.callmdm.mapper.RqC001Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2016/10/12.
 */
@Service
public class RqC001ServiceImpl implements RqC001Service {
    @Value("${schema}")
    private String schema;
    @Autowired
    private RqC001Mapper rqC001Mapper;

    @Transactional
    public int updateFE80101(Fe80101 fe80101) {
        return rqC001Mapper.updateFE80101(fe80101,schema);
    }

    @Transactional
    public int updateF0101(F0101 f0101) {
        return rqC001Mapper.updateF0101(f0101,schema);
    }

    @Transactional
    public int updateFe841003(Fe841003 fe841003) {
        return rqC001Mapper.updateFe841003(fe841003,schema);
    }

    @Override
    public int updateFe841005(Fe841005 fe841005) {
        return 0;
    }
}
