package com.el.cmic.service.repertory;

import java.util.List;
import java.util.Map;

import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.domain.repertory.InInvertoryCancel;

public interface InInvertoryCancelService {
	
	/**
	 * 接收json字符串 处理 入库取消返回推送使用
	 * @param data
	 */
	public WmsResult updateOperation(String  data);
	
	
	/**
	 * 入库取消返回推送使用
	 * @param paramMap
	 * @return
	 */
	public Integer updateInInvertoryCancel(Map<String,String> paramMap);
	
	/**
	 * 获得 InInvertoryCancel list集合  入库单使用
	 * @return
	 */
	public List<InInvertoryCancel>  selectInInvertoryCancel(String co,String mcu);

	/**
	 * 调用入库取消接口
	 */
	public void callWmsInCancelInterface();
}
