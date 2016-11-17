package com.el.cmic.callmdm.service;

import com.el.cmic.callmdm.domain.RqInputHeader;
import org.springframework.util.StringUtils;

/**
 * Created by Vincent on 2016/9/20.
 */
public interface CallMdmService {

    String NO = "NO-";
    String REQNO = "REQNO-";
    String CO = "CO-";

    public void addCallWS();

    public void updateCallWS();

    public default String getBillInfo(String no, String doco,String co) {

        String billInfo = "";

        billInfo = NO + no + ";";
        if(!StringUtils.isEmpty(co)) {
            billInfo = billInfo + CO + co + ";";
        }
        if (!StringUtils.isEmpty(doco)) {
            billInfo = billInfo + REQNO + doco + ";";
        }
        return billInfo;
    }

    public default RqInputHeader getRqE001InputHeader(String dataType, String billInfo, String direction, String funcType) {
        RqInputHeader rqInputHeader = new RqInputHeader();
        rqInputHeader.setDataType(dataType);
        rqInputHeader.setDirection(direction);
        rqInputHeader.setFuncType(funcType);
        rqInputHeader.setMsg("");
        rqInputHeader.setSubmitbillinfo(billInfo);
        return rqInputHeader;
    }
}
