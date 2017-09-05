package com.person.myspringboot;

import java.lang.reflect.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.person.myspringboot.dao.UserDAO;

import antlr.collections.List;
import jdk.nashorn.internal.codegen.ObjectClassGenerator;

@Controller
@EnableAutoConfiguration
public class SampleController {

	@Autowired
	private Config config;
	
	@Value("${name}")
	private String name;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/hello")
	@ResponseBody
	public String home() {
		return "Hello World!" + config.getInfo()+"<br/>|||||name="+name;
	}
	
	@RequestMapping("get_count")
	@ResponseBody
	public Object getCount() {
		int count = jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
		return count;
	}
	
	@ResponseBody
	@RequestMapping("get_users")
	public Object getUsers(String age) {
		
		return userDAO.query(3);
	}

	@ResponseBody
	@RequestMapping("get_basic_info")
	public Object getBasicInfo(String age) {
		
		return userDAO.queryBasicInfo(3);
	}
	
	@ResponseBody
	@RequestMapping("get_basic_info1")
	public Object getBasicInfo1(String age) {
		
		return userDAO.queryBasicInfo1(3);
	}
}
