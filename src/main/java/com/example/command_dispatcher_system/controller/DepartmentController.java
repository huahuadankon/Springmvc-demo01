package com.example.command_dispatcher_system.controller;

import com.example.command_dispatcher_system.entity.Department;
import com.example.command_dispatcher_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门相关controller控制器
 * @author liuyichen
 * @version 1.0
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/queryAll")
    public List<Department> queryAllDepartment(){
        List<Department> departments = this.departmentService.queryAllDepartments();

//        Department department1 = new Department();
//        department1.setId(1);
//        department1.setDepartmentName("开发部");
//        department1.setDesc("开发部门");
//        Department department2 = new Department();
//        department2.setId(2);
//        department2.setDepartmentName("测试部");
//        ArrayList<Department> departments = new ArrayList<>();
//        departments.add(department1);
//        departments.add(department2);


        return departments;

    }

}
