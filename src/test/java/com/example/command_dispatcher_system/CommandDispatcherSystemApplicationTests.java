package com.example.command_dispatcher_system;

import com.example.command_dispatcher_system.entity.User;
import com.example.command_dispatcher_system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommandDispatcherSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testSelectUser(){
		User lyc = userMapper.selectOneUser("lyc", "1923");
		System.out.println(lyc);
	}

}
