package com.el.cmic.service.ckcancel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.el.cfg.domain.FE8WMS20;
import com.el.cmic.common.WmsInterfaceType;
import com.el.cmic.common.domain.WmsData;
import com.el.cmic.common.domain.WmsRequest;
import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.domain.ck.CkOrderDtl;
import com.el.cmic.domain.ckcancel.CkCancelOrder;
import com.el.cmic.domain.ckcancel.CkCancelOrderDtl;
import com.el.cmic.domain.log.Fe8wmslg;
import com.el.cmic.mapper.ckcancel.CkCancelMapper;
import com.el.cmic.service.repertory.FE8WMS20Service;
import com.el.utils.DateUtil;
import com.el.utils.HttpRequest;
import com.el.utils.Md5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vincent on 2016/10/29.
 * 出库取消推送服务实现
 */
@Service
public class CkCancelServiceImpl implements CkCancelService {
    Logger logger = Logger.getLogger(CkCancelServiceImpl.class);
    @Value("${wms.ID}")
    private String wmsId;
    @Value("${wms.Url}")
    private String url;
    //@Value("${wms.AppKey}")
    //private String appKey;
    //@Value("${wms.AppPassword}")
    //private String appPassword;
    @Value("${wms.Ver}")
    private String ver;
    @Autowired
    private CkCancelMapper ckCancelMapper;
    @Resource(name = "httpRequest")
    private HttpRequest httpRequest;
   // @Resource(name = "wmsRequest")
   // private WmsRequest wmsRequest;
    @Autowired
    private FE8WMS20Service fe8WMS20ServiceImpl;

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public void callWmsCkCancelInterface() {
       /* System.out.println("wmsRequest hasCode=" +wmsRequest.hashCode());
        wmsRequest.setData("测试");*/
        List<FE8WMS20> fe8WMS20List = fe8WMS20ServiceImpl.selectAllFE8WMS20();
        for (FE8WMS20 fe8wms20 : fe8WMS20List
                ) {
            List<CkCancelOrder> ckCancelOrderList = ckCancelMapper.selectCkCancelOrderList(fe8wms20.getLsco());
            for (CkCancelOrder ckCancelOrder : ckCancelOrderList
                    ) {
                try {
                    List<CkCancelOrderDtl> ckCancelOrderDtlList = ckCancelMapper.selectCkCancelOrderDtlList(ckCancelOrder.getKcoo(),
                            ckCancelOrder.getDoco(), ckCancelOrder.getDcto());
                    ckCancelOrder.setCkCancelOrderDtlList(ckCancelOrderDtlList);
                    WmsData wmsData = new WmsData(WmsInterfaceType.CK_CANCEL_TYPE, wmsId);
                    wmsData.setInterfaceData(ckCancelOrder);
                    //生成data数据
                    String data = JSON.toJSONString(wmsData, SerializerFeature.WriteMapNullValue);
                    WmsRequest wmsRequest = new WmsRequest(fe8wms20.getLse8appk(), fe8wms20.getLsepapsd(), data,ver);
                   // wmsRequest.setData(data);
                    Fe8wmslg fe8wmslg = new Fe8wmslg();
                    fe8wmslg.setLsdoco(new BigDecimal(ckCancelOrder.getDoco()));
                    fe8wmslg.setLsdcto(ckCancelOrder.getDcto());
                    fe8wmslg.setLskcoo(ckCancelOrder.getKcoo());
                    fe8wmslg.setLsvar1(data);
                    //fe8wmslg.setLsdl03("Request");
                    fe8wmslg.setLsdl03(WmsInterfaceType.CK_CANCEL_TYPE);
                    //调用请求
                    String encodeResult = httpRequest.sendPost(wmsRequest.toMap(), fe8wmslg);

                    byte[] bytes = Base64Utils.decodeFromString(encodeResult);
                    String decodeResult = new String(bytes, "utf-8");

                    //处理接收结果
                    afterResponse(decodeResult, ckCancelOrder, ckCancelOrderDtlList);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("调用WMS出库取消推送接口失败," + e.getMessage());
                }
            }
        }

    }

    public void afterResponse(String jsonString, CkCancelOrder ckCancelOrder, List<CkCancelOrderDtl> ckCancelOrderDtlList) {
        WmsResult wmsResult = JSON.parseObject(jsonString, WmsResult.class);
        String status = "Y";
        if (!wmsResult.isSuccess()) {
            //更新状态
            status = "E";
        }
        update(ckCancelOrder, ckCancelOrderDtlList, status);
    }

    @Transactional
    public void update(CkCancelOrder ckCancelOrder, List<CkCancelOrderDtl> ckCancelOrderDtlList, String status) {
        for (CkCancelOrderDtl ckCancelOrderDtl : ckCancelOrderDtlList
                ) {
            ckCancelMapper.updateCkCancel(ckCancelOrder, ckCancelOrderDtl, status);
        }
    }
}
