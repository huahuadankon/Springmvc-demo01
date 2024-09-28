package com.example.command_dispatcher_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.command_dispatcher_system.mapper")
public class CommandDispatcherSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandDispatcherSystemApplication.class, args);
	}

}
