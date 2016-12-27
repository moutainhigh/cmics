package com.el.cmic.common.service;

import com.el.cmic.common.domain.Ve8spd0099;

import java.util.List;

/**
 * Created by Vincent on 2016/11/22.
 */
public interface Ve8spd0099Service {
    /**
     * 根据配送机构获取spd的标识，appkey、password、url、namespace等
     * @param co
     * @return
     */
    List<Ve8spd0099> selectByCo(String co);

    /**
     * 根据配送机构获取spd的标识，appkey、password、url、namespace等
     * @param spdid
     * @return
     */
    Ve8spd0099 selectByCoAndSpdId(String co,String spdid);
}
