package com.el.cmic.service.ck;

import com.el.cmic.domain.ck.CkOrder;
import com.el.cmic.domain.ck.CkOrderDtl;

import java.util.List;

/**出库接口
 * Created by Vincent on 2016/10/24.
 */
public interface CkService {
   public void update(List<CkOrderDtl> ckOrderDtlList);
   void callWmsCkInterface();
}
