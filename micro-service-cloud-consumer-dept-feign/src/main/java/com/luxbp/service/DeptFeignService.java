package com.luxbp.service;

import com.luxbp.entity.Dept;
import com.luxbp.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDERDEPT")
public interface DeptFeignService {
    //对应服务提供者（8001、8002、8003）Controller 中定义的方法
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id);
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/feign/timeout")
    public String DeptFeignTimeout();

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public int addStudent(@RequestBody Student student);
}

