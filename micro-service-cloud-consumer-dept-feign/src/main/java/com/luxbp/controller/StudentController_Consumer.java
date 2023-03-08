package com.luxbp.controller;

import com.luxbp.entity.Student;
import com.luxbp.service.StudentFeignService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController_Consumer {
    @Resource
    private StudentFeignService studentFeignService;

    @RequestMapping(value = "/consumer/student/add")
    public int addStudent(@RequestBody Student student) {
        return studentFeignService.addStudent(student);
    }
}
