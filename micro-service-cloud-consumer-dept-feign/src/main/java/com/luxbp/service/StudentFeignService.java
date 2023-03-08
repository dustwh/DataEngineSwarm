package com.luxbp.service;

import com.luxbp.entity.Dept;
import com.luxbp.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "MICROSERVICECLOUDPROVIDERDEPT")
public interface StudentFeignService {
    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public int addStudent(@RequestBody Student student);

}
