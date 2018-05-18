package com.aceios.bilibili.test;

import com.aceios.bilibili.test.dao.TDepartmentDao;
import com.aceios.bilibili.test.entity.TDepartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TDepartmentTest {

    @Autowired
    private TDepartmentDao departmentMapper;
    
    @Test
    public void testInsert() {
        TDepartment department = new TDepartment();
        department.setId(1);
        department.setName("研发部");
        department.setDescr("开发产品");
        this.departmentMapper.insert(department);
    }
    
    @Test
    public void testGetById() {
        TDepartment department = this.departmentMapper.getById(1);
        System.out.println(department);
    }
    
    @Test
    public void testUpdate() {
        TDepartment department = new TDepartment();
        department.setId(1);
        department.setDescr("开发高级产品");
        this.departmentMapper.update(department);
    }
    
    @Test
    public void testDeleteById() {
        this.departmentMapper.deleteById(1);
    }
}