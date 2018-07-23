package com.bdqn.springcloud.dao;

import com.bdqn.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean addDept(@Param("dept") Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
