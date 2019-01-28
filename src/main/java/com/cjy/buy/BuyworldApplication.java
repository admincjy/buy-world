package com.cjy.buy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.cjy.buy")
public class BuyworldApplication {

	public static void main(String[] args) {

		SpringApplication.run(BuyworldApplication.class, args);
		System.out.println("来了,老弟");
	}

}

