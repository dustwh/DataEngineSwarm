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

    //Hystrix 熔断案例
    @Override
    @HystrixCommand(fallbackMethod = "deptCircuitBreaker_fallback", commandProperties = {
            //以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "1000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    public String deptCircuitBreaker(Integer id) {
        if (id < 0) {
            //当传入的 id 为负数时，抛出异常，调用降级方法
            throw new RuntimeException("id can not < 0！");
        }
//        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "succeed，id：" + "1";
    }
    //deptCircuitBreaker 的降级方法
    public String deptCircuitBreaker_fallback(Integer id) {
        return "id can not be negative,re-try\t id:" + id;
    }

}
