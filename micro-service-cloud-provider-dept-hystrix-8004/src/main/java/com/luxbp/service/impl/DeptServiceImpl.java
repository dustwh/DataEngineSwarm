package com.luxbp.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.luxbp.service.DeptService;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Override
    public String deptInfo_Ok(Integer id) {
        return "thread：" + Thread.currentThread().getName() + "  deptInfo_Ok,id:   " + id;
    }

    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler", commandProperties =
            //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @Override
    public String deptInfo_Timeout(Integer id) {
//        int outTime = 6; //test server fallback method
        int outTime = 4;  //test consumer fallback method
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id + "  time use: " + outTime;
    }
    // 当服务出现故障后，调用该方法给出友好提示
    public String dept_TimeoutHandler(Integer id) {
        return  "write some error here, like system busy or sth else！"+"thread：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id;
    }
}
