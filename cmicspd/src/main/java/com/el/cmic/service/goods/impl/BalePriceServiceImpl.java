package com.el.cmic.service.goods.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.el.cmic.common.SpdInterfaceType;
import com.el.cmic.common.domain.SpdData;
import com.el.cmic.common.domain.SpdRequest;
import com.el.cmic.common.domain.SpdResult;
import com.el.cmic.domain.goods.BalePrice;
import com.el.cmic.mapper.goods.BalePriceMapper;
import com.el.cmic.service.goods.BalePriceService;
import com.el.utils.AddSpaceUtil;
import com.el.utils.CallSpdWebServiceUtil;
import com.el.utils.SpdClientService;

@Service
public class BalePriceServiceImpl implements BalePriceService{
	Logger logger = Logger.getLogger(BalePriceServiceImpl.class);
	 
	@Autowired
	private BalePriceMapper balePriceMapper;
	
	@Value("${spd.ID}")
	private String spdId;
	
	@Resource(name="spdRequest")
	private SpdRequest spdRequest;
	
	@Resource(name="callSpdWebServiceUtil")
	private CallSpdWebServiceUtil callSpdWebServiceUtil;
	
	@Resource(name="spdClientService")
	private SpdClientService spdClientService;
	
	@Override
	public List<BalePrice> selectBalePrice() {
		return balePriceMapper.selectBalePrice();
	}

	@Override
	@Transactional
	public Integer updateEV01(String status,String co,String limt) {
		return balePriceMapper.updateEV01(status, co, limt);
	}
	
	
	
	/**
	 * 更新  FE8SPD04  更新   EV01   接口入口
	 */
	@Override
	public void callBalePriceImplement(){
		List<BalePrice> arrayList = new ArrayList<BalePrice>();
		arrayList=this.selectBalePrice();
		for(BalePrice balePrice:arrayList){
			SpdData  spdData = new SpdData(SpdInterfaceType.BALEPRICE_TYPE,spdId,balePrice,"明细");
			//生成data数据
            String data =spdData.toJson();
            System.out.println(data);
            SpdResult spdResult = spdClientService.callSpdWebService(data);
            System.out.println(spdResult);
            afterResponse(balePrice,spdResult);
		}
	}
	
	public void afterResponse(BalePrice balePrice,SpdResult spdResult){
		 String status = "Y";
		 //接口调用不成功  更新状态
		if(!spdResult.isSuccess()){
			status="E";
		}
		updateEV01(status,AddSpaceUtil.addSpanceRight(balePrice.getCo(),5),AddSpaceUtil.addSpanceRight(balePrice.getLitm(), 25));
	}
}
