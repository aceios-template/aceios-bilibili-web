package com.aceios.bilibili.test.dao;

import com.aceios.bilibili.test.entity.TUser;

public interface TUserDao {
    public int insert(TUser user);
    public int deleteById(Integer id);
    public int update(TUser user);
    public TUser getById(Integer id);
}