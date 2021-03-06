package com.el.cmic.service;

import javax.jws.WebService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.el.cmic.common.SpdInterfaceType;
import com.el.cmic.common.domain.Fe8spdlg;
import com.el.cmic.common.domain.SpdResult;
import com.el.cmic.common.service.ValidParamService;
import com.el.cmic.domain.query.Ve8spdF41021;
import com.el.cmic.domain.query.Ve8spdf4111;
import com.el.cmic.domain.query.Ve8spdsales;
import com.el.cmic.service.ledger.SpdLedgerService;
import com.el.cmic.service.revert.RevertDataService;
import com.el.cmic.service.salequery.SalesQueryService;
import com.el.cmic.service.spdlog.SpdLogService;
import com.el.cmic.service.stockquery.StockQueryService;
import com.el.cmic.service.stockquery.StockQueryServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.el.cmic.service.order.SpdOrderService;
import com.el.cmic.service.settlement.SettlementService;
import org.springframework.util.Base64Utils;

import java.util.List;

/**
 * Created by Vincent on 2016/11/1.
 */
@WebService(endpointInterface = "com.el.cmic.service.SpdWsService")
public class SpdWsServiceImpl implements SpdWsService {
    Logger logger = Logger.getLogger(SpdWsServiceImpl.class);
    @Autowired
    private SpdOrderService spdOrderService;

    @Autowired
    private SettlementService settlementService;
    @Autowired
    private ValidParamService validParamServiceImpl;
    @Autowired
    private RevertDataService revertDataService;
    @Autowired
    private SpdLogService spdLogServiceImpl;
    @Autowired
    private SpdLedgerService spdLedgerServiceImpl;
    @Autowired
    private StockQueryService stockQueryServiceImpl;
    @Autowired
    private SalesQueryService salesQueryServiceImpl;


    public String UpLoadData(String appkey, String timestamp, String data, String sign, String ver) {
        SpdResult spdResult = null;
        Fe8spdlg fe8spdlg = new Fe8spdlg();
        try {
            JSONObject jsonObject = null;
            //验证数据及签名是否正确，不正确的话直接返回
            String acceptParam = "[appkey]=" + appkey +
                    ";[timestamp]=" + timestamp +
                    ";[data]=" + data + ";[sign]=" + sign + ";[ver]=" + ver;
            logger.info("接收到的数据:" + acceptParam);


            spdResult = validParamServiceImpl.validData(timestamp, data, sign);
            fe8spdlg = validParamServiceImpl.getLogInfo();
            fe8spdlg.setLge8rznr(acceptParam);
            fe8spdlg.setLge8rzlx("INFO");
            fe8spdlg.setLge8rzfx("TOERP");
            //签名有问题，直接返回
            if (!spdResult.isSuccess()) {
                logger.error("返回的数据:" + spdResult.toString());
                String ecodeStr = "";
                try {
                    String str = spdResult.toJson();
                    ecodeStr = Base64Utils.encodeToString(str.getBytes("utf-8"));
                    logger.info("返回的数据:[编码]" + ecodeStr);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("返回的数据，转码出错,error:" + e.getMessage());
                }
                return ecodeStr;
            }
            byte[] decodeBytes = Base64Utils.decodeFromString(data);
            String decodeData = new String(decodeBytes, "utf-8");
            //logger.info("[data]解码:" + decodeData);
            //数据转成Json对象
            jsonObject = JSON.parseObject(decodeData);

            //获取接口类型
            String interfaceTypeName = jsonObject.get("接口类型").toString();

            //获取接口数据
            String interfaceData = jsonObject.get("接口数据").toString();
            if (interfaceTypeName.equals(SpdInterfaceType.SPD_ORDER_TYPE)) {
                // SPD订单数据接收
                logger.info("........接收SPD订单接口表开始........");
                spdResult = spdOrderService.acceptData(interfaceData);
                logger.info("........接收SPD订单接口表结束........");
            }
            if (interfaceTypeName.equals(SpdInterfaceType.SPD_SETTLE_TYPE)) {
                // SPD结算数据接收
                logger.info("........接收SPD结算接口表开始........");
                spdResult = settlementService.acceptData(interfaceData);
                logger.info("........接收SPD结算接口表结束........");
            }
            if (interfaceTypeName.equals(SpdInterfaceType.SPD_REVERT_TYPE)) {
                logger.info("........接收SPD请退接口表开始........");
                spdResult = revertDataService.callInsertRevertData(interfaceData);
                logger.info("........接收SPD请退接口表结束........");
            }
            if (interfaceTypeName.equals(SpdInterfaceType.LEDGER_QUERY_TYPE)) {
                logger.info("........接收应急库分类账查询开始........");
                List<Ve8spdf4111> ve8spdf4111List = spdLedgerServiceImpl.acceptData(interfaceData);
                String str = JSON.toJSONString(ve8spdf4111List, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.SortField);
                logger.info("........接收应急库分类账查询结束........");
                String ecodeStr = Base64Utils.encodeToString(str.getBytes("utf-8"));
                return ecodeStr;
            }
            if (interfaceTypeName.equals(SpdInterfaceType.STOCK_QUERY_TYPE)) {
                logger.info("........接收应急库库存查询开始........");
                List<Ve8spdF41021> ve8spdF41021List = stockQueryServiceImpl.acceptData(interfaceData);
                String str = JSON.toJSONString(ve8spdF41021List, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.SortField);
                logger.info("........接收应急库库存查询结束........");
                String ecodeStr = Base64Utils.encodeToString(str.getBytes("utf-8"));
                return ecodeStr;
            }
            if (interfaceTypeName.equals(SpdInterfaceType.SPD_SALES_QUERY_TYPE)) {
                logger.info("........接收商品销售明细查询开始........");
                List<Ve8spdsales> ve8spdsalesList = salesQueryServiceImpl.acceptData(interfaceData);
                String str = JSON.toJSONString(ve8spdsalesList, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.SortField);
                logger.info("........接收商品销售明细查询结束........");
                String ecodeStr = Base64Utils.encodeToString(str.getBytes("utf-8"));
                return ecodeStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
            spdResult = new SpdResult();
            spdResult.setSuccess(false);
            spdResult.setCode("1004");
            spdResult.setMessage("数据接收失败,error:" + e.getMessage());
            logger.error("返回的数据:" + spdResult.toString());
            fe8spdlg.setLge8rzlx("ERROR");
            fe8spdlg.setLge8str200("数据接收失败:error:" + e.getMessage());

        }
        if (spdResult.isSuccess()) {
            fe8spdlg.setLge8rzlx("INFO");
            logger.info("返回的数据:" + spdResult.toString());
        } else {
            fe8spdlg.setLge8rzlx("ERROR");
            fe8spdlg.setLge8str200("SPD返回失败,错误信息:" + spdResult.toJson());
            logger.error("返回的数据:" + spdResult.toString());
        }

        try {
            spdLogServiceImpl.insertFe8spdlg(fe8spdlg);

            fe8spdlg.setLge8rznr(spdResult.toString());
            fe8spdlg.setLge8rzfx("TOSPD");
            //fe8wmslg.setLsdl03("Response");
            spdLogServiceImpl.insertFe8spdlg(fe8spdlg);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("记录日志表fe8spdlg失败,失败原因:" + e.getMessage());
        }
        String str = spdResult.toJson();
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
