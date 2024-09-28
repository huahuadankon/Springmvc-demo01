package com.example.command_dispatcher_system.controller;

import com.example.command_dispatcher_system.entity.User;
import com.example.command_dispatcher_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关controller
 * @author liuyichen
 * @version 1.0
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    /*
    * user封装用户
    * return 返回新用户对象，null失败
    * */
    @PostMapping("regUser")
    public User regUser(@RequestBody User user){
        log.info("封装的新用户属性:"+user);
        User resultUser = this.userService.addUser(user);


        return resultUser;
    }
    @PostMapping("logUser")
    public User login(@RequestBody User user) throws Exception {
        User resultUser = this.userService.logUser(user);
        return resultUser;
    }
    /*自动生成验证码
    * */
    @PostMapping("/sendCode")
    public String sendCode(@RequestBody User user){

        String generateCode = this.userService.generateCode(user.getPhone());
        return generateCode;
    }

}
