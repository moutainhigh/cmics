package com.el.cmic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.el.cmic.common.WmsInterfaceType;
import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.common.service.ValidParamService;
import com.el.cmic.domain.ckback.CkBackOrder;
import com.el.cmic.domain.log.Fe8wmslg;
import com.el.cmic.mapper.log.WmsLogMapper;
import com.el.cmic.service.ckback.CkBackService;
import com.el.cmic.service.ckcancelback.CkCancelBackService;
import com.el.cmic.service.inbound.InboundService;

import com.el.cmic.service.log.Fe8wmslgService;
import com.el.cmic.service.repertory.InInvertoryCancelService;
import com.el.cmic.service.repertory.StoTransferPushService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Vincent on 2016/9/28.
 * 接收wms的推送controller类
 * 由于接口规范要求是5个参数
 * 序号	字段名	说明	类型
 * 1	appkey	AppKey(由接口提供方分配给调用方AppKey) String
 * 2	timestamp	时间戳,格式为(年月日时分秒),例如:20160901110304 String
 * 3	data	接收的数据,UTF-8格式的JSON字符串(内容因业务不同而有差异,具体见各业务调用说明)经过Base64位编码后得到的字符串 String
 * 4	Sign	数据签名,签名算法为 MD5(timestamp +data+AppPassword) AppPassword与AppKey是一对,由接口提供方在分配AppKey时一起提供
 * 5	Ver	接口版本	当前为1
 */
@Controller
@RequestMapping("/wms/")
public class WmsDataController {
    Logger logger = Logger.getLogger(WmsDataController.class);
    @Autowired
    private ValidParamService validParamServiceImpl;

    @Autowired
    private CkBackService ckBackServiceImpl;

    @Autowired
    private CkCancelBackService ckCancelBackServiceImpl;

    @Autowired
    private InboundService inboundService;
    @Autowired
    private InInvertoryCancelService inInvertoryCancelServiceImpl;
    @Autowired
    private StoTransferPushService stoTransferPushServiceImpl;
    //@Autowired
    //private WmsLogMapper wmsLogMapper;
    @Autowired
    private Fe8wmslgService fe8wmslgServiceImpl;

    @RequestMapping(value = "/uploaddata", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String upLoadData(@RequestParam(name = "appkey") String appkey,
                             @RequestParam(name = "timestamp") String timestamp,
                             @RequestParam(name = "data") String data,
                             @RequestParam(name = "sign") String sign,
                             @RequestParam(name = "ver") String ver) {
        WmsResult wmsResult = null;
        Fe8wmslg fe8wmslg = new Fe8wmslg();
        String interfaceTypeName="";
        try {
            JSONObject jsonObject = null;
            //验证数据及签名是否正确，不正确的话直接返回
            String acceptParam = "[appkey]=" + appkey +
                    ";[timestamp]=" + timestamp +
                    ";[data]=" + data + ";[sign]=" + sign + ";[ver]=" + ver;
            logger.info("接收到的数据:" + acceptParam);
            wmsResult = validParamServiceImpl.validData(timestamp, data, sign);
            fe8wmslg = validParamServiceImpl.getLogInfo();
            // TODO: 2016/10/28 测试时可以先注释
            //签名有问题，直接返回
            if (!wmsResult.isSuccess()) {
                logger.error("返回的数据:" + wmsResult.toString());
                return wmsResult.toJson();
            }
            //解码 TODO: 2016/10/28 测试时可以先注释
            byte[] decodeBytes = Base64Utils.decodeFromString(data);
            String decodeData = new String(decodeBytes, "utf-8");
            logger.info("[data]解码:" + decodeData);
            //jsonObject = JSON.parseObject(data);
            //==========================================================
            //数据转成Json对象
            jsonObject = JSON.parseObject(decodeData);

            //获取接口类型
            interfaceTypeName = jsonObject.get("接口类型").toString();

            //获取接口数据
            String interfaceData = jsonObject.get("接口数据").toString();

            //判断接口类型，不同的接口类型调用不同的service，传入接口数据
            if (interfaceTypeName.equals(WmsInterfaceType.CK_BACK_TYPE)) {
                //"出库单返回"
                logger.info("........出库单返回开始........");
                wmsResult = ckBackServiceImpl.acceptData(interfaceData);
                logger.info("........出库单返回结束........");
            } else if (interfaceTypeName.equals(WmsInterfaceType.RK_BACK_TYPE)) {
                // 入库单返回 业务处理
                logger.info("........入库单返回开始........");
                wmsResult = inboundService.acceptData(interfaceData);
                logger.info("........入库单返回结束........");
            } else if (interfaceTypeName.equals(WmsInterfaceType.ST_CHANGE_TYPE)) {
                // 库存移库 业务处理
                logger.info("........库存移库开始........");
                wmsResult = stoTransferPushServiceImpl.acceptData(interfaceData);
                logger.info("........库存移库结束........");
            } else if (interfaceTypeName.equals(WmsInterfaceType.RK_CANCEL_BACK_TYPE)) {
                // 入库单取消返回 业务处理
                logger.info("........入库单取消返回开始........");
                wmsResult = inInvertoryCancelServiceImpl.updateOperation(interfaceData);
                logger.info("........入库单取消返回结束........");
            } else if (interfaceTypeName.equals(WmsInterfaceType.CK_CANCEL_BACK_TYPE)) {
                // 出库单取消返回 业务处理
                logger.info("........出库单取消返回开始........");
                wmsResult = ckCancelBackServiceImpl.acceptData(interfaceData);
                logger.info("........出库单取消返回结束........");
            }

            //记录接收的日志

            //fe8wmslg.setLsdoco(inInvertoryCancel.getQxdoco());
            //fe8wmslg.setLsdcto(inInvertoryCancel.getQxdcto());
            //fe8wmslg.setLskcoo(inInvertoryCancel.getQxkcoo());
            fe8wmslg.setLsdl01("INFO");
            fe8wmslg.setLsvar1(acceptParam);
            fe8wmslg.setLsdl02("TOERP");
           // fe8wmslg.setLsdl03("Request");


        } catch (Exception e) {
            e.printStackTrace();
            wmsResult = new WmsResult();
            wmsResult.setSuccess(false);
            wmsResult.setCode("1004");
            wmsResult.setMessage("数据接收失败,error:" + e.getMessage());
            logger.error("返回的数据:" + wmsResult.toString());
            fe8wmslg.setLsdl01("ERROR");
        }

        if (wmsResult.isSuccess()) {
            fe8wmslg.setLsdl01("INFO");
            logger.info("返回的数据:" + wmsResult.toString());
        } else {
            fe8wmslg.setLsdl01("ERROR");
            logger.error("返回的数据:" + wmsResult.toString());
        }

        //fe8wmslg.setLsdoco(inInvertoryCancel.getQxdoco());
        //fe8wmslg.setLsdcto(inInvertoryCancel.getQxdcto());
        //fe8wmslg.setLskcoo(inInvertoryCancel.getQxkcoo());
        try {
            fe8wmslgServiceImpl.insertFe8wmslg(fe8wmslg);

            fe8wmslg.setLsvar1(wmsResult.toString());
            fe8wmslg.setLsdl02("TOWMS");
            //fe8wmslg.setLsdl03("Response");
            fe8wmslgServiceImpl.insertFe8wmslg(fe8wmslg);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("记录日志表feuwmslg失败,失败原因:" + e.getMessage());
        }
        String str = wmsResult.toJson();
        String ecodeStr = "";
        try {
            ecodeStr = Base64Utils.encodeToString(str.getBytes("utf-8"));
            logger.info("返回的数据:[编码]" + ecodeStr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("返回的数据，转码出错,error:" + e.getMessage());
        }

        return ecodeStr;

    }
}
