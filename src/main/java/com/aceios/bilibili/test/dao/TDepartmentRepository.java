package com.aceios.bilibili.test.dao;

import com.aceios.bilibili.test.entity.TDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TDepartmentRepository extends MongoRepository<TDepartment, Integer> {
    
}