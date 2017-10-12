/**
 * 
 */
package com.person.myspringboot.dto;

import java.util.Date;

/**
 * @author liuquan
 *
 */
public class GameKaifu {
	// 唯一标识ID
	private Integer id;
	// 游戏ID
	private String gameId;
	// 游戏名字
	private String gameName;
	// icon图片
	private String iconImg;
	// 开服时间点
	private Date openTime;
	// 服务器号
	private String serverNum;
	// 服务器名
	private String serverName;
	// 用于的系统android|ios
	private String system;
	// 数据是否有效 0 无效 1 有效
	private Integer status;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameId() {
		return this.gameId;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setIconImg(String iconImg) {
		this.iconImg = iconImg;
	}

	public String getIconImg() {
		return this.iconImg;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setServerNum(String serverNum) {
		this.serverNum = serverNum;
	}

	public String getServerNum() {
		return this.serverNum;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystem() {
		return this.system;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}