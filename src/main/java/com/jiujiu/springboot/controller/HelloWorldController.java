package com.jiujiu.springboot.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private static final String template = "Hello, %s!";

	@GetMapping
	public String sayHi() {
		return "hello world";
	}
}
