package com.aceios.bilibili.test.dao;

import com.aceios.bilibili.test.entity.TDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TMongodbDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(TDepartment department) {
        this.mongoTemplate.insert(department);
    }

    public void deleteById(int id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        this.mongoTemplate.remove(query, TDepartment.class);
    }

    public void update(TDepartment department) {
        Criteria criteria = Criteria.where("id").is(department.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("descr", department.getDescr());
        this.mongoTemplate.updateMulti(query, update, TDepartment.class);
    }

    public TDepartment getById(int id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        return this.mongoTemplate.findOne(query, TDepartment.class);
    }
    
    public List<TDepartment> getAll() {
        List<TDepartment> userList = this.mongoTemplate.findAll(TDepartment.class);
        return userList;
    }
    
}