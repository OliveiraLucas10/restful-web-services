package com.oliveiralucaspro.restful.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.restful.ws.domain.HelloWorldBean;

import lombok.Data;
import lombok.Setter;

@RestController
public class HelloWorld {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!!");
	}
}
