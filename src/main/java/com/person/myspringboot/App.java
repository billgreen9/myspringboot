package com.person.myspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class App {
	
	@Value("${name}")
	private String name;

	@RequestMapping("/app")
	@ResponseBody
	String home() {
		return "Hello World!"+name;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
