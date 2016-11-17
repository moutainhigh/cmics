package com.el.cmic.service.ckcancelback;

import com.alibaba.fastjson.JSON;
import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.domain.ckback.CkBackOrder;
import com.el.cmic.domain.ckback.CkBackOrderDtl;
import com.el.cmic.domain.ckback.CkBackSequence;
import com.el.cmic.domain.ckcancelback.CkCancelBackOrder;
import com.el.cmic.domain.ckcancelback.CkCancelBackOrderDtl;
import com.el.cmic.mapper.ckback.CkBackMapper;
import com.el.cmic.mapper.ckcancelback.CkCancelBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Vincent on 2016/10/29.
 */
@Service
public class CkCancelBackServiceImpl implements CkCancelBackService {
    @Autowired
    private CkCancelBackMapper ckCancelBackMapper;

    @Override
    @Transactional
    public WmsResult acceptData(String data) {
        WmsResult wmsResult = new WmsResult(true, "0000", "成功");
        /*JSONObject jsonObject = JSON.parseObject(data);

        CkBackOrder ckBackOrder = JSON.parseObject(data, CkBackOrder.class);
        String ojb = jsonObject.get("接口数据").toString();*/

        CkCancelBackOrder ckCancelBackOrder = JSON.parseObject(data, CkCancelBackOrder.class);

        List<CkCancelBackOrderDtl> ckCancelBackOrderDtlList = ckCancelBackOrder.getCkCancelBackOrderDtl();
        for (CkCancelBackOrderDtl ckCancelBackOrderDtl : ckCancelBackOrderDtlList
                ) {
            String status = "Y";
            BigDecimal uorg = ckCancelBackOrderDtl.getUorg();
            BigDecimal socn = ckCancelBackOrderDtl.getSocn();
            if (uorg.intValue() != socn.intValue()) {
                status = "D";
            }
            ckCancelBackMapper.updateCancelBackStatus(ckCancelBackOrder,ckCancelBackOrderDtl, status);
        }


        return wmsResult;

    }
}
