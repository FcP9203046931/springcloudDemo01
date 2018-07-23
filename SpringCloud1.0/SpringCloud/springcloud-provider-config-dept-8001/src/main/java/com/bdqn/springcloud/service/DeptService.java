package com.bdqn.springcloud.service;

import com.bdqn.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
