package com.aceios.bilibili.test.service;

import com.aceios.bilibili.test.dao.TDepartmentDao;
import com.aceios.bilibili.test.entity.TDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "department")
@Service
public class TDepartmentService {

    @Autowired
    private TDepartmentDao departmentDao;

    @CachePut(key = "#department.id")
    public TDepartment save(TDepartment department) {
        System.out.println("保存 id=" + department.getId() + " 的数据");
        this.departmentDao.insert(department);
        return department;
    }

    @CachePut(key = "#department.id")
    public TDepartment update(TDepartment department) {
        System.out.println("修改 id=" + department.getId() + " 的数据");
        this.departmentDao.update(department);
        return department;
    }

    @Cacheable(key = "#id")
    public TDepartment getDepartmentById(Integer id) {
        System.out.println("获取 id=" + id + " 的数据");
        TDepartment department = this.departmentDao.getById(id);
        return department;
    }

    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        System.out.println("删除 id=" + id + " 的数据");
        this.departmentDao.deleteById(id);
    }
}