package com.bdqn.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//部门实体类
@SuppressWarnings("serial")//用于抑制编译器产生警告
@NoArgsConstructor//生成无参构造函数
@AllArgsConstructor//生成有参构造函数
@Data//生成get,set方法
@Accessors(chain = true)//访问方式，链式风格
public class Dept implements Serializable {
    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    private Long deptNo;//主键ID
    private String dName;//部门名称
    private String dbSource;//来自于那个数据库
}
