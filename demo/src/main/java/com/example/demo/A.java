package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {
	@RequestMapping("/a")
	public String test() {
		return "sample";
	}
}
