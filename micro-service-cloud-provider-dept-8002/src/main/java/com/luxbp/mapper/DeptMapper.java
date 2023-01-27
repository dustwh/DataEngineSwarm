package com.luxbp.mapper;

import com.luxbp.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface DeptMapper {
    //Get data by primary key / 根据主键获取数据

    Dept selectByPrimaryKey(Integer deptNo);
    //Get all the data in the table / 获取表中的全部数据
    List<Dept> GetAll();
}