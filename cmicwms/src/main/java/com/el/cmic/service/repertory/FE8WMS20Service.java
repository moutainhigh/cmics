package com.el.cmic.service.repertory;

import com.el.cfg.domain.FE8WMS20;

import java.util.List;

public interface FE8WMS20Service {
	
	public FE8WMS20   selectFE8WMS20ByKcoo(String kcoo);
	public List<FE8WMS20> selectAllFE8WMS20();
	public FE8WMS20   selectFE8WMS20ByWmsCo(String wmsCo);

}
