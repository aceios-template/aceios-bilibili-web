package com.aceios.bilibili.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        return "test/thello";
    }

    @RequestMapping("file")
    public String hello() {
        return "test/file";
    }

    @RequestMapping("websocket")
    public String websocket() {
        return "test/websocket";
    }

    @RequestMapping("department")
    public String department(){return "test/department";}
}