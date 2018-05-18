package com.aceios.bilibili.test;

import com.aceios.bilibili.test.dao.TRoleRepository;
import com.aceios.bilibili.test.entity.TRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TRoleRepositoryTest {

    @Autowired
    private TRoleRepository roleRepository;
    
    @Test
    public void testInsert() {
        TRole role = new TRole();
        role.setName("管理员");
        role.setDescr("测试");
        TRole result = this.roleRepository.save(role);
        System.out.println(result);
    }
    
    @Test
    public void testFindOne() {
        Optional<TRole> role = this.roleRepository.findById(1);
        System.out.println(role);
    }
    
    @Test
    public void testUpdate() {
        TRole role = new TRole();
        role.setId(1);
        role.setName("管理员");
        role.setDescr("控制权限");
        TRole result = this.roleRepository.save(role);
        System.out.println(result);
    }
    
    @Test
    public void testDelete() {
        TRole role = new TRole();
        role.setId(1);
        this.roleRepository.delete(role);
    }
}