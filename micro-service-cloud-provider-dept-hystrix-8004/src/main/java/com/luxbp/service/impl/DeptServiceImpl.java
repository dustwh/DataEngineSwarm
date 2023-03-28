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
            //It is stipulated that no error will be reported within 5 seconds, and it will run normally. If it exceeds 5 seconds, an error will be reported and the specified method will be called.
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
    // When the service fails, call this method to give a friendly prompt
    public String dept_TimeoutHandler(Integer id) {
        return  "write some error here, like system busy or sth else！"+"thread：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id;
    }

    //Hystrix Circuit Breaker showcase
    @Override
    @HystrixCommand(fallbackMethod = "deptCircuitBreaker_fallback", commandProperties = {
            //The following parameters have default configurations in the HystrixCommandProperties class
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //Whether to open the breaker
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "1000"), //Statistical time window
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //The number of requests in the statistical time window
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //sleep time window
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //Within the statistical time window, when the request failure rate reaches 60%, it will enter the fuse state
    })
    public String deptCircuitBreaker(Integer id) {
        if (id < 0) {
            //When the id passed in is a negative number, an exception is thrown and the downgrade method is called
            throw new RuntimeException("id can not < 0！");
        }
//        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "succeed，id：" + "1";
    }
    //fall back method in deptCircuitBreaker
    public String deptCircuitBreaker_fallback(Integer id) {
        return "id can not be negative,re-try\t id:" + id;
    }

}
