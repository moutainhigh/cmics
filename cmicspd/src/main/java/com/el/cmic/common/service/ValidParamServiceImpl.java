package com.el.cmic.common.service;

import java.util.Arrays;
import java.util.Base64;

import com.el.cmic.common.domain.Fe8spdlg;
import com.el.cmic.common.domain.Ve8spd0099;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.el.cfg.domain.FE8SPD00;
import com.el.cmic.common.SpdInterfaceType;
import com.el.cmic.common.domain.SpdResult;
import com.el.cmic.service.validate.FE8SPD00Service;
import com.el.utils.Md5Util;

/**
 * Created by Vincent on 2016/10/28.
 */
@Service
public class ValidParamServiceImpl implements ValidParamService {
    Logger logger = Logger.getLogger(ValidParamServiceImpl.class);
    //@Value("${spd.AppPassword}")
    //private String appPassword;
    private Fe8spdlg fe8spdlg = new Fe8spdlg();

    @Autowired
    private Ve8spd0099Service ve8spd0099ServiceImpl;


    @Override
    public SpdResult validData(String timestamp, String data, String sign) {

        //需要对数据进行处理
        SpdResult spdResult = new SpdResult(true, "0000", "成功");
        String[] interfaceTypes = new String[]{SpdInterfaceType.SPD_ORDER_TYPE, SpdInterfaceType.SPD_SETTLE_TYPE,
                SpdInterfaceType.SPD_REVERT_TYPE, SpdInterfaceType.LEDGER_QUERY_TYPE, SpdInterfaceType.STOCK_QUERY_TYPE,
        SpdInterfaceType.SPD_SALES_QUERY_TYPE};
        try {
            if (!spdResult.isSuccess()) {
                return spdResult;
            }
            byte[] decodeBytes = Base64.getDecoder().decode(data);
            String decodeData = new String(decodeBytes, "utf-8");
            logger.info("[data]解码:" + decodeData);
            JSONObject jsonObject = JSON.parseObject(decodeData);
            String interfaceType = "";
            Object object = jsonObject.get("接口类型");
            if (object == null) {
                throw new Exception("缺少接口类型");
            } else {
                interfaceType = object.toString();
                fe8spdlg.setLge8jkmc(interfaceType);//接口名称
                if (!Arrays.asList(interfaceTypes).contains(interfaceType)) {
                    throw new Exception("接口类型不识别,接收到的接口类型[" + interfaceType + "]");
                }
            }
            JSONObject jsonObjectInterfaceData = (JSONObject) jsonObject.get("接口数据");
            if (jsonObjectInterfaceData == null) {
                throw new Exception("缺少接口数据");
            } else {
                Object objco = null;
                Object objSpdid = null;
                if (interfaceType.equals(SpdInterfaceType.SPD_ORDER_TYPE)) {
                    objco = jsonObjectInterfaceData.get("配送单位ERP编号");
                    //Object objerp = jsonObject.get("配送单位系统标识”");
                    objSpdid = jsonObjectInterfaceData.get("SPD系统标识");

                    if (objco != null) {
                        fe8spdlg.setLge8erpid(objco.toString());
                    }
                    if (objSpdid != null) {
                        fe8spdlg.setLge8spdid(objSpdid.toString());
                    }


                    Object objcgdd = jsonObjectInterfaceData.get("采购订单号");
                    String cgdd = "";
                    if (objcgdd != null) {
                        cgdd = objcgdd.toString();
                    }
                    Object objQglx = jsonObjectInterfaceData.get("请购类型");
                    String qglx = "";
                    if (objQglx != null) {
                        qglx = objQglx.toString();
                    }
                    fe8spdlg.setLge8cgdd(cgdd);//订单号
                    fe8spdlg.setLge8qglx(qglx);
                }

                if (interfaceType.equals(SpdInterfaceType.SPD_SETTLE_TYPE)) {
                    objco = jsonObjectInterfaceData.get("结算单位ERP编号");
                    //Object objerp = jsonObject.get("配送单位系统标识”");
                    objSpdid = jsonObjectInterfaceData.get("SPD系统标识");

                    if (objco != null) {
                        fe8spdlg.setLge8erpid(objco.toString());
                    }
                    if (objSpdid != null) {
                        fe8spdlg.setLge8spdid(objSpdid.toString());
                    }
                }

                if (interfaceType.equals(SpdInterfaceType.SPD_REVERT_TYPE)) {
                    objco = jsonObjectInterfaceData.get("配送单位ERP编号");
                    //Object objerp = jsonObject.get("配送单位系统标识”");
                    objSpdid = jsonObjectInterfaceData.get("SPD系统标识");

                    if (objco != null) {
                        fe8spdlg.setLge8erpid(objco.toString());
                    }
                    if (objSpdid != null) {
                        fe8spdlg.setLge8spdid(objSpdid.toString());
                    }


                    Object objcgdd = jsonObjectInterfaceData.get("退货单号");
                    String cgdd = "";
                    if (objcgdd != null) {
                        cgdd = objcgdd.toString();
                    }

                    fe8spdlg.setLge8cgdd(cgdd);//订单号

                }
                if (interfaceType.equals(SpdInterfaceType.LEDGER_QUERY_TYPE) || interfaceType.equals(SpdInterfaceType.STOCK_QUERY_TYPE)
                ||interfaceType.equals(SpdInterfaceType.SPD_SALES_QUERY_TYPE)) {
                    objco = jsonObjectInterfaceData.get("配送机构ERP编号");
                    //Object objerp = jsonObject.get("配送单位系统标识”");
                    objSpdid = jsonObjectInterfaceData.get("SPD系统标识");
                }

                Ve8spd0099 ve8spd0099 = ve8spd0099ServiceImpl.selectByCoAndSpdId(objco.toString(), objSpdid.toString());

                spdResult = validSign(ve8spd0099, timestamp, data, sign);
                if (!spdResult.isSuccess()) {
                    return spdResult;
                }


                /*jsonObject = JSON.parseObject(object.toString());
                Object objDoco = jsonObject.get("通知单号");

                if (objDoco != null) {
                    fe8wmslg.setLsdoco(new BigDecimal(objDoco.toString()));
                }
                Object objDcto = jsonObject.get("订单类型");
                if (objDcto != null) {
                    fe8wmslg.setLsdcto(objDcto.toString());
                }
                Object objKcoo = jsonObject.get("货主");
                if (objKcoo != null) {
                    fe8wmslg.setLskcoo(objKcoo.toString());
                }
                object = jsonObject.get("通知单明细");
                if (object == null) {
                    object = jsonObject.get("明细");
                    if (object == null) {
                        throw new Exception("缺少明细数据");
                    }
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            spdResult.setSuccess(false);
            spdResult.setCode("1005");
            spdResult.setMessage("数据格式错误,解析失败:" + e.getMessage());
        }

        return spdResult;
    }

    @Override
    public SpdResult validSign(Ve8spd0099 ve8spd0099, String timestamp, String data, String sign) {
        SpdResult spdResult = new SpdResult(true, "0000", "成功");
        String calcSign = Md5Util.getMD5(timestamp, data, ve8spd0099.getApppassword());
        if (!sign.equals(calcSign)) {
            spdResult.setSuccess(false);
            spdResult.setCode("1001");
            spdResult.setMessage("签名不合法,接收到的Sign=" + sign + ";计算出的Sign=" + calcSign);
            // return wmsResult;
        }
        return spdResult;
    }

    @Override
    public Fe8spdlg getLogInfo() {
        return fe8spdlg;
    }
}
