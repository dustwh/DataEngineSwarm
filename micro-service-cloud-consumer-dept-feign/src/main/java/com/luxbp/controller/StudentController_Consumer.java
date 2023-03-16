package com.luxbp.controller;

import com.luxbp.entity.Student;
import com.luxbp.service.DeptFeignService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController_Consumer {
    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/f/student/add")
    public int addStudent(@RequestBody Student student) {
        return deptFeignService.addStudent(student);
    }
}
