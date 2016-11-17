package com.el.cmic.service.repertory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.cfg.domain.FE8WMS20;
import com.el.cmic.mapper.repertory.FE820Mapper;
import com.el.cmic.service.repertory.FE8WMS20Service;

import java.util.List;

@Service
public class FE8WMS20ServiceImpl  implements FE8WMS20Service{

	@Autowired
	public FE820Mapper  fE820Mapper;
	
	@Override
	public FE8WMS20 selectFE8WMS20ByKcoo(String kcoo) {
		return fE820Mapper.selectFE8WMS20ByKcoo(kcoo);
	}

	@Override
	public List<FE8WMS20> selectAllFE8WMS20() {
		return fE820Mapper.selectAllFE8WMS20();
	}

	@Override
	public FE8WMS20 selectFE8WMS20ByWmsCo(String wmsCo) {
		return fE820Mapper.selectFE8WMS20ByWmsCo(wmsCo);
	}
}
