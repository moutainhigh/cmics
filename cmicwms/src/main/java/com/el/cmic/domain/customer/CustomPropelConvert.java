package com.el.cmic.domain.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.el.cmic.domain.goods.Licence;
import com.el.utils.DateUtil;

/**
 * 实体英文转汉语
 *
 * @author zhanhao
 */
public class CustomPropelConvert {

    /**
     * 英汉翻译
     *
     * @param list
     * @return
     */
    public static List<Map<String, Object>> cpEntityToMap(List<CustomPropel> list) {
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (CustomPropel customPropel : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("货主 ", customPropel.getLse8hzbm() == null ? "" : customPropel.getLse8hzbm());
            map.put("编号 ", customPropel.getAban8() == null ? "" : customPropel.getAban8());
            map.put("客户类型 ", customPropel.getAbat1() == null ? "" : customPropel.getAbat1());
            map.put("名称 ", customPropel.getAbalph() == null ? "" : customPropel.getAbalph());
            map.put("查询码  ", customPropel.getKse8bym() == null ? "" : customPropel.getKse8bym());
            map.put("地址 ", customPropel.getAddress() == null ? "" : customPropel.getAddress());
            map.put("联系人 ", customPropel.getWwmlnm() == null ? "" : customPropel.getWwmlnm());
            map.put("电话 ", customPropel.getTell() == null ? "" : customPropel.getTell());
            map.put("状态  ", customPropel.getKscusts() == null ? "" : customPropel.getKscusts());
            map.put("货主名称 ", customPropel.getKse8wmshzm() == null ? "" : customPropel.getKse8wmshzm());
            map.put("建档日期  ", DateUtil.formatDate("", customPropel.getKse8jdsj()));
            map.put("税号 ", customPropel.getAbtax() == null ? "" : customPropel.getAbtax());
            //对收货明细 进行英汉翻译
            List<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();
            if (customPropel.getList() != null && customPropel.getList().size() > 0) {
                for (CustomPItem customPItem : customPropel.getList()) {
                    Map<String, Object> mapItem = new HashMap<String, Object>();
                 //   mapItem.put("地址编号", customPItem.getPA8() == null ? "" : customPItem.getPA8());
                    mapItem.put("收货地址", customPItem.getAddress() == null ? "" : customPItem.getAddress());
                    mapItem.put("使用部门", customPItem.getMcu() == null ? "" : customPItem.getMcu());
                    mapItem.put("联系人 ", customPItem.getMlnm() == null ? "" : customPItem.getMlnm());
                    mapItem.put("联系电话", customPItem.getTellPhone() == null ? "" : customPItem.getTellPhone());
                    listItem.add(mapItem);
                }
                map.put("收货地址明细 ", listItem);
            } else {//地址明细为空
                map.put("收货地址明细 ", listItem);
            }

            //对证照明细  进行翻译
            List<Map<String, Object>> licenceList = new ArrayList<Map<String, Object>>();
            if (customPropel.getCustomLicenceList() != null && customPropel.getCustomLicenceList().size() > 0) {
                for (CustomLicence licence : customPropel.getCustomLicenceList()) {
                    Map<String, Object> licenMap = new HashMap<String, Object>();
                    licenMap.put("证照类型", licence.getZZE8ZZLXA() == null ? "" : licence.getZZE8ZZLXA());
                    licenMap.put("证号", licence.getZZE8ZZBM() == null ? "" : licence.getZZE8ZZBM());
                    //licenMap.put("证照有效自",DateUtil.juLianFormatDate(licence.getZZEFTJ()));
                    //licenMap.put("证照有效至", DateUtil.juLianFormatDate(licence.getZZEXDJ()));
                    licenceList.add(licenMap);
                }
                map.put("证照明细", licenceList);
            } else {
                map.put("证照明细", licenceList);
            }
            //map 添加到 listMap中
            listMap.add(map);
        }
        return listMap;
    }
}
