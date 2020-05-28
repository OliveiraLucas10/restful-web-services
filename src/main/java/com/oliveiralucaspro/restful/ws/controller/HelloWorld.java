package com.oliveiralucaspro.restful.ws.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.restful.ws.domain.HelloWorldBean;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RestController
@RequiredArgsConstructor
public class HelloWorld {

	private final MessageSource messageSource;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!!");
	}
	
	@GetMapping(path = "/hello-world-i18n")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good,morning.message", null, locale);
	}
	
	@GetMapping(path = "/hello-world-i18n2")
	public String helloWorldInternationalized2() {
		return messageSource.getMessage("good,morning.message", null, LocaleContextHolder.getLocale());
	}
}
