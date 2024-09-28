package com.example.command_dispatcher_system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试java连接并使用redis数据库
 * @author liuyichen
 * @version 1.0
 */
@RestController
@Slf4j
public class RedisTestController {
    @Autowired
    private RedisTemplate<String ,String > redisTemplate;

    @GetMapping("/redisTest1")
    public String  test1(){
        this.redisTemplate.opsForValue().set("myPhone","sms_code");
        String s = this.redisTemplate.opsForValue().get("myPhone");
        log.info("myPhone的验证码"+this.redisTemplate.opsForValue().get("myPhone"));
        return s;

    }
}
