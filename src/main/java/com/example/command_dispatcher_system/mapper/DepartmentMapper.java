package com.example.command_dispatcher_system.mapper;

import com.example.command_dispatcher_system.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门持久化操作mybatis映射
 * @author liuyichen
 * @version 1.0
 */
@Mapper
public interface DepartmentMapper {

    public List<Department> selectAll();
}
