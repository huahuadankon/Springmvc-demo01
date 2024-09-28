package com.example.command_dispatcher_system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门（私有化）实体
 * @author liuyichen
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class Department {
    private long id;
    private String departmentName;
    private String departmentDesc;
}
