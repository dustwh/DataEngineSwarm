package com.luxbp.service.impl;

import com.luxbp.entity.Student;
import com.luxbp.mapper.StudentDAO;
import com.luxbp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public int addStudent(Student student) {
        return studentDAO.insertStudent(student);
    }
}
