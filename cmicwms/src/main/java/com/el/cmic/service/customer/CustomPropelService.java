package com.el.cmic.service.customer;

import java.util.List;

import com.el.cmic.domain.customer.CustomLicence;
import com.el.cmic.domain.customer.CustomPItem;
import com.el.cmic.domain.customer.CustomPropel;
import com.el.cmic.domain.goods.Licence;

public interface CustomPropelService {

	public List<CustomPropel>  selectCustomPropelList(String co);
	
	public List<CustomPItem>  selectCustomPItemList(String an8);
	
	public List<CustomLicence> selectLicenceList(String an8);
	
	public Integer updateJdeStatus(String flag,String BSAN8);
	public void callWmsCustomInterface();
}
