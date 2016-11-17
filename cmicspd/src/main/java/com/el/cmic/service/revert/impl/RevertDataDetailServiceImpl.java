package com.el.cmic.service.revert.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.el.cmic.domain.revert.RevertDataDetail;
import com.el.cmic.mapper.revert.RevertDataDetailMapper;
import com.el.cmic.service.revert.RevertDataDetailService;

@Service
public class RevertDataDetailServiceImpl  implements RevertDataDetailService{

	@Autowired
	private RevertDataDetailMapper revertDataDetailMapper;
	
	
	/**
	 * SPD请退数据接收    明细新增
	 * @param data
	 * @return
	 */
	@Override
	@Transactional
	public Integer insertRevertDataDetail(RevertDataDetail revertDataDetail) {
		return revertDataDetailMapper.insertRevertDataDetail(revertDataDetail);
	}

}
