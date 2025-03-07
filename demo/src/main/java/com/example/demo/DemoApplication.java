package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
//@ComponentScan(basePackages = "annotation.springmvc")
//@ComponentScan(basePackages = "myconfig")
@ComponentScan(basePackages = "boardmapper")
@ComponentScan(basePackages = "react.ajax")
@ComponentScan(basePackages = "errors")
//@MapperScan(basePackages = "annotation.springmvc.mybatis")
@MapperScan(basePackages = "boardmapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
