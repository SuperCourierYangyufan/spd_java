package com.my.spd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableAsync
@EnableRabbit
@MapperScan("com.my.spd.dao")
@EnableSwagger2
@SpringBootApplication
public class SpdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpdApplication.class, args);
	}

}

