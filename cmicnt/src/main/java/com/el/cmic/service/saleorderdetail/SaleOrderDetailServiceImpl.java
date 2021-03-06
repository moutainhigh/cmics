package com.el.cmic.service.saleorderdetail;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.el.cmic.common.NtInterfaceType;
import com.el.cmic.common.NtRequestParam;
import com.el.cmic.common.service.BasicService;
import com.el.cmic.domain.ntcfg.Fe8NtCfg;
import com.el.cmic.domain.saleorderdetail.Fe8nt004;
import com.el.cmic.mapper.saleorderdetail.SaleOrderDetailMapper;
import com.el.cmic.service.ntcfg.NtCfgService;
import com.el.cmic.utils.HttpClientUtil;
import com.el.cmic.utils.HttpRequestUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by king_ on 2017/2/17.
 */
@Service
public class SaleOrderDetailServiceImpl extends BasicService {
   @Autowired
   private SaleOrderDetailMapper saleOrderDetailMapper;

    @PostConstruct
    public void init(){
        this.interFaceTypeByTime = NtInterfaceType.SALEDETAIL_BY_TIME;
        this.interFaceTypeByCode = NtInterfaceType.SALEDETAIL_BY_KEY;
    }

    @Override
    public boolean callNtInterface(String code) {
        Fe8NtCfg fe8NtCfg = ntCfgServiceImpl.selectFe8NtCfgByInterfaceName(this.interFaceTypeByCode);
        url = fe8NtCfg.getUrl();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userCode", ntRequestParam.getUserCode());
        hashMap.put("pwd", ntRequestParam.getPwd());
        hashMap.put("vr02", code);
        try {

            String result = httpClientUtil.doPost(url, hashMap,"utf-8");

            if (!afterNtResponse(result)) return false;

        } catch (Exception ex) {
            logger.error("调用纳通销售订单明细(根据主键)接口失败;error:" + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void insertOrUpdate(String data) {
        List<Fe8nt004> fe8nt004List = JSON.parseArray(data, Fe8nt004.class);

        if(fe8nt004List == null || fe8nt004List.size() == 0){
            this.rdate = null;
            return;
        }

        Collections.sort(fe8nt004List);

        logger.info(fe8nt004List.get(0).toString());

        this.rdate = fe8nt004List.get(fe8nt004List.size()-1).getSdredate();

        logger.info(fe8nt004List.get(fe8nt004List.size()-1).getSdredate());












        for (Fe8nt004 fe8nt004 : fe8nt004List
                ) {
            Fe8nt004 fe8nt = saleOrderDetailMapper.selectDateByPK(tableSchema, fe8nt004.getSde8from(), fe8nt004.getSde8type(), fe8nt004.getSde8odno(), fe8nt004.getSde8lnid());
            //判断是不是存在该商品，存在的话判断一下更新时间是不是比数据库的要新，如果新就需要更新表
            /*if (fe8nt != null) {
                int compareDateResult = fe8nt.getSdredate().compareTo(fe8nt004.getSdredate());
                if (compareDateResult < 0) {
                    saleOrderDetailMapper.updateFe8nt004ByPK(tableSchema, fe8nt004);
                }
            } else {
                //不存在就插入数据
                insertFe8nt004(tableSchema, fe8nt004);
            }*/

            if (fe8nt != null) {
                //saleOrderDetailMapper.deleteFe8nt004ByPK(tableSchema, fe8nt004.getSde8from(), fe8nt004.getSde8type(), fe8nt004.getSde8odno(), fe8nt004.getSde8lnid());
                logger.info("该条数据已经存在"+fe8nt.toString());
            }else {
                saleOrderDetailMapper.insertFe8nt004(tableSchema, fe8nt004);
            }
        }
    }

}
