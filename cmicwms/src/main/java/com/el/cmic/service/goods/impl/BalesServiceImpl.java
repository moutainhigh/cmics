package com.el.cmic.service.goods.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.el.cfg.domain.Ve8wms20;
import com.el.cmic.common.WmsInterfaceType;
import com.el.cmic.common.domain.WmsData;
import com.el.cmic.common.domain.WmsRequest;
import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.common.service.Ve8wms20Service;
import com.el.cmic.domain.goods.BalesConvert;
import com.el.cmic.domain.goods.BalesData;
import com.el.cmic.domain.log.Fe8wmslg;
import com.el.utils.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.el.cmic.domain.goods.Bales;
import com.el.cmic.domain.goods.Licence;
import com.el.cmic.mapper.goods.BalesMapper;
import com.el.cmic.service.goods.BalesService;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;

/**
 * 货品接口
 */
@Service
public class BalesServiceImpl implements BalesService {
    Logger logger = Logger.getLogger(BalesServiceImpl.class);
    @Autowired
    private BalesMapper balesMapper;
    @Resource(name = "httpRequest")
    private HttpRequest httpRequest;
    //@Resource(name = "wmsRequest")
    //private WmsRequest wmsRequest;
    @Value("${wms.ID}")
    private String wmsId;
    @Value("${wms.Ver}")
    private String ver;
    @Autowired
    private Ve8wms20Service ve8wms20ServiceImpl;

    /**
     * 查询货品推送信息 List
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Bales> selectBalesList() {
        List<Bales> list = balesMapper.selectBalesList();
        //根据 limt  取证照明细
        for (Bales bales : list) {
            if (bales.getImlitm() != null) {
                List<Licence> licenList = this.selectLicenceList(bales.getImlitm());
                bales.setLicenceList(licenList);
            }
        }
        return list;
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Licence> selectLicenceList(String litm) {
        return balesMapper.selectLicenceList(litm);
    }

    @Override
    @Transactional
    public Integer updataJdeStatus(String flag, String litm) {
        return balesMapper.updataJdeStatus(flag, litm);
    }

    @Override
    public void callWmsGoodsInterface() {
        try {
            String status = "Y";
            List<Bales> balesList = new ArrayList<Bales>();
            balesList = selectBalesList();
            for (Bales bales : balesList
                    ) {
                if (balesList == null || balesList.size() == 0) {
                    continue;
                }
                WmsData wmsData = new WmsData(WmsInterfaceType.GOODS_TYPE, wmsId);
                BalesData balesData = new BalesData();

                // List<FE8WMS20> fe8WMS20List = fe8WMS20ServiceImpl.selectAllFE8WMS20();
                //for (FE8WMS20 fe8wms20 : fe8WMS20List
                //         ) {
                List<Ve8wms20> ve8wms20List = ve8wms20ServiceImpl.selectVe8wms20ByKcoo(bales.getLsco());
                for (Ve8wms20 ve8wms20 : ve8wms20List
                        ) {
                    List<Bales> balesOnlyOneList = new ArrayList<Bales>();
                    bales.setLSE8HZBM(ve8wms20.getLse8hzbm());//货主编码
                    bales.setCcname(ve8wms20.getCcname());//货主名称
                    balesOnlyOneList.add(bales);
                    balesData.setBalesList(balesOnlyOneList);

                    wmsData.setInterfaceData(balesData);
                    //生成data数据
                    String data = JSON.toJSONString(wmsData, SerializerFeature.WriteMapNullValue);
                    WmsRequest wmsRequest = new WmsRequest(ve8wms20.getLse8appk(), ve8wms20.getLsepapsd(), data, ver);
                    //wmsRequest.setData(data);
                    Fe8wmslg fe8wmslg = new Fe8wmslg();
                    //fe8wmslg.setLsdoco(bales.getBslitm());
                    fe8wmslg.setLsvar1(data);
                    //fe8wmslg.setLsdl03("Request");
                    fe8wmslg.setLsdl03(WmsInterfaceType.GOODS_TYPE);
                    //发送post请求
                    String result = httpRequest.sendPost(wmsRequest.toMap(), fe8wmslg);
                    byte[] bytes = Base64Utils.decodeFromString(result);
                    String decodeResult = new String(bytes, "utf-8");
                    WmsResult wmsResult = JSON.parseObject(decodeResult, WmsResult.class);
                    status = "Y";
                    if (!wmsResult.isSuccess()) {
                        //status = "E";
                        status = "N";
                    }
                    // }
                    //更新状态
                    updataJdeStatus(status, bales.getBslitm());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("调用货品推送接口失败,error:" + e.getMessage());

        }

    }

}
