package com.example.command_dispatcher_system.mapper;

import com.example.command_dispatcher_system.entity.User;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByPhone(String phone);

    /**
     * 插入一条用户记录
     * @param user
     * @return
     */

    int insertOneUser(User user);

    @Select("<script>" +
            "select uid,user_name,did,phone,state from user_info " +
            "<where>" +
            "<if test = 'userName != null and userName != \"\"'> " +
            "and user_name like '%${userName}%' " +
            "</if>" +
            "<if test = 'phone != null and phone != \"\"'> " +
            "or phone like '%${phone}%' " +
            "</if>" +
            "and did = #{did}" +
            "</where>" +
            "</script>")
    List<User> selectDepartmentUserList(int did, String userName,String phone);

    User selectOneUser(String username,String password);

    /**
     * 根据群主id查询群名称
     * @param creator
     * @return
     */
    String getGroupNameById(Long creator);
}
