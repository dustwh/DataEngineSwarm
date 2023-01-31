package com.luxbp.controller;
import lombok.extern.slf4j.Slf4j;
import com.luxbp.entity.Dept;
import com.luxbp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Service Provider Control Layer / 服务提供者的控制层
 * author:
 */
@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        System.out.println("8001");
        return deptService.selectAll();
    }

    //timeout test, response time = 5s
    @RequestMapping(value = "/dept/feign/timeout")
    public String DeptFeignTimeout() {
        //暂停 5 秒
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}