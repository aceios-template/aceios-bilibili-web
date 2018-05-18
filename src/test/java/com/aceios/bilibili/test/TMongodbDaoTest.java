package com.aceios.bilibili.test;

import com.aceios.bilibili.test.dao.TMongodbDao;
import com.aceios.bilibili.test.entity.TDepartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TMongodbDaoTest {
    @Autowired
    private TMongodbDao mongodbDao;

    @Test
    public void testInsert() {
        TDepartment department = new TDepartment();
        department.setId(2);
        department.setName("Mongo");
        department.setDescr("date");
        this.mongodbDao.insert(department);
    }

    @Test
    public void testUpdate() {
        TDepartment department = new TDepartment();
        department.setId(2);
        department.setName("M313");
        department.setDescr("date");
        this.mongodbDao.update(department);
    }

    @Test
    public void testGetById() {
        TDepartment tDepartment = this.mongodbDao.getById(2);
        System.out.println(tDepartment.getName());
    }

    @Test
    public void testGetAll() {
        List<TDepartment> tDepartments = this.mongodbDao.getAll();
        System.out.println(tDepartments.size());
    }

    @Test
    public void testDeleteById() {
        this.mongodbDao.deleteById(1);
    }
}
