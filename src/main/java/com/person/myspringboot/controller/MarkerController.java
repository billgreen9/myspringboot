/**
 * 
 */
package com.person.myspringboot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.ShardedJedis;

/**
 * @author liuquan
 *
 */
@Controller
public class MarkerController {
	
	ShardedJedis jedis = null;
	@RequestMapping("/marker")
	public String marker(HttpServletRequest request,Map<String,Object> map) {
		request.setAttribute("name1", "bill");
		map.put("name", "Bill Gates!");
		return "hello";
	}
	
	

}
