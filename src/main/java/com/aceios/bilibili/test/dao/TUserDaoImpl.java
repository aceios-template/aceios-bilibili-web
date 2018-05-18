package com.aceios.bilibili.test.dao;

import com.aceios.bilibili.test.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 无问题
 */
@Repository
public class TUserDaoImpl implements TUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(TUser user) {
        String sql = "insert into user(id,username,password,birthday) values(?,?,?,?)";
        return this.jdbcTemplate.update(
                          sql,
                          user.getId(),
                          user.getUsername(),
                          user.getPassword(),
                          user.getBirthday()
                                        );
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        return this.jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(TUser user) {
        String sql = "update user set password = ? where id = ?";
        return this.jdbcTemplate.update(
                                sql,
                                user.getPassword(),
                                user.getId()
                                        );
    }

    @Override
    public TUser getById(Integer id) {
        String sql = "select * from user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<TUser>() {

            @Override
            public TUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                TUser user = new TUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }

        },id);
    }

}