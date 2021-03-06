/**
 * 
 */
package com.el.cmic.service.inbound;

import java.util.List;

import com.el.cmic.common.domain.WmsResult;
import com.el.cmic.domain.inbound.InboundPush;
import com.el.cmic.domain.inbound.InboundPushDetail;

/**
 * @author ELSIAN
 *
 */
public interface InboundService {

   // List<InboundPush> getInboundPushList();

   // List<InboundPush> getInboundPushListWithDetails();
    
   // String getPushData();
    
    int updateF4211Status(InboundPushDetail row);

    int updateF4311Status(InboundPushDetail row);
    
    int updateFE8WMS03Status(InboundPushDetail row);
    
    int updateF4211StatusList(List<InboundPushDetail> updList);

    int updateF4311StatusList(List<InboundPushDetail> updList);

    public int updateFE8WMS03StatusList(List<InboundPushDetail> updList);
        
    public WmsResult acceptData(String data);
    
    public void callWmsInboundPushInterface();
}
