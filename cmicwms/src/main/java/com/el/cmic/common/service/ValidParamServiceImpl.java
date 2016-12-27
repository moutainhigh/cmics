package com.el.cmic.common.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.el.cfg.domain.Ve8wms20;
import com.el.cmic.common.WmsInterfaceType;
import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.domain.log.Fe8wmslg;
import com.el.utils.Md5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vincent on 2016/10/28.
 */
@Service
public class ValidParamServiceImpl implements ValidParamService {
    private final Logger logger=Logger.getLogger(ValidParamServiceImpl.class);
    // @Value("${wms.AppPassword}")
    // private String appPassword;
    private Fe8wmslg fe8wmslg = new Fe8wmslg();
    @Autowired
    private Ve8wms20Service ve8wms20ServiceImpl;

    @Override
    public Fe8wmslg getLogInfo() {
        return fe8wmslg;
    }

    @Override
    public WmsResult validData(String timestamp, String data, String sign) {
        //需要对数据进行处理
        WmsResult wmsResult = new WmsResult(true, "0000", "成功");
        String[] interfaceTypes = new String[]{WmsInterfaceType.CK_BACK_TYPE, WmsInterfaceType.CK_CANCEL_BACK_TYPE,
                WmsInterfaceType.RK_BACK_TYPE, WmsInterfaceType.RK_CANCEL_BACK_TYPE, WmsInterfaceType.ST_CHANGE_TYPE,
                WmsInterfaceType.ACOUNT_TYPY, WmsInterfaceType.INPUT_CHECK_TYPE, WmsInterfaceType.OUT_CHECK_TYPE,
                WmsInterfaceType.CONSERVE_TYPE, WmsInterfaceType.TRANSPORT_TYPE, WmsInterfaceType.STOCK_TYPE, WmsInterfaceType.PURCHASE_TYPE};
        try {

            byte[] decodeBytes = Base64Utils.decodeFromString(data);
            String decodeData = new String(decodeBytes, "utf-8");
            JSONObject jsonObject = JSON.parseObject(decodeData);
            logger.info("[data]解码:" + decodeData);
            Object object = jsonObject.get("接口类型");
            String interfaceType = "";
            if (object == null) {
                throw new Exception("缺少接口类型");
            } else {
                interfaceType = object.toString();
                fe8wmslg.setLsdl03(interfaceType);
                if (!Arrays.asList(interfaceTypes).contains(interfaceType)) {
                    throw new Exception("接口类型不识别,接收到的接口类型[" + interfaceType + "]");
                }
            }
            object = jsonObject.get("接口数据");
            if (object == null) {
                throw new Exception("缺少接口数据");
            } else {
                if (interfaceType.equals(WmsInterfaceType.CK_BACK_TYPE) || interfaceType.equals(WmsInterfaceType.CK_CANCEL_BACK_TYPE)
                        || interfaceType.equals(WmsInterfaceType.RK_BACK_TYPE) || interfaceType.equals(WmsInterfaceType.RK_CANCEL_BACK_TYPE)
                        || interfaceType.equals(WmsInterfaceType.ST_CHANGE_TYPE)) {
                    jsonObject = JSON.parseObject(object.toString());
                    //Object objDoco = jsonObject.get("通知单号");
                    Object objDoco = jsonObject.get("订单号");
                    if (objDoco != null && isNumeric(objDoco.toString())) {
                        fe8wmslg.setLsdoco(new BigDecimal(objDoco.toString()));
                    }
                    Object objDcto = jsonObject.get("订单类型");
                    if (objDcto != null) {
                        fe8wmslg.setLsdcto(objDcto.toString());
                    }
                    Object objKcoo = jsonObject.get("货主");
                    Object objWmsMcu = jsonObject.get("物流中心");
                    if (objKcoo != null && objWmsMcu != null) {
                        List<Ve8wms20> ve8wms20List = ve8wms20ServiceImpl.selectVe8wms20ByWmsCo(objKcoo.toString(), objWmsMcu.toString());
                        Ve8wms20 ve8wms20 = ve8wms20List.get(0);
                        fe8wmslg.setLskcoo(ve8wms20List.get(0).getLsco());
                        wmsResult = validSign(ve8wms20, timestamp, data, sign);
                        if (!wmsResult.isSuccess()) {
                            return wmsResult;
                        }
                    } else {
                        throw new Exception("缺少货主信息或者物流中心");
                    }
                    object = jsonObject.get("通知单明细");
                    if (object == null) {
                        object = jsonObject.get("明细");
                        if (object == null) {
                            throw new Exception("缺少明细数据");
                        }
                    }
                }

            }
        } catch (Exception e) {
            wmsResult.setSuccess(false);
            wmsResult.setCode("1005");
            wmsResult.setMessage("数据格式错误,解析失败:" + e.getMessage());
        }

        return wmsResult;
    }

    @Override
    public WmsResult validSign(Ve8wms20 ve8wms20, String timestamp, String data, String sign) {
        //  FE8WMS20 fe8WMS20 = fe8WMS20ServiceImpl.selectFE8WMS20ByWmsCo(wmsCo);
        WmsResult wmsResult = new WmsResult(true, "0000", "成功");
        String appPassword = ve8wms20.getLsepapsd();
        String calcSign = Md5Util.getMD5(timestamp, data, appPassword);
        if (!sign.equals(calcSign)) {
            wmsResult.setSuccess(false);
            wmsResult.setCode("1001");
            wmsResult.setMessage("签名不合法,接收到的Sign=" + sign + ";计算出的Sign=" + calcSign);
            // return wmsResult;
        }
        return wmsResult;
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
