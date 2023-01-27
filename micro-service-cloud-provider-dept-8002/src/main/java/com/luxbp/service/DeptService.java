package com.luxbp.service;

import com.luxbp.entity.Dept;
import java.util.List;
public interface DeptService {
    Dept get(Integer deptNo);
    List<Dept> selectAll();
}
