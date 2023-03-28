package com.luxbp.mapper;

import com.luxbp.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface DeptMapper {
    //Get data by primary key

    Dept selectByPrimaryKey(Integer deptNo);
    //Get all the data in the table
    List<Dept> GetAll();
}