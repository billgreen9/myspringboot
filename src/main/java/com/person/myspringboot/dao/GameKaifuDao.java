/**
 * 
 */
package com.person.myspringboot.dao;

import com.person.myspringboot.dto.GameKaifu;

/**
 * @author liuquan
 *
 */
public interface GameKaifuDao {

	GameKaifu get(Object id);

	int delete(Object id);

	int update(GameKaifu entity);

	void insert(GameKaifu entity);

	Number save(GameKaifu entity);
	
}
