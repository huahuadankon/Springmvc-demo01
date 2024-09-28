package com.example.command_dispatcher_system.service;

import com.example.command_dispatcher_system.controller.UserController;
import com.example.command_dispatcher_system.entity.User;
import com.example.command_dispatcher_system.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liuyichen
 * @version 1.0
 */
@Service//纳入spring管理
@Slf4j//日志注解，类似sout
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired //实例注入
    private RedisTemplate<String ,String > redisTemplate;
    public User addUser(User user){
        log.info("新增一个用户");
//        String code = this.redisTemplate.opsForValue().get("sms_send" + user.getPhone());//redis中的code
//        if(code==null){
//            throw new RuntimeException("验证码已过期");
//        }
//        if(!code.equals(user.getSmsCode())){
//            throw new RuntimeException("验证码输入错误");
//        }

        User userTest = this.userMapper.selectUserByPhone(user.getPhone());
        if(userTest!=null){
            throw new RuntimeException("该手机号已被注册");
        }
        this.userMapper.insertOneUser(user);
        User resultUser = this.userMapper.selectUserByPhone(user.getPhone());
        return resultUser;
    }


    public User logUser(User user) throws Exception {
        log.info(user+"登录");
        User resultUser = this.userMapper.selectOneUser(user.getUsername(), user.getPassword());
        if(resultUser==null){
            log.error("用户名或密码错误");
            throw new Exception("用户名或密码错误");
        }
        return resultUser;
    }

    public String  generateCode(String phoneNumber){
        Random random = new Random();
        String code = String.format("%04d", random.nextInt(10000));

        // 将验证码存储到Redis中，设置过期时间为5分钟
        String redisKey = "sms_send" + phoneNumber;
        redisTemplate.opsForValue().set(redisKey, code, 5, TimeUnit.MINUTES);
        return code;

    }
}
