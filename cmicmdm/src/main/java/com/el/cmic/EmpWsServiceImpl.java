package com.el.cmic;

import com.el.dev.emp.domain.Emp;
import com.el.dev.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Vincent on 2016/8/31.
 */
@WebService(endpointInterface = "com.el.cmic.EmpWsService")
public class EmpWsServiceImpl implements EmpWsService {
    @Autowired
    private EmpService empService;

    public String reqEmpString(String info) {
        System.out.println("返回:"+info);
        return "返回:"+info;
    }

    public List<Emp> reqEmps() {
        return empService.queryEmp();
    }

    public static void main(String[] args) {
        System.out.println("返回");
    }
}
