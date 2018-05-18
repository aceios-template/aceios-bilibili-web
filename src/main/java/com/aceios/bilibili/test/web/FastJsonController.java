package com.aceios.bilibili.test.web;

import com.aceios.bilibili.test.entity.TUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
public class FastJsonController {

    @RequestMapping("/test")
    @ResponseBody
    @CrossOrigin(origins="http://127.0.0.1:8020")   //CORS 支持 : 细粒度控制
    public TUser test() {
        TUser tuser = new TUser();
        tuser.setId(1);
        tuser.setUsername("jack");
        tuser.setPassword("jack123");
        tuser.setBirthday(new Date());
        return tuser;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public TUser test1() {
        TUser tuser = new TUser();
        tuser.setId(1/0);
        tuser.setUsername("jack");
        tuser.setPassword("jack123");
        tuser.setBirthday(new Date());
        return tuser;
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @GetMapping("/test/{name}")
    public TUser test3(@PathVariable("name") String name) {
        TUser tuser = new TUser();
        tuser.setId(1);
        tuser.setUsername(name);
        tuser.setPassword("jack123");
        tuser.setBirthday(new Date());
        return tuser;
    }

}
