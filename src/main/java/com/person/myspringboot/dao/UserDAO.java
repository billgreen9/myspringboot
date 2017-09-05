package com.person.myspringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.myspringboot.entity.User;
import com.person.myspringboot.entity.UserBasicInfo;



/**
 * @author liuquan
 *
 */
public interface UserDAO extends JpaRepository<User,Long>{
	
	@Query(value="select id,user_name,age,nick_name from user where age>=?1",nativeQuery=true)
	public List<User> query(int age);
	
	@Query(value="select id,user_name from user where age>=?1",nativeQuery=true)
	public List<UserBasicInfo> queryBasicInfo(int age);
	
	@Query(value="select id,user_name from user where age>=?1",nativeQuery=true)
	public List<Object[]> queryBasicInfo1(int age);
	
	

}
