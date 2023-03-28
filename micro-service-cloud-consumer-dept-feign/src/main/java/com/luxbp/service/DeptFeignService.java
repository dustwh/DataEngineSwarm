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

@Component
// The value is set to the service name, ie application.name in configuration file (application.yml or bootstrap.yml)
@FeignClient(value = "MICROSERVICECLOUDPROVIDERDEPT")
public interface DeptFeignService {
    //Corresponding to the method defined in the service provider (8001, 8002, 8003) Controller
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id);
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/feign/timeout")
    public String DeptFeignTimeout();

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public int addStudent(@RequestBody Student student);
}
