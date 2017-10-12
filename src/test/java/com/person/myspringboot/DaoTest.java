package com.person.myspringboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.person.myspringboot.dao.GameKaifuDao;
import com.person.myspringboot.dto.GameKaifu;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
@WebAppConfiguration
@ContextConfiguration
public class DaoTest {
	@Autowired
	private GameKaifuDao gameKaifuDao;

	@Test
	public void test() {
		GameKaifu kaifu = new GameKaifu();
		kaifu.setGameId("game001");
		kaifu.setGameName("飞龙在天");
		kaifu.setStatus(1);
		int id = gameKaifuDao.save(kaifu).intValue();
		GameKaifu ret = gameKaifuDao.get(id);
		System.out.println(ret.getGameName());
		Assert.assertNotEquals(null, ret);
	}
}
