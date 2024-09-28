package com.example.command_dispatcher_system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liuyichen
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private Long deptId;

    private String smsCode;//保存短信验证码（应该把此类临时属性单独放到DTO类/Map）

}
