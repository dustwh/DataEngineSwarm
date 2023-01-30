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
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptFeignService.get(id);
    }
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return deptFeignService.list();
    }
}