package com.example.command_dispatcher_system.service;

import com.example.command_dispatcher_system.entity.Department;
import com.example.command_dispatcher_system.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门相关业务逻辑类
 * @author liuyichen
 * @version 1.0
 */
@Service
//将当前service对象纳入到spring boot环境中
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> queryAllDepartments(){
        System.out.println("部门查询");
        List<Department> departments = departmentMapper.selectAll();
        return departments;
    }
}
