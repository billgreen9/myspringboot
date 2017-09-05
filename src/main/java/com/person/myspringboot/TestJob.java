package com.person.myspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {
	
	@Autowired
	private Hello hello;
	
	@Scheduled(cron="*/3 5 1 * * ?")
	public void test(){
		System.out.println("hello!"+hello.getName());
	}

}
