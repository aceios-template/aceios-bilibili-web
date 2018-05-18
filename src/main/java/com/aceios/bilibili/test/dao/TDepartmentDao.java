package com.aceios.bilibili.test.dao;

import com.aceios.bilibili.test.entity.TDepartment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TDepartmentDao {

    public void insert(TDepartment department);
    
    public TDepartment getById(Integer id);
    
    public void update(TDepartment department);
    
    public void deleteById(Integer id);
}