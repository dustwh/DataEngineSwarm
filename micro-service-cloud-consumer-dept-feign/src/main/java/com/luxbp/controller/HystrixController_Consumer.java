package com.luxbp.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;;
import lombok.extern.slf4j.Slf4j;
import com.luxbp.service.DeptHystrixService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") //Global downgrade method
public class HystrixController_Consumer {
    @Resource
    private DeptHystrixService deptHystrixService;
    @RequestMapping(value = "/consumer/dept/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id) {
        return deptHystrixService.deptInfo_Ok(id);
    }
    //Downgrade on the client side
    @RequestMapping(value = "/consumer/dept/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler") //designate its own fallback method
    @HystrixCommand //use default fallback
    public String deptInfo_Timeout(@PathVariable("id") Integer id) {
        String s = deptHystrixService.deptInfo_Timeout(id);
        log.info(s);
        return s;
    }
    // A dedicated fallback method for the deptInfo_Timeout method
    public String dept_TimeoutHandler(@PathVariable("id") Integer id) {
        log.info("deptInfo_Timeout error，service has been fallback！");
        return "system busy（client's deptInfo_Timeout has been triggered）";
    }

    /**
     * the global fallback method,
     * The fallback method must be in the same class as the execution method of hystrix
     * @DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") on the class，Use the @HystrixCommand annotation on the request method
     */
    public String dept_Global_FallbackMethod() {
        return "default fall back";
    }
}