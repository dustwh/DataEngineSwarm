package com.luxbp.controller;

import com.luxbp.entity.Dept;
import com.luxbp.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
@RestController
public class DeptController_Consumer {

    @Resource
    private DeptFeignService deptFeignService;
    @RequestMapping(value = "/f/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptFeignService.get(id);
    }
    @RequestMapping(value = "/f/dept/list")
    public List<Dept> list() {
        System.out.println("in------->");
        return deptFeignService.list();
    }

    @RequestMapping(value = "/consumer/dept/feign/timeout")
    public String DeptFeignTimeout() {
        // openFeign-ribbon 客户端一般默认等待一秒钟，超过该时间就会报错
        return deptFeignService.DeptFeignTimeout();
    }
}