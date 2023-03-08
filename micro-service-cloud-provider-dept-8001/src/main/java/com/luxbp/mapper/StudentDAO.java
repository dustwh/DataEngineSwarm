package com.luxbp.mapper;

import com.luxbp.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDAO {
    public int insertStudent(Student student);

    public int deleteStudent(String stuNum);
}
