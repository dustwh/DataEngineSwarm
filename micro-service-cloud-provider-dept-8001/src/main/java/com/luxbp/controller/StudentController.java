package com.luxbp.controller;

import com.luxbp.entity.Dept;
import com.luxbp.entity.Student;
import com.luxbp.service.DeptService;
import com.luxbp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Service Provider Control Layer
 * author:
 */
@RestController
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public int addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


}