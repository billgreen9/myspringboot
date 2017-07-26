package com.person.myspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 从properties文件中读取数据，prefix表示以hello开头
 * @author liuquan3
 *
 */
@Configuration
@ConfigurationProperties(prefix="hello")
public class Config {

	private String name;
	private String url;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getInfo(){
		return "name="+name+",url="+url;
	}
   

} 
